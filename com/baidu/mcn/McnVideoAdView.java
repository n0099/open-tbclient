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
    private static final int afp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int afq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int afr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float NT;
    private float NU;
    private TbImageView afh;
    private TextView afi;
    private TextView afj;
    private Animation afk;
    private Animation afl;
    private boolean afm;
    private com.baidu.mcn.a afn;
    private a afo;
    private ViewParent afs;
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
        this.afm = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.afm = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.afm = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.afh = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.afi = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.afj = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.afh.setConrers(5);
        this.afh.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.afh.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.afh.setRadius(l.g(this.mContext, R.dimen.tbds20));
        this.afk = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.afl = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.afl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.afn = aVar;
            this.afh.startLoad(aVar.aeV, 10, false);
            if (!StringUtils.isNull(aVar.aeW)) {
                this.afi.setText(aVar.aeW);
            }
            if (!StringUtils.isNull(aVar.aeX)) {
                this.afj.setText(aVar.aeX);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.NT = motionEvent.getX();
                this.NU = motionEvent.getY();
                this.afs = getParent();
                if (this.afs != null) {
                    this.afs.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                tL();
                if (Math.abs(motionEvent.getX() - this.NT) < 5.0f && Math.abs(motionEvent.getY() - this.NU) < 5.0f) {
                    tM();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.NT > 10.0f && this.isShowing) {
                    this.afm = true;
                    dismiss();
                    if (this.afo != null) {
                        this.afo.c(this.afn);
                        break;
                    }
                }
                break;
            case 3:
                tL();
                break;
        }
        return true;
    }

    private void tL() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.afs != null) {
                    McnVideoAdView.this.afs.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.afs = null;
                }
            }
        }, 500L);
    }

    private void tM() {
        if (this.mContext != null && this.afn != null && this.afn.aeY != null) {
            s.aG(this.mContext, this.afn.aeY);
            if (this.afo != null) {
                this.afo.b(this.afn);
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
        if (this.afk != null) {
            clearAnimation();
            startAnimation(this.afk);
        }
    }

    public void dismiss() {
        if (this.afl != null) {
            clearAnimation();
            startAnimation(this.afl);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.afm = false;
        this.afn = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(afp, afq);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = afr;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(afp, afq);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, afr);
            setLayoutParams(layoutParams2);
        }
        if (this.afo != null) {
            this.afo.a(aVar);
        }
    }

    public void tK() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.afo = aVar;
    }
}
