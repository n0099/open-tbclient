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
    private static final int aGE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int aGF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int aGG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float Bi;
    private Animation aGA;
    private boolean aGB;
    private com.baidu.mcn.a aGC;
    private a aGD;
    private ViewParent aGH;
    private TbImageView aGw;
    private TextView aGx;
    private TextView aGy;
    private Animation aGz;
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
        this.aGB = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aGB = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aGB = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.aGw = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.aGx = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aGy = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.aGw.setConrers(5);
        this.aGw.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aGw.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aGw.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.aGz = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.aGA = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.aGA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.aGC = aVar;
            this.aGw.startLoad(aVar.aGl, 10, false);
            if (!StringUtils.isNull(aVar.aGm)) {
                this.aGx.setText(aVar.aGm);
            }
            if (!StringUtils.isNull(aVar.aGn)) {
                this.aGy.setText(aVar.aGn);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.Bi = motionEvent.getY();
                this.aGH = getParent();
                if (this.aGH != null) {
                    this.aGH.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                AU();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.Bi) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.aGB = true;
                    dismiss();
                    if (this.aGD != null) {
                        this.aGD.c(this.aGC);
                        break;
                    }
                }
                break;
            case 3:
                AU();
                break;
        }
        return true;
    }

    private void AU() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aGH != null) {
                    McnVideoAdView.this.aGH.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aGH = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.aGC != null && this.aGC.aGo != null) {
            s.bd(this.mContext, this.aGC.aGo);
            if (this.aGD != null) {
                this.aGD.b(this.aGC);
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
        if (this.aGz != null) {
            clearAnimation();
            startAnimation(this.aGz);
        }
    }

    public void dismiss() {
        if (this.aGA != null) {
            clearAnimation();
            startAnimation(this.aGA);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aGB = false;
        this.aGC = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aGE, aGF);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aGG;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aGE, aGF);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aGG);
            setLayoutParams(layoutParams2);
        }
        if (this.aGD != null) {
            this.aGD.a(aVar);
        }
    }

    public void AT() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.aGD = aVar;
    }
}
