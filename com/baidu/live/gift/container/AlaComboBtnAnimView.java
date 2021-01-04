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
    private RelativeLayout baW;
    private View baX;
    private Animation baY;
    private ScaleAnimation baZ;
    private LottieAnimationView bba;
    private View bbb;
    private ObjectAnimator bbc;
    private ImageView bbd;
    private AnimatorSet bbe;
    private ObjectAnimator bbf;
    private long bbg;
    private boolean bbh;
    private a bbi;
    private AlaRoundProgress bbj;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void Iz();
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
        this.bbb = findViewById(a.f.combo_container);
        this.bbj = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.baW = (RelativeLayout) findViewById(a.f.combo_btn);
        this.baW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.bbd = (ImageView) findViewById(a.f.combo_text_icon);
        this.baX = findViewById(a.f.combo_bg);
        this.baY = AnimationUtils.loadAnimation(this.mContext, a.C0203a.ala_gift_rotate_anim);
        this.baY.setInterpolator(new LinearInterpolator());
        this.baZ = (ScaleAnimation) AnimationUtils.loadAnimation(this.mContext, a.C0203a.ala_gift_scale_anim);
        this.bba = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.bba.setAnimation("ala_gift_combo_balloon.json");
        this.bba.loop(false);
        this.bbj.setMax(100);
        this.bbj.setProgress(0);
        this.bbc = ObjectAnimator.ofInt(this.bbj, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.bbc.setInterpolator(new LinearInterpolator());
        this.bbc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.bbc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.bbb.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bbi != null) {
                    AlaComboBtnAnimView.this.bbi.Iz();
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baW, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(1000L);
        this.bbf = ObjectAnimator.ofFloat(this.baW, "scaleY", 1.0f, 0.8f, 1.0f);
        this.bbf.setRepeatCount(0);
        this.bbf.setDuration(1000L);
        this.bbe = new AnimatorSet();
        this.bbe.play(ofFloat).with(this.bbf);
        this.bbf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaComboBtnAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!AlaComboBtnAnimView.this.bbh) {
                    AlaComboBtnAnimView.this.baW.startAnimation(AlaComboBtnAnimView.this.baZ);
                }
            }
        });
    }

    public void Iv() {
        this.bbh = System.currentTimeMillis() - this.bbg < 1010;
        this.bbg = System.currentTimeMillis();
        this.baZ.cancel();
        if (this.bbe.isRunning()) {
            this.bbe.cancel();
        }
        this.bbe.start();
        this.bba.playAnimation();
        this.bbc.start();
    }

    public void Iw() {
        this.bbb.setVisibility(0);
        this.baX.startAnimation(this.baY);
        this.baW.startAnimation(this.baZ);
        this.bbc.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.baW != null) {
            this.baW.setOnClickListener(onClickListener);
        }
    }

    public void Ix() {
        if (this.baY != null) {
            this.baY.cancel();
        }
        if (this.baZ != null) {
            this.baZ.cancel();
        }
        if (this.bbc != null && this.bbc.isRunning()) {
            this.bbc.cancel();
        }
        if (this.bbe != null && this.bbe.isRunning()) {
            this.bbe.cancel();
        }
        if (this.bba != null && this.bba.isAnimating()) {
            this.bba.cancelAnimation();
        }
        if (this.bbb != null) {
            this.bbb.setVisibility(8);
        }
        if (this.bbi != null) {
            this.bbi.Iz();
        }
    }

    public void setComboListener(a aVar) {
        this.bbi = aVar;
    }

    public boolean Iy() {
        return this.bbb == null || this.bbb.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Ix();
        } catch (Exception e) {
        }
    }
}
