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
public class k implements u {
    private AlaGiftShowPanel ahl;
    private com.baidu.live.gift.biggift.a ahm;
    private com.baidu.live.gift.smallgift.a ahn;
    private com.baidu.live.gift.graffitiGift.a aho;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean ahp = false;
    CustomMessageListener ahq = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.alG);
            }
        }
    };
    CustomMessageListener ahr = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };

    public k(f fVar) {
        this.mContext = fVar.context;
        this.ahl = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.ahm = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.ahn = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.afZ);
        this.aho = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        sk();
    }

    private void sk() {
        MessageManager.getInstance().registerListener(this.ahq);
        MessageManager.getInstance().registerListener(this.ahr);
        this.ahl.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.ahm.ta();
                k.this.ahm.tf();
                k.this.ahn.tf();
                k.this.aho.uG();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.alQ;
            if (!z3 || cVar.alQ || z || !this.ahp || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.alQ || cVar.priority == 1) {
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
            if (z2 && UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
            }
            if (z2) {
                c(cVar);
            } else if (cVar.alH.agC != null && cVar.alL >= 2 && !ListUtils.isEmpty(cVar.alH.agC.ahB)) {
                e(cVar);
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
        if (cVar == null || cVar.alH == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.uz().dn(cVar.alH.rC());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        sl();
        this.ahm.f(cVar);
        this.ahm.sZ();
    }

    public void sl() {
        this.ahn.sl();
        this.aho.sl();
    }

    public void sm() {
        this.ahn.sm();
        this.aho.sm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.ahn.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aho.e(cVar);
    }

    public void sn() {
        int i = 0;
        if (this.ahl != null) {
            int childCount = this.ahl.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.ahl.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.ahl.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ahl.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void so() {
        int i = 0;
        if (this.ahl != null) {
            int childCount = this.ahl.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.ahl.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.ahl.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ahl.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void K(View view) {
        if (this.ahl.indexOfChild(view) < 0) {
            this.ahl.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.ahl.indexOfChild(view) < 0) {
                this.ahl.addView(view, layoutParams);
                return;
            }
            return;
        }
        K(view);
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            if (this.ahm != null) {
                this.ahm.onDestroy();
            }
            if (this.ahn != null) {
                this.ahn.onDestroy();
            }
            if (this.aho != null) {
                this.aho.onDestroy();
            }
            if (this.ahl != null) {
                this.ahl.clearAnimation();
                this.ahl.setConfigurationChangedListener(null);
                this.ahl.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.ahq);
            MessageManager.getInstance().unRegisterListener(this.ahr);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.u
    public View sp() {
        return this.ahl;
    }

    @Override // com.baidu.live.gift.u
    public void ay(boolean z) {
        if (this.ahn != null) {
            this.ahn.ay(z);
        }
    }

    @Override // com.baidu.live.gift.u
    public void br(int i) {
        if (this.ahn != null) {
            this.ahn.br(i);
        }
    }

    @Override // com.baidu.live.gift.u
    public View sq() {
        return this.ahn.sq();
    }

    @Override // com.baidu.live.gift.u
    public void sr() {
        if (this.ahl != null) {
            this.ahl.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.u
    public void az(boolean z) {
        this.ahp = z;
        if (this.aho != null) {
            this.aho.az(z);
        }
        if (this.ahm != null) {
            this.ahm.az(z);
        }
    }

    @Override // com.baidu.live.gift.u
    public void ss() {
        if (this.aho != null) {
            this.aho.ss();
        }
    }
}
