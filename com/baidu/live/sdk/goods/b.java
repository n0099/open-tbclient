package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.k.a {
    private w aEc;
    private String bqa;
    private com.baidu.live.sdk.goods.b.b bqs;
    private HostPreLiveGoodsEnterView bqv;
    private HostLiveGoodsEnterView bqw;
    private c bqx;
    private TbPageContext mTbPageContext;
    private boolean bqt = false;
    private boolean bqu = false;
    private com.baidu.live.sdk.goods.b.a bqy = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bqv != null) {
                if (z2) {
                    b.this.bqv.Po();
                    b.this.a(b.this.bqv);
                    b.this.OX();
                } else {
                    b.this.bqv.Pp();
                }
            }
            if (b.this.bqw != null) {
                if (z2) {
                    b.this.bqw.Po();
                } else {
                    b.this.bqw.Pp();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bqv != null) {
                b.this.bqv.fd(i2);
            }
            if (b.this.bqw != null) {
                b.this.bqw.fd(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.OX();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bqz = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bqA = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.OX();
            if (b.this.bqx != null) {
                b.this.bqx.display();
            }
        }
    };

    @Override // com.baidu.live.k.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bqs == null) {
            this.bqs = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bqs.init();
        this.bqs.a(this.bqy);
        this.bqx = new c(tbPageContext);
        this.bqx.setHost(true);
    }

    @Override // com.baidu.live.k.a
    public com.baidu.live.core.a.a cc(boolean z) {
        if (z) {
            if (this.bqv == null) {
                this.bqv = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bqv.setOutClickListener(this.bqz);
            }
            return this.bqv;
        }
        if (this.bqw == null) {
            this.bqw = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bqw.setOutClickListener(this.bqA);
        }
        return this.bqw;
    }

    @Override // com.baidu.live.k.a
    public void MS() {
        if (this.bqs != null) {
            this.bqs.MS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bqu) {
            this.bqu = true;
            if (!d.AZ().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void hG(String str) {
        this.bqa = str;
    }

    @Override // com.baidu.live.k.a
    public void f(w wVar) {
        View rootLayout;
        this.aEc = wVar;
        if (this.bqv != null && (rootLayout = this.bqv.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bqv = null;
        }
        if (this.bqx != null) {
            this.bqx.Pc();
            this.bqx.a(wVar);
        }
    }

    @Override // com.baidu.live.k.a
    public void i(w wVar) {
        this.aEc = wVar;
        if (this.bqx != null) {
            this.bqx.a(wVar);
        }
        if (this.bqw != null && this.bqs.Pb()) {
            this.bqw.Po();
            if (!this.bqt && wVar.mLiveInfo != null && wVar.aIe != null) {
                this.bqt = true;
                OX();
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
        if (this.bqw != null || this.bqv != null) {
            OX();
        }
        if (this.bqx != null) {
            this.bqx.onResume();
        }
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
        if (this.bqx != null) {
            this.bqx.onPause();
        }
    }

    @Override // com.baidu.live.k.a
    public void release() {
        if (this.bqs != null) {
            this.bqs.cancelLoadData();
            this.bqs.release();
        }
        if (this.bqx != null) {
            this.bqx.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OX() {
        long j;
        long j2 = 0;
        if (this.bqs != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aEc == null || this.aEc.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aEc.mLiveInfo.feed_id;
                j = this.aEc.mLiveInfo.live_id;
                j2 = this.aEc.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bqa)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bqa);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bqs.a(str, j, j2, str2, str3, str4);
        }
    }
}
