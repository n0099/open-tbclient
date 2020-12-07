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
import com.baidu.live.gift.ad;
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
public class a implements ad {
    public boolean aVr;
    private boolean aXc = false;
    private boolean aXd = false;
    CustomMessageListener aXe = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.bcM);
            }
        }
    };
    CustomMessageListener aXf = new CustomMessageListener(2501064) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && (cVar = (c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                a.this.d(cVar);
            }
        }
    };
    private AlaGiftShowPanel bST;
    private com.baidu.live.yuyingift.biggift.a bSU;
    private com.baidu.live.yuyingift.graffitigift.a bSV;
    private com.baidu.live.yuyingift.yuyinhousegift.a bSW;
    private Context mContext;

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aVr = fVar.aVr;
        this.bST = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bSU = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bSV = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bSW = new com.baidu.live.yuyingift.yuyinhousegift.a(this.mContext, this);
        HH();
    }

    private void HH() {
        MessageManager.getInstance().registerListener(this.aXe);
        MessageManager.getInstance().registerListener(this.aXf);
        this.bST.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bSU.IM();
                a.this.bSU.IR();
                a.this.bSV.KB();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bda;
            if (!z3 || cVar.bda || z || !this.aXd || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bda || cVar.priority == 1) {
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
            } else if (cVar.bcN.aWg != null && cVar.bcU >= 2 && !ListUtils.isEmpty(cVar.bcN.aWg.aXp)) {
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
        if (cVar == null || cVar.bcN == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.Zu().hm(cVar.bcN.GX());
    }

    private void c(c cVar) {
        this.bSW.h(cVar);
        List<r.a> jf = r.jf(cVar.bnb);
        int size = jf != null ? jf.size() : 0;
        if (cVar.bda) {
            size = 1;
            cVar.bcU = 1L;
        }
        for (int i = 0; i < size * cVar.bcU; i++) {
            this.bSU.h(cVar);
            this.bSU.IL();
        }
    }

    public void HJ() {
        this.bSV.HJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        this.bSW.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.bcN != null && cVar.bcN.aWg != null && cVar.bcN.aWg.aXp != null) {
            if (cVar.bcN.aWg.aXp.size() == 1) {
                this.bSW.h(cVar);
            } else if (cVar.bcN.aWg.aXp.size() > 1) {
                b.g(cVar);
            }
        }
        this.bSV.e(cVar);
    }

    public void HL() {
        int i = 0;
        if (this.bST != null) {
            int childCount = this.bST.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bST.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bST.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bST.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void Zm() {
        int i = 0;
        if (this.bST != null) {
            int childCount = this.bST.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bST.getChildAt(i2) instanceof YuyinAlaRoomGiftView) {
                    arrayList.add(this.bST.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bST.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.bST.indexOfChild(view) < 0) {
            this.bST.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            if (this.bST.indexOfChild(view) < 0) {
                this.bST.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ad
    public void onDestroy() {
        if (!this.aXc) {
            this.aXc = true;
            if (this.bSU != null) {
                this.bSU.onDestroy();
            }
            if (this.bSV != null) {
                this.bSV.onDestroy();
            }
            if (this.bSW != null) {
                this.bSW.onDestory();
            }
            if (this.bST != null) {
                this.bST.clearAnimation();
                this.bST.setConfigurationChangedListener(null);
                this.bST.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aXe);
            MessageManager.getInstance().unRegisterListener(this.aXf);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ad
    public View HM() {
        return this.bST;
    }

    @Override // com.baidu.live.gift.ad
    public View HN() {
        return null;
    }

    @Override // com.baidu.live.gift.ad
    public void HO() {
        if (this.bST != null) {
            this.bST.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void bC(boolean z) {
        this.aXd = z;
        if (this.bSV != null) {
            this.bSV.bC(z);
        }
        if (this.bSU != null) {
            this.bSU.bC(z);
        }
    }

    @Override // com.baidu.live.gift.ad
    public void HP() {
        if (this.bSV != null) {
            this.bSV.HP();
        }
    }

    @Override // com.baidu.live.gift.ad
    public void ek(int i) {
    }

    @Override // com.baidu.live.gift.ad
    public void el(int i) {
    }
}
