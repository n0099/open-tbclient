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
import com.baidu.live.data.u;
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
/* loaded from: classes4.dex */
public class c implements a {
    private u aAP;
    private List<com.baidu.live.sdk.goods.a.a> blZ;
    private HttpMessageListener bmd;
    private d bme;
    private com.baidu.live.sdk.goods.b.b bmf;
    private com.baidu.live.view.d bmg;
    private Set<String> bmh;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Nz() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(u uVar) {
        this.aAP = uVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bmh != null) {
                this.bmh.clear();
            }
            NB();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bme != null && this.bme.isShowing()) {
            this.bme.eM(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dD(int i) {
        if (this.bme != null && this.bme.isShowing()) {
            this.bme.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void FB() {
        unRegisterListener();
        if (this.bmh != null) {
            this.bmh.clear();
        }
        if (this.blZ != null) {
            this.blZ.clear();
        }
        if (this.bmf != null) {
            this.bmf.release();
            this.bmf = null;
        }
        if (this.bmg != null) {
            this.bmg.dismiss();
            this.bmg = null;
        }
        if (this.bme != null) {
            this.bme.dismiss();
            this.bme = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        FB();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bmd = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.blZ == null) {
                            c.this.blZ = new ArrayList();
                        }
                        c.this.blZ.clear();
                        if (getVideoGoodsListHttpResponseMessage.blM != null) {
                            c.this.blZ.addAll(getVideoGoodsListHttpResponseMessage.blM);
                        }
                        if (!c.this.blZ.isEmpty()) {
                            Collections.sort(c.this.blZ, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.blk < aVar2.blk) {
                                        return -1;
                                    }
                                    return aVar.blk == aVar2.blk ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bme != null && c.this.bme.isShowing()) {
                            c.this.bme.setData(c.this.blZ);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bmd);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bmd);
    }

    private void NB() {
        this.bme = new d(this.mPageContext.getPageActivity());
        this.bme.setHost(this.mIsHost);
        this.bme.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void NE() {
                c.this.NC();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void u(String str, boolean z) {
                c.this.x(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.y(aVar.gid, aVar.blv);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.w(str, z);
                c.this.z(str, z);
            }
        });
        if (this.blZ != null) {
            this.bme.setData(this.blZ);
        }
        this.bme.eR(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aAP == null || this.aAP.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aAP.mLiveInfo.feed_id != null) {
                    str2 = this.aAP.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aAP.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.m(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.blp != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.blu && !TextUtils.isEmpty(aVar.bls)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bls));
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
                hs(aVar.blt);
            } else {
                hs(aVar.blr);
            }
        }
    }

    private void ND() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aAP != null && this.aAP.aFb != null && this.aAP.mLiveInfo != null && this.aAP.aEz != null) {
            long j = this.aAP.aFb.userId;
            String str = this.aAP.aFb.userName;
            long j2 = this.aAP.mLiveInfo.group_id;
            long j3 = this.aAP.aEz.userId;
            long j4 = this.aAP.mLiveInfo.live_id;
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
                ND();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hs(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            ND();
        }
    }

    private void m(final Intent intent) {
        this.bmg = new com.baidu.live.view.d(this.mPageContext.getPageActivity());
        this.bmg.setCancelable(false);
        this.bmg.setCanceledOnTouchOutside(false);
        this.bmg.cM(false);
        this.bmg.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), this.mPageContext.getString(a.i.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bmg.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.d.a
            public void NF() {
                c.this.bmg.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.d.a
            public void NG() {
                c.this.bmg.dismiss();
            }
        });
        this.bmg.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bmf == null) {
            this.bmf = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aAP == null || this.aAP.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aAP.mLiveInfo.live_id;
            long j6 = this.aAP.mLiveInfo.user_id;
            j3 = this.aAP.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aAP.mLiveInfo.group_id;
        }
        this.bmf.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bmh == null) {
                this.bmh = new HashSet();
            }
            if (!this.bmh.contains(str)) {
                this.bmh.add(str);
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
