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
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j aXb;
    private b bdG;
    private AlaGiftGraffitiShowView bdH;
    private Context mContext;
    private boolean bdE = false;
    private boolean aVJ = false;
    private b.a bdI = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.HF();
        }
    };
    private ArrayList<c> bdF = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.aXb = jVar;
        initView();
    }

    private void initView() {
        this.bdH = new AlaGiftGraffitiShowView(this.mContext);
        this.bdG = new b(this.bdH, this.mContext);
        this.bdG.a(this.bdI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aXb.aUa && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bdH.setLayoutParams(layoutParams);
        this.aXb.M(this.bdH);
    }

    public void GD() {
        this.bdE = false;
        this.aXb.M(this.bdH);
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
        if (!this.bdF.isEmpty() && !this.bdE && this.bdG.isReady()) {
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

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bbc;
            if (!cVar.bbn && !cVar.bbo) {
                if (cVar.bbk || cVar.bbb) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.FT());
                        jSONObject.putOpt("gift_name", gVar.FU());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bbi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bbk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aVJ) && this.bdG.isReady()) {
            c(cVar, true);
            this.bdG.o(cVar);
        }
    }

    public void GC() {
        this.bdE = true;
    }

    public void onDestroy() {
        if (this.bdG != null) {
            this.bdG.destory();
        }
        this.bdE = false;
    }

    public void Jk() {
        if (this.bdG != null) {
            this.bdG.Jk();
        }
    }

    public void br(boolean z) {
        this.aVJ = z;
    }

    public void GJ() {
        if (this.bdG != null) {
            this.bdG.GJ();
        }
    }
}
