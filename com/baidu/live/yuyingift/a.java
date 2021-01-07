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
/* loaded from: classes11.dex */
public class a implements ad {
    public static int bYE = 1;
    public static int bYF = 2;
    public boolean aWW;
    private AlaGiftShowPanel bYA;
    private com.baidu.live.yuyingift.biggift.a bYB;
    private com.baidu.live.yuyingift.graffitigift.a bYC;
    private com.baidu.live.yuyingift.yuyinhousegift.b bYD;
    private Activity mContext;
    private boolean isDestroyed = false;
    private boolean aYI = false;
    CustomMessageListener aYJ = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.bew);
            }
        }
    };
    CustomMessageListener bYG = new CustomMessageListener(2501075) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && a.this.bYD != null) {
                a.this.bYD.dL(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aWW = fVar.aWW;
        this.bYA = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bYB = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bYC = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bYD = new com.baidu.live.yuyingift.yuyinhousegift.b(this.mContext, this);
        Hi();
    }

    private void Hi() {
        MessageManager.getInstance().registerListener(this.bYG);
        MessageManager.getInstance().registerListener(this.aYJ);
        this.bYA.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bYB.In();
                a.this.bYB.Is();
                a.this.bYC.Kc();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.beI;
            if (!z3 || cVar.beI || z || !this.aYI || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.beI || cVar.priority == 1) {
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
            } else if (cVar.bex.aXM != null && cVar.beC >= 2 && !ListUtils.isEmpty(cVar.bex.aXM.aYU)) {
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
        if (cVar == null || cVar.bex == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.aba().gX(cVar.bex.Gx());
    }

    private void c(c cVar) {
        this.bYD.h(cVar);
        List<s.a> iV = s.iV(cVar.boI);
        int size = iV != null ? iV.size() : 0;
        if (cVar.beI) {
            size = 1;
            cVar.beC = 1L;
        }
        for (int i = 0; i < size * cVar.beC; i++) {
            this.bYB.h(cVar);
            this.bYB.aaC();
        }
    }

    public void Hk() {
        this.bYC.Hk();
    }

    private void d(c cVar) {
        this.bYD.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.bex != null && cVar.bex.aXM != null && cVar.bex.aXM.aYU != null) {
            if (cVar.bex.aXM.aYU.size() == 1) {
                this.bYD.h(cVar);
            } else if (cVar.bex.aXM.aYU.size() > 1) {
                b.g(cVar);
            }
        }
        this.bYC.e(cVar);
    }

    public void Hm() {
        int i = 0;
        if (this.bYA != null) {
            int childCount = this.bYA.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bYA.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bYA.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bYA.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void an(View view) {
        if (this.bYA != null && this.bYA.indexOfChild(view) > 0) {
            this.bYA.removeView(view);
        }
    }

    public void M(View view) {
        if (this.bYA.indexOfChild(view) < 0) {
            this.bYA.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.bYA.indexOfChild(view) < 0) {
                this.bYA.addView(view, layoutParams);
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
            if (this.bYB != null) {
                this.bYB.onDestroy();
            }
            if (this.bYC != null) {
                this.bYC.onDestroy();
            }
            if (this.bYD != null) {
                this.bYD.onDestory();
            }
            if (this.bYA != null) {
                this.bYA.clearAnimation();
                this.bYA.setConfigurationChangedListener(null);
                this.bYA.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.bYG);
            MessageManager.getInstance().unRegisterListener(this.aYJ);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View Hn() {
        return this.bYA;
    }

    @Override // com.baidu.live.gift.ad
    public View Ho() {
        return null;
    }

    @Override // com.baidu.live.gift.ad
    public void Hp() {
        if (this.bYA != null) {
            this.bYA.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bA(boolean z) {
        this.aYI = z;
        if (this.bYC != null) {
            this.bYC.bA(z);
        }
        if (this.bYB != null) {
            this.bYB.bA(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void Hq() {
        if (this.bYC != null) {
            this.bYC.Hq();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void ei(int i) {
    }

    @Override // com.baidu.live.gift.ad
    public void ej(int i) {
    }
}
