package com.baidu.live.gift.graffitiGift;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private k aFW;
    private b aLW;
    private AlaGiftGraffitiShowView aLX;
    private Context mContext;
    private boolean aLU = false;
    private boolean aFh = false;
    private b.a aLY = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.yH();
        }
    };
    private ArrayList<c> aLV = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aFW = kVar;
        initView();
    }

    private void initView() {
        this.aLX = new AlaGiftGraffitiShowView(this.mContext);
        this.aLW = new b(this.aLX, this.mContext);
        this.aLW.a(this.aLY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aFW.aDG && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aLX.setLayoutParams(layoutParams);
        this.aFW.L(this.aLX);
    }

    public void xV() {
        this.aLU = false;
        this.aFW.L(this.aLX);
        yH();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aLV.add(0, cVar);
            } else if (this.aLV.size() < com.baidu.live.v.a.Ge().aWF.ayt) {
                this.aLV.add(cVar);
            }
            if (cVar.aJI) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.avv, cVar.avw, cVar.giftId, "");
            }
            yH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH() {
        if (!this.aLV.isEmpty() && !this.aLU && this.aLW.isReady()) {
            c remove = this.aLV.remove(0);
            if (remove != null) {
                remove.ad(System.currentTimeMillis());
                n(remove);
                yH();
                return;
            }
            yH();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aFh) && this.aLW.isReady()) {
            this.aLW.o(cVar);
        }
    }

    public void xU() {
        this.aLU = true;
    }

    public void onDestroy() {
        if (this.aLW != null) {
            this.aLW.destory();
        }
        this.aLU = false;
    }

    public void Ao() {
        if (this.aLW != null) {
            this.aLW.Ao();
        }
    }

    public void bc(boolean z) {
        this.aFh = z;
    }

    public void yb() {
        if (this.aLW != null) {
            this.aLW.yb();
        }
    }
}
