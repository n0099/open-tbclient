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
    private com.baidu.live.alphavideo.c amJ;
    private com.baidu.live.gift.c amK;
    private com.baidu.live.gift.a.c amL;
    private int amM;
    private com.baidu.live.gift.biggift.b amx;
    private AlaBigGiftExtraInfoRevisionView amy;
    private Handler mHandler;
    private boolean mStopped;

    static /* synthetic */ int d(AlaDynamicVideoGiftLayout alaDynamicVideoGiftLayout) {
        int i = alaDynamicVideoGiftLayout.amM + 1;
        alaDynamicVideoGiftLayout.amM = i;
        return i;
    }

    public AlaDynamicVideoGiftLayout(Context context) {
        super(context);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar.afV != null && cVar.afV.afU != null) {
            this.amK = cVar;
            this.amL = cVar2;
            um();
        }
    }

    public void tf() {
        stopAnim();
        if (this.amx != null) {
            this.amx.onEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amx = bVar;
    }

    public void startAnim() {
        this.mStopped = false;
        this.amM = 0;
        if (this.amJ != null && !this.amJ.isDestroyed()) {
            this.amJ.cQ(this.amK.rn());
        }
        if (this.amx != null) {
            this.amx.onStart();
        }
    }

    public void stopAnim() {
        this.mStopped = true;
        if (this.amJ != null) {
            this.amJ.stop();
            this.amJ.release();
        }
        if (this.amy != null) {
            this.amy.end();
        }
    }

    public void onDestroy() {
        this.mStopped = true;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.amJ != null) {
            this.amJ.stop();
            this.amJ.release();
        }
        if (this.amy != null) {
            this.amy.onDestroy();
        }
        removeAllViews();
    }

    private void um() {
        un();
        if (this.amL.tY()) {
            uo();
        }
    }

    private void un() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
        if (runTask != null && runTask.getData() != null) {
            this.amJ = (com.baidu.live.alphavideo.c) runTask.getData();
            this.amJ.a(new c.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.1
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                    if (AlaDynamicVideoGiftLayout.this.amy != null) {
                        AlaDynamicVideoGiftLayout.this.up();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (!AlaDynamicVideoGiftLayout.this.mStopped) {
                        if (AlaDynamicVideoGiftLayout.d(AlaDynamicVideoGiftLayout.this) >= AlaDynamicVideoGiftLayout.this.amK.afV.afU.repeatCount || AlaDynamicVideoGiftLayout.this.amJ == null || AlaDynamicVideoGiftLayout.this.amJ.isDestroyed()) {
                            AlaDynamicVideoGiftLayout.this.us();
                        } else {
                            AlaDynamicVideoGiftLayout.this.amJ.cQ(AlaDynamicVideoGiftLayout.this.amK.rn());
                        }
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    AlaDynamicVideoGiftLayout.this.us();
                }
            });
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            int i = screenDimensions[0];
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, screenDimensions[1] > i ? (i * FormCard.HEIGHT_DEFAULT_SIZE) / FormCard.WIDTH_DEFAULT_SIZE : (i * FormCard.WIDTH_DEFAULT_SIZE) / FormCard.HEIGHT_DEFAULT_SIZE);
            if (this.amK.afV != null && this.amK.afV.afU != null && this.amK.afV.afU.isBottomMargin()) {
                layoutParams.addRule(12);
            }
            addView(this.amJ.getView(), layoutParams);
        }
    }

    private void uo() {
        this.amy = new AlaBigGiftExtraInfoRevisionView(getContext());
        this.amy.setData(this.amL);
        this.amy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicVideoGiftLayout.this.ut();
            }
        });
        this.amy.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
        layoutParams.addRule(14);
        addView(this.amy, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        if (this.amJ != null) {
            long duration = this.amJ.getDuration();
            if (duration > 0) {
                this.mHandler = new Handler();
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.uq();
                    }
                }, ((float) duration) * 0.07f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaDynamicVideoGiftLayout.this.ur();
                    }
                }, ((float) duration) * 0.87f);
                return;
            }
            uq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        if (this.amy != null) {
            this.amy.sU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        if (this.amy != null) {
            this.amy.sV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us() {
        if (this.amy != null) {
            this.amy.end();
        }
        if (this.amx != null) {
            this.amx.onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ut() {
        if (this.amL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.amL.userId), this.amL.userName, this.amL.portrait, this.amL.sex, this.amL.alJ, this.amL.location, this.amL.description, 0L, this.amL.fansCount, this.amL.alK, this.amL.userStatus, this.amL.liveId, this.amL.groupId, this.amL.alN, this.amL.alO, this.amL.appId, this.amL.userName, "")));
        }
    }
}
