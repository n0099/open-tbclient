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
    private com.baidu.live.gift.biggift.b aWc;
    private AlaSmallGiftView aWi;
    private int aWj;
    private int aWk;
    private int aWl;
    private com.baidu.live.gift.a.c aWm;
    private AlaSmallGiftView.a aWn;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aWn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aWc != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWc.m(AlaDynamicGiftSmallGiftStyleView.this.aWm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ha() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aWi != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWi.In();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aWn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aWc != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWc.m(AlaDynamicGiftSmallGiftStyleView.this.aWm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ha() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aWi != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWi.In();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aWn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void GZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aWc != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWc.m(AlaDynamicGiftSmallGiftStyleView.this.aWm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ha() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aWi != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aWi.In();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aWi = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aWi.setMode(false);
        this.aWi.setSmallAnimCallBack(this.aWn);
        Resources resources = this.mContext.getResources();
        this.aWj = (int) resources.getDimension(a.e.sdk_ds650);
        this.aWk = resources.getDimensionPixelOffset(a.e.sdk_ds12) + (resources.getDimensionPixelOffset(a.e.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.e.sdk_ds46);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.aWj, this.aWk);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.e.sdk_ds160);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.aWk);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(10);
            } else {
                layoutParams.addRule(10, 0);
            }
            layoutParams.topMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.aWl;
        }
        if (layoutParams != null) {
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void eq(int i) {
        this.aWl = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.aWl;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.aWm = cVar;
            this.aWm.aVj = -1L;
            this.aWi.setTag(this.aWm.GK());
            this.aWi.setData(this.aWm);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aWm != null && this.aWi != null) {
            this.isShowing = true;
            this.aWi.setVisibility(0);
            this.aWi.Im();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aWc != null) {
                this.aWc.l(this.aWm);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aWi != null) {
            this.aWi.Ip();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aWc = bVar;
    }

    public void bH(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aWi != null) {
            this.aWi.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
