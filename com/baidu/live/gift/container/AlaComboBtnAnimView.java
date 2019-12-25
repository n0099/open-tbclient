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
import com.baidu.live.q.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout afE;
    private View afF;
    private Animation afG;
    private ScaleAnimation afH;
    private LottieAnimationView afI;
    private View afJ;
    private ObjectAnimator afK;
    private ImageView afL;
    private AnimatorSet afM;
    private ObjectAnimator afN;
    private long afO;
    private boolean afP;
    private a afQ;
    private AlaRoundProgress afR;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void rL();
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
        this.afJ = findViewById(a.g.combo_container);
        this.afR = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.afE = (RelativeLayout) findViewById(a.g.combo_btn);
        this.afE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.afL = (ImageView) findViewById(a.g.combo_text_icon);
        this.afF = findViewById(a.g.combo_bg);
        this.afG = AnimationUtils.loadAnimation(this.mContext, a.C0086a.ala_gift_rotate_anim);
        this.afG.setInterpolator(new LinearInterpolator());
        this.afH = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0086a.ala_gift_scale_anim);
        this.afI = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.afI.setAnimation("ala_gift_combo_balloon.json");
        this.afI.loop(false);
        this.afR.setMax(100);
        this.afR.setProgress(0);
        this.afK = ObjectAnimator.ofInt(this.afR, "progress", 100).setDuration(3000L);
        this.afK.setInterpolator(new LinearInterpolator());
        this.afK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.afK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.afJ.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.afQ != null) {
                    AlaComboBtnAnimView.this.afQ.rL();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.afE, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.afN = ObjectAnimator.ofFloat(this.afE, "scaleY", 1.0f, 0.8f, 1.0f);
        this.afN.setRepeatCount(0);
        this.afN.setDuration(1000L);
        this.afM = new AnimatorSet();
        this.afM.play(ofFloat).with(this.afN);
        this.afN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.afP) {
                    AlaComboBtnAnimView.this.afE.startAnimation(AlaComboBtnAnimView.this.afH);
                }
            }
        });
    }

    public void rH() {
        this.afP = System.currentTimeMillis() - this.afO < 1010;
        this.afO = System.currentTimeMillis();
        this.afH.cancel();
        if (this.afM.isRunning()) {
            this.afM.cancel();
        }
        this.afM.start();
        this.afI.playAnimation();
        this.afK.start();
    }

    public void rI() {
        this.afJ.setVisibility(0);
        this.afF.startAnimation(this.afG);
        this.afE.startAnimation(this.afH);
        this.afK.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.afE != null) {
            this.afE.setOnClickListener(onClickListener);
        }
    }

    public void rJ() {
        this.afG.cancel();
        this.afH.cancel();
        if (this.afK.isRunning()) {
            this.afK.cancel();
        }
        if (this.afM.isRunning()) {
            this.afM.cancel();
        }
        if (this.afI.isAnimating()) {
            this.afI.cancelAnimation();
        }
        this.afJ.setVisibility(8);
        if (this.afQ != null) {
            this.afQ.rL();
        }
    }

    public void setComboListener(a aVar) {
        this.afQ = aVar;
    }

    public boolean rK() {
        return this.afJ == null || this.afJ.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            rJ();
        } catch (Exception e) {
        }
    }
}
