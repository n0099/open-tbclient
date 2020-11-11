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
public class j implements ab {
    public boolean aUa;
    private AlaGiftShowPanel aVE;
    private com.baidu.live.gift.biggift.a aVF;
    private com.baidu.live.gift.smallgift.a aVG;
    private com.baidu.live.gift.graffitiGift.a aVH;
    private boolean aVI = false;
    private boolean aVJ = false;
    CustomMessageListener aVK = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.bbb);
            }
        }
    };
    CustomMessageListener aVL = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
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
        this.aUa = fVar.aUa;
        this.isLandscape = fVar.aUk;
        this.aVE = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aVF = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aVG = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aUj);
        this.aVH = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aVG.ew(com.baidu.live.ag.a.a(this.mContext, this.aUa, this.isLandscape, false));
        this.aVF.dY(com.baidu.live.ag.a.a(this.mContext, this.aUa, this.isLandscape, false));
        this.aVF.dZ(com.baidu.live.ag.a.h(this.aUa, this.isLandscape));
        GB();
    }

    private void GB() {
        MessageManager.getInstance().registerListener(this.aVK);
        MessageManager.getInstance().registerListener(this.aVL);
        this.aVE.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aVF.HE();
                j.this.aVF.HJ();
                j.this.aVG.HJ();
                j.this.aVH.Jk();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bbn || cVar.bbp;
            if (!z3 || cVar.bbn || z || !this.aVJ || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bbn || cVar.priority == 1) {
                    if (z && cVar.bbg) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.bbg) {
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
                v.g(cVar);
            } else if (cVar.bbc.aUN != null && cVar.bbi >= 2 && !ListUtils.isEmpty(cVar.bbc.aUN.aVV)) {
                e(cVar);
                v.g(cVar);
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
        if (cVar == null || cVar.bbc == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Je().gX(cVar.bbc.FT());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        GC();
        this.aVF.h(cVar);
        this.aVF.HD();
    }

    public void GC() {
        this.aVG.GC();
        this.aVH.GC();
    }

    public void GD() {
        this.aVG.GD();
        this.aVH.GD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aVG.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aVH.e(cVar);
    }

    public void GE() {
        int i = 0;
        if (this.aVE != null) {
            int childCount = this.aVE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aVE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aVE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aVE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void GF() {
        int i = 0;
        if (this.aVE != null) {
            int childCount = this.aVE.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aVE.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aVE.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aVE.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aVE.indexOfChild(view) < 0) {
            this.aVE.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aVE.indexOfChild(view) < 0) {
                this.aVE.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        if (!this.aVI) {
            this.aVI = true;
            if (this.aVF != null) {
                this.aVF.onDestroy();
            }
            if (this.aVG != null) {
                this.aVG.onDestroy();
            }
            if (this.aVH != null) {
                this.aVH.onDestroy();
            }
            if (this.aVE != null) {
                this.aVE.clearAnimation();
                this.aVE.setConfigurationChangedListener(null);
                this.aVE.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aVK);
            MessageManager.getInstance().unRegisterListener(this.aVL);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ab
    public View GG() {
        return this.aVE;
    }

    @Override // com.baidu.live.gift.ab
    public View GH() {
        return this.aVG.GH();
    }

    @Override // com.baidu.live.gift.ab
    public void GI() {
        if (this.aVE != null) {
            this.aVE.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void br(boolean z) {
        this.aVJ = z;
        if (this.aVH != null) {
            this.aVH.br(z);
        }
        if (this.aVF != null) {
            this.aVF.br(z);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void GJ() {
        if (this.aVH != null) {
            this.aVH.GJ();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dU(int i) {
        if (this.aVF != null) {
            this.aVF.dY(i);
        }
        if (this.aVG != null) {
            this.aVG.ew(i);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dV(int i) {
        if (this.aVF != null) {
            this.aVF.dZ(i);
        }
    }
}
