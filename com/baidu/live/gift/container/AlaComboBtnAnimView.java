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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private a aZA;
    private AlaRoundProgress aZB;
    private RelativeLayout aZo;
    private View aZp;
    private Animation aZq;
    private ScaleAnimation aZr;
    private LottieAnimationView aZs;
    private View aZt;
    private ObjectAnimator aZu;
    private ImageView aZv;
    private AnimatorSet aZw;
    private ObjectAnimator aZx;
    private long aZy;
    private boolean aZz;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void FU();
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
        LayoutInflater.from(this.mContext).inflate(a.g.ala_combo_btn_anim_view, this);
        this.aZt = findViewById(a.f.combo_container);
        this.aZB = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aZo = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aZo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aZv = (ImageView) findViewById(a.f.combo_text_icon);
        this.aZp = findViewById(a.f.combo_bg);
        this.aZq = AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_rotate_anim);
        this.aZq.setInterpolator(new LinearInterpolator());
        this.aZr = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0195a.ala_gift_scale_anim);
        this.aZs = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aZs.setAnimation("ala_gift_combo_balloon.json");
        this.aZs.loop(false);
        this.aZB.setMax(100);
        this.aZB.setProgress(0);
        this.aZu = ObjectAnimator.ofInt(this.aZB, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aZu.setInterpolator(new LinearInterpolator());
        this.aZu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aZu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aZt.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.aZA != null) {
                    AlaComboBtnAnimView.this.aZA.FU();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aZo, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.aZx = ObjectAnimator.ofFloat(this.aZo, "scaleY", 1.0f, 0.8f, 1.0f);
        this.aZx.setRepeatCount(0);
        this.aZx.setDuration(1000L);
        this.aZw = new AnimatorSet();
        this.aZw.play(ofFloat).with(this.aZx);
        this.aZx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.aZz) {
                    AlaComboBtnAnimView.this.aZo.startAnimation(AlaComboBtnAnimView.this.aZr);
                }
            }
        });
    }

    public void FQ() {
        this.aZz = System.currentTimeMillis() - this.aZy < 1010;
        this.aZy = System.currentTimeMillis();
        this.aZr.cancel();
        if (this.aZw.isRunning()) {
            this.aZw.cancel();
        }
        this.aZw.start();
        this.aZs.playAnimation();
        this.aZu.start();
    }

    public void FR() {
        this.aZt.setVisibility(0);
        this.aZp.startAnimation(this.aZq);
        this.aZo.startAnimation(this.aZr);
        this.aZu.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aZo != null) {
            this.aZo.setOnClickListener(onClickListener);
        }
    }

    public void FS() {
        if (this.aZq != null) {
            this.aZq.cancel();
        }
        if (this.aZr != null) {
            this.aZr.cancel();
        }
        if (this.aZu != null && this.aZu.isRunning()) {
            this.aZu.cancel();
        }
        if (this.aZw != null && this.aZw.isRunning()) {
            this.aZw.cancel();
        }
        if (this.aZs != null && this.aZs.isAnimating()) {
            this.aZs.cancelAnimation();
        }
        if (this.aZt != null) {
            this.aZt.setVisibility(8);
        }
        if (this.aZA != null) {
            this.aZA.FU();
        }
    }

    public void setComboListener(a aVar) {
        this.aZA = aVar;
    }

    public boolean FT() {
        return this.aZt == null || this.aZt.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            FS();
        } catch (Exception e) {
        }
    }
}
