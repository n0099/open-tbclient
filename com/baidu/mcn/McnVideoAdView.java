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
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class McnVideoAdView extends FrameLayout {
    private static final int bub = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int buc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bud = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float VU;
    private float VV;
    private TbImageView btT;
    private TextView btU;
    private TextView btV;
    private Animation btW;
    private Animation btX;
    private boolean btY;
    private com.baidu.mcn.a btZ;
    private a bua;
    private ViewParent bue;
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
        this.btY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.btY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.btY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.btT = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.btU = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.btV = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.btT.setConrers(5);
        this.btT.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.btT.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.btT.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.btW = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.btX = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.btX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.btZ = aVar;
            this.btT.startLoad(aVar.btI, 10, false);
            if (!StringUtils.isNull(aVar.btJ)) {
                this.btU.setText(aVar.btJ);
            }
            if (!StringUtils.isNull(aVar.btK)) {
                this.btV.setText(aVar.btK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.VU = motionEvent.getX();
                this.VV = motionEvent.getY();
                this.bue = getParent();
                if (this.bue != null) {
                    this.bue.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                MI();
                if (Math.abs(motionEvent.getX() - this.VU) < 5.0f && Math.abs(motionEvent.getY() - this.VV) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.VU > 10.0f && this.isShowing) {
                    this.btY = true;
                    dismiss();
                    if (this.bua != null) {
                        this.bua.c(this.btZ);
                        break;
                    }
                }
                break;
            case 3:
                MI();
                break;
        }
        return true;
    }

    private void MI() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bue != null) {
                    McnVideoAdView.this.bue.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bue = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.btZ != null && this.btZ.btL != null) {
            r.aO(this.mContext, this.btZ.btL);
            if (this.bua != null) {
                this.bua.b(this.btZ);
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
        if (this.btW != null) {
            clearAnimation();
            startAnimation(this.btW);
        }
    }

    public void dismiss() {
        if (this.btX != null) {
            clearAnimation();
            startAnimation(this.btX);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.btY = false;
        this.btZ = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bub, buc);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bud;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bub, buc);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bud);
            setLayoutParams(layoutParams2);
        }
        if (this.bua != null) {
            this.bua.a(aVar);
        }
    }

    public void MH() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bua = aVar;
    }
}
