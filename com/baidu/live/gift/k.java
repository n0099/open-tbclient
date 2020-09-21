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
public class k implements x {
    public boolean aOB;
    private AlaGiftShowPanel aQf;
    private com.baidu.live.gift.biggift.a aQg;
    private com.baidu.live.gift.smallgift.a aQh;
    private com.baidu.live.gift.graffitiGift.a aQi;
    private boolean aQj = false;
    private boolean aQk = false;
    CustomMessageListener aQl = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aVc);
            }
        }
    };
    CustomMessageListener aQm = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.aOB = fVar.aOB;
        this.isLandscape = fVar.aOL;
        this.aQf = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aQg = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aQh = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aOK);
        this.aQi = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aQh.eq(com.baidu.live.ac.a.a(this.mContext, this.aOB, this.isLandscape, false));
        this.aQg.dS(com.baidu.live.ac.a.a(this.mContext, this.aOB, this.isLandscape, false));
        this.aQg.dT(com.baidu.live.ac.a.h(this.aOB, this.isLandscape));
        EP();
    }

    private void EP() {
        MessageManager.getInstance().registerListener(this.aQl);
        MessageManager.getInstance().registerListener(this.aQm);
        this.aQf.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aQg.FL();
                k.this.aQg.FQ();
                k.this.aQh.FQ();
                k.this.aQi.Ht();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aVn;
            if (!z3 || cVar.aVn || z || !this.aQk || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aVn || cVar.priority == 1) {
                    if (z && cVar.aVh) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.aVh) {
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
                r.g(cVar);
            } else if (cVar.aVd.aPo != null && cVar.aVi >= 2 && !ListUtils.isEmpty(cVar.aVd.aPo.aQw)) {
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
        if (cVar == null || cVar.aVd == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Hn().gv(cVar.aVd.Eh());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        EQ();
        this.aQg.h(cVar);
        this.aQg.FK();
    }

    public void EQ() {
        this.aQh.EQ();
        this.aQi.EQ();
    }

    public void ER() {
        this.aQh.ER();
        this.aQi.ER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aQh.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aQi.e(cVar);
    }

    public void ES() {
        int i = 0;
        if (this.aQf != null) {
            int childCount = this.aQf.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aQf.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aQf.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aQf.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void ET() {
        int i = 0;
        if (this.aQf != null) {
            int childCount = this.aQf.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aQf.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aQf.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aQf.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aQf.indexOfChild(view) < 0) {
            this.aQf.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aQf.indexOfChild(view) < 0) {
                this.aQf.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.x
    public void onDestroy() {
        if (!this.aQj) {
            this.aQj = true;
            if (this.aQg != null) {
                this.aQg.onDestroy();
            }
            if (this.aQh != null) {
                this.aQh.onDestroy();
            }
            if (this.aQi != null) {
                this.aQi.onDestroy();
            }
            if (this.aQf != null) {
                this.aQf.clearAnimation();
                this.aQf.setConfigurationChangedListener(null);
                this.aQf.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aQl);
            MessageManager.getInstance().unRegisterListener(this.aQm);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.x
    public View EU() {
        return this.aQf;
    }

    @Override // com.baidu.live.gift.x
    public View EV() {
        return this.aQh.EV();
    }

    @Override // com.baidu.live.gift.x
    public void EW() {
        if (this.aQf != null) {
            this.aQf.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.x
    public void bk(boolean z) {
        this.aQk = z;
        if (this.aQi != null) {
            this.aQi.bk(z);
        }
        if (this.aQg != null) {
            this.aQg.bk(z);
        }
    }

    @Override // com.baidu.live.gift.x
    public void EX() {
        if (this.aQi != null) {
            this.aQi.EX();
        }
    }

    @Override // com.baidu.live.gift.x
    public void dP(int i) {
        if (this.aQg != null) {
            this.aQg.dS(i);
        }
        if (this.aQh != null) {
            this.aQh.eq(i);
        }
    }

    @Override // com.baidu.live.gift.x
    public void dQ(int i) {
        if (this.aQg != null) {
            this.aQg.dT(i);
        }
    }
}
