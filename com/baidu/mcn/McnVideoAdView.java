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
    private static final int bhD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bhE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bhF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float Vb;
    private float Vc;
    private boolean bhA;
    private com.baidu.mcn.a bhB;
    private a bhC;
    private ViewParent bhG;
    private TbImageView bhv;
    private TextView bhw;
    private TextView bhx;
    private Animation bhy;
    private Animation bhz;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.bhA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bhA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bhA = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bhv = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bhw = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bhx = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bhv.setConrers(5);
        this.bhv.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bhv.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bhv.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bhy = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bhz = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bhz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bhB = aVar;
            this.bhv.startLoad(aVar.bhk, 10, false);
            if (!StringUtils.isNull(aVar.bhl)) {
                this.bhw.setText(aVar.bhl);
            }
            if (!StringUtils.isNull(aVar.bhm)) {
                this.bhx.setText(aVar.bhm);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Vb = motionEvent.getX();
                this.Vc = motionEvent.getY();
                this.bhG = getParent();
                if (this.bhG != null) {
                    this.bhG.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                JG();
                if (Math.abs(motionEvent.getX() - this.Vb) < 5.0f && Math.abs(motionEvent.getY() - this.Vc) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.Vb > 10.0f && this.isShowing) {
                    this.bhA = true;
                    dismiss();
                    if (this.bhC != null) {
                        this.bhC.c(this.bhB);
                        break;
                    }
                }
                break;
            case 3:
                JG();
                break;
        }
        return true;
    }

    private void JG() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bhG != null) {
                    McnVideoAdView.this.bhG.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bhG = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bhB != null && this.bhB.bhn != null) {
            r.aN(this.mContext, this.bhB.bhn);
            if (this.bhC != null) {
                this.bhC.b(this.bhB);
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
        if (this.bhy != null) {
            clearAnimation();
            startAnimation(this.bhy);
        }
    }

    public void dismiss() {
        if (this.bhz != null) {
            clearAnimation();
            startAnimation(this.bhz);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bhA = false;
        this.bhB = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bhD, bhE);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bhF;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bhD, bhE);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bhF);
            setLayoutParams(layoutParams2);
        }
        if (this.bhC != null) {
            this.bhC.a(aVar);
        }
    }

    public void JF() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bhC = aVar;
    }
}
