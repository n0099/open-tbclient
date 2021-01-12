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
    private static final int cdT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int cdU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int cdV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView cdL;
    private TextView cdM;
    private TextView cdN;
    private Animation cdO;
    private Animation cdP;
    private boolean cdQ;
    private com.baidu.mcn.a cdR;
    private a cdS;
    private ViewParent cdW;
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
        this.cdQ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.cdQ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.cdQ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.cdL = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.cdM = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.cdN = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.cdL.setConrers(5);
        this.cdL.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cdL.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cdL.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.cdO = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.cdP = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.cdP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.cdR = aVar;
            this.cdL.startLoad(aVar.cdA, 10, false);
            if (!StringUtils.isNull(aVar.cdB)) {
                this.cdM.setText(aVar.cdB);
            }
            if (!StringUtils.isNull(aVar.cdC)) {
                this.cdN.setText(aVar.cdC);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.cdW = getParent();
                if (this.cdW != null) {
                    this.cdW.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ZE();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    ZF();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.cdQ = true;
                    dismiss();
                    if (this.cdS != null) {
                        this.cdS.c(this.cdR);
                        break;
                    }
                }
                break;
            case 3:
                ZE();
                break;
        }
        return true;
    }

    private void ZE() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.cdW != null) {
                    McnVideoAdView.this.cdW.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.cdW = null;
                }
            }
        }, 500L);
    }

    private void ZF() {
        if (this.mContext != null && this.cdR != null && this.cdR.cdD != null) {
            s.x(this.mContext, this.cdR.cdD, null);
            if (this.cdS != null) {
                this.cdS.b(this.cdR);
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
        if (this.cdO != null) {
            clearAnimation();
            startAnimation(this.cdO);
        }
    }

    public void dismiss() {
        if (this.cdP != null) {
            clearAnimation();
            startAnimation(this.cdP);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.cdQ = false;
        this.cdR = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cdT, cdU);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = cdV;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cdT, cdU);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, cdV);
            setLayoutParams(layoutParams2);
        }
        if (this.cdS != null) {
            this.cdS.a(aVar);
        }
    }

    public void ZD() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.cdS = aVar;
    }
}
