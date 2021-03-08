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
/* loaded from: classes10.dex */
public class b extends Dialog implements View.OnClickListener {
    private a bfX;
    private View bfY;
    private View bfZ;
    private TBLottieAnimationView bga;
    private TBLottieAnimationView bgb;
    private TbImageView bgc;
    private TextView bgd;
    private ImageView bge;
    private AnimatorSet bgf;
    private String mId;

    /* loaded from: classes10.dex */
    public interface a {
        void gM(String str);

        void onClose();
    }

    public b(@NonNull Context context) {
        super(context, a.i.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.bfX = aVar;
    }

    public void o(String str, String str2, String str3) {
        this.mId = str;
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (getWindow() != null) {
                getWindow().addFlags(1280);
            }
            ViewGroup.LayoutParams layoutParams = this.bfY.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.bfY.setLayoutParams(layoutParams);
            }
        }
        show();
        if (!TextUtils.isEmpty(str2)) {
            this.bgc.startLoad(str2, 10, false, false);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.bgd.setText(str3);
        }
        if (this.bga != null) {
            this.bga.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        if (this.bgc != null) {
            this.bgf = new AnimatorSet();
            this.bgf.setDuration(400L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bgc, "scaleX", 0.0f, 1.2f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bgc, "scaleY", 0.0f, 1.2f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bfZ, "alpha", 0.6f, 1.0f);
            ofFloat3.setDuration(400L);
            ofFloat3.setInterpolator(new LinearInterpolator());
            ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    b.this.bfZ.setVisibility(0);
                }
            });
            this.bgf.play(ofFloat).with(ofFloat2).before(ofFloat3);
            this.bgf.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfX != null) {
            if (view == this.bgd) {
                this.bfX.gM(this.mId);
            } else if (view == this.bge) {
                this.bfX.onClose();
            }
        }
    }

    private void init() {
        Hi();
        initView();
        initListener();
    }

    private void Hi() {
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
        Gh();
        Hj();
        Hk();
        Hl();
        Hm();
    }

    private void Gh() {
        this.bfY = findViewById(a.f.layout_dynamic);
        this.bga = (TBLottieAnimationView) findViewById(a.f.lottie_once);
        this.bgb = (TBLottieAnimationView) findViewById(a.f.lottie_loop);
        this.bgc = (TbImageView) findViewById(a.f.iv_thumb);
        this.bfZ = findViewById(a.f.layout_action);
        this.bgd = (TextView) findViewById(a.f.tv_nav);
        this.bge = (ImageView) findViewById(a.f.iv_close);
    }

    private void Hj() {
        this.bga.setRepeatCount(0);
        this.bga.setImageAssetsFolder("images/");
        this.bga.setAnimation("live_gift_fragment_composite_once.json");
        this.bga.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.b.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((float) valueAnimator.getDuration()) >= 0.4f && b.this.bgf == null) {
                    b.this.Hh();
                }
            }
        });
        this.bga.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.bga != null) {
                    b.this.bga.setVisibility(8);
                }
                if (b.this.bgb != null) {
                    b.this.bgb.playAnimation();
                }
            }
        });
        this.bgb.setRepeatCount(-1);
        this.bgb.setImageAssetsFolder("images/");
        this.bgb.setAnimation("live_gift_fragment_composite_loop.json");
    }

    private void Hk() {
        this.bgc.setScaleX(0.0f);
        this.bgc.setScaleY(0.0f);
        this.bgc.setDefaultBgResource(a.c.sdk_transparent);
        this.bgc.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Hl() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-57754, -39399});
        } else {
            gradientDrawable.setColor(-57754);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds36));
        this.bgd.setBackgroundDrawable(gradientDrawable);
        this.bgd.setOnClickListener(this);
    }

    private void Hm() {
        this.bge.setOnClickListener(this);
    }

    private void initListener() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.b.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bgf != null) {
                    b.this.bgf.cancel();
                }
                if (b.this.bga != null) {
                    b.this.bga.cancelAnimation();
                }
                if (b.this.bgb != null) {
                    b.this.bgb.cancelAnimation();
                }
            }
        });
    }
}
