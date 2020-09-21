package com.baidu.live.gift.graffitiGift;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.b;
import com.baidu.live.gift.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private k aRd;
    private b aXG;
    private AlaGiftGraffitiShowView aXH;
    private Context mContext;
    private boolean aXE = false;
    private boolean aQk = false;
    private b.a aXI = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.FM();
        }
    };
    private ArrayList<c> aXF = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aRd = kVar;
        initView();
    }

    private void initView() {
        this.aXH = new AlaGiftGraffitiShowView(this.mContext);
        this.aXG = new b(this.aXH, this.mContext);
        this.aXG.a(this.aXI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aRd.aOB && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.aXH.setLayoutParams(layoutParams);
        this.aRd.M(this.aXH);
    }

    public void ER() {
        this.aXE = false;
        this.aRd.M(this.aXH);
        FM();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aXF.add(0, cVar);
            } else if (this.aXF.size() < com.baidu.live.x.a.NN().bhy.aIy) {
                this.aXF.add(cVar);
            }
            if (cVar.aVk) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aEU, cVar.aEV, cVar.giftId, "");
            }
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (!this.aXF.isEmpty() && !this.aXE && this.aXG.isReady()) {
            c remove = this.aXF.remove(0);
            if (remove != null) {
                remove.ad(System.currentTimeMillis());
                n(remove);
                FM();
                return;
            }
            FM();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aVd;
            if (!cVar.aVn && !cVar.aVo) {
                if (cVar.aVk || cVar.aVc) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Eh());
                        jSONObject.putOpt("gift_name", gVar.Ei());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aVi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aVk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aQk) && this.aXG.isReady()) {
            c(cVar, true);
            this.aXG.o(cVar);
        }
    }

    public void EQ() {
        this.aXE = true;
    }

    public void onDestroy() {
        if (this.aXG != null) {
            this.aXG.destory();
        }
        this.aXE = false;
    }

    public void Ht() {
        if (this.aXG != null) {
            this.aXG.Ht();
        }
    }

    public void bk(boolean z) {
        this.aQk = z;
    }

    public void EX() {
        if (this.aXG != null) {
            this.aXG.EX();
        }
    }
}
