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
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.c.d;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
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
/* loaded from: classes10.dex */
public class c implements a {
    private ab aED;
    private com.baidu.live.sdk.goods.b.b bBA;
    private com.baidu.live.view.c bBB;
    private Set<String> bBC;
    private HttpMessageListener bBy;
    private d bBz;
    private List<com.baidu.live.sdk.goods.a.a> bfU;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void PX() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(ab abVar) {
        this.aED = abVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bBC != null) {
                this.bBC.clear();
            }
            PZ();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bBz != null && this.bBz.isShowing()) {
            this.bBz.dU(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void cs(int i) {
        if (this.bBz != null && this.bBz.isShowing()) {
            this.bBz.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void FB() {
        unRegisterListener();
        if (this.bBC != null) {
            this.bBC.clear();
        }
        if (this.bfU != null) {
            this.bfU.clear();
        }
        if (this.bBA != null) {
            this.bBA.release();
            this.bBA = null;
        }
        if (this.bBB != null) {
            this.bBB.dismiss();
            this.bBB = null;
        }
        if (this.bBz != null) {
            this.bBz.dismiss();
            this.bBz = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        FB();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bBy = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bfU == null) {
                            c.this.bfU = new ArrayList();
                        }
                        c.this.bfU.clear();
                        if (getVideoGoodsListHttpResponseMessage.bBg != null) {
                            c.this.bfU.addAll(getVideoGoodsListHttpResponseMessage.bBg);
                        }
                        if (!c.this.bfU.isEmpty()) {
                            Collections.sort(c.this.bfU, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bAE < aVar2.bAE) {
                                        return -1;
                                    }
                                    return aVar.bAE == aVar2.bAE ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bBz != null && c.this.bBz.isShowing()) {
                            c.this.bBz.setData(c.this.bfU);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bBy);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bBy);
    }

    private void PZ() {
        this.bBz = new d(this.mPageContext.getPageActivity());
        this.bBz.setHost(this.mIsHost);
        this.bBz.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void Qc() {
                c.this.Qa();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.z(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.A(aVar.gid, aVar.bAP);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void x(String str, boolean z) {
                c.this.y(str, z);
                c.this.B(str, z);
            }
        });
        if (this.bfU != null) {
            this.bBz.setData(this.bfU);
        }
        this.bBz.dT(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qa() {
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str = "";
            if (this.aED == null || this.aED.mLiveInfo == null) {
                j = 0;
            } else {
                if (this.aED.mLiveInfo.feed_id != null) {
                    str = this.aED.mLiveInfo.feed_id;
                }
                j = this.aED.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bAJ != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bAO && !TextUtils.isEmpty(aVar.bAM)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bAM));
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
                hA(aVar.bAN);
            } else {
                hA(aVar.bAL);
            }
        }
    }

    private void Qb() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aED != null && this.aED.aJZ != null && this.aED.mLiveInfo != null && this.aED.aJD != null) {
            long j = this.aED.aJZ.userId;
            String str = this.aED.aJZ.userName;
            long j2 = this.aED.mLiveInfo.group_id;
            long j3 = this.aED.aJD.userId;
            long j4 = this.aED.mLiveInfo.live_id;
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
                Qb();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hA(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            Qb();
        }
    }

    private void m(final Intent intent) {
        this.bBB = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.bBB.setCancelable(false);
        this.bBB.setCanceledOnTouchOutside(false);
        this.bBB.dD(false);
        this.bBB.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.bBB.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void Qd() {
                c.this.bBB.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void Qe() {
                c.this.bBB.dismiss();
            }
        });
        this.bBB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        long j;
        long j2;
        if (this.bBA == null) {
            this.bBA = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        long j3 = 0;
        long j4 = 0;
        if (this.aED == null || this.aED.mLiveInfo == null) {
            j = 0;
            j2 = 0;
        } else {
            j3 = this.aED.mLiveInfo.live_id;
            long j5 = this.aED.mLiveInfo.user_id;
            j4 = this.aED.mLiveInfo.room_id;
            j = this.aED.mLiveInfo.group_id;
            j2 = j5;
        }
        this.bBA.a(j3 != 0 ? String.valueOf(j3) : "", str, z ? 2 : 1, j4 != 0 ? String.valueOf(j4) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bBC == null) {
                this.bBC = new HashSet();
            }
            if (!this.bBC.contains(str)) {
                this.bBC.add(str);
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
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", this.mIsHost ? "author_liveroom" : "liveroom", this.mIsHost ? "interpret_show" : "goods_show").setContentExt(jSONObject));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str, boolean z) {
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
    public void B(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gid", str);
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? "cancel" : "intpret");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "interpret_clk").setContentExt(jSONObject));
    }
}
