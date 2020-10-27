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
    private com.baidu.live.yuyingift.biggift.b bKY;
    private AlaSmallGiftView bLd;
    private com.baidu.live.yuyingift.a.c bLe;
    private AlaSmallGiftView.a bLf;
    private int baS;
    private int baT;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bLf = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bKY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bKY.m(AlaDynamicGiftSmallGiftStyleView.this.bLe);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bLd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bLd.JD();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bLf = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bKY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bKY.m(AlaDynamicGiftSmallGiftStyleView.this.bLe);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bLd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bLd.JD();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bLf = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Iq() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bKY != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bKY.m(AlaDynamicGiftSmallGiftStyleView.this.bLe);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ir() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bLd != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bLd.JD();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.yuyin_ala_dynamic_small_style_layout, this);
        this.bLd = (AlaSmallGiftView) this.mRootView.findViewById(a.g.alaSmallGift);
        this.bLd.setMode(false);
        this.bLd.setSmallAnimCallBack(this.bLf);
        this.baS = (int) this.mContext.getResources().getDimension(a.e.sdk_ds650);
        this.baT = (int) this.mContext.getResources().getDimension(a.e.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.baS, this.baT);
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

    public void setData(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            this.bLe = cVar;
            this.bLe.aZQ = -1L;
            this.bLd.setTag(this.bLe.Ib());
            this.bLd.setData(this.bLe);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bLe != null && this.bLd != null) {
            this.isShowing = true;
            this.bLd.setVisibility(0);
            this.bLd.JC();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bKY != null) {
                this.bKY.l(this.bLe);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bLd != null) {
            this.bLd.JF();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bKY = bVar;
    }

    public void bN(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.bLd != null) {
            this.bLd.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
