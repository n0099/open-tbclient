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
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private boolean Wo;
    private j XJ;
    private int abW;
    private int abX;
    private boolean acZ;
    private b adW;
    private b adX;
    private AlaSmallGiftView adY;
    private AlaSmallGiftView adZ;
    private ArrayList<d> ada;
    private int aea;
    private b.a aeb;
    private Context mContext;
    private View mRootView;

    public a(Context context, j jVar) {
        this.acZ = false;
        this.aeb = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void rI() {
                if (!a.this.rH()) {
                    a.this.pV();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(d dVar) {
                if (dVar != null && dVar.aaX < dVar.aaW) {
                    if (a.this.XJ.a(dVar)) {
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
        this.XJ = jVar;
        initData();
        initView();
    }

    public a(Context context, j jVar, boolean z) {
        this(context, jVar);
        this.Wo = z;
        this.adY.setMode(z);
        this.adZ.setMode(z);
    }

    private void initData() {
        this.ada = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.abW = (int) resources.getDimension(a.e.sdk_ds650);
        this.abX = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
        this.aea = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.adY = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.adZ = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.adW = new b(this.adY);
        this.adW.a(this.aeb);
        this.adX = new b(this.adZ);
        this.adX.a(this.aeb);
        setRootViewParam(1);
        this.XJ.J(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.abW, this.abX);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.abX);
            layoutParams2.bottomMargin = this.aea;
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
                layoutParams.bottomMargin = this.aea;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void pZ() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.adW != null) {
            this.adW.pZ();
        }
        if (this.adX != null) {
            this.adX.pZ();
        }
    }

    public void pw() {
        this.acZ = true;
        if (this.adW != null) {
            this.adW.pw();
        }
        if (this.adX != null) {
            this.adX.pw();
        }
        this.XJ.py();
    }

    public void px() {
        this.acZ = false;
        this.XJ.J(this.mRootView);
        if (this.adW != null) {
            this.adW.px();
        }
        if (this.adX != null) {
            this.adX.px();
        }
    }

    public void d(d dVar) {
        boolean z = true;
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            if (!this.adW.t(dVar) && !this.adX.t(dVar)) {
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
        Iterator<d> it = this.ada.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (a(next, dVar)) {
                z = true;
                b(next, dVar);
            }
            z2 = z;
        }
        if (!z) {
            m(dVar);
        }
    }

    private boolean a(d dVar, d dVar2) {
        return dVar != null && !StringUtils.isNull(dVar.aaS) && dVar.aaS.equals(dVar2.aaS) && Math.abs(dVar2.qD() - dVar.qD()) <= 3000 && dVar2.aaW <= 10;
    }

    private void b(d dVar, d dVar2) {
        dVar.aaW += dVar2.aaW;
        dVar.z(dVar2.qD());
    }

    private void m(d dVar) {
        if (dVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(dVar);
            return;
        }
        this.ada.add(dVar);
        pV();
    }

    public void n(d dVar) {
        if (this.acZ) {
            o(dVar);
        } else if (!this.adW.rW() && this.adW.q(dVar)) {
            this.adW.s(dVar);
        } else if (!this.adX.rW() && this.adX.q(dVar)) {
            this.adX.s(dVar);
        } else {
            o(dVar);
            pV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(d dVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.ada.size()) {
                i = -1;
                break;
            } else if (dVar.priority > this.ada.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.ada.add(dVar);
        } else {
            this.ada.add(i, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        if (!this.ada.isEmpty() && !this.acZ) {
            if (this.adW.isReady() || this.adX.isReady()) {
                d remove = this.ada.remove(0);
                if (remove != null) {
                    remove.z(System.currentTimeMillis());
                    i(remove);
                    pV();
                    return;
                }
                pV();
            }
        }
    }

    private void i(d dVar) {
        if (this.adW.isReady()) {
            this.adW.r(dVar);
        } else if (this.adX.isReady()) {
            this.adX.r(dVar);
        }
    }

    public boolean rH() {
        return this.ada.isEmpty();
    }

    public View pB() {
        return this.mRootView;
    }

    public void aZ(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aea = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.acZ = false;
        if (this.ada != null) {
            this.ada.clear();
        }
        if (this.adW != null) {
            this.adW.onDestroy();
        }
        if (this.adX != null) {
            this.adX.onDestroy();
        }
        this.mContext = null;
    }
}
