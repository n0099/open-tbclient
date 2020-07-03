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
/* loaded from: classes3.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout aIZ;
    private View aJa;
    private Animation aJb;
    private ScaleAnimation aJc;
    private LottieAnimationView aJd;
    private View aJe;
    private ObjectAnimator aJf;
    private ImageView aJg;
    private AnimatorSet aJh;
    private ObjectAnimator aJi;
    private long aJj;
    private boolean aJk;
    private a aJl;
    private AlaRoundProgress aJm;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void zt();
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
        this.aJe = findViewById(a.g.combo_container);
        this.aJm = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aIZ = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aIZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aJg = (ImageView) findViewById(a.g.combo_text_icon);
        this.aJa = findViewById(a.g.combo_bg);
        this.aJb = AnimationUtils.loadAnimation(this.mContext, a.C0176a.ala_gift_rotate_anim);
        this.aJb.setInterpolator(new LinearInterpolator());
        this.aJc = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0176a.ala_gift_scale_anim);
        this.aJd = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aJd.setAnimation("ala_gift_combo_balloon.json");
        this.aJd.loop(false);
        this.aJm.setMax(100);
        this.aJm.setProgress(0);
        this.aJf = ObjectAnimator.ofInt(this.aJm, "progress", 100).setDuration(3000L);
        this.aJf.setInterpolator(new LinearInterpolator());
        this.aJf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aJf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aJe.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aJl != null) {
                    AlaComboBtnAnimView.this.aJl.zt();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aIZ, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aJi = ObjectAnimator.ofFloat(this.aIZ, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aJi.setRepeatCount(0);
        this.aJi.setDuration(1000L);
        this.aJh = new AnimatorSet();
        this.aJh.play(ofFloat).with(this.aJi);
        this.aJi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aJk) {
                    AlaComboBtnAnimView.this.aIZ.startAnimation(AlaComboBtnAnimView.this.aJc);
                }
            }
        });
    }

    public void zp() {
        this.aJk = System.currentTimeMillis() - this.aJj < 1010;
        this.aJj = System.currentTimeMillis();
        this.aJc.cancel();
        if (this.aJh.isRunning()) {
            this.aJh.cancel();
        }
        this.aJh.start();
        this.aJd.playAnimation();
        this.aJf.start();
    }

    public void zq() {
        this.aJe.setVisibility(0);
        this.aJa.startAnimation(this.aJb);
        this.aIZ.startAnimation(this.aJc);
        this.aJf.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aIZ != null) {
            this.aIZ.setOnClickListener(onClickListener);
        }
    }

    public void zr() {
        this.aJb.cancel();
        this.aJc.cancel();
        if (this.aJf.isRunning()) {
            this.aJf.cancel();
        }
        if (this.aJh.isRunning()) {
            this.aJh.cancel();
        }
        if (this.aJd.isAnimating()) {
            this.aJd.cancelAnimation();
        }
        this.aJe.setVisibility(8);
        if (this.aJl != null) {
            this.aJl.zt();
        }
    }

    public void setComboListener(a aVar) {
        this.aJl = aVar;
    }

    public boolean zs() {
        return this.aJe == null || this.aJe.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            zr();
        } catch (Exception e) {
        }
    }
}
