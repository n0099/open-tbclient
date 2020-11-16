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
    public boolean aSp;
    private AlaGiftShowPanel aTT;
    private com.baidu.live.gift.biggift.a aTU;
    private com.baidu.live.gift.smallgift.a aTV;
    private com.baidu.live.gift.graffitiGift.a aTW;
    private boolean aTX = false;
    private boolean aTY = false;
    CustomMessageListener aTZ = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                j.this.a(cVar, cVar.aZp);
            }
        }
    };
    CustomMessageListener aUa = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
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
        this.aSp = fVar.aSp;
        this.isLandscape = fVar.aSz;
        this.aTT = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.gift_popshow_contain_layout, (ViewGroup) null);
        this.aTU = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aTV = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aSy);
        this.aTW = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        this.aTV.es(com.baidu.live.ag.a.a(this.mContext, this.aSp, this.isLandscape, false));
        this.aTU.dU(com.baidu.live.ag.a.a(this.mContext, this.aSp, this.isLandscape, false));
        this.aTU.dV(com.baidu.live.ag.a.h(this.aSp, this.isLandscape));
        FS();
    }

    private void FS() {
        MessageManager.getInstance().registerListener(this.aTZ);
        MessageManager.getInstance().registerListener(this.aUa);
        this.aTT.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.aTU.GV();
                j.this.aTU.Ha();
                j.this.aTV.Ha();
                j.this.aTW.IB();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZB || cVar.aZD;
            if (!z3 || cVar.aZB || z || !this.aTY || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZB || cVar.priority == 1) {
                    if (z && cVar.aZu) {
                        cVar.priority = 11;
                    } else if (z) {
                        cVar.priority = 7;
                    } else if (cVar.aZu) {
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
            } else if (cVar.aZq.aTc != null && cVar.aZw >= 2 && !ListUtils.isEmpty(cVar.aZq.aTc.aUk)) {
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
        if (cVar == null || cVar.aZq == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Iv().gR(cVar.aZq.Fk());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        FT();
        this.aTU.h(cVar);
        this.aTU.GU();
    }

    public void FT() {
        this.aTV.FT();
        this.aTW.FT();
    }

    public void FU() {
        this.aTV.FU();
        this.aTW.FU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aTV.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aTW.e(cVar);
    }

    public void FV() {
        int i = 0;
        if (this.aTT != null) {
            int childCount = this.aTT.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aTT.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aTT.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTT.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void FW() {
        int i = 0;
        if (this.aTT != null) {
            int childCount = this.aTT.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aTT.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aTT.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aTT.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aTT.indexOfChild(view) < 0) {
            this.aTT.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aTT.indexOfChild(view) < 0) {
                this.aTT.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        if (!this.aTX) {
            this.aTX = true;
            if (this.aTU != null) {
                this.aTU.onDestroy();
            }
            if (this.aTV != null) {
                this.aTV.onDestroy();
            }
            if (this.aTW != null) {
                this.aTW.onDestroy();
            }
            if (this.aTT != null) {
                this.aTT.clearAnimation();
                this.aTT.setConfigurationChangedListener(null);
                this.aTT.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aTZ);
            MessageManager.getInstance().unRegisterListener(this.aUa);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ab
    public View FX() {
        return this.aTT;
    }

    @Override // com.baidu.live.gift.ab
    public View FY() {
        return this.aTV.FY();
    }

    @Override // com.baidu.live.gift.ab
    public void FZ() {
        if (this.aTT != null) {
            this.aTT.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void bt(boolean z) {
        this.aTY = z;
        if (this.aTW != null) {
            this.aTW.bt(z);
        }
        if (this.aTU != null) {
            this.aTU.bt(z);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void Ga() {
        if (this.aTW != null) {
            this.aTW.Ga();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dQ(int i) {
        if (this.aTU != null) {
            this.aTU.dU(i);
        }
        if (this.aTV != null) {
            this.aTV.es(i);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dR(int i) {
        if (this.aTU != null) {
            this.aTU.dV(i);
        }
    }
}
