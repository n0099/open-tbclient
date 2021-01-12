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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.n.a {
    private x aBr;
    private String buS;
    private com.baidu.live.sdk.goods.b.b bvk;
    private HostPreLiveGoodsEnterView bvn;
    private HostLiveGoodsEnterView bvo;
    private c bvp;
    private TbPageContext mTbPageContext;
    private boolean bvl = false;
    private boolean bvm = false;
    private com.baidu.live.sdk.goods.b.a bvq = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void b(int i, String str, boolean z, boolean z2) {
            if (b.this.bvn != null) {
                if (z2) {
                    b.this.bvn.OH();
                    b.this.a(b.this.bvn);
                    b.this.Oq();
                } else {
                    b.this.bvn.OI();
                }
            }
            if (b.this.bvo != null) {
                if (z2) {
                    b.this.bvo.OH();
                } else {
                    b.this.bvo.OI();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bvn != null) {
                b.this.bvn.dS(i2);
            }
            if (b.this.bvo != null) {
                b.this.bvo.dS(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Oq();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bvr = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bvs = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "shopmall"));
            b.this.Oq();
            if (b.this.bvp != null) {
                b.this.bvp.rV();
            }
        }
    };

    @Override // com.baidu.live.n.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bvk == null) {
            this.bvk = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bvk.init();
        this.bvk.a(this.bvq);
        this.bvp = new c(tbPageContext);
        this.bvp.setHost(true);
    }

    @Override // com.baidu.live.n.a
    public com.baidu.live.core.a.a cs(boolean z) {
        if (z) {
            if (this.bvn == null) {
                this.bvn = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bvn.setOutClickListener(this.bvr);
            }
            return this.bvn;
        }
        if (this.bvo == null) {
            this.bvo = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bvo.setOutClickListener(this.bvs);
        }
        return this.bvo;
    }

    @Override // com.baidu.live.n.a
    public void KR() {
        if (this.bvk != null) {
            this.bvk.KR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bvm) {
            this.bvm = true;
            if (!d.xf().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.n.a
    public void gK(String str) {
        this.buS = str;
    }

    @Override // com.baidu.live.n.a
    public void f(x xVar) {
        View rootLayout;
        this.aBr = xVar;
        if (this.bvn != null && (rootLayout = this.bvn.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bvn = null;
        }
        if (this.bvp != null) {
            this.bvp.Ov();
            this.bvp.a(xVar);
        }
    }

    @Override // com.baidu.live.n.a
    public void i(x xVar) {
        this.aBr = xVar;
        if (this.bvp != null) {
            this.bvp.a(xVar);
        }
        if (this.bvo != null && this.bvk.Ou()) {
            this.bvo.OH();
            if (!this.bvl && xVar.mLiveInfo != null && xVar.aFH != null) {
                this.bvl = true;
                Oq();
            }
        }
    }

    @Override // com.baidu.live.n.a
    public void onResume() {
        if (this.bvo != null || this.bvn != null) {
            Oq();
        }
        if (this.bvp != null) {
            this.bvp.onResume();
        }
    }

    @Override // com.baidu.live.n.a
    public void onPause() {
        if (this.bvp != null) {
            this.bvp.onPause();
        }
    }

    @Override // com.baidu.live.n.a
    public void release() {
        if (this.bvk != null) {
            this.bvk.cancelLoadData();
            this.bvk.release();
        }
        if (this.bvp != null) {
            this.bvp.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oq() {
        long j;
        long j2;
        String str;
        String str2;
        if (this.bvk != null) {
            String str3 = "";
            String str4 = "";
            if (this.aBr == null || this.aBr.mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                str3 = this.aBr.mLiveInfo.feed_id;
                long j3 = this.aBr.mLiveInfo.live_id;
                j = this.aBr.mLiveInfo.user_id;
                j2 = j3;
            }
            if (TextUtils.isEmpty(this.buS)) {
                str = "";
                str2 = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.buS);
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
                        this.bvk.a(str3, j2, j, str2, str, str4);
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = "";
                    str2 = "";
                }
            }
            this.bvk.a(str3, j2, j, str2, str, str4);
        }
    }
}
