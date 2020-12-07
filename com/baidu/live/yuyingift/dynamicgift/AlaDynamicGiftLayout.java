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
    private com.baidu.live.yuyingift.a.c bSY;
    private com.baidu.live.yuyingift.biggift.b bUg;
    private AlaBigGiftExtraInfoRevisionView bUh;
    private AlaDynamicGiftAnimationView bUi;
    private a bUj;
    private boolean bcZ;
    private int bdA;
    public d bdV;
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
        this.bcZ = true;
        this.bUj = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eM(i);
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.eq(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bUh != null) {
                    AlaDynamicGiftLayout.this.bUh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.m(AlaDynamicGiftLayout.this.bSY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bcZ = true;
        this.bUj = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eM(i);
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.eq(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bUh != null) {
                    AlaDynamicGiftLayout.this.bUh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.m(AlaDynamicGiftLayout.this.bSY);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bcZ = true;
        this.bUj = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.eM(i2);
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.eq(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bUh != null) {
                    AlaDynamicGiftLayout.this.bUh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bUg != null) {
                    AlaDynamicGiftLayout.this.bUg.m(AlaDynamicGiftLayout.this.bSY);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bUi = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bUi.setFrameCallback(this.bUj);
        Space space = (Space) findViewById(a.f.space);
        if (this.bSY != null && this.bSY.bcX && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bUh = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.IJ();
            }
        });
        this.bcZ = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVv != null && cVar.aVv.aVu != null) {
            this.bSY = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                JY();
            }
            this.bdV = cVar.aVv.aVu;
            this.mFrameCount = this.bdV.frame_count;
            if (this.bUh != null) {
                if (!cVar2.JM()) {
                    this.bUh.setVisibility(8);
                    this.bcZ = false;
                } else {
                    this.bUh.setData(cVar2);
                    this.bcZ = true;
                }
            }
            if (this.bUi != null) {
                this.bUi.setScreen(this.bdA, this.mScreenHeight);
                this.bUi.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ() {
        if (this.bSY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bSY.userId), this.bSY.userName, this.bSY.portrait, this.bSY.sex, this.bSY.bcP, this.bSY.location, this.bSY.description, 0L, this.bSY.bcR, this.bSY.bcQ, this.bSY.userStatus, this.bSY.liveId, this.bSY.groupId, this.bSY.bcX, this.bSY.bcY, this.bSY.appId, this.bSY.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(int i) {
        if (this.bUh != null && this.bcZ) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bUh.IG();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bUh.IH();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bUi != null) {
            this.bUi.startAnim();
            this.isShowing = true;
            if (this.bUg != null) {
                this.bUg.l(this.bSY);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bUi != null) {
                this.bUi.stopAnim();
            }
            if (this.bUh != null) {
                this.bUh.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bUg = bVar;
    }

    public void onDestroy() {
        if (this.bUi != null) {
            this.bUi.onDestroy();
        }
        if (this.bUh != null) {
            this.bUh.onDestroy();
        }
    }

    public void bZ(boolean z) {
        JY();
        if (this.bUi != null) {
            this.bUi.setScreen(this.bdA, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bUg != null) {
            this.bUg.m(this.bSY);
        }
    }

    private void JY() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bdA = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bdA = i;
        this.mScreenHeight = i2;
    }
}
