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
    private static final int aHw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int aHx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int aHy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float Bn;
    private TbImageView aHo;
    private TextView aHp;
    private TextView aHq;
    private Animation aHr;
    private Animation aHs;
    private boolean aHt;
    private com.baidu.mcn.a aHu;
    private a aHv;
    private ViewParent aHz;
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
        this.aHt = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aHt = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aHt = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.aHo = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.aHp = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aHq = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.aHo.setConrers(5);
        this.aHo.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aHo.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aHo.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.aHr = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.aHs = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.aHs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.aHu = aVar;
            this.aHo.startLoad(aVar.aHd, 10, false);
            if (!StringUtils.isNull(aVar.aHe)) {
                this.aHp.setText(aVar.aHe);
            }
            if (!StringUtils.isNull(aVar.aHf)) {
                this.aHq.setText(aVar.aHf);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.Bn = motionEvent.getY();
                this.aHz = getParent();
                if (this.aHz != null) {
                    this.aHz.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                Bq();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.Bn) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.aHt = true;
                    dismiss();
                    if (this.aHv != null) {
                        this.aHv.c(this.aHu);
                        break;
                    }
                }
                break;
            case 3:
                Bq();
                break;
        }
        return true;
    }

    private void Bq() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aHz != null) {
                    McnVideoAdView.this.aHz.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aHz = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.aHu != null && this.aHu.aHg != null) {
            s.be(this.mContext, this.aHu.aHg);
            if (this.aHv != null) {
                this.aHv.b(this.aHu);
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
        if (this.aHr != null) {
            clearAnimation();
            startAnimation(this.aHr);
        }
    }

    public void dismiss() {
        if (this.aHs != null) {
            clearAnimation();
            startAnimation(this.aHs);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aHt = false;
        this.aHu = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aHw, aHx);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aHy;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aHw, aHx);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aHy);
            setLayoutParams(layoutParams2);
        }
        if (this.aHv != null) {
            this.aHv.a(aVar);
        }
    }

    public void Bp() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.aHv = aVar;
    }
}
