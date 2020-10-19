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
/* loaded from: classes4.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout aUX;
    private View aUY;
    private Animation aUZ;
    private ScaleAnimation aVa;
    private LottieAnimationView aVb;
    private View aVc;
    private ObjectAnimator aVd;
    private ImageView aVe;
    private AnimatorSet aVf;
    private ObjectAnimator aVg;
    private long aVh;
    private boolean aVi;
    private a aVj;
    private AlaRoundProgress aVk;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void GU();
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
        this.aVc = findViewById(a.g.combo_container);
        this.aVk = (AlaRoundProgress) findViewById(a.g.ala_round_progress);
        this.aUX = (RelativeLayout) findViewById(a.g.combo_btn);
        this.aUX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aVe = (ImageView) findViewById(a.g.combo_text_icon);
        this.aUY = findViewById(a.g.combo_bg);
        this.aUZ = AnimationUtils.loadAnimation(this.mContext, a.C0194a.ala_gift_rotate_anim);
        this.aUZ.setInterpolator(new LinearInterpolator());
        this.aVa = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0194a.ala_gift_scale_anim);
        this.aVb = (LottieAnimationView) findViewById(a.g.lottie_balloon);
        this.aVb.setAnimation("ala_gift_combo_balloon.json");
        this.aVb.loop(false);
        this.aVk.setMax(100);
        this.aVk.setProgress(0);
        this.aVd = ObjectAnimator.ofInt(this.aVk, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aVd.setInterpolator(new LinearInterpolator());
        this.aVd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aVd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aVc.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aVj != null) {
                    AlaComboBtnAnimView.this.aVj.GU();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUX, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aVg = ObjectAnimator.ofFloat(this.aUX, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aVg.setRepeatCount(0);
        this.aVg.setDuration(1000L);
        this.aVf = new AnimatorSet();
        this.aVf.play(ofFloat).with(this.aVg);
        this.aVg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aVi) {
                    AlaComboBtnAnimView.this.aUX.startAnimation(AlaComboBtnAnimView.this.aVa);
                }
            }
        });
    }

    public void GQ() {
        this.aVi = System.currentTimeMillis() - this.aVh < 1010;
        this.aVh = System.currentTimeMillis();
        this.aVa.cancel();
        if (this.aVf.isRunning()) {
            this.aVf.cancel();
        }
        this.aVf.start();
        this.aVb.playAnimation();
        this.aVd.start();
    }

    public void GR() {
        this.aVc.setVisibility(0);
        this.aUY.startAnimation(this.aUZ);
        this.aUX.startAnimation(this.aVa);
        this.aVd.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aUX != null) {
            this.aUX.setOnClickListener(onClickListener);
        }
    }

    public void GS() {
        this.aUZ.cancel();
        this.aVa.cancel();
        if (this.aVd.isRunning()) {
            this.aVd.cancel();
        }
        if (this.aVf.isRunning()) {
            this.aVf.cancel();
        }
        if (this.aVb.isAnimating()) {
            this.aVb.cancelAnimation();
        }
        this.aVc.setVisibility(8);
        if (this.aVj != null) {
            this.aVj.GU();
        }
    }

    public void setComboListener(a aVar) {
        this.aVj = aVar;
    }

    public boolean GT() {
        return this.aVc == null || this.aVc.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            GS();
        } catch (Exception e) {
        }
    }
}
