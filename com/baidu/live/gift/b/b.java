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
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes4.dex */
public class b extends Dialog implements View.OnClickListener {
    private ImageView beA;
    private AnimatorSet beB;
    private a bes;
    private View beu;
    private View bev;
    private TBLottieAnimationView bew;
    private TBLottieAnimationView bex;
    private TbImageView bey;
    private TextView bez;
    private String mId;

    /* loaded from: classes4.dex */
    public interface a {
        void hJ(String str);

        void onClose();
    }

    public b(@NonNull Context context) {
        super(context, a.i.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.bes = aVar;
    }

    public void o(String str, String str2, String str3) {
        this.mId = str;
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (getWindow() != null) {
                getWindow().addFlags(PlatformPlugin.DEFAULT_SYSTEM_UI);
            }
            ViewGroup.LayoutParams layoutParams = this.beu.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.beu.setLayoutParams(layoutParams);
            }
        }
        show();
        if (!TextUtils.isEmpty(str2)) {
            this.bey.startLoad(str2, 10, false, false);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.bez.setText(str3);
        }
        if (this.bew != null) {
            this.bew.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        if (this.bey != null) {
            this.beB = new AnimatorSet();
            this.beB.setDuration(400L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bey, "scaleX", 0.0f, 1.2f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bey, "scaleY", 0.0f, 1.2f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bev, "alpha", 0.6f, 1.0f);
            ofFloat3.setDuration(400L);
            ofFloat3.setInterpolator(new LinearInterpolator());
            ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    b.this.bev.setVisibility(0);
                }
            });
            this.beB.play(ofFloat).with(ofFloat2).before(ofFloat3);
            this.beB.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bes != null) {
            if (view == this.bez) {
                this.bes.hJ(this.mId);
            } else if (view == this.beA) {
                this.bes.onClose();
            }
        }
    }

    private void init() {
        Ki();
        initView();
        initListener();
    }

    private void Ki() {
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
        Jh();
        Kj();
        Kk();
        Kl();
        Km();
    }

    private void Jh() {
        this.beu = findViewById(a.f.layout_dynamic);
        this.bew = (TBLottieAnimationView) findViewById(a.f.lottie_once);
        this.bex = (TBLottieAnimationView) findViewById(a.f.lottie_loop);
        this.bey = (TbImageView) findViewById(a.f.iv_thumb);
        this.bev = findViewById(a.f.layout_action);
        this.bez = (TextView) findViewById(a.f.tv_nav);
        this.beA = (ImageView) findViewById(a.f.iv_close);
    }

    private void Kj() {
        this.bew.setRepeatCount(0);
        this.bew.setImageAssetsFolder("images/");
        this.bew.setAnimation("live_gift_fragment_composite_once.json");
        this.bew.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.b.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((float) valueAnimator.getDuration()) >= 0.4f && b.this.beB == null) {
                    b.this.Kh();
                }
            }
        });
        this.bew.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.bew != null) {
                    b.this.bew.setVisibility(8);
                }
                if (b.this.bex != null) {
                    b.this.bex.playAnimation();
                }
            }
        });
        this.bex.setRepeatCount(-1);
        this.bex.setImageAssetsFolder("images/");
        this.bex.setAnimation("live_gift_fragment_composite_loop.json");
    }

    private void Kk() {
        this.bey.setScaleX(0.0f);
        this.bey.setScaleY(0.0f);
        this.bey.setDefaultBgResource(a.c.sdk_transparent);
        this.bey.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void Kl() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-57754, -39399});
        } else {
            gradientDrawable.setColor(-57754);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds36));
        this.bez.setBackgroundDrawable(gradientDrawable);
        this.bez.setOnClickListener(this);
    }

    private void Km() {
        this.beA.setOnClickListener(this);
    }

    private void initListener() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.b.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.beB != null) {
                    b.this.beB.cancel();
                }
                if (b.this.bew != null) {
                    b.this.bew.cancelAnimation();
                }
                if (b.this.bex != null) {
                    b.this.bex.cancelAnimation();
                }
            }
        });
    }
}
