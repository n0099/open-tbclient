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
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.yuyingift.a bTa;
    private b bUI;
    private AlaGiftGraffitiShowView bUJ;
    private Context mContext;
    private boolean bfT = false;
    private boolean aXd = false;
    private b.a bUK = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.IN();
        }
    };
    private ArrayList<c> bfU = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bTa = aVar;
        initView();
    }

    private void initView() {
        this.bUJ = new AlaGiftGraffitiShowView(this.mContext);
        this.bUI = new b(this.bUJ, this.mContext);
        this.bUI.a(this.bUK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bTa.aVr && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bUJ.setLayoutParams(layoutParams);
        this.bTa.M(this.bUJ);
    }

    public void HJ() {
        this.bfT = false;
        this.bTa.M(this.bUJ);
        IN();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bfU.add(0, cVar);
            } else if (this.bfU.size() < com.baidu.live.ae.a.RB().brA.aOq) {
                this.bfU.add(cVar);
            }
            if (cVar.bcX) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            IN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (!this.bfU.isEmpty() && !this.bfT && this.bUI.isReady()) {
            c remove = this.bfU.remove(0);
            if (remove != null) {
                remove.aQ(System.currentTimeMillis());
                n(remove);
                IN();
                return;
            }
            IN();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aXd) && this.bUI.isReady()) {
            this.bUI.o(cVar);
        }
    }

    public void onDestroy() {
        if (this.bUI != null) {
            this.bUI.destory();
        }
        this.bfT = false;
    }

    public void KB() {
        if (this.bUI != null) {
            this.bUI.KB();
        }
    }

    public void bC(boolean z) {
        this.aXd = z;
    }

    public void HP() {
        if (this.bUI != null) {
            this.bUI.HP();
        }
    }
}
