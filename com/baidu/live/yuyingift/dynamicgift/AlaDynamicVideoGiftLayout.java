package com.baidu.live.yuyingift.dynamicgift;

import android.app.Activity;
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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.alphavideo.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.yuyingift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.tieba.recapp.lego.model.FormCard;
import java.io.File;
/* loaded from: classes11.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bZY;
    private AlaBigGiftExtraInfoRevisionView bZZ;
    private com.baidu.live.alphavideo.c bfS;
    private com.baidu.live.gift.c bfT;
    private int bfV;
    private MediaMetadataRetriever bfW;
    private boolean cab;
    private com.baidu.live.yuyingift.a.c cae;
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
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setIsKeyBoadVis(boolean z) {
        if (this.cab != z) {
            this.cab = z;
            dG(this.cab);
        }
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (cVar != null && cVar.aXb != null && cVar.aXb.aWZ != null) {
            this.bfT = cVar;
            this.cae = cVar2;
            if (!TextUtils.isEmpty(this.bfT.Ge())) {
                try {
                    if (new File(this.bfT.Ge()).exists()) {
                        int[] ht = ht(this.bfT.Ge());
                        R(ht[0], ht[1]);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            dG(this.cab);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
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
        this.bfW.setDataSource(str);
        try {
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
        if (this.bZY != null) {
            this.bZY.l(this.cae);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bZY = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.bfV = 0;
        if (this.bfS != null && !this.bfS.isDestroyed() && !TextUtils.isEmpty(this.bfT.Ge())) {
            this.bfS.play(this.bfT.Ge());
            if (this.bZY != null) {
                this.bZY.k(this.cae);
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
        if (this.bZZ != null) {
            this.bZZ.end();
        }
    }

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
        if (this.bZZ != null) {
            this.bZZ.onDestroy();
        }
        removeAllViews();
    }

    private void R(int i, int i2) {
        S(i, i2);
        if (this.cae.Jo()) {
            Jz();
        }
    }

    private void S(int i, int i2) {
        if (this.bfS == null || this.bfS.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfS = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        JD();
        if (indexOfChild(this.bfS.getView()) < 0) {
            addView(this.bfS.getView());
        }
        T(i, i2);
    }

    private void Jz() {
        if (this.bZZ == null) {
            this.bZZ = new AlaBigGiftExtraInfoRevisionView(getContext());
        }
        this.bZZ.setData(this.cae);
        this.bZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.JI();
            }
        });
        this.bZZ.setVisibility(8);
        if (indexOfChild(this.bZZ) < 0) {
            int i = 0;
            if (this.cae != null && this.cae.beF && (getContext() instanceof Activity) && UtilHelper.canUseStyleImmersiveSticky()) {
                i = BdUtilHelper.getStatusBarHeight((Activity) getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = i + getResources().getDimensionPixelOffset(a.d.sdk_ds206);
            layoutParams.addRule(14);
            addView(this.bZZ, layoutParams);
        }
    }

    private void JD() {
        this.bfS.a(new c.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.2
            @Override // com.baidu.live.alphavideo.c.a
            public void onStart() {
                if (AlaDynamicVideoGiftLayout.this.cae != null && AlaDynamicVideoGiftLayout.this.cae.Jo() && AlaDynamicVideoGiftLayout.this.bZZ != null) {
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

    private void T(int i, int i2) {
        if (this.cae != null && !this.cae.beI) {
            i = FormCard.WIDTH_DEFAULT_SIZE;
            i2 = FormCard.HEIGHT_DEFAULT_SIZE;
        }
        ViewGroup.LayoutParams layoutParams = this.bfS.getView().getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        layoutParams.width = -1;
        layoutParams.height = screenDimensions[1] > screenDimensions[0] ? (screenDimensions[0] * i2) / i : (screenDimensions[0] * i) / i2;
        if (this.cae != null && this.cae.beI && this.bfT != null && this.bfT.aXb != null && this.bfT.aXb.aWZ != null && this.bfT.aXb.aWZ.aXe) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.baidu.live.al.c.d(this.isHost, false, false) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds200);
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
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.JF();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout.4
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
        if (this.bZZ != null) {
            this.bZZ.Ii();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (this.bZZ != null) {
            this.bZZ.Ij();
        }
    }

    public com.baidu.live.yuyingift.a.c getGiftData() {
        return this.cae;
    }

    private void dG(boolean z) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501083, Integer.class);
        if (this.bfS != null && this.bfS.getView() != null && runTask != null) {
            ViewGroup.LayoutParams layoutParams = this.bfS.getView().getLayoutParams();
            if (runTask != null && layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams) && this.cae != null && this.cae.beI) {
                int intValue = ((Integer) runTask.getData()).intValue();
                if (z) {
                    int realScreenHeight = ScreenHelper.getRealScreenHeight(getContext());
                    int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight() + intValue;
                    int height = this.bfS.getView().getHeight();
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = realScreenHeight - keyboardHeight < height ? (realScreenHeight - height) - BdUtilHelper.dip2px(getContext(), 20.0f) : keyboardHeight;
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = intValue + getBoottomBarHeight();
                }
                this.bfS.getView().setLayoutParams(layoutParams);
            }
        }
    }

    private int getBoottomBarHeight() {
        return (int) TbadkCoreApplication.getInst().getResources().getDimension(a.d.sdk_ds120);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JH() {
        if (this.bZZ != null) {
            this.bZZ.end();
        }
        if (this.bZY != null) {
            this.bZY.l(this.cae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        if (this.cae != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(getContext(), String.valueOf(this.cae.userId), this.cae.userName, this.cae.portrait, this.cae.sex, this.cae.bez, this.cae.location, this.cae.description, 0L, this.cae.fansCount, this.cae.followCount, this.cae.userStatus, this.cae.liveId, this.cae.groupId, this.cae.beF, this.cae.beG, this.cae.appId, this.cae.userName, "")));
        }
    }
}
