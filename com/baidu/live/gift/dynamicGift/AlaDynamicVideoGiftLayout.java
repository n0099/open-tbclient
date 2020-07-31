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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes4.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.alphavideo.c aOK;
    private com.baidu.live.gift.c aOL;
    private com.baidu.live.gift.a.c aOM;
    private int aON;
    private MediaMetadataRetriever aOO;
    private com.baidu.live.gift.biggift.b aOy;
    private AlaBigGiftExtraInfoRevisionView aOz;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aON + 1;
        alaDynamicVideoGiftLayout.aON = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aHB != null && cVar.aHB.aHA != null) {
            this.aOL = cVar;
            this.aOM = cVar2;
            int[] fh = fh(this.aOL.xX());
            w(fh[0], fh[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] fh(String str) {
        int i;
        int i2;
        int i3;
        if (this.aOO == null) {
            this.aOO = new MediaMetadataRetriever();
        }
        this.aOO.setDataSource(str);
        try {
            i = Integer.valueOf(this.aOO.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aOO.extractMetadata(19)).intValue();
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

    public void zN() {
        stopAnim();
        if (this.aOy != null) {
            this.aOy.m(this.aOM);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aOy = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aON = 0;
        if (this.aOK != null && !this.aOK.isDestroyed() && !TextUtils.isEmpty(this.aOL.xX())) {
            this.aOK.eg(this.aOL.xX());
            if (this.aOy != null) {
                this.aOy.l(this.aOM);
                return;
            }
            return;
        }
        Bc();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aOK != null) {
            this.aOK.stop();
            this.aOK.reset();
        }
        if (this.aOz != null) {
            this.aOz.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aOO != null) {
            this.aOO.release();
        }
        if (this.aOK != null) {
            this.aOK.stop();
            this.aOK.release();
        }
        if (this.aOz != null) {
            this.aOz.onDestroy();
        }
        removeAllViews();
    }

    private void w(int i, int i2) {
        x(i, i2);
        if (this.aOM.AJ()) {
            AX();
        }
    }

    private void x(int i, int i2) {
        if (this.aOK == null || this.aOK.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aOK = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        AY();
        if (indexOfChild(this.aOK.getView()) < 0) {
            addView(this.aOK.getView());
        }
        y(i, i2);
    }

    private void AX() {
        if (this.aOz == null) {
            this.aOz = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aOz.setData(this.aOM);
        this.aOz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Bd();
            }
        });
        this.aOz.setVisibility(8);
        if (indexOfChild(this.aOz) < 0) {
            int i = 0;
            if (this.aOM != null && this.aOM.aNJ && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds266);
            layoutParams.addRule(14);
            addView(this.aOz, layoutParams);
        }
    }

    private void AY() {
        this.aOK.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aOM != null && AlaDynamicVideoGiftLayout.this.aOM.AJ() && AlaDynamicVideoGiftLayout.this.aOz != null) {
                    AlaDynamicVideoGiftLayout.this.AZ();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aOL.aHB.aHA.repeatCount || AlaDynamicVideoGiftLayout.this.aOK == null || AlaDynamicVideoGiftLayout.this.aOK.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Bc();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aOK.eg(AlaDynamicVideoGiftLayout.this.aOL.xX());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Bc();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aOL != null && AlaDynamicVideoGiftLayout.this.aOL.aHB != null) {
                    if (AlaDynamicVideoGiftLayout.this.aOL.aHB.aHz != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aOL.aHB.aHz.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aOL.aHB.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void y(int i, int i2) {
        if (this.aOM != null && !this.aOM.aNM) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.aOK.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.aOM != null && this.aOM.aNM && this.aOL != null && this.aOL.aHB != null && this.aOL.aHB.aHA != null && this.aOL.aHB.aHA.aHE) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.aa.a.h(this.isHost, false) + com.baidu.live.aa.a.cu(this.isHost);
            return;
        }
        if (this.aOL != null && this.aOL.aHB != null && this.aOL.aHB.aHA != null && this.aOL.aHB.aHA.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aOK.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        if (this.aOK != null) {
            long duration = this.aOK.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ba();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Bb();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Ba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.aOz != null) {
            this.aOz.zC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        if (this.aOz != null) {
            this.aOz.zD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        if (this.aOz != null) {
            this.aOz.end();
        }
        if (this.aOy != null) {
            this.aOy.m(this.aOM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (this.aOM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aOM.userId), this.aOM.userName, this.aOM.portrait, this.aOM.sex, this.aOM.aNF, this.aOM.location, this.aOM.description, 0L, this.aOM.fansCount, this.aOM.aNG, this.aOM.userStatus, this.aOM.liveId, this.aOM.groupId, this.aOM.aNJ, this.aOM.aNK, this.aOM.appId, this.aOM.userName, "")));
        }
    }
}
