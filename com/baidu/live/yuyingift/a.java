package com.baidu.live.yuyingift;

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
import com.baidu.live.gift.ab;
import com.baidu.live.gift.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.AlaGiftShowPanel;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements ab {
    public boolean aSp;
    private boolean aTX = false;
    private boolean aTY = false;
    CustomMessageListener aTZ = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.aZp);
            }
        }
    };
    CustomMessageListener aUa = new CustomMessageListener(2501064) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && (cVar = (c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                a.this.d(cVar);
            }
        }
    };
    private AlaGiftShowPanel bNN;
    private com.baidu.live.yuyingift.biggift.a bNO;
    private com.baidu.live.yuyingift.graffitigift.a bNP;
    private com.baidu.live.yuyingift.yuyinhousegift.a bNQ;
    private Context mContext;

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aSp = fVar.aSp;
        this.bNN = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bNO = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bNP = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bNQ = new com.baidu.live.yuyingift.yuyinhousegift.a(this.mContext, this);
        FS();
    }

    private void FS() {
        MessageManager.getInstance().registerListener(this.aTZ);
        MessageManager.getInstance().registerListener(this.aUa);
        this.bNN.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bNO.GV();
                a.this.bNO.Ha();
                a.this.bNP.IB();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZB;
            if (!z3 || cVar.aZB || z || !this.aTY || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZB || cVar.priority == 1) {
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
            } else if (cVar.aZq.aTc != null && cVar.aZw >= 2 && !ListUtils.isEmpty(cVar.aZq.aTc.aUk)) {
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
        if (cVar == null || cVar.aZq == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.WV().gR(cVar.aZq.Fk());
    }

    private void c(c cVar) {
        this.bNQ.h(cVar);
        List<r.a> iB = r.iB(cVar.biJ);
        int size = iB != null ? iB.size() : 0;
        if (cVar.aZB) {
            size = 1;
            cVar.aZw = 1L;
        }
        for (int i = 0; i < size * cVar.aZw; i++) {
            this.bNO.h(cVar);
            this.bNO.GU();
        }
    }

    public void FU() {
        this.bNP.FU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        this.bNQ.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.aZq != null && cVar.aZq.aTc != null && cVar.aZq.aTc.aUk != null) {
            if (cVar.aZq.aTc.aUk.size() == 1) {
                this.bNQ.h(cVar);
            } else if (cVar.aZq.aTc.aUk.size() > 1) {
                b.g(cVar);
            }
        }
        this.bNP.e(cVar);
    }

    public void FW() {
        int i = 0;
        if (this.bNN != null) {
            int childCount = this.bNN.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bNN.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bNN.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bNN.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void WN() {
        int i = 0;
        if (this.bNN != null) {
            int childCount = this.bNN.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bNN.getChildAt(i2) instanceof YuyinAlaRoomGiftView) {
                    arrayList.add(this.bNN.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bNN.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.bNN.indexOfChild(view) < 0) {
            this.bNN.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            if (this.bNN.indexOfChild(view) < 0) {
                this.bNN.addView(view, layoutParams);
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
            if (this.bNO != null) {
                this.bNO.onDestroy();
            }
            if (this.bNP != null) {
                this.bNP.onDestroy();
            }
            if (this.bNQ != null) {
                this.bNQ.onDestory();
            }
            if (this.bNN != null) {
                this.bNN.clearAnimation();
                this.bNN.setConfigurationChangedListener(null);
                this.bNN.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aTZ);
            MessageManager.getInstance().unRegisterListener(this.aUa);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ab
    public View FX() {
        return this.bNN;
    }

    @Override // com.baidu.live.gift.ab
    public View FY() {
        return null;
    }

    @Override // com.baidu.live.gift.ab
    public void FZ() {
        if (this.bNN != null) {
            this.bNN.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void bt(boolean z) {
        this.aTY = z;
        if (this.bNP != null) {
            this.bNP.bt(z);
        }
        if (this.bNO != null) {
            this.bNO.bt(z);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void Ga() {
        if (this.bNP != null) {
            this.bNP.Ga();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dQ(int i) {
    }

    @Override // com.baidu.live.gift.ab
    public void dR(int i) {
    }
}
