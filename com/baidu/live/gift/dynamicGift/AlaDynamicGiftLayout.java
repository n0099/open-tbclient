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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.b aeZ;
    private boolean aiL;
    private a ajA;
    private int ajf;
    private com.baidu.live.gift.biggift.b ajw;
    private AlaBigGiftExtraInfoRevisionView ajx;
    private AlaDynamicGiftAnimationView ajy;
    public d ajz;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aiL = true;
        this.ajA = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bE(i);
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.bm(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.ajx != null) {
                    AlaDynamicGiftLayout.this.ajx.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aiL = true;
        this.ajA = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bE(i);
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.bm(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.ajx != null) {
                    AlaDynamicGiftLayout.this.ajx.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aiL = true;
        this.ajA = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bE(i2);
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.bm(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.ajx != null) {
                    AlaDynamicGiftLayout.this.ajx.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.ajw != null) {
                    AlaDynamicGiftLayout.this.ajw.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.ajy = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.ajy.setFrameCallback(this.ajA);
        this.ajx = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.ajx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.ru();
            }
        });
        this.aiL = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.b bVar) {
        setData(cVar, bVar, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.b bVar, int i, int i2) {
        if (cVar != null && cVar.adu != null && cVar.adu.adt != null) {
            this.aeZ = bVar;
            if (i > 0 && i2 > 0) {
                p(i, i2);
            } else {
                sC();
            }
            this.ajz = cVar.adu.adt;
            this.mFrameCount = this.ajz.frame_count;
            if (this.ajx != null) {
                if (!bVar.sr()) {
                    this.ajx.setVisibility(8);
                    this.aiL = false;
                } else {
                    this.ajx.setData(bVar);
                    this.aiL = true;
                }
            }
            if (this.ajy != null) {
                this.ajy.setScreen(this.ajf, this.mScreenHeight);
                this.ajy.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru() {
        if (this.aeZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aeZ.userId), this.aeZ.userName, this.aeZ.portrait, this.aeZ.sex, this.aeZ.aiE, this.aeZ.location, this.aeZ.description, 0L, this.aeZ.aiG, this.aeZ.aiF, this.aeZ.userStatus, this.aeZ.liveId, this.aeZ.groupId, this.aeZ.aiJ, this.aeZ.aiK, this.aeZ.appId, this.aeZ.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(int i) {
        if (this.ajx != null && this.aiL) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.ajx.rr();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.ajx.rs();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.ajy != null) {
            this.ajy.startAnim();
            this.isShowing = true;
            if (this.ajw != null) {
                this.ajw.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.ajy != null) {
                this.ajy.stopAnim();
            }
            if (this.ajx != null) {
                this.ajx.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.ajw = bVar;
    }

    public void onDestroy() {
        if (this.ajy != null) {
            this.ajy.onDestroy();
        }
        if (this.ajx != null) {
            this.ajx.onDestroy();
        }
    }

    public void aJ(boolean z) {
        sC();
        if (this.ajy != null) {
            this.ajy.setScreen(this.ajf, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.ajw != null) {
            this.ajw.onEnd();
        }
    }

    private void sC() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.ajf = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void p(int i, int i2) {
        this.ajf = i;
        this.mScreenHeight = i2;
    }
}
