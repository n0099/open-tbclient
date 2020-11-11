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
    private com.baidu.live.yuyingift.a.c bPC;
    private com.baidu.live.yuyingift.biggift.b bQG;
    private AlaBigGiftExtraInfoRevisionView bQH;
    private AlaDynamicGiftAnimationView bQI;
    private a bQJ;
    private int bbM;
    private boolean bbm;
    public d bcg;
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
        this.bbm = true;
        this.bQJ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.ea(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bQH != null) {
                    AlaDynamicGiftLayout.this.bQH.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.m(AlaDynamicGiftLayout.this.bPC);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bbm = true;
        this.bQJ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.ev(i);
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.ea(i);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bQH != null) {
                    AlaDynamicGiftLayout.this.bQH.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.m(AlaDynamicGiftLayout.this.bPC);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bbm = true;
        this.bQJ = new a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.ev(i2);
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.ea(i2);
                }
            }

            @Override // com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bQH != null) {
                    AlaDynamicGiftLayout.this.bQH.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bQG != null) {
                    AlaDynamicGiftLayout.this.bQG.m(AlaDynamicGiftLayout.this.bPC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bQI = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bQI.setFrameCallback(this.bQJ);
        Space space = (Space) findViewById(a.f.space);
        if (this.bPC != null && this.bPC.bbk && (this.mContext instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
            space.getLayoutParams().height = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            space.setVisibility(0);
        } else {
            space.setVisibility(8);
        }
        this.bQH = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.HB();
            }
        });
        this.bbm = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aUe != null && cVar.aUe.aUd != null) {
            this.bPC = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                IQ();
            }
            this.bcg = cVar.aUe.aUd;
            this.mFrameCount = this.bcg.frame_count;
            if (this.bQH != null) {
                if (!cVar2.IE()) {
                    this.bQH.setVisibility(8);
                    this.bbm = false;
                } else {
                    this.bQH.setData(cVar2);
                    this.bbm = true;
                }
            }
            if (this.bQI != null) {
                this.bQI.setScreen(this.bbM, this.mScreenHeight);
                this.bQI.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB() {
        if (this.bPC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bPC.userId), this.bPC.userName, this.bPC.portrait, this.bPC.sex, this.bPC.bbe, this.bPC.location, this.bPC.description, 0L, this.bPC.fansCount, this.bPC.bbf, this.bPC.userStatus, this.bPC.liveId, this.bPC.groupId, this.bPC.bbk, this.bPC.bbl, this.bPC.appId, this.bPC.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        if (this.bQH != null && this.bbm) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bQH.Hy();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bQH.Hz();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bQI != null) {
            this.bQI.startAnim();
            this.isShowing = true;
            if (this.bQG != null) {
                this.bQG.l(this.bPC);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bQI != null) {
                this.bQI.stopAnim();
            }
            if (this.bQH != null) {
                this.bQH.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bQG = bVar;
    }

    public void onDestroy() {
        if (this.bQI != null) {
            this.bQI.onDestroy();
        }
        if (this.bQH != null) {
            this.bQH.onDestroy();
        }
    }

    public void bO(boolean z) {
        IQ();
        if (this.bQI != null) {
            this.bQI.setScreen(this.bbM, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bQG != null) {
            this.bQG.m(this.bPC);
        }
    }

    private void IQ() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bbM = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.bbM = i;
        this.mScreenHeight = i2;
    }
}
