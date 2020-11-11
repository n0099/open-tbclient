package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements BaiduRtcRoom.a, g.d {
    private String aAX;
    private String aBY;
    private String aBZ;
    private long aCa;
    private com.baidu.live.alablmsdk.config.a aCd;
    private boolean aCe;
    private boolean aCf;
    private d aCg;
    private com.baidu.live.alablmsdk.c.b.a aCj;
    private boolean aCp;
    private String aCq;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aCb = RtcParameterSettings.adT();
    private boolean aCc = false;
    private List<RTCVideoView> aCh = new ArrayList();
    private BLMRtcState aCi = BLMRtcState.DEFAULT;
    private int aCk = 1;
    private boolean aCl = false;
    private final int aCm = 2;
    private int aCn = 0;
    private int aCo = 0;
    Runnable aCr = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aCp && c.this.aCe) {
                c.this.fT("没有回调推流成功");
            }
        }
    };
    private Runnable aCs = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.aAX, c.this.aBY, c.this.aBZ, c.this.aCa);
        }
    };

    static /* synthetic */ int t(c cVar) {
        int i = cVar.aCn;
        cVar.aCn = i + 1;
        return i;
    }

    static /* synthetic */ int v(c cVar) {
        int i = cVar.aCo;
        cVar.aCo = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aCj = aVar;
    }

    public String Ca() {
        return this.aAX;
    }

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
                this.aCb.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.AutoPublish " + this.aCb.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aCb.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.AutoSubScribe " + this.aCb.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aCb.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.VideoMaxkbps " + this.aCb.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aCb.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.VideoMinkbps " + this.aCb.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aCb.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.HasAudio  " + this.aCb.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aCb.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.HasVideo  " + this.aCb.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aCb.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.VideoFps  " + this.aCb.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aCb.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.VideoWidth  " + this.aCb.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aCb.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.ah(" cfg.VideoHeight  " + this.aCb.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aCc = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.ah(" isVideoExternalCapture  " + this.aCc, "");
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aCd = aVar;
        Cb();
    }

    private void Cb() {
        if (this.aCd != null && ((this.aCd.aAK == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM || this.aCd.aAK == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR) && !TextUtils.isEmpty(this.aCd.aAL))) {
            this.aCe = true;
        }
        com.baidu.live.alablmsdk.a.b.ah(" parseLiveStream isNeedTransfer=" + this.aCe, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aCg = dVar;
    }

    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.ah(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.ah(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.ah(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    public void fR(String str) {
        this.aCq = str;
    }

    public void c(String str, String str2, String str3, long j) {
        this.aCk = 1;
        this.aCi = BLMRtcState.DEFAULT;
        this.aCl = false;
        this.aCf = false;
        this.aAX = str;
        this.aBY = str2;
        this.aBZ = str3;
        this.aCa = j;
        c(false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.ah("joinRtcRoomInner, mRTCRoomState=" + c.this.aCi, "");
                if (c.this.aCi == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.ah("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.ah("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.aCi = BLMRtcState.JOINING;
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.fJ(" initWithAppID failed ");
                        c.this.dB(-1);
                        return;
                    }
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.dP(true);
                    } else {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.dP(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.aCb.VideoResolution = c.this.Cd();
                    c.this.aCb.ConnectionTimeoutMs = 5000;
                    c.this.aCb.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.aCb.AudioFrequency = 16000;
                        c.this.aCb.AudioChannel = 2;
                        c.this.aCb.AudioContentType = 2;
                    }
                    c.this.aCb.cmc = true;
                    c.this.aCb.cmb = true;
                    c.this.aCb.cmh = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.aCb, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    if (c.this.aCe && c.this.aCd != null && !TextUtils.isEmpty(c.this.aCd.aAL)) {
                        com.baidu.live.alablmsdk.a.b.ah(" configLiveServerWithUrl isNeedTransfer=" + c.this.aCe, " live_url=" + c.this.aCd.aAL);
                        c.this.mBaiduRtcRoom.a(c.this.aCd.aAL, c.this.aCd.aAM, false, c.this.Cc(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                    } else {
                        com.baidu.live.alablmsdk.a.b.ah(" configLiveServerWithUrl not Transfer ", "");
                    }
                    if (c.this.aCc) {
                        com.baidu.live.alablmsdk.a.b.ah(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.aCg);
                    }
                    if (!TextUtils.isEmpty(c.this.aCq)) {
                        c.this.mBaiduRtcRoom.jU(c.this.aCq);
                        com.baidu.live.alablmsdk.a.b.ah(" set mix layout order " + c.this.aCq, "");
                    }
                    c.this.mBaiduRtcRoom.c(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        BaiduRtcRoom.dP(true);
                    }
                    if (c.this.aCf) {
                        com.baidu.live.alablmsdk.a.b.d(" isReLogin yes");
                        com.baidu.live.alablmsdk.a.b.fJ(" isReLogin yes");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.d(" isReLogin no");
                        com.baidu.live.alablmsdk.a.b.fJ(" isReLogin no");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    com.baidu.live.alablmsdk.a.b.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.fJ(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.d(" isMute=" + c.this.isMute);
                    com.baidu.live.alablmsdk.a.b.fJ(" isMute " + c.this.isMute);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    if (c.this.aCj != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.fJ(" loginRtcRoomWithRoomName fail");
                        c.this.dB(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Cc() {
        return (this.aCd == null || TextUtils.isEmpty(this.aCd.aAN)) ? "" : this.aCd.aAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Cd() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] adB;
        if (this.mBaiduRtcRoom != null && (adB = this.mBaiduRtcRoom.adB()) != null) {
            for (BaiduRtcRoom.c cVar : adB) {
                if (cVar != null) {
                }
            }
        }
    }

    public void ai(long j) {
        com.baidu.live.alablmsdk.a.b.fJ(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bk(j);
        }
    }

    public void aY(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.ah(" muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void Ce() {
        com.baidu.live.alablmsdk.a.b.ah(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.Cf();
            }
        });
    }

    public void Cf() {
        com.baidu.live.alablmsdk.a.b.ah(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.d.Bh().removeCallbacks(c.this.aCs);
                c.this.Cj();
                c.this.aCi = BLMRtcState.LEAVE;
                c.this.aCp = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.ah(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg() {
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ah(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.ah(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.fJ(" onErrorInfoUpdate " + i);
        dB(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        dz(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.isDebug()) {
            com.baidu.live.alablmsdk.a.b.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if ((i == 100 || i == 106 || i == 107 || i == 300 || i == 301 || i == 104 || i == 303 || i == 115) && this.aCj != null) {
            this.aCj.onRoomEventUpdate(i, j, str);
        }
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.dA(i);
            }
        });
    }

    private void dz(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.fJ("rtc onRoomEventUpdate roomEvents " + i);
            dB(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.fJ("rtc onRoomEventUpdate roomEvents " + i);
            Ch();
        } else if (i == 100 && !this.aCe) {
            Ch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(final int i) {
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("rtcError errEvent = " + i + " mRTCRoomState = " + c.this.aCi);
                }
                com.baidu.live.alablmsdk.a.b.ah(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.aCi + " , mIsRetrying=" + c.this.aCl, "");
                if (c.this.aCi != BLMRtcState.LEAVE) {
                    if (c.this.aCe) {
                        if (c.this.aCi == BLMRtcState.STREAM) {
                            c.this.aCk = 2;
                        }
                    } else if (c.this.aCi == BLMRtcState.JOINED) {
                        c.this.aCk = 2;
                    }
                    if (!c.this.aCp && i == 117) {
                        c.this.Cj();
                    }
                    com.baidu.live.alablmsdk.a.b.d(" mConnectType = " + c.this.aCk);
                    com.baidu.live.alablmsdk.a.b.fJ(" mConnectType " + c.this.aCk);
                    if (c.this.aCk == 1) {
                        c.this.c(true, 2000L);
                        return;
                    } else if (c.this.aCk == 2) {
                        c.this.c(true, 5000L);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.ah(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void Ch() {
        com.baidu.live.alablmsdk.a.b.ah(" rtcSuccess ", "");
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.aCe) {
                    if (!c.this.aCp) {
                        c.this.aCp = true;
                    }
                    c.this.aCi = BLMRtcState.STREAM;
                    c.this.Cj();
                    com.baidu.live.alablmsdk.a.b.ah(" rtcSuccess , mRTCRoomState=" + c.this.aCi, "");
                } else {
                    c.this.aCi = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.ah(" rtcSuccess , mRTCRoomState=" + c.this.aCi, "");
                }
                c.this.aCn = 0;
                c.this.aCo = 0;
                c.this.aCl = false;
                c.this.aCk = 2;
                com.baidu.live.alablmsdk.a.d.Bh().removeCallbacks(c.this.aCs);
                c.this.fS("rtcPublishSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        if (this.aCe) {
            com.baidu.live.alablmsdk.a.d.Bh().postDelayed(this.aCr, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        if (this.aCe) {
            com.baidu.live.alablmsdk.a.d.Bh().removeCallbacks(this.aCr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        com.baidu.live.alablmsdk.a.b.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.b.fJ("rtc callback success");
        if (this.aCj != null) {
            this.aCj.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        com.baidu.live.alablmsdk.a.b.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.fJ("rtc callback fail " + str);
        Cj();
        if (this.aCj != null) {
            this.aCj.g(-1, str);
        }
    }

    public void Ck() {
        com.baidu.live.alablmsdk.a.b.ah(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("mConnectType =" + c.this.aCk + " mRTCRoomState = " + c.this.aCi + " mIsRetrying " + c.this.aCl);
                }
                if (c.this.aCi != BLMRtcState.LEAVE) {
                    if (!c.this.aCl) {
                        if (c.this.aCe) {
                            if (c.this.aCi == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.ah(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.aCi == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.ah(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.aCk != 1) {
                            if (c.this.aCk == 2) {
                                c.v(c.this);
                                c.this.c(true, 2000L);
                                com.baidu.live.alablmsdk.a.b.ah(" re join rtc room fail. mRTCReTryCount " + c.this.aCo, "");
                                return;
                            }
                            return;
                        }
                        c.t(c.this);
                        if (c.this.aCn <= 2) {
                            c.this.c(true, 2000L);
                            com.baidu.live.alablmsdk.a.b.ah("init join rtc room mRTCInitRetryCount " + c.this.aCn, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.ah("init join rtc room fail. callback", "");
                        c.this.fT(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.ah(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.ah(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.ah("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aCk, "");
        if (j < 2000) {
            j = 2000;
        }
        if (z && !this.aCl && this.aCj != null && this.aCk == 2) {
            this.aCj.dy(2);
        }
        this.aCl = z;
        com.baidu.live.alablmsdk.a.d.Bh().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.Ci();
                    com.baidu.live.alablmsdk.a.d.Bh().post(c.this.aCs);
                    return;
                }
                c.this.aCf = z;
                c.this.aCl = true;
                c.this.Cg();
                com.baidu.live.alablmsdk.a.d.Bh().removeCallbacks(c.this.aCs);
                com.baidu.live.alablmsdk.a.d.Bh().postDelayed(c.this.aCs, j);
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.fJ(" BLMRtcRoom release ");
        this.aCj = null;
        com.baidu.live.alablmsdk.a.d.Bh().removeCallbacks(this.aCs);
        Cj();
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.BP().fN(this.aAX);
        UserPermission userPermission = UserPermission.VISITER;
        if (fN != null) {
            userPermission = fN.BI();
        }
        if (userPermission == UserPermission.OWNER) {
            Ce();
        } else {
            Cf();
        }
    }
}
