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
    private k aOZ;
    private b aVl;
    private AlaGiftGraffitiShowView aVm;
    private Context mContext;
    private boolean aVj = false;
    private boolean aOj = false;
    private b.a aVn = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.Fm();
        }
    };
    private ArrayList<c> aVk = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aOZ = kVar;
        initView();
    }

    private void initView() {
        this.aVm = new AlaGiftGraffitiShowView(this.mContext);
        this.aVl = new b(this.aVm, this.mContext);
        this.aVl.a(this.aVn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aOZ.aMH && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aVm.setLayoutParams(layoutParams);
        this.aOZ.M(this.aVm);
    }

    public void EA() {
        this.aVj = false;
        this.aOZ.M(this.aVm);
        Fm();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aVk.add(0, cVar);
            } else if (this.aVk.size() < com.baidu.live.w.a.Nk().beH.aHf) {
                this.aVk.add(cVar);
            }
            if (cVar.aSW) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aDW, cVar.aDX, cVar.giftId, "");
            }
            Fm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (!this.aVk.isEmpty() && !this.aVj && this.aVl.isReady()) {
            c remove = this.aVk.remove(0);
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
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aOj) && this.aVl.isReady()) {
            this.aVl.o(cVar);
        }
    }

    public void Ez() {
        this.aVj = true;
    }

    public void onDestroy() {
        if (this.aVl != null) {
            this.aVl.destory();
        }
        this.aVj = false;
    }

    public void GT() {
        if (this.aVl != null) {
            this.aVl.GT();
        }
    }

    public void bj(boolean z) {
        this.aOj = z;
    }

    public void EG() {
        if (this.aVl != null) {
            this.aVl.EG();
        }
    }
}
