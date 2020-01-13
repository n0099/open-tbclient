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
import com.baidu.live.r.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private a agA;
    private AlaRoundProgress agB;
    private RelativeLayout ago;
    private View agp;
    private Animation agq;
    private ScaleAnimation agr;
    private LottieAnimationView ags;
    private View agt;
    private ObjectAnimator agu;
    private ImageView agv;
    private AnimatorSet agw;
    private ObjectAnimator agx;
    private long agy;
    private boolean agz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void rY();
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
        this.agt = findViewById(a.g.combo_container);
        this.agB = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.ago = (RelativeLayout) findViewById(a.g.combo_btn);
        this.ago.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.agv = (ImageView) findViewById(a.g.combo_text_icon);
        this.agp = findViewById(a.g.combo_bg);
        this.agq = AnimationUtils.loadAnimation(this.mContext, a.C0086a.ala_gift_rotate_anim);
        this.agq.setInterpolator(new LinearInterpolator());
        this.agr = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0086a.ala_gift_scale_anim);
        this.ags = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.ags.setAnimation("ala_gift_combo_balloon.json");
        this.ags.loop(false);
        this.agB.setMax(100);
        this.agB.setProgress(0);
        this.agu = ObjectAnimator.ofInt(this.agB, "progress", 100).setDuration(3000L);
        this.agu.setInterpolator(new LinearInterpolator());
        this.agu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.agu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.agt.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.agA != null) {
                    AlaComboBtnAnimView.this.agA.rY();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ago, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.agx = ObjectAnimator.ofFloat(this.ago, "scaleY", 1.0f, 0.8f, 1.0f);
        this.agx.setRepeatCount(0);
        this.agx.setDuration(1000L);
        this.agw = new AnimatorSet();
        this.agw.play(ofFloat).with(this.agx);
        this.agx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.agz) {
                    AlaComboBtnAnimView.this.ago.startAnimation(AlaComboBtnAnimView.this.agr);
                }
            }
        });
    }

    public void rU() {
        this.agz = System.currentTimeMillis() - this.agy < 1010;
        this.agy = System.currentTimeMillis();
        this.agr.cancel();
        if (this.agw.isRunning()) {
            this.agw.cancel();
        }
        this.agw.start();
        this.ags.playAnimation();
        this.agu.start();
    }

    public void rV() {
        this.agt.setVisibility(0);
        this.agp.startAnimation(this.agq);
        this.ago.startAnimation(this.agr);
        this.agu.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.ago != null) {
            this.ago.setOnClickListener(onClickListener);
        }
    }

    public void rW() {
        this.agq.cancel();
        this.agr.cancel();
        if (this.agu.isRunning()) {
            this.agu.cancel();
        }
        if (this.agw.isRunning()) {
            this.agw.cancel();
        }
        if (this.ags.isAnimating()) {
            this.ags.cancelAnimation();
        }
        this.agt.setVisibility(8);
        if (this.agA != null) {
            this.agA.rY();
        }
    }

    public void setComboListener(a aVar) {
        this.agA = aVar;
    }

    public boolean rX() {
        return this.agt == null || this.agt.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            rW();
        } catch (Exception e) {
        }
    }
}
