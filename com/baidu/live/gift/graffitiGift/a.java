package com.baidu.live.gift.graffitiGift;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j aYB;
    private b bfV;
    private AlaGiftGraffitiShowView bfW;
    private Context mContext;
    private boolean bfT = false;
    private boolean aXd = false;
    private b.a bfX = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.IN();
        }
    };
    private ArrayList<c> bfU = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.aYB = jVar;
        initView();
    }

    private void initView() {
        this.bfW = new AlaGiftGraffitiShowView(this.mContext);
        this.bfV = new b(this.bfW, this.mContext);
        this.bfV.a(this.bfX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aYB.aVr && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bfW.setLayoutParams(layoutParams);
        this.aYB.M(this.bfW);
    }

    public void HJ() {
        this.bfT = false;
        this.aYB.M(this.bfW);
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
        if (!this.bfU.isEmpty() && !this.bfT && this.bfV.isReady()) {
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

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcN;
            if (!cVar.bda && !cVar.bdb) {
                if (cVar.bcX || cVar.bcM) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.GX());
                        jSONObject.putOpt("gift_name", gVar.GY());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcU));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcX ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aXd) && this.bfV.isReady()) {
            c(cVar, true);
            this.bfV.o(cVar);
        }
    }

    public void HI() {
        this.bfT = true;
    }

    public void onDestroy() {
        if (this.bfV != null) {
            this.bfV.destory();
        }
        this.bfT = false;
    }

    public void KB() {
        if (this.bfV != null) {
            this.bfV.KB();
        }
    }

    public void bC(boolean z) {
        this.aXd = z;
    }

    public void HP() {
        if (this.bfV != null) {
            this.bfV.HP();
        }
    }
}
