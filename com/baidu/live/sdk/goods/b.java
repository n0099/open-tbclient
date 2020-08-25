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
    private r aAh;
    private String bhB;
    private com.baidu.live.sdk.goods.b.b bhS;
    private HostPreLiveGoodsEnterView bhV;
    private HostLiveGoodsEnterView bhW;
    private c bhX;
    private TbPageContext mTbPageContext;
    private boolean bhT = false;
    private boolean bhU = false;
    private com.baidu.live.sdk.goods.b.a bhY = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bhV != null) {
                if (z2) {
                    b.this.bhV.Ni();
                    b.this.a(b.this.bhV);
                    b.this.MQ();
                } else {
                    b.this.bhV.Nj();
                }
            }
            if (b.this.bhW != null) {
                if (z2) {
                    b.this.bhW.Ni();
                } else {
                    b.this.bhW.Nj();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bhV != null) {
                b.this.bhV.eH(i2);
            }
            if (b.this.bhW != null) {
                b.this.bhW.eH(i2);
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
    private View.OnClickListener bhZ = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.m(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bia = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.MQ();
            if (b.this.bhX != null) {
                b.this.bhX.display();
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bhS == null) {
            this.bhS = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bhS.init();
        this.bhS.a(this.bhY);
        this.bhX = new c(tbPageContext);
        this.bhX.setHost(true);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a bV(boolean z) {
        if (z) {
            if (this.bhV == null) {
                this.bhV = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bhV.setOutClickListener(this.bhZ);
            }
            return this.bhV;
        }
        if (this.bhW == null) {
            this.bhW = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bhW.setOutClickListener(this.bia);
        }
        return this.bhW;
    }

    @Override // com.baidu.live.j.a
    public void KM() {
        if (this.bhS != null) {
            this.bhS.KM();
        }
    }

    @Override // com.baidu.live.j.a
    public void KN() {
        MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bhU) {
            this.bhU = true;
            if (!com.baidu.live.c.AD().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void gU(String str) {
        this.bhB = str;
    }

    @Override // com.baidu.live.j.a
    public void h(r rVar) {
        View rootLayout;
        this.aAh = rVar;
        if (this.bhV != null && (rootLayout = this.bhV.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bhV = null;
        }
        if (this.bhX != null) {
            this.bhX.MV();
            this.bhX.a(rVar);
        }
    }

    @Override // com.baidu.live.j.a
    public void i(r rVar) {
        this.aAh = rVar;
        if (this.bhX != null) {
            this.bhX.a(rVar);
        }
        if (this.bhW != null && this.bhS.MU()) {
            this.bhW.Ni();
            if (!this.bhT && rVar.mLiveInfo != null && rVar.aDE != null) {
                this.bhT = true;
                MQ();
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.bhW != null || this.bhV != null) {
            MQ();
        }
        if (this.bhX != null) {
            this.bhX.onResume();
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.bhX != null) {
            this.bhX.onPause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.bhS != null) {
            this.bhS.cancelLoadData();
            this.bhS.release();
        }
        if (this.bhX != null) {
            this.bhX.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MQ() {
        long j;
        long j2 = 0;
        if (this.bhS != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aAh == null || this.aAh.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aAh.mLiveInfo.feed_id;
                j = this.aAh.mLiveInfo.live_id;
                j2 = this.aAh.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bhB)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bhB);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bhS.a(str, j, j2, str2, str3, str4);
        }
    }
}
