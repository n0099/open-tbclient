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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k implements w {
    public boolean aDG;
    private AlaGiftShowPanel aFc;
    private com.baidu.live.gift.biggift.a aFd;
    private com.baidu.live.gift.smallgift.a aFe;
    private com.baidu.live.gift.graffitiGift.a aFf;
    private boolean aFg = false;
    private boolean aFh = false;
    CustomMessageListener aFi = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aJB);
            }
        }
    };
    CustomMessageListener aFj = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };
    private Context mContext;

    public k(f fVar) {
        this.mContext = fVar.context;
        this.aDG = fVar.aDG;
        this.aFc = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aFd = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aFe = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aDP);
        this.aFf = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        xT();
    }

    private void xT() {
        MessageManager.getInstance().registerListener(this.aFi);
        MessageManager.getInstance().registerListener(this.aFj);
        this.aFc.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aFd.yG();
                k.this.aFd.yL();
                k.this.aFe.yL();
                k.this.aFf.Ao();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aJL;
            if (!z3 || cVar.aJL || z || !this.aFh || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aJL || cVar.priority == 1) {
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
            } else if (cVar.aJC.aEq != null && cVar.aJG >= 2 && !ListUtils.isEmpty(cVar.aJC.aEq.aFt)) {
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
        if (cVar == null || cVar.aJC == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Ah().eL(cVar.aJC.xl());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        xU();
        this.aFd.h(cVar);
        this.aFd.yF();
    }

    public void xU() {
        this.aFe.xU();
        this.aFf.xU();
    }

    public void xV() {
        this.aFe.xV();
        this.aFf.xV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aFe.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aFf.e(cVar);
    }

    public void xW() {
        int i = 0;
        if (this.aFc != null) {
            int childCount = this.aFc.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aFc.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aFc.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aFc.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void xX() {
        int i = 0;
        if (this.aFc != null) {
            int childCount = this.aFc.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aFc.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aFc.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aFc.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void L(View view) {
        if (this.aFc.indexOfChild(view) < 0) {
            this.aFc.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aFc.indexOfChild(view) < 0) {
                this.aFc.addView(view, layoutParams);
                return;
            }
            return;
        }
        L(view);
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        if (!this.aFg) {
            this.aFg = true;
            if (this.aFd != null) {
                this.aFd.onDestroy();
            }
            if (this.aFe != null) {
                this.aFe.onDestroy();
            }
            if (this.aFf != null) {
                this.aFf.onDestroy();
            }
            if (this.aFc != null) {
                this.aFc.clearAnimation();
                this.aFc.setConfigurationChangedListener(null);
                this.aFc.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aFi);
            MessageManager.getInstance().unRegisterListener(this.aFj);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.w
    public View xY() {
        return this.aFc;
    }

    @Override // com.baidu.live.gift.w
    public void bb(boolean z) {
        if (this.aFe != null) {
            this.aFe.bb(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bL(int i) {
        if (this.aFe != null) {
            this.aFe.bL(i);
        }
    }

    @Override // com.baidu.live.gift.w
    public View xZ() {
        return this.aFe.xZ();
    }

    @Override // com.baidu.live.gift.w
    public void ya() {
        if (this.aFc != null) {
            this.aFc.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bc(boolean z) {
        this.aFh = z;
        if (this.aFf != null) {
            this.aFf.bc(z);
        }
        if (this.aFd != null) {
            this.aFd.bc(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void yb() {
        if (this.aFf != null) {
            this.aFf.yb();
        }
    }
}
