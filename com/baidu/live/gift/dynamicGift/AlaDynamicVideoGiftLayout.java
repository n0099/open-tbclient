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
    private int aRl;
    private com.baidu.live.gift.biggift.b aWc;
    private AlaBigGiftExtraInfoRevisionView aWd;
    private com.baidu.live.alphavideo.c aWp;
    private com.baidu.live.gift.c aWq;
    private com.baidu.live.gift.a.c aWr;
    private int aWs;
    private MediaMetadataRetriever aWt;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.aWs + 1;
        alaDynamicVideoGiftLayout.aWs = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aRl = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.aOF != null && cVar.aOF.aOE != null) {
            this.aWq = cVar;
            this.aWr = cVar2;
            int[] gN = gN(this.aWq.DQ());
            z(gN[0], gN[1]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gN(String str) {
        int i;
        int i2;
        int i3;
        if (this.aWt == null) {
            this.aWt = new MediaMetadataRetriever();
        }
        try {
            this.aWt.setDataSource(str);
            i = Integer.valueOf(this.aWt.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.aWt.extractMetadata(19)).intValue();
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
        if (this.aWc != null) {
            this.aWc.m(this.aWr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aWc = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.aWs = 0;
        if (this.aWp != null && !this.aWp.isDestroyed() && !TextUtils.isEmpty(this.aWq.DQ())) {
            this.aWp.play(this.aWq.DQ());
            if (this.aWc != null) {
                this.aWc.l(this.aWr);
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
        if (this.aWp != null) {
            this.aWp.stop();
            this.aWp.reset();
        }
        if (this.aWd != null) {
            this.aWd.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aWt != null) {
            this.aWt.release();
        }
        if (this.aWp != null) {
            this.aWp.stop();
            this.aWp.release();
        }
        if (this.aWd != null) {
            this.aWd.onDestroy();
        }
        removeAllViews();
    }

    private void z(int i, int i2) {
        A(i, i2);
        if (this.aWr.GM()) {
            GX();
        }
    }

    private void A(int i, int i2) {
        if (this.aWp == null || this.aWp.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aWp = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        Hb();
        if (indexOfChild(this.aWp.getView()) < 0) {
            addView(this.aWp.getView());
        }
        B(i, i2);
    }

    private void GX() {
        int dimensionPixelOffset;
        int aA;
        if (this.aWd == null) {
            this.aWd = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.aWd.setData(this.aWr);
        this.aWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Hg();
            }
        });
        this.aWd.setVisibility(8);
        if (indexOfChild(this.aWd) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.aWd, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.aWd.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aA = h.az(getContext());
                } else {
                    aA = h.aA(getContext());
                }
                dimensionPixelOffset = aA + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.aWd.setLayoutParams(layoutParams2);
        }
    }

    private void Hb() {
        this.aWp.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.aWr != null && AlaDynamicVideoGiftLayout.this.aWr.GM() && AlaDynamicVideoGiftLayout.this.aWd != null) {
                    AlaDynamicVideoGiftLayout.this.Hc();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.aWq.aOF.aOE.repeatCount || AlaDynamicVideoGiftLayout.this.aWp == null || AlaDynamicVideoGiftLayout.this.aWp.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Hf();
                    } else {
                        AlaDynamicVideoGiftLayout.this.aWp.play(AlaDynamicVideoGiftLayout.this.aWq.DQ());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.Hf();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.aWq != null && AlaDynamicVideoGiftLayout.this.aWq.aOF != null) {
                    if (AlaDynamicVideoGiftLayout.this.aWq.aOF.aOD != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.aWq.aOF.aOD.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.aWq.aOF.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void B(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.aWp.getView().getLayoutParams();
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
        if (this.aWr != null && this.aWr.aVn && this.aWq != null && this.aWq.aOF != null && this.aWq.aOF.aOE != null && this.aWq.aOF.aOE.aOI) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aRl;
            return;
        }
        if (this.aWq != null && this.aWq.aOF != null && this.aWq.aOF.aOE != null && this.aWq.aOF.aOE.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.aWp.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        if (this.aWp != null) {
            long duration = this.aWp.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Hd();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
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
        if (this.aWd != null) {
            this.aWd.FF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (this.aWd != null) {
            this.aWd.FG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        if (this.aWd != null) {
            this.aWd.end();
        }
        if (this.aWc != null) {
            this.aWc.m(this.aWr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        if (this.aWr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aWr.userId), this.aWr.userName, this.aWr.portrait, this.aWr.sex, this.aWr.aVf, this.aWr.location, this.aWr.description, 0L, this.aWr.fansCount, this.aWr.aVg, this.aWr.userStatus, this.aWr.liveId, this.aWr.groupId, this.aWr.aVk, this.aWr.aVl, this.aWr.appId, this.aWr.userName, "")));
        }
    }
}
