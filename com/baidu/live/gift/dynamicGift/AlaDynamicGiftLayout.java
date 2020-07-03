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
/* loaded from: classes3.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aIp;
    private int aMM;
    private boolean aMq;
    private com.baidu.live.gift.biggift.b aNd;
    private AlaBigGiftExtraInfoRevisionView aNe;
    private AlaDynamicGiftAnimationView aNf;
    public d aNg;
    private a aNh;
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
        this.aMq = true;
        this.aNh = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cq(i);
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.bV(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aNe != null) {
                    AlaDynamicGiftLayout.this.aNe.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.m(AlaDynamicGiftLayout.this.aIp);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aMq = true;
        this.aNh = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.cq(i);
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.bV(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aNe != null) {
                    AlaDynamicGiftLayout.this.aNe.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.m(AlaDynamicGiftLayout.this.aIp);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aMq = true;
        this.aNh = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.cq(i2);
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.bV(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aNe != null) {
                    AlaDynamicGiftLayout.this.aNe.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aNd != null) {
                    AlaDynamicGiftLayout.this.aNd.m(AlaDynamicGiftLayout.this.aIp);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aNf = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aNf.setFrameCallback(this.aNh);
        Space space = (Space) findViewById(a.g.space);
        if (this.aIp != null && this.aIp.aMo && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.aNe = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.zd();
            }
        });
        this.aMq = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aGg != null && cVar.aGg.aGf != null) {
            this.aIp = cVar2;
            if (i > 0 && i2 > 0) {
                v(i, i2);
            } else {
                As();
            }
            this.aNg = cVar.aGg.aGf;
            this.mFrameCount = this.aNg.frame_count;
            if (this.aNe != null) {
                if (!cVar2.Ah()) {
                    this.aNe.setVisibility(8);
                    this.aMq = false;
                } else {
                    this.aNe.setData(cVar2);
                    this.aMq = true;
                }
            }
            if (this.aNf != null) {
                this.aNf.setScreen(this.aMM, this.mScreenHeight);
                this.aNf.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd() {
        if (this.aIp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aIp.userId), this.aIp.userName, this.aIp.portrait, this.aIp.sex, this.aIp.aMk, this.aIp.location, this.aIp.description, 0L, this.aIp.fansCount, this.aIp.aMl, this.aIp.userStatus, this.aIp.liveId, this.aIp.groupId, this.aIp.aMo, this.aIp.aMp, this.aIp.appId, this.aIp.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(int i) {
        if (this.aNe != null && this.aMq) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aNe.za();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aNe.zb();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aNf != null) {
            this.aNf.startAnim();
            this.isShowing = true;
            if (this.aNd != null) {
                this.aNd.l(this.aIp);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aNf != null) {
                this.aNf.stopAnim();
            }
            if (this.aNe != null) {
                this.aNe.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aNd = bVar;
    }

    public void onDestroy() {
        if (this.aNf != null) {
            this.aNf.onDestroy();
        }
        if (this.aNe != null) {
            this.aNe.onDestroy();
        }
    }

    public void by(boolean z) {
        As();
        if (this.aNf != null) {
            this.aNf.setScreen(this.aMM, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aNd != null) {
            this.aNd.m(this.aIp);
        }
    }

    private void As() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aMM = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void v(int i, int i2) {
        this.aMM = i;
        this.mScreenHeight = i2;
    }
}
