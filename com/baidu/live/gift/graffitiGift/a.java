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
    private k aAD;
    private b aGo;
    private AlaGiftGraffitiShowView aGp;
    private Context mContext;
    private boolean aGm = false;
    private boolean azP = false;
    private b.a aGq = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.xt();
        }
    };
    private ArrayList<c> aGn = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aAD = kVar;
        initView();
    }

    private void initView() {
        this.aGp = new AlaGiftGraffitiShowView(this.mContext);
        this.aGo = new b(this.aGp, this.mContext);
        this.aGo.a(this.aGq);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aAD.ayo && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aGp.setLayoutParams(layoutParams);
        this.aAD.M(this.aGp);
    }

    public void wE() {
        this.aGm = false;
        this.aAD.M(this.aGp);
        xt();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aGn.add(0, cVar);
            } else if (this.aGn.size() < com.baidu.live.v.a.En().aQu.atv) {
                this.aGn.add(cVar);
            }
            if (cVar.aEj) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aqw, cVar.aqx, cVar.giftId, "");
            }
            xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (!this.aGn.isEmpty() && !this.aGm && this.aGo.isReady()) {
            c remove = this.aGn.remove(0);
            if (remove != null) {
                remove.Z(System.currentTimeMillis());
                k(remove);
                xt();
                return;
            }
            xt();
        }
    }

    private void k(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.azP) && this.aGo.isReady()) {
            this.aGo.l(cVar);
        }
    }

    public void wD() {
        this.aGm = true;
    }

    public void onDestroy() {
        if (this.aGo != null) {
            this.aGo.destory();
        }
        this.aGm = false;
    }

    public void za() {
        if (this.aGo != null) {
            this.aGo.za();
        }
    }

    public void aX(boolean z) {
        this.azP = z;
    }

    public void wK() {
        if (this.aGo != null) {
            this.aGo.wK();
        }
    }
}
