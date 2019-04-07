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
    private static final int afi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds626);
    private static final int afj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds156);
    private static final int afk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds112);
    private float Ql;
    private float Qm;
    private TbImageView afa;
    private TextView afb;
    private TextView afc;
    private Animation afd;
    private Animation afe;
    private boolean aff;
    private com.baidu.mcn.a afg;
    private a afh;
    private ViewParent afl;
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
        this.aff = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.aff = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.aff = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(d.h.mcn_video_ad_layout, this);
        this.afa = (TbImageView) findViewById(d.g.id_mcn_video_ad_image);
        this.afb = (TextView) findViewById(d.g.id_mcn_video_ad_title);
        this.afc = (TextView) findViewById(d.g.id_mcn_video_ad_jump_btn);
        this.afa.setConrers(5);
        this.afa.setDefaultResource(d.f.mcn_video_ad_default_img_bg);
        this.afa.setDefaultBgResource(d.f.mcn_video_ad_default_img_bg);
        this.afa.setRadius(l.h(this.mContext, d.e.tbds20));
        this.afd = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_open_anim);
        this.afe = AnimationUtils.loadAnimation(this.mContext, d.a.mcn_video_ad_close_anim);
        this.afe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afg = aVar;
            this.afa.startLoad(aVar.aeO, 10, false);
            if (!StringUtils.isNull(aVar.aeP)) {
                this.afb.setText(aVar.aeP);
            }
            if (!StringUtils.isNull(aVar.aeQ)) {
                this.afc.setText(aVar.aeQ);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Ql = motionEvent.getX();
                this.Qm = motionEvent.getY();
                this.afl = getParent();
                if (this.afl != null) {
                    this.afl.requestDisallowInterceptTouchEvent(true);
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
                    this.aff = true;
                    dismiss();
                    if (this.afh != null) {
                        this.afh.c(this.afg);
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
                if (McnVideoAdView.this.afl != null) {
                    McnVideoAdView.this.afl.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.afl = null;
                }
            }
        }, 500L);
    }

    private void ta() {
        if (this.mContext != null && this.afg != null && this.afg.aeR != null) {
            s.aS(this.mContext, this.afg.aeR);
            if (this.afh != null) {
                this.afh.b(this.afg);
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
        if (this.afd != null) {
            clearAnimation();
            startAnimation(this.afd);
        }
    }

    public void dismiss() {
        if (this.afe != null) {
            clearAnimation();
            startAnimation(this.afe);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.aff = false;
        this.afg = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afi, afj);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = afk;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afi, afj);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, afk);
            setLayoutParams(layoutParams2);
        }
        if (this.afh != null) {
            this.afh.a(aVar);
        }
    }

    public void sY() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afh = aVar;
    }
}
