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
    private k aUo;
    private b bba;
    private AlaGiftGraffitiShowView bbb;
    private Context mContext;
    private boolean baY = false;
    private boolean aTv = false;
    private b.a bbc = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.GI();
        }
    };
    private ArrayList<c> baZ = new ArrayList<>();

    public a(Context context, k kVar) {
        this.mContext = context;
        this.aUo = kVar;
        initView();
    }

    private void initView() {
        this.bbb = new AlaGiftGraffitiShowView(this.mContext);
        this.bba = new b(this.bbb, this.mContext);
        this.bba.a(this.bbc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aUo.aRM && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.e.sdk_ds112));
        layoutParams.addRule(10);
        this.bbb.setLayoutParams(layoutParams);
        this.aUo.M(this.bbb);
    }

    public void FN() {
        this.baY = false;
        this.aUo.M(this.bbb);
        GI();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.baZ.add(0, cVar);
            } else if (this.baZ.size() < com.baidu.live.x.a.OS().blo.aLC) {
                this.baZ.add(cVar);
            }
            if (cVar.aYv) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aHY, cVar.aHZ, cVar.giftId, "");
            }
            GI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (!this.baZ.isEmpty() && !this.baY && this.bba.isReady()) {
            c remove = this.baZ.remove(0);
            if (remove != null) {
                remove.af(System.currentTimeMillis());
                n(remove);
                GI();
                return;
            }
            GI();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aYo;
            if (!cVar.aYy && !cVar.aYz) {
                if (cVar.aYv || cVar.aYn) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fd());
                        jSONObject.putOpt("gift_name", gVar.Fe());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aYt));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aYv ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aTv) && this.bba.isReady()) {
            c(cVar, true);
            this.bba.o(cVar);
        }
    }

    public void FM() {
        this.baY = true;
    }

    public void onDestroy() {
        if (this.bba != null) {
            this.bba.destory();
        }
        this.baY = false;
    }

    public void Iq() {
        if (this.bba != null) {
            this.bba.Iq();
        }
    }

    public void bo(boolean z) {
        this.aTv = z;
    }

    public void FT() {
        if (this.bba != null) {
            this.bba.FT();
        }
    }
}
