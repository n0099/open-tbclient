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
    private static final int bYq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bYr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bYs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView bYi;
    private TextView bYj;
    private TextView bYk;
    private Animation bYl;
    private Animation bYm;
    private boolean bYn;
    private com.baidu.mcn.a bYo;
    private a bYp;
    private ViewParent bYt;
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
        this.bYn = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bYn = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bYn = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bYi = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bYj = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bYk = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bYi.setConrers(5);
        this.bYi.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bYi.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bYi.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bYl = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bYm = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bYm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bYo = aVar;
            this.bYi.startLoad(aVar.bXX, 10, false);
            if (!StringUtils.isNull(aVar.bXY)) {
                this.bYj.setText(aVar.bXY);
            }
            if (!StringUtils.isNull(aVar.bXZ)) {
                this.bYk.setText(aVar.bXZ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bYt = getParent();
                if (this.bYt != null) {
                    this.bYt.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ZR();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bYn = true;
                    dismiss();
                    if (this.bYp != null) {
                        this.bYp.c(this.bYo);
                        break;
                    }
                }
                break;
            case 3:
                ZR();
                break;
        }
        return true;
    }

    private void ZR() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bYt != null) {
                    McnVideoAdView.this.bYt.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bYt = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bYo != null && this.bYo.bYa != null) {
            s.aY(this.mContext, this.bYo.bYa);
            if (this.bYp != null) {
                this.bYp.b(this.bYo);
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
        if (this.bYl != null) {
            clearAnimation();
            startAnimation(this.bYl);
        }
    }

    public void dismiss() {
        if (this.bYm != null) {
            clearAnimation();
            startAnimation(this.bYm);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bYn = false;
        this.bYo = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bYq, bYr);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bYs;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bYq, bYr);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bYs);
            setLayoutParams(layoutParams2);
        }
        if (this.bYp != null) {
            this.bYp.a(aVar);
        }
    }

    public void ZQ() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bYp = aVar;
    }
}
