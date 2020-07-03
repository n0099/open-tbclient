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
/* loaded from: classes3.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b aNd;
    private AlaBigGiftExtraInfoRevisionView aNe;
    private com.baidu.live.alphavideo.c aNp;
    private com.baidu.live.gift.c aNq;
    private com.baidu.live.gift.a.c aNr;
    private int aNs;
    private MediaMetadataRetriever aNt;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aNs + 1;
        alaDynamicVideoGiftLayout.aNs = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aGg != null && cVar.aGg.aGf != null) {
            this.aNq = cVar;
            this.aNr = cVar2;
            int[] fi = fi(this.aNq.xv());
            w(fi[0], fi[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] fi(String str) {
        int i;
        int i2;
        int i3;
        if (this.aNt == null) {
            this.aNt = new MediaMetadataRetriever();
        }
        this.aNt.setDataSource(str);
        try {
            i = Integer.valueOf(this.aNt.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aNt.extractMetadata(19)).intValue();
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

    public void zl() {
        stopAnim();
        if (this.aNd != null) {
            this.aNd.m(this.aNr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aNd = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aNs = 0;
        if (this.aNp != null && !this.aNp.isDestroyed() && !TextUtils.isEmpty(this.aNq.xv())) {
            this.aNp.eh(this.aNq.xv());
            if (this.aNd != null) {
                this.aNd.l(this.aNr);
                return;
            }
            return;
        }
        AA();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aNp != null) {
            this.aNp.stop();
            this.aNp.reset();
        }
        if (this.aNe != null) {
            this.aNe.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aNt != null) {
            this.aNt.release();
        }
        if (this.aNp != null) {
            this.aNp.stop();
            this.aNp.release();
        }
        if (this.aNe != null) {
            this.aNe.onDestroy();
        }
        removeAllViews();
    }

    private void w(int i, int i2) {
        x(i, i2);
        if (this.aNr.Ah()) {
            Av();
        }
    }

    private void x(int i, int i2) {
        if (this.aNp == null || this.aNp.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aNp = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Aw();
        if (indexOfChild(this.aNp.getView()) < 0) {
            addView(this.aNp.getView());
        }
        y(i, i2);
    }

    private void Av() {
        if (this.aNe == null) {
            this.aNe = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aNe.setData(this.aNr);
        this.aNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.AB();
            }
        });
        this.aNe.setVisibility(8);
        if (indexOfChild(this.aNe) < 0) {
            int i = 0;
            if (this.aNr != null && this.aNr.aMo && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.e.sdk_ds266);
            layoutParams.addRule(14);
            addView(this.aNe, layoutParams);
        }
    }

    private void Aw() {
        this.aNp.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aNr != null && AlaDynamicVideoGiftLayout.this.aNr.Ah() && AlaDynamicVideoGiftLayout.this.aNe != null) {
                    AlaDynamicVideoGiftLayout.this.Ax();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aNq.aGg.aGf.repeatCount || AlaDynamicVideoGiftLayout.this.aNp == null || AlaDynamicVideoGiftLayout.this.aNp.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.AA();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aNp.eh(AlaDynamicVideoGiftLayout.this.aNq.xv());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.AA();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aNq != null && AlaDynamicVideoGiftLayout.this.aNq.aGg != null) {
                    if (AlaDynamicVideoGiftLayout.this.aNq.aGg.aGe != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aNq.aGg.aGe.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aNq.aGg.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void y(int i, int i2) {
        if (this.aNr != null && !this.aNr.aMr) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.aNp.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.aNr != null && this.aNr.aMr && this.aNq != null && this.aNq.aGg != null && this.aNq.aGg.aGf != null && this.aNq.aGg.aGf.aGj) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.aa.a.h(this.isHost, false) + com.baidu.live.aa.a.cs(this.isHost);
            return;
        }
        if (this.aNq != null && this.aNq.aGg != null && this.aNq.aGg.aGf != null && this.aNq.aGg.aGf.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aNp.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ax() {
        if (this.aNp != null) {
            long duration = this.aNp.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ay();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Az();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            Ay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        if (this.aNe != null) {
            this.aNe.za();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az() {
        if (this.aNe != null) {
            this.aNe.zb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA() {
        if (this.aNe != null) {
            this.aNe.end();
        }
        if (this.aNd != null) {
            this.aNd.m(this.aNr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB() {
        if (this.aNr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aNr.userId), this.aNr.userName, this.aNr.portrait, this.aNr.sex, this.aNr.aMk, this.aNr.location, this.aNr.description, 0L, this.aNr.fansCount, this.aNr.aMl, this.aNr.userStatus, this.aNr.liveId, this.aNr.groupId, this.aNr.aMo, this.aNr.aMp, this.aNr.appId, this.aNr.userName, "")));
        }
    }
}
