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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a {
    private boolean adM;
    private k afL;
    private int akn;
    private int ako;
    private boolean alr;
    private ArrayList<c> als;
    private b amp;
    private b amq;
    private AlaSmallGiftView amr;
    private AlaSmallGiftView ams;
    private int amt;
    private b.a amu;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.alr = false;
        this.amu = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void tP() {
                if (!a.this.tO()) {
                    a.this.rL();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(c cVar) {
                if (cVar != null && cVar.ajt < cVar.ajs) {
                    if (a.this.afL.a(cVar)) {
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
        this.afL = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.adM = z;
        this.amr.setMode(z);
        this.ams.setMode(z);
    }

    private void initData() {
        this.als = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.akn = (int) resources.getDimension(a.e.sdk_ds650);
        this.ako = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.amt = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.amr = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.ams = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.amp = new b(this.amr);
        this.amp.a(this.amu);
        this.amq = new b(this.ams);
        this.amq.a(this.amu);
        setRootViewParam(1);
        this.afL.K(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.akn, this.ako);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.ako);
            layoutParams2.bottomMargin = this.amt;
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
                layoutParams.bottomMargin = this.amt;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void rP() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.amp != null) {
            this.amp.rP();
        }
        if (this.amq != null) {
            this.amq.rP();
        }
    }

    public void rf() {
        this.alr = true;
        if (this.amp != null) {
            this.amp.rf();
        }
        if (this.amq != null) {
            this.amq.rf();
        }
        this.afL.rh();
    }

    public void rg() {
        this.alr = false;
        this.afL.K(this.mRootView);
        if (this.amp != null) {
            this.amp.rg();
        }
        if (this.amq != null) {
            this.amq.rg();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.amp.t(cVar) && !this.amq.t(cVar)) {
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
        Iterator<c> it = this.als.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.ajp) && cVar.ajp.equals(cVar2.ajp) && Math.abs(cVar2.sD() - cVar.sD()) <= 3000 && cVar2.ajs <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.ajs += cVar2.ajs;
        cVar.A(cVar2.sD());
    }

    private void m(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(cVar);
            return;
        }
        this.als.add(cVar);
        try {
            rI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        rL();
    }

    public void n(c cVar) {
        if (this.alr) {
            o(cVar);
        } else if (!this.amp.ud() && this.amp.q(cVar)) {
            this.amp.s(cVar);
        } else if (!this.amq.ud() && this.amq.q(cVar)) {
            this.amq.s(cVar);
        } else {
            o(cVar);
            rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.als.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.als.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.als.add(cVar);
        } else {
            this.als.add(i, cVar);
        }
        try {
            rI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rI() {
        if (this.als != null) {
            int i = com.baidu.live.s.a.wR().asq != null ? com.baidu.live.s.a.wR().asq.YX : 0;
            if (i > 0 && this.als.size() >= i) {
                Collections.sort(this.als, new c.a());
                ArrayList arrayList = new ArrayList(this.als.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.als.clear();
                this.als.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL() {
        if (!this.als.isEmpty() && !this.alr) {
            if (this.amp.isReady() || this.amq.isReady()) {
                c remove = this.als.remove(0);
                if (remove != null) {
                    remove.A(System.currentTimeMillis());
                    i(remove);
                    rL();
                    return;
                }
                rL();
            }
        }
    }

    private void i(c cVar) {
        if (this.amp.isReady()) {
            this.amp.r(cVar);
        } else if (this.amq.isReady()) {
            this.amq.r(cVar);
        }
    }

    public boolean tO() {
        return this.als.isEmpty();
    }

    public View rk() {
        return this.mRootView;
    }

    public void bk(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.amt = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.alr = false;
        if (this.als != null) {
            this.als.clear();
        }
        if (this.amp != null) {
            this.amp.onDestroy();
        }
        if (this.amq != null) {
            this.amq.onDestroy();
        }
        this.mContext = null;
    }
}
