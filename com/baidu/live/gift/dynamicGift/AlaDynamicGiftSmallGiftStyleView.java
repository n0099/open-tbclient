package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b akg;
    private AlaSmallGiftView akm;
    private int akn;
    private int ako;
    private com.baidu.live.gift.a.c akp;
    private AlaSmallGiftView.a akq;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.akq = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.akg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akg.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.akm != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akm.tX();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.akq = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.akg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akg.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.akm != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akm.tX();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.akq = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sT() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.akg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akg.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void sU() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.akm != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.akm.tX();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.akm = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.akm.setMode(false);
        this.akm.setSmallAnimCallBack(this.akq);
        this.akn = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.ako = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.akn, this.ako);
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
            this.akp = cVar;
            this.akp.ajt = -1L;
            this.akm.setTag(this.akp.sF());
            this.akm.setData(this.akp);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.akp != null && this.akm != null) {
            this.isShowing = true;
            this.akm.setVisibility(0);
            this.akm.tW();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.akg != null) {
                this.akg.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.akm != null) {
            this.akm.tZ();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.akg = bVar;
    }

    public void aL(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.akm != null) {
            this.akm.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
