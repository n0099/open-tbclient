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
    private com.baidu.live.gift.a.c aVG;
    private boolean aZT;
    private com.baidu.live.gift.biggift.b baL;
    private AlaBigGiftExtraInfoRevisionView baM;
    private AlaDynamicGiftAnimationView baN;
    public d baO;
    private a baP;
    private int bau;
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
        this.aZT = true;
        this.baP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.ea(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baM != null) {
                    AlaDynamicGiftLayout.this.baM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.m(AlaDynamicGiftLayout.this.aVG);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZT = true;
        this.baP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.ea(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baM != null) {
                    AlaDynamicGiftLayout.this.baM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.m(AlaDynamicGiftLayout.this.aVG);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZT = true;
        this.baP = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ev(i2);
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.ea(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baM != null) {
                    AlaDynamicGiftLayout.this.baM.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baL != null) {
                    AlaDynamicGiftLayout.this.baL.m(AlaDynamicGiftLayout.this.aVG);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.baN = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.baN.setFrameCallback(this.baP);
        this.baM = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.baM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Ha();
            }
        });
        this.aZT = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSL != null && cVar.aSL.aSK != null) {
            this.aVG = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Ip();
            }
            this.baO = cVar.aSL.aSK;
            this.mFrameCount = this.baO.frame_count;
            if (this.baM != null) {
                if (!cVar2.Id()) {
                    this.baM.setVisibility(8);
                    this.aZT = false;
                } else {
                    this.baM.setData(cVar2);
                    Io();
                    this.aZT = true;
                }
            }
            if (this.baN != null) {
                this.baN.setScreen(this.bau, this.mScreenHeight);
                this.baN.setData(cVar);
            }
        }
    }

    private void Io() {
        int dimensionPixelOffset;
        int aD;
        ViewGroup.LayoutParams layoutParams = this.baM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aD = h.aC(getContext());
                } else {
                    aD = h.aD(getContext());
                }
                dimensionPixelOffset = aD + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.baM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (this.aVG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVG.userId), this.aVG.userName, this.aVG.portrait, this.aVG.sex, this.aVG.aZL, this.aVG.location, this.aVG.description, 0L, this.aVG.fansCount, this.aVG.aZM, this.aVG.userStatus, this.aVG.liveId, this.aVG.groupId, this.aVG.aZR, this.aVG.aZS, this.aVG.appId, this.aVG.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        if (this.baM != null && this.aZT) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.baM.GX();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.baM.GY();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.baN != null) {
            this.baN.startAnim();
            this.isShowing = true;
            if (this.baL != null) {
                this.baL.l(this.aVG);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.baN != null) {
                this.baN.stopAnim();
            }
            if (this.baM != null) {
                this.baM.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.baL = bVar;
    }

    public void onDestroy() {
        if (this.baN != null) {
            this.baN.onDestroy();
        }
        if (this.baM != null) {
            this.baM.onDestroy();
        }
    }

    public void bN(boolean z) {
        Ip();
        if (this.baN != null) {
            this.baN.setScreen(this.bau, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.baL != null) {
            this.baL.m(this.aVG);
        }
    }

    private void Ip() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bau = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.bau = i;
        this.mScreenHeight = i2;
    }
}
