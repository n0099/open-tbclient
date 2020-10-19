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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.h;
/* loaded from: classes4.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aUl;
    private int aYW;
    private boolean aYx;
    private com.baidu.live.gift.biggift.b aZn;
    private AlaBigGiftExtraInfoRevisionView aZo;
    private AlaDynamicGiftAnimationView aZp;
    public d aZq;
    private a aZr;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.aYx = true;
        this.aZr = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eu(i);
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.dZ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aZo != null) {
                    AlaDynamicGiftLayout.this.aZo.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.m(AlaDynamicGiftLayout.this.aUl);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aYx = true;
        this.aZr = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.eu(i);
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.dZ(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aZo != null) {
                    AlaDynamicGiftLayout.this.aZo.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.m(AlaDynamicGiftLayout.this.aUl);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aYx = true;
        this.aZr = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.eu(i2);
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.dZ(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.aZo != null) {
                    AlaDynamicGiftLayout.this.aZo.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.aZn != null) {
                    AlaDynamicGiftLayout.this.aZn.m(AlaDynamicGiftLayout.this.aUl);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aZp = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aZp.setFrameCallback(this.aZr);
        this.aZo = (AlaBigGiftExtraInfoRevisionView) findViewById(a.g.ala_big_gift_extra_view);
        this.aZo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.GE();
            }
        });
        this.aYx = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aRQ != null && cVar.aRQ.aRP != null) {
            this.aUl = cVar2;
            if (i > 0 && i2 > 0) {
                y(i, i2);
            } else {
                HU();
            }
            this.aZq = cVar.aRQ.aRP;
            this.mFrameCount = this.aZq.frame_count;
            if (this.aZo != null) {
                if (!cVar2.HI()) {
                    this.aZo.setVisibility(8);
                    this.aYx = false;
                } else {
                    this.aZo.setData(cVar2);
                    HT();
                    this.aYx = true;
                }
            }
            if (this.aZp != null) {
                this.aZp.setScreen(this.aYW, this.mScreenHeight);
                this.aZp.setData(cVar);
            }
        }
    }

    private void HT() {
        int dimensionPixelOffset;
        int aD;
        ViewGroup.LayoutParams layoutParams = this.aZo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                if (this.isHost) {
                    aD = h.aC(getContext());
                } else {
                    aD = h.aD(getContext());
                }
                dimensionPixelOffset = aD + getResources().getDimensionPixelOffset(a.e.sdk_ds72);
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds180);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.aZo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        if (this.aUl != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aUl.userId), this.aUl.userName, this.aUl.portrait, this.aUl.sex, this.aUl.aYq, this.aUl.location, this.aUl.description, 0L, this.aUl.fansCount, this.aUl.aYr, this.aUl.userStatus, this.aUl.liveId, this.aUl.groupId, this.aUl.aYv, this.aUl.aYw, this.aUl.appId, this.aUl.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(int i) {
        if (this.aZo != null && this.aYx) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.aZo.GB();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.aZo.GC();
            }
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aZp != null) {
            this.aZp.startAnim();
            this.isShowing = true;
            if (this.aZn != null) {
                this.aZn.l(this.aUl);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.aZp != null) {
                this.aZp.stopAnim();
            }
            if (this.aZo != null) {
                this.aZo.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aZn = bVar;
    }

    public void onDestroy() {
        if (this.aZp != null) {
            this.aZp.onDestroy();
        }
        if (this.aZo != null) {
            this.aZo.onDestroy();
        }
    }

    public void bL(boolean z) {
        HU();
        if (this.aZp != null) {
            this.aZp.setScreen(this.aYW, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.aZn != null) {
            this.aZn.m(this.aUl);
        }
    }

    private void HU() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.aYW = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void y(int i, int i2) {
        this.aYW = i;
        this.mScreenHeight = i2;
    }
}
