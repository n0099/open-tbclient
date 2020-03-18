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
    private RelativeLayout aiH;
    private View aiI;
    private Animation aiJ;
    private ScaleAnimation aiK;
    private LottieAnimationView aiL;
    private View aiM;
    private ObjectAnimator aiN;
    private ImageView aiO;
    private AnimatorSet aiP;
    private ObjectAnimator aiQ;
    private long aiR;
    private boolean aiS;
    private a aiT;
    private AlaRoundProgress aiU;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void tp();
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
        this.aiM = findViewById(a.g.combo_container);
        this.aiU = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aiH = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aiH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aiO = (ImageView) findViewById(a.g.combo_text_icon);
        this.aiI = findViewById(a.g.combo_bg);
        this.aiJ = AnimationUtils.loadAnimation(this.mContext, a.C0102a.ala_gift_rotate_anim);
        this.aiJ.setInterpolator(new LinearInterpolator());
        this.aiK = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0102a.ala_gift_scale_anim);
        this.aiL = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aiL.setAnimation("ala_gift_combo_balloon.json");
        this.aiL.loop(false);
        this.aiU.setMax(100);
        this.aiU.setProgress(0);
        this.aiN = ObjectAnimator.ofInt(this.aiU, "progress", 100).setDuration(3000L);
        this.aiN.setInterpolator(new LinearInterpolator());
        this.aiN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aiN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aiM.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aiT != null) {
                    AlaComboBtnAnimView.this.aiT.tp();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aiH, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aiQ = ObjectAnimator.ofFloat(this.aiH, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aiQ.setRepeatCount(0);
        this.aiQ.setDuration(1000L);
        this.aiP = new AnimatorSet();
        this.aiP.play(ofFloat).with(this.aiQ);
        this.aiQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aiS) {
                    AlaComboBtnAnimView.this.aiH.startAnimation(AlaComboBtnAnimView.this.aiK);
                }
            }
        });
    }

    public void tk() {
        this.aiS = System.currentTimeMillis() - this.aiR < 1010;
        this.aiR = System.currentTimeMillis();
        this.aiK.cancel();
        if (this.aiP.isRunning()) {
            this.aiP.cancel();
        }
        this.aiP.start();
        this.aiL.playAnimation();
        this.aiN.start();
    }

    public void tl() {
        this.aiM.setVisibility(0);
        this.aiI.startAnimation(this.aiJ);
        this.aiH.startAnimation(this.aiK);
        this.aiN.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aiH != null) {
            this.aiH.setOnClickListener(onClickListener);
        }
    }

    public void tm() {
        this.aiJ.cancel();
        this.aiK.cancel();
        if (this.aiN.isRunning()) {
            this.aiN.cancel();
        }
        if (this.aiP.isRunning()) {
            this.aiP.cancel();
        }
        if (this.aiL.isAnimating()) {
            this.aiL.cancelAnimation();
        }
        this.aiM.setVisibility(8);
        if (this.aiT != null) {
            this.aiT.tp();
        }
    }

    public void setComboListener(a aVar) {
        this.aiT = aVar;
    }

    public boolean tn() {
        return this.aiM == null || this.aiM.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            tm();
        } catch (Exception e) {
        }
    }
}
