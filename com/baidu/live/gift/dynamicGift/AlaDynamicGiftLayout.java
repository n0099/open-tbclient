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
    private com.baidu.live.gift.a.c aAu;
    private com.baidu.live.gift.biggift.b aEP;
    private AlaBigGiftExtraInfoRevisionView aEQ;
    private AlaDynamicGiftAnimationView aER;
    public d aES;
    private a aET;
    private boolean aEf;
    private int aEy;
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
        this.aEf = true;
        this.aET = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cb(i);
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.bG(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEQ != null) {
                    AlaDynamicGiftLayout.this.aEQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aEf = true;
        this.aET = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cb(i);
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.bG(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEQ != null) {
                    AlaDynamicGiftLayout.this.aEQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aEf = true;
        this.aET = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.cb(i2);
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.bG(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aEQ != null) {
                    AlaDynamicGiftLayout.this.aEQ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aEP != null) {
                    AlaDynamicGiftLayout.this.aEP.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aER = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aER.setFrameCallback(this.aET);
        Space space = (Space) findViewById(a.g.space);
        if (this.aAu != null && this.aAu.aEd && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.aEQ = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.xq();
            }
        });
        this.aEf = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aym != null && cVar.aym.ayl != null) {
            this.aAu = cVar2;
            if (i > 0 && i2 > 0) {
                t(i, i2);
            } else {
                yD();
            }
            this.aES = cVar.aym.ayl;
            this.mFrameCount = this.aES.frame_count;
            if (this.aEQ != null) {
                if (!cVar2.ys()) {
                    this.aEQ.setVisibility(8);
                    this.aEf = false;
                } else {
                    this.aEQ.setData(cVar2);
                    this.aEf = true;
                }
            }
            if (this.aER != null) {
                this.aER.setScreen(this.aEy, this.mScreenHeight);
                this.aER.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq() {
        if (this.aAu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aAu.userId), this.aAu.userName, this.aAu.portrait, this.aAu.sex, this.aAu.aDZ, this.aAu.location, this.aAu.description, 0L, this.aAu.fansCount, this.aAu.aEa, this.aAu.userStatus, this.aAu.liveId, this.aAu.groupId, this.aAu.aEd, this.aAu.aEe, this.aAu.appId, this.aAu.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i) {
        if (this.aEQ != null && this.aEf) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aEQ.xn();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aEQ.xo();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aER != null) {
            this.aER.startAnim();
            this.isShowing = true;
            if (this.aEP != null) {
                this.aEP.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aER != null) {
                this.aER.stopAnim();
            }
            if (this.aEQ != null) {
                this.aEQ.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEP = bVar;
    }

    public void onDestroy() {
        if (this.aER != null) {
            this.aER.onDestroy();
        }
        if (this.aEQ != null) {
            this.aEQ.onDestroy();
        }
    }

    public void bq(boolean z) {
        yD();
        if (this.aER != null) {
            this.aER.setScreen(this.aEy, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aEP != null) {
            this.aEP.onEnd();
        }
    }

    private void yD() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aEy = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void t(int i, int i2) {
        this.aEy = i;
        this.mScreenHeight = i2;
    }
}
