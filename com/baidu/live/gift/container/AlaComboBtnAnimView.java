package com.baidu.live.gift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.sdk.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes7.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout aPI;
    private View aPJ;
    private Animation aPK;
    private ScaleAnimation aPL;
    private LottieAnimationView aPM;
    private View aPN;
    private ObjectAnimator aPO;
    private ImageView aPP;
    private AnimatorSet aPQ;
    private ObjectAnimator aPR;
    private long aPS;
    private boolean aPT;
    private a aPU;
    private AlaRoundProgress aPV;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void Fy();
    }

    public AlaComboBtnAnimView(Context context) {
        this(context, null);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.h.ala_combo_btn_anim_view, this);
        this.aPN = findViewById(a.g.combo_container);
        this.aPV = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aPI = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aPI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aPP = (ImageView) findViewById(a.g.combo_text_icon);
        this.aPJ = findViewById(a.g.combo_bg);
        this.aPK = AnimationUtils.loadAnimation(this.mContext, a.C0185a.ala_gift_rotate_anim);
        this.aPK.setInterpolator(new LinearInterpolator());
        this.aPL = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0185a.ala_gift_scale_anim);
        this.aPM = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aPM.setAnimation("ala_gift_combo_balloon.json");
        this.aPM.loop(false);
        this.aPV.setMax(100);
        this.aPV.setProgress(0);
        this.aPO = ObjectAnimator.ofInt(this.aPV, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aPO.setInterpolator(new LinearInterpolator());
        this.aPO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aPO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aPN.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aPU != null) {
                    AlaComboBtnAnimView.this.aPU.Fy();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aPI, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aPR = ObjectAnimator.ofFloat(this.aPI, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aPR.setRepeatCount(0);
        this.aPR.setDuration(1000L);
        this.aPQ = new AnimatorSet();
        this.aPQ.play(ofFloat).with(this.aPR);
        this.aPR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aPT) {
                    AlaComboBtnAnimView.this.aPI.startAnimation(AlaComboBtnAnimView.this.aPL);
                }
            }
        });
    }

    public void Fu() {
        this.aPT = System.currentTimeMillis() - this.aPS < 1010;
        this.aPS = System.currentTimeMillis();
        this.aPL.cancel();
        if (this.aPQ.isRunning()) {
            this.aPQ.cancel();
        }
        this.aPQ.start();
        this.aPM.playAnimation();
        this.aPO.start();
    }

    public void Fv() {
        this.aPN.setVisibility(0);
        this.aPJ.startAnimation(this.aPK);
        this.aPI.startAnimation(this.aPL);
        this.aPO.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aPI != null) {
            this.aPI.setOnClickListener(onClickListener);
        }
    }

    public void Fw() {
        this.aPK.cancel();
        this.aPL.cancel();
        if (this.aPO.isRunning()) {
            this.aPO.cancel();
        }
        if (this.aPQ.isRunning()) {
            this.aPQ.cancel();
        }
        if (this.aPM.isAnimating()) {
            this.aPM.cancelAnimation();
        }
        this.aPN.setVisibility(8);
        if (this.aPU != null) {
            this.aPU.Fy();
        }
    }

    public void setComboListener(a aVar) {
        this.aPU = aVar;
    }

    public boolean Fx() {
        return this.aPN == null || this.aPN.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Fw();
        } catch (Exception e) {
        }
    }
}
