package com.baidu.live.sdk.goods;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.bb;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.goods.c.d;
import com.baidu.live.sdk.goods.d.c;
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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.j.b {
    private q aLQ;
    private d bbH;
    private AudienceLiveGoodsEnterView bbI;
    private com.baidu.live.sdk.goods.b.a bbJ;
    private AudienceLiveGoodsExplainView bbK;
    private c bbL;
    private com.baidu.live.sdk.goods.a.a bbQ;
    private String bbR;
    private PendantParentView bbS;
    private boolean bbT;
    private boolean bbU;
    private TbPageContext mTbPageContext;
    private String bbM = "";
    private boolean bbN = false;
    private boolean bbO = false;
    private String bbP = "";
    private boolean bbV = false;
    private com.baidu.live.sdk.goods.c.c bbW = new com.baidu.live.sdk.goods.c.c() { // from class: com.baidu.live.sdk.goods.a.1
        @Override // com.baidu.live.sdk.goods.c.c
        public void a(int i, String str, boolean z, final long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (a.this.aLQ != null && a.this.aLQ.mLiveInfo != null) {
                long j2 = a.this.aLQ.mLiveInfo.room_id;
                final String str2 = a.this.aLQ.mLiveInfo.feed_id;
                if (a.this.bbI != null) {
                    a.this.bbI.a(j2, str2, j, a.this.bbM, i2, list);
                }
                if (!a.this.bbN && z && i2 > 0 && list != null && list.size() > 0 && !a.this.bbT) {
                    if (a.this.bbJ == null) {
                        a.this.bbJ = new com.baidu.live.sdk.goods.b.a();
                    } else {
                        a.this.bbJ.GV();
                    }
                    a.this.bbJ.setOutClickListener(a.this.bbX);
                    a.this.bbJ.a(a.this.mTbPageContext.getPageActivity(), a.this.bbI, j, j2, str2, a.this.bbM, list);
                }
                if (a.this.bbJ != null && i2 < 0) {
                    a.this.bbJ.GV();
                }
                if (!a.this.bbN && !a.this.bbO) {
                    a.this.bbO = true;
                    String str3 = "goods_task_" + j;
                    if (!TextUtils.isEmpty(a.this.bbP) && !str3.equals(a.this.bbP)) {
                        LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bbP, true);
                    }
                    a.this.bbP = str3;
                    long j3 = 10;
                    bb bbVar = com.baidu.live.v.a.Hm().bdV;
                    if (bbVar != null && bbVar.aCX != null) {
                        j3 = bbVar.aCX.aES;
                    }
                    LiveTimerManager.getInstance().addLiveTimerTask(a.this.bbP, j, new OnLiveTimerListener() { // from class: com.baidu.live.sdk.goods.a.1.1
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z2) {
                            if (!a.this.bbN) {
                                a.this.a(str2, j, false, true, a.this.aLQ.mLiveInfo.user_id);
                            }
                        }

                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onInterrupt() {
                        }
                    }, (j3 <= 0 ? 10L : j3) * 1000, true);
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.c.c
        public void c(com.baidu.live.sdk.goods.a.a aVar) {
            if (aVar == null || !aVar.GU()) {
                a.this.t("", false);
            } else if (!aVar.bcp.equals(a.this.bbR)) {
                a.this.bbQ = aVar;
                a.this.bbR = aVar.bcp;
                a.this.a(aVar);
            }
        }
    };
    private View.OnClickListener bbX = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bbN = true;
            if (!TextUtils.isEmpty(a.this.bbP)) {
                LiveTimerManager.getInstance().removeLiveTimerTask(a.this.bbP, true);
            }
            if (a.this.bbL != null && a.this.aLQ != null && a.this.aLQ.mLiveInfo != null) {
                long j = a.this.aLQ.mLiveInfo.live_id;
                String valueOf = String.valueOf(a.this.aLQ.mLiveInfo.feed_id);
                long j2 = a.this.aLQ.mLiveInfo.room_id;
                String str = a.this.aLQ.mLiveInfo.cover;
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (a.this.aLQ.mLiveInfo.session_info != null) {
                    str2 = a.this.aLQ.mLiveInfo.session_info.flvUrl;
                }
                if (!TextUtils.isEmpty(a.this.bbM)) {
                    try {
                        JSONObject jSONObject = new JSONObject(a.this.bbM);
                        str3 = jSONObject.optString("tab");
                        str4 = jSONObject.optString("tag");
                        str5 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j3 = a.this.aLQ.axI.userId;
                long j4 = a.this.aLQ.mLiveInfo.group_id;
                a.this.bbL.u(com.baidu.live.sdk.goods.e.a.a(valueOf, j + "", j2, false, 1, str, str2, str3, str4, str5, String.valueOf(j3), a.this.aLQ.axI.userName, String.valueOf(j4), String.valueOf(a.this.aLQ.axp.userId)), false);
                if (!ILiveGoodsLogger.displayGoodsListMap.contains(Long.valueOf(j))) {
                    ILiveGoodsLogger.displayGoodsListMap.add(Long.valueOf(j));
                    LogManager.getLiveGoodsLogger().doDisplayGoodsListLog(j + "", j2 + "", valueOf, a.this.bbM);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "shopcart_clk"));
            }
        }
    };
    private AudienceLiveGoodsExplainView.a bbY = new AudienceLiveGoodsExplainView.a() { // from class: com.baidu.live.sdk.goods.a.3
        @Override // com.baidu.live.sdk.goods.view.AudienceLiveGoodsExplainView.a
        public void a(View view, com.baidu.live.sdk.goods.a.a aVar) {
            a.this.t(aVar.bcp, true);
        }
    };
    private View.OnClickListener bbZ = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.a.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.R(view);
        }
    };

    @Override // com.baidu.live.j.b
    public void d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bbH == null) {
            this.bbH = new d(tbPageContext);
        }
        this.bbH.init();
        this.bbH.a(this.bbW);
        this.bbL = new com.baidu.live.sdk.goods.d.a(tbPageContext);
    }

    @Override // com.baidu.live.j.b
    public com.baidu.live.core.a.a Fn() {
        if (this.bbI == null) {
            this.bbI = new AudienceLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bbI.setOutClickListener(this.bbX);
        }
        return this.bbI;
    }

    @Override // com.baidu.live.j.b
    public void a(String str, long j, boolean z, boolean z2, long j2) {
        if (this.bbH != null) {
            this.bbH.a(str, j, z, z2, j2);
        }
    }

    @Override // com.baidu.live.j.b
    public void a(q qVar, PendantParentView pendantParentView) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.bbS = pendantParentView;
            this.bbN = false;
            this.bbO = false;
            this.aLQ = qVar;
            if (qVar.mLiveInfo != null) {
                String str = qVar.mLiveInfo.feed_id;
                long j = qVar.mLiveInfo.live_id;
                a(str, j, false, false, qVar.mLiveInfo.user_id);
                b(qVar.mLiveInfo.introducegoods, str, j);
            }
        }
    }

    private void b(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            if (this.bbH != null) {
                this.bbH.c(str2, j, str);
                return;
            }
            return;
        }
        t("", false);
    }

    @Override // com.baidu.live.j.b
    public void i(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null) {
            this.aLQ = qVar;
            if (this.bbI != null && this.bbI.getRootLayout() != null && qVar.mLiveInfo != null) {
                boolean z = this.bbI.Hi() != qVar.mLiveInfo.isGoodsListVisible();
                String str = qVar.mLiveInfo.feed_id;
                long j = qVar.mLiveInfo.live_id;
                if (z) {
                    this.bbH.a(str, j, false, false, qVar.mLiveInfo.user_id);
                }
            }
            if (qVar.mLiveInfo != null) {
                if (TextUtils.isEmpty(qVar.mLiveInfo.introducegoods) || "0".equals(qVar.mLiveInfo.introducegoods)) {
                    this.bbV = false;
                    this.bbU = false;
                    this.bbR = null;
                } else if (qVar.mLiveInfo.introducegoods.equals(this.bbR)) {
                    this.bbU = false;
                } else {
                    this.bbU = true;
                }
            }
            if (qVar.mLiveInfo != null && this.bbU && qVar.mLiveInfo.isGoodsListVisible()) {
                String str2 = qVar.mLiveInfo.feed_id;
                long j2 = qVar.mLiveInfo.live_id;
                this.bbU = false;
                b(qVar.mLiveInfo.introducegoods, str2, j2);
            } else if (TextUtils.isEmpty(this.bbR) || (qVar.mLiveInfo != null && !qVar.mLiveInfo.isGoodsListVisible())) {
                t(this.bbR, false);
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void onResume() {
        if (this.bbL != null) {
            this.bbL.resume();
        }
    }

    @Override // com.baidu.live.j.b
    public void onPause() {
        if (this.bbL != null) {
            this.bbL.pause();
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
                    J(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    private void J(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString("gid");
            long optLong = jSONObject.optLong("live_id");
            if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
                if (optInt == 1) {
                    String valueOf = String.valueOf(this.aLQ.mLiveInfo.feed_id);
                    if (TextUtils.isEmpty(this.bbR) || !this.bbR.equals(optString)) {
                        this.bbH.c(valueOf, optLong, optString);
                    }
                } else if (optInt == 2) {
                    this.bbV = false;
                    this.bbR = null;
                    t(optString, false);
                }
            }
        }
    }

    @Override // com.baidu.live.j.b
    public void Fo() {
        this.bbT = false;
        if (this.bbH != null) {
            this.bbH.cancelMessage();
        }
        if (this.bbL != null) {
            this.bbL.release();
        }
        if (this.bbI != null) {
            this.bbI.release();
        }
        if (this.bbJ != null) {
            this.bbJ.release();
        }
        if (!TextUtils.isEmpty(this.bbP)) {
            LiveTimerManager.getInstance().removeLiveTimerTask(this.bbP, true);
        }
        t(this.bbR, false);
        this.bbQ = null;
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
    }

    @Override // com.baidu.live.j.b
    public void release() {
        if (this.bbH != null) {
            this.bbH.cancelLoadData();
            this.bbH.release();
        }
        if (this.bbL != null) {
            this.bbL.release();
        }
        if (this.bbI != null) {
            this.bbI.release();
        }
        if (this.bbJ != null) {
            this.bbJ.release();
        }
        this.bbR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.sdk.goods.a.a aVar) {
        if (this.bbJ != null && this.bbJ.isShow()) {
            this.bbJ.GV();
        }
        this.bbT = true;
        if (this.bbK == null) {
            this.bbK = new AudienceLiveGoodsExplainView(this.mTbPageContext.getPageActivity());
            this.bbK.setOnClickListener(this.bbZ);
            this.bbK.setOnCloseBtnClickListener(this.bbY);
            this.bbK.a(this.bbS);
        } else if (this.bbS != null) {
            this.bbK.a(this.bbS);
        }
        this.bbK.d(aVar);
        this.bbK.setVisibility(0);
        b(aVar);
    }

    private void b(com.baidu.live.sdk.goods.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("livesdk", TbConfig.getVersion());
            jSONObject.put("gid", aVar.bcp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "intcard_show").setContentExt(jSONObject));
    }

    @Override // com.baidu.live.j.b
    public void fB(String str) {
        this.bbM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.bbQ != null) {
            if (z) {
                this.bbV = true;
                aB(str, "intcardclose");
            }
            if (this.bbK.getVisibility() == 0) {
                this.bbK.setVisibility(8);
                if (this.bbS != null && this.bbK.getParent() != null) {
                    this.bbS.removeView(this.bbK);
                }
                this.bbQ = null;
            }
            this.bbT = false;
        }
    }

    private void aB(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("livesdk", TbConfig.getVersion());
            jSONObject.put("gid", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, str2).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view) {
        if (this.bbQ != null) {
            aB(this.bbQ.bcp, "intcard_clk");
            bb bbVar = com.baidu.live.v.a.Hm().bdV;
            if (bbVar != null && bbVar.aCX != null) {
                q qVar = this.aLQ;
                if (this.bbL != null && qVar != null && qVar.mLiveInfo != null) {
                    long j = qVar.mLiveInfo.room_id;
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (!TextUtils.isEmpty(this.bbM)) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.bbM);
                            str = jSONObject.optString("tab");
                            str2 = jSONObject.optString("tag");
                            str3 = jSONObject.optString("source");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    long j2 = qVar.axI.userId;
                    String str4 = qVar.axI.userName;
                    long j3 = qVar.mLiveInfo.group_id;
                    long j4 = qVar.axp.userId;
                    String str5 = this.bbQ.bcD;
                    String str6 = this.bbQ.bcC;
                    String str7 = bbVar.aCX.appKey;
                    String str8 = bbVar.aCX.aEV;
                    if (str8 == null) {
                        str8 = "";
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str5.replace("{{DEEPLINK_APPKEY}}", str7).replace("{{DEEPLINK_BACKURL}}", com.baidu.live.sdk.goods.e.a.a(String.valueOf(qVar.mLiveInfo.live_id), j, false, str, str2, str3)).replace("{{DEEPLINK_KEPLERID}}", str8)));
                    List<ResolveInfo> list = null;
                    PackageManager packageManager = this.mTbPageContext.getPageActivity().getPackageManager();
                    if (packageManager != null) {
                        list = packageManager.queryIntentActivities(intent, 0);
                    }
                    boolean z = (list == null || list.isEmpty()) ? false : true;
                    boolean z2 = true;
                    if (TbadkCoreApplication.getInst().isTieba() && "京东".equals(this.bbQ.platform)) {
                        z2 = false;
                    }
                    if (z && z2) {
                        intent.addFlags(268435456);
                        this.mTbPageContext.getPageActivity().startActivity(intent);
                    } else {
                        SchemeUtils.openScheme(str6);
                    }
                    com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
                    aVar.a(qVar.mLiveInfo.live_id, j2, str4, j4, j3);
                    MessageManager.getInstance().sendMessage(aVar);
                }
            }
        }
    }
}
