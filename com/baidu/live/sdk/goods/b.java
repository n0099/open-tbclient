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
    private w aDh;
    private String bpI;
    private com.baidu.live.sdk.goods.b.b bqa;
    private HostPreLiveGoodsEnterView bqd;
    private HostLiveGoodsEnterView bqe;
    private c bqf;
    private TbPageContext mTbPageContext;
    private boolean bqb = false;
    private boolean bqc = false;
    private com.baidu.live.sdk.goods.b.a bqg = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bqd != null) {
                if (z2) {
                    b.this.bqd.Pf();
                    b.this.a(b.this.bqd);
                    b.this.OO();
                } else {
                    b.this.bqd.Pg();
                }
            }
            if (b.this.bqe != null) {
                if (z2) {
                    b.this.bqe.Pf();
                } else {
                    b.this.bqe.Pg();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bqd != null) {
                b.this.bqd.eZ(i2);
            }
            if (b.this.bqe != null) {
                b.this.bqe.eZ(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.OO();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bqh = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bqi = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.OO();
            if (b.this.bqf != null) {
                b.this.bqf.display();
            }
        }
    };

    @Override // com.baidu.live.k.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bqa == null) {
            this.bqa = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bqa.init();
        this.bqa.a(this.bqg);
        this.bqf = new c(tbPageContext);
        this.bqf.setHost(true);
    }

    @Override // com.baidu.live.k.a
    public com.baidu.live.core.a.a cf(boolean z) {
        if (z) {
            if (this.bqd == null) {
                this.bqd = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bqd.setOutClickListener(this.bqh);
            }
            return this.bqd;
        }
        if (this.bqe == null) {
            this.bqe = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bqe.setOutClickListener(this.bqi);
        }
        return this.bqe;
    }

    @Override // com.baidu.live.k.a
    public void MJ() {
        if (this.bqa != null) {
            this.bqa.MJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bqc) {
            this.bqc = true;
            if (!d.Aq().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void hH(String str) {
        this.bpI = str;
    }

    @Override // com.baidu.live.k.a
    public void e(w wVar) {
        View rootLayout;
        this.aDh = wVar;
        if (this.bqd != null && (rootLayout = this.bqd.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bqd = null;
        }
        if (this.bqf != null) {
            this.bqf.OT();
            this.bqf.a(wVar);
        }
    }

    @Override // com.baidu.live.k.a
    public void h(w wVar) {
        this.aDh = wVar;
        if (this.bqf != null) {
            this.bqf.a(wVar);
        }
        if (this.bqe != null && this.bqa.OS()) {
            this.bqe.Pf();
            if (!this.bqb && wVar.mLiveInfo != null && wVar.aHk != null) {
                this.bqb = true;
                OO();
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
        if (this.bqe != null || this.bqd != null) {
            OO();
        }
        if (this.bqf != null) {
            this.bqf.onResume();
        }
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
        if (this.bqf != null) {
            this.bqf.onPause();
        }
    }

    @Override // com.baidu.live.k.a
    public void release() {
        if (this.bqa != null) {
            this.bqa.cancelLoadData();
            this.bqa.release();
        }
        if (this.bqf != null) {
            this.bqf.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OO() {
        long j;
        long j2 = 0;
        if (this.bqa != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aDh == null || this.aDh.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aDh.mLiveInfo.feed_id;
                j = this.aDh.mLiveInfo.live_id;
                j2 = this.aDh.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bpI)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bpI);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bqa.a(str, j, j2, str2, str3, str4);
        }
    }
}
