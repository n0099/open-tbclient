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
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView;
/* loaded from: classes10.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private boolean aZR;
    private com.baidu.live.yuyingift.a.c bTW;
    private com.baidu.live.yuyingift.biggift.b bVm;
    private AlaBigGiftExtraInfoRevisionView bVn;
    private AlaDynamicGiftAnimationView bVo;
    private boolean bVp;
    private AlaDynamicGiftAnimationView.a bVq;
    public d baS;
    private int bax;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aZR = true;
        this.bVq = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.de(i);
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.cI(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bVn != null) {
                    AlaDynamicGiftLayout.this.bVn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.l(AlaDynamicGiftLayout.this.bTW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZR = true;
        this.bVq = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.de(i);
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.cI(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bVn != null) {
                    AlaDynamicGiftLayout.this.bVn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.l(AlaDynamicGiftLayout.this.bTW);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZR = true;
        this.bVq = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.de(i2);
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.cI(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bVn != null) {
                    AlaDynamicGiftLayout.this.bVn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bVm != null) {
                    AlaDynamicGiftLayout.this.bVm.l(AlaDynamicGiftLayout.this.bTW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bVo = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bVo.setFrameCallback(this.bVq);
        Space space = (Space) findViewById(a.f.space);
        if (this.bTW != null && this.bTW.aZP && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bVn = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Eq();
            }
        });
        this.aZR = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.bVp != z) {
            this.bVp = z;
            dC(this.bVp);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSo != null && cVar.aSo.aSm != null) {
            this.bTW = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                FF();
            }
            this.baS = cVar.aSo.aSm;
            this.mFrameCount = this.baS.frame_count;
            if (this.bVn != null) {
                if (!cVar2.Ft()) {
                    this.bVn.setVisibility(8);
                    this.aZR = false;
                } else {
                    this.bVn.setData(cVar2);
                    this.aZR = true;
                }
            }
            if (this.bVo != null) {
                this.bVo.setScreen(this.bax, this.mScreenHeight);
                this.bVo.setData(cVar);
            }
            dC(this.bVp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        if (this.bTW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bTW.userId), this.bTW.userName, this.bTW.portrait, this.bTW.sex, this.bTW.aZJ, this.bTW.location, this.bTW.description, 0L, this.bTW.fansCount, this.bTW.followCount, this.bTW.userStatus, this.bTW.liveId, this.bTW.groupId, this.bTW.aZP, this.bTW.aZQ, this.bTW.appId, this.bTW.userName, "")));
        }
    }

    private void dC(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (runTask != null && (layoutParams = getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.bTW != null && this.bTW.aZS) {
            int intValue = ((Integer) runTask.getData()).intValue();
            if (z) {
                int realScreenHeight = ScreenHelper.getRealScreenHeight(getContext());
                int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight() + intValue;
                int height = getHeight();
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = realScreenHeight - keyboardHeight < height ? (realScreenHeight - height) - BdUtilHelper.dip2px(getContext(), 20.0f) : keyboardHeight;
            } else {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = intValue + getBoottomBarHeight();
            }
            setLayoutParams(layoutParams);
        }
    }

    private int getBoottomBarHeight() {
        return (int) TbadkCoreApplication.getInst().getResources().getDimension(a.d.sdk_ds120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i) {
        if (this.bVn != null && this.aZR) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bVn.En();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bVn.Eo();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bVo != null) {
            this.bVo.startAnim();
            this.isShowing = true;
            if (this.bVm != null) {
                this.bVm.k(this.bTW);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bVo != null) {
                this.bVo.stopAnim();
            }
            if (this.bVn != null) {
                this.bVn.end();
            }
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.bTW;
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bVm = bVar;
    }

    public void onDestroy() {
        if (this.bVo != null) {
            this.bVo.onDestroy();
        }
        if (this.bVn != null) {
            this.bVn.onDestroy();
        }
    }

    public void bT(boolean z) {
        FF();
        if (this.bVo != null) {
            this.bVo.setScreen(this.bax, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bVm != null) {
            this.bVm.l(this.bTW);
        }
    }

    private void FF() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bax = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bax = i;
        this.mScreenHeight = i2;
    }
}
