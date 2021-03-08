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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.m.a {
    private ab aED;
    private com.baidu.live.sdk.goods.b.b bAm;
    private HostPreLiveGoodsEnterView bAp;
    private HostLiveGoodsEnterView bAq;
    private c bAr;
    private String bzU;
    private TbPageContext mTbPageContext;
    private boolean bAn = false;
    private boolean bAo = false;
    private com.baidu.live.sdk.goods.b.a bAs = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void b(int i, String str, boolean z, boolean z2) {
            if (b.this.bAp != null) {
                if (z2) {
                    b.this.bAp.Qk();
                    b.this.a(b.this.bAp);
                    b.this.PS();
                } else {
                    b.this.bAp.Ql();
                }
            }
            if (b.this.bAq != null) {
                if (z2) {
                    b.this.bAq.Qk();
                } else {
                    b.this.bAq.Ql();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bAp != null) {
                b.this.bAp.dX(i2);
            }
            if (b.this.bAq != null) {
                b.this.bAq.dX(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.PS();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bAt = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bAu = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "shopmall"));
            b.this.PS();
            if (b.this.bAr != null) {
                b.this.bAr.display();
            }
        }
    };

    @Override // com.baidu.live.m.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bAm == null) {
            this.bAm = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bAm.init();
        this.bAm.a(this.bAs);
        this.bAr = new c(tbPageContext);
        this.bAr.setHost(true);
    }

    @Override // com.baidu.live.m.a
    public com.baidu.live.core.a.a cB(boolean z) {
        if (z) {
            if (this.bAp == null) {
                this.bAp = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bAp.setOutClickListener(this.bAt);
            }
            return this.bAp;
        }
        if (this.bAq == null) {
            this.bAq = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bAq.setOutClickListener(this.bAu);
        }
        return this.bAq;
    }

    @Override // com.baidu.live.m.a
    public void Ms() {
        if (this.bAm != null) {
            this.bAm.Ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bAo) {
            this.bAo = true;
            if (!d.xf().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void hp(String str) {
        this.bzU = str;
    }

    @Override // com.baidu.live.m.a
    public void h(ab abVar) {
        View rootLayout;
        this.aED = abVar;
        if (this.bAp != null && (rootLayout = this.bAp.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bAp = null;
        }
        if (this.bAr != null) {
            this.bAr.PX();
            this.bAr.a(abVar);
        }
    }

    @Override // com.baidu.live.m.a
    public void i(ab abVar) {
        this.aED = abVar;
        if (this.bAr != null) {
            this.bAr.a(abVar);
        }
        if (this.bAq != null && this.bAm.PW()) {
            this.bAq.Qk();
            if (!this.bAn && abVar.mLiveInfo != null && abVar.aJD != null) {
                this.bAn = true;
                PS();
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void onResume() {
        if (this.bAq != null || this.bAp != null) {
            PS();
        }
        if (this.bAr != null) {
            this.bAr.onResume();
        }
    }

    @Override // com.baidu.live.m.a
    public void onPause() {
        if (this.bAr != null) {
            this.bAr.onPause();
        }
    }

    @Override // com.baidu.live.m.a
    public void release() {
        if (this.bAm != null) {
            this.bAm.cancelLoadData();
            this.bAm.release();
        }
        if (this.bAr != null) {
            this.bAr.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PS() {
        long j;
        long j2;
        String str;
        String str2;
        if (this.bAm != null) {
            String str3 = "";
            String str4 = "";
            if (this.aED == null || this.aED.mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                str3 = this.aED.mLiveInfo.feed_id;
                long j3 = this.aED.mLiveInfo.live_id;
                j = this.aED.mLiveInfo.user_id;
                j2 = j3;
            }
            if (TextUtils.isEmpty(this.bzU)) {
                str = "";
                str2 = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.bzU);
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
                        this.bAm.a(str3, j2, j, str2, str, str4);
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = "";
                    str2 = "";
                }
            }
            this.bAm.a(str3, j2, j, str2, str, str4);
        }
    }
}
