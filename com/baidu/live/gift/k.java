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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class k implements t {
    private AlaGiftShowPanel aeU;
    private com.baidu.live.gift.biggift.a aeV;
    private com.baidu.live.gift.smallgift.a aeW;
    private com.baidu.live.gift.graffitiGift.a aeX;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aeY = false;
    CustomMessageListener aeZ = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.ajn);
            }
        }
    };
    CustomMessageListener afa = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.aeU = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aeV = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aeW = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.adM);
        this.aeX = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        re();
    }

    private void re() {
        MessageManager.getInstance().registerListener(this.aeZ);
        MessageManager.getInstance().registerListener(this.afa);
        this.aeU.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aeV.rK();
                k.this.aeV.rP();
                k.this.aeW.rP();
                k.this.aeX.tj();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.ajx;
            if (!z3 || cVar.ajx || z || !this.aeY || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.ajx || cVar.priority == 1) {
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
            } else if (cVar.ajo.ael != null && cVar.ajs >= 2 && !ListUtils.isEmpty(cVar.ajo.ael.afk)) {
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
        if (cVar == null || cVar.ajo == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.ta().de(cVar.ajo.qE());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        rf();
        this.aeV.f(cVar);
        this.aeV.rJ();
    }

    public void rf() {
        this.aeW.rf();
        this.aeX.rf();
    }

    public void rg() {
        this.aeW.rg();
        this.aeX.rg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aeW.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aeX.e(cVar);
    }

    public void rh() {
        int i = 0;
        if (this.aeU != null) {
            int childCount = this.aeU.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aeU.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aeU.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aeU.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void ri() {
        int i = 0;
        if (this.aeU != null) {
            int childCount = this.aeU.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aeU.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aeU.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aeU.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void K(View view) {
        if (this.aeU.indexOfChild(view) < 0) {
            this.aeU.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aeU.indexOfChild(view) < 0) {
                this.aeU.addView(view, layoutParams);
                return;
            }
            return;
        }
        K(view);
    }

    @Override // com.baidu.live.gift.t
    public void onDestroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            if (this.aeV != null) {
                this.aeV.onDestroy();
            }
            if (this.aeW != null) {
                this.aeW.onDestroy();
            }
            if (this.aeX != null) {
                this.aeX.onDestroy();
            }
            if (this.aeU != null) {
                this.aeU.clearAnimation();
                this.aeU.setConfigurationChangedListener(null);
                this.aeU.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aeZ);
            MessageManager.getInstance().unRegisterListener(this.afa);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.t
    public View rj() {
        return this.aeU;
    }

    @Override // com.baidu.live.gift.t
    public void av(boolean z) {
        if (this.aeW != null) {
            this.aeW.av(z);
        }
    }

    @Override // com.baidu.live.gift.t
    public void bk(int i) {
        if (this.aeW != null) {
            this.aeW.bk(i);
        }
    }

    @Override // com.baidu.live.gift.t
    public View rk() {
        return this.aeW.rk();
    }

    @Override // com.baidu.live.gift.t
    public void rl() {
        if (this.aeU != null) {
            this.aeU.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.t
    public void aw(boolean z) {
        this.aeY = z;
        if (this.aeX != null) {
            this.aeX.aw(z);
        }
        if (this.aeV != null) {
            this.aeV.aw(z);
        }
    }

    @Override // com.baidu.live.gift.t
    public void rm() {
        if (this.aeX != null) {
            this.aeX.rm();
        }
    }
}
