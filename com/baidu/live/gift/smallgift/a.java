package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.k;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.gift.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean aSQ;
    private k aVJ;
    private int baS;
    private int baT;
    private int baU;
    private boolean bcl;
    private ArrayList<c> bcm;
    private b bdn;
    private b bdo;
    private AlaSmallGiftView bdp;
    private AlaSmallGiftView bdq;
    private b.a bdr;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.bcl = false;
        this.bdr = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Jv() {
                if (!a.this.Ju()) {
                    a.this.He();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aZQ < cVar.aZP) {
                    a.this.i(cVar);
                    cVar.aZY = true;
                    if (a.this.aVJ.a(cVar)) {
                        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            cVar.priority = 10;
                        } else {
                            cVar.priority = 8;
                        }
                    } else if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cVar.priority = 4;
                    } else {
                        cVar.priority = 2;
                    }
                    a.this.t(cVar);
                }
            }
        };
        this.mContext = context;
        this.aVJ = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aSQ = z;
        this.bdp.setMode(z);
        this.bdq.setMode(z);
    }

    private void initData() {
        this.bcm = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.baS = (int) resources.getDimension(a.e.sdk_ds650);
        this.baT = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.bdp = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.bdq = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.bdn = new b(this.bdp);
        this.bdn.a(this.bdr);
        this.bdo = new b(this.bdq);
        this.bdo.a(this.bdr);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.aVJ.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.baS, this.baT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.baT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.removeRule(10);
            } else {
                layoutParams2.addRule(10, 0);
            }
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.baU;
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void ew(int i) {
        this.baU = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.baU;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void Hi() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.bdn != null) {
            this.bdn.Hi();
        }
        if (this.bdo != null) {
            this.bdo.Hi();
        }
    }

    public void Gb() {
        this.bcl = true;
        if (this.bdn != null) {
            this.bdn.Gb();
        }
        if (this.bdo != null) {
            this.bdo.Gb();
        }
        this.aVJ.Gd();
    }

    public void Gc() {
        this.bcl = false;
        this.aVJ.M(this.mRootView);
        if (this.bdn != null) {
            this.bdn.Gc();
        }
        if (this.bdo != null) {
            this.bdo.Gc();
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

    public void d(c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z = false;
            if (this.bdn.z(cVar)) {
                z = true;
            } else if (this.bdo.z(cVar)) {
                z = true;
            }
            c(cVar, true);
            if (!z) {
                q(cVar);
            }
        }
    }

    private void q(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.bcm.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (c(next, cVar)) {
                z = true;
                d(next, cVar);
            }
            z2 = z;
        }
        if (!z) {
            r(cVar);
        }
    }

    public static boolean c(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.aZK) && cVar.aZK.equals(cVar2.aZK) && Math.abs(cVar2.HZ() - cVar.HZ()) <= IMConnection.RETRY_DELAY_TIMES && cVar2.aZP <= 99;
    }

    public static void d(c cVar, c cVar2) {
        w.a(cVar, cVar2);
        cVar.aZP += cVar2.aZP;
        cVar.ag(cVar2.HZ());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.bcm.add(cVar);
        if (cVar.aZR) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
        try {
            Hb();
        } catch (Exception e) {
            e.printStackTrace();
        }
        He();
    }

    public void s(c cVar) {
        if (this.bcl) {
            t(cVar);
        } else if (!this.bdn.JJ() && this.bdn.w(cVar)) {
            this.bdn.y(cVar);
        } else if (!this.bdo.JJ() && this.bdo.w(cVar)) {
            this.bdo.y(cVar);
        } else {
            t(cVar);
            He();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bcm.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.bcm.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.bcm.add(cVar);
        } else {
            this.bcm.add(i, cVar);
        }
        try {
            Hb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Hb() {
        if (this.bcm != null) {
            int i = com.baidu.live.z.a.Pq().bmJ != null ? com.baidu.live.z.a.Pq().bmJ.aMf : 0;
            if (i > 0 && this.bcm.size() >= i) {
                Collections.sort(this.bcm, new c.a());
                ArrayList arrayList = new ArrayList(this.bcm.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.bcm.clear();
                this.bcm.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (!this.bcm.isEmpty() && !this.bcl) {
            if (this.bdn.isReady() || this.bdo.isReady()) {
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
    }

    private void n(c cVar) {
        if (this.bdn.isReady()) {
            this.bdn.x(cVar);
        } else if (this.bdo.isReady()) {
            this.bdo.x(cVar);
        }
        if (cVar.aZR) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
        }
    }

    public boolean Ju() {
        return this.bcm.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aZR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZQ);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HZ());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZY) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View Gg() {
        return this.mRootView;
    }

    public void onDestroy() {
        this.bcl = false;
        if (this.bcm != null) {
            this.bcm.clear();
        }
        if (this.bdn != null) {
            this.bdn.onDestroy();
        }
        if (this.bdo != null) {
            this.bdo.onDestroy();
        }
        this.mContext = null;
    }
}
