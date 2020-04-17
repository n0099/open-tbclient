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
    private k aAx;
    private b aGi;
    private AlaGiftGraffitiShowView aGj;
    private Context mContext;
    private boolean aGg = false;
    private boolean azJ = false;
    private b.a aGk = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.xu();
        }
    };
    private ArrayList<c> aGh = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aAx = kVar;
        initView();
    }

    private void initView() {
        this.aGj = new AlaGiftGraffitiShowView(this.mContext);
        this.aGi = new b(this.aGj, this.mContext);
        this.aGi.a(this.aGk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aAx.ayi && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aGj.setLayoutParams(layoutParams);
        this.aAx.M(this.aGj);
    }

    public void wF() {
        this.aGg = false;
        this.aAx.M(this.aGj);
        xu();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aGh.add(0, cVar);
            } else if (this.aGh.size() < com.baidu.live.v.a.Eo().aQp.atp) {
                this.aGh.add(cVar);
            }
            if (cVar.aEd) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aqq, cVar.aqr, cVar.giftId, "");
            }
            xu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu() {
        if (!this.aGh.isEmpty() && !this.aGg && this.aGi.isReady()) {
            c remove = this.aGh.remove(0);
            if (remove != null) {
                remove.Z(System.currentTimeMillis());
                k(remove);
                xu();
                return;
            }
            xu();
        }
    }

    private void k(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.azJ) && this.aGi.isReady()) {
            this.aGi.l(cVar);
        }
    }

    public void wE() {
        this.aGg = true;
    }

    public void onDestroy() {
        if (this.aGi != null) {
            this.aGi.destory();
        }
        this.aGg = false;
    }

    public void zb() {
        if (this.aGi != null) {
            this.aGi.zb();
        }
    }

    public void aX(boolean z) {
        this.azJ = z;
    }

    public void wL() {
        if (this.aGi != null) {
            this.aGi.wL();
        }
    }
}
