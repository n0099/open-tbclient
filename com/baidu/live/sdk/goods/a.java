package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bn;
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
    private w aDh;
    private d bpE;
    private AudienceLiveGoodsEnterView bpF;
    private AudienceLiveGoodsExplainView bpG;
    private com.baidu.live.sdk.goods.c.a bpH;
    private com.baidu.live.sdk.goods.a.a bpM;
    private String bpN;
    private PendantParentView bpO;
    private boolean bpP;
    private boolean bpQ;
    private com.baidu.live.sdk.goods.guide.a bpR;
    private TbPageContext mTbPageContext;
    private String bpI = "";
    private boolean bpJ = false;
    private boolean bpK = false;
    private String bpL = "";
    private boolean bpS = false;
    private boolean bpT = false;
    private c bpU = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                long j2 = a.this.aDh.mLiveInfo.room_id;
                String str2 = a.this.aDh.mLiveInfo.feed_id;
                if (a.this.bpF != null) {
                    a.this.bpF.a(j2, str2, j, a.this.bpI, i2, list);
                }
                if (!a.this.bpJ && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bpP) {
                    if (a.this.bpR == null) {
                        a.this.bpR = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bpR.OR();
                    }
                    a.this.bpR.setOutClickListener(a.this.bpV);
                    a.this.bpR.a(a.this.mTbPageContext.getPageActivity(), a.this.bpF, j, j2, str2, a.this.bpI, list);
                }
                if (a.this.bpR != null && i2 < 0) {
                    a.this.bpR.OR();
                }
                if (!a.this.bpJ && !a.this.bpK) {
                    a.this.bpK = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bpL) && !str3.equals(a.this.bpL)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bpL, true);
                    }
                    a.this.bpL = str3;
                    long j3 = 10;
                    bn bnVar = com.baidu.live.aa.a.Ph().bsh;
                    if (bnVar != null && bnVar.aNQ != null) {
                        j3 = bnVar.aNQ.aQo;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bpL, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bpJ) {
                                a.this.cu(true);
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
            if (aVar == null || !aVar.DB()) {
                a.this.u("", false);
            } else if (!aVar.gid.equals(a.this.bpN)) {
                a.this.bpM = aVar;
                a.this.bpN = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bpV = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bpJ = true;
            if (!TextUtils.isEmpty(a.this.bpL)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bpL, true);
            }
            a.this.cu(false);
            if (a.this.bpH != null) {
                a.this.bpH.display();
            }
            if (a.this.aDh != null && a.this.aDh.mLiveInfo != null) {
                long j = a.this.aDh.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aDh.mLiveInfo.room_id), String.valueOf(a.this.aDh.mLiveInfo.feed_id), a.this.bpI);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.bpE != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.bpE.bqV)) {
                        com.baidu.live.sdk.goods.d.b.F(a.this.mTbPageContext.getPageActivity(), a.this.bpE.bqV);
                    }
                } else if (a.this.bpE.bqW != null && !a.this.bpE.bqW.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.bpE.bqW);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bpW = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.u(aVar.gid, true);
        }
    };
    private View.OnClickListener bpX = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.k.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bpE == null) {
            this.bpE = new d(tbPageContext);
        }
        this.bpE.init();
        this.bpE.a(this.bpU);
        this.bpH = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.k.b
    public void a(com.baidu.live.k.c cVar) {
    }

    @Override // com.baidu.live.k.b
    public com.baidu.live.core.a.a MK() {
        if (this.bpF == null) {
            this.bpF = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bpF.setOutClickListener(this.bpV);
        }
        return this.bpF;
    }

    @Override // com.baidu.live.k.b
    public void U(View view) {
    }

    @Override // com.baidu.live.k.b
    public void a(w wVar, PendantParentView pendantParentView) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.bpT = true;
            this.bpO = pendantParentView;
            this.bpJ = false;
            this.bpK = false;
            this.aDh = wVar;
            if (this.bpH != null) {
                this.bpH.OT();
                this.bpH.a(wVar);
            }
            cu(false);
            if (wVar.mLiveInfo != null) {
                c(wVar.mLiveInfo.introducegoods, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bpE != null) {
                this.bpE.c(str2, j, str);
                return;
            }
            return;
        }
        u("", false);
    }

    @Override // com.baidu.live.k.b
    public void h(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            if (this.bpT) {
                this.bpT = false;
                return;
            }
            this.aDh = wVar;
            if (this.bpH != null) {
                this.bpH.a(wVar);
            }
            if (this.bpF != null && this.bpF.getRootLayout() != null && wVar.mLiveInfo != null) {
                if (this.bpF.Pd() != wVar.mLiveInfo.isGoodsListVisible()) {
                    cu(false);
                }
            }
            p(wVar);
        }
    }

    private void p(w wVar) {
        if (wVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(wVar.mLiveInfo.introducegoods) || "0".equals(wVar.mLiveInfo.introducegoods)) {
                this.bpS = false;
                this.bpQ = false;
                this.bpN = null;
            } else if (wVar.mLiveInfo.introducegoods.equals(this.bpN)) {
                this.bpQ = false;
            } else {
                this.bpQ = true;
            }
            if (wVar.mLiveInfo != null && this.bpQ && wVar.mLiveInfo.isGoodsListVisible()) {
                String str = wVar.mLiveInfo.feed_id;
                long j = wVar.mLiveInfo.live_id;
                this.bpQ = false;
                c(wVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bpN) || (wVar.mLiveInfo != null && !wVar.mLiveInfo.isGoodsListVisible())) {
                u(this.bpN, false);
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void onResume() {
        if (this.bpH != null) {
            this.bpH.onResume();
        }
    }

    @Override // com.baidu.live.k.b
    public void onPause() {
        if (this.bpH != null) {
            this.bpH.onPause();
        }
    }

    @Override // com.baidu.live.k.b
    public void z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    cu(false);
                    M(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (this.bpE != null && this.aDh != null && this.aDh.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bpI)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bpI);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bpE.a(this.aDh.mLiveInfo.feed_id, this.aDh.mLiveInfo.live_id, false, z, this.aDh.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void M(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aDh != null && this.aDh.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aDh.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bpN) || !this.bpN.equals(optString)) {
                        this.bpE.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bpS = false;
                    this.bpN = null;
                    u(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void Ke() {
        this.bpP = false;
        if (this.bpE != null) {
            this.bpE.cancelMessage();
        }
        if (this.bpH != null) {
            this.bpH.GK();
        }
        if (this.bpF != null) {
            this.bpF.release();
        }
        if (this.bpR != null) {
            this.bpR.release();
        }
        if (!TextUtils.isEmpty(this.bpL)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bpL, true);
        }
        u(this.bpN, false);
        this.bpM = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.k.b
    public void release() {
        if (this.bpE != null) {
            this.bpE.cancelLoadData();
            this.bpE.release();
            this.bpE = null;
        }
        if (this.bpH != null) {
            this.bpH.release();
        }
        if (this.bpF != null) {
            this.bpF.release();
        }
        if (this.bpR != null) {
            this.bpR.release();
        }
        this.bpN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bpR != null && this.bpR.isShow()) {
            this.bpR.OR();
        }
        this.bpP = true;
        if (this.bpG == null) {
            this.bpG = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bpG.setOnClickListener(this.bpX);
            this.bpG.setOnCloseBtnClickListener(this.bpW);
            this.bpG.a(this.bpO);
        } else if (this.bpO != null) {
            this.bpG.a(this.bpO);
        }
        this.bpG.f(aVar);
        this.bpG.setVisibility(0);
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
    public void hH(String str) {
        this.bpI = str;
    }

    @Override // com.baidu.live.k.b
    public void dE(int i) {
        if (this.bpH != null) {
            this.bpH.dE(i);
        }
        if (this.bpR != null) {
            this.bpR.dT(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        if (this.bpM != null) {
            if (z) {
                this.bpS = true;
                aK(str, "intcardclose");
            }
            if (this.bpG.getVisibility() == 0) {
                this.bpG.setVisibility(8);
                if (this.bpO != null && this.bpG.getParent() != null) {
                    this.bpO.removeView(this.bpG);
                }
                this.bpM = null;
            }
            this.bpP = false;
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
        if (this.bpM != null) {
            aK(this.bpM.gid, "intcard_clk");
            bn bnVar = com.baidu.live.aa.a.Ph().bsh;
            if (bnVar != null && bnVar.aNQ != null && (wVar = this.aDh) != null && wVar.mLiveInfo != null) {
                long j = wVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bpI)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bpI);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = wVar.aHG.userId;
                String str4 = wVar.aHG.userName;
                long j3 = wVar.mLiveInfo.group_id;
                long j4 = wVar.aHk.userId;
                String str5 = this.bpM.bqz;
                String str6 = this.bpM.bqy;
                String str7 = bnVar.aNQ.appKey;
                String str8 = bnVar.aNQ.aQr;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bpM.platform)) {
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
