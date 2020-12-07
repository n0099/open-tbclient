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
    private com.baidu.live.gift.biggift.b bdS;
    private AlaSmallGiftView bdY;
    private int bdZ;
    private int bea;
    private int beb;
    private com.baidu.live.gift.a.c bec;
    private AlaSmallGiftView.a bed;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bed = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bdS != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdS.m(AlaDynamicGiftSmallGiftStyleView.this.bec);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bdY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdY.Lv();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bed = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bdS != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdS.m(AlaDynamicGiftSmallGiftStyleView.this.bec);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bdY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdY.Lv();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bed = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bdS != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdS.m(AlaDynamicGiftSmallGiftStyleView.this.bec);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bdY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bdY.Lv();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.ala_dynamic_small_style_layout, this);
        this.bdY = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift);
        this.bdY.setMode(false);
        this.bdY.setSmallAnimCallBack(this.bed);
        Resources resources = this.mContext.getResources();
        this.bdZ = (int) resources.getDimension(a.d.sdk_ds650);
        this.bea = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.bdZ, this.bea);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds160);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.bea);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(10);
            } else {
                layoutParams.addRule(10, 0);
            }
            layoutParams.topMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.beb;
        }
        if (layoutParams != null) {
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void eN(int i) {
        this.beb = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.beb;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.bec = cVar;
            this.bec.bcV = -1L;
            this.bdY.setTag(this.bec.JK());
            this.bdY.setData(this.bec);
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void startAnim() {
        if (!this.isShowing && this.bec != null && this.bdY != null) {
            this.isShowing = true;
            this.bdY.setVisibility(0);
            this.bdY.Lu();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bdS != null) {
                this.bdS.l(this.bec);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bdY != null) {
            this.bdY.Lx();
            this.isShowing = false;
        }
    }

    @Override // com.baidu.live.gift.biggift.c
    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bdS = bVar;
    }

    public void bZ(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    @Override // com.baidu.live.gift.biggift.c
    public void onDestroy() {
        this.isShowing = false;
        if (this.bdY != null) {
            this.bdY.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
