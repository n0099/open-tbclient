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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int afc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds626);
    private static final int afd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds156);
    private static final int afe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112);
    private float Qk;
    private float Ql;
    private TbImageView aeU;
    private TextView aeV;
    private TextView aeW;
    private Animation aeX;
    private Animation aeY;
    private boolean aeZ;
    private com.baidu.mcn.a afa;
    private a afb;
    private ViewParent aff;
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
        this.aeZ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aeZ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aeZ = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.mcn_video_ad_layout, this);
        this.aeU = (TbImageView) findViewById(d.g.id_mcn_video_ad_image);
        this.aeV = (TextView) findViewById(d.g.id_mcn_video_ad_title);
        this.aeW = (TextView) findViewById(d.g.id_mcn_video_ad_jump_btn);
        this.aeU.setConrers(5);
        this.aeU.setDefaultResource(d.f.mcn_video_ad_default_img_bg);
        this.aeU.setDefaultBgResource(d.f.mcn_video_ad_default_img_bg);
        this.aeU.setRadius(l.h(this.mContext, d.e.tbds20));
        this.aeX = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_open_anim);
        this.aeY = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_close_anim);
        this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afa = aVar;
            this.aeU.startLoad(aVar.aeI, 10, false);
            if (!StringUtils.isNull(aVar.aeJ)) {
                this.aeV.setText(aVar.aeJ);
            }
            if (!StringUtils.isNull(aVar.aeK)) {
                this.aeW.setText(aVar.aeK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Qk = motionEvent.getX();
                this.Ql = motionEvent.getY();
                this.aff = getParent();
                if (this.aff != null) {
                    this.aff.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ta();
                if (Math.abs(motionEvent.getX() - this.Qk) < 5.0f && Math.abs(motionEvent.getY() - this.Ql) < 5.0f) {
                    tb();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.Qk > 10.0f && this.isShowing) {
                    this.aeZ = true;
                    dismiss();
                    if (this.afb != null) {
                        this.afb.c(this.afa);
                        break;
                    }
                }
                break;
            case 3:
                ta();
                break;
        }
        return true;
    }

    private void ta() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.aff != null) {
                    McnVideoAdView.this.aff.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.aff = null;
                }
            }
        }, 500L);
    }

    private void tb() {
        if (this.mContext != null && this.afa != null && this.afa.aeL != null) {
            s.aT(this.mContext, this.afa.aeL);
            if (this.afb != null) {
                this.afb.b(this.afa);
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
        if (this.aeX != null) {
            clearAnimation();
            startAnimation(this.aeX);
        }
    }

    public void dismiss() {
        if (this.aeY != null) {
            clearAnimation();
            startAnimation(this.aeY);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aeZ = false;
        this.afa = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afc, afd);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = afe;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afc, afd);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, afe);
            setLayoutParams(layoutParams2);
        }
        if (this.afb != null) {
            this.afb.a(aVar);
        }
    }

    public void sZ() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afb = aVar;
    }
}
