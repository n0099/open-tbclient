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
/* loaded from: classes4.dex */
public class a {
    private boolean aHG;
    private k aJO;
    private int aOF;
    private int aOG;
    private boolean aPV;
    private ArrayList<c> aPW;
    private b aQV;
    private b aQW;
    private AlaSmallGiftView aQX;
    private AlaSmallGiftView aQY;
    private int aQZ;
    private b.a aRa;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aPV = false;
        this.aRa = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void u(c cVar) {
                if (cVar != null) {
                    a.this.i(cVar);
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void Ca() {
                if (!a.this.BZ()) {
                    a.this.zJ();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void v(c cVar) {
                if (cVar != null && cVar.aNI < cVar.aNH) {
                    a.this.i(cVar);
                    cVar.aNO = true;
                    if (a.this.aJO.a(cVar)) {
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
        this.aJO = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.aHG = z;
        this.aQX.setMode(z);
        this.aQY.setMode(z);
    }

    private void initData() {
        this.aPW = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aOF = (int) resources.getDimension(a.e.sdk_ds650);
        this.aOG = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aQZ = resources.getDimensionPixelOffset(a.e.sdk_ds6) + com.baidu.live.aa.a.h(false, false) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aQX = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aQY = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aQV = new b(this.aQX);
        this.aQV.a(this.aRa);
        this.aQW = new b(this.aQY);
        this.aQW.a(this.aRa);
        setRootViewParam(1);
        this.aJO.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aOF, this.aOG);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aOG);
            layoutParams2.bottomMargin = this.aQZ;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void be(boolean z) {
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
                layoutParams.bottomMargin = this.aQZ;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void zN() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aQV != null) {
            this.aQV.zN();
        }
        if (this.aQW != null) {
            this.aQW.zN();
        }
    }

    public void yW() {
        this.aPV = true;
        if (this.aQV != null) {
            this.aQV.yW();
        }
        if (this.aQW != null) {
            this.aQW.yW();
        }
        this.aJO.yY();
    }

    public void yX() {
        this.aPV = false;
        this.aJO.M(this.mRootView);
        if (this.aQV != null) {
            this.aQV.yX();
        }
        if (this.aQW != null) {
            this.aQW.yX();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aQV.z(cVar) && !this.aQW.z(cVar)) {
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
        Iterator<c> it = this.aPW.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aNE) && cVar.aNE.equals(cVar2.aNE) && Math.abs(cVar2.AF() - cVar.AF()) <= 3000 && cVar2.aNH <= 99;
    }

    public static void d(c cVar, c cVar2) {
        r.a(cVar, cVar2);
        cVar.aNH += cVar2.aNH;
        cVar.ad(cVar2.AF());
    }

    private void r(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            s(cVar);
            return;
        }
        this.aPW.add(cVar);
        if (cVar.aNJ) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.ayO, cVar.ayP, cVar.giftId, "");
        }
        try {
            zG();
        } catch (Exception e) {
            e.printStackTrace();
        }
        zJ();
    }

    public void s(c cVar) {
        if (this.aPV) {
            t(cVar);
        } else if (!this.aQV.Co() && this.aQV.w(cVar)) {
            this.aQV.y(cVar);
        } else if (!this.aQW.Co() && this.aQW.w(cVar)) {
            this.aQW.y(cVar);
        } else {
            t(cVar);
            zJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aPW.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aPW.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aPW.add(cVar);
        } else {
            this.aPW.add(i, cVar);
        }
        try {
            zG();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void zG() {
        if (this.aPW != null) {
            int i = com.baidu.live.v.a.Hs().aZn != null ? com.baidu.live.v.a.Hs().aZn.aBU : 0;
            if (i > 0 && this.aPW.size() >= i) {
                Collections.sort(this.aPW, new c.a());
                ArrayList arrayList = new ArrayList(this.aPW.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aPW.clear();
                this.aPW.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zJ() {
        if (!this.aPW.isEmpty() && !this.aPV) {
            if (this.aQV.isReady() || this.aQW.isReady()) {
                c remove = this.aPW.remove(0);
                if (remove != null) {
                    remove.ad(System.currentTimeMillis());
                    n(remove);
                    zJ();
                    return;
                }
                zJ();
            }
        }
    }

    private void n(c cVar) {
        if (this.aQV.isReady()) {
            this.aQV.x(cVar);
        } else if (this.aQW.isReady()) {
            this.aQW.x(cVar);
        }
        if (cVar.aNJ) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.ayO, cVar.ayP, cVar.giftId, "");
        }
    }

    public boolean BZ() {
        return this.aPW.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar) {
        if (cVar != null && cVar.aNJ) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aNI);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.AF());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aNO) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    public View zb() {
        return this.mRootView;
    }

    public void bZ(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aQZ = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.aPV = false;
        if (this.aPW != null) {
            this.aPW.clear();
        }
        if (this.aQV != null) {
            this.aQV.onDestroy();
        }
        if (this.aQW != null) {
            this.aQW.onDestroy();
        }
        this.mContext = null;
    }
}
