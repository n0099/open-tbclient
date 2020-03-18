package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private k aie;
    private b anQ;
    private AlaGiftGraffitiShowView anR;
    private Context mContext;
    private boolean anO = false;
    private boolean ahp = false;
    private b.a anS = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.tb();
        }
    };
    private ArrayList<c> anP = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aie = kVar;
        initView();
    }

    private void initView() {
        this.anR = new AlaGiftGraffitiShowView(this.mContext);
        this.anQ = new b(this.anR, this.mContext);
        this.anQ.a(this.anS);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.anR.setLayoutParams(layoutParams);
        this.aie.K(this.anR);
    }

    public void sm() {
        this.anO = false;
        this.aie.K(this.anR);
        tb();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.anP.add(0, cVar);
            } else if (this.anP.size() < com.baidu.live.v.a.zs().awM.aba) {
                this.anP.add(cVar);
            }
            if (cVar.alN) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.Yh, cVar.Yi, cVar.giftId, "");
            }
            tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        if (!this.anP.isEmpty() && !this.anO && this.anQ.isReady()) {
            c remove = this.anP.remove(0);
            if (remove != null) {
                remove.B(System.currentTimeMillis());
                i(remove);
                tb();
                return;
            }
            tb();
        }
    }

    private void i(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.ahp) && this.anQ.isReady()) {
            this.anQ.j(cVar);
        }
    }

    public void sl() {
        this.anO = true;
    }

    public void onDestroy() {
        if (this.anQ != null) {
            this.anQ.destory();
        }
        this.anO = false;
    }

    public void uG() {
        if (this.anQ != null) {
            this.anQ.uG();
        }
    }

    public void az(boolean z) {
        this.ahp = z;
    }

    public void ss() {
        if (this.anQ != null) {
            this.anQ.ss();
        }
    }
}
