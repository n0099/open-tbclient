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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k implements v {
    public boolean ayo;
    private AlaGiftShowPanel azK;
    private com.baidu.live.gift.biggift.a azL;
    private com.baidu.live.gift.smallgift.a azM;
    private com.baidu.live.gift.graffitiGift.a azN;
    private boolean azO = false;
    private boolean azP = false;
    CustomMessageListener azQ = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aEc);
            }
        }
    };
    CustomMessageListener azR = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };
    private Context mContext;

    public k(f fVar) {
        this.mContext = fVar.context;
        this.ayo = fVar.ayo;
        this.azK = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.azL = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.azM = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.ayw);
        this.azN = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        wC();
    }

    private void wC() {
        MessageManager.getInstance().registerListener(this.azQ);
        MessageManager.getInstance().registerListener(this.azR);
        this.azK.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.azL.xs();
                k.this.azL.xx();
                k.this.azM.xx();
                k.this.azN.za();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aEm;
            if (!z3 || cVar.aEm || z || !this.azP || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aEm || cVar.priority == 1) {
                    if (z) {
                        cVar.priority = 9;
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
                q.g(cVar);
            } else if (cVar.aEd.ayY != null && cVar.aEh >= 2 && !ListUtils.isEmpty(cVar.aEd.ayY.aAb)) {
                e(cVar);
                q.g(cVar);
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
        if (cVar == null || cVar.aEd == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.yS().ee(cVar.aEd.vU());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        wD();
        this.azL.h(cVar);
        this.azL.xr();
    }

    public void wD() {
        this.azM.wD();
        this.azN.wD();
    }

    public void wE() {
        this.azM.wE();
        this.azN.wE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.azM.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.azN.e(cVar);
    }

    public void wF() {
        int i = 0;
        if (this.azK != null) {
            int childCount = this.azK.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.azK.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.azK.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.azK.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void wG() {
        int i = 0;
        if (this.azK != null) {
            int childCount = this.azK.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.azK.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.azK.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.azK.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.azK.indexOfChild(view) < 0) {
            this.azK.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.azK.indexOfChild(view) < 0) {
                this.azK.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        if (!this.azO) {
            this.azO = true;
            if (this.azL != null) {
                this.azL.onDestroy();
            }
            if (this.azM != null) {
                this.azM.onDestroy();
            }
            if (this.azN != null) {
                this.azN.onDestroy();
            }
            if (this.azK != null) {
                this.azK.clearAnimation();
                this.azK.setConfigurationChangedListener(null);
                this.azK.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.azQ);
            MessageManager.getInstance().unRegisterListener(this.azR);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.v
    public View wH() {
        return this.azK;
    }

    @Override // com.baidu.live.gift.v
    public void aW(boolean z) {
        if (this.azM != null) {
            this.azM.aW(z);
        }
    }

    @Override // com.baidu.live.gift.v
    public void bE(int i) {
        if (this.azM != null) {
            this.azM.bE(i);
        }
    }

    @Override // com.baidu.live.gift.v
    public View wI() {
        return this.azM.wI();
    }

    @Override // com.baidu.live.gift.v
    public void wJ() {
        if (this.azK != null) {
            this.azK.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.v
    public void aX(boolean z) {
        this.azP = z;
        if (this.azN != null) {
            this.azN.aX(z);
        }
        if (this.azL != null) {
            this.azL.aX(z);
        }
    }

    @Override // com.baidu.live.gift.v
    public void wK() {
        if (this.azN != null) {
            this.azN.wK();
        }
    }
}
