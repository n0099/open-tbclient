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
    private RelativeLayout aGB;
    private View aGC;
    private Animation aGD;
    private ScaleAnimation aGE;
    private LottieAnimationView aGF;
    private View aGG;
    private ObjectAnimator aGH;
    private ImageView aGI;
    private AnimatorSet aGJ;
    private ObjectAnimator aGK;
    private long aGL;
    private boolean aGM;
    private a aGN;
    private AlaRoundProgress aGO;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void yT();
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
        this.aGG = findViewById(a.g.combo_container);
        this.aGO = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aGB = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aGB.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aGI = (ImageView) findViewById(a.g.combo_text_icon);
        this.aGC = findViewById(a.g.combo_bg);
        this.aGD = AnimationUtils.loadAnimation(this.mContext, a.C0182a.ala_gift_rotate_anim);
        this.aGD.setInterpolator(new LinearInterpolator());
        this.aGE = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0182a.ala_gift_scale_anim);
        this.aGF = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aGF.setAnimation("ala_gift_combo_balloon.json");
        this.aGF.loop(false);
        this.aGO.setMax(100);
        this.aGO.setProgress(0);
        this.aGH = ObjectAnimator.ofInt(this.aGO, "progress", 100).setDuration(3000L);
        this.aGH.setInterpolator(new LinearInterpolator());
        this.aGH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aGH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aGG.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aGN != null) {
                    AlaComboBtnAnimView.this.aGN.yT();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aGB, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aGK = ObjectAnimator.ofFloat(this.aGB, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aGK.setRepeatCount(0);
        this.aGK.setDuration(1000L);
        this.aGJ = new AnimatorSet();
        this.aGJ.play(ofFloat).with(this.aGK);
        this.aGK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aGM) {
                    AlaComboBtnAnimView.this.aGB.startAnimation(AlaComboBtnAnimView.this.aGE);
                }
            }
        });
    }

    public void yP() {
        this.aGM = System.currentTimeMillis() - this.aGL < 1010;
        this.aGL = System.currentTimeMillis();
        this.aGE.cancel();
        if (this.aGJ.isRunning()) {
            this.aGJ.cancel();
        }
        this.aGJ.start();
        this.aGF.playAnimation();
        this.aGH.start();
    }

    public void yQ() {
        this.aGG.setVisibility(0);
        this.aGC.startAnimation(this.aGD);
        this.aGB.startAnimation(this.aGE);
        this.aGH.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aGB != null) {
            this.aGB.setOnClickListener(onClickListener);
        }
    }

    public void yR() {
        this.aGD.cancel();
        this.aGE.cancel();
        if (this.aGH.isRunning()) {
            this.aGH.cancel();
        }
        if (this.aGJ.isRunning()) {
            this.aGJ.cancel();
        }
        if (this.aGF.isAnimating()) {
            this.aGF.cancelAnimation();
        }
        this.aGG.setVisibility(8);
        if (this.aGN != null) {
            this.aGN.yT();
        }
    }

    public void setComboListener(a aVar) {
        this.aGN = aVar;
    }

    public boolean yS() {
        return this.aGG == null || this.aGG.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            yR();
        } catch (Exception e) {
        }
    }
}
