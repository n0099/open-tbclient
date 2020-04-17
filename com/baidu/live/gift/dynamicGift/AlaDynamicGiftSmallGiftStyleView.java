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
    private com.baidu.live.gift.biggift.b aEP;
    private AlaSmallGiftView aEV;
    private int aEW;
    private int aEX;
    private com.baidu.live.gift.a.c aEY;
    private AlaSmallGiftView.a aEZ;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aEZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEP != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEP.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yF() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.zR();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aEZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEP != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEP.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yF() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.zR();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aEZ = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yE() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void P(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aEP != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEP.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void yF() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aEV != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aEV.zR();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aEV = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aEV.setMode(false);
        this.aEV.setSmallAnimCallBack(this.aEZ);
        this.aEW = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.aEX = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aEW, this.aEX);
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
            this.aEY = cVar;
            this.aEY.aEc = -1L;
            this.aEV.setTag(this.aEY.yq());
            this.aEV.setData(this.aEY);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aEY != null && this.aEV != null) {
            this.isShowing = true;
            this.aEV.setVisibility(0);
            this.aEV.zQ();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aEP != null) {
                this.aEP.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aEV != null) {
            this.aEV.zT();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aEP = bVar;
    }

    public void bq(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aEV != null) {
            this.aEV.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
