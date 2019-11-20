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
    private static final int ayS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int ayT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int ayU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private boolean abA;
    private TbImageView ayK;
    private TextView ayL;
    private TextView ayM;
    private Animation ayN;
    private Animation ayO;
    private boolean ayP;
    private com.baidu.mcn.a ayQ;
    private a ayR;
    private ViewParent ayV;
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
        this.abA = false;
        this.ayP = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abA = false;
        this.ayP = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abA = false;
        this.ayP = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.ayK = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.ayL = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.ayM = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.ayK.setConrers(5);
        this.ayK.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.ayK.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.ayK.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.ayN = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.ayO = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.ayO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.ayQ = aVar;
            this.ayK.startLoad(aVar.ayy, 10, false);
            if (!StringUtils.isNull(aVar.ayz)) {
                this.ayL.setText(aVar.ayz);
            }
            if (!StringUtils.isNull(aVar.ayA)) {
                this.ayM.setText(aVar.ayA);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.ayV = getParent();
                if (this.ayV != null) {
                    this.ayV.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                zg();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    zh();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.abA) {
                    this.ayP = true;
                    dismiss();
                    if (this.ayR != null) {
                        this.ayR.c(this.ayQ);
                        break;
                    }
                }
                break;
            case 3:
                zg();
                break;
        }
        return true;
    }

    private void zg() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.ayV != null) {
                    McnVideoAdView.this.ayV.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.ayV = null;
                }
            }
        }, 500L);
    }

    private void zh() {
        if (this.mContext != null && this.ayQ != null && this.ayQ.ayB != null) {
            s.aL(this.mContext, this.ayQ.ayB);
            if (this.ayR != null) {
                this.ayR.b(this.ayQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeView() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.abA = false;
        }
    }

    public void a(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        b(aVar, viewGroup);
        if (this.ayN != null) {
            clearAnimation();
            startAnimation(this.ayN);
        }
    }

    public void dismiss() {
        if (this.ayO != null) {
            clearAnimation();
            startAnimation(this.ayO);
        }
    }

    public boolean isShowing() {
        return this.abA;
    }

    public void reset() {
        removeView();
        this.abA = false;
        this.ayP = false;
        this.ayQ = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.abA = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ayS, ayT);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = ayU;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ayS, ayT);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, ayU);
            setLayoutParams(layoutParams2);
        }
        if (this.ayR != null) {
            this.ayR.a(aVar);
        }
    }

    public void zf() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.ayR = aVar;
    }
}
