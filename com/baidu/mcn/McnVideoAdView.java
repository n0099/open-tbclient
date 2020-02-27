package com.baidu.mcn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int aLB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int aLC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int aLD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float BF;
    private a aLA;
    private ViewParent aLE;
    private TbImageView aLt;
    private TextView aLu;
    private TextView aLv;
    private Animation aLw;
    private Animation aLx;
    private boolean aLy;
    private com.baidu.mcn.a aLz;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;
    private float mLastX;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.aLy = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aLy = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aLy = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.aLt = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.aLu = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aLv = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.aLt.setConrers(5);
        this.aLt.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLt.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLt.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.aLw = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.aLx = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.aLx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                McnVideoAdView.this.removeView();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void setData(com.baidu.mcn.a aVar) {
        if (aVar != null) {
            this.aLz = aVar;
            this.aLt.startLoad(aVar.aLi, 10, false);
            if (!StringUtils.isNull(aVar.aLj)) {
                this.aLu.setText(aVar.aLj);
            }
            if (!StringUtils.isNull(aVar.aLk)) {
                this.aLv.setText(aVar.aLk);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.BF = motionEvent.getY();
                this.aLE = getParent();
                if (this.aLE != null) {
                    this.aLE.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                DG();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.BF) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.aLy = true;
                    dismiss();
                    if (this.aLA != null) {
                        this.aLA.c(this.aLz);
                        break;
                    }
                }
                break;
            case 3:
                DG();
                break;
        }
        return true;
    }

    private void DG() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aLE != null) {
                    McnVideoAdView.this.aLE.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aLE = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.aLz != null && this.aLz.aLl != null) {
            s.be(this.mContext, this.aLz.aLl);
            if (this.aLA != null) {
                this.aLA.b(this.aLz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeView() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.isShowing = false;
        }
    }

    public void a(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        b(aVar, viewGroup);
        if (this.aLw != null) {
            clearAnimation();
            startAnimation(this.aLw);
        }
    }

    public void dismiss() {
        if (this.aLx != null) {
            clearAnimation();
            startAnimation(this.aLx);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aLy = false;
        this.aLz = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aLB, aLC);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aLD;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aLB, aLC);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aLD);
            setLayoutParams(layoutParams2);
        }
        if (this.aLA != null) {
            this.aLA.a(aVar);
        }
    }

    public void DF() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.aLA = aVar;
    }
}
