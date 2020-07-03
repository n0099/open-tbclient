package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.k;
import com.baidu.live.gift.r;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean aGl;
    private k aIs;
    private int aNk;
    private int aNl;
    private boolean aOA;
    private ArrayList<c> aOB;
    private b aPC;
    private b aPD;
    private AlaSmallGiftView aPE;
    private AlaSmallGiftView aPF;
    private int aPG;
    private b.a aPH;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aOA = false;
        this.aPH = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void By() {
                if (!a.this.Bx()) {
                    a.this.zh();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aMn < cVar.aMm) {
                    a.this.i(cVar);
                    cVar.aMt = true;
                    if (a.this.aIs.a(cVar)) {
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
        this.aIs = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aGl = z;
        this.aPE.setMode(z);
        this.aPF.setMode(z);
    }

    private void initData() {
        this.aOB = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aNk = (int) resources.getDimension(a.e.sdk_ds650);
        this.aNl = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aPG = resources.getDimensionPixelOffset(a.e.sdk_ds6) + com.baidu.live.aa.a.h(false, false) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aPE = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aPF = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aPC = new b(this.aPE);
        this.aPC.a(this.aPH);
        this.aPD = new b(this.aPF);
        this.aPD.a(this.aPH);
        setRootViewParam(1);
        this.aIs.J(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aNk, this.aNl);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aNl);
            layoutParams2.bottomMargin = this.aPG;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void bb(boolean z) {
        if (this.mRootView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRootView.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin += this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds130);
            } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
                layoutParams.bottomMargin = 0;
                layoutParams.addRule(10);
                layoutParams.addRule(12, 0);
            } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
                layoutParams.bottomMargin = this.aPG;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void zl() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aPC != null) {
            this.aPC.zl();
        }
        if (this.aPD != null) {
            this.aPD.zl();
        }
    }

    public void yu() {
        this.aOA = true;
        if (this.aPC != null) {
            this.aPC.yu();
        }
        if (this.aPD != null) {
            this.aPD.yu();
        }
        this.aIs.yw();
    }

    public void yv() {
        this.aOA = false;
        this.aIs.J(this.mRootView);
        if (this.aPC != null) {
            this.aPC.yv();
        }
        if (this.aPD != null) {
            this.aPD.yv();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aPC.z(cVar) && !this.aPD.z(cVar)) {
                z = false;
            }
            if (!z) {
                q(cVar);
            }
        }
    }

    private void q(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.aOB.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aMj) && cVar.aMj.equals(cVar2.aMj) && Math.abs(cVar2.Ad() - cVar.Ad()) <= 3000 && cVar2.aMm <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aMm += cVar2.aMm;
        cVar.ad(cVar2.Ad());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aOB.add(cVar);
        if (cVar.aMo) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.axB, cVar.axC, cVar.giftId, "");
        }
        try {
            ze();
        } catch (Exception e) {
            e.printStackTrace();
        }
        zh();
    }

    public void s(c cVar) {
        if (this.aOA) {
            t(cVar);
        } else if (!this.aPC.BM() && this.aPC.w(cVar)) {
            this.aPC.y(cVar);
        } else if (!this.aPD.BM() && this.aPD.w(cVar)) {
            this.aPD.y(cVar);
        } else {
            t(cVar);
            zh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aOB.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aOB.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aOB.add(cVar);
        } else {
            this.aOB.add(i, cVar);
        }
        try {
            ze();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ze() {
        if (this.aOB != null) {
            int i = com.baidu.live.v.a.Hm().aZp != null ? com.baidu.live.v.a.Hm().aZp.aAH : 0;
            if (i > 0 && this.aOB.size() >= i) {
                Collections.sort(this.aOB, new c.a());
                ArrayList arrayList = new ArrayList(this.aOB.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aOB.clear();
                this.aOB.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (!this.aOB.isEmpty() && !this.aOA) {
            if (this.aPC.isReady() || this.aPD.isReady()) {
                c remove = this.aOB.remove(0);
                if (remove != null) {
                    remove.ad(System.currentTimeMillis());
                    n(remove);
                    zh();
                    return;
                }
                zh();
            }
        }
    }

    private void n(c cVar) {
        if (this.aPC.isReady()) {
            this.aPC.x(cVar);
        } else if (this.aPD.isReady()) {
            this.aPD.x(cVar);
        }
        if (cVar.aMo) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.axB, cVar.axC, cVar.giftId, "");
        }
    }

    public boolean Bx() {
        return this.aOB.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aMo) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aMn);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Ad());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aMt) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View yz() {
        return this.mRootView;
    }

    public void bT(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aPG = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.aOA = false;
        if (this.aOB != null) {
            this.aOB.clear();
        }
        if (this.aPC != null) {
            this.aPC.onDestroy();
        }
        if (this.aPD != null) {
            this.aPD.onDestroy();
        }
        this.mContext = null;
    }
}
