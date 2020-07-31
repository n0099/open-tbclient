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
    private float VM;
    private float VN;
    private ViewParent buB;
    private TbImageView buq;
    private TextView bur;
    private TextView bus;
    private Animation but;
    private Animation buu;
    private boolean buv;
    private com.baidu.mcn.a buw;
    private a bux;
    private boolean isShowing;
    private Context mContext;
    private final Handler mHandler;
    private static final int buy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int buz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int buA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.mcn.a aVar);

        void b(com.baidu.mcn.a aVar);

        void c(com.baidu.mcn.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.isShowing = false;
        this.buv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.buv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.buv = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.buq = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.bur = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.bus = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.buq.setConrers(5);
        this.buq.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.buq.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.buq.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.but = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.buu = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.buu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.buw = aVar;
            this.buq.startLoad(aVar.bue, 10, false);
            if (!StringUtils.isNull(aVar.bug)) {
                this.bur.setText(aVar.bug);
            }
            if (!StringUtils.isNull(aVar.buh)) {
                this.bus.setText(aVar.buh);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.VM = motionEvent.getX();
                this.VN = motionEvent.getY();
                this.buB = getParent();
                if (this.buB != null) {
                    this.buB.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                MP();
                if (Math.abs(motionEvent.getX() - this.VM) < 5.0f && Math.abs(motionEvent.getY() - this.VN) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.VM > 10.0f && this.isShowing) {
                    this.buv = true;
                    dismiss();
                    if (this.bux != null) {
                        this.bux.c(this.buw);
                        break;
                    }
                }
                break;
            case 3:
                MP();
                break;
        }
        return true;
    }

    private void MP() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.buB != null) {
                    McnVideoAdView.this.buB.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.buB = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.buw != null && this.buw.bui != null) {
            s.aN(this.mContext, this.buw.bui);
            if (this.bux != null) {
                this.bux.b(this.buw);
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
        if (this.but != null) {
            clearAnimation();
            startAnimation(this.but);
        }
    }

    public void dismiss() {
        if (this.buu != null) {
            clearAnimation();
            startAnimation(this.buu);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.buv = false;
        this.buw = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(buy, buz);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = buA;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(buy, buz);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, buA);
            setLayoutParams(layoutParams2);
        }
        if (this.bux != null) {
            this.bux.a(aVar);
        }
    }

    public void MO() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bux = aVar;
    }
}
