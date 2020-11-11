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
    private com.baidu.live.yuyingift.biggift.b bQG;
    private AlaSmallGiftView bQL;
    private com.baidu.live.yuyingift.a.c bQM;
    private AlaSmallGiftView.a bQN;
    private int bck;
    private int bcl;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bQN = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bQG != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQG.m(AlaDynamicGiftSmallGiftStyleView.this.bQM);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bQL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQL.Kd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bQN = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bQG != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQG.m(AlaDynamicGiftSmallGiftStyleView.this.bQM);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bQL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQL.Kd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bQN = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IR() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bQG != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQG.m(AlaDynamicGiftSmallGiftStyleView.this.bQM);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void IS() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bQL != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bQL.Kd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.yuyin_ala_dynamic_small_style_layout, this);
        this.bQL = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift);
        this.bQL.setMode(false);
        this.bQL.setSmallAnimCallBack(this.bQN);
        this.bck = (int) this.mContext.getResources().getDimension(a.d.sdk_ds650);
        this.bcl = (int) this.mContext.getResources().getDimension(a.d.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bck, this.bcl);
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
            this.bQM = cVar;
            this.bQM.bbj = -1L;
            this.bQL.setTag(this.bQM.IC());
            this.bQL.setData(this.bQM);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bQM != null && this.bQL != null) {
            this.isShowing = true;
            this.bQL.setVisibility(0);
            this.bQL.Kc();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bQG != null) {
                this.bQG.l(this.bQM);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bQL != null) {
            this.bQL.Kf();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bQG = bVar;
    }

    public void bO(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.bQL != null) {
            this.bQL.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
