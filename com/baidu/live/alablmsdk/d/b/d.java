package com.baidu.live.alablmsdk.d.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.live.alablmsdk.module.common.LiveDataState;
import com.thunder.livesdk.LiveTranscoding;
import com.thunder.livesdk.ThunderCustomVideoSource;
import com.thunder.livesdk.ThunderEngine;
import com.thunder.livesdk.ThunderEventHandler;
import com.thunder.livesdk.ThunderNotification;
import com.thunder.livesdk.ThunderVideoCanvas;
import com.thunder.livesdk.ThunderVideoEncoderConfiguration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class d {
    public static final String TAG = d.class.getSimpleName();
    public static volatile Integer azT = null;
    public static volatile boolean azU = false;
    private static volatile d azY;
    private String roomId;
    private byte[] token;
    private String uid;
    public LiveDataState azV = LiveDataState.NULL;
    public LiveDataState azW = LiveDataState.NULL;
    public LiveDataState azX = LiveDataState.NULL;
    private ThunderEngine azZ = null;
    private List<ThunderEventHandler> aAa = new CopyOnWriteArrayList();
    private ThunderEventHandler aAb = new ThunderEventHandler() { // from class: com.baidu.live.alablmsdk.d.b.d.1
        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onError(int i) {
            d.this.eX("onError" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onError(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onJoinRoomSuccess(String str, String str2, int i) {
            d.this.eW("yy-manager onJoinRoomSuccess: room=" + str + " uid =" + str2 + " elapsed =" + i);
            d.this.azW = LiveDataState.NULL;
            d.this.azX = LiveDataState.NULL;
            d.this.azV = LiveDataState.TRUE;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onJoinRoomSuccess(str, str2, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLeaveRoom(ThunderEventHandler.RoomStats roomStats) {
            d.this.eW("yy-manager onLeaveRoom: " + roomStats.temp);
            d.this.azW = LiveDataState.NULL;
            d.this.azX = LiveDataState.NULL;
            d.this.token = null;
            d.this.roomId = null;
            d.this.uid = null;
            d.this.azV = LiveDataState.FALSE;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onLeaveRoom(roomStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onBizAuthResult(boolean z, int i) {
            d.this.eW("yy-manager onBizAuthResult: bPublish = " + z + "::::result =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onBizAuthResult(z, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onSdkAuthResult(int i) {
            d.this.eW("yy-manager onSdkAuthResult: result = " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onSdkAuthResult(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserBanned(boolean z) {
            d.this.eW("yy-manager onUserBanned: status = " + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onUserBanned(z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserJoined(String str, int i) {
            d.this.eW("yy-manager onUserJoined: uid = " + str + "::::elapsed =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onUserJoined(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserOffline(String str, int i) {
            d.this.eW("yy-manager onUserOffline: uid = " + str + "::::reason =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onUserOffline(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onTokenWillExpire(byte[] bArr) {
            d.this.eW("yy-manager onTokenWillExpire: token = " + bArr);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onTokenWillExpire(bArr);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onTokenRequested() {
            d.this.eW("yy-manager onTokenRequested: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onTokenRequested();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onNetworkQuality(String str, int i, int i2) {
            d.this.eW("yy-manager onNetworkQuality: uid = " + str + ":::txQuality=" + i + ":::rxQuality=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i4)).onNetworkQuality(str, i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRoomStats(ThunderNotification.RoomStats roomStats) {
            d.this.eW("yy-manager onRoomStats: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRoomStats(roomStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLocalVideoStats(ThunderEventHandler.LocalVideoStats localVideoStats) {
            super.onLocalVideoStats(localVideoStats);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onLocalVideoStats(localVideoStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onPlayVolumeIndication(ThunderEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i) {
            d.this.eW("yy-manager onPlayVolumeIndication: totalVolume = " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onPlayVolumeIndication(audioVolumeInfoArr, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onCaptureVolumeIndication(int i, int i2, int i3) {
            d.this.eW("yy-manager onCaptureVolumeIndication: ");
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i5)).onCaptureVolumeIndication(i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioQuality(String str, int i, short s, short s2) {
            d.this.eW("yy-manager onAudioQuality: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onAudioQuality(str, i, s, s2);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionLost() {
            d.this.eW("yy-manager onConnectionLost: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onConnectionLost();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionInterrupted() {
            d.this.eW("yy-manager onConnectionInterrupted: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onConnectionInterrupted();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioRouteChanged(int i) {
            d.this.eW("yy-manager onAudioRouteChanged: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onAudioRouteChanged(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioPlayData(byte[] bArr, long j, long j2, String str, long j3) {
            d.this.eW("yy-manager onAudioPlayData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onAudioPlayData(bArr, j, j2, str, j3);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioPlaySpectrumData(byte[] bArr) {
            d.this.eW("yy-manager onAudioPlaySpectrumData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onAudioPlaySpectrumData(bArr);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRecvUserAppMsgData(byte[] bArr, String str) {
            d.this.eW("yy-manager onRecvUserAppMsgData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRecvUserAppMsgData(bArr, str);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onSendAppMsgDataFailedStatus(int i) {
            d.this.eW("yy-manager onSendAppMsgDataFailedStatus: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onSendAppMsgDataFailedStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalAudioFrameSent(int i) {
            d.this.eW("yy-manager onFirstLocalAudioFrameSent: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onFirstLocalAudioFrameSent(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalVideoFrameSent(int i) {
            d.this.eW("yy-manager onFirstLocalVideoFrameSent callback: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onFirstLocalVideoFrameSent(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onPublishStreamToCDNStatus(String str, int i) {
            int i2 = 0;
            d.this.eW("yy-manager onPublishStreamToCDNStatus: errorCode=" + i);
            d.azT = Integer.valueOf(i);
            if (d.azT.intValue() == 0) {
                d.azU = true;
            } else {
                d.azU = false;
            }
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onPublishStreamToCDNStatus(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onNetworkTypeChanged(int i) {
            d.this.eW("yy-manager onNetworkTypeChanged: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onNetworkTypeChanged(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionStatus(int i) {
            d.this.eW("yy-manager onConnectionStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onConnectionStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioCaptureStatus(int i) {
            d.this.eW("yy-manager onAudioCaptureStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onAudioCaptureStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onVideoCaptureStatus(int i) {
            d.this.eW("yy-manager onVideoCaptureStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i3)).onVideoCaptureStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioArrived(String str, String str2, boolean z) {
            d.this.eW("yy-manager onRemoteAudioArrived: roomId=" + str + " uid=" + str2 + " arrive=" + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRemoteAudioArrived(str, str2, z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoArrived(String str, String str2, boolean z) {
            d.this.eW("yy-manager onRemoteVideoArrived: roomId=" + str + "uid=" + str2 + " arrive=" + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRemoteVideoArrived(str, str2, z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoPlay(String str, int i, int i2, int i3) {
            d.this.eW("yy-manager onRemoteVideoPlay: uid=" + str + " width=" + i + " height=" + i2 + " elapsed=" + i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i5)).onRemoteVideoPlay(str, i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onVideoSizeChanged(String str, int i, int i2, int i3) {
            d.this.eW("yy-manager onVideoSizeChanged: uid=" + str + " width=" + i + " height=" + i2 + " rotation=" + i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i5)).onVideoSizeChanged(str, i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioStatsOfUid(String str, ThunderEventHandler.RemoteAudioStats remoteAudioStats) {
            super.onRemoteAudioStatsOfUid(str, remoteAudioStats);
            d.this.eW("yy-manager onRemoteAudioStatsOfUid: uid=" + str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRemoteAudioStatsOfUid(str, remoteAudioStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoStatsOfUid(String str, ThunderEventHandler.RemoteVideoStats remoteVideoStats) {
            super.onRemoteVideoStatsOfUid(str, remoteVideoStats);
            d.this.eW("yy-manager onRemoteVideoStatsOfUid: uid=" + str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i2)).onRemoteVideoStatsOfUid(str, remoteVideoStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLocalAudioStatusChanged(int i, int i2) {
            super.onLocalAudioStatusChanged(i, i2);
            d.this.eW("yy-manager onLocalAudioStatusChanged: status=" + i + " errorReason=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i4)).onLocalAudioStatusChanged(i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLocalVideoStatusChanged(int i, int i2) {
            super.onLocalVideoStatusChanged(i, i2);
            d.this.eW("yy-manager onLocalVideoStatusChanged: status=" + i + " errorReason=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aAa.size()) {
                    ((ThunderEventHandler) d.this.aAa.get(i4)).onLocalVideoStatusChanged(i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    };

    private d() {
    }

    public static synchronized d yX() {
        d dVar;
        synchronized (d.class) {
            if (azY == null) {
                synchronized (d.class) {
                    if (azY == null) {
                        azY = new d();
                    }
                }
            }
            dVar = azY;
        }
        return dVar;
    }

    public boolean yY() {
        return this.azW == LiveDataState.FALSE;
    }

    public boolean yZ() {
        return this.azW == LiveDataState.FALSE;
    }

    public void a(Context context, String str, long j, ThunderEventHandler thunderEventHandler) {
        if (this.azZ == null) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-manager  create yy engine ", " appId:" + str + " sceneId:" + j);
            this.azZ = ThunderEngine.createEngine(context, str, j, thunderEventHandler);
            this.azZ.setArea(2);
        }
    }

    public void destroyEngine() {
        if (this.azZ != null) {
            com.baidu.live.alablmsdk.a.b.a.d("destroyEngine");
            ThunderEngine.destroyEngine();
            this.azZ = null;
        }
    }

    public int setMediaMode(int i) {
        if (this.azZ == null) {
            eW("yy-manager setMediaMode 未初始化");
            return 1000;
        }
        eW("yy-manager setMediaMode " + i);
        return this.azZ.setMediaMode(i);
    }

    public int setRoomMode(int i) {
        if (this.azZ == null) {
            eW("yy-manager setRoomMode 未初始化");
            return 1000;
        }
        eW("yy-manager setRoomMode " + i);
        return this.azZ.setRoomMode(i);
    }

    public int setAudioConfig(int i, int i2, int i3) {
        if (this.azZ == null) {
            eW("yy-manager setAudioConfig 未初始化");
            return 1000;
        }
        eW("yy-manager setAudioConfig");
        Log.d(TAG, "setAudioConfig profile=" + i + " commutMode=" + i2 + " scenarioMode=" + i3);
        int audioConfig = this.azZ.setAudioConfig(i, i2, i3);
        Log.d(TAG, "setAudioConfig result=" + audioConfig);
        return audioConfig;
    }

    public int setVideoEncoderConfig(ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration) {
        if (this.azZ == null) {
            eW("yy-manager setVideoEncoderConfig 未初始化");
            return 1000;
        }
        eW("yy-manager setVideoEncoderConfig configuration=" + thunderVideoEncoderConfiguration);
        int videoEncoderConfig = this.azZ.setVideoEncoderConfig(thunderVideoEncoderConfiguration);
        eW("yy-manager setVideoEncoderConfig result=" + videoEncoderConfig);
        return videoEncoderConfig;
    }

    public int setLiveTranscodingTask(String str, LiveTranscoding liveTranscoding) {
        if (this.azZ != null) {
            eW("yy-manager setLiveTranscodingTask");
            int liveTranscodingTask = this.azZ.setLiveTranscodingTask(str, liveTranscoding);
            eW("yy-manager setLiveTranscodingTask: result=" + liveTranscodingTask);
            return liveTranscodingTask;
        }
        return 1000;
    }

    public int removeLiveTranscodingTask(String str) {
        if (this.azZ != null) {
            eW("yy-manager removeLiveTranscodingTask");
            int removeLiveTranscodingTask = this.azZ.removeLiveTranscodingTask(str);
            eW("yy-manager removeLiveTranscodingTask: result=" + removeLiveTranscodingTask);
            return removeLiveTranscodingTask;
        }
        return 1000;
    }

    public int addPublishTranscodingStreamUrl(String str, String str2) {
        if (this.azZ == null) {
            eW("yy-manager addPublishTranscodingStreamUrl 未初始化");
            return 1000;
        }
        azU = true;
        eW("yy-manager addPublishTranscodingStreamUrl: url=" + str2);
        int addPublishTranscodingStreamUrl = this.azZ.addPublishTranscodingStreamUrl(str, str2);
        eW("yy-manager addPublishTranscodingStreamUrl: result=" + addPublishTranscodingStreamUrl);
        return addPublishTranscodingStreamUrl;
    }

    public int removePublishTranscodingStreamUrl(String str, String str2) {
        if (this.azZ == null) {
            eW("yy-manager removePublishTranscodingStreamUrl 未初始化");
            return 1000;
        }
        azU = false;
        eW("yy-manager removePublishTranscodingStreamUrl");
        return this.azZ.removePublishTranscodingStreamUrl(str, str2);
    }

    public void a(ThunderCustomVideoSource thunderCustomVideoSource) {
        if (this.azZ == null) {
            eW("yy-manager setCustomVideoSource 未初始化");
            return;
        }
        eW("yy-manager setCustomVideoSource");
        this.azZ.setCustomVideoSource(thunderCustomVideoSource);
    }

    public int joinRoom(byte[] bArr, String str, String str2) {
        if (this.azZ == null) {
            eW("yy-manager joinRoom 未初始化");
            return 1000;
        } else if (TextUtils.isEmpty(str)) {
            eW("yy-manager joinRoom roomId empty");
            return 1000;
        } else if (TextUtils.isEmpty(str2)) {
            eW("yy-manager joinRoom uid empty");
            return 1000;
        } else {
            this.token = bArr;
            this.roomId = str;
            this.uid = str2;
            eW("yy-manager joinRoom");
            int joinRoom = this.azZ.joinRoom(bArr, str, str2);
            eW("yy-manager joinRoom：token=" + Arrays.toString(bArr) + " roomId=" + str + " uid=" + str2 + " result=" + joinRoom);
            return joinRoom;
        }
    }

    public int sendUserAppMsgData(byte[] bArr) {
        if (this.azZ == null) {
            eW("yy-manager sendUserAppMsgData 未初始化");
            return 1000;
        } else if (!this.azV.isTrue()) {
            eW("yy-manager sendUserAppMsgData 未 join room");
            return 1002;
        } else if (bArr == null || bArr.length <= 0) {
            return 1001;
        } else {
            int sendUserAppMsgData = this.azZ.sendUserAppMsgData(bArr);
            eW("yy-manager sendUserAppMsgData message= result=" + sendUserAppMsgData);
            return sendUserAppMsgData;
        }
    }

    public void d(View view, String str) {
        if (this.azZ != null) {
            eW("yy-manager setRemotePlayerView setRemoteCanvasMode");
            eW("yy-manager setRemoteCanvasMode: " + this.azZ.setRemoteVideoCanvas(new ThunderVideoCanvas(view, 2, str)));
        }
    }

    public int za() {
        if (this.azZ == null) {
            eW("yy-manager enableCaptureVolumeIndication 未初始化");
            return 1000;
        }
        eW("yy-manager enableCaptureVolumeIndication");
        int enableCaptureVolumeIndication = this.azZ.enableCaptureVolumeIndication(500, 0, 0, 0);
        eW("enableCaptureVolumeIndication result=" + enableCaptureVolumeIndication);
        return enableCaptureVolumeIndication;
    }

    public boolean isLoudspeakerEnabled() {
        if (this.azZ == null) {
            eW("yy-manager isLoudspeakerEnabled 未初始化");
            return false;
        }
        eW("yy-manager isLoudspeakerEnabled");
        boolean isLoudspeakerEnabled = this.azZ.isLoudspeakerEnabled();
        eW("yy-manager isLoudspeakerEnabled enabled=" + isLoudspeakerEnabled);
        return isLoudspeakerEnabled;
    }

    public int setLoudSpeakerVolume(int i) {
        if (this.azZ == null) {
            eW("yy-manager setLoudSpeakerVolume 未初始化");
            return 1000;
        }
        eW("yy-manager setLoudSpeakerVolume + " + i);
        int loudSpeakerVolume = this.azZ.setLoudSpeakerVolume(i);
        eW("yy-manager setLoudSpeakerVolume result=" + loudSpeakerVolume);
        return loudSpeakerVolume;
    }

    public void setSoundEffect(int i) {
        if (this.azZ == null) {
            eW("yy-manager setSoundEffect 未初始化");
            return;
        }
        eW("yy-manager setSoundEffect mode " + i);
        this.azZ.setSoundEffect(i);
    }

    public int zb() {
        if (this.azZ == null) {
            eW("yy-manager startAudio 未初始化");
            return 1000;
        } else if (!this.azV.isTrue()) {
            return 1002;
        } else {
            eW("yy-manager startAudio stopLocalAudioStream ");
            this.azZ.enableLocalAudioCapture(false);
            this.azZ.enableLocalAudioCapture(true);
            int stopLocalAudioStream = this.azZ.stopLocalAudioStream(false);
            if (stopLocalAudioStream != 0) {
                eX("startAudio stopLocalAudioStream error=" + stopLocalAudioStream);
                return stopLocalAudioStream;
            }
            this.azW = LiveDataState.FALSE;
            eW("yy-manager startAudio result=" + stopLocalAudioStream);
            return stopLocalAudioStream;
        }
    }

    public int zc() {
        if (this.azZ == null) {
            eW("yy-manager startVideo 未初始化");
            return 1000;
        } else if (!this.azV.isTrue()) {
            return 1002;
        } else {
            eW("yy-manager startVideo stopLocalVideoStream ");
            int stopLocalVideoStream = this.azZ.stopLocalVideoStream(false);
            if (stopLocalVideoStream != 0) {
                eX("startAudio stopLocalVideoStream error=" + stopLocalVideoStream);
                return stopLocalVideoStream;
            }
            this.azX = LiveDataState.FALSE;
            eW("yy-manager startVideo result=" + stopLocalVideoStream);
            return stopLocalVideoStream;
        }
    }

    public int zd() {
        if (this.azZ == null) {
            eW("yy-manager stopAudio 未初始化");
            return 1000;
        } else if (!this.azV.isTrue()) {
            return 1002;
        } else {
            eW("yy-manager stopAudio stopLocalAudioStream");
            int stopLocalAudioStream = this.azZ.stopLocalAudioStream(true);
            if (stopLocalAudioStream != 0) {
                eW("yy-manager stopAudio stopLocalAudioStream error=" + stopLocalAudioStream);
                return stopLocalAudioStream;
            }
            this.azW = LiveDataState.TRUE;
            eW("yy-manager stopAudio result=" + stopLocalAudioStream);
            return stopLocalAudioStream;
        }
    }

    public int ze() {
        if (this.azZ == null) {
            eW("yy-manager stopVideo 未初始化");
            return 1000;
        } else if (!this.azV.isTrue()) {
            return 1002;
        } else {
            eW("yy-manager stopVideo stopLocalVideoStream");
            int stopLocalVideoStream = this.azZ.stopLocalVideoStream(true);
            if (stopLocalVideoStream != 0) {
                eX("stopVideo stopLocalVideoStream error=" + stopLocalVideoStream);
                return stopLocalVideoStream;
            }
            this.azX = LiveDataState.TRUE;
            eW("yy-manager stopVideo result=" + stopLocalVideoStream);
            return stopLocalVideoStream;
        }
    }

    public int enableLocalAudioCapture(boolean z) {
        if (this.azZ == null) {
            eW("yy-manager enableLocalAudioCapture 未初始化");
            return 1000;
        }
        eW("yy-manager enableLocalAudioCapture enable " + z);
        int enableLocalAudioCapture = this.azZ.enableLocalAudioCapture(z);
        eW("yy-manager enableLocalAudioCapture enable " + z + " result " + enableLocalAudioCapture);
        return enableLocalAudioCapture;
    }

    public int setMicVolume(int i) {
        if (this.azZ == null) {
            eW("yy-manager enableLocalAudioCapture 未初始化");
            return 1000;
        }
        eW("yy-manager setMicVolume volume " + i);
        int micVolume = this.azZ.setMicVolume(i);
        eW("yy-manager setMicVolume volume " + i + " result " + micVolume);
        return micVolume;
    }

    public void eV(String str) {
        if (this.azZ == null) {
            eW("yy-manager updateToken 未初始化");
        } else if (TextUtils.isEmpty(str)) {
            eW("yy-manager  updateToken token is empty");
        } else {
            eW("yy-manager updateToken：roomId=" + this.roomId + " updateToken=" + str + " result=" + this.azZ.updateToken(str.getBytes()));
        }
    }

    public int leaveRoom() {
        if (this.azZ == null) {
            eW("yy-manager leaveRoom 未初始化");
            return 1000;
        }
        int i = 0;
        if (this.azV.isTrue()) {
            eW("yy-manager leaveRoom");
            this.azZ.setRemoteVideoCanvas(null);
            i = this.azZ.leaveRoom();
        }
        eW("yy-manager leaveRoom：roomId=" + this.roomId + " uid=" + this.uid + " result=" + i);
        return i;
    }

    public String getVersion() {
        return ThunderEngine.getVersion();
    }

    public void a(ThunderEventHandler thunderEventHandler) {
        this.aAa.add(thunderEventHandler);
    }

    public void b(ThunderEventHandler thunderEventHandler) {
        this.aAa.remove(thunderEventHandler);
    }

    public ThunderEventHandler zf() {
        return this.aAb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            Log.d(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            Log.e(TAG, str);
        }
    }
}
