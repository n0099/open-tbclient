package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.alphavideo.c;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.u.a;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class AlaDynamicVideoGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.c amA;
    private com.baidu.live.gift.a.c amB;
    private int amC;
    private com.baidu.live.gift.biggift.b amn;
    private AlaBigGiftExtraInfoRevisionView amo;
    private com.baidu.live.alphavideo.c amz;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int d(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.amC + 1;
        alaDynamicVideoGiftLayout.amC = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.afL != null && cVar.afL.afK != null) {
            this.amA = cVar;
            this.amB = cVar2;
            uh();
        }
    }

    public void ta() {
        stopAnim();
        if (this.amn != null) {
            this.amn.onEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amn = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.amC = 0;
        if (this.amz != null && !this.amz.isDestroyed()) {
            this.amz.cR(this.amA.ri());
        }
        if (this.amn != null) {
            this.amn.onStart();
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.amz != null) {
            this.amz.stop();
            this.amz.release();
        }
        if (this.amo != null) {
            this.amo.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.amz != null) {
            this.amz.stop();
            this.amz.release();
        }
        if (this.amo != null) {
            this.amo.onDestroy();
        }
        removeAllViews();
    }

    private void uh() {
        ui();
        if (this.amB.tT()) {
            uj();
        }
    }

    private void ui() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
        if (runTask != null && runTask.getData() != null) {
            this.amz = (com.baidu.live.alphavideo.c) runTask.getData();
            this.amz.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                    if (AlaDynamicVideoGiftLayout.this.amo != null) {
                        AlaDynamicVideoGiftLayout.this.uk();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                        if (AlaDynamicVideoGiftLayout.d(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.amA.afL.afK.repeatCount || AlaDynamicVideoGiftLayout.this.amz == null || AlaDynamicVideoGiftLayout.this.amz.isDestroyed()) {
                            AlaDynamicVideoGiftLayout.this.un();
                        } else {
                            AlaDynamicVideoGiftLayout.this.amz.cR(AlaDynamicVideoGiftLayout.this.amA.ri());
                        }
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    AlaDynamicVideoGiftLayout.this.un();
                }
            });
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            int i = screenDimensions[0];
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, screenDimensions[1] > i ? (i * FormCard.HEIGHT_DEFAULT_SIZE) / FormCard.WIDTH_DEFAULT_SIZE : (i * FormCard.WIDTH_DEFAULT_SIZE) / FormCard.HEIGHT_DEFAULT_SIZE);
            if (this.amA.afL != null && this.amA.afL.afK != null && this.amA.afL.afK.isBottomMargin()) {
                layoutParams.addRule(12);
            }
            addView(this.amz.getView(), layoutParams);
        }
    }

    private void uj() {
        this.amo = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.amo.setData(this.amB);
        this.amo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.uo();
            }
        });
        this.amo.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
        layoutParams.addRule(14);
        addView(this.amo, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk() {
        if (this.amz != null) {
            long duration = this.amz.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.ul();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.um();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            ul();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul() {
        if (this.amo != null) {
            this.amo.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        if (this.amo != null) {
            this.amo.sQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un() {
        if (this.amo != null) {
            this.amo.end();
        }
        if (this.amn != null) {
            this.amn.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        if (this.amB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.amB.userId), this.amB.userName, this.amB.portrait, this.amB.sex, this.amB.alz, this.amB.location, this.amB.description, 0L, this.amB.fansCount, this.amB.alA, this.amB.userStatus, this.amB.liveId, this.amB.groupId, this.amB.alD, this.amB.alE, this.amB.appId, this.amB.userName, "")));
        }
    }
}
