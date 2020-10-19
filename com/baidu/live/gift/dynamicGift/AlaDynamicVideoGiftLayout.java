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
    private int aUw;
    private com.baidu.live.alphavideo.c aZA;
    private com.baidu.live.gift.c aZB;
    private com.baidu.live.gift.a.c aZC;
    private int aZD;
    private MediaMetadataRetriever aZE;
    private com.baidu.live.gift.biggift.b aZn;
    private AlaBigGiftExtraInfoRevisionView aZo;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aZD + 1;
        alaDynamicVideoGiftLayout.aZD = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aUw = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aRQ != null && cVar.aRQ.aRP != null) {
            this.aZB = cVar;
            this.aZC = cVar2;
            int[] hb = hb(this.aZB.EM());
            z(hb[0], hb[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] hb(String str) {
        int i;
        int i2;
        int i3;
        if (this.aZE == null) {
            this.aZE = new MediaMetadataRetriever();
        }
        try {
            this.aZE.setDataSource(str);
            i = Integer.valueOf(this.aZE.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aZE.extractMetadata(19)).intValue();
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

    public void GM() {
        stopAnim();
        if (this.aZn != null) {
            this.aZn.m(this.aZC);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aZn = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aZD = 0;
        if (this.aZA != null && !this.aZA.isDestroyed() && !TextUtils.isEmpty(this.aZB.EM())) {
            this.aZA.play(this.aZB.EM());
            if (this.aZn != null) {
                this.aZn.l(this.aZC);
                return;
            }
            return;
        }
        Ib();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZA != null) {
            this.aZA.stop();
            this.aZA.reset();
        }
        if (this.aZo != null) {
            this.aZo.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aZE != null) {
            this.aZE.release();
        }
        if (this.aZA != null) {
            this.aZA.stop();
            this.aZA.release();
        }
        if (this.aZo != null) {
            this.aZo.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.aZC.HI()) {
            HT();
        }
    }

    private void A(int i, int i2) {
        if (this.aZA == null || this.aZA.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aZA = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        HX();
        if (indexOfChild(this.aZA.getView()) < 0) {
            addView(this.aZA.getView());
        }
        B(i, i2);
    }

    private void HT() {
        int dimensionPixelOffset;
        int aD;
        if (this.aZo == null) {
            this.aZo = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aZo.setData(this.aZC);
        this.aZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Ic();
            }
        });
        this.aZo.setVisibility(8);
        if (indexOfChild(this.aZo) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.aZo, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.aZo.getLayoutParams();
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
            this.aZo.setLayoutParams(layoutParams2);
        }
    }

    private void HX() {
        this.aZA.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aZC != null && AlaDynamicVideoGiftLayout.this.aZC.HI() && AlaDynamicVideoGiftLayout.this.aZo != null) {
                    AlaDynamicVideoGiftLayout.this.HY();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aZB.aRQ.aRP.repeatCount || AlaDynamicVideoGiftLayout.this.aZA == null || AlaDynamicVideoGiftLayout.this.aZA.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Ib();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aZA.play(AlaDynamicVideoGiftLayout.this.aZB.EM());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Ib();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aZB != null && AlaDynamicVideoGiftLayout.this.aZB.aRQ != null) {
                    if (AlaDynamicVideoGiftLayout.this.aZB.aRQ.aRO != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aZB.aRQ.aRO.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aZB.aRQ.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.aZA.getView().getLayoutParams();
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
        if (this.aZC != null && this.aZC.aYy && this.aZB != null && this.aZB.aRQ != null && this.aZB.aRQ.aRP != null && this.aZB.aRQ.aRP.aRT) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aUw;
            return;
        }
        if (this.aZB != null && this.aZB.aRQ != null && this.aZB.aRQ.aRP != null && this.aZB.aRQ.aRP.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aZA.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        if (this.aZA != null) {
            long duration = this.aZA.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.HZ();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ia();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            HZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HZ() {
        if (this.aZo != null) {
            this.aZo.GB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia() {
        if (this.aZo != null) {
            this.aZo.GC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        if (this.aZo != null) {
            this.aZo.end();
        }
        if (this.aZn != null) {
            this.aZn.m(this.aZC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        if (this.aZC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aZC.userId), this.aZC.userName, this.aZC.portrait, this.aZC.sex, this.aZC.aYq, this.aZC.location, this.aZC.description, 0L, this.aZC.fansCount, this.aZC.aYr, this.aZC.userStatus, this.aZC.liveId, this.aZC.groupId, this.aZC.aYv, this.aZC.aYw, this.aZC.appId, this.aZC.userName, "")));
        }
    }
}
