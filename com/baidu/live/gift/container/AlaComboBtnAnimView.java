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
import com.baidu.live.sdk.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private View aKA;
    private ObjectAnimator aKB;
    private ImageView aKC;
    private AnimatorSet aKD;
    private ObjectAnimator aKE;
    private long aKF;
    private boolean aKG;
    private a aKH;
    private AlaRoundProgress aKI;
    private RelativeLayout aKv;
    private View aKw;
    private Animation aKx;
    private ScaleAnimation aKy;
    private LottieAnimationView aKz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void zV();
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
        this.aKA = findViewById(a.g.combo_container);
        this.aKI = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aKv = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aKv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aKC = (ImageView) findViewById(a.g.combo_text_icon);
        this.aKw = findViewById(a.g.combo_bg);
        this.aKx = AnimationUtils.loadAnimation(this.mContext, a.C0178a.ala_gift_rotate_anim);
        this.aKx.setInterpolator(new LinearInterpolator());
        this.aKy = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0178a.ala_gift_scale_anim);
        this.aKz = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aKz.setAnimation("ala_gift_combo_balloon.json");
        this.aKz.loop(false);
        this.aKI.setMax(100);
        this.aKI.setProgress(0);
        this.aKB = ObjectAnimator.ofInt(this.aKI, "progress", 100).setDuration(3000L);
        this.aKB.setInterpolator(new LinearInterpolator());
        this.aKB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aKB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aKA.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aKH != null) {
                    AlaComboBtnAnimView.this.aKH.zV();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aKv, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aKE = ObjectAnimator.ofFloat(this.aKv, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aKE.setRepeatCount(0);
        this.aKE.setDuration(1000L);
        this.aKD = new AnimatorSet();
        this.aKD.play(ofFloat).with(this.aKE);
        this.aKE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aKG) {
                    AlaComboBtnAnimView.this.aKv.startAnimation(AlaComboBtnAnimView.this.aKy);
                }
            }
        });
    }

    public void zR() {
        this.aKG = System.currentTimeMillis() - this.aKF < 1010;
        this.aKF = System.currentTimeMillis();
        this.aKy.cancel();
        if (this.aKD.isRunning()) {
            this.aKD.cancel();
        }
        this.aKD.start();
        this.aKz.playAnimation();
        this.aKB.start();
    }

    public void zS() {
        this.aKA.setVisibility(0);
        this.aKw.startAnimation(this.aKx);
        this.aKv.startAnimation(this.aKy);
        this.aKB.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aKv != null) {
            this.aKv.setOnClickListener(onClickListener);
        }
    }

    public void zT() {
        this.aKx.cancel();
        this.aKy.cancel();
        if (this.aKB.isRunning()) {
            this.aKB.cancel();
        }
        if (this.aKD.isRunning()) {
            this.aKD.cancel();
        }
        if (this.aKz.isAnimating()) {
            this.aKz.cancelAnimation();
        }
        this.aKA.setVisibility(8);
        if (this.aKH != null) {
            this.aKH.zV();
        }
    }

    public void setComboListener(a aVar) {
        this.aKH = aVar;
    }

    public boolean zU() {
        return this.aKA == null || this.aKA.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            zT();
        } catch (Exception e) {
        }
    }
}
