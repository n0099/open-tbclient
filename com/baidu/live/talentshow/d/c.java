package com.baidu.live.talentshow.d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import com.baidu.ala.dumixar.EGLTextureReader;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private w aES;
    private com.baidu.live.talentshow.components.b.b bvk;
    private String byh;
    private com.baidu.live.talentshow.d.a.b byi;
    private b byl;
    private AlaLiveRecorder bym;
    private boolean isMute;
    private Context mContext;
    private Handler mMainHandler;
    private int byk = d.byz;
    private final com.baidu.live.alablmsdk.c.b byn = new com.baidu.live.alablmsdk.c.b() { // from class: com.baidu.live.talentshow.d.c.3
        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final BLMStreamState bLMStreamState) {
            BdLog.e("BCVideoChat blmsdk  state=" + bLMStreamState + " imuk=" + aVar.aBv);
            if (bLMStreamState == BLMStreamState.BLMSTREAMSTATE_ARRIVAL) {
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(aVar, bLMStreamState);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(final com.baidu.live.alablmsdk.module.rtc.a aVar, final int i) {
            if (aVar != null) {
                BdLog.e("BCVideoChat blmsdk leavedForSeconds imUk=" + aVar.aBv + " sec=" + i + " order " + aVar.order);
                c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b(aVar, i);
                    }
                });
            }
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedRing roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " user=null | ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar, final JSONObject jSONObject) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " user=null ext=" + jSONObject);
            } else {
                BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteCancel roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar, jSONObject);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void a(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteTimeout roomId=" + str + " imUk=" + cVar.aBv);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteAccept roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
            BdLog.e("BCVideoChat blmsdk onRoomReceivedInviteReject roomId=" + str + " imUk=" + cVar.aBv + " ext=" + jSONObject);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void b(String str, com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserJoined roomId=" + str + " imUk=" + cVar.aBv);
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void c(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            BdLog.e("BCVideoChat blmsdk onRoomUserLeaved roomId=" + str + " imUk=" + cVar.aBv);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.g(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void d(final String str, final com.baidu.live.alablmsdk.module.c cVar) {
            if (cVar == null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " user=null  currentuk: " + AccountManager.getUK(c.this.mContext));
            } else {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed roomId=" + str + " imUk=" + cVar.aBv + "  currentuk: " + AccountManager.getUK(c.this.mContext));
            }
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(str, cVar);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fH(final String str) {
            BdLog.e("BCVideoChat blmsdk onRoomClosed roomId=" + str);
            c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.3.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.iq(str);
                }
            });
        }

        @Override // com.baidu.live.alablmsdk.c.b
        public void fI(String str) {
            BdLog.e("BCVideoChat blmsdk onLogReport message=" + str);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("blm_msg", str);
                    jSONObject.put("blm_from", "show_pub_v2");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(com.baidu.live.alablmsdk.a.aAm, com.baidu.live.alablmsdk.a.LOG_TYPE, com.baidu.live.alablmsdk.a.aAn, com.baidu.live.alablmsdk.a.aAo);
                ubcStatisticItem.setContentExt(jSONObject);
                UbcStatisticManager.getInstance().logLMSdkEvent(ubcStatisticItem);
            }
        }
    };
    private com.baidu.live.alablmsdk.b byj = new com.baidu.live.alablmsdk.b(TbadkCoreApplication.getInst());

    public c(Context context) {
        this.mContext = context;
        St();
        BdLog.e("BCVideoChat blmsdk constructor");
    }

    public void b(AlaLiveRecorder alaLiveRecorder) {
        this.bym = alaLiveRecorder;
    }

    public void a(com.baidu.live.talentshow.components.b.b bVar) {
        this.bvk = bVar;
    }

    public void a(b bVar) {
        this.byl = bVar;
    }

    public void s(w wVar) {
        this.aES = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk: chatStatus=" + this.byk + "|chatRoomId=" + str + "|ext=" + jSONObject + "|user=" + cVar);
        if (Sp() && cVar != null) {
            fq(d.byB);
            this.byh = str;
            this.byi = d(cVar);
            if (this.byi.index == -1 && jSONObject != null) {
                this.byi.index = jSONObject.optInt("line", -1);
            }
            if (this.byl != null) {
                this.byl.b(cVar, this.byi.index);
            }
        } else if (So() && cVar != null) {
            JSONObject c = e.c(this.aES, JavaTypesHelper.toInt(cVar.order, -1));
            this.byj.b(str, c, (com.baidu.live.alablmsdk.c.c) null);
            a(com.baidu.live.talentshow.b.c.bxK, str, com.baidu.live.talentshow.b.c.bxX, TbadkCoreApplication.getCurrentAccount(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject) {
        BdLog.e("BCVideoChat blmsdk dealReceivedInviteCancel roomId = " + str + "|currentRoomId = " + this.byh + "|status = " + this.byk + "|ext=" + jSONObject + "|user=" + cVar);
        if (TextUtils.equals(this.byh, str) && Sq()) {
            resetData();
            Sm();
            if (this.byl != null) {
                this.byl.Rg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState) {
        int i;
        if (aVar == null) {
            BdLog.e("BCVideoChat blmsdk stream = null");
            return;
        }
        BdLog.e("BCVideoChat blmsdk " + aVar + "|imUk=" + aVar.aBv + "|order=" + aVar.order + "|status=" + this.byk);
        if (Ss()) {
            try {
                i = Integer.parseInt(aVar.order);
            } catch (NumberFormatException e) {
                i = -1;
            }
            BdLog.e("BCVideoChat blmsdk  order=" + aVar.order + " index=" + i);
            if (this.bvk != null && Build.VERSION.SDK_INT >= 14) {
                TextureView ah = this.byj.Be().ah(aVar.aBv);
                if (ah != null) {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival  renderView=" + ah + "|index=" + i + "|stream.imUk=" + aVar.aBv + "|renderView.surface=" + ah.getSurfaceTexture());
                } else {
                    BdLog.e("blmsdk BCVideoChat AudienceLogic dealRtcStreamArrival renderView==null");
                }
                this.bvk.a(ah, i, aVar.aBv, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.alablmsdk.module.rtc.a aVar, int i) {
        int i2;
        BdLog.e("BCVideoChat blmsdk |sec=" + i);
        if (aVar != null && i >= 15) {
            if (TextUtils.equals("0", aVar.order)) {
                BdLog.e("BCVideoChat blmsdk  host");
                Sh();
            } else if (this.byi != null && TextUtils.equals(aVar.order, this.byi.index + "")) {
                BdLog.e("BCVideoChat blmsdk  currentOrder " + this.byi.index);
                Sh();
            } else {
                BdLog.e("BCVideoChat blmsdk  other");
                if (this.bvk != null) {
                    try {
                        i2 = Integer.parseInt(aVar.order);
                    } catch (NumberFormatException e) {
                        i2 = -1;
                    }
                    this.bvk.fm(i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk |roomId=" + str + "|user=" + cVar);
        if (TextUtils.equals(str, this.byh) && cVar != null) {
            if (cVar.aBv == AccountManager.getUK(this.mContext)) {
                fp(2);
            } else if (this.byi != null && !TextUtils.equals(cVar.order, this.byi.index + "") && this.bvk != null) {
                BdLog.e("BCVideoChat blmsdk onRoomUserKickoffed order = " + cVar.order);
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bvk.fm(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, com.baidu.live.alablmsdk.module.c cVar) {
        int i;
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|user=" + cVar + "|mBIMRoomId=" + this.byh);
        if (this.byh != null && this.byh.equals(str) && cVar != null) {
            BdLog.e("BCVideoChat blmsdk roomId=" + str + " imUk=" + cVar.aBv + " order " + cVar.order);
            if (this.bvk != null) {
                try {
                    i = Integer.parseInt(cVar.order);
                } catch (NumberFormatException e) {
                    i = -1;
                }
                this.bvk.fm(i);
            }
            a(com.baidu.live.talentshow.b.c.bxM, this.byh, null, TbadkCoreApplication.getCurrentAccount(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(String str) {
        BdLog.e("BCVideoChat blmsdk|roomId=" + str + "|mBIMRoomId=" + this.byh);
        if (TextUtils.equals(str, this.byh)) {
            fp(1);
        }
    }

    public void Sf() {
        BdLog.e("BCVideoChat blmsdk acceptChat status=" + this.byk);
        if (Sq()) {
            fq(d.byC);
            this.bvk.Rp();
            Si();
            Sj();
            final JSONObject b = e.b(this.aES, this.byi.index);
            this.byi.ext = b;
            this.byj.aY(this.isMute);
            this.byj.a(this.byh, b, new com.baidu.live.alablmsdk.c.c() { // from class: com.baidu.live.talentshow.d.c.1
                @Override // com.baidu.live.alablmsdk.c.c
                public void f(int i, final int i2, final String str) {
                    c.this.mMainHandler.post(new Runnable() { // from class: com.baidu.live.talentshow.d.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(b, i2, str);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, int i, String str) {
        BdLog.e("BCVideoChat blmsdk |status=" + i + "|msg=" + str + "|ext=" + jSONObject + "|mChatStatus: " + this.byk);
        if (Sr()) {
            if (i == 0) {
                fq(d.byD);
                if (this.byl != null) {
                    this.byl.Rf();
                }
                a(com.baidu.live.talentshow.b.c.bxK, this.byh, com.baidu.live.talentshow.b.c.bxW, TbadkCoreApplication.getCurrentAccount(), jSONObject);
                return;
            }
            if (this.byl != null) {
                this.byl.fh(i);
            }
            Sh();
        }
    }

    public void Sg() {
        BdLog.e("BCVideoChat blmsdk rejectChat mChatStatus=" + this.byk);
        if (Sq() && this.byj != null) {
            JSONObject c = e.c(this.aES, this.byi.index);
            this.byj.b(this.byh, c, (com.baidu.live.alablmsdk.c.c) null);
            a(com.baidu.live.talentshow.b.c.bxK, this.byh, com.baidu.live.talentshow.b.c.bxX, TbadkCoreApplication.getCurrentAccount(), c);
            resetData();
            Sm();
        }
    }

    public void Sh() {
        fp(0);
    }

    public void fp(int i) {
        BdLog.e("BCVideoChat blmsdk mChatStatus " + this.byk + "|code=" + i);
        if (Ss()) {
            JSONObject a2 = e.a(this.aES, this.byi.index);
            if (i != 2) {
                this.byj.c(this.byh, a2, (com.baidu.live.alablmsdk.c.c) null);
            }
            Sk();
            if (this.bvk != null) {
                this.bvk.Ro();
            }
            Sm();
            if (this.byl != null) {
                this.byl.cz(i == 0);
            }
            a(com.baidu.live.talentshow.b.c.bxL, this.byh, null, TbadkCoreApplication.getCurrentAccount(), a2);
            resetData();
            return;
        }
        resetData();
        Sm();
    }

    private void Si() {
        BdLog.e("BCVideoChat blmsdk addRecorderToRtcView");
        if (this.bym != null && this.bym.getPreview() != null && this.bvk != null && this.byi != null) {
            this.bvk.a(this.bym.getPreview(), this.byi.index, 0L, true, true);
            this.bym.startRecord();
        }
    }

    private void Sj() {
        final com.baidu.live.alablmsdk.c.a.a BX = this.byj.Be().BX();
        if (this.bym != null) {
            this.bym.setDefaultCloudRtcMode(new EGLTextureReader.OnPixelReadCallback() { // from class: com.baidu.live.talentshow.d.c.2
                @Override // com.baidu.ala.dumixar.EGLTextureReader.OnPixelReadCallback
                public void onPixelRead(byte[] bArr, int i, int i2) {
                    if (BX != null) {
                        BX.onPixelRead(bArr, i, i2);
                    } else {
                        BdLog.e("BCVideoChat blmsdk capturer=" + BX);
                    }
                }
            });
        }
    }

    private void Sk() {
        BdLog.e("BCVideoChat blmsdk switchNormalLive");
        if (this.bym != null) {
            this.bym.setDefaultCloudRtcMode(null);
        }
    }

    private void a(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (this.byl != null) {
            com.baidu.live.talentshow.b.c cVar = new com.baidu.live.talentshow.b.c();
            cVar.action = str;
            cVar.bxZ = str2;
            cVar.bya = str3;
            cVar.byb = str4;
            cVar.ext = jSONObject;
            this.byl.b(cVar);
        }
    }

    public void setMute(boolean z) {
        BdLog.e("BCVideoChat blmsdk isMute=" + z);
        this.isMute = z;
        if (this.byj != null) {
            this.byj.aY(z);
        }
    }

    private void resetData() {
        this.isMute = false;
        this.byh = null;
        this.byi = null;
    }

    public void Sl() {
        fq(d.byA);
    }

    public void Sm() {
        fq(d.byz);
    }

    private void fq(int i) {
        BdLog.e("BCVideoChat blmsdk updateStatus=" + i + " oldStatus = " + this.byk);
        this.byk = i;
    }

    public int Sn() {
        return this.byk;
    }

    public boolean So() {
        return this.byk == d.byz;
    }

    public boolean Sp() {
        return this.byk == d.byA;
    }

    public boolean Sq() {
        return this.byk == d.byB;
    }

    public boolean Sr() {
        return this.byk == d.byC;
    }

    public boolean Ss() {
        return this.byk == d.byC || this.byk == d.byD;
    }

    private com.baidu.live.talentshow.d.a.b d(com.baidu.live.alablmsdk.module.c cVar) {
        BdLog.e("BCVideoChat blmsdk user=" + cVar.toString());
        com.baidu.live.talentshow.d.a.b bVar = new com.baidu.live.talentshow.d.a.b();
        bVar.index = JavaTypesHelper.toInt(cVar.order, -1);
        bVar.status = d.byz;
        bVar.bzf = cVar.clone();
        return bVar;
    }

    private void St() {
        if (this.byj != null) {
            this.byj.a(this.byn);
            this.mMainHandler = new Handler(Looper.getMainLooper());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("room_mode", d.byE);
            hashMap.put("rtc_room_source_key", d.byy);
            hashMap.put("is_auto_publish", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(10);
            arrayList.add(15);
            hashMap.put("blm_rtc_stream_leaved_listen_seconds_key", arrayList);
            hashMap.put("encode_bitrate", Integer.valueOf(com.baidu.live.aa.a.PQ().bod.aNB.aSn));
            hashMap.put("encode_min_bitrate", Integer.valueOf(com.baidu.live.aa.a.PQ().bod.aNB.aSm));
            hashMap.put("external_audio_capture", true);
            this.byj.v(hashMap);
        }
    }

    public void onDestroy() {
        BdLog.e("BCVideoChat blmsdk onDestroy");
        if (this.mMainHandler != null) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
        }
        if (this.byj != null) {
            this.byj.onRelease();
            this.byj = null;
        }
    }
}
