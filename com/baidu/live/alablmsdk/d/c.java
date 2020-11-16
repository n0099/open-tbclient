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
    private boolean aAE;
    private String aAF;
    private String aAn;
    private String aAo;
    private long aAp;
    private com.baidu.live.alablmsdk.config.a aAs;
    private boolean aAt;
    private boolean aAu;
    private d aAv;
    private com.baidu.live.alablmsdk.c.b.a aAy;
    private String azm;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aAq = RtcParameterSettings.adl();
    private boolean aAr = false;
    private List<RTCVideoView> aAw = new ArrayList();
    private BLMRtcState aAx = BLMRtcState.DEFAULT;
    private int aAz = 1;
    private boolean aAA = false;
    private final int aAB = 2;
    private int aAC = 0;
    private int aAD = 0;
    Runnable aAG = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aAE && c.this.aAt) {
                c.this.fN("没有回调推流成功");
            }
        }
    };
    private Runnable aAH = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.azm, c.this.aAn, c.this.aAo, c.this.aAp);
        }
    };

    static /* synthetic */ int t(c cVar) {
        int i = cVar.aAC;
        cVar.aAC = i + 1;
        return i;
    }

    static /* synthetic */ int v(c cVar) {
        int i = cVar.aAD;
        cVar.aAD = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aAy = aVar;
    }

    public String Br() {
        return this.azm;
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
                this.aAq.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.AutoPublish " + this.aAq.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aAq.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.AutoSubScribe " + this.aAq.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aAq.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.VideoMaxkbps " + this.aAq.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aAq.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.VideoMinkbps " + this.aAq.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aAq.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.HasAudio  " + this.aAq.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aAq.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.HasVideo  " + this.aAq.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aAq.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.VideoFps  " + this.aAq.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aAq.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.VideoWidth  " + this.aAq.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aAq.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.ag(" cfg.VideoHeight  " + this.aAq.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aAr = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.ag(" isVideoExternalCapture  " + this.aAr, "");
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aAs = aVar;
        Bs();
    }

    private void Bs() {
        if (this.aAs != null && ((this.aAs.ayZ == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM || this.aAs.ayZ == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR) && !TextUtils.isEmpty(this.aAs.aza))) {
            this.aAt = true;
        }
        com.baidu.live.alablmsdk.a.b.ag(" parseLiveStream isNeedTransfer=" + this.aAt, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aAv = dVar;
    }

    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.ag(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.ag(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.ag(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    public void fL(String str) {
        this.aAF = str;
    }

    public void c(String str, String str2, String str3, long j) {
        this.aAz = 1;
        this.aAx = BLMRtcState.DEFAULT;
        this.aAA = false;
        this.aAu = false;
        this.azm = str;
        this.aAn = str2;
        this.aAo = str3;
        this.aAp = j;
        c(false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.ag("joinRtcRoomInner, mRTCRoomState=" + c.this.aAx, "");
                if (c.this.aAx == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.ag("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.ag("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.aAx = BLMRtcState.JOINING;
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.fD(" initWithAppID failed ");
                        c.this.dx(-1);
                        return;
                    }
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.dR(true);
                    } else {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.dR(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.aAq.VideoResolution = c.this.Bu();
                    c.this.aAq.ConnectionTimeoutMs = 5000;
                    c.this.aAq.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.aAq.AudioFrequency = 16000;
                        c.this.aAq.AudioChannel = 2;
                        c.this.aAq.AudioContentType = 2;
                    }
                    c.this.aAq.cks = true;
                    c.this.aAq.ckr = true;
                    c.this.aAq.ckw = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.aAq, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    if (c.this.aAt && c.this.aAs != null && !TextUtils.isEmpty(c.this.aAs.aza)) {
                        com.baidu.live.alablmsdk.a.b.ag(" configLiveServerWithUrl isNeedTransfer=" + c.this.aAt, " live_url=" + c.this.aAs.aza);
                        c.this.mBaiduRtcRoom.a(c.this.aAs.aza, c.this.aAs.azb, false, c.this.Bt(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                    } else {
                        com.baidu.live.alablmsdk.a.b.ag(" configLiveServerWithUrl not Transfer ", "");
                    }
                    if (c.this.aAr) {
                        com.baidu.live.alablmsdk.a.b.ag(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.aAv);
                    }
                    if (!TextUtils.isEmpty(c.this.aAF)) {
                        c.this.mBaiduRtcRoom.jO(c.this.aAF);
                        com.baidu.live.alablmsdk.a.b.ag(" set mix layout order " + c.this.aAF, "");
                    }
                    c.this.mBaiduRtcRoom.c(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                        BaiduRtcRoom.dR(true);
                    }
                    if (c.this.aAu) {
                        com.baidu.live.alablmsdk.a.b.d(" isReLogin yes");
                        com.baidu.live.alablmsdk.a.b.fD(" isReLogin yes");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.a(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.d(" isReLogin no");
                        com.baidu.live.alablmsdk.a.b.fD(" isReLogin no");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    com.baidu.live.alablmsdk.a.b.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.fD(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.d(" isMute=" + c.this.isMute);
                    com.baidu.live.alablmsdk.a.b.fD(" isMute " + c.this.isMute);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    if (c.this.aAy != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.fD(" loginRtcRoomWithRoomName fail");
                        c.this.dx(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bt() {
        return (this.aAs == null || TextUtils.isEmpty(this.aAs.azc)) ? "" : this.aAs.azc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bu() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] acT;
        if (this.mBaiduRtcRoom != null && (acT = this.mBaiduRtcRoom.acT()) != null) {
            for (BaiduRtcRoom.c cVar : acT) {
                if (cVar != null) {
                }
            }
        }
    }

    public void ai(long j) {
        com.baidu.live.alablmsdk.a.b.fD(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bk(j);
        }
    }

    public void ba(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.ag(" muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void Bv() {
        com.baidu.live.alablmsdk.a.b.ag(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.acS();
                }
                c.this.Bw();
            }
        });
    }

    public void Bw() {
        com.baidu.live.alablmsdk.a.b.ag(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.d.Ay().removeCallbacks(c.this.aAH);
                c.this.BA();
                c.this.aAx = BLMRtcState.LEAVE;
                c.this.aAE = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.ag(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bx() {
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.ag(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.ag(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.fD(" onErrorInfoUpdate " + i);
        dx(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        dv(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.isDebug()) {
            com.baidu.live.alablmsdk.a.b.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if ((i == 100 || i == 106 || i == 107 || i == 300 || i == 301 || i == 104 || i == 303 || i == 115) && this.aAy != null) {
            this.aAy.onRoomEventUpdate(i, j, str);
        }
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.dw(i);
            }
        });
    }

    private void dv(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.fD("rtc onRoomEventUpdate roomEvents " + i);
            dx(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.fD("rtc onRoomEventUpdate roomEvents " + i);
            By();
        } else if (i == 100 && !this.aAt) {
            By();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(final int i) {
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("rtcError errEvent = " + i + " mRTCRoomState = " + c.this.aAx);
                }
                com.baidu.live.alablmsdk.a.b.ag(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.aAx + " , mIsRetrying=" + c.this.aAA, "");
                if (c.this.aAx != BLMRtcState.LEAVE) {
                    if (c.this.aAt) {
                        if (c.this.aAx == BLMRtcState.STREAM) {
                            c.this.aAz = 2;
                        }
                    } else if (c.this.aAx == BLMRtcState.JOINED) {
                        c.this.aAz = 2;
                    }
                    if (!c.this.aAE && i == 117) {
                        c.this.BA();
                    }
                    com.baidu.live.alablmsdk.a.b.d(" mConnectType = " + c.this.aAz);
                    com.baidu.live.alablmsdk.a.b.fD(" mConnectType " + c.this.aAz);
                    if (c.this.aAz == 1) {
                        c.this.c(true, 2000L);
                        return;
                    } else if (c.this.aAz == 2) {
                        c.this.c(true, 5000L);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.ag(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void By() {
        com.baidu.live.alablmsdk.a.b.ag(" rtcSuccess ", "");
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.aAt) {
                    if (!c.this.aAE) {
                        c.this.aAE = true;
                    }
                    c.this.aAx = BLMRtcState.STREAM;
                    c.this.BA();
                    com.baidu.live.alablmsdk.a.b.ag(" rtcSuccess , mRTCRoomState=" + c.this.aAx, "");
                } else {
                    c.this.aAx = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.ag(" rtcSuccess , mRTCRoomState=" + c.this.aAx, "");
                }
                c.this.aAC = 0;
                c.this.aAD = 0;
                c.this.aAA = false;
                c.this.aAz = 2;
                com.baidu.live.alablmsdk.a.d.Ay().removeCallbacks(c.this.aAH);
                c.this.fM("rtcPublishSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bz() {
        if (this.aAt) {
            com.baidu.live.alablmsdk.a.d.Ay().postDelayed(this.aAG, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA() {
        if (this.aAt) {
            com.baidu.live.alablmsdk.a.d.Ay().removeCallbacks(this.aAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(String str) {
        com.baidu.live.alablmsdk.a.b.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.b.fD("rtc callback success");
        if (this.aAy != null) {
            this.aAy.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(String str) {
        com.baidu.live.alablmsdk.a.b.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.fD("rtc callback fail " + str);
        BA();
        if (this.aAy != null) {
            this.aAy.g(-1, str);
        }
    }

    public void BB() {
        com.baidu.live.alablmsdk.a.b.ag(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.d("mConnectType =" + c.this.aAz + " mRTCRoomState = " + c.this.aAx + " mIsRetrying " + c.this.aAA);
                }
                if (c.this.aAx != BLMRtcState.LEAVE) {
                    if (!c.this.aAA) {
                        if (c.this.aAt) {
                            if (c.this.aAx == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.ag(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.aAx == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.ag(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.aAz != 1) {
                            if (c.this.aAz == 2) {
                                c.v(c.this);
                                c.this.c(true, 2000L);
                                com.baidu.live.alablmsdk.a.b.ag(" re join rtc room fail. mRTCReTryCount " + c.this.aAD, "");
                                return;
                            }
                            return;
                        }
                        c.t(c.this);
                        if (c.this.aAC <= 2) {
                            c.this.c(true, 2000L);
                            com.baidu.live.alablmsdk.a.b.ag("init join rtc room mRTCInitRetryCount " + c.this.aAC, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.ag("init join rtc room fail. callback", "");
                        c.this.fN(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.ag(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.ag(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.ag("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aAz, "");
        if (j < 2000) {
            j = 2000;
        }
        if (z && !this.aAA && this.aAy != null && this.aAz == 2) {
            this.aAy.du(2);
        }
        this.aAA = z;
        com.baidu.live.alablmsdk.a.d.Ay().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.Bz();
                    com.baidu.live.alablmsdk.a.d.Ay().post(c.this.aAH);
                    return;
                }
                c.this.aAu = z;
                c.this.aAA = true;
                c.this.Bx();
                com.baidu.live.alablmsdk.a.d.Ay().removeCallbacks(c.this.aAH);
                com.baidu.live.alablmsdk.a.d.Ay().postDelayed(c.this.aAH, j);
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.fD(" BLMRtcRoom release ");
        this.aAy = null;
        com.baidu.live.alablmsdk.a.d.Ay().removeCallbacks(this.aAH);
        BA();
        com.baidu.live.alablmsdk.module.a fH = com.baidu.live.alablmsdk.module.b.Bg().fH(this.azm);
        UserPermission userPermission = UserPermission.VISITER;
        if (fH != null) {
            userPermission = fH.AZ();
        }
        if (userPermission == UserPermission.OWNER) {
            Bv();
        } else {
            Bw();
        }
    }
}
