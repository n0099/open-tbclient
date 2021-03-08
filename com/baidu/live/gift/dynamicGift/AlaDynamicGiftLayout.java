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
/* loaded from: classes10.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.a.c aZZ;
    private boolean beA;
    private AlaDynamicGiftAnimationView bfA;
    public d bfB;
    private a bfC;
    private int bfg;
    private com.baidu.live.gift.biggift.b bfy;
    private AlaBigGiftExtraInfoRevisionView bfz;
    private boolean isHost;
    private boolean isShowing;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.isShowing = false;
        this.beA = true;
        this.bfC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dk(i);
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.cO(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bfz != null) {
                    AlaDynamicGiftLayout.this.bfz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.n(AlaDynamicGiftLayout.this.aZZ);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.beA = true;
        this.bfC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.dk(i);
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.cO(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bfz != null) {
                    AlaDynamicGiftLayout.this.bfz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.n(AlaDynamicGiftLayout.this.aZZ);
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.beA = true;
        this.bfC = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.dk(i2);
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.cO(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.bfz != null) {
                    AlaDynamicGiftLayout.this.bfz.end();
                }
                AlaDynamicGiftLayout.this.isShowing = false;
                if (AlaDynamicGiftLayout.this.bfy != null) {
                    AlaDynamicGiftLayout.this.bfy.n(AlaDynamicGiftLayout.this.aZZ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.g.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.bfA = (AlaDynamicGiftAnimationView) findViewById(a.f.ala_dynamic_gift_animation_view);
        this.bfA.setFrameCallback(this.bfC);
        this.bfz = (AlaBigGiftExtraInfoRevisionView) findViewById(a.f.ala_big_gift_extra_view);
        this.bfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.FJ();
            }
        });
        this.beA = true;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        setData(cVar, cVar2, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2, int i, int i2) {
        if (cVar != null && cVar.aWS != null && cVar.aWS.aWQ != null) {
            this.aZZ = cVar2;
            if (i > 0 && i2 > 0) {
                B(i, i2);
            } else {
                GY();
            }
            this.bfB = cVar.aWS.aWQ;
            this.mFrameCount = this.bfB.frame_count;
            if (this.bfz != null) {
                if (!cVar2.GM()) {
                    this.bfz.setVisibility(8);
                    this.beA = false;
                } else {
                    this.bfz.setData(cVar2);
                    GX();
                    this.beA = true;
                }
            }
            if (this.bfA != null) {
                this.bfA.setScreen(this.bfg, this.mScreenHeight);
                this.bfA.setData(cVar);
            }
        }
    }

    private void GX() {
        int dimensionPixelOffset;
        int bm;
        ViewGroup.LayoutParams layoutParams = this.bfz.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
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
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
            this.bfz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.aZZ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.aZZ.userId), this.aZZ.userName, this.aZZ.portrait, this.aZZ.sex, this.aZZ.ber, this.aZZ.location, this.aZZ.description, 0L, this.aZZ.fansCount, this.aZZ.followCount, this.aZZ.userStatus, this.aZZ.liveId, this.aZZ.groupId, this.aZZ.bey, this.aZZ.bez, this.aZZ.appId, this.aZZ.userName)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i) {
        if (this.bfz != null && this.beA) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.bfz.FG();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.bfz.FH();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        if (!this.isShowing && this.bfA != null) {
            this.bfA.startAnim();
            this.isShowing = true;
            if (this.bfy != null) {
                this.bfy.m(this.aZZ);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing) {
            if (this.bfA != null) {
                this.bfA.stopAnim();
            }
            if (this.bfz != null) {
                this.bfz.end();
            }
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bfy = bVar;
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        if (this.bfA != null) {
            this.bfA.onDestroy();
        }
        if (this.bfz != null) {
            this.bfz.onDestroy();
        }
    }

    public void bY(boolean z) {
        GY();
        if (this.bfA != null) {
            this.bfA.setScreen(this.bfg, this.mScreenHeight);
        }
        this.isShowing = false;
        stopAnim();
        if (this.bfy != null) {
            this.bfy.n(this.aZZ);
        }
    }

    private void GY() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.bfg = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void B(int i, int i2) {
        this.bfg = i;
        this.mScreenHeight = i2;
    }
}
