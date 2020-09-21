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
    private static final int bDJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bDK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bDL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView bDB;
    private TextView bDC;
    private TextView bDD;
    private Animation bDE;
    private Animation bDF;
    private boolean bDG;
    private com.baidu.mcn.a bDH;
    private a bDI;
    private ViewParent bDM;
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
        this.bDG = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.bDG = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.bDG = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.bDB = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bDC = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bDD = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.bDB.setConrers(5);
        this.bDB.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bDB.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.bDB.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.bDE = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.bDF = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.bDF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.bDH = aVar;
            this.bDB.startLoad(aVar.bDq, 10, false);
            if (!StringUtils.isNull(aVar.bDr)) {
                this.bDC.setText(aVar.bDr);
            }
            if (!StringUtils.isNull(aVar.bDs)) {
                this.bDD.setText(aVar.bDs);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.bDM = getParent();
                if (this.bDM != null) {
                    this.bDM.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                TF();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.bDG = true;
                    dismiss();
                    if (this.bDI != null) {
                        this.bDI.c(this.bDH);
                        break;
                    }
                }
                break;
            case 3:
                TF();
                break;
        }
        return true;
    }

    private void TF() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bDM != null) {
                    McnVideoAdView.this.bDM.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bDM = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.bDH != null && this.bDH.bDt != null) {
            s.aU(this.mContext, this.bDH.bDt);
            if (this.bDI != null) {
                this.bDI.b(this.bDH);
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
        if (this.bDE != null) {
            clearAnimation();
            startAnimation(this.bDE);
        }
    }

    public void dismiss() {
        if (this.bDF != null) {
            clearAnimation();
            startAnimation(this.bDF);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.bDG = false;
        this.bDH = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bDJ, bDK);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bDL;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bDJ, bDK);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bDL);
            setLayoutParams(layoutParams2);
        }
        if (this.bDI != null) {
            this.bDI.a(aVar);
        }
    }

    public void TE() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bDI = aVar;
    }
}
