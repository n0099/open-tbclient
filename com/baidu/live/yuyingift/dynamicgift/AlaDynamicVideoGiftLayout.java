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
/* loaded from: classes11.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bZo;
    private AlaBigGiftExtraInfoRevisionView bZp;
    private boolean bZr;
    private com.baidu.live.yuyingift.a.c bZu;
    private com.baidu.live.alphavideo.c bei;
    private com.baidu.live.gift.c bej;
    private int bel;
    private MediaMetadataRetriever bem;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bel + 1;
        alaDynamicVideoGiftLayout.bel = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.bZr != z) {
            this.bZr = z;
            dK(this.bZr);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aVs != null && cVar.aVs.aVq != null) {
            this.bej = cVar;
            this.bZu = cVar2;
            if (!TextUtils.isEmpty(this.bej.Dy())) {
                try {
                    if (new File(this.bej.Dy()).exists()) {
                        int[] gF = gF(this.bej.Dy());
                        Q(gF[0], gF[1]);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            dK(this.bZr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gF(String str) {
        int i;
        int i2;
        int i3;
        if (this.bem == null) {
            this.bem = new MediaMetadataRetriever();
        }
        this.bem.setDataSource(str);
        try {
            i = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
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

    public void FN() {
        stopAnim();
        if (this.bZo != null) {
            this.bZo.l(this.bZu);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bZo = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bel = 0;
        if (this.bei != null && !this.bei.isDestroyed() && !TextUtils.isEmpty(this.bej.Dy())) {
            this.bei.play(this.bej.Dy());
            if (this.bZo != null) {
                this.bZo.k(this.bZu);
                return;
            }
            return;
        }
        Hc();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bei != null) {
            this.bei.stop();
            this.bei.reset();
        }
        if (this.bZp != null) {
            this.bZp.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bem != null) {
            this.bem.release();
        }
        if (this.bei != null) {
            this.bei.stop();
            this.bei.release();
        }
        if (this.bZp != null) {
            this.bZp.onDestroy();
        }
        removeAllViews();
    }

    private void Q(int i, int i2) {
        R(i, i2);
        if (this.bZu.GJ()) {
            GU();
        }
    }

    private void R(int i, int i2) {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        GY();
        if (indexOfChild(this.bei.getView()) < 0) {
            addView(this.bei.getView());
        }
        S(i, i2);
    }

    private void GU() {
        if (this.bZp == null) {
            this.bZp = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bZp.setData(this.bZu);
        this.bZp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Hd();
            }
        });
        this.bZp.setVisibility(8);
        if (indexOfChild(this.bZp) < 0) {
            int i = 0;
            if (this.bZu != null && this.bZu.bcW && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bZp, layoutParams);
        }
    }

    private void GY() {
        this.bei.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bZu != null && AlaDynamicVideoGiftLayout.this.bZu.GJ() && AlaDynamicVideoGiftLayout.this.bZp != null) {
                    AlaDynamicVideoGiftLayout.this.GZ();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bej.aVs.aVq.repeatCount || AlaDynamicVideoGiftLayout.this.bei == null || AlaDynamicVideoGiftLayout.this.bei.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Hc();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bei.play(AlaDynamicVideoGiftLayout.this.bej.Dy());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Hc();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bej != null && AlaDynamicVideoGiftLayout.this.bej.aVs != null) {
                    if (AlaDynamicVideoGiftLayout.this.bej.aVs.aVp != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bej.aVs.aVp.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bej.aVs.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void S(int i, int i2) {
        if (this.bZu != null && !this.bZu.bcZ) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bei.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.bZu != null && this.bZu.bcZ && this.bej != null && this.bej.aVs != null && this.bej.aVs.aVq != null && this.bej.aVs.aVq.aVv) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.aj.c.d(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
            return;
        }
        if (this.bej != null && this.bej.aVs != null && this.bej.aVs.aVq != null && this.bej.aVs.aVq.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bei.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ() {
        if (this.bei != null) {
            long duration = this.bei.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ha();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Hb();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Ha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (this.bZp != null) {
            this.bZp.FD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hb() {
        if (this.bZp != null) {
            this.bZp.FE();
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.bZu;
    }

    private void dK(boolean z) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (this.bei != null && this.bei.getView() != null && runTask != null) {
            ViewGroup.LayoutParams layoutParams = this.bei.getView().getLayoutParams();
            if (runTask != null && layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.bZu != null && this.bZu.bcZ) {
                int intValue = ((Integer) runTask.getData()).intValue();
                if (z) {
                    int realScreenHeight = ScreenHelper.getRealScreenHeight(getContext());
                    int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight() + intValue;
                    int height = this.bei.getView().getHeight();
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = realScreenHeight - keyboardHeight < height ? (realScreenHeight - height) - BdUtilHelper.dip2px(getContext(), 20.0f) : keyboardHeight;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = intValue + getBoottomBarHeight();
                }
                this.bei.getView().setLayoutParams(layoutParams);
            }
        }
    }

    private int getBoottomBarHeight() {
        return (int) TbadkCoreApplication.getInst().getResources().getDimension(a.d.sdk_ds120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        if (this.bZp != null) {
            this.bZp.end();
        }
        if (this.bZo != null) {
            this.bZo.l(this.bZu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        if (this.bZu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.bZu.userId), this.bZu.userName, this.bZu.portrait, this.bZu.sex, this.bZu.bcQ, this.bZu.location, this.bZu.description, 0L, this.bZu.fansCount, this.bZu.followCount, this.bZu.userStatus, this.bZu.liveId, this.bZu.groupId, this.bZu.bcW, this.bZu.bcX, this.bZu.appId, this.bZu.userName, "")));
        }
    }
}
