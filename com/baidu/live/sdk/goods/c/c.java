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
import com.baidu.live.data.r;
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
import com.baidu.live.view.d;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements a {
    private r aAh;
    private List<com.baidu.live.sdk.goods.a.a> bjc;
    private HttpMessageListener bjg;
    private d bjh;
    private com.baidu.live.sdk.goods.b.b bji;
    private com.baidu.live.view.d bjj;
    private Set<String> bjk;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void MV() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(r rVar) {
        this.aAh = rVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bjk != null) {
                this.bjk.clear();
            }
            MX();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bjh != null && this.bjh.isShowing()) {
            this.bjh.eF(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dz(int i) {
        if (this.bjh != null && this.bjh.isShowing()) {
            this.bjh.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Fb() {
        unRegisterListener();
        if (this.bjk != null) {
            this.bjk.clear();
        }
        if (this.bjc != null) {
            this.bjc.clear();
        }
        if (this.bji != null) {
            this.bji.release();
            this.bji = null;
        }
        if (this.bjj != null) {
            this.bjj.dismiss();
            this.bjj = null;
        }
        if (this.bjh != null) {
            this.bjh.dismiss();
            this.bjh = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Fb();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bjg = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bjc == null) {
                            c.this.bjc = new ArrayList();
                        }
                        c.this.bjc.clear();
                        if (getVideoGoodsListHttpResponseMessage.biP != null) {
                            c.this.bjc.addAll(getVideoGoodsListHttpResponseMessage.biP);
                        }
                        if (!c.this.bjc.isEmpty()) {
                            Collections.sort(c.this.bjc, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bim < aVar2.bim) {
                                        return -1;
                                    }
                                    return aVar.bim == aVar2.bim ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bjh != null && c.this.bjh.isShowing()) {
                            c.this.bjh.setData(c.this.bjc);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bjg);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bjg);
    }

    private void MX() {
        this.bjh = new d(this.mPageContext.getPageActivity());
        this.bjh.setHost(this.mIsHost);
        this.bjh.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void Na() {
                c.this.MY();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void u(String str, boolean z) {
                c.this.x(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.y(aVar.gid, aVar.biy);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.w(str, z);
                c.this.z(str, z);
            }
        });
        if (this.bjc != null) {
            this.bjh.setData(this.bjc);
        }
        this.bjh.eE(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aAh == null || this.aAh.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aAh.mLiveInfo.feed_id != null) {
                    str2 = this.aAh.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aAh.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.m(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bis != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bix && !TextUtils.isEmpty(aVar.biv)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.biv));
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
                hb(aVar.biw);
            } else {
                hb(aVar.biu);
            }
        }
    }

    private void MZ() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aAh != null && this.aAh.aEd != null && this.aAh.mLiveInfo != null && this.aAh.aDE != null) {
            long j = this.aAh.aEd.userId;
            String str = this.aAh.aEd.userName;
            long j2 = this.aAh.mLiveInfo.group_id;
            long j3 = this.aAh.aDE.userId;
            long j4 = this.aAh.mLiveInfo.live_id;
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
                MZ();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hb(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            MZ();
        }
    }

    private void m(final Intent intent) {
        this.bjj = new com.baidu.live.view.d(this.mPageContext.getPageActivity());
        this.bjj.setCancelable(false);
        this.bjj.setCanceledOnTouchOutside(false);
        this.bjj.cK(false);
        this.bjj.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), this.mPageContext.getString(a.i.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bjj.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.d.a
            public void Nb() {
                c.this.bjj.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.d.a
            public void Nc() {
                c.this.bjj.dismiss();
            }
        });
        this.bjj.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bji == null) {
            this.bji = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aAh == null || this.aAh.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aAh.mLiveInfo.live_id;
            long j6 = this.aAh.mLiveInfo.user_id;
            j3 = this.aAh.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aAh.mLiveInfo.group_id;
        }
        this.bji.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bjk == null) {
                this.bjk = new HashSet();
            }
            if (!this.bjk.contains(str)) {
                this.bjk.add(str);
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
    public void y(String str, boolean z) {
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
    public void z(String str, boolean z) {
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
