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
    private com.baidu.live.gift.a.c aAA;
    private int aEE;
    private com.baidu.live.gift.biggift.b aEV;
    private AlaBigGiftExtraInfoRevisionView aEW;
    private AlaDynamicGiftAnimationView aEX;
    public d aEY;
    private a aEZ;
    private boolean aEl;
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
        this.aEl = true;
        this.aEZ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cb(i);
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.bG(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEW != null) {
                    AlaDynamicGiftLayout.this.aEW.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aEl = true;
        this.aEZ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cb(i);
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.bG(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEW != null) {
                    AlaDynamicGiftLayout.this.aEW.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aEl = true;
        this.aEZ = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.cb(i2);
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.bG(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEW != null) {
                    AlaDynamicGiftLayout.this.aEW.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEV != null) {
                    AlaDynamicGiftLayout.this.aEV.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aEX = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aEX.setFrameCallback(this.aEZ);
        Space space = (Space) findViewById(a.g.space);
        if (this.aAA != null && this.aAA.aEj && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.aEW = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.xp();
            }
        });
        this.aEl = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.ays != null && cVar.ays.ayr != null) {
            this.aAA = cVar2;
            if (i > 0 && i2 > 0) {
                t(i, i2);
            } else {
                yC();
            }
            this.aEY = cVar.ays.ayr;
            this.mFrameCount = this.aEY.frame_count;
            if (this.aEW != null) {
                if (!cVar2.yr()) {
                    this.aEW.setVisibility(8);
                    this.aEl = false;
                } else {
                    this.aEW.setData(cVar2);
                    this.aEl = true;
                }
            }
            if (this.aEX != null) {
                this.aEX.setScreen(this.aEE, this.mScreenHeight);
                this.aEX.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp() {
        if (this.aAA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAA.userId), this.aAA.userName, this.aAA.portrait, this.aAA.sex, this.aAA.aEf, this.aAA.location, this.aAA.description, 0L, this.aAA.fansCount, this.aAA.aEg, this.aAA.userStatus, this.aAA.liveId, this.aAA.groupId, this.aAA.aEj, this.aAA.aEk, this.aAA.appId, this.aAA.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i) {
        if (this.aEW != null && this.aEl) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aEW.xm();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aEW.xn();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aEX != null) {
            this.aEX.startAnim();
            this.isShowing = true;
            if (this.aEV != null) {
                this.aEV.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aEX != null) {
                this.aEX.stopAnim();
            }
            if (this.aEW != null) {
                this.aEW.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEV = bVar;
    }

    public void onDestroy() {
        if (this.aEX != null) {
            this.aEX.onDestroy();
        }
        if (this.aEW != null) {
            this.aEW.onDestroy();
        }
    }

    public void bq(boolean z) {
        yC();
        if (this.aEX != null) {
            this.aEX.setScreen(this.aEE, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aEV != null) {
            this.aEV.onEnd();
        }
    }

    private void yC() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aEE = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void t(int i, int i2) {
        this.aEE = i;
        this.mScreenHeight = i2;
    }
}
