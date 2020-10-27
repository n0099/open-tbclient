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
    private k aVJ;
    private b bcn;
    private AlaGiftGraffitiShowView bco;
    private Context mContext;
    private boolean bcl = false;
    private boolean aUr = false;
    private b.a bcp = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.He();
        }
    };
    private ArrayList<c> bcm = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aVJ = kVar;
        initView();
    }

    private void initView() {
        this.bco = new AlaGiftGraffitiShowView(this.mContext);
        this.bcn = new b(this.bco, this.mContext);
        this.bcn.a(this.bcp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aVJ.aSH && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.bco.setLayoutParams(layoutParams);
        this.aVJ.M(this.bco);
    }

    public void Gc() {
        this.bcl = false;
        this.aVJ.M(this.bco);
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
        if (!this.bcm.isEmpty() && !this.bcl && this.bcn.isReady()) {
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

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZJ;
            if (!cVar.aZU && !cVar.aZV) {
                if (cVar.aZR || cVar.aZI) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fs());
                        jSONObject.putOpt("gift_name", gVar.Ft());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZP));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZR ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aUr) && this.bcn.isReady()) {
            c(cVar, true);
            this.bcn.o(cVar);
        }
    }

    public void Gb() {
        this.bcl = true;
    }

    public void onDestroy() {
        if (this.bcn != null) {
            this.bcn.destory();
        }
        this.bcl = false;
    }

    public void IJ() {
        if (this.bcn != null) {
            this.bcn.IJ();
        }
    }

    public void bq(boolean z) {
        this.aUr = z;
    }

    public void Gi() {
        if (this.bcn != null) {
            this.bcn.Gi();
        }
    }
}
