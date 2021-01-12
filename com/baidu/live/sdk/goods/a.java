package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bq;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.n.b {
    private x aBr;
    private d buO;
    private AudienceLiveGoodsEnterView buP;
    private AudienceLiveGoodsExplainView buQ;
    private com.baidu.live.sdk.goods.c.a buR;
    private com.baidu.live.sdk.goods.a.a buW;
    private String buX;
    private PendantParentView buY;
    private boolean buZ;
    private boolean bva;
    private com.baidu.live.sdk.goods.guide.a bvb;
    private TbPageContext mTbPageContext;
    private String buS = "";
    private boolean buT = false;
    private boolean buU = false;
    private String buV = "";
    private boolean bvc = false;
    private boolean bvd = false;
    private c bve = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                long j2 = a.this.aBr.mLiveInfo.room_id;
                String str2 = a.this.aBr.mLiveInfo.feed_id;
                if (a.this.buP != null) {
                    a.this.buP.a(j2, str2, j, a.this.buS, i2, list);
                }
                if (!a.this.buT && z && i2 > 0 && list != null && list.size() > 0 && !a.this.buZ) {
                    if (a.this.bvb == null) {
                        a.this.bvb = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bvb.Ot();
                    }
                    a.this.bvb.setOutClickListener(a.this.bvf);
                    a.this.bvb.a(a.this.mTbPageContext.getPageActivity(), a.this.buP, j, j2, str2, a.this.buS, list);
                }
                if (a.this.bvb != null && i2 < 0) {
                    a.this.bvb.Ot();
                }
                if (!a.this.buT && !a.this.buU) {
                    a.this.buU = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.buV) && !str3.equals(a.this.buV)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.buV, true);
                    }
                    a.this.buV = str3;
                    long j3 = 10;
                    bq bqVar = com.baidu.live.af.a.OJ().bxp;
                    if (bqVar != null && bqVar.aMS != null) {
                        j3 = bqVar.aMS.aPB;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.buV, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.buT) {
                                a.this.cH(true);
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
            if (aVar == null || !aVar.AH()) {
                a.this.v("", false);
            } else if (!aVar.gid.equals(a.this.buX)) {
                a.this.buW = aVar;
                a.this.buX = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bvf = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.buT = true;
            if (!TextUtils.isEmpty(a.this.buV)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.buV, true);
            }
            a.this.cH(false);
            if (a.this.buR != null) {
                a.this.buR.rV();
            }
            if (a.this.aBr != null && a.this.aBr.mLiveInfo != null) {
                long j = a.this.aBr.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aBr.mLiveInfo.room_id), String.valueOf(a.this.aBr.mLiveInfo.feed_id), a.this.buS);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.buO != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.buO.bwf)) {
                        com.baidu.live.sdk.goods.d.b.N(a.this.mTbPageContext.getPageActivity(), a.this.buO.bwf);
                    }
                } else if (a.this.buO.bwg != null && !a.this.buO.bwg.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.buO.bwg);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bvg = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.v(aVar.gid, true);
        }
    };
    private View.OnClickListener bvh = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.n.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.buO == null) {
            this.buO = new d(tbPageContext);
        }
        this.buO.init();
        this.buO.a(this.bve);
        this.buR = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.n.b
    public void a(com.baidu.live.n.c cVar) {
    }

    @Override // com.baidu.live.n.b
    public com.baidu.live.core.a.a KS() {
        if (this.buP == null) {
            this.buP = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.buP.setOutClickListener(this.bvf);
        }
        return this.buP;
    }

    @Override // com.baidu.live.n.b
    public void U(View view) {
    }

    @Override // com.baidu.live.n.b
    public void a(x xVar, PendantParentView pendantParentView) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.bvd = true;
            this.buY = pendantParentView;
            this.buT = false;
            this.buU = false;
            this.aBr = xVar;
            if (this.buR != null) {
                this.buR.Ov();
                this.buR.a(xVar);
            }
            cH(false);
            if (xVar.mLiveInfo != null) {
                c(xVar.mLiveInfo.introducegoods, xVar.mLiveInfo.feed_id, xVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.buO != null) {
                this.buO.c(str2, j, str);
                return;
            }
            return;
        }
        v("", false);
    }

    @Override // com.baidu.live.n.b
    public void i(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            if (this.bvd) {
                this.bvd = false;
                return;
            }
            this.aBr = xVar;
            if (this.buR != null) {
                this.buR.a(xVar);
            }
            if (this.buP != null && this.buP.getRootLayout() != null && xVar.mLiveInfo != null) {
                if (this.buP.OF() != xVar.mLiveInfo.isGoodsListVisible()) {
                    cH(false);
                }
            }
            q(xVar);
        }
    }

    private void q(x xVar) {
        if (xVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(xVar.mLiveInfo.introducegoods) || "0".equals(xVar.mLiveInfo.introducegoods)) {
                this.bvc = false;
                this.bva = false;
                this.buX = null;
            } else if (xVar.mLiveInfo.introducegoods.equals(this.buX)) {
                this.bva = false;
            } else {
                this.bva = true;
            }
            if (xVar.mLiveInfo != null && this.bva && xVar.mLiveInfo.isGoodsListVisible()) {
                String str = xVar.mLiveInfo.feed_id;
                long j = xVar.mLiveInfo.live_id;
                this.bva = false;
                c(xVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.buX) || (xVar.mLiveInfo != null && !xVar.mLiveInfo.isGoodsListVisible())) {
                v(this.buX, false);
            }
        }
    }

    @Override // com.baidu.live.n.b
    public void onResume() {
        if (this.buR != null) {
            this.buR.onResume();
        }
    }

    @Override // com.baidu.live.n.b
    public void onPause() {
        if (this.buR != null) {
            this.buR.onPause();
        }
    }

    @Override // com.baidu.live.n.b
    public void C(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    cH(false);
                    W(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(boolean z) {
        if (this.buO != null && this.aBr != null && this.aBr.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.buS)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.buS);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.buO.a(this.aBr.mLiveInfo.feed_id, this.aBr.mLiveInfo.live_id, false, z, this.aBr.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void W(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aBr != null && this.aBr.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aBr.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.buX) || !this.buX.equals(optString)) {
                        this.buO.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bvc = false;
                    this.buX = null;
                    v(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.n.b
    public void HJ() {
        this.buZ = false;
        if (this.buO != null) {
            this.buO.cancelMessage();
        }
        if (this.buR != null) {
            this.buR.Ei();
        }
        if (this.buP != null) {
            this.buP.release();
        }
        if (this.bvb != null) {
            this.bvb.release();
        }
        if (!TextUtils.isEmpty(this.buV)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.buV, true);
        }
        v(this.buX, false);
        this.buW = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.n.b
    public void release() {
        if (this.buO != null) {
            this.buO.cancelLoadData();
            this.buO.release();
            this.buO = null;
        }
        if (this.buR != null) {
            this.buR.release();
        }
        if (this.buP != null) {
            this.buP.release();
        }
        if (this.bvb != null) {
            this.bvb.release();
        }
        this.buX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bvb != null && this.bvb.isShow()) {
            this.bvb.Ot();
        }
        this.buZ = true;
        if (this.buQ == null) {
            this.buQ = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.buQ.setOnClickListener(this.bvh);
            this.buQ.setOnCloseBtnClickListener(this.bvg);
            this.buQ.a(this.buY);
        } else if (this.buY != null) {
            this.buQ.a(this.buY);
        }
        this.buQ.f(aVar);
        this.buQ.setVisibility(0);
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

    @Override // com.baidu.live.n.b
    public void gK(String str) {
        this.buS = str;
    }

    @Override // com.baidu.live.n.b
    public void co(int i) {
        if (this.buR != null) {
            this.buR.co(i);
        }
        if (this.bvb != null) {
            this.bvb.cF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        if (this.buW != null) {
            if (z) {
                this.bvc = true;
                aI(str, "intcardclose");
            }
            if (this.buQ.getVisibility() == 0) {
                this.buQ.setVisibility(8);
                if (this.buY != null && this.buQ.getParent() != null) {
                    this.buY.removeView(this.buQ);
                }
                this.buW = null;
            }
            this.buZ = false;
        }
    }

    private void aI(String str, String str2) {
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
        x xVar;
        if (this.buW != null) {
            aI(this.buW.gid, "intcard_clk");
            bq bqVar = com.baidu.live.af.a.OJ().bxp;
            if (bqVar != null && bqVar.aMS != null && (xVar = this.aBr) != null && xVar.mLiveInfo != null) {
                long j = xVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.buS)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.buS);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = xVar.aGd.userId;
                String str4 = xVar.aGd.userName;
                long j3 = xVar.mLiveInfo.group_id;
                long j4 = xVar.aFH.userId;
                String str5 = this.buW.bvJ;
                String str6 = this.buW.bvI;
                String str7 = bqVar.aMS.appKey;
                String str8 = bqVar.aMS.aPE;
                if (str8 == null) {
                    str8 = "";
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(xVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                List<ResolveInfo> list = null;
                PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                if (packageManager != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                boolean z = (list == null || list.isEmpty()) ? false : true;
                boolean z2 = true;
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.buW.platform)) {
                    z2 = false;
                }
                if (z && z2) {
                    intent.addFlags(268435456);
                    this.mTbPageContext.getPageActivity().startActivity(intent);
                } else {
                    SchemeUtils.openScheme(str6, false);
                }
                com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                aVar.a(xVar.mLiveInfo.live_id, j2, str4, j4, j3);
                MessageManager.getInstance().sendMessage(aVar);
            }
        }
    }
}
