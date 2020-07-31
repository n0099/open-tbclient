package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bc;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.goods.b.d;
import com.baidu.live.sdk.goods.c.c;
import com.baidu.live.sdk.goods.view.AudienceLiveGoodsEnterView;
import com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.j.b {
    private q avf;
    private d bbZ;
    private AudienceLiveGoodsEnterView bca;
    private AudienceLiveGoodsExplainView bcb;
    private c bcc;
    private com.baidu.live.sdk.goods.a.a bch;
    private String bci;
    private PendantParentView bcj;
    private boolean bck;
    private boolean bcl;
    private com.baidu.live.sdk.goods.guide.a bcm;
    private TbPageContext mTbPageContext;
    private String bcd = "";
    private boolean bce = false;
    private boolean bcf = false;
    private String bcg = "";
    private boolean bcn = false;
    private com.baidu.live.sdk.goods.b.c bco = new com.baidu.live.sdk.goods.b.c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, final long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.avf != null && a.this.avf.mLiveInfo != null) {
                long j2 = a.this.avf.mLiveInfo.room_id;
                final String str2 = a.this.avf.mLiveInfo.feed_id;
                if (a.this.bca != null) {
                    a.this.bca.a(j2, str2, j, a.this.bcd, i2, list);
                }
                if (!a.this.bce && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bck) {
                    if (a.this.bcm == null) {
                        a.this.bcm = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bcm.Hb();
                    }
                    a.this.bcm.setOutClickListener(a.this.bcp);
                    a.this.bcm.a(a.this.mTbPageContext.getPageActivity(), a.this.bca, j, j2, str2, a.this.bcd, list);
                }
                if (a.this.bcm != null && i2 < 0) {
                    a.this.bcm.Hb();
                }
                if (!a.this.bce && !a.this.bcf) {
                    a.this.bcf = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bcg) && !str3.equals(a.this.bcg)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bcg, true);
                    }
                    a.this.bcg = str3;
                    long j3 = 10;
                    bc bcVar = com.baidu.live.v.a.Hs().beo;
                    if (bcVar != null && bcVar.aEs != null) {
                        j3 = bcVar.aEs.aGn;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bcg, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bce) {
                                a.this.a(str2, j, false, true, a.this.avf.mLiveInfo.user_id);
                            }
                        }

                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onInterrupt() {
                        }
                    }, (j3 <= 0 ? 10L : j3) * 1000, true);
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.c
        public void c(com.baidu.live.sdk.goods.a.a aVar) {
            if (aVar == null || !aVar.Ha()) {
                a.this.t("", false);
            } else if (!aVar.bcH.equals(a.this.bci)) {
                a.this.bch = aVar;
                a.this.bci = aVar.bcH;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bcp = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bce = true;
            if (!TextUtils.isEmpty(a.this.bcg)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bcg, true);
            }
            if (a.this.bcc != null && a.this.avf != null && a.this.avf.mLiveInfo != null) {
                long j = a.this.avf.mLiveInfo.live_id;
                String valueOf = String.valueOf(a.this.avf.mLiveInfo.feed_id);
                long j2 = a.this.avf.mLiveInfo.room_id;
                String str = a.this.avf.mLiveInfo.cover;
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (a.this.avf.mLiveInfo.session_info != null) {
                    str2 = a.this.avf.mLiveInfo.session_info.flvUrl;
                }
                if (!TextUtils.isEmpty(a.this.bcd)) {
                    try {
                        JSONObject jSONObject = new JSONObject(a.this.bcd);
                        str3 = jSONObject.optString("tab");
                        str4 = jSONObject.optString("tag");
                        str5 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j3 = a.this.avf.ayV.userId;
                long j4 = a.this.avf.mLiveInfo.group_id;
                a.this.bcc.u(com.baidu.live.sdk.goods.d.a.a(valueOf, j + "", j2, false, 1, str, str2, str3, str4, str5, String.valueOf(j3), a.this.avf.ayV.userName, String.valueOf(j4), String.valueOf(a.this.avf.ayC.userId)), false);
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf, a.this.bcd);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bcq = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.bcH, true);
        }
    };
    private View.OnClickListener bcr = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.U(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bbZ == null) {
            this.bbZ = new d(tbPageContext);
        }
        this.bbZ.init();
        this.bbZ.a(this.bco);
        this.bcc = new com.baidu.live.sdk.goods.c.a(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public void a(com.baidu.live.j.c cVar) {
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a Fh() {
        if (this.bca == null) {
            this.bca = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bca.setOutClickListener(this.bcp);
        }
        return this.bca;
    }

    @Override // com.baidu.live.j.b
    public void S(View view) {
    }

    @Override // com.baidu.live.j.b
    public void a(String str, long j, boolean z, boolean z2, long j2) {
        if (this.bbZ != null) {
            this.bbZ.a(str, j, z, z2, j2);
        }
    }

    @Override // com.baidu.live.j.b
    public void a(q qVar, PendantParentView pendantParentView) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.bcj = pendantParentView;
            this.bce = false;
            this.bcf = false;
            this.avf = qVar;
            if (qVar.mLiveInfo != null) {
                String str = qVar.mLiveInfo.feed_id;
                long j = qVar.mLiveInfo.live_id;
                a(str, j, false, false, qVar.mLiveInfo.user_id);
                b(qVar.mLiveInfo.introducegoods, str, j);
            }
        }
    }

    private void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bbZ != null) {
                this.bbZ.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void i(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.avf = qVar;
            if (this.bca != null && this.bca.getRootLayout() != null && qVar.mLiveInfo != null) {
                boolean z = this.bca.Ho() != qVar.mLiveInfo.isGoodsListVisible();
                String str = qVar.mLiveInfo.feed_id;
                long j = qVar.mLiveInfo.live_id;
                if (z) {
                    this.bbZ.a(str, j, false, false, qVar.mLiveInfo.user_id);
                }
            }
            if (qVar.mLiveInfo != null) {
                if (TextUtils.isEmpty(qVar.mLiveInfo.introducegoods) || "0".equals(qVar.mLiveInfo.introducegoods)) {
                    this.bcn = false;
                    this.bcl = false;
                    this.bci = null;
                } else if (qVar.mLiveInfo.introducegoods.equals(this.bci)) {
                    this.bcl = false;
                } else {
                    this.bcl = true;
                }
            }
            if (qVar.mLiveInfo != null && this.bcl && qVar.mLiveInfo.isGoodsListVisible()) {
                String str2 = qVar.mLiveInfo.feed_id;
                long j2 = qVar.mLiveInfo.live_id;
                this.bcl = false;
                b(qVar.mLiveInfo.introducegoods, str2, j2);
            } else if (TextUtils.isEmpty(this.bci) || (qVar.mLiveInfo != null && !qVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bci, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bcc != null) {
            this.bcc.resume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bcc != null) {
            this.bcc.pause();
        }
    }

    @Override // com.baidu.live.j.b
    public void x(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    J(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    private void J(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.avf != null && this.avf.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.avf.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bci) || !this.bci.equals(optString)) {
                        this.bbZ.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bcn = false;
                    this.bci = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void Fi() {
        this.bck = false;
        if (this.bbZ != null) {
            this.bbZ.cancelMessage();
        }
        if (this.bcc != null) {
            this.bcc.release();
        }
        if (this.bca != null) {
            this.bca.release();
        }
        if (this.bcm != null) {
            this.bcm.release();
        }
        if (!TextUtils.isEmpty(this.bcg)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bcg, true);
        }
        t(this.bci, false);
        this.bch = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.bbZ != null) {
            this.bbZ.cancelLoadData();
            this.bbZ.release();
        }
        if (this.bcc != null) {
            this.bcc.release();
        }
        if (this.bca != null) {
            this.bca.release();
        }
        if (this.bcm != null) {
            this.bcm.release();
        }
        this.bci = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bcm != null && this.bcm.isShow()) {
            this.bcm.Hb();
        }
        this.bck = true;
        if (this.bcb == null) {
            this.bcb = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bcb.setOnClickListener(this.bcr);
            this.bcb.setOnCloseBtnClickListener(this.bcq);
            this.bcb.a(this.bcj);
        } else if (this.bcj != null) {
            this.bcb.a(this.bcj);
        }
        this.bcb.d(aVar);
        this.bcb.setVisibility(0);
        b(aVar);
    }

    private void b(com.baidu.live.sdk.goods.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
            jSONObject.put("gid", aVar.bcH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "intcard_show").setContentExt(jSONObject));
    }

    @Override // com.baidu.live.j.b
    public void fz(String str) {
        this.bcd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bch != null) {
            if (z) {
                this.bcn = true;
                aB(str, "intcardclose");
            }
            if (this.bcb.getVisibility() == 0) {
                this.bcb.setVisibility(8);
                if (this.bcj != null && this.bcb.getParent() != null) {
                    this.bcj.removeView(this.bcb);
                }
                this.bch = null;
            }
            this.bck = false;
        }
    }

    private void aB(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
            jSONObject.put("gid", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, str2).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(View view) {
        if (this.bch != null) {
            aB(this.bch.bcH, "intcard_clk");
            bc bcVar = com.baidu.live.v.a.Hs().beo;
            if (bcVar != null && bcVar.aEs != null) {
                q qVar = this.avf;
                if (this.bcc != null && qVar != null && qVar.mLiveInfo != null) {
                    long j = qVar.mLiveInfo.room_id;
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (!TextUtils.isEmpty(this.bcd)) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.bcd);
                            str = jSONObject.optString("tab");
                            str2 = jSONObject.optString("tag");
                            str3 = jSONObject.optString("source");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    long j2 = qVar.ayV.userId;
                    String str4 = qVar.ayV.userName;
                    long j3 = qVar.mLiveInfo.group_id;
                    long j4 = qVar.ayC.userId;
                    String str5 = this.bch.bcV;
                    String str6 = this.bch.bcU;
                    String str7 = bcVar.aEs.appKey;
                    String str8 = bcVar.aEs.aGq;
                    if (str8 == null) {
                        str8 = "";
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(qVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                    List<ResolveInfo> list = null;
                    PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                    if (packageManager != null) {
                        list = packageManager.queryIntentActivities(intent, 0);
                    }
                    boolean z = (list == null || list.isEmpty()) ? false : true;
                    boolean z2 = true;
                    if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bch.platform)) {
                        z2 = false;
                    }
                    if (z && z2) {
                        intent.addFlags(268435456);
                        this.mTbPageContext.getPageActivity().startActivity(intent);
                    } else {
                        SchemeUtils.openScheme(str6);
                    }
                    com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                    aVar.a(qVar.mLiveInfo.live_id, j2, str4, j4, j3);
                    MessageManager.getInstance().sendMessage(aVar);
                }
            }
        }
    }
}
