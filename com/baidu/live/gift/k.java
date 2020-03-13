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
public class k implements u {
    private AlaGiftShowPanel ahb;
    private com.baidu.live.gift.biggift.a ahc;
    private com.baidu.live.gift.smallgift.a ahd;
    private com.baidu.live.gift.graffitiGift.a ahe;
    private Context mContext;
    private boolean isDestroyed = false;
    private boolean ahf = false;
    CustomMessageListener ahg = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.alw);
            }
        }
    };
    CustomMessageListener ahh = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
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
        this.ahb = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.ahc = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.ahd = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.afP);
        this.ahe = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        sf();
    }

    private void sf() {
        MessageManager.getInstance().registerListener(this.ahg);
        MessageManager.getInstance().registerListener(this.ahh);
        this.ahb.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.ahc.sV();
                k.this.ahc.ta();
                k.this.ahd.ta();
                k.this.ahe.uB();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.alG;
            if (!z3 || cVar.alG || z || !this.ahf || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.alG || cVar.priority == 1) {
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
            } else if (cVar.alx.ags != null && cVar.alB >= 2 && !ListUtils.isEmpty(cVar.alx.ags.ahr)) {
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
        if (cVar == null || cVar.alx == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.uu().mo19do(cVar.alx.rx());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        sg();
        this.ahc.f(cVar);
        this.ahc.sU();
    }

    public void sg() {
        this.ahd.sg();
        this.ahe.sg();
    }

    public void sh() {
        this.ahd.sh();
        this.ahe.sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.ahd.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.ahe.e(cVar);
    }

    public void si() {
        int i = 0;
        if (this.ahb != null) {
            int childCount = this.ahb.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.ahb.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.ahb.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ahb.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void sj() {
        int i = 0;
        if (this.ahb != null) {
            int childCount = this.ahb.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.ahb.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.ahb.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.ahb.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void K(View view) {
        if (this.ahb.indexOfChild(view) < 0) {
            this.ahb.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.ahb.indexOfChild(view) < 0) {
                this.ahb.addView(view, layoutParams);
                return;
            }
            return;
        }
        K(view);
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            if (this.ahc != null) {
                this.ahc.onDestroy();
            }
            if (this.ahd != null) {
                this.ahd.onDestroy();
            }
            if (this.ahe != null) {
                this.ahe.onDestroy();
            }
            if (this.ahb != null) {
                this.ahb.clearAnimation();
                this.ahb.setConfigurationChangedListener(null);
                this.ahb.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.ahg);
            MessageManager.getInstance().unRegisterListener(this.ahh);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.u
    public View sk() {
        return this.ahb;
    }

    @Override // com.baidu.live.gift.u
    public void ay(boolean z) {
        if (this.ahd != null) {
            this.ahd.ay(z);
        }
    }

    @Override // com.baidu.live.gift.u
    public void br(int i) {
        if (this.ahd != null) {
            this.ahd.br(i);
        }
    }

    @Override // com.baidu.live.gift.u
    public View sl() {
        return this.ahd.sl();
    }

    @Override // com.baidu.live.gift.u
    public void sm() {
        if (this.ahb != null) {
            this.ahb.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.u
    public void az(boolean z) {
        this.ahf = z;
        if (this.ahe != null) {
            this.ahe.az(z);
        }
        if (this.ahc != null) {
            this.ahc.az(z);
        }
    }

    @Override // com.baidu.live.gift.u
    public void sn() {
        if (this.ahe != null) {
            this.ahe.sn();
        }
    }
}
