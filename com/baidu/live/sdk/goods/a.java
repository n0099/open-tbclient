package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bo;
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
public class a implements com.baidu.live.m.b {
    private w aFN;
    private d buP;
    private AudienceLiveGoodsEnterView buQ;
    private AudienceLiveGoodsExplainView buR;
    private com.baidu.live.sdk.goods.c.a buS;
    private com.baidu.live.sdk.goods.a.a buX;
    private String buY;
    private PendantParentView buZ;
    private boolean bva;
    private boolean bvb;
    private com.baidu.live.sdk.goods.guide.a bvc;
    private TbPageContext mTbPageContext;
    private String buT = "";
    private boolean buU = false;
    private boolean buV = false;
    private String buW = "";
    private boolean bvd = false;
    private boolean bve = false;
    private c bvf = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                long j2 = a.this.aFN.mLiveInfo.room_id;
                String str2 = a.this.aFN.mLiveInfo.feed_id;
                if (a.this.buQ != null) {
                    a.this.buQ.a(j2, str2, j, a.this.buT, i2, list);
                }
                if (!a.this.buU && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bva) {
                    if (a.this.bvc == null) {
                        a.this.bvc = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bvc.Rl();
                    }
                    a.this.bvc.setOutClickListener(a.this.bvg);
                    a.this.bvc.a(a.this.mTbPageContext.getPageActivity(), a.this.buQ, j, j2, str2, a.this.buT, list);
                }
                if (a.this.bvc != null && i2 < 0) {
                    a.this.bvc.Rl();
                }
                if (!a.this.buU && !a.this.buV) {
                    a.this.buV = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.buW) && !str3.equals(a.this.buW)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.buW, true);
                    }
                    a.this.buW = str3;
                    long j3 = 10;
                    bo boVar = com.baidu.live.ae.a.RB().bxq;
                    if (boVar != null && boVar.aQQ != null) {
                        j3 = boVar.aQQ.aTq;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.buW, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.buU) {
                                a.this.cI(true);
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
            if (aVar == null || !aVar.Fm()) {
                a.this.v("", false);
            } else if (!aVar.gid.equals(a.this.buY)) {
                a.this.buX = aVar;
                a.this.buY = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bvg = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.buU = true;
            if (!TextUtils.isEmpty(a.this.buW)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.buW, true);
            }
            a.this.cI(false);
            if (a.this.buS != null) {
                a.this.buS.su();
            }
            if (a.this.aFN != null && a.this.aFN.mLiveInfo != null) {
                long j = a.this.aFN.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aFN.mLiveInfo.room_id), String.valueOf(a.this.aFN.mLiveInfo.feed_id), a.this.buT);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.buP != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.buP.bwg)) {
                        com.baidu.live.sdk.goods.d.b.J(a.this.mTbPageContext.getPageActivity(), a.this.buP.bwg);
                    }
                } else if (a.this.buP.bwh != null && !a.this.buP.bwh.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.buP.bwh);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bvh = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.v(aVar.gid, true);
        }
    };
    private View.OnClickListener bvi = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.m.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.buP == null) {
            this.buP = new d(tbPageContext);
        }
        this.buP.init();
        this.buP.a(this.bvf);
        this.buS = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.m.b
    public void a(com.baidu.live.m.c cVar) {
    }

    @Override // com.baidu.live.m.b
    public com.baidu.live.core.a.a Pc() {
        if (this.buQ == null) {
            this.buQ = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.buQ.setOutClickListener(this.bvg);
        }
        return this.buQ;
    }

    @Override // com.baidu.live.m.b
    public void U(View view) {
    }

    @Override // com.baidu.live.m.b
    public void a(w wVar, PendantParentView pendantParentView) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.bve = true;
            this.buZ = pendantParentView;
            this.buU = false;
            this.buV = false;
            this.aFN = wVar;
            if (this.buS != null) {
                this.buS.Rn();
                this.buS.a(wVar);
            }
            cI(false);
            if (wVar.mLiveInfo != null) {
                c(wVar.mLiveInfo.introducegoods, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.buP != null) {
                this.buP.c(str2, j, str);
                return;
            }
            return;
        }
        v("", false);
    }

    @Override // com.baidu.live.m.b
    public void h(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            if (this.bve) {
                this.bve = false;
                return;
            }
            this.aFN = wVar;
            if (this.buS != null) {
                this.buS.a(wVar);
            }
            if (this.buQ != null && this.buQ.getRootLayout() != null && wVar.mLiveInfo != null) {
                if (this.buQ.Rx() != wVar.mLiveInfo.isGoodsListVisible()) {
                    cI(false);
                }
            }
            p(wVar);
        }
    }

    private void p(w wVar) {
        if (wVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(wVar.mLiveInfo.introducegoods) || "0".equals(wVar.mLiveInfo.introducegoods)) {
                this.bvd = false;
                this.bvb = false;
                this.buY = null;
            } else if (wVar.mLiveInfo.introducegoods.equals(this.buY)) {
                this.bvb = false;
            } else {
                this.bvb = true;
            }
            if (wVar.mLiveInfo != null && this.bvb && wVar.mLiveInfo.isGoodsListVisible()) {
                String str = wVar.mLiveInfo.feed_id;
                long j = wVar.mLiveInfo.live_id;
                this.bvb = false;
                c(wVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.buY) || (wVar.mLiveInfo != null && !wVar.mLiveInfo.isGoodsListVisible())) {
                v(this.buY, false);
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void onResume() {
        if (this.buS != null) {
            this.buS.onResume();
        }
    }

    @Override // com.baidu.live.m.b
    public void onPause() {
        if (this.buS != null) {
            this.buS.onPause();
        }
    }

    @Override // com.baidu.live.m.b
    public void A(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    cI(false);
                    O(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(boolean z) {
        if (this.buP != null && this.aFN != null && this.aFN.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.buT)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.buT);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.buP.a(this.aFN.mLiveInfo.feed_id, this.aFN.mLiveInfo.live_id, false, z, this.aFN.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void O(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aFN != null && this.aFN.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aFN.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.buY) || !this.buY.equals(optString)) {
                        this.buP.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bvd = false;
                    this.buY = null;
                    v(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void Mg() {
        this.bva = false;
        if (this.buP != null) {
            this.buP.cancelMessage();
        }
        if (this.buS != null) {
            this.buS.IB();
        }
        if (this.buQ != null) {
            this.buQ.release();
        }
        if (this.bvc != null) {
            this.bvc.release();
        }
        if (!TextUtils.isEmpty(this.buW)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.buW, true);
        }
        v(this.buY, false);
        this.buX = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.m.b
    public void release() {
        if (this.buP != null) {
            this.buP.cancelLoadData();
            this.buP.release();
            this.buP = null;
        }
        if (this.buS != null) {
            this.buS.release();
        }
        if (this.buQ != null) {
            this.buQ.release();
        }
        if (this.bvc != null) {
            this.bvc.release();
        }
        this.buY = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bvc != null && this.bvc.isShow()) {
            this.bvc.Rl();
        }
        this.bva = true;
        if (this.buR == null) {
            this.buR = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.buR.setOnClickListener(this.bvi);
            this.buR.setOnCloseBtnClickListener(this.bvh);
            this.buR.a(this.buZ);
        } else if (this.buZ != null) {
            this.buR.a(this.buZ);
        }
        this.buR.f(aVar);
        this.buR.setVisibility(0);
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

    @Override // com.baidu.live.m.b
    public void ik(String str) {
        this.buT = str;
    }

    @Override // com.baidu.live.m.b
    public void dX(int i) {
        if (this.buS != null) {
            this.buS.dX(i);
        }
        if (this.bvc != null) {
            this.bvc.en(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        if (this.buX != null) {
            if (z) {
                this.bvd = true;
                aO(str, "intcardclose");
            }
            if (this.buR.getVisibility() == 0) {
                this.buR.setVisibility(8);
                if (this.buZ != null && this.buR.getParent() != null) {
                    this.buZ.removeView(this.buR);
                }
                this.buX = null;
            }
            this.bva = false;
        }
    }

    private void aO(String str, String str2) {
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
        if (this.buX != null) {
            aO(this.buX.gid, "intcard_clk");
            bo boVar = com.baidu.live.ae.a.RB().bxq;
            if (boVar != null && boVar.aQQ != null && (wVar = this.aFN) != null && wVar.mLiveInfo != null) {
                long j = wVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.buT)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.buT);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = wVar.aKr.userId;
                String str4 = wVar.aKr.userName;
                long j3 = wVar.mLiveInfo.group_id;
                long j4 = wVar.aJV.userId;
                String str5 = this.buX.bvK;
                String str6 = this.buX.bvJ;
                String str7 = boVar.aQQ.appKey;
                String str8 = boVar.aQQ.aTt;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.buX.platform)) {
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
