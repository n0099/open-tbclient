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
    public boolean ayi;
    private AlaGiftShowPanel azE;
    private com.baidu.live.gift.biggift.a azF;
    private com.baidu.live.gift.smallgift.a azG;
    private com.baidu.live.gift.graffitiGift.a azH;
    private boolean azI = false;
    private boolean azJ = false;
    CustomMessageListener azK = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aDW);
            }
        }
    };
    CustomMessageListener azL = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.ayi = fVar.ayi;
        this.azE = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.azF = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.azG = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.ayq);
        this.azH = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        wD();
    }

    private void wD() {
        MessageManager.getInstance().registerListener(this.azK);
        MessageManager.getInstance().registerListener(this.azL);
        this.azE.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.azF.xt();
                k.this.azF.xy();
                k.this.azG.xy();
                k.this.azH.zb();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aEg;
            if (!z3 || cVar.aEg || z || !this.azJ || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aEg || cVar.priority == 1) {
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
            } else if (cVar.aDX.ayS != null && cVar.aEb >= 2 && !ListUtils.isEmpty(cVar.aDX.ayS.azV)) {
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
        if (cVar == null || cVar.aDX == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.yT().ee(cVar.aDX.vV());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        wE();
        this.azF.h(cVar);
        this.azF.xs();
    }

    public void wE() {
        this.azG.wE();
        this.azH.wE();
    }

    public void wF() {
        this.azG.wF();
        this.azH.wF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.azG.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.azH.e(cVar);
    }

    public void wG() {
        int i = 0;
        if (this.azE != null) {
            int childCount = this.azE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.azE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.azE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.azE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void wH() {
        int i = 0;
        if (this.azE != null) {
            int childCount = this.azE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.azE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.azE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.azE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.azE.indexOfChild(view) < 0) {
            this.azE.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.azE.indexOfChild(view) < 0) {
                this.azE.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        if (!this.azI) {
            this.azI = true;
            if (this.azF != null) {
                this.azF.onDestroy();
            }
            if (this.azG != null) {
                this.azG.onDestroy();
            }
            if (this.azH != null) {
                this.azH.onDestroy();
            }
            if (this.azE != null) {
                this.azE.clearAnimation();
                this.azE.setConfigurationChangedListener(null);
                this.azE.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.azK);
            MessageManager.getInstance().unRegisterListener(this.azL);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.v
    public View wI() {
        return this.azE;
    }

    @Override // com.baidu.live.gift.v
    public void aW(boolean z) {
        if (this.azG != null) {
            this.azG.aW(z);
        }
    }

    @Override // com.baidu.live.gift.v
    public void bE(int i) {
        if (this.azG != null) {
            this.azG.bE(i);
        }
    }

    @Override // com.baidu.live.gift.v
    public View wJ() {
        return this.azG.wJ();
    }

    @Override // com.baidu.live.gift.v
    public void wK() {
        if (this.azE != null) {
            this.azE.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.v
    public void aX(boolean z) {
        this.azJ = z;
        if (this.azH != null) {
            this.azH.aX(z);
        }
        if (this.azF != null) {
            this.azF.aX(z);
        }
    }

    @Override // com.baidu.live.gift.v
    public void wL() {
        if (this.azH != null) {
            this.azH.wL();
        }
    }
}
