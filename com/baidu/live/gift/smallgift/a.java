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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean aDP;
    private k aFW;
    private int aKE;
    private int aKF;
    private boolean aLU;
    private ArrayList<c> aLV;
    private b aMW;
    private b aMX;
    private AlaSmallGiftView aMY;
    private AlaSmallGiftView aMZ;
    private int aNa;
    private b.a aNb;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aLU = false;
        this.aNb = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void AY() {
                if (!a.this.AX()) {
                    a.this.yH();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aJH < cVar.aJG) {
                    a.this.i(cVar);
                    cVar.aJN = true;
                    if (a.this.aFW.a(cVar)) {
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
        this.aFW = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aDP = z;
        this.aMY.setMode(z);
        this.aMZ.setMode(z);
    }

    private void initData() {
        this.aLV = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aKE = (int) resources.getDimension(a.e.sdk_ds650);
        this.aKF = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aNa = resources.getDimensionPixelOffset(a.e.sdk_ds6) + com.baidu.live.aa.a.h(false, false) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aMY = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aMZ = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aMW = new b(this.aMY);
        this.aMW.a(this.aNb);
        this.aMX = new b(this.aMZ);
        this.aMX.a(this.aNb);
        setRootViewParam(1);
        this.aFW.L(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aKE, this.aKF);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aKF);
            layoutParams2.bottomMargin = this.aNa;
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
                layoutParams.bottomMargin = this.aNa;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void yL() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aMW != null) {
            this.aMW.yL();
        }
        if (this.aMX != null) {
            this.aMX.yL();
        }
    }

    public void xU() {
        this.aLU = true;
        if (this.aMW != null) {
            this.aMW.xU();
        }
        if (this.aMX != null) {
            this.aMX.xU();
        }
        this.aFW.xW();
    }

    public void xV() {
        this.aLU = false;
        this.aFW.L(this.mRootView);
        if (this.aMW != null) {
            this.aMW.xV();
        }
        if (this.aMX != null) {
            this.aMX.xV();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aMW.z(cVar) && !this.aMX.z(cVar)) {
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
        Iterator<c> it = this.aLV.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aJD) && cVar.aJD.equals(cVar2.aJD) && Math.abs(cVar2.zD() - cVar.zD()) <= 3000 && cVar2.aJG <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aJG += cVar2.aJG;
        cVar.ad(cVar2.zD());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aLV.add(cVar);
        if (cVar.aJI) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.avv, cVar.avw, cVar.giftId, "");
        }
        try {
            yE();
        } catch (Exception e) {
            e.printStackTrace();
        }
        yH();
    }

    public void s(c cVar) {
        if (this.aLU) {
            t(cVar);
        } else if (!this.aMW.Bm() && this.aMW.w(cVar)) {
            this.aMW.y(cVar);
        } else if (!this.aMX.Bm() && this.aMX.w(cVar)) {
            this.aMX.y(cVar);
        } else {
            t(cVar);
            yH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aLV.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aLV.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aLV.add(cVar);
        } else {
            this.aLV.add(i, cVar);
        }
        try {
            yE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void yE() {
        if (this.aLV != null) {
            int i = com.baidu.live.v.a.Ge().aWF != null ? com.baidu.live.v.a.Ge().aWF.ays : 0;
            if (i > 0 && this.aLV.size() >= i) {
                Collections.sort(this.aLV, new c.a());
                ArrayList arrayList = new ArrayList(this.aLV.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aLV.clear();
                this.aLV.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH() {
        if (!this.aLV.isEmpty() && !this.aLU) {
            if (this.aMW.isReady() || this.aMX.isReady()) {
                c remove = this.aLV.remove(0);
                if (remove != null) {
                    remove.ad(System.currentTimeMillis());
                    n(remove);
                    yH();
                    return;
                }
                yH();
            }
        }
    }

    private void n(c cVar) {
        if (this.aMW.isReady()) {
            this.aMW.x(cVar);
        } else if (this.aMX.isReady()) {
            this.aMX.x(cVar);
        }
        if (cVar.aJI) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.avv, cVar.avw, cVar.giftId, "");
        }
    }

    public boolean AX() {
        return this.aLV.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aJI) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aJH);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.zD());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aJN) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View xZ() {
        return this.mRootView;
    }

    public void bL(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aNa = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.aLU = false;
        if (this.aLV != null) {
            this.aLV.clear();
        }
        if (this.aMW != null) {
            this.aMW.onDestroy();
        }
        if (this.aMX != null) {
            this.aMX.onDestroy();
        }
        this.mContext = null;
    }
}
