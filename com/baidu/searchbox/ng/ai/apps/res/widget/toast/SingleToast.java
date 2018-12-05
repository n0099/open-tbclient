package com.baidu.searchbox.ng.ai.apps.res.widget.toast;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
final class SingleToast {
    private static final String TAG = "SingleToast";
    private static Toast mSystemToast;
    private static WeakReference<ToastCustom> mToastRef;
    private static boolean sDebug = false;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    SingleToast() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void show(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2) {
        TextView textView;
        boolean z2 = true;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(R.drawable.aiapps_normal_toast_view_bg));
        relativeLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setText(charSequence);
            boolean z3 = i2 >= 2;
            if (z3 || !z) {
                z2 = false;
            }
            textView.setSingleLine(z2);
            if (z3) {
                textView.setMaxLines(i2);
                textView.setGravity(17);
            }
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(relativeLayout);
                    SingleToast.mSystemToast.setGravity(17, 0, 0);
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    SingleToast.mSystemToast.show();
                    if (SingleToast.sDebug) {
                        Log.d(SingleToast.TAG, "mSystemToast.show() invoked in show");
                    }
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        toastCustom.setView(relativeLayout);
        toastCustom.setGravity(17, 0, 0);
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToastBottom(@NonNull final Context context, @NonNull CharSequence charSequence, int i) {
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(R.drawable.aiapps_normal_toast_view_bg));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text);
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setText(charSequence);
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(relativeLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    SingleToast.mSystemToast.show();
                    if (SingleToast.sDebug) {
                        Log.d(SingleToast.TAG, "mSystemToast.show() invoked in showToastBottom");
                    }
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        toastCustom.setView(relativeLayout);
        toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighlight(@NonNull final Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text)) != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.aiapps_highlight_toast_image));
            }
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.3
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(context);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(17, 0, 0);
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(17, 0, 0);
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighLoadingToast(final Context context, CharSequence charSequence, int i) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        TextView textView = (TextView) linearLayout.findViewById(R.id.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.4
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(context);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(17, 0, 0);
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(17, 0, 0);
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToast(@NonNull Context context, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (ToastUtils.shouldShowSystemToast(context)) {
            final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.aiapps_normal_toast_view_bg));
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                textView2.setText(charSequence);
                textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
                textView2.setTextSize(1, i);
            }
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.5
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(relativeLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (toastCallback != null) {
                                toastCallback.onToastClick();
                            }
                        }
                    });
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setTextSize(1, i);
        }
        View findViewById = linearLayout.findViewById(R.id.clickable_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.aiapps_white_text));
        }
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
        if (textView3 != null) {
            textView3.setTextColor(resources.getColor(R.color.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView3.setText(charSequence2);
                textView3.setTextSize(1, i);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(R.drawable.aiapps_clickable_toast_icon));
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i2);
        toastCustom.setOnClick(toastCallback);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToastWithLeftGif(@NonNull final Context context, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_left_icon_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        ((SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon)).setController(c.bTV().oT(true).u(uri).bUE());
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setText(charSequence);
        }
        View findViewById = linearLayout.findViewById(R.id.gif_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.aiapps_white_text));
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
        if (textView2 != null) {
            textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gif_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(R.drawable.aiapps_clickable_toast_icon));
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            linearLayout.findViewById(R.id.gif_toast_line).setVisibility(8);
            linearLayout.findViewById(R.id.gif_toast_click_area).setVisibility(8);
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.6
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (toastCallback != null) {
                                toastCallback.onToastClick();
                            }
                        }
                    });
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i);
        toastCustom.setOnClick(toastCallback);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToastWithLeftIcon(@NonNull final Context context, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_left_icon_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageDrawable(drawable);
        }
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setText(charSequence);
        }
        View findViewById = linearLayout.findViewById(R.id.gif_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(R.color.aiapps_white_text));
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
        if (textView2 != null) {
            textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gif_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(R.drawable.aiapps_clickable_toast_icon));
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            linearLayout.findViewById(R.id.gif_toast_line).setVisibility(8);
            linearLayout.findViewById(R.id.gif_toast_click_area).setVisibility(8);
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.7
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.7.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (toastCallback != null) {
                                toastCallback.onToastClick();
                            }
                        }
                    });
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i);
        toastCustom.setOnClick(toastCallback);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showRightButtonToast(@NonNull Context context, CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (ToastUtils.shouldShowSystemToast(context)) {
            final RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.aiapps_normal_toast_view_bg));
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                textView2.setText(charSequence);
                textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
                textView2.setTextSize(1, i);
            }
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.8
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(relativeLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.aiapps_button_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.8.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (toastCallback != null) {
                                toastCallback.onToastClick();
                            }
                        }
                    });
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_right_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_right_button_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.right_button_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
            textView.setTextSize(1, i);
        }
        Button button = (Button) linearLayout.findViewById(R.id.right_button_toast_btn_view);
        if (button != null) {
            button.setBackground(resources.getDrawable(R.drawable.aiapps_toast_button_view_bg));
            if (!TextUtils.isEmpty(charSequence2)) {
                button.setText(charSequence2);
                button.setTextColor(resources.getColor(R.color.aiapps_white_text));
                button.setTextSize(1, i2);
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UniversalToast.ToastCallback.this != null) {
                        UniversalToast.ToastCallback.this.onToastClick();
                    }
                    SingleToast.cancel();
                }
            });
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.aiapps_button_toast_view_margin_bottom));
        toastCustom.setDuration(i3);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showIconTitleMsgBtnToast(@NonNull final Context context, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z;
        final TextView textView;
        final Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i != 1) {
                simpleDraweeView.getHierarchy().a(new RoundingParams().oW(false));
            }
        } else {
            simpleDraweeView.setVisibility(8);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.title_text);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.message_text);
        textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
        textView3.setTextColor(resources.getColor(R.color.aiapps_white_text));
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
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.aiapps_clickable_toast_single_line_padding);
            ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        final View findViewById = linearLayout.findViewById(R.id.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence3)) {
            switch (i2) {
                case 1:
                    linearLayout.findViewById(R.id.bg_text_btn).setVisibility(8);
                    linearLayout.findViewById(R.id.clickable_toast_line).setBackgroundColor(resources.getColor(R.color.aiapps_white_text));
                    textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
                    textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(R.drawable.aiapps_clickable_toast_icon));
                    break;
                default:
                    linearLayout.findViewById(R.id.line_text_icon_btn).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(R.id.bg_text_btn);
                    textView.setBackground(resources.getDrawable(R.drawable.aiapps_toast_button_view_bg));
                    textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
                    textView.setText(charSequence3);
                    break;
            }
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.10
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            textView.setAlpha(AiAppNightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
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
        if (ToastUtils.shouldShowSystemToast(context)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.11
                @Override // java.lang.Runnable
                public void run() {
                    findViewById.setVisibility(8);
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i3);
        toastCustom.setOnClick(toastCallback);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    public static void show2Icon2BtnToast(Context context, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i, final UniversalToast.ToastCallback toastCallback) {
        final Context applicationContext = context.getApplicationContext();
        final Resources resources = context.getResources();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.aiapps_double_icon_double_text_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
        } else {
            simpleDraweeView.setVisibility(8);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gif_toast_icon_view);
        if (uri2 != null) {
            imageView.setImageURI(uri2);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view);
        textView.setTextColor(resources.getColor(R.color.aiapps_white_text));
        textView.setText(charSequence);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
        textView2.setTextColor(resources.getColor(R.color.aiapps_white_text));
        textView2.setText(charSequence2);
        final View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area_left);
        final View findViewById2 = linearLayout.findViewById(R.id.gif_toast_click_area);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UniversalToast.ToastCallback.this instanceof UniversalToast.ToastCallbackWithAction) {
                    UniversalToast.ToastCallbackWithAction toastCallbackWithAction = (UniversalToast.ToastCallbackWithAction) UniversalToast.ToastCallback.this;
                    if (view.getId() == findViewById.getId()) {
                        toastCallbackWithAction.onToastClick(0);
                        return;
                    } else if (view.getId() == findViewById2.getId()) {
                        toastCallbackWithAction.onToastClick(-1);
                        return;
                    } else {
                        return;
                    }
                }
                UniversalToast.ToastCallback.this.onToastClick();
            }
        };
        if (findViewById != null) {
            findViewById.setOnClickListener(onClickListener);
        }
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(onClickListener);
        }
        if (ToastUtils.shouldShowSystemToast(context)) {
            mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.13
                @Override // java.lang.Runnable
                public void run() {
                    Toast unused = SingleToast.mSystemToast = new Toast(applicationContext);
                    SingleToast.mSystemToast.setView(linearLayout);
                    SingleToast.mSystemToast.setGravity(81, 0, (int) resources.getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
                    ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                    SingleToast.mSystemToast.show();
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        if (ToastUtils.checkIsOppoRom()) {
            toastCustom.setWindowType(2003);
            if (sDebug) {
                Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        toastCustom.setView(linearLayout);
        toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.aiapps_clickable_toast_view_margin_bottom));
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.toast_animation);
        toastCustom.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showBigPicToast(@NonNull Context context, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (!ToastUtils.shouldShowSystemToast(context)) {
            View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.aiapps_big_pic_toast_view, (ViewGroup) null);
            inflate.setClickable(true);
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.left_img)).setImageDrawable(drawable);
            }
            if (drawable2 != null) {
                ((ImageView) inflate.findViewById(R.id.right_img)).setImageDrawable(drawable2);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) inflate.findViewById(R.id.text_title)) != null) {
                textView.setText(charSequence);
            }
            View findViewById = inflate.findViewById(R.id.big_pic_root);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.aiapps_black));
            }
            inflate.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SingleToast.cancel();
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_open_night_mode);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.widget.toast.SingleToast.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UniversalToast.ToastCallback.this != null) {
                            UniversalToast.ToastCallback.this.onToastClick();
                        }
                        SingleToast.cancel();
                    }
                });
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(inflate);
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.aiapps_big_pic_toast_view_margin_bottom));
            toastCustom.setDuration(i);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.big_pic_animation);
            toastCustom.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cancel() {
        ToastCustom toastCustom;
        if (mToastRef != null && (toastCustom = mToastRef.get()) != null) {
            toastCustom.cancel();
        }
        if (mSystemToast != null) {
            mSystemToast.cancel();
        }
    }

    private static void setToastRef(ToastCustom toastCustom) {
        if (mToastRef != null) {
            mToastRef.clear();
        }
        mToastRef = new WeakReference<>(toastCustom);
    }
}
