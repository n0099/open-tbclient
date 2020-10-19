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
    private u aDU;
    private d boj;
    private AudienceLiveGoodsEnterView bok;
    private AudienceLiveGoodsExplainView bol;
    private com.baidu.live.sdk.goods.c.a bom;
    private com.baidu.live.sdk.goods.a.a bor;
    private String bos;
    private PendantParentView bot;
    private boolean bou;
    private boolean bov;
    private com.baidu.live.sdk.goods.guide.a bow;
    private TbPageContext mTbPageContext;
    private String bon = "";
    private boolean boo = false;
    private boolean bop = false;
    private String boq = "";
    private boolean box = false;
    private boolean boy = false;
    private c boz = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aDU != null && a.this.aDU.mLiveInfo != null) {
                long j2 = a.this.aDU.mLiveInfo.room_id;
                String str2 = a.this.aDU.mLiveInfo.feed_id;
                if (a.this.bok != null) {
                    a.this.bok.a(j2, str2, j, a.this.bon, i2, list);
                }
                if (!a.this.boo && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bou) {
                    if (a.this.bow == null) {
                        a.this.bow = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.bow.OC();
                    }
                    a.this.bow.setOutClickListener(a.this.boA);
                    a.this.bow.a(a.this.mTbPageContext.getPageActivity(), a.this.bok, j, j2, str2, a.this.bon, list);
                }
                if (a.this.bow != null && i2 < 0) {
                    a.this.bow.OC();
                }
                if (!a.this.boo && !a.this.bop) {
                    a.this.bop = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.boq) && !str3.equals(a.this.boq)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.boq, true);
                    }
                    a.this.boq = str3;
                    long j3 = 10;
                    bj bjVar = com.baidu.live.x.a.OS().bqJ;
                    if (bjVar != null && bjVar.aNZ != null) {
                        j3 = bjVar.aNZ.aQn;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.boq, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.boo) {
                                a.this.cp(true);
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
            if (aVar == null || !aVar.DI()) {
                a.this.t("", false);
            } else if (!aVar.gid.equals(a.this.bos)) {
                a.this.bor = aVar;
                a.this.bos = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener boA = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.boo = true;
            if (!TextUtils.isEmpty(a.this.boq)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.boq, true);
            }
            a.this.cp(false);
            if (a.this.bom != null) {
                a.this.bom.display();
            }
            if (a.this.aDU != null && a.this.aDU.mLiveInfo != null) {
                long j = a.this.aDU.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aDU.mLiveInfo.room_id), String.valueOf(a.this.aDU.mLiveInfo.feed_id), a.this.bon);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
        }
    };
    private AudienceLiveGoodsExplainView.a boB = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.gid, true);
        }
    };
    private View.OnClickListener boC = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.boj == null) {
            this.boj = new d(tbPageContext);
        }
        this.boj.init();
        this.boj.a(this.boz);
        this.bom = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public void a(com.baidu.live.j.c cVar) {
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a Mz() {
        if (this.bok == null) {
            this.bok = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bok.setOutClickListener(this.boA);
        }
        return this.bok;
    }

    @Override // com.baidu.live.j.b
    public void U(View view) {
    }

    @Override // com.baidu.live.j.b
    public void a(u uVar, PendantParentView pendantParentView) {
        if (uVar != null && uVar.mLiveInfo != null) {
            this.boy = true;
            this.bot = pendantParentView;
            this.boo = false;
            this.bop = false;
            this.aDU = uVar;
            if (this.bom != null) {
                this.bom.OE();
                this.bom.a(uVar);
            }
            cp(false);
            if (uVar.mLiveInfo != null) {
                c(uVar.mLiveInfo.introducegoods, uVar.mLiveInfo.feed_id, uVar.mLiveInfo.live_id);
            }
        }
    }

    private void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.boj != null) {
                this.boj.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void j(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null) {
            if (this.boy) {
                this.boy = false;
                return;
            }
            this.aDU = uVar;
            if (this.bom != null) {
                this.bom.a(uVar);
            }
            if (this.bok != null && this.bok.getRootLayout() != null && uVar.mLiveInfo != null) {
                if (this.bok.OO() != uVar.mLiveInfo.isGoodsListVisible()) {
                    cp(false);
                }
            }
            r(uVar);
        }
    }

    private void r(u uVar) {
        if (uVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(uVar.mLiveInfo.introducegoods) || "0".equals(uVar.mLiveInfo.introducegoods)) {
                this.box = false;
                this.bov = false;
                this.bos = null;
            } else if (uVar.mLiveInfo.introducegoods.equals(this.bos)) {
                this.bov = false;
            } else {
                this.bov = true;
            }
            if (uVar.mLiveInfo != null && this.bov && uVar.mLiveInfo.isGoodsListVisible()) {
                String str = uVar.mLiveInfo.feed_id;
                long j = uVar.mLiveInfo.live_id;
                this.bov = false;
                c(uVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.bos) || (uVar.mLiveInfo != null && !uVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bos, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bom != null) {
            this.bom.onResume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bom != null) {
            this.bom.onPause();
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
                    cp(false);
                    N(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(boolean z) {
        if (this.boj != null && this.aDU != null && this.aDU.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.bon)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bon);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.boj.a(this.aDU.mLiveInfo.feed_id, this.aDU.mLiveInfo.live_id, false, z, this.aDU.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void N(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aDU != null && this.aDU.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aDU.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bos) || !this.bos.equals(optString)) {
                        this.boj.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.box = false;
                    this.bos = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void JT() {
        this.bou = false;
        if (this.boj != null) {
            this.boj.cancelMessage();
        }
        if (this.bom != null) {
            this.bom.Gx();
        }
        if (this.bok != null) {
            this.bok.release();
        }
        if (this.bow != null) {
            this.bow.release();
        }
        if (!TextUtils.isEmpty(this.boq)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.boq, true);
        }
        t(this.bos, false);
        this.bor = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.boj != null) {
            this.boj.cancelLoadData();
            this.boj.release();
            this.boj = null;
        }
        if (this.bom != null) {
            this.bom.release();
        }
        if (this.bok != null) {
            this.bok.release();
        }
        if (this.bow != null) {
            this.bow.release();
        }
        this.bos = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bow != null && this.bow.isShow()) {
            this.bow.OC();
        }
        this.bou = true;
        if (this.bol == null) {
            this.bol = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bol.setOnClickListener(this.boC);
            this.bol.setOnCloseBtnClickListener(this.boB);
            this.bol.a(this.bot);
        } else if (this.bot != null) {
            this.bol.a(this.bot);
        }
        this.bol.f(aVar);
        this.bol.setVisibility(0);
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
    public void hz(String str) {
        this.bon = str;
    }

    @Override // com.baidu.live.j.b
    public void dI(int i) {
        if (this.bom != null) {
            this.bom.dI(i);
        }
        if (this.bow != null) {
            this.bow.eZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bor != null) {
            if (z) {
                this.box = true;
                aI(str, "intcardclose");
            }
            if (this.bol.getVisibility() == 0) {
                this.bol.setVisibility(8);
                if (this.bot != null && this.bol.getParent() != null) {
                    this.bot.removeView(this.bol);
                }
                this.bor = null;
            }
            this.bou = false;
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
        u uVar;
        if (this.bor != null) {
            aI(this.bor.gid, "intcard_clk");
            bj bjVar = com.baidu.live.x.a.OS().bqJ;
            if (bjVar != null && bjVar.aNZ != null && (uVar = this.aDU) != null && uVar.mLiveInfo != null) {
                long j = uVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.bon)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.bon);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = uVar.aIf.userId;
                String str4 = uVar.aIf.userName;
                long j3 = uVar.mLiveInfo.group_id;
                long j4 = uVar.aHD.userId;
                String str5 = this.bor.bpe;
                String str6 = this.bor.bpd;
                String str7 = bjVar.aNZ.appKey;
                String str8 = bjVar.aNZ.aQq;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bor.platform)) {
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
