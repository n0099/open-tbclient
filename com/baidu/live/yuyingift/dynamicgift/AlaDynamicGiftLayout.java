package com.baidu.live.yuyingift.dynamicgift;

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
import com.baidu.live.gift.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
/* loaded from: classes4.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private boolean aZT;
    private com.baidu.live.yuyingift.a.c bJW;
    private com.baidu.live.yuyingift.biggift.b bKY;
    private AlaBigGiftExtraInfoRevisionView bKZ;
    private AlaDynamicGiftAnimationView bLa;
    private a bLb;
    public d baO;
    private int bau;
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
        this.aZT = true;
        this.bLb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.ea(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bKZ != null) {
                    AlaDynamicGiftLayout.this.bKZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.m(AlaDynamicGiftLayout.this.bJW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZT = true;
        this.bLb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.ea(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bKZ != null) {
                    AlaDynamicGiftLayout.this.bKZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.m(AlaDynamicGiftLayout.this.bJW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZT = true;
        this.bLb = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ev(i2);
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.ea(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bKZ != null) {
                    AlaDynamicGiftLayout.this.bKZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bKY != null) {
                    AlaDynamicGiftLayout.this.bKY.m(AlaDynamicGiftLayout.this.bJW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bLa = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.bLa.setFrameCallback(this.bLb);
        Space space = (Space) findViewById(a.g.space);
        if (this.bJW != null && this.bJW.aZR && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bKZ = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.bKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Ha();
            }
        });
        this.aZT = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSL != null && cVar.aSL.aSK != null) {
            this.bJW = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Ip();
            }
            this.baO = cVar.aSL.aSK;
            this.mFrameCount = this.baO.frame_count;
            if (this.bKZ != null) {
                if (!cVar2.Id()) {
                    this.bKZ.setVisibility(8);
                    this.aZT = false;
                } else {
                    this.bKZ.setData(cVar2);
                    this.aZT = true;
                }
            }
            if (this.bLa != null) {
                this.bLa.setScreen(this.bau, this.mScreenHeight);
                this.bLa.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (this.bJW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bJW.userId), this.bJW.userName, this.bJW.portrait, this.bJW.sex, this.bJW.aZL, this.bJW.location, this.bJW.description, 0L, this.bJW.fansCount, this.bJW.aZM, this.bJW.userStatus, this.bJW.liveId, this.bJW.groupId, this.bJW.aZR, this.bJW.aZS, this.bJW.appId, this.bJW.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        if (this.bKZ != null && this.aZT) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bKZ.GX();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bKZ.GY();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bLa != null) {
            this.bLa.startAnim();
            this.isShowing = true;
            if (this.bKY != null) {
                this.bKY.l(this.bJW);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bLa != null) {
                this.bLa.stopAnim();
            }
            if (this.bKZ != null) {
                this.bKZ.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bKY = bVar;
    }

    public void onDestroy() {
        if (this.bLa != null) {
            this.bLa.onDestroy();
        }
        if (this.bKZ != null) {
            this.bKZ.onDestroy();
        }
    }

    public void bN(boolean z) {
        Ip();
        if (this.bLa != null) {
            this.bLa.setScreen(this.bau, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bKY != null) {
            this.bKY.m(this.bJW);
        }
    }

    private void Ip() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bau = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.bau = i;
        this.mScreenHeight = i2;
    }
}
