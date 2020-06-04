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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aFT;
    private boolean aJK;
    public d aKA;
    private a aKB;
    private int aKg;
    private com.baidu.live.gift.biggift.b aKx;
    private AlaBigGiftExtraInfoRevisionView aKy;
    private AlaDynamicGiftAnimationView aKz;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aJK = true;
        this.aKB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ck(i);
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.bP(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aKy != null) {
                    AlaDynamicGiftLayout.this.aKy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.m(AlaDynamicGiftLayout.this.aFT);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aJK = true;
        this.aKB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ck(i);
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.bP(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aKy != null) {
                    AlaDynamicGiftLayout.this.aKy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.m(AlaDynamicGiftLayout.this.aFT);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aJK = true;
        this.aKB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ck(i2);
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.bP(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aKy != null) {
                    AlaDynamicGiftLayout.this.aKy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aKx != null) {
                    AlaDynamicGiftLayout.this.aKx.m(AlaDynamicGiftLayout.this.aFT);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aKz = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aKz.setFrameCallback(this.aKB);
        Space space = (Space) findViewById(a.g.space);
        if (this.aFT != null && this.aFT.aJI && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.aKy = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.yD();
            }
        });
        this.aJK = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aDK != null && cVar.aDK.aDJ != null) {
            this.aFT = cVar2;
            if (i > 0 && i2 > 0) {
                t(i, i2);
            } else {
                zS();
            }
            this.aKA = cVar.aDK.aDJ;
            this.mFrameCount = this.aKA.frame_count;
            if (this.aKy != null) {
                if (!cVar2.zH()) {
                    this.aKy.setVisibility(8);
                    this.aJK = false;
                } else {
                    this.aKy.setData(cVar2);
                    this.aJK = true;
                }
            }
            if (this.aKz != null) {
                this.aKz.setScreen(this.aKg, this.mScreenHeight);
                this.aKz.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD() {
        if (this.aFT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aFT.userId), this.aFT.userName, this.aFT.portrait, this.aFT.sex, this.aFT.aJE, this.aFT.location, this.aFT.description, 0L, this.aFT.fansCount, this.aFT.aJF, this.aFT.userStatus, this.aFT.liveId, this.aFT.groupId, this.aFT.aJI, this.aFT.aJJ, this.aFT.appId, this.aFT.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(int i) {
        if (this.aKy != null && this.aJK) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aKy.yA();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aKy.yB();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aKz != null) {
            this.aKz.startAnim();
            this.isShowing = true;
            if (this.aKx != null) {
                this.aKx.l(this.aFT);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aKz != null) {
                this.aKz.stopAnim();
            }
            if (this.aKy != null) {
                this.aKy.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aKx = bVar;
    }

    public void onDestroy() {
        if (this.aKz != null) {
            this.aKz.onDestroy();
        }
        if (this.aKy != null) {
            this.aKy.onDestroy();
        }
    }

    public void by(boolean z) {
        zS();
        if (this.aKz != null) {
            this.aKz.setScreen(this.aKg, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aKx != null) {
            this.aKx.m(this.aFT);
        }
    }

    private void zS() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aKg = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void t(int i, int i2) {
        this.aKg = i;
        this.mScreenHeight = i2;
    }
}
