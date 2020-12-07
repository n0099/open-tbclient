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
public class j implements ad {
    public boolean aVr;
    private AlaGiftShowPanel aWY;
    private com.baidu.live.gift.biggift.a aWZ;
    private com.baidu.live.gift.smallgift.a aXa;
    private com.baidu.live.gift.graffitiGift.a aXb;
    private boolean aXc = false;
    private boolean aXd = false;
    CustomMessageListener aXe = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.bcM);
            }
        }
    };
    CustomMessageListener aXf = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                j.this.d(cVar);
            }
        }
    };
    public boolean isLandscape;
    private Context mContext;

    public j(f fVar) {
        this.mContext = fVar.context;
        this.aVr = fVar.aVr;
        this.isLandscape = fVar.aVB;
        this.aWY = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aWZ = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aXa = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aVA);
        this.aXb = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aXa.eN(com.baidu.live.ak.a.a(this.mContext, this.aVr, this.isLandscape, false));
        this.aWZ.eo(com.baidu.live.ak.a.a(this.mContext, this.aVr, this.isLandscape, false));
        this.aWZ.ep(com.baidu.live.ak.a.h(this.aVr, this.isLandscape));
        HH();
    }

    private void HH() {
        MessageManager.getInstance().registerListener(this.aXe);
        MessageManager.getInstance().registerListener(this.aXf);
        this.aWY.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aWZ.IM();
                j.this.aWZ.IR();
                j.this.aXa.IR();
                j.this.aXb.KB();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bda || cVar.bdc;
            if (!z3 || cVar.bda || z || !this.aXd || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bda || cVar.priority == 1) {
                    if (z && cVar.bcS) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.bcS) {
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
            } else if (cVar.bcN.aWg != null && cVar.bcU >= 2 && !ListUtils.isEmpty(cVar.bcN.aWg.aXp)) {
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
        if (cVar == null || cVar.bcN == null) {
            return false;
        }
        return com.baidu.live.gift.c.b.Kv().hm(cVar.bcN.GX());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        HI();
        this.aWZ.h(cVar);
        this.aWZ.IL();
    }

    public void HI() {
        this.aXa.HI();
        this.aXb.HI();
    }

    public void HJ() {
        this.aXa.HJ();
        this.aXb.HJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aXa.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aXb.e(cVar);
    }

    public void HK() {
        int i = 0;
        if (this.aWY != null) {
            int childCount = this.aWY.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aWY.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aWY.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aWY.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void HL() {
        int i = 0;
        if (this.aWY != null) {
            int childCount = this.aWY.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aWY.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aWY.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aWY.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aWY.indexOfChild(view) < 0) {
            this.aWY.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aWY.indexOfChild(view) < 0) {
                this.aWY.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ad
    public void onDestroy() {
        if (!this.aXc) {
            this.aXc = true;
            if (this.aWZ != null) {
                this.aWZ.onDestroy();
            }
            if (this.aXa != null) {
                this.aXa.onDestroy();
            }
            if (this.aXb != null) {
                this.aXb.onDestroy();
            }
            if (this.aWY != null) {
                this.aWY.clearAnimation();
                this.aWY.setConfigurationChangedListener(null);
                this.aWY.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aXe);
            MessageManager.getInstance().unRegisterListener(this.aXf);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View HM() {
        return this.aWY;
    }

    @Override // com.baidu.live.gift.ad
    public View HN() {
        return this.aXa.HN();
    }

    @Override // com.baidu.live.gift.ad
    public void HO() {
        if (this.aWY != null) {
            this.aWY.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bC(boolean z) {
        this.aXd = z;
        if (this.aXb != null) {
            this.aXb.bC(z);
        }
        if (this.aWZ != null) {
            this.aWZ.bC(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void HP() {
        if (this.aXb != null) {
            this.aXb.HP();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void ek(int i) {
        if (this.aWZ != null) {
            this.aWZ.eo(i);
        }
        if (this.aXa != null) {
            this.aXa.eN(i);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void el(int i) {
        if (this.aWZ != null) {
            this.aWZ.ep(i);
        }
    }
}
