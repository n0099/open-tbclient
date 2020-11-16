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
    private com.baidu.live.yuyingift.a bNU;
    private b bPy;
    private AlaGiftGraffitiShowView bPz;
    private Context mContext;
    private boolean bbT = false;
    private boolean aTY = false;
    private b.a bPA = new b.a() { // from class: com.baidu.live.yuyingift.graffitigift.a.1
        @Override // com.baidu.live.yuyingift.graffitigift.b.a
        public void onEnd() {
            a.this.GW();
        }
    };
    private ArrayList<c> bbU = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bNU = aVar;
        initView();
    }

    private void initView() {
        this.bPz = new AlaGiftGraffitiShowView(this.mContext);
        this.bPy = new b(this.bPz, this.mContext);
        this.bPy.a(this.bPA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bNU.aSp && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bPz.setLayoutParams(layoutParams);
        this.bNU.M(this.bPz);
    }

    public void FU() {
        this.bbT = false;
        this.bNU.M(this.bPz);
        GW();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bbU.add(0, cVar);
            } else if (this.bbU.size() < com.baidu.live.aa.a.Ph().bms.aLv) {
                this.bbU.add(cVar);
            }
            if (cVar.aZy) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            GW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
        if (!this.bbU.isEmpty() && !this.bbT && this.bPy.isReady()) {
            c remove = this.bbU.remove(0);
            if (remove != null) {
                remove.as(System.currentTimeMillis());
                n(remove);
                GW();
                return;
            }
            GW();
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aTY) && this.bPy.isReady()) {
            this.bPy.o(cVar);
        }
    }

    public void onDestroy() {
        if (this.bPy != null) {
            this.bPy.destory();
        }
        this.bbT = false;
    }

    public void IB() {
        if (this.bPy != null) {
            this.bPy.IB();
        }
    }

    public void bt(boolean z) {
        this.aTY = z;
    }

    public void Ga() {
        if (this.bPy != null) {
            this.bPy.Ga();
        }
    }
}
