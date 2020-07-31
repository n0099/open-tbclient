package com.baidu.live.gift.dynamicGift;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Space;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.gift.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aJL;
    private boolean aNL;
    private AlaDynamicGiftAnimationView aOA;
    public d aOB;
    private a aOC;
    private int aOh;
    private com.baidu.live.gift.biggift.b aOy;
    private AlaBigGiftExtraInfoRevisionView aOz;
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
        this.aNL = true;
        this.aOC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cw(i);
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.cb(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aOz != null) {
                    AlaDynamicGiftLayout.this.aOz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.m(AlaDynamicGiftLayout.this.aJL);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aNL = true;
        this.aOC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cw(i);
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.cb(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aOz != null) {
                    AlaDynamicGiftLayout.this.aOz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.m(AlaDynamicGiftLayout.this.aJL);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aNL = true;
        this.aOC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.cw(i2);
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.cb(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aOz != null) {
                    AlaDynamicGiftLayout.this.aOz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aOy != null) {
                    AlaDynamicGiftLayout.this.aOy.m(AlaDynamicGiftLayout.this.aJL);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aOA = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aOA.setFrameCallback(this.aOC);
        Space space = (Space) findViewById(a.g.space);
        if (this.aJL != null && this.aJL.aNJ && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.aOz = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aOz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.zF();
            }
        });
        this.aNL = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aHB != null && cVar.aHB.aHA != null) {
            this.aJL = cVar2;
            if (i > 0 && i2 > 0) {
                v(i, i2);
            } else {
                AU();
            }
            this.aOB = cVar.aHB.aHA;
            this.mFrameCount = this.aOB.frame_count;
            if (this.aOz != null) {
                if (!cVar2.AJ()) {
                    this.aOz.setVisibility(8);
                    this.aNL = false;
                } else {
                    this.aOz.setData(cVar2);
                    this.aNL = true;
                }
            }
            if (this.aOA != null) {
                this.aOA.setScreen(this.aOh, this.mScreenHeight);
                this.aOA.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF() {
        if (this.aJL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aJL.userId), this.aJL.userName, this.aJL.portrait, this.aJL.sex, this.aJL.aNF, this.aJL.location, this.aJL.description, 0L, this.aJL.fansCount, this.aJL.aNG, this.aJL.userStatus, this.aJL.liveId, this.aJL.groupId, this.aJL.aNJ, this.aJL.aNK, this.aJL.appId, this.aJL.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i) {
        if (this.aOz != null && this.aNL) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aOz.zC();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aOz.zD();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aOA != null) {
            this.aOA.startAnim();
            this.isShowing = true;
            if (this.aOy != null) {
                this.aOy.l(this.aJL);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aOA != null) {
                this.aOA.stopAnim();
            }
            if (this.aOz != null) {
                this.aOz.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aOy = bVar;
    }

    public void onDestroy() {
        if (this.aOA != null) {
            this.aOA.onDestroy();
        }
        if (this.aOz != null) {
            this.aOz.onDestroy();
        }
    }

    public void bB(boolean z) {
        AU();
        if (this.aOA != null) {
            this.aOA.setScreen(this.aOh, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aOy != null) {
            this.aOy.m(this.aJL);
        }
    }

    private void AU() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aOh = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void v(int i, int i2) {
        this.aOh = i;
        this.mScreenHeight = i2;
    }
}
