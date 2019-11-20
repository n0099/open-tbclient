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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e {
    private static boolean bjA = false;
    private static Runnable bjg;
    private static View bjy;
    private static View bjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, int i2, boolean z) {
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
        a(J(activity), relativeLayout, i, layoutParams, a.C0151a.aiapps_toast_enter);
    }

    static View J(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Activity activity, @NonNull CharSequence charSequence, int i) {
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
        a(J(activity), relativeLayout, i, layoutParams, a.C0151a.aiapps_toast_enter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i, boolean z) {
        Resources resources = activity.getResources();
        bjA = z;
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
        a(J(activity), linearLayout, i, layoutParams, a.C0151a.aiapps_highlight_toast_show);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity, CharSequence charSequence, int i, boolean z) {
        Resources resources = activity.getResources();
        bjA = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(a.g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        a(J(activity), linearLayout, i, layoutParams, a.C0151a.aiapps_highlight_toast_show);
    }

    private static void a(View view, View view2, int i, FrameLayout.LayoutParams layoutParams, @AnimRes int i2) {
        if (view != null && view2 != null) {
            a(view, view2, i, layoutParams, AnimationUtils.loadAnimation(view.getContext(), i2));
        }
    }

    private static void a(final View view, final View view2, int i, final FrameLayout.LayoutParams layoutParams, final Animation animation) {
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
                        if (e.bjA && view != null) {
                            if (e.bjz != null && (e.bjz.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) e.bjz.getParent()).removeView(e.bjz);
                            }
                            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                                FrameLayout frameLayout = new FrameLayout(context);
                                frameLayout.setClickable(true);
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams2.topMargin = d.by(context);
                                if (view instanceof ViewGroup) {
                                    ((ViewGroup) view).addView(frameLayout, layoutParams2);
                                    View unused = e.bjz = frameLayout;
                                }
                            } else {
                                return;
                            }
                        }
                        if (e.bjy != null && (e.bjy.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) e.bjy.getParent()).removeView(e.bjy);
                        }
                        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                            ((ViewGroup) view).addView(view2, layoutParams);
                            view2.startAnimation(animation);
                            View unused2 = e.bjy = view2;
                        }
                    }
                });
                if (bjg == null) {
                    bjg = new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.cancel();
                        }
                    };
                }
                view.postDelayed(bjg, i * 1000);
            }
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
                simpleDraweeView.getHierarchy().a(new RoundingParams().si(false));
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
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.e.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.a.this != null) {
                        d.a.this.QU();
                    }
                    e.cancel();
                }
            });
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.res.widget.b.e.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            textView.setAlpha(com.baidu.swan.apps.u.a.JE().Kd() ? 0.5f : 0.2f);
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
                animation = AnimationUtils.loadAnimation(activity, a.C0151a.aiapps_toast_enter);
                break;
        }
        a(J(activity), linearLayout, i4, layoutParams, animation);
    }

    public static synchronized void cancel() {
        synchronized (e.class) {
            if (bjy != null) {
                bjy.post(new AnonymousClass2(bjy, bjz));
                bjy.removeCallbacks(bjg);
                bjy = null;
                bjg = null;
                bjz = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.res.widget.b.e$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static class AnonymousClass2 implements Runnable {
        final /* synthetic */ View bjE;
        final /* synthetic */ View bjF;

        AnonymousClass2(View view, View view2) {
            this.bjE = view;
            this.bjF = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.bjE.getContext(), a.C0151a.aiapps_toast_exit);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (AnonymousClass2.this.bjE.getParent() instanceof ViewGroup) {
                        AnonymousClass2.this.bjE.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass2.this.bjE.getParent() != null) {
                                    ((ViewGroup) AnonymousClass2.this.bjE.getParent()).removeView(AnonymousClass2.this.bjE);
                                }
                            }
                        });
                    }
                    if (AnonymousClass2.this.bjF != null) {
                        AnonymousClass2.this.bjF.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.e.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass2.this.bjF != null && AnonymousClass2.this.bjF.getParent() != null && (AnonymousClass2.this.bjF.getParent() instanceof ViewGroup)) {
                                    ((ViewGroup) AnonymousClass2.this.bjF.getParent()).removeView(AnonymousClass2.this.bjF);
                                }
                            }
                        });
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bjE.startAnimation(loadAnimation);
        }
    }
}
