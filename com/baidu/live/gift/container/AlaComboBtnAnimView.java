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
    private RelativeLayout aBg;
    private View aBh;
    private Animation aBi;
    private ScaleAnimation aBj;
    private LottieAnimationView aBk;
    private View aBl;
    private ObjectAnimator aBm;
    private ImageView aBn;
    private AnimatorSet aBo;
    private ObjectAnimator aBp;
    private long aBq;
    private boolean aBr;
    private a aBs;
    private AlaRoundProgress aBt;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void xG();
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
        this.aBl = findViewById(a.g.combo_container);
        this.aBt = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aBg = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aBg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aBn = (ImageView) findViewById(a.g.combo_text_icon);
        this.aBh = findViewById(a.g.combo_bg);
        this.aBi = AnimationUtils.loadAnimation(this.mContext, a.C0149a.ala_gift_rotate_anim);
        this.aBi.setInterpolator(new LinearInterpolator());
        this.aBj = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0149a.ala_gift_scale_anim);
        this.aBk = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aBk.setAnimation("ala_gift_combo_balloon.json");
        this.aBk.loop(false);
        this.aBt.setMax(100);
        this.aBt.setProgress(0);
        this.aBm = ObjectAnimator.ofInt(this.aBt, "progress", 100).setDuration(3000L);
        this.aBm.setInterpolator(new LinearInterpolator());
        this.aBm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aBm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aBl.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aBs != null) {
                    AlaComboBtnAnimView.this.aBs.xG();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aBg, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aBp = ObjectAnimator.ofFloat(this.aBg, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aBp.setRepeatCount(0);
        this.aBp.setDuration(1000L);
        this.aBo = new AnimatorSet();
        this.aBo.play(ofFloat).with(this.aBp);
        this.aBp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aBr) {
                    AlaComboBtnAnimView.this.aBg.startAnimation(AlaComboBtnAnimView.this.aBj);
                }
            }
        });
    }

    public void xC() {
        this.aBr = System.currentTimeMillis() - this.aBq < 1010;
        this.aBq = System.currentTimeMillis();
        this.aBj.cancel();
        if (this.aBo.isRunning()) {
            this.aBo.cancel();
        }
        this.aBo.start();
        this.aBk.playAnimation();
        this.aBm.start();
    }

    public void xD() {
        this.aBl.setVisibility(0);
        this.aBh.startAnimation(this.aBi);
        this.aBg.startAnimation(this.aBj);
        this.aBm.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aBg != null) {
            this.aBg.setOnClickListener(onClickListener);
        }
    }

    public void xE() {
        this.aBi.cancel();
        this.aBj.cancel();
        if (this.aBm.isRunning()) {
            this.aBm.cancel();
        }
        if (this.aBo.isRunning()) {
            this.aBo.cancel();
        }
        if (this.aBk.isAnimating()) {
            this.aBk.cancelAnimation();
        }
        this.aBl.setVisibility(8);
        if (this.aBs != null) {
            this.aBs.xG();
        }
    }

    public void setComboListener(a aVar) {
        this.aBs = aVar;
    }

    public boolean xF() {
        return this.aBl == null || this.aBl.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            xE();
        } catch (Exception e) {
        }
    }
}
