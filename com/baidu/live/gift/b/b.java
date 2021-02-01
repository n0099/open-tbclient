package com.baidu.live.gift.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes11.dex */
public class b extends Dialog implements View.OnClickListener {
    private TbImageView beA;
    private TextView beB;
    private ImageView beC;
    private AnimatorSet beD;
    private a bev;
    private View bew;
    private View bex;
    private TBLottieAnimationView bey;
    private TBLottieAnimationView bez;
    private String mId;

    /* loaded from: classes11.dex */
    public interface a {
        void gG(String str);

        void onClose();
    }

    public b(@NonNull Context context) {
        super(context, a.i.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.bev = aVar;
    }

    public void o(String str, String str2, String str3) {
        this.mId = str;
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (getWindow() != null) {
                getWindow().addFlags(1280);
            }
            ViewGroup.LayoutParams layoutParams = this.bew.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.bew.setLayoutParams(layoutParams);
            }
        }
        show();
        if (!TextUtils.isEmpty(str2)) {
            this.beA.startLoad(str2, 10, false, false);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.beB.setText(str3);
        }
        if (this.bey != null) {
            this.bey.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (this.beA != null) {
            this.beD = new AnimatorSet();
            this.beD.setDuration(400L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.beA, "scaleX", 0.0f, 1.2f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.beA, "scaleY", 0.0f, 1.2f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bex, "alpha", 0.6f, 1.0f);
            ofFloat3.setDuration(400L);
            ofFloat3.setInterpolator(new LinearInterpolator());
            ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    b.this.bex.setVisibility(0);
                }
            });
            this.beD.play(ofFloat).with(ofFloat2).before(ofFloat3);
            this.beD.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bev != null) {
            if (view == this.beB) {
                this.bev.gG(this.mId);
            } else if (view == this.beC) {
                this.bev.onClose();
            }
        }
    }

    private void init() {
        Hf();
        initView();
        initListener();
    }

    private void Hf() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(-1291845632));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.g.live_gift_fragment_composite_dialog);
        Ge();
        Hg();
        Hh();
        Hi();
        Hj();
    }

    private void Ge() {
        this.bew = findViewById(a.f.layout_dynamic);
        this.bey = (TBLottieAnimationView) findViewById(a.f.lottie_once);
        this.bez = (TBLottieAnimationView) findViewById(a.f.lottie_loop);
        this.beA = (TbImageView) findViewById(a.f.iv_thumb);
        this.bex = findViewById(a.f.layout_action);
        this.beB = (TextView) findViewById(a.f.tv_nav);
        this.beC = (ImageView) findViewById(a.f.iv_close);
    }

    private void Hg() {
        this.bey.setRepeatCount(0);
        this.bey.setImageAssetsFolder("images/");
        this.bey.setAnimation("live_gift_fragment_composite_once.json");
        this.bey.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.b.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((float) valueAnimator.getDuration()) >= 0.4f && b.this.beD == null) {
                    b.this.He();
                }
            }
        });
        this.bey.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.bey != null) {
                    b.this.bey.setVisibility(8);
                }
                if (b.this.bez != null) {
                    b.this.bez.playAnimation();
                }
            }
        });
        this.bez.setRepeatCount(-1);
        this.bez.setImageAssetsFolder("images/");
        this.bez.setAnimation("live_gift_fragment_composite_loop.json");
    }

    private void Hh() {
        this.beA.setScaleX(0.0f);
        this.beA.setScaleY(0.0f);
        this.beA.setDefaultBgResource(a.c.sdk_transparent);
        this.beA.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Hi() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-57754, -39399});
        } else {
            gradientDrawable.setColor(-57754);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds36));
        this.beB.setBackgroundDrawable(gradientDrawable);
        this.beB.setOnClickListener(this);
    }

    private void Hj() {
        this.beC.setOnClickListener(this);
    }

    private void initListener() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.b.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.beD != null) {
                    b.this.beD.cancel();
                }
                if (b.this.bey != null) {
                    b.this.bey.cancelAnimation();
                }
                if (b.this.bez != null) {
                    b.this.bez.cancelAnimation();
                }
            }
        });
    }
}
