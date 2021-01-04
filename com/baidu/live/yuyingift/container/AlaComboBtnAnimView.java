package com.baidu.live.yuyingift.container;

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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.gift.g;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private a bYY;
    private AlaRoundProgress bYZ;
    private final int bZa;
    private g bZb;
    private RelativeLayout baW;
    private View baX;
    private Animation baY;
    private LottieAnimationView bba;
    private View bbb;
    private ObjectAnimator bbc;
    private AnimatorSet bbe;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        void j(g gVar);
    }

    public AlaComboBtnAnimView(Context context) {
        this(context, null);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaComboBtnAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZa = 3000;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_combo_btn_anim_view, this);
        this.bbb = findViewById(a.f.combo_container);
        this.bYZ = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.baW = (RelativeLayout) findViewById(a.f.combo_btn);
        this.baW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.baX = findViewById(a.f.combo_bg);
        this.baY = AnimationUtils.loadAnimation(this.mContext, a.C0203a.yuyin_ala_gift_rotate_anim);
        this.baY.setInterpolator(new LinearInterpolator());
        this.bba = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.bba.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.bba.loop(false);
        this.bYZ.setMax(100);
        this.bYZ.setProgress(0);
        this.bbc = ObjectAnimator.ofInt(this.bYZ, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.bbc.setInterpolator(new LinearInterpolator());
        this.bbc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.bbc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.bbb.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bYY != null) {
                    AlaComboBtnAnimView.this.bYY.j(AlaComboBtnAnimView.this.bZb);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baW, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(IMConnection.RETRY_DELAY_TIMES);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.baW, "scaleY", 1.0f, 0.8f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.bbe = new AnimatorSet();
        this.bbe.play(ofFloat).with(ofFloat2);
    }

    public void h(g gVar) {
        this.bZb = gVar;
        if (this.bbe.isRunning()) {
            this.bbe.cancel();
        }
        this.bbe.start();
        this.bba.playAnimation();
        this.bbc.start();
    }

    public void i(g gVar) {
        this.bZb = gVar;
        this.bbb.setVisibility(0);
        this.baX.startAnimation(this.baY);
        this.bbe.start();
        this.bbc.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.baW != null) {
            this.baW.setOnClickListener(onClickListener);
        }
    }

    public void Ix() {
        this.baY.cancel();
        if (this.bbc.isRunning()) {
            this.bbc.cancel();
        }
        if (this.bbe.isRunning()) {
            this.bbe.cancel();
        }
        if (this.bba.isAnimating()) {
            this.bba.cancelAnimation();
        }
        this.bbb.setVisibility(8);
        if (this.bYY != null) {
            this.bYY.j(this.bZb);
        }
    }

    public void setComboListener(a aVar) {
        this.bYY = aVar;
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
