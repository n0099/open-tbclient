package com.baidu.live.alablmsdk.d.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.alablmsdk.c.b.f;
import com.baidu.live.alablmsdk.c.b.g;
import com.baidu.live.alablmsdk.config.a;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.config.enums.BLMTransportAudioChannel;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class c implements g, BaiduRtcRoom.a, g.d {
    private boolean awT;
    private String axH;
    private String ayE;
    private String ayF;
    private long ayG;
    private com.baidu.live.alablmsdk.config.a aze;
    private volatile a azf;
    private volatile a azg;
    private boolean azi;
    private f azl;
    private boolean azr;
    private boolean azs;
    private String azv;
    private boolean azw;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings azc = RtcParameterSettings.aeQ();
    private boolean azd = false;
    private volatile boolean azh = false;
    private d azj = new d();
    private BLMRtcState azk = BLMRtcState.DEFAULT;
    private int azm = 1;
    private int azn = 5000;
    private boolean azo = false;
    private int azp = 0;
    private int azq = 0;
    private boolean azt = false;
    private boolean azu = false;
    private com.baidu.live.alablmsdk.c.a.a ayK = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.c.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            c.this.azj.o(bArr, i, i2);
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
        }
    };
    Runnable azx = new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.12
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.azr && c.this.awT) {
                c.this.eT("没有回调推流成功");
            }
        }
    };
    private Runnable azy = new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.axH, c.this.ayE, c.this.ayF, c.this.ayG);
        }
    };

    static /* synthetic */ int B(c cVar) {
        int i = cVar.azq;
        cVar.azq = i + 1;
        return i;
    }

    static /* synthetic */ int z(c cVar) {
        int i = cVar.azp;
        cVar.azp = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.eA("bd-rtc BdRtcRoom constructor ");
        this.azf = new a();
        this.azg = new a();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(f fVar) {
        this.azl = fVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String ym() {
        return this.axH;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yn() {
        return this.ayK;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void v(HashMap<String, Object> hashMap) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        if (hashMap != null) {
            if (hashMap.containsKey("is_auto_publish") && (obj10 = hashMap.get("is_auto_publish")) != null) {
                this.azc.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.AutoPublish " + this.azc.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.azc.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.AutoSubScribe " + this.azc.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.azc.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoMaxkbps " + this.azc.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.azc.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoMinkbps " + this.azc.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.azc.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.HasAudio  " + this.azc.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.azc.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.HasVideo  " + this.azc.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.azc.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoFps  " + this.azc.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.azc.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoWidth  " + this.azc.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.azc.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoHeight  " + this.azc.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.azd = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc isVideoExternalCapture  " + this.azd, "");
            }
            BLMTransportAudioChannel bLMTransportAudioChannel = (BLMTransportAudioChannel) com.baidu.live.alablmsdk.config.c.a(hashMap, "transport_audio_channel_key", null);
            if (bLMTransportAudioChannel != null) {
                this.azc.cvF = bLMTransportAudioChannel.getValue();
            }
            this.azc.cvr = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_max_kbps_key", Integer.valueOf(this.azc.cvr))).intValue();
            this.azc.cvt = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_source_key", Integer.valueOf(this.azc.cvt))).intValue();
            this.azc.cvq = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_codec_complex_key", Integer.valueOf(this.azc.cvq))).intValue();
            this.azc.cvs = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_playout_delay_key", Integer.valueOf(this.azc.cvs))).intValue();
            this.azc.cvv = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "disable_built_in_aec", Boolean.valueOf(this.azc.cvv))).booleanValue();
            this.azt = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "enable_ans_key", Boolean.valueOf(this.azt))).booleanValue();
            this.azu = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "enable_agc_key", Boolean.valueOf(this.azu))).booleanValue();
            this.azn = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "rtc_re_try_post_delay_time", 5000)).intValue();
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.enableAns(this.azt);
                this.mBaiduRtcRoom.enableAgc(this.azu);
            }
            this.azf.ayW = this.azc.AutoPublish;
            com.baidu.live.alablmsdk.a.b.c.xu().e(15, 15, this.azc.VideoMaxkbps, this.azc.VideoMinkbps, this.azc.AudioFrequency, this.azc.AudioChannel);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.azc.AutoPublish = ((Boolean) obj).booleanValue();
            this.azf.ayW = this.azc.AutoPublish;
            com.baidu.live.alablmsdk.a.b.a.ag(" bd rtc updateParamSetting cfg.AutoPublish=" + this.azc.AutoPublish, "");
            return 0;
        }
        return 0;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aze = aVar;
        yR();
    }

    private void yL() {
        if (this.aze != null && this.aze.axm != null && this.mBaiduRtcRoom != null) {
            String b2 = b(this.aze.axm);
            com.baidu.live.alablmsdk.a.b.a.ag(" configLiveServerWithUrl anchorMode: url=" + this.aze.axm.axr + " , enableMix=" + this.aze.axm.axs + " , IS_RECORD=false , template=" + b2, "");
            this.mBaiduRtcRoom.a(this.aze.axm.axr, this.aze.axm.axs, false, b2, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eB("anchor");
        }
    }

    private void yM() {
        if (this.aze != null && this.aze.axl != null && this.mBaiduRtcRoom != null) {
            String b2 = b(this.aze.axl);
            com.baidu.live.alablmsdk.a.b.a.ag(" configLiveServerWithUrl roomMode: url=" + this.aze.axl.axr + " , enableMix=" + this.aze.axl.axs + " , IS_RECORD=false , template=" + b2, "");
            this.mBaiduRtcRoom.a(this.aze.axl.axr, this.aze.axl.axs, false, b2, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eB(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    private void yN() {
        if (this.aze != null && this.aze.axm != null && this.mBaiduRtcRoom != null && this.azh) {
            String b2 = b(this.aze.axm);
            com.baidu.live.alablmsdk.a.b.a.ag(" startTransPushAnchor anchorMode: url=" + this.aze.axm.axr + " , enableMix=" + this.aze.axm.axs + " , IS_RECORD=false , template=" + b2, "");
            this.mBaiduRtcRoom.b(this.aze.axm.axr, this.aze.axm.axs, false, b2, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eB("anchor");
        }
    }

    private void yO() {
        if (this.aze != null && this.aze.axl != null && this.mBaiduRtcRoom != null && this.azh) {
            String b2 = b(this.aze.axl);
            com.baidu.live.alablmsdk.a.b.a.ag(" startTransPushRoom roomMode: url=" + this.aze.axl.axr + " , enableMix=" + this.aze.axl.axs + " , IS_RECORD=false , template=" + b2, "");
            this.mBaiduRtcRoom.b(this.aze.axl.axr, this.aze.axl.axs, false, b2, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eB(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    private void yP() {
        if (this.aze != null && this.aze.axm != null && this.mBaiduRtcRoom != null && this.azh) {
            com.baidu.live.alablmsdk.a.b.a.ag(" stopTransPushAnchor anchorMode: url=" + this.aze.axm.axr + " , enableMix=" + this.aze.axm.axs + " , IS_RECORD=false , template=" + b(this.aze.axm), "");
            this.mBaiduRtcRoom.a(BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eD("anchor");
        }
    }

    private void yQ() {
        if (this.aze != null && this.aze.axl != null && this.mBaiduRtcRoom != null && this.azh) {
            com.baidu.live.alablmsdk.a.b.a.ag(" stopLiveServerStreaming roomMode: url=" + this.aze.axl.axr + " , enableMix=" + this.aze.axl.axs + " , IS_RECORD=false , template=" + b(this.aze.axl), "");
            this.mBaiduRtcRoom.a(BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xu().eD(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aze != null) {
            int value = this.aze.axn.getValue();
            if ((bLMLiveTransferMode.getValue() & 1) != 0) {
                if (this.mBaiduRtcRoom != null && this.azh) {
                    yO();
                }
                value |= 1;
            }
            if ((bLMLiveTransferMode.getValue() & 2) != 0) {
                if (this.mBaiduRtcRoom != null && this.azh) {
                    yN();
                    value |= 2;
                }
                value |= 2;
            }
            this.aze.axn = ci(value);
            yR();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag(" bd-rtc stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        if (this.aze != null) {
            int value = this.aze.axn.getValue();
            if ((bLMLiveTransferMode.getValue() & 1) != 0) {
                if (this.mBaiduRtcRoom != null && this.azh) {
                    yQ();
                }
                value &= -2;
            }
            if ((bLMLiveTransferMode.getValue() & 2) != 0) {
                if (this.mBaiduRtcRoom != null && this.azh) {
                    yP();
                }
                value &= -3;
            }
            this.aze.axn = ci(value);
            yR();
        }
    }

    private BLMLiveTransferMode ci(int i) {
        if (i == 0) {
            return BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_NONE;
        }
        if (i == 1) {
            return BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM;
        }
        if (i == 2) {
            return BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR;
        }
        if (i == 3) {
            return BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR;
        }
        return BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_NONE;
    }

    private void yR() {
        if (this.aze != null && ((this.aze.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM && this.aze.axl != null && this.aze.axl.xM()) || ((this.aze.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR && this.aze.axm != null && this.aze.axm.xM()) || (this.aze.axn == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR && this.aze.axl != null && this.aze.axl.xM() && this.aze.axm != null && this.aze.axm.xM())))) {
            this.awT = true;
            this.azf.ayY = (this.aze.axn.getValue() & 1) != 0;
            this.azf.ayX = (this.aze.axn.getValue() & 2) != 0;
            com.baidu.live.alablmsdk.a.b.c.xu().bb(this.awT);
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransferStatus isNeedTransfer=" + this.awT, "");
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yi() {
        this.azf.ayW = true;
        if (this.azh) {
            if (this.mBaiduRtcRoom == null) {
                com.baidu.live.alablmsdk.a.b.a.ag(" publish stream erorr: baidu rtc room is null ", "");
                if (this.azl != null) {
                    this.azl.onError(1000, " publish stream, mBaiduRtcRoom is null");
                    return 1000;
                }
                return 1000;
            }
            this.mBaiduRtcRoom.publishStreaming();
            com.baidu.live.alablmsdk.a.b.c.xu().xx();
        }
        return 0;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xk() {
        this.azf.ayW = false;
        if (this.azh) {
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.stopPublish();
                com.baidu.live.alablmsdk.a.b.c.xu().xz();
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("stopPublishStream fail, mBaiduRtcRoom is null", "");
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ag(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ag(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ag(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void eN(String str) {
        this.azv = str;
    }

    public void c(String str, String str2, String str3, long j) {
        this.azm = 1;
        this.azk = BLMRtcState.DEFAULT;
        this.azo = false;
        this.azi = false;
        this.axH = str;
        this.ayE = str2;
        this.ayF = str3;
        this.ayG = j;
        j(false, 0L);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yl() {
        return this.awT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner, mRTCRoomState=" + c.this.azk, "");
                if (c.this.azk == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.azk = BLMRtcState.JOINING;
                    c.this.azg.ayW = c.this.azf.ayW;
                    c.this.azc.AutoPublish = c.this.azg.ayW;
                    c.this.azg.ayX = c.this.azf.ayX;
                    c.this.azg.ayY = c.this.azf.ayY;
                    String str4 = null;
                    if (c.this.aze != null) {
                        if (c.this.aze.axl != null) {
                            str4 = c.this.aze.axl.axr;
                        } else {
                            str4 = null;
                        }
                    }
                    com.baidu.live.alablmsdk.a.b.c.xu().setPushConfig(AlaRecorderLog.Protocol.RTC, str4);
                    com.baidu.live.alablmsdk.a.b.c.xu().xv();
                    if (c.this.azg.ayW) {
                        com.baidu.live.alablmsdk.a.b.c.xu().xx();
                    }
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.a.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.a.eA(" initWithAppID failed ");
                        c.this.ck(-1);
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.c xu = com.baidu.live.alablmsdk.a.b.c.xu();
                    BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                    xu.eH(BaiduRtcRoom.version());
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.ep(true);
                    } else {
                        BaiduRtcRoom unused3 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.ep(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.azc.VideoResolution = c.this.yT();
                    c.this.azc.ConnectionTimeoutMs = 5000;
                    c.this.azc.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.azc.AudioFrequency = 16000;
                        c.this.azc.AudioChannel = 2;
                        c.this.azc.AudioContentType = 2;
                    }
                    c.this.azc.cvy = true;
                    c.this.azc.cvx = true;
                    c.this.azc.cvG = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.azc, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    if (c.this.azt) {
                        c.this.mBaiduRtcRoom.enableAns(c.this.azt);
                    }
                    if (c.this.azu) {
                        c.this.mBaiduRtcRoom.enableAgc(c.this.azu);
                    }
                    c.this.yS();
                    if (c.this.azd) {
                        com.baidu.live.alablmsdk.a.b.a.ag(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.azj);
                    }
                    if (!TextUtils.isEmpty(c.this.azv)) {
                        c.this.mBaiduRtcRoom.ju(c.this.azv);
                        com.baidu.live.alablmsdk.a.b.a.ag(" set mix layout order " + c.this.azv, "");
                    }
                    c.this.mBaiduRtcRoom.f(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom.ep(true);
                    }
                    if (c.this.azi) {
                        com.baidu.live.alablmsdk.a.b.a.ag(" isReLogin yes", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ag(" isReLogin no", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    com.baidu.live.alablmsdk.a.b.a.eA(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.d(" muteMicphone isMute=" + c.this.isMute + " muteSpeaker isSpeakerMute =" + c.this.azs);
                    com.baidu.live.alablmsdk.a.b.a.eA(" muteMicphone isMute=" + c.this.isMute + " muteSpeaker isSpeakerMute =" + c.this.azs);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    c.this.mBaiduRtcRoom.aZ(c.this.azs);
                    if (c.this.azl != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.a.eA(" loginRtcRoomWithRoomName fail");
                        c.this.ck(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS() {
        if (this.awT && this.aze != null) {
            if (this.azg.ayX) {
                yL();
            }
            if (this.azg.ayY) {
                yM();
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" configTransServer isNeedTransfer=" + this.awT + " , mBLMLiveConfig=" + this.aze, "");
    }

    private String b(a.C0161a c0161a) {
        return (c0161a == null || TextUtils.isEmpty(c0161a.axx)) ? "" : c0161a.axx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yT() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(com.baidu.rtc.g gVar) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void az(long j) {
        com.baidu.live.alablmsdk.a.b.a.eA(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bO(j);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(String str, List<com.baidu.live.alablmsdk.module.c> list, boolean z) {
        if (!TextUtils.isEmpty(str) && com.baidu.live.alablmsdk.a.a.getCount(list) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a(str, list.get(i2), z);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(String str, com.baidu.live.alablmsdk.module.c cVar, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(ym()) && cVar != null) {
            d(cVar.ayk, z);
        }
    }

    private void d(long j, boolean z) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.d(j, z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aY(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.a.ag(" bd-rtc muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void aZ(boolean z) {
        this.azs = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.aZ(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yp() {
        com.baidu.live.alablmsdk.a.b.a.ag(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.yo();
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yo() {
        com.baidu.live.alablmsdk.a.b.a.ag(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.7
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.azy);
                c.this.yW();
                c.this.azk = BLMRtcState.LEAVE;
                c.this.azr = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.azw = false;
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.c.xu().pushEnd();
                com.baidu.live.alablmsdk.a.b.a.ag(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yU() {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.ag(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.a.eA(" onErrorInfoUpdate " + i);
        ck(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        cj(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, final long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.ez(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if (this.azl != null) {
            if (i == 100) {
                if (!this.awT) {
                    k(1, " bd rtc login success ");
                }
                this.azh = true;
                if (this.azf.ayW != this.azg.ayW) {
                    if (this.azf.ayW) {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change publishStreaming");
                        this.mBaiduRtcRoom.publishStreaming();
                        com.baidu.live.alablmsdk.a.b.c.xu().xx();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change stopPublish");
                        this.mBaiduRtcRoom.stopPublish();
                        com.baidu.live.alablmsdk.a.b.c.xu().xz();
                    }
                }
                if (this.azf.ayX != this.azg.ayX) {
                    if (this.azf.ayX) {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change startTransPushAnchor");
                        yN();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change stopTransPushAnchor");
                        yP();
                    }
                }
                if (this.azf.ayY != this.azg.ayY) {
                    if (this.azf.ayY) {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change startTransPushRoom");
                        yO();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eA(" config change stopTransPushRoom");
                        yQ();
                    }
                }
                this.azl.i(0, "bd rtc login success");
            } else if (i == 102 || i == 101) {
                this.azl.i(-1, "bd rtc login fail or time out , roomEvents=" + i + " extra_info =" + str);
            } else if (i == 300) {
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.ayk = j;
                this.azl.b(cVar);
            } else if (i == 303) {
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.ayk = j;
                com.baidu.live.alablmsdk.module.a.b eQ = com.baidu.live.alablmsdk.module.a.b.eQ(str);
                if (eQ != null && eQ.ayk == cVar2.ayk) {
                    cVar2.order = eQ.order;
                }
                this.azl.f(cVar2);
            } else if (i == 106) {
                com.baidu.live.alablmsdk.module.rtc.c cVar3 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar3.ayk = j;
                this.azl.c(cVar3);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.module.c cVar4 = new com.baidu.live.alablmsdk.module.c();
                cVar4.ayk = j;
                this.azl.g(cVar4);
            } else if (i == 107) {
                com.baidu.live.alablmsdk.module.rtc.c cVar5 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar5.ayk = j;
                this.azl.d(cVar5);
            } else if (i == 301) {
                com.baidu.live.alablmsdk.module.c cVar6 = new com.baidu.live.alablmsdk.module.c();
                cVar6.ayk = j;
                this.azl.c(cVar6);
            } else if (i == 302) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.ayk = j;
                aVar.message = str;
                this.azl.a(aVar);
            } else if (i == 113) {
                com.baidu.live.alablmsdk.module.c cVar7 = new com.baidu.live.alablmsdk.module.c();
                cVar7.ayk = j;
                this.azl.d(cVar7);
            } else if (i == 114) {
                com.baidu.live.alablmsdk.module.c cVar8 = new com.baidu.live.alablmsdk.module.c();
                cVar8.ayk = j;
                this.azl.e(cVar8);
            }
        }
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.f(i, j);
            }
        });
    }

    private void cj(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
            if (this.azl != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.ayk = this.ayG;
                this.azl.b(cVar);
            }
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.muteMicphone(this.isMute);
            }
            if (this.azl != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar2.ayk = this.ayG;
                this.azl.a(cVar2);
                com.baidu.live.alablmsdk.a.b.c.xu().xy();
            }
        } else if (i == 2003) {
            com.baidu.live.alablmsdk.a.b.a.ag("rtc onPeerConnectStateUpdate " + i, "");
            ck(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, long j) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.a.eA("rtc onRoomEventUpdate roomEvents " + i);
            if (i == 10000) {
                if (!this.azw) {
                    this.azw = true;
                    ck(i);
                    return;
                }
                return;
            }
            ck(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.a.eA("rtc onRoomEventUpdate roomEvents " + i);
            k(2, " bd rtc trans success");
            if (j == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                com.baidu.live.alablmsdk.a.b.c.xu().eC(UbcStatConstant.KEY_CONTENT_ROOM);
            }
            if (j == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION.ordinal()) {
                com.baidu.live.alablmsdk.a.b.c.xu().eC("anchor");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(final int i) {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.ag(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.azk + " , mIsRetrying=" + c.this.azo, "");
                if (c.this.azk != BLMRtcState.LEAVE) {
                    if (c.this.awT) {
                        if (c.this.azk == BLMRtcState.STREAM) {
                            c.this.azm = 2;
                        }
                        com.baidu.live.alablmsdk.a.b.c.xu().cb(i);
                    } else if (c.this.azk == BLMRtcState.JOINED) {
                        c.this.azm = 2;
                    }
                    if (!c.this.azr && i == 117) {
                        c.this.yW();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" mConnectType = " + c.this.azm);
                    com.baidu.live.alablmsdk.a.b.a.eA(" mConnectType " + c.this.azm);
                    if (c.this.azm == 1) {
                        c.this.j(true, c.this.azn);
                        return;
                    } else if (c.this.azm == 2) {
                        c.this.j(true, c.this.azn);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ag(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void k(final int i, final String str) {
        com.baidu.live.alablmsdk.a.b.a.ag(" rtcSuccess ", " , msg=" + str);
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.awT) {
                    if (!c.this.azr) {
                        c.this.azr = true;
                    }
                    c.this.azk = BLMRtcState.STREAM;
                    c.this.yW();
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtcSuccess , mRTCRoomState=" + c.this.azk, "");
                } else {
                    c.this.azk = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtcSuccess , mRTCRoomState=" + c.this.azk, "");
                }
                c.this.azp = 0;
                c.this.azq = 0;
                c.this.azo = false;
                c.this.azw = false;
                c.this.azm = 2;
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.azy);
                if (i == 2) {
                    c.this.eS(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV() {
        if (this.awT) {
            com.baidu.live.alablmsdk.a.c.xo().postDelayed(this.azx, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yW() {
        if (this.awT) {
            com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(this.azx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("rtc trans success. callback", "");
        if (this.azl != null) {
            this.azl.j(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.a.eA("rtc callback fail " + str);
        yW();
        if (this.azl != null) {
            this.azl.j(-1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yj() {
        com.baidu.live.alablmsdk.a.b.a.ag(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("mConnectType =" + c.this.azm + " mRTCRoomState = " + c.this.azk + " mIsRetrying " + c.this.azo);
                }
                if (c.this.azk != BLMRtcState.LEAVE) {
                    if (!c.this.azo) {
                        if (c.this.awT) {
                            if (c.this.azk == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.a.ag(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.azk == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.a.ag(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.azm != 1) {
                            if (c.this.azm == 2) {
                                c.B(c.this);
                                c.this.j(true, c.this.azn);
                                com.baidu.live.alablmsdk.a.b.a.ag(" re join rtc room fail. mRTCReTryCount " + c.this.azq, "");
                                return;
                            }
                            return;
                        }
                        c.z(c.this);
                        if (c.this.azp <= 2) {
                            c.this.j(true, c.this.azn);
                            com.baidu.live.alablmsdk.a.b.a.ag("init join rtc room mRTCInitRetryCount " + c.this.azp, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.a.ag("init join rtc room fail. callback", "");
                        c.this.eT(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ag(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.ag(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.module.rtc.d yk() {
        BaiduRtcRoom.c[] aew;
        com.baidu.live.alablmsdk.module.rtc.d dVar = new com.baidu.live.alablmsdk.module.rtc.d();
        if (this.mBaiduRtcRoom != null && (aew = this.mBaiduRtcRoom.aew()) != null) {
            for (BaiduRtcRoom.c cVar : aew) {
                if (cVar != null && cVar.userId == this.ayG) {
                    dVar.id = cVar.userId + "";
                    dVar.volume = cVar.volumeLevel / 327;
                }
            }
        }
        return dVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.ez(" sendMessage : msg=" + str);
        if (this.mBaiduRtcRoom != null) {
            long j = cVar != null ? cVar.ayk : 0L;
            com.baidu.live.alablmsdk.a.b.a.ez(" sendMessage : msg=" + str + " , id=" + j);
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.azm, "");
        if (j < this.azn) {
            j = this.azn;
        }
        if (z && !this.azo && this.azl != null && this.azm == 2) {
            this.azl.ch(2);
        }
        this.azo = z;
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.yV();
                    com.baidu.live.alablmsdk.a.c.xo().post(c.this.azy);
                    return;
                }
                c.this.azi = z;
                c.this.azo = true;
                c.this.azh = false;
                c.this.yU();
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.azy);
                com.baidu.live.alablmsdk.a.c.xo().postDelayed(c.this.azy, j);
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.a.eA(" BLMRtcRoom release ");
        this.azl = null;
        com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(this.azy);
        yW();
        com.baidu.live.alablmsdk.module.a eO = com.baidu.live.alablmsdk.module.b.yz().eO(this.axH);
        UserPermission userPermission = UserPermission.VISITER;
        if (eO != null) {
            userPermission = eO.yq();
        }
        if (userPermission == UserPermission.OWNER) {
            yp();
        } else {
            yo();
        }
    }
}
