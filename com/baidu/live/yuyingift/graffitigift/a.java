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
    private com.baidu.live.yuyingift.a bYK;
    private b caA;
    private AlaGiftGraffitiShowView caB;
    private Context mContext;
    private boolean bhC = false;
    private boolean aYI = false;
    private b.a caC = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.Io();
        }
    };
    private ArrayList<c> bhD = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bYK = aVar;
        initView();
    }

    private void initView() {
        this.caB = new AlaGiftGraffitiShowView(this.mContext);
        this.caA = new b(this.caB, this.mContext);
        this.caA.a(this.caC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bYK.aWW && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.caB.setLayoutParams(layoutParams);
        this.bYK.M(this.caB);
    }

    public void Hk() {
        this.bhC = false;
        this.bYK.M(this.caB);
        Io();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bhD.add(0, cVar);
            } else if (this.bhD.size() < com.baidu.live.af.a.SE().bwi.aOX) {
                this.bhD.add(cVar);
            }
            if (cVar.beF) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            Io();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (!this.bhD.isEmpty() && !this.bhC && this.caA.isReady()) {
            c remove = this.bhD.remove(0);
            if (remove != null) {
                remove.aP(System.currentTimeMillis());
                m(remove);
                Io();
                return;
            }
            Io();
        }
    }

    private void m(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aYI) && this.caA.isReady()) {
            this.caA.n(cVar);
        }
    }

    public void onDestroy() {
        if (this.caA != null) {
            this.caA.destory();
        }
        this.bhC = false;
    }

    public void Kc() {
        if (this.caA != null) {
            this.caA.Kc();
        }
    }

    public void bA(boolean z) {
        this.aYI = z;
    }

    public void Hq() {
        if (this.caA != null) {
            this.caA.Hq();
        }
    }
}
