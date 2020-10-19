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
    private u aDU;
    private com.baidu.live.sdk.goods.b.b boF;
    private HostPreLiveGoodsEnterView boI;
    private HostLiveGoodsEnterView boJ;
    private c boK;
    private String bon;
    private TbPageContext mTbPageContext;
    private boolean boG = false;
    private boolean boH = false;
    private com.baidu.live.sdk.goods.b.a boL = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.boI != null) {
                if (z2) {
                    b.this.boI.OQ();
                    b.this.a(b.this.boI);
                    b.this.Oz();
                } else {
                    b.this.boI.OR();
                }
            }
            if (b.this.boJ != null) {
                if (z2) {
                    b.this.boJ.OQ();
                } else {
                    b.this.boJ.OR();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.boI != null) {
                b.this.boI.fb(i2);
            }
            if (b.this.boJ != null) {
                b.this.boJ.fb(i2);
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(boolean z, String str, String str2, String str3, int i) {
            if (z) {
                b.this.Oz();
            } else if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
            }
        }
    };
    private View.OnClickListener boM = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.o(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener boN = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            b.this.Oz();
            if (b.this.boK != null) {
                b.this.boK.display();
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.boF == null) {
            this.boF = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.boF.init();
        this.boF.a(this.boL);
        this.boK = new c(tbPageContext);
        this.boK.setHost(true);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a ca(boolean z) {
        if (z) {
            if (this.boI == null) {
                this.boI = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.boI.setOutClickListener(this.boM);
            }
            return this.boI;
        }
        if (this.boJ == null) {
            this.boJ = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.boJ.setOutClickListener(this.boN);
        }
        return this.boJ;
    }

    @Override // com.baidu.live.j.a
    public void My() {
        if (this.boF != null) {
            this.boF.My();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.boH) {
            this.boH = true;
            if (!com.baidu.live.c.AZ().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void hz(String str) {
        this.bon = str;
    }

    @Override // com.baidu.live.j.a
    public void f(u uVar) {
        View rootLayout;
        this.aDU = uVar;
        if (this.boI != null && (rootLayout = this.boI.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.boI = null;
        }
        if (this.boK != null) {
            this.boK.OE();
            this.boK.a(uVar);
        }
    }

    @Override // com.baidu.live.j.a
    public void j(u uVar) {
        this.aDU = uVar;
        if (this.boK != null) {
            this.boK.a(uVar);
        }
        if (this.boJ != null && this.boF.OD()) {
            this.boJ.OQ();
            if (!this.boG && uVar.mLiveInfo != null && uVar.aHD != null) {
                this.boG = true;
                Oz();
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.boJ != null || this.boI != null) {
            Oz();
        }
        if (this.boK != null) {
            this.boK.onResume();
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.boK != null) {
            this.boK.onPause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.boF != null) {
            this.boF.cancelLoadData();
            this.boF.release();
        }
        if (this.boK != null) {
            this.boK.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oz() {
        long j;
        long j2 = 0;
        if (this.boF != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (this.aDU == null || this.aDU.mLiveInfo == null) {
                j = 0;
            } else {
                str = this.aDU.mLiveInfo.feed_id;
                j = this.aDU.mLiveInfo.live_id;
                j2 = this.aDU.mLiveInfo.user_id;
            }
            if (!TextUtils.isEmpty(this.bon)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bon);
                    str2 = jSONObject.optString("tab");
                    str3 = jSONObject.optString("tag");
                    str4 = jSONObject.optString("source");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.boF.a(str, j, j2, str2, str3, str4);
        }
    }
}
