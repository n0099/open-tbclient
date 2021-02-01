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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.l;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private j aYC;
    private b bfW;
    private AlaGiftGraffitiShowView bfX;
    private Context mContext;
    private boolean bfU = false;
    private boolean aXa = false;
    private b.a bfY = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.FJ();
        }
    };
    private ArrayList<c> bfV = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.aYC = jVar;
        initView();
    }

    private void initView() {
        this.bfX = new AlaGiftGraffitiShowView(this.mContext);
        this.bfW = new b(this.bfX, this.mContext);
        this.bfW.a(this.bfY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aYC.aVn && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bfX.setLayoutParams(layoutParams);
        this.aYC.M(this.bfX);
    }

    public void EF() {
        this.bfU = false;
        this.aYC.M(this.bfX);
        FJ();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bfV.add(0, cVar);
            } else if (this.bfV.size() < com.baidu.live.ae.a.Qj().buX.aMX) {
                this.bfV.add(cVar);
            } else {
                l.a(cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
            }
            if (cVar.bcW) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            FJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (!this.bfV.isEmpty() && !this.bfU && this.bfW.isReady()) {
            c remove = this.bfV.remove(0);
            if (remove != null) {
                remove.aS(System.currentTimeMillis());
                o(remove);
                FJ();
                return;
            }
            FJ();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcO;
            if (!cVar.bcZ && !cVar.bda) {
                if (cVar.bcW || cVar.bcN) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DR());
                        jSONObject.putOpt("gift_name", gVar.DS());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcT));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcW ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void o(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aXa) && this.bfW.isReady()) {
            c(cVar, true);
            this.bfW.p(cVar);
        }
    }

    public void EE() {
        this.bfU = true;
    }

    public void onDestroy() {
        if (this.bfW != null) {
            this.bfW.destory();
        }
        this.bfU = false;
    }

    public void Hx() {
        if (this.bfW != null) {
            this.bfW.Hx();
        }
    }

    public void bB(boolean z) {
        this.aXa = z;
    }

    public void EL() {
        if (this.bfW != null) {
            this.bfW.EL();
        }
    }

    public int getCacheSize() {
        if (this.bfV != null) {
            return this.bfV.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.bfV != null) {
            this.bfV.clear();
        }
    }
}
