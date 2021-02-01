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
/* loaded from: classes11.dex */
public class e implements com.baidu.live.alablmsdk.c.b.g {
    public static long aAf = 0;
    public static String mTaskId;
    private ThunderVideoFrameConsumer aAh;
    private com.baidu.live.alablmsdk.config.a aAi;
    private int aAj;
    private ThunderCustomVideoSource aAq;
    private boolean awT;
    private String axH;
    private long ayG;
    private com.baidu.live.alablmsdk.c.b.f ayQ;
    private boolean isMute;
    private Context mContext;
    private b aAe = new b();
    private Set<String> aAg = new HashSet();
    private boolean isStarted = false;
    private JSONObject aAk = new JSONObject();
    private boolean aAl = true;
    private boolean aAm = true;
    private boolean ayW = true;
    private boolean aAn = false;
    private boolean aAo = true;
    private Map<String, g> aAp = new HashMap();
    private com.baidu.live.alablmsdk.c.a.a ayK = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.b.e.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            if (e.this.isStarted && e.this.aAh != null) {
                long nanoTime = System.nanoTime() / TimeUtils.NANOS_PER_MS;
                ThunderExternalVideoFrame thunderExternalVideoFrame = new ThunderExternalVideoFrame();
                thunderExternalVideoFrame.data = bArr;
                thunderExternalVideoFrame.width = i;
                thunderExternalVideoFrame.height = i2;
                thunderExternalVideoFrame.scaleMode = 1;
                thunderExternalVideoFrame.timeStamp = nanoTime;
                thunderExternalVideoFrame.format = 2;
                thunderExternalVideoFrame.rotation = 0;
                e.this.aAh.consumeVideoFrame(thunderExternalVideoFrame);
            }
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
            com.baidu.live.alablmsdk.a.b.a.d(" InnerCapture error=" + i + " , errorMsg=" + str);
        }
    };
    private ThunderEventHandler aAb = new ThunderEventHandler() { // from class: com.baidu.live.alablmsdk.d.b.e.3
        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onError(int i) {
            super.onError(i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc error, code=" + i, "");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onJoinRoomSuccess(String str, String str2, int i) {
            super.onJoinRoomSuccess(str, str2, i);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onJoinRoomSuccess ", " room=" + str + " , uid=" + str2);
            e.this.zh();
            e.this.c(true, "yy-rtc join room success");
            com.baidu.live.alablmsdk.a.b.c.xu().xw();
            if (e.this.ayW) {
                int zb = e.this.aAm ? d.yX().zb() : 0;
                int zc = e.this.aAl ? d.yX().zc() : 0;
                if (e.this.isMute) {
                    d.yX().enableLocalAudioCapture(e.this.isMute ? false : true);
                }
                if (zb != 0) {
                    e.this.e(false, "yy-rtc push media fail");
                } else if (zc != 0) {
                    e.this.d(false, "yy-rtc push media fail");
                } else {
                    e.this.zi();
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
            if (e.this.aAl) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.ayk = Long.valueOf(str2).longValue();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.ayk = Long.valueOf(str2).longValue();
                if (z) {
                    if (e.this.ayQ != null) {
                        e.this.ayQ.b(cVar2);
                        e.this.ayQ.c(cVar);
                    }
                    if (!e.this.aAg.contains(str2) && e.this.eZ(str2)) {
                        com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoArrived: arrive=" + z + " , add " + str2);
                        e.this.aAg.add(str2);
                    }
                } else {
                    if (e.this.ayQ != null) {
                        e.this.ayQ.c(cVar2);
                        e.this.ayQ.d(cVar);
                    }
                    if (e.this.aAg.contains(str2)) {
                        com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoArrived: arrive=" + z + " , remove " + str2);
                        e.this.aAg.remove(str2);
                    }
                }
                if (e.this.aAi != null && e.this.yl()) {
                    LiveTranscoding a2 = e.this.a(false, e.this.aAi);
                    d.yX().setLiveTranscodingTask(e.mTaskId, a2);
                    CustomTranscodingOptions customTranscodingOptions = a2.getCustomTranscodingOptions();
                    com.baidu.live.alablmsdk.a.b.c.xu().e(customTranscodingOptions.videoFps, customTranscodingOptions.videoFps, customTranscodingOptions.videoBitrate + customTranscodingOptions.audioBitrate, customTranscodingOptions.videoBitrate + customTranscodingOptions.audioBitrate, customTranscodingOptions.audioSample, customTranscodingOptions.audioChannel);
                }
            }
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onRemoteAudioArrived(String str, String str2, boolean z) {
            super.onRemoteAudioArrived(str, str2, z);
            if (!e.this.aAl) {
                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onRemoteAudioArrived roomId " + str + " id " + str2 + " arrive " + z, "");
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.ayk = Long.valueOf(str2).longValue();
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.ayk = Long.valueOf(str2).longValue();
                if (z) {
                    if (e.this.ayQ != null) {
                        e.this.ayQ.b(cVar2);
                        e.this.ayQ.c(cVar);
                    }
                } else if (e.this.ayQ != null) {
                    e.this.ayQ.c(cVar2);
                    e.this.ayQ.d(cVar);
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
                        d.yX().eV(str);
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
            boolean z = d.yX().yY() || d.yX().yZ();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current stream status=" + i + " isPushStream " + z, " mCurrentUserConnected " + e.this.aAo);
            if (z) {
                if (i == 1) {
                    e.this.aAo = true;
                    if (e.this.ayQ != null) {
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current-stream-arrival callback", "");
                        e.this.ayQ.ch(1);
                        com.baidu.live.alablmsdk.a.b.c.xu().xA();
                    }
                } else if (e.this.aAo && i == 2) {
                    e.this.aAo = false;
                    if (e.this.ayQ != null) {
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc current-stream-leave callback", "");
                        e.this.ayQ.ch(2);
                        com.baidu.live.alablmsdk.a.b.c.xu().cb(0);
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
            String str2 = e.this.ayG + "";
            boolean z = !TextUtils.isEmpty(str2) && str2.equals(str);
            com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRemoteVideoStatsOfUid uid=" + str + " , isCurrentUser=" + z + " , receivedBitrate=" + i);
            if (!z) {
                if (e.this.aAl && remoteVideoStats != null) {
                    if (e.this.aAp.containsKey(str)) {
                        g gVar = (g) e.this.aAp.get(str);
                        if (remoteVideoStats.receivedBitrate > 0) {
                            if (gVar.status == 0) {
                                gVar.status = 1;
                                gVar.num = 0L;
                                e.this.aAp.put(str, gVar);
                                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc onRemoteVideoStatsOfUid arrive callback", "");
                                e.this.a(1, true, str);
                                return;
                            }
                            return;
                        }
                        gVar.status = 0;
                        gVar.num++;
                        e.this.aAp.put(str, gVar);
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
                    e.this.aAp.put(str, gVar2);
                    return;
                }
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc ronRemoteVideoStatsOfUid me return", "");
        }

        @Override // com.thunder.livesdk.ThunderEventHandler
        public void onCaptureVolumeIndication(int i, int i2, int i3) {
            super.onCaptureVolumeIndication(i, i2, i3);
            e.this.aAj = i3;
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
    Runnable aAr = new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.4
        @Override // java.lang.Runnable
        public void run() {
            e.this.c(false, "yy-rtc join room 20s no callback ");
        }
    };
    private f aAd = new f();

    public e(Context context) {
        this.mContext = context;
        mTaskId = com.baidu.live.alablmsdk.a.c.a.cd(10);
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc taskId " + mTaskId, "");
        a((com.baidu.live.alablmsdk.c.b.a) null);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.c.b.f fVar) {
        this.ayQ = fVar;
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
            this.aAe.y((HashMap) hashMap.get("yy_rtc_private_params_key"));
        }
        if (TextUtils.isEmpty(this.aAe.mAppId)) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc app id is empty", "");
            return;
        }
        if (hashMap.containsKey("has_video") && (obj3 = hashMap.get("has_video")) != null) {
            this.aAl = ((Boolean) obj3).booleanValue();
        }
        if (hashMap.containsKey("has_audio") && (obj2 = hashMap.get("has_audio")) != null) {
            this.aAm = ((Boolean) obj2).booleanValue();
        }
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.ayW = ((Boolean) obj).booleanValue();
        }
        if (!this.aAn) {
            this.aAn = true;
            a((com.baidu.live.alablmsdk.c.b.a) null);
        }
        d.yX().a(this.mContext, this.aAe.mAppId, aAf, d.yX().zf());
        d.yX().a(this.aAb);
        com.baidu.live.alablmsdk.a.b.c.xu().eH(d.yX().getVersion());
        if (this.aAl) {
            this.aAq = new ThunderCustomVideoSource() { // from class: com.baidu.live.alablmsdk.d.b.e.5
                @Override // com.thunder.livesdk.ThunderCustomVideoSource
                public boolean onInitialize(ThunderVideoFrameConsumer thunderVideoFrameConsumer) {
                    e.this.aAh = thunderVideoFrameConsumer;
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
            d.yX().a(this.aAq);
            ThunderVideoEncoderConfiguration thunderVideoEncoderConfiguration = new ThunderVideoEncoderConfiguration();
            if (this.aAe.azQ != -1) {
                thunderVideoEncoderConfiguration.publishMode = this.aAe.azQ;
                com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc configuration.publishMode  " + thunderVideoEncoderConfiguration.publishMode, "");
            }
            thunderVideoEncoderConfiguration.playType = this.aAe.mPlayType;
            d.yX().setVideoEncoderConfig(thunderVideoEncoderConfiguration);
        }
        d.yX().setMediaMode(this.aAe.azM);
        d.yX().setRoomMode(this.aAe.azL);
        d.yX().setAudioConfig(this.aAe.azN, this.aAe.azO, this.aAe.azP);
        if (this.aAe.azR != -1) {
            d.yX().setSoundEffect(this.aAe.azR);
        }
        d.yX().za();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.ayW = ((Boolean) obj).booleanValue();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc yy rtc updateParamSetting  isAutoPublish=" + this.ayW, "");
            return 0;
        }
        return 0;
    }

    public void d(View view, String str) {
        d.yX().d(view, str);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aAi = aVar;
        if (aVar != null && ((aVar.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM && aVar.axl != null && aVar.axl.xM()) || ((aVar.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR && aVar.axm != null && aVar.axm.xM()) || (aVar.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR && aVar.axl != null && aVar.axl.xM() && aVar.axm != null && aVar.axm.xM())))) {
            this.awT = true;
            com.baidu.live.alablmsdk.a.b.c.xu().bb(this.awT);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc parseLiveStream isNeedTransfer=" + this.awT, "");
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aAi != null && this.aAi.axl != null && this.aAi.axl.xM()) {
            this.awT = true;
            com.baidu.live.alablmsdk.a.b.c.xu().bb(this.awT);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc startLiveServerStreaming transferMode=" + bLMLiveTransferMode, "");
        zi();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aAi != null && this.aAi.axl != null && this.aAi.axl.xM()) {
            this.awT = false;
            com.baidu.live.alablmsdk.a.b.c.xu().bb(this.awT);
        }
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stopLiveServerStreaming transferMode=" + bLMLiveTransferMode, "");
        zj();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yi() {
        int i;
        int i2;
        if (this.aAm) {
            i = d.yX().zb();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc publishStream push audio result=" + i, "");
        } else {
            i = 0;
        }
        if (this.aAl) {
            i2 = d.yX().zc();
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc publishStream push video result=" + i2, "");
        } else {
            i2 = 0;
        }
        com.baidu.live.alablmsdk.a.b.c.xu().xx();
        return (i == 0 && i2 == 0) ? 0 : -1;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xk() {
        if (this.aAm) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stop publishStream push audio result=" + d.yX().zd(), "");
        }
        if (this.aAl) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc stop publishStream push video result=" + d.yX().ze(), "");
        }
        com.baidu.live.alablmsdk.a.b.c.xu().xz();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void eN(String str) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aY(final boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc muteSpeaker: mute" + z, "");
        this.isMute = z;
        d.yX().setMicVolume(z ? 0 : 100);
        com.baidu.live.alablmsdk.a.c.xo().postDelayed(new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                d.yX().enableLocalAudioCapture(!z);
            }
        }, 400L);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aZ(boolean z) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc muteSpeaker: mute" + z + " , isOutSpeaker=" + d.yX().isLoudspeakerEnabled(), "");
        if (z) {
            d.yX().setLoudSpeakerVolume(0);
        } else {
            d.yX().setLoudSpeakerVolume(100);
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
                        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc shutUpUserWithId id " + cVar.ayk + " result " + d.yX().sendUserAppMsgData(a.b(this.ayG, cVar.ayk, z)), "");
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yj() {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.module.rtc.d yk() {
        com.baidu.live.alablmsdk.module.rtc.d dVar = new com.baidu.live.alablmsdk.module.rtc.d();
        dVar.volume = this.aAj;
        dVar.id = this.axH;
        return dVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.yX().sendUserAppMsgData(a.a(this.ayG, cVar != null ? cVar.ayk : 0L, str));
        return true;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yl() {
        return this.awT;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String ym() {
        return this.axH;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yn() {
        return this.ayK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.alablmsdk.c.b.a aVar) {
        if (this.aAd != null) {
            this.aAd.setAppId(this.aAe.mAppId);
            if (this.ayG == 0) {
                if (this.ayQ != null) {
                    this.ayQ.a(new com.baidu.live.alablmsdk.c.b.b() { // from class: com.baidu.live.alablmsdk.d.b.e.7
                        @Override // com.baidu.live.alablmsdk.c.b.b
                        public void ax(long j) {
                            e.this.ayG = j;
                            e.this.aAd.fa(e.this.ayG + "");
                            e.this.aAd.b(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.7.1
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
            this.aAd.fa(this.ayG + "");
            this.aAd.b(new com.baidu.live.alablmsdk.c.b.a() { // from class: com.baidu.live.alablmsdk.d.b.e.8
                @Override // com.baidu.live.alablmsdk.c.b.a
                public void ai(String str, String str2) {
                    if (aVar != null) {
                        aVar.ai(str, str2);
                    }
                }
            });
        }
    }

    public void eY(final String str) {
        if (this.aAd != null) {
            String token = this.aAd.getToken();
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
        if (this.ayG != 0) {
            c(str, str2, this.ayG);
        } else if (this.ayQ != null) {
            this.ayQ.a(new com.baidu.live.alablmsdk.c.b.b() { // from class: com.baidu.live.alablmsdk.d.b.e.10
                @Override // com.baidu.live.alablmsdk.c.b.b
                public void ax(long j) {
                    e.this.ayG = j;
                    e.this.c(str, str2, e.this.ayG);
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
        this.axH = str;
        this.ayG = j;
        if (this.aAi != null && this.aAi.axl != null) {
            str3 = this.aAi.axl.axr;
        }
        com.baidu.live.alablmsdk.a.b.c.xu().setPushConfig(AlaRecorderLog.Protocol.RTC, str3);
        com.baidu.live.alablmsdk.a.b.c.xu().xv();
        zg();
        if (d.yX().joinRoom(str2.getBytes(), str, j + "") != 0) {
            c(false, "yy-rtc join rtc room error");
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void az(long j) {
    }

    private void zg() {
        com.baidu.live.alablmsdk.a.c.xo().postDelayed(this.aAr, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(this.aAr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str) {
        if (this.ayQ != null) {
            if (z) {
                this.ayQ.i(0, str);
            } else {
                this.ayQ.i(-1, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        if (this.ayQ != null) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.ayk = this.ayG;
            cVar.ayI = str;
            if (z) {
                this.ayQ.a(cVar);
                com.baidu.live.alablmsdk.a.b.c.xu().xy();
                return;
            }
            this.ayQ.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        if (this.ayQ != null && !this.aAl) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.ayk = this.ayG;
            cVar.ayI = str;
            if (z) {
                this.ayQ.a(cVar);
            } else {
                this.ayQ.b(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        if (this.ayQ != null) {
            if (z) {
                this.ayQ.j(0, str);
                com.baidu.live.alablmsdk.a.b.c.xu().eC("anchor");
                return;
            }
            this.ayQ.j(-1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc remote stream change callback: streamType=" + i + " isArrive=" + z + " id=" + str, "");
        if (this.ayQ != null) {
            com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
            cVar.ayk = Long.valueOf(str).longValue();
            if (z) {
                this.ayQ.c(cVar);
            } else {
                this.ayQ.d(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eZ(String str) {
        if (TextUtils.isEmpty(str) || this.ayQ == null) {
            return false;
        }
        List<com.baidu.live.alablmsdk.module.c> yd = this.ayQ.yd();
        if (com.baidu.live.alablmsdk.a.a.isEmpty(yd)) {
            return false;
        }
        for (int i = 0; i < yd.size(); i++) {
            com.baidu.live.alablmsdk.module.c cVar = yd.get(i);
            if (cVar != null && cVar.ayk != 0 && str.equals(cVar.ayk + "")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        if (this.aAi != null && this.aAi.axm != null && !TextUtils.isEmpty(this.aAi.axm.axr) && yl()) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc TranscodingStreamUrl=" + this.aAi.axm.axr, "");
            int liveTranscodingTask = d.yX().setLiveTranscodingTask(mTaskId, a(true, this.aAi));
            int addPublishTranscodingStreamUrl = d.yX().addPublishTranscodingStreamUrl(mTaskId, this.aAi.axm.axr);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc addPublishTranscodingStreamUrl: setTransTaskResult=" + liveTranscodingTask + " ,addTransUrlResult=" + addPublishTranscodingStreamUrl, "");
            if (liveTranscodingTask != 0 || addPublishTranscodingStreamUrl != 0) {
                f(false, " yy rtc trans media fail");
            }
            com.baidu.live.alablmsdk.a.b.c.xu().eB("anchor");
        }
    }

    private void zj() {
        if (this.aAi != null && this.aAi.axm != null && yl()) {
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc TranscodingStreamUrl=" + this.aAi.axm.axr, "");
            int removeLiveTranscodingTask = d.yX().removeLiveTranscodingTask(mTaskId);
            int removePublishTranscodingStreamUrl = d.yX().removePublishTranscodingStreamUrl(mTaskId, this.aAi.axm.axr);
            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc addPublishTranscodingStreamUrl: removeTransTaskResult=" + removeLiveTranscodingTask + " ,removeTransUrlResult=" + removePublishTranscodingStreamUrl, "");
            if (removeLiveTranscodingTask != 0 || removePublishTranscodingStreamUrl != 0) {
                f(false, "yy-rtc trans media fail");
            }
            com.baidu.live.alablmsdk.a.b.c.xu().eD("anchor");
        }
    }

    public LiveTranscoding a(boolean z, com.baidu.live.alablmsdk.config.a aVar) {
        a.C0161a c0161a;
        int i;
        int i2;
        if (aVar != null && (c0161a = aVar.axm) != null) {
            LiveTranscoding liveTranscoding = new LiveTranscoding();
            CustomTranscodingOptions customTranscodingOptions = new CustomTranscodingOptions();
            if (this.aAl) {
                if (c0161a.axo == null) {
                    i = 960;
                    i2 = 544;
                } else {
                    int width = c0161a.axo.getWidth();
                    i = c0161a.axo.getHeight();
                    i2 = width;
                }
                if (this.ayG != 0) {
                    LiveTranscoding.TranscodingUser transcodingUser = new LiveTranscoding.TranscodingUser();
                    com.baidu.live.alablmsdk.config.a.d dVar = null;
                    com.baidu.live.alablmsdk.config.a.a aVar2 = null;
                    if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0161a.axu) && (aVar2 = c0161a.axu.get(0)) != null) {
                        dVar = aVar.b(c0161a.axo, c0161a.axt, aVar2.axE);
                    }
                    transcodingUser.roomId = this.axH;
                    transcodingUser.uid = this.ayG + "";
                    transcodingUser.layoutX = dVar != null ? dVar.x : 0;
                    transcodingUser.layoutY = dVar != null ? dVar.y : 0;
                    transcodingUser.layoutW = dVar != null ? dVar.width : i2;
                    transcodingUser.layoutH = dVar != null ? dVar.height : i;
                    transcodingUser.zOrder = aVar2 != null ? aVar2.axD : 0;
                    transcodingUser.bCrop = true;
                    transcodingUser.layoutShape = 0;
                    liveTranscoding.addUser(transcodingUser);
                    com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc LiveTranscoding: add myself=" + transcodingUser.toString(), "");
                }
                if (this.aAg != null && !this.aAg.isEmpty()) {
                    Iterator<String> it = this.aAg.iterator();
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            LiveTranscoding.TranscodingUser transcodingUser2 = new LiveTranscoding.TranscodingUser();
                            com.baidu.live.alablmsdk.config.a.d dVar2 = null;
                            com.baidu.live.alablmsdk.config.a.a aVar3 = null;
                            if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0161a.axu) && (aVar3 = c0161a.axu.get(1)) != null) {
                                dVar2 = aVar.b(c0161a.axo, c0161a.axt, aVar3.axE);
                            }
                            transcodingUser2.roomId = this.axH;
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
                            transcodingUser2.zOrder = aVar3 != null ? aVar3.axD : 0;
                            transcodingUser2.bCrop = true;
                            transcodingUser2.layoutShape = 0;
                            com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc LiveTranscoding: add other=" + transcodingUser2.toString(), "");
                            liveTranscoding.addUser(transcodingUser2);
                        }
                    }
                }
                customTranscodingOptions.videoCodecType = 2;
                customTranscodingOptions.videoBitrate = c0161a.axq;
                customTranscodingOptions.videoFps = c0161a.fps;
                customTranscodingOptions.videoGop = c0161a.fps * 4;
                if (c0161a.axo != null) {
                    customTranscodingOptions.videoWidth = c0161a.axo.getWidth();
                    customTranscodingOptions.videoHeight = c0161a.axo.getHeight();
                } else {
                    customTranscodingOptions.videoWidth = VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH;
                    customTranscodingOptions.videoHeight = 960;
                }
                liveTranscoding.setTransCodingStreamType(0);
            } else {
                if (z) {
                    LiveTranscoding.TranscodingUser transcodingUser3 = new LiveTranscoding.TranscodingUser();
                    transcodingUser3.roomId = this.axH;
                    transcodingUser3.uid = this.ayG + "";
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
            customTranscodingOptions.audioSample = c0161a.axp.getSampleRate();
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
        if (this.aAd != null) {
            this.aAd.a(eVar);
        }
    }

    public void ew(String str) {
        if (this.aAd != null) {
            this.aAd.ew(str);
        }
    }

    private void e(long j, String str) {
        com.baidu.live.alablmsdk.a.b.a.ez("yy-rtc onReceiveBusinessMessage ");
        if (this.ayQ != null && !TextUtils.isEmpty(str)) {
            com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
            aVar.ayk = j;
            aVar.message = str;
            this.ayQ.a(aVar);
        }
    }

    private void be(final boolean z) {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.d("yy-rtc onRecvShutUpMessage: isMute: " + z);
                d.yX().enableLocalAudioCapture(!z);
                if (e.this.ayQ != null) {
                    com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                    cVar.ayk = e.this.ayG;
                    if (z) {
                        e.this.ayQ.d(cVar);
                    } else {
                        e.this.ayQ.e(cVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(byte[] bArr, String str) {
        a eU = a.eU(new String(bArr));
        if (eU != null && eU.azI >= 0) {
            com.baidu.live.alablmsdk.a.b.a.ez("yy-rtc processAppMessage: msg: " + new String(bArr) + " uid:" + str);
            if (eU.azI == 1) {
                if (this.ayG != eU.azK) {
                    com.baidu.live.alablmsdk.a.b.a.d("yy-rtc processAppMessage-shut up: msg.imuk != uid  " + eU.azK + " | " + this.ayG);
                } else {
                    be(true);
                }
            } else if (eU.azI == 2) {
                if (this.ayG != eU.azK) {
                    com.baidu.live.alablmsdk.a.b.a.d("yy-rtc processAppMessage-dis shut up: msg.imuk != uid  " + eU.azK + " | " + this.ayG);
                } else {
                    be(false);
                }
            } else if (eU.azI == 0) {
                if (eU.azK == 0 || (eU.azK != 0 && eU.azK == this.ayG)) {
                    e(eU.azJ, eU.content);
                }
            }
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yo() {
        com.baidu.live.alablmsdk.a.b.a.ag("yy-rtc leave room", "");
        this.aAg.clear();
        d.yX().enableLocalAudioCapture(false);
        d.yX().leaveRoom();
        com.baidu.live.alablmsdk.a.b.c.xu().pushEnd();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yp() {
        yo();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        this.aAp.clear();
        this.aAg.clear();
        d.yX().enableLocalAudioCapture(false);
        d.yX().b(this.aAb);
        d.yX().destroyEngine();
        this.aAd.zk();
        this.ayQ = null;
    }
}
