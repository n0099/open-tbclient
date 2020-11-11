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
    private w aES;
    private com.baidu.live.sdk.goods.b.b brL;
    private HostPreLiveGoodsEnterView brO;
    private HostLiveGoodsEnterView brP;
    private c brQ;
    private String brt;
    private TbPageContext mTbPageContext;
    private boolean brM = false;
    private boolean brN = false;
    private com.baidu.live.sdk.goods.b.a brR = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.brO != null) {
                if (z2) {
                    b.this.brO.PO();
                    b.this.a(b.this.brO);
                    b.this.Px();
                } else {
                    b.this.brO.PP();
                }
            }
            if (b.this.brP != null) {
                if (z2) {
                    b.this.brP.PO();
                } else {
                    b.this.brP.PP();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.brO != null) {
                b.this.brO.fd(i2);
            }
            if (b.this.brP != null) {
                b.this.brP.fd(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Px();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener brS = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener brT = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.Px();
            if (b.this.brQ != null) {
                b.this.brQ.display();
            }
        }
    };

    @Override // com.baidu.live.k.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.brL == null) {
            this.brL = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.brL.init();
        this.brL.a(this.brR);
        this.brQ = new c(tbPageContext);
        this.brQ.setHost(true);
    }

    @Override // com.baidu.live.k.a
    public com.baidu.live.core.a.a cd(boolean z) {
        if (z) {
            if (this.brO == null) {
                this.brO = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.brO.setOutClickListener(this.brS);
            }
            return this.brO;
        }
        if (this.brP == null) {
            this.brP = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.brP.setOutClickListener(this.brT);
        }
        return this.brP;
    }

    @Override // com.baidu.live.k.a
    public void Ns() {
        if (this.brL != null) {
            this.brL.Ns();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.brN) {
            this.brN = true;
            if (!d.AZ().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void hN(String str) {
        this.brt = str;
    }

    @Override // com.baidu.live.k.a
    public void e(w wVar) {
        View rootLayout;
        this.aES = wVar;
        if (this.brO != null && (rootLayout = this.brO.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.brO = null;
        }
        if (this.brQ != null) {
            this.brQ.PC();
            this.brQ.a(wVar);
        }
    }

    @Override // com.baidu.live.k.a
    public void h(w wVar) {
        this.aES = wVar;
        if (this.brQ != null) {
            this.brQ.a(wVar);
        }
        if (this.brP != null && this.brL.PB()) {
            this.brP.PO();
            if (!this.brM && wVar.mLiveInfo != null && wVar.aIV != null) {
                this.brM = true;
                Px();
            }
        }
    }

    @Override // com.baidu.live.k.a
    public void onResume() {
        if (this.brP != null || this.brO != null) {
            Px();
        }
        if (this.brQ != null) {
            this.brQ.onResume();
        }
    }

    @Override // com.baidu.live.k.a
    public void onPause() {
        if (this.brQ != null) {
            this.brQ.onPause();
        }
    }

    @Override // com.baidu.live.k.a
    public void release() {
        if (this.brL != null) {
            this.brL.cancelLoadData();
            this.brL.release();
        }
        if (this.brQ != null) {
            this.brQ.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        long j;
        long j2 = 0;
        if (this.brL != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aES == null || this.aES.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aES.mLiveInfo.feed_id;
                j = this.aES.mLiveInfo.live_id;
                j2 = this.aES.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.brt)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.brt);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.brL.a(str, j, j2, str2, str3, str4);
        }
    }
}
