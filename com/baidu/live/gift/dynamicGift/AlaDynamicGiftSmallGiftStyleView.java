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
    private com.baidu.live.gift.biggift.b aEV;
    private AlaSmallGiftView aFb;
    private int aFc;
    private int aFd;
    private com.baidu.live.gift.a.c aFe;
    private AlaSmallGiftView.a aFf;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aFf = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yD() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aFb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aFb.zQ();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aFf = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yD() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aFb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aFb.zQ();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aFf = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yD() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aFb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aFb.zQ();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aFb = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aFb.setMode(false);
        this.aFb.setSmallAnimCallBack(this.aFf);
        this.aFc = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.aFd = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aFc, this.aFd);
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
            this.aFe = cVar;
            this.aFe.aEi = -1L;
            this.aFb.setTag(this.aFe.yp());
            this.aFb.setData(this.aFe);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aFe != null && this.aFb != null) {
            this.isShowing = true;
            this.aFb.setVisibility(0);
            this.aFb.zP();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aEV != null) {
                this.aEV.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aFb != null) {
            this.aFb.zS();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEV = bVar;
    }

    public void bq(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aFb != null) {
            this.aFb.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
