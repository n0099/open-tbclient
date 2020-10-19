package com.baidu.live.videochat.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.config.enums.BLMRoomMode;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.cf;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements a {
    private u aDU;
    private com.baidu.live.alablmsdk.b bzT;
    private AlaLiveRecorder bzU;
    private f bzV;
    private Handler mMainHandler;
    private com.baidu.live.alablmsdk.module.c bzW = null;
    private com.baidu.live.alablmsdk.module.c bzX = null;
    private JSONObject bzY = null;
    private int bye = c.bzo;
    private String bzZ = null;
    private long bAa = 0;
    private boolean isMute = false;
    private boolean bAb = true;
    private com.baidu.live.alablmsdk.c.c bAc = new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.videochat.d.g.4
        @Override // com.baidu.live.alablmsdk.c.c
        public void e(final int i, final int i2, final String str) {
            BdLog.e("blmsdk:type=" + i + "|status=" + i2 + "|msg=" + str);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i == 2) {
                        g.this.J(i2, str);
                    } else if (i == 4) {
                        g.this.N(i2, str);
                    } else if (i == 5) {
                        g.this.O(i2, str);
                    } else if (i == 7) {
                        g.this.P(i2, str);
                    } else if (i == 8) {
                        g.this.M(i2, str);
                    } else if (i == 3) {
                        g.this.L(i2, str);
                    } else if (i == 6) {
                        g.this.K(i2, str);
                    }
                }
            });
        }
    };
    private com.baidu.live.alablmsdk.c.b bAd = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.videochat.d.g.5
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye + "|streamState=" + bLMStreamState);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.So();
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            BdLog.e("blmsdk:leavedForSeconds sec=" + i + " stream.imUk=" + aVar.aBd);
            g.this.bAb = true;
            if (g.this.bzW != null && g.this.bzW.aBd == aVar.aBd) {
                g.this.bAb = false;
            }
            if (g.this.bzX != null && g.this.bzX.aBd == aVar.aBd) {
                g.this.bAb = false;
            }
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.bzV != null) {
                        g.this.bzV.q(i, g.this.bAb);
                    }
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye + "|mMainHandler=" + g.this.mMainHandler + "|ext=" + str2);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.h(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.4
                @Override // java.lang.Runnable
                public void run() {
                    g.this.i(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.e(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.6
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(final String str, final com.baidu.live.alablmsdk.module.c cVar, final String str2) {
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.7
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(str, cVar, str2);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("blmsdk:chatStatus=" + g.this.bye + "|mMainHandler=" + g.this.mMainHandler);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.8
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("blmsdk:onRoomClosed callback chatStatus=" + g.this.bye);
            g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.5.9
                @Override // java.lang.Runnable
                public void run() {
                    g.this.in(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fI(String str) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.aAh, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.aAi, com.baidu.live.alablmsdk.a.aAj);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };

    @Override // com.baidu.live.videochat.d.a
    public void init(Context context) {
        BdLog.e("blmsdk：LiveBBVideoChatLogicController init context = " + context);
        if (this.bzT == null) {
            this.bzT = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());
            this.bzT.a(this.bAd);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", BLMRoomMode.BLMROOMMODE_1V1);
            hashMap.put("rtc_room_source_key", c.bzn);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(30);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf((int) FeatureCodes.ADVANCE_BEAUTY));
            hashMap.put("encode_min_bitrate", 1100);
            hashMap.put("external_audio_capture", true);
            this.bzT.v(hashMap);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void s(u uVar) {
        this.aDU = uVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(f fVar) {
        this.bzV = fVar;
    }

    @Override // com.baidu.live.videochat.d.a
    public void a(AlaLiveRecorder alaLiveRecorder) {
        if (this.bzU == null) {
            this.bzU = alaLiveRecorder;
            com.baidu.live.alablmsdk.config.a aVar = new com.baidu.live.alablmsdk.config.a();
            aVar.fps = 15;
            aVar.aAu = new com.baidu.live.alablmsdk.config.a.a(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, TbConfig.HEAD_IMG_SIZE);
            aVar.aAA = true;
            aVar.aAz = this.bzU.getPushUrl();
            List<cf.a> list = com.baidu.live.x.a.OS().blo.aLV.dataList;
            cf.a aVar2 = list.get(0) == null ? cf.a.aQy.get(0) : list.get(0);
            com.baidu.live.alablmsdk.config.a.b bVar = new com.baidu.live.alablmsdk.config.a.b(aVar2.x, aVar2.y, aVar2.width, aVar2.height);
            cf.a aVar3 = list.get(1) == null ? cf.a.aQy.get(1) : list.get(1);
            com.baidu.live.alablmsdk.config.a.b bVar2 = new com.baidu.live.alablmsdk.config.a.b(aVar3.x, aVar3.y, aVar3.width, aVar3.height);
            ArrayList arrayList = new ArrayList();
            if ((this.aDU == null || this.aDU.mLiveInfo == null) ? false : this.aDU.mLiveInfo.isPubShow) {
                arrayList.add(bVar2);
                arrayList.add(bVar);
            } else {
                arrayList.add(bVar);
                arrayList.add(bVar2);
            }
            aVar.aAD = arrayList;
            aVar.aAC = new com.baidu.live.alablmsdk.config.a.a(com.baidu.live.x.a.OS().blo.aLV.aQt, com.baidu.live.x.a.OS().blo.aLV.aQu);
            aVar.aAv = FeatureCodes.ADVANCE_BEAUTY;
            aVar.aAB = aVar.Bk();
            com.baidu.live.alablmsdk.a.c.d(" mixTemplate =" + aVar.aAB);
            if (this.bzT != null) {
                this.bzT.a(aVar);
            }
        }
    }

    private void fV(int i) {
        this.bye = i;
    }

    @Override // com.baidu.live.videochat.d.a
    public int Sa() {
        return this.bye;
    }

    private boolean Sk() {
        BdLog.e("mCurInvitedUser=" + this.bzW);
        return this.bzW != null;
    }

    @Override // com.baidu.live.videochat.d.a
    public com.baidu.live.alablmsdk.module.c Si() {
        return this.bzW;
    }

    @Override // com.baidu.live.videochat.d.a
    public void setMute(boolean z) {
        BdLog.e("LogicControllerSetMute " + z);
        this.isMute = z;
        if (this.bzT != null) {
            BdLog.e("LogicControllerSetMute2 " + z);
            this.bzT.aY(z);
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public JSONObject Sj() {
        return this.bzY;
    }

    private String Sl() {
        StringBuilder sb = new StringBuilder();
        if (this.bzY != null) {
            b ab = d.ab(this.bzY);
            sb.append("sender:");
            if (ab.bzl != null) {
                sb.append(ab.bzl.userId);
            }
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append("receiver:");
            if (ab.bzm != null) {
                sb.append(ab.bzm.userId);
            }
            if (this.bzW != null) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("imuk:");
                sb.append(this.bzW.aBd);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("cuid:");
                sb.append(this.bzW.cuid);
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.live.videochat.d.a
    public boolean b(final com.baidu.live.alablmsdk.module.c cVar, final String str) {
        if (cVar == null) {
            BdLog.e("blmsdk:user is null");
            return false;
        }
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|ext=" + str + "|user=" + cVar.toString());
        if (this.bye == c.bzo) {
            fV(c.bzq);
            this.bAa = System.currentTimeMillis();
            Sm();
            this.bzW = cVar;
            this.bzY = d.il(str);
            this.bzT.a(new com.baidu.live.alablmsdk.c.a() { // from class: com.baidu.live.videochat.d.g.1
                @Override // com.baidu.live.alablmsdk.c.a
                public void c(final String str2, final int i, final String str3) {
                    g.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(str2, i, str3, str, cVar);
                        }
                    });
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, String str3, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:createRoom costTime=" + (System.currentTimeMillis() - this.bAa) + "|chatRoomId=" + str + "|status=" + i + "|msg=" + str2 + "|mChatStatus=" + this.bye + "|ext=" + str3);
        this.bAa = System.currentTimeMillis();
        if (this.bye == c.bzq) {
            if (i == 0) {
                this.bzZ = str;
                a(str, str3, cVar);
                return;
            }
            if (this.bzV != null) {
                this.bzV.a(c.bzu, true, i, str2, str, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzu, true);
            }
        }
    }

    private void a(String str, String str2, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|invitedUser=" + cVar + "|chatRoomId=" + str + "|senderExtStr=" + str2);
        if (this.bye == c.bzq) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.add(cVar);
            this.bzT.a(str, arrayList, str2, this.bAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        BdLog.e("blmsdk:inviteUsers costTime=" + (System.currentTimeMillis() - this.bAa) + "|mChatStatus=" + this.bye + "|msg=" + str);
        this.bAa = System.currentTimeMillis();
        if (this.bye == c.bzq) {
            if (i == 0) {
                fV(c.bzr);
                if (this.bzV != null) {
                    this.bzV.Ru();
                    return;
                }
                return;
            }
            this.bzT.d(this.bzZ, d.aL("invite_fail", this.bzZ), this.bAc);
            if (this.bzV != null) {
                this.bzV.a(c.bzv, true, i, str, this.bzZ, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        if (Sk() && this.bye == c.bzr) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bzW);
            this.bzT.b(this.bzZ, arrayList, null, this.bAc);
            this.bzT.d(this.bzZ, d.aL("invite_time_out", str), this.bAc);
            if (this.bzV != null) {
                this.bzV.a(c.bzz, true, c.bzz, "inviteTimeOut", str, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzz, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|chatRoomId=" + str + "|userInfo=" + cVar + "|mChatRoomId=" + this.bzZ + "|isChatSender()=" + Sk() + "|costTime=" + (System.currentTimeMillis() - this.bAa));
        this.bAa = System.currentTimeMillis();
        if (this.bye == c.bzr && this.bzZ != null && this.bzZ.equals(str) && cVar != null && this.bzW != null) {
            BdLog.e("blmsdk:user uk=" + cVar.aBd + "|invite user uk" + this.bzW.aBd);
            if (cVar.aBd == this.bzW.aBd) {
                fV(c.bzs);
                Sn();
                im(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bzW);
            this.bzT.b(this.bzZ, arrayList, null, this.bAc);
            this.bzT.d(this.bzZ, d.aL("user_data_error", str), this.bAc);
            if (this.bzV != null) {
                this.bzV.a(c.bzw, true, c.bzw, "inviteAcceptDataError", str, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzw, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|isChatSender()=" + Sk() + "|chatRoomId=" + str + "|costTime=" + (System.currentTimeMillis() - this.bAa) + "ext=" + str2);
        this.bAa = System.currentTimeMillis();
        if (Sk() && this.bye == c.bzr) {
            this.bzT.d(str, d.aL("invite_reject", str), this.bAc);
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzA, true);
            }
        }
    }

    private void im(String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|costTime=" + (System.currentTimeMillis() - this.bAa));
        this.bAa = System.currentTimeMillis();
        if (this.bye == c.bzs) {
            this.bzT.a(str, this.bAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        BdLog.e("blmsdk:joinRoom costTime=" + (System.currentTimeMillis() - this.bAa) + "|msg=" + str + "|status=" + i + "|mChatStatus=" + this.bye);
        this.bAa = System.currentTimeMillis();
        if (this.bye == c.bzs) {
            if (i == 0) {
                fV(c.bzt);
                if (this.bzV != null) {
                    this.bzV.A(this.bzZ, Sk());
                    return;
                }
                return;
            }
            this.bzT.d(this.bzZ, d.aL("join_fail", this.bzZ), this.bAc);
            Sp();
            if (this.bzV != null) {
                this.bzV.a(c.bzx, true, i, str, this.bzZ, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzx, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
    }

    private void cQ(boolean z) {
        if (this.bye == c.bzq) {
            if (this.bzZ != null) {
                this.bzT.d(this.bzZ, d.aL("closed_by_user_in_create", this.bzZ), this.bAc);
            }
            fV(c.bzo);
            Sm();
            if (z) {
                if (this.bzV != null) {
                    this.bzV.p(c.bzD, true);
                }
            } else if (this.bzV != null) {
                this.bzV.p(c.bzE, true);
            }
        } else if (this.bye == c.bzr) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.bzW);
            this.bzT.b(this.bzZ, arrayList, null, this.bAc);
            this.bzT.d(this.bzZ, d.aL(z ? "closed_by_user_wait_connect" : "closed_by_time_out", this.bzZ), this.bAc);
            fV(c.bzo);
            Sm();
            if (z) {
                if (this.bzV != null) {
                    this.bzV.p(c.bzD, true);
                }
            } else if (this.bzV != null) {
                this.bzV.p(c.bzE, true);
            }
        } else if (this.bye == c.bzs) {
            this.bzT.d(this.bzZ, d.aL("closed_by_user_in_connecting", this.bzZ), this.bAc);
            Sp();
            fV(c.bzo);
            Sm();
            if (z) {
                if (this.bzV != null) {
                    this.bzV.p(c.bzD, true);
                }
            } else if (this.bzV != null) {
                this.bzV.p(c.bzE, true);
            }
        } else if (this.bye == c.bzt) {
            this.bzT.d(this.bzZ, d.aL("closed_by_user", this.bzZ), this.bAc);
            Sp();
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.B(this.bzZ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|chatRoomId=" + str + "|currentRoomId=" + this.bzZ + "|ext=" + str2);
        if (this.bye == c.bzo) {
            this.bzZ = str;
            this.bzX = cVar;
            this.bzY = d.a(d.ik(str2), this.aDU, d.bzQ);
            fV(c.bzp);
            if (this.bzV != null) {
                this.bzV.a(cVar, str2);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void Sh() {
        fV(c.bzo);
        Sm();
    }

    @Override // com.baidu.live.videochat.d.a
    public void Y(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        if (this.bye == c.bzp) {
            fV(c.bzs);
            Sn();
            this.bzT.a(this.bzZ, jSONObject.toString(), this.bAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, String str) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|msg=" + str);
        if (this.bye == c.bzs) {
            if (i == 0) {
                fV(c.bzt);
                if (this.bzV != null) {
                    this.bzV.A(this.bzZ, Sk());
                    return;
                }
                return;
            }
            Sp();
            if (this.bzV != null) {
                this.bzV.a(c.bzy, false, i, str, this.bzZ, Sl());
            }
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzy, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, com.baidu.live.alablmsdk.module.c cVar, String str2) {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        if (this.bye == c.bzp) {
            boolean Sk = Sk();
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.p(c.bzB, Sk);
            }
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public void Z(JSONObject jSONObject) {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        if (this.bye == c.bzp) {
            this.bzT.b(this.bzZ, jSONObject.toString(), this.bAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, String str) {
        fV(c.bzo);
        Sm();
        if (this.bzV != null) {
            this.bzV.p(c.bzE, false);
        }
    }

    private void cR(boolean z) {
        if (this.bye == c.bzs) {
            this.bzT.c(this.bzZ, d.aL(z ? "leave_by_time_out" : "leave_by_user_in_connecting", this.bzZ), this.bAc);
            Sp();
            fV(c.bzo);
            Sm();
            if (z) {
                if (this.bzV != null) {
                    this.bzV.p(c.bzD, false);
                }
            } else if (this.bzV != null) {
                this.bzV.p(c.bzE, false);
            }
        } else if (this.bye == c.bzt) {
            this.bzT.c(this.bzZ, d.aL("leave_by_user", this.bzZ), this.bAc);
            Sp();
            fV(c.bzo);
            Sm();
            if (this.bzV != null) {
                this.bzV.B(this.bzZ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("blmsdk:dealUserLeaved chatStatus=" + this.bye + "isChatSender =" + Sk());
        if (Sk()) {
            if (this.bye == c.bzt) {
                this.bzT.d(str, d.aL("user_leave", str), this.bAc);
                Sp();
                fV(c.bzo);
                Sm();
                if (this.bzV != null) {
                    this.bzV.B(str, false);
                }
            } else if (this.bye == c.bzs) {
                this.bzT.d(str, d.aL("user_leave_in_connecting", str), this.bAc);
                Sp();
                fV(c.bzo);
                Sm();
                if (this.bzV != null) {
                    this.bzV.p(c.bzC, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(String str) {
        BdLog.e("blmsdk:dealRoomClosed chatStatus=" + this.bye + "|chatRoomId=" + str);
        if (!Sk()) {
            if (this.bye == c.bzt) {
                this.bzT.c(this.bzZ, d.aL("room_closed", this.bzZ), this.bAc);
                Sp();
                fV(c.bzo);
                Sm();
                if (this.bzV != null) {
                    this.bzV.B(this.bzZ, false);
                }
            } else if (this.bye == c.bzs) {
                Sp();
                fV(c.bzo);
                Sm();
                if (this.bzV != null) {
                    this.bzV.p(c.bzC, true);
                }
            }
        }
    }

    private void Sm() {
        this.bzW = null;
        this.bzX = null;
        this.bzZ = null;
    }

    @Override // com.baidu.live.videochat.d.a
    public void cP(boolean z) {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|isChatSender()=" + Sk());
        if (Sk()) {
            cQ(z);
        } else {
            cR(z);
        }
    }

    private void Sn() {
        BdLog.e("blmsdk:chatStatus=" + this.bye + "|mAuthorLiveRecorder=" + this.bzU);
        final com.baidu.live.alablmsdk.c.a.a BF = this.bzT.Be().BF();
        if (this.bzU != null) {
            this.bzU.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.videochat.d.g.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (BF == null) {
                        BdLog.e("blmsdk:chatStatus=" + g.this.bye + "|capturer=" + BF);
                    } else {
                        BF.onPixelRead(bArr, i, i2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void So() {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        if (this.bzT != null) {
            com.baidu.live.alablmsdk.a.c.d("StreamArrive" + this.isMute);
            this.bzT.aY(this.isMute);
        }
        if (this.bzV != null) {
            this.bzV.Rv();
        }
    }

    @Override // com.baidu.live.videochat.d.a
    public View getPlayerView() {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        return Sk() ? this.bzT.Be().a(this.bzW) : this.bzT.Be().a(this.bzX);
    }

    private void Sp() {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.videochat.d.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.bzU.setDefaultCloudRtcMode(null);
                g.this.bzU.startPush();
            }
        });
    }

    @Override // com.baidu.live.videochat.d.a
    public void onDestroy() {
        BdLog.e("blmsdk:chatStatus=" + this.bye);
        this.bzU = null;
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.bzT != null) {
            this.bzT.onRelease();
            this.bzT = null;
        }
    }
}
