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
    private com.baidu.live.yuyingift.a.c bXV;
    private com.baidu.live.yuyingift.biggift.b bZo;
    private AlaBigGiftExtraInfoRevisionView bZp;
    private AlaDynamicGiftAnimationView bZq;
    private boolean bZr;
    private AlaDynamicGiftAnimationView.a bZs;
    private boolean bcY;
    private int bdD;
    public d bdX;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.bcY = true;
        this.bZs = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dj(i);
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.cN(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZp != null) {
                    AlaDynamicGiftLayout.this.bZp.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.l(AlaDynamicGiftLayout.this.bXV);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bcY = true;
        this.bZs = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dj(i);
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.cN(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZp != null) {
                    AlaDynamicGiftLayout.this.bZp.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.l(AlaDynamicGiftLayout.this.bXV);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bcY = true;
        this.bZs = new AlaDynamicGiftAnimationView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.dj(i2);
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.cN(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftAnimationView.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bZp != null) {
                    AlaDynamicGiftLayout.this.bZp.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bZo != null) {
                    AlaDynamicGiftLayout.this.bZo.l(AlaDynamicGiftLayout.this.bXV);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bZq = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bZq.setFrameCallback(this.bZs);
        Space space = (Space) findViewById(a.f.space);
        if (this.bXV != null && this.bXV.bcW && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bZp = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bZp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.FG();
            }
        });
        this.bcY = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.bZr != z) {
            this.bZr = z;
            dK(this.bZr);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVs != null && cVar.aVs.aVq != null) {
            this.bXV = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                GV();
            }
            this.bdX = cVar.aVs.aVq;
            this.mFrameCount = this.bdX.frame_count;
            if (this.bZp != null) {
                if (!cVar2.GJ()) {
                    this.bZp.setVisibility(8);
                    this.bcY = false;
                } else {
                    this.bZp.setData(cVar2);
                    this.bcY = true;
                }
            }
            if (this.bZq != null) {
                this.bZq.setScreen(this.bdD, this.mScreenHeight);
                this.bZq.setData(cVar);
            }
            dK(this.bZr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.bXV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bXV.userId), this.bXV.userName, this.bXV.portrait, this.bXV.sex, this.bXV.bcQ, this.bXV.location, this.bXV.description, 0L, this.bXV.fansCount, this.bXV.followCount, this.bXV.userStatus, this.bXV.liveId, this.bXV.groupId, this.bXV.bcW, this.bXV.bcX, this.bXV.appId, this.bXV.userName, "")));
        }
    }

    private void dK(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (runTask != null && (layoutParams = getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.bXV != null && this.bXV.bcZ) {
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
    public void dj(int i) {
        if (this.bZp != null && this.bcY) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bZp.FD();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bZp.FE();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bZq != null) {
            this.bZq.startAnim();
            this.isShowing = true;
            if (this.bZo != null) {
                this.bZo.k(this.bXV);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bZq != null) {
                this.bZq.stopAnim();
            }
            if (this.bZp != null) {
                this.bZp.end();
            }
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.bXV;
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bZo = bVar;
    }

    public void onDestroy() {
        if (this.bZq != null) {
            this.bZq.onDestroy();
        }
        if (this.bZp != null) {
            this.bZp.onDestroy();
        }
    }

    public void bY(boolean z) {
        GV();
        if (this.bZq != null) {
            this.bZq.setScreen(this.bdD, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bZo != null) {
            this.bZo.l(this.bXV);
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
