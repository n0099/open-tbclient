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
    private j aVu;
    private b bcN;
    private AlaGiftGraffitiShowView bcO;
    private Context mContext;
    private boolean bcL = false;
    private boolean aTV = false;
    private b.a bcP = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.Et();
        }
    };
    private ArrayList<c> bcM = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.aVu = jVar;
        initView();
    }

    private void initView() {
        this.bcO = new AlaGiftGraffitiShowView(this.mContext);
        this.bcN = new b(this.bcO, this.mContext);
        this.bcN.a(this.bcP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.aVu.aSj && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bcO.setLayoutParams(layoutParams);
        this.aVu.M(this.bcO);
    }

    public void Dp() {
        this.bcL = false;
        this.aVu.M(this.bcO);
        Et();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bcM.add(0, cVar);
            } else if (this.bcM.size() < com.baidu.live.af.a.OJ().bru.aKk) {
                this.bcM.add(cVar);
            } else {
                l.a(cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
            }
            if (cVar.aZP) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            Et();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        if (!this.bcM.isEmpty() && !this.bcL && this.bcN.isReady()) {
            c remove = this.bcM.remove(0);
            if (remove != null) {
                remove.aP(System.currentTimeMillis());
                o(remove);
                Et();
                return;
            }
            Et();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZH;
            if (!cVar.aZS && !cVar.aZT) {
                if (cVar.aZP || cVar.aZG) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.CC());
                        jSONObject.putOpt("gift_name", gVar.CD());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZM));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZP ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void o(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aTV) && this.bcN.isReady()) {
            c(cVar, true);
            this.bcN.p(cVar);
        }
    }

    public void Do() {
        this.bcL = true;
    }

    public void onDestroy() {
        if (this.bcN != null) {
            this.bcN.destory();
        }
        this.bcL = false;
    }

    public void Gh() {
        if (this.bcN != null) {
            this.bcN.Gh();
        }
    }

    public void bw(boolean z) {
        this.aTV = z;
    }

    public void Dv() {
        if (this.bcN != null) {
            this.bcN.Dv();
        }
    }
}
