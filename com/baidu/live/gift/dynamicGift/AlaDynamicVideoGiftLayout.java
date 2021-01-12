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
/* loaded from: classes10.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private int aVC;
    private com.baidu.live.gift.biggift.b baP;
    private AlaBigGiftExtraInfoRevisionView baQ;
    private com.baidu.live.alphavideo.c bbc;
    private com.baidu.live.gift.c bbd;
    private com.baidu.live.gift.a.c bbe;
    private int bbf;
    private MediaMetadataRetriever bbg;
    private boolean bbh;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bbf + 1;
        alaDynamicVideoGiftLayout.bbf = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
        this.bbh = false;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.aVC = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        setData(cVar, cVar2, screenDimensions[0], screenDimensions[1]);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aSo != null && cVar.aSo.aSm != null) {
            this.bbd = cVar;
            this.bbe = cVar2;
            int[] gh = gh(this.bbd.Cj());
            g(gh[0], gh[1], i, i2);
        }
    }

    public void setLooping(boolean z) {
        this.bbh = z;
        if (this.bbc != null) {
            this.bbc.setLooping(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gh(String str) {
        int i;
        int i2;
        int i3;
        if (this.bbg == null) {
            this.bbg = new MediaMetadataRetriever();
        }
        try {
            this.bbg.setDataSource(str);
            i = Integer.valueOf(this.bbg.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bbg.extractMetadata(19)).intValue();
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

    public void Ex() {
        stopAnim();
        if (this.baP != null) {
            this.baP.n(this.bbe);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.baP = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        this.mStopped = false;
        this.bbf = 0;
        if (this.bbc != null && !this.bbc.isDestroyed() && !TextUtils.isEmpty(this.bbd.Cj())) {
            this.bbc.play(this.bbd.Cj());
            if (this.baP != null) {
                this.baP.m(this.bbe);
                return;
            }
            return;
        }
        FM();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.reset();
        }
        if (this.baQ != null) {
            this.baQ.end();
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbg != null) {
            this.bbg.release();
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.release();
        }
        if (this.baQ != null) {
            this.baQ.onDestroy();
        }
        removeAllViews();
    }

    private void g(int i, int i2, int i3, int i4) {
        h(i, i2, i3, i4);
        if (this.bbe.Ft()) {
            FE();
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        if (this.bbc == null || this.bbc.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bbc = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.bbc.setLooping(this.bbh);
        FI();
        if (indexOfChild(this.bbc.getView()) < 0) {
            addView(this.bbc.getView());
        }
        i(i, i2, i3, i4);
    }

    private void FE() {
        int dimensionPixelOffset;
        int bn;
        this.baQ = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.baQ.setData(this.bbe);
        this.baQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.FN();
            }
        });
        this.baQ.setVisibility(8);
        if (indexOfChild(this.baQ) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.baQ, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.baQ.getLayoutParams();
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
            this.baQ.setLayoutParams(layoutParams2);
        }
    }

    private void FI() {
        this.bbc.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bbe != null && AlaDynamicVideoGiftLayout.this.bbe.Ft() && AlaDynamicVideoGiftLayout.this.baQ != null) {
                    AlaDynamicVideoGiftLayout.this.FJ();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bbd.aSo.aSm.repeatCount || AlaDynamicVideoGiftLayout.this.bbc == null || AlaDynamicVideoGiftLayout.this.bbc.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.FM();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bbc.play(AlaDynamicVideoGiftLayout.this.bbd.Cj());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.s(i, str);
                AlaDynamicVideoGiftLayout.this.FM();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bbd != null && AlaDynamicVideoGiftLayout.this.bbd.aSo != null) {
                    if (AlaDynamicVideoGiftLayout.this.bbd.aSo.aSl != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bbd.aSo.aSl.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bbd.aSo.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void i(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.bbc.getView().getLayoutParams();
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
        if (this.bbe != null && this.bbe.aZS && this.bbd != null && this.bbd.aSo != null && this.bbd.aSo.aSm != null && this.bbd.aSo.aSm.aSr) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.aVC;
            return;
        }
        if (this.bbd != null && this.bbd.aSo != null && this.bbd.aSo.aSm != null && this.bbd.aSo.aSm.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bbc.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.bbc != null) {
            long duration = this.bbc.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.FK();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.FL();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            FK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK() {
        if (this.baQ != null) {
            this.baQ.En();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.baQ != null) {
            this.baQ.Eo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, String str) {
        if (this.baP != null) {
            this.baP.a(i, str, this.bbe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.baQ != null) {
            this.baQ.end();
        }
        if (this.baP != null) {
            this.baP.n(this.bbe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN() {
        if (this.bbe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bbe.userId), this.bbe.userName, this.bbe.portrait, this.bbe.sex, this.bbe.aZJ, this.bbe.location, this.bbe.description, 0L, this.bbe.fansCount, this.bbe.followCount, this.bbe.userStatus, this.bbe.liveId, this.bbe.groupId, this.bbe.aZP, this.bbe.aZQ, this.bbe.appId, this.bbe.userName)));
        }
    }
}
