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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.m.b {
    private ab aDd;
    private PendantParentView byA;
    private boolean byB;
    private boolean byC;
    private com.baidu.live.sdk.goods.guide.a byD;
    private d byq;
    private AudienceLiveGoodsEnterView byr;
    private AudienceLiveGoodsExplainView bys;
    private com.baidu.live.sdk.goods.c.a byt;
    private com.baidu.live.sdk.goods.a.a byy;
    private String byz;
    private TbPageContext mTbPageContext;
    private String byu = "";
    private boolean byv = false;
    private boolean byw = false;
    private String byx = "";
    private boolean byE = false;
    private boolean byF = false;
    private c byG = new c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.b.c
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                long j2 = a.this.aDd.mLiveInfo.room_id;
                String str2 = a.this.aDd.mLiveInfo.feed_id;
                if (a.this.byr != null) {
                    a.this.byr.a(j2, str2, j, a.this.byu, i2, list);
                }
                if (!a.this.byv && z && i2 > 0 && list != null && list.size() > 0 && !a.this.byB) {
                    if (a.this.byD == null) {
                        a.this.byD = new com.baidu.live.sdk.goods.guide.a();
                    } else {
                        a.this.byD.PS();
                    }
                    a.this.byD.setOutClickListener(a.this.byH);
                    a.this.byD.a(a.this.mTbPageContext.getPageActivity(), a.this.byr, j, j2, str2, a.this.byu, list);
                }
                if (a.this.byD != null && i2 < 0) {
                    a.this.byD.PS();
                }
                if (!a.this.byv && !a.this.byw) {
                    a.this.byw = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.byx) && !str3.equals(a.this.byx)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.byx, true);
                    }
                    a.this.byx = str3;
                    long j3 = 10;
                    bv bvVar = com.baidu.live.ae.a.Qj().bAS;
                    if (bvVar != null && bvVar.aPQ != null) {
                        j3 = bvVar.aPQ.aSD;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.byx, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.byv) {
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
            if (aVar == null || !aVar.BU()) {
                a.this.v("", false);
            } else if (!aVar.gid.equals(a.this.byz)) {
                a.this.byy = aVar;
                a.this.byz = aVar.gid;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener byH = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.byv = true;
            if (!TextUtils.isEmpty(a.this.byx)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.byx, true);
            }
            a.this.cQ(false);
            if (a.this.byt != null) {
                a.this.byt.display();
            }
            if (a.this.aDd != null && a.this.aDd.mLiveInfo != null) {
                long j = a.this.aDd.mLiveInfo.live_id;
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(String.valueOf(j), String.valueOf(a.this.aDd.mLiveInfo.room_id), String.valueOf(a.this.aDd.mLiveInfo.feed_id), a.this.byu);
                }
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            if (a.this.byq != null) {
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(a.this.byq.bzH)) {
                        com.baidu.live.sdk.goods.d.b.N(a.this.mTbPageContext.getPageActivity(), a.this.byq.bzH);
                    }
                } else if (a.this.byq.bzI != null && !a.this.byq.bzI.isEmpty()) {
                    com.baidu.live.sdk.goods.d.b.e(a.this.mTbPageContext.getPageActivity(), a.this.byq.bzI);
                }
            }
        }
    };
    private AudienceLiveGoodsExplainView.a byI = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.v(aVar.gid, true);
        }
    };
    private View.OnClickListener byJ = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X(view);
        }
    };

    @Override // com.baidu.live.m.b
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.byq == null) {
            this.byq = new d(tbPageContext);
        }
        this.byq.init();
        this.byq.a(this.byG);
        this.byt = new com.baidu.live.sdk.goods.c.c(tbPageContext);
    }

    @Override // com.baidu.live.m.b
    public void a(com.baidu.live.m.c cVar) {
    }

    @Override // com.baidu.live.m.b
    public com.baidu.live.core.a.a Mq() {
        if (this.byr == null) {
            this.byr = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.byr.setOutClickListener(this.byH);
        }
        return this.byr;
    }

    @Override // com.baidu.live.m.b
    public void U(View view) {
    }

    @Override // com.baidu.live.m.b
    public void a(ab abVar, PendantParentView pendantParentView) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.byF = true;
            this.byA = pendantParentView;
            this.byv = false;
            this.byw = false;
            this.aDd = abVar;
            if (this.byt != null) {
                this.byt.PU();
                this.byt.a(abVar);
            }
            cQ(false);
            if (abVar.mLiveInfo != null) {
                d(abVar.mLiveInfo.introducegoods, abVar.mLiveInfo.feed_id, abVar.mLiveInfo.live_id);
            }
        }
    }

    private void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.byq != null) {
                this.byq.c(str2, j, str);
                return;
            }
            return;
        }
        v("", false);
    }

    @Override // com.baidu.live.m.b
    public void i(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            if (this.byF) {
                this.byF = false;
                return;
            }
            this.aDd = abVar;
            if (this.byt != null) {
                this.byt.a(abVar);
            }
            if (this.byr != null && this.byr.getRootLayout() != null && abVar.mLiveInfo != null) {
                if (this.byr.Qf() != abVar.mLiveInfo.isGoodsListVisible()) {
                    cQ(false);
                }
            }
            q(abVar);
        }
    }

    private void q(ab abVar) {
        if (abVar.mLiveInfo != null) {
            if (TextUtils.isEmpty(abVar.mLiveInfo.introducegoods) || "0".equals(abVar.mLiveInfo.introducegoods)) {
                this.byE = false;
                this.byC = false;
                this.byz = null;
            } else if (abVar.mLiveInfo.introducegoods.equals(this.byz)) {
                this.byC = false;
            } else {
                this.byC = true;
            }
            if (abVar.mLiveInfo != null && this.byC && abVar.mLiveInfo.isGoodsListVisible()) {
                String str = abVar.mLiveInfo.feed_id;
                long j = abVar.mLiveInfo.live_id;
                this.byC = false;
                d(abVar.mLiveInfo.introducegoods, str, j);
            } else if (TextUtils.isEmpty(this.byz) || (abVar.mLiveInfo != null && !abVar.mLiveInfo.isGoodsListVisible())) {
                v(this.byz, false);
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void onResume() {
        if (this.byt != null) {
            this.byt.onResume();
        }
    }

    @Override // com.baidu.live.m.b
    public void onPause() {
        if (this.byt != null) {
            this.byt.onPause();
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
                    X(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(boolean z) {
        if (this.byq != null && this.aDd != null && this.aDd.mLiveInfo != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty(this.byu)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.byu);
                    str = jSONObject.optString("tab");
                    str2 = jSONObject.optString("tag");
                    str3 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.byq.a(this.aDd.mLiveInfo.feed_id, this.aDd.mLiveInfo.live_id, false, z, this.aDd.mLiveInfo.user_id, str, str2, str3);
        }
    }

    private void X(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aDd != null && this.aDd.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aDd.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.byz) || !this.byz.equals(optString)) {
                        this.byq.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.byE = false;
                    this.byz = null;
                    v(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.m.b
    public void IZ() {
        this.byB = false;
        if (this.byq != null) {
            this.byq.cancelMessage();
        }
        if (this.byt != null) {
            this.byt.Fy();
        }
        if (this.byr != null) {
            this.byr.release();
        }
        if (this.byD != null) {
            this.byD.release();
        }
        if (!TextUtils.isEmpty(this.byx)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.byx, true);
        }
        v(this.byz, false);
        this.byy = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.m.b
    public void release() {
        if (this.byq != null) {
            this.byq.cancelLoadData();
            this.byq.release();
            this.byq = null;
        }
        if (this.byt != null) {
            this.byt.release();
        }
        if (this.byr != null) {
            this.byr.release();
        }
        if (this.byD != null) {
            this.byD.release();
        }
        this.byz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.byD != null && this.byD.isShow()) {
            this.byD.PS();
        }
        this.byB = true;
        if (this.bys == null) {
            this.bys = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bys.setOnClickListener(this.byJ);
            this.bys.setOnCloseBtnClickListener(this.byI);
            this.bys.a(this.byA);
        } else if (this.byA != null) {
            this.bys.a(this.byA);
        }
        this.bys.f(aVar);
        this.bys.setVisibility(0);
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
    public void hj(String str) {
        this.byu = str;
    }

    @Override // com.baidu.live.m.b
    public void cr(int i) {
        if (this.byt != null) {
            this.byt.cr(i);
        }
        if (this.byD != null) {
            this.byD.cK(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, boolean z) {
        if (this.byy != null) {
            if (z) {
                this.byE = true;
                aI(str, "intcardclose");
            }
            if (this.bys.getVisibility() == 0) {
                this.bys.setVisibility(8);
                if (this.byA != null && this.bys.getParent() != null) {
                    this.byA.removeView(this.bys);
                }
                this.byy = null;
            }
            this.byB = false;
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
        if (this.byy != null) {
            aI(this.byy.gid, "intcard_clk");
            bv bvVar = com.baidu.live.ae.a.Qj().bAS;
            if (bvVar != null && bvVar.aPQ != null && (abVar = this.aDd) != null && abVar.mLiveInfo != null) {
                long j = abVar.mLiveInfo.room_id;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(this.byu)) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.byu);
                        str = jSONObject.optString("tab");
                        str2 = jSONObject.optString("tag");
                        str3 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = abVar.aIz.userId;
                String str4 = abVar.aIz.userName;
                long j3 = abVar.mLiveInfo.group_id;
                long j4 = abVar.aId.userId;
                String str5 = this.byy.bzl;
                String str6 = this.byy.bzk;
                String str7 = bvVar.aPQ.appKey;
                String str8 = bvVar.aPQ.aSG;
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
                if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.byy.platform)) {
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
