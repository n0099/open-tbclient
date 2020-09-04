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
    private static final int bAm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bAn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bAo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView bAe;
    private TextView bAf;
    private TextView bAg;
    private Animation bAh;
    private Animation bAi;
    private boolean bAj;
    private com.baidu.mcn.a bAk;
    private a bAl;
    private ViewParent bAp;
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
        this.bAj = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bAj = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bAj = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bAe = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bAf = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bAg = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bAe.setConrers(5);
        this.bAe.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bAe.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bAe.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bAh = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bAi = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bAi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bAk = aVar;
            this.bAe.startLoad(aVar.bzT, 10, false);
            if (!StringUtils.isNull(aVar.bzU)) {
                this.bAf.setText(aVar.bzU);
            }
            if (!StringUtils.isNull(aVar.bzV)) {
                this.bAg.setText(aVar.bzV);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bAp = getParent();
                if (this.bAp != null) {
                    this.bAp.requestDisallowInterceptTouchEvent(true);
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
                    this.bAj = true;
                    dismiss();
                    if (this.bAl != null) {
                        this.bAl.c(this.bAk);
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
                if (McnVideoAdView.this.bAp != null) {
                    McnVideoAdView.this.bAp.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bAp = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bAk != null && this.bAk.bzW != null) {
            s.aR(this.mContext, this.bAk.bzW);
            if (this.bAl != null) {
                this.bAl.b(this.bAk);
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
        if (this.bAh != null) {
            clearAnimation();
            startAnimation(this.bAh);
        }
    }

    public void dismiss() {
        if (this.bAi != null) {
            clearAnimation();
            startAnimation(this.bAi);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bAj = false;
        this.bAk = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bAm, bAn);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bAo;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bAm, bAn);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bAo);
            setLayoutParams(layoutParams2);
        }
        if (this.bAl != null) {
            this.bAl.a(aVar);
        }
    }

    public void SN() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bAl = aVar;
    }
}
