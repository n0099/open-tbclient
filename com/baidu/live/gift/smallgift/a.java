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
    private k aAx;
    private int aEW;
    private int aEX;
    private boolean aGg;
    private ArrayList<c> aGh;
    private b aHh;
    private b aHi;
    private AlaSmallGiftView aHj;
    private AlaSmallGiftView aHk;
    private int aHl;
    private b.a aHm;
    private boolean ayq;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.aGg = false;
        this.aHm = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void zJ() {
                if (!a.this.zI()) {
                    a.this.xu();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void r(c cVar) {
                if (cVar != null && cVar.aEc < cVar.aEb) {
                    if (a.this.aAx.a(cVar)) {
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
        this.aAx = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.ayq = z;
        this.aHj.setMode(z);
        this.aHk.setMode(z);
    }

    private void initData() {
        this.aGh = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.aEW = (int) resources.getDimension(a.e.sdk_ds650);
        this.aEX = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aHl = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aHj = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aHk = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aHh = new b(this.aHj);
        this.aHh.a(this.aHm);
        this.aHi = new b(this.aHk);
        this.aHi.a(this.aHm);
        setRootViewParam(1);
        this.aAx.M(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aEW, this.aEX);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.aEX);
            layoutParams2.bottomMargin = this.aHl;
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
                layoutParams.bottomMargin = this.aHl;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void xy() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aHh != null) {
            this.aHh.xy();
        }
        if (this.aHi != null) {
            this.aHi.xy();
        }
    }

    public void wE() {
        this.aGg = true;
        if (this.aHh != null) {
            this.aHh.wE();
        }
        if (this.aHi != null) {
            this.aHi.wE();
        }
        this.aAx.wG();
    }

    public void wF() {
        this.aGg = false;
        this.aAx.M(this.mRootView);
        if (this.aHh != null) {
            this.aHh.wF();
        }
        if (this.aHi != null) {
            this.aHi.wF();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aHh.v(cVar) && !this.aHi.v(cVar)) {
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
        Iterator<c> it = this.aGh.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.aDY) && cVar.aDY.equals(cVar2.aDY) && Math.abs(cVar2.yo() - cVar.yo()) <= 3000 && cVar2.aEb <= 99;
    }

    public static void d(c cVar, c cVar2) {
        q.a(cVar, cVar2);
        cVar.aEb += cVar2.aEb;
        cVar.Z(cVar2.yo());
    }

    private void o(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            p(cVar);
            return;
        }
        this.aGh.add(cVar);
        if (cVar.aEd) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.aqq, cVar.aqr, cVar.giftId, "");
        }
        try {
            xr();
        } catch (Exception e) {
            e.printStackTrace();
        }
        xu();
    }

    public void p(c cVar) {
        if (this.aGg) {
            q(cVar);
        } else if (!this.aHh.zX() && this.aHh.s(cVar)) {
            this.aHh.u(cVar);
        } else if (!this.aHi.zX() && this.aHi.s(cVar)) {
            this.aHi.u(cVar);
        } else {
            q(cVar);
            xu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.aGh.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.aGh.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.aGh.add(cVar);
        } else {
            this.aGh.add(i, cVar);
        }
        try {
            xr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void xr() {
        if (this.aGh != null) {
            int i = com.baidu.live.v.a.Eo().aQp != null ? com.baidu.live.v.a.Eo().aQp.ato : 0;
            if (i > 0 && this.aGh.size() >= i) {
                Collections.sort(this.aGh, new c.a());
                ArrayList arrayList = new ArrayList(this.aGh.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.aGh.clear();
                this.aGh.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu() {
        if (!this.aGh.isEmpty() && !this.aGg) {
            if (this.aHh.isReady() || this.aHi.isReady()) {
                c remove = this.aGh.remove(0);
                if (remove != null) {
                    remove.Z(System.currentTimeMillis());
                    k(remove);
                    xu();
                    return;
                }
                xu();
            }
        }
    }

    private void k(c cVar) {
        if (this.aHh.isReady()) {
            this.aHh.t(cVar);
        } else if (this.aHi.isReady()) {
            this.aHi.t(cVar);
        }
        if (cVar.aEd) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aqq, cVar.aqr, cVar.giftId, "");
        }
    }

    public boolean zI() {
        return this.aGh.isEmpty();
    }

    public View wJ() {
        return this.mRootView;
    }

    public void bE(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aHl = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.aGg = false;
        if (this.aGh != null) {
            this.aGh.clear();
        }
        if (this.aHh != null) {
            this.aHh.onDestroy();
        }
        if (this.aHi != null) {
            this.aHi.onDestroy();
        }
        this.mContext = null;
    }
}
