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
    private com.baidu.live.alphavideo.c bfL;
    private com.baidu.live.gift.c bfM;
    private int bfO;
    private MediaMetadataRetriever bfP;
    private com.baidu.live.yuyingift.biggift.b caO;
    private AlaBigGiftExtraInfoRevisionView caP;
    private boolean caR;
    private com.baidu.live.yuyingift.a.c caU;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bfO + 1;
        alaDynamicVideoGiftLayout.bfO = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.caR != z) {
            this.caR = z;
            dK(this.caR);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aWS != null && cVar.aWS.aWQ != null) {
            this.bfM = cVar;
            this.caU = cVar2;
            if (!TextUtils.isEmpty(this.bfM.DB())) {
                try {
                    if (new File(this.bfM.DB()).exists()) {
                        int[] gL = gL(this.bfM.DB());
                        Q(gL[0], gL[1]);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            dK(this.caR);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gL(String str) {
        int i;
        int i2;
        int i3;
        if (this.bfP == null) {
            this.bfP = new MediaMetadataRetriever();
        }
        this.bfP.setDataSource(str);
        try {
            i = Integer.valueOf(this.bfP.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bfP.extractMetadata(19)).intValue();
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

    public void FQ() {
        stopAnim();
        if (this.caO != null) {
            this.caO.l(this.caU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.caO = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bfO = 0;
        if (this.bfL != null && !this.bfL.isDestroyed() && !TextUtils.isEmpty(this.bfM.DB())) {
            this.bfL.play(this.bfM.DB());
            if (this.caO != null) {
                this.caO.k(this.caU);
                return;
            }
            return;
        }
        Hf();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.reset();
        }
        if (this.caP != null) {
            this.caP.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfP != null) {
            this.bfP.release();
        }
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.release();
        }
        if (this.caP != null) {
            this.caP.onDestroy();
        }
        removeAllViews();
    }

    private void Q(int i, int i2) {
        R(i, i2);
        if (this.caU.GM()) {
            GX();
        }
    }

    private void R(int i, int i2) {
        if (this.bfL == null || this.bfL.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfL = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Hb();
        if (indexOfChild(this.bfL.getView()) < 0) {
            addView(this.bfL.getView());
        }
        S(i, i2);
    }

    private void GX() {
        if (this.caP == null) {
            this.caP = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.caP.setData(this.caU);
        this.caP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Hg();
            }
        });
        this.caP.setVisibility(8);
        if (indexOfChild(this.caP) < 0) {
            int i = 0;
            if (this.caU != null && this.caU.bey && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.caP, layoutParams);
        }
    }

    private void Hb() {
        this.bfL.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.caU != null && AlaDynamicVideoGiftLayout.this.caU.GM() && AlaDynamicVideoGiftLayout.this.caP != null) {
                    AlaDynamicVideoGiftLayout.this.Hc();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bfM.aWS.aWQ.repeatCount || AlaDynamicVideoGiftLayout.this.bfL == null || AlaDynamicVideoGiftLayout.this.bfL.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Hf();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bfL.play(AlaDynamicVideoGiftLayout.this.bfM.DB());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Hf();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bfM != null && AlaDynamicVideoGiftLayout.this.bfM.aWS != null) {
                    if (AlaDynamicVideoGiftLayout.this.bfM.aWS.aWP != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bfM.aWS.aWP.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bfM.aWS.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void S(int i, int i2) {
        if (this.caU != null && !this.caU.beB) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bfL.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.caU != null && this.caU.beB && this.bfM != null && this.bfM.aWS != null && this.bfM.aWS.aWQ != null && this.bfM.aWS.aWQ.aWV) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.aj.c.d(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.bfM != null && this.bfM.aWS != null && this.bfM.aWS.aWQ != null && this.bfM.aWS.aWQ.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bfL.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        if (this.bfL != null) {
            long duration = this.bfL.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Hd();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.He();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Hd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        if (this.caP != null) {
            this.caP.FG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (this.caP != null) {
            this.caP.FH();
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.caU;
    }

    private void dK(boolean z) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (this.bfL != null && this.bfL.getView() != null && runTask != null) {
            ViewGroup.LayoutParams layoutParams = this.bfL.getView().getLayoutParams();
            if (runTask != null && layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.caU != null && this.caU.beB) {
                int intValue = ((Integer) runTask.getData()).intValue();
                if (z) {
                    int realScreenHeight = ScreenHelper.getRealScreenHeight(getContext());
                    int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight() + intValue;
                    int height = this.bfL.getView().getHeight();
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = realScreenHeight - keyboardHeight < height ? (realScreenHeight - height) - BdUtilHelper.dip2px(getContext(), 20.0f) : keyboardHeight;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = intValue + getBoottomBarHeight();
                }
                this.bfL.getView().setLayoutParams(layoutParams);
            }
        }
    }

    private int getBoottomBarHeight() {
        return (int) TbadkCoreApplication.getInst().getResources().getDimension(a.d.sdk_ds120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        if (this.caP != null) {
            this.caP.end();
        }
        if (this.caO != null) {
            this.caO.l(this.caU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        if (this.caU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.caU.userId), this.caU.userName, this.caU.portrait, this.caU.sex, this.caU.ber, this.caU.location, this.caU.description, 0L, this.caU.fansCount, this.caU.followCount, this.caU.userStatus, this.caU.liveId, this.caU.groupId, this.caU.bey, this.caU.bez, this.caU.appId, this.caU.userName, "")));
        }
    }
}
