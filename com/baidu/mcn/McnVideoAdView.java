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
import com.baidu.tieba.recapp.t;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int cib = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int cic = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int cie = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private TbImageView chT;
    private TextView chU;
    private TextView chV;
    private Animation chW;
    private Animation chX;
    private boolean chY;
    private com.baidu.mcn.a chZ;
    private a cia;
    private ViewParent cif;
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
        this.chY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.chY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.chY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.chT = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.chU = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.chV = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.chT.setConrers(5);
        this.chT.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.chT.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.chT.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.chW = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.chX = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.chX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.chZ = aVar;
            this.chT.startLoad(aVar.chI, 10, false);
            if (!StringUtils.isNull(aVar.chJ)) {
                this.chU.setText(aVar.chJ);
            }
            if (!StringUtils.isNull(aVar.chK)) {
                this.chV.setText(aVar.chK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.cif = getParent();
                if (this.cif != null) {
                    this.cif.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                abt();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    abu();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.isShowing) {
                    this.chY = true;
                    dismiss();
                    if (this.cia != null) {
                        this.cia.c(this.chZ);
                        break;
                    }
                }
                break;
            case 3:
                abt();
                break;
        }
        return true;
    }

    private void abt() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.cif != null) {
                    McnVideoAdView.this.cif.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.cif = null;
                }
            }
        }, 500L);
    }

    private void abu() {
        if (this.mContext != null && this.chZ != null && this.chZ.chL != null) {
            t.i(this.mContext, this.chZ.chL, null, null);
            if (this.cia != null) {
                this.cia.b(this.chZ);
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
        if (this.chW != null) {
            clearAnimation();
            startAnimation(this.chW);
        }
    }

    public void dismiss() {
        if (this.chX != null) {
            clearAnimation();
            startAnimation(this.chX);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.chY = false;
        this.chZ = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cib, cic);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = cie;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cib, cic);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, cie);
            setLayoutParams(layoutParams2);
        }
        if (this.cia != null) {
            this.cia.a(aVar);
        }
    }

    public void abs() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.cia = aVar;
    }
}
