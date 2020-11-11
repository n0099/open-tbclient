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
    private com.baidu.live.gift.a.c aWY;
    private int bbM;
    private boolean bbm;
    private com.baidu.live.gift.biggift.b bcd;
    private AlaBigGiftExtraInfoRevisionView bce;
    private AlaDynamicGiftAnimationView bcf;
    public d bcg;
    private a bch;
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
        this.bbm = true;
        this.bch = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.ea(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bce != null) {
                    AlaDynamicGiftLayout.this.bce.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.m(AlaDynamicGiftLayout.this.aWY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bbm = true;
        this.bch = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.ea(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bce != null) {
                    AlaDynamicGiftLayout.this.bce.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.m(AlaDynamicGiftLayout.this.aWY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bbm = true;
        this.bch = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ev(i2);
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.ea(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bce != null) {
                    AlaDynamicGiftLayout.this.bce.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bcd != null) {
                    AlaDynamicGiftLayout.this.bcd.m(AlaDynamicGiftLayout.this.aWY);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bcf = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bcf.setFrameCallback(this.bch);
        this.bce = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bce.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.HB();
            }
        });
        this.bbm = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aUe != null && cVar.aUe.aUd != null) {
            this.aWY = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                IQ();
            }
            this.bcg = cVar.aUe.aUd;
            this.mFrameCount = this.bcg.frame_count;
            if (this.bce != null) {
                if (!cVar2.IE()) {
                    this.bce.setVisibility(8);
                    this.bbm = false;
                } else {
                    this.bce.setData(cVar2);
                    IP();
                    this.bbm = true;
                }
            }
            if (this.bcf != null) {
                this.bcf.setScreen(this.bbM, this.mScreenHeight);
                this.bcf.setData(cVar);
            }
        }
    }

    private void IP() {
        int dimensionPixelOffset;
        int aE;
        ViewGroup.LayoutParams layoutParams = this.bce.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aE = h.aD(getContext());
                } else {
                    aE = h.aE(getContext());
                }
                dimensionPixelOffset = aE + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.bce.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.aWY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aWY.userId), this.aWY.userName, this.aWY.portrait, this.aWY.sex, this.aWY.bbe, this.aWY.location, this.aWY.description, 0L, this.aWY.fansCount, this.aWY.bbf, this.aWY.userStatus, this.aWY.liveId, this.aWY.groupId, this.aWY.bbk, this.aWY.bbl, this.aWY.appId, this.aWY.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        if (this.bce != null && this.bbm) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bce.Hy();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bce.Hz();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bcf != null) {
            this.bcf.startAnim();
            this.isShowing = true;
            if (this.bcd != null) {
                this.bcd.l(this.aWY);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bcf != null) {
                this.bcf.stopAnim();
            }
            if (this.bce != null) {
                this.bce.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bcd = bVar;
    }

    public void onDestroy() {
        if (this.bcf != null) {
            this.bcf.onDestroy();
        }
        if (this.bce != null) {
            this.bce.onDestroy();
        }
    }

    public void bO(boolean z) {
        IQ();
        if (this.bcf != null) {
            this.bcf.setScreen(this.bbM, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bcd != null) {
            this.bcd.m(this.aWY);
        }
    }

    private void IQ() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bbM = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.bbM = i;
        this.mScreenHeight = i2;
    }
}
