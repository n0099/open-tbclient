package com.baidu.rtc;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.rtc.RtcConfig;
import com.baidu.rtc.ndk.AlaNDKPlayerAdapter;
import com.baidu.rtc.ndk.AlaNDKRecorderAdapter;
import com.baidu.rtc.utils.AlaLiveDebugInfo;
import com.baidu.rtc.utils.NetworkManager;
import com.baidu.rtc.utils.b;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes16.dex */
public class AudioSession {
    private static final int NETWORK_UNAVAILABLE = 0;
    private static final int NETWORK_WWAN = 2;
    private static final int NETWROK_WIFI = 1;
    private static final String TAG = AudioSession.class.getSimpleName();
    private Context mContext;
    private AlaNDKRecorderAdapter mNDKAdapter;
    private AlaNDKPlayerAdapter mNdkPlayer;
    private RtcConfig mRtcConfig;
    private RtcConfig.RtcHandler mRtcHandler;
    private com.baidu.rtc.utils.b mCallState = null;
    private volatile boolean mIsEnablePlaySound = true;
    private com.baidu.rtc.a.a mAudioDevices = null;
    private ExecutorService mPlayerService = Executors.newFixedThreadPool(1);
    private ExecutorService mRecordService = Executors.newFixedThreadPool(1);
    private com.baidu.rtc.utils.c mBaseInfo = new com.baidu.rtc.utils.c();
    private String mRtcUrl = null;
    private volatile boolean mIsStop = false;
    private volatile boolean mHasStart = false;
    private boolean mIsConnected = false;
    private int mConnectStateChangedCount = 0;
    private int mConnectSuccessCount = 0;
    private int mConnectFailedCount = 0;
    private AlaNDKRecorderAdapter.OnNDKCallback mRecorderCallback = new AlaNDKRecorderAdapter.OnNDKCallback() { // from class: com.baidu.rtc.AudioSession.1
        @Override // com.baidu.rtc.ndk.AlaNDKRecorderAdapter.OnNDKCallback
        public void rtmpResponsedCallback(int i, int i2, int i3) {
            if (i2 == 1) {
                if (i == 0) {
                    AudioSession.this.handleLostConnection(i3);
                } else if (1 == i) {
                    AudioSession.this.handleConnectionSuccess();
                }
            }
        }

        @Override // com.baidu.rtc.ndk.AlaNDKRecorderAdapter.OnNDKCallback
        public void rtmpDebugResponsedCallback(AlaLiveDebugInfo alaLiveDebugInfo) {
            if (alaLiveDebugInfo == null) {
            }
        }

        @Override // com.baidu.rtc.ndk.AlaNDKRecorderAdapter.OnNDKCallback
        public void onRemoteUserOnLine(int i, long j, int i2) {
            AudioSession.this.mNdkPlayer.startPlayerNative(String.format("rtc://%s:%d?room_id=%d&line_index=%d&user_id=%d", AudioSession.this.mRtcConfig.hostName, Integer.valueOf(AudioSession.this.mRtcConfig.hostPort), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)), i2, AudioSession.this.getNetworkState(), AudioSession.this.mBaseInfo.toJsonString(), AudioSession.this.mRtcConfig.enableAudio, AudioSession.this.mRtcConfig.enableVideo);
        }
    };
    private AlaNDKPlayerAdapter.OnNDKCallback mPlayerCallback = new AlaNDKPlayerAdapter.OnNDKCallback() { // from class: com.baidu.rtc.AudioSession.2
        @Override // com.baidu.rtc.ndk.AlaNDKPlayerAdapter.OnNDKCallback
        public void jniNotifyMessage(int i, int i2, String str) {
        }
    };
    private NetworkManager.a mNetworkChangeListener = new NetworkManager.a() { // from class: com.baidu.rtc.AudioSession.3
        @Override // com.baidu.rtc.utils.NetworkManager.a
        public void onNetworkChanged(NetworkManager.NetworkType networkType, NetworkManager.NetworkType networkType2) {
            AudioSession.this.handleNetworkChanged();
        }
    };

    public AudioSession(Context context, RtcConfig rtcConfig, RtcConfig.RtcHandler rtcHandler) {
        this.mContext = null;
        this.mRtcConfig = null;
        this.mRtcHandler = null;
        this.mNDKAdapter = null;
        this.mNdkPlayer = null;
        this.mRtcHandler = rtcHandler;
        this.mContext = context;
        this.mRtcConfig = rtcConfig.cloneObj();
        this.mRtcConfig.enableAudio = 1;
        this.mRtcConfig.enableVideo = 0;
        this.mNDKAdapter = new AlaNDKRecorderAdapter();
        this.mNDKAdapter.setNDKCallback(this.mRecorderCallback);
        this.mNdkPlayer = new AlaNDKPlayerAdapter();
        this.mNdkPlayer.setNDKCallback(this.mPlayerCallback);
        if (!NetworkManager.aeu().aev()) {
            NetworkManager.aeu().init((Application) context.getApplicationContext());
        }
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.4
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName("com_baidu_rtc_audio_session_player");
            }
        });
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.5
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName("com_baidu_rtc_audio_session_recorder");
            }
        });
        this.mRtcHandler.onLoadLibrary("rtc");
        registerCallState();
    }

    public int start() {
        if (this.mRtcConfig == null || this.mContext == null) {
            Log.e(TAG, "invalid params");
            if (this.mRtcHandler != null) {
                this.mRtcHandler.onFailed(RtcConfig.RTC_FAILED_INVALID_PARAMS);
                return -1;
            }
            return -1;
        } else if (startNativeObject() != 0) {
            Log.e(TAG, "startNativeObject failed");
            if (this.mRtcHandler != null) {
                this.mRtcHandler.onFailed(RtcConfig.RTC_FAILED_INIT_FAILED);
                return -1;
            }
            return -1;
        } else {
            this.mAudioDevices = new com.baidu.rtc.a.a(this.mContext, this.mNDKAdapter.getNativeObject());
            startAudioRecord();
            startAudioPlayer();
            NetworkManager.aeu().a(this.mNetworkChangeListener);
            this.mHasStart = true;
            this.mIsStop = false;
            return 0;
        }
    }

    public int stop() {
        if (this.mIsStop) {
            return -1;
        }
        stopAudioPlayer();
        stopAudioRecord();
        if (stopNativeObject() != 0) {
            Log.e(TAG, "stopNativeObject failed");
        }
        NetworkManager.aeu().b(this.mNetworkChangeListener);
        this.mIsStop = true;
        if (this.mHasStart && this.mRtcHandler != null && this.mRtcConfig != null) {
            this.mRtcHandler.onStop(this.mRtcConfig.roomId, this.mRtcConfig.lineId);
        }
        this.mHasStart = false;
        return 0;
    }

    public void destroy() {
        try {
            if (this.mAudioDevices != null) {
                this.mAudioDevices.destroy();
            }
            if (this.mPlayerService != null) {
                this.mPlayerService.shutdown();
            }
            if (this.mRecordService != null) {
                this.mRecordService.shutdown();
            }
            unRegisterCallState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mContext = null;
        this.mRtcHandler = null;
    }

    public void mute() {
        if (this.mAudioDevices != null) {
            this.mAudioDevices.mute();
        }
        if (this.mRtcHandler != null && this.mRtcConfig != null) {
            this.mRtcHandler.onMuteStatusChanged(true);
        }
    }

    public void unMute() {
        if (this.mAudioDevices != null) {
            this.mAudioDevices.unMute();
        }
        if (this.mRtcHandler != null && this.mRtcConfig != null) {
            this.mRtcHandler.onMuteStatusChanged(false);
        }
    }

    private int startNativeObject() {
        if (this.mNDKAdapter.initRecordNative(2, 1, this.mRtcConfig.enableAudio, this.mRtcConfig.enableVideo) != 0) {
            Log.e(TAG, "initRecordNative failed");
            return -1;
        }
        this.mNDKAdapter.syncStatConfig(this.mContext.getCacheDir().getAbsolutePath() + "/rtc_stream/", "http://c.tieba.baidu.com/ala/sys/mlog", 1);
        if (this.mNDKAdapter.initRtcRoomType(1) != 0) {
            Log.e(TAG, "initRtcRoomType failed");
            return -1;
        } else if (this.mNDKAdapter.initRtcRoomInfoNative(this.mRtcConfig.roomId, this.mRtcConfig.lineId, this.mRtcConfig.userId, this.mRtcConfig.pushUrl, this.mRtcConfig.identity) != 0) {
            Log.e(TAG, "initRtcRoomInfoNative failed");
            return -1;
        } else {
            updateStatInfo();
            this.mRtcUrl = String.format("rtc://%s:%d?room_id=%d&line_index=%d&user_id=%d", this.mRtcConfig.hostName, Integer.valueOf(this.mRtcConfig.hostPort), Integer.valueOf(this.mRtcConfig.roomId), Integer.valueOf(this.mRtcConfig.lineId), Integer.valueOf(this.mRtcConfig.userId));
            if (this.mNDKAdapter.startNative(this.mRtcUrl, getNetworkState(), this.mBaseInfo.toJsonString()) != 0) {
                Log.e(TAG, "startNative failed");
                return -1;
            } else if (this.mNDKAdapter.initAudioEncoderNative(com.baidu.rtc.utils.d.cqp, 1, 16) != 0) {
                Log.e(TAG, "initAudioEncoderNative failed");
                return -1;
            } else if (this.mNDKAdapter.initPKPlayer(this.mNdkPlayer) != 0) {
                Log.e(TAG, "initPKPlayer failed");
                return -1;
            } else {
                this.mNdkPlayer.setNativeObject(this.mNDKAdapter.getNativeObject());
                return 0;
            }
        }
    }

    private int stopNativeObject() {
        int i = 1;
        if (this.mNdkPlayer != null && this.mRtcConfig != null) {
            for (int i2 = 1; i2 <= 9; i2++) {
                if (i2 != this.mRtcConfig.lineId) {
                    this.mNdkPlayer.stopNative(i);
                    i++;
                }
            }
        }
        if (this.mNDKAdapter != null) {
            this.mNDKAdapter.stopNative();
            return 0;
        }
        return 0;
    }

    private void startAudioPlayer() {
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.6
            @Override // java.lang.Runnable
            public void run() {
                if (!AudioSession.this.mAudioDevices.Z(com.baidu.rtc.utils.d.OUTPUT_SAMPLE_RATE, 4)) {
                    Log.e(AudioSession.TAG, "initAudioPlayer failed");
                    AudioSession.this.mAudioDevices.stopAudioPlayer();
                } else if (!com.baidu.rtc.utils.d.useOpenSLES()) {
                    byte[] bArr = new byte[4096];
                    while (!AudioSession.this.mIsStop && !AudioSession.this.mPlayerService.isShutdown()) {
                        int audioPCMNative = AudioSession.this.mNdkPlayer.getAudioPCMNative(bArr);
                        if (audioPCMNative <= 0) {
                            Arrays.fill(bArr, (byte) 0);
                            audioPCMNative = 2048;
                        }
                        try {
                            if (AudioSession.this.mAudioDevices != null && AudioSession.this.mIsEnablePlaySound) {
                                AudioSession.this.mAudioDevices.writeData(bArr, 0, audioPCMNative);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void stopAudioPlayer() {
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.7
            @Override // java.lang.Runnable
            public void run() {
                AudioSession.this.mAudioDevices.stopAudioPlayer();
            }
        });
    }

    private void startAudioRecord() {
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.8
            @Override // java.lang.Runnable
            public void run() {
                if (!AudioSession.this.mAudioDevices.aa(com.baidu.rtc.utils.d.cqp, 16)) {
                    Log.e(AudioSession.TAG, "initAudioRecord failed");
                    AudioSession.this.mAudioDevices.stopAudioRecord();
                } else if (!com.baidu.rtc.utils.d.useOpenSLES()) {
                    while (!AudioSession.this.mIsStop && !AudioSession.this.mRecordService.isShutdown()) {
                        if (AudioSession.this.mIsEnablePlaySound) {
                            try {
                                byte[] adS = AudioSession.this.mAudioDevices.adS();
                                if (adS != null) {
                                    AudioSession.this.mNDKAdapter.sendPCMDataNative2(adS, 2048);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                Thread.sleep(40L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    private void stopAudioRecord() {
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.AudioSession.9
            @Override // java.lang.Runnable
            public void run() {
                AudioSession.this.mAudioDevices.stopAudioRecord();
            }
        });
    }

    private void updateStatInfo() {
        com.baidu.rtc.utils.c.getAppVersion(this.mContext);
        this.mBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mBaseInfo.mUid = "" + this.mRtcConfig.userId;
        this.mBaseInfo.mNetWork = NetworkManager.aeu().aew().toString();
        this.mBaseInfo.mCuid = this.mRtcConfig.cuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLostConnection(int i) {
        this.mIsConnected = false;
        handleConnectionStateChanged(false, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionSuccess() {
        this.mIsConnected = true;
        handleConnectionStateChanged(true, 0);
    }

    private void handleConnectionStateChanged(boolean z, int i) {
        this.mConnectStateChangedCount++;
        if (z) {
            this.mConnectSuccessCount++;
            String pushStreamIpNative = this.mNDKAdapter.getPushStreamIpNative();
            if (1 == this.mConnectSuccessCount) {
                if (this.mRtcHandler != null && this.mRtcConfig != null) {
                    this.mRtcHandler.onStart(this.mRtcConfig.roomId, this.mRtcConfig.lineId, this.mRtcUrl, pushStreamIpNative);
                    return;
                }
                return;
            } else if (this.mRtcHandler != null && this.mRtcConfig != null) {
                this.mRtcHandler.onConnectSuccess(this.mRtcConfig.roomId, this.mRtcConfig.lineId, this.mRtcUrl, pushStreamIpNative);
                return;
            } else {
                return;
            }
        }
        this.mConnectFailedCount++;
        if (this.mRtcHandler != null && this.mRtcConfig != null) {
            this.mRtcHandler.onConnectFailed(this.mRtcConfig.roomId, this.mRtcConfig.lineId, this.mRtcUrl, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetworkState() {
        int aex = NetworkManager.aeu().aex();
        if (aex <= 0) {
            return 0;
        }
        if (aex < 2) {
            return aex;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkChanged() {
        if (this.mNDKAdapter != null) {
            this.mNDKAdapter.networkChangedNotifyNative(getNetworkState());
        }
    }

    private void registerCallState() {
        if (this.mCallState == null) {
            this.mCallState = new com.baidu.rtc.utils.b(new b.a() { // from class: com.baidu.rtc.AudioSession.10
                @Override // com.baidu.rtc.utils.b.a
                public void onInterruptionBegin() {
                    AudioSession.this.mIsEnablePlaySound = false;
                    if (com.baidu.rtc.utils.d.useOpenSLES() && AudioSession.this.mHasStart) {
                        AudioSession.this.mAudioDevices.pause();
                    }
                }

                @Override // com.baidu.rtc.utils.b.a
                public void onInterruptionEnd() {
                    AudioSession.this.mIsEnablePlaySound = true;
                    if (com.baidu.rtc.utils.d.useOpenSLES() && AudioSession.this.mHasStart) {
                        AudioSession.this.mAudioDevices.resume();
                    }
                }
            });
            this.mCallState.register(this.mContext);
        }
    }

    private void unRegisterCallState() {
        if (this.mCallState != null) {
            this.mCallState.unregister(this.mContext);
            this.mCallState = null;
        }
    }
}
