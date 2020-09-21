package com.baidu.rtc;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.rtc.RtcConfig;
import com.baidu.rtc.a.a;
import com.baidu.rtc.a.b;
import com.baidu.rtc.ndk.AlaNDKPlayerAdapter;
import com.baidu.rtc.ndk.AlaNDKRecorderAdapter;
import com.baidu.rtc.utils.AlaLiveDebugInfo;
import com.baidu.rtc.utils.NetworkManager;
import com.baidu.rtc.utils.c;
import com.baidu.rtc.utils.d;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class RTCSession {
    private static final int NETWORK_UNAVAILABLE = 0;
    private static final int NETWORK_WWAN = 2;
    private static final int NETWROK_WIFI = 1;
    private static final String TAG = AudioSession.class.getSimpleName();
    private Context mContext;
    private boolean mIsBackCamera;
    private AlaNDKRecorderAdapter mNDKAdapter;
    private AlaNDKPlayerAdapter mNdkPlayer;
    private RtcConfig mRtcConfig;
    private RtcConfig.RtcHandler mRtcHandler;
    private b mVideoDevices;
    private a mAudioDevices = null;
    private ExecutorService mPlayerService = Executors.newFixedThreadPool(1);
    private ExecutorService mRecordService = Executors.newFixedThreadPool(1);
    private c mBaseInfo = new c();
    private String mRtcUrl = null;
    private volatile boolean mIsStop = false;
    private volatile boolean mHasStart = false;
    private boolean mIsConnected = false;
    private int mConnectStateChangedCount = 0;
    private int mConnectSuccessCount = 0;
    private int mConnectFailedCount = 0;
    private int mPlayMediaIndex = 1;
    private AlaNDKRecorderAdapter.OnNDKCallback mRecorderCallback = new AlaNDKRecorderAdapter.OnNDKCallback() { // from class: com.baidu.rtc.RTCSession.1
        @Override // com.baidu.rtc.ndk.AlaNDKRecorderAdapter.OnNDKCallback
        public void rtmpResponsedCallback(int i, int i2, int i3) {
            if (i2 == 1) {
                if (i == 0) {
                    RTCSession.this.handleLostConnection(i3);
                } else if (1 == i) {
                    RTCSession.this.handleConnectionSuccess();
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
            RTCSession.this.mNdkPlayer.startPlayerNative(String.format("rtc://%s:%d?room_id=%d&line_index=%d&user_id=%d", RTCSession.this.mRtcConfig.hostName, Integer.valueOf(RTCSession.this.mRtcConfig.hostPort), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)), RTCSession.this.mPlayMediaIndex, RTCSession.this.getNetworkState(), RTCSession.this.mBaseInfo.toJsonString(), RTCSession.this.mRtcConfig.enableAudio, RTCSession.this.mRtcConfig.enableVideo);
            if (RTCSession.this.mVideoDevices.XS() != null) {
                RTCSession.this.mVideoDevices.XS().XU();
            }
            if (RTCSession.this.mRtcHandler != null) {
                RTCSession.this.mRtcHandler.onRemoteUserOnLine(i, i2);
            }
        }
    };
    private AlaNDKPlayerAdapter.OnNDKCallback mPlayerCallback = new AlaNDKPlayerAdapter.OnNDKCallback() { // from class: com.baidu.rtc.RTCSession.2
        @Override // com.baidu.rtc.ndk.AlaNDKPlayerAdapter.OnNDKCallback
        public void jniNotifyMessage(int i, int i2, String str) {
        }
    };
    private NetworkManager.a mNetworkChangeListener = new NetworkManager.a() { // from class: com.baidu.rtc.RTCSession.3
        @Override // com.baidu.rtc.utils.NetworkManager.a
        public void onNetworkChanged(NetworkManager.NetworkType networkType, NetworkManager.NetworkType networkType2) {
            RTCSession.this.handleNetworkChanged();
        }
    };

    public RTCSession(Context context, RtcConfig rtcConfig, RtcConfig.RtcHandler rtcHandler) {
        this.mContext = null;
        this.mRtcConfig = null;
        this.mRtcHandler = null;
        this.mNDKAdapter = null;
        this.mNdkPlayer = null;
        this.mVideoDevices = null;
        this.mIsBackCamera = false;
        this.mRtcHandler = rtcHandler;
        this.mContext = context;
        this.mRtcConfig = rtcConfig.cloneObj();
        this.mRtcConfig.enableAudio = 1;
        this.mRtcConfig.enableVideo = 1;
        this.mIsBackCamera = this.mRtcConfig.isCameraFront() ? false : true;
        this.mNDKAdapter = new AlaNDKRecorderAdapter();
        this.mNDKAdapter.setNDKCallback(this.mRecorderCallback);
        this.mNdkPlayer = new AlaNDKPlayerAdapter();
        this.mNdkPlayer.setNDKCallback(this.mPlayerCallback);
        if (!NetworkManager.XW().XX()) {
            NetworkManager.XW().init((Application) context.getApplicationContext());
        }
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.4
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName("com_baidu_rtc_audio_session_player");
            }
        });
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.5
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName("com_baidu_rtc_audio_session_recorder");
            }
        });
        this.mRtcHandler.onLoadLibrary("rtc");
        this.mVideoDevices = new b(this.mContext, this.mRtcConfig, this.mNDKAdapter, this.mNdkPlayer);
    }

    public int start(String str) {
        if (this.mRtcConfig == null || this.mContext == null) {
            if (this.mRtcHandler != null) {
                this.mRtcHandler.onFailed(RtcConfig.RTC_FAILED_INVALID_PARAMS);
                return -1;
            }
            return -1;
        } else if (this.mHasStart) {
            return -1;
        } else {
            this.mRtcConfig.pushUrl = str;
            if (TextUtils.isEmpty(this.mRtcConfig.pushUrl)) {
                if (this.mRtcHandler != null) {
                    this.mRtcHandler.onFailed(RtcConfig.RTC_FAILED_INVALID_PUSHURL);
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
                this.mAudioDevices = new a(this.mContext, this.mNDKAdapter.getNativeObject());
                startAudioRecord();
                startAudioPlayer();
                this.mVideoDevices.a(this.mRtcConfig);
                NetworkManager.XW().a(this.mNetworkChangeListener);
                this.mHasStart = true;
                this.mIsStop = false;
                return 0;
            }
        }
    }

    public int stop() {
        if (this.mIsStop) {
            return -1;
        }
        stopAudioPlayer();
        stopAudioRecord();
        this.mVideoDevices.stopRecording();
        if (stopNativeObject() != 0) {
            Log.e(TAG, "stopNativeObject failed");
        }
        NetworkManager.XW().b(this.mNetworkChangeListener);
        this.mIsStop = true;
        if (this.mHasStart && this.mRtcHandler != null && this.mRtcConfig != null) {
            this.mRtcHandler.onStop(this.mRtcConfig.roomId, this.mRtcConfig.lineId);
        }
        this.mHasStart = false;
        return 0;
    }

    public View getRecorderView() {
        return this.mVideoDevices.getRecorderView();
    }

    public View getPlayerView() {
        return this.mVideoDevices.XS();
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

    public void switchCamera() {
        this.mIsBackCamera = !this.mIsBackCamera;
        this.mVideoDevices.switchCamera();
    }

    public boolean updateRTCConfig(RtcConfig rtcConfig) {
        if (this.mHasStart || rtcConfig == null) {
            return false;
        }
        this.mRtcConfig.hostName = rtcConfig.hostName;
        this.mRtcConfig.hostPort = rtcConfig.hostPort;
        this.mRtcConfig.roomId = rtcConfig.roomId;
        this.mRtcConfig.lineId = rtcConfig.lineId;
        this.mRtcConfig.userId = rtcConfig.lineId;
        this.mRtcConfig.identity = rtcConfig.identity;
        this.mRtcConfig.devicePosition = rtcConfig.devicePosition;
        if (this.mIsBackCamera == this.mRtcConfig.isCameraFront()) {
            switchCamera();
        }
        if (this.mVideoDevices != null) {
            this.mVideoDevices.b(this.mRtcConfig);
        }
        return true;
    }

    public void resetPreview() {
        this.mVideoDevices.resetPreview();
    }

    private int startNativeObject() {
        if (this.mNDKAdapter.initRecordNative(2, 1, this.mRtcConfig.enableAudio, this.mRtcConfig.enableVideo) != 0) {
            Log.e(TAG, "initRecordNative failed");
            return -1;
        }
        this.mNDKAdapter.syncStatConfig(this.mContext.getCacheDir().getAbsolutePath() + "/rtc_stream/", "http://c.tieba.baidu.com/ala/sys/mlog", 1);
        if (this.mNDKAdapter.initRtcRoomType(2) != 0) {
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
            } else if (this.mNDKAdapter.initAudioEncoderNative(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, 1, 16) != 0) {
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
        if (this.mNDKAdapter != null) {
            this.mNDKAdapter.stopNative();
        }
        if (this.mNdkPlayer != null && this.mRtcConfig != null) {
            this.mNdkPlayer.stopNative(this.mPlayMediaIndex);
            return 0;
        }
        return 0;
    }

    private void startAudioPlayer() {
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.6
            @Override // java.lang.Runnable
            public void run() {
                if (!RTCSession.this.mAudioDevices.Z(d.OUTPUT_SAMPLE_RATE, 4)) {
                    Log.e(RTCSession.TAG, "initAudioPlayer failed");
                    RTCSession.this.mAudioDevices.stopAudioPlayer();
                } else if (!d.useOpenSLES()) {
                    byte[] bArr = new byte[4096];
                    while (!RTCSession.this.mIsStop && !RTCSession.this.mPlayerService.isShutdown()) {
                        int audioPCMNative = RTCSession.this.mNdkPlayer.getAudioPCMNative(bArr);
                        if (audioPCMNative <= 0) {
                            Arrays.fill(bArr, (byte) 0);
                            audioPCMNative = 2048;
                        }
                        try {
                            if (RTCSession.this.mAudioDevices != null) {
                                RTCSession.this.mAudioDevices.writeData(bArr, 0, audioPCMNative);
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
        this.mPlayerService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.7
            @Override // java.lang.Runnable
            public void run() {
                RTCSession.this.mAudioDevices.stopAudioPlayer();
            }
        });
    }

    private void startAudioRecord() {
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.8
            @Override // java.lang.Runnable
            public void run() {
                if (!RTCSession.this.mAudioDevices.aa(d.OUTPUT_SAMPLE_RATE, 16)) {
                    Log.e(RTCSession.TAG, "initAudioRecord failed");
                    RTCSession.this.mAudioDevices.stopAudioRecord();
                } else if (!d.useOpenSLES()) {
                    while (!RTCSession.this.mIsStop && !RTCSession.this.mRecordService.isShutdown()) {
                        try {
                            byte[] XP = RTCSession.this.mAudioDevices.XP();
                            if (XP != null) {
                                RTCSession.this.mNDKAdapter.sendPCMDataNative2(XP, 2048);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void stopAudioRecord() {
        this.mRecordService.submit(new Runnable() { // from class: com.baidu.rtc.RTCSession.9
            @Override // java.lang.Runnable
            public void run() {
                RTCSession.this.mAudioDevices.stopAudioRecord();
            }
        });
    }

    private void updateStatInfo() {
        c.getAppVersion(this.mContext);
        this.mBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_SEND;
        this.mBaseInfo.mUid = "" + this.mRtcConfig.userId;
        this.mBaseInfo.mNetWork = NetworkManager.XW().XY().toString();
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
        int XZ = NetworkManager.XW().XZ();
        if (XZ <= 0) {
            return 0;
        }
        if (XZ < 2) {
            return XZ;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkChanged() {
        if (this.mNDKAdapter != null) {
            this.mNDKAdapter.networkChangedNotifyNative(getNetworkState());
        }
    }
}
