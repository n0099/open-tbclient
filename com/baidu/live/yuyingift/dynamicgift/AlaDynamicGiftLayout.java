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
    private boolean aZA;
    private com.baidu.live.yuyingift.a.c bNS;
    private com.baidu.live.yuyingift.biggift.b bOW;
    private AlaBigGiftExtraInfoRevisionView bOX;
    private AlaDynamicGiftAnimationView bOY;
    private a bOZ;
    private int baa;
    public d bav;
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
        this.aZA = true;
        this.bOZ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.er(i);
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.dW(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bOX != null) {
                    AlaDynamicGiftLayout.this.bOX.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.m(AlaDynamicGiftLayout.this.bNS);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aZA = true;
        this.bOZ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.er(i);
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.dW(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bOX != null) {
                    AlaDynamicGiftLayout.this.bOX.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.m(AlaDynamicGiftLayout.this.bNS);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aZA = true;
        this.bOZ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.er(i2);
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.dW(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bOX != null) {
                    AlaDynamicGiftLayout.this.bOX.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bOW != null) {
                    AlaDynamicGiftLayout.this.bOW.m(AlaDynamicGiftLayout.this.bNS);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bOY = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bOY.setFrameCallback(this.bOZ);
        Space space = (Space) findViewById(a.f.space);
        if (this.bNS != null && this.bNS.aZy && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bOX = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bOX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.GS();
            }
        });
        this.aZA = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSt != null && cVar.aSt.aSs != null) {
            this.bNS = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                Ih();
            }
            this.bav = cVar.aSt.aSs;
            this.mFrameCount = this.bav.frame_count;
            if (this.bOX != null) {
                if (!cVar2.HV()) {
                    this.bOX.setVisibility(8);
                    this.aZA = false;
                } else {
                    this.bOX.setData(cVar2);
                    this.aZA = true;
                }
            }
            if (this.bOY != null) {
                this.bOY.setScreen(this.baa, this.mScreenHeight);
                this.bOY.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        if (this.bNS != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bNS.userId), this.bNS.userName, this.bNS.portrait, this.bNS.sex, this.bNS.aZs, this.bNS.location, this.bNS.description, 0L, this.bNS.fansCount, this.bNS.aZt, this.bNS.userStatus, this.bNS.liveId, this.bNS.groupId, this.bNS.aZy, this.bNS.aZz, this.bNS.appId, this.bNS.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(int i) {
        if (this.bOX != null && this.aZA) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bOX.GP();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bOX.GQ();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bOY != null) {
            this.bOY.startAnim();
            this.isShowing = true;
            if (this.bOW != null) {
                this.bOW.l(this.bNS);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bOY != null) {
                this.bOY.stopAnim();
            }
            if (this.bOX != null) {
                this.bOX.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bOW = bVar;
    }

    public void onDestroy() {
        if (this.bOY != null) {
            this.bOY.onDestroy();
        }
        if (this.bOX != null) {
            this.bOX.onDestroy();
        }
    }

    public void bQ(boolean z) {
        Ih();
        if (this.bOY != null) {
            this.bOY.setScreen(this.baa, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bOW != null) {
            this.bOW.m(this.bNS);
        }
    }

    private void Ih() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.baa = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.baa = i;
        this.mScreenHeight = i2;
    }
}
