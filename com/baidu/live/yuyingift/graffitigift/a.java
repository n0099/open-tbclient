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
    private com.baidu.live.yuyingift.a bTY;
    private b bVO;
    private AlaGiftGraffitiShowView bVP;
    private Context mContext;
    private boolean bcL = false;
    private boolean aTV = false;
    private b.a bVQ = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.Et();
        }
    };
    private ArrayList<c> bcM = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bTY = aVar;
        initView();
    }

    private void initView() {
        this.bVP = new AlaGiftGraffitiShowView(this.mContext);
        this.bVO = new b(this.bVP, this.mContext);
        this.bVO.a(this.bVQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bTY.aSj && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bVP.setLayoutParams(layoutParams);
        this.bTY.M(this.bVP);
    }

    public void Dp() {
        this.bcL = false;
        this.bTY.M(this.bVP);
        Et();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bcM.add(0, cVar);
            } else if (this.bcM.size() < com.baidu.live.af.a.OJ().bru.aKk) {
                this.bcM.add(cVar);
            }
            if (cVar.aZP) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            Et();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        if (!this.bcM.isEmpty() && !this.bcL && this.bVO.isReady()) {
            c remove = this.bcM.remove(0);
            if (remove != null) {
                remove.aP(System.currentTimeMillis());
                m(remove);
                Et();
                return;
            }
            Et();
        }
    }

    private void m(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aTV) && this.bVO.isReady()) {
            this.bVO.n(cVar);
        }
    }

    public void onDestroy() {
        if (this.bVO != null) {
            this.bVO.destory();
        }
        this.bcL = false;
    }

    public void Gh() {
        if (this.bVO != null) {
            this.bVO.Gh();
        }
    }

    public void bw(boolean z) {
        this.aTV = z;
    }

    public void Dv() {
        if (this.bVO != null) {
            this.bVO.Dv();
        }
    }
}
