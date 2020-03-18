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
    private AlaSmallGiftView amD;
    private int amE;
    private int amF;
    private com.baidu.live.gift.a.c amG;
    private AlaSmallGiftView.a amH;
    private com.baidu.live.gift.biggift.b amx;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.amH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void uk() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.amx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amx.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void ul() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.amD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amD.vt();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.amH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void uk() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.amx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amx.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void ul() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.amD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amD.vt();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.amH = new AlaSmallGiftView.a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void uk() {
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void N(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.amx != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amx.onEnd();
                }
            }

            @Override // com.baidu.live.gift.smallgift.AlaSmallGiftView.a
            public void ul() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.amD != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.amD.vt();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_dynamic_small_style_layout, this);
        this.amD = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.amD.setMode(false);
        this.amD.setSmallAnimCallBack(this.amH);
        this.amE = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.amF = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.amE, this.amF);
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
            this.amG = cVar;
            this.amG.alM = -1L;
            this.amD.setTag(this.amG.tW());
            this.amD.setData(this.amG);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.amG != null && this.amD != null) {
            this.isShowing = true;
            this.amD.setVisibility(0);
            this.amD.vs();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.amx != null) {
                this.amx.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.amD != null) {
            this.amD.vv();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.amx = bVar;
    }

    public void aO(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.amD != null) {
            this.amD.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
