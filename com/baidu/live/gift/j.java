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
/* loaded from: classes10.dex */
public class j implements ad {
    public boolean aWN;
    private AlaGiftShowPanel aYw;
    private com.baidu.live.gift.biggift.a aYx;
    private com.baidu.live.gift.smallgift.a aYy;
    private com.baidu.live.gift.graffitiGift.a aYz;
    public boolean isLandscape;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean aYA = false;
    CustomMessageListener aYB = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.beo);
            }
        }
    };
    CustomMessageListener aYC = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                j.this.d(cVar);
            }
        }
    };
    private CustomMessageListener aEM = new CustomMessageListener(2913300) { // from class: com.baidu.live.gift.j.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            int i2;
            int i3 = 0;
            Log.i("memoryMonitor", "@@ memoryMonitor AlaGiftViewPanelController @memoryMonitorCleanListener");
            if (j.this.aYx != null) {
                i = j.this.aYx.getCacheSize();
                j.this.aYx.clearCache();
            } else {
                i = 0;
            }
            if (j.this.aYy != null) {
                i2 = j.this.aYy.getCacheSize();
                j.this.aYy.clearCache();
            } else {
                i2 = 0;
            }
            if (j.this.aYz != null) {
                i3 = j.this.aYz.getCacheSize();
                j.this.aYz.clearCache();
            }
            Log.i("memoryMonitor", "@@ memoryMonitor AlaGiftViewPanelController @memoryMonitorCleanListener bigSize=" + i + ", smallSize=" + i2 + ", graffitiSize=" + i3);
        }
    };

    public j(f fVar) {
        this.mContext = fVar.context;
        this.aWN = fVar.aWN;
        this.isLandscape = fVar.aWY;
        this.aYw = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aYx = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aYy = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aWX);
        this.aYz = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aYy.dl(com.baidu.live.aj.a.a(this.mContext, this.aWN, this.isLandscape, false));
        this.aYx.cM(com.baidu.live.aj.a.a(this.mContext, this.aWN, this.isLandscape, false));
        this.aYx.cN(com.baidu.live.aj.a.i(this.aWN, this.isLandscape));
        EG();
    }

    private void EG() {
        MessageManager.getInstance().registerListener(this.aYB);
        MessageManager.getInstance().registerListener(this.aYC);
        MessageManager.getInstance().registerListener(this.aEM);
        this.aYw.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aYx.FL();
                j.this.aYx.FQ();
                j.this.aYy.FQ();
                j.this.aYz.HA();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.beB || cVar.beD;
            if (!z3 || cVar.beB || z || !this.aYA || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.beB || cVar.priority == 1) {
                    if (z && cVar.bes) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 9;
                    } else if (cVar.bes) {
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
            } else if (cVar.bep.aXE != null && cVar.bev >= 2 && !ListUtils.isEmpty(cVar.bep.aXE.aYM)) {
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
        if (cVar == null || cVar.bep == null) {
            return false;
        }
        return com.baidu.live.gift.c.b.Hu().gm(cVar.bep.DU());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        EH();
        this.aYx.h(cVar);
        this.aYx.i(cVar);
    }

    public void EH() {
        this.aYy.EH();
        this.aYz.EH();
    }

    public void EI() {
        this.aYy.EI();
        this.aYz.EI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aYy.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aYz.e(cVar);
    }

    public void EJ() {
        int i = 0;
        if (this.aYw != null) {
            int childCount = this.aYw.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aYw.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aYw.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aYw.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void EK() {
        int i = 0;
        if (this.aYw != null) {
            int childCount = this.aYw.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aYw.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aYw.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aYw.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aYw.indexOfChild(view) < 0) {
            this.aYw.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aYw.indexOfChild(view) < 0) {
                this.aYw.addView(view, layoutParams);
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
            if (this.aYx != null) {
                this.aYx.onDestroy();
            }
            if (this.aYy != null) {
                this.aYy.onDestroy();
            }
            if (this.aYz != null) {
                this.aYz.onDestroy();
            }
            if (this.aYw != null) {
                this.aYw.clearAnimation();
                this.aYw.setConfigurationChangedListener(null);
                this.aYw.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aYB);
            MessageManager.getInstance().unRegisterListener(this.aYC);
            MessageManager.getInstance().unRegisterListener(this.aEM);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View EL() {
        return this.aYw;
    }

    @Override // com.baidu.live.gift.ad
    public View EM() {
        return this.aYy.EM();
    }

    @Override // com.baidu.live.gift.ad
    public void EN() {
        if (this.aYw != null) {
            this.aYw.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bB(boolean z) {
        this.aYA = z;
        if (this.aYz != null) {
            this.aYz.bB(z);
        }
        if (this.aYx != null) {
            this.aYx.bB(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void EO() {
        if (this.aYz != null) {
            this.aYz.EO();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cI(int i) {
        if (this.aYx != null) {
            this.aYx.cM(i);
        }
        if (this.aYy != null) {
            this.aYy.dl(i);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cJ(int i) {
        if (this.aYx != null) {
            this.aYx.cN(i);
        }
    }
}
