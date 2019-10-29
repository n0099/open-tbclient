package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b abO;
    private boolean abS;
    private AlaSmallGiftView abV;
    private int abW;
    private int abX;
    private d abY;
    private AlaSmallGiftView.a abZ;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.abS = false;
        this.abZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abS = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abO != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abO.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abV.rP();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abS = false;
        this.abZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abS = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abO != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abO.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abV.rP();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abS = false;
        this.abZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abS = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abO != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abO.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abV.rP();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.abV = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.abV.setMode(false);
        this.abV.setSmallAnimCallBack(this.abZ);
        this.abW = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.abX = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.abW, this.abX);
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

    public void setData(d dVar) {
        if (dVar != null) {
            this.abY = dVar;
            this.abY.aaX = -1L;
            this.abV.setTag(this.abY.qF());
            this.abV.setData(this.abY);
        }
    }

    public void startAnim() {
        if (!this.abS && this.abY != null && this.abV != null) {
            this.abS = true;
            this.abV.setVisibility(0);
            this.abV.rO();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.abO != null) {
                this.abO.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.abS && this.abV != null) {
            this.abV.rR();
            this.abS = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.abO = bVar;
    }

    public void at(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.abS = false;
        if (this.abV != null) {
            this.abV.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
