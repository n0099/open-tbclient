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
/* loaded from: classes10.dex */
public class a {
    private j bac;
    private b bhx;
    private AlaGiftGraffitiShowView bhy;
    private Context mContext;
    private boolean bhv = false;
    private boolean aYA = false;
    private b.a bhz = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.FM();
        }
    };
    private ArrayList<c> bhw = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.bac = jVar;
        initView();
    }

    private void initView() {
        this.bhy = new AlaGiftGraffitiShowView(this.mContext);
        this.bhx = new b(this.bhy, this.mContext);
        this.bhx.a(this.bhz);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bac.aWN && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bhy.setLayoutParams(layoutParams);
        this.bac.M(this.bhy);
    }

    public void EI() {
        this.bhv = false;
        this.bac.M(this.bhy);
        FM();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bhw.add(0, cVar);
            } else if (this.bhw.size() < com.baidu.live.ae.a.Qm().bwx.aOx) {
                this.bhw.add(cVar);
            } else {
                l.a(cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
            }
            if (cVar.bey) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (!this.bhw.isEmpty() && !this.bhv && this.bhx.isReady()) {
            c remove = this.bhw.remove(0);
            if (remove != null) {
                remove.aS(System.currentTimeMillis());
                o(remove);
                FM();
                return;
            }
            FM();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bep;
            if (!cVar.beB && !cVar.beC) {
                if (cVar.bey || cVar.beo) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DU());
                        jSONObject.putOpt("gift_name", gVar.DV());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bev));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bey ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void o(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aYA) && this.bhx.isReady()) {
            c(cVar, true);
            this.bhx.p(cVar);
        }
    }

    public void EH() {
        this.bhv = true;
    }

    public void onDestroy() {
        if (this.bhx != null) {
            this.bhx.destory();
        }
        this.bhv = false;
    }

    public void HA() {
        if (this.bhx != null) {
            this.bhx.HA();
        }
    }

    public void bB(boolean z) {
        this.aYA = z;
    }

    public void EO() {
        if (this.bhx != null) {
            this.bhx.EO();
        }
    }

    public int getCacheSize() {
        if (this.bhw != null) {
            return this.bhw.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.bhw != null) {
            this.bhw.clear();
        }
    }
}
