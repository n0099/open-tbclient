package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.gift.d;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c afI;
    private int ajP;
    private boolean ajw;
    private com.baidu.live.gift.biggift.b akg;
    private AlaBigGiftExtraInfoRevisionView akh;
    private AlaDynamicGiftAnimationView aki;
    public d akj;
    private a akk;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.ajw = true;
        this.akk = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bE(i);
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.bm(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.akh != null) {
                    AlaDynamicGiftLayout.this.akh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.ajw = true;
        this.akk = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bE(i);
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.bm(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.akh != null) {
                    AlaDynamicGiftLayout.this.akh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.ajw = true;
        this.akk = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bE(i2);
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.bm(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.akh != null) {
                    AlaDynamicGiftLayout.this.akh.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.akg != null) {
                    AlaDynamicGiftLayout.this.akg.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aki = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aki.setFrameCallback(this.akk);
        this.akh = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.akh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.rH();
            }
        });
        this.ajw = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.adJ != null && cVar.adJ.adI != null) {
            this.afI = cVar2;
            if (i > 0 && i2 > 0) {
                t(i, i2);
            } else {
                sS();
            }
            this.akj = cVar.adJ.adI;
            this.mFrameCount = this.akj.frame_count;
            if (this.akh != null) {
                if (!cVar2.sH()) {
                    this.akh.setVisibility(8);
                    this.ajw = false;
                } else {
                    this.akh.setData(cVar2);
                    this.ajw = true;
                }
            }
            if (this.aki != null) {
                this.aki.setScreen(this.ajP, this.mScreenHeight);
                this.aki.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH() {
        if (this.afI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.afI.userId), this.afI.userName, this.afI.portrait, this.afI.sex, this.afI.ajq, this.afI.location, this.afI.description, 0L, this.afI.fansCount, this.afI.ajr, this.afI.userStatus, this.afI.liveId, this.afI.groupId, this.afI.aju, this.afI.ajv, this.afI.appId, this.afI.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(int i) {
        if (this.akh != null && this.ajw) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.akh.rE();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.akh.rF();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aki != null) {
            this.aki.startAnim();
            this.isShowing = true;
            if (this.akg != null) {
                this.akg.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aki != null) {
                this.aki.stopAnim();
            }
            if (this.akh != null) {
                this.akh.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.akg = bVar;
    }

    public void onDestroy() {
        if (this.aki != null) {
            this.aki.onDestroy();
        }
        if (this.akh != null) {
            this.akh.onDestroy();
        }
    }

    public void aL(boolean z) {
        sS();
        if (this.aki != null) {
            this.aki.setScreen(this.ajP, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.akg != null) {
            this.akg.onEnd();
        }
    }

    private void sS() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.ajP = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void t(int i, int i2) {
        this.ajP = i;
        this.mScreenHeight = i2;
    }
}
