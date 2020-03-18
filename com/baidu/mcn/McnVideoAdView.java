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
    private static final int aLR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int aLS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int aLT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float BF;
    private TbImageView aLJ;
    private TextView aLK;
    private TextView aLL;
    private Animation aLM;
    private Animation aLN;
    private boolean aLO;
    private com.baidu.mcn.a aLP;
    private a aLQ;
    private ViewParent aLU;
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
        this.aLO = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aLO = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aLO = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.aLJ = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.aLK = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aLL = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.aLJ.setConrers(5);
        this.aLJ.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLJ.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.aLJ.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.aLM = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.aLN = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.aLN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.aLP = aVar;
            this.aLJ.startLoad(aVar.aLy, 10, false);
            if (!StringUtils.isNull(aVar.aLz)) {
                this.aLK.setText(aVar.aLz);
            }
            if (!StringUtils.isNull(aVar.aLA)) {
                this.aLL.setText(aVar.aLA);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.BF = motionEvent.getY();
                this.aLU = getParent();
                if (this.aLU != null) {
                    this.aLU.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                DP();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.BF) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.aLO = true;
                    dismiss();
                    if (this.aLQ != null) {
                        this.aLQ.c(this.aLP);
                        break;
                    }
                }
                break;
            case 3:
                DP();
                break;
        }
        return true;
    }

    private void DP() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aLU != null) {
                    McnVideoAdView.this.aLU.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aLU = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.aLP != null && this.aLP.aLB != null) {
            s.be(this.mContext, this.aLP.aLB);
            if (this.aLQ != null) {
                this.aLQ.b(this.aLP);
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
        if (this.aLM != null) {
            clearAnimation();
            startAnimation(this.aLM);
        }
    }

    public void dismiss() {
        if (this.aLN != null) {
            clearAnimation();
            startAnimation(this.aLN);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aLO = false;
        this.aLP = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aLR, aLS);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aLT;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aLR, aLS);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aLT);
            setLayoutParams(layoutParams2);
        }
        if (this.aLQ != null) {
            this.aLQ.a(aVar);
        }
    }

    public void DO() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.aLQ = aVar;
    }
}
