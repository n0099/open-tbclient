package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.ala.recorder.video.AlaRecorderLog;
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
/* loaded from: classes10.dex */
public class c implements BaiduRtcRoom.a, g.d {
    private boolean awZ;
    private String axu;
    private com.baidu.live.alablmsdk.config.a ayC;
    private boolean ayD;
    private d ayE;
    private com.baidu.live.alablmsdk.c.b.a ayH;
    private boolean ayN;
    private String ayO;
    private String ayx;
    private String ayy;
    private long ayz;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings ayA = RtcParameterSettings.aex();
    private boolean ayB = false;
    private List<RTCVideoView> ayF = new ArrayList();
    private BLMRtcState ayG = BLMRtcState.DEFAULT;
    private int ayI = 1;
    private boolean ayJ = false;
    private final int ayK = 2;
    private int ayL = 0;
    private int ayM = 0;
    Runnable ayP = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.ayN && c.this.awZ) {
                c.this.eI("没有回调推流成功");
            }
        }
    };
    private Runnable ayQ = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.e(c.this.axu, c.this.ayx, c.this.ayy, c.this.ayz);
        }
    };

    static /* synthetic */ int t(c cVar) {
        int i = cVar.ayL;
        cVar.ayL = i + 1;
        return i;
    }

    static /* synthetic */ int v(c cVar) {
        int i = cVar.ayM;
        cVar.ayM = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.ayH = aVar;
    }

    public String yv() {
        return this.axu;
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
                this.ayA.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.AutoPublish " + this.ayA.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.ayA.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.AutoSubScribe " + this.ayA.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.ayA.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.VideoMaxkbps " + this.ayA.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.ayA.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.VideoMinkbps " + this.ayA.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.ayA.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.HasAudio  " + this.ayA.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.ayA.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.HasVideo  " + this.ayA.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.ayA.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.VideoFps  " + this.ayA.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.ayA.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.VideoWidth  " + this.ayA.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.ayA.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" cfg.VideoHeight  " + this.ayA.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.ayB = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ai(" isVideoExternalCapture  " + this.ayB, "");
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.ayC = aVar;
        yw();
    }

    private void yw() {
        if (this.ayC != null && ((this.ayC.axh == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM || this.ayC.axh == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR) && !TextUtils.isEmpty(this.ayC.axi))) {
            this.awZ = true;
            com.baidu.live.alablmsdk.a.b.c.xu().bb(this.awZ);
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" parseLiveStream isNeedTransfer=" + this.awZ, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.ayE = dVar;
    }

    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ai(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ai(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ai(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    public void eG(String str) {
        this.ayO = str;
    }

    public void d(String str, String str2, String str3, long j) {
        this.ayI = 1;
        this.ayG = BLMRtcState.DEFAULT;
        this.ayJ = false;
        this.ayD = false;
        this.axu = str;
        this.ayx = str2;
        this.ayy = str3;
        this.ayz = j;
        j(false, 0L);
    }

    public boolean yx() {
        return this.awZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.a.ai("joinRtcRoomInner, mRTCRoomState=" + c.this.ayG, "");
                if (c.this.ayG == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.a.ai("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.a.ai("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.ayG = BLMRtcState.JOINING;
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.a.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.a.ew(" initWithAppID failed ");
                        c.this.ch(-1);
                        return;
                    }
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.em(true);
                    } else {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.em(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.ayA.VideoResolution = c.this.yz();
                    c.this.ayA.ConnectionTimeoutMs = 5000;
                    c.this.ayA.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.ayA.AudioFrequency = 16000;
                        c.this.ayA.AudioChannel = 2;
                        c.this.ayA.AudioContentType = 2;
                    }
                    c.this.ayA.ctw = true;
                    c.this.ayA.ctv = true;
                    c.this.ayA.ctD = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.ayA, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    com.baidu.live.alablmsdk.a.b.c.xu().e(15, 15, c.this.ayA.VideoMaxkbps, c.this.ayA.VideoMinkbps, c.this.ayA.AudioFrequency, c.this.ayA.AudioChannel);
                    if (c.this.awZ && c.this.ayC != null && !TextUtils.isEmpty(c.this.ayC.axi)) {
                        com.baidu.live.alablmsdk.a.b.a.ai(" configLiveServerWithUrl isNeedTransfer=" + c.this.awZ, " live_url=" + c.this.ayC.axi);
                        c.this.mBaiduRtcRoom.a(c.this.ayC.axi, c.this.ayC.axj, false, c.this.yy(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ai(" configLiveServerWithUrl not Transfer ", "");
                    }
                    if (c.this.ayB) {
                        com.baidu.live.alablmsdk.a.b.a.ai(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.ayE);
                    }
                    if (!TextUtils.isEmpty(c.this.ayO)) {
                        c.this.mBaiduRtcRoom.jd(c.this.ayO);
                        com.baidu.live.alablmsdk.a.b.a.ai(" set mix layout order " + c.this.ayO, "");
                    }
                    c.this.mBaiduRtcRoom.f(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom.em(true);
                    }
                    if (c.this.ayD) {
                        com.baidu.live.alablmsdk.a.b.a.ai(" isReLogin yes", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ai(" isReLogin no", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    if (c.this.awZ) {
                        com.baidu.live.alablmsdk.a.b.c.xu().setPushConfig(AlaRecorderLog.Protocol.RTC, c.this.ayC.axi);
                        com.baidu.live.alablmsdk.a.b.c.xu().xv();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.ew(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.d(" isMute=" + c.this.isMute);
                    com.baidu.live.alablmsdk.a.b.a.ew(" isMute " + c.this.isMute);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    if (c.this.ayH != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.a.ew(" loginRtcRoomWithRoomName fail");
                        c.this.ch(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yy() {
        return (this.ayC == null || TextUtils.isEmpty(this.ayC.axk)) ? "" : this.ayC.axk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yz() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] aef;
        if (this.mBaiduRtcRoom != null && (aef = this.mBaiduRtcRoom.aef()) != null) {
            for (BaiduRtcRoom.c cVar : aef) {
                if (cVar != null) {
                }
            }
        }
    }

    public void aF(long j) {
        com.baidu.live.alablmsdk.a.b.a.ew(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bK(j);
        }
    }

    public void aZ(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.a.ai(" muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void yA() {
        com.baidu.live.alablmsdk.a.b.a.ai(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.yB();
            }
        });
    }

    public void yB() {
        com.baidu.live.alablmsdk.a.b.a.ai(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.ayQ);
                c.this.yF();
                c.this.ayG = BLMRtcState.LEAVE;
                c.this.ayN = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.ai(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC() {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.ai(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.a.ew(" onErrorInfoUpdate " + i);
        ch(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        cf(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if ((i == 100 || i == 106 || i == 107 || i == 300 || i == 301 || i == 104 || i == 303 || i == 115) && this.ayH != null) {
            this.ayH.onRoomEventUpdate(i, j, str);
        }
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.cg(i);
            }
        });
    }

    private void cf(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        } else if (i == 2003) {
            com.baidu.live.alablmsdk.a.b.a.ai("rtc onPeerConnectStateUpdate " + i, "");
            ch(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.a.ew("rtc onRoomEventUpdate roomEvents " + i);
            ch(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.a.ew("rtc onRoomEventUpdate roomEvents " + i);
            yD();
        } else if (i == 100 && !this.awZ) {
            yD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(final int i) {
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("rtcError errEvent = " + i + " mRTCRoomState = " + c.this.ayG);
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.ayG + " , mIsRetrying=" + c.this.ayJ, "");
                if (c.this.ayG != BLMRtcState.LEAVE) {
                    if (c.this.awZ) {
                        if (c.this.ayG == BLMRtcState.STREAM) {
                            c.this.ayI = 2;
                        }
                        com.baidu.live.alablmsdk.a.b.c.xu().cb(i);
                    } else if (c.this.ayG == BLMRtcState.JOINED) {
                        c.this.ayI = 2;
                    }
                    if (!c.this.ayN && i == 117) {
                        c.this.yF();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" mConnectType = " + c.this.ayI);
                    com.baidu.live.alablmsdk.a.b.a.ew(" mConnectType " + c.this.ayI);
                    if (c.this.ayI == 1) {
                        c.this.j(true, 5000L);
                        return;
                    } else if (c.this.ayI == 2) {
                        c.this.j(true, 5000L);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void yD() {
        com.baidu.live.alablmsdk.a.b.a.ai(" rtcSuccess ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.awZ) {
                    if (!c.this.ayN) {
                        c.this.ayN = true;
                    }
                    c.this.ayG = BLMRtcState.STREAM;
                    c.this.yF();
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtcSuccess , mRTCRoomState=" + c.this.ayG, "");
                    com.baidu.live.alablmsdk.a.b.c.xu().xx();
                } else {
                    c.this.ayG = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.a.ai(" rtcSuccess , mRTCRoomState=" + c.this.ayG, "");
                }
                c.this.ayL = 0;
                c.this.ayM = 0;
                c.this.ayJ = false;
                c.this.ayI = 2;
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.ayQ);
                c.this.eH("rtcPublishSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE() {
        if (this.awZ) {
            com.baidu.live.alablmsdk.a.c.xo().postDelayed(this.ayP, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF() {
        if (this.awZ) {
            com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(this.ayP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.b.a.ew("rtc callback success");
        if (this.ayH != null) {
            this.ayH.h(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.a.ew("rtc callback fail " + str);
        yF();
        if (this.ayH != null) {
            this.ayH.h(-1, str);
        }
    }

    public void yG() {
        com.baidu.live.alablmsdk.a.b.a.ai(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("mConnectType =" + c.this.ayI + " mRTCRoomState = " + c.this.ayG + " mIsRetrying " + c.this.ayJ);
                }
                if (c.this.ayG != BLMRtcState.LEAVE) {
                    if (!c.this.ayJ) {
                        if (c.this.awZ) {
                            if (c.this.ayG == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.a.ai(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.ayG == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.a.ai(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.ayI != 1) {
                            if (c.this.ayI == 2) {
                                c.v(c.this);
                                c.this.j(true, 5000L);
                                com.baidu.live.alablmsdk.a.b.a.ai(" re join rtc room fail. mRTCReTryCount " + c.this.ayM, "");
                                return;
                            }
                            return;
                        }
                        c.t(c.this);
                        if (c.this.ayL <= 2) {
                            c.this.j(true, 5000L);
                            com.baidu.live.alablmsdk.a.b.a.ai("init join rtc room mRTCInitRetryCount " + c.this.ayL, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.a.ai("init join rtc room fail. callback", "");
                        c.this.eI(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ai(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.ai(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.a.ai("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.ayI, "");
        if (j < 5000) {
            j = 5000;
        }
        if (z && !this.ayJ && this.ayH != null && this.ayI == 2) {
            this.ayH.ce(2);
        }
        this.ayJ = z;
        com.baidu.live.alablmsdk.a.c.xo().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.yE();
                    com.baidu.live.alablmsdk.a.c.xo().post(c.this.ayQ);
                    return;
                }
                c.this.ayD = z;
                c.this.ayJ = true;
                c.this.yC();
                com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(c.this.ayQ);
                com.baidu.live.alablmsdk.a.c.xo().postDelayed(c.this.ayQ, j);
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.a.ew(" BLMRtcRoom release ");
        this.ayH = null;
        com.baidu.live.alablmsdk.a.c.xo().removeCallbacks(this.ayQ);
        yF();
        com.baidu.live.alablmsdk.module.a eC = com.baidu.live.alablmsdk.module.b.yl().eC(this.axu);
        UserPermission userPermission = UserPermission.VISITER;
        if (eC != null) {
            userPermission = eC.yd();
        }
        if (userPermission == UserPermission.OWNER) {
            yA();
        } else {
            yB();
        }
    }
}
