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
    private w aDh;
    private List<com.baidu.live.sdk.goods.a.a> brj;
    private HttpMessageListener brn;
    private d bro;
    private com.baidu.live.sdk.goods.b.b brp;
    private com.baidu.live.view.c brq;
    private Set<String> brr;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void OT() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(w wVar) {
        this.aDh = wVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.brr != null) {
                this.brr.clear();
            }
            OV();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bro != null && this.bro.isShowing()) {
            this.bro.eU(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dE(int i) {
        if (this.bro != null && this.bro.isShowing()) {
            this.bro.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void GK() {
        unRegisterListener();
        if (this.brr != null) {
            this.brr.clear();
        }
        if (this.brj != null) {
            this.brj.clear();
        }
        if (this.brp != null) {
            this.brp.release();
            this.brp = null;
        }
        if (this.brq != null) {
            this.brq.dismiss();
            this.brq = null;
        }
        if (this.bro != null) {
            this.bro.dismiss();
            this.bro = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        GK();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.brn = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.brj == null) {
                            c.this.brj = new ArrayList();
                        }
                        c.this.brj.clear();
                        if (getVideoGoodsListHttpResponseMessage.bqU != null) {
                            c.this.brj.addAll(getVideoGoodsListHttpResponseMessage.bqU);
                        }
                        if (!c.this.brj.isEmpty()) {
                            Collections.sort(c.this.brj, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bqs < aVar2.bqs) {
                                        return -1;
                                    }
                                    return aVar.bqs == aVar2.bqs ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bro != null && c.this.bro.isShowing()) {
                            c.this.bro.setData(c.this.brj);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.brn);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.brn);
    }

    private void OV() {
        this.bro = new d(this.mPageContext.getPageActivity());
        this.bro.setHost(this.mIsHost);
        this.bro.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void OY() {
                c.this.OW();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.y(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.z(aVar.gid, aVar.bqD);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.x(str, z);
                c.this.A(str, z);
            }
        });
        if (this.brj != null) {
            this.bro.setData(this.brj);
        }
        this.bro.eY(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OW() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aDh == null || this.aDh.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aDh.mLiveInfo.feed_id != null) {
                    str2 = this.aDh.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aDh.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bqx != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bqC && !TextUtils.isEmpty(aVar.bqA)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bqA));
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
                hS(aVar.bqB);
            } else {
                hS(aVar.bqz);
            }
        }
    }

    private void OX() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aDh != null && this.aDh.aHG != null && this.aDh.mLiveInfo != null && this.aDh.aHk != null) {
            long j = this.aDh.aHG.userId;
            String str = this.aDh.aHG.userName;
            long j2 = this.aDh.mLiveInfo.group_id;
            long j3 = this.aDh.aHk.userId;
            long j4 = this.aDh.mLiveInfo.live_id;
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
                OX();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hS(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            OX();
        }
    }

    private void m(final Intent intent) {
        this.brq = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.brq.setCancelable(false);
        this.brq.setCanceledOnTouchOutside(false);
        this.brq.di(false);
        this.brq.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.brq.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void OZ() {
                c.this.brq.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void Pa() {
                c.this.brq.dismiss();
            }
        });
        this.brq.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.brp == null) {
            this.brp = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aDh == null || this.aDh.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aDh.mLiveInfo.live_id;
            long j6 = this.aDh.mLiveInfo.user_id;
            j3 = this.aDh.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aDh.mLiveInfo.group_id;
        }
        this.brp.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.brr == null) {
                this.brr = new HashSet();
            }
            if (!this.brr.contains(str)) {
                this.brr.add(str);
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
