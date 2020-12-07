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
    private com.baidu.live.yuyingift.biggift.b bUg;
    private AlaBigGiftExtraInfoRevisionView bUh;
    private com.baidu.live.yuyingift.a.c bUp;
    private com.baidu.live.alphavideo.c bef;
    private com.baidu.live.gift.c beh;
    private int bej;
    private MediaMetadataRetriever bek;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bej + 1;
        alaDynamicVideoGiftLayout.bej = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aVv != null && cVar.aVv.aVu != null) {
            this.beh = cVar;
            this.bUp = cVar2;
            if (!TextUtils.isEmpty(this.beh.GE())) {
                try {
                    if (new File(this.beh.GE()).exists()) {
                        int[] hI = hI(this.beh.GE());
                        R(hI[0], hI[1]);
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
    private int[] hI(String str) {
        int i;
        int i2;
        int i3;
        if (this.bek == null) {
            this.bek = new MediaMetadataRetriever();
        }
        this.bek.setDataSource(str);
        try {
            i = Integer.valueOf(this.bek.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bek.extractMetadata(19)).intValue();
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

    public void IR() {
        stopAnim();
        if (this.bUg != null) {
            this.bUg.m(this.bUp);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bUg = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bej = 0;
        if (this.bef != null && !this.bef.isDestroyed() && !TextUtils.isEmpty(this.beh.GE())) {
            this.bef.play(this.beh.GE());
            if (this.bUg != null) {
                this.bUg.l(this.bUp);
                return;
            }
            return;
        }
        Kf();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bef != null) {
            this.bef.stop();
            this.bef.reset();
        }
        if (this.bUh != null) {
            this.bUh.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bek != null) {
            this.bek.release();
        }
        if (this.bef != null) {
            this.bef.stop();
            this.bef.release();
        }
        if (this.bUh != null) {
            this.bUh.onDestroy();
        }
        removeAllViews();
    }

    private void R(int i, int i2) {
        S(i, i2);
        if (this.bUp.JM()) {
            JX();
        }
    }

    private void S(int i, int i2) {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Kb();
        if (indexOfChild(this.bef.getView()) < 0) {
            addView(this.bef.getView());
        }
        T(i, i2);
    }

    private void JX() {
        if (this.bUh == null) {
            this.bUh = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bUh.setData(this.bUp);
        this.bUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Kg();
            }
        });
        this.bUh.setVisibility(8);
        if (indexOfChild(this.bUh) < 0) {
            int i = 0;
            if (this.bUp != null && this.bUp.bcX && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bUh, layoutParams);
        }
    }

    private void Kb() {
        this.bef.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bUp != null && AlaDynamicVideoGiftLayout.this.bUp.JM() && AlaDynamicVideoGiftLayout.this.bUh != null) {
                    AlaDynamicVideoGiftLayout.this.Kc();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.beh.aVv.aVu.repeatCount || AlaDynamicVideoGiftLayout.this.bef == null || AlaDynamicVideoGiftLayout.this.bef.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Kf();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bef.play(AlaDynamicVideoGiftLayout.this.beh.GE());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Kf();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.beh != null && AlaDynamicVideoGiftLayout.this.beh.aVv != null) {
                    if (AlaDynamicVideoGiftLayout.this.beh.aVv.aVt != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.beh.aVv.aVt.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.beh.aVv.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void T(int i, int i2) {
        if (this.bUp != null && !this.bUp.bda) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bef.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bUp != null && this.bUp.bda && this.beh != null && this.beh.aVv != null && this.beh.aVv.aVu != null && this.beh.aVv.aVu.aVy) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.ak.c.c(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.beh != null && this.beh.aVv != null && this.beh.aVv.aVu != null && this.beh.aVv.aVu.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bef.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc() {
        if (this.bef != null) {
            long duration = this.bef.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Kd();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ke();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Kd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.bUh != null) {
            this.bUh.IG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        if (this.bUh != null) {
            this.bUh.IH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (this.bUh != null) {
            this.bUh.end();
        }
        if (this.bUg != null) {
            this.bUg.m(this.bUp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.bUp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bUp.userId), this.bUp.userName, this.bUp.portrait, this.bUp.sex, this.bUp.bcP, this.bUp.location, this.bUp.description, 0L, this.bUp.bcR, this.bUp.bcQ, this.bUp.userStatus, this.bUp.liveId, this.bUp.groupId, this.bUp.bcX, this.bUp.bcY, this.bUp.appId, this.bUp.userName, "")));
        }
    }
}
