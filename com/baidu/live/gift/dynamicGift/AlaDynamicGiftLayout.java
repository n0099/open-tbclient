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
    private com.baidu.live.gift.a.c aia;
    private boolean alP;
    public d amA;
    private a amB;
    private int amg;
    private com.baidu.live.gift.biggift.b amx;
    private AlaBigGiftExtraInfoRevisionView amy;
    private AlaDynamicGiftAnimationView amz;
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
        this.alP = true;
        this.amB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bL(i);
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.bt(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amy != null) {
                    AlaDynamicGiftLayout.this.amy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.alP = true;
        this.amB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bL(i);
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.bt(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amy != null) {
                    AlaDynamicGiftLayout.this.amy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.alP = true;
        this.amB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bL(i2);
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.bt(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.amy != null) {
                    AlaDynamicGiftLayout.this.amy.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.amx != null) {
                    AlaDynamicGiftLayout.this.amx.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.amz = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.amz.setFrameCallback(this.amB);
        this.amy = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.amy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.sX();
            }
        });
        this.alP = true;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.afV != null && cVar.afV.afU != null) {
            this.aia = cVar2;
            if (i > 0 && i2 > 0) {
                u(i, i2);
            } else {
                uj();
            }
            this.amA = cVar.afV.afU;
            this.mFrameCount = this.amA.frame_count;
            if (this.amy != null) {
                if (!cVar2.tY()) {
                    this.amy.setVisibility(8);
                    this.alP = false;
                } else {
                    this.amy.setData(cVar2);
                    this.alP = true;
                }
            }
            if (this.amz != null) {
                this.amz.setScreen(this.amg, this.mScreenHeight);
                this.amz.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sX() {
        if (this.aia != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aia.userId), this.aia.userName, this.aia.portrait, this.aia.sex, this.aia.alJ, this.aia.location, this.aia.description, 0L, this.aia.fansCount, this.aia.alK, this.aia.userStatus, this.aia.liveId, this.aia.groupId, this.aia.alN, this.aia.alO, this.aia.appId, this.aia.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(int i) {
        if (this.amy != null && this.alP) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.amy.sU();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.amy.sV();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.amz != null) {
            this.amz.startAnim();
            this.isShowing = true;
            if (this.amx != null) {
                this.amx.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.amz != null) {
                this.amz.stopAnim();
            }
            if (this.amy != null) {
                this.amy.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amx = bVar;
    }

    public void onDestroy() {
        if (this.amz != null) {
            this.amz.onDestroy();
        }
        if (this.amy != null) {
            this.amy.onDestroy();
        }
    }

    public void aO(boolean z) {
        uj();
        if (this.amz != null) {
            this.amz.setScreen(this.amg, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.amx != null) {
            this.amx.onEnd();
        }
    }

    private void uj() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.amg = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void u(int i, int i2) {
        this.amg = i;
        this.mScreenHeight = i2;
    }
}
