package com.baidu.live.gift.graffitiGift;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private k aJO;
    private b aPX;
    private AlaGiftGraffitiShowView aPY;
    private Context mContext;
    private boolean aPV = false;
    private boolean aIY = false;
    private b.a aPZ = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.zJ();
        }
    };
    private ArrayList<c> aPW = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aJO = kVar;
        initView();
    }

    private void initView() {
        this.aPY = new AlaGiftGraffitiShowView(this.mContext);
        this.aPX = new b(this.aPY, this.mContext);
        this.aPX.a(this.aPZ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aJO.aHx && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aPY.setLayoutParams(layoutParams);
        this.aJO.M(this.aPY);
    }

    public void yX() {
        this.aPV = false;
        this.aJO.M(this.aPY);
        zJ();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aPW.add(0, cVar);
            } else if (this.aPW.size() < com.baidu.live.v.a.Hs().aZn.aBV) {
                this.aPW.add(cVar);
            }
            if (cVar.aNJ) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.ayO, cVar.ayP, cVar.giftId, "");
            }
            zJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zJ() {
        if (!this.aPW.isEmpty() && !this.aPV && this.aPX.isReady()) {
            c remove = this.aPW.remove(0);
            if (remove != null) {
                remove.ad(System.currentTimeMillis());
                n(remove);
                zJ();
                return;
            }
            zJ();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aIY) && this.aPX.isReady()) {
            this.aPX.o(cVar);
        }
    }

    public void yW() {
        this.aPV = true;
    }

    public void onDestroy() {
        if (this.aPX != null) {
            this.aPX.destory();
        }
        this.aPV = false;
    }

    public void Bq() {
        if (this.aPX != null) {
            this.aPX.Bq();
        }
    }

    public void bf(boolean z) {
        this.aIY = z;
    }

    public void zd() {
        if (this.aPX != null) {
            this.aPX.zd();
        }
    }
}
