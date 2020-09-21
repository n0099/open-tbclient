package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bj;
import com.baidu.live.data.u;
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
public class a implements com.baidu.live.j.b {
    private u aAP;
    private com.baidu.live.sdk.goods.a.a bkE;
    private String bkF;
    private PendantParentView bkG;
    private boolean bkH;
    private boolean bkI;
    private com.baidu.live.sdk.goods.guide.a bkJ;
    private d bkw;
    private AudienceLiveGoodsEnterView bkx;
    private AudienceLiveGoodsExplainView bky;
    private com.baidu.live.sdk.goods.c.a bkz;
    private TbPageContext mTbPageContext;
    private String bkA = "";
    private boolean bkB = false;
    private boolean bkC = false;
    private String bkD = "";
    private boolean bkK = false;
    private boolean bkL = false;
    private c bkM = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aAP != null && a.this.aAP.mLiveInfo != null) {
                long j2 = a.this.aAP.mLiveInfo.room_id;
                String str2 = a.this.aAP.mLiveInfo.feed_id;
                if (a.this.bkx != null) {
                    a.this.bkx.a(j2, str2, j, a.this.bkA, i2, list);
                }
                if (!a.this.bkB && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bkH) {
                    if (a.this.bkJ == null) {
                        a.this.bkJ = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bkJ.Nx();
                    }
                    a.this.bkJ.setOutClickListener(a.this.bkN);
                    a.this.bkJ.a(a.this.mTbPageContext.getPageActivity(), a.this.bkx, j, j2, str2, a.this.bkA, list);
                }
                if (a.this.bkJ != null && i2 < 0) {
                    a.this.bkJ.Nx();
                }
                if (!a.this.bkB && !a.this.bkC) {
                    a.this.bkC = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bkD) && !str3.equals(a.this.bkD)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bkD, true);
                    }
                    a.this.bkD = str3;
                    long j3 = 10;
                    bj bjVar = com.baidu.live.x.a.NN().bmW;
                    if (bjVar != null && bjVar.aKU != null) {
                        j3 = bjVar.aKU.aNi;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bkD, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bkB) {
                                a.this.cm(true);
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
            if (aVar == null || !aVar.CL()) {
                a.this.t("", false);
            } else if (!aVar.gid.equals(a.this.bkF)) {
                a.this.bkE = aVar;
                a.this.bkF = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bkN = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bkB = true;
            if (!TextUtils.isEmpty(a.this.bkD)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bkD, true);
            }
            a.this.cm(false);
            if (a.this.bkz != null) {
                a.this.bkz.display();
            }
            if (a.this.aAP != null && a.this.aAP.mLiveInfo != null) {
                long j = a.this.aAP.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aAP.mLiveInfo.room_id), String.valueOf(a.this.aAP.mLiveInfo.feed_id), a.this.bkA);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
        }
    };
    private AudienceLiveGoodsExplainView.a bkO = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.gid, true);
        }
    };
    private View.OnClickListener bkP = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bkw == null) {
            this.bkw = new d(tbPageContext);
        }
        this.bkw.init();
        this.bkw.a(this.bkM);
        this.bkz = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public void a(com.baidu.live.j.c cVar) {
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a Lu() {
        if (this.bkx == null) {
            this.bkx = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bkx.setOutClickListener(this.bkN);
        }
        return this.bkx;
    }

    @Override // com.baidu.live.j.b
    public void U(View view) {
    }

    @Override // com.baidu.live.j.b
    public void a(u uVar, PendantParentView pendantParentView) {
        if (uVar != null && uVar.mLiveInfo != null) {
            this.bkL = true;
            this.bkG = pendantParentView;
            this.bkB = false;
            this.bkC = false;
            this.aAP = uVar;
            if (this.bkz != null) {
                this.bkz.Nz();
                this.bkz.a(uVar);
            }
            cm(false);
            if (uVar.mLiveInfo != null) {
                b(uVar.mLiveInfo.introducegoods, uVar.mLiveInfo.feed_id, uVar.mLiveInfo.live_id);
            }
        }
    }

    private void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bkw != null) {
                this.bkw.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void j(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null) {
            if (this.bkL) {
                this.bkL = false;
                return;
            }
            this.aAP = uVar;
            if (this.bkz != null) {
                this.bkz.a(uVar);
            }
            if (this.bkx != null && this.bkx.getRootLayout() != null && uVar.mLiveInfo != null) {
                if (this.bkx.NJ() != uVar.mLiveInfo.isGoodsListVisible()) {
                    cm(false);
                }
            }
            r(uVar);
        }
    }

    private void r(u uVar) {
        if (uVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(uVar.mLiveInfo.introducegoods) || "0".equals(uVar.mLiveInfo.introducegoods)) {
                this.bkK = false;
                this.bkI = false;
                this.bkF = null;
            } else if (uVar.mLiveInfo.introducegoods.equals(this.bkF)) {
                this.bkI = false;
            } else {
                this.bkI = true;
            }
            if (uVar.mLiveInfo != null && this.bkI && uVar.mLiveInfo.isGoodsListVisible()) {
                String str = uVar.mLiveInfo.feed_id;
                long j = uVar.mLiveInfo.live_id;
                this.bkI = false;
                b(uVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bkF) || (uVar.mLiveInfo != null && !uVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bkF, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bkz != null) {
            this.bkz.onResume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bkz != null) {
            this.bkz.onPause();
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
                    cm(false);
                    O(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (this.bkw != null && this.aAP != null && this.aAP.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bkA)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bkA);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bkw.a(this.aAP.mLiveInfo.feed_id, this.aAP.mLiveInfo.live_id, false, z, this.aAP.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void O(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aAP != null && this.aAP.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aAP.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bkF) || !this.bkF.equals(optString)) {
                        this.bkw.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bkK = false;
                    this.bkF = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void Lv() {
        this.bkH = false;
        if (this.bkw != null) {
            this.bkw.cancelMessage();
        }
        if (this.bkz != null) {
            this.bkz.FB();
        }
        if (this.bkx != null) {
            this.bkx.release();
        }
        if (this.bkJ != null) {
            this.bkJ.release();
        }
        if (!TextUtils.isEmpty(this.bkD)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bkD, true);
        }
        t(this.bkF, false);
        this.bkE = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.bkw != null) {
            this.bkw.cancelLoadData();
            this.bkw.release();
            this.bkw = null;
        }
        if (this.bkz != null) {
            this.bkz.release();
        }
        if (this.bkx != null) {
            this.bkx.release();
        }
        if (this.bkJ != null) {
            this.bkJ.release();
        }
        this.bkF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bkJ != null && this.bkJ.isShow()) {
            this.bkJ.Nx();
        }
        this.bkH = true;
        if (this.bky == null) {
            this.bky = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bky.setOnClickListener(this.bkP);
            this.bky.setOnCloseBtnClickListener(this.bkO);
            this.bky.a(this.bkG);
        } else if (this.bkG != null) {
            this.bky.a(this.bkG);
        }
        this.bky.f(aVar);
        this.bky.setVisibility(0);
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
    public void hi(String str) {
        this.bkA = str;
    }

    @Override // com.baidu.live.j.b
    public void dD(int i) {
        if (this.bkz != null) {
            this.bkz.dD(i);
        }
        if (this.bkJ != null) {
            this.bkJ.eQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bkE != null) {
            if (z) {
                this.bkK = true;
                aF(str, "intcardclose");
            }
            if (this.bky.getVisibility() == 0) {
                this.bky.setVisibility(8);
                if (this.bkG != null && this.bky.getParent() != null) {
                    this.bkG.removeView(this.bky);
                }
                this.bkE = null;
            }
            this.bkH = false;
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
    public void X(View view) {
        u uVar;
        if (this.bkE != null) {
            aF(this.bkE.gid, "intcard_clk");
            bj bjVar = com.baidu.live.x.a.NN().bmW;
            if (bjVar != null && bjVar.aKU != null && (uVar = this.aAP) != null && uVar.mLiveInfo != null) {
                long j = uVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bkA)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bkA);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = uVar.aFb.userId;
                String str4 = uVar.aFb.userName;
                long j3 = uVar.mLiveInfo.group_id;
                long j4 = uVar.aEz.userId;
                String str5 = this.bkE.blr;
                String str6 = this.bkE.blq;
                String str7 = bjVar.aKU.appKey;
                String str8 = bjVar.aKU.aNl;
                if (str8 == null) {
                    str8 = "";
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.d.a.a(String.valueOf(uVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                List<ResolveInfo> list = null;
                PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                if (packageManager != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                boolean z = (list == null || list.isEmpty()) ? false : true;
                boolean z2 = true;
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bkE.platform)) {
                    z2 = false;
                }
                if (z && z2) {
                    intent.addFlags(268435456);
                    this.mTbPageContext.getPageActivity().startActivity(intent);
                } else {
                    SchemeUtils.openScheme(str6, false);
                }
                com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                aVar.a(uVar.mLiveInfo.live_id, j2, str4, j4, j3);
                MessageManager.getInstance().sendMessage(aVar);
            }
        }
    }
}
