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
    private com.baidu.live.yuyingift.a bJY;
    private b bLA;
    private AlaGiftGraffitiShowView bLB;
    private Context mContext;
    private boolean bcl = false;
    private boolean aUr = false;
    private b.a bLC = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.He();
        }
    };
    private ArrayList<c> bcm = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bJY = aVar;
        initView();
    }

    private void initView() {
        this.bLB = new AlaGiftGraffitiShowView(this.mContext);
        this.bLA = new b(this.bLB, this.mContext);
        this.bLA.a(this.bLC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bJY.aSH && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.bLB.setLayoutParams(layoutParams);
        this.bJY.M(this.bLB);
    }

    public void Gc() {
        this.bcl = false;
        this.bJY.M(this.bLB);
        He();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bcm.add(0, cVar);
            } else if (this.bcm.size() < com.baidu.live.z.a.Pq().bmJ.aMg) {
                this.bcm.add(cVar);
            }
            if (cVar.aZR) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            He();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (!this.bcm.isEmpty() && !this.bcl && this.bLA.isReady()) {
            c remove = this.bcm.remove(0);
            if (remove != null) {
                remove.ag(System.currentTimeMillis());
                n(remove);
                He();
                return;
            }
            He();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aUr) && this.bLA.isReady()) {
            this.bLA.o(cVar);
        }
    }

    public void onDestroy() {
        if (this.bLA != null) {
            this.bLA.destory();
        }
        this.bcl = false;
    }

    public void IJ() {
        if (this.bLA != null) {
            this.bLA.IJ();
        }
    }

    public void bq(boolean z) {
        this.aUr = z;
    }

    public void Gi() {
        if (this.bLA != null) {
            this.bLA.Gi();
        }
    }
}
