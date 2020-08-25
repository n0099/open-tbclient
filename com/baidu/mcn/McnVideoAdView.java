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
/* loaded from: classes2.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int bAj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bAk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bAl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView bAb;
    private TextView bAc;
    private TextView bAd;
    private Animation bAe;
    private Animation bAf;
    private boolean bAg;
    private com.baidu.mcn.a bAh;
    private a bAi;
    private ViewParent bAm;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;
    private float mLastX;
    private float mLastY;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.bAg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bAg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bAg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bAb = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bAc = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bAd = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bAb.setConrers(5);
        this.bAb.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bAb.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bAb.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bAe = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bAf = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bAf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bAh = aVar;
            this.bAb.startLoad(aVar.bzQ, 10, false);
            if (!StringUtils.isNull(aVar.bzR)) {
                this.bAc.setText(aVar.bzR);
            }
            if (!StringUtils.isNull(aVar.bzS)) {
                this.bAd.setText(aVar.bzS);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bAm = getParent();
                if (this.bAm != null) {
                    this.bAm.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                SO();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bAg = true;
                    dismiss();
                    if (this.bAi != null) {
                        this.bAi.c(this.bAh);
                        break;
                    }
                }
                break;
            case 3:
                SO();
                break;
        }
        return true;
    }

    private void SO() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bAm != null) {
                    McnVideoAdView.this.bAm.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bAm = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bAh != null && this.bAh.bzT != null) {
            s.aR(this.mContext, this.bAh.bzT);
            if (this.bAi != null) {
                this.bAi.b(this.bAh);
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
        if (this.bAe != null) {
            clearAnimation();
            startAnimation(this.bAe);
        }
    }

    public void dismiss() {
        if (this.bAf != null) {
            clearAnimation();
            startAnimation(this.bAf);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bAg = false;
        this.bAh = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bAj, bAk);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bAl;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bAj, bAk);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bAl);
            setLayoutParams(layoutParams2);
        }
        if (this.bAi != null) {
            this.bAi.a(aVar);
        }
    }

    public void SN() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bAi = aVar;
    }
}
