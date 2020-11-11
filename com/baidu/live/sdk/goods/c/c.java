package com.baidu.live.sdk.goods.c;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.c.d;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.c;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements a {
    private w aES;
    private List<com.baidu.live.sdk.goods.a.a> bsU;
    private HttpMessageListener bsY;
    private d bsZ;
    private com.baidu.live.sdk.goods.b.b bta;
    private com.baidu.live.view.c btb;
    private Set<String> btc;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void PC() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(w wVar) {
        this.aES = wVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.btc != null) {
                this.btc.clear();
            }
            PE();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bsZ != null && this.bsZ.isShowing()) {
            this.bsZ.eY(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dI(int i) {
        if (this.bsZ != null && this.bsZ.isShowing()) {
            this.bsZ.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Ht() {
        unRegisterListener();
        if (this.btc != null) {
            this.btc.clear();
        }
        if (this.bsU != null) {
            this.bsU.clear();
        }
        if (this.bta != null) {
            this.bta.release();
            this.bta = null;
        }
        if (this.btb != null) {
            this.btb.dismiss();
            this.btb = null;
        }
        if (this.bsZ != null) {
            this.bsZ.dismiss();
            this.bsZ = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Ht();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bsY = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bsU == null) {
                            c.this.bsU = new ArrayList();
                        }
                        c.this.bsU.clear();
                        if (getVideoGoodsListHttpResponseMessage.bsF != null) {
                            c.this.bsU.addAll(getVideoGoodsListHttpResponseMessage.bsF);
                        }
                        if (!c.this.bsU.isEmpty()) {
                            Collections.sort(c.this.bsU, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bsd < aVar2.bsd) {
                                        return -1;
                                    }
                                    return aVar.bsd == aVar2.bsd ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bsZ != null && c.this.bsZ.isShowing()) {
                            c.this.bsZ.setData(c.this.bsU);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bsY);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bsY);
    }

    private void PE() {
        this.bsZ = new d(this.mPageContext.getPageActivity());
        this.bsZ.setHost(this.mIsHost);
        this.bsZ.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void PH() {
                c.this.PF();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.y(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.z(aVar.gid, aVar.bso);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.x(str, z);
                c.this.A(str, z);
            }
        });
        if (this.bsU != null) {
            this.bsZ.setData(this.bsU);
        }
        this.bsZ.fc(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aES == null || this.aES.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aES.mLiveInfo.feed_id != null) {
                    str2 = this.aES.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aES.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bsi != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bsn && !TextUtils.isEmpty(aVar.bsl)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bsl));
                List<ResolveInfo> list = null;
                if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && (packageManager = this.mPageContext.getPageActivity().getPackageManager()) != null) {
                    list = packageManager.queryIntentActivities(intent, 0);
                }
                if (list != null && !list.isEmpty()) {
                    if (SharedPrefHelper.getInstance().getBoolean("live_goods_nav_thirdparty_disclaimered", false)) {
                        l(intent);
                        return;
                    } else {
                        m(intent);
                        return;
                    }
                }
                hY(aVar.bsm);
            } else {
                hY(aVar.bsk);
            }
        }
    }

    private void PG() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aES != null && this.aES.aJr != null && this.aES.mLiveInfo != null && this.aES.aIV != null) {
            long j = this.aES.aJr.userId;
            String str = this.aES.aJr.userName;
            long j2 = this.aES.mLiveInfo.group_id;
            long j3 = this.aES.aIV.userId;
            long j4 = this.aES.mLiveInfo.live_id;
            com.baidu.live.sdk.goods.message.a aVar = new com.baidu.live.sdk.goods.message.a();
            aVar.a(j4, j, str, j3, j2);
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Intent intent) {
        if (intent != null) {
            try {
                intent.addFlags(268435456);
                this.mPageContext.getPageActivity().startActivity(intent);
                PG();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hY(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            PG();
        }
    }

    private void m(final Intent intent) {
        this.btb = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.btb.setCancelable(false);
        this.btb.setCanceledOnTouchOutside(false);
        this.btb.dg(false);
        this.btb.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.btb.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void PI() {
                c.this.btb.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void PJ() {
                c.this.btb.dismiss();
            }
        });
        this.btb.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bta == null) {
            this.bta = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aES == null || this.aES.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aES.mLiveInfo.live_id;
            long j6 = this.aES.mLiveInfo.user_id;
            j3 = this.aES.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aES.mLiveInfo.group_id;
        }
        this.bta.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.btc == null) {
                this.btc = new HashSet();
            }
            if (!this.btc.contains(str)) {
                this.btc.add(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("gid", str);
                    if (this.mIsHost) {
                        jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "cancel" : "intpret");
                    } else {
                        jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? 1 : 0);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", this.mIsHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", this.mIsHost ? "interpret_show" : "goods_show").setContentExt(jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!this.mIsHost) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gid", str);
                jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? 1 : 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "goods_clk").setContentExt(jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gid", str);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "cancel" : "intpret");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "interpret_clk").setContentExt(jSONObject));
    }
}
