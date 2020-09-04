package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.be;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.j.b {
    private r aAj;
    private d bhA;
    private AudienceLiveGoodsEnterView bhB;
    private AudienceLiveGoodsExplainView bhC;
    private com.baidu.live.sdk.goods.c.a bhD;
    private com.baidu.live.sdk.goods.a.a bhI;
    private String bhJ;
    private PendantParentView bhK;
    private boolean bhL;
    private boolean bhM;
    private com.baidu.live.sdk.goods.guide.a bhN;
    private TbPageContext mTbPageContext;
    private String bhE = "";
    private boolean bhF = false;
    private boolean bhG = false;
    private String bhH = "";
    private boolean bhO = false;
    private c bhP = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aAj != null && a.this.aAj.mLiveInfo != null) {
                long j2 = a.this.aAj.mLiveInfo.room_id;
                String str2 = a.this.aAj.mLiveInfo.feed_id;
                if (a.this.bhB != null) {
                    a.this.bhB.a(j2, str2, j, a.this.bhE, i2, list);
                }
                if (!a.this.bhF && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bhL) {
                    if (a.this.bhN == null) {
                        a.this.bhN = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bhN.MT();
                    }
                    a.this.bhN.setOutClickListener(a.this.bhQ);
                    a.this.bhN.a(a.this.mTbPageContext.getPageActivity(), a.this.bhB, j, j2, str2, a.this.bhE, list);
                }
                if (a.this.bhN != null && i2 < 0) {
                    a.this.bhN.MT();
                }
                if (!a.this.bhF && !a.this.bhG) {
                    a.this.bhG = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bhH) && !str3.equals(a.this.bhH)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bhH, true);
                    }
                    a.this.bhH = str3;
                    long j3 = 10;
                    be beVar = com.baidu.live.w.a.Nk().bkd;
                    if (beVar != null && beVar.aJE != null) {
                        j3 = beVar.aJE.aLz;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bhH, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bhF) {
                                a.this.cl(true);
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
            if (aVar == null || !aVar.Cw()) {
                a.this.t("", false);
            } else if (!aVar.gid.equals(a.this.bhJ)) {
                a.this.bhI = aVar;
                a.this.bhJ = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bhQ = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bhF = true;
            if (!TextUtils.isEmpty(a.this.bhH)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bhH, true);
            }
            a.this.cl(false);
            if (a.this.bhD != null) {
                a.this.bhD.display();
            }
            if (a.this.aAj != null && a.this.aAj.mLiveInfo != null) {
                long j = a.this.aAj.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aAj.mLiveInfo.room_id), String.valueOf(a.this.aAj.mLiveInfo.feed_id), a.this.bhE);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
        }
    };
    private AudienceLiveGoodsExplainView.a bhR = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.gid, true);
        }
    };
    private View.OnClickListener bhS = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.V(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bhA == null) {
            this.bhA = new d(tbPageContext);
        }
        this.bhA.init();
        this.bhA.a(this.bhP);
        this.bhD = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public void a(com.baidu.live.j.c cVar) {
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a KO() {
        if (this.bhB == null) {
            this.bhB = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bhB.setOutClickListener(this.bhQ);
        }
        return this.bhB;
    }

    @Override // com.baidu.live.j.b
    public void S(View view) {
    }

    @Override // com.baidu.live.j.b
    public void bW(boolean z) {
        cl(z);
    }

    @Override // com.baidu.live.j.b
    public void a(r rVar, PendantParentView pendantParentView) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.bhK = pendantParentView;
            this.bhF = false;
            this.bhG = false;
            this.aAj = rVar;
            if (this.bhD != null) {
                this.bhD.MV();
                this.bhD.a(rVar);
            }
            cl(false);
            if (rVar.mLiveInfo != null) {
                b(rVar.mLiveInfo.introducegoods, rVar.mLiveInfo.feed_id, rVar.mLiveInfo.live_id);
            }
        }
    }

    private void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bhA != null) {
                this.bhA.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void i(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.aAj = rVar;
            if (this.bhD != null) {
                this.bhD.a(rVar);
            }
            if (this.bhB != null && this.bhB.getRootLayout() != null && rVar.mLiveInfo != null) {
                if (this.bhB.Ng() != rVar.mLiveInfo.isGoodsListVisible()) {
                    cl(false);
                }
            }
            if (rVar.mLiveInfo != null) {
                if (TextUtils.isEmpty(rVar.mLiveInfo.introducegoods) || "0".equals(rVar.mLiveInfo.introducegoods)) {
                    this.bhO = false;
                    this.bhM = false;
                    this.bhJ = null;
                } else if (rVar.mLiveInfo.introducegoods.equals(this.bhJ)) {
                    this.bhM = false;
                } else {
                    this.bhM = true;
                }
            }
            if (rVar.mLiveInfo != null && this.bhM && rVar.mLiveInfo.isGoodsListVisible()) {
                String str = rVar.mLiveInfo.feed_id;
                long j = rVar.mLiveInfo.live_id;
                this.bhM = false;
                b(rVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bhJ) || (rVar.mLiveInfo != null && !rVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bhJ, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bhD != null) {
            this.bhD.onResume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bhD != null) {
            this.bhD.onPause();
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
                    cl(false);
                    L(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (this.bhA != null && this.aAj != null && this.aAj.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bhE)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bhE);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bhA.a(this.aAj.mLiveInfo.feed_id, this.aAj.mLiveInfo.live_id, false, z, this.aAj.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void L(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aAj != null && this.aAj.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aAj.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bhJ) || !this.bhJ.equals(optString)) {
                        this.bhA.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bhO = false;
                    this.bhJ = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void KP() {
        this.bhL = false;
        if (this.bhA != null) {
            this.bhA.cancelMessage();
        }
        if (this.bhD != null) {
            this.bhD.Fb();
        }
        if (this.bhB != null) {
            this.bhB.release();
        }
        if (this.bhN != null) {
            this.bhN.release();
        }
        if (!TextUtils.isEmpty(this.bhH)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bhH, true);
        }
        t(this.bhJ, false);
        this.bhI = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.bhA != null) {
            this.bhA.cancelLoadData();
            this.bhA.release();
            this.bhA = null;
        }
        if (this.bhD != null) {
            this.bhD.release();
        }
        if (this.bhB != null) {
            this.bhB.release();
        }
        if (this.bhN != null) {
            this.bhN.release();
        }
        this.bhJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bhN != null && this.bhN.isShow()) {
            this.bhN.MT();
        }
        this.bhL = true;
        if (this.bhC == null) {
            this.bhC = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bhC.setOnClickListener(this.bhS);
            this.bhC.setOnCloseBtnClickListener(this.bhR);
            this.bhC.a(this.bhK);
        } else if (this.bhK != null) {
            this.bhC.a(this.bhK);
        }
        this.bhC.f(aVar);
        this.bhC.setVisibility(0);
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

    @Override // com.baidu.live.j.b
    public void gV(String str) {
        this.bhE = str;
    }

    @Override // com.baidu.live.j.b
    public void dz(int i) {
        if (this.bhD != null) {
            this.bhD.dz(i);
        }
        if (this.bhN != null) {
            this.bhN.eD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bhI != null) {
            if (z) {
                this.bhO = true;
                aF(str, "intcardclose");
            }
            if (this.bhC.getVisibility() == 0) {
                this.bhC.setVisibility(8);
                if (this.bhK != null && this.bhC.getParent() != null) {
                    this.bhK.removeView(this.bhC);
                }
                this.bhI = null;
            }
            this.bhL = false;
        }
    }

    private void aF(String str, String str2) {
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
    public void V(View view) {
        r rVar;
        if (this.bhI != null) {
            aF(this.bhI.gid, "intcard_clk");
            be beVar = com.baidu.live.w.a.Nk().bkd;
            if (beVar != null && beVar.aJE != null && (rVar = this.aAj) != null && rVar.mLiveInfo != null) {
                long j = rVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bhE)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bhE);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = rVar.aEf.userId;
                String str4 = rVar.aEf.userName;
                long j3 = rVar.mLiveInfo.group_id;
                long j4 = rVar.aDG.userId;
                String str5 = this.bhI.bix;
                String str6 = this.bhI.biw;
                String str7 = beVar.aJE.appKey;
                String str8 = beVar.aJE.aLC;
                if (str8 == null) {
                    str8 = "";
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(rVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                List<ResolveInfo> list = null;
                PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                if (packageManager != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                boolean z = (list == null || list.isEmpty()) ? false : true;
                boolean z2 = true;
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bhI.platform)) {
                    z2 = false;
                }
                if (z && z2) {
                    intent.addFlags(268435456);
                    this.mTbPageContext.getPageActivity().startActivity(intent);
                } else {
                    SchemeUtils.openScheme(str6, false);
                }
                com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                aVar.a(rVar.mLiveInfo.live_id, j2, str4, j4, j3);
                MessageManager.getInstance().sendMessage(aVar);
            }
        }
    }
}
