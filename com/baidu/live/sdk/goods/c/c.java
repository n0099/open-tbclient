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
/* loaded from: classes11.dex */
public class c implements a {
    private ab aDd;
    private com.baidu.live.sdk.goods.b.b bAa;
    private com.baidu.live.view.c bAb;
    private Set<String> bAc;
    private List<com.baidu.live.sdk.goods.a.a> ber;
    private HttpMessageListener bzY;
    private d bzZ;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void PU() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(ab abVar) {
        this.aDd = abVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bAc != null) {
                this.bAc.clear();
            }
            PW();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bzZ != null && this.bzZ.isShowing()) {
            this.bzZ.dT(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void cr(int i) {
        if (this.bzZ != null && this.bzZ.isShowing()) {
            this.bzZ.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Fy() {
        unRegisterListener();
        if (this.bAc != null) {
            this.bAc.clear();
        }
        if (this.ber != null) {
            this.ber.clear();
        }
        if (this.bAa != null) {
            this.bAa.release();
            this.bAa = null;
        }
        if (this.bAb != null) {
            this.bAb.dismiss();
            this.bAb = null;
        }
        if (this.bzZ != null) {
            this.bzZ.dismiss();
            this.bzZ = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Fy();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bzY = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.ber == null) {
                            c.this.ber = new ArrayList();
                        }
                        c.this.ber.clear();
                        if (getVideoGoodsListHttpResponseMessage.bzG != null) {
                            c.this.ber.addAll(getVideoGoodsListHttpResponseMessage.bzG);
                        }
                        if (!c.this.ber.isEmpty()) {
                            Collections.sort(c.this.ber, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bze < aVar2.bze) {
                                        return -1;
                                    }
                                    return aVar.bze == aVar2.bze ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bzZ != null && c.this.bzZ.isShowing()) {
                            c.this.bzZ.setData(c.this.ber);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bzY);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bzY);
    }

    private void PW() {
        this.bzZ = new d(this.mPageContext.getPageActivity());
        this.bzZ.setHost(this.mIsHost);
        this.bzZ.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void PZ() {
                c.this.PX();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.z(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.A(aVar.gid, aVar.bzp);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void x(String str, boolean z) {
                c.this.y(str, z);
                c.this.B(str, z);
            }
        });
        if (this.ber != null) {
            this.bzZ.setData(this.ber);
        }
        this.bzZ.dS(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PX() {
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str = "";
            if (this.aDd == null || this.aDd.mLiveInfo == null) {
                j = 0;
            } else {
                if (this.aDd.mLiveInfo.feed_id != null) {
                    str = this.aDd.mLiveInfo.feed_id;
                }
                j = this.aDd.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bzj != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bzo && !TextUtils.isEmpty(aVar.bzm)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bzm));
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
                hu(aVar.bzn);
            } else {
                hu(aVar.bzl);
            }
        }
    }

    private void PY() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aDd != null && this.aDd.aIz != null && this.aDd.mLiveInfo != null && this.aDd.aId != null) {
            long j = this.aDd.aIz.userId;
            String str = this.aDd.aIz.userName;
            long j2 = this.aDd.mLiveInfo.group_id;
            long j3 = this.aDd.aId.userId;
            long j4 = this.aDd.mLiveInfo.live_id;
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
                PY();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hu(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            PY();
        }
    }

    private void m(final Intent intent) {
        this.bAb = new com.baidu.live.view.c(this.mPageContext.getPageActivity());
        this.bAb.setCancelable(false);
        this.bAb.setCanceledOnTouchOutside(false);
        this.bAb.dD(false);
        this.bAb.o(this.mPageContext.getString(a.h.sdk_live_disclaimer), this.mPageContext.getString(a.h.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.h.sdk_live_iknow), this.mPageContext.getString(a.h.sdk_live_cancel));
        this.bAb.a(new c.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.c.a
            public void Qa() {
                c.this.bAb.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.c.a
            public void Qb() {
                c.this.bAb.dismiss();
            }
        });
        this.bAb.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        long j;
        long j2;
        if (this.bAa == null) {
            this.bAa = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        long j3 = 0;
        long j4 = 0;
        if (this.aDd == null || this.aDd.mLiveInfo == null) {
            j = 0;
            j2 = 0;
        } else {
            j3 = this.aDd.mLiveInfo.live_id;
            long j5 = this.aDd.mLiveInfo.user_id;
            j4 = this.aDd.mLiveInfo.room_id;
            j = this.aDd.mLiveInfo.group_id;
            j2 = j5;
        }
        this.bAa.a(j3 != 0 ? String.valueOf(j3) : "", str, z ? 2 : 1, j4 != 0 ? String.valueOf(j4) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bAc == null) {
                this.bAc = new HashSet();
            }
            if (!this.bAc.contains(str)) {
                this.bAc.add(str);
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
