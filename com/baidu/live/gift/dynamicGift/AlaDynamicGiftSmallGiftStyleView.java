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
/* loaded from: classes4.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b baL;
    private AlaSmallGiftView baR;
    private int baS;
    private int baT;
    private int baU;
    private com.baidu.live.gift.a.c baV;
    private AlaSmallGiftView.a baW;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.baW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.baL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baL.m(AlaDynamicGiftSmallGiftStyleView.this.baV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.baR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baR.JD();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.baW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.baL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baL.m(AlaDynamicGiftSmallGiftStyleView.this.baV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.baR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baR.JD();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.baW = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.baL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baL.m(AlaDynamicGiftSmallGiftStyleView.this.baV);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.baR != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.baR.JD();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.baR = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.baR.setMode(false);
        this.baR.setSmallAnimCallBack(this.baW);
        Resources resources = this.mContext.getResources();
        this.baS = (int) resources.getDimension(a.e.sdk_ds650);
        this.baT = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.baS, this.baT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.baT);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(10);
            } else {
                layoutParams.addRule(10, 0);
            }
            layoutParams.topMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.baU;
        }
        if (layoutParams != null) {
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void ew(int i) {
        this.baU = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.baU;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.baV = cVar;
            this.baV.aZQ = -1L;
            this.baR.setTag(this.baV.Ib());
            this.baR.setData(this.baV);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.baV != null && this.baR != null) {
            this.isShowing = true;
            this.baR.setVisibility(0);
            this.baR.JC();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.baL != null) {
                this.baL.l(this.baV);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.baR != null) {
            this.baR.JF();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.baL = bVar;
    }

    public void bN(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.baR != null) {
            this.baR.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
