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
/* loaded from: classes10.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aVr;
    private boolean aZR;
    private com.baidu.live.gift.biggift.b baP;
    private AlaBigGiftExtraInfoRevisionView baQ;
    private AlaDynamicGiftAnimationView baR;
    public d baS;
    private a baT;
    private int bax;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aZR = true;
        this.baT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.de(i);
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.cI(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baQ != null) {
                    AlaDynamicGiftLayout.this.baQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.n(AlaDynamicGiftLayout.this.aVr);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZR = true;
        this.baT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.de(i);
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.cI(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baQ != null) {
                    AlaDynamicGiftLayout.this.baQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.n(AlaDynamicGiftLayout.this.aVr);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZR = true;
        this.baT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.de(i2);
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.cI(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.baQ != null) {
                    AlaDynamicGiftLayout.this.baQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.baP != null) {
                    AlaDynamicGiftLayout.this.baP.n(AlaDynamicGiftLayout.this.aVr);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.baR = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.baR.setFrameCallback(this.baT);
        this.baQ = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.baQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Eq();
            }
        });
        this.aZR = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSo != null && cVar.aSo.aSm != null) {
            this.aVr = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                FF();
            }
            this.baS = cVar.aSo.aSm;
            this.mFrameCount = this.baS.frame_count;
            if (this.baQ != null) {
                if (!cVar2.Ft()) {
                    this.baQ.setVisibility(8);
                    this.aZR = false;
                } else {
                    this.baQ.setData(cVar2);
                    FE();
                    this.aZR = true;
                }
            }
            if (this.baR != null) {
                this.baR.setScreen(this.bax, this.mScreenHeight);
                this.baR.setData(cVar);
            }
        }
    }

    private void FE() {
        int dimensionPixelOffset;
        int bn;
        ViewGroup.LayoutParams layoutParams = this.baQ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bn = h.bm(getContext());
                } else {
                    bn = h.bn(getContext());
                }
                dimensionPixelOffset = bn + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.baQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        if (this.aVr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVr.userId), this.aVr.userName, this.aVr.portrait, this.aVr.sex, this.aVr.aZJ, this.aVr.location, this.aVr.description, 0L, this.aVr.fansCount, this.aVr.followCount, this.aVr.userStatus, this.aVr.liveId, this.aVr.groupId, this.aVr.aZP, this.aVr.aZQ, this.aVr.appId, this.aVr.userName)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i) {
        if (this.baQ != null && this.aZR) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.baQ.En();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.baQ.Eo();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        if (!this.isShowing && this.baR != null) {
            this.baR.startAnim();
            this.isShowing = true;
            if (this.baP != null) {
                this.baP.m(this.aVr);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.baR != null) {
                this.baR.stopAnim();
            }
            if (this.baQ != null) {
                this.baQ.end();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.baP = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        if (this.baR != null) {
            this.baR.onDestroy();
        }
        if (this.baQ != null) {
            this.baQ.onDestroy();
        }
    }

    public void bT(boolean z) {
        FF();
        if (this.baR != null) {
            this.baR.setScreen(this.bax, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.baP != null) {
            this.baP.n(this.aVr);
        }
    }

    private void FF() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bax = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bax = i;
        this.mScreenHeight = i2;
    }
}
