package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.gift.smallgift.AlaSmallGiftView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.gift.biggift.c {
    private com.baidu.live.gift.biggift.b aNd;
    private AlaSmallGiftView aNj;
    private int aNk;
    private int aNl;
    private com.baidu.live.gift.a.c aNm;
    private AlaSmallGiftView.a aNn;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.aNn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void At() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aNd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNd.m(AlaDynamicGiftSmallGiftStyleView.this.aNm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Au() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aNj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNj.BG();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aNn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void At() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aNd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNd.m(AlaDynamicGiftSmallGiftStyleView.this.aNm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Au() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aNj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNj.BG();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aNn = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void At() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void O(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.aNd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNd.m(AlaDynamicGiftSmallGiftStyleView.this.aNm);
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void Au() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.aNj != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.aNj.BG();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.aNj = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.aNj.setMode(false);
        this.aNj.setSmallAnimCallBack(this.aNn);
        this.aNk = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.aNl = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aNk, this.aNl);
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
            this.aNm = cVar;
            this.aNm.aMn = -1L;
            this.aNj.setTag(this.aNm.Af());
            this.aNj.setData(this.aNm);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.aNm != null && this.aNj != null) {
            this.isShowing = true;
            this.aNj.setVisibility(0);
            this.aNj.BF();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.aNd != null) {
                this.aNd.l(this.aNm);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.aNj != null) {
            this.aNj.BI();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.aNd = bVar;
    }

    public void by(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.aNj != null) {
            this.aNj.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
