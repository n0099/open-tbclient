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
    private int bak;
    private com.baidu.live.alphavideo.c bfL;
    private com.baidu.live.gift.c bfM;
    private com.baidu.live.gift.a.c bfN;
    private int bfO;
    private MediaMetadataRetriever bfP;
    private boolean bfQ;
    private com.baidu.live.gift.biggift.b bfy;
    private AlaBigGiftExtraInfoRevisionView bfz;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bfO + 1;
        alaDynamicVideoGiftLayout.bfO = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
        this.bfQ = false;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.bak = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        setData(cVar, cVar2, screenDimensions[0], screenDimensions[1]);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aWS != null && cVar.aWS.aWQ != null) {
            this.bfM = cVar;
            this.bfN = cVar2;
            int[] gL = gL(this.bfM.DB());
            g(gL[0], gL[1], i, i2);
        }
    }

    public void setLooping(boolean z) {
        this.bfQ = z;
        if (this.bfL != null) {
            this.bfL.setLooping(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] gL(String str) {
        int i;
        int i2;
        int i3;
        if (this.bfP == null) {
            this.bfP = new MediaMetadataRetriever();
        }
        try {
            this.bfP.setDataSource(str);
            i = Integer.valueOf(this.bfP.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bfP.extractMetadata(19)).intValue();
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
        if (this.bfy != null) {
            this.bfy.n(this.bfN);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bfy = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        this.mStopped = false;
        this.bfO = 0;
        if (this.bfL != null && !this.bfL.isDestroyed() && !TextUtils.isEmpty(this.bfM.DB())) {
            this.bfL.play(this.bfM.DB());
            if (this.bfy != null) {
                this.bfy.m(this.bfN);
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
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.reset();
        }
        if (this.bfz != null) {
            this.bfz.end();
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfP != null) {
            this.bfP.release();
        }
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.release();
        }
        if (this.bfz != null) {
            this.bfz.onDestroy();
        }
        removeAllViews();
    }

    private void g(int i, int i2, int i3, int i4) {
        h(i, i2, i3, i4);
        if (this.bfN.GM()) {
            GX();
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        if (this.bfL == null || this.bfL.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfL = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.bfL.setLooping(this.bfQ);
        Hb();
        if (indexOfChild(this.bfL.getView()) < 0) {
            addView(this.bfL.getView());
        }
        i(i, i2, i3, i4);
    }

    private void GX() {
        int dimensionPixelOffset;
        int bm;
        this.bfz = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.bfz.setData(this.bfN);
        this.bfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.Hg();
            }
        });
        this.bfz.setVisibility(8);
        if (indexOfChild(this.bfz) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.bfz, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.bfz.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bm = h.bl(getContext());
                } else {
                    bm = h.bm(getContext());
                }
                dimensionPixelOffset = bm + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.bfz.setLayoutParams(layoutParams2);
        }
    }

    private void Hb() {
        this.bfL.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bfN != null && AlaDynamicVideoGiftLayout.this.bfN.GM() && AlaDynamicVideoGiftLayout.this.bfz != null) {
                    AlaDynamicVideoGiftLayout.this.Hc();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bfM.aWS.aWQ.repeatCount || AlaDynamicVideoGiftLayout.this.bfL == null || AlaDynamicVideoGiftLayout.this.bfL.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.Hf();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bfL.play(AlaDynamicVideoGiftLayout.this.bfM.DB());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.v(i, str);
                AlaDynamicVideoGiftLayout.this.Hf();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bfM != null && AlaDynamicVideoGiftLayout.this.bfM.aWS != null) {
                    if (AlaDynamicVideoGiftLayout.this.bfM.aWS.aWP != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bfM.aWS.aWP.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bfM.aWS.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void i(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.bfL.getView().getLayoutParams();
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
        if (this.bfN != null && this.bfN.beB && this.bfM != null && this.bfM.aWS != null && this.bfM.aWS.aWQ != null && this.bfM.aWS.aWQ.aWV) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.bak;
            return;
        }
        if (this.bfM != null && this.bfM.aWS != null && this.bfM.aWS.aWQ != null && this.bfM.aWS.aWQ.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bfL.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        if (this.bfL != null) {
            long duration = this.bfL.getDuration();
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
        if (this.bfz != null) {
            this.bfz.FG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (this.bfz != null) {
            this.bfz.FH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, String str) {
        if (this.bfy != null) {
            this.bfy.a(i, str, this.bfN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        if (this.bfz != null) {
            this.bfz.end();
        }
        if (this.bfy != null) {
            this.bfy.n(this.bfN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        if (this.bfN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bfN.userId), this.bfN.userName, this.bfN.portrait, this.bfN.sex, this.bfN.ber, this.bfN.location, this.bfN.description, 0L, this.bfN.fansCount, this.bfN.followCount, this.bfN.userStatus, this.bfN.liveId, this.bfN.groupId, this.bfN.bey, this.bfN.bez, this.bfN.appId, this.bfN.userName)));
        }
    }
}
