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
    private static final int afj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds626);
    private static final int afk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds156);
    private static final int afl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112);
    private float Ql;
    private float Qm;
    private TbImageView afb;
    private TextView afc;
    private TextView afd;
    private Animation afe;
    private Animation aff;
    private boolean afg;
    private com.baidu.mcn.a afh;
    private a afi;
    private ViewParent afm;
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
        this.afg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.afg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.afg = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.mcn_video_ad_layout, this);
        this.afb = (TbImageView) findViewById(d.g.id_mcn_video_ad_image);
        this.afc = (TextView) findViewById(d.g.id_mcn_video_ad_title);
        this.afd = (TextView) findViewById(d.g.id_mcn_video_ad_jump_btn);
        this.afb.setConrers(5);
        this.afb.setDefaultResource(d.f.mcn_video_ad_default_img_bg);
        this.afb.setDefaultBgResource(d.f.mcn_video_ad_default_img_bg);
        this.afb.setRadius(l.h(this.mContext, d.e.tbds20));
        this.afe = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_open_anim);
        this.aff = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_close_anim);
        this.aff.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afh = aVar;
            this.afb.startLoad(aVar.aeP, 10, false);
            if (!StringUtils.isNull(aVar.aeQ)) {
                this.afc.setText(aVar.aeQ);
            }
            if (!StringUtils.isNull(aVar.aeR)) {
                this.afd.setText(aVar.aeR);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Ql = motionEvent.getX();
                this.Qm = motionEvent.getY();
                this.afm = getParent();
                if (this.afm != null) {
                    this.afm.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                sZ();
                if (Math.abs(motionEvent.getX() - this.Ql) < 5.0f && Math.abs(motionEvent.getY() - this.Qm) < 5.0f) {
                    ta();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.Ql > 10.0f && this.isShowing) {
                    this.afg = true;
                    dismiss();
                    if (this.afi != null) {
                        this.afi.c(this.afh);
                        break;
                    }
                }
                break;
            case 3:
                sZ();
                break;
        }
        return true;
    }

    private void sZ() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.afm != null) {
                    McnVideoAdView.this.afm.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.afm = null;
                }
            }
        }, 500L);
    }

    private void ta() {
        if (this.mContext != null && this.afh != null && this.afh.aeS != null) {
            s.aS(this.mContext, this.afh.aeS);
            if (this.afi != null) {
                this.afi.b(this.afh);
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
        if (this.afe != null) {
            clearAnimation();
            startAnimation(this.afe);
        }
    }

    public void dismiss() {
        if (this.aff != null) {
            clearAnimation();
            startAnimation(this.aff);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.afg = false;
        this.afh = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afj, afk);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = afl;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afj, afk);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, afl);
            setLayoutParams(layoutParams2);
        }
        if (this.afi != null) {
            this.afi.a(aVar);
        }
    }

    public void sY() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afi = aVar;
    }
}
