package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.j;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private j Xr;
    private b acJ;
    private AlaGiftGraffitiShowView acK;
    private Context mContext;
    private boolean acH = false;
    private boolean WL = false;
    private b.a acL = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.pW();
        }
    };
    private ArrayList<d> acI = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.Xr = jVar;
        initView();
    }

    private void initView() {
        this.acK = new AlaGiftGraffitiShowView(this.mContext);
        this.acJ = new b(this.acK, this.mContext);
        this.acJ.a(this.acL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.acK.setLayoutParams(layoutParams);
        this.Xr.J(this.acK);
    }

    public void px() {
        this.acH = false;
        this.Xr.J(this.acK);
        pW();
    }

    public void e(d dVar) {
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.acI.add(0, dVar);
            } else if (this.acI.size() < com.baidu.live.l.a.uB().ajF.Sa) {
                this.acI.add(dVar);
            }
            pW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW() {
        if (!this.acI.isEmpty() && !this.acH && this.acJ.isReady()) {
            d remove = this.acI.remove(0);
            if (remove != null) {
                remove.y(System.currentTimeMillis());
                i(remove);
                pW();
                return;
            }
            pW();
        }
    }

    private void i(d dVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.WL) && this.acJ.isReady()) {
            this.acJ.j(dVar);
        }
    }

    public void pw() {
        this.acH = true;
    }

    public void onDestroy() {
        if (this.acJ != null) {
            this.acJ.destory();
        }
        this.acH = false;
    }

    public void rj() {
        if (this.acJ != null) {
            this.acJ.rj();
        }
    }

    public void aj(boolean z) {
        this.WL = z;
    }
}
