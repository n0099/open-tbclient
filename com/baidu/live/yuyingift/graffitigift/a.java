package com.baidu.live.yuyingift.graffitigift;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.graffitigift.b;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.live.yuyingift.a bXX;
    private b bZQ;
    private AlaGiftGraffitiShowView bZR;
    private Context mContext;
    private boolean bfU = false;
    private boolean aXa = false;
    private b.a bZS = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.FJ();
        }
    };
    private ArrayList<c> bfV = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bXX = aVar;
        initView();
    }

    private void initView() {
        this.bZR = new AlaGiftGraffitiShowView(this.mContext);
        this.bZQ = new b(this.bZR, this.mContext);
        this.bZQ.a(this.bZS);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bXX.aVn && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bZR.setLayoutParams(layoutParams);
        this.bXX.M(this.bZR);
    }

    public void EF() {
        this.bfU = false;
        this.bXX.M(this.bZR);
        FJ();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bfV.add(0, cVar);
            } else if (this.bfV.size() < com.baidu.live.ae.a.Qj().buX.aMX) {
                this.bfV.add(cVar);
            }
            if (cVar.bcW) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            FJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (!this.bfV.isEmpty() && !this.bfU && this.bZQ.isReady()) {
            c remove = this.bfV.remove(0);
            if (remove != null) {
                remove.aS(System.currentTimeMillis());
                m(remove);
                FJ();
                return;
            }
            FJ();
        }
    }

    private void m(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aXa) && this.bZQ.isReady()) {
            this.bZQ.n(cVar);
        }
    }

    public void onDestroy() {
        if (this.bZQ != null) {
            this.bZQ.destory();
        }
        this.bfU = false;
    }

    public void Hx() {
        if (this.bZQ != null) {
            this.bZQ.Hx();
        }
    }

    public void bB(boolean z) {
        this.aXa = z;
    }

    public void EL() {
        if (this.bZQ != null) {
            this.bZQ.EL();
        }
    }
}
