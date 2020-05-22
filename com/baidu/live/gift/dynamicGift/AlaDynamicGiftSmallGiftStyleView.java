package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private AlaSmallGiftView aKD;
    private int aKE;
    private int aKF;
    private com.baidu.live.gift.a.c aKG;
    private AlaSmallGiftView.a aKH;
    private com.baidu.live.gift.biggift.b aKx;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aKH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aKx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKx.m(AlaDynamicGiftSmallGiftStyleView.this.aKG);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aKD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKD.Bg();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aKH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aKx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKx.m(AlaDynamicGiftSmallGiftStyleView.this.aKG);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aKD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKD.Bg();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aKH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aKx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKx.m(AlaDynamicGiftSmallGiftStyleView.this.aKG);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void zU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aKD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aKD.Bg();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aKD = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aKD.setMode(false);
        this.aKD.setSmallAnimCallBack(this.aKH);
        this.aKE = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.aKF = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aKE, this.aKF);
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
            this.aKG = cVar;
            this.aKG.aJH = -1L;
            this.aKD.setTag(this.aKG.zF());
            this.aKD.setData(this.aKG);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aKG != null && this.aKD != null) {
            this.isShowing = true;
            this.aKD.setVisibility(0);
            this.aKD.Bf();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aKx != null) {
                this.aKx.l(this.aKG);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aKD != null) {
            this.aKD.Bi();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aKx = bVar;
    }

    public void by(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aKD != null) {
            this.aKD.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
