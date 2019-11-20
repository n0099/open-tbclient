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
    private boolean abA;
    private AlaSmallGiftView abD;
    private int abE;
    private int abF;
    private d abG;
    private AlaSmallGiftView.a abH;
    private com.baidu.live.gift.biggift.b abw;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.abA = false;
        this.abH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abA = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abw != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abw.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qV() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abD.rQ();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abA = false;
        this.abH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abA = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abw != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abw.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qV() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abD.rQ();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abA = false;
        this.abH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qU() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void K(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.abA = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.abw != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abw.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void qV() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.abD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.abD.rQ();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.abD = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.abD.setMode(false);
        this.abD.setSmallAnimCallBack(this.abH);
        this.abE = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.abF = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.abE, this.abF);
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
            this.abG = dVar;
            this.abG.aaF = -1L;
            this.abD.setTag(this.abG.qG());
            this.abD.setData(this.abG);
        }
    }

    public void startAnim() {
        if (!this.abA && this.abG != null && this.abD != null) {
            this.abA = true;
            this.abD.setVisibility(0);
            this.abD.rP();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.abw != null) {
                this.abw.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.abA && this.abD != null) {
            this.abD.rS();
            this.abA = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.abw = bVar;
    }

    public void at(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.abA = false;
        if (this.abD != null) {
            this.abD.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
