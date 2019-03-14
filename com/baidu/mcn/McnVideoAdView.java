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
    private static final int afd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds626);
    private static final int afe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds156);
    private static final int aff = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112);
    private float Ql;
    private float Qm;
    private TbImageView aeV;
    private TextView aeW;
    private TextView aeX;
    private Animation aeY;
    private Animation aeZ;
    private boolean afa;
    private com.baidu.mcn.a afb;
    private a afc;
    private ViewParent afg;
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
        this.afa = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.afa = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.afa = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.mcn_video_ad_layout, this);
        this.aeV = (TbImageView) findViewById(d.g.id_mcn_video_ad_image);
        this.aeW = (TextView) findViewById(d.g.id_mcn_video_ad_title);
        this.aeX = (TextView) findViewById(d.g.id_mcn_video_ad_jump_btn);
        this.aeV.setConrers(5);
        this.aeV.setDefaultResource(d.f.mcn_video_ad_default_img_bg);
        this.aeV.setDefaultBgResource(d.f.mcn_video_ad_default_img_bg);
        this.aeV.setRadius(l.h(this.mContext, d.e.tbds20));
        this.aeY = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_open_anim);
        this.aeZ = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_close_anim);
        this.aeZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afb = aVar;
            this.aeV.startLoad(aVar.aeJ, 10, false);
            if (!StringUtils.isNull(aVar.aeK)) {
                this.aeW.setText(aVar.aeK);
            }
            if (!StringUtils.isNull(aVar.aeL)) {
                this.aeX.setText(aVar.aeL);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Ql = motionEvent.getX();
                this.Qm = motionEvent.getY();
                this.afg = getParent();
                if (this.afg != null) {
                    this.afg.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ta();
                if (Math.abs(motionEvent.getX() - this.Ql) < 5.0f && Math.abs(motionEvent.getY() - this.Qm) < 5.0f) {
                    tb();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.Ql > 10.0f && this.isShowing) {
                    this.afa = true;
                    dismiss();
                    if (this.afc != null) {
                        this.afc.c(this.afb);
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
                if (McnVideoAdView.this.afg != null) {
                    McnVideoAdView.this.afg.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.afg = null;
                }
            }
        }, 500L);
    }

    private void tb() {
        if (this.mContext != null && this.afb != null && this.afb.aeM != null) {
            s.aS(this.mContext, this.afb.aeM);
            if (this.afc != null) {
                this.afc.b(this.afb);
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
        if (this.aeY != null) {
            clearAnimation();
            startAnimation(this.aeY);
        }
    }

    public void dismiss() {
        if (this.aeZ != null) {
            clearAnimation();
            startAnimation(this.aeZ);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.afa = false;
        this.afb = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afd, afe);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = aff;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afd, afe);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, aff);
            setLayoutParams(layoutParams2);
        }
        if (this.afc != null) {
            this.afc.a(aVar);
        }
    }

    public void sZ() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afc = aVar;
    }
}
