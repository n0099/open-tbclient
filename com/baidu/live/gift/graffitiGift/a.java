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
    private k ahT;
    private b anG;
    private AlaGiftGraffitiShowView anH;
    private Context mContext;
    private boolean anE = false;
    private boolean ahf = false;
    private b.a anI = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.sW();
        }
    };
    private ArrayList<c> anF = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.ahT = kVar;
        initView();
    }

    private void initView() {
        this.anH = new AlaGiftGraffitiShowView(this.mContext);
        this.anG = new b(this.anH, this.mContext);
        this.anG.a(this.anI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.anH.setLayoutParams(layoutParams);
        this.ahT.K(this.anH);
    }

    public void sh() {
        this.anE = false;
        this.ahT.K(this.anH);
        sW();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.anF.add(0, cVar);
            } else if (this.anF.size() < com.baidu.live.v.a.zl().awC.aaQ) {
                this.anF.add(cVar);
            }
            if (cVar.alD) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.XX, cVar.XY, cVar.giftId, "");
            }
            sW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW() {
        if (!this.anF.isEmpty() && !this.anE && this.anG.isReady()) {
            c remove = this.anF.remove(0);
            if (remove != null) {
                remove.B(System.currentTimeMillis());
                i(remove);
                sW();
                return;
            }
            sW();
        }
    }

    private void i(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.ahf) && this.anG.isReady()) {
            this.anG.j(cVar);
        }
    }

    public void sg() {
        this.anE = true;
    }

    public void onDestroy() {
        if (this.anG != null) {
            this.anG.destory();
        }
        this.anE = false;
    }

    public void uB() {
        if (this.anG != null) {
            this.anG.uB();
        }
    }

    public void az(boolean z) {
        this.ahf = z;
    }

    public void sn() {
        if (this.anG != null) {
            this.anG.sn();
        }
    }
}
