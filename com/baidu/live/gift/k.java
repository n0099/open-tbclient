package com.baidu.live.gift;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.AlaGiftShowPanel;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k implements ac {
    public boolean aSH;
    private AlaGiftShowPanel aUm;
    private com.baidu.live.gift.biggift.a aUn;
    private com.baidu.live.gift.smallgift.a aUo;
    private com.baidu.live.gift.graffitiGift.a aUp;
    private boolean aUq = false;
    private boolean aUr = false;
    CustomMessageListener aUs = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aZI);
            }
        }
    };
    CustomMessageListener aUt = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };
    public boolean isLandscape;
    private Context mContext;

    public k(f fVar) {
        this.mContext = fVar.context;
        this.aSH = fVar.aSH;
        this.isLandscape = fVar.aSR;
        this.aUm = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aUn = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aUo = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aSQ);
        this.aUp = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aUo.ew(com.baidu.live.af.a.a(this.mContext, this.aSH, this.isLandscape, false));
        this.aUn.dY(com.baidu.live.af.a.a(this.mContext, this.aSH, this.isLandscape, false));
        this.aUn.dZ(com.baidu.live.af.a.h(this.aSH, this.isLandscape));
        Ga();
    }

    private void Ga() {
        MessageManager.getInstance().registerListener(this.aUs);
        MessageManager.getInstance().registerListener(this.aUt);
        this.aUm.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aUn.Hd();
                k.this.aUn.Hi();
                k.this.aUo.Hi();
                k.this.aUp.IJ();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZU || cVar.aZW;
            if (!z3 || cVar.aZU || z || !this.aUr || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZU || cVar.priority == 1) {
                    if (z && cVar.aZN) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.aZN) {
                        cVar.priority = 11;
                    } else {
                        cVar.priority = 7;
                    }
                }
            } else if (z) {
                cVar.priority = 3;
            } else {
                cVar.priority = 1;
            }
            if (z2) {
                c(cVar);
                w.g(cVar);
            } else if (cVar.aZJ.aTv != null && cVar.aZP >= 2 && !ListUtils.isEmpty(cVar.aZJ.aTv.aUD)) {
                e(cVar);
                w.g(cVar);
            } else {
                d(cVar);
            }
        }
    }

    public boolean a(com.baidu.live.gift.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        return b(cVar);
    }

    private boolean b(com.baidu.live.gift.a.c cVar) {
        if (cVar == null || cVar.aZJ == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.ID().gS(cVar.aZJ.Fs());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        Gb();
        this.aUn.h(cVar);
        this.aUn.Hc();
    }

    public void Gb() {
        this.aUo.Gb();
        this.aUp.Gb();
    }

    public void Gc() {
        this.aUo.Gc();
        this.aUp.Gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aUo.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aUp.e(cVar);
    }

    public void Gd() {
        int i = 0;
        if (this.aUm != null) {
            int childCount = this.aUm.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aUm.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aUm.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aUm.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void Ge() {
        int i = 0;
        if (this.aUm != null) {
            int childCount = this.aUm.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aUm.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aUm.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aUm.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aUm.indexOfChild(view) < 0) {
            this.aUm.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aUm.indexOfChild(view) < 0) {
                this.aUm.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        if (!this.aUq) {
            this.aUq = true;
            if (this.aUn != null) {
                this.aUn.onDestroy();
            }
            if (this.aUo != null) {
                this.aUo.onDestroy();
            }
            if (this.aUp != null) {
                this.aUp.onDestroy();
            }
            if (this.aUm != null) {
                this.aUm.clearAnimation();
                this.aUm.setConfigurationChangedListener(null);
                this.aUm.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aUs);
            MessageManager.getInstance().unRegisterListener(this.aUt);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ac
    public View Gf() {
        return this.aUm;
    }

    @Override // com.baidu.live.gift.ac
    public View Gg() {
        return this.aUo.Gg();
    }

    @Override // com.baidu.live.gift.ac
    public void Gh() {
        if (this.aUm != null) {
            this.aUm.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void bq(boolean z) {
        this.aUr = z;
        if (this.aUp != null) {
            this.aUp.bq(z);
        }
        if (this.aUn != null) {
            this.aUn.bq(z);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Gi() {
        if (this.aUp != null) {
            this.aUp.Gi();
        }
    }

    @Override // com.baidu.live.gift.ac
    public void dU(int i) {
        if (this.aUn != null) {
            this.aUn.dY(i);
        }
        if (this.aUo != null) {
            this.aUo.ew(i);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void dV(int i) {
        if (this.aUn != null) {
            this.aUn.dZ(i);
        }
    }
}
