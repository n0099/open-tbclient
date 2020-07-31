package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private AlaSmallGiftView aOE;
    private int aOF;
    private int aOG;
    private com.baidu.live.gift.a.c aOH;
    private AlaSmallGiftView.a aOI;
    private com.baidu.live.gift.biggift.b aOy;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aOI = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AV() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aOy != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOy.m(AlaDynamicGiftSmallGiftStyleView.this.aOH);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AW() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aOE != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOE.Ci();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aOI = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AV() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aOy != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOy.m(AlaDynamicGiftSmallGiftStyleView.this.aOH);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AW() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aOE != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOE.Ci();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aOI = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AV() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aOy != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOy.m(AlaDynamicGiftSmallGiftStyleView.this.aOH);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void AW() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aOE != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aOE.Ci();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aOE = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aOE.setMode(false);
        this.aOE.setSmallAnimCallBack(this.aOI);
        this.aOF = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.aOG = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aOF, this.aOG);
            layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds240);
            layoutParams.addRule(12);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(a.e.sdk_ds356));
            layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds420);
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aOH = cVar;
            this.aOH.aNI = -1L;
            this.aOE.setTag(this.aOH.AH());
            this.aOE.setData(this.aOH);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aOH != null && this.aOE != null) {
            this.isShowing = true;
            this.aOE.setVisibility(0);
            this.aOE.Ch();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aOy != null) {
                this.aOy.l(this.aOH);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aOE != null) {
            this.aOE.Ck();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aOy = bVar;
    }

    public void bB(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aOE != null) {
            this.aOE.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
