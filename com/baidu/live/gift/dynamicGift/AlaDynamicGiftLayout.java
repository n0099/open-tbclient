package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.gift.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.g;
/* loaded from: classes7.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aOW;
    private boolean aSY;
    private com.baidu.live.gift.biggift.b aTL;
    private AlaBigGiftExtraInfoRevisionView aTM;
    private AlaDynamicGiftAnimationView aTN;
    public d aTO;
    private a aTP;
    private int aTu;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aSY = true;
        this.aTP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.el(i);
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.dQ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTM != null) {
                    AlaDynamicGiftLayout.this.aTM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.m(AlaDynamicGiftLayout.this.aOW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aSY = true;
        this.aTP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.el(i);
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.dQ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTM != null) {
                    AlaDynamicGiftLayout.this.aTM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.m(AlaDynamicGiftLayout.this.aOW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aSY = true;
        this.aTP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.el(i2);
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.dQ(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTM != null) {
                    AlaDynamicGiftLayout.this.aTM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTL != null) {
                    AlaDynamicGiftLayout.this.aTL.m(AlaDynamicGiftLayout.this.aOW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aTN = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aTN.setFrameCallback(this.aTP);
        this.aTM = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Fi();
            }
        });
        this.aSY = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aML != null && cVar.aML.aMK != null) {
            this.aOW = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Gy();
            }
            this.aTO = cVar.aML.aMK;
            this.mFrameCount = this.aTO.frame_count;
            if (this.aTM != null) {
                if (!cVar2.Gm()) {
                    this.aTM.setVisibility(8);
                    this.aSY = false;
                } else {
                    this.aTM.setData(cVar2);
                    Gx();
                    this.aSY = true;
                }
            }
            if (this.aTN != null) {
                this.aTN.setScreen(this.aTu, this.mScreenHeight);
                this.aTN.setData(cVar);
            }
        }
    }

    private void Gx() {
        int dimensionPixelOffset;
        int aA;
        ViewGroup.LayoutParams layoutParams = this.aTM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aA = g.az(getContext());
                } else {
                    aA = g.aA(getContext());
                }
                dimensionPixelOffset = aA + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.aTM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi() {
        if (this.aOW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOW.userId), this.aOW.userName, this.aOW.portrait, this.aOW.sex, this.aOW.aSS, this.aOW.location, this.aOW.description, 0L, this.aOW.fansCount, this.aOW.aST, this.aOW.userStatus, this.aOW.liveId, this.aOW.groupId, this.aOW.aSW, this.aOW.aSX, this.aOW.appId, this.aOW.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(int i) {
        if (this.aTM != null && this.aSY) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aTM.Ff();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aTM.Fg();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aTN != null) {
            this.aTN.startAnim();
            this.isShowing = true;
            if (this.aTL != null) {
                this.aTL.l(this.aOW);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aTN != null) {
                this.aTN.stopAnim();
            }
            if (this.aTM != null) {
                this.aTM.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aTL = bVar;
    }

    public void onDestroy() {
        if (this.aTN != null) {
            this.aTN.onDestroy();
        }
        if (this.aTM != null) {
            this.aTM.onDestroy();
        }
    }

    public void bG(boolean z) {
        Gy();
        if (this.aTN != null) {
            this.aTN.setScreen(this.aTu, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aTL != null) {
            this.aTL.m(this.aOW);
        }
    }

    private void Gy() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aTu = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.aTu = i;
        this.mScreenHeight = i2;
    }
}
