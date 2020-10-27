package com.baidu.live.yuyingift.dynamicgift;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes4.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bKY;
    private AlaBigGiftExtraInfoRevisionView bKZ;
    private com.baidu.live.yuyingift.a.c bLh;
    private com.baidu.live.alphavideo.c baY;
    private com.baidu.live.gift.c baZ;
    private int bbb;
    private MediaMetadataRetriever bbc;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bbb + 1;
        alaDynamicVideoGiftLayout.bbb = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aSL != null && cVar.aSL.aSK != null) {
            this.baZ = cVar;
            this.bLh = cVar2;
            int[] hm = hm(this.baZ.Fb());
            z(hm[0], hm[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] hm(String str) {
        int i;
        int i2;
        int i3;
        if (this.bbc == null) {
            this.bbc = new MediaMetadataRetriever();
        }
        this.bbc.setDataSource(str);
        try {
            i = Integer.valueOf(this.bbc.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bbc.extractMetadata(19)).intValue();
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

    public void Hi() {
        stopAnim();
        if (this.bKY != null) {
            this.bKY.m(this.bLh);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bKY = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bbb = 0;
        if (this.baY != null && !this.baY.isDestroyed() && !TextUtils.isEmpty(this.baZ.Fb())) {
            this.baY.play(this.baZ.Fb());
            if (this.bKY != null) {
                this.bKY.l(this.bLh);
                return;
            }
            return;
        }
        Iw();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.baY != null) {
            this.baY.stop();
            this.baY.reset();
        }
        if (this.bKZ != null) {
            this.bKZ.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbc != null) {
            this.bbc.release();
        }
        if (this.baY != null) {
            this.baY.stop();
            this.baY.release();
        }
        if (this.bKZ != null) {
            this.bKZ.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.bLh.Id()) {
            Io();
        }
    }

    private void A(int i, int i2) {
        if (this.baY == null || this.baY.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.baY = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Is();
        if (indexOfChild(this.baY.getView()) < 0) {
            addView(this.baY.getView());
        }
        B(i, i2);
    }

    private void Io() {
        if (this.bKZ == null) {
            this.bKZ = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bKZ.setData(this.bLh);
        this.bKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Ix();
            }
        });
        this.bKZ.setVisibility(8);
        if (indexOfChild(this.bKZ) < 0) {
            int i = 0;
            if (this.bLh != null && this.bLh.aZR && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bKZ, layoutParams);
        }
    }

    private void Is() {
        this.baY.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bLh != null && AlaDynamicVideoGiftLayout.this.bLh.Id() && AlaDynamicVideoGiftLayout.this.bKZ != null) {
                    AlaDynamicVideoGiftLayout.this.It();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.baZ.aSL.aSK.repeatCount || AlaDynamicVideoGiftLayout.this.baY == null || AlaDynamicVideoGiftLayout.this.baY.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Iw();
                    } else {
                        AlaDynamicVideoGiftLayout.this.baY.play(AlaDynamicVideoGiftLayout.this.baZ.Fb());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Iw();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.baZ != null && AlaDynamicVideoGiftLayout.this.baZ.aSL != null) {
                    if (AlaDynamicVideoGiftLayout.this.baZ.aSL.aSJ != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.baZ.aSL.aSJ.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.baZ.aSL.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        if (this.bLh != null && !this.bLh.aZU) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.baY.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bLh != null && this.bLh.aZU && this.baZ != null && this.baZ.aSL != null && this.baZ.aSL.aSK != null && this.baZ.aSL.aSK.aSO) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.af.b.c(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds200);
            return;
        }
        if (this.baZ != null && this.baZ.aSL != null && this.baZ.aSL.aSK != null && this.baZ.aSL.aSK.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.baY.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void It() {
        if (this.baY != null) {
            long duration = this.baY.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Iu();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Iv();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Iu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu() {
        if (this.bKZ != null) {
            this.bKZ.GX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv() {
        if (this.bKZ != null) {
            this.bKZ.GY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        if (this.bKZ != null) {
            this.bKZ.end();
        }
        if (this.bKY != null) {
            this.bKY.m(this.bLh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        if (this.bLh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bLh.userId), this.bLh.userName, this.bLh.portrait, this.bLh.sex, this.bLh.aZL, this.bLh.location, this.bLh.description, 0L, this.bLh.fansCount, this.bLh.aZM, this.bLh.userStatus, this.bLh.liveId, this.bLh.groupId, this.bLh.aZR, this.bLh.aZS, this.bLh.appId, this.bLh.userName, "")));
        }
    }
}
