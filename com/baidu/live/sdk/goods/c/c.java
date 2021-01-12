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
/* loaded from: classes10.dex */
public class c implements a {
    private x aBr;
    private List<com.baidu.live.sdk.goods.a.a> bbl;
    private Set<String> bwA;
    private HttpMessageListener bww;
    private d bwx;
    private com.baidu.live.sdk.goods.b.b bwy;
    private com.baidu.live.view.c bwz;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Ov() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(x xVar) {
        this.aBr = xVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void rV() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bwA != null) {
                this.bwA.clear();
            }
            Ox();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bwx != null && this.bwx.isShowing()) {
            this.bwx.dM(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void co(int i) {
        if (this.bwx != null && this.bwx.isShowing()) {
            this.bwx.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Ei() {
        unRegisterListener();
        if (this.bwA != null) {
            this.bwA.clear();
        }
        if (this.bbl != null) {
            this.bbl.clear();
        }
        if (this.bwy != null) {
            this.bwy.release();
            this.bwy = null;
        }
        if (this.bwz != null) {
            this.bwz.dismiss();
            this.bwz = null;
        }
        if (this.bwx != null) {
            this.bwx.dismiss();
            this.bwx = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Ei();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bww = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bbl == null) {
                            c.this.bbl = new ArrayList();
                        }
                        c.this.bbl.clear();
                        if (getVideoGoodsListHttpResponseMessage.bwe != null) {
                            c.this.bbl.addAll(getVideoGoodsListHttpResponseMessage.bwe);
                        }
                        if (!c.this.bbl.isEmpty()) {
                            Collections.sort(c.this.bbl, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bvC < aVar2.bvC) {
                                        return -1;
                                    }
                                    return aVar.bvC == aVar2.bvC ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bwx != null && c.this.bwx.isShowing()) {
                            c.this.bwx.setData(c.this.bbl);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bww);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bww);
    }

    private void Ox() {
        this.bwx = new d(this.mPageContext.getPageActivity());
        this.bwx.setHost(this.mIsHost);
        this.bwx.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void OA() {
                c.this.Oy();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.z(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.A(aVar.gid, aVar.bvN);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void x(String str, boolean z) {
                c.this.y(str, z);
                c.this.B(str, z);
            }
        });
        if (this.bbl != null) {
            this.bwx.setData(this.bbl);
        }
        this.bwx.dQ(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str = "";
            if (this.aBr == null || this.aBr.mLiveInfo == null) {
                j = 0;
            } else {
                if (this.aBr.mLiveInfo.feed_id != null) {
                    str = this.aBr.mLiveInfo.feed_id;
                }
                j = this.aBr.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bvH != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bvM && !TextUtils.isEmpty(aVar.bvK)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bvK));
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
                gY(aVar.bvL);
            } else {
                gY(aVar.bvJ);
            }
        }
    }

    private void Oz() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aBr != null && this.aBr.aGd != null && this.aBr.mLiveInfo != null && this.aBr.aFH != null) {
            long j = this.aBr.aGd.userId;
            String str = this.aBr.aGd.userName;
            long j2 = this.aBr.mLiveInfo.group_id;
            long j3 = this.aBr.aFH.userId;
            long j4 = this.aBr.mLiveInfo.live_id;
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
                Oz();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void gY(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            Oz();
        }
    }

    private void m(final Intent intent) {
        this.bwz = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.bwz.setCancelable(false);
        this.bwz.setCanceledOnTouchOutside(false);
        this.bwz.dv(false);
        this.bwz.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.bwz.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void OB() {
                c.this.bwz.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void OC() {
                c.this.bwz.dismiss();
            }
        });
        this.bwz.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        long j;
        long j2;
        if (this.bwy == null) {
            this.bwy = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        long j3 = 0;
        long j4 = 0;
        if (this.aBr == null || this.aBr.mLiveInfo == null) {
            j = 0;
            j2 = 0;
        } else {
            j3 = this.aBr.mLiveInfo.live_id;
            long j5 = this.aBr.mLiveInfo.user_id;
            j4 = this.aBr.mLiveInfo.room_id;
            j = this.aBr.mLiveInfo.group_id;
            j2 = j5;
        }
        this.bwy.a(j3 != 0 ? String.valueOf(j3) : "", str, z ? 2 : 1, j4 != 0 ? String.valueOf(j4) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bwA == null) {
                this.bwA = new HashSet();
            }
            if (!this.bwA.contains(str)) {
                this.bwA.add(str);
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
