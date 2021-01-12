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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.alphavideo.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import java.io.File;
/* loaded from: classes10.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bVm;
    private AlaBigGiftExtraInfoRevisionView bVn;
    private boolean bVp;
    private com.baidu.live.yuyingift.a.c bVs;
    private com.baidu.live.alphavideo.c bbc;
    private com.baidu.live.gift.c bbd;
    private int bbf;
    private MediaMetadataRetriever bbg;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bbf + 1;
        alaDynamicVideoGiftLayout.bbf = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.bVp != z) {
            this.bVp = z;
            dC(this.bVp);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aSo != null && cVar.aSo.aSm != null) {
            this.bbd = cVar;
            this.bVs = cVar2;
            if (!TextUtils.isEmpty(this.bbd.Cj())) {
                try {
                    if (new File(this.bbd.Cj()).exists()) {
                        int[] gh = gh(this.bbd.Cj());
                        R(gh[0], gh[1]);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            dC(this.bVp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gh(String str) {
        int i;
        int i2;
        int i3;
        if (this.bbg == null) {
            this.bbg = new MediaMetadataRetriever();
        }
        this.bbg.setDataSource(str);
        try {
            i = Integer.valueOf(this.bbg.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bbg.extractMetadata(19)).intValue();
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

    public void Ex() {
        stopAnim();
        if (this.bVm != null) {
            this.bVm.l(this.bVs);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bVm = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bbf = 0;
        if (this.bbc != null && !this.bbc.isDestroyed() && !TextUtils.isEmpty(this.bbd.Cj())) {
            this.bbc.play(this.bbd.Cj());
            if (this.bVm != null) {
                this.bVm.k(this.bVs);
                return;
            }
            return;
        }
        FM();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.reset();
        }
        if (this.bVn != null) {
            this.bVn.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbg != null) {
            this.bbg.release();
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.release();
        }
        if (this.bVn != null) {
            this.bVn.onDestroy();
        }
        removeAllViews();
    }

    private void R(int i, int i2) {
        S(i, i2);
        if (this.bVs.Ft()) {
            FE();
        }
    }

    private void S(int i, int i2) {
        if (this.bbc == null || this.bbc.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bbc = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        FI();
        if (indexOfChild(this.bbc.getView()) < 0) {
            addView(this.bbc.getView());
        }
        T(i, i2);
    }

    private void FE() {
        if (this.bVn == null) {
            this.bVn = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bVn.setData(this.bVs);
        this.bVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.FN();
            }
        });
        this.bVn.setVisibility(8);
        if (indexOfChild(this.bVn) < 0) {
            int i = 0;
            if (this.bVs != null && this.bVs.aZP && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bVn, layoutParams);
        }
    }

    private void FI() {
        this.bbc.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bVs != null && AlaDynamicVideoGiftLayout.this.bVs.Ft() && AlaDynamicVideoGiftLayout.this.bVn != null) {
                    AlaDynamicVideoGiftLayout.this.FJ();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bbd.aSo.aSm.repeatCount || AlaDynamicVideoGiftLayout.this.bbc == null || AlaDynamicVideoGiftLayout.this.bbc.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.FM();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bbc.play(AlaDynamicVideoGiftLayout.this.bbd.Cj());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.FM();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bbd != null && AlaDynamicVideoGiftLayout.this.bbd.aSo != null) {
                    if (AlaDynamicVideoGiftLayout.this.bbd.aSo.aSl != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bbd.aSo.aSl.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bbd.aSo.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void T(int i, int i2) {
        if (this.bVs != null && !this.bVs.aZS) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bbc.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bVs != null && this.bVs.aZS && this.bbd != null && this.bbd.aSo != null && this.bbd.aSo.aSm != null && this.bbd.aSo.aSm.aSr) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.al.c.d(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.bbd != null && this.bbd.aSo != null && this.bbd.aSo.aSm != null && this.bbd.aSo.aSm.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bbc.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.bbc != null) {
            long duration = this.bbc.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.FK();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.FL();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            FK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK() {
        if (this.bVn != null) {
            this.bVn.En();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.bVn != null) {
            this.bVn.Eo();
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.bVs;
    }

    private void dC(boolean z) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (this.bbc != null && this.bbc.getView() != null && runTask != null) {
            ViewGroup.LayoutParams layoutParams = this.bbc.getView().getLayoutParams();
            if (runTask != null && layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.bVs != null && this.bVs.aZS) {
                int intValue = ((Integer) runTask.getData()).intValue();
                if (z) {
                    int realScreenHeight = ScreenHelper.getRealScreenHeight(getContext());
                    int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight() + intValue;
                    int height = this.bbc.getView().getHeight();
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = realScreenHeight - keyboardHeight < height ? (realScreenHeight - height) - BdUtilHelper.dip2px(getContext(), 20.0f) : keyboardHeight;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = intValue + getBoottomBarHeight();
                }
                this.bbc.getView().setLayoutParams(layoutParams);
            }
        }
    }

    private int getBoottomBarHeight() {
        return (int) TbadkCoreApplication.getInst().getResources().getDimension(a.d.sdk_ds120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.bVn != null) {
            this.bVn.end();
        }
        if (this.bVm != null) {
            this.bVm.l(this.bVs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN() {
        if (this.bVs != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bVs.userId), this.bVs.userName, this.bVs.portrait, this.bVs.sex, this.bVs.aZJ, this.bVs.location, this.bVs.description, 0L, this.bVs.fansCount, this.bVs.followCount, this.bVs.userStatus, this.bVs.liveId, this.bVs.groupId, this.bVs.aZP, this.bVs.aZQ, this.bVs.appId, this.bVs.userName, "")));
        }
    }
}
