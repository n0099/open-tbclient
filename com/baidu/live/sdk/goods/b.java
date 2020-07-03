package com.baidu.live.sdk.goods;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.c;
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.j.a {
    private q aLQ;
    private String bbM;
    private com.baidu.live.sdk.goods.c.b bcd;
    private HostPreLiveGoodsEnterView bcg;
    private HostLiveGoodsEnterView bch;
    private com.baidu.live.sdk.goods.d.a bci;
    private TbPageContext mTbPageContext;
    private boolean bce = false;
    private boolean bcf = false;
    private com.baidu.live.sdk.goods.c.a bcj = new com.baidu.live.sdk.goods.c.a() { // from class: com.baidu.live.sdk.goods.b.1
        @Override // com.baidu.live.sdk.goods.c.a
        public void a(int i, String str, boolean z, boolean z2) {
            if (b.this.bcg != null) {
                if (z2) {
                    b.this.bcg.Hk();
                    b.this.GT();
                    if (b.this.bcd != null) {
                        b.this.bcd.d("", 0L, 0L);
                    }
                } else {
                    b.this.bcg.Hl();
                }
            }
            if (b.this.bch != null) {
                if (z2) {
                    b.this.bch.Hk();
                } else {
                    b.this.bch.Hl();
                }
            }
        }

        @Override // com.baidu.live.sdk.goods.c.a
        public void a(int i, String str, boolean z, long j, int i2, List<com.baidu.live.sdk.goods.a.a> list) {
            if (b.this.bcg != null) {
                b.this.bcg.cN(i2);
            }
            if (b.this.bch != null) {
                b.this.bch.cN(i2);
            }
        }
    };
    private View.OnClickListener bck = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.live.sdk.goods.e.a.m(b.this.mTbPageContext.getPageActivity(), "", "");
            LogManager.getLiveRecordLogger().doClickLiveStoreIconButtonLog("");
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "shopmall"));
        }
    };
    private View.OnClickListener bcl = new View.OnClickListener() { // from class: com.baidu.live.sdk.goods.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
            q qVar = b.this.aLQ;
            if (b.this.bci != null && qVar != null && qVar.mLiveInfo != null) {
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
                if (!TextUtils.isEmpty(b.this.bbM)) {
                    try {
                        JSONObject jSONObject = new JSONObject(b.this.bbM);
                        str3 = jSONObject.optString("tab");
                        str4 = jSONObject.optString("tag");
                        str5 = jSONObject.optString("source");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                long j2 = qVar.mLiveInfo.user_id;
                long j3 = qVar.mLiveInfo.group_id;
                b.this.bci.u(com.baidu.live.sdk.goods.e.a.a(valueOf2, valueOf, j, true, 1, str, str2, str3, str4, str5, String.valueOf(j2), qVar.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(qVar.axp.userId)), true);
            }
        }
    };

    @Override // com.baidu.live.j.a
    public void d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        if (this.bcd == null) {
            this.bcd = new com.baidu.live.sdk.goods.c.b(tbPageContext);
        }
        this.bcd.init();
        this.bcd.a(this.bcj);
        this.bci = new com.baidu.live.sdk.goods.d.a(tbPageContext);
    }

    @Override // com.baidu.live.j.a
    public com.baidu.live.core.a.a bO(boolean z) {
        if (z) {
            if (this.bcg == null) {
                this.bcg = new HostPreLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
                this.bcg.setOutClickListener(this.bck);
            }
            return this.bcg;
        }
        if (this.bch == null) {
            this.bch = new HostLiveGoodsEnterView(this.mTbPageContext.getPageActivity());
            this.bch.setOutClickListener(this.bcl);
        }
        return this.bch;
    }

    @Override // com.baidu.live.j.a
    public void Fm() {
        if (this.bcd != null) {
            this.bcd.Fm();
        }
    }

    @Override // com.baidu.live.j.a
    public void d(String str, long j, long j2) {
        if (this.bcd != null) {
            this.bcd.d(str, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        if (!this.bcf) {
            this.bcf = true;
            if (!c.vf().getBoolean("has_show_goods_auth_guide", false)) {
                new com.baidu.live.sdk.goods.b.b(this.mTbPageContext.getPageActivity()).c(this.bcg.getGoodsImageView(), this.bcg.getTargetView());
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void fB(String str) {
        this.bbM = str;
    }

    @Override // com.baidu.live.j.a
    public void h(q qVar) {
        View rootLayout;
        this.aLQ = qVar;
        if (this.bcg != null && (rootLayout = this.bcg.getRootLayout()) != null && rootLayout.getParent() != null) {
            ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            this.bcg = null;
        }
    }

    @Override // com.baidu.live.j.a
    public void i(q qVar) {
        this.aLQ = qVar;
        if (this.bch != null && this.bcd.GW()) {
            this.bch.Hk();
            if (!this.bce && qVar.mLiveInfo != null && qVar.axp != null) {
                this.bce = true;
                long j = this.aLQ.axp.userId;
                if (this.bcd != null) {
                    this.bcd.d(qVar.mLiveInfo.feed_id, qVar.mLiveInfo.live_id, j);
                }
            }
        }
    }

    @Override // com.baidu.live.j.a
    public void onResume() {
        if (this.bci != null) {
            this.bci.resume();
        }
        if ((this.bch != null || this.bcg != null) && this.bcd != null) {
            this.bcd.d("", 0L, 0L);
        }
    }

    @Override // com.baidu.live.j.a
    public void onPause() {
        if (this.bci != null) {
            this.bci.pause();
        }
    }

    @Override // com.baidu.live.j.a
    public void release() {
        if (this.bcd != null) {
            this.bcd.cancelLoadData();
            this.bcd.release();
        }
        if (this.bci != null) {
            this.bci.release();
        }
    }
}
