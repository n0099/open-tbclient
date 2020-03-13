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
    private static final int aLD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int aLE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int aLF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float BF;
    private boolean aLA;
    private com.baidu.mcn.a aLB;
    private a aLC;
    private ViewParent aLG;
    private TbImageView aLv;
    private TextView aLw;
    private TextView aLx;
    private Animation aLy;
    private Animation aLz;
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
        this.aLA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aLA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aLA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.aLv = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.aLw = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aLx = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.aLv.setConrers(5);
        this.aLv.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLv.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLv.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.aLy = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.aLz = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.aLz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.aLB = aVar;
            this.aLv.startLoad(aVar.aLk, 10, false);
            if (!StringUtils.isNull(aVar.aLl)) {
                this.aLw.setText(aVar.aLl);
            }
            if (!StringUtils.isNull(aVar.aLm)) {
                this.aLx.setText(aVar.aLm);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.BF = motionEvent.getY();
                this.aLG = getParent();
                if (this.aLG != null) {
                    this.aLG.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                DI();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.BF) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.aLA = true;
                    dismiss();
                    if (this.aLC != null) {
                        this.aLC.c(this.aLB);
                        break;
                    }
                }
                break;
            case 3:
                DI();
                break;
        }
        return true;
    }

    private void DI() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aLG != null) {
                    McnVideoAdView.this.aLG.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aLG = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.aLB != null && this.aLB.aLn != null) {
            s.be(this.mContext, this.aLB.aLn);
            if (this.aLC != null) {
                this.aLC.b(this.aLB);
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
        if (this.aLy != null) {
            clearAnimation();
            startAnimation(this.aLy);
        }
    }

    public void dismiss() {
        if (this.aLz != null) {
            clearAnimation();
            startAnimation(this.aLz);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aLA = false;
        this.aLB = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aLD, aLE);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aLF;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aLD, aLE);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aLF);
            setLayoutParams(layoutParams2);
        }
        if (this.aLC != null) {
            this.aLC.a(aVar);
        }
    }

    public void DH() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.aLC = aVar;
    }
}
