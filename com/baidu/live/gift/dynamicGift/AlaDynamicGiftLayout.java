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
    private com.baidu.live.gift.a.c aOY;
    private com.baidu.live.gift.biggift.b aTN;
    private AlaBigGiftExtraInfoRevisionView aTO;
    private AlaDynamicGiftAnimationView aTP;
    public d aTQ;
    private a aTR;
    private boolean aTa;
    private int aTw;
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
        this.aTa = true;
        this.aTR = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.el(i);
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.dQ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTO != null) {
                    AlaDynamicGiftLayout.this.aTO.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.m(AlaDynamicGiftLayout.this.aOY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aTa = true;
        this.aTR = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.el(i);
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.dQ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTO != null) {
                    AlaDynamicGiftLayout.this.aTO.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.m(AlaDynamicGiftLayout.this.aOY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aTa = true;
        this.aTR = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.el(i2);
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.dQ(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aTO != null) {
                    AlaDynamicGiftLayout.this.aTO.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aTN != null) {
                    AlaDynamicGiftLayout.this.aTN.m(AlaDynamicGiftLayout.this.aOY);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aTP = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aTP.setFrameCallback(this.aTR);
        this.aTO = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Fi();
            }
        });
        this.aTa = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aMN != null && cVar.aMN.aMM != null) {
            this.aOY = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Gy();
            }
            this.aTQ = cVar.aMN.aMM;
            this.mFrameCount = this.aTQ.frame_count;
            if (this.aTO != null) {
                if (!cVar2.Gm()) {
                    this.aTO.setVisibility(8);
                    this.aTa = false;
                } else {
                    this.aTO.setData(cVar2);
                    Gx();
                    this.aTa = true;
                }
            }
            if (this.aTP != null) {
                this.aTP.setScreen(this.aTw, this.mScreenHeight);
                this.aTP.setData(cVar);
            }
        }
    }

    private void Gx() {
        int dimensionPixelOffset;
        int aA;
        ViewGroup.LayoutParams layoutParams = this.aTO.getLayoutParams();
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
            this.aTO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi() {
        if (this.aOY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOY.userId), this.aOY.userName, this.aOY.portrait, this.aOY.sex, this.aOY.aSU, this.aOY.location, this.aOY.description, 0L, this.aOY.fansCount, this.aOY.aSV, this.aOY.userStatus, this.aOY.liveId, this.aOY.groupId, this.aOY.aSY, this.aOY.aSZ, this.aOY.appId, this.aOY.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(int i) {
        if (this.aTO != null && this.aTa) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aTO.Ff();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aTO.Fg();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aTP != null) {
            this.aTP.startAnim();
            this.isShowing = true;
            if (this.aTN != null) {
                this.aTN.l(this.aOY);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aTP != null) {
                this.aTP.stopAnim();
            }
            if (this.aTO != null) {
                this.aTO.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aTN = bVar;
    }

    public void onDestroy() {
        if (this.aTP != null) {
            this.aTP.onDestroy();
        }
        if (this.aTO != null) {
            this.aTO.onDestroy();
        }
    }

    public void bG(boolean z) {
        Gy();
        if (this.aTP != null) {
            this.aTP.setScreen(this.aTw, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aTN != null) {
            this.aTN.m(this.aOY);
        }
    }

    private void Gy() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aTw = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.aTw = i;
        this.mScreenHeight = i2;
    }
}
