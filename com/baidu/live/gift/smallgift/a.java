package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.j;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private boolean VV;
    private j Xr;
    private int abE;
    private int abF;
    private boolean acH;
    private ArrayList<d> acI;
    private b adE;
    private b adF;
    private AlaSmallGiftView adG;
    private AlaSmallGiftView adH;
    private int adI;
    private b.a adJ;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.acH = false;
        this.adJ = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void rJ() {
                if (!a.this.rI()) {
                    a.this.pW();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(d dVar) {
                if (dVar != null && dVar.aaF < dVar.aaE) {
                    if (a.this.Xr.a(dVar)) {
                        if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            dVar.priority = 10;
                        } else {
                            dVar.priority = 8;
                        }
                    } else if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        dVar.priority = 4;
                    } else {
                        dVar.priority = 2;
                    }
                    a.this.o(dVar);
                }
            }
        };
        this.mContext = context;
        this.Xr = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.VV = z;
        this.adG.setMode(z);
        this.adH.setMode(z);
    }

    private void initData() {
        this.acI = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.abE = (int) resources.getDimension(a.e.sdk_ds650);
        this.abF = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
        this.adI = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.adG = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.adH = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.adE = new b(this.adG);
        this.adE.a(this.adJ);
        this.adF = new b(this.adH);
        this.adF.a(this.adJ);
        setRootViewParam(1);
        this.Xr.J(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.abE, this.abF);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.abF);
            layoutParams2.bottomMargin = this.adI;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void ai(boolean z) {
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
                layoutParams.bottomMargin = this.adI;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void qa() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.adE != null) {
            this.adE.qa();
        }
        if (this.adF != null) {
            this.adF.qa();
        }
    }

    public void pw() {
        this.acH = true;
        if (this.adE != null) {
            this.adE.pw();
        }
        if (this.adF != null) {
            this.adF.pw();
        }
        this.Xr.py();
    }

    public void px() {
        this.acH = false;
        this.Xr.J(this.mRootView);
        if (this.adE != null) {
            this.adE.px();
        }
        if (this.adF != null) {
            this.adF.px();
        }
    }

    public void d(d dVar) {
        boolean z = true;
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            if (!this.adE.t(dVar) && !this.adF.t(dVar)) {
                z = false;
            }
            if (!z) {
                l(dVar);
            }
        }
    }

    private void l(d dVar) {
        boolean z;
        boolean z2 = false;
        Iterator<d> it = this.acI.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (b(next, dVar)) {
                z = true;
                c(next, dVar);
            }
            z2 = z;
        }
        if (!z) {
            m(dVar);
        }
    }

    private boolean b(d dVar, d dVar2) {
        return dVar != null && !StringUtils.isNull(dVar.aaA) && dVar.aaA.equals(dVar2.aaA) && Math.abs(dVar2.qE() - dVar.qE()) <= 3000 && dVar2.aaE <= 10;
    }

    private void c(d dVar, d dVar2) {
        dVar.aaE += dVar2.aaE;
        dVar.y(dVar2.qE());
    }

    private void m(d dVar) {
        if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(dVar);
            return;
        }
        this.acI.add(dVar);
        try {
            pT();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pW();
    }

    public void n(d dVar) {
        if (this.acH) {
            o(dVar);
        } else if (!this.adE.rX() && this.adE.q(dVar)) {
            this.adE.s(dVar);
        } else if (!this.adF.rX() && this.adF.q(dVar)) {
            this.adF.s(dVar);
        } else {
            o(dVar);
            pW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(d dVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.acI.size()) {
                i = -1;
                break;
            } else if (dVar.priority > this.acI.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.acI.add(dVar);
        } else {
            this.acI.add(i, dVar);
        }
        try {
            pT();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pT() {
        if (this.acI != null) {
            int i = com.baidu.live.l.a.uB().ajF != null ? com.baidu.live.l.a.uB().ajF.RZ : 0;
            if (i > 0 && this.acI.size() >= i) {
                Collections.sort(this.acI, new d.a());
                ArrayList arrayList = new ArrayList(this.acI.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.acI.clear();
                this.acI.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW() {
        if (!this.acI.isEmpty() && !this.acH) {
            if (this.adE.isReady() || this.adF.isReady()) {
                d remove = this.acI.remove(0);
                if (remove != null) {
                    remove.y(System.currentTimeMillis());
                    i(remove);
                    pW();
                    return;
                }
                pW();
            }
        }
    }

    private void i(d dVar) {
        if (this.adE.isReady()) {
            this.adE.r(dVar);
        } else if (this.adF.isReady()) {
            this.adF.r(dVar);
        }
    }

    public boolean rI() {
        return this.acI.isEmpty();
    }

    public View pB() {
        return this.mRootView;
    }

    public void aZ(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.adI = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.acH = false;
        if (this.acI != null) {
            this.acI.clear();
        }
        if (this.adE != null) {
            this.adE.onDestroy();
        }
        if (this.adF != null) {
            this.adF.onDestroy();
        }
        this.mContext = null;
    }
}
