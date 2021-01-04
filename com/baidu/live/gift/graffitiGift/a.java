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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private j bah;
    private b bhE;
    private AlaGiftGraffitiShowView bhF;
    private Context mContext;
    private boolean bhC = false;
    private boolean aYI = false;
    private b.a bhG = new b.a() { // from class: com.baidu.live.gift.graffitiGift.a.1
        @Override // com.baidu.live.gift.graffitiGift.b.a
        public void onEnd() {
            a.this.Io();
        }
    };
    private ArrayList<c> bhD = new ArrayList<>();

    public a(Context context, j jVar) {
        this.mContext = context;
        this.bah = jVar;
        initView();
    }

    private void initView() {
        this.bhF = new AlaGiftGraffitiShowView(this.mContext);
        this.bhE = new b(this.bhF, this.mContext);
        this.bhE.a(this.bhG);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int i = 0;
        if (this.bah.aWW && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            i = BdUtilHelper.getStatusBarHeight((Activity) this.mContext) + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds4));
        }
        layoutParams.topMargin = i + ((int) this.mContext.getResources().getDimension(a.d.sdk_ds112));
        layoutParams.addRule(10);
        this.bhF.setLayoutParams(layoutParams);
        this.bah.M(this.bhF);
    }

    public void Hk() {
        this.bhC = false;
        this.bah.M(this.bhF);
        Io();
    }

    public void e(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bhD.add(0, cVar);
            } else if (this.bhD.size() < com.baidu.live.af.a.SE().bwi.aOX) {
                this.bhD.add(cVar);
            } else {
                l.a(cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
            }
            if (cVar.beF) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
            }
            Io();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (!this.bhD.isEmpty() && !this.bhC && this.bhE.isReady()) {
            c remove = this.bhD.remove(0);
            if (remove != null) {
                remove.aP(System.currentTimeMillis());
                o(remove);
                Io();
                return;
            }
            Io();
        }
    }

    private void c(c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bex;
            if (!cVar.beI && !cVar.beJ) {
                if (cVar.beF || cVar.bew) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Gx());
                        jSONObject.putOpt("gift_name", gVar.Gy());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.beC));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.beF ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void o(c cVar) {
        if ((UtilHelper.getRealScreenOrientation(this.mContext) != 2 || !this.aYI) && this.bhE.isReady()) {
            c(cVar, true);
            this.bhE.p(cVar);
        }
    }

    public void Hj() {
        this.bhC = true;
    }

    public void onDestroy() {
        if (this.bhE != null) {
            this.bhE.destory();
        }
        this.bhC = false;
    }

    public void Kc() {
        if (this.bhE != null) {
            this.bhE.Kc();
        }
    }

    public void bA(boolean z) {
        this.aYI = z;
    }

    public void Hq() {
        if (this.bhE != null) {
            this.bhE.Hq();
        }
    }
}
