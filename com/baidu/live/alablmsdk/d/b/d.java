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
/* loaded from: classes10.dex */
public class d {
    public static final String TAG = d.class.getSimpleName();
    public static volatile Integer aBt = null;
    public static volatile boolean aBu = false;
    private static volatile d aBy;
    private String roomId;
    private byte[] token;
    private String uid;
    public LiveDataState aBv = LiveDataState.NULL;
    public LiveDataState aBw = LiveDataState.NULL;
    public LiveDataState aBx = LiveDataState.NULL;
    private ThunderEngine aBz = null;
    private List<ThunderEventHandler> aBA = new CopyOnWriteArrayList();
    private ThunderEventHandler aBB = new ThunderEventHandler() { // from class: com.baidu.live.alablmsdk.d.b.d.1
        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onError(int i) {
            d.this.fd("onError" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onError(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onJoinRoomSuccess(String str, String str2, int i) {
            d.this.fc("yy-manager onJoinRoomSuccess: room=" + str + " uid =" + str2 + " elapsed =" + i);
            d.this.aBw = LiveDataState.NULL;
            d.this.aBx = LiveDataState.NULL;
            d.this.aBv = LiveDataState.TRUE;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onJoinRoomSuccess(str, str2, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLeaveRoom(ThunderEventHandler.RoomStats roomStats) {
            d.this.fc("yy-manager onLeaveRoom: " + roomStats.temp);
            d.this.aBw = LiveDataState.NULL;
            d.this.aBx = LiveDataState.NULL;
            d.this.token = null;
            d.this.roomId = null;
            d.this.uid = null;
            d.this.aBv = LiveDataState.FALSE;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onLeaveRoom(roomStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onBizAuthResult(boolean z, int i) {
            d.this.fc("yy-manager onBizAuthResult: bPublish = " + z + "::::result =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onBizAuthResult(z, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onSdkAuthResult(int i) {
            d.this.fc("yy-manager onSdkAuthResult: result = " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onSdkAuthResult(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserBanned(boolean z) {
            d.this.fc("yy-manager onUserBanned: status = " + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onUserBanned(z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserJoined(String str, int i) {
            d.this.fc("yy-manager onUserJoined: uid = " + str + "::::elapsed =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onUserJoined(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onUserOffline(String str, int i) {
            d.this.fc("yy-manager onUserOffline: uid = " + str + "::::reason =" + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onUserOffline(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onTokenWillExpire(byte[] bArr) {
            d.this.fc("yy-manager onTokenWillExpire: token = " + bArr);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onTokenWillExpire(bArr);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onTokenRequested() {
            d.this.fc("yy-manager onTokenRequested: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onTokenRequested();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onNetworkQuality(String str, int i, int i2) {
            d.this.fc("yy-manager onNetworkQuality: uid = " + str + ":::txQuality=" + i + ":::rxQuality=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i4)).onNetworkQuality(str, i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRoomStats(ThunderNotification.RoomStats roomStats) {
            d.this.fc("yy-manager onRoomStats: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRoomStats(roomStats);
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
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onLocalVideoStats(localVideoStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onPlayVolumeIndication(ThunderEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i) {
            d.this.fc("yy-manager onPlayVolumeIndication: totalVolume = " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onPlayVolumeIndication(audioVolumeInfoArr, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onCaptureVolumeIndication(int i, int i2, int i3) {
            d.this.fc("yy-manager onCaptureVolumeIndication: ");
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i5)).onCaptureVolumeIndication(i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioQuality(String str, int i, short s, short s2) {
            d.this.fc("yy-manager onAudioQuality: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onAudioQuality(str, i, s, s2);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionLost() {
            d.this.fc("yy-manager onConnectionLost: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onConnectionLost();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionInterrupted() {
            d.this.fc("yy-manager onConnectionInterrupted: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onConnectionInterrupted();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioRouteChanged(int i) {
            d.this.fc("yy-manager onAudioRouteChanged: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onAudioRouteChanged(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioPlayData(byte[] bArr, long j, long j2, String str, long j3) {
            d.this.fc("yy-manager onAudioPlayData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onAudioPlayData(bArr, j, j2, str, j3);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioPlaySpectrumData(byte[] bArr) {
            d.this.fc("yy-manager onAudioPlaySpectrumData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onAudioPlaySpectrumData(bArr);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRecvUserAppMsgData(byte[] bArr, String str) {
            d.this.fc("yy-manager onRecvUserAppMsgData: ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRecvUserAppMsgData(bArr, str);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onSendAppMsgDataFailedStatus(int i) {
            d.this.fc("yy-manager onSendAppMsgDataFailedStatus: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onSendAppMsgDataFailedStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalAudioFrameSent(int i) {
            d.this.fc("yy-manager onFirstLocalAudioFrameSent: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onFirstLocalAudioFrameSent(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalVideoFrameSent(int i) {
            d.this.fc("yy-manager onFirstLocalVideoFrameSent callback: ");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onFirstLocalVideoFrameSent(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onPublishStreamToCDNStatus(String str, int i) {
            int i2 = 0;
            d.this.fc("yy-manager onPublishStreamToCDNStatus: errorCode=" + i);
            d.aBt = Integer.valueOf(i);
            if (d.aBt.intValue() == 0) {
                d.aBu = true;
            } else {
                d.aBu = false;
            }
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onPublishStreamToCDNStatus(str, i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onNetworkTypeChanged(int i) {
            d.this.fc("yy-manager onNetworkTypeChanged: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onNetworkTypeChanged(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionStatus(int i) {
            d.this.fc("yy-manager onConnectionStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onConnectionStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioCaptureStatus(int i) {
            d.this.fc("yy-manager onAudioCaptureStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onAudioCaptureStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onVideoCaptureStatus(int i) {
            d.this.fc("yy-manager onVideoCaptureStatus: " + i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i3)).onVideoCaptureStatus(i);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioArrived(String str, String str2, boolean z) {
            d.this.fc("yy-manager onRemoteAudioArrived: roomId=" + str + " uid=" + str2 + " arrive=" + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRemoteAudioArrived(str, str2, z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoArrived(String str, String str2, boolean z) {
            d.this.fc("yy-manager onRemoteVideoArrived: roomId=" + str + "uid=" + str2 + " arrive=" + z);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRemoteVideoArrived(str, str2, z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoPlay(String str, int i, int i2, int i3) {
            d.this.fc("yy-manager onRemoteVideoPlay: uid=" + str + " width=" + i + " height=" + i2 + " elapsed=" + i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i5)).onRemoteVideoPlay(str, i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onVideoSizeChanged(String str, int i, int i2, int i3) {
            d.this.fc("yy-manager onVideoSizeChanged: uid=" + str + " width=" + i + " height=" + i2 + " rotation=" + i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i5)).onVideoSizeChanged(str, i, i2, i3);
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioStatsOfUid(String str, ThunderEventHandler.RemoteAudioStats remoteAudioStats) {
            super.onRemoteAudioStatsOfUid(str, remoteAudioStats);
            d.this.fc("yy-manager onRemoteAudioStatsOfUid: uid=" + str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRemoteAudioStatsOfUid(str, remoteAudioStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoStatsOfUid(String str, ThunderEventHandler.RemoteVideoStats remoteVideoStats) {
            super.onRemoteVideoStatsOfUid(str, remoteVideoStats);
            d.this.fc("yy-manager onRemoteVideoStatsOfUid: uid=" + str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i2)).onRemoteVideoStatsOfUid(str, remoteVideoStats);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLocalAudioStatusChanged(int i, int i2) {
            super.onLocalAudioStatusChanged(i, i2);
            d.this.fc("yy-manager onLocalAudioStatusChanged: status=" + i + " errorReason=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i4)).onLocalAudioStatusChanged(i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onLocalVideoStatusChanged(int i, int i2) {
            super.onLocalVideoStatusChanged(i, i2);
            d.this.fc("yy-manager onLocalVideoStatusChanged: status=" + i + " errorReason=" + i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < d.this.aBA.size()) {
                    ((ThunderEventHandler) d.this.aBA.get(i4)).onLocalVideoStatusChanged(i, i2);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    };

    private d() {
    }

    public static synchronized d za() {
        d dVar;
        synchronized (d.class) {
            if (aBy == null) {
                synchronized (d.class) {
                    if (aBy == null) {
                        aBy = new d();
                    }
                }
            }
            dVar = aBy;
        }
        return dVar;
    }

    public boolean zb() {
        return this.aBw == LiveDataState.FALSE;
    }

    public boolean zc() {
        return this.aBw == LiveDataState.FALSE;
    }

    public void a(Context context, String str, long j, ThunderEventHandler thunderEventHandler) {
        if (this.aBz == null) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-manager  create yy engine ", " appId:" + str + " sceneId:" + j);
            this.aBz = ThunderEngine.createEngine(context, str, j, thunderEventHandler);
            this.aBz.setArea(2);
        }
    }

    public void destroyEngine() {
        if (this.aBz != null) {
            com.baidu.live.alablmsdk.a.b.a.d("destroyEngine");
            ThunderEngine.destroyEngine();
            this.aBz = null;
        }
    }

    public int setMediaMode(int i) {
        if (this.aBz == null) {
            fc("yy-manager setMediaMode 未初始化");
            return 1000;
        }
        fc("yy-manager setMediaMode " + i);
        return this.aBz.setMediaMode(i);
    }

    public int setRoomMode(int i) {
        if (this.aBz == null) {
            fc("yy-manager setRoomMode 未初始化");
            return 1000;
        }
        fc("yy-manager setRoomMode " + i);
        return this.aBz.setRoomMode(i);
    }

    public int setAudioConfig(int i, int i2, int i3) {
        if (this.aBz == null) {
            fc("yy-manager setAudioConfig 未初始化");
            return 1000;
        }
        fc("yy-manager setAudioConfig");
        Log.d(TAG, "setAudioConfig profile=" + i + " commutMode=" + i2 + " scenarioMode=" + i3);
        int audioConfig = this.aBz.setAudioConfig(i, i2, i3);
        Log.d(TAG, "setAudioConfig result=" + audioConfig);
        return audioConfig;
    }

    public int setVideoEncoderConfig(ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration) {
        if (this.aBz == null) {
            fc("yy-manager setVideoEncoderConfig 未初始化");
            return 1000;
        }
        fc("yy-manager setVideoEncoderConfig configuration=" + thunderVideoEncoderConfiguration);
        int videoEncoderConfig = this.aBz.setVideoEncoderConfig(thunderVideoEncoderConfiguration);
        fc("yy-manager setVideoEncoderConfig result=" + videoEncoderConfig);
        return videoEncoderConfig;
    }

    public int setLiveTranscodingTask(String str, LiveTranscoding liveTranscoding) {
        if (this.aBz != null) {
            fc("yy-manager setLiveTranscodingTask");
            int liveTranscodingTask = this.aBz.setLiveTranscodingTask(str, liveTranscoding);
            fc("yy-manager setLiveTranscodingTask: result=" + liveTranscodingTask);
            return liveTranscodingTask;
        }
        return 1000;
    }

    public int removeLiveTranscodingTask(String str) {
        if (this.aBz != null) {
            fc("yy-manager removeLiveTranscodingTask");
            int removeLiveTranscodingTask = this.aBz.removeLiveTranscodingTask(str);
            fc("yy-manager removeLiveTranscodingTask: result=" + removeLiveTranscodingTask);
            return removeLiveTranscodingTask;
        }
        return 1000;
    }

    public int addPublishTranscodingStreamUrl(String str, String str2) {
        if (this.aBz == null) {
            fc("yy-manager addPublishTranscodingStreamUrl 未初始化");
            return 1000;
        }
        aBu = true;
        fc("yy-manager addPublishTranscodingStreamUrl: url=" + str2);
        int addPublishTranscodingStreamUrl = this.aBz.addPublishTranscodingStreamUrl(str, str2);
        fc("yy-manager addPublishTranscodingStreamUrl: result=" + addPublishTranscodingStreamUrl);
        return addPublishTranscodingStreamUrl;
    }

    public int removePublishTranscodingStreamUrl(String str, String str2) {
        if (this.aBz == null) {
            fc("yy-manager removePublishTranscodingStreamUrl 未初始化");
            return 1000;
        }
        aBu = false;
        fc("yy-manager removePublishTranscodingStreamUrl");
        return this.aBz.removePublishTranscodingStreamUrl(str, str2);
    }

    public void a(ThunderCustomVideoSource thunderCustomVideoSource) {
        if (this.aBz == null) {
            fc("yy-manager setCustomVideoSource 未初始化");
            return;
        }
        fc("yy-manager setCustomVideoSource");
        this.aBz.setCustomVideoSource(thunderCustomVideoSource);
    }

    public int joinRoom(byte[] bArr, String str, String str2) {
        if (this.aBz == null) {
            fc("yy-manager joinRoom 未初始化");
            return 1000;
        } else if (TextUtils.isEmpty(str)) {
            fc("yy-manager joinRoom roomId empty");
            return 1000;
        } else if (TextUtils.isEmpty(str2)) {
            fc("yy-manager joinRoom uid empty");
            return 1000;
        } else {
            this.token = bArr;
            this.roomId = str;
            this.uid = str2;
            fc("yy-manager joinRoom");
            int joinRoom = this.aBz.joinRoom(bArr, str, str2);
            fc("yy-manager joinRoom：token=" + Arrays.toString(bArr) + " roomId=" + str + " uid=" + str2 + " result=" + joinRoom);
            return joinRoom;
        }
    }

    public int sendUserAppMsgData(byte[] bArr) {
        if (this.aBz == null) {
            fc("yy-manager sendUserAppMsgData 未初始化");
            return 1000;
        } else if (!this.aBv.isTrue()) {
            fc("yy-manager sendUserAppMsgData 未 join room");
            return 1002;
        } else if (bArr == null || bArr.length <= 0) {
            return 1001;
        } else {
            int sendUserAppMsgData = this.aBz.sendUserAppMsgData(bArr);
            fc("yy-manager sendUserAppMsgData message= result=" + sendUserAppMsgData);
            return sendUserAppMsgData;
        }
    }

    public void d(View view, String str) {
        if (this.aBz != null) {
            fc("yy-manager setRemotePlayerView setRemoteCanvasMode");
            fc("yy-manager setRemoteCanvasMode: " + this.aBz.setRemoteVideoCanvas(new ThunderVideoCanvas(view, 2, str)));
        }
    }

    public int zd() {
        if (this.aBz == null) {
            fc("yy-manager enableCaptureVolumeIndication 未初始化");
            return 1000;
        }
        fc("yy-manager enableCaptureVolumeIndication");
        int enableCaptureVolumeIndication = this.aBz.enableCaptureVolumeIndication(500, 0, 0, 0);
        fc("enableCaptureVolumeIndication result=" + enableCaptureVolumeIndication);
        return enableCaptureVolumeIndication;
    }

    public boolean isLoudspeakerEnabled() {
        if (this.aBz == null) {
            fc("yy-manager isLoudspeakerEnabled 未初始化");
            return false;
        }
        fc("yy-manager isLoudspeakerEnabled");
        boolean isLoudspeakerEnabled = this.aBz.isLoudspeakerEnabled();
        fc("yy-manager isLoudspeakerEnabled enabled=" + isLoudspeakerEnabled);
        return isLoudspeakerEnabled;
    }

    public int setLoudSpeakerVolume(int i) {
        if (this.aBz == null) {
            fc("yy-manager setLoudSpeakerVolume 未初始化");
            return 1000;
        }
        fc("yy-manager setLoudSpeakerVolume + " + i);
        int loudSpeakerVolume = this.aBz.setLoudSpeakerVolume(i);
        fc("yy-manager setLoudSpeakerVolume result=" + loudSpeakerVolume);
        return loudSpeakerVolume;
    }

    public void setSoundEffect(int i) {
        if (this.aBz == null) {
            fc("yy-manager setSoundEffect 未初始化");
            return;
        }
        fc("yy-manager setSoundEffect mode " + i);
        this.aBz.setSoundEffect(i);
    }

    public int ze() {
        if (this.aBz == null) {
            fc("yy-manager startAudio 未初始化");
            return 1000;
        } else if (!this.aBv.isTrue()) {
            return 1002;
        } else {
            fc("yy-manager startAudio stopLocalAudioStream ");
            this.aBz.enableLocalAudioCapture(false);
            this.aBz.enableLocalAudioCapture(true);
            int stopLocalAudioStream = this.aBz.stopLocalAudioStream(false);
            if (stopLocalAudioStream != 0) {
                fd("startAudio stopLocalAudioStream error=" + stopLocalAudioStream);
                return stopLocalAudioStream;
            }
            this.aBw = LiveDataState.FALSE;
            fc("yy-manager startAudio result=" + stopLocalAudioStream);
            return stopLocalAudioStream;
        }
    }

    public int zf() {
        if (this.aBz == null) {
            fc("yy-manager startVideo 未初始化");
            return 1000;
        } else if (!this.aBv.isTrue()) {
            return 1002;
        } else {
            fc("yy-manager startVideo stopLocalVideoStream ");
            int stopLocalVideoStream = this.aBz.stopLocalVideoStream(false);
            if (stopLocalVideoStream != 0) {
                fd("startAudio stopLocalVideoStream error=" + stopLocalVideoStream);
                return stopLocalVideoStream;
            }
            this.aBx = LiveDataState.FALSE;
            fc("yy-manager startVideo result=" + stopLocalVideoStream);
            return stopLocalVideoStream;
        }
    }

    public int zg() {
        if (this.aBz == null) {
            fc("yy-manager stopAudio 未初始化");
            return 1000;
        } else if (!this.aBv.isTrue()) {
            return 1002;
        } else {
            fc("yy-manager stopAudio stopLocalAudioStream");
            int stopLocalAudioStream = this.aBz.stopLocalAudioStream(true);
            if (stopLocalAudioStream != 0) {
                fc("yy-manager stopAudio stopLocalAudioStream error=" + stopLocalAudioStream);
                return stopLocalAudioStream;
            }
            this.aBw = LiveDataState.TRUE;
            fc("yy-manager stopAudio result=" + stopLocalAudioStream);
            return stopLocalAudioStream;
        }
    }

    public int zh() {
        if (this.aBz == null) {
            fc("yy-manager stopVideo 未初始化");
            return 1000;
        } else if (!this.aBv.isTrue()) {
            return 1002;
        } else {
            fc("yy-manager stopVideo stopLocalVideoStream");
            int stopLocalVideoStream = this.aBz.stopLocalVideoStream(true);
            if (stopLocalVideoStream != 0) {
                fd("stopVideo stopLocalVideoStream error=" + stopLocalVideoStream);
                return stopLocalVideoStream;
            }
            this.aBx = LiveDataState.TRUE;
            fc("yy-manager stopVideo result=" + stopLocalVideoStream);
            return stopLocalVideoStream;
        }
    }

    public int enableLocalAudioCapture(boolean z) {
        if (this.aBz == null) {
            fc("yy-manager enableLocalAudioCapture 未初始化");
            return 1000;
        }
        fc("yy-manager enableLocalAudioCapture enable " + z);
        int enableLocalAudioCapture = this.aBz.enableLocalAudioCapture(z);
        fc("yy-manager enableLocalAudioCapture enable " + z + " result " + enableLocalAudioCapture);
        return enableLocalAudioCapture;
    }

    public int setMicVolume(int i) {
        if (this.aBz == null) {
            fc("yy-manager enableLocalAudioCapture 未初始化");
            return 1000;
        }
        fc("yy-manager setMicVolume volume " + i);
        int micVolume = this.aBz.setMicVolume(i);
        fc("yy-manager setMicVolume volume " + i + " result " + micVolume);
        return micVolume;
    }

    public void fb(String str) {
        if (this.aBz == null) {
            fc("yy-manager updateToken 未初始化");
        } else if (TextUtils.isEmpty(str)) {
            fc("yy-manager  updateToken token is empty");
        } else {
            fc("yy-manager updateToken：roomId=" + this.roomId + " updateToken=" + str + " result=" + this.aBz.updateToken(str.getBytes()));
        }
    }

    public int leaveRoom() {
        if (this.aBz == null) {
            fc("yy-manager leaveRoom 未初始化");
            return 1000;
        }
        int i = 0;
        if (this.aBv.isTrue()) {
            fc("yy-manager leaveRoom");
            this.aBz.setRemoteVideoCanvas(null);
            i = this.aBz.leaveRoom();
        }
        fc("yy-manager leaveRoom：roomId=" + this.roomId + " uid=" + this.uid + " result=" + i);
        return i;
    }

    public String getVersion() {
        return ThunderEngine.getVersion();
    }

    public void a(ThunderEventHandler thunderEventHandler) {
        this.aBA.add(thunderEventHandler);
    }

    public void b(ThunderEventHandler thunderEventHandler) {
        this.aBA.remove(thunderEventHandler);
    }

    public ThunderEventHandler zi() {
        return this.aBB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            Log.d(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            Log.e(TAG, str);
        }
    }
}
