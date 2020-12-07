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
    private w aFN;
    private List<com.baidu.live.sdk.goods.a.a> bep;
    private com.baidu.live.view.c bwA;
    private Set<String> bwB;
    private HttpMessageListener bwx;
    private d bwy;
    private com.baidu.live.sdk.goods.b.b bwz;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Rn() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(w wVar) {
        this.aFN = wVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void su() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bwB != null) {
                this.bwB.clear();
            }
            Rp();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bwy != null && this.bwy.isShowing()) {
            this.bwy.fs(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dX(int i) {
        if (this.bwy != null && this.bwy.isShowing()) {
            this.bwy.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void IB() {
        unRegisterListener();
        if (this.bwB != null) {
            this.bwB.clear();
        }
        if (this.bep != null) {
            this.bep.clear();
        }
        if (this.bwz != null) {
            this.bwz.release();
            this.bwz = null;
        }
        if (this.bwA != null) {
            this.bwA.dismiss();
            this.bwA = null;
        }
        if (this.bwy != null) {
            this.bwy.dismiss();
            this.bwy = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        IB();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bwx = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bep == null) {
                            c.this.bep = new ArrayList();
                        }
                        c.this.bep.clear();
                        if (getVideoGoodsListHttpResponseMessage.bwf != null) {
                            c.this.bep.addAll(getVideoGoodsListHttpResponseMessage.bwf);
                        }
                        if (!c.this.bep.isEmpty()) {
                            Collections.sort(c.this.bep, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bvD < aVar2.bvD) {
                                        return -1;
                                    }
                                    return aVar.bvD == aVar2.bvD ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bwy != null && c.this.bwy.isShowing()) {
                            c.this.bwy.setData(c.this.bep);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bwx);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bwx);
    }

    private void Rp() {
        this.bwy = new d(this.mPageContext.getPageActivity());
        this.bwy.setHost(this.mIsHost);
        this.bwy.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void Rs() {
                c.this.Rq();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.z(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.A(aVar.gid, aVar.bvO);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void x(String str, boolean z) {
                c.this.y(str, z);
                c.this.B(str, z);
            }
        });
        if (this.bep != null) {
            this.bwy.setData(this.bep);
        }
        this.bwy.fw(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rq() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aFN == null || this.aFN.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aFN.mLiveInfo.feed_id != null) {
                    str2 = this.aFN.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aFN.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bvI != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bvN && !TextUtils.isEmpty(aVar.bvL)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bvL));
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
                iw(aVar.bvM);
            } else {
                iw(aVar.bvK);
            }
        }
    }

    private void Rr() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aFN != null && this.aFN.aKr != null && this.aFN.mLiveInfo != null && this.aFN.aJV != null) {
            long j = this.aFN.aKr.userId;
            String str = this.aFN.aKr.userName;
            long j2 = this.aFN.mLiveInfo.group_id;
            long j3 = this.aFN.aJV.userId;
            long j4 = this.aFN.mLiveInfo.live_id;
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
                Rr();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void iw(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            Rr();
        }
    }

    private void m(final Intent intent) {
        this.bwA = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.bwA.setCancelable(false);
        this.bwA.setCanceledOnTouchOutside(false);
        this.bwA.dw(false);
        this.bwA.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.bwA.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void Rt() {
                c.this.bwA.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void Ru() {
                c.this.bwA.dismiss();
            }
        });
        this.bwA.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bwz == null) {
            this.bwz = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aFN == null || this.aFN.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aFN.mLiveInfo.live_id;
            long j6 = this.aFN.mLiveInfo.user_id;
            j3 = this.aFN.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aFN.mLiveInfo.group_id;
        }
        this.bwz.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bwB == null) {
                this.bwB = new HashSet();
            }
            if (!this.bwB.contains(str)) {
                this.bwB.add(str);
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
