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
import com.baidu.live.utils.h;
/* loaded from: classes4.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aRa;
    private int aVL;
    private boolean aVm;
    private com.baidu.live.gift.biggift.b aWc;
    private AlaBigGiftExtraInfoRevisionView aWd;
    private AlaDynamicGiftAnimationView aWe;
    public d aWf;
    private a aWg;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aVm = true;
        this.aWg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ep(i);
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.dU(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aWd != null) {
                    AlaDynamicGiftLayout.this.aWd.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.m(AlaDynamicGiftLayout.this.aRa);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aVm = true;
        this.aWg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ep(i);
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.dU(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aWd != null) {
                    AlaDynamicGiftLayout.this.aWd.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.m(AlaDynamicGiftLayout.this.aRa);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aVm = true;
        this.aWg = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ep(i2);
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.dU(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aWd != null) {
                    AlaDynamicGiftLayout.this.aWd.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aWc != null) {
                    AlaDynamicGiftLayout.this.aWc.m(AlaDynamicGiftLayout.this.aRa);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aWe = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aWe.setFrameCallback(this.aWg);
        this.aWd = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.FI();
            }
        });
        this.aVm = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aOF != null && cVar.aOF.aOE != null) {
            this.aRa = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                GY();
            }
            this.aWf = cVar.aOF.aOE;
            this.mFrameCount = this.aWf.frame_count;
            if (this.aWd != null) {
                if (!cVar2.GM()) {
                    this.aWd.setVisibility(8);
                    this.aVm = false;
                } else {
                    this.aWd.setData(cVar2);
                    GX();
                    this.aVm = true;
                }
            }
            if (this.aWe != null) {
                this.aWe.setScreen(this.aVL, this.mScreenHeight);
                this.aWe.setData(cVar);
            }
        }
    }

    private void GX() {
        int dimensionPixelOffset;
        int aA;
        ViewGroup.LayoutParams layoutParams = this.aWd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aA = h.az(getContext());
                } else {
                    aA = h.aA(getContext());
                }
                dimensionPixelOffset = aA + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.aWd.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI() {
        if (this.aRa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aRa.userId), this.aRa.userName, this.aRa.portrait, this.aRa.sex, this.aRa.aVf, this.aRa.location, this.aRa.description, 0L, this.aRa.fansCount, this.aRa.aVg, this.aRa.userStatus, this.aRa.liveId, this.aRa.groupId, this.aRa.aVk, this.aRa.aVl, this.aRa.appId, this.aRa.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(int i) {
        if (this.aWd != null && this.aVm) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aWd.FF();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aWd.FG();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aWe != null) {
            this.aWe.startAnim();
            this.isShowing = true;
            if (this.aWc != null) {
                this.aWc.l(this.aRa);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aWe != null) {
                this.aWe.stopAnim();
            }
            if (this.aWd != null) {
                this.aWd.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aWc = bVar;
    }

    public void onDestroy() {
        if (this.aWe != null) {
            this.aWe.onDestroy();
        }
        if (this.aWd != null) {
            this.aWd.onDestroy();
        }
    }

    public void bH(boolean z) {
        GY();
        if (this.aWe != null) {
            this.aWe.setScreen(this.aVL, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aWc != null) {
            this.aWc.m(this.aRa);
        }
    }

    private void GY() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aVL = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.aVL = i;
        this.mScreenHeight = i2;
    }
}
