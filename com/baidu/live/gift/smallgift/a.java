package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.k;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private boolean afP;
    private k ahT;
    private int amt;
    private int amu;
    private boolean anD;
    private ArrayList<c> anE;
    private b aoC;
    private b aoD;
    private AlaSmallGiftView aoE;
    private AlaSmallGiftView aoF;
    private int aoG;
    private b.a aoH;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.anD = false;
        this.aoH = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void vg() {
                if (!a.this.vf()) {
                    a.this.sW();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(c cVar) {
                if (cVar != null && cVar.alB < cVar.alA) {
                    if (a.this.ahT.a(cVar)) {
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
                    a.this.o(cVar);
                }
            }
        };
        this.mContext = context;
        this.ahT = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.afP = z;
        this.aoE.setMode(z);
        this.aoF.setMode(z);
    }

    private void initData() {
        this.anE = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.amt = (int) resources.getDimension(a.e.sdk_ds650);
        this.amu = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aoG = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aoE = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aoF = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aoC = new b(this.aoE);
        this.aoC.a(this.aoH);
        this.aoD = new b(this.aoF);
        this.aoD.a(this.aoH);
        setRootViewParam(1);
        this.ahT.K(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.amt, this.amu);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.amu);
            layoutParams2.bottomMargin = this.aoG;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void ay(boolean z) {
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
                layoutParams.bottomMargin = this.aoG;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void ta() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aoC != null) {
            this.aoC.ta();
        }
        if (this.aoD != null) {
            this.aoD.ta();
        }
    }

    public void sg() {
        this.anD = true;
        if (this.aoC != null) {
            this.aoC.sg();
        }
        if (this.aoD != null) {
            this.aoD.sg();
        }
        this.ahT.si();
    }

    public void sh() {
        this.anD = false;
        this.ahT.K(this.mRootView);
        if (this.aoC != null) {
            this.aoC.sh();
        }
        if (this.aoD != null) {
            this.aoD.sh();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aoC.t(cVar) && !this.aoD.t(cVar)) {
                z = false;
            }
            if (!z) {
                l(cVar);
            }
        }
    }

    private void l(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.anE.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (b(next, cVar)) {
                z = true;
                c(next, cVar);
            }
            z2 = z;
        }
        if (!z) {
            m(cVar);
        }
    }

    private boolean b(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.alx) && cVar.alx.equals(cVar2.alx) && Math.abs(cVar2.tP() - cVar.tP()) <= 3000 && cVar2.alA <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.alA += cVar2.alA;
        cVar.B(cVar2.tP());
    }

    private void m(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(cVar);
            return;
        }
        this.anE.add(cVar);
        if (cVar.alC) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.XX, cVar.XY, cVar.giftId, "");
        }
        try {
            sT();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sW();
    }

    public void n(c cVar) {
        if (this.anD) {
            o(cVar);
        } else if (!this.aoC.vu() && this.aoC.q(cVar)) {
            this.aoC.s(cVar);
        } else if (!this.aoD.vu() && this.aoD.q(cVar)) {
            this.aoD.s(cVar);
        } else {
            o(cVar);
            sW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.anE.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.anE.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.anE.add(cVar);
        } else {
            this.anE.add(i, cVar);
        }
        try {
            sT();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sT() {
        if (this.anE != null) {
            int i = com.baidu.live.v.a.zj().awA != null ? com.baidu.live.v.a.zj().awA.aaP : 0;
            if (i > 0 && this.anE.size() >= i) {
                Collections.sort(this.anE, new c.a());
                ArrayList arrayList = new ArrayList(this.anE.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.anE.clear();
                this.anE.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW() {
        if (!this.anE.isEmpty() && !this.anD) {
            if (this.aoC.isReady() || this.aoD.isReady()) {
                c remove = this.anE.remove(0);
                if (remove != null) {
                    remove.B(System.currentTimeMillis());
                    i(remove);
                    sW();
                    return;
                }
                sW();
            }
        }
    }

    private void i(c cVar) {
        if (this.aoC.isReady()) {
            this.aoC.r(cVar);
        } else if (this.aoD.isReady()) {
            this.aoD.r(cVar);
        }
        if (cVar.alC) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.XX, cVar.XY, cVar.giftId, "");
        }
    }

    public boolean vf() {
        return this.anE.isEmpty();
    }

    public View sl() {
        return this.mRootView;
    }

    public void br(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aoG = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.anD = false;
        if (this.anE != null) {
            this.anE.clear();
        }
        if (this.aoC != null) {
            this.aoC.onDestroy();
        }
        if (this.aoD != null) {
            this.aoD.onDestroy();
        }
        this.mContext = null;
    }
}
