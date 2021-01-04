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
/* loaded from: classes11.dex */
public class j implements ad {
    public boolean aWW;
    private AlaGiftShowPanel aYE;
    private com.baidu.live.gift.biggift.a aYF;
    private com.baidu.live.gift.smallgift.a aYG;
    private com.baidu.live.gift.graffitiGift.a aYH;
    public boolean isLandscape;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aYI = false;
    CustomMessageListener aYJ = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.bew);
            }
        }
    };
    CustomMessageListener aYK = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
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
        this.aWW = fVar.aWW;
        this.isLandscape = fVar.aXh;
        this.aYE = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aYF = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aYG = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aXg);
        this.aYH = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aYG.eL(com.baidu.live.al.a.b(this.mContext, this.aWW, this.isLandscape, false));
        this.aYF.em(com.baidu.live.al.a.b(this.mContext, this.aWW, this.isLandscape, false));
        this.aYF.en(com.baidu.live.al.a.h(this.aWW, this.isLandscape));
        Hi();
    }

    private void Hi() {
        MessageManager.getInstance().registerListener(this.aYJ);
        MessageManager.getInstance().registerListener(this.aYK);
        this.aYE.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aYF.In();
                j.this.aYF.Is();
                j.this.aYG.Is();
                j.this.aYH.Kc();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.beI || cVar.beK;
            if (!z3 || cVar.beI || z || !this.aYI || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.beI || cVar.priority == 1) {
                    if (z && cVar.beA) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.beA) {
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
            } else if (cVar.bex.aXM != null && cVar.beC >= 2 && !ListUtils.isEmpty(cVar.bex.aXM.aYU)) {
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
        if (cVar == null || cVar.bex == null) {
            return false;
        }
        return com.baidu.live.gift.c.b.JW().gX(cVar.bex.Gx());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        Hj();
        this.aYF.h(cVar);
        this.aYF.i(cVar);
    }

    public void Hj() {
        this.aYG.Hj();
        this.aYH.Hj();
    }

    public void Hk() {
        this.aYG.Hk();
        this.aYH.Hk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aYG.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aYH.e(cVar);
    }

    public void Hl() {
        int i = 0;
        if (this.aYE != null) {
            int childCount = this.aYE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aYE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aYE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aYE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void Hm() {
        int i = 0;
        if (this.aYE != null) {
            int childCount = this.aYE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aYE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aYE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aYE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aYE.indexOfChild(view) < 0) {
            this.aYE.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aYE.indexOfChild(view) < 0) {
                this.aYE.addView(view, layoutParams);
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
            if (this.aYF != null) {
                this.aYF.onDestroy();
            }
            if (this.aYG != null) {
                this.aYG.onDestroy();
            }
            if (this.aYH != null) {
                this.aYH.onDestroy();
            }
            if (this.aYE != null) {
                this.aYE.clearAnimation();
                this.aYE.setConfigurationChangedListener(null);
                this.aYE.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aYJ);
            MessageManager.getInstance().unRegisterListener(this.aYK);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View Hn() {
        return this.aYE;
    }

    @Override // com.baidu.live.gift.ad
    public View Ho() {
        return this.aYG.Ho();
    }

    @Override // com.baidu.live.gift.ad
    public void Hp() {
        if (this.aYE != null) {
            this.aYE.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bA(boolean z) {
        this.aYI = z;
        if (this.aYH != null) {
            this.aYH.bA(z);
        }
        if (this.aYF != null) {
            this.aYF.bA(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void Hq() {
        if (this.aYH != null) {
            this.aYH.Hq();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void ei(int i) {
        if (this.aYF != null) {
            this.aYF.em(i);
        }
        if (this.aYG != null) {
            this.aYG.eL(i);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void ej(int i) {
        if (this.aYF != null) {
            this.aYF.en(i);
        }
    }
}
