package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.ab;
import com.baidu.live.data.bv;
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
public class a implements com.baidu.live.m.b {
    private ab aED;
    private PendantParentView bAa;
    private boolean bAb;
    private boolean bAc;
    private com.baidu.live.sdk.goods.guide.a bAd;
    private d bzQ;
    private AudienceLiveGoodsEnterView bzR;
    private AudienceLiveGoodsExplainView bzS;
    private com.baidu.live.sdk.goods.c.a bzT;
    private com.baidu.live.sdk.goods.a.a bzY;
    private String bzZ;
    private TbPageContext mTbPageContext;
    private String bzU = "";
    private boolean bzV = false;
    private boolean bzW = false;
    private String bzX = "";
    private boolean bAe = false;
    private boolean bAf = false;
    private c bAg = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aED != null && a.this.aED.mLiveInfo != null) {
                long j2 = a.this.aED.mLiveInfo.room_id;
                String str2 = a.this.aED.mLiveInfo.feed_id;
                if (a.this.bzR != null) {
                    a.this.bzR.a(j2, str2, j, a.this.bzU, i2, list);
                }
                if (!a.this.bzV && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bAb) {
                    if (a.this.bAd == null) {
                        a.this.bAd = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bAd.PV();
                    }
                    a.this.bAd.setOutClickListener(a.this.bAh);
                    a.this.bAd.a(a.this.mTbPageContext.getPageActivity(), a.this.bzR, j, j2, str2, a.this.bzU, list);
                }
                if (a.this.bAd != null && i2 < 0) {
                    a.this.bAd.PV();
                }
                if (!a.this.bzV && !a.this.bzW) {
                    a.this.bzW = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bzX) && !str3.equals(a.this.bzX)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bzX, true);
                    }
                    a.this.bzX = str3;
                    long j3 = 10;
                    bv bvVar = com.baidu.live.ae.a.Qm().bCs;
                    if (bvVar != null && bvVar.aRq != null) {
                        j3 = bvVar.aRq.aUd;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bzX, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bzV) {
                                a.this.cQ(true);
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
            if (aVar == null || !aVar.BX()) {
                a.this.v("", false);
            } else if (!aVar.gid.equals(a.this.bzZ)) {
                a.this.bzY = aVar;
                a.this.bzZ = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bAh = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bzV = true;
            if (!TextUtils.isEmpty(a.this.bzX)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bzX, true);
            }
            a.this.cQ(false);
            if (a.this.bzT != null) {
                a.this.bzT.display();
            }
            if (a.this.aED != null && a.this.aED.mLiveInfo != null) {
                long j = a.this.aED.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aED.mLiveInfo.room_id), String.valueOf(a.this.aED.mLiveInfo.feed_id), a.this.bzU);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.bzQ != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.bzQ.bBh)) {
                        com.baidu.live.sdk.goods.d.b.N(a.this.mTbPageContext.getPageActivity(), a.this.bzQ.bBh);
                    }
                } else if (a.this.bzQ.bBi != null && !a.this.bzQ.bBi.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.bzQ.bBi);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bAi = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.v(aVar.gid, true);
        }
    };
    private View.OnClickListener bAj = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.m.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bzQ == null) {
            this.bzQ = new d(tbPageContext);
        }
        this.bzQ.init();
        this.bzQ.a(this.bAg);
        this.bzT = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.m.b
    public void a(com.baidu.live.m.c cVar) {
    }

    @Override // com.baidu.live.m.b
    public com.baidu.live.core.a.a Mt() {
        if (this.bzR == null) {
            this.bzR = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bzR.setOutClickListener(this.bAh);
        }
        return this.bzR;
    }

    @Override // com.baidu.live.m.b
    public void U(View view) {
    }

    @Override // com.baidu.live.m.b
    public void a(ab abVar, PendantParentView pendantParentView) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.bAf = true;
            this.bAa = pendantParentView;
            this.bzV = false;
            this.bzW = false;
            this.aED = abVar;
            if (this.bzT != null) {
                this.bzT.PX();
                this.bzT.a(abVar);
            }
            cQ(false);
            if (abVar.mLiveInfo != null) {
                d(abVar.mLiveInfo.introducegoods, abVar.mLiveInfo.feed_id, abVar.mLiveInfo.live_id);
            }
        }
    }

    private void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bzQ != null) {
                this.bzQ.c(str2, j, str);
                return;
            }
            return;
        }
        v("", false);
    }

    @Override // com.baidu.live.m.b
    public void i(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            if (this.bAf) {
                this.bAf = false;
                return;
            }
            this.aED = abVar;
            if (this.bzT != null) {
                this.bzT.a(abVar);
            }
            if (this.bzR != null && this.bzR.getRootLayout() != null && abVar.mLiveInfo != null) {
                if (this.bzR.Qi() != abVar.mLiveInfo.isGoodsListVisible()) {
                    cQ(false);
                }
            }
            q(abVar);
        }
    }

    private void q(ab abVar) {
        if (abVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(abVar.mLiveInfo.introducegoods) || "0".equals(abVar.mLiveInfo.introducegoods)) {
                this.bAe = false;
                this.bAc = false;
                this.bzZ = null;
            } else if (abVar.mLiveInfo.introducegoods.equals(this.bzZ)) {
                this.bAc = false;
            } else {
                this.bAc = true;
            }
            if (abVar.mLiveInfo != null && this.bAc && abVar.mLiveInfo.isGoodsListVisible()) {
                String str = abVar.mLiveInfo.feed_id;
                long j = abVar.mLiveInfo.live_id;
                this.bAc = false;
                d(abVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bzZ) || (abVar.mLiveInfo != null && !abVar.mLiveInfo.isGoodsListVisible())) {
                v(this.bzZ, false);
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void onResume() {
        if (this.bzT != null) {
            this.bzT.onResume();
        }
    }

    @Override // com.baidu.live.m.b
    public void onPause() {
        if (this.bzT != null) {
            this.bzT.onPause();
        }
    }

    @Override // com.baidu.live.m.b
    public void I(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "introduce_goods".equals(jSONObject.optString("content_type"))) {
                    cQ(false);
                    Z(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(boolean z) {
        if (this.bzQ != null && this.aED != null && this.aED.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bzU)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bzU);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bzQ.a(this.aED.mLiveInfo.feed_id, this.aED.mLiveInfo.live_id, false, z, this.aED.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void Z(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aED != null && this.aED.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aED.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bzZ) || !this.bzZ.equals(optString)) {
                        this.bzQ.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bAe = false;
                    this.bzZ = null;
                    v(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void Jc() {
        this.bAb = false;
        if (this.bzQ != null) {
            this.bzQ.cancelMessage();
        }
        if (this.bzT != null) {
            this.bzT.FB();
        }
        if (this.bzR != null) {
            this.bzR.release();
        }
        if (this.bAd != null) {
            this.bAd.release();
        }
        if (!TextUtils.isEmpty(this.bzX)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bzX, true);
        }
        v(this.bzZ, false);
        this.bzY = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.m.b
    public void release() {
        if (this.bzQ != null) {
            this.bzQ.cancelLoadData();
            this.bzQ.release();
            this.bzQ = null;
        }
        if (this.bzT != null) {
            this.bzT.release();
        }
        if (this.bzR != null) {
            this.bzR.release();
        }
        if (this.bAd != null) {
            this.bAd.release();
        }
        this.bzZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bAd != null && this.bAd.isShow()) {
            this.bAd.PV();
        }
        this.bAb = true;
        if (this.bzS == null) {
            this.bzS = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bzS.setOnClickListener(this.bAj);
            this.bzS.setOnCloseBtnClickListener(this.bAi);
            this.bzS.a(this.bAa);
        } else if (this.bAa != null) {
            this.bzS.a(this.bAa);
        }
        this.bzS.f(aVar);
        this.bzS.setVisibility(0);
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
    public void hp(String str) {
        this.bzU = str;
    }

    @Override // com.baidu.live.m.b
    public void cs(int i) {
        if (this.bzT != null) {
            this.bzT.cs(i);
        }
        if (this.bAd != null) {
            this.bAd.cL(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        if (this.bzY != null) {
            if (z) {
                this.bAe = true;
                aI(str, "intcardclose");
            }
            if (this.bzS.getVisibility() == 0) {
                this.bzS.setVisibility(8);
                if (this.bAa != null && this.bzS.getParent() != null) {
                    this.bAa.removeView(this.bzS);
                }
                this.bzY = null;
            }
            this.bAb = false;
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
        ab abVar;
        if (this.bzY != null) {
            aI(this.bzY.gid, "intcard_clk");
            bv bvVar = com.baidu.live.ae.a.Qm().bCs;
            if (bvVar != null && bvVar.aRq != null && (abVar = this.aED) != null && abVar.mLiveInfo != null) {
                long j = abVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bzU)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bzU);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = abVar.aJZ.userId;
                String str4 = abVar.aJZ.userName;
                long j3 = abVar.mLiveInfo.group_id;
                long j4 = abVar.aJD.userId;
                String str5 = this.bzY.bAL;
                String str6 = this.bzY.bAK;
                String str7 = bvVar.aRq.appKey;
                String str8 = bvVar.aRq.aUg;
                if (str8 == null) {
                    str8 = "";
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(abVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                List<ResolveInfo> list = null;
                PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                if (packageManager != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                boolean z = (list == null || list.isEmpty()) ? false : true;
                boolean z2 = true;
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bzY.platform)) {
                    z2 = false;
                }
                if (z && z2) {
                    intent.addFlags(268435456);
                    this.mTbPageContext.getPageActivity().startActivity(intent);
                } else {
                    SchemeUtils.openScheme(str6, false);
                }
                com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                aVar.a(abVar.mLiveInfo.live_id, j2, str4, j4, j3);
                MessageManager.getInstance().sendMessage(aVar);
            }
        }
    }
}
