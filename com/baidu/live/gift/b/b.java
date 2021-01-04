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
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public class b extends Dialog implements View.OnClickListener {
    private a bge;
    private View bgf;
    private View bgg;
    private TBLottieAnimationView bgh;
    private TBLottieAnimationView bgi;
    private TbImageView bgj;
    private TextView bgk;
    private ImageView bgl;
    private AnimatorSet bgm;
    private String mId;

    /* loaded from: classes11.dex */
    public interface a {
        void hu(String str);

        void onClose();
    }

    public b(@NonNull Context context) {
        super(context, a.i.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.bge = aVar;
    }

    public void p(String str, String str2, String str3) {
        this.mId = str;
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (getWindow() != null) {
                getWindow().addFlags(PlatformPlugin.DEFAULT_SYSTEM_UI);
            }
            ViewGroup.LayoutParams layoutParams = this.bgf.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.bgf.setLayoutParams(layoutParams);
            }
        }
        show();
        if (!TextUtils.isEmpty(str2)) {
            this.bgj.startLoad(str2, 10, false, false);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.bgk.setText(str3);
        }
        if (this.bgh != null) {
            this.bgh.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ() {
        if (this.bgj != null) {
            this.bgm = new AnimatorSet();
            this.bgm.setDuration(400L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bgj, "scaleX", 0.0f, 1.2f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bgj, "scaleY", 0.0f, 1.2f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bgg, "alpha", 0.6f, 1.0f);
            ofFloat3.setDuration(400L);
            ofFloat3.setInterpolator(new LinearInterpolator());
            ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    b.this.bgg.setVisibility(0);
                }
            });
            this.bgm.play(ofFloat).with(ofFloat2).before(ofFloat3);
            this.bgm.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bge != null) {
            if (view == this.bgk) {
                this.bge.hu(this.mId);
            } else if (view == this.bgl) {
                this.bge.onClose();
            }
        }
    }

    private void init() {
        JK();
        initView();
        initListener();
    }

    private void JK() {
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
        IJ();
        JL();
        JM();
        JN();
        JO();
    }

    private void IJ() {
        this.bgf = findViewById(a.f.layout_dynamic);
        this.bgh = (TBLottieAnimationView) findViewById(a.f.lottie_once);
        this.bgi = (TBLottieAnimationView) findViewById(a.f.lottie_loop);
        this.bgj = (TbImageView) findViewById(a.f.iv_thumb);
        this.bgg = findViewById(a.f.layout_action);
        this.bgk = (TextView) findViewById(a.f.tv_nav);
        this.bgl = (ImageView) findViewById(a.f.iv_close);
    }

    private void JL() {
        this.bgh.setRepeatCount(0);
        this.bgh.setImageAssetsFolder("images/");
        this.bgh.setAnimation("live_gift_fragment_composite_once.json");
        this.bgh.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.b.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((float) valueAnimator.getDuration()) >= 0.4f && b.this.bgm == null) {
                    b.this.JJ();
                }
            }
        });
        this.bgh.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.bgh != null) {
                    b.this.bgh.setVisibility(8);
                }
                if (b.this.bgi != null) {
                    b.this.bgi.playAnimation();
                }
            }
        });
        this.bgi.setRepeatCount(-1);
        this.bgi.setImageAssetsFolder("images/");
        this.bgi.setAnimation("live_gift_fragment_composite_loop.json");
    }

    private void JM() {
        this.bgj.setScaleX(0.0f);
        this.bgj.setScaleY(0.0f);
        this.bgj.setDefaultBgResource(a.c.sdk_transparent);
        this.bgj.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void JN() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-57754, -39399});
        } else {
            gradientDrawable.setColor(-57754);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds36));
        this.bgk.setBackgroundDrawable(gradientDrawable);
        this.bgk.setOnClickListener(this);
    }

    private void JO() {
        this.bgl.setOnClickListener(this);
    }

    private void initListener() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.b.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bgm != null) {
                    b.this.bgm.cancel();
                }
                if (b.this.bgh != null) {
                    b.this.bgh.cancelAnimation();
                }
                if (b.this.bgi != null) {
                    b.this.bgi.cancelAnimation();
                }
            }
        });
    }
}
