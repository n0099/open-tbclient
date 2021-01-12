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
/* loaded from: classes10.dex */
public class j implements ad {
    public boolean aSj;
    private AlaGiftShowPanel aTR;
    private com.baidu.live.gift.biggift.a aTS;
    private com.baidu.live.gift.smallgift.a aTT;
    private com.baidu.live.gift.graffitiGift.a aTU;
    public boolean isLandscape;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aTV = false;
    CustomMessageListener aTW = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.aZG);
            }
        }
    };
    CustomMessageListener aTX = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                j.this.d(cVar);
            }
        }
    };

    public j(f fVar) {
        this.mContext = fVar.context;
        this.aSj = fVar.aSj;
        this.isLandscape = fVar.aSu;
        this.aTR = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aTS = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aTT = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aSt);
        this.aTU = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aTT.df(com.baidu.live.al.a.b(this.mContext, this.aSj, this.isLandscape, false));
        this.aTS.cG(com.baidu.live.al.a.b(this.mContext, this.aSj, this.isLandscape, false));
        this.aTS.cH(com.baidu.live.al.a.h(this.aSj, this.isLandscape));
        Dn();
    }

    private void Dn() {
        MessageManager.getInstance().registerListener(this.aTW);
        MessageManager.getInstance().registerListener(this.aTX);
        this.aTR.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aTS.Es();
                j.this.aTS.Ex();
                j.this.aTT.Ex();
                j.this.aTU.Gh();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZS || cVar.aZU;
            if (!z3 || cVar.aZS || z || !this.aTV || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZS || cVar.priority == 1) {
                    if (z && cVar.aZK) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.aZK) {
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
            } else if (cVar.aZH.aSZ != null && cVar.aZM >= 2 && !ListUtils.isEmpty(cVar.aZH.aSZ.aUh)) {
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
        if (cVar == null || cVar.aZH == null) {
            return false;
        }
        return com.baidu.live.gift.c.b.Gb().fL(cVar.aZH.CC());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        Do();
        this.aTS.h(cVar);
        this.aTS.i(cVar);
    }

    public void Do() {
        this.aTT.Do();
        this.aTU.Do();
    }

    public void Dp() {
        this.aTT.Dp();
        this.aTU.Dp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aTT.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aTU.e(cVar);
    }

    public void Dq() {
        int i = 0;
        if (this.aTR != null) {
            int childCount = this.aTR.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aTR.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aTR.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTR.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void Dr() {
        int i = 0;
        if (this.aTR != null) {
            int childCount = this.aTR.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aTR.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aTR.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTR.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aTR.indexOfChild(view) < 0) {
            this.aTR.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aTR.indexOfChild(view) < 0) {
                this.aTR.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ad
    public void onDestroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            if (this.aTS != null) {
                this.aTS.onDestroy();
            }
            if (this.aTT != null) {
                this.aTT.onDestroy();
            }
            if (this.aTU != null) {
                this.aTU.onDestroy();
            }
            if (this.aTR != null) {
                this.aTR.clearAnimation();
                this.aTR.setConfigurationChangedListener(null);
                this.aTR.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aTW);
            MessageManager.getInstance().unRegisterListener(this.aTX);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View Ds() {
        return this.aTR;
    }

    @Override // com.baidu.live.gift.ad
    public View Dt() {
        return this.aTT.Dt();
    }

    @Override // com.baidu.live.gift.ad
    public void Du() {
        if (this.aTR != null) {
            this.aTR.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bw(boolean z) {
        this.aTV = z;
        if (this.aTU != null) {
            this.aTU.bw(z);
        }
        if (this.aTS != null) {
            this.aTS.bw(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void Dv() {
        if (this.aTU != null) {
            this.aTU.Dv();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cC(int i) {
        if (this.aTS != null) {
            this.aTS.cG(i);
        }
        if (this.aTT != null) {
            this.aTT.df(i);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cD(int i) {
        if (this.aTS != null) {
            this.aTS.cH(i);
        }
    }
}
