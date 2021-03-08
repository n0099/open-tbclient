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
/* loaded from: classes10.dex */
public class a {
    private com.baidu.live.yuyingift.a bZx;
    private b cbq;
    private AlaGiftGraffitiShowView cbr;
    private Context mContext;
    private boolean bhv = false;
    private boolean aYA = false;
    private b.a cbt = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.FM();
        }
    };
    private ArrayList<c> bhw = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bZx = aVar;
        initView();
    }

    private void initView() {
        this.cbr = new AlaGiftGraffitiShowView(this.mContext);
        this.cbq = new b(this.cbr, this.mContext);
        this.cbq.a(this.cbt);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bZx.aWN && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.cbr.setLayoutParams(layoutParams);
        this.bZx.M(this.cbr);
    }

    public void EI() {
        this.bhv = false;
        this.bZx.M(this.cbr);
        FM();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bhw.add(0, cVar);
            } else if (this.bhw.size() < com.baidu.live.ae.a.Qm().bwx.aOx) {
                this.bhw.add(cVar);
            }
            if (cVar.bey) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (!this.bhw.isEmpty() && !this.bhv && this.cbq.isReady()) {
            c remove = this.bhw.remove(0);
            if (remove != null) {
                remove.aS(System.currentTimeMillis());
                m(remove);
                FM();
                return;
            }
            FM();
        }
    }

    private void m(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aYA) && this.cbq.isReady()) {
            this.cbq.n(cVar);
        }
    }

    public void onDestroy() {
        if (this.cbq != null) {
            this.cbq.destory();
        }
        this.bhv = false;
    }

    public void HA() {
        if (this.cbq != null) {
            this.cbq.HA();
        }
    }

    public void bB(boolean z) {
        this.aYA = z;
    }

    public void EO() {
        if (this.cbq != null) {
            this.cbq.EO();
        }
    }
}
