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
    private static final int ciG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int ciH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int ciI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TextView ciA;
    private Animation ciB;
    private Animation ciC;
    private boolean ciD;
    private com.baidu.mcn.a ciE;
    private a ciF;
    private ViewParent ciJ;
    private TbImageView ciy;
    private TextView ciz;
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
        this.ciD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.ciD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.ciD = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.ciy = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.ciz = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.ciA = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.ciy.setConrers(5);
        this.ciy.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.ciy.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.ciy.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.ciB = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.ciC = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.ciC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.ciE = aVar;
            this.ciy.startLoad(aVar.cin, 10, false);
            if (!StringUtils.isNull(aVar.cio)) {
                this.ciz.setText(aVar.cio);
            }
            if (!StringUtils.isNull(aVar.cip)) {
                this.ciA.setText(aVar.cip);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.ciJ = getParent();
                if (this.ciJ != null) {
                    this.ciJ.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                adw();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    adx();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.ciD = true;
                    dismiss();
                    if (this.ciF != null) {
                        this.ciF.c(this.ciE);
                        break;
                    }
                }
                break;
            case 3:
                adw();
                break;
        }
        return true;
    }

    private void adw() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.ciJ != null) {
                    McnVideoAdView.this.ciJ.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.ciJ = null;
                }
            }
        }, 500L);
    }

    private void adx() {
        if (this.mContext != null && this.ciE != null && this.ciE.ciq != null) {
            s.x(this.mContext, this.ciE.ciq, null);
            if (this.ciF != null) {
                this.ciF.b(this.ciE);
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
        if (this.ciB != null) {
            clearAnimation();
            startAnimation(this.ciB);
        }
    }

    public void dismiss() {
        if (this.ciC != null) {
            clearAnimation();
            startAnimation(this.ciC);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.ciD = false;
        this.ciE = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ciG, ciH);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = ciI;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ciG, ciH);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, ciI);
            setLayoutParams(layoutParams2);
        }
        if (this.ciF != null) {
            this.ciF.a(aVar);
        }
    }

    public void adv() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.ciF = aVar;
    }
}
