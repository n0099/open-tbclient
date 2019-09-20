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
    private static final int afM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int afN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int afO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView afE;
    private TextView afF;
    private TextView afG;
    private Animation afH;
    private Animation afI;
    private boolean afJ;
    private com.baidu.mcn.a afK;
    private a afL;
    private ViewParent afP;
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
        this.afJ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.afJ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.afJ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.afE = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.afF = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.afG = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.afE.setConrers(5);
        this.afE.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.afE.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.afE.setRadius(l.g(this.mContext, R.dimen.tbds20));
        this.afH = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.afI = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.afI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afK = aVar;
            this.afE.startLoad(aVar.afs, 10, false);
            if (!StringUtils.isNull(aVar.aft)) {
                this.afF.setText(aVar.aft);
            }
            if (!StringUtils.isNull(aVar.afu)) {
                this.afG.setText(aVar.afu);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.afP = getParent();
                if (this.afP != null) {
                    this.afP.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ul();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    um();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.afJ = true;
                    dismiss();
                    if (this.afL != null) {
                        this.afL.c(this.afK);
                        break;
                    }
                }
                break;
            case 3:
                ul();
                break;
        }
        return true;
    }

    private void ul() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.afP != null) {
                    McnVideoAdView.this.afP.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.afP = null;
                }
            }
        }, 500L);
    }

    private void um() {
        if (this.mContext != null && this.afK != null && this.afK.afv != null) {
            s.aO(this.mContext, this.afK.afv);
            if (this.afL != null) {
                this.afL.b(this.afK);
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
        if (this.afH != null) {
            clearAnimation();
            startAnimation(this.afH);
        }
    }

    public void dismiss() {
        if (this.afI != null) {
            clearAnimation();
            startAnimation(this.afI);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.afJ = false;
        this.afK = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afM, afN);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = afO;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afM, afN);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, afO);
            setLayoutParams(layoutParams2);
        }
        if (this.afL != null) {
            this.afL.a(aVar);
        }
    }

    public void uk() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afL = aVar;
    }
}
