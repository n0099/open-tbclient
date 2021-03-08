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
import com.baidu.tieba.recapp.t;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int cjC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int cjD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int cjE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private com.baidu.mcn.a cjA;
    private a cjB;
    private ViewParent cjF;
    private TbImageView cju;
    private TextView cjv;
    private TextView cjw;
    private Animation cjx;
    private Animation cjy;
    private boolean cjz;
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
        this.cjz = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.cjz = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.cjz = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.cju = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.cjv = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.cjw = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.cju.setConrers(5);
        this.cju.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cju.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cju.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.cjx = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.cjy = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.cjy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.cjA = aVar;
            this.cju.startLoad(aVar.cjj, 10, false);
            if (!StringUtils.isNull(aVar.cjk)) {
                this.cjv.setText(aVar.cjk);
            }
            if (!StringUtils.isNull(aVar.cjl)) {
                this.cjw.setText(aVar.cjl);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.cjF = getParent();
                if (this.cjF != null) {
                    this.cjF.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                abw();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    abx();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.cjz = true;
                    dismiss();
                    if (this.cjB != null) {
                        this.cjB.c(this.cjA);
                        break;
                    }
                }
                break;
            case 3:
                abw();
                break;
        }
        return true;
    }

    private void abw() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.cjF != null) {
                    McnVideoAdView.this.cjF.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.cjF = null;
                }
            }
        }, 500L);
    }

    private void abx() {
        if (this.mContext != null && this.cjA != null && this.cjA.cjm != null) {
            t.i(this.mContext, this.cjA.cjm, null, null);
            if (this.cjB != null) {
                this.cjB.b(this.cjA);
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
        if (this.cjx != null) {
            clearAnimation();
            startAnimation(this.cjx);
        }
    }

    public void dismiss() {
        if (this.cjy != null) {
            clearAnimation();
            startAnimation(this.cjy);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.cjz = false;
        this.cjA = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cjC, cjD);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = cjE;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cjC, cjD);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, cjE);
            setLayoutParams(layoutParams2);
        }
        if (this.cjB != null) {
            this.cjB.a(aVar);
        }
    }

    public void abv() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.cjB = aVar;
    }
}
