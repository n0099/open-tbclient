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
    private boolean afZ;
    private k aie;
    private int amE;
    private int amF;
    private boolean anO;
    private ArrayList<c> anP;
    private b aoN;
    private b aoO;
    private AlaSmallGiftView aoP;
    private AlaSmallGiftView aoQ;
    private int aoR;
    private b.a aoS;
    private Context mContext;
    private View mRootView;

    public a(Context context, k kVar) {
        this.anO = false;
        this.aoS = new b.a() { // from class: com.baidu.live.gift.smallgift.a.1
            @Override // com.baidu.live.gift.smallgift.b.a
            public void vl() {
                if (!a.this.vk()) {
                    a.this.tb();
                }
            }

            @Override // com.baidu.live.gift.smallgift.b.a
            public void p(c cVar) {
                if (cVar != null && cVar.alM < cVar.alL) {
                    if (a.this.aie.a(cVar)) {
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
        this.aie = kVar;
        initData();
        initView();
    }

    public a(Context context, k kVar, boolean z) {
        this(context, kVar);
        this.afZ = z;
        this.aoP.setMode(z);
        this.aoQ.setMode(z);
    }

    private void initData() {
        this.anP = new ArrayList<>();
        Resources resources = this.mContext.getResources();
        this.amE = (int) resources.getDimension(a.e.sdk_ds650);
        this.amF = (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46) + resources.getDimensionPixelOffset(a.e.sdk_ds12);
        this.aoR = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.27f) + resources.getDimensionPixelSize(a.e.sdk_tbds64) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_small_gift_panel_layout, (ViewGroup) null);
        this.aoP = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift1);
        this.aoQ = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift2);
        this.aoN = new b(this.aoP);
        this.aoN.a(this.aoS);
        this.aoO = new b(this.aoQ);
        this.aoO.a(this.aoS);
        setRootViewParam(1);
        this.aie.K(this.mRootView);
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.amE, this.amF);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
            layoutParams.addRule(10);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.amF);
            layoutParams2.bottomMargin = this.aoR;
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
                layoutParams.bottomMargin = this.aoR;
                layoutParams.topMargin = 0;
                layoutParams.addRule(12);
                layoutParams.addRule(10, 0);
            }
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void tf() {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        if (this.aoN != null) {
            this.aoN.tf();
        }
        if (this.aoO != null) {
            this.aoO.tf();
        }
    }

    public void sl() {
        this.anO = true;
        if (this.aoN != null) {
            this.aoN.sl();
        }
        if (this.aoO != null) {
            this.aoO.sl();
        }
        this.aie.sn();
    }

    public void sm() {
        this.anO = false;
        this.aie.K(this.mRootView);
        if (this.aoN != null) {
            this.aoN.sm();
        }
        if (this.aoO != null) {
            this.aoO.sm();
        }
    }

    public void d(c cVar) {
        boolean z = true;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            if (!this.aoN.t(cVar) && !this.aoO.t(cVar)) {
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
        Iterator<c> it = this.anP.iterator();
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
        return cVar != null && !StringUtils.isNull(cVar.alI) && cVar.alI.equals(cVar2.alI) && Math.abs(cVar2.tU() - cVar.tU()) <= 3000 && cVar2.alL <= 10;
    }

    private void c(c cVar, c cVar2) {
        cVar.alL += cVar2.alL;
        cVar.B(cVar2.tU());
    }

    private void m(c cVar) {
        if (cVar.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
            n(cVar);
            return;
        }
        this.anP.add(cVar);
        if (cVar.alN) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, cVar.Yh, cVar.Yi, cVar.giftId, "");
        }
        try {
            sY();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tb();
    }

    public void n(c cVar) {
        if (this.anO) {
            o(cVar);
        } else if (!this.aoN.vz() && this.aoN.q(cVar)) {
            this.aoN.s(cVar);
        } else if (!this.aoO.vz() && this.aoO.q(cVar)) {
            this.aoO.s(cVar);
        } else {
            o(cVar);
            tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(c cVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.anP.size()) {
                i = -1;
                break;
            } else if (cVar.priority > this.anP.get(i).priority) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == -1) {
            this.anP.add(cVar);
        } else {
            this.anP.add(i, cVar);
        }
        try {
            sY();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sY() {
        if (this.anP != null) {
            int i = com.baidu.live.v.a.zs().awM != null ? com.baidu.live.v.a.zs().awM.aaZ : 0;
            if (i > 0 && this.anP.size() >= i) {
                Collections.sort(this.anP, new c.a());
                ArrayList arrayList = new ArrayList(this.anP.subList(0, Math.max((int) (i * 0.7f), 1)));
                this.anP.clear();
                this.anP.addAll(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        if (!this.anP.isEmpty() && !this.anO) {
            if (this.aoN.isReady() || this.aoO.isReady()) {
                c remove = this.anP.remove(0);
                if (remove != null) {
                    remove.B(System.currentTimeMillis());
                    i(remove);
                    tb();
                    return;
                }
                tb();
            }
        }
    }

    private void i(c cVar) {
        if (this.aoN.isReady()) {
            this.aoN.r(cVar);
        } else if (this.aoO.isReady()) {
            this.aoO.r(cVar);
        }
        if (cVar.alN) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.Yh, cVar.Yi, cVar.giftId, "");
        }
    }

    public boolean vk() {
        return this.anP.isEmpty();
    }

    public View sq() {
        return this.mRootView;
    }

    public void br(int i) {
        if (i == 2 && UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            Resources resources = this.mContext.getResources();
            this.aoR = (int) (resources.getDimensionPixelOffset(a.e.sdk_ds6) + (BdUtilHelper.getEquipmentHeight(this.mContext) * 0.33f) + resources.getDimensionPixelSize(a.e.sdk_tbds27) + resources.getDimensionPixelSize(a.e.sdk_tbds130) + resources.getDimensionPixelOffset(a.e.sdk_ds80) + resources.getDimensionPixelOffset(a.e.sdk_ds20));
            setRootViewParam(1);
        }
    }

    public void onDestroy() {
        this.anO = false;
        if (this.anP != null) {
            this.anP.clear();
        }
        if (this.aoN != null) {
            this.aoN.onDestroy();
        }
        if (this.aoO != null) {
            this.aoO.onDestroy();
        }
        this.mContext = null;
    }
}
