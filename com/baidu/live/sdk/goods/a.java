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
    private r aAh;
    private com.baidu.live.sdk.goods.c.a bhA;
    private com.baidu.live.sdk.goods.a.a bhF;
    private String bhG;
    private PendantParentView bhH;
    private boolean bhI;
    private boolean bhJ;
    private com.baidu.live.sdk.goods.guide.a bhK;
    private d bhx;
    private AudienceLiveGoodsEnterView bhy;
    private AudienceLiveGoodsExplainView bhz;
    private TbPageContext mTbPageContext;
    private String bhB = "";
    private boolean bhC = false;
    private boolean bhD = false;
    private String bhE = "";
    private boolean bhL = false;
    private c bhM = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aAh != null && a.this.aAh.mLiveInfo != null) {
                long j2 = a.this.aAh.mLiveInfo.room_id;
                String str2 = a.this.aAh.mLiveInfo.feed_id;
                if (a.this.bhy != null) {
                    a.this.bhy.a(j2, str2, j, a.this.bhB, i2, list);
                }
                if (!a.this.bhC && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bhI) {
                    if (a.this.bhK == null) {
                        a.this.bhK = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bhK.MT();
                    }
                    a.this.bhK.setOutClickListener(a.this.bhN);
                    a.this.bhK.a(a.this.mTbPageContext.getPageActivity(), a.this.bhy, j, j2, str2, a.this.bhB, list);
                }
                if (a.this.bhK != null && i2 < 0) {
                    a.this.bhK.MT();
                }
                if (!a.this.bhC && !a.this.bhD) {
                    a.this.bhD = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bhE) && !str3.equals(a.this.bhE)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bhE, true);
                    }
                    a.this.bhE = str3;
                    long j3 = 10;
                    be beVar = com.baidu.live.w.a.Nk().bka;
                    if (beVar != null && beVar.aJC != null) {
                        j3 = beVar.aJC.aLx;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bhE, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bhC) {
                                a.this.ck(true);
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
            } else if (!aVar.gid.equals(a.this.bhG)) {
                a.this.bhF = aVar;
                a.this.bhG = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bhN = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bhC = true;
            if (!TextUtils.isEmpty(a.this.bhE)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bhE, true);
            }
            a.this.ck(false);
            if (a.this.bhA != null) {
                a.this.bhA.display();
            }
            if (a.this.aAh != null && a.this.aAh.mLiveInfo != null) {
                long j = a.this.aAh.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aAh.mLiveInfo.room_id), String.valueOf(a.this.aAh.mLiveInfo.feed_id), a.this.bhB);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
        }
    };
    private AudienceLiveGoodsExplainView.a bhO = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.gid, true);
        }
    };
    private View.OnClickListener bhP = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.V(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bhx == null) {
            this.bhx = new d(tbPageContext);
        }
        this.bhx.init();
        this.bhx.a(this.bhM);
        this.bhA = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public void a(com.baidu.live.j.c cVar) {
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a KO() {
        if (this.bhy == null) {
            this.bhy = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bhy.setOutClickListener(this.bhN);
        }
        return this.bhy;
    }

    @Override // com.baidu.live.j.b
    public void S(View view) {
    }

    @Override // com.baidu.live.j.b
    public void bW(boolean z) {
        ck(z);
    }

    @Override // com.baidu.live.j.b
    public void a(r rVar, PendantParentView pendantParentView) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.bhH = pendantParentView;
            this.bhC = false;
            this.bhD = false;
            this.aAh = rVar;
            if (this.bhA != null) {
                this.bhA.MV();
                this.bhA.a(rVar);
            }
            ck(false);
            if (rVar.mLiveInfo != null) {
                b(rVar.mLiveInfo.introducegoods, rVar.mLiveInfo.feed_id, rVar.mLiveInfo.live_id);
            }
        }
    }

    private void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bhx != null) {
                this.bhx.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void i(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null) {
            this.aAh = rVar;
            if (this.bhA != null) {
                this.bhA.a(rVar);
            }
            if (this.bhy != null && this.bhy.getRootLayout() != null && rVar.mLiveInfo != null) {
                if (this.bhy.Ng() != rVar.mLiveInfo.isGoodsListVisible()) {
                    ck(false);
                }
            }
            if (rVar.mLiveInfo != null) {
                if (TextUtils.isEmpty(rVar.mLiveInfo.introducegoods) || "0".equals(rVar.mLiveInfo.introducegoods)) {
                    this.bhL = false;
                    this.bhJ = false;
                    this.bhG = null;
                } else if (rVar.mLiveInfo.introducegoods.equals(this.bhG)) {
                    this.bhJ = false;
                } else {
                    this.bhJ = true;
                }
            }
            if (rVar.mLiveInfo != null && this.bhJ && rVar.mLiveInfo.isGoodsListVisible()) {
                String str = rVar.mLiveInfo.feed_id;
                long j = rVar.mLiveInfo.live_id;
                this.bhJ = false;
                b(rVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bhG) || (rVar.mLiveInfo != null && !rVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bhG, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bhA != null) {
            this.bhA.onResume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bhA != null) {
            this.bhA.onPause();
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
                    ck(false);
                    L(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (this.bhx != null && this.aAh != null && this.aAh.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bhB)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bhB);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bhx.a(this.aAh.mLiveInfo.feed_id, this.aAh.mLiveInfo.live_id, false, z, this.aAh.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void L(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aAh != null && this.aAh.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aAh.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bhG) || !this.bhG.equals(optString)) {
                        this.bhx.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bhL = false;
                    this.bhG = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void KP() {
        this.bhI = false;
        if (this.bhx != null) {
            this.bhx.cancelMessage();
        }
        if (this.bhA != null) {
            this.bhA.Fb();
        }
        if (this.bhy != null) {
            this.bhy.release();
        }
        if (this.bhK != null) {
            this.bhK.release();
        }
        if (!TextUtils.isEmpty(this.bhE)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bhE, true);
        }
        t(this.bhG, false);
        this.bhF = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.bhx != null) {
            this.bhx.cancelLoadData();
            this.bhx.release();
            this.bhx = null;
        }
        if (this.bhA != null) {
            this.bhA.release();
        }
        if (this.bhy != null) {
            this.bhy.release();
        }
        if (this.bhK != null) {
            this.bhK.release();
        }
        this.bhG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bhK != null && this.bhK.isShow()) {
            this.bhK.MT();
        }
        this.bhI = true;
        if (this.bhz == null) {
            this.bhz = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bhz.setOnClickListener(this.bhP);
            this.bhz.setOnCloseBtnClickListener(this.bhO);
            this.bhz.a(this.bhH);
        } else if (this.bhH != null) {
            this.bhz.a(this.bhH);
        }
        this.bhz.f(aVar);
        this.bhz.setVisibility(0);
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
    public void gU(String str) {
        this.bhB = str;
    }

    @Override // com.baidu.live.j.b
    public void dz(int i) {
        if (this.bhA != null) {
            this.bhA.dz(i);
        }
        if (this.bhK != null) {
            this.bhK.eD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bhF != null) {
            if (z) {
                this.bhL = true;
                aF(str, "intcardclose");
            }
            if (this.bhz.getVisibility() == 0) {
                this.bhz.setVisibility(8);
                if (this.bhH != null && this.bhz.getParent() != null) {
                    this.bhH.removeView(this.bhz);
                }
                this.bhF = null;
            }
            this.bhI = false;
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
        if (this.bhF != null) {
            aF(this.bhF.gid, "intcard_clk");
            be beVar = com.baidu.live.w.a.Nk().bka;
            if (beVar != null && beVar.aJC != null && (rVar = this.aAh) != null && rVar.mLiveInfo != null) {
                long j = rVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bhB)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bhB);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = rVar.aEd.userId;
                String str4 = rVar.aEd.userName;
                long j3 = rVar.mLiveInfo.group_id;
                long j4 = rVar.aDE.userId;
                String str5 = this.bhF.biu;
                String str6 = this.bhF.bit;
                String str7 = beVar.aJC.appKey;
                String str8 = beVar.aJC.aLA;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bhF.platform)) {
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
