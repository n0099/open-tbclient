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
/* loaded from: classes3.dex */
public class k implements w {
    public boolean aGc;
    private com.baidu.live.gift.smallgift.a aHA;
    private com.baidu.live.gift.graffitiGift.a aHB;
    private boolean aHC = false;
    private boolean aHD = false;
    CustomMessageListener aHE = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aMh);
            }
        }
    };
    CustomMessageListener aHF = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };
    private AlaGiftShowPanel aHy;
    private com.baidu.live.gift.biggift.a aHz;
    private Context mContext;

    public k(f fVar) {
        this.mContext = fVar.context;
        this.aGc = fVar.aGc;
        this.aHy = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aHz = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aHA = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aGl);
        this.aHB = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        yt();
    }

    private void yt() {
        MessageManager.getInstance().registerListener(this.aHE);
        MessageManager.getInstance().registerListener(this.aHF);
        this.aHy.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aHz.zg();
                k.this.aHz.zl();
                k.this.aHA.zl();
                k.this.aHB.AO();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aMr;
            if (!z3 || cVar.aMr || z || !this.aHD || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aMr || cVar.priority == 1) {
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
            } else if (cVar.aMi.aGM != null && cVar.aMm >= 2 && !ListUtils.isEmpty(cVar.aMi.aGM.aHP)) {
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
        if (cVar == null || cVar.aMi == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.AH().eR(cVar.aMi.xM());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        yu();
        this.aHz.h(cVar);
        this.aHz.zf();
    }

    public void yu() {
        this.aHA.yu();
        this.aHB.yu();
    }

    public void yv() {
        this.aHA.yv();
        this.aHB.yv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aHA.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aHB.e(cVar);
    }

    public void yw() {
        int i = 0;
        if (this.aHy != null) {
            int childCount = this.aHy.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aHy.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aHy.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aHy.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void yx() {
        int i = 0;
        if (this.aHy != null) {
            int childCount = this.aHy.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aHy.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aHy.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aHy.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void J(View view) {
        if (this.aHy.indexOfChild(view) < 0) {
            this.aHy.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aHy.indexOfChild(view) < 0) {
                this.aHy.addView(view, layoutParams);
                return;
            }
            return;
        }
        J(view);
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        if (!this.aHC) {
            this.aHC = true;
            if (this.aHz != null) {
                this.aHz.onDestroy();
            }
            if (this.aHA != null) {
                this.aHA.onDestroy();
            }
            if (this.aHB != null) {
                this.aHB.onDestroy();
            }
            if (this.aHy != null) {
                this.aHy.clearAnimation();
                this.aHy.setConfigurationChangedListener(null);
                this.aHy.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aHE);
            MessageManager.getInstance().unRegisterListener(this.aHF);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.w
    public View yy() {
        return this.aHy;
    }

    @Override // com.baidu.live.gift.w
    public void bb(boolean z) {
        if (this.aHA != null) {
            this.aHA.bb(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bT(int i) {
        if (this.aHA != null) {
            this.aHA.bT(i);
        }
    }

    @Override // com.baidu.live.gift.w
    public View yz() {
        return this.aHA.yz();
    }

    @Override // com.baidu.live.gift.w
    public void yA() {
        if (this.aHy != null) {
            this.aHy.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bc(boolean z) {
        this.aHD = z;
        if (this.aHB != null) {
            this.aHB.bc(z);
        }
        if (this.aHz != null) {
            this.aHz.bc(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void yB() {
        if (this.aHB != null) {
            this.aHB.yB();
        }
    }
}
