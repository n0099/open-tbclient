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
    private com.baidu.live.gift.biggift.b aEV;
    private AlaBigGiftExtraInfoRevisionView aEW;
    private com.baidu.live.alphavideo.c aFh;
    private com.baidu.live.gift.c aFi;
    private com.baidu.live.gift.a.c aFj;
    private int aFk;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int d(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aFk + 1;
        alaDynamicVideoGiftLayout.aFk = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.ays != null && cVar.ays.ayr != null) {
            this.aFi = cVar;
            this.aFj = cVar2;
            yF();
        }
    }

    public void xx() {
        stopAnim();
        if (this.aEV != null) {
            this.aEV.onEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEV = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aFk = 0;
        if (this.aFh != null && !this.aFh.isDestroyed()) {
            this.aFh.dB(this.aFi.vE());
        }
        if (this.aEV != null) {
            this.aEV.onStart();
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aFh != null) {
            this.aFh.stop();
            this.aFh.reset();
        }
        if (this.aEW != null) {
            this.aEW.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aFh != null) {
            this.aFh.stop();
            this.aFh.release();
        }
        if (this.aEW != null) {
            this.aEW.onDestroy();
        }
        removeAllViews();
    }

    private void yF() {
        yG();
        if (this.aFj.yr()) {
            yH();
        }
    }

    private void yG() {
        if (this.aFh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aFh = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.aFh.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aEW != null) {
                    AlaDynamicVideoGiftLayout.this.yI();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.d(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aFi.ays.ayr.repeatCount || AlaDynamicVideoGiftLayout.this.aFh == null || AlaDynamicVideoGiftLayout.this.aFh.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.yL();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aFh.dB(AlaDynamicVideoGiftLayout.this.aFi.vE());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.yL();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aFi != null && AlaDynamicVideoGiftLayout.this.aFi.ays != null) {
                    if (AlaDynamicVideoGiftLayout.this.aFi.ays.ayq != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aFi.ays.ayq.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aFi.ays.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
        if (indexOfChild(this.aFh.getView()) < 0) {
            addView(this.aFh.getView());
        }
        ViewGroup.LayoutParams layoutParams = this.aFh.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        int i = screenDimensions[0];
        int i2 = screenDimensions[1];
        layoutParams.width = -1;
        layoutParams.height = i2 > i ? (i * FormCard.HEIGHT_DEFAULT_SIZE) / FormCard.WIDTH_DEFAULT_SIZE : (i * FormCard.WIDTH_DEFAULT_SIZE) / FormCard.HEIGHT_DEFAULT_SIZE;
        if (this.aFi.ays != null && this.aFi.ays.ayr != null && this.aFi.ays.ayr.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        this.aFh.getView().setLayoutParams(layoutParams);
    }

    private void yH() {
        if (this.aEW == null) {
            this.aEW = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aEW.setData(this.aFj);
        this.aEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.yM();
            }
        });
        this.aEW.setVisibility(8);
        if (indexOfChild(this.aEW) < 0) {
            int i = 0;
            if (this.aFj != null && this.aFj.aEj && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds266);
            layoutParams.addRule(14);
            addView(this.aEW, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI() {
        if (this.aFh != null) {
            long duration = this.aFh.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.yJ();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.yK();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            yJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ() {
        if (this.aEW != null) {
            this.aEW.xm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK() {
        if (this.aEW != null) {
            this.aEW.xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL() {
        if (this.aEW != null) {
            this.aEW.end();
        }
        if (this.aEV != null) {
            this.aEV.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM() {
        if (this.aFj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aFj.userId), this.aFj.userName, this.aFj.portrait, this.aFj.sex, this.aFj.aEf, this.aFj.location, this.aFj.description, 0L, this.aFj.fansCount, this.aFj.aEg, this.aFj.userStatus, this.aFj.liveId, this.aFj.groupId, this.aFj.aEj, this.aFj.aEk, this.aFj.appId, this.aFj.userName, "")));
        }
    }
}
