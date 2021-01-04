package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.data.x;
import com.baidu.live.sdk.goods.c.c;
import com.baidu.live.sdk.goods.guide.HostLiveGoodsAuthGuide;
import com.baidu.live.sdk.goods.view.HostLiveGoodsEnterView;
import com.baidu.live.sdk.goods.view.HostPreLiveGoodsEnterView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.n.a {
    private x aGe;
    private HostLiveGoodsEnterView bAa;
    private c bAb;
    private String bzE;
    private com.baidu.live.sdk.goods.b.b bzW;
    private HostPreLiveGoodsEnterView bzZ;
    private TbPageContext mTbPageContext;
    private boolean bzX = false;
    private boolean bzY = false;
    private com.baidu.live.sdk.goods.b.a bAc = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void b(int i, String str, boolean z, boolean z2) {
            if (b.this.bzZ != null) {
                if (z2) {
                    b.this.bzZ.SC();
                    b.this.a(b.this.bzZ);
                    b.this.Sl();
                } else {
                    b.this.bzZ.SD();
                }
            }
            if (b.this.bAa != null) {
                if (z2) {
                    b.this.bAa.SC();
                } else {
                    b.this.bAa.SD();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bzZ != null) {
                b.this.bzZ.fy(i2);
            }
            if (b.this.bAa != null) {
                b.this.bAa.fy(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Sl();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bAd = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bAe = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "shopmall"));
            b.this.Sl();
            if (b.this.bAb != null) {
                b.this.bAb.rV();
            }
        }
    };

    @Override // com.baidu.live.n.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bzW == null) {
            this.bzW = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bzW.init();
        this.bzW.a(this.bAc);
        this.bAb = new c(tbPageContext);
        this.bAb.setHost(true);
    }

    @Override // com.baidu.live.n.a
    public com.baidu.live.core.a.a cw(boolean z) {
        if (z) {
            if (this.bzZ == null) {
                this.bzZ = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bzZ.setOutClickListener(this.bAd);
            }
            return this.bzZ;
        }
        if (this.bAa == null) {
            this.bAa = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bAa.setOutClickListener(this.bAe);
        }
        return this.bAa;
    }

    @Override // com.baidu.live.n.a
    public void OM() {
        if (this.bzW != null) {
            this.bzW.OM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bzY) {
            this.bzY = true;
            if (!d.Ba().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.n.a
    public void hV(String str) {
        this.bzE = str;
    }

    @Override // com.baidu.live.n.a
    public void f(x xVar) {
        View rootLayout;
        this.aGe = xVar;
        if (this.bzZ != null && (rootLayout = this.bzZ.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bzZ = null;
        }
        if (this.bAb != null) {
            this.bAb.Sq();
            this.bAb.a(xVar);
        }
    }

    @Override // com.baidu.live.n.a
    public void i(x xVar) {
        this.aGe = xVar;
        if (this.bAb != null) {
            this.bAb.a(xVar);
        }
        if (this.bAa != null && this.bzW.Sp()) {
            this.bAa.SC();
            if (!this.bzX && xVar.mLiveInfo != null && xVar.aKu != null) {
                this.bzX = true;
                Sl();
            }
        }
    }

    @Override // com.baidu.live.n.a
    public void onResume() {
        if (this.bAa != null || this.bzZ != null) {
            Sl();
        }
        if (this.bAb != null) {
            this.bAb.onResume();
        }
    }

    @Override // com.baidu.live.n.a
    public void onPause() {
        if (this.bAb != null) {
            this.bAb.onPause();
        }
    }

    @Override // com.baidu.live.n.a
    public void release() {
        if (this.bzW != null) {
            this.bzW.cancelLoadData();
            this.bzW.release();
        }
        if (this.bAb != null) {
            this.bAb.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sl() {
        long j;
        long j2;
        String str;
        String str2;
        if (this.bzW != null) {
            String str3 = "";
            String str4 = "";
            if (this.aGe == null || this.aGe.mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                str3 = this.aGe.mLiveInfo.feed_id;
                long j3 = this.aGe.mLiveInfo.live_id;
                j = this.aGe.mLiveInfo.user_id;
                j2 = j3;
            }
            if (TextUtils.isEmpty(this.bzE)) {
                str = "";
                str2 = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.bzE);
                    str2 = jSONObject.optString("tab");
                    try {
                        str = jSONObject.optString("tag");
                    } catch (JSONException e) {
                        e = e;
                        str = "";
                    }
                    try {
                        str4 = jSONObject.optString("source");
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        this.bzW.a(str3, j2, j, str2, str, str4);
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = "";
                    str2 = "";
                }
            }
            this.bzW.a(str3, j2, j, str2, str, str4);
        }
    }
}
