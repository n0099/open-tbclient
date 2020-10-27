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
    private static final int bSG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bSH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bSI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TextView bSA;
    private Animation bSB;
    private Animation bSC;
    private boolean bSD;
    private com.baidu.mcn.a bSE;
    private a bSF;
    private ViewParent bSJ;
    private TbImageView bSy;
    private TextView bSz;
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
        this.bSD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bSD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bSD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bSy = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bSz = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bSA = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bSy.setConrers(5);
        this.bSy.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bSy.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bSy.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bSB = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bSC = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bSC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bSE = aVar;
            this.bSy.startLoad(aVar.bSn, 10, false);
            if (!StringUtils.isNull(aVar.bSo)) {
                this.bSz.setText(aVar.bSo);
            }
            if (!StringUtils.isNull(aVar.bSp)) {
                this.bSA.setText(aVar.bSp);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bSJ = getParent();
                if (this.bSJ != null) {
                    this.bSJ.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                Xs();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bSD = true;
                    dismiss();
                    if (this.bSF != null) {
                        this.bSF.c(this.bSE);
                        break;
                    }
                }
                break;
            case 3:
                Xs();
                break;
        }
        return true;
    }

    private void Xs() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bSJ != null) {
                    McnVideoAdView.this.bSJ.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bSJ = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bSE != null && this.bSE.bSq != null) {
            s.aY(this.mContext, this.bSE.bSq);
            if (this.bSF != null) {
                this.bSF.b(this.bSE);
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
        if (this.bSB != null) {
            clearAnimation();
            startAnimation(this.bSB);
        }
    }

    public void dismiss() {
        if (this.bSC != null) {
            clearAnimation();
            startAnimation(this.bSC);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bSD = false;
        this.bSE = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bSG, bSH);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bSI;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bSG, bSH);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bSI);
            setLayoutParams(layoutParams2);
        }
        if (this.bSF != null) {
            this.bSF.a(aVar);
        }
    }

    public void Xr() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bSF = aVar;
    }
}
