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
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private ScaleAnimation aiA;
    private LottieAnimationView aiB;
    private View aiC;
    private ObjectAnimator aiD;
    private ImageView aiE;
    private AnimatorSet aiF;
    private ObjectAnimator aiG;
    private long aiH;
    private boolean aiI;
    private a aiJ;
    private AlaRoundProgress aiK;
    private RelativeLayout aix;
    private View aiy;
    private Animation aiz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void tj();
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
        this.aiC = findViewById(a.g.combo_container);
        this.aiK = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aix = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aix.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aiE = (ImageView) findViewById(a.g.combo_text_icon);
        this.aiy = findViewById(a.g.combo_bg);
        this.aiz = AnimationUtils.loadAnimation(this.mContext, a.C0102a.ala_gift_rotate_anim);
        this.aiz.setInterpolator(new LinearInterpolator());
        this.aiA = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0102a.ala_gift_scale_anim);
        this.aiB = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aiB.setAnimation("ala_gift_combo_balloon.json");
        this.aiB.loop(false);
        this.aiK.setMax(100);
        this.aiK.setProgress(0);
        this.aiD = ObjectAnimator.ofInt(this.aiK, "progress", 100).setDuration(3000L);
        this.aiD.setInterpolator(new LinearInterpolator());
        this.aiD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aiD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aiC.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aiJ != null) {
                    AlaComboBtnAnimView.this.aiJ.tj();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aix, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aiG = ObjectAnimator.ofFloat(this.aix, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aiG.setRepeatCount(0);
        this.aiG.setDuration(1000L);
        this.aiF = new AnimatorSet();
        this.aiF.play(ofFloat).with(this.aiG);
        this.aiG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aiI) {
                    AlaComboBtnAnimView.this.aix.startAnimation(AlaComboBtnAnimView.this.aiA);
                }
            }
        });
    }

    public void tf() {
        this.aiI = System.currentTimeMillis() - this.aiH < 1010;
        this.aiH = System.currentTimeMillis();
        this.aiA.cancel();
        if (this.aiF.isRunning()) {
            this.aiF.cancel();
        }
        this.aiF.start();
        this.aiB.playAnimation();
        this.aiD.start();
    }

    public void tg() {
        this.aiC.setVisibility(0);
        this.aiy.startAnimation(this.aiz);
        this.aix.startAnimation(this.aiA);
        this.aiD.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aix != null) {
            this.aix.setOnClickListener(onClickListener);
        }
    }

    public void th() {
        this.aiz.cancel();
        this.aiA.cancel();
        if (this.aiD.isRunning()) {
            this.aiD.cancel();
        }
        if (this.aiF.isRunning()) {
            this.aiF.cancel();
        }
        if (this.aiB.isAnimating()) {
            this.aiB.cancelAnimation();
        }
        this.aiC.setVisibility(8);
        if (this.aiJ != null) {
            this.aiJ.tj();
        }
    }

    public void setComboListener(a aVar) {
        this.aiJ = aVar;
    }

    public boolean ti() {
        return this.aiC == null || this.aiC.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            th();
        } catch (Exception e) {
        }
    }
}
