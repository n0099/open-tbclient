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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class j implements r {
    private AlaGiftShowPanel WG;
    private com.baidu.live.gift.biggift.a WH;
    private com.baidu.live.gift.smallgift.a WI;
    private com.baidu.live.gift.graffitiGift.a WJ;
    private boolean WK = false;
    private boolean WL = false;
    CustomMessageListener WM = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.d)) {
                com.baidu.live.gift.a.d dVar = (com.baidu.live.gift.a.d) customResponsedMessage.getData();
                j.this.a(dVar, dVar.aay);
            }
        }
    };
    CustomMessageListener WN = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.j.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.d dVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.d) && (dVar = (com.baidu.live.gift.a.d) customResponsedMessage.getData()) != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
                j.this.d(dVar);
                j.this.px();
            }
        }
    };
    private Context mContext;

    public j(f fVar) {
        this.mContext = fVar.context;
        this.WG = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.WH = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.WI = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.VV);
        this.WJ = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        pv();
    }

    private void pv() {
        MessageManager.getInstance().registerListener(this.WM);
        MessageManager.getInstance().registerListener(this.WN);
        this.WG.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.WH.pV();
                j.this.WH.qa();
                j.this.WI.qa();
                j.this.WJ.rj();
            }
        });
    }

    public void a(com.baidu.live.gift.a.d dVar, boolean z) {
        boolean z2 = false;
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            boolean z3 = a(dVar) || dVar.aaJ;
            if (!z3 || dVar.aaJ || z || !this.WL || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!dVar.aaJ || dVar.priority == 1) {
                    if (z) {
                        dVar.priority = 9;
                    } else {
                        dVar.priority = 7;
                    }
                }
            } else if (z) {
                dVar.priority = 3;
            } else {
                dVar.priority = 1;
            }
            if (z2 && UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913024));
            }
            if (z2) {
                c(dVar);
            } else if (dVar.aaz.Wq != null && dVar.aaE >= 2 && !ListUtils.isEmpty(dVar.aaz.Wq.WX)) {
                e(dVar);
            } else {
                d(dVar);
            }
        }
    }

    public boolean a(com.baidu.live.gift.a.d dVar) {
        if (dVar == null) {
            return false;
        }
        return b(dVar);
    }

    private boolean b(com.baidu.live.gift.a.d dVar) {
        if (dVar == null || dVar.aaz == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.rd().ck(dVar.aaz.pc());
    }

    private void c(com.baidu.live.gift.a.d dVar) {
        pw();
        this.WH.f(dVar);
        this.WH.pU();
    }

    public void pw() {
        this.WI.pw();
        this.WJ.pw();
    }

    public void px() {
        this.WI.px();
        this.WJ.px();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.d dVar) {
        this.WI.d(dVar);
    }

    private void e(com.baidu.live.gift.a.d dVar) {
        this.WJ.e(dVar);
    }

    public void py() {
        int i = 0;
        if (this.WG != null) {
            int childCount = this.WG.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.WG.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.WG.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.WG.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void pz() {
        int i = 0;
        if (this.WG != null) {
            int childCount = this.WG.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.WG.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.WG.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.WG.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void J(View view) {
        if (this.WG.indexOfChild(view) < 0) {
            this.WG.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.WG.indexOfChild(view) < 0) {
                this.WG.addView(view, layoutParams);
                return;
            }
            return;
        }
        J(view);
    }

    @Override // com.baidu.live.gift.r
    public void onDestroy() {
        if (!this.WK) {
            this.WK = true;
            if (this.WH != null) {
                this.WH.onDestroy();
            }
            if (this.WI != null) {
                this.WI.onDestroy();
            }
            if (this.WJ != null) {
                this.WJ.onDestroy();
            }
            if (this.WG != null) {
                this.WG.clearAnimation();
                this.WG.setConfigurationChangedListener(null);
                this.WG.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.WM);
            MessageManager.getInstance().unRegisterListener(this.WN);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.r
    public View pA() {
        return this.WG;
    }

    @Override // com.baidu.live.gift.r
    public void ai(boolean z) {
        if (this.WI != null) {
            this.WI.ai(z);
        }
    }

    @Override // com.baidu.live.gift.r
    public void aZ(int i) {
        if (this.WI != null) {
            this.WI.aZ(i);
        }
    }

    @Override // com.baidu.live.gift.r
    public View pB() {
        return this.WI.pB();
    }

    @Override // com.baidu.live.gift.r
    public void pC() {
        if (this.WG != null) {
            this.WG.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.r
    public void aj(boolean z) {
        this.WL = z;
        if (this.WJ != null) {
            this.WJ.aj(z);
        }
        if (this.WH != null) {
            this.WH.aj(z);
        }
    }
}
