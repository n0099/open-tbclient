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
    private b anF;
    private AlaGiftGraffitiShowView anG;
    private Context mContext;
    private boolean anD = false;
    private boolean ahf = false;
    private b.a anH = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.sW();
        }
    };
    private ArrayList<c> anE = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.ahT = kVar;
        initView();
    }

    private void initView() {
        this.anG = new AlaGiftGraffitiShowView(this.mContext);
        this.anF = new b(this.anG, this.mContext);
        this.anF.a(this.anH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.anG.setLayoutParams(layoutParams);
        this.ahT.K(this.anG);
    }

    public void sh() {
        this.anD = false;
        this.ahT.K(this.anG);
        sW();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.anE.add(0, cVar);
            } else if (this.anE.size() < com.baidu.live.v.a.zl().awB.aaQ) {
                this.anE.add(cVar);
            }
            if (cVar.alC) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.XX, cVar.XY, cVar.giftId, "");
            }
            sW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW() {
        if (!this.anE.isEmpty() && !this.anD && this.anF.isReady()) {
            c remove = this.anE.remove(0);
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
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.ahf) && this.anF.isReady()) {
            this.anF.j(cVar);
        }
    }

    public void sg() {
        this.anD = true;
    }

    public void onDestroy() {
        if (this.anF != null) {
            this.anF.destory();
        }
        this.anD = false;
    }

    public void uB() {
        if (this.anF != null) {
            this.anF.uB();
        }
    }

    public void az(boolean z) {
        this.ahf = z;
    }

    public void sn() {
        if (this.anF != null) {
            this.anF.sn();
        }
    }
}
