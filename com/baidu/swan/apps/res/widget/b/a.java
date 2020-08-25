package com.baidu.swan.apps.res.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.b.d;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
final class a {
    private static Toast mSystemToast;
    private static WeakReference<b> mToastRef;
    private static boolean sDebug = com.baidu.swan.apps.b.DEBUG;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void show(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        boolean z3 = true;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(a.e.aiapps_normal_toast_view_bg));
        relativeLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
            boolean z4 = i2 >= 2;
            if (z4 || !z) {
                z3 = false;
            }
            textView.setSingleLine(z3);
            if (z4) {
                textView.setMaxLines(i2);
                textView.setGravity(17);
            }
        }
        if (c.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = a.mSystemToast = new Toast(applicationContext);
                    a.mSystemToast.setView(relativeLayout);
                    a.mSystemToast.setGravity(17, 0, 0);
                    c.setToastAnimation(a.mSystemToast, a.i.toast_animation);
                    try {
                        a.mSystemToast.show();
                    } catch (NullPointerException e) {
                        if (a.sDebug) {
                            e.printStackTrace();
                        }
                    }
                    if (a.sDebug) {
                        Log.d("SingleToast", "mSystemToast.show() invoked in show");
                    }
                }
            });
            return;
        }
        b bVar = new b(applicationContext);
        a(bVar);
        bVar.setView(relativeLayout);
        bVar.setMask(z2);
        bVar.setGravity(17, 0, 0);
        bVar.setDuration(i);
        bVar.setWindowAnimation(a.i.toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToastBottom(@NonNull final Context context, @NonNull CharSequence charSequence, int i) {
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(a.e.aiapps_normal_toast_view_bg));
        TextView textView = (TextView) relativeLayout.findViewById(a.f.normal_toast_text);
        if (textView != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        if (c.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = a.mSystemToast = new Toast(applicationContext);
                    a.mSystemToast.setView(relativeLayout);
                    a.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
                    c.setToastAnimation(a.mSystemToast, a.i.toast_animation);
                    a.mSystemToast.show();
                    if (a.sDebug) {
                        Log.d("SingleToast", "mSystemToast.show() invoked in showToastBottom");
                    }
                }
            });
            return;
        }
        b bVar = new b(applicationContext);
        a(bVar);
        bVar.setView(relativeLayout);
        bVar.setGravity(81, 0, (int) context.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.setDuration(i);
        bVar.setWindowAnimation(a.i.toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighlight(@NonNull final Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i, boolean z) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(a.f.highlight_toast_text)) != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageDrawable(resources.getDrawable(a.e.aiapps_highlight_toast_image));
            }
        }
        if (c.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = a.mSystemToast = new Toast(context);
                    a.mSystemToast.setView(linearLayout);
                    a.mSystemToast.setGravity(17, 0, 0);
                    c.setToastAnimation(a.mSystemToast, a.i.highlight_toast_animation);
                    a.mSystemToast.show();
                }
            });
            return;
        }
        b bVar = new b(applicationContext);
        a(bVar);
        bVar.setView(linearLayout);
        bVar.setMask(z);
        bVar.setGravity(17, 0, 0);
        bVar.setDuration(i);
        bVar.setWindowAnimation(a.i.highlight_toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighLoadingToast(final Context context, CharSequence charSequence, int i, boolean z) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        TextView textView = (TextView) linearLayout.findViewById(a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
        }
        if (c.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = a.mSystemToast = new Toast(context);
                    a.mSystemToast.setView(linearLayout);
                    a.mSystemToast.setGravity(17, 0, 0);
                    c.setToastAnimation(a.mSystemToast, a.i.highlight_toast_animation);
                    a.mSystemToast.show();
                }
            });
            return;
        }
        b bVar = new b(applicationContext);
        a(bVar);
        bVar.setView(linearLayout);
        bVar.setMask(z);
        bVar.setGravity(17, 0, 0);
        bVar.setDuration(i);
        bVar.setWindowAnimation(a.i.highlight_toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Context context, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable final d.a aVar) {
        TextView textView;
        TextView textView2;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (c.shouldShowSystemToast(context)) {
            final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(a.e.aiapps_normal_toast_view_bg));
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(a.f.normal_toast_text)) != null) {
                textView2.setText(charSequence);
                textView2.setTextColor(resources.getColor(a.c.aiapps_white_text));
                textView2.setTextSize(1, i);
            }
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.7
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = a.mSystemToast = new Toast(applicationContext);
                    a.mSystemToast.setView(relativeLayout);
                    a.mSystemToast.setGravity(81, 0, (int) applicationContext.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
                    c.setToastAnimation(a.mSystemToast, a.i.toast_animation);
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.b.a.7.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aVar != null) {
                                aVar.onToastClick();
                            }
                        }
                    });
                    a.mSystemToast.show();
                }
            });
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(a.f.clickable_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(a.c.aiapps_white_text));
            textView.setTextSize(1, i);
        }
        View findViewById = linearLayout.findViewById(a.f.clickable_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(a.c.aiapps_white_text));
        }
        TextView textView3 = (TextView) linearLayout.findViewById(a.f.clickable_toast_check_text);
        if (textView3 != null) {
            textView3.setTextColor(resources.getColor(a.c.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView3.setText(charSequence2);
                textView3.setTextSize(1, i);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.clickable_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(a.e.aiapps_clickable_toast_icon));
        }
        b bVar = new b(applicationContext);
        a(bVar);
        if (c.checkIsOppoRom()) {
            bVar.setWindowType(2003);
            if (sDebug) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.setView(linearLayout);
        bVar.setGravity(81, 0, (int) applicationContext.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.setDuration(i2);
        bVar.a(aVar);
        bVar.setWindowAnimation(a.i.toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull final Context context, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, @Nullable d.a aVar) {
        boolean z;
        final TextView textView;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(a.g.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(a.f.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i != 1) {
                simpleDraweeView.getHierarchy().a(new RoundingParams().xZ(false));
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
        final View findViewById = linearLayout.findViewById(a.f.clickable_toast_click_area);
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
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.res.widget.b.a.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            textView.setAlpha(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState() ? 0.5f : 0.2f);
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
        if (c.shouldShowSystemToast(context)) {
            mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.res.widget.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    findViewById.setVisibility(8);
                    Toast unused = a.mSystemToast = new Toast(applicationContext);
                    a.mSystemToast.setView(linearLayout);
                    a.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
                    c.setToastAnimation(a.mSystemToast, a.i.toast_animation);
                    a.mSystemToast.show();
                }
            });
            return;
        }
        b bVar = new b(applicationContext);
        a(bVar);
        if (c.checkIsOppoRom()) {
            bVar.setWindowType(2003);
            if (sDebug) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.setView(linearLayout);
        bVar.setGravity(81, 0, (int) context.getResources().getDimension(a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.setDuration(i3);
        bVar.a(aVar);
        bVar.setWindowAnimation(a.i.toast_animation);
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cancel() {
        b bVar;
        if (mToastRef != null && (bVar = mToastRef.get()) != null) {
            bVar.cancel();
        }
        if (mSystemToast != null) {
            mSystemToast.cancel();
        }
    }

    private static void a(b bVar) {
        if (mToastRef != null) {
            mToastRef.clear();
        }
        mToastRef = new WeakReference<>(bVar);
    }
}
