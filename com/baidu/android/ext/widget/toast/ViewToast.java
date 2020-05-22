package com.baidu.android.ext.widget.toast;

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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.UIRuntime;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
class ViewToast {
    private static Runnable mCancelRunnable;
    private static WeakReference<View> mToastViewRef;
    private static UniversalToast.OnDismissListener onDismissListener;
    private static View sMaskView;
    private static boolean sShowMask = false;

    ViewToast() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, int i2, boolean z) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
        sShowMask = z;
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(R.color.white_text));
            textView.setText(charSequence);
            if (i2 >= 2) {
                textView.setSingleLine(false);
                textView.setMaxLines(i2);
                textView.setGravity(17);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, R.anim.toast_enter);
    }

    static View getContentView(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    static View getDecorView(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showToastBottom(@NonNull Activity activity, @NonNull CharSequence charSequence, int i) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(R.color.white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
        addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, R.anim.toast_enter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighlight(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i, boolean z) {
        Resources resources = activity.getResources();
        sShowMask = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text);
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(resources.getColor(R.color.white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable == null) {
                drawable = resources.getDrawable(R.drawable.highlight_toast_image);
            }
            imageView.setImageDrawable(drawable);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, R.anim.highlight_toast_show);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showHighLoadingToast(Activity activity, CharSequence charSequence, int i, boolean z) {
        Resources resources = activity.getResources();
        sShowMask = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(R.id.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(R.color.white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, R.anim.highlight_toast_show);
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
                view.post(new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view3;
                        if (ViewToast.sShowMask && view != null) {
                            if (ViewToast.sMaskView != null && (ViewToast.sMaskView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) ViewToast.sMaskView.getParent()).removeView(ViewToast.sMaskView);
                            }
                            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                                FrameLayout frameLayout = new FrameLayout(context);
                                frameLayout.setClickable(true);
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams2.topMargin = UniversalToast.getSwanAppStatusBarAndActionBarHeight(context);
                                if (view instanceof ViewGroup) {
                                    ((ViewGroup) view).addView(frameLayout, layoutParams2);
                                    View unused = ViewToast.sMaskView = frameLayout;
                                }
                            } else {
                                return;
                            }
                        }
                        if (ViewToast.mToastViewRef != null && (view3 = (View) ViewToast.mToastViewRef.get()) != null && (view3.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) view3.getParent()).removeView(view3);
                        }
                        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                            ((ViewGroup) view).addView(view2, layoutParams);
                            view2.startAnimation(animation);
                            WeakReference unused2 = ViewToast.mToastViewRef = new WeakReference(view2);
                        }
                    }
                });
                if (mCancelRunnable == null) {
                    mCancelRunnable = new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewToast.cancel();
                        }
                    };
                }
                UiThreadUtil.getMainHandler().postDelayed(mCancelRunnable, i * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable final UniversalToast.ToastCallback toastCallback, boolean z) {
        TextView textView;
        Resources resources = activity.getResources();
        View decorView = z ? getDecorView(activity) : getContentView(activity);
        if (decorView != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(decorView.getContext()).inflate(R.layout.clickable_toast_view, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            View findViewById = linearLayout.findViewById(R.id.clickable_toast_click_area);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i);
            }
            View findViewById2 = linearLayout.findViewById(R.id.clickable_toast_line);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(resources.getColor(R.color.white_text));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.white_text));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                    textView2.setTextSize(1, i);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UniversalToast.ToastCallback.this != null) {
                            UniversalToast.ToastCallback.this.onToastClick();
                        }
                        ViewToast.cancel();
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
            addToastToViewTree(decorView, linearLayout, i2, layoutParams, R.anim.toast_enter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToastWithLeftGif(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Resources resources = activity.getResources();
        View contentView = getContentView(activity);
        if (contentView != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(contentView.getContext()).inflate(R.layout.left_icon_clickable_toast_view, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            ((SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon)).setController(c.dvf().wa(true).Q(uri).dvW());
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UniversalToast.ToastCallback.this != null) {
                            UniversalToast.ToastCallback.this.onToastClick();
                        }
                        ViewToast.cancel();
                    }
                });
            }
            View findViewById2 = linearLayout.findViewById(R.id.gif_toast_line);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(resources.getColor(R.color.white_text));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.white_text));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gif_toast_icon_view);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
            addToastToViewTree(contentView, linearLayout, i, layoutParams, R.anim.toast_enter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToastWithLeftIcon(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Resources resources = activity.getResources();
        View contentView = getContentView(activity);
        if (contentView != null) {
            try {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(contentView.getContext()).inflate(R.layout.left_icon_clickable_toast_view, (ViewGroup) null);
                linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
                if (simpleDraweeView != null) {
                    simpleDraweeView.setImageDrawable(drawable);
                }
                if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                    textView.setTextColor(resources.getColor(R.color.white_text));
                    textView.setText(charSequence);
                }
                View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (UniversalToast.ToastCallback.this != null) {
                                UniversalToast.ToastCallback.this.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    });
                }
                View findViewById2 = linearLayout.findViewById(R.id.gif_toast_line);
                if (findViewById2 != null) {
                    findViewById2.setBackgroundColor(resources.getColor(R.color.white_text));
                }
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
                if (textView2 != null) {
                    textView2.setTextColor(resources.getColor(R.color.white_text));
                    if (!TextUtils.isEmpty(charSequence2)) {
                        textView2.setText(charSequence2);
                    }
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gif_toast_icon_view);
                if (imageView != null) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
                addToastToViewTree(contentView, linearLayout, i, layoutParams, R.anim.toast_enter);
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showClickableToastWithLeftIconNoBtn(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        int dimension;
        TextView textView;
        Resources resources = activity.getResources();
        View contentView = getContentView(activity);
        if (contentView != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(contentView.getContext()).inflate(R.layout.left_icon_no_btn_clickable_toast_view, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_circle_toast_view_bg));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageDrawable(drawable);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                textView.setMaxLines(1);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.gif_toast_view);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UniversalToast.ToastCallback.this != null) {
                            UniversalToast.ToastCallback.this.onToastClick();
                        }
                        ViewToast.cancel();
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) resources.getDimension(R.dimen.dasou_toast_view_height));
            layoutParams.gravity = 81;
            if (DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext()) >= 1080) {
                dimension = (int) resources.getDimension(R.dimen.dasou_toast_view_margin_bottom_toolbar_high);
            } else {
                dimension = (int) resources.getDimension(R.dimen.dasou_toast_view_margin_bottom_toolbar_low);
            }
            layoutParams.bottomMargin = dimension + ((int) resources.getDimension(R.dimen.common_tool_bar_height));
            addToastToViewTree(contentView, linearLayout, i, layoutParams, R.anim.toast_enter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showRightButtonToast(@NonNull Activity activity, CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Resources resources = activity.getResources();
        View contentView = getContentView(activity);
        if (contentView != null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(contentView.getContext()).inflate(R.layout.right_button_toast_view, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.right_button_toast_view_bg));
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.right_button_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
                textView.setTextSize(1, i);
            }
            Button button = (Button) linearLayout.findViewById(R.id.right_button_toast_btn_view);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.custom_blue_btn_corner_bg));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColorStateList(R.color.custom_blue_btn_text_color_selector));
                    button.setTextSize(1, i2);
                }
            }
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (UniversalToast.ToastCallback.this != null) {
                            UniversalToast.ToastCallback.this.onToastClick();
                        }
                        ViewToast.cancel();
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.button_toast_view_margin_bottom);
            addToastToViewTree(contentView, linearLayout, i3, layoutParams, R.anim.toast_enter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showIconTitleMsgBtnToast(@NonNull Activity activity, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, int i4, @Nullable final UniversalToast.ToastCallback toastCallback) {
        boolean z;
        Animation animation;
        final TextView textView;
        Resources resources = activity.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i != 1) {
                simpleDraweeView.getHierarchy().a(new RoundingParams().wf(false));
            }
        } else {
            simpleDraweeView.setVisibility(8);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.title_text);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.message_text);
        textView2.setTextColor(resources.getColor(R.color.white_text));
        textView3.setTextColor(resources.getColor(R.color.white_text));
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
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.clickable_toast_single_line_padding);
            ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        View findViewById = linearLayout.findViewById(R.id.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence3)) {
            switch (i2) {
                case 1:
                    linearLayout.findViewById(R.id.bg_text_btn).setVisibility(8);
                    linearLayout.findViewById(R.id.clickable_toast_line).setBackgroundColor(resources.getColor(R.color.white_text));
                    textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
                    textView.setTextColor(resources.getColor(R.color.white_text));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
                    break;
                default:
                    linearLayout.findViewById(R.id.line_text_icon_btn).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(R.id.bg_text_btn);
                    textView.setBackground(resources.getDrawable(R.drawable.toast_button_view_bg));
                    textView.setTextColor(resources.getColor(R.color.white_text));
                    textView.setText(charSequence3);
                    break;
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UniversalToast.ToastCallback.this != null) {
                        UniversalToast.ToastCallback.this.onToastClick();
                    }
                    ViewToast.cancel();
                }
            });
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.9
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            textView.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
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
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
        switch (i3) {
            case 2:
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.clickable_toast_view_shift_start_y);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(200L);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, dimensionPixelSize2, 0, 0.0f));
                animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                animation = animationSet;
                break;
            default:
                animation = AnimationUtils.loadAnimation(activity, R.anim.toast_enter);
                break;
        }
        addToastToViewTree(getContentView(activity), linearLayout, i4, layoutParams, animation);
    }

    public static void show2Icon2BtnToast(Activity activity, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i, final UniversalToast.ToastCallback toastCallback) {
        Resources resources = activity.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.double_icon_double_text_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
        if (simpleDraweeView != null) {
            if (uri != null) {
                simpleDraweeView.setImageURI(uri);
            } else {
                simpleDraweeView.setVisibility(8);
            }
        }
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_icon_view);
        if (simpleDraweeView2 != null) {
            if (uri2 != null) {
                simpleDraweeView2.setImageURI(uri2);
            } else {
                simpleDraweeView2.setVisibility(8);
            }
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view);
        textView.setTextColor(resources.getColor(R.color.white_text));
        textView.setText(charSequence);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
        textView2.setTextColor(resources.getColor(R.color.white_text));
        textView2.setText(charSequence2);
        final View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area_left);
        final View findViewById2 = linearLayout.findViewById(R.id.gif_toast_click_area);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UniversalToast.ToastCallback.this instanceof UniversalToast.ToastCallbackWithAction) {
                    UniversalToast.ToastCallbackWithAction toastCallbackWithAction = (UniversalToast.ToastCallbackWithAction) UniversalToast.ToastCallback.this;
                    if (view.getId() == findViewById.getId()) {
                        toastCallbackWithAction.onToastClick(0);
                        ViewToast.cancel();
                        return;
                    } else if (view.getId() == findViewById2.getId()) {
                        toastCallbackWithAction.onToastClick(-1);
                        ViewToast.cancel();
                        return;
                    } else {
                        return;
                    }
                }
                UniversalToast.ToastCallback.this.onToastClick();
            }
        };
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                        return false;
                    case 1:
                    default:
                        view.setAlpha(1.0f);
                        return false;
                    case 2:
                        return false;
                }
            }
        };
        if (findViewById != null) {
            findViewById.setOnClickListener(onClickListener);
            findViewById.setOnTouchListener(onTouchListener);
        }
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(onClickListener);
            findViewById2.setOnTouchListener(onTouchListener);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.big_pic_toast_view_margin_bottom);
        addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, R.anim.big_pic_toast_enter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showBigPicToast(@NonNull Activity activity, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i, @Nullable final UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Resources resources = activity.getResources();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.big_pic_toast_view, (ViewGroup) null);
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
            findViewById.setBackgroundColor(resources.getColor(R.color.black));
        }
        inflate.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewToast.cancel();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.btn_open_night_mode);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (UniversalToast.ToastCallback.this != null) {
                        UniversalToast.ToastCallback.this.onToastClick();
                    }
                    ViewToast.cancel();
                }
            });
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.big_pic_toast_view_margin_bottom);
        addToastToViewTree(getContentView(activity), inflate, i, layoutParams, R.anim.big_pic_toast_enter);
    }

    public static synchronized void cancel() {
        synchronized (ViewToast.class) {
            if (mToastViewRef != null) {
                View view = mToastViewRef.get();
                if (view != null) {
                    view.post(new AnonymousClass14(view, sMaskView));
                    view.removeCallbacks(mCancelRunnable);
                    UiThreadUtil.getMainHandler().removeCallbacks(mCancelRunnable);
                }
                mToastViewRef = null;
                mCancelRunnable = null;
                sMaskView = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.ext.widget.toast.ViewToast$14  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static class AnonymousClass14 implements Runnable {
        final /* synthetic */ View val$maskView;
        final /* synthetic */ View val$toastView;

        AnonymousClass14(View view, View view2) {
            this.val$toastView = view;
            this.val$maskView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference weakReference = new WeakReference(this.val$toastView.getContext());
            if (weakReference.get() != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), R.anim.toast_exit);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.14.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (AnonymousClass14.this.val$toastView.getParent() instanceof ViewGroup) {
                            try {
                                if (AnonymousClass14.this.val$toastView.getParent() != null) {
                                    ((ViewGroup) AnonymousClass14.this.val$toastView.getParent()).removeView(AnonymousClass14.this.val$toastView);
                                    if (ViewToast.onDismissListener != null) {
                                        ViewToast.onDismissListener.onDismiss();
                                        UniversalToast.OnDismissListener unused = ViewToast.onDismissListener = null;
                                    }
                                }
                            } catch (Exception e) {
                                AnonymousClass14.this.val$toastView.post(new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.14.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AnonymousClass14.this.val$toastView.getParent() != null) {
                                            ((ViewGroup) AnonymousClass14.this.val$toastView.getParent()).removeView(AnonymousClass14.this.val$toastView);
                                            if (ViewToast.onDismissListener != null) {
                                                ViewToast.onDismissListener.onDismiss();
                                                UniversalToast.OnDismissListener unused2 = ViewToast.onDismissListener = null;
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (AnonymousClass14.this.val$maskView != null) {
                            AnonymousClass14.this.val$maskView.post(new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.14.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (AnonymousClass14.this.val$maskView != null && AnonymousClass14.this.val$maskView.getParent() != null && (AnonymousClass14.this.val$maskView.getParent() instanceof ViewGroup)) {
                                        ((ViewGroup) AnonymousClass14.this.val$maskView.getParent()).removeView(AnonymousClass14.this.val$maskView);
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

    public static void setOnDismissListener(UniversalToast.OnDismissListener onDismissListener2) {
        onDismissListener = onDismissListener2;
    }
}
