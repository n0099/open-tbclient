package com.baidu.live.yuyingift.dynamicgift;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.yuyingift.smallgift.AlaSmallGiftView;
/* loaded from: classes4.dex */
public class AlaDynamicGiftSmallGiftStyleView extends FrameLayout implements com.baidu.live.yuyingift.biggift.c {
    private com.baidu.live.yuyingift.biggift.b bOW;
    private AlaSmallGiftView bPb;
    private com.baidu.live.yuyingift.a.c bPc;
    private AlaSmallGiftView.a bPd;
    private int baA;
    private int baz;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bPd = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ii() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bOW != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bOW.m(AlaDynamicGiftSmallGiftStyleView.this.bPc);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ij() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bPb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bPb.Ju();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bPd = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ii() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bOW != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bOW.m(AlaDynamicGiftSmallGiftStyleView.this.bPc);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ij() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bPb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bPb.Ju();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bPd = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ii() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bOW != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bOW.m(AlaDynamicGiftSmallGiftStyleView.this.bPc);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ij() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bPb != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bPb.Ju();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.yuyin_ala_dynamic_small_style_layout, this);
        this.bPb = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift);
        this.bPb.setMode(false);
        this.bPb.setSmallAnimCallBack(this.bPd);
        this.baz = (int) this.mContext.getResources().getDimension(a.d.sdk_ds650);
        this.baA = (int) this.mContext.getResources().getDimension(a.d.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.baz, this.baA);
            layoutParams.bottomMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds240);
            layoutParams.addRule(12);
            this.mRootView.setLayoutParams(layoutParams);
        } else if (i == 1) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(a.d.sdk_ds356));
            layoutParams2.bottomMargin = (int) this.mContext.getResources().getDimension(a.d.sdk_ds420);
            layoutParams2.addRule(12);
            this.mRootView.setLayoutParams(layoutParams2);
        }
    }

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bPc = cVar;
            this.bPc.aZx = -1L;
            this.bPb.setTag(this.bPc.HT());
            this.bPb.setData(this.bPc);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bPc != null && this.bPb != null) {
            this.isShowing = true;
            this.bPb.setVisibility(0);
            this.bPb.Jt();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bOW != null) {
                this.bOW.l(this.bPc);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bPb != null) {
            this.bPb.Jw();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bOW = bVar;
    }

    public void bQ(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.bPb != null) {
            this.bPb.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
