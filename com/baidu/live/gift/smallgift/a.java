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
import com.baidu.live.gift.q;
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
    private k aAD;
    private int aFc;
    private int aFd;
    private boolean aGm;
    private ArrayList<c> aGn;
    private b aHn;
    private b aHo;
    private AlaSmallGiftView aHp;
    private AlaSmallGiftView aHq;
    private int aHr;
    private b.a aHs;
    private boolean ayw;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aGm = false;
        this.aHs = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void zI() {
                if (!a.this.zH()) {
                    a.this.xt();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void r(c cVar) {
                if (cVar != null && cVar.aEi < cVar.aEh) {
                    if (a.this.aAD.a(cVar)) {
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
                    a.this.q(cVar);
                }
            }
        };
        this.mContext = context;
        this.aAD = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.ayw = z;
        this.aHp.setMode(z);
        this.aHq.setMode(z);
    }

    private void initData() {
        this.aGn = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aFc = (int) resources.getDimension(a.e.sdk_ds650);
        this.aFd = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aHr = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aHp = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aHq = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aHn = new b(this.aHp);
        this.aHn.a(this.aHs);
        this.aHo = new b(this.aHq);
        this.aHo.a(this.aHs);
        setRootViewParam(1);
        this.aAD.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aFc, this.aFd);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aFd);
            layoutParams2.bottomMargin = this.aHr;
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void aW(boolean z) {
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
                layoutParams.bottomMargin = this.aHr;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void xx() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aHn != null) {
            this.aHn.xx();
        }
        if (this.aHo != null) {
            this.aHo.xx();
        }
    }

    public void wD() {
        this.aGm = true;
        if (this.aHn != null) {
            this.aHn.wD();
        }
        if (this.aHo != null) {
            this.aHo.wD();
        }
        this.aAD.wF();
    }

    public void wE() {
        this.aGm = false;
        this.aAD.M(this.mRootView);
        if (this.aHn != null) {
            this.aHn.wE();
        }
        if (this.aHo != null) {
            this.aHo.wE();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aHn.v(cVar) && !this.aHo.v(cVar)) {
                z = false;
            }
            if (!z) {
                n(cVar);
            }
        }
    }

    private void n(c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<c> it = this.aGn.iterator();
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
            o(cVar);
        }
    }

    public static boolean c(c cVar, c cVar2) {
        return cVar != null && !StringUtils.isNull(cVar.aEe) && cVar.aEe.equals(cVar2.aEe) && Math.abs(cVar2.yn() - cVar.yn()) <= 3000 && cVar2.aEh <= 99;
    }

    public static void d(c cVar, c cVar2) {
        q.a(cVar, cVar2);
        cVar.aEh += cVar2.aEh;
        cVar.Z(cVar2.yn());
    }

    private void o(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            p(cVar);
            return;
        }
        this.aGn.add(cVar);
        if (cVar.aEj) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aqw, cVar.aqx, cVar.giftId, "");
        }
        try {
            xq();
        } catch (Exception e) {
            e.printStackTrace();
        }
        xt();
    }

    public void p(c cVar) {
        if (this.aGm) {
            q(cVar);
        } else if (!this.aHn.zW() && this.aHn.s(cVar)) {
            this.aHn.u(cVar);
        } else if (!this.aHo.zW() && this.aHo.s(cVar)) {
            this.aHo.u(cVar);
        } else {
            q(cVar);
            xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aGn.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aGn.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aGn.add(cVar);
        } else {
            this.aGn.add(i, cVar);
        }
        try {
            xq();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void xq() {
        if (this.aGn != null) {
            int i = com.baidu.live.v.a.En().aQu != null ? com.baidu.live.v.a.En().aQu.atu : 0;
            if (i > 0 && this.aGn.size() >= i) {
                Collections.sort(this.aGn, new c.a());
                ArrayList arrayList = new ArrayList(this.aGn.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aGn.clear();
                this.aGn.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (!this.aGn.isEmpty() && !this.aGm) {
            if (this.aHn.isReady() || this.aHo.isReady()) {
                c remove = this.aGn.remove(0);
                if (remove != null) {
                    remove.Z(System.currentTimeMillis());
                    k(remove);
                    xt();
                    return;
                }
                xt();
            }
        }
    }

    private void k(c cVar) {
        if (this.aHn.isReady()) {
            this.aHn.t(cVar);
        } else if (this.aHo.isReady()) {
            this.aHo.t(cVar);
        }
        if (cVar.aEj) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aqw, cVar.aqx, cVar.giftId, "");
        }
    }

    public boolean zH() {
        return this.aGn.isEmpty();
    }

    public View wI() {
        return this.mRootView;
    }

    public void bE(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aHr = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.aGm = false;
        if (this.aGn != null) {
            this.aGn.clear();
        }
        if (this.aHn != null) {
            this.aHn.onDestroy();
        }
        if (this.aHo != null) {
            this.aHo.onDestroy();
        }
        this.mContext = null;
    }
}
