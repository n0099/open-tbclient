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
    private static final int cbV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int cbW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int cbX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView cbN;
    private TextView cbO;
    private TextView cbP;
    private Animation cbQ;
    private Animation cbR;
    private boolean cbS;
    private com.baidu.mcn.a cbT;
    private a cbU;
    private ViewParent cbY;
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
        this.cbS = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.cbS = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.cbS = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.cbN = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.cbO = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.cbP = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.cbN.setConrers(5);
        this.cbN.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cbN.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.cbN.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.cbQ = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.cbR = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.cbR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.cbT = aVar;
            this.cbN.startLoad(aVar.cbC, 10, false);
            if (!StringUtils.isNull(aVar.cbD)) {
                this.cbO.setText(aVar.cbD);
            }
            if (!StringUtils.isNull(aVar.cbE)) {
                this.cbP.setText(aVar.cbE);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.cbY = getParent();
                if (this.cbY != null) {
                    this.cbY.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                abL();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.cbS = true;
                    dismiss();
                    if (this.cbU != null) {
                        this.cbU.c(this.cbT);
                        break;
                    }
                }
                break;
            case 3:
                abL();
                break;
        }
        return true;
    }

    private void abL() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.cbY != null) {
                    McnVideoAdView.this.cbY.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.cbY = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.cbT != null && this.cbT.cbF != null) {
            s.aZ(this.mContext, this.cbT.cbF);
            if (this.cbU != null) {
                this.cbU.b(this.cbT);
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
        if (this.cbQ != null) {
            clearAnimation();
            startAnimation(this.cbQ);
        }
    }

    public void dismiss() {
        if (this.cbR != null) {
            clearAnimation();
            startAnimation(this.cbR);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.cbS = false;
        this.cbT = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cbV, cbW);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = cbX;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cbV, cbW);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, cbX);
            setLayoutParams(layoutParams2);
        }
        if (this.cbU != null) {
            this.cbU.a(aVar);
        }
    }

    public void abK() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.cbU = aVar;
    }
}
