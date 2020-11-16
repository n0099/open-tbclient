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
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int bWG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bWH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bWI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TextView bWA;
    private Animation bWB;
    private Animation bWC;
    private boolean bWD;
    private com.baidu.mcn.a bWE;
    private a bWF;
    private ViewParent bWJ;
    private TbImageView bWy;
    private TextView bWz;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;
    private float mLastX;
    private float mLastY;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.bWD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bWD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bWD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bWy = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bWz = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bWA = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bWy.setConrers(5);
        this.bWy.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bWy.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bWy.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bWB = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bWC = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bWC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bWE = aVar;
            this.bWy.startLoad(aVar.bWn, 10, false);
            if (!StringUtils.isNull(aVar.bWo)) {
                this.bWz.setText(aVar.bWo);
            }
            if (!StringUtils.isNull(aVar.bWp)) {
                this.bWA.setText(aVar.bWp);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bWJ = getParent();
                if (this.bWJ != null) {
                    this.bWJ.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                Zi();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bWD = true;
                    dismiss();
                    if (this.bWF != null) {
                        this.bWF.c(this.bWE);
                        break;
                    }
                }
                break;
            case 3:
                Zi();
                break;
        }
        return true;
    }

    private void Zi() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bWJ != null) {
                    McnVideoAdView.this.bWJ.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bWJ = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bWE != null && this.bWE.bWq != null) {
            r.aV(this.mContext, this.bWE.bWq);
            if (this.bWF != null) {
                this.bWF.b(this.bWE);
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
        if (this.bWB != null) {
            clearAnimation();
            startAnimation(this.bWB);
        }
    }

    public void dismiss() {
        if (this.bWC != null) {
            clearAnimation();
            startAnimation(this.bWC);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bWD = false;
        this.bWE = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bWG, bWH);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bWI;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bWG, bWH);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bWI);
            setLayoutParams(layoutParams2);
        }
        if (this.bWF != null) {
            this.bWF.a(aVar);
        }
    }

    public void Zh() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bWF = aVar;
    }
}
