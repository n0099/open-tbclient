package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private k afL;
    private b alt;
    private AlaGiftGraffitiShowView alu;
    private Context mContext;
    private boolean alr = false;
    private boolean aeY = false;
    private b.a alv = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.rL();
        }
    };
    private ArrayList<c> als = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.afL = kVar;
        initView();
    }

    private void initView() {
        this.alu = new AlaGiftGraffitiShowView(this.mContext);
        this.alt = new b(this.alu, this.mContext);
        this.alt.a(this.alv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.alu.setLayoutParams(layoutParams);
        this.afL.K(this.alu);
    }

    public void rg() {
        this.alr = false;
        this.afL.K(this.alu);
        rL();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.als.add(0, cVar);
            } else if (this.als.size() < com.baidu.live.s.a.wR().asq.YY) {
                this.als.add(cVar);
            }
            rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL() {
        if (!this.als.isEmpty() && !this.alr && this.alt.isReady()) {
            c remove = this.als.remove(0);
            if (remove != null) {
                remove.A(System.currentTimeMillis());
                i(remove);
                rL();
                return;
            }
            rL();
        }
    }

    private void i(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aeY) && this.alt.isReady()) {
            this.alt.j(cVar);
        }
    }

    public void rf() {
        this.alr = true;
    }

    public void onDestroy() {
        if (this.alt != null) {
            this.alt.destory();
        }
        this.alr = false;
    }

    public void tj() {
        if (this.alt != null) {
            this.alt.tj();
        }
    }

    public void aw(boolean z) {
        this.aeY = z;
    }

    public void rm() {
        if (this.alt != null) {
            this.alt.rm();
        }
    }
}
