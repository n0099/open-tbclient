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
/* loaded from: classes3.dex */
public class a {
    private k aIs;
    private b aOC;
    private AlaGiftGraffitiShowView aOD;
    private Context mContext;
    private boolean aOA = false;
    private boolean aHD = false;
    private b.a aOE = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.zh();
        }
    };
    private ArrayList<c> aOB = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aIs = kVar;
        initView();
    }

    private void initView() {
        this.aOD = new AlaGiftGraffitiShowView(this.mContext);
        this.aOC = new b(this.aOD, this.mContext);
        this.aOC.a(this.aOE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aIs.aGc && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aOD.setLayoutParams(layoutParams);
        this.aIs.J(this.aOD);
    }

    public void yv() {
        this.aOA = false;
        this.aIs.J(this.aOD);
        zh();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aOB.add(0, cVar);
            } else if (this.aOB.size() < com.baidu.live.v.a.Hm().aZp.aAI) {
                this.aOB.add(cVar);
            }
            if (cVar.aMo) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.axB, cVar.axC, cVar.giftId, "");
            }
            zh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (!this.aOB.isEmpty() && !this.aOA && this.aOC.isReady()) {
            c remove = this.aOB.remove(0);
            if (remove != null) {
                remove.ad(System.currentTimeMillis());
                n(remove);
                zh();
                return;
            }
            zh();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aHD) && this.aOC.isReady()) {
            this.aOC.o(cVar);
        }
    }

    public void yu() {
        this.aOA = true;
    }

    public void onDestroy() {
        if (this.aOC != null) {
            this.aOC.destory();
        }
        this.aOA = false;
    }

    public void AO() {
        if (this.aOC != null) {
            this.aOC.AO();
        }
    }

    public void bc(boolean z) {
        this.aHD = z;
    }

    public void yB() {
        if (this.aOC != null) {
            this.aOC.yB();
        }
    }
}
