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
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class c implements a {
    private x aGe;
    private HttpMessageListener bBi;
    private d bBj;
    private com.baidu.live.sdk.goods.b.b bBk;
    private com.baidu.live.view.c bBl;
    private Set<String> bBm;
    private List<com.baidu.live.sdk.goods.a.a> bgb;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Sq() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(x xVar) {
        this.aGe = xVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void rV() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bBm != null) {
                this.bBm.clear();
            }
            Ss();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bBj != null && this.bBj.isShowing()) {
            this.bBj.fs(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dU(int i) {
        if (this.bBj != null && this.bBj.isShowing()) {
            this.bBj.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Id() {
        unRegisterListener();
        if (this.bBm != null) {
            this.bBm.clear();
        }
        if (this.bgb != null) {
            this.bgb.clear();
        }
        if (this.bBk != null) {
            this.bBk.release();
            this.bBk = null;
        }
        if (this.bBl != null) {
            this.bBl.dismiss();
            this.bBl = null;
        }
        if (this.bBj != null) {
            this.bBj.dismiss();
            this.bBj = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Id();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bBi = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bgb == null) {
                            c.this.bgb = new ArrayList();
                        }
                        c.this.bgb.clear();
                        if (getVideoGoodsListHttpResponseMessage.bAQ != null) {
                            c.this.bgb.addAll(getVideoGoodsListHttpResponseMessage.bAQ);
                        }
                        if (!c.this.bgb.isEmpty()) {
                            Collections.sort(c.this.bgb, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bAo < aVar2.bAo) {
                                        return -1;
                                    }
                                    return aVar.bAo == aVar2.bAo ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bBj != null && c.this.bBj.isShowing()) {
                            c.this.bBj.setData(c.this.bgb);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bBi);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bBi);
    }

    private void Ss() {
        this.bBj = new d(this.mPageContext.getPageActivity());
        this.bBj.setHost(this.mIsHost);
        this.bBj.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void Sv() {
                c.this.St();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.z(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.A(aVar.gid, aVar.bAz);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void x(String str, boolean z) {
                c.this.y(str, z);
                c.this.B(str, z);
            }
        });
        if (this.bgb != null) {
            this.bBj.setData(this.bgb);
        }
        this.bBj.fw(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void St() {
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str = "";
            if (this.aGe == null || this.aGe.mLiveInfo == null) {
                j = 0;
            } else {
                if (this.aGe.mLiveInfo.feed_id != null) {
                    str = this.aGe.mLiveInfo.feed_id;
                }
                j = this.aGe.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bAt != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bAy && !TextUtils.isEmpty(aVar.bAw)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bAw));
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
                ij(aVar.bAx);
            } else {
                ij(aVar.bAv);
            }
        }
    }

    private void Su() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aGe != null && this.aGe.aKQ != null && this.aGe.mLiveInfo != null && this.aGe.aKu != null) {
            long j = this.aGe.aKQ.userId;
            String str = this.aGe.aKQ.userName;
            long j2 = this.aGe.mLiveInfo.group_id;
            long j3 = this.aGe.aKu.userId;
            long j4 = this.aGe.mLiveInfo.live_id;
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
                Su();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void ij(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            Su();
        }
    }

    private void m(final Intent intent) {
        this.bBl = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.bBl.setCancelable(false);
        this.bBl.setCanceledOnTouchOutside(false);
        this.bBl.dz(false);
        this.bBl.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.bBl.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void Sw() {
                c.this.bBl.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void Sx() {
                c.this.bBl.dismiss();
            }
        });
        this.bBl.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        long j;
        long j2;
        if (this.bBk == null) {
            this.bBk = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        long j3 = 0;
        long j4 = 0;
        if (this.aGe == null || this.aGe.mLiveInfo == null) {
            j = 0;
            j2 = 0;
        } else {
            j3 = this.aGe.mLiveInfo.live_id;
            long j5 = this.aGe.mLiveInfo.user_id;
            j4 = this.aGe.mLiveInfo.room_id;
            j = this.aGe.mLiveInfo.group_id;
            j2 = j5;
        }
        this.bBk.a(j3 != 0 ? String.valueOf(j3) : "", str, z ? 2 : 1, j4 != 0 ? String.valueOf(j4) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bBm == null) {
                this.bBm = new HashSet();
            }
            if (!this.bBm.contains(str)) {
                this.bBm.add(str);
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
