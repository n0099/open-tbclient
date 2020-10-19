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
    private u aDU;
    private List<com.baidu.live.sdk.goods.a.a> bpM;
    private HttpMessageListener bpQ;
    private d bpR;
    private com.baidu.live.sdk.goods.b.b bpS;
    private com.baidu.live.view.d bpT;
    private Set<String> bpU;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void OE() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(u uVar) {
        this.aDU = uVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.bpU != null) {
                this.bpU.clear();
            }
            OG();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.bpR != null && this.bpR.isShowing()) {
            this.bpR.eV(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dI(int i) {
        if (this.bpR != null && this.bpR.isShowing()) {
            this.bpR.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Gx() {
        unRegisterListener();
        if (this.bpU != null) {
            this.bpU.clear();
        }
        if (this.bpM != null) {
            this.bpM.clear();
        }
        if (this.bpS != null) {
            this.bpS.release();
            this.bpS = null;
        }
        if (this.bpT != null) {
            this.bpT.dismiss();
            this.bpT = null;
        }
        if (this.bpR != null) {
            this.bpR.dismiss();
            this.bpR = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        Gx();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.bpQ = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.bpM == null) {
                            c.this.bpM = new ArrayList();
                        }
                        c.this.bpM.clear();
                        if (getVideoGoodsListHttpResponseMessage.bpz != null) {
                            c.this.bpM.addAll(getVideoGoodsListHttpResponseMessage.bpz);
                        }
                        if (!c.this.bpM.isEmpty()) {
                            Collections.sort(c.this.bpM, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.boX < aVar2.boX) {
                                        return -1;
                                    }
                                    return aVar.boX == aVar2.boX ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.bpR != null && c.this.bpR.isShowing()) {
                            c.this.bpR.setData(c.this.bpM);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bpQ);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bpQ);
    }

    private void OG() {
        this.bpR = new d(this.mPageContext.getPageActivity());
        this.bpR.setHost(this.mIsHost);
        this.bpR.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void OJ() {
                c.this.OH();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void u(String str, boolean z) {
                c.this.x(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.y(aVar.gid, aVar.bpi);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.w(str, z);
                c.this.z(str, z);
            }
        });
        if (this.bpM != null) {
            this.bpR.setData(this.bpM);
        }
        this.bpR.fa(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aDU == null || this.aDU.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aDU.mLiveInfo.feed_id != null) {
                    str2 = this.aDU.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aDU.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bpc != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bph && !TextUtils.isEmpty(aVar.bpf)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bpf));
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
                hJ(aVar.bpg);
            } else {
                hJ(aVar.bpe);
            }
        }
    }

    private void OI() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aDU != null && this.aDU.aIf != null && this.aDU.mLiveInfo != null && this.aDU.aHD != null) {
            long j = this.aDU.aIf.userId;
            String str = this.aDU.aIf.userName;
            long j2 = this.aDU.mLiveInfo.group_id;
            long j3 = this.aDU.aHD.userId;
            long j4 = this.aDU.mLiveInfo.live_id;
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
                OI();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hJ(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            OI();
        }
    }

    private void m(final Intent intent) {
        this.bpT = new com.baidu.live.view.d(this.mPageContext.getPageActivity());
        this.bpT.setCancelable(false);
        this.bpT.setCanceledOnTouchOutside(false);
        this.bpT.cT(false);
        this.bpT.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), this.mPageContext.getString(a.i.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.bpT.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.d.a
            public void OK() {
                c.this.bpT.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.d.a
            public void OL() {
                c.this.bpT.dismiss();
            }
        });
        this.bpT.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.bpS == null) {
            this.bpS = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aDU == null || this.aDU.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aDU.mLiveInfo.live_id;
            long j6 = this.aDU.mLiveInfo.user_id;
            j3 = this.aDU.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aDU.mLiveInfo.group_id;
        }
        this.bpS.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bpU == null) {
                this.bpU = new HashSet();
            }
            if (!this.bpU.contains(str)) {
                this.bpU.add(str);
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
