package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.goods.b.c;
import com.baidu.live.sdk.goods.b.d;
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
public class a implements com.baidu.live.k.b {
    private w aEc;
    private d bpW;
    private AudienceLiveGoodsEnterView bpX;
    private AudienceLiveGoodsExplainView bpY;
    private com.baidu.live.sdk.goods.c.a bpZ;
    private com.baidu.live.sdk.goods.a.a bqe;
    private String bqf;
    private PendantParentView bqg;
    private boolean bqh;
    private boolean bqi;
    private com.baidu.live.sdk.goods.guide.a bqj;
    private TbPageContext mTbPageContext;
    private String bqa = "";
    private boolean bqb = false;
    private boolean bqc = false;
    private String bqd = "";
    private boolean bqk = false;
    private boolean bql = false;
    private c bqm = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                long j2 = a.this.aEc.mLiveInfo.room_id;
                String str2 = a.this.aEc.mLiveInfo.feed_id;
                if (a.this.bpX != null) {
                    a.this.bpX.a(j2, str2, j, a.this.bqa, i2, list);
                }
                if (!a.this.bqb && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bqh) {
                    if (a.this.bqj == null) {
                        a.this.bqj = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bqj.Pa();
                    }
                    a.this.bqj.setOutClickListener(a.this.bqn);
                    a.this.bqj.a(a.this.mTbPageContext.getPageActivity(), a.this.bpX, j, j2, str2, a.this.bqa, list);
                }
                if (a.this.bqj != null && i2 < 0) {
                    a.this.bqj.Pa();
                }
                if (!a.this.bqb && !a.this.bqc) {
                    a.this.bqc = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bqd) && !str3.equals(a.this.bqd)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bqd, true);
                    }
                    a.this.bqd = str3;
                    long j3 = 10;
                    bm bmVar = com.baidu.live.z.a.Pq().bsy;
                    if (bmVar != null && bmVar.aOE != null) {
                        j3 = bmVar.aOE.aQX;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bqd, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bqb) {
                                a.this.cr(true);
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
            if (aVar == null || !aVar.DR()) {
                a.this.u("", false);
            } else if (!aVar.gid.equals(a.this.bqf)) {
                a.this.bqe = aVar;
                a.this.bqf = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bqn = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bqb = true;
            if (!TextUtils.isEmpty(a.this.bqd)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bqd, true);
            }
            a.this.cr(false);
            if (a.this.bpZ != null) {
                a.this.bpZ.display();
            }
            if (a.this.aEc != null && a.this.aEc.mLiveInfo != null) {
                long j = a.this.aEc.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aEc.mLiveInfo.room_id), String.valueOf(a.this.aEc.mLiveInfo.feed_id), a.this.bqa);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.bpW != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.bpW.brn)) {
                        com.baidu.live.sdk.goods.d.b.I(a.this.mTbPageContext.getPageActivity(), a.this.bpW.brn);
                    }
                } else if (a.this.bpW.bro != null && !a.this.bpW.bro.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.bpW.bro);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bqo = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.u(aVar.gid, true);
        }
    };
    private View.OnClickListener bqp = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.k.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bpW == null) {
            this.bpW = new d(tbPageContext);
        }
        this.bpW.init();
        this.bpW.a(this.bqm);
        this.bpZ = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.k.b
    public void a(com.baidu.live.k.c cVar) {
    }

    @Override // com.baidu.live.k.b
    public com.baidu.live.core.a.a MT() {
        if (this.bpX == null) {
            this.bpX = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bpX.setOutClickListener(this.bqn);
        }
        return this.bpX;
    }

    @Override // com.baidu.live.k.b
    public void U(View view) {
    }

    @Override // com.baidu.live.k.b
    public void a(w wVar, PendantParentView pendantParentView) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.bql = true;
            this.bqg = pendantParentView;
            this.bqb = false;
            this.bqc = false;
            this.aEc = wVar;
            if (this.bpZ != null) {
                this.bpZ.Pc();
                this.bpZ.a(wVar);
            }
            cr(false);
            if (wVar.mLiveInfo != null) {
                c(wVar.mLiveInfo.introducegoods, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bpW != null) {
                this.bpW.c(str2, j, str);
                return;
            }
            return;
        }
        u("", false);
    }

    @Override // com.baidu.live.k.b
    public void i(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            if (this.bql) {
                this.bql = false;
                return;
            }
            this.aEc = wVar;
            if (this.bpZ != null) {
                this.bpZ.a(wVar);
            }
            if (this.bpX != null && this.bpX.getRootLayout() != null && wVar.mLiveInfo != null) {
                if (this.bpX.Pm() != wVar.mLiveInfo.isGoodsListVisible()) {
                    cr(false);
                }
            }
            q(wVar);
        }
    }

    private void q(w wVar) {
        if (wVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(wVar.mLiveInfo.introducegoods) || "0".equals(wVar.mLiveInfo.introducegoods)) {
                this.bqk = false;
                this.bqi = false;
                this.bqf = null;
            } else if (wVar.mLiveInfo.introducegoods.equals(this.bqf)) {
                this.bqi = false;
            } else {
                this.bqi = true;
            }
            if (wVar.mLiveInfo != null && this.bqi && wVar.mLiveInfo.isGoodsListVisible()) {
                String str = wVar.mLiveInfo.feed_id;
                long j = wVar.mLiveInfo.live_id;
                this.bqi = false;
                c(wVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bqf) || (wVar.mLiveInfo != null && !wVar.mLiveInfo.isGoodsListVisible())) {
                u(this.bqf, false);
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void onResume() {
        if (this.bpZ != null) {
            this.bpZ.onResume();
        }
    }

    @Override // com.baidu.live.k.b
    public void onPause() {
        if (this.bpZ != null) {
            this.bpZ.onPause();
        }
    }

    @Override // com.baidu.live.k.b
    public void y(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    cr(false);
                    P(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(boolean z) {
        if (this.bpW != null && this.aEc != null && this.aEc.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bqa)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bqa);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bpW.a(this.aEc.mLiveInfo.feed_id, this.aEc.mLiveInfo.live_id, false, z, this.aEc.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void P(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aEc != null && this.aEc.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aEc.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bqf) || !this.bqf.equals(optString)) {
                        this.bpW.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bqk = false;
                    this.bqf = null;
                    u(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void Kn() {
        this.bqh = false;
        if (this.bpW != null) {
            this.bpW.cancelMessage();
        }
        if (this.bpZ != null) {
            this.bpZ.GS();
        }
        if (this.bpX != null) {
            this.bpX.release();
        }
        if (this.bqj != null) {
            this.bqj.release();
        }
        if (!TextUtils.isEmpty(this.bqd)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bqd, true);
        }
        u(this.bqf, false);
        this.bqe = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.k.b
    public void release() {
        if (this.bpW != null) {
            this.bpW.cancelLoadData();
            this.bpW.release();
            this.bpW = null;
        }
        if (this.bpZ != null) {
            this.bpZ.release();
        }
        if (this.bpX != null) {
            this.bpX.release();
        }
        if (this.bqj != null) {
            this.bqj.release();
        }
        this.bqf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bqj != null && this.bqj.isShow()) {
            this.bqj.Pa();
        }
        this.bqh = true;
        if (this.bpY == null) {
            this.bpY = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bpY.setOnClickListener(this.bqp);
            this.bpY.setOnCloseBtnClickListener(this.bqo);
            this.bpY.a(this.bqg);
        } else if (this.bqg != null) {
            this.bpY.a(this.bqg);
        }
        this.bpY.f(aVar);
        this.bpY.setVisibility(0);
        b(aVar);
    }

    private void b(com.baidu.live.sdk.goods.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
            jSONObject.put("gid", aVar.gid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "intcard_show").setContentExt(jSONObject));
    }

    @Override // com.baidu.live.k.b
    public void hG(String str) {
        this.bqa = str;
    }

    @Override // com.baidu.live.k.b
    public void dI(int i) {
        if (this.bpZ != null) {
            this.bpZ.dI(i);
        }
        if (this.bqj != null) {
            this.bqj.dX(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        if (this.bqe != null) {
            if (z) {
                this.bqk = true;
                aK(str, "intcardclose");
            }
            if (this.bpY.getVisibility() == 0) {
                this.bpY.setVisibility(8);
                if (this.bqg != null && this.bpY.getParent() != null) {
                    this.bqg.removeView(this.bpY);
                }
                this.bqe = null;
            }
            this.bqh = false;
        }
    }

    private void aK(String str, String str2) {
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
    public void X(View view) {
        w wVar;
        if (this.bqe != null) {
            aK(this.bqe.gid, "intcard_clk");
            bm bmVar = com.baidu.live.z.a.Pq().bsy;
            if (bmVar != null && bmVar.aOE != null && (wVar = this.aEc) != null && wVar.mLiveInfo != null) {
                long j = wVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bqa)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bqa);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = wVar.aIA.userId;
                String str4 = wVar.aIA.userName;
                long j3 = wVar.mLiveInfo.group_id;
                long j4 = wVar.aIe.userId;
                String str5 = this.bqe.bqR;
                String str6 = this.bqe.bqQ;
                String str7 = bmVar.aOE.appKey;
                String str8 = bmVar.aOE.aRa;
                if (str8 == null) {
                    str8 = "";
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(wVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                List<ResolveInfo> list = null;
                PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                if (packageManager != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                boolean z = (list == null || list.isEmpty()) ? false : true;
                boolean z2 = true;
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bqe.platform)) {
                    z2 = false;
                }
                if (z && z2) {
                    intent.addFlags(268435456);
                    this.mTbPageContext.getPageActivity().startActivity(intent);
                } else {
                    SchemeUtils.openScheme(str6, false);
                }
                com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                aVar.a(wVar.mLiveInfo.live_id, j2, str4, j4, j3);
                MessageManager.getInstance().sendMessage(aVar);
            }
        }
    }
}
