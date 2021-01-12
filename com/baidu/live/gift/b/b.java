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
/* loaded from: classes10.dex */
public class b extends Dialog implements View.OnClickListener {
    private a bbo;
    private View bbp;
    private View bbq;
    private TBLottieAnimationView bbr;
    private TBLottieAnimationView bbs;
    private TbImageView bbt;
    private TextView bbu;
    private ImageView bbv;
    private AnimatorSet bbw;
    private String mId;

    /* loaded from: classes10.dex */
    public interface a {
        void gi(String str);

        void onClose();
    }

    public b(@NonNull Context context) {
        super(context, a.i.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.bbo = aVar;
    }

    public void o(String str, String str2, String str3) {
        this.mId = str;
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (getWindow() != null) {
                getWindow().addFlags(PlatformPlugin.DEFAULT_SYSTEM_UI);
            }
            ViewGroup.LayoutParams layoutParams = this.bbp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                this.bbp.setLayoutParams(layoutParams);
            }
        }
        show();
        if (!TextUtils.isEmpty(str2)) {
            this.bbt.startLoad(str2, 10, false, false);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.bbu.setText(str3);
        }
        if (this.bbr != null) {
            this.bbr.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO() {
        if (this.bbt != null) {
            this.bbw = new AnimatorSet();
            this.bbw.setDuration(400L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bbt, "scaleX", 0.0f, 1.2f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bbt, "scaleY", 0.0f, 1.2f, 1.0f);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.bbq, "alpha", 0.6f, 1.0f);
            ofFloat3.setDuration(400L);
            ofFloat3.setInterpolator(new LinearInterpolator());
            ofFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    b.this.bbq.setVisibility(0);
                }
            });
            this.bbw.play(ofFloat).with(ofFloat2).before(ofFloat3);
            this.bbw.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbo != null) {
            if (view == this.bbu) {
                this.bbo.gi(this.mId);
            } else if (view == this.bbv) {
                this.bbo.onClose();
            }
        }
    }

    private void init() {
        FP();
        initView();
        initListener();
    }

    private void FP() {
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
        EO();
        FQ();
        FR();
        FS();
        FT();
    }

    private void EO() {
        this.bbp = findViewById(a.f.layout_dynamic);
        this.bbr = (TBLottieAnimationView) findViewById(a.f.lottie_once);
        this.bbs = (TBLottieAnimationView) findViewById(a.f.lottie_loop);
        this.bbt = (TbImageView) findViewById(a.f.iv_thumb);
        this.bbq = findViewById(a.f.layout_action);
        this.bbu = (TextView) findViewById(a.f.tv_nav);
        this.bbv = (ImageView) findViewById(a.f.iv_close);
    }

    private void FQ() {
        this.bbr.setRepeatCount(0);
        this.bbr.setImageAssetsFolder("images/");
        this.bbr.setAnimation("live_gift_fragment_composite_once.json");
        this.bbr.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.b.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((float) valueAnimator.getDuration()) >= 0.4f && b.this.bbw == null) {
                    b.this.FO();
                }
            }
        });
        this.bbr.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.b.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (b.this.bbr != null) {
                    b.this.bbr.setVisibility(8);
                }
                if (b.this.bbs != null) {
                    b.this.bbs.playAnimation();
                }
            }
        });
        this.bbs.setRepeatCount(-1);
        this.bbs.setImageAssetsFolder("images/");
        this.bbs.setAnimation("live_gift_fragment_composite_loop.json");
    }

    private void FR() {
        this.bbt.setScaleX(0.0f);
        this.bbt.setScaleY(0.0f);
        this.bbt.setDefaultBgResource(a.c.sdk_transparent);
        this.bbt.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void FS() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-57754, -39399});
        } else {
            gradientDrawable.setColor(-57754);
        }
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds36));
        this.bbu.setBackgroundDrawable(gradientDrawable);
        this.bbu.setOnClickListener(this);
    }

    private void FT() {
        this.bbv.setOnClickListener(this);
    }

    private void initListener() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.b.b.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bbw != null) {
                    b.this.bbw.cancel();
                }
                if (b.this.bbr != null) {
                    b.this.bbr.cancelAnimation();
                }
                if (b.this.bbs != null) {
                    b.this.bbs.cancelAnimation();
                }
            }
        });
    }
}
