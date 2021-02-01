package com.baidu.live.gift;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
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
    public boolean aVn;
    private AlaGiftShowPanel aWW;
    private com.baidu.live.gift.biggift.a aWX;
    private com.baidu.live.gift.smallgift.a aWY;
    private com.baidu.live.gift.graffitiGift.a aWZ;
    public boolean isLandscape;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aXa = false;
    CustomMessageListener aXb = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.bcN);
            }
        }
    };
    CustomMessageListener aXc = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                j.this.d(cVar);
            }
        }
    };
    private CustomMessageListener aDm = new CustomMessageListener(2913300) { // from class: com.baidu.live.gift.j.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            int i2;
            int i3 = 0;
            Log.i("memoryMonitor", "@@ memoryMonitor AlaGiftViewPanelController @memoryMonitorCleanListener");
            if (j.this.aWX != null) {
                i = j.this.aWX.getCacheSize();
                j.this.aWX.clearCache();
            } else {
                i = 0;
            }
            if (j.this.aWY != null) {
                i2 = j.this.aWY.getCacheSize();
                j.this.aWY.clearCache();
            } else {
                i2 = 0;
            }
            if (j.this.aWZ != null) {
                i3 = j.this.aWZ.getCacheSize();
                j.this.aWZ.clearCache();
            }
            Log.i("memoryMonitor", "@@ memoryMonitor AlaGiftViewPanelController @memoryMonitorCleanListener bigSize=" + i + ", smallSize=" + i2 + ", graffitiSize=" + i3);
        }
    };

    public j(f fVar) {
        this.mContext = fVar.context;
        this.aVn = fVar.aVn;
        this.isLandscape = fVar.aVy;
        this.aWW = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aWX = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aWY = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aVx);
        this.aWZ = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aWY.dk(com.baidu.live.aj.a.b(this.mContext, this.aVn, this.isLandscape, false));
        this.aWX.cL(com.baidu.live.aj.a.b(this.mContext, this.aVn, this.isLandscape, false));
        this.aWX.cM(com.baidu.live.aj.a.i(this.aVn, this.isLandscape));
        ED();
    }

    private void ED() {
        MessageManager.getInstance().registerListener(this.aXb);
        MessageManager.getInstance().registerListener(this.aXc);
        MessageManager.getInstance().registerListener(this.aDm);
        this.aWW.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aWX.FI();
                j.this.aWX.FN();
                j.this.aWY.FN();
                j.this.aWZ.Hx();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bcZ || cVar.bdb;
            if (!z3 || cVar.bcZ || z || !this.aXa || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bcZ || cVar.priority == 1) {
                    if (z && cVar.bcR) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 9;
                    } else if (cVar.bcR) {
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
            } else if (cVar.bcO.aWe != null && cVar.bcT >= 2 && !ListUtils.isEmpty(cVar.bcO.aWe.aXm)) {
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
        if (cVar == null || cVar.bcO == null) {
            return false;
        }
        return com.baidu.live.gift.c.b.Hr().gg(cVar.bcO.DR());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        EE();
        this.aWX.h(cVar);
        this.aWX.i(cVar);
    }

    public void EE() {
        this.aWY.EE();
        this.aWZ.EE();
    }

    public void EF() {
        this.aWY.EF();
        this.aWZ.EF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aWY.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aWZ.e(cVar);
    }

    public void EG() {
        int i = 0;
        if (this.aWW != null) {
            int childCount = this.aWW.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aWW.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aWW.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aWW.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void EH() {
        int i = 0;
        if (this.aWW != null) {
            int childCount = this.aWW.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aWW.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aWW.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aWW.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aWW.indexOfChild(view) < 0) {
            this.aWW.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aWW.indexOfChild(view) < 0) {
                this.aWW.addView(view, layoutParams);
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
            if (this.aWX != null) {
                this.aWX.onDestroy();
            }
            if (this.aWY != null) {
                this.aWY.onDestroy();
            }
            if (this.aWZ != null) {
                this.aWZ.onDestroy();
            }
            if (this.aWW != null) {
                this.aWW.clearAnimation();
                this.aWW.setConfigurationChangedListener(null);
                this.aWW.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aXb);
            MessageManager.getInstance().unRegisterListener(this.aXc);
            MessageManager.getInstance().unRegisterListener(this.aDm);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View EI() {
        return this.aWW;
    }

    @Override // com.baidu.live.gift.ad
    public View EJ() {
        return this.aWY.EJ();
    }

    @Override // com.baidu.live.gift.ad
    public void EK() {
        if (this.aWW != null) {
            this.aWW.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bB(boolean z) {
        this.aXa = z;
        if (this.aWZ != null) {
            this.aWZ.bB(z);
        }
        if (this.aWX != null) {
            this.aWX.bB(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void EL() {
        if (this.aWZ != null) {
            this.aWZ.EL();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cH(int i) {
        if (this.aWX != null) {
            this.aWX.cL(i);
        }
        if (this.aWY != null) {
            this.aWY.dk(i);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cI(int i) {
        if (this.aWX != null) {
            this.aWX.cM(i);
        }
    }
}
