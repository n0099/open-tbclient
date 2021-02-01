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
    private RelativeLayout aZo;
    private View aZp;
    private Animation aZq;
    private LottieAnimationView aZs;
    private View aZt;
    private ObjectAnimator aZu;
    private AnimatorSet aZw;
    private a bYo;
    private AlaRoundProgress bYp;
    private final int bYq;
    private g bYr;
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
        this.bYq = 3000;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_combo_btn_anim_view, this);
        this.aZt = findViewById(a.f.combo_container);
        this.bYp = (AlaRoundProgress) findViewById(a.f.ala_round_progress);
        this.aZo = (RelativeLayout) findViewById(a.f.combo_btn);
        this.aZo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.aZp = findViewById(a.f.combo_bg);
        this.aZq = AnimationUtils.loadAnimation(this.mContext, a.C0195a.yuyin_ala_gift_rotate_anim);
        this.aZq.setInterpolator(new LinearInterpolator());
        this.aZs = (LottieAnimationView) findViewById(a.f.lottie_balloon);
        this.aZs.setAnimation("yuyin_ala_gift_combo_balloon.json");
        this.aZs.loop(false);
        this.bYp.setMax(100);
        this.bYp.setProgress(0);
        this.aZu = ObjectAnimator.ofInt(this.bYp, "progress", 100).setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aZu.setInterpolator(new LinearInterpolator());
        this.aZu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        this.aZu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.yuyingift.container.AlaComboBtnAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (((Integer) ((ValueAnimator) animator).getAnimatedValue()).intValue() == 100) {
                    AlaComboBtnAnimView.this.aZt.setVisibility(8);
                }
                if (AlaComboBtnAnimView.this.bYo != null) {
                    AlaComboBtnAnimView.this.bYo.j(AlaComboBtnAnimView.this.bYr);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aZo, "scaleX", 1.0f, 0.8f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(IMConnection.RETRY_DELAY_TIMES);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aZo, "scaleY", 1.0f, 0.8f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setDuration(IMConnection.RETRY_DELAY_TIMES);
        this.aZw = new AnimatorSet();
        this.aZw.play(ofFloat).with(ofFloat2);
    }

    public void h(g gVar) {
        this.bYr = gVar;
        if (this.aZw.isRunning()) {
            this.aZw.cancel();
        }
        this.aZw.start();
        this.aZs.playAnimation();
        this.aZu.start();
    }

    public void i(g gVar) {
        this.bYr = gVar;
        this.aZt.setVisibility(0);
        this.aZp.startAnimation(this.aZq);
        this.aZw.start();
        this.aZu.start();
    }

    public void setComboClickListener(View.OnClickListener onClickListener) {
        if (this.aZo != null) {
            this.aZo.setOnClickListener(onClickListener);
        }
    }

    public void FS() {
        this.aZq.cancel();
        if (this.aZu.isRunning()) {
            this.aZu.cancel();
        }
        if (this.aZw.isRunning()) {
            this.aZw.cancel();
        }
        if (this.aZs.isAnimating()) {
            this.aZs.cancelAnimation();
        }
        this.aZt.setVisibility(8);
        if (this.bYo != null) {
            this.bYo.j(this.bYr);
        }
    }

    public void setComboListener(a aVar) {
        this.bYo = aVar;
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
