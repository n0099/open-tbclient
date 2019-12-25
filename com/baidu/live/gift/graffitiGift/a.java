package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private k afc;
    private b akG;
    private AlaGiftGraffitiShowView akH;
    private Context mContext;
    private boolean akE = false;
    private boolean aep = false;
    private b.a akI = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.ry();
        }
    };
    private ArrayList<com.baidu.live.gift.a.b> akF = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.afc = kVar;
        initView();
    }

    private void initView() {
        this.akH = new AlaGiftGraffitiShowView(this.mContext);
        this.akG = new b(this.akH, this.mContext);
        this.akG.a(this.akI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.akH.setLayoutParams(layoutParams);
        this.afc.K(this.akH);
    }

    public void qU() {
        this.akE = false;
        this.afc.K(this.akH);
        ry();
    }

    public void e(com.baidu.live.gift.a.b bVar) {
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.giftId)) {
            if (bVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.akF.add(0, bVar);
            } else if (this.akF.size() < com.baidu.live.r.a.wA().arE.YM) {
                this.akF.add(bVar);
            }
            ry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        if (!this.akF.isEmpty() && !this.akE && this.akG.isReady()) {
            com.baidu.live.gift.a.b remove = this.akF.remove(0);
            if (remove != null) {
                remove.A(System.currentTimeMillis());
                i(remove);
                ry();
                return;
            }
            ry();
        }
    }

    private void i(com.baidu.live.gift.a.b bVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aep) && this.akG.isReady()) {
            this.akG.j(bVar);
        }
    }

    public void qT() {
        this.akE = true;
    }

    public void onDestroy() {
        if (this.akG != null) {
            this.akG.destory();
        }
        this.akE = false;
    }

    public void sT() {
        if (this.akG != null) {
            this.akG.sT();
        }
    }

    public void aw(boolean z) {
        this.aep = z;
    }

    public void ra() {
        if (this.akG != null) {
            this.akG.ra();
        }
    }
}
