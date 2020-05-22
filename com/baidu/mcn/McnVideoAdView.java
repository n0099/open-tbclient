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
    private static final int bpb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    private static final int bpc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    private static final int bpd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);
    private float Vq;
    private float Vr;
    private TbImageView boT;
    private TextView boU;
    private TextView boV;
    private Animation boW;
    private Animation boX;
    private boolean boY;
    private com.baidu.mcn.a boZ;
    private a bpa;
    private ViewParent bpe;
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
        this.boY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isShowing = false;
        this.boY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isShowing = false;
        this.boY = false;
        this.mHandler = new Handler();
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.mcn_video_ad_layout, this);
        this.boT = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.boU = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.boV = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.boT.setConrers(5);
        this.boT.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.boT.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.boT.setRadius(l.getDimens(this.mContext, R.dimen.tbds20));
        this.boW = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_open_anim);
        this.boX = AnimationUtils.loadAnimation(this.mContext, R.anim.mcn_video_ad_close_anim);
        this.boX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.mcn.McnVideoAdView.1
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
            this.boZ = aVar;
            this.boT.startLoad(aVar.boI, 10, false);
            if (!StringUtils.isNull(aVar.boJ)) {
                this.boU.setText(aVar.boJ);
            }
            if (!StringUtils.isNull(aVar.boK)) {
                this.boV.setText(aVar.boK);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.Vq = motionEvent.getX();
                this.Vr = motionEvent.getY();
                this.bpe = getParent();
                if (this.bpe != null) {
                    this.bpe.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                Lz();
                if (Math.abs(motionEvent.getX() - this.Vq) < 5.0f && Math.abs(motionEvent.getY() - this.Vr) < 5.0f) {
                    click();
                    break;
                }
                break;
            case 2:
                if (motionEvent.getX() - this.Vq > 10.0f && this.isShowing) {
                    this.boY = true;
                    dismiss();
                    if (this.bpa != null) {
                        this.bpa.c(this.boZ);
                        break;
                    }
                }
                break;
            case 3:
                Lz();
                break;
        }
        return true;
    }

    private void Lz() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.mcn.McnVideoAdView.2
            @Override // java.lang.Runnable
            public void run() {
                if (McnVideoAdView.this.bpe != null) {
                    McnVideoAdView.this.bpe.requestDisallowInterceptTouchEvent(false);
                    McnVideoAdView.this.bpe = null;
                }
            }
        }, 500L);
    }

    private void click() {
        if (this.mContext != null && this.boZ != null && this.boZ.boL != null) {
            r.aO(this.mContext, this.boZ.boL);
            if (this.bpa != null) {
                this.bpa.b(this.boZ);
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
        if (this.boW != null) {
            clearAnimation();
            startAnimation(this.boW);
        }
    }

    public void dismiss() {
        if (this.boX != null) {
            clearAnimation();
            startAnimation(this.boX);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void reset() {
        removeView();
        this.isShowing = false;
        this.boY = false;
        this.boZ = null;
    }

    public void b(com.baidu.mcn.a aVar, ViewGroup viewGroup) {
        this.isShowing = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bpb, bpc);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = bpd;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bpb, bpc);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, bpd);
            setLayoutParams(layoutParams2);
        }
        if (this.bpa != null) {
            this.bpa.a(aVar);
        }
    }

    public void Ly() {
        removeView();
    }

    public void setIMcnStatListener(a aVar) {
        this.bpa = aVar;
    }
}
