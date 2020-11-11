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
    public boolean aUa;
    private boolean aVI = false;
    private boolean aVJ = false;
    CustomMessageListener aVK = new CustomMessageListener(2501063) { // from class: com.baidu.live.yuyingift.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                a.this.a(cVar, cVar.bbb);
            }
        }
    };
    CustomMessageListener aVL = new CustomMessageListener(2501064) { // from class: com.baidu.live.yuyingift.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && (cVar = (c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                a.this.d(cVar);
            }
        }
    };
    private com.baidu.live.yuyingift.yuyinhousegift.a bPA;
    private AlaGiftShowPanel bPx;
    private com.baidu.live.yuyingift.biggift.a bPy;
    private com.baidu.live.yuyingift.graffitigift.a bPz;
    private Context mContext;

    public a(f fVar) {
        this.mContext = fVar.context;
        this.aUa = fVar.aUa;
        this.bPx = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.g.yuyingift_popshow_contain_layout, (ViewGroup) null);
        this.bPy = new com.baidu.live.yuyingift.biggift.a(this.mContext, this);
        this.bPz = new com.baidu.live.yuyingift.graffitigift.a(this.mContext, this);
        this.bPA = new com.baidu.live.yuyingift.yuyinhousegift.a(this.mContext, this);
        GB();
    }

    private void GB() {
        MessageManager.getInstance().registerListener(this.aVK);
        MessageManager.getInstance().registerListener(this.aVL);
        this.bPx.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.yuyingift.a.1
            @Override // com.baidu.live.yuyingift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                a.this.bPy.HE();
                a.this.bPy.HJ();
                a.this.bPz.Jk();
            }
        });
    }

    public void a(c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.bbn;
            if (!z3 || cVar.bbn || z || !this.aVJ || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.bbn || cVar.priority == 1) {
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
            } else if (cVar.bbc.aUN != null && cVar.bbi >= 2 && !ListUtils.isEmpty(cVar.bbc.aUN.aVV)) {
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
        if (cVar == null || cVar.bbc == null) {
            return false;
        }
        return com.baidu.live.yuyingift.b.b.XE().gX(cVar.bbc.FT());
    }

    private void c(c cVar) {
        this.bPA.h(cVar);
        List<r.a> iH = r.iH(cVar.bku);
        int size = iH != null ? iH.size() : 0;
        if (cVar.bbn) {
            size = 1;
            cVar.bbi = 1L;
        }
        for (int i = 0; i < size * cVar.bbi; i++) {
            this.bPy.h(cVar);
            this.bPy.HD();
        }
    }

    public void GD() {
        this.bPz.GD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar) {
        this.bPA.h(cVar);
    }

    private void e(c cVar) {
        if (cVar != null && cVar.bbc != null && cVar.bbc.aUN != null && cVar.bbc.aUN.aVV != null) {
            if (cVar.bbc.aUN.aVV.size() == 1) {
                this.bPA.h(cVar);
            } else if (cVar.bbc.aUN.aVV.size() > 1) {
                b.g(cVar);
            }
        }
        this.bPz.e(cVar);
    }

    public void GF() {
        int i = 0;
        if (this.bPx != null) {
            int childCount = this.bPx.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bPx.getChildAt(i2) instanceof com.baidu.live.yuyingift.biggift.c) {
                    arrayList.add(this.bPx.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bPx.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void Xw() {
        int i = 0;
        if (this.bPx != null) {
            int childCount = this.bPx.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.bPx.getChildAt(i2) instanceof YuyinAlaRoomGiftView) {
                    arrayList.add(this.bPx.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.bPx.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.bPx.indexOfChild(view) < 0) {
            this.bPx.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            if (this.bPx.indexOfChild(view) < 0) {
                this.bPx.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.ab
    public void onDestroy() {
        if (!this.aVI) {
            this.aVI = true;
            if (this.bPy != null) {
                this.bPy.onDestroy();
            }
            if (this.bPz != null) {
                this.bPz.onDestroy();
            }
            if (this.bPA != null) {
                this.bPA.onDestory();
            }
            if (this.bPx != null) {
                this.bPx.clearAnimation();
                this.bPx.setConfigurationChangedListener(null);
                this.bPx.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aVK);
            MessageManager.getInstance().unRegisterListener(this.aVL);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.ab
    public View GG() {
        return this.bPx;
    }

    @Override // com.baidu.live.gift.ab
    public View GH() {
        return null;
    }

    @Override // com.baidu.live.gift.ab
    public void GI() {
        if (this.bPx != null) {
            this.bPx.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void br(boolean z) {
        this.aVJ = z;
        if (this.bPz != null) {
            this.bPz.br(z);
        }
        if (this.bPy != null) {
            this.bPy.br(z);
        }
    }

    @Override // com.baidu.live.gift.ab
    public void GJ() {
        if (this.bPz != null) {
            this.bPz.GJ();
        }
    }

    @Override // com.baidu.live.gift.ab
    public void dU(int i) {
    }

    @Override // com.baidu.live.gift.ab
    public void dV(int i) {
    }
}
