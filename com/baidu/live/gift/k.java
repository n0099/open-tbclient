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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k implements w {
    public boolean aHx;
    private AlaGiftShowPanel aIT;
    private com.baidu.live.gift.biggift.a aIU;
    private com.baidu.live.gift.smallgift.a aIV;
    private com.baidu.live.gift.graffitiGift.a aIW;
    private boolean aIX = false;
    private boolean aIY = false;
    CustomMessageListener aIZ = new CustomMessageListener(2913031) { // from class: com.baidu.live.gift.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c)) {
                com.baidu.live.gift.a.c cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData();
                k.this.a(cVar, cVar.aNC);
            }
        }
    };
    CustomMessageListener aJa = new CustomMessageListener(2913138) { // from class: com.baidu.live.gift.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.gift.a.c cVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.gift.a.c) && (cVar = (com.baidu.live.gift.a.c) customResponsedMessage.getData()) != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
                k.this.d(cVar);
            }
        }
    };
    private Context mContext;

    public k(f fVar) {
        this.mContext = fVar.context;
        this.aHx = fVar.aHx;
        this.aIT = (AlaGiftShowPanel) LayoutInflater.from(fVar.context).inflate(a.h.gift_popshow_contain_layout, (ViewGroup) null);
        this.aIU = new com.baidu.live.gift.biggift.a(this.mContext, this);
        this.aIV = new com.baidu.live.gift.smallgift.a(this.mContext, this, fVar.aHG);
        this.aIW = new com.baidu.live.gift.graffitiGift.a(this.mContext, this);
        yV();
    }

    private void yV() {
        MessageManager.getInstance().registerListener(this.aIZ);
        MessageManager.getInstance().registerListener(this.aJa);
        this.aIT.setConfigurationChangedListener(new AlaGiftShowPanel.a() { // from class: com.baidu.live.gift.k.1
            @Override // com.baidu.live.gift.AlaGiftShowPanel.a
            public void onConfigurationChanged(Configuration configuration) {
                k.this.aIU.zI();
                k.this.aIU.zN();
                k.this.aIV.zN();
                k.this.aIW.Bq();
            }
        });
    }

    public void a(com.baidu.live.gift.a.c cVar, boolean z) {
        boolean z2 = false;
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            boolean z3 = a(cVar) || cVar.aNM;
            if (!z3 || cVar.aNM || z || !this.aIY || UtilHelper.getRealScreenOrientation(this.mContext) != 2) {
                z2 = z3;
            }
            if (z2) {
                if (!cVar.aNM || cVar.priority == 1) {
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
                r.g(cVar);
            } else if (cVar.aND.aIh != null && cVar.aNH >= 2 && !ListUtils.isEmpty(cVar.aND.aIh.aJk)) {
                e(cVar);
                r.g(cVar);
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
        if (cVar == null || cVar.aND == null) {
            return false;
        }
        return com.baidu.live.gift.b.b.Bj().eQ(cVar.aND.yo());
    }

    private void c(com.baidu.live.gift.a.c cVar) {
        yW();
        this.aIU.h(cVar);
        this.aIU.zH();
    }

    public void yW() {
        this.aIV.yW();
        this.aIW.yW();
    }

    public void yX() {
        this.aIV.yX();
        this.aIW.yX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.live.gift.a.c cVar) {
        this.aIV.d(cVar);
    }

    private void e(com.baidu.live.gift.a.c cVar) {
        this.aIW.e(cVar);
    }

    public void yY() {
        int i = 0;
        if (this.aIT != null) {
            int childCount = this.aIT.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (!(this.aIT.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c)) {
                    arrayList.add(this.aIT.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aIT.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void yZ() {
        int i = 0;
        if (this.aIT != null) {
            int childCount = this.aIT.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.aIT.getChildAt(i2) instanceof com.baidu.live.gift.biggift.c) {
                    arrayList.add(this.aIT.getChildAt(i2));
                }
            }
            while (true) {
                int i3 = i;
                if (i3 < arrayList.size()) {
                    this.aIT.removeView((View) arrayList.get(i3));
                    i = i3 + 1;
                } else {
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    public void M(View view) {
        if (this.aIT.indexOfChild(view) < 0) {
            this.aIT.addView(view);
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParams != null) {
            if (this.aIT.indexOfChild(view) < 0) {
                this.aIT.addView(view, layoutParams);
                return;
            }
            return;
        }
        M(view);
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        if (!this.aIX) {
            this.aIX = true;
            if (this.aIU != null) {
                this.aIU.onDestroy();
            }
            if (this.aIV != null) {
                this.aIV.onDestroy();
            }
            if (this.aIW != null) {
                this.aIW.onDestroy();
            }
            if (this.aIT != null) {
                this.aIT.clearAnimation();
                this.aIT.setConfigurationChangedListener(null);
                this.aIT.removeAllViews();
            }
            MessageManager.getInstance().unRegisterListener(this.aIZ);
            MessageManager.getInstance().unRegisterListener(this.aJa);
            this.mContext = null;
        }
    }

    @Override // com.baidu.live.gift.w
    public View za() {
        return this.aIT;
    }

    @Override // com.baidu.live.gift.w
    public void be(boolean z) {
        if (this.aIV != null) {
            this.aIV.be(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bZ(int i) {
        if (this.aIV != null) {
            this.aIV.bZ(i);
        }
    }

    @Override // com.baidu.live.gift.w
    public View zb() {
        return this.aIV.zb();
    }

    @Override // com.baidu.live.gift.w
    public void zc() {
        if (this.aIT != null) {
            this.aIT.onConfigurationChanged(null);
        }
    }

    @Override // com.baidu.live.gift.w
    public void bf(boolean z) {
        this.aIY = z;
        if (this.aIW != null) {
            this.aIW.bf(z);
        }
        if (this.aIU != null) {
            this.aIU.bf(z);
        }
    }

    @Override // com.baidu.live.gift.w
    public void zd() {
        if (this.aIW != null) {
            this.aIW.zd();
        }
    }
}
