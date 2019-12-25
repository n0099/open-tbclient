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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class k implements t {
    private AlaGiftShowPanel ael;
    private com.baidu.live.gift.biggift.a aem;
    private com.baidu.live.gift.smallgift.a aen;
    private com.baidu.live.gift.graffitiGift.a aeo;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aep = false;
    CustomMessageListener aeq = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.b)) {
                com.baidu.live.gift.a.b bVar = (com.baidu.live.gift.a.b) customResponsedMessage.getData();
                k.this.a(bVar, bVar.aiB);
            }
        }
    };
    CustomMessageListener aer = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.b bVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.b) && (bVar = (com.baidu.live.gift.a.b) customResponsedMessage.getData()) != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.giftId)) {
                k.this.d(bVar);
            }
        }
    };

    public k(f fVar) {
        this.mContext = fVar.context;
        this.ael = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aem = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aen = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.adx);
        this.aeo = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        qS();
    }

    private void qS() {
        MessageManager.getInstance().registerListener(this.aeq);
        MessageManager.getInstance().registerListener(this.aer);
        this.ael.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aem.rx();
                k.this.aem.rC();
                k.this.aen.rC();
                k.this.aeo.sT();
            }
        });
    }

    public void a(com.baidu.live.gift.a.b bVar, boolean z) {
        boolean z2 = false;
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.giftId)) {
            boolean z3 = a(bVar) || bVar.aiM;
            if (!z3 || bVar.aiM || z || !this.aep || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!bVar.aiM || bVar.priority == 1) {
                    if (z) {
                        bVar.priority = 9;
                    } else {
                        bVar.priority = 7;
                    }
                }
            } else if (z) {
                bVar.priority = 3;
            } else {
                bVar.priority = 1;
            }
            if (z2 && UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
            }
            if (z2) {
                c(bVar);
            } else if (bVar.aiC.adW != null && bVar.aiH >= 2 && !ListUtils.isEmpty(bVar.aiC.adW.aeB)) {
                e(bVar);
            } else {
                d(bVar);
            }
        }
    }

    public boolean a(com.baidu.live.gift.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        return b(bVar);
    }

    private boolean b(com.baidu.live.gift.a.b bVar) {
        if (bVar == null || bVar.aiC == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.sK().dc(bVar.aiC.qx());
    }

    private void c(com.baidu.live.gift.a.b bVar) {
        qT();
        this.aem.f(bVar);
        this.aem.rw();
    }

    public void qT() {
        this.aen.qT();
        this.aeo.qT();
    }

    public void qU() {
        this.aen.qU();
        this.aeo.qU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.b bVar) {
        this.aen.d(bVar);
    }

    private void e(com.baidu.live.gift.a.b bVar) {
        this.aeo.e(bVar);
    }

    public void qV() {
        int i = 0;
        if (this.ael != null) {
            int childCount = this.ael.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.ael.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.ael.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ael.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void qW() {
        int i = 0;
        if (this.ael != null) {
            int childCount = this.ael.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.ael.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.ael.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ael.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void K(View view) {
        if (this.ael.indexOfChild(view) < 0) {
            this.ael.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.ael.indexOfChild(view) < 0) {
                this.ael.addView(view, layoutParams);
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
            if (this.aem != null) {
                this.aem.onDestroy();
            }
            if (this.aen != null) {
                this.aen.onDestroy();
            }
            if (this.aeo != null) {
                this.aeo.onDestroy();
            }
            if (this.ael != null) {
                this.ael.clearAnimation();
                this.ael.setConfigurationChangedListener(null);
                this.ael.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aeq);
            MessageManager.getInstance().unRegisterListener(this.aer);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.t
    public View qX() {
        return this.ael;
    }

    @Override // com.baidu.live.gift.t
    public void av(boolean z) {
        if (this.aen != null) {
            this.aen.av(z);
        }
    }

    @Override // com.baidu.live.gift.t
    public void bk(int i) {
        if (this.aen != null) {
            this.aen.bk(i);
        }
    }

    @Override // com.baidu.live.gift.t
    public View qY() {
        return this.aen.qY();
    }

    @Override // com.baidu.live.gift.t
    public void qZ() {
        if (this.ael != null) {
            this.ael.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.t
    public void aw(boolean z) {
        this.aep = z;
        if (this.aeo != null) {
            this.aeo.aw(z);
        }
        if (this.aem != null) {
            this.aem.aw(z);
        }
    }

    @Override // com.baidu.live.gift.t
    public void ra() {
        if (this.aeo != null) {
            this.aeo.ra();
        }
    }
}
