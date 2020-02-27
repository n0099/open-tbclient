package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoRevisionView;
import com.baidu.live.gift.d;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c ahQ;
    private boolean alE;
    private int alV;
    private com.baidu.live.gift.biggift.b amm;
    private AlaBigGiftExtraInfoRevisionView amn;
    private AlaDynamicGiftAnimationView amo;
    public d amp;
    private a amq;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.alE = true;
        this.amq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bL(i);
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.bt(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amn != null) {
                    AlaDynamicGiftLayout.this.amn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.alE = true;
        this.amq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bL(i);
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.bt(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amn != null) {
                    AlaDynamicGiftLayout.this.amn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.alE = true;
        this.amq = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bL(i2);
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.bt(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amn != null) {
                    AlaDynamicGiftLayout.this.amn.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amm != null) {
                    AlaDynamicGiftLayout.this.amm.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.amo = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.amo.setFrameCallback(this.amq);
        this.amn = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.amn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.sS();
            }
        });
        this.alE = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.afL != null && cVar.afL.afK != null) {
            this.ahQ = cVar2;
            if (i > 0 && i2 > 0) {
                u(i, i2);
            } else {
                ue();
            }
            this.amp = cVar.afL.afK;
            this.mFrameCount = this.amp.frame_count;
            if (this.amn != null) {
                if (!cVar2.tT()) {
                    this.amn.setVisibility(8);
                    this.alE = false;
                } else {
                    this.amn.setData(cVar2);
                    this.alE = true;
                }
            }
            if (this.amo != null) {
                this.amo.setScreen(this.alV, this.mScreenHeight);
                this.amo.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        if (this.ahQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.ahQ.userId), this.ahQ.userName, this.ahQ.portrait, this.ahQ.sex, this.ahQ.aly, this.ahQ.location, this.ahQ.description, 0L, this.ahQ.fansCount, this.ahQ.alz, this.ahQ.userStatus, this.ahQ.liveId, this.ahQ.groupId, this.ahQ.alC, this.ahQ.alD, this.ahQ.appId, this.ahQ.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(int i) {
        if (this.amn != null && this.alE) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.amn.sP();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.amn.sQ();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.amo != null) {
            this.amo.startAnim();
            this.isShowing = true;
            if (this.amm != null) {
                this.amm.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.amo != null) {
                this.amo.stopAnim();
            }
            if (this.amn != null) {
                this.amn.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amm = bVar;
    }

    public void onDestroy() {
        if (this.amo != null) {
            this.amo.onDestroy();
        }
        if (this.amn != null) {
            this.amn.onDestroy();
        }
    }

    public void aO(boolean z) {
        ue();
        if (this.amo != null) {
            this.amo.setScreen(this.alV, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.amm != null) {
            this.amm.onEnd();
        }
    }

    private void ue() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.alV = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void u(int i, int i2) {
        this.alV = i;
        this.mScreenHeight = i2;
    }
}
