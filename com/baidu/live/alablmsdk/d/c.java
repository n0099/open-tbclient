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
/* loaded from: classes4.dex */
public class c implements BaiduRtcRoom.a, g.d {
    private String aBQ;
    private boolean aBv;
    private String aCT;
    private String aCU;
    private long aCV;
    private com.baidu.live.alablmsdk.config.a aCY;
    private boolean aCZ;
    private d aDa;
    private com.baidu.live.alablmsdk.c.b.a aDd;
    private boolean aDj;
    private String aDk;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aCW = RtcParameterSettings.agu();
    private boolean aCX = false;
    private List<RTCVideoView> aDb = new ArrayList();
    private BLMRtcState aDc = BLMRtcState.DEFAULT;
    private int aDe = 1;
    private boolean aDf = false;
    private final int aDg = 2;
    private int aDh = 0;
    private int aDi = 0;
    Runnable aDl = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aDj && c.this.aBv) {
                c.this.gj("没有回调推流成功");
            }
        }
    };
    private Runnable aDm = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.e(c.this.aBQ, c.this.aCT, c.this.aCU, c.this.aCV);
        }
    };

    static /* synthetic */ int t(c cVar) {
        int i = cVar.aDh;
        cVar.aDh = i + 1;
        return i;
    }

    static /* synthetic */ int v(c cVar) {
        int i = cVar.aDi;
        cVar.aDi = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aDd = aVar;
    }

    public String CZ() {
        return this.aBQ;
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
                this.aCW.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.AutoPublish " + this.aCW.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aCW.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.AutoSubScribe " + this.aCW.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aCW.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.VideoMaxkbps " + this.aCW.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aCW.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.VideoMinkbps " + this.aCW.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aCW.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.HasAudio  " + this.aCW.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aCW.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.HasVideo  " + this.aCW.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aCW.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.VideoFps  " + this.aCW.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aCW.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.VideoWidth  " + this.aCW.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aCW.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" cfg.VideoHeight  " + this.aCW.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aCX = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.ak(" isVideoExternalCapture  " + this.aCX, "");
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aCY = aVar;
        Da();
    }

    private void Da() {
        if (this.aCY != null && ((this.aCY.aBD == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM || this.aCY.aBD == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR) && !TextUtils.isEmpty(this.aCY.aBE))) {
            this.aBv = true;
            com.baidu.live.alablmsdk.a.b.c.BY().bi(this.aBv);
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" parseLiveStream isNeedTransfer=" + this.aBv, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aDa = dVar;
    }

    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ak(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.ak(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.ak(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    public void gh(String str) {
        this.aDk = str;
    }

    public void d(String str, String str2, String str3, long j) {
        this.aDe = 1;
        this.aDc = BLMRtcState.DEFAULT;
        this.aDf = false;
        this.aCZ = false;
        this.aBQ = str;
        this.aCT = str2;
        this.aCU = str3;
        this.aCV = j;
        c(false, 0L);
    }

    public boolean Db() {
        return this.aBv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.a.ak("joinRtcRoomInner, mRTCRoomState=" + c.this.aDc, "");
                if (c.this.aDc == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.a.ak("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.a.ak("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.aDc = BLMRtcState.JOINING;
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.a.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.a.fY(" initWithAppID failed ");
                        c.this.dQ(-1);
                        return;
                    }
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.eh(true);
                    } else {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.eh(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.aCW.VideoResolution = c.this.Dd();
                    c.this.aCW.ConnectionTimeoutMs = 5000;
                    c.this.aCW.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.aCW.AudioFrequency = 16000;
                        c.this.aCW.AudioChannel = 2;
                        c.this.aCW.AudioContentType = 2;
                    }
                    c.this.aCW.crh = true;
                    c.this.aCW.crg = true;
                    c.this.aCW.crn = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.aCW, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    com.baidu.live.alablmsdk.a.b.c.BY().d(15, 15, c.this.aCW.VideoMaxkbps, c.this.aCW.VideoMinkbps, c.this.aCW.AudioFrequency, c.this.aCW.AudioChannel);
                    if (c.this.aBv && c.this.aCY != null && !TextUtils.isEmpty(c.this.aCY.aBE)) {
                        com.baidu.live.alablmsdk.a.b.a.ak(" configLiveServerWithUrl isNeedTransfer=" + c.this.aBv, " live_url=" + c.this.aCY.aBE);
                        c.this.mBaiduRtcRoom.a(c.this.aCY.aBE, c.this.aCY.aBF, false, c.this.Dc(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ak(" configLiveServerWithUrl not Transfer ", "");
                    }
                    if (c.this.aCX) {
                        com.baidu.live.alablmsdk.a.b.a.ak(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.aDa);
                    }
                    if (!TextUtils.isEmpty(c.this.aDk)) {
                        c.this.mBaiduRtcRoom.kv(c.this.aDk);
                        com.baidu.live.alablmsdk.a.b.a.ak(" set mix layout order " + c.this.aDk, "");
                    }
                    c.this.mBaiduRtcRoom.c(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom.eh(true);
                    }
                    if (c.this.aCZ) {
                        com.baidu.live.alablmsdk.a.b.a.ak(" isReLogin yes", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.ak(" isReLogin no", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    if (c.this.aBv) {
                        com.baidu.live.alablmsdk.a.b.c.BY().setPushConfig(AlaRecorderLog.Protocol.RTC, c.this.aCY.aBE);
                        com.baidu.live.alablmsdk.a.b.c.BY().BZ();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.fY(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.d(" isMute=" + c.this.isMute);
                    com.baidu.live.alablmsdk.a.b.a.fY(" isMute " + c.this.isMute);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    if (c.this.aDd != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.a.fY(" loginRtcRoomWithRoomName fail");
                        c.this.dQ(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Dc() {
        return (this.aCY == null || TextUtils.isEmpty(this.aCY.aBG)) ? "" : this.aCY.aBG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Dd() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] agc;
        if (this.mBaiduRtcRoom != null && (agc = this.mBaiduRtcRoom.agc()) != null) {
            for (BaiduRtcRoom.c cVar : agc) {
                if (cVar != null) {
                }
            }
        }
    }

    public void aG(long j) {
        com.baidu.live.alablmsdk.a.b.a.fY(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bJ(j);
        }
    }

    public void bg(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.a.ak(" muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void De() {
        com.baidu.live.alablmsdk.a.b.a.ak(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.Df();
            }
        });
    }

    public void Df() {
        com.baidu.live.alablmsdk.a.b.a.ak(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.c.BS().removeCallbacks(c.this.aDm);
                c.this.Dj();
                c.this.aDc = BLMRtcState.LEAVE;
                c.this.aDj = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.ak(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg() {
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.ak(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.a.fY(" onErrorInfoUpdate " + i);
        dQ(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        dO(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if ((i == 100 || i == 106 || i == 107 || i == 300 || i == 301 || i == 104 || i == 303 || i == 115) && this.aDd != null) {
            this.aDd.onRoomEventUpdate(i, j, str);
        }
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.dP(i);
            }
        });
    }

    private void dO(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        } else if (i == 2003) {
            com.baidu.live.alablmsdk.a.b.a.ak("rtc onPeerConnectStateUpdate " + i, "");
            dQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.a.fY("rtc onRoomEventUpdate roomEvents " + i);
            dQ(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.a.fY("rtc onRoomEventUpdate roomEvents " + i);
            Dh();
        } else if (i == 100 && !this.aBv) {
            Dh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(final int i) {
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("rtcError errEvent = " + i + " mRTCRoomState = " + c.this.aDc);
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.aDc + " , mIsRetrying=" + c.this.aDf, "");
                if (c.this.aDc != BLMRtcState.LEAVE) {
                    if (c.this.aBv) {
                        if (c.this.aDc == BLMRtcState.STREAM) {
                            c.this.aDe = 2;
                        }
                        com.baidu.live.alablmsdk.a.b.c.BY().dK(i);
                    } else if (c.this.aDc == BLMRtcState.JOINED) {
                        c.this.aDe = 2;
                    }
                    if (!c.this.aDj && i == 117) {
                        c.this.Dj();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" mConnectType = " + c.this.aDe);
                    com.baidu.live.alablmsdk.a.b.a.fY(" mConnectType " + c.this.aDe);
                    if (c.this.aDe == 1) {
                        c.this.c(true, 5000L);
                        return;
                    } else if (c.this.aDe == 2) {
                        c.this.c(true, 5000L);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void Dh() {
        com.baidu.live.alablmsdk.a.b.a.ak(" rtcSuccess ", "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.aBv) {
                    if (!c.this.aDj) {
                        c.this.aDj = true;
                    }
                    c.this.aDc = BLMRtcState.STREAM;
                    c.this.Dj();
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtcSuccess , mRTCRoomState=" + c.this.aDc, "");
                    com.baidu.live.alablmsdk.a.b.c.BY().Cb();
                } else {
                    c.this.aDc = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.a.ak(" rtcSuccess , mRTCRoomState=" + c.this.aDc, "");
                }
                c.this.aDh = 0;
                c.this.aDi = 0;
                c.this.aDf = false;
                c.this.aDe = 2;
                com.baidu.live.alablmsdk.a.c.BS().removeCallbacks(c.this.aDm);
                c.this.gi("rtcPublishSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di() {
        if (this.aBv) {
            com.baidu.live.alablmsdk.a.c.BS().postDelayed(this.aDl, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        if (this.aBv) {
            com.baidu.live.alablmsdk.a.c.BS().removeCallbacks(this.aDl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.b.a.fY("rtc callback success");
        if (this.aDd != null) {
            this.aDd.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.a.fY("rtc callback fail " + str);
        Dj();
        if (this.aDd != null) {
            this.aDd.g(-1, str);
        }
    }

    public void Dk() {
        com.baidu.live.alablmsdk.a.b.a.ak(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("mConnectType =" + c.this.aDe + " mRTCRoomState = " + c.this.aDc + " mIsRetrying " + c.this.aDf);
                }
                if (c.this.aDc != BLMRtcState.LEAVE) {
                    if (!c.this.aDf) {
                        if (c.this.aBv) {
                            if (c.this.aDc == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.a.ak(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.aDc == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.a.ak(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.aDe != 1) {
                            if (c.this.aDe == 2) {
                                c.v(c.this);
                                c.this.c(true, 5000L);
                                com.baidu.live.alablmsdk.a.b.a.ak(" re join rtc room fail. mRTCReTryCount " + c.this.aDi, "");
                                return;
                            }
                            return;
                        }
                        c.t(c.this);
                        if (c.this.aDh <= 2) {
                            c.this.c(true, 5000L);
                            com.baidu.live.alablmsdk.a.b.a.ak("init join rtc room mRTCInitRetryCount " + c.this.aDh, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.a.ak("init join rtc room fail. callback", "");
                        c.this.gj(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ak(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.ak(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.a.ak("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aDe, "");
        if (j < 5000) {
            j = 5000;
        }
        if (z && !this.aDf && this.aDd != null && this.aDe == 2) {
            this.aDd.dN(2);
        }
        this.aDf = z;
        com.baidu.live.alablmsdk.a.c.BS().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.Di();
                    com.baidu.live.alablmsdk.a.c.BS().post(c.this.aDm);
                    return;
                }
                c.this.aCZ = z;
                c.this.aDf = true;
                c.this.Dg();
                com.baidu.live.alablmsdk.a.c.BS().removeCallbacks(c.this.aDm);
                com.baidu.live.alablmsdk.a.c.BS().postDelayed(c.this.aDm, j);
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.a.fY(" BLMRtcRoom release ");
        this.aDd = null;
        com.baidu.live.alablmsdk.a.c.BS().removeCallbacks(this.aDm);
        Dj();
        com.baidu.live.alablmsdk.module.a gd = com.baidu.live.alablmsdk.module.b.CP().gd(this.aBQ);
        UserPermission userPermission = UserPermission.VISITER;
        if (gd != null) {
            userPermission = gd.CH();
        }
        if (userPermission == UserPermission.OWNER) {
            De();
        } else {
            Df();
        }
    }
}
