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
    private static final int bKl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bKm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bKn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView bKd;
    private TextView bKe;
    private TextView bKf;
    private Animation bKg;
    private Animation bKh;
    private boolean bKi;
    private com.baidu.mcn.a bKj;
    private a bKk;
    private ViewParent bKo;
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
        this.bKi = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bKi = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bKi = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bKd = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bKe = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bKf = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bKd.setConrers(5);
        this.bKd.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bKd.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bKd.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bKg = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bKh = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bKh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bKj = aVar;
            this.bKd.startLoad(aVar.bJS, 10, false);
            if (!StringUtils.isNull(aVar.bJT)) {
                this.bKe.setText(aVar.bJT);
            }
            if (!StringUtils.isNull(aVar.bJU)) {
                this.bKf.setText(aVar.bJU);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bKo = getParent();
                if (this.bKo != null) {
                    this.bKo.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                Vy();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bKi = true;
                    dismiss();
                    if (this.bKk != null) {
                        this.bKk.c(this.bKj);
                        break;
                    }
                }
                break;
            case 3:
                Vy();
                break;
        }
        return true;
    }

    private void Vy() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bKo != null) {
                    McnVideoAdView.this.bKo.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bKo = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bKj != null && this.bKj.bJV != null) {
            s.aW(this.mContext, this.bKj.bJV);
            if (this.bKk != null) {
                this.bKk.b(this.bKj);
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
        if (this.bKg != null) {
            clearAnimation();
            startAnimation(this.bKg);
        }
    }

    public void dismiss() {
        if (this.bKh != null) {
            clearAnimation();
            startAnimation(this.bKh);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bKi = false;
        this.bKj = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bKl, bKm);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bKn;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bKl, bKm);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bKn);
            setLayoutParams(layoutParams2);
        }
        if (this.bKk != null) {
            this.bKk.a(aVar);
        }
    }

    public void Vx() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bKk = aVar;
    }
}
