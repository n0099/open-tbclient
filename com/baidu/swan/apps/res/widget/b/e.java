package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.b.d;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes10.dex */
class e {
    private static View bKA;
    private static Runnable mCancelRunnable;
    private static View sMaskView;
    private static boolean sShowMask = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, int i2, boolean z) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(a.e.aiapps_normal_toast_view_bg));
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
            if (i2 >= 2) {
                textView.setSingleLine(false);
                textView.setMaxLines(i2);
                textView.setGravity(17);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, a.C0187a.aiapps_toast_enter);
    }

    static View getContentView(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToastBottom(@NonNull Activity activity, @NonNull CharSequence charSequence, int i) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(a.e.aiapps_normal_toast_view_bg));
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(a.d.aiapps_clickable_toast_view_margin_bottom);
        addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, a.C0187a.aiapps_toast_enter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighlight(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i, boolean z) {
        Resources resources = activity.getResources();
        sShowMask = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(a.f.highlight_toast_text);
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable == null) {
                drawable = resources.getDrawable(a.e.aiapps_highlight_toast_image);
            }
            imageView.setImageDrawable(drawable);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, a.C0187a.aiapps_highlight_toast_show);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighLoadingToast(Activity activity, CharSequence charSequence, int i, boolean z) {
        Resources resources = activity.getResources();
        sShowMask = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, a.C0187a.aiapps_highlight_toast_show);
    }

    private static void addToastToViewTree(View view, View view2, int i, FrameLayout.LayoutParams layoutParams, @AnimRes int i2) {
        if (view != null && view2 != null) {
            addToastToViewTree(view, view2, i, layoutParams, AnimationUtils.loadAnimation(view.getContext(), i2));
        }
    }

    private static void addToastToViewTree(final View view, final View view2, int i, final FrameLayout.LayoutParams layoutParams, final Animation animation) {
        if (view != null && view2 != null) {
            final Context context = view.getContext();
            if (view2.getParent() instanceof ViewGroup) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            view2.setClickable(true);
            if (view instanceof ViewGroup) {
                view.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.sShowMask && view != null) {
                            if (e.sMaskView != null && (e.sMaskView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) e.sMaskView.getParent()).removeView(e.sMaskView);
                            }
                            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                                FrameLayout frameLayout = new FrameLayout(context);
                                frameLayout.setClickable(true);
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams2.topMargin = d.getSwanAppStatusBarAndActionBarHeight(context);
                                if (view instanceof ViewGroup) {
                                    ((ViewGroup) view).addView(frameLayout, layoutParams2);
                                    View unused = e.sMaskView = frameLayout;
                                }
                            } else {
                                return;
                            }
                        }
                        if (e.bKA != null && (e.bKA.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) e.bKA.getParent()).removeView(e.bKA);
                        }
                        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                            ((ViewGroup) view).addView(view2, layoutParams);
                            view2.startAnimation(animation);
                            View unused2 = e.bKA = view2;
                        }
                    }
                });
                if (mCancelRunnable == null) {
                    mCancelRunnable = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.cancel();
                        }
                    };
                }
                view.postDelayed(mCancelRunnable, i * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable final d.a aVar) {
        TextView textView;
        Resources resources = activity.getResources();
        View contentView = getContentView(activity);
        if (contentView != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(contentView.getContext()).inflate(a.g.aiapps_clickable_toast_view, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(a.e.aiapps_clickable_toast_view_bg));
            View findViewById = linearLayout.findViewById(a.f.clickable_toast_click_area);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(a.f.clickable_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
                textView.setTextSize(1, i);
            }
            View findViewById2 = linearLayout.findViewById(a.f.clickable_toast_line);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(resources.getColor(a.c.aiapps_white_text));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(a.f.clickable_toast_check_text);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(a.c.aiapps_white_text));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                    textView2.setTextSize(1, i);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(a.f.clickable_toast_icon_view);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(a.e.aiapps_clickable_toast_icon));
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (d.a.this != null) {
                            d.a.this.onToastClick();
                        }
                        e.cancel();
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(a.d.aiapps_clickable_toast_view_margin_bottom);
            addToastToViewTree(contentView, linearLayout, i2, layoutParams, a.C0187a.aiapps_toast_enter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Activity activity, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, int i4, @Nullable final d.a aVar) {
        boolean z;
        Animation animation;
        final TextView textView;
        Resources resources = activity.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(a.f.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i != 1) {
                simpleDraweeView.getHierarchy().a(new RoundingParams().vi(false));
            }
        } else {
            simpleDraweeView.setVisibility(8);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(a.f.title_text);
        TextView textView3 = (TextView) linearLayout.findViewById(a.f.message_text);
        textView2.setTextColor(resources.getColor(a.c.aiapps_white_text));
        textView3.setTextColor(resources.getColor(a.c.aiapps_white_text));
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            textView2.setText(charSequence);
            textView3.setText(charSequence2);
            z = true;
        } else if (!TextUtils.isEmpty(charSequence)) {
            textView3.setVisibility(8);
            textView2.setText(charSequence);
            z = false;
        } else if (!TextUtils.isEmpty(charSequence2)) {
            textView3.setVisibility(8);
            textView2.setText(charSequence2);
            z = false;
        } else {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            z = false;
        }
        if (uri == null && !z) {
            int dimensionPixelSize = resources.getDimensionPixelSize(a.d.aiapps_clickable_toast_single_line_padding);
            ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(a.f.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        View findViewById = linearLayout.findViewById(a.f.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence3)) {
            switch (i2) {
                case 1:
                    linearLayout.findViewById(a.f.bg_text_btn).setVisibility(8);
                    linearLayout.findViewById(a.f.clickable_toast_line).setBackgroundColor(resources.getColor(a.c.aiapps_white_text));
                    textView = (TextView) linearLayout.findViewById(a.f.clickable_toast_check_text);
                    textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(a.f.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(a.e.aiapps_clickable_toast_icon));
                    break;
                default:
                    linearLayout.findViewById(a.f.line_text_icon_btn).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(a.f.bg_text_btn);
                    textView.setBackground(resources.getDrawable(a.e.aiapps_toast_button_view_bg));
                    textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
                    textView.setText(charSequence3);
                    break;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.a.this != null) {
                        d.a.this.onToastClick();
                    }
                    e.cancel();
                }
            });
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.res.widget.b.e.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            textView.setAlpha(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState() ? 0.5f : 0.2f);
                            return false;
                        case 1:
                        default:
                            textView.setAlpha(1.0f);
                            return false;
                        case 2:
                            return false;
                    }
                }
            });
        } else {
            findViewById.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(a.d.aiapps_clickable_toast_view_margin_bottom);
        switch (i3) {
            case 2:
                int dimensionPixelSize2 = resources.getDimensionPixelSize(a.d.aiapps_clickable_toast_view_shift_start_y);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(200L);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, dimensionPixelSize2, 0, 0.0f));
                animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                animation = animationSet;
                break;
            default:
                animation = AnimationUtils.loadAnimation(activity, a.C0187a.aiapps_toast_enter);
                break;
        }
        addToastToViewTree(getContentView(activity), linearLayout, i4, layoutParams, animation);
    }

    public static synchronized void cancel() {
        synchronized (e.class) {
            if (bKA != null) {
                bKA.post(new AnonymousClass2(bKA, sMaskView));
                bKA.removeCallbacks(mCancelRunnable);
                bKA = null;
                mCancelRunnable = null;
                sMaskView = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.res.widget.b.e$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass2 implements Runnable {
        final /* synthetic */ View val$maskView;
        final /* synthetic */ View val$toastView;

        AnonymousClass2(View view, View view2) {
            this.val$toastView = view;
            this.val$maskView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.val$toastView.getContext(), a.C0187a.aiapps_toast_exit);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (AnonymousClass2.this.val$toastView.getParent() instanceof ViewGroup) {
                        AnonymousClass2.this.val$toastView.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass2.this.val$toastView.getParent() != null) {
                                    ((ViewGroup) AnonymousClass2.this.val$toastView.getParent()).removeView(AnonymousClass2.this.val$toastView);
                                }
                            }
                        });
                    }
                    if (AnonymousClass2.this.val$maskView != null) {
                        AnonymousClass2.this.val$maskView.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass2.this.val$maskView != null && AnonymousClass2.this.val$maskView.getParent() != null && (AnonymousClass2.this.val$maskView.getParent() instanceof ViewGroup)) {
                                    ((ViewGroup) AnonymousClass2.this.val$maskView.getParent()).removeView(AnonymousClass2.this.val$maskView);
                                }
                            }
                        });
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.val$toastView.startAnimation(loadAnimation);
        }
    }
}
