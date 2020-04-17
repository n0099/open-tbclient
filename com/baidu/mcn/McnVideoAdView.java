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
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private float UY;
    private float UZ;
    private ViewParent bhB;
    private TbImageView bhq;
    private TextView bhr;
    private TextView bhs;
    private Animation bht;
    private Animation bhu;
    private boolean bhv;
    private com.baidu.mcn.a bhw;
    private a bhx;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;
    private static final int bhy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bhz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bhA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.bhv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bhv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bhv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bhq = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bhr = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bhs = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bhq.setConrers(5);
        this.bhq.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bhq.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bhq.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bht = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bhu = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bhu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bhw = aVar;
            this.bhq.startLoad(aVar.bhf, 10, false);
            if (!StringUtils.isNull(aVar.bhg)) {
                this.bhr.setText(aVar.bhg);
            }
            if (!StringUtils.isNull(aVar.bhh)) {
                this.bhs.setText(aVar.bhh);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.UY = motionEvent.getX();
                this.UZ = motionEvent.getY();
                this.bhB = getParent();
                if (this.bhB != null) {
                    this.bhB.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                JH();
                if (Math.abs(motionEvent.getX() - this.UY) < 5.0f && Math.abs(motionEvent.getY() - this.UZ) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.UY > 10.0f && this.isShowing) {
                    this.bhv = true;
                    dismiss();
                    if (this.bhx != null) {
                        this.bhx.c(this.bhw);
                        break;
                    }
                }
                break;
            case 3:
                JH();
                break;
        }
        return true;
    }

    private void JH() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bhB != null) {
                    McnVideoAdView.this.bhB.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bhB = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bhw != null && this.bhw.bhi != null) {
            r.aZ(this.mContext, this.bhw.bhi);
            if (this.bhx != null) {
                this.bhx.b(this.bhw);
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
        if (this.bht != null) {
            clearAnimation();
            startAnimation(this.bht);
        }
    }

    public void dismiss() {
        if (this.bhu != null) {
            clearAnimation();
            startAnimation(this.bhu);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bhv = false;
        this.bhw = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bhy, bhz);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bhA;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bhy, bhz);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bhA);
            setLayoutParams(layoutParams2);
        }
        if (this.bhx != null) {
            this.bhx.a(aVar);
        }
    }

    public void JG() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bhx = aVar;
    }
}
