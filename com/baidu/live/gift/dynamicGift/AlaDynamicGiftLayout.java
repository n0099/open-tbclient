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
/* loaded from: classes11.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aYz;
    private boolean bcY;
    private int bdD;
    private com.baidu.live.gift.biggift.b bdU;
    private AlaBigGiftExtraInfoRevisionView bdV;
    private AlaDynamicGiftAnimationView bdW;
    public d bdX;
    private a bdY;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.bcY = true;
        this.bdY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dj(i);
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.cN(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdV != null) {
                    AlaDynamicGiftLayout.this.bdV.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.n(AlaDynamicGiftLayout.this.aYz);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bcY = true;
        this.bdY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dj(i);
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.cN(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdV != null) {
                    AlaDynamicGiftLayout.this.bdV.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.n(AlaDynamicGiftLayout.this.aYz);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bcY = true;
        this.bdY = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.dj(i2);
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.cN(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bdV != null) {
                    AlaDynamicGiftLayout.this.bdV.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bdU != null) {
                    AlaDynamicGiftLayout.this.bdU.n(AlaDynamicGiftLayout.this.aYz);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bdW = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bdW.setFrameCallback(this.bdY);
        this.bdV = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.FG();
            }
        });
        this.bcY = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVs != null && cVar.aVs.aVq != null) {
            this.aYz = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                GV();
            }
            this.bdX = cVar.aVs.aVq;
            this.mFrameCount = this.bdX.frame_count;
            if (this.bdV != null) {
                if (!cVar2.GJ()) {
                    this.bdV.setVisibility(8);
                    this.bcY = false;
                } else {
                    this.bdV.setData(cVar2);
                    GU();
                    this.bcY = true;
                }
            }
            if (this.bdW != null) {
                this.bdW.setScreen(this.bdD, this.mScreenHeight);
                this.bdW.setData(cVar);
            }
        }
    }

    private void GU() {
        int dimensionPixelOffset;
        int bn;
        ViewGroup.LayoutParams layoutParams = this.bdV.getLayoutParams();
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
            this.bdV.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.aYz != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aYz.userId), this.aYz.userName, this.aYz.portrait, this.aYz.sex, this.aYz.bcQ, this.aYz.location, this.aYz.description, 0L, this.aYz.fansCount, this.aYz.followCount, this.aYz.userStatus, this.aYz.liveId, this.aYz.groupId, this.aYz.bcW, this.aYz.bcX, this.aYz.appId, this.aYz.userName)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i) {
        if (this.bdV != null && this.bcY) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bdV.FD();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bdV.FE();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        if (!this.isShowing && this.bdW != null) {
            this.bdW.startAnim();
            this.isShowing = true;
            if (this.bdU != null) {
                this.bdU.m(this.aYz);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bdW != null) {
                this.bdW.stopAnim();
            }
            if (this.bdV != null) {
                this.bdV.end();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bdU = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        if (this.bdW != null) {
            this.bdW.onDestroy();
        }
        if (this.bdV != null) {
            this.bdV.onDestroy();
        }
    }

    public void bY(boolean z) {
        GV();
        if (this.bdW != null) {
            this.bdW.setScreen(this.bdD, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bdU != null) {
            this.bdU.n(this.aYz);
        }
    }

    private void GV() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bdD = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bdD = i;
        this.mScreenHeight = i2;
    }
}
