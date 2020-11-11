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
    private com.baidu.live.yuyingift.biggift.b bQG;
    private AlaBigGiftExtraInfoRevisionView bQH;
    private com.baidu.live.yuyingift.a.c bQP;
    private com.baidu.live.alphavideo.c bcq;
    private com.baidu.live.gift.c bcr;
    private int bct;
    private MediaMetadataRetriever bcu;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bct + 1;
        alaDynamicVideoGiftLayout.bct = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aUe != null && cVar.aUe.aUd != null) {
            this.bcr = cVar;
            this.bQP = cVar2;
            if (!TextUtils.isEmpty(this.bcr.FC())) {
                try {
                    if (new File(this.bcr.FC()).exists()) {
                        int[] ht = ht(this.bcr.FC());
                        z(ht[0], ht[1]);
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
    private int[] ht(String str) {
        int i;
        int i2;
        int i3;
        if (this.bcu == null) {
            this.bcu = new MediaMetadataRetriever();
        }
        this.bcu.setDataSource(str);
        try {
            i = Integer.valueOf(this.bcu.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bcu.extractMetadata(19)).intValue();
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

    public void HJ() {
        stopAnim();
        if (this.bQG != null) {
            this.bQG.m(this.bQP);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bQG = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bct = 0;
        if (this.bcq != null && !this.bcq.isDestroyed() && !TextUtils.isEmpty(this.bcr.FC())) {
            this.bcq.play(this.bcr.FC());
            if (this.bQG != null) {
                this.bQG.l(this.bQP);
                return;
            }
            return;
        }
        IX();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bcq != null) {
            this.bcq.stop();
            this.bcq.reset();
        }
        if (this.bQH != null) {
            this.bQH.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bcu != null) {
            this.bcu.release();
        }
        if (this.bcq != null) {
            this.bcq.stop();
            this.bcq.release();
        }
        if (this.bQH != null) {
            this.bQH.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.bQP.IE()) {
            IP();
        }
    }

    private void A(int i, int i2) {
        if (this.bcq == null || this.bcq.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bcq = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        IT();
        if (indexOfChild(this.bcq.getView()) < 0) {
            addView(this.bcq.getView());
        }
        B(i, i2);
    }

    private void IP() {
        if (this.bQH == null) {
            this.bQH = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bQH.setData(this.bQP);
        this.bQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.IY();
            }
        });
        this.bQH.setVisibility(8);
        if (indexOfChild(this.bQH) < 0) {
            int i = 0;
            if (this.bQP != null && this.bQP.bbk && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bQH, layoutParams);
        }
    }

    private void IT() {
        this.bcq.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bQP != null && AlaDynamicVideoGiftLayout.this.bQP.IE() && AlaDynamicVideoGiftLayout.this.bQH != null) {
                    AlaDynamicVideoGiftLayout.this.IU();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bcr.aUe.aUd.repeatCount || AlaDynamicVideoGiftLayout.this.bcq == null || AlaDynamicVideoGiftLayout.this.bcq.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.IX();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bcq.play(AlaDynamicVideoGiftLayout.this.bcr.FC());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.IX();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bcr != null && AlaDynamicVideoGiftLayout.this.bcr.aUe != null) {
                    if (AlaDynamicVideoGiftLayout.this.bcr.aUe.aUc != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bcr.aUe.aUc.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bcr.aUe.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        if (this.bQP != null && !this.bQP.bbn) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bcq.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bQP != null && this.bQP.bbn && this.bcr != null && this.bcr.aUe != null && this.bcr.aUe.aUd != null && this.bcr.aUe.aUd.aUh) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.ag.b.c(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.bcr != null && this.bcr.aUe != null && this.bcr.aUe.aUd != null && this.bcr.aUe.aUd.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bcq.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IU() {
        if (this.bcq != null) {
            long duration = this.bcq.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.IV();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.IW();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            IV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IV() {
        if (this.bQH != null) {
            this.bQH.Hy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IW() {
        if (this.bQH != null) {
            this.bQH.Hz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        if (this.bQH != null) {
            this.bQH.end();
        }
        if (this.bQG != null) {
            this.bQG.m(this.bQP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        if (this.bQP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bQP.userId), this.bQP.userName, this.bQP.portrait, this.bQP.sex, this.bQP.bbe, this.bQP.location, this.bQP.description, 0L, this.bQP.fansCount, this.bQP.bbf, this.bQP.userStatus, this.bQP.liveId, this.bQP.groupId, this.bQP.bbk, this.bQP.bbl, this.bQP.appId, this.bQP.userName, "")));
        }
    }
}
