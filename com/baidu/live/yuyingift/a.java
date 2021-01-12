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
    public static int bTS = 1;
    public static int bTT = 2;
    public boolean aSj;
    private AlaGiftShowPanel bTO;
    private com.baidu.live.yuyingift.biggift.a bTP;
    private com.baidu.live.yuyingift.graffitigift.a bTQ;
    private com.baidu.live.yuyingift.yuyinhousegift.b bTR;
    private Activity mContext;
    private boolean isDestroyed = false;
    private boolean aTV = false;
    CustomMessageListener aTW = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.aZG);
            }
        }
    };
    CustomMessageListener bTU = new CustomMessageListener(2501075) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && a.this.bTR != null) {
                a.this.bTR.dH(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aSj = fVar.aSj;
        this.bTO = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bTP = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bTQ = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bTR = new com.baidu.live.yuyingift.yuyinhousegift.b(this.mContext, this);
        Dn();
    }

    private void Dn() {
        MessageManager.getInstance().registerListener(this.bTU);
        MessageManager.getInstance().registerListener(this.aTW);
        this.bTO.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bTP.Es();
                a.this.bTP.Ex();
                a.this.bTQ.Gh();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZS;
            if (!z3 || cVar.aZS || z || !this.aTV || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZS || cVar.priority == 1) {
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
            } else if (cVar.aZH.aSZ != null && cVar.aZM >= 2 && !ListUtils.isEmpty(cVar.aZH.aSZ.aUh)) {
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
        if (cVar == null || cVar.aZH == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.Xh().fL(cVar.aZH.CC());
    }

    private void c(c cVar) {
        this.bTR.h(cVar);
        List<s.a> hK = s.hK(cVar.bjV);
        int size = hK != null ? hK.size() : 0;
        if (cVar.aZS) {
            size = 1;
            cVar.aZM = 1L;
        }
        for (int i = 0; i < size * cVar.aZM; i++) {
            this.bTP.h(cVar);
            this.bTP.WJ();
        }
    }

    public void Dp() {
        this.bTQ.Dp();
    }

    private void d(c cVar) {
        this.bTR.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.aZH != null && cVar.aZH.aSZ != null && cVar.aZH.aSZ.aUh != null) {
            if (cVar.aZH.aSZ.aUh.size() == 1) {
                this.bTR.h(cVar);
            } else if (cVar.aZH.aSZ.aUh.size() > 1) {
                b.g(cVar);
            }
        }
        this.bTQ.e(cVar);
    }

    public void Dr() {
        int i = 0;
        if (this.bTO != null) {
            int childCount = this.bTO.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bTO.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bTO.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bTO.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void an(View view) {
        if (this.bTO != null && this.bTO.indexOfChild(view) > 0) {
            this.bTO.removeView(view);
        }
    }

    public void M(View view) {
        if (this.bTO.indexOfChild(view) < 0) {
            this.bTO.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.bTO.indexOfChild(view) < 0) {
                this.bTO.addView(view, layoutParams);
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
            if (this.bTP != null) {
                this.bTP.onDestroy();
            }
            if (this.bTQ != null) {
                this.bTQ.onDestroy();
            }
            if (this.bTR != null) {
                this.bTR.onDestory();
            }
            if (this.bTO != null) {
                this.bTO.clearAnimation();
                this.bTO.setConfigurationChangedListener(null);
                this.bTO.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.bTU);
            MessageManager.getInstance().unRegisterListener(this.aTW);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View Ds() {
        return this.bTO;
    }

    @Override // com.baidu.live.gift.ad
    public View Dt() {
        return null;
    }

    @Override // com.baidu.live.gift.ad
    public void Du() {
        if (this.bTO != null) {
            this.bTO.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bw(boolean z) {
        this.aTV = z;
        if (this.bTQ != null) {
            this.bTQ.bw(z);
        }
        if (this.bTP != null) {
            this.bTP.bw(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void Dv() {
        if (this.bTQ != null) {
            this.bTQ.Dv();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void cC(int i) {
    }

    @Override // com.baidu.live.gift.ad
    public void cD(int i) {
    }
}
