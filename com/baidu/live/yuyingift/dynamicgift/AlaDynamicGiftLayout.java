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
/* loaded from: classes11.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.a.c bYI;
    private com.baidu.live.yuyingift.biggift.b bZY;
    private AlaBigGiftExtraInfoRevisionView bZZ;
    private boolean beH;
    public d bfI;
    private int bfn;
    private AlaDynamicGiftAnimationView caa;
    private boolean cab;
    private AlaDynamicGiftAnimationView.a cac;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.beH = true;
        this.cac = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eK(i);
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.eo(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZZ != null) {
                    AlaDynamicGiftLayout.this.bZZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.l(AlaDynamicGiftLayout.this.bYI);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.beH = true;
        this.cac = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eK(i);
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.eo(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZZ != null) {
                    AlaDynamicGiftLayout.this.bZZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.l(AlaDynamicGiftLayout.this.bYI);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.beH = true;
        this.cac = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.eK(i2);
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.eo(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZZ != null) {
                    AlaDynamicGiftLayout.this.bZZ.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZY != null) {
                    AlaDynamicGiftLayout.this.bZY.l(AlaDynamicGiftLayout.this.bYI);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.caa = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.caa.setFrameCallback(this.cac);
        Space space = (Space) findViewById(a.f.space);
        if (this.bYI != null && this.bYI.beF && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bZZ = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.Il();
            }
        });
        this.beH = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.cab != z) {
            this.cab = z;
            dG(this.cab);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aXb != null && cVar.aXb.aWZ != null) {
            this.bYI = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                JA();
            }
            this.bfI = cVar.aXb.aWZ;
            this.mFrameCount = this.bfI.frame_count;
            if (this.bZZ != null) {
                if (!cVar2.Jo()) {
                    this.bZZ.setVisibility(8);
                    this.beH = false;
                } else {
                    this.bZZ.setData(cVar2);
                    this.beH = true;
                }
            }
            if (this.caa != null) {
                this.caa.setScreen(this.bfn, this.mScreenHeight);
                this.caa.setData(cVar);
            }
            dG(this.cab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (this.bYI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bYI.userId), this.bYI.userName, this.bYI.portrait, this.bYI.sex, this.bYI.bez, this.bYI.location, this.bYI.description, 0L, this.bYI.fansCount, this.bYI.followCount, this.bYI.userStatus, this.bYI.liveId, this.bYI.groupId, this.bYI.beF, this.bYI.beG, this.bYI.appId, this.bYI.userName, "")));
        }
    }

    private void dG(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (runTask != null && (layoutParams = getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.bYI != null && this.bYI.beI) {
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
    public void eK(int i) {
        if (this.bZZ != null && this.beH) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bZZ.Ii();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bZZ.Ij();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.caa != null) {
            this.caa.startAnim();
            this.isShowing = true;
            if (this.bZY != null) {
                this.bZY.k(this.bYI);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.caa != null) {
                this.caa.stopAnim();
            }
            if (this.bZZ != null) {
                this.bZZ.end();
            }
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.bYI;
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bZY = bVar;
    }

    public void onDestroy() {
        if (this.caa != null) {
            this.caa.onDestroy();
        }
        if (this.bZZ != null) {
            this.bZZ.onDestroy();
        }
    }

    public void bX(boolean z) {
        JA();
        if (this.caa != null) {
            this.caa.setScreen(this.bfn, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bZY != null) {
            this.bZY.l(this.bYI);
        }
    }

    private void JA() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bfn = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bfn = i;
        this.mScreenHeight = i2;
    }
}
