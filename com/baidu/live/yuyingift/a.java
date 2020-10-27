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
import com.baidu.live.gift.ac;
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
public class a implements ac {
    public boolean aSH;
    private boolean aUq = false;
    private boolean aUr = false;
    CustomMessageListener aUs = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.aZI);
            }
        }
    };
    CustomMessageListener aUt = new CustomMessageListener(2501064) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && (cVar = (c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                a.this.d(cVar);
            }
        }
    };
    private AlaGiftShowPanel bJR;
    private com.baidu.live.yuyingift.biggift.a bJS;
    private com.baidu.live.yuyingift.graffitigift.a bJT;
    private com.baidu.live.yuyingift.yuyinhousegift.a bJU;
    private Context mContext;

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aSH = fVar.aSH;
        this.bJR = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bJS = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bJT = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bJU = new com.baidu.live.yuyingift.yuyinhousegift.a(this.mContext, this);
        Ga();
    }

    private void Ga() {
        MessageManager.getInstance().registerListener(this.aUs);
        MessageManager.getInstance().registerListener(this.aUt);
        this.bJR.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bJS.Hd();
                a.this.bJS.Hi();
                a.this.bJT.IJ();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aZU;
            if (!z3 || cVar.aZU || z || !this.aUr || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aZU || cVar.priority == 1) {
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
            } else if (cVar.aZJ.aTv != null && cVar.aZP >= 2 && !ListUtils.isEmpty(cVar.aZJ.aTv.aUD)) {
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
        if (cVar == null || cVar.aZJ == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.Vf().gS(cVar.aZJ.Fs());
    }

    private void c(c cVar) {
        this.bJU.h(cVar);
        List<r.a> io2 = r.io(cVar.bja);
        int size = io2 != null ? io2.size() : 0;
        if (cVar.aZU) {
            size = 1;
            cVar.aZP = 1L;
        }
        for (int i = 0; i < size * cVar.aZP; i++) {
            this.bJS.h(cVar);
            this.bJS.Hc();
        }
    }

    public void Gc() {
        this.bJT.Gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        this.bJU.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.aZJ != null && cVar.aZJ.aTv != null && cVar.aZJ.aTv.aUD != null) {
            if (cVar.aZJ.aTv.aUD.size() == 1) {
                this.bJU.h(cVar);
            } else if (cVar.aZJ.aTv.aUD.size() > 1) {
                b.g(cVar);
            }
        }
        this.bJT.e(cVar);
    }

    public void Ge() {
        int i = 0;
        if (this.bJR != null) {
            int childCount = this.bJR.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bJR.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bJR.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bJR.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void UX() {
        int i = 0;
        if (this.bJR != null) {
            int childCount = this.bJR.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bJR.getChildAt(i2) instanceof YuyinAlaRoomGiftView) {
                    arrayList.add(this.bJR.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bJR.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.bJR.indexOfChild(view) < 0) {
            this.bJR.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.bJR.indexOfChild(view) < 0) {
                this.bJR.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        if (!this.aUq) {
            this.aUq = true;
            if (this.bJS != null) {
                this.bJS.onDestroy();
            }
            if (this.bJT != null) {
                this.bJT.onDestroy();
            }
            if (this.bJU != null) {
                this.bJU.onDestory();
            }
            if (this.bJR != null) {
                this.bJR.clearAnimation();
                this.bJR.setConfigurationChangedListener(null);
                this.bJR.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aUs);
            MessageManager.getInstance().unRegisterListener(this.aUt);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ac
    public View Gf() {
        return this.bJR;
    }

    @Override // com.baidu.live.gift.ac
    public View Gg() {
        return null;
    }

    @Override // com.baidu.live.gift.ac
    public void Gh() {
        if (this.bJR != null) {
            this.bJR.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void bq(boolean z) {
        this.aUr = z;
        if (this.bJT != null) {
            this.bJT.bq(z);
        }
        if (this.bJS != null) {
            this.bJS.bq(z);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Gi() {
        if (this.bJT != null) {
            this.bJT.Gi();
        }
    }

    @Override // com.baidu.live.gift.ac
    public void dU(int i) {
    }

    @Override // com.baidu.live.gift.ac
    public void dV(int i) {
    }
}
