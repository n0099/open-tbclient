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
    private static final int azk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int azl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int azm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private boolean abS;
    private TbImageView azc;
    private TextView azd;
    private TextView aze;
    private Animation azf;
    private Animation azg;
    private boolean azh;
    private com.baidu.mcn.a azi;
    private a azj;
    private ViewParent azn;
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
        this.abS = false;
        this.azh = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abS = false;
        this.azh = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abS = false;
        this.azh = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.azc = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.azd = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.aze = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.azc.setConrers(5);
        this.azc.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.azc.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.azc.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.azf = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.azg = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.azg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.azi = aVar;
            this.azc.startLoad(aVar.ayQ, 10, false);
            if (!StringUtils.isNull(aVar.ayR)) {
                this.azd.setText(aVar.ayR);
            }
            if (!StringUtils.isNull(aVar.ayS)) {
                this.aze.setText(aVar.ayS);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.azn = getParent();
                if (this.azn != null) {
                    this.azn.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                zf();
                if (Math.abs(motionEvent.getX() - this.mLastX) < 5.0f && Math.abs(motionEvent.getY() - this.mLastY) < 5.0f) {
                    zg();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.mLastX > 10.0f && this.abS) {
                    this.azh = true;
                    dismiss();
                    if (this.azj != null) {
                        this.azj.c(this.azi);
                        break;
                    }
                }
                break;
            case 3:
                zf();
                break;
        }
        return true;
    }

    private void zf() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.azn != null) {
                    McnVideoAdView.this.azn.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.azn = null;
                }
            }
        }, 500L);
    }

    private void zg() {
        if (this.mContext != null && this.azi != null && this.azi.ayT != null) {
            s.aL(this.mContext, this.azi.ayT);
            if (this.azj != null) {
                this.azj.b(this.azi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeView() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
            this.abS = false;
        }
    }

    public void a(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        b(aVar, viewGroup);
        if (this.azf != null) {
            clearAnimation();
            startAnimation(this.azf);
        }
    }

    public void dismiss() {
        if (this.azg != null) {
            clearAnimation();
            startAnimation(this.azg);
        }
    }

    public boolean isShowing() {
        return this.abS;
    }

    public void reset() {
        removeView();
        this.abS = false;
        this.azh = false;
        this.azi = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.abS = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(azk, azl);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = azm;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(azk, azl);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, azm);
            setLayoutParams(layoutParams2);
        }
        if (this.azj != null) {
            this.azj.a(aVar);
        }
    }

    public void ze() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.azj = aVar;
    }
}
