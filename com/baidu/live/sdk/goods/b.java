package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.u;
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
public class b implements com.baidu.live.j.a {
    private u aAP;
    private String bkA;
    private com.baidu.live.sdk.goods.b.b bkS;
    private HostPreLiveGoodsEnterView bkV;
    private HostLiveGoodsEnterView bkW;
    private c bkX;
    private TbPageContext mTbPageContext;
    private boolean bkT = false;
    private boolean bkU = false;
    private com.baidu.live.sdk.goods.b.a bkY = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bkV != null) {
                if (z2) {
                    b.this.bkV.NL();
                    b.this.a(b.this.bkV);
                    b.this.Nu();
                } else {
                    b.this.bkV.NM();
                }
            }
            if (b.this.bkW != null) {
                if (z2) {
                    b.this.bkW.NL();
                } else {
                    b.this.bkW.NM();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bkV != null) {
                b.this.bkV.eS(i2);
            }
            if (b.this.bkW != null) {
                b.this.bkW.eS(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Nu();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener bkZ = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.m(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bla = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.Nu();
            if (b.this.bkX != null) {
                b.this.bkX.display();
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bkS == null) {
            this.bkS = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bkS.init();
        this.bkS.a(this.bkY);
        this.bkX = new c(tbPageContext);
        this.bkX.setHost(true);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a bX(boolean z) {
        if (z) {
            if (this.bkV == null) {
                this.bkV = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bkV.setOutClickListener(this.bkZ);
            }
            return this.bkV;
        }
        if (this.bkW == null) {
            this.bkW = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bkW.setOutClickListener(this.bla);
        }
        return this.bkW;
    }

    @Override // com.baidu.live.j.a
    public void Lt() {
        if (this.bkS != null) {
            this.bkS.Lt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bkU) {
            this.bkU = true;
            if (!com.baidu.live.c.AR().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void hi(String str) {
        this.bkA = str;
    }

    @Override // com.baidu.live.j.a
    public void i(u uVar) {
        View rootLayout;
        this.aAP = uVar;
        if (this.bkV != null && (rootLayout = this.bkV.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bkV = null;
        }
        if (this.bkX != null) {
            this.bkX.Nz();
            this.bkX.a(uVar);
        }
    }

    @Override // com.baidu.live.j.a
    public void j(u uVar) {
        this.aAP = uVar;
        if (this.bkX != null) {
            this.bkX.a(uVar);
        }
        if (this.bkW != null && this.bkS.Ny()) {
            this.bkW.NL();
            if (!this.bkT && uVar.mLiveInfo != null && uVar.aEz != null) {
                this.bkT = true;
                Nu();
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.bkW != null || this.bkV != null) {
            Nu();
        }
        if (this.bkX != null) {
            this.bkX.onResume();
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.bkX != null) {
            this.bkX.onPause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.bkS != null) {
            this.bkS.cancelLoadData();
            this.bkS.release();
        }
        if (this.bkX != null) {
            this.bkX.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu() {
        long j;
        long j2 = 0;
        if (this.bkS != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aAP == null || this.aAP.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aAP.mLiveInfo.feed_id;
                j = this.aAP.mLiveInfo.live_id;
                j2 = this.aAP.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bkA)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bkA);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.bkS.a(str, j, j2, str2, str3, str4);
        }
    }
}
