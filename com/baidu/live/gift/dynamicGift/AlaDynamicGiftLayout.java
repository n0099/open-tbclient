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
    private com.baidu.live.gift.a.c aVn;
    private boolean aZA;
    private int baa;
    private com.baidu.live.gift.biggift.b bas;
    private AlaBigGiftExtraInfoRevisionView bat;
    private AlaDynamicGiftAnimationView bau;
    public d bav;
    private a baw;
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
        this.aZA = true;
        this.baw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.er(i);
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.dW(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bat != null) {
                    AlaDynamicGiftLayout.this.bat.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.m(AlaDynamicGiftLayout.this.aVn);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZA = true;
        this.baw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.er(i);
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.dW(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bat != null) {
                    AlaDynamicGiftLayout.this.bat.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.m(AlaDynamicGiftLayout.this.aVn);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZA = true;
        this.baw = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.er(i2);
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.dW(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bat != null) {
                    AlaDynamicGiftLayout.this.bat.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bas != null) {
                    AlaDynamicGiftLayout.this.bas.m(AlaDynamicGiftLayout.this.aVn);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bau = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bau.setFrameCallback(this.baw);
        this.bat = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.GS();
            }
        });
        this.aZA = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSt != null && cVar.aSt.aSs != null) {
            this.aVn = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Ih();
            }
            this.bav = cVar.aSt.aSs;
            this.mFrameCount = this.bav.frame_count;
            if (this.bat != null) {
                if (!cVar2.HV()) {
                    this.bat.setVisibility(8);
                    this.aZA = false;
                } else {
                    this.bat.setData(cVar2);
                    Ig();
                    this.aZA = true;
                }
            }
            if (this.bau != null) {
                this.bau.setScreen(this.baa, this.mScreenHeight);
                this.bau.setData(cVar);
            }
        }
    }

    private void Ig() {
        int dimensionPixelOffset;
        int aE;
        ViewGroup.LayoutParams layoutParams = this.bat.getLayoutParams();
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
            this.bat.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        if (this.aVn != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aVn.userId), this.aVn.userName, this.aVn.portrait, this.aVn.sex, this.aVn.aZs, this.aVn.location, this.aVn.description, 0L, this.aVn.fansCount, this.aVn.aZt, this.aVn.userStatus, this.aVn.liveId, this.aVn.groupId, this.aVn.aZy, this.aVn.aZz, this.aVn.appId, this.aVn.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(int i) {
        if (this.bat != null && this.aZA) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bat.GP();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bat.GQ();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bau != null) {
            this.bau.startAnim();
            this.isShowing = true;
            if (this.bas != null) {
                this.bas.l(this.aVn);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bau != null) {
                this.bau.stopAnim();
            }
            if (this.bat != null) {
                this.bat.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bas = bVar;
    }

    public void onDestroy() {
        if (this.bau != null) {
            this.bau.onDestroy();
        }
        if (this.bat != null) {
            this.bat.onDestroy();
        }
    }

    public void bQ(boolean z) {
        Ih();
        if (this.bau != null) {
            this.bau.setScreen(this.baa, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bas != null) {
            this.bas.m(this.aVn);
        }
    }

    private void Ih() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.baa = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.baa = i;
        this.mScreenHeight = i2;
    }
}
