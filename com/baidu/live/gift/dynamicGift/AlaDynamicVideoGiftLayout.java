package com.baidu.live.gift.dynamicGift;

import android.app.Activity;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
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
    private com.baidu.live.alphavideo.c aKJ;
    private com.baidu.live.gift.c aKK;
    private com.baidu.live.gift.a.c aKL;
    private int aKM;
    private MediaMetadataRetriever aKN;
    private com.baidu.live.gift.biggift.b aKx;
    private AlaBigGiftExtraInfoRevisionView aKy;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aKM + 1;
        alaDynamicVideoGiftLayout.aKM = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aDK != null && cVar.aDK.aDJ != null) {
            this.aKK = cVar;
            this.aKL = cVar2;
            int[] fc = fc(this.aKK.wU());
            u(fc[0], fc[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] fc(String str) {
        int i;
        int i2;
        int i3;
        if (this.aKN == null) {
            this.aKN = new MediaMetadataRetriever();
        }
        this.aKN.setDataSource(str);
        try {
            i = Integer.valueOf(this.aKN.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aKN.extractMetadata(19)).intValue();
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                i2 = 0;
                if (i > 0) {
                }
                if (i2 <= 0) {
                }
                return new int[]{i3, i2};
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        if (i > 0) {
            i3 = FormCard.WIDTH_DEFAULT_SIZE;
        } else {
            i3 = i / 2;
        }
        if (i2 <= 0) {
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        return new int[]{i3, i2};
    }

    public void yL() {
        stopAnim();
        if (this.aKx != null) {
            this.aKx.m(this.aKL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aKx = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aKM = 0;
        if (this.aKJ != null && !this.aKJ.isDestroyed() && !TextUtils.isEmpty(this.aKK.wU())) {
            this.aKJ.ef(this.aKK.wU());
            if (this.aKx != null) {
                this.aKx.l(this.aKL);
                return;
            }
            return;
        }
        Aa();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aKJ != null) {
            this.aKJ.stop();
            this.aKJ.reset();
        }
        if (this.aKy != null) {
            this.aKy.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aKN != null) {
            this.aKN.release();
        }
        if (this.aKJ != null) {
            this.aKJ.stop();
            this.aKJ.release();
        }
        if (this.aKy != null) {
            this.aKy.onDestroy();
        }
        removeAllViews();
    }

    private void u(int i, int i2) {
        v(i, i2);
        if (this.aKL.zH()) {
            zV();
        }
    }

    private void v(int i, int i2) {
        if (this.aKJ == null || this.aKJ.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aKJ = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        zW();
        if (indexOfChild(this.aKJ.getView()) < 0) {
            addView(this.aKJ.getView());
        }
        w(i, i2);
    }

    private void zV() {
        if (this.aKy == null) {
            this.aKy = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aKy.setData(this.aKL);
        this.aKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Ab();
            }
        });
        this.aKy.setVisibility(8);
        if (indexOfChild(this.aKy) < 0) {
            int i = 0;
            if (this.aKL != null && this.aKL.aJI && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds266);
            layoutParams.addRule(14);
            addView(this.aKy, layoutParams);
        }
    }

    private void zW() {
        this.aKJ.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aKL != null && AlaDynamicVideoGiftLayout.this.aKL.zH() && AlaDynamicVideoGiftLayout.this.aKy != null) {
                    AlaDynamicVideoGiftLayout.this.zX();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aKK.aDK.aDJ.repeatCount || AlaDynamicVideoGiftLayout.this.aKJ == null || AlaDynamicVideoGiftLayout.this.aKJ.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Aa();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aKJ.ef(AlaDynamicVideoGiftLayout.this.aKK.wU());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Aa();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aKK != null && AlaDynamicVideoGiftLayout.this.aKK.aDK != null) {
                    if (AlaDynamicVideoGiftLayout.this.aKK.aDK.aDI != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aKK.aDK.aDI.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aKK.aDK.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void w(int i, int i2) {
        if (this.aKL != null && !this.aKL.aJL) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.aKJ.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.aKL != null && this.aKL.aJL && this.aKK != null && this.aKK.aDK != null && this.aKK.aDK.aDJ != null && this.aKK.aDK.aDJ.aDN) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.aa.a.h(this.isHost, false) + com.baidu.live.aa.a.cn(this.isHost);
            return;
        }
        if (this.aKK != null && this.aKK.aDK != null && this.aKK.aDK.aDJ != null && this.aKK.aDK.aDJ.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aKJ.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zX() {
        if (this.aKJ != null) {
            long duration = this.aKJ.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.zY();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.zZ();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            zY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        if (this.aKy != null) {
            this.aKy.yA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zZ() {
        if (this.aKy != null) {
            this.aKy.yB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        if (this.aKy != null) {
            this.aKy.end();
        }
        if (this.aKx != null) {
            this.aKx.m(this.aKL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab() {
        if (this.aKL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aKL.userId), this.aKL.userName, this.aKL.portrait, this.aKL.sex, this.aKL.aJE, this.aKL.location, this.aKL.description, 0L, this.aKL.fansCount, this.aKL.aJF, this.aKL.userStatus, this.aKL.liveId, this.aKL.groupId, this.aKL.aJI, this.aKL.aJJ, this.aKL.appId, this.aKL.userName, "")));
        }
    }
}
