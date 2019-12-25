package com.baidu.live.gift.smallgift;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.b;
import com.baidu.live.gift.k;
import com.baidu.live.gift.smallgift.b;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private boolean adx;
    private k afc;
    private int ajD;
    private int ajE;
    private boolean akE;
    private ArrayList<com.baidu.live.gift.a.b> akF;
    private b alC;
    private b alD;
    private AlaSmallGiftView alE;
    private AlaSmallGiftView alF;
    private int alG;
    private b.a alH;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.akE = false;
        this.alH = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void ty() {
                if (!a.this.tx()) {
                    a.this.ry();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(com.baidu.live.gift.a.b bVar) {
                if (bVar != null && bVar.aiI < bVar.aiH) {
                    if (a.this.afc.a(bVar)) {
                        if (bVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            bVar.priority = 10;
                        } else {
                            bVar.priority = 8;
                        }
                    } else if (bVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        bVar.priority = 4;
                    } else {
                        bVar.priority = 2;
                    }
                    a.this.o(bVar);
                }
            }
        };
        this.mContext = context;
        this.afc = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.adx = z;
        this.alE.setMode(z);
        this.alF.setMode(z);
    }

    private void initData() {
        this.akF = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.ajD = (int) resources.getDimension(a.e.sdk_ds650);
        this.ajE = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.alG = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.alE = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.alF = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.alC = new b(this.alE);
        this.alC.a(this.alH);
        this.alD = new b(this.alF);
        this.alD.a(this.alH);
        setRootViewParam(1);
        this.afc.K(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ajD, this.ajE);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.ajE);
            layoutParams2.bottomMargin = this.alG;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void av(boolean z) {
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
                layoutParams.bottomMargin = this.alG;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void rC() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.alC != null) {
            this.alC.rC();
        }
        if (this.alD != null) {
            this.alD.rC();
        }
    }

    public void qT() {
        this.akE = true;
        if (this.alC != null) {
            this.alC.qT();
        }
        if (this.alD != null) {
            this.alD.qT();
        }
        this.afc.qV();
    }

    public void qU() {
        this.akE = false;
        this.afc.K(this.mRootView);
        if (this.alC != null) {
            this.alC.qU();
        }
        if (this.alD != null) {
            this.alD.qU();
        }
    }

    public void d(com.baidu.live.gift.a.b bVar) {
        boolean z = true;
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.giftId)) {
            if (!this.alC.t(bVar) && !this.alD.t(bVar)) {
                z = false;
            }
            if (!z) {
                l(bVar);
            }
        }
    }

    private void l(com.baidu.live.gift.a.b bVar) {
        boolean z;
        boolean z2 = false;
        Iterator<com.baidu.live.gift.a.b> it = this.akF.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            com.baidu.live.gift.a.b next = it.next();
            if (b(next, bVar)) {
                z = true;
                c(next, bVar);
            }
            z2 = z;
        }
        if (!z) {
            m(bVar);
        }
    }

    private boolean b(com.baidu.live.gift.a.b bVar, com.baidu.live.gift.a.b bVar2) {
        return bVar != null && !StringUtils.isNull(bVar.aiD) && bVar.aiD.equals(bVar2.aiD) && Math.abs(bVar2.sn() - bVar.sn()) <= 3000 && bVar2.aiH <= 10;
    }

    private void c(com.baidu.live.gift.a.b bVar, com.baidu.live.gift.a.b bVar2) {
        bVar.aiH += bVar2.aiH;
        bVar.A(bVar2.sn());
    }

    private void m(com.baidu.live.gift.a.b bVar) {
        if (bVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(bVar);
            return;
        }
        this.akF.add(bVar);
        try {
            rv();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ry();
    }

    public void n(com.baidu.live.gift.a.b bVar) {
        if (this.akE) {
            o(bVar);
        } else if (!this.alC.tM() && this.alC.q(bVar)) {
            this.alC.s(bVar);
        } else if (!this.alD.tM() && this.alD.q(bVar)) {
            this.alD.s(bVar);
        } else {
            o(bVar);
            ry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(com.baidu.live.gift.a.b bVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.akF.size()) {
                i = -1;
                break;
            } else if (bVar.priority > this.akF.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.akF.add(bVar);
        } else {
            this.akF.add(i, bVar);
        }
        try {
            rv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rv() {
        if (this.akF != null) {
            int i = com.baidu.live.r.a.wA().arE != null ? com.baidu.live.r.a.wA().arE.YL : 0;
            if (i > 0 && this.akF.size() >= i) {
                Collections.sort(this.akF, new b.a());
                ArrayList arrayList = new ArrayList(this.akF.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.akF.clear();
                this.akF.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        if (!this.akF.isEmpty() && !this.akE) {
            if (this.alC.isReady() || this.alD.isReady()) {
                com.baidu.live.gift.a.b remove = this.akF.remove(0);
                if (remove != null) {
                    remove.A(System.currentTimeMillis());
                    i(remove);
                    ry();
                    return;
                }
                ry();
            }
        }
    }

    private void i(com.baidu.live.gift.a.b bVar) {
        if (this.alC.isReady()) {
            this.alC.r(bVar);
        } else if (this.alD.isReady()) {
            this.alD.r(bVar);
        }
    }

    public boolean tx() {
        return this.akF.isEmpty();
    }

    public View qY() {
        return this.mRootView;
    }

    public void bk(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.alG = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.akE = false;
        if (this.akF != null) {
            this.akF.clear();
        }
        if (this.alC != null) {
            this.alC.onDestroy();
        }
        if (this.alD != null) {
            this.alD.onDestroy();
        }
        this.mContext = null;
    }
}
