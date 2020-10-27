package com.baidu.live.gift.dynamicGift;

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
import com.baidu.live.utils.h;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes4.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private int aVR;
    private com.baidu.live.gift.biggift.b baL;
    private AlaBigGiftExtraInfoRevisionView baM;
    private com.baidu.live.alphavideo.c baY;
    private com.baidu.live.gift.c baZ;
    private com.baidu.live.gift.a.c bba;
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

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aVR = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aSL != null && cVar.aSL.aSK != null) {
            this.baZ = cVar;
            this.bba = cVar2;
            int[] hm = hm(this.baZ.Fb());
            z(hm[0], hm[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
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
        try {
            this.bbc.setDataSource(str);
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
        if (this.baL != null) {
            this.baL.m(this.bba);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.baL = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bbb = 0;
        if (this.baY != null && !this.baY.isDestroyed() && !TextUtils.isEmpty(this.baZ.Fb())) {
            this.baY.play(this.baZ.Fb());
            if (this.baL != null) {
                this.baL.l(this.bba);
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
        if (this.baM != null) {
            this.baM.end();
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
        if (this.baM != null) {
            this.baM.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.bba.Id()) {
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
        int dimensionPixelOffset;
        int aD;
        this.baM = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.baM.setData(this.bba);
        this.baM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Ix();
            }
        });
        this.baM.setVisibility(8);
        if (indexOfChild(this.baM) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.baM, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.baM.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aD = h.aC(getContext());
                } else {
                    aD = h.aD(getContext());
                }
                dimensionPixelOffset = aD + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.baM.setLayoutParams(layoutParams2);
        }
    }

    private void Is() {
        this.baY.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bba != null && AlaDynamicVideoGiftLayout.this.bba.Id() && AlaDynamicVideoGiftLayout.this.baM != null) {
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
        ViewGroup.LayoutParams layoutParams = this.baY.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            layoutParams.width = -1;
            layoutParams.height = (screenDimensions[0] * i2) / i;
        } else {
            layoutParams.width = (screenDimensions[1] * i) / i2;
            layoutParams.height = -1;
            ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
        }
        if (this.bba != null && this.bba.aZU && this.baZ != null && this.baZ.aSL != null && this.baZ.aSL.aSK != null && this.baZ.aSL.aSK.aSO) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aVR;
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Iu();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
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
        if (this.baM != null) {
            this.baM.GX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv() {
        if (this.baM != null) {
            this.baM.GY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        if (this.baM != null) {
            this.baM.end();
        }
        if (this.baL != null) {
            this.baL.m(this.bba);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        if (this.bba != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bba.userId), this.bba.userName, this.bba.portrait, this.bba.sex, this.bba.aZL, this.bba.location, this.bba.description, 0L, this.bba.fansCount, this.bba.aZM, this.bba.userStatus, this.bba.liveId, this.bba.groupId, this.bba.aZR, this.bba.aZS, this.bba.appId, this.bba.userName, "")));
        }
    }
}
