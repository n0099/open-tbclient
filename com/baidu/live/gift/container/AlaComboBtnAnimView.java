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
    private RelativeLayout aBa;
    private View aBb;
    private Animation aBc;
    private ScaleAnimation aBd;
    private LottieAnimationView aBe;
    private View aBf;
    private ObjectAnimator aBg;
    private ImageView aBh;
    private AnimatorSet aBi;
    private ObjectAnimator aBj;
    private long aBk;
    private boolean aBl;
    private a aBm;
    private AlaRoundProgress aBn;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void xH();
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
        this.aBf = findViewById(a.g.combo_container);
        this.aBn = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aBa = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aBa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aBh = (ImageView) findViewById(a.g.combo_text_icon);
        this.aBb = findViewById(a.g.combo_bg);
        this.aBc = AnimationUtils.loadAnimation(this.mContext, a.C0128a.ala_gift_rotate_anim);
        this.aBc.setInterpolator(new LinearInterpolator());
        this.aBd = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0128a.ala_gift_scale_anim);
        this.aBe = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aBe.setAnimation("ala_gift_combo_balloon.json");
        this.aBe.loop(false);
        this.aBn.setMax(100);
        this.aBn.setProgress(0);
        this.aBg = ObjectAnimator.ofInt(this.aBn, "progress", 100).setDuration(3000L);
        this.aBg.setInterpolator(new LinearInterpolator());
        this.aBg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aBg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aBf.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aBm != null) {
                    AlaComboBtnAnimView.this.aBm.xH();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aBa, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aBj = ObjectAnimator.ofFloat(this.aBa, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aBj.setRepeatCount(0);
        this.aBj.setDuration(1000L);
        this.aBi = new AnimatorSet();
        this.aBi.play(ofFloat).with(this.aBj);
        this.aBj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aBl) {
                    AlaComboBtnAnimView.this.aBa.startAnimation(AlaComboBtnAnimView.this.aBd);
                }
            }
        });
    }

    public void xD() {
        this.aBl = System.currentTimeMillis() - this.aBk < 1010;
        this.aBk = System.currentTimeMillis();
        this.aBd.cancel();
        if (this.aBi.isRunning()) {
            this.aBi.cancel();
        }
        this.aBi.start();
        this.aBe.playAnimation();
        this.aBg.start();
    }

    public void xE() {
        this.aBf.setVisibility(0);
        this.aBb.startAnimation(this.aBc);
        this.aBa.startAnimation(this.aBd);
        this.aBg.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aBa != null) {
            this.aBa.setOnClickListener(onClickListener);
        }
    }

    public void xF() {
        this.aBc.cancel();
        this.aBd.cancel();
        if (this.aBg.isRunning()) {
            this.aBg.cancel();
        }
        if (this.aBi.isRunning()) {
            this.aBi.cancel();
        }
        if (this.aBe.isAnimating()) {
            this.aBe.cancelAnimation();
        }
        this.aBf.setVisibility(8);
        if (this.aBm != null) {
            this.aBm.xH();
        }
    }

    public void setComboListener(a aVar) {
        this.aBm = aVar;
    }

    public boolean xG() {
        return this.aBf == null || this.aBf.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            xF();
        } catch (Exception e) {
        }
    }
}
