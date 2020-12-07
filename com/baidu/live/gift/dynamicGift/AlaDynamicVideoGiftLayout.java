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
    private int aYJ;
    private com.baidu.live.gift.biggift.b bdS;
    private AlaBigGiftExtraInfoRevisionView bdT;
    private com.baidu.live.alphavideo.c bef;
    private com.baidu.live.gift.c beh;
    private com.baidu.live.gift.a.c bei;
    private int bej;
    private MediaMetadataRetriever bek;
    private boolean bel;
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
        this.bel = false;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aYJ = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        setData(cVar, cVar2, screenDimensions[0], screenDimensions[1]);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aVv != null && cVar.aVv.aVu != null) {
            this.beh = cVar;
            this.bei = cVar2;
            int[] hI = hI(this.beh.GE());
            g(hI[0], hI[1], i, i2);
        }
    }

    public void setLooping(boolean z) {
        this.bel = z;
        if (this.bef != null) {
            this.bef.setLooping(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
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
        try {
            this.bek.setDataSource(str);
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
        if (this.bdS != null) {
            this.bdS.m(this.bei);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bdS = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        this.mStopped = false;
        this.bej = 0;
        if (this.bef != null && !this.bef.isDestroyed() && !TextUtils.isEmpty(this.beh.GE())) {
            this.bef.play(this.beh.GE());
            if (this.bdS != null) {
                this.bdS.l(this.bei);
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
        if (this.bdT != null) {
            this.bdT.end();
        }
    }

    @Override // com.baidu.live.gift.biggift.c
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
        if (this.bdT != null) {
            this.bdT.onDestroy();
        }
        removeAllViews();
    }

    private void g(int i, int i2, int i3, int i4) {
        h(i, i2, i3, i4);
        if (this.bei.JM()) {
            JX();
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.bef.setLooping(this.bel);
        Kb();
        if (indexOfChild(this.bef.getView()) < 0) {
            addView(this.bef.getView());
        }
        i(i, i2, i3, i4);
    }

    private void JX() {
        int dimensionPixelOffset;
        int bi;
        this.bdT = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.bdT.setData(this.bei);
        this.bdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Kg();
            }
        });
        this.bdT.setVisibility(8);
        if (indexOfChild(this.bdT) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.bdT, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.bdT.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bi = h.bh(getContext());
                } else {
                    bi = h.bi(getContext());
                }
                dimensionPixelOffset = bi + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.bdT.setLayoutParams(layoutParams2);
        }
    }

    private void Kb() {
        this.bef.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bei != null && AlaDynamicVideoGiftLayout.this.bei.JM() && AlaDynamicVideoGiftLayout.this.bdT != null) {
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

    private void i(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.bef.getView().getLayoutParams();
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
        if (this.bei != null && this.bei.bda && this.beh != null && this.beh.aVv != null && this.beh.aVv.aVu != null && this.beh.aVv.aVu.aVy) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aYJ;
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.Kd();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
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
        if (this.bdT != null) {
            this.bdT.IG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        if (this.bdT != null) {
            this.bdT.IH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (this.bdT != null) {
            this.bdT.end();
        }
        if (this.bdS != null) {
            this.bdS.m(this.bei);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.bei != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bei.userId), this.bei.userName, this.bei.portrait, this.bei.sex, this.bei.bcP, this.bei.location, this.bei.description, 0L, this.bei.bcR, this.bei.bcQ, this.bei.userStatus, this.bei.liveId, this.bei.groupId, this.bei.bcX, this.bei.bcY, this.bei.appId, this.bei.userName, "")));
        }
    }
}
