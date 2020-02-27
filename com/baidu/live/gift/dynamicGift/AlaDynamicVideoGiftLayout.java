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
    private com.baidu.live.gift.a.c amA;
    private int amB;
    private com.baidu.live.gift.biggift.b amm;
    private AlaBigGiftExtraInfoRevisionView amn;
    private com.baidu.live.alphavideo.c amy;
    private com.baidu.live.gift.c amz;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int d(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.amB + 1;
        alaDynamicVideoGiftLayout.amB = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.afL != null && cVar.afL.afK != null) {
            this.amz = cVar;
            this.amA = cVar2;
            uh();
        }
    }

    public void ta() {
        stopAnim();
        if (this.amm != null) {
            this.amm.onEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amm = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.amB = 0;
        if (this.amy != null && !this.amy.isDestroyed()) {
            this.amy.cR(this.amz.ri());
        }
        if (this.amm != null) {
            this.amm.onStart();
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.amy != null) {
            this.amy.stop();
            this.amy.release();
        }
        if (this.amn != null) {
            this.amn.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.amy != null) {
            this.amy.stop();
            this.amy.release();
        }
        if (this.amn != null) {
            this.amn.onDestroy();
        }
        removeAllViews();
    }

    private void uh() {
        ui();
        if (this.amA.tT()) {
            uj();
        }
    }

    private void ui() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
        if (runTask != null && runTask.getData() != null) {
            this.amy = (com.baidu.live.alphavideo.c) runTask.getData();
            this.amy.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                    if (AlaDynamicVideoGiftLayout.this.amn != null) {
                        AlaDynamicVideoGiftLayout.this.uk();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                        if (AlaDynamicVideoGiftLayout.d(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.amz.afL.afK.repeatCount || AlaDynamicVideoGiftLayout.this.amy == null || AlaDynamicVideoGiftLayout.this.amy.isDestroyed()) {
                            AlaDynamicVideoGiftLayout.this.un();
                        } else {
                            AlaDynamicVideoGiftLayout.this.amy.cR(AlaDynamicVideoGiftLayout.this.amz.ri());
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
            if (this.amz.afL != null && this.amz.afL.afK != null && this.amz.afL.afK.isBottomMargin()) {
                layoutParams.addRule(12);
            }
            addView(this.amy.getView(), layoutParams);
        }
    }

    private void uj() {
        this.amn = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.amn.setData(this.amA);
        this.amn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.uo();
            }
        });
        this.amn.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
        layoutParams.addRule(14);
        addView(this.amn, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk() {
        if (this.amy != null) {
            long duration = this.amy.getDuration();
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
        if (this.amn != null) {
            this.amn.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        if (this.amn != null) {
            this.amn.sQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un() {
        if (this.amn != null) {
            this.amn.end();
        }
        if (this.amm != null) {
            this.amm.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        if (this.amA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.amA.userId), this.amA.userName, this.amA.portrait, this.amA.sex, this.amA.aly, this.amA.location, this.amA.description, 0L, this.amA.fansCount, this.amA.alz, this.amA.userStatus, this.amA.liveId, this.amA.groupId, this.amA.alC, this.amA.alD, this.amA.appId, this.amA.userName, "")));
        }
    }
}
