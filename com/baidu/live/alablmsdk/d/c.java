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
/* loaded from: classes11.dex */
public class c implements BaiduRtcRoom.a, g.d {
    private boolean aBM;
    private String aCh;
    private boolean aDA;
    private String aDB;
    private String aDk;
    private String aDl;
    private long aDm;
    private com.baidu.live.alablmsdk.config.a aDp;
    private boolean aDq;
    private d aDr;
    private com.baidu.live.alablmsdk.c.b.a aDu;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aDn = RtcParameterSettings.aiq();
    private boolean aDo = false;
    private List<RTCVideoView> aDs = new ArrayList();
    private BLMRtcState aDt = BLMRtcState.DEFAULT;
    private int aDv = 1;
    private boolean aDw = false;
    private final int aDx = 2;
    private int aDy = 0;
    private int aDz = 0;
    Runnable aDC = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.10
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aDA && c.this.aBM) {
                c.this.fT("没有回调推流成功");
            }
        }
    };
    private Runnable aDD = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.e(c.this.aCh, c.this.aDk, c.this.aDl, c.this.aDm);
        }
    };

    static /* synthetic */ int t(c cVar) {
        int i = cVar.aDy;
        cVar.aDy = i + 1;
        return i;
    }

    static /* synthetic */ int v(c cVar) {
        int i = cVar.aDz;
        cVar.aDz = i + 1;
        return i;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aDu = aVar;
    }

    public String Cq() {
        return this.aCh;
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
                this.aDn.AutoPublish = ((Boolean) obj10).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.AutoPublish " + this.aDn.AutoPublish, "");
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aDn.AutoSubScribe = ((Boolean) obj9).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.AutoSubScribe " + this.aDn.AutoSubScribe, "");
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aDn.VideoMaxkbps = ((Integer) obj8).intValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.VideoMaxkbps " + this.aDn.VideoMaxkbps, "");
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aDn.VideoMinkbps = ((Integer) obj7).intValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.VideoMinkbps " + this.aDn.VideoMinkbps, "");
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aDn.HasAudio = ((Boolean) obj6).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.HasAudio  " + this.aDn.HasAudio, "");
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aDn.HasVideo = ((Boolean) obj5).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.HasVideo  " + this.aDn.HasVideo, "");
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aDn.VideoFps = ((Integer) obj4).intValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.VideoFps  " + this.aDn.VideoFps, "");
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aDn.VideoWidth = ((Integer) obj3).intValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.VideoWidth  " + this.aDn.VideoWidth, "");
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aDn.VideoHeight = ((Integer) obj2).intValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" cfg.VideoHeight  " + this.aDn.VideoHeight, "");
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aDo = ((Boolean) obj).booleanValue();
                com.baidu.live.alablmsdk.a.b.a.aj(" isVideoExternalCapture  " + this.aDo, "");
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aDp = aVar;
        Cr();
    }

    private void Cr() {
        if (this.aDp != null && ((this.aDp.aBU == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ROOM || this.aDp.aBU == BLMLiveTransferMode.BLM_LIVE_TRANSFER_MODE_ANCHOR) && !TextUtils.isEmpty(this.aDp.aBV))) {
            this.aBM = true;
            com.baidu.live.alablmsdk.a.b.c.Bp().bf(this.aBM);
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" parseLiveStream isNeedTransfer=" + this.aBM, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aDr = dVar;
    }

    public void setUserAttribute(String str) {
        this.mBaiduRtcRoom.setUserAttribute(str);
    }

    public void setExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.aj(" setExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.setExternalSurface(j, surface);
        }
    }

    public void changeSurfaceSize(long j, int i, int i2) {
        com.baidu.live.alablmsdk.a.b.a.aj(" changeSurfaceSize imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.changeSurfaceSize(j, i, i2);
        }
    }

    public void destroyExternalSurface(long j, Surface surface) {
        com.baidu.live.alablmsdk.a.b.a.aj(" destroyExternalSurface imUK=" + j, "");
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.destroyExternalSurface(j, surface);
        }
    }

    public void fR(String str) {
        this.aDB = str;
    }

    public void d(String str, String str2, String str3, long j) {
        this.aDv = 1;
        this.aDt = BLMRtcState.DEFAULT;
        this.aDw = false;
        this.aDq = false;
        this.aCh = str;
        this.aDk = str2;
        this.aDl = str3;
        this.aDm = j;
        j(false, 0L);
    }

    public boolean Cs() {
        return this.aBM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.b.a.aj("joinRtcRoomInner, mRTCRoomState=" + c.this.aDt, "");
                if (c.this.aDt == BLMRtcState.LEAVE) {
                    com.baidu.live.alablmsdk.a.b.a.aj("joinRtcRoomInner , has leave rtc room , return", "");
                } else if (j == 0) {
                    com.baidu.live.alablmsdk.a.b.a.aj("joinRtcRoomInner , imUk==0 , return", "");
                } else {
                    c.this.aDt = BLMRtcState.JOINING;
                    c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                    if (c.this.mBaiduRtcRoom == null) {
                        com.baidu.live.alablmsdk.a.b.a.d(" initWithAppID failed ");
                        com.baidu.live.alablmsdk.a.b.a.fI(" initWithAppID failed ");
                        c.this.dN(-1);
                        return;
                    }
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.eq(true);
                    } else {
                        BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                        BaiduRtcRoom.eq(false);
                    }
                    c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                    c.this.mBaiduRtcRoom.a((g.d) c.this);
                    c.this.aDn.VideoResolution = c.this.Cu();
                    c.this.aDn.ConnectionTimeoutMs = 5000;
                    c.this.aDn.ReadTimeoutMs = 5000;
                    if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                        c.this.aDn.AudioFrequency = 16000;
                        c.this.aDn.AudioChannel = 2;
                        c.this.aDn.AudioContentType = 2;
                    }
                    c.this.aDn.cyl = true;
                    c.this.aDn.cyk = true;
                    c.this.aDn.cyr = RtcParameterSettings.RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_EXTERNAL;
                    c.this.mBaiduRtcRoom.a(c.this.aDn, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                    com.baidu.live.alablmsdk.a.b.c.Bp().d(15, 15, c.this.aDn.VideoMaxkbps, c.this.aDn.VideoMinkbps, c.this.aDn.AudioFrequency, c.this.aDn.AudioChannel);
                    if (c.this.aBM && c.this.aDp != null && !TextUtils.isEmpty(c.this.aDp.aBV)) {
                        com.baidu.live.alablmsdk.a.b.a.aj(" configLiveServerWithUrl isNeedTransfer=" + c.this.aBM, " live_url=" + c.this.aDp.aBV);
                        c.this.mBaiduRtcRoom.a(c.this.aDp.aBV, c.this.aDp.aBW, false, c.this.Ct(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.aj(" configLiveServerWithUrl not Transfer ", "");
                    }
                    if (c.this.aDo) {
                        com.baidu.live.alablmsdk.a.b.a.aj(" open external capture ", "");
                        c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                        c.this.mBaiduRtcRoom.a(c.this.aDr);
                    }
                    if (!TextUtils.isEmpty(c.this.aDB)) {
                        c.this.mBaiduRtcRoom.ko(c.this.aDB);
                        com.baidu.live.alablmsdk.a.b.a.aj(" set mix layout order " + c.this.aDB, "");
                    }
                    c.this.mBaiduRtcRoom.f(true, false, "online");
                    if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                        BaiduRtcRoom.eq(true);
                    }
                    if (c.this.aDq) {
                        com.baidu.live.alablmsdk.a.b.a.aj(" isReLogin yes", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                    } else {
                        com.baidu.live.alablmsdk.a.b.a.aj(" isReLogin no", "");
                        loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                    }
                    if (c.this.aBM) {
                        com.baidu.live.alablmsdk.a.b.c.Bp().setPushConfig(AlaRecorderLog.Protocol.RTC, c.this.aDp.aBV);
                        com.baidu.live.alablmsdk.a.b.c.Bp().Bq();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.fI(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                    com.baidu.live.alablmsdk.a.b.a.d(" isMute=" + c.this.isMute);
                    com.baidu.live.alablmsdk.a.b.a.fI(" isMute " + c.this.isMute);
                    c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                    if (c.this.aDu != null && !loginRtcRoomWithRoomName) {
                        com.baidu.live.alablmsdk.a.b.a.d(" loginRtcRoomWithRoomName fail");
                        com.baidu.live.alablmsdk.a.b.a.fI(" loginRtcRoomWithRoomName fail");
                        c.this.dN(-1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ct() {
        return (this.aDp == null || TextUtils.isEmpty(this.aDp.aBX)) ? "" : this.aDp.aBX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Cu() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] ahY;
        if (this.mBaiduRtcRoom != null && (ahY = this.mBaiduRtcRoom.ahY()) != null) {
            for (BaiduRtcRoom.c cVar : ahY) {
                if (cVar != null) {
                }
            }
        }
    }

    public void aF(long j) {
        com.baidu.live.alablmsdk.a.b.a.fI(" kickOffUser imUk=" + j);
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.bK(j);
        }
    }

    public void bd(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.b.a.aj(" muteMicrophone mute" + z, "");
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void Cv() {
        com.baidu.live.alablmsdk.a.b.a.aj(" rtc closeRoom ", "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtc disbandRoom ", "");
                    c.this.mBaiduRtcRoom.disbandRoom();
                }
                c.this.Cw();
            }
        });
    }

    public void Cw() {
        com.baidu.live.alablmsdk.a.b.a.aj(" rtc leaveRoom ", "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(c.this.aDD);
                c.this.CA();
                c.this.aDt = BLMRtcState.LEAVE;
                c.this.aDA = false;
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtc logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtc destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.aj(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx() {
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.6
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtc closeRoomInner logoutRtcRoom ", "");
                    c.this.mBaiduRtcRoom.logoutRtcRoom();
                }
                if (c.this.mBaiduRtcRoom != null) {
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtc closeRoomInner destroy ", "");
                    c.this.mBaiduRtcRoom.destroy();
                }
                c.this.mBaiduRtcRoom = null;
                com.baidu.live.alablmsdk.a.b.a.aj(" rtc mBaiduRtcRoom == null ", "");
            }
        });
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.b.a.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.b.a.fI(" onErrorInfoUpdate " + i);
        dN(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        dL(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
            com.baidu.live.alablmsdk.a.b.a.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        }
        if ((i == 100 || i == 106 || i == 107 || i == 300 || i == 301 || i == 104 || i == 303 || i == 115) && this.aDu != null) {
            this.aDu.onRoomEventUpdate(i, j, str);
        }
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.7
            @Override // java.lang.Runnable
            public void run() {
                c.this.dM(i);
            }
        });
    }

    private void dL(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.b.a.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        } else if (i == 2003) {
            com.baidu.live.alablmsdk.a.b.a.aj("rtc onPeerConnectStateUpdate " + i, "");
            dN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.b.a.fI("rtc onRoomEventUpdate roomEvents " + i);
            dN(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.b.a.fI("rtc onRoomEventUpdate roomEvents " + i);
            Cy();
        } else if (i == 100 && !this.aBM) {
            Cy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(final int i) {
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("rtcError errEvent = " + i + " mRTCRoomState = " + c.this.aDt);
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" rtcError errEvent " + i + " mRTCRoomState=" + c.this.aDt + " , mIsRetrying=" + c.this.aDw, "");
                if (c.this.aDt != BLMRtcState.LEAVE) {
                    if (c.this.aBM) {
                        if (c.this.aDt == BLMRtcState.STREAM) {
                            c.this.aDv = 2;
                        }
                        com.baidu.live.alablmsdk.a.b.c.Bp().dH(i);
                    } else if (c.this.aDt == BLMRtcState.JOINED) {
                        c.this.aDv = 2;
                    }
                    if (!c.this.aDA && i == 117) {
                        c.this.CA();
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" mConnectType = " + c.this.aDv);
                    com.baidu.live.alablmsdk.a.b.a.fI(" mConnectType " + c.this.aDv);
                    if (c.this.aDv == 1) {
                        c.this.j(true, 5000L);
                        return;
                    } else if (c.this.aDv == 2) {
                        c.this.j(true, 5000L);
                        return;
                    } else {
                        return;
                    }
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" rtcError mRTCRoomState == LEAVE, return", "");
            }
        });
    }

    private void Cy() {
        com.baidu.live.alablmsdk.a.b.a.aj(" rtcSuccess ", "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.9
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.aBM) {
                    if (!c.this.aDA) {
                        c.this.aDA = true;
                    }
                    c.this.aDt = BLMRtcState.STREAM;
                    c.this.CA();
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtcSuccess , mRTCRoomState=" + c.this.aDt, "");
                    com.baidu.live.alablmsdk.a.b.c.Bp().Bs();
                } else {
                    c.this.aDt = BLMRtcState.JOINED;
                    com.baidu.live.alablmsdk.a.b.a.aj(" rtcSuccess , mRTCRoomState=" + c.this.aDt, "");
                }
                c.this.aDy = 0;
                c.this.aDz = 0;
                c.this.aDw = false;
                c.this.aDv = 2;
                com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(c.this.aDD);
                c.this.fS("rtcPublishSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (this.aBM) {
            com.baidu.live.alablmsdk.a.c.Bj().postDelayed(this.aDC, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA() {
        if (this.aBM) {
            com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.b.a.fI("rtc callback success");
        if (this.aDu != null) {
            this.aDu.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        com.baidu.live.alablmsdk.a.b.a.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.b.a.fI("rtc callback fail " + str);
        CA();
        if (this.aDu != null) {
            this.aDu.g(-1, str);
        }
    }

    public void CB() {
        com.baidu.live.alablmsdk.a.b.a.aj(" reTryRtc ", "");
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.11
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.live.alablmsdk.a.b.a.isDebug()) {
                    com.baidu.live.alablmsdk.a.b.a.d("mConnectType =" + c.this.aDv + " mRTCRoomState = " + c.this.aDt + " mIsRetrying " + c.this.aDw);
                }
                if (c.this.aDt != BLMRtcState.LEAVE) {
                    if (!c.this.aDw) {
                        if (c.this.aBM) {
                            if (c.this.aDt == BLMRtcState.STREAM) {
                                com.baidu.live.alablmsdk.a.b.a.aj(" isNeedTransfer reTry Rtc room mRTCRoomState==STREAM return ", "");
                                return;
                            }
                        } else if (c.this.aDt == BLMRtcState.JOINED) {
                            com.baidu.live.alablmsdk.a.b.a.aj(" not isNeedTransfer reTry Rtc room mRTCRoomState==JOINED return ", "");
                            return;
                        }
                        if (c.this.aDv != 1) {
                            if (c.this.aDv == 2) {
                                c.v(c.this);
                                c.this.j(true, 5000L);
                                com.baidu.live.alablmsdk.a.b.a.aj(" re join rtc room fail. mRTCReTryCount " + c.this.aDz, "");
                                return;
                            }
                            return;
                        }
                        c.t(c.this);
                        if (c.this.aDy <= 2) {
                            c.this.j(true, 5000L);
                            com.baidu.live.alablmsdk.a.b.a.aj("init join rtc room mRTCInitRetryCount " + c.this.aDy, "");
                            return;
                        }
                        com.baidu.live.alablmsdk.a.b.a.aj("init join rtc room fail. callback", "");
                        c.this.fT(" init join rtc room fail. ");
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.aj(" reTryRtc Is Retrying return ", "");
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.aj(" reTry Rtc room mRTCRoomState==LEAVE return ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, final long j) {
        com.baidu.live.alablmsdk.a.b.a.aj("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aDv, "");
        if (j < 5000) {
            j = 5000;
        }
        if (z && !this.aDw && this.aDu != null && this.aDv == 2) {
            this.aDu.dK(2);
        }
        this.aDw = z;
        com.baidu.live.alablmsdk.a.c.Bj().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    c.this.Cz();
                    com.baidu.live.alablmsdk.a.c.Bj().post(c.this.aDD);
                    return;
                }
                c.this.aDq = z;
                c.this.aDw = true;
                c.this.Cx();
                com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(c.this.aDD);
                com.baidu.live.alablmsdk.a.c.Bj().postDelayed(c.this.aDD, j);
            }
        });
    }

    public void release() {
        com.baidu.live.alablmsdk.a.b.a.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.b.a.fI(" BLMRtcRoom release ");
        this.aDu = null;
        com.baidu.live.alablmsdk.a.c.Bj().removeCallbacks(this.aDD);
        CA();
        com.baidu.live.alablmsdk.module.a fN = com.baidu.live.alablmsdk.module.b.Cg().fN(this.aCh);
        UserPermission userPermission = UserPermission.VISITER;
        if (fN != null) {
            userPermission = fN.BY();
        }
        if (userPermission == UserPermission.OWNER) {
            Cv();
        } else {
            Cw();
        }
    }
}
