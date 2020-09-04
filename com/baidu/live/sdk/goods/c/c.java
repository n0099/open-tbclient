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
    private r aAj;
    private List<com.baidu.live.sdk.goods.a.a> bjf;
    private HttpMessageListener bjj;
    private d bjk;
    private com.baidu.live.sdk.goods.b.b bjl;
    private com.baidu.live.view.d bjm;
    private Set<String> bjn;
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
        this.aAj = rVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bjn != null) {
                this.bjn.clear();
            }
            MX();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bjk != null && this.bjk.isShowing()) {
            this.bjk.eF(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dz(int i) {
        if (this.bjk != null && this.bjk.isShowing()) {
            this.bjk.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Fb() {
        unRegisterListener();
        if (this.bjn != null) {
            this.bjn.clear();
        }
        if (this.bjf != null) {
            this.bjf.clear();
        }
        if (this.bjl != null) {
            this.bjl.release();
            this.bjl = null;
        }
        if (this.bjm != null) {
            this.bjm.dismiss();
            this.bjm = null;
        }
        if (this.bjk != null) {
            this.bjk.dismiss();
            this.bjk = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Fb();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bjj = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bjf == null) {
                            c.this.bjf = new ArrayList();
                        }
                        c.this.bjf.clear();
                        if (getVideoGoodsListHttpResponseMessage.biS != null) {
                            c.this.bjf.addAll(getVideoGoodsListHttpResponseMessage.biS);
                        }
                        if (!c.this.bjf.isEmpty()) {
                            Collections.sort(c.this.bjf, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.biq < aVar2.biq) {
                                        return -1;
                                    }
                                    return aVar.biq == aVar2.biq ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bjk != null && c.this.bjk.isShowing()) {
                            c.this.bjk.setData(c.this.bjf);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bjj);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bjj);
    }

    private void MX() {
        this.bjk = new d(this.mPageContext.getPageActivity());
        this.bjk.setHost(this.mIsHost);
        this.bjk.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
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
                c.this.y(aVar.gid, aVar.biB);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.w(str, z);
                c.this.z(str, z);
            }
        });
        if (this.bjf != null) {
            this.bjk.setData(this.bjf);
        }
        this.bjk.eE(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aAj == null || this.aAj.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aAj.mLiveInfo.feed_id != null) {
                    str2 = this.aAj.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aAj.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.m(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.biv != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.biA && !TextUtils.isEmpty(aVar.biy)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.biy));
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
                hc(aVar.biz);
            } else {
                hc(aVar.bix);
            }
        }
    }

    private void MZ() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aAj != null && this.aAj.aEf != null && this.aAj.mLiveInfo != null && this.aAj.aDG != null) {
            long j = this.aAj.aEf.userId;
            String str = this.aAj.aEf.userName;
            long j2 = this.aAj.mLiveInfo.group_id;
            long j3 = this.aAj.aDG.userId;
            long j4 = this.aAj.mLiveInfo.live_id;
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

    private void hc(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            MZ();
        }
    }

    private void m(final Intent intent) {
        this.bjm = new com.baidu.live.view.d(this.mPageContext.getPageActivity());
        this.bjm.setCancelable(false);
        this.bjm.setCanceledOnTouchOutside(false);
        this.bjm.cL(false);
        this.bjm.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), this.mPageContext.getString(a.i.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bjm.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.d.a
            public void Nb() {
                c.this.bjm.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.d.a
            public void Nc() {
                c.this.bjm.dismiss();
            }
        });
        this.bjm.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bjl == null) {
            this.bjl = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aAj == null || this.aAj.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aAj.mLiveInfo.live_id;
            long j6 = this.aAj.mLiveInfo.user_id;
            j3 = this.aAj.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aAj.mLiveInfo.group_id;
        }
        this.bjl.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bjn == null) {
                this.bjn = new HashSet();
            }
            if (!this.bjn.contains(str)) {
                this.bjn.add(str);
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
