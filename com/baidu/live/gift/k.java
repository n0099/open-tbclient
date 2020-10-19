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
    public boolean aRM;
    private AlaGiftShowPanel aTq;
    private com.baidu.live.gift.biggift.a aTr;
    private com.baidu.live.gift.smallgift.a aTs;
    private com.baidu.live.gift.graffitiGift.a aTt;
    private boolean aTu = false;
    private boolean aTv = false;
    CustomMessageListener aTw = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aYn);
            }
        }
    };
    CustomMessageListener aTx = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.aRM = fVar.aRM;
        this.isLandscape = fVar.aRW;
        this.aTq = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aTr = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aTs = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aRV);
        this.aTt = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aTs.ev(com.baidu.live.ac.a.a(this.mContext, this.aRM, this.isLandscape, false));
        this.aTr.dX(com.baidu.live.ac.a.a(this.mContext, this.aRM, this.isLandscape, false));
        this.aTr.dY(com.baidu.live.ac.a.h(this.aRM, this.isLandscape));
        FL();
    }

    private void FL() {
        MessageManager.getInstance().registerListener(this.aTw);
        MessageManager.getInstance().registerListener(this.aTx);
        this.aTq.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aTr.GH();
                k.this.aTr.GM();
                k.this.aTs.GM();
                k.this.aTt.Iq();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aYy;
            if (!z3 || cVar.aYy || z || !this.aTv || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aYy || cVar.priority == 1) {
                    if (z && cVar.aYs) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.aYs) {
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
            } else if (cVar.aYo.aSz != null && cVar.aYt >= 2 && !ListUtils.isEmpty(cVar.aYo.aSz.aTH)) {
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
        if (cVar == null || cVar.aYo == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Ik().gJ(cVar.aYo.Fd());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        FM();
        this.aTr.h(cVar);
        this.aTr.GG();
    }

    public void FM() {
        this.aTs.FM();
        this.aTt.FM();
    }

    public void FN() {
        this.aTs.FN();
        this.aTt.FN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aTs.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aTt.e(cVar);
    }

    public void FO() {
        int i = 0;
        if (this.aTq != null) {
            int childCount = this.aTq.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aTq.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aTq.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTq.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void FP() {
        int i = 0;
        if (this.aTq != null) {
            int childCount = this.aTq.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aTq.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aTq.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTq.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aTq.indexOfChild(view) < 0) {
            this.aTq.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aTq.indexOfChild(view) < 0) {
                this.aTq.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.x
    public void onDestroy() {
        if (!this.aTu) {
            this.aTu = true;
            if (this.aTr != null) {
                this.aTr.onDestroy();
            }
            if (this.aTs != null) {
                this.aTs.onDestroy();
            }
            if (this.aTt != null) {
                this.aTt.onDestroy();
            }
            if (this.aTq != null) {
                this.aTq.clearAnimation();
                this.aTq.setConfigurationChangedListener(null);
                this.aTq.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aTw);
            MessageManager.getInstance().unRegisterListener(this.aTx);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.x
    public View FQ() {
        return this.aTq;
    }

    @Override // com.baidu.live.gift.x
    public View FR() {
        return this.aTs.FR();
    }

    @Override // com.baidu.live.gift.x
    public void FS() {
        if (this.aTq != null) {
            this.aTq.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.x
    public void bo(boolean z) {
        this.aTv = z;
        if (this.aTt != null) {
            this.aTt.bo(z);
        }
        if (this.aTr != null) {
            this.aTr.bo(z);
        }
    }

    @Override // com.baidu.live.gift.x
    public void FT() {
        if (this.aTt != null) {
            this.aTt.FT();
        }
    }

    @Override // com.baidu.live.gift.x
    public void dU(int i) {
        if (this.aTr != null) {
            this.aTr.dX(i);
        }
        if (this.aTs != null) {
            this.aTs.ev(i);
        }
    }

    @Override // com.baidu.live.gift.x
    public void dV(int i) {
        if (this.aTr != null) {
            this.aTr.dY(i);
        }
    }
}
