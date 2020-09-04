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
    private int aPj;
    private com.baidu.live.gift.biggift.b aTN;
    private AlaBigGiftExtraInfoRevisionView aTO;
    private com.baidu.live.alphavideo.c aUa;
    private com.baidu.live.gift.c aUb;
    private com.baidu.live.gift.a.c aUc;
    private int aUd;
    private MediaMetadataRetriever aUe;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aUd + 1;
        alaDynamicVideoGiftLayout.aUd = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aPj = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aMN != null && cVar.aMN.aMM != null) {
            this.aUb = cVar;
            this.aUc = cVar2;
            int[] gD = gD(this.aUb.DA());
            z(gD[0], gD[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gD(String str) {
        int i;
        int i2;
        int i3;
        if (this.aUe == null) {
            this.aUe = new MediaMetadataRetriever();
        }
        this.aUe.setDataSource(str);
        try {
            i = Integer.valueOf(this.aUe.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aUe.extractMetadata(19)).intValue();
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
        if (this.aTN != null) {
            this.aTN.m(this.aUc);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aTN = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aUd = 0;
        if (this.aUa != null && !this.aUa.isDestroyed() && !TextUtils.isEmpty(this.aUb.DA())) {
            this.aUa.play(this.aUb.DA());
            if (this.aTN != null) {
                this.aTN.l(this.aUc);
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
        if (this.aUa != null) {
            this.aUa.stop();
            this.aUa.reset();
        }
        if (this.aTO != null) {
            this.aTO.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aUe != null) {
            this.aUe.release();
        }
        if (this.aUa != null) {
            this.aUa.stop();
            this.aUa.release();
        }
        if (this.aTO != null) {
            this.aTO.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.aUc.Gm()) {
            Gx();
        }
    }

    private void A(int i, int i2) {
        if (this.aUa == null || this.aUa.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aUa = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        GB();
        if (indexOfChild(this.aUa.getView()) < 0) {
            addView(this.aUa.getView());
        }
        B(i, i2);
    }

    private void Gx() {
        int dimensionPixelOffset;
        int aA;
        if (this.aTO == null) {
            this.aTO = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aTO.setData(this.aUc);
        this.aTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.GG();
            }
        });
        this.aTO.setVisibility(8);
        if (indexOfChild(this.aTO) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.aTO, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.aTO.getLayoutParams();
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
            this.aTO.setLayoutParams(layoutParams2);
        }
    }

    private void GB() {
        this.aUa.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aUc != null && AlaDynamicVideoGiftLayout.this.aUc.Gm() && AlaDynamicVideoGiftLayout.this.aTO != null) {
                    AlaDynamicVideoGiftLayout.this.GC();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aUb.aMN.aMM.repeatCount || AlaDynamicVideoGiftLayout.this.aUa == null || AlaDynamicVideoGiftLayout.this.aUa.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.GF();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aUa.play(AlaDynamicVideoGiftLayout.this.aUb.DA());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.GF();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aUb != null && AlaDynamicVideoGiftLayout.this.aUb.aMN != null) {
                    if (AlaDynamicVideoGiftLayout.this.aUb.aMN.aML != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aUb.aMN.aML.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aUb.aMN.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.aUa.getView().getLayoutParams();
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
        if (this.aUc != null && this.aUc.aTb && this.aUb != null && this.aUb.aMN != null && this.aUb.aMN.aMM != null && this.aUb.aMN.aMM.aMQ) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aPj;
            return;
        }
        if (this.aUb != null && this.aUb.aMN != null && this.aUb.aMN.aMM != null && this.aUb.aMN.aMM.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aUa.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC() {
        if (this.aUa != null) {
            long duration = this.aUa.getDuration();
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
        if (this.aTO != null) {
            this.aTO.Ff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        if (this.aTO != null) {
            this.aTO.Fg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GF() {
        if (this.aTO != null) {
            this.aTO.end();
        }
        if (this.aTN != null) {
            this.aTN.m(this.aUc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GG() {
        if (this.aUc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aUc.userId), this.aUc.userName, this.aUc.portrait, this.aUc.sex, this.aUc.aSU, this.aUc.location, this.aUc.description, 0L, this.aUc.fansCount, this.aUc.aSV, this.aUc.userStatus, this.aUc.liveId, this.aUc.groupId, this.aUc.aSY, this.aUc.aSZ, this.aUc.appId, this.aUc.userName, "")));
        }
    }
}
