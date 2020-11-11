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
    private w aES;
    private boolean brA;
    private boolean brB;
    private com.baidu.live.sdk.goods.guide.a brC;
    private d brp;
    private AudienceLiveGoodsEnterView brq;
    private AudienceLiveGoodsExplainView brr;
    private com.baidu.live.sdk.goods.c.a brs;
    private com.baidu.live.sdk.goods.a.a brx;
    private String bry;
    private PendantParentView brz;
    private TbPageContext mTbPageContext;
    private String brt = "";
    private boolean bru = false;
    private boolean brv = false;
    private String brw = "";
    private boolean brD = false;
    private boolean brE = false;
    private c brF = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aES != null && a.this.aES.mLiveInfo != null) {
                long j2 = a.this.aES.mLiveInfo.room_id;
                String str2 = a.this.aES.mLiveInfo.feed_id;
                if (a.this.brq != null) {
                    a.this.brq.a(j2, str2, j, a.this.brt, i2, list);
                }
                if (!a.this.bru && z && i2 > 0 && list != null && list.size() > 0 && !a.this.brA) {
                    if (a.this.brC == null) {
                        a.this.brC = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.brC.PA();
                    }
                    a.this.brC.setOutClickListener(a.this.brG);
                    a.this.brC.a(a.this.mTbPageContext.getPageActivity(), a.this.brq, j, j2, str2, a.this.brt, list);
                }
                if (a.this.brC != null && i2 < 0) {
                    a.this.brC.PA();
                }
                if (!a.this.bru && !a.this.brv) {
                    a.this.brv = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.brw) && !str3.equals(a.this.brw)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.brw, true);
                    }
                    a.this.brw = str3;
                    long j3 = 10;
                    bn bnVar = com.baidu.live.aa.a.PQ().btT;
                    if (bnVar != null && bnVar.aPB != null) {
                        j3 = bnVar.aPB.aRZ;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.brw, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bru) {
                                a.this.cs(true);
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
            if (aVar == null || !aVar.Ek()) {
                a.this.u("", false);
            } else if (!aVar.gid.equals(a.this.bry)) {
                a.this.brx = aVar;
                a.this.bry = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener brG = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bru = true;
            if (!TextUtils.isEmpty(a.this.brw)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.brw, true);
            }
            a.this.cs(false);
            if (a.this.brs != null) {
                a.this.brs.display();
            }
            if (a.this.aES != null && a.this.aES.mLiveInfo != null) {
                long j = a.this.aES.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aES.mLiveInfo.room_id), String.valueOf(a.this.aES.mLiveInfo.feed_id), a.this.brt);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.brp != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.brp.bsG)) {
                        com.baidu.live.sdk.goods.d.b.I(a.this.mTbPageContext.getPageActivity(), a.this.brp.bsG);
                    }
                } else if (a.this.brp.bsH != null && !a.this.brp.bsH.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.brp.bsH);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a brH = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.u(aVar.gid, true);
        }
    };
    private View.OnClickListener brI = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.k.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.brp == null) {
            this.brp = new d(tbPageContext);
        }
        this.brp.init();
        this.brp.a(this.brF);
        this.brs = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.k.b
    public void a(com.baidu.live.k.c cVar) {
    }

    @Override // com.baidu.live.k.b
    public com.baidu.live.core.a.a Nt() {
        if (this.brq == null) {
            this.brq = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.brq.setOutClickListener(this.brG);
        }
        return this.brq;
    }

    @Override // com.baidu.live.k.b
    public void U(View view) {
    }

    @Override // com.baidu.live.k.b
    public void a(w wVar, PendantParentView pendantParentView) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.brE = true;
            this.brz = pendantParentView;
            this.bru = false;
            this.brv = false;
            this.aES = wVar;
            if (this.brs != null) {
                this.brs.PC();
                this.brs.a(wVar);
            }
            cs(false);
            if (wVar.mLiveInfo != null) {
                c(wVar.mLiveInfo.introducegoods, wVar.mLiveInfo.feed_id, wVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.brp != null) {
                this.brp.c(str2, j, str);
                return;
            }
            return;
        }
        u("", false);
    }

    @Override // com.baidu.live.k.b
    public void h(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            if (this.brE) {
                this.brE = false;
                return;
            }
            this.aES = wVar;
            if (this.brs != null) {
                this.brs.a(wVar);
            }
            if (this.brq != null && this.brq.getRootLayout() != null && wVar.mLiveInfo != null) {
                if (this.brq.PM() != wVar.mLiveInfo.isGoodsListVisible()) {
                    cs(false);
                }
            }
            p(wVar);
        }
    }

    private void p(w wVar) {
        if (wVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(wVar.mLiveInfo.introducegoods) || "0".equals(wVar.mLiveInfo.introducegoods)) {
                this.brD = false;
                this.brB = false;
                this.bry = null;
            } else if (wVar.mLiveInfo.introducegoods.equals(this.bry)) {
                this.brB = false;
            } else {
                this.brB = true;
            }
            if (wVar.mLiveInfo != null && this.brB && wVar.mLiveInfo.isGoodsListVisible()) {
                String str = wVar.mLiveInfo.feed_id;
                long j = wVar.mLiveInfo.live_id;
                this.brB = false;
                c(wVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bry) || (wVar.mLiveInfo != null && !wVar.mLiveInfo.isGoodsListVisible())) {
                u(this.bry, false);
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void onResume() {
        if (this.brs != null) {
            this.brs.onResume();
        }
    }

    @Override // com.baidu.live.k.b
    public void onPause() {
        if (this.brs != null) {
            this.brs.onPause();
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
                    cs(false);
                    S(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        if (this.brp != null && this.aES != null && this.aES.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.brt)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.brt);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.brp.a(this.aES.mLiveInfo.feed_id, this.aES.mLiveInfo.live_id, false, z, this.aES.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void S(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aES != null && this.aES.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aES.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bry) || !this.bry.equals(optString)) {
                        this.brp.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.brD = false;
                    this.bry = null;
                    u(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.k.b
    public void KN() {
        this.brA = false;
        if (this.brp != null) {
            this.brp.cancelMessage();
        }
        if (this.brs != null) {
            this.brs.Ht();
        }
        if (this.brq != null) {
            this.brq.release();
        }
        if (this.brC != null) {
            this.brC.release();
        }
        if (!TextUtils.isEmpty(this.brw)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.brw, true);
        }
        u(this.bry, false);
        this.brx = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.k.b
    public void release() {
        if (this.brp != null) {
            this.brp.cancelLoadData();
            this.brp.release();
            this.brp = null;
        }
        if (this.brs != null) {
            this.brs.release();
        }
        if (this.brq != null) {
            this.brq.release();
        }
        if (this.brC != null) {
            this.brC.release();
        }
        this.bry = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.brC != null && this.brC.isShow()) {
            this.brC.PA();
        }
        this.brA = true;
        if (this.brr == null) {
            this.brr = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.brr.setOnClickListener(this.brI);
            this.brr.setOnCloseBtnClickListener(this.brH);
            this.brr.a(this.brz);
        } else if (this.brz != null) {
            this.brr.a(this.brz);
        }
        this.brr.f(aVar);
        this.brr.setVisibility(0);
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
    public void hN(String str) {
        this.brt = str;
    }

    @Override // com.baidu.live.k.b
    public void dI(int i) {
        if (this.brs != null) {
            this.brs.dI(i);
        }
        if (this.brC != null) {
            this.brC.dX(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        if (this.brx != null) {
            if (z) {
                this.brD = true;
                aL(str, "intcardclose");
            }
            if (this.brr.getVisibility() == 0) {
                this.brr.setVisibility(8);
                if (this.brz != null && this.brr.getParent() != null) {
                    this.brz.removeView(this.brr);
                }
                this.brx = null;
            }
            this.brA = false;
        }
    }

    private void aL(String str, String str2) {
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
        if (this.brx != null) {
            aL(this.brx.gid, "intcard_clk");
            bn bnVar = com.baidu.live.aa.a.PQ().btT;
            if (bnVar != null && bnVar.aPB != null && (wVar = this.aES) != null && wVar.mLiveInfo != null) {
                long j = wVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.brt)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.brt);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = wVar.aJr.userId;
                String str4 = wVar.aJr.userName;
                long j3 = wVar.mLiveInfo.group_id;
                long j4 = wVar.aIV.userId;
                String str5 = this.brx.bsk;
                String str6 = this.brx.bsj;
                String str7 = bnVar.aPB.appKey;
                String str8 = bnVar.aPB.aSc;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.brx.platform)) {
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
