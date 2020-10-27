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
    private String aBA;
    private long aBB;
    private com.baidu.live.alablmsdk.config.a aBE;
    private boolean aBF;
    private d aBG;
    private com.baidu.live.alablmsdk.c.b.a aBJ;
    private boolean aBP;
    private String aBy;
    private String aBz;
    private boolean isMute;
    private BaiduRtcRoom mBaiduRtcRoom;
    private Context mContext;
    private RtcParameterSettings aBC = RtcParameterSettings.abt();
    private boolean aBD = false;
    private List<RTCVideoView> aBH = new ArrayList();
    private BLMRtcState aBI = BLMRtcState.DEFAULT;
    private int aBK = 1;
    private boolean aBL = false;
    private final int aBM = 2;
    private int aBN = 0;
    private int aBO = 0;
    Runnable aBQ = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.3
        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.aBP) {
                c.this.fP("没有回调推流成功");
            }
        }
    };
    private Runnable aBR = new Runnable() { // from class: com.baidu.live.alablmsdk.d.c.4
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(c.this.aBy, c.this.aBz, c.this.aBA, c.this.aBB);
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.alablmsdk.c.b.a aVar) {
        this.aBJ = aVar;
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
                this.aBC.AutoPublish = ((Boolean) obj10).booleanValue();
            }
            if (hashMap.containsKey("is_auto_subscribe") && (obj9 = hashMap.get("is_auto_subscribe")) != null) {
                this.aBC.AutoSubScribe = ((Boolean) obj9).booleanValue();
            }
            if (hashMap.containsKey("encode_bitrate") && (obj8 = hashMap.get("encode_bitrate")) != null) {
                this.aBC.VideoMaxkbps = ((Integer) obj8).intValue();
            }
            if (hashMap.containsKey("encode_min_bitrate") && (obj7 = hashMap.get("encode_min_bitrate")) != null) {
                this.aBC.VideoMinkbps = ((Integer) obj7).intValue();
            }
            if (hashMap.containsKey("has_audio") && (obj6 = hashMap.get("has_audio")) != null) {
                this.aBC.HasAudio = ((Boolean) obj6).booleanValue();
            }
            if (hashMap.containsKey("has_video") && (obj5 = hashMap.get("has_video")) != null) {
                this.aBC.HasVideo = ((Boolean) obj5).booleanValue();
            }
            if (hashMap.containsKey("internal_capture_video_frame_rate") && (obj4 = hashMap.get("internal_capture_video_frame_rate")) != null) {
                this.aBC.VideoFps = ((Integer) obj4).intValue();
            }
            if (hashMap.containsKey("internal_capture_video_width") && (obj3 = hashMap.get("internal_capture_video_width")) != null) {
                this.aBC.VideoWidth = ((Integer) obj3).intValue();
            }
            if (hashMap.containsKey("internal_capture_video_height") && (obj2 = hashMap.get("internal_capture_video_height")) != null) {
                this.aBC.VideoHeight = ((Integer) obj2).intValue();
            }
            if (hashMap.containsKey("external_audio_capture") && (obj = hashMap.get("external_audio_capture")) != null) {
                this.aBD = ((Boolean) obj).booleanValue();
            }
        }
    }

    public void a(com.baidu.live.alablmsdk.config.a aVar) {
        this.aBE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(d dVar) {
        this.aBG = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(List<RTCVideoView> list) {
        this.aBH.clear();
        this.aBH.addAll(list);
    }

    public RTCVideoView[] BL() {
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aBH)) {
            int size = this.aBH.size();
            com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray size = " + size);
            com.baidu.live.alablmsdk.a.c.fJ(" getRTCVideoViewArray size " + size);
            RTCVideoView[] rTCVideoViewArr = new RTCVideoView[size];
            for (int i = 0; i < size; i++) {
                rTCVideoViewArr[i] = this.aBH.get(i);
                com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray array[0] " + rTCVideoViewArr[i]);
            }
            return rTCVideoViewArr;
        }
        com.baidu.live.alablmsdk.a.c.d(" getRTCVideoViewArray return null");
        com.baidu.live.alablmsdk.a.c.fJ(" getRTCVideoViewArray return null");
        return null;
    }

    public void c(String str, String str2, String str3, long j) {
        this.aBK = 1;
        this.aBI = BLMRtcState.DEFAULT;
        this.aBL = false;
        this.aBF = false;
        this.aBy = str;
        this.aBz = str2;
        this.aBA = str3;
        this.aBB = j;
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
                c.this.aBI = BLMRtcState.JOINING;
                c.this.mBaiduRtcRoom = BaiduRtcRoom.p(c.this.mContext, str3, str2);
                if (c.this.mBaiduRtcRoom == null) {
                    com.baidu.live.alablmsdk.a.c.d(" initWithAppID failed ");
                    com.baidu.live.alablmsdk.a.c.fJ(" initWithAppID failed ");
                    c.this.dB(-1);
                    return;
                }
                if (com.baidu.live.alablmsdk.a.c.isDebug()) {
                    BaiduRtcRoom unused = c.this.mBaiduRtcRoom;
                    BaiduRtcRoom.dI(true);
                } else {
                    BaiduRtcRoom unused2 = c.this.mBaiduRtcRoom;
                    BaiduRtcRoom.dI(false);
                }
                c.this.mBaiduRtcRoom.a((BaiduRtcRoom.a) c.this);
                c.this.mBaiduRtcRoom.a((g.d) c.this);
                c.this.aBC.VideoResolution = c.this.BN();
                c.this.aBC.ConnectionTimeoutMs = 5000;
                c.this.aBC.ReadTimeoutMs = 5000;
                if (Build.MANUFACTURER.contains("Ainemo") || Build.MODEL.contains("NV6001") || Build.MODEL.contains("NV6101") || Build.MODEL.contains("NV2001") || Build.MODEL.contains("NV5001")) {
                    c.this.aBC.AudioFrequency = 16000;
                    c.this.aBC.AudioChannel = 2;
                    c.this.aBC.AudioContentType = 2;
                }
                c.this.aBC.cgl = true;
                c.this.aBC.cgk = true;
                c.this.mBaiduRtcRoom.a(c.this.aBC, RtcParameterSettings.RtcParamSettingType.RTC_PARAM_SETTINGS_ALL);
                if (c.this.aBE != null && !TextUtils.isEmpty(c.this.aBE.aAE)) {
                    c.this.mBaiduRtcRoom.a(c.this.aBE.aAE, c.this.aBE.aAF, false, c.this.BM(), BaiduRtcRoom.RtcLiveTransferMode.RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION);
                }
                RTCVideoView[] BL = c.this.BL();
                if (BL != null) {
                    c.this.mBaiduRtcRoom.a(BL);
                } else {
                    com.baidu.live.alablmsdk.a.c.d(" setRemoteDisplayGroup array == null ");
                    com.baidu.live.alablmsdk.a.c.fJ(" setRemoteDisplayGroup array == null ");
                }
                if (c.this.aBD) {
                    com.baidu.live.alablmsdk.a.c.d(" 开启外部采集逻辑 ");
                    com.baidu.live.alablmsdk.a.c.fJ(" open external capture ");
                    c.this.mBaiduRtcRoom.enableExternalVideoCapturer(true);
                    c.this.mBaiduRtcRoom.a(c.this.aBG);
                }
                if (c.this.aBF) {
                    com.baidu.live.alablmsdk.a.c.d(" isReLogin yes");
                    com.baidu.live.alablmsdk.a.c.fJ(" isReLogin yes");
                    loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true);
                } else {
                    com.baidu.live.alablmsdk.a.c.d(" isReLogin no");
                    com.baidu.live.alablmsdk.a.c.fJ(" isReLogin no");
                    loginRtcRoomWithRoomName = c.this.mBaiduRtcRoom.loginRtcRoomWithRoomName(str, j, "tom", true, true);
                }
                com.baidu.live.alablmsdk.a.c.d(" loginRtcRoomWithRoomName isLoginSuccess=" + loginRtcRoomWithRoomName);
                com.baidu.live.alablmsdk.a.c.fJ(" loginRtcRoomWithRoomName isLoginSuccess " + loginRtcRoomWithRoomName);
                com.baidu.live.alablmsdk.a.c.d(" isMute=" + c.this.isMute);
                com.baidu.live.alablmsdk.a.c.fJ(" isMute " + c.this.isMute);
                c.this.mBaiduRtcRoom.muteMicphone(c.this.isMute);
                if (c.this.aBJ != null && !loginRtcRoomWithRoomName) {
                    com.baidu.live.alablmsdk.a.c.d(" loginRtcRoomWithRoomName fail");
                    com.baidu.live.alablmsdk.a.c.fJ(" loginRtcRoomWithRoomName fail");
                    c.this.dB(-1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BM() {
        return (this.aBE == null || TextUtils.isEmpty(this.aBE.aAG)) ? "" : this.aBE.aAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BN() {
        return "540x960";
    }

    @Override // com.baidu.rtc.g.d
    public void a(g gVar) {
        BaiduRtcRoom.c[] abc;
        if (this.mBaiduRtcRoom != null && (abc = this.mBaiduRtcRoom.abc()) != null) {
            for (BaiduRtcRoom.c cVar : abc) {
                if (cVar != null) {
                }
            }
        }
    }

    public void W(long j) {
        if (this.mBaiduRtcRoom != null) {
            this.mBaiduRtcRoom.aO(j);
        }
    }

    public void aY(boolean z) {
        this.isMute = z;
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" muteMicrophone mute" + z);
            com.baidu.live.alablmsdk.a.c.fJ(" muteMicrophone mute" + z);
            this.mBaiduRtcRoom.muteMicphone(z);
        }
    }

    public void BO() {
        com.baidu.live.alablmsdk.a.c.d(" rtc closeRoom ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoom ");
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc disbandRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc disbandRoom ");
            this.mBaiduRtcRoom.disbandRoom();
        }
        BP();
    }

    public void BP() {
        com.baidu.live.alablmsdk.a.c.d(" rtc leaveRoom ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtc leaveRoom ");
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBR);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBQ);
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc logoutRtcRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc logoutRtcRoom ");
            this.mBaiduRtcRoom.logoutRtcRoom();
        }
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc destroy ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc destroy ");
            this.mBaiduRtcRoom.destroy();
        }
        this.aBI = BLMRtcState.LEAVE;
        this.aBP = false;
        this.mBaiduRtcRoom = null;
    }

    private void BQ() {
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc closeRoomInner logoutRtcRoom ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoomInner logoutRtcRoom ");
            this.mBaiduRtcRoom.logoutRtcRoom();
        }
        if (this.mBaiduRtcRoom != null) {
            com.baidu.live.alablmsdk.a.c.d(" rtc closeRoomInner destroy ");
            com.baidu.live.alablmsdk.a.c.fJ(" rtc closeRoomInner destroy ");
            this.mBaiduRtcRoom.destroy();
        }
        this.mBaiduRtcRoom = null;
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
    public void onRoomDataMessage(ByteBuffer byteBuffer) {
    }

    @Override // com.baidu.rtc.BaiduRtcRoom.a
    public void onRoomEventUpdate(final int i, long j, String str) {
        com.baidu.live.alablmsdk.a.c.d(" RTC 监听 : onRoomEventUpdate roomEvents = " + i + " , data = " + j + " , extra_info = " + str);
        if (i == 106 || i == 107 || i == 300 || i == 301) {
            com.baidu.live.alablmsdk.a.c.fJ("rtc onRoomEventUpdate roomEvents " + i);
            if (this.aBJ != null) {
                this.aBJ.onRoomEventUpdate(i, j, str);
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
            com.baidu.live.alablmsdk.a.c.d("rtcError errEvent = " + i + " mRTCRoomState = " + this.aBI);
        }
        com.baidu.live.alablmsdk.a.c.fJ(" rtcError errEvent " + i);
        if (this.aBI == BLMRtcState.STREAM) {
            this.aBK = 2;
        }
        if (!this.aBP && i == 117) {
            com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBQ);
        }
        com.baidu.live.alablmsdk.a.c.d(" mConnectType = " + this.aBK);
        com.baidu.live.alablmsdk.a.c.fJ(" mConnectType " + this.aBK);
        if (this.aBK == 1) {
            c(true, 2000L);
        } else if (this.aBK == 2) {
            c(true, 5000L);
        }
    }

    private void BR() {
        com.baidu.live.alablmsdk.a.c.d(" rtcSuccess ");
        com.baidu.live.alablmsdk.a.c.fJ(" rtcSuccess ");
        if (!this.aBP) {
            this.aBP = true;
        }
        if (this.aBK == 2) {
        }
        this.aBN = 0;
        this.aBO = 0;
        this.aBL = false;
        this.aBK = 2;
        this.aBI = BLMRtcState.STREAM;
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBR);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBQ);
        fO("rtcPublishSuccess");
    }

    private void fO(String str) {
        com.baidu.live.alablmsdk.a.c.d("rtc 成功回调");
        com.baidu.live.alablmsdk.a.c.fJ("rtc callback success");
        if (this.aBJ != null) {
            this.aBJ.g(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        com.baidu.live.alablmsdk.a.c.d("rtc 失败回调" + str);
        com.baidu.live.alablmsdk.a.c.fJ("rtc callback fail " + str);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBQ);
        if (this.aBJ != null) {
            this.aBJ.g(-1, str);
        }
    }

    public void BS() {
        if (com.baidu.live.alablmsdk.a.c.isDebug()) {
            com.baidu.live.alablmsdk.a.c.d("mConnectType =" + this.aBK + " mRTCRoomState = " + this.aBI + " mIsRetrying " + this.aBL);
        }
        com.baidu.live.alablmsdk.a.c.fJ(" reTryRtc ");
        if (this.aBI == BLMRtcState.LEAVE) {
            com.baidu.live.alablmsdk.a.c.d(" reTry Rtc room 的时候，发现 mRTCRoomState==LEAVE， return; ");
            com.baidu.live.alablmsdk.a.c.fJ(" reTry Rtc room mRTCRoomState==LEAVE return ");
        } else if (this.aBL) {
            com.baidu.live.alablmsdk.a.c.d(" reTryRtc 当前正在尝试，return ");
            com.baidu.live.alablmsdk.a.c.fJ(" reTryRtc Is Retrying return ");
        } else if (this.aBK == 1) {
            this.aBN++;
            if (this.aBN <= 2) {
                c(true, 2000L);
                com.baidu.live.alablmsdk.a.c.d("init join rtc room , mRTCInitRetryCount=" + this.aBN);
                com.baidu.live.alablmsdk.a.c.fJ("init join rtc room mRTCInitRetryCount " + this.aBN);
                return;
            }
            com.baidu.live.alablmsdk.a.c.d("init join rtc room fail. callback");
            com.baidu.live.alablmsdk.a.c.fJ("init join rtc room fail. callback");
            fP(" init join rtc room fail. ");
        } else if (this.aBK == 2) {
            this.aBO++;
            c(true, 2000L);
            com.baidu.live.alablmsdk.a.c.d(" re join rtc room fail. mRTCReTryCount = " + this.aBO);
            com.baidu.live.alablmsdk.a.c.fJ(" re join rtc room fail. mRTCReTryCount " + this.aBO);
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.alablmsdk.a.c.d("joinRtcChat isRetry = " + z + " , delayTime=" + j);
        com.baidu.live.alablmsdk.a.c.fJ("joinRtcChat isRetry " + z + " delayTime " + j + " mConnectType " + this.aBK);
        if (z) {
            this.aBF = z;
            if (!this.aBL && this.aBJ != null && this.aBK == 2) {
                this.aBJ.dy(2);
            }
            this.aBL = true;
            BQ();
            com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBR);
            if (j < 2000) {
                j = 2000;
            }
            com.baidu.live.alablmsdk.a.d.Bi().postDelayed(this.aBR, j);
            return;
        }
        com.baidu.live.alablmsdk.a.d.Bi().postDelayed(this.aBQ, 20000L);
        com.baidu.live.alablmsdk.a.d.Bi().post(this.aBR);
    }

    public void release() {
        com.baidu.live.alablmsdk.a.c.d(" BLMRtcRoom release ");
        com.baidu.live.alablmsdk.a.c.fJ(" BLMRtcRoom release ");
        this.aBJ = null;
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBR);
        com.baidu.live.alablmsdk.a.d.Bi().removeCallbacks(this.aBQ);
        com.baidu.live.alablmsdk.module.a fL = com.baidu.live.alablmsdk.module.b.BE().fL(this.aBy);
        UserPermission userPermission = UserPermission.VISITER;
        if (fL != null) {
            userPermission = fL.aBj;
        }
        if (userPermission == UserPermission.OWNER) {
            BO();
        } else {
            BP();
        }
    }
}
