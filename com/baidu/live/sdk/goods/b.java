package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.c;
import com.baidu.live.data.q;
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
    private q avf;
    private com.baidu.live.sdk.goods.c.a bcA;
    private String bcd;
    private com.baidu.live.sdk.goods.b.b bcv;
    private HostPreLiveGoodsEnterView bcy;
    private HostLiveGoodsEnterView bcz;
    private TbPageContext mTbPageContext;
    private boolean bcw = false;
    private boolean bcx = false;
    private com.baidu.live.sdk.goods.b.a bcB = new com.baidu.live.sdk.goods.b.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bcy != null) {
                if (z2) {
                    b.this.bcy.Hq();
                    b.this.a(b.this.bcy);
                    if (b.this.bcv != null) {
                        b.this.bcv.d("", 0L, 0L);
                    }
                } else {
                    b.this.bcy.Hr();
                }
            }
            if (b.this.bcz != null) {
                if (z2) {
                    b.this.bcz.Hq();
                } else {
                    b.this.bcz.Hr();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.b.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bcy != null) {
                b.this.bcy.cO(i2);
            }
            if (b.this.bcz != null) {
                b.this.bcz.cO(i2);
            }
        }
    };
    private View.OnClickListener bcC = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.d.a.m(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bcD = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            q qVar = b.this.avf;
            if (b.this.bcA != null && qVar != null && qVar.mLiveInfo != null) {
                String valueOf = String.valueOf(qVar.mLiveInfo.live_id);
                String valueOf2 = String.valueOf(qVar.mLiveInfo.feed_id);
                long j = qVar.mLiveInfo.room_id;
                String str = qVar.mLiveInfo.cover;
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (qVar.mLiveInfo.session_info != null) {
                    str2 = qVar.mLiveInfo.session_info.flvUrl;
                }
                if (!TextUtils.isEmpty(b.this.bcd)) {
                    try {
                        JSONObject jSONObject = new JSONObject(b.this.bcd);
                        str3 = jSONObject.optString("tab");
                        str4 = jSONObject.optString("tag");
                        str5 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = qVar.mLiveInfo.user_id;
                long j3 = qVar.mLiveInfo.group_id;
                b.this.bcA.u(com.baidu.live.sdk.goods.d.a.a(valueOf2, valueOf, j, true, 1, str, str2, str3, str4, str5, String.valueOf(j2), qVar.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(qVar.ayC.userId)), true);
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bcv == null) {
            this.bcv = new com.baidu.live.sdk.goods.b.b(tbPageContext);
        }
        this.bcv.init();
        this.bcv.a(this.bcB);
        this.bcA = new com.baidu.live.sdk.goods.c.a(tbPageContext);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a bP(boolean z) {
        if (z) {
            if (this.bcy == null) {
                this.bcy = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bcy.setOutClickListener(this.bcC);
            }
            return this.bcy;
        }
        if (this.bcz == null) {
            this.bcz = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bcz.setOutClickListener(this.bcD);
        }
        return this.bcz;
    }

    @Override // com.baidu.live.j.a
    public void Fg() {
        if (this.bcv != null) {
            this.bcv.Fg();
        }
    }

    @Override // com.baidu.live.j.a
    public void d(String str, long j, long j2) {
        if (this.bcv != null) {
            this.bcv.d(str, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HostPreLiveGoodsEnterView hostPreLiveGoodsEnterView) {
        if (!this.bcx) {
            this.bcx = true;
            if (!c.vf().getBoolean("has_show_goods_auth_guide", false)) {
                new HostLiveGoodsAuthGuide(this.mTbPageContext.getPageActivity()).c(hostPreLiveGoodsEnterView.getGoodsImageView(), hostPreLiveGoodsEnterView.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void fz(String str) {
        this.bcd = str;
    }

    @Override // com.baidu.live.j.a
    public void h(q qVar) {
        View rootLayout;
        this.avf = qVar;
        if (this.bcy != null && (rootLayout = this.bcy.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bcy = null;
        }
    }

    @Override // com.baidu.live.j.a
    public void i(q qVar) {
        this.avf = qVar;
        if (this.bcz != null && this.bcv.Hc()) {
            this.bcz.Hq();
            if (!this.bcw && qVar.mLiveInfo != null && qVar.ayC != null) {
                this.bcw = true;
                long j = this.avf.ayC.userId;
                if (this.bcv != null) {
                    this.bcv.d(qVar.mLiveInfo.feed_id, qVar.mLiveInfo.live_id, j);
                }
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.bcA != null) {
            this.bcA.resume();
        }
        if ((this.bcz != null || this.bcy != null) && this.bcv != null) {
            this.bcv.d("", 0L, 0L);
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.bcA != null) {
            this.bcA.pause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.bcv != null) {
            this.bcv.cancelLoadData();
            this.bcv.release();
        }
        if (this.bcA != null) {
            this.bcA.release();
        }
    }
}
