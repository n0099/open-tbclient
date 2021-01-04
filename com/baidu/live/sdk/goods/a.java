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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.n.b {
    private x aGe;
    private d bzA;
    private AudienceLiveGoodsEnterView bzB;
    private AudienceLiveGoodsExplainView bzC;
    private com.baidu.live.sdk.goods.c.a bzD;
    private com.baidu.live.sdk.goods.a.a bzI;
    private String bzJ;
    private PendantParentView bzK;
    private boolean bzL;
    private boolean bzM;
    private com.baidu.live.sdk.goods.guide.a bzN;
    private TbPageContext mTbPageContext;
    private String bzE = "";
    private boolean bzF = false;
    private boolean bzG = false;
    private String bzH = "";
    private boolean bzO = false;
    private boolean bzP = false;
    private c bzQ = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                long j2 = a.this.aGe.mLiveInfo.room_id;
                String str2 = a.this.aGe.mLiveInfo.feed_id;
                if (a.this.bzB != null) {
                    a.this.bzB.a(j2, str2, j, a.this.bzE, i2, list);
                }
                if (!a.this.bzF && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bzL) {
                    if (a.this.bzN == null) {
                        a.this.bzN = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bzN.So();
                    }
                    a.this.bzN.setOutClickListener(a.this.bzR);
                    a.this.bzN.a(a.this.mTbPageContext.getPageActivity(), a.this.bzB, j, j2, str2, a.this.bzE, list);
                }
                if (a.this.bzN != null && i2 < 0) {
                    a.this.bzN.So();
                }
                if (!a.this.bzF && !a.this.bzG) {
                    a.this.bzG = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bzH) && !str3.equals(a.this.bzH)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bzH, true);
                    }
                    a.this.bzH = str3;
                    long j3 = 10;
                    bq bqVar = com.baidu.live.af.a.SE().bCb;
                    if (bqVar != null && bqVar.aRF != null) {
                        j3 = bqVar.aRF.aUo;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bzH, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bzF) {
                                a.this.cL(true);
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
            if (aVar == null || !aVar.EC()) {
                a.this.v("", false);
            } else if (!aVar.gid.equals(a.this.bzJ)) {
                a.this.bzI = aVar;
                a.this.bzJ = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bzR = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bzF = true;
            if (!TextUtils.isEmpty(a.this.bzH)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bzH, true);
            }
            a.this.cL(false);
            if (a.this.bzD != null) {
                a.this.bzD.rV();
            }
            if (a.this.aGe != null && a.this.aGe.mLiveInfo != null) {
                long j = a.this.aGe.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aGe.mLiveInfo.room_id), String.valueOf(a.this.aGe.mLiveInfo.feed_id), a.this.bzE);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.bzA != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.bzA.bAR)) {
                        com.baidu.live.sdk.goods.d.b.N(a.this.mTbPageContext.getPageActivity(), a.this.bzA.bAR);
                    }
                } else if (a.this.bzA.bAS != null && !a.this.bzA.bAS.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.bzA.bAS);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bzS = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.v(aVar.gid, true);
        }
    };
    private View.OnClickListener bzT = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.n.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bzA == null) {
            this.bzA = new d(tbPageContext);
        }
        this.bzA.init();
        this.bzA.a(this.bzQ);
        this.bzD = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.n.b
    public void a(com.baidu.live.n.c cVar) {
    }

    @Override // com.baidu.live.n.b
    public com.baidu.live.core.a.a ON() {
        if (this.bzB == null) {
            this.bzB = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bzB.setOutClickListener(this.bzR);
        }
        return this.bzB;
    }

    @Override // com.baidu.live.n.b
    public void U(View view) {
    }

    @Override // com.baidu.live.n.b
    public void a(x xVar, PendantParentView pendantParentView) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.bzP = true;
            this.bzK = pendantParentView;
            this.bzF = false;
            this.bzG = false;
            this.aGe = xVar;
            if (this.bzD != null) {
                this.bzD.Sq();
                this.bzD.a(xVar);
            }
            cL(false);
            if (xVar.mLiveInfo != null) {
                c(xVar.mLiveInfo.introducegoods, xVar.mLiveInfo.feed_id, xVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bzA != null) {
                this.bzA.c(str2, j, str);
                return;
            }
            return;
        }
        v("", false);
    }

    @Override // com.baidu.live.n.b
    public void i(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            if (this.bzP) {
                this.bzP = false;
                return;
            }
            this.aGe = xVar;
            if (this.bzD != null) {
                this.bzD.a(xVar);
            }
            if (this.bzB != null && this.bzB.getRootLayout() != null && xVar.mLiveInfo != null) {
                if (this.bzB.SA() != xVar.mLiveInfo.isGoodsListVisible()) {
                    cL(false);
                }
            }
            q(xVar);
        }
    }

    private void q(x xVar) {
        if (xVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(xVar.mLiveInfo.introducegoods) || "0".equals(xVar.mLiveInfo.introducegoods)) {
                this.bzO = false;
                this.bzM = false;
                this.bzJ = null;
            } else if (xVar.mLiveInfo.introducegoods.equals(this.bzJ)) {
                this.bzM = false;
            } else {
                this.bzM = true;
            }
            if (xVar.mLiveInfo != null && this.bzM && xVar.mLiveInfo.isGoodsListVisible()) {
                String str = xVar.mLiveInfo.feed_id;
                long j = xVar.mLiveInfo.live_id;
                this.bzM = false;
                c(xVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bzJ) || (xVar.mLiveInfo != null && !xVar.mLiveInfo.isGoodsListVisible())) {
                v(this.bzJ, false);
            }
        }
    }

    @Override // com.baidu.live.n.b
    public void onResume() {
        if (this.bzD != null) {
            this.bzD.onResume();
        }
    }

    @Override // com.baidu.live.n.b
    public void onPause() {
        if (this.bzD != null) {
            this.bzD.onPause();
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
                    cL(false);
                    W(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(boolean z) {
        if (this.bzA != null && this.aGe != null && this.aGe.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bzE)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bzE);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bzA.a(this.aGe.mLiveInfo.feed_id, this.aGe.mLiveInfo.live_id, false, z, this.aGe.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void W(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aGe != null && this.aGe.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aGe.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bzJ) || !this.bzJ.equals(optString)) {
                        this.bzA.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bzO = false;
                    this.bzJ = null;
                    v(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.n.b
    public void LE() {
        this.bzL = false;
        if (this.bzA != null) {
            this.bzA.cancelMessage();
        }
        if (this.bzD != null) {
            this.bzD.Id();
        }
        if (this.bzB != null) {
            this.bzB.release();
        }
        if (this.bzN != null) {
            this.bzN.release();
        }
        if (!TextUtils.isEmpty(this.bzH)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bzH, true);
        }
        v(this.bzJ, false);
        this.bzI = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.n.b
    public void release() {
        if (this.bzA != null) {
            this.bzA.cancelLoadData();
            this.bzA.release();
            this.bzA = null;
        }
        if (this.bzD != null) {
            this.bzD.release();
        }
        if (this.bzB != null) {
            this.bzB.release();
        }
        if (this.bzN != null) {
            this.bzN.release();
        }
        this.bzJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bzN != null && this.bzN.isShow()) {
            this.bzN.So();
        }
        this.bzL = true;
        if (this.bzC == null) {
            this.bzC = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bzC.setOnClickListener(this.bzT);
            this.bzC.setOnCloseBtnClickListener(this.bzS);
            this.bzC.a(this.bzK);
        } else if (this.bzK != null) {
            this.bzC.a(this.bzK);
        }
        this.bzC.f(aVar);
        this.bzC.setVisibility(0);
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
    public void hV(String str) {
        this.bzE = str;
    }

    @Override // com.baidu.live.n.b
    public void dU(int i) {
        if (this.bzD != null) {
            this.bzD.dU(i);
        }
        if (this.bzN != null) {
            this.bzN.el(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        if (this.bzI != null) {
            if (z) {
                this.bzO = true;
                aJ(str, "intcardclose");
            }
            if (this.bzC.getVisibility() == 0) {
                this.bzC.setVisibility(8);
                if (this.bzK != null && this.bzC.getParent() != null) {
                    this.bzK.removeView(this.bzC);
                }
                this.bzI = null;
            }
            this.bzL = false;
        }
    }

    private void aJ(String str, String str2) {
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
        if (this.bzI != null) {
            aJ(this.bzI.gid, "intcard_clk");
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if (bqVar != null && bqVar.aRF != null && (xVar = this.aGe) != null && xVar.mLiveInfo != null) {
                long j = xVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bzE)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bzE);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = xVar.aKQ.userId;
                String str4 = xVar.aKQ.userName;
                long j3 = xVar.mLiveInfo.group_id;
                long j4 = xVar.aKu.userId;
                String str5 = this.bzI.bAv;
                String str6 = this.bzI.bAu;
                String str7 = bqVar.aRF.appKey;
                String str8 = bqVar.aRF.aUr;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bzI.platform)) {
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
