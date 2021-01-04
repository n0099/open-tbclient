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
    private int bap;
    private com.baidu.live.gift.biggift.b bfF;
    private AlaBigGiftExtraInfoRevisionView bfG;
    private com.baidu.live.alphavideo.c bfS;
    private com.baidu.live.gift.c bfT;
    private com.baidu.live.gift.a.c bfU;
    private int bfV;
    private MediaMetadataRetriever bfW;
    private boolean bfX;
    private boolean isHost;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int f(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.bfV + 1;
        alaDynamicVideoGiftLayout.bfV = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
        this.bfX = false;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setEnterEffectRelativeBottomMargin(int i) {
        this.bap = i;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        setData(cVar, cVar2, screenDimensions[0], screenDimensions[1]);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aXb != null && cVar.aXb.aWZ != null) {
            this.bfT = cVar;
            this.bfU = cVar2;
            int[] ht = ht(this.bfT.Ge());
            g(ht[0], ht[1], i, i2);
        }
    }

    public void setLooping(boolean z) {
        this.bfX = z;
        if (this.bfS != null) {
            this.bfS.setLooping(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] ht(String str) {
        int i;
        int i2;
        int i3;
        if (this.bfW == null) {
            this.bfW = new MediaMetadataRetriever();
        }
        try {
            this.bfW.setDataSource(str);
            i = Integer.valueOf(this.bfW.extractMetadata(18)).intValue();
            try {
                i2 = Integer.valueOf(this.bfW.extractMetadata(19)).intValue();
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

    public void Is() {
        stopAnim();
        if (this.bfF != null) {
            this.bfF.n(this.bfU);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bfF = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        this.mStopped = false;
        this.bfV = 0;
        if (this.bfS != null && !this.bfS.isDestroyed() && !TextUtils.isEmpty(this.bfT.Ge())) {
            this.bfS.play(this.bfT.Ge());
            if (this.bfF != null) {
                this.bfF.m(this.bfU);
                return;
            }
            return;
        }
        JH();
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfS != null) {
            this.bfS.stop();
            this.bfS.reset();
        }
        if (this.bfG != null) {
            this.bfG.end();
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfW != null) {
            this.bfW.release();
        }
        if (this.bfS != null) {
            this.bfS.stop();
            this.bfS.release();
        }
        if (this.bfG != null) {
            this.bfG.onDestroy();
        }
        removeAllViews();
    }

    private void g(int i, int i2, int i3, int i4) {
        h(i, i2, i3, i4);
        if (this.bfU.Jo()) {
            Jz();
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        if (this.bfS == null || this.bfS.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfS = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        this.bfS.setLooping(this.bfX);
        JD();
        if (indexOfChild(this.bfS.getView()) < 0) {
            addView(this.bfS.getView());
        }
        i(i, i2, i3, i4);
    }

    private void Jz() {
        int dimensionPixelOffset;
        int bo;
        this.bfG = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.bfG.setData(this.bfU);
        this.bfG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.JI();
            }
        });
        this.bfG.setVisibility(8);
        if (indexOfChild(this.bfG) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            addView(this.bfG, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.bfG.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    bo = h.bn(getContext());
                } else {
                    bo = h.bo(getContext());
                }
                dimensionPixelOffset = bo + getResources().getDimensionPixelOffset(a.d.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
            this.bfG.setLayoutParams(layoutParams2);
        }
    }

    private void JD() {
        this.bfS.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.bfU != null && AlaDynamicVideoGiftLayout.this.bfU.Jo() && AlaDynamicVideoGiftLayout.this.bfG != null) {
                    AlaDynamicVideoGiftLayout.this.JE();
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onEnd() {
                if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                    if (AlaDynamicVideoGiftLayout.f(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.bfT.aXb.aWZ.repeatCount || AlaDynamicVideoGiftLayout.this.bfS == null || AlaDynamicVideoGiftLayout.this.bfS.isDestroyed()) {
                        AlaDynamicVideoGiftLayout.this.JH();
                    } else {
                        AlaDynamicVideoGiftLayout.this.bfS.play(AlaDynamicVideoGiftLayout.this.bfT.Ge());
                    }
                }
            }

            @Override // com.baidu.live.alphavideo.c.a
            public void onError(int i, String str) {
                AlaDynamicVideoGiftLayout.this.r(i, str);
                AlaDynamicVideoGiftLayout.this.JH();
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("err", Integer.valueOf(i));
                alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, str);
                if (AlaDynamicVideoGiftLayout.this.bfT != null && AlaDynamicVideoGiftLayout.this.bfT.aXb != null) {
                    if (AlaDynamicVideoGiftLayout.this.bfT.aXb.aWY != null) {
                        alaStatsItem.addValue("videourl", AlaDynamicVideoGiftLayout.this.bfT.aXb.aWY.videoUrl);
                    }
                    alaStatsItem.addValue("giftid", AlaDynamicVideoGiftLayout.this.bfT.aXb.giftId);
                }
                AlaStatManager.getInstance().debug("mp4player_playfail", alaStatsItem);
            }
        });
    }

    private void i(int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = this.bfS.getView().getLayoutParams();
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
        if (this.bfU != null && this.bfU.beI && this.bfT != null && this.bfT.aXb != null && this.bfT.aXb.aWZ != null && this.bfT.aXb.aWZ.aXe) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = this.bap;
            return;
        }
        if (this.bfT != null && this.bfT.aXb != null && this.bfT.aXb.aWZ != null && this.bfT.aXb.aWZ.isBottomMargin()) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
        } else if (Build.VERSION.SDK_INT >= 17) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(12);
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, 0);
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
        this.bfS.getView().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        if (this.bfS != null) {
            long duration = this.bfS.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.JF();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.JG();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            JF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF() {
        if (this.bfG != null) {
            this.bfG.Ii();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (this.bfG != null) {
            this.bfG.Ij();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str) {
        if (this.bfF != null) {
            this.bfF.a(i, str, this.bfU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JH() {
        if (this.bfG != null) {
            this.bfG.end();
        }
        if (this.bfF != null) {
            this.bfF.n(this.bfU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        if (this.bfU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.bfU.userId), this.bfU.userName, this.bfU.portrait, this.bfU.sex, this.bfU.bez, this.bfU.location, this.bfU.description, 0L, this.bfU.fansCount, this.bfU.followCount, this.bfU.userStatus, this.bfU.liveId, this.bfU.groupId, this.bfU.beF, this.bfU.beG, this.bfU.appId, this.bfU.userName)));
        }
    }
}
