package com.baidu.android.ext.widget.toast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.ext.widget.toast.util.ReplaceViewHelper;
import com.baidu.android.toast.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
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
import h.d;
import h.l.b.a;
import h.n.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public final class SingleToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SYSTEMTOAST_LONGDURATION = 3500;
    public static final int SYSTEMTOAST_SHORTDURATION = 2000;
    public static final String TAG = "SingleToast";
    public static Handler mHandler;
    public static Toast mSystemToast;
    public static WeakReference<ToastCustom> mToastRef;
    public static UniversalToast.OnDismissListener onDismissListener;
    public static boolean sDebug;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1216878157, "Lcom/baidu/android/ext/widget/toast/SingleToast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1216878157, "Lcom/baidu/android/ext/widget/toast/SingleToast;");
                return;
            }
        }
        mHandler = new Handler(Looper.getMainLooper());
    }

    public SingleToast() {
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

    public static void cancel() {
        ToastCustom toastCustom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            WeakReference<ToastCustom> weakReference = mToastRef;
            if (weakReference != null && (toastCustom = weakReference.get()) != null) {
                toastCustom.cancel();
            }
            Toast toast = mSystemToast;
            if (toast != null) {
                toast.cancel();
            }
            UniversalToast.OnDismissListener onDismissListener2 = onDismissListener;
            if (onDismissListener2 != null) {
                onDismissListener2.onDismiss();
                onDismissListener = null;
            }
        }
    }

    public static void setOnDismissListener(UniversalToast.OnDismissListener onDismissListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, onDismissListener2) == null) {
            onDismissListener = onDismissListener2;
        }
    }

    public static void setToastRef(ToastCustom toastCustom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, toastCustom) == null) {
            WeakReference<ToastCustom> weakReference = mToastRef;
            if (weakReference != null) {
                weakReference.clear();
            }
            mToastRef = new WeakReference<>(toastCustom);
        }
    }

    public static void show(@NonNull Context context, @NonNull CharSequence charSequence, int i2, boolean z, int i3, boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.normal_toast_view, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
            boolean z3 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
                boolean z4 = i3 >= 2;
                textView.setSingleLine((z4 || !z) ? false : false);
                if (z4) {
                    textView.setMaxLines(i3);
                    textView.setGravity(17);
                }
            }
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                mHandler.post(new Runnable(applicationContext, relativeLayout) { // from class: com.baidu.android.ext.widget.toast.SingleToast.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ RelativeLayout val$container;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, relativeLayout};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = relativeLayout;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(17, 0, 0);
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            int i4 = SingleToast.mSystemToast.getDuration() == 1 ? 3500 : 2000;
                            UniversalToast.OnDismissListener unused2 = SingleToast.onDismissListener = null;
                            d.B(i4, TimeUnit.MILLISECONDS).y(Schedulers.io()).k(a.b()).w(new b<Long>(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$0;

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

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // h.n.b
                                public void call(Long l) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, l) == null) {
                                        MutexPopManager.doNextTask();
                                    }
                                }
                            });
                            SingleToast.mSystemToast.show();
                            boolean unused3 = SingleToast.sDebug;
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            toastCustom.setView(relativeLayout);
            toastCustom.setMask(z2);
            toastCustom.setGravity(17, 0, 0);
            toastCustom.setDuration(i2);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void show2Icon2BtnToast(Context context, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i2, UniversalToast.ToastCallback toastCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, uri, charSequence, uri2, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.double_icon_double_text_clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
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
            textView.setTextColor(resources.getColor(R.color.white_text));
            textView.setText(charSequence);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.gif_toast_check_text);
            textView2.setTextColor(resources.getColor(R.color.white_text));
            textView2.setText(charSequence2);
            View findViewById = linearLayout.findViewById(R.id.gif_toast_click_area_left);
            View findViewById2 = linearLayout.findViewById(R.id.gif_toast_click_area);
            View.OnClickListener onClickListener = new View.OnClickListener(toastCallback, findViewById, findViewById2) { // from class: com.baidu.android.ext.widget.toast.SingleToast.17
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
                                return;
                            } else if (view.getId() == this.val$dismissView.getId()) {
                                toastCallbackWithAction.onToastClick(-1);
                                return;
                            } else {
                                return;
                            }
                        }
                        toastCallback2.onToastClick();
                    }
                }
            };
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            }
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(onClickListener);
            }
            if (ToastUtils.shouldShowSystemToast(context)) {
                mHandler.post(new Runnable(applicationContext, linearLayout, resources) { // from class: com.baidu.android.ext.widget.toast.SingleToast.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ LinearLayout val$container;
                    public final /* synthetic */ Resources val$resources;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, linearLayout, resources};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = linearLayout;
                        this.val$resources = resources;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$resources.getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i2);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    public static void showBigPicToast(@NonNull Context context, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, drawable, drawable2, charSequence, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                return;
            }
            View inflate = View.inflate(applicationContext, R.layout.big_pic_toast_view, null);
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
            inflate.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.SingleToast.19
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
                        SingleToast.cancel();
                    }
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_open_night_mode);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.20
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
                            SingleToast.cancel();
                        }
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
                boolean z = sDebug;
            }
            toastCustom.setView(inflate);
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.big_pic_toast_view_margin_bottom));
            toastCustom.setDuration(i2);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.big_pic_animation);
            toastCustom.show();
        }
    }

    public static void showClickablePopToast(@NonNull Context context, @NonNull CharSequence charSequence, int i2, @Nullable CharSequence charSequence2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), toastCallback}) == null) {
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i2);
            }
            View findViewById = linearLayout.findViewById(R.id.clickable_toast_line);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.white_text));
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
            ToastCustom toastCustom = new ToastCustom(context);
            setToastRef(toastCustom);
            toastCustom.setWindowType(1002);
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i3);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void showClickableToast(@NonNull Context context, @NonNull CharSequence charSequence, int i2, @Nullable CharSequence charSequence2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.normal_toast_view, null);
                relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
                relativeLayout.setClickable(true);
                if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                    textView2.setText(charSequence);
                    textView2.setTextColor(resources.getColor(R.color.white_text));
                    textView2.setTextSize(1, i2);
                }
                mHandler.post(new Runnable(applicationContext, relativeLayout, toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;
                    public final /* synthetic */ RelativeLayout val$container;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, relativeLayout, toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = relativeLayout;
                        this.val$callback = toastCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$appContext.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            this.val$container.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass9 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) || (toastCallback2 = this.this$0.val$callback) == null) {
                                        return;
                                    }
                                    toastCallback2.onToastClick();
                                }
                            });
                            int i4 = SingleToast.mSystemToast.getDuration() == 1 ? 3500 : 2000;
                            UniversalToast.OnDismissListener unused2 = SingleToast.onDismissListener = null;
                            d.B(i4, TimeUnit.MILLISECONDS).y(Schedulers.io()).k(a.b()).w(new b<Long>(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.9.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass9 this$0;

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

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // h.n.b
                                public void call(Long l) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, l) == null) {
                                        MutexPopManager.doNextTask();
                                    }
                                }
                            });
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.clickable_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i2);
            }
            View findViewById = linearLayout.findViewById(R.id.clickable_toast_line);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.white_text));
            }
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.clickable_toast_check_text);
            if (textView3 != null) {
                textView3.setTextColor(resources.getColor(R.color.white_text));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView3.setText(charSequence2);
                    textView3.setTextSize(1, i2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.clickable_toast_icon_view);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.clickable_toast_icon));
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i3);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void showClickableToastWithLeftGif(@NonNull Context context, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, charSequence, uri, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.left_icon_clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            linearLayout.setClickable(true);
            ((SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.gif_toast_line);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.white_text));
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
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                linearLayout.findViewById(R.id.gif_toast_click_area).setVisibility(8);
                mHandler.post(new Runnable(applicationContext, linearLayout, context, toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;
                    public final /* synthetic */ LinearLayout val$container;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, linearLayout, context, toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = linearLayout;
                        this.val$context = context;
                        this.val$callback = toastCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            this.val$container.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.10.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass10 this$0;

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

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) || (toastCallback2 = this.this$0.val$callback) == null) {
                                        return;
                                    }
                                    toastCallback2.onToastClick();
                                }
                            });
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i2);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    public static void showClickableToastWithLeftIcon(@NonNull Context context, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, charSequence, drawable, charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.left_icon_clickable_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.clickable_toast_view_bg));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.gif_toast_left_icon);
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageDrawable(drawable);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.gif_toast_info_view)) != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.gif_toast_line);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.white_text));
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
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                linearLayout.findViewById(R.id.gif_toast_click_area).setVisibility(8);
                mHandler.post(new Runnable(applicationContext, linearLayout, context, toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;
                    public final /* synthetic */ LinearLayout val$container;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, linearLayout, context, toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = linearLayout;
                        this.val$context = context;
                        this.val$callback = toastCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            this.val$container.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass11 this$0;

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

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) || (toastCallback2 = this.this$0.val$callback) == null) {
                                        return;
                                    }
                                    toastCallback2.onToastClick();
                                }
                            });
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i2);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    public static void showCustomToast(@NonNull Context context, @NonNull View view, @NonNull int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65552, null, context, view, i2) == null) {
            mHandler.post(new Runnable(context.getApplicationContext(), view, i2) { // from class: com.baidu.android.ext.widget.toast.SingleToast.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$appContext;
                public final /* synthetic */ View val$customView;
                public final /* synthetic */ int val$marginBottom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, view, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$appContext = r6;
                    this.val$customView = view;
                    this.val$marginBottom = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                        SingleToast.mSystemToast.setView(this.val$customView);
                        SingleToast.mSystemToast.setGravity(81, 0, this.val$marginBottom);
                        ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                        SingleToast.mSystemToast.show();
                    }
                }
            });
        }
    }

    public static void showHighLoadingToast(Context context, CharSequence charSequence, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, charSequence, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.toast_template_square_d20, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
            linearLayout.findViewById(R.id.highlight_toast_imageView_d20).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.highlight_toast_loading_d20);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.toast_loading_d20));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text_d20);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.GC6));
            }
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                mHandler.post(new Runnable(context, linearLayout) { // from class: com.baidu.android.ext.widget.toast.SingleToast.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LinearLayout val$container;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, linearLayout};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$container = linearLayout;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$context);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(17, 0, 0);
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            toastCustom.setView(linearLayout);
            toastCustom.setMask(z);
            toastCustom.setGravity(17, 0, 0);
            toastCustom.setDuration(i2);
            toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
            toastCustom.show();
        }
    }

    public static void showHighlight(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, charSequence, drawable, view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.toast_template_square_d20, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.highlight_toast_text_d20)) != null) {
            textView.setTextColor(resources.getColor(R.color.GC6));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.highlight_toast_imageView_d20);
        if (imageView != null) {
            if (view != null) {
                new ReplaceViewHelper(applicationContext).toReplaceView(imageView, view);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.highlight_toast_image_d20);
                }
                ToastUtils.setColorFilter(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (ToastUtils.shouldShowSystemToast(applicationContext)) {
            mHandler.post(new Runnable(context, linearLayout) { // from class: com.baidu.android.ext.widget.toast.SingleToast.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LinearLayout val$container;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, linearLayout};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$container = linearLayout;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Toast unused = SingleToast.mSystemToast = new Toast(this.val$context);
                        SingleToast.mSystemToast.setView(this.val$container);
                        SingleToast.mSystemToast.setGravity(17, 0, 0);
                        ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                        SingleToast.mSystemToast.show();
                    }
                }
            });
            return;
        }
        ToastCustom toastCustom = new ToastCustom(applicationContext);
        setToastRef(toastCustom);
        toastCustom.setView(linearLayout);
        toastCustom.setMask(z);
        toastCustom.setGravity(17, 0, 0);
        toastCustom.setDuration(i2);
        toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
        toastCustom.show();
    }

    public static void showIconTitleMsgBtnToast(@NonNull Context context, Uri uri, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, int i4, int i5, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, uri, Integer.valueOf(i2), charSequence, charSequence2, charSequence3, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.icon_title_message_button_toast_view, null);
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
                findViewById.setOnTouchListener(new View.OnTouchListener(textView) { // from class: com.baidu.android.ext.widget.toast.SingleToast.15
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
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
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
            if (ToastUtils.shouldShowSystemToast(context)) {
                mHandler.post(new Runnable(findViewById, applicationContext, linearLayout, context) { // from class: com.baidu.android.ext.widget.toast.SingleToast.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ View val$clickArea;
                    public final /* synthetic */ LinearLayout val$container;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {findViewById, applicationContext, linearLayout, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$clickArea = findViewById;
                        this.val$appContext = applicationContext;
                        this.val$container = linearLayout;
                        this.val$context = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$clickArea.setVisibility(8);
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z2 = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, i5 <= 0 ? (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom) : i5);
            toastCustom.setDuration(i4);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    public static void showRightButtonPopToast(@NonNull Context context, CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), Integer.valueOf(i4), toastCallback}) == null) {
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.right_button_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.right_button_toast_view_bg));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.right_button_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i2);
            }
            Button button = (Button) linearLayout.findViewById(R.id.right_button_toast_btn_view);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.toast_button_view_bg));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColor(R.color.white_text));
                    button.setTextSize(1, i3);
                }
                button.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.14
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
                            SingleToast.cancel();
                        }
                    }
                });
            }
            ToastCustom toastCustom = new ToastCustom(context);
            setToastRef(toastCustom);
            toastCustom.setWindowType(1002);
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.button_toast_view_margin_bottom));
            toastCustom.setDuration(i4);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    public static void showRightButtonToast(@NonNull Context context, CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, charSequence, Integer.valueOf(i2), charSequence2, Integer.valueOf(i3), Integer.valueOf(i4), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.normal_toast_view, null);
                relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
                relativeLayout.setClickable(true);
                if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.normal_toast_text)) != null) {
                    textView2.setText(charSequence);
                    textView2.setTextColor(resources.getColor(R.color.white_text));
                    textView2.setTextSize(1, i2);
                }
                mHandler.post(new Runnable(applicationContext, relativeLayout, toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ UniversalToast.ToastCallback val$callback;
                    public final /* synthetic */ RelativeLayout val$container;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, relativeLayout, toastCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = relativeLayout;
                        this.val$callback = toastCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$appContext.getResources().getDimension(R.dimen.button_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            this.val$container.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass12 this$0;

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

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) || (toastCallback2 = this.this$0.val$callback) == null) {
                                        return;
                                    }
                                    toastCallback2.onToastClick();
                                }
                            });
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.right_button_toast_view, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.right_button_toast_view_bg));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.right_button_toast_info_view)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setTextSize(1, i2);
            }
            Button button = (Button) linearLayout.findViewById(R.id.right_button_toast_btn_view);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.toast_button_view_bg));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColor(R.color.white_text));
                    button.setTextSize(1, i3);
                }
                button.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.13
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
                            SingleToast.cancel();
                        }
                    }
                });
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            if (ToastUtils.checkIsOppoRom()) {
                toastCustom.setWindowType(2003);
                boolean z = sDebug;
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.button_toast_view_margin_bottom));
            toastCustom.setDuration(i4);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate2(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @NonNull TextColorHolder textColorHolder2, int i2, @NonNull ToastLocation toastLocation, @Nullable UniversalToast.ToastCallback toastCallback, boolean z) {
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, uri, drawable, view, charSequence, textColorHolder, charSequence2, textColorHolder2, Integer.valueOf(i2), toastLocation, toastCallback, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.toast_template_a_d20, null);
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
                textView.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new ReplaceViewHelper(applicationContext).toReplaceView(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(context, !z2 ? 14.0f : 5.0f), DeviceUtil.ScreenInfo.dp2px(context, 9.0f), DeviceUtil.ScreenInfo.dp2px(context, 14.0f), DeviceUtil.ScreenInfo.dp2px(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(R.id.right_jump_img)).setImageDrawable(resources.getDrawable(R.drawable.toast_right_jump_d20));
                        textView2.setText(charSequence2);
                        if (textColorHolder2 != null) {
                            textView2.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder2.nightColor : textColorHolder2.dayColor);
                        }
                        findViewById.setBackground(resources.getDrawable(R.color.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.5
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
                                        SingleToast.cancel();
                                    }
                                }
                            });
                            ToastUtils.processAlpha(linearLayout2);
                        }
                        if (!ToastUtils.shouldShowSystemToast(applicationContext)) {
                            mHandler.post(new Runnable(toastLocation2, resources, context, linearLayout) { // from class: com.baidu.android.ext.widget.toast.SingleToast.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ LinearLayout val$container;
                                public final /* synthetic */ Context val$context;
                                public final /* synthetic */ ToastLocation val$finalToastLocation;
                                public final /* synthetic */ Resources val$resources;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {toastLocation2, resources, context, linearLayout};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$finalToastLocation = toastLocation2;
                                    this.val$resources = resources;
                                    this.val$context = context;
                                    this.val$container = linearLayout;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    int i3;
                                    int i4;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        if (ToastLocation.BOTTOM == this.val$finalToastLocation) {
                                            i3 = 81;
                                            i4 = (int) this.val$resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
                                        } else {
                                            i3 = 17;
                                            i4 = 0;
                                        }
                                        Toast unused = SingleToast.mSystemToast = new Toast(this.val$context);
                                        SingleToast.mSystemToast.setView(this.val$container);
                                        SingleToast.mSystemToast.setGravity(i3, 0, i4);
                                        ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                                        SingleToast.mSystemToast.show();
                                    }
                                }
                            });
                            return;
                        }
                        ToastCustom toastCustom = new ToastCustom(applicationContext);
                        setToastRef(toastCustom);
                        toastCustom.setView(linearLayout);
                        toastCustom.setMask(z);
                        toastCustom.setGravity(17, 0, 0);
                        toastCustom.setDuration(i2);
                        toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
                        toastCustom.show();
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
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(DeviceUtil.ScreenInfo.dp2px(context, !z2 ? 14.0f : 5.0f), DeviceUtil.ScreenInfo.dp2px(context, 9.0f), DeviceUtil.ScreenInfo.dp2px(context, 14.0f), DeviceUtil.ScreenInfo.dp2px(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!ToastUtils.shouldShowSystemToast(applicationContext)) {
            }
        } else {
            ToastUtils.printStackTraceString("has no main text");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate3(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @NonNull TextColorHolder textColorHolder2, @Nullable ToastRightAreaStyle toastRightAreaStyle, int i2, UniversalToast.ToastCallback toastCallback, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, uri, drawable, view, charSequence, textColorHolder, charSequence2, charSequence3, textColorHolder2, toastRightAreaStyle, Integer.valueOf(i2), toastCallback, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.toast_template_b_d20, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.toast_bg_d20));
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.text_area);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.left_icon);
        simpleDraweeView.setVisibility(0);
        if (view != null) {
            new ReplaceViewHelper(applicationContext).toReplaceView(simpleDraweeView, view);
        } else if (drawable != null) {
            ToastUtils.setColorFilter(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(applicationContext, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            z2 = true;
            TextView textView = (TextView) linearLayout.findViewById(R.id.title);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.sub_title);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.one_line_text);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z2) {
                        textView.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(context, 175.0f));
                        textView2.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(context, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    if (textColorHolder != null) {
                        textView.setTextColor(NightModeHelper.getNightModeSwitcherState() ? textColorHolder.nightColor : textColorHolder.dayColor);
                    }
                    textView2.setTextColor(resources.getColor(R.color.GC4));
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    textView3.setVisibility(8);
                } else {
                    if (z2) {
                        textView3.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(context, 175.0f));
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
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        linearLayout3.setVisibility(0);
                        linearLayout4.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setTextColor(resources.getColor(R.color.GC6));
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
                    if (linearLayout3 != null) {
                        linearLayout3.setClickable(true);
                        linearLayout3.setOnClickListener(new View.OnClickListener(toastCallback) { // from class: com.baidu.android.ext.widget.toast.SingleToast.7
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
                                    SingleToast.cancel();
                                }
                            }
                        });
                        ToastUtils.processAlpha(linearLayout3);
                    }
                } else {
                    linearLayout3.setVisibility(8);
                    linearLayout4.setVisibility(8);
                }
                if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                    mHandler.post(new Runnable(resources, context, linearLayout) { // from class: com.baidu.android.ext.widget.toast.SingleToast.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LinearLayout val$container;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ Resources val$resources;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {resources, context, linearLayout};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$resources = resources;
                            this.val$context = context;
                            this.val$container = linearLayout;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int dimension = (int) this.val$resources.getDimension(R.dimen.clickable_toast_view_margin_bottom);
                                Toast unused = SingleToast.mSystemToast = new Toast(this.val$context);
                                SingleToast.mSystemToast.setView(this.val$container);
                                SingleToast.mSystemToast.setGravity(81, 0, dimension);
                                ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.highlight_toast_animation);
                                SingleToast.mSystemToast.show();
                            }
                        }
                    });
                    return;
                }
                ToastCustom toastCustom = new ToastCustom(applicationContext);
                setToastRef(toastCustom);
                toastCustom.setView(linearLayout);
                toastCustom.setMask(z);
                toastCustom.setGravity(81, 0, (int) resources.getDimension(R.dimen.clickable_toast_view_margin_bottom));
                toastCustom.setDuration(i2);
                toastCustom.setWindowAnimation(R.style.highlight_toast_animation);
                toastCustom.show();
                return;
            }
            ToastUtils.printStackTraceString("has no main text");
            return;
        }
        z2 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.title);
        TextView textView22 = (TextView) linearLayout.findViewById(R.id.sub_title);
        TextView textView32 = (TextView) linearLayout.findViewById(R.id.one_line_text);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public static void showToastBottom(@NonNull Context context, @NonNull CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65560, null, context, charSequence, i2) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.normal_toast_view, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.normal_toast_view_bg));
            TextView textView = (TextView) relativeLayout.findViewById(R.id.normal_toast_text);
            if (textView != null) {
                textView.setTextColor(resources.getColor(R.color.white_text));
                textView.setText(charSequence);
            }
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                mHandler.post(new Runnable(applicationContext, relativeLayout, context) { // from class: com.baidu.android.ext.widget.toast.SingleToast.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$appContext;
                    public final /* synthetic */ RelativeLayout val$container;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {applicationContext, relativeLayout, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$appContext = applicationContext;
                        this.val$container = relativeLayout;
                        this.val$context = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.toast_animation);
                            SingleToast.mSystemToast.show();
                            boolean unused2 = SingleToast.sDebug;
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            toastCustom.setView(relativeLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.clickable_toast_view_margin_bottom));
            toastCustom.setDuration(i2);
            toastCustom.setWindowAnimation(R.style.toast_animation);
            toastCustom.show();
        }
    }
}
