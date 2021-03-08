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
/* loaded from: classes10.dex */
public class c implements g, BaiduRtcRoom.a, g.d {
    private com.baidu.live.alablmsdk.config.a aAE;
    private volatile a aAF;
    private volatile a aAG;
    private boolean aAI;
    private f aAL;
    private boolean aAR;
    private boolean aAS;
    private String aAV;
    private boolean aAW;
    private String aAe;
    private String aAf;
    private long aAg;
    private boolean ayt;
    private String azh;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aAC = RtcParameterSettings.aeT();
    private boolean aAD = false;
    private volatile boolean aAH = false;
    private d aAJ = new d();
    private BLMRtcState aAK = BLMRtcState.DEFAULT;
    private int aAM = 1;
    private int aAN = 5000;
    private boolean aAO = false;
    private int aAP = 0;
    private int aAQ = 0;
    private boolean aAT = false;
    private boolean aAU = false;
    private com.baidu.live.alablmsdk.c.a.a aAk = new com.baidu.live.alablmsdk.c.a.a() { // from class: com.baidu.live.alablmsdk.d.a.c.1
        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onPixelRead(byte[] bArr, int i, int i2) {
            c.this.aAJ.o(bArr, i, i2);
        }

        @Override // com.baidu.live.alablmsdk.c.a.a
        public void onError(int i, String str) {
        }
    };
    Runnable aAX = new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.12
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aAR && c.this.ayt) {
                c.this.eZ("没有回调推流成功");
            }
        }
    };
    private Runnable aAY = new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.azh, c.this.aAe, c.this.aAf, c.this.aAg);
        }
    };

    static /* synthetic */ int B(c cVar) {
        int i = cVar.aAQ;
        cVar.aAQ = i + 1;
        return i;
    }

    static /* synthetic */ int z(c cVar) {
        int i = cVar.aAP;
        cVar.aAP = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
        com.baidu.live.alablmsdk.a.b.a.eG("bd-rtc BdRtcRoom constructor ");
        this.aAF = new a();
        this.aAG = new a();
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(f fVar) {
        this.aAL = fVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public String yp() {
        return this.azh;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public com.baidu.live.alablmsdk.c.a.a yq() {
        return this.aAk;
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
                this.aAC.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.AutoPublish " + this.aAC.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aAC.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.AutoSubScribe " + this.aAC.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aAC.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoMaxkbps " + this.aAC.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aAC.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoMinkbps " + this.aAC.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aAC.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.HasAudio  " + this.aAC.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aAC.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.HasVideo  " + this.aAC.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aAC.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoFps  " + this.aAC.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aAC.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoWidth  " + this.aAC.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aAC.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc cfg.VideoHeight  " + this.aAC.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aAD = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ag("bd-rtc isVideoExternalCapture  " + this.aAD, "");
            }
            BLMTransportAudioChannel bLMTransportAudioChannel = (BLMTransportAudioChannel) com.baidu.live.alablmsdk.config.c.a(hashMap, "transport_audio_channel_key", null);
            if (bLMTransportAudioChannel != null) {
                this.aAC.cxf = bLMTransportAudioChannel.getValue();
            }
            this.aAC.cwR = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_max_kbps_key", Integer.valueOf(this.aAC.cwR))).intValue();
            this.aAC.cwT = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_source_key", Integer.valueOf(this.aAC.cwT))).intValue();
            this.aAC.cwQ = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_codec_complex_key", Integer.valueOf(this.aAC.cwQ))).intValue();
            this.aAC.cwS = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "audio_playout_delay_key", Integer.valueOf(this.aAC.cwS))).intValue();
            this.aAC.cwV = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "disable_built_in_aec", Boolean.valueOf(this.aAC.cwV))).booleanValue();
            this.aAT = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "enable_ans_key", Boolean.valueOf(this.aAT))).booleanValue();
            this.aAU = ((Boolean) com.baidu.live.alablmsdk.config.c.a(hashMap, "enable_agc_key", Boolean.valueOf(this.aAU))).booleanValue();
            this.aAN = ((Integer) com.baidu.live.alablmsdk.config.c.a(hashMap, "rtc_re_try_post_delay_time", 5000)).intValue();
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.enableAns(this.aAT);
                this.mBaiduRtcRoom.enableAgc(this.aAU);
            }
            this.aAF.aAw = this.aAC.AutoPublish;
            com.baidu.live.alablmsdk.a.b.c.xx().e(15, 15, this.aAC.VideoMaxkbps, this.aAC.VideoMinkbps, this.aAC.AudioFrequency, this.aAC.AudioChannel);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int w(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap.containsKey("is_auto_publish") && (obj = hashMap.get("is_auto_publish")) != null) {
            this.aAC.AutoPublish = ((Boolean) obj).booleanValue();
            this.aAF.aAw = this.aAC.AutoPublish;
            com.baidu.live.alablmsdk.a.b.a.ag(" bd rtc updateParamSetting cfg.AutoPublish=" + this.aAC.AutoPublish, "");
            return 0;
        }
        return 0;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aAE = aVar;
        yU();
    }

    private void yO() {
        if (this.aAE != null && this.aAE.ayM != null && this.mBaiduRtcRoom != null) {
            String b = b(this.aAE.ayM);
            com.baidu.live.alablmsdk.a.b.a.ag(" configLiveServerWithUrl anchorMode: url=" + this.aAE.ayM.ayR + " , enableMix=" + this.aAE.ayM.ayS + " , IS_RECORD=false , template=" + b, "");
            this.mBaiduRtcRoom.a(this.aAE.ayM.ayR, this.aAE.ayM.ayS, false, b, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eH("anchor");
        }
    }

    private void yP() {
        if (this.aAE != null && this.aAE.ayL != null && this.mBaiduRtcRoom != null) {
            String b = b(this.aAE.ayL);
            com.baidu.live.alablmsdk.a.b.a.ag(" configLiveServerWithUrl roomMode: url=" + this.aAE.ayL.ayR + " , enableMix=" + this.aAE.ayL.ayS + " , IS_RECORD=false , template=" + b, "");
            this.mBaiduRtcRoom.a(this.aAE.ayL.ayR, this.aAE.ayL.ayS, false, b, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eH(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    private void yQ() {
        if (this.aAE != null && this.aAE.ayM != null && this.mBaiduRtcRoom != null && this.aAH) {
            String b = b(this.aAE.ayM);
            com.baidu.live.alablmsdk.a.b.a.ag(" startTransPushAnchor anchorMode: url=" + this.aAE.ayM.ayR + " , enableMix=" + this.aAE.ayM.ayS + " , IS_RECORD=false , template=" + b, "");
            this.mBaiduRtcRoom.b(this.aAE.ayM.ayR, this.aAE.ayM.ayS, false, b, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eH("anchor");
        }
    }

    private void yR() {
        if (this.aAE != null && this.aAE.ayL != null && this.mBaiduRtcRoom != null && this.aAH) {
            String b = b(this.aAE.ayL);
            com.baidu.live.alablmsdk.a.b.a.ag(" startTransPushRoom roomMode: url=" + this.aAE.ayL.ayR + " , enableMix=" + this.aAE.ayL.ayS + " , IS_RECORD=false , template=" + b, "");
            this.mBaiduRtcRoom.b(this.aAE.ayL.ayR, this.aAE.ayL.ayS, false, b, BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eH(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    private void yS() {
        if (this.aAE != null && this.aAE.ayM != null && this.mBaiduRtcRoom != null && this.aAH) {
            com.baidu.live.alablmsdk.a.b.a.ag(" stopTransPushAnchor anchorMode: url=" + this.aAE.ayM.ayR + " , enableMix=" + this.aAE.ayM.ayS + " , IS_RECORD=false , template=" + b(this.aAE.ayM), "");
            this.mBaiduRtcRoom.a(BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eJ("anchor");
        }
    }

    private void yT() {
        if (this.aAE != null && this.aAE.ayL != null && this.mBaiduRtcRoom != null && this.aAH) {
            com.baidu.live.alablmsdk.a.b.a.ag(" stopLiveServerStreaming roomMode: url=" + this.aAE.ayL.ayR + " , enableMix=" + this.aAE.ayL.ayS + " , IS_RECORD=false , template=" + b(this.aAE.ayL), "");
            this.mBaiduRtcRoom.a(BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION);
            com.baidu.live.alablmsdk.a.b.c.xx().eJ(UbcStatConstant.KEY_CONTENT_ROOM);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void a(BLMLiveTransferMode bLMLiveTransferMode) {
        if (this.aAE != null) {
            int value = this.aAE.ayN.getValue();
            if ((bLMLiveTransferMode.getValue() & 1) != 0) {
                if (this.mBaiduRtcRoom != null && this.aAH) {
                    yR();
                }
                value |= 1;
            }
            if ((bLMLiveTransferMode.getValue() & 2) != 0) {
                if (this.mBaiduRtcRoom != null && this.aAH) {
                    yQ();
                    value |= 2;
                }
                value |= 2;
            }
            this.aAE.ayN = cj(value);
            yU();
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void b(BLMLiveTransferMode bLMLiveTransferMode) {
        com.baidu.live.alablmsdk.a.b.a.ag(" bd-rtc stopLiveServerStreaming mode " + bLMLiveTransferMode, "");
        if (this.aAE != null) {
            int value = this.aAE.ayN.getValue();
            if ((bLMLiveTransferMode.getValue() & 1) != 0) {
                if (this.mBaiduRtcRoom != null && this.aAH) {
                    yT();
                }
                value &= -2;
            }
            if ((bLMLiveTransferMode.getValue() & 2) != 0) {
                if (this.mBaiduRtcRoom != null && this.aAH) {
                    yS();
                }
                value &= -3;
            }
            this.aAE.ayN = cj(value);
            yU();
        }
    }

    private BLMLiveTransferMode cj(int i) {
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

    private void yU() {
        if (this.aAE != null && ((this.aAE.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM && this.aAE.ayL != null && this.aAE.ayL.xP()) || ((this.aAE.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR && this.aAE.ayM != null && this.aAE.ayM.xP()) || (this.aAE.ayN == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM_AND_ANCHOR && this.aAE.ayL != null && this.aAE.ayL.xP() && this.aAE.ayM != null && this.aAE.ayM.xP())))) {
            this.ayt = true;
            this.aAF.aAy = (this.aAE.ayN.getValue() & 1) != 0;
            this.aAF.aAx = (this.aAE.ayN.getValue() & 2) != 0;
            com.baidu.live.alablmsdk.a.b.c.xx().bb(this.ayt);
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransferStatus isNeedTransfer=" + this.ayt, "");
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public int yl() {
        this.aAF.aAw = true;
        if (this.aAH) {
            if (this.mBaiduRtcRoom == null) {
                com.baidu.live.alablmsdk.a.b.a.ag(" publish stream erorr: baidu rtc room is null ", "");
                if (this.aAL != null) {
                    this.aAL.onError(1000, " publish stream, mBaiduRtcRoom is null");
                    return 1000;
                }
                return 1000;
            }
            this.mBaiduRtcRoom.publishStreaming();
            com.baidu.live.alablmsdk.a.b.c.xx().xA();
        }
        return 0;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void xn() {
        this.aAF.aAw = false;
        if (this.aAH) {
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.stopPublish();
                com.baidu.live.alablmsdk.a.b.c.xx().xC();
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
    public void eT(String str) {
        this.aAV = str;
    }

    public void c(String str, String str2, String str3, long j) {
        this.aAM = 1;
        this.aAK = BLMRtcState.DEFAULT;
        this.aAO = false;
        this.aAI = false;
        this.azh = str;
        this.aAe = str2;
        this.aAf = str3;
        this.aAg = j;
        k(false, 0L);
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean yo() {
        return this.ayt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner, mRTCRoomState=" + c.this.aAK, "");
                if (c.this.aAK == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.a.ag("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.aAK = BLMRtcState.JOINING;
                    c.this.aAG.aAw = c.this.aAF.aAw;
                    c.this.aAC.AutoPublish = c.this.aAG.aAw;
                    c.this.aAG.aAx = c.this.aAF.aAx;
                    c.this.aAG.aAy = c.this.aAF.aAy;
                    String str4 = null;
                    if (c.this.aAE != null) {
                        if (c.this.aAE.ayL != null) {
                            str4 = c.this.aAE.ayL.ayR;
                        } else {
                            str4 = null;
                        }
                    }
                    com.baidu.live.alablmsdk.a.b.c.xx().setPushConfig(AlaRecorderLog.Protocol.RTC, str4);
                    com.baidu.live.alablmsdk.a.b.c.xx().xy();
                    if (c.this.aAG.aAw) {
                        com.baidu.live.alablmsdk.a.b.c.xx().xA();
                    }
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.a.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.a.eG(" initWithAppID failed ");
                        c.this.cl(-1);
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.c xx = com.baidu.live.alablmsdk.a.b.c.xx();
                    BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                    xx.eN(BaiduRtcRoom.version());
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.ep(true);
                    } else {
                        BaiduRtcRoom unused3 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.ep(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.aAC.VideoResolution = c.this.yW();
                    c.this.aAC.ConnectionTimeoutMs = 5000;
                    c.this.aAC.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.aAC.AudioFrequency = 16000;
                        c.this.aAC.AudioChannel = 2;
                        c.this.aAC.AudioContentType = 2;
                    }
                    c.this.aAC.cwY = true;
                    c.this.aAC.cwX = true;
                    c.this.aAC.cxg = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.aAC, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    if (c.this.aAT) {
                        c.this.mBaiduRtcRoom.enableAns(c.this.aAT);
                    }
                    if (c.this.aAU) {
                        c.this.mBaiduRtcRoom.enableAgc(c.this.aAU);
                    }
                    c.this.yV();
                    if (c.this.aAD) {
                        com.baidu.live.alablmsdk.a.b.a.ag(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.aAJ);
                    }
                    if (!TextUtils.isEmpty(c.this.aAV)) {
                        c.this.mBaiduRtcRoom.jB(c.this.aAV);
                        com.baidu.live.alablmsdk.a.b.a.ag(" set mix layout order " + c.this.aAV, "");
                    }
                    c.this.mBaiduRtcRoom.d(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom.ep(true);
                    }
                    if (c.this.aAI) {
                        com.baidu.live.alablmsdk.a.b.a.ag(" isReLogin yes", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ag(" isReLogin no", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    com.baidu.live.alablmsdk.a.b.a.eG(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.d(" muteMicphone isMute=" + c.this.isMute + " muteSpeaker isSpeakerMute =" + c.this.aAS);
                    com.baidu.live.alablmsdk.a.b.a.eG(" muteMicphone isMute=" + c.this.isMute + " muteSpeaker isSpeakerMute =" + c.this.aAS);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    c.this.mBaiduRtcRoom.aZ(c.this.aAS);
                    if (c.this.aAL != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.a.eG(" loginRtcRoomWithRoomName fail");
                        c.this.cl(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV() {
        if (this.ayt && this.aAE != null) {
            if (this.aAG.aAx) {
                yO();
            }
            if (this.aAG.aAy) {
                yP();
                return;
            }
            return;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" configTransServer isNeedTransfer=" + this.ayt + " , mBLMLiveConfig=" + this.aAE, "");
    }

    private String b(a.C0167a c0167a) {
        return (c0167a == null || TextUtils.isEmpty(c0167a.ayX)) ? "" : c0167a.ayX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yW() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(com.baidu.rtc.g gVar) {
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void az(long j) {
        com.baidu.live.alablmsdk.a.b.a.eG(" kickOffUser imUk=" + j);
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
        if (!TextUtils.isEmpty(str) && str.equals(yp()) && cVar != null) {
            d(cVar.azK, z);
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
        this.aAS = z;
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.aZ(z);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ys() {
        com.baidu.live.alablmsdk.a.b.a.ag(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.yr();
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void yr() {
        com.baidu.live.alablmsdk.a.b.a.ag(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.7
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(c.this.aAY);
                c.this.yZ();
                c.this.aAK = BLMRtcState.LEAVE;
                c.this.aAR = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.aAW = false;
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.c.xx().pushEnd();
                com.baidu.live.alablmsdk.a.b.a.ag(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX() {
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.8
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
        com.baidu.live.alablmsdk.a.b.a.eG(" onErrorInfoUpdate " + i);
        cl(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        ck(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, final long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.eF(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if (this.aAL != null) {
            if (i == 100) {
                if (!this.ayt) {
                    k(1, " bd rtc login success ");
                }
                this.aAH = true;
                if (this.aAF.aAw != this.aAG.aAw) {
                    if (this.aAF.aAw) {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change publishStreaming");
                        this.mBaiduRtcRoom.publishStreaming();
                        com.baidu.live.alablmsdk.a.b.c.xx().xA();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change stopPublish");
                        this.mBaiduRtcRoom.stopPublish();
                        com.baidu.live.alablmsdk.a.b.c.xx().xC();
                    }
                }
                if (this.aAF.aAx != this.aAG.aAx) {
                    if (this.aAF.aAx) {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change startTransPushAnchor");
                        yQ();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change stopTransPushAnchor");
                        yS();
                    }
                }
                if (this.aAF.aAy != this.aAG.aAy) {
                    if (this.aAF.aAy) {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change startTransPushRoom");
                        yR();
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.eG(" config change stopTransPushRoom");
                        yT();
                    }
                }
                this.aAL.i(0, "bd rtc login success");
            } else if (i == 102 || i == 101) {
                this.aAL.i(-1, "bd rtc login fail or time out , roomEvents=" + i + " extra_info =" + str);
            } else if (i == 300) {
                com.baidu.live.alablmsdk.module.c cVar = new com.baidu.live.alablmsdk.module.c();
                cVar.azK = j;
                this.aAL.b(cVar);
            } else if (i == 303) {
                com.baidu.live.alablmsdk.module.c cVar2 = new com.baidu.live.alablmsdk.module.c();
                cVar2.azK = j;
                com.baidu.live.alablmsdk.module.a.b eW = com.baidu.live.alablmsdk.module.a.b.eW(str);
                if (eW != null && eW.azK == cVar2.azK) {
                    cVar2.order = eW.order;
                }
                this.aAL.f(cVar2);
            } else if (i == 106) {
                com.baidu.live.alablmsdk.module.rtc.c cVar3 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar3.azK = j;
                this.aAL.c(cVar3);
            } else if (i == 115) {
                com.baidu.live.alablmsdk.module.c cVar4 = new com.baidu.live.alablmsdk.module.c();
                cVar4.azK = j;
                this.aAL.g(cVar4);
            } else if (i == 107) {
                com.baidu.live.alablmsdk.module.rtc.c cVar5 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar5.azK = j;
                this.aAL.d(cVar5);
            } else if (i == 301) {
                com.baidu.live.alablmsdk.module.c cVar6 = new com.baidu.live.alablmsdk.module.c();
                cVar6.azK = j;
                this.aAL.c(cVar6);
            } else if (i == 302) {
                com.baidu.live.alablmsdk.module.rtc.a aVar = new com.baidu.live.alablmsdk.module.rtc.a();
                aVar.azK = j;
                aVar.message = str;
                this.aAL.a(aVar);
            } else if (i == 113) {
                com.baidu.live.alablmsdk.module.c cVar7 = new com.baidu.live.alablmsdk.module.c();
                cVar7.azK = j;
                this.aAL.d(cVar7);
            } else if (i == 114) {
                com.baidu.live.alablmsdk.module.c cVar8 = new com.baidu.live.alablmsdk.module.c();
                cVar8.azK = j;
                this.aAL.e(cVar8);
            }
        }
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.f(i, j);
            }
        });
    }

    private void ck(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
            if (this.aAL != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar.azK = this.aAg;
                this.aAL.b(cVar);
            }
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
            if (this.mBaiduRtcRoom != null) {
                this.mBaiduRtcRoom.muteMicphone(this.isMute);
            }
            if (this.aAL != null) {
                com.baidu.live.alablmsdk.module.rtc.c cVar2 = new com.baidu.live.alablmsdk.module.rtc.c();
                cVar2.azK = this.aAg;
                this.aAL.a(cVar2);
                com.baidu.live.alablmsdk.a.b.c.xx().xB();
            }
        } else if (i == 2003) {
            com.baidu.live.alablmsdk.a.b.a.ag("rtc onPeerConnectStateUpdate " + i, "");
            cl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, long j) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.a.eG("rtc onRoomEventUpdate roomEvents " + i);
            if (i == 10000) {
                if (!this.aAW) {
                    this.aAW = true;
                    cl(i);
                    return;
                }
                return;
            }
            cl(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.a.eG("rtc onRoomEventUpdate roomEvents " + i);
            k(2, " bd rtc trans success");
            if (j == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION.ordinal()) {
                com.baidu.live.alablmsdk.a.b.c.xx().eI(UbcStatConstant.KEY_CONTENT_ROOM);
            }
            if (j == BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION.ordinal()) {
                com.baidu.live.alablmsdk.a.b.c.xx().eI("anchor");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(final int i) {
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.b.a.ag(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.aAK + " , mIsRetrying=" + c.this.aAO, "");
                if (c.this.aAK != BLMRtcState.LEAVE) {
                    if (c.this.ayt) {
                        if (c.this.aAK == BLMRtcState.STREAM) {
                            c.this.aAM = 2;
                        }
                        com.baidu.live.alablmsdk.a.b.c.xx().cc(i);
                    } else if (c.this.aAK == BLMRtcState.JOINED) {
                        c.this.aAM = 2;
                    }
                    if (!c.this.aAR && i == 117) {
                        c.this.yZ();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" mConnectType = " + c.this.aAM);
                    com.baidu.live.alablmsdk.a.b.a.eG(" mConnectType " + c.this.aAM);
                    if (c.this.aAM == 1) {
                        c.this.k(true, c.this.aAN);
                        return;
                    } else if (c.this.aAM == 2) {
                        c.this.k(true, c.this.aAN);
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
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ayt) {
                    if (!c.this.aAR) {
                        c.this.aAR = true;
                    }
                    c.this.aAK = BLMRtcState.STREAM;
                    c.this.yZ();
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtcSuccess , mRTCRoomState=" + c.this.aAK, "");
                } else {
                    c.this.aAK = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.a.ag(" rtcSuccess , mRTCRoomState=" + c.this.aAK, "");
                }
                c.this.aAP = 0;
                c.this.aAQ = 0;
                c.this.aAO = false;
                c.this.aAW = false;
                c.this.aAM = 2;
                com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(c.this.aAY);
                if (i == 2) {
                    c.this.eY(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        if (this.ayt) {
            com.baidu.live.alablmsdk.a.c.xr().postDelayed(this.aAX, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yZ() {
        if (this.ayt) {
            com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.aAX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("rtc trans success. callback", "");
        if (this.aAL != null) {
            this.aAL.j(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.a.eG("rtc callback fail " + str);
        yZ();
        if (this.aAL != null) {
            this.aAL.j(-1, str);
        }
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void ym() {
        com.baidu.live.alablmsdk.a.b.a.ag(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("mConnectType =" + c.this.aAM + " mRTCRoomState = " + c.this.aAK + " mIsRetrying " + c.this.aAO);
                }
                if (c.this.aAK != BLMRtcState.LEAVE) {
                    if (!c.this.aAO) {
                        if (c.this.ayt) {
                            if (c.this.aAK == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.a.ag(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.aAK == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.a.ag(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.aAM != 1) {
                            if (c.this.aAM == 2) {
                                c.B(c.this);
                                c.this.k(true, c.this.aAN);
                                com.baidu.live.alablmsdk.a.b.a.ag(" re join rtc room fail. mRTCReTryCount " + c.this.aAQ, "");
                                return;
                            }
                            return;
                        }
                        c.z(c.this);
                        if (c.this.aAP <= 2) {
                            c.this.k(true, c.this.aAN);
                            com.baidu.live.alablmsdk.a.b.a.ag("init join rtc room mRTCInitRetryCount " + c.this.aAP, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.a.ag("init join rtc room fail. callback", "");
                        c.this.eZ(" init join rtc room fail. ");
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
    public com.baidu.live.alablmsdk.module.rtc.d yn() {
        BaiduRtcRoom.c[] aez;
        com.baidu.live.alablmsdk.module.rtc.d dVar = new com.baidu.live.alablmsdk.module.rtc.d();
        if (this.mBaiduRtcRoom != null && (aez = this.mBaiduRtcRoom.aez()) != null) {
            for (BaiduRtcRoom.c cVar : aez) {
                if (cVar != null && cVar.userId == this.aAg) {
                    dVar.id = cVar.userId + "";
                    dVar.volume = cVar.volumeLevel / 327;
                }
            }
        }
        return dVar;
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public boolean h(String str, com.baidu.live.alablmsdk.module.c cVar) {
        com.baidu.live.alablmsdk.a.b.a.eF(" sendMessage : msg=" + str);
        if (this.mBaiduRtcRoom != null) {
            long j = cVar != null ? cVar.azK : 0L;
            com.baidu.live.alablmsdk.a.b.a.eF(" sendMessage : msg=" + str + " , id=" + j);
            this.mBaiduRtcRoom.sendMessageToUser(str, j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.a.ag("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aAM, "");
        if (j < this.aAN) {
            j = this.aAN;
        }
        if (z && !this.aAO && this.aAL != null && this.aAM == 2) {
            this.aAL.ci(2);
        }
        this.aAO = z;
        com.baidu.live.alablmsdk.a.c.xr().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.yY();
                    com.baidu.live.alablmsdk.a.c.xr().post(c.this.aAY);
                    return;
                }
                c.this.aAI = z;
                c.this.aAO = true;
                c.this.aAH = false;
                c.this.yX();
                com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(c.this.aAY);
                com.baidu.live.alablmsdk.a.c.xr().postDelayed(c.this.aAY, j);
            }
        });
    }

    @Override // com.baidu.live.alablmsdk.c.b.g
    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.a.eG(" BLMRtcRoom release ");
        this.aAL = null;
        com.baidu.live.alablmsdk.a.c.xr().removeCallbacks(this.aAY);
        yZ();
        com.baidu.live.alablmsdk.module.a eU = com.baidu.live.alablmsdk.module.b.yC().eU(this.azh);
        UserPermission userPermission = UserPermission.VISITER;
        if (eU != null) {
            userPermission = eU.yt();
        }
        if (userPermission == UserPermission.OWNER) {
            ys();
        } else {
            yr();
        }
    }
}
