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
    public boolean aMH;
    private AlaGiftShowPanel aOe;
    private com.baidu.live.gift.biggift.a aOf;
    private com.baidu.live.gift.smallgift.a aOg;
    private com.baidu.live.gift.graffitiGift.a aOh;
    private boolean aOi = false;
    private boolean aOj = false;
    CustomMessageListener aOk = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aSP);
            }
        }
    };
    CustomMessageListener aOl = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.aMH = fVar.aMH;
        this.isLandscape = fVar.aMR;
        this.aOe = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aOf = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aOg = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aMQ);
        this.aOh = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aOg.em(com.baidu.live.ab.a.a(this.mContext, this.aMH, this.isLandscape, false));
        this.aOf.dO(com.baidu.live.ab.a.a(this.mContext, this.aMH, this.isLandscape, false));
        this.aOf.dP(com.baidu.live.ab.a.h(this.aMH, this.isLandscape));
        Ey();
    }

    private void Ey() {
        MessageManager.getInstance().registerListener(this.aOk);
        MessageManager.getInstance().registerListener(this.aOl);
        this.aOe.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aOf.Fl();
                k.this.aOf.Fq();
                k.this.aOg.Fq();
                k.this.aOh.GT();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aSZ;
            if (!z3 || cVar.aSZ || z || !this.aOj || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aSZ || cVar.priority == 1) {
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
            } else if (cVar.aSQ.aNs != null && cVar.aSU >= 2 && !ListUtils.isEmpty(cVar.aSQ.aNs.aOv)) {
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
        if (cVar == null || cVar.aSQ == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.GM().gk(cVar.aSQ.DR());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        Ez();
        this.aOf.h(cVar);
        this.aOf.Fk();
    }

    public void Ez() {
        this.aOg.Ez();
        this.aOh.Ez();
    }

    public void EA() {
        this.aOg.EA();
        this.aOh.EA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aOg.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aOh.e(cVar);
    }

    public void EB() {
        int i = 0;
        if (this.aOe != null) {
            int childCount = this.aOe.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aOe.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aOe.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aOe.removeView((View) arrayList.get(i3));
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
        if (this.aOe != null) {
            int childCount = this.aOe.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aOe.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aOe.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aOe.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aOe.indexOfChild(view) < 0) {
            this.aOe.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aOe.indexOfChild(view) < 0) {
                this.aOe.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        if (!this.aOi) {
            this.aOi = true;
            if (this.aOf != null) {
                this.aOf.onDestroy();
            }
            if (this.aOg != null) {
                this.aOg.onDestroy();
            }
            if (this.aOh != null) {
                this.aOh.onDestroy();
            }
            if (this.aOe != null) {
                this.aOe.clearAnimation();
                this.aOe.setConfigurationChangedListener(null);
                this.aOe.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aOk);
            MessageManager.getInstance().unRegisterListener(this.aOl);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.w
    public View ED() {
        return this.aOe;
    }

    @Override // com.baidu.live.gift.w
    public View EE() {
        return this.aOg.EE();
    }

    @Override // com.baidu.live.gift.w
    public void EF() {
        if (this.aOe != null) {
            this.aOe.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bj(boolean z) {
        this.aOj = z;
        if (this.aOh != null) {
            this.aOh.bj(z);
        }
        if (this.aOf != null) {
            this.aOf.bj(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void EG() {
        if (this.aOh != null) {
            this.aOh.EG();
        }
    }

    @Override // com.baidu.live.gift.w
    public void dL(int i) {
        if (this.aOf != null) {
            this.aOf.dO(i);
        }
        if (this.aOg != null) {
            this.aOg.em(i);
        }
    }

    @Override // com.baidu.live.gift.w
    public void dM(int i) {
        if (this.aOf != null) {
            this.aOf.dP(i);
        }
    }
}
