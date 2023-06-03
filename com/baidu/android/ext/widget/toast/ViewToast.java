package com.baidu.android.ext.widget.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.ext.widget.toast.util.ReplaceViewHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.config.utils.ResUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.UIRuntime;
import com.baidu.tieba.R;
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
/* loaded from: classes.dex */
public class ViewToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICK_CALLBACK_DELAY_MILLIS = 200;
    public static Runnable mCancelRunnable;
    public static Runnable mCancelWindowRunnable;
    public static WeakReference<View> mToastViewRef;
    public static WeakReference<WindowManager> mWindowManagerWeakReference;
    public static UniversalToast.OnDismissListener onDismissListener;
    @SuppressLint({"StaticFieldLeak"})
    public static View sMaskView;
    public static boolean sShowMask;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* renamed from: com.baidu.android.ext.widget.toast.ViewToast$17  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass17 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View val$maskView;
        public final /* synthetic */ View val$toastView;

        public AnonymousClass17(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$toastView = view2;
            this.val$maskView = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WeakReference weakReference = new WeakReference(this.val$toastView.getContext());
                if (weakReference.get() == null) {
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), R.anim.obfuscated_res_0x7f010175);
                Context context = (Context) weakReference.get();
                Lifecycle lifecycle = null;
                if (context instanceof LifecycleOwner) {
                    lifecycle = ((LifecycleOwner) context).getLifecycle();
                }
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver(this, loadAnimation, lifecycle) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass17 this$0;
                    public final /* synthetic */ Animation val$animation;
                    public final /* synthetic */ Lifecycle val$finalLifecycle;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, loadAnimation, lifecycle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$animation = loadAnimation;
                        this.val$finalLifecycle = lifecycle;
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_DESTROY) {
                            try {
                                if (this.val$animation != null) {
                                    this.val$animation.cancel();
                                }
                                if (this.val$finalLifecycle != null) {
                                    this.val$finalLifecycle.removeObserver(this);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                };
                if (lifecycle != null) {
                    try {
                        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                            lifecycle.addObserver(lifecycleEventObserver);
                        }
                    } catch (Exception unused) {
                    }
                }
                loadAnimation.setAnimationListener(new Animation.AnimationListener(this, lifecycle, lifecycleEventObserver) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass17 this$0;
                    public final /* synthetic */ Lifecycle val$finalLifecycle;
                    public final /* synthetic */ LifecycleEventObserver val$observer;

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

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, lifecycle, lifecycleEventObserver};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$finalLifecycle = lifecycle;
                        this.val$observer = lifecycleEventObserver;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            if (this.this$0.val$toastView.getParent() instanceof ViewGroup) {
                                try {
                                    if (this.this$0.val$toastView.getParent() != null) {
                                        this.this$0.val$toastView.setVisibility(8);
                                        ((ViewGroup) this.this$0.val$toastView.getParent()).removeView(this.this$0.val$toastView);
                                        this.this$0.val$toastView.removeCallbacks(ViewToast.mCancelRunnable);
                                        UiThreadUtils.getMainHandler().removeCallbacks(ViewToast.mCancelRunnable);
                                        WeakReference unused2 = ViewToast.mToastViewRef = null;
                                        Runnable unused3 = ViewToast.mCancelRunnable = null;
                                        if (ViewToast.onDismissListener != null) {
                                            ViewToast.onDismissListener.onDismiss();
                                            UniversalToast.OnDismissListener unused4 = ViewToast.onDismissListener = null;
                                        }
                                    }
                                } catch (Exception unused5) {
                                    this.this$0.val$toastView.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
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
                                            if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.this$1.this$0.val$toastView.getParent() != null) {
                                                ((ViewGroup) this.this$1.this$0.val$toastView.getParent()).removeView(this.this$1.this$0.val$toastView);
                                                this.this$1.this$0.val$toastView.removeCallbacks(ViewToast.mCancelRunnable);
                                                UiThreadUtils.getMainHandler().removeCallbacks(ViewToast.mCancelRunnable);
                                                WeakReference unused6 = ViewToast.mToastViewRef = null;
                                                Runnable unused7 = ViewToast.mCancelRunnable = null;
                                                if (ViewToast.onDismissListener != null) {
                                                    ViewToast.onDismissListener.onDismiss();
                                                    UniversalToast.OnDismissListener unused8 = ViewToast.onDismissListener = null;
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                            View view2 = this.this$0.val$maskView;
                            if (view2 != null) {
                                view2.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.17.2.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        View view3;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (view3 = this.this$1.this$0.val$maskView) != null && view3.getParent() != null && (this.this$1.this$0.val$maskView.getParent() instanceof ViewGroup)) {
                                            ((ViewGroup) this.this$1.this$0.val$maskView.getParent()).removeView(this.this$1.this$0.val$maskView);
                                            View unused6 = ViewToast.sMaskView = null;
                                        }
                                    }
                                });
                            }
                            try {
                                if (this.val$finalLifecycle != null) {
                                    this.val$finalLifecycle.removeObserver(this.val$observer);
                                }
                            } catch (Exception unused6) {
                            }
                        }
                    }
                });
                this.val$toastView.startAnimation(loadAnimation);
            }
        }
    }

    public ViewToast() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void doCancelBeforeShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            synchronized (ViewToast.class) {
                UiThreadUtils.getMainHandler().removeCallbacks(mCancelRunnable);
                UiThreadUtils.getMainHandler().removeCallbacks(mCancelWindowRunnable);
                cancel();
            }
        }
    }

    public static int getTemplate3Height() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (FontSizeHelper.getFontSizeType() <= 1) {
                return R.dimen.obfuscated_res_0x7f070307;
            }
            if (FontSizeHelper.getFontSizeType() <= 2) {
                return R.dimen.obfuscated_res_0x7f07030b;
            }
            return R.dimen.obfuscated_res_0x7f070314;
        }
        return invokeV.intValue;
    }

    public static void recycler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            mCancelRunnable = null;
            mCancelWindowRunnable = null;
            mToastViewRef = null;
            mWindowManagerWeakReference = null;
            onDismissListener = null;
        }
    }

    public static int getTemplate3TitleMaxWidth(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, activity)) == null) {
            return DeviceUtil.ScreenInfo.dp2px(activity, 175.0f);
        }
        return invokeL.intValue;
    }

    public static void setAdapterHighlightTopView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, view2) == null) {
            FontSizeViewExtKt.setScaledMarginRes(view2, 0, R.dimen.obfuscated_res_0x7f0702f5, R.dimen.obfuscated_res_0x7f0702e7, R.dimen.obfuscated_res_0x7f0702f5, R.dimen.obfuscated_res_0x7f0702d8);
            FontSizeViewExtKt.setScaledSizeRes(view2, 0, R.dimen.obfuscated_res_0x7f0702f8, R.dimen.obfuscated_res_0x7f0702f8);
        }
    }

    public static void setOnDismissListener(UniversalToast.OnDismissListener onDismissListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, onDismissListener2) == null) {
            onDismissListener = onDismissListener2;
        }
    }

    public static void addToastToViewTree(View view2, View view3, int i, FrameLayout.LayoutParams layoutParams, @AnimRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{view2, view3, Integer.valueOf(i), layoutParams, Integer.valueOf(i2)}) == null) && view2 != null && view3 != null) {
            addToastToViewTree(view2, view3, i, layoutParams, AnimationUtils.loadAnimation(view2.getContext(), i2));
        }
    }

    public static void addToastToViewTree(View view2, View view3, int i, FrameLayout.LayoutParams layoutParams, Animation animation) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{view2, view3, Integer.valueOf(i), layoutParams, animation}) == null) && view2 != null && view3 != null) {
            Context context = view2.getContext();
            if (view3.getParent() instanceof ViewGroup) {
                ((ViewGroup) view3.getParent()).removeView(view3);
            }
            view3.setClickable(true);
            if (view2 instanceof ViewGroup) {
                view2.post(new Runnable(view2, context, view3, layoutParams, animation) { // from class: com.baidu.android.ext.widget.toast.ViewToast.4
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
                            Object[] objArr = {view2, context, view3, layoutParams, animation};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$parent = view2;
                        this.val$context = context;
                        this.val$container = view3;
                        this.val$layoutParams = layoutParams;
                        this.val$anim = animation;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        View view4;
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
                                View view5 = this.val$parent;
                                if (view5 instanceof ViewGroup) {
                                    ((ViewGroup) view5).addView(frameLayout, layoutParams2);
                                    View unused = ViewToast.sMaskView = frameLayout;
                                }
                            }
                            if (ViewToast.mToastViewRef != null && (view4 = (View) ViewToast.mToastViewRef.get()) != null && (view4.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) view4.getParent()).removeView(view4);
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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
                UiThreadUtils.getMainHandler().postDelayed(mCancelRunnable, i * 1000);
            }
        }
    }

    public static void showToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, int i2, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{activity, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d06fb, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081088));
            sShowMask = z;
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091905)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setText(charSequence);
                if (i2 >= 2) {
                    textView.setSingleLine(false);
                    textView.setMaxLines(i2);
                    textView.setGravity(17);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }

    public static void addToastToWindow(Activity activity, View view2, long j, WindowManager.LayoutParams layoutParams) {
        WindowManager windowManagerOrNull;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, view2, Long.valueOf(j), layoutParams}) == null) && activity != null && view2 != null && layoutParams != null && !activity.isFinishing()) {
            if ((Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) || (windowManagerOrNull = ToastExtKt.getWindowManagerOrNull(activity)) == null) {
                return;
            }
            try {
                view2.setId(R.id.obfuscated_res_0x7f092508);
                ToastExtKt.removeViewBeforeAdd(view2, windowManagerOrNull);
                if (mToastViewRef != null) {
                    ToastExtKt.removeViewBeforeAdd(mToastViewRef.get(), windowManagerOrNull);
                }
                windowManagerOrNull.addView(view2, layoutParams);
                mToastViewRef = new WeakReference<>(view2);
                mWindowManagerWeakReference = new WeakReference<>(windowManagerOrNull);
                mCancelWindowRunnable = new Runnable() { // from class: com.baidu.android.ext.widget.toast.ViewToast.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                UiThreadUtils.getMainHandler().postDelayed(mCancelWindowRunnable, j * 1000);
            } catch (Exception unused) {
                recycler();
            }
        }
    }

    public static synchronized void cancel() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            synchronized (ViewToast.class) {
                if (mToastViewRef != null && (view2 = mToastViewRef.get()) != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f092508) {
                        cancelWindow();
                        return;
                    }
                    view2.post(new AnonymousClass17(view2, sMaskView));
                }
            }
        }
    }

    public static synchronized void cancelWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            synchronized (ViewToast.class) {
                try {
                    if (mToastViewRef != null) {
                        View view2 = mToastViewRef.get();
                        if (view2 == null) {
                            recycler();
                            return;
                        } else if (view2.getId() != R.id.obfuscated_res_0x7f092508) {
                            recycler();
                            return;
                        } else if (mWindowManagerWeakReference != null) {
                            boolean removeViewBeforeAddByWm = ToastExtKt.removeViewBeforeAddByWm(view2, mWindowManagerWeakReference.get());
                            UiThreadUtils.getMainHandler().removeCallbacks(mCancelWindowRunnable);
                            if (onDismissListener != null && removeViewBeforeAddByWm) {
                                onDismissListener.onDismiss();
                            }
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    recycler();
                    throw th;
                }
                recycler();
            }
        }
    }

    public static View getContentView(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, activity)) == null) {
            if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                return activity.getWindow().getDecorView().findViewById(16908290);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static View getDecorView(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, activity)) == null) {
            if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                return activity.getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static void setAdapterHighlightTitle(Resources resources, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, resources, textView) == null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702dd);
            FontSizeViewExtKt.setScaledTopMarginRes(textView, 0, R.dimen.obfuscated_res_0x7f0702df);
            FontSizeViewExtKt.setScaledBottomMarginRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e3);
            textView.setMaxWidth(FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f070322, 2));
        }
    }

    public static void show2Icon2BtnToast(Activity activity, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i, UniversalToast.ToastCallback toastCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{activity, uri, charSequence, uri2, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Resources resources = activity.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d026e, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081486));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e02);
            if (simpleDraweeView != null) {
                if (uri != null) {
                    simpleDraweeView.setImageURI(uri);
                } else {
                    simpleDraweeView.setVisibility(8);
                }
            }
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e00);
            if (simpleDraweeView2 != null) {
                if (uri2 != null) {
                    simpleDraweeView2.setImageURI(uri2);
                } else {
                    simpleDraweeView2.setVisibility(8);
                }
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e01);
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
            textView.setText(charSequence);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfd);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
            textView2.setText(charSequence2);
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090dff);
            View findViewById2 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfe);
            View findViewById3 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e03);
            if (findViewById2 != null && findViewById3 != null) {
                if (TextUtils.isEmpty(charSequence2)) {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(4);
                } else {
                    findViewById2.setVisibility(0);
                    findViewById3.setVisibility(0);
                }
            }
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        UniversalToast.ToastCallback toastCallback2 = this.val$mToastCallback;
                        if (toastCallback2 instanceof UniversalToast.ToastCallbackWithAction) {
                            UniversalToast.ToastCallbackWithAction toastCallbackWithAction = (UniversalToast.ToastCallbackWithAction) toastCallback2;
                            if (view2.getId() == this.val$confirmView.getId()) {
                                toastCallbackWithAction.onToastClick(0);
                                ViewToast.cancel();
                                return;
                            } else if (view2.getId() == this.val$dismissView.getId()) {
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    float f;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 2) {
                                view2.setAlpha(1.0f);
                                return false;
                            }
                            return false;
                        }
                        if (NightModeHelper.getNightModeSwitcherState()) {
                            f = 0.5f;
                        } else {
                            f = 0.2f;
                        }
                        view2.setAlpha(f);
                        return false;
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
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0701de);
            addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010046);
        }
    }

    public static void showBigPicToast(@NonNull Activity activity, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{activity, drawable, drawable2, charSequence, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d0173, null);
            inflate.setClickable(true);
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0914a1)).setImageDrawable(drawable);
            }
            if (drawable2 != null) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e70)).setImageDrawable(drawable2);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d8)) != null) {
                textView.setText(charSequence);
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0903ee);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0604a1));
            }
            inflate.findViewById(R.id.obfuscated_res_0x7f0904ab).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.ViewToast.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ViewToast.cancel();
                    }
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904ce);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0701de);
            addToastToViewTree(getContentView(activity), inflate, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010046);
        }
    }

    public static void showClickableToast(@NonNull Activity activity, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback, boolean z) {
        View contentView;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{activity, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), toastCallback, Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            if (z) {
                contentView = getDecorView(activity);
            } else {
                contentView = getContentView(activity);
            }
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.obfuscated_res_0x7f0d0203, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804f0));
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090713);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090715)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setTextSize(1, i);
            }
            View findViewById2 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090716);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090712);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                    textView2.setTextSize(1, i);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090714);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804ef));
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
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
            addToastToViewTree(contentView, linearLayout, i2, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }

    public static void showRightButtonToast(@NonNull Activity activity, CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{activity, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.obfuscated_res_0x7f0d0836, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08122d));
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e66)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setText(charSequence);
                textView.setTextSize(1, i);
            }
            Button button = (Button) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e65);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080554));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColorStateList(R.color.obfuscated_res_0x7f0606e1));
                    button.setTextSize(1, i2);
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
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070203);
            addToastToViewTree(contentView, linearLayout, i3, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }

    public static void showClickableToastWithLeftGif(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{activity, charSequence, uri, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.obfuscated_res_0x7f0d058c, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804f0));
            ((SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e02)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e01)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfe);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
            }
            View findViewById2 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e03);
            if (findViewById2 != null) {
                findViewById2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfd);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e00);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804ef));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
            addToastToViewTree(contentView, linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }

    public static void showClickableToastWithLeftIcon(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{activity, charSequence, drawable, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            try {
                LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.obfuscated_res_0x7f0d058c, null);
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804f0));
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e02);
                if (simpleDraweeView != null) {
                    simpleDraweeView.setImageDrawable(drawable);
                }
                if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e01)) != null) {
                    textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                    textView.setText(charSequence);
                }
                View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfe);
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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
                }
                View findViewById2 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e03);
                if (findViewById2 != null) {
                    findViewById2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                }
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090dfd);
                if (textView2 != null) {
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                    if (!TextUtils.isEmpty(charSequence2)) {
                        textView2.setText(charSequence2);
                    }
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e00);
                if (imageView != null) {
                    imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804ef));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
                addToastToViewTree(contentView, linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static void showClickableToastWithLeftIconNoBtn(@NonNull Activity activity, @NonNull CharSequence charSequence, @NonNull Drawable drawable, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        float dimension;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{activity, charSequence, drawable, Integer.valueOf(i), toastCallback}) == null) {
            Resources resources = activity.getResources();
            View contentView = getContentView(activity);
            if (contentView == null) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(contentView.getContext(), R.layout.obfuscated_res_0x7f0d058d, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804ee));
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e02);
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageDrawable(drawable);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e01)) != null) {
                textView.setMaxLines(1);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e04);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) resources.getDimension(R.dimen.obfuscated_res_0x7f07029a));
            layoutParams.gravity = 81;
            if (DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext()) >= 1080) {
                dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f07029b);
            } else {
                dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f07029c);
            }
            layoutParams.bottomMargin = ((int) resources.getDimension(R.dimen.obfuscated_res_0x7f07024b)) + ((int) dimension);
            addToastToViewTree(contentView, linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }

    public static void showHighLoadingToast(Activity activity, CharSequence charSequence, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{activity, charSequence, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            sShowMask = z;
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d095c, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081486));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090f1b).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f1c);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08148b));
            setAdapterHighlightTopView(progressBar);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f1d);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                setAdapterHighlightTitle(resources, textView);
            }
            if (z2) {
                addToastToWindow(activity, linearLayout, i, ToastExtKt.getWMLayoutParamsOrNull(ToastLocation.MIDDLE, R.style.obfuscated_res_0x7f1003d1, 0, -2, -2));
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f0100a4);
        }
    }

    public static void showHighlight(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view2, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{activity, charSequence, drawable, view2, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            sShowMask = z;
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d095c, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081486));
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f1d);
            if (textView != null && !TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
                setAdapterHighlightTitle(resources, textView);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f1b);
            if (imageView != null) {
                setAdapterHighlightTopView(imageView);
                if (view2 != null) {
                    new ReplaceViewHelper(activity).toReplaceView(imageView, view2);
                } else {
                    if (drawable == null) {
                        drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f080712);
                    }
                    ToastUtils.setColorFilter(drawable);
                    imageView.setImageDrawable(drawable);
                }
            }
            if (z2) {
                addToastToWindow(activity, linearLayout, i, ToastExtKt.getWMLayoutParamsOrNull(ToastLocation.MIDDLE, R.style.obfuscated_res_0x7f1003d1, 0, -2, -2));
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addToastToViewTree(getContentView(activity), linearLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f0100a4);
        }
    }

    public static void showIconTitleMsgBtnToast(@NonNull Activity activity, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, int i4, int i5, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z;
        int i6;
        Animation animation;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{activity, uri, Integer.valueOf(i), charSequence, charSequence2, charSequence3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), toastCallback}) == null) {
            Resources resources = activity.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d0412, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804f0));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09149f);
            if (uri != null) {
                simpleDraweeView.setImageURI(uri);
                if (i != 1) {
                    simpleDraweeView.getHierarchy().setRoundingParams(new RoundingParams().setRoundAsCircle(false));
                }
            } else {
                simpleDraweeView.setVisibility(8);
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924cf);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091718);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
            textView3.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
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
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070231);
                ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.obfuscated_res_0x7f0923a8).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090713);
            if (!TextUtils.isEmpty(charSequence3)) {
                if (i2 != 1) {
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f0914e3).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903dd);
                    textView.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081487));
                    textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                    textView.setText(charSequence3);
                } else {
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f0903dd).setVisibility(8);
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f090716).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                    textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090712);
                    textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090714)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804ef));
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
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        float f;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            int action = motionEvent.getAction();
                            if (action != 0) {
                                if (action != 2) {
                                    this.val$touchStateView.setAlpha(1.0f);
                                    return false;
                                }
                                return false;
                            }
                            View view3 = this.val$touchStateView;
                            if (NightModeHelper.getNightModeSwitcherState()) {
                                f = 0.5f;
                            } else {
                                f = 0.2f;
                            }
                            view3.setAlpha(f);
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            } else {
                findViewById.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            if (i5 <= 0) {
                i6 = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
            } else {
                i6 = i5;
            }
            layoutParams.bottomMargin = i6;
            if (i3 != 2) {
                animation = AnimationUtils.loadAnimation(activity, R.anim.obfuscated_res_0x7f010174);
            } else {
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070236);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(200L);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, dimensionPixelSize2, 0, 0.0f));
                animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                animation = animationSet;
            }
            addToastToViewTree(getContentView(activity), linearLayout, i4, layoutParams, animation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate2(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @NonNull TextColorHolder textColorHolder2, int i, @NonNull ToastLocation toastLocation, boolean z, boolean z2, @Nullable UniversalToast.ToastCallback toastCallback) {
        View contentView;
        boolean z3;
        float f;
        ToastLocation toastLocation2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65571, null, new Object[]{activity, uri, drawable, view2, charSequence, textColorHolder, charSequence2, textColorHolder2, Integer.valueOf(i), toastLocation, Boolean.valueOf(z), Boolean.valueOf(z2), toastCallback}) != null) || activity == null) {
            return;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        if (z) {
            contentView = getDecorView(activity);
        } else {
            contentView = getContentView(activity);
        }
        if (contentView == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d095a, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081486));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914a0);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914ab);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e79);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e7a);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091e7b);
        if (!TextUtils.isEmpty(charSequence)) {
            View view3 = contentView;
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702df);
            if (textColorHolder != null) {
                if (NightModeHelper.getNightModeSwitcherState()) {
                    i3 = textColorHolder.nightColor;
                } else {
                    i3 = textColorHolder.dayColor;
                }
                textView.setTextColor(i3);
            }
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(ToastUtils.getMaxTitleLines());
                textView.setText(charSequence);
                textView.setMaxWidth(DeviceUtils.ScreenInfo.dp2px(activity, FontSizeHelper.getScaledSize(0, 200.0f)));
            } else {
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView, 0, R.dimen.obfuscated_res_0x7f0702e6, R.dimen.obfuscated_res_0x7f0702e6);
                    new ReplaceViewHelper(activity).toReplaceView(simpleDraweeView, view2);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    z3 = true;
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (!z3) {
                        f = 14.0f;
                    } else {
                        f = 5.0f;
                    }
                    layoutParams.setMargins(DeviceUtils.ScreenInfo.dp2px(activity, f), DeviceUtils.ScreenInfo.dp2px(activity, 9.0f), DeviceUtils.ScreenInfo.dp2px(activity, 14.0f), DeviceUtils.ScreenInfo.dp2px(activity, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e71);
                        FontSizeViewExtKt.setScaledSizeRes(imageView, 0, R.dimen.obfuscated_res_0x7f0702e1, R.dimen.obfuscated_res_0x7f0702e1);
                        imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08148e));
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        textView2.setText(charSequence2);
                        FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.obfuscated_res_0x7f0702df);
                        if (textColorHolder2 != null) {
                            if (NightModeHelper.getNightModeSwitcherState()) {
                                i2 = textColorHolder2.nightColor;
                            } else {
                                i2 = textColorHolder2.dayColor;
                            }
                            textView2.setTextColor(i2);
                        }
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c1));
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
                                public void onClick(View view4) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
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
                        int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
                        if (!z2) {
                            addToastToWindow(activity, linearLayout, i, ToastExtKt.getWMLayoutParamsOrNull(toastLocation2, R.style.obfuscated_res_0x7f10043c, dimension, -2, -2));
                            return;
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        if (ToastLocation.BOTTOM == toastLocation2) {
                            layoutParams2.gravity = 81;
                            layoutParams2.bottomMargin = dimension;
                        } else {
                            layoutParams2.gravity = 17;
                        }
                        addToastToViewTree(view3, linearLayout, i, layoutParams2, (int) R.anim.obfuscated_res_0x7f010174);
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView, 0, R.dimen.obfuscated_res_0x7f0702e6, R.dimen.obfuscated_res_0x7f0702e6);
                    if (drawable != null) {
                        ToastUtils.setColorFilter(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z3 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                if (!z3) {
                }
                layoutParams3.setMargins(DeviceUtils.ScreenInfo.dp2px(activity, f), DeviceUtils.ScreenInfo.dp2px(activity, 9.0f), DeviceUtils.ScreenInfo.dp2px(activity, 14.0f), DeviceUtils.ScreenInfo.dp2px(activity, 10.0f));
                textView.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            int dimension2 = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
            if (!z2) {
            }
        } else {
            ToastUtils.printStackTraceString("has no main text");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate3(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @NonNull TextColorHolder textColorHolder2, @Nullable ToastRightAreaStyle toastRightAreaStyle, boolean z, int i, boolean z2, boolean z3, UniversalToast.ToastCallback toastCallback, UniversalToast.ToastCallback toastCallback2) {
        View contentView;
        boolean z4;
        int i2;
        int i3;
        ImageView imageView;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65572, null, new Object[]{activity, uri, drawable, view2, charSequence, textColorHolder, charSequence2, charSequence3, textColorHolder2, toastRightAreaStyle, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z3), toastCallback, toastCallback2}) != null) || activity == null) {
            return;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        if (z2) {
            contentView = getDecorView(activity);
        } else {
            contentView = getContentView(activity);
        }
        if (contentView == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d095b, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081486));
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0923a8);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09149f);
        simpleDraweeView.setVisibility(0);
        View view3 = contentView;
        FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView, 0, R.dimen.obfuscated_res_0x7f0702f1, R.dimen.obfuscated_res_0x7f0702f1);
        if (view2 != null) {
            new ReplaceViewHelper(activity).toReplaceView(simpleDraweeView, view2);
        } else if (drawable != null) {
            ToastUtils.setColorFilter(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            z4 = true;
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = DeviceUtil.ScreenInfo.dp2px(activity, 15.0f);
            layoutParams.gravity = 16;
            linearLayout2.setMinimumHeight((int) ResUtil.getDimenByResId(getTemplate3Height()));
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924a3);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092219);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091945);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z4) {
                        textView.setMaxWidth(getTemplate3TitleMaxWidth(activity));
                        textView2.setMaxWidth(getTemplate3TitleMaxWidth(activity));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702df);
                    FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.obfuscated_res_0x7f0702dc);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    if (textColorHolder != null) {
                        if (NightModeHelper.getNightModeSwitcherState()) {
                            i4 = textColorHolder.nightColor;
                        } else {
                            i4 = textColorHolder.dayColor;
                        }
                        textView.setTextColor(i4);
                    }
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601c5));
                    textView3.setVisibility(8);
                } else {
                    if (z4) {
                        textView3.setMaxWidth(getTemplate3TitleMaxWidth(activity));
                    }
                    textView3.setText(charSequence);
                    FontSizeTextViewExtKt.setScaledSizeRes(textView3, 0, R.dimen.obfuscated_res_0x7f0702df);
                    if (FontSizeHelper.isFontSizeBigger()) {
                        textView3.setSingleLine(false);
                        textView3.setMaxLines(2);
                    } else {
                        textView3.setSingleLine();
                    }
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    if (textColorHolder != null) {
                        if (NightModeHelper.getNightModeSwitcherState()) {
                            i2 = textColorHolder.nightColor;
                        } else {
                            i2 = textColorHolder.dayColor;
                        }
                        textView3.setTextColor(i2);
                    }
                }
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0904a4);
                LinearLayout linearLayout4 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0911ff);
                TextView textView4 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0904e6);
                TextView textView5 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091202);
                ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091205);
                View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091e7b);
                ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090495);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        linearLayout3.setVisibility(0);
                        linearLayout4.setVisibility(8);
                        textView4.setText(charSequence3);
                        FontSizeTextViewExtKt.setScaledSizeRes(textView4, 0, R.dimen.obfuscated_res_0x7f0702dd);
                        textView4.setBackground(resources.getDrawable(toastRightAreaStyle.btnBgDrawableResId));
                        textView4.setTextColor(resources.getColor(toastRightAreaStyle.btnTextColorResId));
                        toastRightAreaStyle.resetButtonStyle();
                        if (z) {
                            imageView3.setVisibility(0);
                            FontSizeImageViewExtKt.setScaledImageDrawableRes(imageView3, 0, R.drawable.obfuscated_res_0x7f081488);
                            imageView = imageView3;
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
                                    public void onClick(View view4) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                            ViewToast.cancel();
                                            UiThreadUtils.getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.2.1
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
                                                        int i5 = newInitContext.flag;
                                                        if ((i5 & 1) != 0) {
                                                            int i6 = i5 & 2;
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
                                                    if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (toastCallback3 = this.this$0.val$callback) != null) {
                                                        toastCallback3.onToastClick();
                                                    }
                                                }
                                            }, 200L);
                                        }
                                    }
                                });
                                ToastUtils.processAlpha(linearLayout3);
                            }
                            if (imageView != null) {
                                imageView.setOnClickListener(new View.OnClickListener(toastCallback2) { // from class: com.baidu.android.ext.widget.toast.ViewToast.3
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
                                            int i5 = newInitContext.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.val$cancelCallback = toastCallback2;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view4) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view4) == null) {
                                            ViewToast.cancel();
                                            UiThreadUtils.getMainHandler().postDelayed(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ViewToast.3.1
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
                                                        int i5 = newInitContext.flag;
                                                        if ((i5 & 1) != 0) {
                                                            int i6 = i5 & 2;
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
                                                    if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (toastCallback3 = this.this$0.val$cancelCallback) != null) {
                                                        toastCallback3.onToastClick();
                                                    }
                                                }
                                            }, 200L);
                                        }
                                    }
                                });
                                ToastUtils.processAlpha(imageView);
                            }
                        } else {
                            imageView3.setVisibility(8);
                        }
                    } else {
                        linearLayout4.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView5.setText(charSequence3);
                        FontSizeTextViewExtKt.setScaledSizeRes(textView5, 0, R.dimen.obfuscated_res_0x7f0702df);
                        if (textColorHolder2 != null) {
                            if (NightModeHelper.getNightModeSwitcherState()) {
                                i3 = textColorHolder2.nightColor;
                            } else {
                                i3 = textColorHolder2.dayColor;
                            }
                            textView5.setTextColor(i3);
                        }
                        imageView2.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f08148e));
                        FontSizeViewExtKt.setScaledSizeRes(imageView2, 0, R.dimen.obfuscated_res_0x7f0702e1, R.dimen.obfuscated_res_0x7f0702e1);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c1));
                        linearLayout3 = linearLayout4;
                    }
                    imageView = null;
                    if (linearLayout3 != null) {
                    }
                    if (imageView != null) {
                    }
                } else {
                    linearLayout3.setVisibility(8);
                    linearLayout4.setVisibility(8);
                }
                int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
                if (z3) {
                    addToastToWindow(activity, linearLayout, i, ToastExtKt.getWMLayoutParamsOrNull(ToastLocation.BOTTOM, R.style.obfuscated_res_0x7f10043c, dimension, -2, -2));
                    return;
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = dimension;
                addToastToViewTree(view3, linearLayout, i, layoutParams2, (int) R.anim.obfuscated_res_0x7f010174);
                return;
            }
            ToastUtils.printStackTraceString("has no main text");
            return;
        }
        z4 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924a3);
        TextView textView22 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092219);
        TextView textView32 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091945);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public static void showToastBottom(@NonNull Activity activity, @NonNull CharSequence charSequence, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65574, null, activity, charSequence, i) == null) {
            Resources resources = activity.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(activity, R.layout.obfuscated_res_0x7f0d06fb, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081088));
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091905)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060b9e));
                textView.setText(charSequence);
                FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702df);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070235);
            addToastToViewTree(getContentView(activity), relativeLayout, i, layoutParams, (int) R.anim.obfuscated_res_0x7f010174);
        }
    }
}
