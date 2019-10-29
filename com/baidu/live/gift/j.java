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
    private AlaGiftShowPanel WZ;
    private com.baidu.live.gift.biggift.a Xa;
    private com.baidu.live.gift.smallgift.a Xb;
    private com.baidu.live.gift.graffitiGift.a Xc;
    private boolean Xd = false;
    private boolean Xe = false;
    CustomMessageListener Xf = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.j.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.d)) {
                com.baidu.live.gift.a.d dVar = (com.baidu.live.gift.a.d) customResponsedMessage.getData();
                j.this.a(dVar, dVar.aaQ);
            }
        }
    };
    private Context mContext;

    public j(f fVar) {
        this.mContext = fVar.context;
        this.WZ = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.Xa = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.Xb = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.Wo);
        this.Xc = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        pv();
    }

    private void pv() {
        MessageManager.getInstance().registerListener(this.Xf);
        this.WZ.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.j.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                j.this.Xa.pU();
                j.this.Xa.pZ();
                j.this.Xb.pZ();
                j.this.Xc.ri();
            }
        });
    }

    public void a(com.baidu.live.gift.a.d dVar, boolean z) {
        boolean z2 = false;
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            boolean z3 = a(dVar) || dVar.abb;
            if (!z3 || dVar.abb || z || !this.Xe || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!dVar.abb || dVar.priority == 1) {
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
            } else if (dVar.aaR.WJ != null && dVar.aaW >= 2 && !ListUtils.isEmpty(dVar.aaR.WJ.Xp)) {
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
        if (dVar == null || dVar.aaR == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.rc().ck(dVar.aaR.pc());
    }

    private void c(com.baidu.live.gift.a.d dVar) {
        pw();
        this.Xa.f(dVar);
        this.Xa.pT();
    }

    public void pw() {
        this.Xb.pw();
        this.Xc.pw();
    }

    public void px() {
        this.Xb.px();
        this.Xc.px();
    }

    private void d(com.baidu.live.gift.a.d dVar) {
        this.Xb.d(dVar);
    }

    private void e(com.baidu.live.gift.a.d dVar) {
        this.Xc.e(dVar);
    }

    public void py() {
        int i = 0;
        if (this.WZ != null) {
            int childCount = this.WZ.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.WZ.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.WZ.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.WZ.removeView((View) arrayList.get(i3));
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
        if (this.WZ != null) {
            int childCount = this.WZ.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.WZ.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.WZ.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.WZ.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void J(View view) {
        if (this.WZ.indexOfChild(view) < 0) {
            this.WZ.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.WZ.indexOfChild(view) < 0) {
                this.WZ.addView(view, layoutParams);
                return;
            }
            return;
        }
        J(view);
    }

    @Override // com.baidu.live.gift.r
    public void onDestroy() {
        if (!this.Xd) {
            this.Xd = true;
            if (this.Xa != null) {
                this.Xa.onDestroy();
            }
            if (this.Xb != null) {
                this.Xb.onDestroy();
            }
            if (this.Xc != null) {
                this.Xc.onDestroy();
            }
            if (this.WZ != null) {
                this.WZ.clearAnimation();
                this.WZ.setConfigurationChangedListener(null);
                this.WZ.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.Xf);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.r
    public View pA() {
        return this.WZ;
    }

    @Override // com.baidu.live.gift.r
    public void ai(boolean z) {
        if (this.Xb != null) {
            this.Xb.ai(z);
        }
    }

    @Override // com.baidu.live.gift.r
    public void aZ(int i) {
        if (this.Xb != null) {
            this.Xb.aZ(i);
        }
    }

    @Override // com.baidu.live.gift.r
    public View pB() {
        return this.Xb.pB();
    }

    @Override // com.baidu.live.gift.r
    public void pC() {
        if (this.WZ != null) {
            this.WZ.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.r
    public void aj(boolean z) {
        this.Xe = z;
        if (this.Xc != null) {
            this.Xc.aj(z);
        }
    }
}
