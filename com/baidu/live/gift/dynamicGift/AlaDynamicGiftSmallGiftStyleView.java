package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b aTL;
    private AlaSmallGiftView aTR;
    private int aTS;
    private int aTT;
    private int aTU;
    private com.baidu.live.gift.a.c aTV;
    private AlaSmallGiftView.a aTW;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aTW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Gz() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aTL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTL.m(AlaDynamicGiftSmallGiftStyleView.this.aTV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GA() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aTR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTR.HL();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aTW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Gz() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aTL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTL.m(AlaDynamicGiftSmallGiftStyleView.this.aTV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GA() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aTR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTR.HL();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aTW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Gz() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void R(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aTL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTL.m(AlaDynamicGiftSmallGiftStyleView.this.aTV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GA() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aTR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aTR.HL();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aTR = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aTR.setMode(false);
        this.aTR.setSmallAnimCallBack(this.aTW);
        Resources resources = this.mContext.getResources();
        this.aTS = (int) resources.getDimension(a.e.sdk_ds650);
        this.aTT = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.aTS, this.aTT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.aTT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(10);
            } else {
                layoutParams.addRule(10, 0);
            }
            layoutParams.topMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.aTU;
        }
        if (layoutParams != null) {
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void em(int i) {
        this.aTU = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aTU;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aTV = cVar;
            this.aTV.aSV = -1L;
            this.aTR.setTag(this.aTV.Gk());
            this.aTR.setData(this.aTV);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aTV != null && this.aTR != null) {
            this.isShowing = true;
            this.aTR.setVisibility(0);
            this.aTR.HK();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aTL != null) {
                this.aTL.l(this.aTV);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aTR != null) {
            this.aTR.HN();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aTL = bVar;
    }

    public void bG(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aTR != null) {
            this.aTR.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
