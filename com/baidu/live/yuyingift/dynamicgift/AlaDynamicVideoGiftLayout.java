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
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import java.io.File;
/* loaded from: classes4.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bOW;
    private AlaBigGiftExtraInfoRevisionView bOX;
    private com.baidu.live.yuyingift.a.c bPf;
    private com.baidu.live.alphavideo.c baF;
    private com.baidu.live.gift.c baG;
    private int baI;
    private MediaMetadataRetriever baJ;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.baI + 1;
        alaDynamicVideoGiftLayout.baI = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aSt != null && cVar.aSt.aSs != null) {
            this.baG = cVar;
            this.bPf = cVar2;
            if (!TextUtils.isEmpty(this.baG.ET())) {
                try {
                    if (new File(this.baG.ET()).exists()) {
                        int[] hn = hn(this.baG.ET());
                        z(hn[0], hn[1]);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] hn(String str) {
        int i;
        int i2;
        int i3;
        if (this.baJ == null) {
            this.baJ = new MediaMetadataRetriever();
        }
        this.baJ.setDataSource(str);
        try {
            i = Integer.valueOf(this.baJ.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.baJ.extractMetadata(19)).intValue();
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

    public void Ha() {
        stopAnim();
        if (this.bOW != null) {
            this.bOW.m(this.bPf);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bOW = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.baI = 0;
        if (this.baF != null && !this.baF.isDestroyed() && !TextUtils.isEmpty(this.baG.ET())) {
            this.baF.play(this.baG.ET());
            if (this.bOW != null) {
                this.bOW.l(this.bPf);
                return;
            }
            return;
        }
        Io();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.baF != null) {
            this.baF.stop();
            this.baF.reset();
        }
        if (this.bOX != null) {
            this.bOX.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.baJ != null) {
            this.baJ.release();
        }
        if (this.baF != null) {
            this.baF.stop();
            this.baF.release();
        }
        if (this.bOX != null) {
            this.bOX.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.bPf.HV()) {
            Ig();
        }
    }

    private void A(int i, int i2) {
        if (this.baF == null || this.baF.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.baF = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Ik();
        if (indexOfChild(this.baF.getView()) < 0) {
            addView(this.baF.getView());
        }
        B(i, i2);
    }

    private void Ig() {
        if (this.bOX == null) {
            this.bOX = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bOX.setData(this.bPf);
        this.bOX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Ip();
            }
        });
        this.bOX.setVisibility(8);
        if (indexOfChild(this.bOX) < 0) {
            int i = 0;
            if (this.bPf != null && this.bPf.aZy && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bOX, layoutParams);
        }
    }

    private void Ik() {
        this.baF.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bPf != null && AlaDynamicVideoGiftLayout.this.bPf.HV() && AlaDynamicVideoGiftLayout.this.bOX != null) {
                    AlaDynamicVideoGiftLayout.this.Il();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.baG.aSt.aSs.repeatCount || AlaDynamicVideoGiftLayout.this.baF == null || AlaDynamicVideoGiftLayout.this.baF.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Io();
                    } else {
                        AlaDynamicVideoGiftLayout.this.baF.play(AlaDynamicVideoGiftLayout.this.baG.ET());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Io();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.baG != null && AlaDynamicVideoGiftLayout.this.baG.aSt != null) {
                    if (AlaDynamicVideoGiftLayout.this.baG.aSt.aSr != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.baG.aSt.aSr.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.baG.aSt.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        if (this.bPf != null && !this.bPf.aZB) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.baF.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bPf != null && this.bPf.aZB && this.baG != null && this.baG.aSt != null && this.baG.aSt.aSs != null && this.baG.aSt.aSs.aSw) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.ag.b.c(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.baG != null && this.baG.aSt != null && this.baG.aSt.aSs != null && this.baG.aSt.aSs.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.baF.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        if (this.baF != null) {
            long duration = this.baF.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Im();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.In();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Im();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        if (this.bOX != null) {
            this.bOX.GP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void In() {
        if (this.bOX != null) {
            this.bOX.GQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (this.bOX != null) {
            this.bOX.end();
        }
        if (this.bOW != null) {
            this.bOW.m(this.bPf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip() {
        if (this.bPf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bPf.userId), this.bPf.userName, this.bPf.portrait, this.bPf.sex, this.bPf.aZs, this.bPf.location, this.bPf.description, 0L, this.bPf.fansCount, this.bPf.aZt, this.bPf.userStatus, this.bPf.liveId, this.bPf.groupId, this.bPf.aZy, this.bPf.aZz, this.bPf.appId, this.bPf.userName, "")));
        }
    }
}
