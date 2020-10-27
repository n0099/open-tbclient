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
    private w aEc;
    private List<com.baidu.live.sdk.goods.a.a> brB;
    private HttpMessageListener brF;
    private d brG;
    private com.baidu.live.sdk.goods.b.b brH;
    private com.baidu.live.view.d brI;
    private Set<String> brJ;
    private boolean mIsHost;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHost(boolean z) {
        this.mIsHost = z;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void Pc() {
        registerListener();
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void a(w wVar) {
        this.aEc = wVar;
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void display() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.brJ != null) {
                this.brJ.clear();
            }
            Pe();
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onResume() {
        if (this.brG != null && this.brG.isShowing()) {
            this.brG.eY(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void onPause() {
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void dI(int i) {
        if (this.brG != null && this.brG.isShowing()) {
            this.brG.n(i, true);
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void GS() {
        unRegisterListener();
        if (this.brJ != null) {
            this.brJ.clear();
        }
        if (this.brB != null) {
            this.brB.clear();
        }
        if (this.brH != null) {
            this.brH.release();
            this.brH = null;
        }
        if (this.brI != null) {
            this.brI.dismiss();
            this.brI = null;
        }
        if (this.brG != null) {
            this.brG.dismiss();
            this.brG = null;
        }
    }

    @Override // com.baidu.live.sdk.goods.c.a
    public void release() {
        GS();
        this.mPageContext = null;
    }

    private void registerListener() {
        this.brF = new HttpMessageListener(1021144) { // from class: com.baidu.live.sdk.goods.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (!getVideoGoodsListHttpResponseMessage.hasError() && getVideoGoodsListHttpResponseMessage.getError() == 0) {
                        if (c.this.brB == null) {
                            c.this.brB = new ArrayList();
                        }
                        c.this.brB.clear();
                        if (getVideoGoodsListHttpResponseMessage.brm != null) {
                            c.this.brB.addAll(getVideoGoodsListHttpResponseMessage.brm);
                        }
                        if (!c.this.brB.isEmpty()) {
                            Collections.sort(c.this.brB, new Comparator<com.baidu.live.sdk.goods.a.a>() { // from class: com.baidu.live.sdk.goods.c.c.1.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(com.baidu.live.sdk.goods.a.a aVar, com.baidu.live.sdk.goods.a.a aVar2) {
                                    if (aVar.bqK < aVar2.bqK) {
                                        return -1;
                                    }
                                    return aVar.bqK == aVar2.bqK ? 0 : 1;
                                }
                            });
                        }
                        if (c.this.brG != null && c.this.brG.isShowing()) {
                            c.this.brG.setData(c.this.brB);
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.brF);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.brF);
    }

    private void Pe() {
        this.brG = new d(this.mPageContext.getPageActivity());
        this.brG.setHost(this.mIsHost);
        this.brG.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.2
            @Override // com.baidu.live.sdk.goods.c.d.a
            public void Ph() {
                c.this.Pf();
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void v(String str, boolean z) {
                c.this.y(str, z);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void e(com.baidu.live.sdk.goods.a.a aVar) {
                c.this.d(aVar);
                c.this.z(aVar.gid, aVar.bqV);
            }

            @Override // com.baidu.live.sdk.goods.c.d.a
            public void w(String str, boolean z) {
                c.this.x(str, z);
                c.this.A(str, z);
            }
        });
        if (this.brB != null) {
            this.brG.setData(this.brB);
        }
        this.brG.fc(UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pf() {
        String str;
        long j;
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            String str2 = "";
            if (this.aEc == null || this.aEc.mLiveInfo == null) {
                str = "";
                j = 0;
            } else {
                if (this.aEc.mLiveInfo.feed_id != null) {
                    str2 = this.aEc.mLiveInfo.feed_id;
                }
                str = str2;
                j = this.aEc.mLiveInfo.live_id;
            }
            com.baidu.live.sdk.goods.d.a.o(this.mPageContext.getPageActivity(), str, j != 0 ? String.valueOf(j) : "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.sdk.goods.a.a aVar) {
        PackageManager packageManager;
        if (aVar != null && !this.mIsHost) {
            if (aVar.bqP != 1) {
                BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "此商品已下架");
            } else if (aVar.bqU && !TextUtils.isEmpty(aVar.bqS)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.bqS));
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
                hR(aVar.bqT);
            } else {
                hR(aVar.bqR);
            }
        }
    }

    private void Pg() {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.aEc != null && this.aEc.aIA != null && this.aEc.mLiveInfo != null && this.aEc.aIe != null) {
            long j = this.aEc.aIA.userId;
            String str = this.aEc.aIA.userName;
            long j2 = this.aEc.mLiveInfo.group_id;
            long j3 = this.aEc.aIe.userId;
            long j4 = this.aEc.mLiveInfo.live_id;
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
                Pg();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void hR(String str) {
        if (!TextUtils.isEmpty(str) && SchemeUtils.openScheme(str, false)) {
            Pg();
        }
    }

    private void m(final Intent intent) {
        this.brI = new com.baidu.live.view.d(this.mPageContext.getPageActivity());
        this.brI.setCancelable(false);
        this.brI.setCanceledOnTouchOutside(false);
        this.brI.cZ(false);
        this.brI.o(this.mPageContext.getString(a.i.sdk_live_disclaimer), this.mPageContext.getString(a.i.goods_nav_thirdparty_alert_content), this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.brI.a(new d.a() { // from class: com.baidu.live.sdk.goods.c.c.3
            @Override // com.baidu.live.view.d.a
            public void Pi() {
                c.this.brI.dismiss();
                SharedPrefHelper.getInstance().putBoolean("live_goods_nav_thirdparty_disclaimered", true);
                c.this.l(intent);
            }

            @Override // com.baidu.live.view.d.a
            public void Pj() {
                c.this.brI.dismiss();
            }
        });
        this.brI.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (this.brH == null) {
            this.brH = new com.baidu.live.sdk.goods.b.b(this.mPageContext);
        }
        if (this.aEc == null || this.aEc.mLiveInfo == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            long j5 = this.aEc.mLiveInfo.live_id;
            long j6 = this.aEc.mLiveInfo.user_id;
            j3 = this.aEc.mLiveInfo.room_id;
            j2 = j6;
            j4 = j5;
            j = this.aEc.mLiveInfo.group_id;
        }
        this.brH.a(j4 != 0 ? String.valueOf(j4) : "", str, z ? 2 : 1, j3 != 0 ? String.valueOf(j3) : "", j2 != 0 ? String.valueOf(j2) : "", j != 0 ? String.valueOf(j) : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (this.brJ == null) {
                this.brJ = new HashSet();
            }
            if (!this.brJ.contains(str)) {
                this.brJ.add(str);
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
