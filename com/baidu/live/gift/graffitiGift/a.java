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
    private j aVq;
    private b bbV;
    private AlaGiftGraffitiShowView bbW;
    private Context mContext;
    private boolean bbT = false;
    private boolean aTY = false;
    private b.a bbX = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.GW();
        }
    };
    private ArrayList<c> bbU = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.aVq = jVar;
        initView();
    }

    private void initView() {
        this.bbW = new AlaGiftGraffitiShowView(this.mContext);
        this.bbV = new b(this.bbW, this.mContext);
        this.bbV.a(this.bbX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aVq.aSp && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bbW.setLayoutParams(layoutParams);
        this.aVq.M(this.bbW);
    }

    public void FU() {
        this.bbT = false;
        this.aVq.M(this.bbW);
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
        if (!this.bbU.isEmpty() && !this.bbT && this.bbV.isReady()) {
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

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZq;
            if (!cVar.aZB && !cVar.aZC) {
                if (cVar.aZy || cVar.aZp) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fk());
                        jSONObject.putOpt("gift_name", gVar.Fl());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZw));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZy ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void n(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aTY) && this.bbV.isReady()) {
            c(cVar, true);
            this.bbV.o(cVar);
        }
    }

    public void FT() {
        this.bbT = true;
    }

    public void onDestroy() {
        if (this.bbV != null) {
            this.bbV.destory();
        }
        this.bbT = false;
    }

    public void IB() {
        if (this.bbV != null) {
            this.bbV.IB();
        }
    }

    public void bt(boolean z) {
        this.aTY = z;
    }

    public void Ga() {
        if (this.bbV != null) {
            this.bbV.Ga();
        }
    }
}
