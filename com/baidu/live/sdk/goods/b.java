package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class b implements com.baidu.live.j.a {
    private r aAj;
    private String bhE;
    private com.baidu.live.sdk.goods.b.b bhV;
    private HostPreLiveGoodsEnterView bhY;
    private HostLiveGoodsEnterView bhZ;
    private c bia;
    private TbPageContext mTbPageContext;
    private boolean bhW = false;
    private boolean bhX = false;
    private com.baidu.live.sdk.goods.b.a bib = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bhY != null) {
                if (z2) {
                    b.this.bhY.Ni();
                    b.this.a(b.this.bhY);
                    b.this.MQ();
                } else {
                    b.this.bhY.Nj();
                }
            }
            if (b.this.bhZ != null) {
                if (z2) {
                    b.this.bhZ.Ni();
                } else {
                    b.this.bhZ.Nj();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bhY != null) {
                b.this.bhY.eH(i2);
            }
            if (b.this.bhZ != null) {
                b.this.bhZ.eH(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.MQ();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bic = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.m(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bie = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.MQ();
            if (b.this.bia != null) {
                b.this.bia.display();
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bhV == null) {
            this.bhV = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bhV.init();
        this.bhV.a(this.bib);
        this.bia = new c(tbPageContext);
        this.bia.setHost(true);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a bV(boolean z) {
        if (z) {
            if (this.bhY == null) {
                this.bhY = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bhY.setOutClickListener(this.bic);
            }
            return this.bhY;
        }
        if (this.bhZ == null) {
            this.bhZ = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bhZ.setOutClickListener(this.bie);
        }
        return this.bhZ;
    }

    @Override // com.baidu.live.j.a
    public void KM() {
        if (this.bhV != null) {
            this.bhV.KM();
        }
    }

    @Override // com.baidu.live.j.a
    public void KN() {
        MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bhX) {
            this.bhX = true;
            if (!com.baidu.live.c.AD().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void gV(String str) {
        this.bhE = str;
    }

    @Override // com.baidu.live.j.a
    public void h(r rVar) {
        View rootLayout;
        this.aAj = rVar;
        if (this.bhY != null && (rootLayout = this.bhY.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bhY = null;
        }
        if (this.bia != null) {
            this.bia.MV();
            this.bia.a(rVar);
        }
    }

    @Override // com.baidu.live.j.a
    public void i(r rVar) {
        this.aAj = rVar;
        if (this.bia != null) {
            this.bia.a(rVar);
        }
        if (this.bhZ != null && this.bhV.MU()) {
            this.bhZ.Ni();
            if (!this.bhW && rVar.mLiveInfo != null && rVar.aDG != null) {
                this.bhW = true;
                MQ();
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.bhZ != null || this.bhY != null) {
            MQ();
        }
        if (this.bia != null) {
            this.bia.onResume();
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.bia != null) {
            this.bia.onPause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.bhV != null) {
            this.bhV.cancelLoadData();
            this.bhV.release();
        }
        if (this.bia != null) {
            this.bia.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MQ() {
        long j;
        long j2 = 0;
        if (this.bhV != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aAj == null || this.aAj.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aAj.mLiveInfo.feed_id;
                j = this.aAj.mLiveInfo.live_id;
                j2 = this.aAj.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bhE)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bhE);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bhV.a(str, j, j2, str2, str3, str4);
        }
    }
}
