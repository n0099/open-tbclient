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
/* loaded from: classes10.dex */
public class AlaComboBtnAnimView extends FrameLayout {
    private RelativeLayout aWi;
    private View aWj;
    private Animation aWk;
    private LottieAnimationView aWm;
    private View aWn;
    private ObjectAnimator aWo;
    private AnimatorSet aWq;
    private a bUm;
    private AlaRoundProgress bUn;
    private final int bUo;
    private g bUp;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
        this.bUo = 3000;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_combo_btn_anim_view, this);
        this.aWn = findViewById(a.f.combo_container);
        this.bUn = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aWi = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aWi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aWj = findViewById(a.f.combo_bg);
        this.aWk = AnimationUtils.loadAnimation(this.mContext, a.C0194a.yuyin_ala_gift_rotate_anim);
        this.aWk.setInterpolator(new LinearInterpolator());
        this.aWm = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aWm.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.aWm.loop(false);
        this.bUn.setMax(100);
        this.bUn.setProgress(0);
        this.aWo = ObjectAnimator.ofInt(this.bUn, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aWo.setInterpolator(new LinearInterpolator());
        this.aWo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aWo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aWn.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bUm != null) {
                    AlaComboBtnAnimView.this.bUm.j(AlaComboBtnAnimView.this.bUp);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aWi, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(IMConnection.RETRY_DELAY_TIMES);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aWi, "scaleY", 1.0f, 0.8f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aWq = new AnimatorSet();
        this.aWq.play(ofFloat).with(ofFloat2);
    }

    public void h(g gVar) {
        this.bUp = gVar;
        if (this.aWq.isRunning()) {
            this.aWq.cancel();
        }
        this.aWq.start();
        this.aWm.playAnimation();
        this.aWo.start();
    }

    public void i(g gVar) {
        this.bUp = gVar;
        this.aWn.setVisibility(0);
        this.aWj.startAnimation(this.aWk);
        this.aWq.start();
        this.aWo.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aWi != null) {
            this.aWi.setOnClickListener(onClickListener);
        }
    }

    public void EC() {
        this.aWk.cancel();
        if (this.aWo.isRunning()) {
            this.aWo.cancel();
        }
        if (this.aWq.isRunning()) {
            this.aWq.cancel();
        }
        if (this.aWm.isAnimating()) {
            this.aWm.cancelAnimation();
        }
        this.aWn.setVisibility(8);
        if (this.bUm != null) {
            this.bUm.j(this.bUp);
        }
    }

    public void setComboListener(a aVar) {
        this.bUm = aVar;
    }

    public boolean ED() {
        return this.aWn == null || this.aWn.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            EC();
        } catch (Exception e) {
        }
    }
}
