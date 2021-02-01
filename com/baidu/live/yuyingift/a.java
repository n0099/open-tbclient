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
    public static int bXR = 1;
    public static int bXS = 2;
    public boolean aVn;
    private AlaGiftShowPanel bXN;
    private com.baidu.live.yuyingift.biggift.a bXO;
    private com.baidu.live.yuyingift.graffitigift.a bXP;
    private com.baidu.live.yuyingift.yuyinhousegift.b bXQ;
    private Activity mContext;
    private boolean isDestroyed = false;
    private boolean aXa = false;
    CustomMessageListener aXb = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.bcN);
            }
        }
    };
    CustomMessageListener bXT = new CustomMessageListener(2501075) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && a.this.bXQ != null) {
                a.this.bXQ.dP(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aVn = fVar.aVn;
        this.bXN = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bXO = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bXP = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bXQ = new com.baidu.live.yuyingift.yuyinhousegift.b(this.mContext, this);
        ED();
    }

    private void ED() {
        MessageManager.getInstance().registerListener(this.bXT);
        MessageManager.getInstance().registerListener(this.aXb);
        this.bXN.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bXO.FI();
                a.this.bXO.FN();
                a.this.bXP.Hx();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bcZ;
            if (!z3 || cVar.bcZ || z || !this.aXa || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bcZ || cVar.priority == 1) {
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
            } else if (cVar.bcO.aWe != null && cVar.bcT >= 2 && !ListUtils.isEmpty(cVar.bcO.aWe.aXm)) {
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
        if (cVar == null || cVar.bcO == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.YX().gg(cVar.bcO.DR());
    }

    private void c(c cVar) {
        this.bXQ.h(cVar);
        if (!cVar.bZf) {
            List<s.a> m22if = s.m22if(cVar.bno);
            int size = m22if != null ? m22if.size() : 0;
            if (cVar.bcZ) {
                size = 1;
                cVar.bcT = 1L;
            }
            for (int i = 0; i < size * cVar.bcT; i++) {
                this.bXO.h(cVar);
                this.bXO.Yz();
            }
        }
    }

    public void EF() {
        this.bXP.EF();
    }

    private void d(c cVar) {
        this.bXQ.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.bcO != null && cVar.bcO.aWe != null && cVar.bcO.aWe.aXm != null) {
            if (cVar.bcO.aWe.aXm.size() == 1) {
                this.bXQ.h(cVar);
            } else if (cVar.bcO.aWe.aXm.size() > 1) {
                b.g(cVar);
            }
        }
        this.bXP.e(cVar);
    }

    public void EH() {
        int i = 0;
        if (this.bXN != null) {
            int childCount = this.bXN.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bXN.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bXN.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bXN.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void ak(View view) {
        if (this.bXN != null && this.bXN.indexOfChild(view) > 0) {
            this.bXN.removeView(view);
        }
    }

    public void M(View view) {
        if (this.bXN.indexOfChild(view) < 0) {
            this.bXN.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.bXN.indexOfChild(view) < 0) {
                this.bXN.addView(view, layoutParams);
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
            if (this.bXO != null) {
                this.bXO.onDestroy();
            }
            if (this.bXP != null) {
                this.bXP.onDestroy();
            }
            if (this.bXQ != null) {
                this.bXQ.onDestory();
            }
            if (this.bXN != null) {
                this.bXN.clearAnimation();
                this.bXN.setConfigurationChangedListener(null);
                this.bXN.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.bXT);
            MessageManager.getInstance().unRegisterListener(this.aXb);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View EI() {
        return this.bXN;
    }

    @Override // com.baidu.live.gift.ad
    public View EJ() {
        return null;
    }

    @Override // com.baidu.live.gift.ad
    public void EK() {
        if (this.bXN != null) {
            this.bXN.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bB(boolean z) {
        this.aXa = z;
        if (this.bXP != null) {
            this.bXP.bB(z);
        }
        if (this.bXO != null) {
            this.bXO.bB(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void EL() {
        if (this.bXP != null) {
            this.bXP.EL();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cH(int i) {
    }

    @Override // com.baidu.live.gift.ad
    public void cI(int i) {
    }
}
