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
    private com.baidu.live.gift.biggift.b bcd;
    private AlaSmallGiftView bcj;
    private int bck;
    private int bcl;
    private int bcm;
    private com.baidu.live.gift.a.c bcn;
    private AlaSmallGiftView.a bco;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bco = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bcd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcd.m(AlaDynamicGiftSmallGiftStyleView.this.bcn);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bcj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcj.Kd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bco = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bcd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcd.m(AlaDynamicGiftSmallGiftStyleView.this.bcn);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bcj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcj.Kd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bco = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bcd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcd.m(AlaDynamicGiftSmallGiftStyleView.this.bcn);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bcj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bcj.Kd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.ala_dynamic_small_style_layout, this);
        this.bcj = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift);
        this.bcj.setMode(false);
        this.bcj.setSmallAnimCallBack(this.bco);
        Resources resources = this.mContext.getResources();
        this.bck = (int) resources.getDimension(a.d.sdk_ds650);
        this.bcl = resources.getDimensionPixelOffset(a.d.sdk_ds12) + (resources.getDimensionPixelOffset(a.d.sdk_ds136) * 2) + resources.getDimensionPixelOffset(a.d.sdk_ds46);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 2) {
            layoutParams = new RelativeLayout.LayoutParams(this.bck, this.bcl);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            } else {
                layoutParams.addRule(12, 0);
            }
            layoutParams.bottomMargin = 0;
            layoutParams.addRule(10);
            layoutParams.topMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds160);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.bcl);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(10);
            } else {
                layoutParams.addRule(10, 0);
            }
            layoutParams.topMargin = 0;
            layoutParams.addRule(12);
            layoutParams.bottomMargin = this.bcm;
        }
        if (layoutParams != null) {
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void ew(int i) {
        this.bcm = i;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bcm;
            this.mRootView.setLayoutParams(layoutParams);
        }
    }

    public void setData(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            this.bcn = cVar;
            this.bcn.bbj = -1L;
            this.bcj.setTag(this.bcn.IC());
            this.bcj.setData(this.bcn);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bcn != null && this.bcj != null) {
            this.isShowing = true;
            this.bcj.setVisibility(0);
            this.bcj.Kc();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bcd != null) {
                this.bcd.l(this.bcn);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bcj != null) {
            this.bcj.Kf();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.bcd = bVar;
    }

    public void bO(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.bcj != null) {
            this.bcj.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
