package com.baidu.live.alablmsdk.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
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
    private com.baidu.live.alablmsdk.config.a aBA;
    private boolean aBB;
    private d aBC;
    private com.baidu.live.alablmsdk.c.b.a aBF;
    private boolean aBL;
    private BaiduRtcRoom aBt;
    private String aBu;
    private String aBv;
    private String aBw;
    private long aBx;
    private boolean isMute;
    private Context mContext;
    private RtcParameterSettings aBy = RtcParameterSettings.ZA();
    private boolean aBz = false;
    private List<RTCVideoView> aBD = new ArrayList();
    private BLMRtcState aBE = BLMRtcState.DEFAULT;
    private int aBG = 1;
    private boolean aBH = false;
    private final int aBI = 2;
    private int aBJ = 0;
    private int aBK = 0;
    Runnable aBM = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aBL) {
                c.this.fP("没有回调推流成功");
            }
        }
    };
    private Runnable aBN = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.aBu, c.this.aBv, c.this.aBw, c.this.aBx);
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aBF = aVar;
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
                this.aBy.AutoPublish = ((Boolean) obj10).booleanValue();
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aBy.AutoSubScribe = ((Boolean) obj9).booleanValue();
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aBy.VideoMaxkbps = ((Integer) obj8).intValue();
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aBy.VideoMinkbps = ((Integer) obj7).intValue();
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aBy.HasAudio = ((Boolean) obj6).booleanValue();
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aBy.HasVideo = ((Boolean) obj5).booleanValue();
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aBy.VideoFps = ((Integer) obj4).intValue();
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aBy.VideoWidth = ((Integer) obj3).intValue();
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aBy.VideoHeight = ((Integer) obj2).intValue();
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aBz = ((Boolean) obj).booleanValue();
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aBA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aBC = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(List<RTCVideoView> list) {
        this.aBD.clear();
        this.aBD.addAll(list);
    }

    public RTCVideoView[] BL() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBD)) {
            int size = this.aBD.size();
            com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray size = " + size);
            com.baidu.live.alablmsdk.a.c.fJ(" getRTCVideoViewArray size " + size);
            RTCVideoView[] rTCVideoViewArr = new RTCVideoView[size];
            for (int i = 0; i < size; i++) {
                rTCVideoViewArr[i] = this.aBD.get(i);
                com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray array[0] " + rTCVideoViewArr[i]);
            }
            return rTCVideoViewArr;
        }
        com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray return null");
        com.baidu.live.alablmsdk.a.c.fJ(" getRTCVideoViewArray return null");
        return null;
    }

    public void c(String str, String str2, String str3, long j) {
        this.aBG = 1;
        this.aBE = BLMRtcState.DEFAULT;
        this.aBH = false;
        this.aBB = false;
        this.aBu = str;
        this.aBv = str2;
        this.aBw = str3;
        this.aBx = j;
        c(false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final String str2, final String str3, final long j) {
        com.baidu.live.alablmsdk.a.d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean loginRtcRoomWithRoomName;
                if (com.baidu.live.alablmsdk.a.c.isDebug()) {
                    com.baidu.live.alablmsdk.a.c.d(" join rtc Room param: roomId=" + str + " , token=" + str2 + " , appId=" + str3 + " , imUk=" + j);
                }
                com.baidu.live.alablmsdk.a.c.fJ("joinRtcRoomInner");
                c.this.aBE = BLMRtcState.JOINING;
                c.this.aBt = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                if (c.this.aBt == null) {
                    com.baidu.live.alablmsdk.a.c.d(" initWithAppID failed ");
                    com.baidu.live.alablmsdk.a.c.fJ(" initWithAppID failed ");
                    c.this.dB(-1);
                    return;
                }
                if (com.baidu.live.alablmsdk.a.c.isDebug()) {
                    BaiduRtcRoom unused = c.this.aBt;
                    BaiduRtcRoom.du(true);
                } else {
                    BaiduRtcRoom unused2 = c.this.aBt;
                    BaiduRtcRoom.du(false);
                }
                c.this.aBt.a((BaiduRtcRoom.a) c.this);
                c.this.aBt.a((g.d) c.this);
                c.this.aBy.VideoResolution = c.this.BN();
                c.this.aBy.ConnectionTimeoutMs = 5000;
                c.this.aBy.ReadTimeoutMs = 5000;
                if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                    c.this.aBy.AudioFrequency = 16000;
                    c.this.aBy.AudioChannel = 2;
                    c.this.aBy.AudioContentType = 2;
                }
                c.this.aBy.bXM = true;
                c.this.aBy.bXL = true;
                c.this.aBt.a(c.this.aBy, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                if (c.this.aBA != null && !TextUtils.isEmpty(c.this.aBA.aAz)) {
                    c.this.aBt.a(c.this.aBA.aAz, c.this.aBA.aAA, false, c.this.BM(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                }
                RTCVideoView[] BL = c.this.BL();
                if (BL != null) {
                    c.this.aBt.a(BL);
                } else {
                    com.baidu.live.alablmsdk.a.c.d(" setRemoteDisplayGroup array == null ");
                    com.baidu.live.alablmsdk.a.c.fJ(" setRemoteDisplayGroup array == null ");
                }
                if (c.this.aBz) {
                    com.baidu.live.alablmsdk.a.c.d(" 开启外部采集逻辑 ");
                    com.baidu.live.alablmsdk.a.c.fJ(" open external capture ");
                    c.this.aBt.enableExternalVideoCapturer(true);
                    c.this.aBt.a(c.this.aBC);
                }
                if (c.this.aBB) {
                    com.baidu.live.alablmsdk.a.c.d(" isReLogin yes");
                    com.baidu.live.alablmsdk.a.c.fJ(" isReLogin yes");
                    loginRtcRoomWithRoomName = c.this.aBt.a(str, j, "tom", true);
                } else {
                    com.baidu.live.alablmsdk.a.c.d(" isReLogin no");
                    com.baidu.live.alablmsdk.a.c.fJ(" isReLogin no");
                    loginRtcRoomWithRoomName = c.this.aBt.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                }
                com.baidu.live.alablmsdk.a.c.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                com.baidu.live.alablmsdk.a.c.fJ(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                com.baidu.live.alablmsdk.a.c.d(" isMute=" + c.this.isMute);
                com.baidu.live.alablmsdk.a.c.fJ(" isMute " + c.this.isMute);
                c.this.aBt.muteMicphone(c.this.isMute);
                if (c.this.aBF != null && !loginRtcRoomWithRoomName) {
                    com.baidu.live.alablmsdk.a.c.d(" loginRtcRoomWithRoomName fail");
                    com.baidu.live.alablmsdk.a.c.fJ(" loginRtcRoomWithRoomName fail");
                    c.this.dB(-1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BM() {
        return (this.aBA == null || TextUtils.isEmpty(this.aBA.aAB)) ? "" : this.aBA.aAB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BN() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] Zk;
        if (this.aBt != null && (Zk = this.aBt.Zk()) != null) {
            for (BaiduRtcRoom.c cVar : Zk) {
                if (cVar != null) {
                }
            }
        }
    }

    public void W(long j) {
        if (this.aBt != null) {
            this.aBt.aM(j);
        }
    }

    public void aY(boolean z) {
        this.isMute = z;
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" muteMicrophone mute" + z);
            com.baidu.live.alablmsdk.a.c.fJ(" muteMicrophone mute" + z);
            this.aBt.muteMicphone(z);
        }
    }

    public void BO() {
        com.baidu.live.alablmsdk.a.c.d(" rtc closeRoom ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoom ");
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc disbandRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc disbandRoom ");
            this.aBt.Zj();
        }
        BP();
    }

    public void BP() {
        com.baidu.live.alablmsdk.a.c.d(" rtc leaveRoom ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtc leaveRoom ");
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBN);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBM);
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc logoutRtcRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc logoutRtcRoom ");
            this.aBt.logoutRtcRoom();
        }
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc destroy ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc destroy ");
            this.aBt.destroy();
        }
        this.aBE = BLMRtcState.LEAVE;
        this.aBL = false;
        this.aBt = null;
    }

    private void BQ() {
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc closeRoomInner logoutRtcRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoomInner logoutRtcRoom ");
            this.aBt.logoutRtcRoom();
        }
        if (this.aBt != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc closeRoomInner destroy ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoomInner destroy ");
            this.aBt.destroy();
        }
        this.aBt = null;
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onErrorInfoUpdate(int i) {
        com.baidu.live.alablmsdk.a.c.d(" onErrorInfoUpdate=" + i);
        com.baidu.live.alablmsdk.a.c.fJ(" onErrorInfoUpdate " + i);
        dB(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onPeerConnectStateUpdate(int i) {
        com.baidu.live.alablmsdk.a.c.d(" RTC 监听 : onPeerConnectStateUpdate , connecStates = " + i);
        dz(i);
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void l(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        com.baidu.live.alablmsdk.a.c.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        if (i == 106 || i == 107 || i == 300 || i == 301) {
            com.baidu.live.alablmsdk.a.c.fJ("rtc onRoomEventUpdate roomEvents " + i);
            if (this.aBF != null) {
                this.aBF.onRoomEventUpdate(i, j, str);
            }
        }
        com.baidu.live.alablmsdk.a.d.Bi().post(new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.dA(i);
            }
        });
    }

    private void dz(int i) {
        if (i == 2002) {
            com.baidu.live.alablmsdk.a.c.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_FAILED");
        } else if (i == 2001) {
            com.baidu.live.alablmsdk.a.c.d("rtc handlePeerConnectStateUpdate RTC_STATE_SENDING_MEDIA_OK");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i) {
        if (i == 102 || i == 101 || i == 10000 || i == 117 || i == 103) {
            com.baidu.live.alablmsdk.a.c.fJ("rtc onRoomEventUpdate roomEvents " + i);
            dB(i);
        } else if (i == 116) {
            com.baidu.live.alablmsdk.a.c.fJ("rtc onRoomEventUpdate roomEvents " + i);
            BR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(int i) {
        if (com.baidu.live.alablmsdk.a.c.isDebug()) {
            com.baidu.live.alablmsdk.a.c.d("rtcError errEvent = " + i + " mRTCRoomState = " + this.aBE);
        }
        com.baidu.live.alablmsdk.a.c.fJ(" rtcError errEvent " + i);
        if (this.aBE == BLMRtcState.STREAM) {
            this.aBG = 2;
        }
        if (!this.aBL && i == 117) {
            com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBM);
        }
        com.baidu.live.alablmsdk.a.c.d(" mConnectType = " + this.aBG);
        com.baidu.live.alablmsdk.a.c.fJ(" mConnectType " + this.aBG);
        if (this.aBG == 1) {
            c(true, 2000L);
        } else if (this.aBG == 2) {
            c(true, 5000L);
        }
    }

    private void BR() {
        com.baidu.live.alablmsdk.a.c.d(" rtcSuccess ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtcSuccess ");
        if (!this.aBL) {
            this.aBL = true;
        }
        if (this.aBG == 2) {
        }
        this.aBJ = 0;
        this.aBK = 0;
        this.aBH = false;
        this.aBG = 2;
        this.aBE = BLMRtcState.STREAM;
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBN);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBM);
        fO("rtcPublishSuccess");
    }

    private void fO(String str) {
        com.baidu.live.alablmsdk.a.c.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.c.fJ("rtc callback success");
        if (this.aBF != null) {
            this.aBF.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        com.baidu.live.alablmsdk.a.c.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.c.fJ("rtc callback fail " + str);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBM);
        if (this.aBF != null) {
            this.aBF.g(-1, str);
        }
    }

    public void BS() {
        if (com.baidu.live.alablmsdk.a.c.isDebug()) {
            com.baidu.live.alablmsdk.a.c.d("mConnectType =" + this.aBG + " mRTCRoomState = " + this.aBE + " mIsRetrying " + this.aBH);
        }
        com.baidu.live.alablmsdk.a.c.fJ(" reTryRtc ");
        if (this.aBE == BLMRtcState.LEAVE) {
            com.baidu.live.alablmsdk.a.c.d(" reTry Rtc room 的时候，发现 mRTCRoomState==LEAVE， return; ");
            com.baidu.live.alablmsdk.a.c.fJ(" reTry Rtc room mRTCRoomState==LEAVE return ");
        } else if (this.aBH) {
            com.baidu.live.alablmsdk.a.c.d(" reTryRtc 当前正在尝试，return ");
            com.baidu.live.alablmsdk.a.c.fJ(" reTryRtc Is Retrying return ");
        } else if (this.aBG == 1) {
            this.aBJ++;
            if (this.aBJ <= 2) {
                c(true, 2000L);
                com.baidu.live.alablmsdk.a.c.d("init join rtc room , mRTCInitRetryCount=" + this.aBJ);
                com.baidu.live.alablmsdk.a.c.fJ("init join rtc room mRTCInitRetryCount " + this.aBJ);
                return;
            }
            com.baidu.live.alablmsdk.a.c.d("init join rtc room fail. callback");
            com.baidu.live.alablmsdk.a.c.fJ("init join rtc room fail. callback");
            fP(" init join rtc room fail. ");
        } else if (this.aBG == 2) {
            this.aBK++;
            c(true, 2000L);
            com.baidu.live.alablmsdk.a.c.d(" re join rtc room fail. mRTCReTryCount = " + this.aBK);
            com.baidu.live.alablmsdk.a.c.fJ(" re join rtc room fail. mRTCReTryCount " + this.aBK);
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.alablmsdk.a.c.d("joinRtcChat isRetry = " + z + " , delayTime=" + j);
        com.baidu.live.alablmsdk.a.c.fJ("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aBG);
        if (z) {
            this.aBB = z;
            if (!this.aBH && this.aBF != null && this.aBG == 2) {
                this.aBF.dy(2);
            }
            this.aBH = true;
            BQ();
            com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBN);
            if (j < 2000) {
                j = 2000;
            }
            com.baidu.live.alablmsdk.a.d.Bi().postDelayed(this.aBN, j);
            return;
        }
        com.baidu.live.alablmsdk.a.d.Bi().postDelayed(this.aBM, 20000L);
        com.baidu.live.alablmsdk.a.d.Bi().post(this.aBN);
    }

    public void release() {
        com.baidu.live.alablmsdk.a.c.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMRtcRoom release ");
        this.aBF = null;
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBN);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBM);
        com.baidu.live.alablmsdk.module.a fL = com.baidu.live.alablmsdk.module.b.BE().fL(this.aBu);
        UserPermission userPermission = UserPermission.VISITER;
        if (fL != null) {
            userPermission = fL.aBe;
        }
        if (userPermission == UserPermission.OWNER) {
            BO();
        } else {
            BP();
        }
    }
}
