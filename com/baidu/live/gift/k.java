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
/* loaded from: classes7.dex */
public class k implements w {
    public boolean aMJ;
    private AlaGiftShowPanel aOg;
    private com.baidu.live.gift.biggift.a aOh;
    private com.baidu.live.gift.smallgift.a aOi;
    private com.baidu.live.gift.graffitiGift.a aOj;
    private boolean aOk = false;
    private boolean aOl = false;
    CustomMessageListener aOm = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aSR);
            }
        }
    };
    CustomMessageListener aOn = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.aMJ = fVar.aMJ;
        this.isLandscape = fVar.aMT;
        this.aOg = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aOh = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aOi = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aMS);
        this.aOj = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aOi.em(com.baidu.live.ab.a.a(this.mContext, this.aMJ, this.isLandscape, false));
        this.aOh.dO(com.baidu.live.ab.a.a(this.mContext, this.aMJ, this.isLandscape, false));
        this.aOh.dP(com.baidu.live.ab.a.h(this.aMJ, this.isLandscape));
        Ey();
    }

    private void Ey() {
        MessageManager.getInstance().registerListener(this.aOm);
        MessageManager.getInstance().registerListener(this.aOn);
        this.aOg.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aOh.Fl();
                k.this.aOh.Fq();
                k.this.aOi.Fq();
                k.this.aOj.GT();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aTb;
            if (!z3 || cVar.aTb || z || !this.aOl || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aTb || cVar.priority == 1) {
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
                r.g(cVar);
            } else if (cVar.aSS.aNu != null && cVar.aSW >= 2 && !ListUtils.isEmpty(cVar.aSS.aNu.aOx)) {
                e(cVar);
                r.g(cVar);
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
        if (cVar == null || cVar.aSS == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.GM().gl(cVar.aSS.DR());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        Ez();
        this.aOh.h(cVar);
        this.aOh.Fk();
    }

    public void Ez() {
        this.aOi.Ez();
        this.aOj.Ez();
    }

    public void EA() {
        this.aOi.EA();
        this.aOj.EA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aOi.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aOj.e(cVar);
    }

    public void EB() {
        int i = 0;
        if (this.aOg != null) {
            int childCount = this.aOg.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aOg.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aOg.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aOg.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void EC() {
        int i = 0;
        if (this.aOg != null) {
            int childCount = this.aOg.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aOg.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aOg.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aOg.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aOg.indexOfChild(view) < 0) {
            this.aOg.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aOg.indexOfChild(view) < 0) {
                this.aOg.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        if (!this.aOk) {
            this.aOk = true;
            if (this.aOh != null) {
                this.aOh.onDestroy();
            }
            if (this.aOi != null) {
                this.aOi.onDestroy();
            }
            if (this.aOj != null) {
                this.aOj.onDestroy();
            }
            if (this.aOg != null) {
                this.aOg.clearAnimation();
                this.aOg.setConfigurationChangedListener(null);
                this.aOg.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aOm);
            MessageManager.getInstance().unRegisterListener(this.aOn);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.w
    public View ED() {
        return this.aOg;
    }

    @Override // com.baidu.live.gift.w
    public View EE() {
        return this.aOi.EE();
    }

    @Override // com.baidu.live.gift.w
    public void EF() {
        if (this.aOg != null) {
            this.aOg.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bj(boolean z) {
        this.aOl = z;
        if (this.aOj != null) {
            this.aOj.bj(z);
        }
        if (this.aOh != null) {
            this.aOh.bj(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void EG() {
        if (this.aOj != null) {
            this.aOj.EG();
        }
    }

    @Override // com.baidu.live.gift.w
    public void dL(int i) {
        if (this.aOh != null) {
            this.aOh.dO(i);
        }
        if (this.aOi != null) {
            this.aOi.em(i);
        }
    }

    @Override // com.baidu.live.gift.w
    public void dM(int i) {
        if (this.aOh != null) {
            this.aOh.dP(i);
        }
    }
}
