package com.baidu.android.ext.widget.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.ext.widget.toast.util.ReplaceViewHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.toast.R;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.UIRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ViewToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICK_CALLBACK_DELAY_MILLIS = 200;
    public static Runnable mCancelRunnable;
    public static WeakReference<View> mToastViewRef;
    public static UniversalToast.OnDismissListener onDismissListener;
    @SuppressLint({"StaticFieldLeak"})
    public static View sMaskView;
    public static boolean sShowMask;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.ext.widget.toast.ViewToast$17  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static class AnonymousClass17 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View val$maskView;
        public final /* synthetic */ View val$toastView;

        public AnonymousClass17(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$toastView = view;
            this.val$maskView = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WeakReference weakReference = new WeakReference(this.val$toastView.getContext());
                if (weakReference.get() == null) {
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), R.anim.toast_exit);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass17 this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            if (this.this$0.val$toastView.getParent() instanceof ViewGroup) {
                                try {
                                    if (this.this$0.val$toastView.getParent() != null) {
                                        ((ViewGroup) this.this$0.val$toastView.getParent()).removeView(this.this$0.val$toastView);
                                        this.this$0.val$toastView.removeCallbacks(ViewToast.mCancelRunnable);
                                        UiThreadUtil.getMainHandler().removeCallbacks(ViewToast.mCancelRunnable);
                                        WeakReference unused = ViewToast.mToastViewRef = null;
                                        Runnable unused2 = ViewToast.mCancelRunnable = null;
                                        if (ViewToast.onDismissListener != null) {
                                            ViewToast.onDismissListener.onDismiss();
                                            UniversalToast.OnDismissListener unused3 = ViewToast.onDismissListener = null;
                                        }
                                    }
                                } catch (Exception unused4) {
                                    this.this$0.val$toastView.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.val$toastView.getParent() == null) {
                                                return;
                                            }
                                            ((ViewGroup) this.this$1.this$0.val$toastView.getParent()).removeView(this.this$1.this$0.val$toastView);
                                            this.this$1.this$0.val$toastView.removeCallbacks(ViewToast.mCancelRunnable);
                                            UiThreadUtil.getMainHandler().removeCallbacks(ViewToast.mCancelRunnable);
                                            WeakReference unused5 = ViewToast.mToastViewRef = null;
                                            Runnable unused6 = ViewToast.mCancelRunnable = null;
                                            if (ViewToast.onDismissListener != null) {
                                                ViewToast.onDismissListener.onDismiss();
                                                UniversalToast.OnDismissListener unused7 = ViewToast.onDismissListener = null;
                                            }
                                        }
                                    });
                                }
                            }
                            View view = this.this$0.val$maskView;
                            if (view != null) {
                                view.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.1.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        View view2;
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (view2 = this.this$1.this$0.val$maskView) == null || view2.getParent() == null || !(this.this$1.this$0.val$maskView.getParent() instanceof ViewGroup)) {
                                            return;
                                        }
                                        ((ViewGroup) this.this$1.this$0.val$maskView.getParent()).removeView(this.this$1.this$0.val$maskView);
                                        View unused5 = ViewToast.sMaskView = null;
                                    }
                                });
                            }
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                        }
                    }
                });
                this.val$toastView.startAnimation(loadAnimation);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-398209008, "Lcom/baidu/android/ext/widget/toast/ViewToast;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-398209008, "Lcom/baidu/android/ext/widget/toast/ViewToast;");
        }
    }

    public ViewToast() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addToastToViewTree(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, @AnimRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{view, view2, Integer.valueOf(i2), layoutParams, Integer.valueOf(i3)}) == null) || view == null || view2 == null) {
            return;
        }
        addToastToViewTree(view, view2, i2, layoutParams, AnimationUtils.loadAnimation(view.getContext(), i3));
    }

    public static synchronized void cancel() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            synchronized (ViewToast.class) {
                if (mToastViewRef != null && (view = mToastViewRef.get()) != null) {
                    view.post(new AnonymousClass17(view, sMaskView));
                }
            }
        }
    }

    public static synchronized void doCancelBeforeShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            synchronized (ViewToast.class) {
                UiThreadUtil.getMainHandler().removeCallbacks(mCancelRunnable);
                cancel();
            }
        }
    }

    public static View getContentView(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public static View getDecorView(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return null;
            }
            return activity.getWindow().getDecorView();
        }
        return (View) invokeL.objValue;
    }

    public static void setOnDismissListener(UniversalToast.OnDismissListener onDismissListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, onDismissListener2) == null) {
            onDismissListener = onDismissListener2;
        }
    }

    public static void show2Icon2BtnToast(Activity activity, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i2, UniversalToast.ToastCallback toastCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{activity, uri, charSequence, uri2, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = activity.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.double_icon_double_text_clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
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
            View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area_left);
            View findViewById2 = linearLayout.findViewById(R.id.gif_toast_click_area);
            View.OnClickListener onClickListener = new View.OnClickListener(toastCallback, findViewById, findViewById2) { // from class: com.baidu.android.ext.widget.toast.ViewToast.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View val$confirmView;
                public final /* synthetic */ View val$dismissView;
                public final /* synthetic */ UniversalToast.ToastCallback val$mToastCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {toastCallback, findViewById, findViewById2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$mToastCallback = toastCallback;
                    this.val$confirmView = findViewById;
                    this.val$dismissView = findViewById2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        UniversalToast.ToastCallback toastCallback2 = this.val$mToastCallback;
                        if (toastCallback2 instanceof UniversalToast.ToastCallbackWithAction) {
                            UniversalToast.ToastCallbackWithAction toastCallbackWithAction = (UniversalToast.ToastCallbackWithAction) toastCallback2;
                            if (view.getId() == this.val$confirmView.getId()) {
                                toastCallbackWithAction.onToastClick(0);
                                ViewToast.cancel();
                                return;
                            } else if (view.getId() == this.val$dismissView.getId()) {
                                toastCallbackWithAction.onToastClick(-1);
                                ViewToast.cancel();
                                return;
                            } else {
                                return;
                            }
                        }
                        toastCallback2.onToastClick();
                    }
                }
            };
            View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            view.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                            return false;
                        } else if (action != 2) {
                            view.setAlpha(1.0f);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
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
            addToastToViewTree(getContentView(activity), linearLayout, i2, layoutParams, R.anim.big_pic_toast_enter);
        }
    }

    public static void showBigPicToast(@NonNull Activity activity, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{activity, drawable, drawable2, charSequence, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View inflate = View.inflate(activity, R.layout.big_pic_toast_view, null);
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
            inflate.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        ViewToast.cancel();
                    }
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_open_night_mode);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    }
                });
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.big_pic_toast_view_margin_bottom);
            addToastToViewTree(getContentView(activity), inflate, i2, layoutParams, R.anim.big_pic_toast_enter);
        }
    }

    public static void showClickableToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2, @Nullable CharSequence charSequence2, int i3, @Nullable UniversalToast.ToastCallback toastCallback, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{activity, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), toastCallback, Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            View decorView = z ? getDecorView(activity) : getContentView(activity);
            if (decorView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(decorView.getContext(), R.layout.clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            View findViewById = linearLayout.findViewById(R.id.clickable_toast_click_area);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i2);
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
                    textView2.setTextSize(1, i2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
            addToastToViewTree(decorView, linearLayout, i3, layoutParams, R.anim.toast_enter);
        }
    }

    public static void showClickableToastWithLeftGif(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{activity, charSequence, uri, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.left_icon_clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            ((SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
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
            addToastToViewTree(contentView, linearLayout, i2, layoutParams, R.anim.toast_enter);
        }
    }

    public static void showClickableToastWithLeftIcon(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{activity, charSequence, drawable, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            try {
                LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.left_icon_clickable_toast_view, null);
                if (linearLayout == null) {
                    return;
                }
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
                    findViewById.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {toastCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$callback = toastCallback;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                                if (toastCallback2 != null) {
                                    toastCallback2.onToastClick();
                                }
                                ViewToast.cancel();
                            }
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
                addToastToViewTree(contentView, linearLayout, i2, layoutParams, R.anim.toast_enter);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static void showClickableToastWithLeftIconNoBtn(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        float dimension;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{activity, charSequence, drawable, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.left_icon_no_btn_clickable_toast_view, null);
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
                findViewById.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) resources.getDimension(R.dimen.dasou_toast_view_height));
            layoutParams.gravity = 81;
            if (DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext()) >= 1080) {
                dimension = resources.getDimension(R.dimen.dasou_toast_view_margin_bottom_toolbar_high);
            } else {
                dimension = resources.getDimension(R.dimen.dasou_toast_view_margin_bottom_toolbar_low);
            }
            layoutParams.bottomMargin = ((int) resources.getDimension(R.dimen.common_tool_bar_height)) + ((int) dimension);
            addToastToViewTree(contentView, linearLayout, i2, layoutParams, R.anim.toast_enter);
        }
    }

    public static void showHighLoadingToast(Activity activity, CharSequence charSequence, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{activity, charSequence, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            sShowMask = z;
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.toast_template_square_d20, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
            linearLayout.findViewById(R.id.highlight_toast_imageView_d20).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.highlight_toast_loading_d20);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.toast_loading_d20));
            TextView textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text_d20);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setTextColor(resources.getColor(R.color.GC6));
                textView.setText(charSequence);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), linearLayout, i2, layoutParams, R.anim.highlight_toast_show_d20);
        }
    }

    public static void showHighlight(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{activity, charSequence, drawable, view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            sShowMask = z;
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.toast_template_square_d20, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
            TextView textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text_d20);
            if (textView != null && !TextUtils.isEmpty(charSequence)) {
                textView.setTextColor(resources.getColor(R.color.GC6));
                textView.setText(charSequence);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.highlight_toast_imageView_d20);
            if (imageView != null) {
                if (view != null) {
                    new ReplaceViewHelper(activity).toReplaceView(imageView, view);
                } else {
                    if (drawable == null) {
                        drawable = resources.getDrawable(R.drawable.highlight_toast_image_d20);
                    }
                    ToastUtils.setColorFilter(drawable);
                    imageView.setImageDrawable(drawable);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.highlight_toast_view_width_new_d20), resources.getDimensionPixelSize(R.dimen.highlight_toast_view_height_new_d20));
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), linearLayout, i2, layoutParams, R.anim.highlight_toast_show_d20);
        }
    }

    public static void showIconTitleMsgBtnToast(@NonNull Activity activity, Uri uri, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, int i4, int i5, int i6, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z;
        Animation animation;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{activity, uri, Integer.valueOf(i2), charSequence, charSequence2, charSequence3, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), toastCallback}) == null) {
            Resources resources = activity.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.icon_title_message_button_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon);
            if (uri != null) {
                simpleDraweeView.setImageURI(uri);
                if (i2 != 1) {
                    simpleDraweeView.getHierarchy().setRoundingParams(new RoundingParams().setRoundAsCircle(false));
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
            } else {
                if (!TextUtils.isEmpty(charSequence)) {
                    textView3.setVisibility(8);
                    textView2.setText(charSequence);
                } else if (!TextUtils.isEmpty(charSequence2)) {
                    textView3.setVisibility(8);
                    textView2.setText(charSequence2);
                } else {
                    textView2.setVisibility(8);
                    textView3.setVisibility(8);
                }
                z = false;
            }
            if (uri == null && !z) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.clickable_toast_single_line_padding);
                ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
            }
            View findViewById = linearLayout.findViewById(R.id.clickable_toast_click_area);
            if (!TextUtils.isEmpty(charSequence3)) {
                if (i3 != 1) {
                    linearLayout.findViewById(R.id.line_text_icon_btn).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(R.id.bg_text_btn);
                    textView.setBackground(resources.getDrawable(R.drawable.toast_button_view_bg));
                    textView.setTextColor(resources.getColor(R.color.white_text));
                    textView.setText(charSequence3);
                } else {
                    linearLayout.findViewById(R.id.bg_text_btn).setVisibility(8);
                    linearLayout.findViewById(R.id.clickable_toast_line).setBackgroundColor(resources.getColor(R.color.white_text));
                    textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
                    textView.setTextColor(resources.getColor(R.color.white_text));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
                }
                findViewById.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    }
                });
                findViewById.setOnTouchListener(new View.OnTouchListener(textView) { // from class: com.baidu.android.ext.widget.toast.ViewToast.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View val$touchStateView;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {textView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$touchStateView = textView;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.val$touchStateView.setAlpha(NightModeHelper.getNightModeSwitcherState() ? 0.5f : 0.2f);
                                return false;
                            } else if (action != 2) {
                                this.val$touchStateView.setAlpha(1.0f);
                                return false;
                            } else {
                                return false;
                            }
                        }
                        return invokeLL.booleanValue;
                    }
                });
            } else {
                findViewById.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = i6 <= 0 ? (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom) : i6;
            if (i4 != 2) {
                animation = AnimationUtils.loadAnimation(activity, R.anim.toast_enter);
            } else {
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.clickable_toast_view_shift_start_y);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(200L);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, dimensionPixelSize2, 0, 0.0f));
                animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                animation = animationSet;
            }
            addToastToViewTree(getContentView(activity), linearLayout, i5, layoutParams, animation);
        }
    }

    public static void showRightButtonToast(@NonNull Activity activity, CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{activity, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), Integer.valueOf(i4), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.right_button_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.right_button_toast_view_bg));
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.right_button_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
                textView.setTextSize(1, i2);
            }
            Button button = (Button) linearLayout.findViewById(R.id.right_button_toast_btn_view);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.custom_blue_btn_corner_bg));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColorStateList(R.color.custom_blue_btn_text_color_selector));
                    button.setTextSize(1, i3);
                }
            }
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = toastCallback;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                            if (toastCallback2 != null) {
                                toastCallback2.onToastClick();
                            }
                            ViewToast.cancel();
                        }
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.button_toast_view_margin_bottom);
            addToastToViewTree(contentView, linearLayout, i4, layoutParams, R.anim.toast_enter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate2(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @NonNull TextColorHolder textColorHolder2, int i2, @NonNull ToastLocation toastLocation, boolean z, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z2;
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{activity, uri, drawable, view, charSequence, textColorHolder, charSequence2, textColorHolder2, Integer.valueOf(i2), toastLocation, Boolean.valueOf(z), toastCallback}) == null) || activity == null) {
            return;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        View decorView = z ? getDecorView(activity) : getContentView(activity);
        if (decorView == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.toast_template_a_d20, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon_fresco);
        TextView textView = (TextView) linearLayout.findViewById(R.id.left_toast_info_view);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.right_toast_click_area);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.right_toast_jump_text);
        View findViewById = linearLayout.findViewById(R.id.right_toast_vertical_line);
        if (!TextUtils.isEmpty(charSequence)) {
            if (textColorHolder != null) {
                textView.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder.nightColor : textColorHolder.dayColor);
            }
            if (uri == null && drawable == null && view == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(activity, 200.0f));
            } else {
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new ReplaceViewHelper(activity).toReplaceView(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    z2 = true;
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(activity, !z2 ? 14.0f : 5.0f), DeviceUtil.ScreenInfo.dp2px(activity, 9.0f), DeviceUtil.ScreenInfo.dp2px(activity, 14.0f), DeviceUtil.ScreenInfo.dp2px(activity, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        ((ImageView) linearLayout.findViewById(R.id.right_jump_img)).setImageDrawable(resources.getDrawable(R.drawable.toast_right_jump_d20));
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        textView2.setText(charSequence2);
                        if (textColorHolder2 != null) {
                            textView2.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder2.nightColor : textColorHolder2.dayColor);
                        }
                        findViewById.setBackground(resources.getDrawable(R.color.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {toastCallback};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$callback = toastCallback;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                        UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                                        if (toastCallback2 != null) {
                                            toastCallback2.onToastClick();
                                        }
                                        ViewToast.cancel();
                                    }
                                }
                            });
                            ToastUtils.processAlpha(linearLayout2);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        if (ToastLocation.BOTTOM != toastLocation2) {
                            layoutParams2.gravity = 81;
                            layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
                        } else {
                            layoutParams2.gravity = 17;
                        }
                        addToastToViewTree(decorView, linearLayout, i2, layoutParams2, R.anim.toast_enter);
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        ToastUtils.setColorFilter(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(DeviceUtil.ScreenInfo.dp2px(activity, !z2 ? 14.0f : 5.0f), DeviceUtil.ScreenInfo.dp2px(activity, 9.0f), DeviceUtil.ScreenInfo.dp2px(activity, 14.0f), DeviceUtil.ScreenInfo.dp2px(activity, 10.0f));
                textView.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-2, -2);
            if (ToastLocation.BOTTOM != toastLocation2) {
            }
            addToastToViewTree(decorView, linearLayout, i2, layoutParams22, R.anim.toast_enter);
            return;
        }
        ToastUtils.printStackTraceString("has no main text");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate3(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @NonNull TextColorHolder textColorHolder2, @Nullable ToastRightAreaStyle toastRightAreaStyle, boolean z, int i2, boolean z2, UniversalToast.ToastCallback toastCallback, UniversalToast.ToastCallback toastCallback2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{activity, uri, drawable, view, charSequence, textColorHolder, charSequence2, charSequence3, textColorHolder2, toastRightAreaStyle, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), toastCallback, toastCallback2}) == null) || activity == null) {
            return;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        View decorView = z2 ? getDecorView(activity) : getContentView(activity);
        if (decorView == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.toast_template_b_d20, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
        boolean z3 = true;
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.text_area);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon);
        simpleDraweeView.setVisibility(0);
        if (view != null) {
            new ReplaceViewHelper(activity).toReplaceView(simpleDraweeView, view);
        } else if (drawable != null) {
            ToastUtils.setColorFilter(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(activity, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = (TextView) linearLayout.findViewById(R.id.title);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.sub_title);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.one_line_text);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z3) {
                        textView.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(activity, 175.0f));
                        textView2.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(activity, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    if (textColorHolder != null) {
                        textView.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder.nightColor : textColorHolder.dayColor);
                    }
                    textView2.setTextColor(resources.getColor(R.color.GC4));
                    textView3.setVisibility(8);
                } else {
                    if (z3) {
                        textView3.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(activity, 175.0f));
                    }
                    textView3.setText(charSequence);
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    if (textColorHolder != null) {
                        textView3.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder.nightColor : textColorHolder.dayColor);
                    }
                }
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.btn_area);
                LinearLayout linearLayout4 = (LinearLayout) linearLayout.findViewById(R.id.jump_area);
                TextView textView4 = (TextView) linearLayout.findViewById(R.id.btn_text);
                textView4.setBackground(resources.getDrawable(R.drawable.template_2_btn_bg_d20));
                TextView textView5 = (TextView) linearLayout.findViewById(R.id.jump_text);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.jump_view);
                View findViewById = linearLayout.findViewById(R.id.right_toast_vertical_line);
                ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.btnStyle_close_view);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        linearLayout3.setVisibility(0);
                        linearLayout4.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setTextColor(resources.getColor(R.color.GC6));
                        if (z) {
                            imageView2.setVisibility(0);
                            imageView2.setImageDrawable(resources.getDrawable(R.drawable.toast_cancel));
                            if (linearLayout3 != null) {
                                linearLayout3.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.ViewToast.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {toastCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.val$callback = toastCallback;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                            ViewToast.cancel();
                                            UiThreadUtil.getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.2.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass2 this$0;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i3 = newInitContext.flag;
                                                        if ((i3 & 1) != 0) {
                                                            int i4 = i3 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    UniversalToast.ToastCallback toastCallback3;
                                                    Interceptable interceptable3 = $ic;
                                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (toastCallback3 = this.this$0.val$callback) == null) {
                                                        return;
                                                    }
                                                    toastCallback3.onToastClick();
                                                }
                                            }, 200L);
                                        }
                                    }
                                });
                                ToastUtils.processAlpha(linearLayout3);
                            }
                            if (imageView2 != null) {
                                imageView2.setOnClickListener(new View.OnClickListener(toastCallback2) { // from class: com.baidu.android.ext.widget.toast.ViewToast.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ UniversalToast.ToastCallback val$cancelCallback;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {toastCallback2};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.val$cancelCallback = toastCallback2;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                            ViewToast.cancel();
                                            UiThreadUtil.getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.3.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass3 this$0;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i3 = newInitContext.flag;
                                                        if ((i3 & 1) != 0) {
                                                            int i4 = i3 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$0 = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    UniversalToast.ToastCallback toastCallback3;
                                                    Interceptable interceptable3 = $ic;
                                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (toastCallback3 = this.this$0.val$cancelCallback) == null) {
                                                        return;
                                                    }
                                                    toastCallback3.onToastClick();
                                                }
                                            }, 200L);
                                        }
                                    }
                                });
                                ToastUtils.processAlpha(imageView2);
                            }
                        } else {
                            imageView2.setVisibility(8);
                        }
                    } else {
                        linearLayout4.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView5.setText(charSequence3);
                        if (textColorHolder2 != null) {
                            textView5.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder2.nightColor : textColorHolder2.dayColor);
                        }
                        imageView.setImageDrawable(resources.getDrawable(R.drawable.toast_right_jump_d20));
                        findViewById.setBackground(resources.getDrawable(R.color.GC36));
                        linearLayout3 = linearLayout4;
                    }
                    imageView2 = null;
                    if (linearLayout3 != null) {
                    }
                    if (imageView2 != null) {
                    }
                } else {
                    linearLayout3.setVisibility(8);
                    linearLayout4.setVisibility(8);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
                addToastToViewTree(decorView, linearLayout, i2, layoutParams2, R.anim.toast_enter);
                return;
            }
            ToastUtils.printStackTraceString("has no main text");
            return;
        }
        z3 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.title);
        TextView textView22 = (TextView) linearLayout.findViewById(R.id.sub_title);
        TextView textView32 = (TextView) linearLayout.findViewById(R.id.one_line_text);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public static void showToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2, int i3, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{activity, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(activity, R.layout.normal_toast_view, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
            sShowMask = z;
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
                if (i3 >= 2) {
                    textView.setSingleLine(false);
                    textView.setMaxLines(i3);
                    textView.setGravity(17);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), relativeLayout, i2, layoutParams, R.anim.toast_enter);
        }
    }

    public static void showToastBottom(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65567, null, activity, charSequence, i2) == null) {
            Resources resources = activity.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(activity, R.layout.normal_toast_view, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
            addToastToViewTree(getContentView(activity), relativeLayout, i2, layoutParams, R.anim.toast_enter);
        }
    }

    public static void addToastToViewTree(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{view, view2, Integer.valueOf(i2), layoutParams, animation}) == null) || view == null || view2 == null) {
            return;
        }
        Context context = view.getContext();
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        view2.setClickable(true);
        if (view instanceof ViewGroup) {
            view.post(new Runnable(view, context, view2, layoutParams, animation) { // from class: com.baidu.android.ext.widget.toast.ViewToast.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animation val$anim;
                public final /* synthetic */ View val$container;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ FrameLayout.LayoutParams val$layoutParams;
                public final /* synthetic */ View val$parent;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view, context, view2, layoutParams, animation};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$parent = view;
                    this.val$context = context;
                    this.val$container = view2;
                    this.val$layoutParams = layoutParams;
                    this.val$anim = animation;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (ViewToast.sShowMask && this.val$parent != null) {
                            if (ViewToast.sMaskView != null && (ViewToast.sMaskView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) ViewToast.sMaskView.getParent()).removeView(ViewToast.sMaskView);
                            }
                            Context context2 = this.val$context;
                            if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                                return;
                            }
                            FrameLayout frameLayout = new FrameLayout(this.val$context);
                            frameLayout.setClickable(true);
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                            layoutParams2.topMargin = UniversalToast.getSwanAppStatusBarAndActionBarHeight(this.val$context);
                            View view4 = this.val$parent;
                            if (view4 instanceof ViewGroup) {
                                ((ViewGroup) view4).addView(frameLayout, layoutParams2);
                                View unused = ViewToast.sMaskView = frameLayout;
                            }
                        }
                        if (ViewToast.mToastViewRef != null && (view3 = (View) ViewToast.mToastViewRef.get()) != null && (view3.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) view3.getParent()).removeView(view3);
                        }
                        Context context3 = this.val$context;
                        if ((context3 instanceof Activity) && ((Activity) context3).isFinishing()) {
                            return;
                        }
                        ((ViewGroup) this.val$parent).addView(this.val$container, this.val$layoutParams);
                        this.val$container.startAnimation(this.val$anim);
                        WeakReference unused2 = ViewToast.mToastViewRef = new WeakReference(this.val$container);
                    }
                }
            });
            if (mCancelRunnable == null) {
                mCancelRunnable = new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ViewToast.cancel();
                        }
                    }
                };
            }
            UiThreadUtil.getMainHandler().postDelayed(mCancelRunnable, i2 * 1000);
        }
    }
}
