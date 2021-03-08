package com.baidu.live.yuyingift;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.AlaGiftShowPanel;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements ad {
    public static int bZr = 1;
    public static int bZs = 2;
    public boolean aWN;
    private AlaGiftShowPanel bZn;
    private com.baidu.live.yuyingift.biggift.a bZo;
    private com.baidu.live.yuyingift.graffitigift.a bZp;
    private com.baidu.live.yuyingift.yuyinhousegift.b bZq;
    private Activity mContext;
    private boolean isDestroyed = false;
    private boolean aYA = false;
    CustomMessageListener aYB = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.beo);
            }
        }
    };
    CustomMessageListener bZt = new CustomMessageListener(2501075) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && a.this.bZq != null) {
                a.this.bZq.dP(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aWN = fVar.aWN;
        this.bZn = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bZo = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bZp = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bZq = new com.baidu.live.yuyingift.yuyinhousegift.b(this.mContext, this);
        EG();
    }

    private void EG() {
        MessageManager.getInstance().registerListener(this.bZt);
        MessageManager.getInstance().registerListener(this.aYB);
        this.bZn.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bZo.FL();
                a.this.bZo.FQ();
                a.this.bZp.HA();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.beB;
            if (!z3 || cVar.beB || z || !this.aYA || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.beB || cVar.priority == 1) {
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
            } else if (cVar.bep.aXE != null && cVar.bev >= 2 && !ListUtils.isEmpty(cVar.bep.aXE.aYM)) {
                e(cVar);
            } else {
                d(cVar);
            }
        }
    }

    public boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        return b(cVar);
    }

    private boolean b(c cVar) {
        if (cVar == null || cVar.bep == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.Za().gm(cVar.bep.DU());
    }

    private void c(c cVar) {
        this.bZq.h(cVar);
        if (!cVar.caF) {
            List<s.a> il = s.il(cVar.boO);
            int size = il != null ? il.size() : 0;
            if (cVar.beB) {
                size = 1;
                cVar.bev = 1L;
            }
            for (int i = 0; i < size * cVar.bev; i++) {
                this.bZo.h(cVar);
                this.bZo.YC();
            }
        }
    }

    public void EI() {
        this.bZp.EI();
    }

    private void d(c cVar) {
        this.bZq.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.bep != null && cVar.bep.aXE != null && cVar.bep.aXE.aYM != null) {
            if (cVar.bep.aXE.aYM.size() == 1) {
                this.bZq.h(cVar);
            } else if (cVar.bep.aXE.aYM.size() > 1) {
                b.g(cVar);
            }
        }
        this.bZp.e(cVar);
    }

    public void EK() {
        int i = 0;
        if (this.bZn != null) {
            int childCount = this.bZn.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bZn.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bZn.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bZn.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void ak(View view) {
        if (this.bZn != null && this.bZn.indexOfChild(view) > 0) {
            this.bZn.removeView(view);
        }
    }

    public void M(View view) {
        if (this.bZn.indexOfChild(view) < 0) {
            this.bZn.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.bZn.indexOfChild(view) < 0) {
                this.bZn.addView(view, layoutParams);
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
            if (this.bZo != null) {
                this.bZo.onDestroy();
            }
            if (this.bZp != null) {
                this.bZp.onDestroy();
            }
            if (this.bZq != null) {
                this.bZq.onDestory();
            }
            if (this.bZn != null) {
                this.bZn.clearAnimation();
                this.bZn.setConfigurationChangedListener(null);
                this.bZn.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.bZt);
            MessageManager.getInstance().unRegisterListener(this.aYB);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View EL() {
        return this.bZn;
    }

    @Override // com.baidu.live.gift.ad
    public View EM() {
        return null;
    }

    @Override // com.baidu.live.gift.ad
    public void EN() {
        if (this.bZn != null) {
            this.bZn.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bB(boolean z) {
        this.aYA = z;
        if (this.bZp != null) {
            this.bZp.bB(z);
        }
        if (this.bZo != null) {
            this.bZo.bB(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void EO() {
        if (this.bZp != null) {
            this.bZp.EO();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cI(int i) {
    }

    @Override // com.baidu.live.gift.ad
    public void cJ(int i) {
    }
}
