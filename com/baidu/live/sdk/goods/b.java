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
public class b implements com.baidu.live.m.a {
    private w aFN;
    private String buT;
    private com.baidu.live.sdk.goods.b.b bvl;
    private HostPreLiveGoodsEnterView bvo;
    private HostLiveGoodsEnterView bvp;
    private c bvq;
    private TbPageContext mTbPageContext;
    private boolean bvm = false;
    private boolean bvn = false;
    private com.baidu.live.sdk.goods.b.a bvr = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bvo != null) {
                if (z2) {
                    b.this.bvo.Rz();
                    b.this.a(b.this.bvo);
                    b.this.Ri();
                } else {
                    b.this.bvo.RA();
                }
            }
            if (b.this.bvp != null) {
                if (z2) {
                    b.this.bvp.Rz();
                } else {
                    b.this.bvp.RA();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bvo != null) {
                b.this.bvo.fx(i2);
            }
            if (b.this.bvp != null) {
                b.this.bvp.fx(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Ri();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bvs = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bvt = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "shopmall"));
            b.this.Ri();
            if (b.this.bvq != null) {
                b.this.bvq.su();
            }
        }
    };

    @Override // com.baidu.live.m.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bvl == null) {
            this.bvl = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bvl.init();
        this.bvl.a(this.bvr);
        this.bvq = new c(tbPageContext);
        this.bvq.setHost(true);
    }

    @Override // com.baidu.live.m.a
    public com.baidu.live.core.a.a ct(boolean z) {
        if (z) {
            if (this.bvo == null) {
                this.bvo = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bvo.setOutClickListener(this.bvs);
            }
            return this.bvo;
        }
        if (this.bvp == null) {
            this.bvp = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bvp.setOutClickListener(this.bvt);
        }
        return this.bvp;
    }

    @Override // com.baidu.live.m.a
    public void Pb() {
        if (this.bvl != null) {
            this.bvl.Pb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bvn) {
            this.bvn = true;
            if (!d.BM().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void ik(String str) {
        this.buT = str;
    }

    @Override // com.baidu.live.m.a
    public void e(w wVar) {
        View rootLayout;
        this.aFN = wVar;
        if (this.bvo != null && (rootLayout = this.bvo.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bvo = null;
        }
        if (this.bvq != null) {
            this.bvq.Rn();
            this.bvq.a(wVar);
        }
    }

    @Override // com.baidu.live.m.a
    public void h(w wVar) {
        this.aFN = wVar;
        if (this.bvq != null) {
            this.bvq.a(wVar);
        }
        if (this.bvp != null && this.bvl.Rm()) {
            this.bvp.Rz();
            if (!this.bvm && wVar.mLiveInfo != null && wVar.aJV != null) {
                this.bvm = true;
                Ri();
            }
        }
    }

    @Override // com.baidu.live.m.a
    public void onResume() {
        if (this.bvp != null || this.bvo != null) {
            Ri();
        }
        if (this.bvq != null) {
            this.bvq.onResume();
        }
    }

    @Override // com.baidu.live.m.a
    public void onPause() {
        if (this.bvq != null) {
            this.bvq.onPause();
        }
    }

    @Override // com.baidu.live.m.a
    public void release() {
        if (this.bvl != null) {
            this.bvl.cancelLoadData();
            this.bvl.release();
        }
        if (this.bvq != null) {
            this.bvq.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        long j;
        long j2 = 0;
        if (this.bvl != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aFN == null || this.aFN.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aFN.mLiveInfo.feed_id;
                j = this.aFN.mLiveInfo.live_id;
                j2 = this.aFN.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.buT)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.buT);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bvl.a(str, j, j2, str2, str3, str4);
        }
    }
}
