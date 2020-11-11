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
    private com.baidu.live.yuyingift.a bPE;
    private b bRi;
    private AlaGiftGraffitiShowView bRj;
    private Context mContext;
    private boolean bdE = false;
    private boolean aVJ = false;
    private b.a bRk = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.HF();
        }
    };
    private ArrayList<c> bdF = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bPE = aVar;
        initView();
    }

    private void initView() {
        this.bRj = new AlaGiftGraffitiShowView(this.mContext);
        this.bRi = new b(this.bRj, this.mContext);
        this.bRi.a(this.bRk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bPE.aUa && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bRj.setLayoutParams(layoutParams);
        this.bPE.M(this.bRj);
    }

    public void GD() {
        this.bdE = false;
        this.bPE.M(this.bRj);
        HF();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bdF.add(0, cVar);
            } else if (this.bdF.size() < com.baidu.live.aa.a.PQ().bod.aNg) {
                this.bdF.add(cVar);
            }
            if (cVar.bbk) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            HF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HF() {
        if (!this.bdF.isEmpty() && !this.bdE && this.bRi.isReady()) {
            c remove = this.bdF.remove(0);
            if (remove != null) {
                remove.as(System.currentTimeMillis());
                n(remove);
                HF();
                return;
            }
            HF();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aVJ) && this.bRi.isReady()) {
            this.bRi.o(cVar);
        }
    }

    public void onDestroy() {
        if (this.bRi != null) {
            this.bRi.destory();
        }
        this.bdE = false;
    }

    public void Jk() {
        if (this.bRi != null) {
            this.bRi.Jk();
        }
    }

    public void br(boolean z) {
        this.aVJ = z;
    }

    public void GJ() {
        if (this.bRi != null) {
            this.bRi.GJ();
        }
    }
}
