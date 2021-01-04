package com.baidu.ala.recorder.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.ala.adp.lib.util.BdLog;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AlaAudioFrame;
import com.baidu.ala.recorder.audio.IAudioService;
import com.baidu.android.imsdk.internal.IMConnection;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes15.dex */
public class AlaAudioSession {
    private static final int CHECK_INTERVAL = 3000;
    private static final String TAG = AlaAudioSession.class.getSimpleName();
    private static final boolean VERBOSE = false;
    private IAudioService.FrameCallback mCallback;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsStop = false;
    private boolean mMute = false;
    private int mType = 1;
    private IAudioService mAudioDevices = null;
    private AlaAudioConfig mConfig = null;
    private CaptureThread mThread = null;
    private Timer mTimer = null;
    private boolean mHasAudio = false;
    private boolean mUseDummyCapture = false;
    private boolean mUseExternalAudio = false;
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() { // from class: com.baidu.ala.recorder.audio.AlaAudioSession.3
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 0:
                    AlaAudioSession.this.mMute = false;
                    break;
                case 1:
                    AlaAudioSession.this.mMute = true;
                    break;
                case 2:
                    AlaAudioSession.this.mMute = true;
                    break;
            }
            super.onCallStateChanged(i, str);
        }
    };
    private int reTryNum = 0;
    public long mLastCaptureTimestamp = 0;

    public AlaAudioSession(Context context, IAudioService.FrameCallback frameCallback) {
        this.mCallback = null;
        this.mContext = null;
        this.mHandler = null;
        this.mContext = context;
        this.mCallback = frameCallback;
        this.mHandler = new Handler();
        ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 32);
    }

    public boolean onCreate(AlaAudioConfig alaAudioConfig) {
        if (alaAudioConfig != null) {
            if (!this.mIsStop) {
                logMessage("onCreate stop audioDevice");
                stop();
            }
            this.mConfig = new AlaAudioConfig(alaAudioConfig);
            if (StreamConfig.initConfig(this.mContext) < 0) {
                BdLog.e("onCreate initConfig failed");
            }
            this.mType = 1;
            if (alaAudioConfig.mode == 2) {
                this.mType = StreamConfig.useOpenSLES() ? 3 : 2;
            }
            logMessage("onCreate mType = " + this.mType);
        }
        return false;
    }

    public void setDummyCapture(boolean z) {
        logMessage("setDummyCapture mType = " + this.mType + " mUseDummyCapture:" + this.mUseDummyCapture);
        this.mUseDummyCapture = z;
    }

    public void onResume() {
        logMessage("onResume mType = " + this.mType + " mUseDummyCapture:" + this.mUseDummyCapture);
        if (this.mUseExternalAudio) {
            logMessage("onResume mType = " + this.mType + " ExternalCapture ");
        } else if (this.mUseDummyCapture) {
            stop();
        }
    }

    public void onPause() {
        logMessage("onPause mType = " + this.mType + " mUseDummyCapture:" + this.mUseDummyCapture);
        if (this.mUseExternalAudio) {
            logMessage("onPause mType = " + this.mType + " ExternalCapture ");
        } else if (this.mUseDummyCapture) {
            startDummyCapture();
        }
    }

    public void setExternalAudio(boolean z) {
        this.mUseExternalAudio = z;
    }

    public synchronized boolean start() {
        if (this.mThread == null) {
            logMessage("new CaptureThread");
            this.mIsStop = false;
            this.mThread = new CaptureThread(this.mType);
            try {
                if (this.mTimer != null) {
                    logMessage("Timer has not release");
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
                this.mTimer = new Timer();
                this.mThread.start();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.ala.recorder.audio.AlaAudioSession.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        AlaAudioSession.this.onTimerCheck();
                    }
                }, 200L, IMConnection.RETRY_DELAY_TIMES);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public synchronized void stop() {
        if (this.mThread != null) {
            logMessage("stop CaptureThread");
            this.mIsStop = true;
            this.mTimer.cancel();
            this.mTimer = null;
            try {
                this.mThread.interrupt();
                this.mThread.join();
                logMessage("final CaptureThread stoped");
                this.mThread.destroyAudioDevice();
                this.mThread = null;
            } catch (Exception e) {
                e.printStackTrace();
                logMessage("final CaptureThread stoped");
                this.mThread.destroyAudioDevice();
                this.mThread = null;
            }
        }
    }

    public void onDestroy() {
        stop();
        this.mHandler.removeCallbacksAndMessages(null);
        try {
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logMessage(" onDestroy Done");
    }

    public void mute(boolean z) {
        this.mMute = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logMessage(String str) {
    }

    private synchronized void startDummyCapture() {
        stop();
        if (this.mThread == null) {
            logMessage("new CaptureThread");
            this.mIsStop = false;
            this.mThread = new CaptureThread(4);
            try {
                if (this.mTimer != null) {
                    logMessage("Timer has not release");
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
                this.mTimer = new Timer();
                this.mThread.start();
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.ala.recorder.audio.AlaAudioSession.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        AlaAudioSession.this.onTimerCheck();
                    }
                }, 200L, IMConnection.RETRY_DELAY_TIMES);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpenSLESNoData() {
        if (!this.mIsStop) {
            Log.i(TAG, "OpenSLES no data, will revert to Recorder, disable APM");
            this.mType = 2;
            this.mConfig.enableAPM = false;
            stop();
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimerCheck() {
        if (this.mIsStop) {
            Log.i(TAG, "no Audio Has Stoped!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.mLastCaptureTimestamp + 5000 && this.mLastCaptureTimestamp > 0) {
            this.mHasAudio = false;
            Log.i(TAG, "no AudioData Capture, Restart, num:" + this.reTryNum);
            stop();
            Log.i(TAG, "no AudioData Capture, Stop Devices, num:" + this.reTryNum);
            start();
            Log.i(TAG, "no AudioData Capture, Start Devices, num:" + this.reTryNum);
            this.reTryNum++;
        } else {
            this.mHasAudio = true;
        }
        Log.i(TAG, "TimerTask cts:" + currentTimeMillis + " hasAudio:" + this.mHasAudio);
        if (this.mCallback != null) {
            this.mCallback.onMessage(1000, new Boolean(this.mHasAudio), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class CaptureThread extends Thread {
        private IAudioService.FrameCallback callback;
        private byte[] mMuteBytes;
        private int mType;

        private CaptureThread(int i) {
            this.mMuteBytes = new byte[2048];
            this.mType = 1;
            this.callback = new IAudioService.FrameCallback() { // from class: com.baidu.ala.recorder.audio.AlaAudioSession.CaptureThread.1
                @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
                public void onAudioData(AlaAudioFrame alaAudioFrame) {
                    if (!AlaAudioSession.this.mIsStop && CaptureThread.this.mType != 3 && AlaAudioSession.this.mCallback != null) {
                        AlaAudioSession.this.mCallback.onAudioData(alaAudioFrame);
                    }
                }

                @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
                public void onMessage(int i2, Object obj, String str) {
                    if (!AlaAudioSession.this.mIsStop && AlaAudioSession.this.mCallback != null) {
                        AlaAudioSession.this.mCallback.onMessage(i2, obj, str);
                    }
                }

                @Override // com.baidu.ala.recorder.audio.IAudioService.FrameCallback
                public void onError(int i2, String str) {
                    AlaAudioSession.logMessage("CaptureThread onError code:" + i2 + " msg:" + str);
                    if (!AlaAudioSession.this.mIsStop) {
                        if (i2 == 300) {
                            AlaAudioSession.this.mHandler.post(new Runnable() { // from class: com.baidu.ala.recorder.audio.AlaAudioSession.CaptureThread.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlaAudioSession.this.onOpenSLESNoData();
                                }
                            });
                        } else if (AlaAudioSession.this.mCallback != null) {
                            AlaAudioSession.this.mCallback.onError(i2, str);
                        }
                    }
                }
            };
            this.mType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void destroyAudioDevice() {
            try {
                if (AlaAudioSession.this.mAudioDevices != null) {
                    AlaAudioSession.this.mAudioDevices.stop();
                    AlaAudioSession.this.mAudioDevices.onDestroy();
                    AlaAudioSession.logMessage(" audioRecorder stop and release ");
                }
                AlaAudioSession.this.mAudioDevices = null;
            } catch (Exception e) {
                e.printStackTrace();
                AlaAudioSession.this.mAudioDevices = null;
            }
        }

        private synchronized IAudioService createAudioService(int i) {
            if (AlaAudioSession.this.mConfig == null) {
                AlaAudioSession.logMessage("createAudioService config = null");
            } else {
                switch (i) {
                    case 2:
                        AlaAudioSession.this.mAudioDevices = new AlaAECRecorder();
                        AlaAudioSession.this.mAudioDevices.onCreate(AlaAudioSession.this.mContext, this.callback);
                        AlaAudioSession.logMessage("createAudioService type = " + i + " new AlaAECRecorder");
                        if (AlaAudioSession.this.mCallback != null) {
                            AlaAudioSession.this.mCallback.onMessage(1001, new Integer(1), "");
                            break;
                        }
                        break;
                    case 3:
                        AlaAudioSession.this.mAudioDevices = new AlaSLRecorder();
                        AlaAudioSession.this.mAudioDevices.onCreate(AlaAudioSession.this.mContext, this.callback);
                        AlaAudioSession.logMessage("createAudioService type = " + i + " new AlaSLRecorder");
                        if (AlaAudioSession.this.mCallback != null) {
                            AlaAudioSession.this.mCallback.onMessage(1001, new Integer(2), "");
                            break;
                        }
                        break;
                    case 4:
                        AlaAudioSession.this.mAudioDevices = new AlaDumRecorder();
                        AlaAudioSession.this.mAudioDevices.onCreate(AlaAudioSession.this.mContext, this.callback);
                        AlaAudioSession.logMessage("createAudioService type = " + i + " new AlaDumRecorder");
                        break;
                    default:
                        AlaAudioSession.this.mAudioDevices = new AlaStdRecorder();
                        AlaAudioSession.this.mAudioDevices.onCreate(AlaAudioSession.this.mContext, this.callback);
                        AlaAudioSession.logMessage("createAudioService type = " + i + " new AlaStdRecorder");
                        if (AlaAudioSession.this.mCallback != null) {
                            AlaAudioSession.this.mCallback.onMessage(1001, new Integer(1), "");
                            break;
                        }
                        break;
                }
            }
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            Thread.currentThread().setName("Audio-Capture");
            if (AlaAudioSession.this.mAudioDevices != null) {
                AlaAudioSession.this.mAudioDevices.onDestroy();
                AlaAudioSession.this.mAudioDevices = null;
            }
            createAudioService(this.mType);
            if (AlaAudioSession.this.mAudioDevices == null) {
                AlaAudioSession.logMessage("createAudioService failed");
                return;
            }
            AlaAudioSession.this.mHasAudio = true;
            if (!AlaAudioSession.this.mAudioDevices.start(AlaAudioSession.this.mConfig)) {
                Log.i(AlaAudioSession.TAG, "AudioDevice start failed, mType:" + this.mType);
                destroyAudioDevice();
                return;
            }
            AlaAudioSession.logMessage("audioDevices start, rate:" + AlaAudioSession.this.mConfig.sampleRate + " channels:" + AlaAudioSession.this.mConfig.channels);
            boolean z = AlaAudioSession.this.mMute;
            while (true) {
                if (AlaAudioSession.this.mIsStop) {
                    break;
                } else if (AlaAudioSession.this.mIsStop) {
                    AlaAudioSession.logMessage("isStop = " + AlaAudioSession.this.mIsStop);
                    break;
                } else {
                    if (z != AlaAudioSession.this.mMute) {
                        AlaAudioSession.logMessage(" audioDevice mute: " + AlaAudioSession.this.mMute);
                        AlaAudioSession.this.mAudioDevices.mute(AlaAudioSession.this.mMute);
                        z = AlaAudioSession.this.mMute;
                    }
                    AlaAudioFrame readFrame = AlaAudioSession.this.mAudioDevices.readFrame();
                    if (readFrame == null) {
                        AlaAudioSession.logMessage(" readData failed");
                    } else {
                        AlaAudioSession.logMessage(" readData len:" + readFrame.length);
                        AlaAudioSession.this.mLastCaptureTimestamp = System.currentTimeMillis();
                        if (AlaAudioSession.this.mMute) {
                            readFrame.bytes = this.mMuteBytes;
                            readFrame.length = 2048;
                        }
                        if (AlaAudioSession.this.mCallback != null && AlaAudioSession.this.mAudioDevices.getType() != 3) {
                            AlaAudioSession.this.mCallback.onAudioData(readFrame);
                        }
                    }
                }
            }
            AlaAudioSession.logMessage("CaptureThread will exit, isStop = " + AlaAudioSession.this.mIsStop);
            destroyAudioDevice();
        }
    }
}
