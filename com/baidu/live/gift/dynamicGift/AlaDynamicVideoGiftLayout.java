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
/* loaded from: classes11.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private int aYK;
    private com.baidu.live.gift.biggift.b bdU;
    private AlaBigGiftExtraInfoRevisionView bdV;
    private com.baidu.live.alphavideo.c bei;
    private com.baidu.live.gift.c bej;
    private com.baidu.live.gift.a.c bek;
    private int bel;
    private MediaMetadataRetriever bem;
    private boolean ben;
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
        this.ben = false;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aYK = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        setData(cVar, cVar2, screenDimensions[0], screenDimensions[1]);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVs != null && cVar.aVs.aVq != null) {
            this.bej = cVar;
            this.bek = cVar2;
            int[] gF = gF(this.bej.Dy());
            g(gF[0], gF[1], i, i2);
        }
    }

    public void setLooping(boolean z) {
        this.ben = z;
        if (this.bei != null) {
            this.bei.setLooping(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
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
        try {
            this.bem.setDataSource(str);
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
        if (this.bdU != null) {
            this.bdU.n(this.bek);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bdU = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        this.mStopped = false;
        this.bel = 0;
        if (this.bei != null && !this.bei.isDestroyed() && !TextUtils.isEmpty(this.bej.Dy())) {
            this.bei.play(this.bej.Dy());
            if (this.bdU != null) {
                this.bdU.m(this.bek);
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
        if (this.bdV != null) {
            this.bdV.end();
        }
    }

    @Override // com.baidu.live.gift.biggift.c
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
        if (this.bdV != null) {
            this.bdV.onDestroy();
        }
        removeAllViews();
    }

    private void g(int i, int i2, int i3, int i4) {
        h(i, i2, i3, i4);
        if (this.bek.GJ()) {
            GU();
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.bei.setLooping(this.ben);
        GY();
        if (indexOfChild(this.bei.getView()) < 0) {
            addView(this.bei.getView());
        }
        i(i, i2, i3, i4);
    }

    private void GU() {
        int dimensionPixelOffset;
        int bn;
        this.bdV = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.bdV.setData(this.bek);
        this.bdV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Hd();
            }
        });
        this.bdV.setVisibility(8);
        if (indexOfChild(this.bdV) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.bdV, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.bdV.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bn = h.bm(getContext());
                } else {
                    bn = h.bn(getContext());
                }
                dimensionPixelOffset = bn + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.bdV.setLayoutParams(layoutParams2);
        }
    }

    private void GY() {
        this.bei.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bek != null && AlaDynamicVideoGiftLayout.this.bek.GJ() && AlaDynamicVideoGiftLayout.this.bdV != null) {
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
                AlaDynamicVideoGiftLayout.this.v(i, str);
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

    private void i(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.bei.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            layoutParams.width = -1;
            layoutParams.height = (i3 * i2) / i;
        } else {
            layoutParams.width = (i4 * i) / i2;
            layoutParams.height = -1;
            ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
        }
        if (this.bek != null && this.bek.bcZ && this.bej != null && this.bej.aVs != null && this.bej.aVs.aVq != null && this.bej.aVs.aVq.aVv) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aYK;
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Ha();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
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
        if (this.bdV != null) {
            this.bdV.FD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hb() {
        if (this.bdV != null) {
            this.bdV.FE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        if (this.bdU != null) {
            this.bdU.a(i, str, this.bek);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        if (this.bdV != null) {
            this.bdV.end();
        }
        if (this.bdU != null) {
            this.bdU.n(this.bek);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        if (this.bek != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bek.userId), this.bek.userName, this.bek.portrait, this.bek.sex, this.bek.bcQ, this.bek.location, this.bek.description, 0L, this.bek.fansCount, this.bek.followCount, this.bek.userStatus, this.bek.liveId, this.bek.groupId, this.bek.bcW, this.bek.bcX, this.bek.appId, this.bek.userName)));
        }
    }
}
