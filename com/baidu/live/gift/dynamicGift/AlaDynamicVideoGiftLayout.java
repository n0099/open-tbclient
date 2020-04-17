package com.baidu.live.gift.dynamicGift;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.alphavideo.c;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b aEP;
    private AlaBigGiftExtraInfoRevisionView aEQ;
    private com.baidu.live.alphavideo.c aFb;
    private com.baidu.live.gift.c aFc;
    private com.baidu.live.gift.a.c aFd;
    private int aFe;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int d(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aFe + 1;
        alaDynamicVideoGiftLayout.aFe = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aym != null && cVar.aym.ayl != null) {
            this.aFc = cVar;
            this.aFd = cVar2;
            yG();
        }
    }

    public void xy() {
        stopAnim();
        if (this.aEP != null) {
            this.aEP.onEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEP = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aFe = 0;
        if (this.aFb != null && !this.aFb.isDestroyed()) {
            this.aFb.dB(this.aFc.vF());
        }
        if (this.aEP != null) {
            this.aEP.onStart();
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aFb != null) {
            this.aFb.stop();
            this.aFb.reset();
        }
        if (this.aEQ != null) {
            this.aEQ.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aFb != null) {
            this.aFb.stop();
            this.aFb.release();
        }
        if (this.aEQ != null) {
            this.aEQ.onDestroy();
        }
        removeAllViews();
    }

    private void yG() {
        yH();
        if (this.aFd.ys()) {
            yI();
        }
    }

    private void yH() {
        if (this.aFb == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aFb = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.aFb.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aEQ != null) {
                    AlaDynamicVideoGiftLayout.this.yJ();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.d(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aFc.aym.ayl.repeatCount || AlaDynamicVideoGiftLayout.this.aFb == null || AlaDynamicVideoGiftLayout.this.aFb.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.yM();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aFb.dB(AlaDynamicVideoGiftLayout.this.aFc.vF());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.yM();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aFc != null && AlaDynamicVideoGiftLayout.this.aFc.aym != null) {
                    if (AlaDynamicVideoGiftLayout.this.aFc.aym.ayk != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aFc.aym.ayk.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aFc.aym.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
        if (indexOfChild(this.aFb.getView()) < 0) {
            addView(this.aFb.getView());
        }
        ViewGroup.LayoutParams layoutParams = this.aFb.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        int i = screenDimensions[0];
        int i2 = screenDimensions[1];
        layoutParams.width = -1;
        layoutParams.height = i2 > i ? (i * FormCard.HEIGHT_DEFAULT_SIZE) / FormCard.WIDTH_DEFAULT_SIZE : (i * FormCard.WIDTH_DEFAULT_SIZE) / FormCard.HEIGHT_DEFAULT_SIZE;
        if (this.aFc.aym != null && this.aFc.aym.ayl != null && this.aFc.aym.ayl.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        this.aFb.getView().setLayoutParams(layoutParams);
    }

    private void yI() {
        if (this.aEQ == null) {
            this.aEQ = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aEQ.setData(this.aFd);
        this.aEQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.yN();
            }
        });
        this.aEQ.setVisibility(8);
        if (indexOfChild(this.aEQ) < 0) {
            int i = 0;
            if (this.aFd != null && this.aFd.aEd && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds266);
            layoutParams.addRule(14);
            addView(this.aEQ, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ() {
        if (this.aFb != null) {
            long duration = this.aFb.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.yK();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.yL();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            yK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK() {
        if (this.aEQ != null) {
            this.aEQ.xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL() {
        if (this.aEQ != null) {
            this.aEQ.xo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM() {
        if (this.aEQ != null) {
            this.aEQ.end();
        }
        if (this.aEP != null) {
            this.aEP.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN() {
        if (this.aFd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aFd.userId), this.aFd.userName, this.aFd.portrait, this.aFd.sex, this.aFd.aDZ, this.aFd.location, this.aFd.description, 0L, this.aFd.fansCount, this.aFd.aEa, this.aFd.userStatus, this.aFd.liveId, this.aFd.groupId, this.aFd.aEd, this.aFd.aEe, this.aFd.appId, this.aFd.userName, "")));
        }
    }
}
