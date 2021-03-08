package com.baidu.live.alablmsdk.d.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.alablmsdk.config.a;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.thunder.livesdk.CustomTranscodingOptions;
import com.thunder.livesdk.LiveTranscoding;
import com.thunder.livesdk.ThunderCustomVideoSource;
import com.thunder.livesdk.ThunderEventHandler;
import com.thunder.livesdk.ThunderExternalVideoFrame;
import com.thunder.livesdk.ThunderVideoEncoderConfiguration;
import com.thunder.livesdk.ThunderVideoFrameConsumer;
import com.yy.mediaframework.base.VideoEncoderConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e implements com.baidu.live.alablmsdk.c.b.g {
    public static long aBF = 0;
    public static String mTaskId;
    private long aAg;
    private com.baidu.live.alablmsdk.c.b.f aAq;
    private ThunderVideoFrameConsumer aBH;
    private com.baidu.live.alablmsdk.config.a aBI;
    private int aBJ;
    private ThunderCustomVideoSource aBQ;
    private boolean ayt;
    private String azh;
    private boolean isMute;
    private Context mContext;
    private b aBE = new b();
    private Set<String> aBG = new HashSet();
    private boolean isStarted = false;
    private JSONObject aBK = new JSONObject();
    private boolean aBL = true;
    private boolean aBM = true;
    private boolean aAw = true;
    private boolean aBN = false;
    private boolean aBO = true;
    private Map<String, g> aBP = new HashMap();
    private com.baidu.live.alablmsdk.c.a.a aAk = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.b.e.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (e.this.isStarted && e.this.aBH != null) {
                long nanoTime = System.nanoTime() / TimeUtils.NANOS_PER_MS;
                ThunderExternalVideoFrame thunderExternalVideoFrame = new ThunderExternalVideoFrame();
                thunderExternalVideoFrame.data = bArr;
                thunderExternalVideoFrame.width = i;
                thunderExternalVideoFrame.height = i2;
                thunderExternalVideoFrame.scaleMode = 1;
                thunderExternalVideoFrame.timeStamp = nanoTime;
                thunderExternalVideoFrame.format = 2;
                thunderExternalVideoFrame.rotation = 0;
                e.this.aBH.consumeVideoFrame(thunderExternalVideoFrame);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.a.d(" InnerCapture error=" + i + " , errorMsg=" + str);
        }
    };
    private ThunderEventHandler aBB = new ThunderEventHandler() { // from class: com.baidu.live.alablmsdk.d.b.e.3
        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onError(int i) {
            super.onError(i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc error, code=" + i, "");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onJoinRoomSuccess(String str, String str2, int i) {
            super.onJoinRoomSuccess(str, str2, i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onJoinRoomSuccess ", " room=" + str + " , uid=" + str2);
            e.this.zk();
            e.this.c(true, "yy-rtc join room success");
            com.baidu.live.alablmsdk.a.b.c.xx().xz();
            if (e.this.aAw) {
                int ze = e.this.aBM ? d.za().ze() : 0;
                int zf = e.this.aBL ? d.za().zf() : 0;
                if (e.this.isMute) {
                    d.za().enableLocalAudioCapture(e.this.isMute ? false : true);
                }
                if (ze != 0) {
                    e.this.e(false, "yy-rtc push media fail");
                } else if (zf != 0) {
                    e.this.d(false, "yy-rtc push media fail");
                } else {
                    e.this.zl();
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalVideoFrameSent(int i) {
            super.onFirstLocalVideoFrameSent(i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc  onFirstLocalVideoFrameSent ", "");
            e.this.d(true, "yy-rtc first video frame sent success");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onFirstLocalAudioFrameSent(int i) {
            super.onFirstLocalAudioFrameSent(i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc  onFirstLocalAudioFrameSent ", "");
            e.this.e(true, "yy-rtc first audio frame sent success");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onPublishStreamToCDNStatus(String str, int i) {
            super.onPublishStreamToCDNStatus(str, i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onPublishStreamToCDNStatus: errorCode=" + i, " , url=" + str);
            if (i == 0) {
                e.this.f(true, "yy-rtc trans success ");
            } else if (i == 1 || i == 2) {
                e.this.f(false, "yy-rtc trans fail , errorCode=" + i);
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoArrived(String str, String str2, boolean z) {
            super.onRemoteVideoArrived(str, str2, z);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc  onRemoteVideoArrived ", " uid=" + str2 + " , arrive=" + z);
            if (e.this.aBL) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.azK = Long.valueOf(str2).longValue();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.azK = Long.valueOf(str2).longValue();
                if (z) {
                    if (e.this.aAq != null) {
                        e.this.aAq.b(cVar2);
                        e.this.aAq.c(cVar);
                    }
                    if (!e.this.aBG.contains(str2) && e.this.ff(str2)) {
                        com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoArrived: arrive=" + z + " , add " + str2);
                        e.this.aBG.add(str2);
                    }
                } else {
                    if (e.this.aAq != null) {
                        e.this.aAq.c(cVar2);
                        e.this.aAq.d(cVar);
                    }
                    if (e.this.aBG.contains(str2)) {
                        com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoArrived: arrive=" + z + " , remove " + str2);
                        e.this.aBG.remove(str2);
                    }
                }
                if (e.this.aBI != null && e.this.yo()) {
                    LiveTranscoding a2 = e.this.a(false, e.this.aBI);
                    d.za().setLiveTranscodingTask(e.mTaskId, a2);
                    CustomTranscodingOptions customTranscodingOptions = a2.getCustomTranscodingOptions();
                    com.baidu.live.alablmsdk.a.b.c.xx().e(customTranscodingOptions.videoFps, customTranscodingOptions.videoFps, customTranscodingOptions.videoBitrate + customTranscodingOptions.audioBitrate, customTranscodingOptions.videoBitrate + customTranscodingOptions.audioBitrate, customTranscodingOptions.audioSample, customTranscodingOptions.audioChannel);
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioArrived(String str, String str2, boolean z) {
            super.onRemoteAudioArrived(str, str2, z);
            if (!e.this.aBL) {
                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onRemoteAudioArrived roomId " + str + " id " + str2 + " arrive " + z, "");
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.azK = Long.valueOf(str2).longValue();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.azK = Long.valueOf(str2).longValue();
                if (z) {
                    if (e.this.aAq != null) {
                        e.this.aAq.b(cVar2);
                        e.this.aAq.c(cVar);
                    }
                } else if (e.this.aAq != null) {
                    e.this.aAq.c(cVar2);
                    e.this.aAq.d(cVar);
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoPlay(String str, int i, int i2, int i3) {
            super.onRemoteVideoPlay(str, i, i2, i3);
            com.baidu.live.alablmsdk.a.b.a.d("yy-rtc  onRemoteVideoArrived uid " + str + " width " + i + "  height" + i2);
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onTokenWillExpire(byte[] bArr) {
            super.onTokenWillExpire(bArr);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onTokenWillExpire", "");
            e.this.a(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.3.1
                @Override // com.baidu.live.alablmsdk.c.b.a
                public void ai(String str, String str2) {
                    if (!TextUtils.isEmpty(str)) {
                        d.za().fb(str);
                    }
                }
            });
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onNetworkQuality(String str, int i, int i2) {
            super.onNetworkQuality(str, i, i2);
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionLost() {
            super.onConnectionLost();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onConnectionLost ", "");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onConnectionStatus(int i) {
            super.onConnectionStatus(i);
            boolean z = d.za().zb() || d.za().zc();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current stream status=" + i + " isPushStream " + z, " mCurrentUserConnected " + e.this.aBO);
            if (z) {
                if (i == 1) {
                    e.this.aBO = true;
                    if (e.this.aAq != null) {
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current-stream-arrival callback", "");
                        e.this.aAq.ci(1);
                        com.baidu.live.alablmsdk.a.b.c.xx().xD();
                    }
                } else if (e.this.aBO && i == 2) {
                    e.this.aBO = false;
                    if (e.this.aAq != null) {
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current-stream-leave callback", "");
                        e.this.aAq.ci(2);
                        com.baidu.live.alablmsdk.a.b.c.xx().cc(0);
                    }
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioStatsOfUid(String str, ThunderEventHandler.RemoteAudioStats remoteAudioStats) {
            super.onRemoteAudioStatsOfUid(str, remoteAudioStats);
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteVideoStatsOfUid(String str, ThunderEventHandler.RemoteVideoStats remoteVideoStats) {
            super.onRemoteVideoStatsOfUid(str, remoteVideoStats);
            int i = remoteVideoStats != null ? remoteVideoStats.receivedBitrate : 0;
            String str2 = e.this.aAg + "";
            boolean z = !TextUtils.isEmpty(str2) && str2.equals(str);
            com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoStatsOfUid uid=" + str + " , isCurrentUser=" + z + " , receivedBitrate=" + i);
            if (!z) {
                if (e.this.aBL && remoteVideoStats != null) {
                    if (e.this.aBP.containsKey(str)) {
                        g gVar = (g) e.this.aBP.get(str);
                        if (remoteVideoStats.receivedBitrate > 0) {
                            if (gVar.status == 0) {
                                gVar.status = 1;
                                gVar.num = 0L;
                                e.this.aBP.put(str, gVar);
                                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onRemoteVideoStatsOfUid arrive callback", "");
                                e.this.a(1, true, str);
                                return;
                            }
                            return;
                        }
                        gVar.status = 0;
                        gVar.num++;
                        e.this.aBP.put(str, gVar);
                        if (gVar.num == 3) {
                            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onRemoteVideoStatsOfUid leave callback", "");
                            e.this.a(1, false, str);
                            return;
                        }
                        return;
                    }
                    g gVar2 = new g();
                    gVar2.status = 1;
                    gVar2.num = 0L;
                    e.this.aBP.put(str, gVar2);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc ronRemoteVideoStatsOfUid me return", "");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onCaptureVolumeIndication(int i, int i2, int i3) {
            super.onCaptureVolumeIndication(i, i2, i3);
            e.this.aBJ = i3;
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRecvUserAppMsgData(byte[] bArr, String str) {
            e.this.c(bArr, str);
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onAudioCaptureStatus(int i) {
            super.onAudioCaptureStatus(i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc audio capture status " + i, "");
        }
    };
    Runnable aBR = new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.c(false, "yy-rtc join room 20s no callback ");
        }
    };
    private f aBD = new f();

    public e(Context context) {
        this.mContext = context;
        mTaskId = com.baidu.live.alablmsdk.a.c.a.ce(10);
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc taskId " + mTaskId, "");
        a((com.baidu.live.alablmsdk.c.b.a) null);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.c.b.f fVar) {
        this.aAq = fVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void v(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        if (hashMap == null) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc configParamSetting: paramSettings is null", "");
            return;
        }
        if (hashMap.containsKey("yy_rtc_private_params_key")) {
            this.aBE.y((HashMap) hashMap.get("yy_rtc_private_params_key"));
        }
        if (TextUtils.isEmpty(this.aBE.mAppId)) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc app id is empty", "");
            return;
        }
        if (hashMap.containsKey("has_video") && (obj3 = hashMap.get("has_video")) != null) {
            this.aBL = ((Boolean) obj3).booleanValue();
        }
        if (hashMap.containsKey("has_audio") && (obj2 = hashMap.get("has_audio")) != null) {
            this.aBM = ((Boolean) obj2).booleanValue();
        }
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.aAw = ((Boolean) obj).booleanValue();
        }
        if (!this.aBN) {
            this.aBN = true;
            a((com.baidu.live.alablmsdk.c.b.a) null);
        }
        d.za().a(this.mContext, this.aBE.mAppId, aBF, d.za().zi());
        d.za().a(this.aBB);
        com.baidu.live.alablmsdk.a.b.c.xx().eN(d.za().getVersion());
        if (this.aBL) {
            this.aBQ = new ThunderCustomVideoSource() { // from class: com.baidu.live.alablmsdk.d.b.e.5
                @Override // com.thunder.livesdk.ThunderCustomVideoSource
                public boolean onInitialize(ThunderVideoFrameConsumer thunderVideoFrameConsumer) {
                    e.this.aBH = thunderVideoFrameConsumer;
                    return false;
                }

                @Override // com.thunder.livesdk.ThunderCustomVideoSource
                public boolean onStart() {
                    e.this.isStarted = true;
                    return false;
                }

                @Override // com.thunder.livesdk.ThunderCustomVideoSource
                public boolean onStop() {
                    e.this.isStarted = false;
                    return false;
                }

                @Override // com.thunder.livesdk.ThunderCustomVideoSource
                public boolean onDispose() {
                    return false;
                }
            };
            d.za().a(this.aBQ);
            ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration = new ThunderVideoEncoderConfiguration();
            if (this.aBE.aBq != -1) {
                thunderVideoEncoderConfiguration.publishMode = this.aBE.aBq;
                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc configuration.publishMode  " + thunderVideoEncoderConfiguration.publishMode, "");
            }
            thunderVideoEncoderConfiguration.playType = this.aBE.mPlayType;
            d.za().setVideoEncoderConfig(thunderVideoEncoderConfiguration);
        }
        d.za().setMediaMode(this.aBE.aBm);
        d.za().setRoomMode(this.aBE.aBl);
        d.za().setAudioConfig(this.aBE.aBn, this.aBE.aBo, this.aBE.aBp);
        if (this.aBE.aBr != -1) {
            d.za().setSoundEffect(this.aBE.aBr);
        }
        d.za().zd();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.aAw = ((Boolean) obj).booleanValue();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc yy rtc updateParamSetting  isAutoPublish=" + this.aAw, "");
            return 0;
        }
        return 0;
    }

    public void d(View view, String str) {
        d.za().d(view, str);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aBI = aVar;
        if (aVar != null && ((aVar.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM && aVar.ayL != null && aVar.ayL.xP()) || ((aVar.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR && aVar.ayM != null && aVar.ayM.xP()) || (aVar.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR && aVar.ayL != null && aVar.ayL.xP() && aVar.ayM != null && aVar.ayM.xP())))) {
            this.ayt = true;
            com.baidu.live.alablmsdk.a.b.c.xx().bb(this.ayt);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc parseLiveStream isNeedTransfer=" + this.ayt, "");
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aBI != null && this.aBI.ayL != null && this.aBI.ayL.xP()) {
            this.ayt = true;
            com.baidu.live.alablmsdk.a.b.c.xx().bb(this.ayt);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc startLiveServerStreaming transferMode=" + bLMLiveTransferMode, "");
        zl();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aBI != null && this.aBI.ayL != null && this.aBI.ayL.xP()) {
            this.ayt = false;
            com.baidu.live.alablmsdk.a.b.c.xx().bb(this.ayt);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stopLiveServerStreaming transferMode=" + bLMLiveTransferMode, "");
        zm();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yl() {
        int i;
        int i2;
        if (this.aBM) {
            i = d.za().ze();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc publishStream push audio result=" + i, "");
        } else {
            i = 0;
        }
        if (this.aBL) {
            i2 = d.za().zf();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc publishStream push video result=" + i2, "");
        } else {
            i2 = 0;
        }
        com.baidu.live.alablmsdk.a.b.c.xx().xA();
        return (i == 0 && i2 == 0) ? 0 : -1;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xn() {
        if (this.aBM) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stop publishStream push audio result=" + d.za().zg(), "");
        }
        if (this.aBL) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stop publishStream push video result=" + d.za().zh(), "");
        }
        com.baidu.live.alablmsdk.a.b.c.xx().xC();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void eT(String str) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aY(final boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc muteSpeaker: mute" + z, "");
        this.isMute = z;
        d.za().setMicVolume(z ? 0 : 100);
        com.baidu.live.alablmsdk.a.c.xr().postDelayed(new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                d.za().enableLocalAudioCapture(!z);
            }
        }, 400L);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aZ(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc muteSpeaker: mute" + z + " , isOutSpeaker=" + d.za().isLoudspeakerEnabled(), "");
        if (z) {
            d.za().setLoudSpeakerVolume(0);
        } else {
            d.za().setLoudSpeakerVolume(100);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void setUserAttribute(String str) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, boolean z) {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.live.alablmsdk.module.c cVar = list.get(i2);
                    if (cVar != null) {
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc shutUpUserWithId id " + cVar.azK + " result " + d.za().sendUserAppMsgData(a.b(this.aAg, cVar.azK, z)), "");
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ym() {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.module.rtc.d yn() {
        com.baidu.live.alablmsdk.module.rtc.d dVar = new com.baidu.live.alablmsdk.module.rtc.d();
        dVar.volume = this.aBJ;
        dVar.id = this.azh;
        return dVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.za().sendUserAppMsgData(a.a(this.aAg, cVar != null ? cVar.azK : 0L, str));
        return true;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yo() {
        return this.ayt;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String yp() {
        return this.azh;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yq() {
        return this.aAk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.alablmsdk.c.b.a aVar) {
        if (this.aBD != null) {
            this.aBD.setAppId(this.aBE.mAppId);
            if (this.aAg == 0) {
                if (this.aAq != null) {
                    this.aAq.a(new com.baidu.live.alablmsdk.c.b.b() { // from class: com.baidu.live.alablmsdk.d.b.e.7
                        @Override // com.baidu.live.alablmsdk.c.b.b
                        public void ax(long j) {
                            e.this.aAg = j;
                            e.this.aBD.fg(e.this.aAg + "");
                            e.this.aBD.b(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.7.1
                                @Override // com.baidu.live.alablmsdk.c.b.a
                                public void ai(String str, String str2) {
                                    if (aVar != null) {
                                        aVar.ai(str, str2);
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
                return;
            }
            this.aBD.fg(this.aAg + "");
            this.aBD.b(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.8
                @Override // com.baidu.live.alablmsdk.c.b.a
                public void ai(String str, String str2) {
                    if (aVar != null) {
                        aVar.ai(str, str2);
                    }
                }
            });
        }
    }

    public void fe(final String str) {
        if (this.aBD != null) {
            String token = this.aBD.getToken();
            if (TextUtils.isEmpty(token)) {
                a(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.9
                    @Override // com.baidu.live.alablmsdk.c.b.a
                    public void ai(String str2, String str3) {
                        if (!TextUtils.isEmpty(str2)) {
                            e.this.aj(str, str2);
                        } else {
                            e.this.c(false, "yy-rtc getTokenAsync error, token is empty" + str3);
                        }
                    }
                });
            } else {
                aj(str, token);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(final String str, final String str2) {
        if (this.aAg != 0) {
            c(str, str2, this.aAg);
        } else if (this.aAq != null) {
            this.aAq.a(new com.baidu.live.alablmsdk.c.b.b() { // from class: com.baidu.live.alablmsdk.d.b.e.10
                @Override // com.baidu.live.alablmsdk.c.b.b
                public void ax(long j) {
                    e.this.aAg = j;
                    e.this.c(str, str2, e.this.aAg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, long j) {
        String str3 = null;
        com.baidu.live.alablmsdk.a.b.a.d("yy-rtc joinRtcRoomInner： roomId=" + str + " , token=" + str2 + " , imUk=" + j);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j == 0) {
            c(false, "yy-rtc join rtc room params error");
        }
        this.azh = str;
        this.aAg = j;
        if (this.aBI != null && this.aBI.ayL != null) {
            str3 = this.aBI.ayL.ayR;
        }
        com.baidu.live.alablmsdk.a.b.c.xx().setPushConfig(AlaRecorderLog.Protocol.RTC, str3);
        com.baidu.live.alablmsdk.a.b.c.xx().xy();
        zj();
        if (d.za().joinRoom(str2.getBytes(), str, j + "") != 0) {
            c(false, "yy-rtc join rtc room error");
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void az(long j) {
    }

    private void zj() {
        com.baidu.live.alablmsdk.a.c.xr().postDelayed(this.aBR, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk() {
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.aBR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str) {
        if (this.aAq != null) {
            if (z) {
                this.aAq.i(0, str);
            } else {
                this.aAq.i(-1, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        if (this.aAq != null) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.azK = this.aAg;
            cVar.aAi = str;
            if (z) {
                this.aAq.a(cVar);
                com.baidu.live.alablmsdk.a.b.c.xx().xB();
                return;
            }
            this.aAq.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (this.aAq != null && !this.aBL) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.azK = this.aAg;
            cVar.aAi = str;
            if (z) {
                this.aAq.a(cVar);
            } else {
                this.aAq.b(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (this.aAq != null) {
            if (z) {
                this.aAq.j(0, str);
                com.baidu.live.alablmsdk.a.b.c.xx().eI("anchor");
                return;
            }
            this.aAq.j(-1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc remote stream change callback: streamType=" + i + " isArrive=" + z + " id=" + str, "");
        if (this.aAq != null) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.azK = Long.valueOf(str).longValue();
            if (z) {
                this.aAq.c(cVar);
            } else {
                this.aAq.d(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ff(String str) {
        if (TextUtils.isEmpty(str) || this.aAq == null) {
            return false;
        }
        List<com.baidu.live.alablmsdk.module.c> yg = this.aAq.yg();
        if (com.baidu.live.alablmsdk.a.a.isEmpty(yg)) {
            return false;
        }
        for (int i = 0; i < yg.size(); i++) {
            com.baidu.live.alablmsdk.module.c cVar = yg.get(i);
            if (cVar != null && cVar.azK != 0 && str.equals(cVar.azK + "")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl() {
        if (this.aBI != null && this.aBI.ayM != null && !TextUtils.isEmpty(this.aBI.ayM.ayR) && yo()) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc TranscodingStreamUrl=" + this.aBI.ayM.ayR, "");
            int liveTranscodingTask = d.za().setLiveTranscodingTask(mTaskId, a(true, this.aBI));
            int addPublishTranscodingStreamUrl = d.za().addPublishTranscodingStreamUrl(mTaskId, this.aBI.ayM.ayR);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc addPublishTranscodingStreamUrl: setTransTaskResult=" + liveTranscodingTask + " ,addTransUrlResult=" + addPublishTranscodingStreamUrl, "");
            if (liveTranscodingTask != 0 || addPublishTranscodingStreamUrl != 0) {
                f(false, " yy rtc trans media fail");
            }
            com.baidu.live.alablmsdk.a.b.c.xx().eH("anchor");
        }
    }

    private void zm() {
        if (this.aBI != null && this.aBI.ayM != null && yo()) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc TranscodingStreamUrl=" + this.aBI.ayM.ayR, "");
            int removeLiveTranscodingTask = d.za().removeLiveTranscodingTask(mTaskId);
            int removePublishTranscodingStreamUrl = d.za().removePublishTranscodingStreamUrl(mTaskId, this.aBI.ayM.ayR);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc addPublishTranscodingStreamUrl: removeTransTaskResult=" + removeLiveTranscodingTask + " ,removeTransUrlResult=" + removePublishTranscodingStreamUrl, "");
            if (removeLiveTranscodingTask != 0 || removePublishTranscodingStreamUrl != 0) {
                f(false, "yy-rtc trans media fail");
            }
            com.baidu.live.alablmsdk.a.b.c.xx().eJ("anchor");
        }
    }

    public LiveTranscoding a(boolean z, com.baidu.live.alablmsdk.config.a aVar) {
        a.C0167a c0167a;
        int i;
        int i2;
        if (aVar != null && (c0167a = aVar.ayM) != null) {
            LiveTranscoding liveTranscoding = new LiveTranscoding();
            CustomTranscodingOptions customTranscodingOptions = new CustomTranscodingOptions();
            if (this.aBL) {
                if (c0167a.ayO == null) {
                    i = 960;
                    i2 = 544;
                } else {
                    int width = c0167a.ayO.getWidth();
                    i = c0167a.ayO.getHeight();
                    i2 = width;
                }
                if (this.aAg != 0) {
                    LiveTranscoding.TranscodingUser transcodingUser = new LiveTranscoding.TranscodingUser();
                    com.baidu.live.alablmsdk.config.a.d dVar = null;
                    com.baidu.live.alablmsdk.config.a.a aVar2 = null;
                    if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0167a.ayU) && (aVar2 = c0167a.ayU.get(0)) != null) {
                        dVar = aVar.b(c0167a.ayO, c0167a.ayT, aVar2.aze);
                    }
                    transcodingUser.roomId = this.azh;
                    transcodingUser.uid = this.aAg + "";
                    transcodingUser.layoutX = dVar != null ? dVar.x : 0;
                    transcodingUser.layoutY = dVar != null ? dVar.y : 0;
                    transcodingUser.layoutW = dVar != null ? dVar.width : i2;
                    transcodingUser.layoutH = dVar != null ? dVar.height : i;
                    transcodingUser.zOrder = aVar2 != null ? aVar2.azd : 0;
                    transcodingUser.bCrop = true;
                    transcodingUser.layoutShape = 0;
                    liveTranscoding.addUser(transcodingUser);
                    com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc LiveTranscoding: add myself=" + transcodingUser.toString(), "");
                }
                if (this.aBG != null && !this.aBG.isEmpty()) {
                    Iterator<String> it = this.aBG.iterator();
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            LiveTranscoding.TranscodingUser transcodingUser2 = new LiveTranscoding.TranscodingUser();
                            com.baidu.live.alablmsdk.config.a.d dVar2 = null;
                            com.baidu.live.alablmsdk.config.a.a aVar3 = null;
                            if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0167a.ayU) && (aVar3 = c0167a.ayU.get(1)) != null) {
                                dVar2 = aVar.b(c0167a.ayO, c0167a.ayT, aVar3.aze);
                            }
                            transcodingUser2.roomId = this.azh;
                            transcodingUser2.uid = next;
                            transcodingUser2.layoutX = dVar2 != null ? dVar2.x : 0;
                            transcodingUser2.layoutY = dVar2 != null ? dVar2.y : 0;
                            if (dVar2 != null) {
                                i2 = dVar2.width;
                            }
                            transcodingUser2.layoutW = i2;
                            if (dVar2 != null) {
                                i = dVar2.height;
                            }
                            transcodingUser2.layoutH = i;
                            transcodingUser2.zOrder = aVar3 != null ? aVar3.azd : 0;
                            transcodingUser2.bCrop = true;
                            transcodingUser2.layoutShape = 0;
                            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc LiveTranscoding: add other=" + transcodingUser2.toString(), "");
                            liveTranscoding.addUser(transcodingUser2);
                        }
                    }
                }
                customTranscodingOptions.videoCodecType = 2;
                customTranscodingOptions.videoBitrate = c0167a.ayQ;
                customTranscodingOptions.videoFps = c0167a.fps;
                customTranscodingOptions.videoGop = c0167a.fps * 4;
                if (c0167a.ayO != null) {
                    customTranscodingOptions.videoWidth = c0167a.ayO.getWidth();
                    customTranscodingOptions.videoHeight = c0167a.ayO.getHeight();
                } else {
                    customTranscodingOptions.videoWidth = VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH;
                    customTranscodingOptions.videoHeight = 960;
                }
                liveTranscoding.setTransCodingStreamType(0);
            } else {
                if (z) {
                    LiveTranscoding.TranscodingUser transcodingUser3 = new LiveTranscoding.TranscodingUser();
                    transcodingUser3.roomId = this.azh;
                    transcodingUser3.uid = this.aAg + "";
                    liveTranscoding.addUser(transcodingUser3);
                }
                customTranscodingOptions.videoCodecType = 2;
                customTranscodingOptions.videoBitrate = 1;
                customTranscodingOptions.videoFps = 1;
                customTranscodingOptions.videoGop = 1;
                customTranscodingOptions.videoWidth = 4;
                customTranscodingOptions.videoHeight = 4;
                liveTranscoding.setTransCodingStreamType(2);
            }
            customTranscodingOptions.audioCodecType = 2;
            customTranscodingOptions.audioSample = c0167a.ayP.getSampleRate();
            customTranscodingOptions.audioBitrate = 128;
            customTranscodingOptions.audioChannel = 2;
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc TranscodingOptions videoCodecType=" + customTranscodingOptions.videoCodecType + " , videoBitrate=" + customTranscodingOptions.videoBitrate + " , videoFps=" + customTranscodingOptions.videoFps + " , videoGop=" + customTranscodingOptions.videoGop + " , videoWidth=" + customTranscodingOptions.videoWidth + " , videoHeight=" + customTranscodingOptions.videoHeight + " , audioCodecType=" + customTranscodingOptions.audioCodecType + " , audioSample=" + customTranscodingOptions.audioSample + " , audioBitrate=" + customTranscodingOptions.audioBitrate + " , audioChannel=" + customTranscodingOptions.audioChannel + " , ", "");
            liveTranscoding.setTransCodingMode(0);
            liveTranscoding.setCustomTranscodingOptions(customTranscodingOptions);
            return liveTranscoding;
        }
        return null;
    }

    public void a(com.baidu.live.alablmsdk.c.b.e eVar) {
        if (this.aBD != null) {
            this.aBD.a(eVar);
        }
    }

    public void eD(String str) {
        if (this.aBD != null) {
            this.aBD.eD(str);
        }
    }

    private void e(long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.eF("yy-rtc onReceiveBusinessMessage ");
        if (this.aAq != null && !TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.azK = j;
            aVar.message = str;
            this.aAq.a(aVar);
        }
    }

    private void be(final boolean z) {
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRecvShutUpMessage: isMute: " + z);
                d.za().enableLocalAudioCapture(!z);
                if (e.this.aAq != null) {
                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                    cVar.azK = e.this.aAg;
                    if (z) {
                        e.this.aAq.d(cVar);
                    } else {
                        e.this.aAq.e(cVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(byte[] bArr, String str) {
        a fa = a.fa(new String(bArr));
        if (fa != null && fa.aBi >= 0) {
            com.baidu.live.alablmsdk.a.b.a.eF("yy-rtc processAppMessage: msg: " + new String(bArr) + " uid:" + str);
            if (fa.aBi == 1) {
                if (this.aAg != fa.aBk) {
                    com.baidu.live.alablmsdk.a.b.a.d("yy-rtc processAppMessage-shut up: msg.imuk != uid  " + fa.aBk + " | " + this.aAg);
                } else {
                    be(true);
                }
            } else if (fa.aBi == 2) {
                if (this.aAg != fa.aBk) {
                    com.baidu.live.alablmsdk.a.b.a.d("yy-rtc processAppMessage-dis shut up: msg.imuk != uid  " + fa.aBk + " | " + this.aAg);
                } else {
                    be(false);
                }
            } else if (fa.aBi == 0) {
                if (fa.aBk == 0 || (fa.aBk != 0 && fa.aBk == this.aAg)) {
                    e(fa.aBj, fa.content);
                }
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yr() {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc leave room", "");
        this.aBG.clear();
        d.za().enableLocalAudioCapture(false);
        d.za().leaveRoom();
        com.baidu.live.alablmsdk.a.b.c.xx().pushEnd();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ys() {
        yr();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        this.aBP.clear();
        this.aBG.clear();
        d.za().enableLocalAudioCapture(false);
        d.za().b(this.aBB);
        d.za().destroyEngine();
        this.aBD.zn();
        this.aAq = null;
    }
}
