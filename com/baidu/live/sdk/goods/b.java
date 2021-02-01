package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.data.ab;
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
public class b implements com.baidu.live.m.a {
    private ab aDd;
    private com.baidu.live.sdk.goods.b.b byM;
    private HostPreLiveGoodsEnterView byP;
    private HostLiveGoodsEnterView byQ;
    private c byR;
    private String byu;
    private TbPageContext mTbPageContext;
    private boolean byN = false;
    private boolean byO = false;
    private com.baidu.live.sdk.goods.b.a byS = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void b(int i, String str, boolean z, boolean z2) {
            if (b.this.byP != null) {
                if (z2) {
                    b.this.byP.Qh();
                    b.this.a(b.this.byP);
                    b.this.PP();
                } else {
                    b.this.byP.Qi();
                }
            }
            if (b.this.byQ != null) {
                if (z2) {
                    b.this.byQ.Qh();
                } else {
                    b.this.byQ.Qi();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.byP != null) {
                b.this.byP.dW(i2);
            }
            if (b.this.byQ != null) {
                b.this.byQ.dW(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.PP();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener byT = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener byU = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "shopmall"));
            b.this.PP();
            if (b.this.byR != null) {
                b.this.byR.display();
            }
        }
    };

    @Override // com.baidu.live.m.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.byM == null) {
            this.byM = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.byM.init();
        this.byM.a(this.byS);
        this.byR = new c(tbPageContext);
        this.byR.setHost(true);
    }

    @Override // com.baidu.live.m.a
    public com.baidu.live.core.a.a cB(boolean z) {
        if (z) {
            if (this.byP == null) {
                this.byP = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.byP.setOutClickListener(this.byT);
            }
            return this.byP;
        }
        if (this.byQ == null) {
            this.byQ = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.byQ.setOutClickListener(this.byU);
        }
        return this.byQ;
    }

    @Override // com.baidu.live.m.a
    public void Mp() {
        if (this.byM != null) {
            this.byM.Mp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.byO) {
            this.byO = true;
            if (!d.xc().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void hj(String str) {
        this.byu = str;
    }

    @Override // com.baidu.live.m.a
    public void h(ab abVar) {
        View rootLayout;
        this.aDd = abVar;
        if (this.byP != null && (rootLayout = this.byP.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.byP = null;
        }
        if (this.byR != null) {
            this.byR.PU();
            this.byR.a(abVar);
        }
    }

    @Override // com.baidu.live.m.a
    public void i(ab abVar) {
        this.aDd = abVar;
        if (this.byR != null) {
            this.byR.a(abVar);
        }
        if (this.byQ != null && this.byM.PT()) {
            this.byQ.Qh();
            if (!this.byN && abVar.mLiveInfo != null && abVar.aId != null) {
                this.byN = true;
                PP();
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void onResume() {
        if (this.byQ != null || this.byP != null) {
            PP();
        }
        if (this.byR != null) {
            this.byR.onResume();
        }
    }

    @Override // com.baidu.live.m.a
    public void onPause() {
        if (this.byR != null) {
            this.byR.onPause();
        }
    }

    @Override // com.baidu.live.m.a
    public void release() {
        if (this.byM != null) {
            this.byM.cancelLoadData();
            this.byM.release();
        }
        if (this.byR != null) {
            this.byR.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PP() {
        long j;
        long j2;
        String str;
        String str2;
        if (this.byM != null) {
            String str3 = "";
            String str4 = "";
            if (this.aDd == null || this.aDd.mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                str3 = this.aDd.mLiveInfo.feed_id;
                long j3 = this.aDd.mLiveInfo.live_id;
                j = this.aDd.mLiveInfo.user_id;
                j2 = j3;
            }
            if (TextUtils.isEmpty(this.byu)) {
                str = "";
                str2 = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.byu);
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
                        this.byM.a(str3, j2, j, str2, str, str4);
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = "";
                    str2 = "";
                }
            }
            this.byM.a(str3, j2, j, str2, str, str4);
        }
    }
}
