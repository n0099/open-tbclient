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
/* loaded from: classes7.dex */
public class a {
    private k aPb;
    private b aVn;
    private AlaGiftGraffitiShowView aVo;
    private Context mContext;
    private boolean aVl = false;
    private boolean aOl = false;
    private b.a aVp = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.Fm();
        }
    };
    private ArrayList<c> aVm = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aPb = kVar;
        initView();
    }

    private void initView() {
        this.aVo = new AlaGiftGraffitiShowView(this.mContext);
        this.aVn = new b(this.aVo, this.mContext);
        this.aVn.a(this.aVp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aPb.aMJ && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aVo.setLayoutParams(layoutParams);
        this.aPb.M(this.aVo);
    }

    public void EA() {
        this.aVl = false;
        this.aPb.M(this.aVo);
        Fm();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aVm.add(0, cVar);
            } else if (this.aVm.size() < com.baidu.live.w.a.Nk().beJ.aHh) {
                this.aVm.add(cVar);
            }
            if (cVar.aSY) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aDY, cVar.aDZ, cVar.giftId, "");
            }
            Fm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (!this.aVm.isEmpty() && !this.aVl && this.aVn.isReady()) {
            c remove = this.aVm.remove(0);
            if (remove != null) {
                remove.ae(System.currentTimeMillis());
                n(remove);
                Fm();
                return;
            }
            Fm();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aOl) && this.aVn.isReady()) {
            this.aVn.o(cVar);
        }
    }

    public void Ez() {
        this.aVl = true;
    }

    public void onDestroy() {
        if (this.aVn != null) {
            this.aVn.destory();
        }
        this.aVl = false;
    }

    public void GT() {
        if (this.aVn != null) {
            this.aVn.GT();
        }
    }

    public void bj(boolean z) {
        this.aOl = z;
    }

    public void EG() {
        if (this.aVn != null) {
            this.aVn.EG();
        }
    }
}
