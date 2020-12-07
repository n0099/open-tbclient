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
    private com.baidu.live.gift.a.c aYy;
    private boolean bcZ;
    private int bdA;
    private com.baidu.live.gift.biggift.b bdS;
    private AlaBigGiftExtraInfoRevisionView bdT;
    private AlaDynamicGiftAnimationView bdU;
    public d bdV;
    private a bdW;
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
        this.bcZ = true;
        this.bdW = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eM(i);
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.eq(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdT != null) {
                    AlaDynamicGiftLayout.this.bdT.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.m(AlaDynamicGiftLayout.this.aYy);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bcZ = true;
        this.bdW = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eM(i);
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.eq(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdT != null) {
                    AlaDynamicGiftLayout.this.bdT.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.m(AlaDynamicGiftLayout.this.aYy);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bcZ = true;
        this.bdW = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.eM(i2);
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.eq(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdT != null) {
                    AlaDynamicGiftLayout.this.bdT.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdS != null) {
                    AlaDynamicGiftLayout.this.bdS.m(AlaDynamicGiftLayout.this.aYy);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bdU = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bdU.setFrameCallback(this.bdW);
        this.bdT = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.IJ();
            }
        });
        this.bcZ = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVv != null && cVar.aVv.aVu != null) {
            this.aYy = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                JY();
            }
            this.bdV = cVar.aVv.aVu;
            this.mFrameCount = this.bdV.frame_count;
            if (this.bdT != null) {
                if (!cVar2.JM()) {
                    this.bdT.setVisibility(8);
                    this.bcZ = false;
                } else {
                    this.bdT.setData(cVar2);
                    JX();
                    this.bcZ = true;
                }
            }
            if (this.bdU != null) {
                this.bdU.setScreen(this.bdA, this.mScreenHeight);
                this.bdU.setData(cVar);
            }
        }
    }

    private void JX() {
        int dimensionPixelOffset;
        int bi;
        ViewGroup.LayoutParams layoutParams = this.bdT.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bi = h.bh(getContext());
                } else {
                    bi = h.bi(getContext());
                }
                dimensionPixelOffset = bi + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.bdT.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ() {
        if (this.aYy != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYy.userId), this.aYy.userName, this.aYy.portrait, this.aYy.sex, this.aYy.bcP, this.aYy.location, this.aYy.description, 0L, this.aYy.bcR, this.aYy.bcQ, this.aYy.userStatus, this.aYy.liveId, this.aYy.groupId, this.aYy.bcX, this.aYy.bcY, this.aYy.appId, this.aYy.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(int i) {
        if (this.bdT != null && this.bcZ) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bdT.IG();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bdT.IH();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        if (!this.isShowing && this.bdU != null) {
            this.bdU.startAnim();
            this.isShowing = true;
            if (this.bdS != null) {
                this.bdS.l(this.aYy);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bdU != null) {
                this.bdU.stopAnim();
            }
            if (this.bdT != null) {
                this.bdT.end();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bdS = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        if (this.bdU != null) {
            this.bdU.onDestroy();
        }
        if (this.bdT != null) {
            this.bdT.onDestroy();
        }
    }

    public void bZ(boolean z) {
        JY();
        if (this.bdU != null) {
            this.bdU.setScreen(this.bdA, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bdS != null) {
            this.bdS.m(this.aYy);
        }
    }

    private void JY() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bdA = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bdA = i;
        this.mScreenHeight = i2;
    }
}
