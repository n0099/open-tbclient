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
    private com.baidu.live.yuyingift.biggift.b bUg;
    private AlaSmallGiftView bUl;
    private com.baidu.live.yuyingift.a.c bUm;
    private AlaSmallGiftView.a bUn;
    private int bdZ;
    private int bea;
    private boolean isShowing;
    private Context mContext;
    private Handler mHandler;
    private View mRootView;
    private Runnable mRunnable;

    public AlaDynamicGiftSmallGiftStyleView(Context context) {
        super(context);
        this.isShowing = false;
        this.bUn = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bUg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUg.m(AlaDynamicGiftSmallGiftStyleView.this.bUm);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bUl != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUl.Lv();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bUn = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bUg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUg.m(AlaDynamicGiftSmallGiftStyleView.this.bUm);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bUl != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUl.Lv();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftSmallGiftStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bUn = new AlaSmallGiftView.a() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.1
            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void JZ() {
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void T(View view) {
                view.setVisibility(4);
                view.clearAnimation();
                AlaDynamicGiftSmallGiftStyleView.this.isShowing = false;
                if (AlaDynamicGiftSmallGiftStyleView.this.bUg != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUg.m(AlaDynamicGiftSmallGiftStyleView.this.bUm);
                }
            }

            @Override // com.baidu.live.yuyingift.smallgift.AlaSmallGiftView.a
            public void Ka() {
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (AlaDynamicGiftSmallGiftStyleView.this.bUl != null) {
                    AlaDynamicGiftSmallGiftStyleView.this.bUl.Lv();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.yuyin_ala_dynamic_small_style_layout, this);
        this.bUl = (AlaSmallGiftView) this.mRootView.findViewById(a.f.alaSmallGift);
        this.bUl.setMode(false);
        this.bUl.setSmallAnimCallBack(this.bUn);
        this.bdZ = (int) this.mContext.getResources().getDimension(a.d.sdk_ds650);
        this.bea = (int) this.mContext.getResources().getDimension(a.d.sdk_ds356);
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? 2 : 1);
        this.mHandler = new Handler();
    }

    private void setRootViewParam(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bdZ, this.bea);
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
            this.bUm = cVar;
            this.bUm.bcV = -1L;
            this.bUl.setTag(this.bUm.JK());
            this.bUl.setData(this.bUm);
        }
    }

    public void startAnim() {
        if (!this.isShowing && this.bUm != null && this.bUl != null) {
            this.isShowing = true;
            this.bUl.setVisibility(0);
            this.bUl.Lu();
            this.mHandler.postDelayed(this.mRunnable, 3500L);
            if (this.bUg != null) {
                this.bUg.l(this.bUm);
            }
        }
    }

    public void stopAnim() {
        if (this.isShowing && this.bUl != null) {
            this.bUl.Lx();
            this.isShowing = false;
        }
    }

    public void setBigGiftCallBack(com.baidu.live.yuyingift.biggift.b bVar) {
        this.bUg = bVar;
    }

    public void bZ(boolean z) {
        setRootViewParam(UtilHelper.getRealScreenOrientation(this.mContext));
    }

    public void onDestroy() {
        this.isShowing = false;
        if (this.bUl != null) {
            this.bUl.onDestroy();
        }
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
