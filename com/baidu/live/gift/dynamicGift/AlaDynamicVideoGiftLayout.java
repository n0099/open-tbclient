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
import com.baidu.live.utils.g;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes7.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private int aPh;
    private com.baidu.live.gift.biggift.b aTL;
    private AlaBigGiftExtraInfoRevisionView aTM;
    private com.baidu.live.alphavideo.c aTY;
    private com.baidu.live.gift.c aTZ;
    private com.baidu.live.gift.a.c aUa;
    private int aUb;
    private MediaMetadataRetriever aUc;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aUb + 1;
        alaDynamicVideoGiftLayout.aUb = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aPh = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aML != null && cVar.aML.aMK != null) {
            this.aTZ = cVar;
            this.aUa = cVar2;
            int[] gC = gC(this.aTZ.DA());
            z(gC[0], gC[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gC(String str) {
        int i;
        int i2;
        int i3;
        if (this.aUc == null) {
            this.aUc = new MediaMetadataRetriever();
        }
        this.aUc.setDataSource(str);
        try {
            i = Integer.valueOf(this.aUc.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aUc.extractMetadata(19)).intValue();
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

    public void Fq() {
        stopAnim();
        if (this.aTL != null) {
            this.aTL.m(this.aUa);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aTL = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aUb = 0;
        if (this.aTY != null && !this.aTY.isDestroyed() && !TextUtils.isEmpty(this.aTZ.DA())) {
            this.aTY.play(this.aTZ.DA());
            if (this.aTL != null) {
                this.aTL.l(this.aUa);
                return;
            }
            return;
        }
        GF();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aTY != null) {
            this.aTY.stop();
            this.aTY.reset();
        }
        if (this.aTM != null) {
            this.aTM.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aUc != null) {
            this.aUc.release();
        }
        if (this.aTY != null) {
            this.aTY.stop();
            this.aTY.release();
        }
        if (this.aTM != null) {
            this.aTM.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.aUa.Gm()) {
            Gx();
        }
    }

    private void A(int i, int i2) {
        if (this.aTY == null || this.aTY.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aTY = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        GB();
        if (indexOfChild(this.aTY.getView()) < 0) {
            addView(this.aTY.getView());
        }
        B(i, i2);
    }

    private void Gx() {
        int dimensionPixelOffset;
        int aA;
        if (this.aTM == null) {
            this.aTM = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aTM.setData(this.aUa);
        this.aTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.GG();
            }
        });
        this.aTM.setVisibility(8);
        if (indexOfChild(this.aTM) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.aTM, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.aTM.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aA = g.az(getContext());
                } else {
                    aA = g.aA(getContext());
                }
                dimensionPixelOffset = aA + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.aTM.setLayoutParams(layoutParams2);
        }
    }

    private void GB() {
        this.aTY.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aUa != null && AlaDynamicVideoGiftLayout.this.aUa.Gm() && AlaDynamicVideoGiftLayout.this.aTM != null) {
                    AlaDynamicVideoGiftLayout.this.GC();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aTZ.aML.aMK.repeatCount || AlaDynamicVideoGiftLayout.this.aTY == null || AlaDynamicVideoGiftLayout.this.aTY.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.GF();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aTY.play(AlaDynamicVideoGiftLayout.this.aTZ.DA());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.GF();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aTZ != null && AlaDynamicVideoGiftLayout.this.aTZ.aML != null) {
                    if (AlaDynamicVideoGiftLayout.this.aTZ.aML.aMJ != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aTZ.aML.aMJ.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aTZ.aML.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.aTY.getView().getLayoutParams();
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
        if (this.aUa != null && this.aUa.aSZ && this.aTZ != null && this.aTZ.aML != null && this.aTZ.aML.aMK != null && this.aTZ.aML.aMK.aMO) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aPh;
            return;
        }
        if (this.aTZ != null && this.aTZ.aML != null && this.aTZ.aML.aMK != null && this.aTZ.aML.aMK.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aTY.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC() {
        if (this.aTY != null) {
            long duration = this.aTY.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.GD();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.GE();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            GD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        if (this.aTM != null) {
            this.aTM.Ff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        if (this.aTM != null) {
            this.aTM.Fg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GF() {
        if (this.aTM != null) {
            this.aTM.end();
        }
        if (this.aTL != null) {
            this.aTL.m(this.aUa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GG() {
        if (this.aUa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aUa.userId), this.aUa.userName, this.aUa.portrait, this.aUa.sex, this.aUa.aSS, this.aUa.location, this.aUa.description, 0L, this.aUa.fansCount, this.aUa.aST, this.aUa.userStatus, this.aUa.liveId, this.aUa.groupId, this.aUa.aSW, this.aUa.aSX, this.aUa.appId, this.aUa.userName, "")));
        }
    }
}
