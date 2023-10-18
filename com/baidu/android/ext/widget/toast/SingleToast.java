package com.baidu.android.ext.widget.toast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.h6c;
import com.baidu.tieba.r6c;
import com.baidu.tieba.v6c;
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
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public final class SingleToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NORMAL_MAX_LINES = 2;
    public static final int SYSTEMTOAST_LONGDURATION = 3500;
    public static final int SYSTEMTOAST_SHORTDURATION = 2000;
    public static final String TAG = "SingleToast";
    public static Handler mHandler;
    public static Toast mSystemToast;
    public static WeakReference<Toast> mSystemToastRef;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void setAdapterHighlightTopView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, view2) == null) {
            FontSizeViewExtKt.setScaledMarginRes(view2, 0, R.dimen.obfuscated_res_0x7f0702fb, R.dimen.obfuscated_res_0x7f0702ed, R.dimen.obfuscated_res_0x7f0702fb, R.dimen.obfuscated_res_0x7f0702de);
            FontSizeViewExtKt.setScaledSizeRes(view2, 0, R.dimen.obfuscated_res_0x7f0702fe, R.dimen.obfuscated_res_0x7f0702fe);
        }
    }

    public static void setOnDismissListener(UniversalToast.OnDismissListener onDismissListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, onDismissListener2) == null) {
            onDismissListener = onDismissListener2;
        }
    }

    public static void setToastRef(ToastCustom toastCustom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, toastCustom) == null) {
            WeakReference<ToastCustom> weakReference = mToastRef;
            if (weakReference != null) {
                weakReference.clear();
            }
            mToastRef = new WeakReference<>(toastCustom);
        }
    }

    public static void cancel() {
        ToastCustom toastCustom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
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
            WeakReference<Toast> weakReference2 = mSystemToastRef;
            if (weakReference2 != null) {
                Toast toast2 = weakReference2.get();
                if (toast2 != null) {
                    toast2.cancel();
                }
                mSystemToastRef = null;
            }
        }
    }

    public static void setAdapterHighlightTitle(Resources resources, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, resources, textView) == null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601e3));
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e3);
            FontSizeViewExtKt.setScaledTopMarginRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e5);
            FontSizeViewExtKt.setScaledBottomMarginRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e9);
            textView.setMaxWidth(FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f070328, 2));
        }
    }

    public static void show(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0736, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081106));
            boolean z4 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0919d3)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setText(charSequence);
                FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e5);
                if (i2 >= 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                textView.setSingleLine((z3 || !z) ? false : false);
                if (z3) {
                    textView.setMaxLines(i2);
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
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast toast = new Toast(this.val$appContext);
                            toast.setView(this.val$container);
                            toast.setGravity(17, 0, 0);
                            ToastUtils.setToastAnimation(toast, R.style.obfuscated_res_0x7f100443);
                            if (toast.getDuration() == 1) {
                                i3 = 3500;
                            } else {
                                i3 = 2000;
                            }
                            UniversalToast.OnDismissListener unused = SingleToast.onDismissListener = null;
                            h6c.M(i3, TimeUnit.MILLISECONDS).J(Schedulers.io()).s(r6c.b()).H(new v6c<Long>(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.1.1
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

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tieba.v6c
                                public void call(Long l) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, l) == null) {
                                        MutexPopManager.doNextTask();
                                    }
                                }
                            });
                            toast.show();
                            WeakReference unused2 = SingleToast.mSystemToastRef = new WeakReference(toast);
                            if (SingleToast.sDebug) {
                                Log.d(SingleToast.TAG, "mSystemToast.show() invoked in show");
                            }
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
            toastCustom.setDuration(i);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void showClickablePopToast(@NonNull Context context, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.obfuscated_res_0x7f0d020c, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fd));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090736)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setTextSize(1, i);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090737);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090733);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                    textView2.setTextSize(1, i);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090735);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fc));
            }
            ToastCustom toastCustom = new ToastCustom(context);
            setToastRef(toastCustom);
            toastCustom.setWindowType(1002);
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i2);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void showClickableToastWithLeftIcon(@NonNull Context context, @NonNull CharSequence charSequence, @NonNull Drawable drawable, @Nullable CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, charSequence, drawable, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d05a8, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fd));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e48);
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageDrawable(drawable);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e47)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e49);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e43);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e46);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fc));
            }
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                linearLayout.findViewById(R.id.obfuscated_res_0x7f090e44).setVisibility(8);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeL(1048576, this, view2) == null) && (toastCallback2 = this.this$0.val$callback) != null) {
                                        toastCallback2.onToastClick();
                                    }
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
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    public static void show2Icon2BtnToast(Context context, Uri uri, CharSequence charSequence, Uri uri2, CharSequence charSequence2, int i, UniversalToast.ToastCallback toastCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, uri, charSequence, uri2, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.obfuscated_res_0x7f0d027a, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150d));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e48);
            if (uri != null) {
                simpleDraweeView.setImageURI(uri);
            } else {
                simpleDraweeView.setVisibility(8);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e46);
            if (uri2 != null) {
                imageView.setImageURI(uri2);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e47);
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            textView.setText(charSequence);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e43);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            textView2.setText(charSequence2);
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e45);
            View findViewById2 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e44);
            View findViewById3 = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e49);
            if (findViewById2 != null && findViewById3 != null) {
                if (TextUtils.isEmpty(charSequence2)) {
                    findViewById2.setVisibility(8);
                    findViewById3.setVisibility(4);
                } else {
                    findViewById2.setVisibility(0);
                    findViewById3.setVisibility(0);
                }
            }
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
                                return;
                            } else if (view2.getId() == this.val$dismissView.getId()) {
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$resources.getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    public static void showRightButtonToast(@NonNull Context context, CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0736, null);
                relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081106));
                relativeLayout.setClickable(true);
                if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0919d3)) != null) {
                    textView2.setText(charSequence);
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    textView2.setTextSize(1, i);
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$appContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070208));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                                public void onClick(View view2) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeL(1048576, this, view2) == null) && (toastCallback2 = this.this$0.val$callback) != null) {
                                        toastCallback2.onToastClick();
                                    }
                                }
                            });
                            SingleToast.mSystemToast.show();
                        }
                    }
                });
                return;
            }
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0877, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0812b2));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f52)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setTextSize(1, i);
            }
            Button button = (Button) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f51);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150e));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    button.setTextSize(1, i2);
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
                            SingleToast.cancel();
                        }
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
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070208));
            toastCustom.setDuration(i3);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    public static void showBigPicToast(@NonNull Context context, @NonNull Drawable drawable, @NonNull Drawable drawable2, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, drawable, drawable2, charSequence, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                return;
            }
            View inflate = View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0178, null);
            inflate.setClickable(true);
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091502)).setImageDrawable(drawable);
            }
            if (drawable2 != null) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091f5b)).setImageDrawable(drawable2);
            }
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924d8)) != null) {
                textView.setText(charSequence);
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0903f1);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0604a9));
            }
            inflate.findViewById(R.id.obfuscated_res_0x7f0904be).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.ext.widget.toast.SingleToast.19
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
                        SingleToast.cancel();
                    }
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904e1);
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
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(inflate);
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701de));
            toastCustom.setDuration(i);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f1003be);
            toastCustom.show();
        }
    }

    public static void showRightButtonPopToast(@NonNull Context context, CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), toastCallback}) == null) {
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.obfuscated_res_0x7f0d0877, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0812b2));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f52)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setTextSize(1, i);
            }
            Button button = (Button) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f51);
            if (button != null) {
                button.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150e));
                if (!TextUtils.isEmpty(charSequence2)) {
                    button.setText(charSequence2);
                    button.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    button.setTextSize(1, i2);
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
                            SingleToast.cancel();
                        }
                    }
                });
            }
            ToastCustom toastCustom = new ToastCustom(context);
            setToastRef(toastCustom);
            toastCustom.setWindowType(1002);
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070208));
            toastCustom.setDuration(i3);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    public static void showClickableToast(@NonNull Context context, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        TextView textView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, charSequence, Integer.valueOf(i), charSequence2, Integer.valueOf(i2), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            if (ToastUtils.shouldShowSystemToast(context)) {
                RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0736, null);
                relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081106));
                relativeLayout.setClickable(true);
                if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0919d3)) != null) {
                    textView2.setText(charSequence);
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    textView2.setTextSize(1, i);
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
                        this.val$callback = toastCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                            SingleToast.mSystemToast.setView(this.val$container);
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$appContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                                public void onClick(View view2) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeL(1048576, this, view2) == null) && (toastCallback2 = this.this$0.val$callback) != null) {
                                        toastCallback2.onToastClick();
                                    }
                                }
                            });
                            if (SingleToast.mSystemToast.getDuration() == 1) {
                                i3 = 3500;
                            } else {
                                i3 = 2000;
                            }
                            UniversalToast.OnDismissListener unused2 = SingleToast.onDismissListener = null;
                            h6c.M(i3, TimeUnit.MILLISECONDS).J(Schedulers.io()).s(r6c.b()).H(new v6c<Long>(this) { // from class: com.baidu.android.ext.widget.toast.SingleToast.9.2
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

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.tieba.v6c
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
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d020c, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fd));
            linearLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090736)) != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setTextSize(1, i);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090737);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            }
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090733);
            if (textView3 != null) {
                textView3.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView3.setText(charSequence2);
                    textView3.setTextSize(1, i);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090735);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fc));
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
            toastCustom.setGravity(81, 0, (int) applicationContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i2);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.setOnDissmissListener(onDismissListener);
            onDismissListener = null;
            toastCustom.show();
        }
    }

    public static void showClickableToastWithLeftGif(@NonNull Context context, @NonNull CharSequence charSequence, @NonNull Uri uri, @Nullable CharSequence charSequence2, int i, @Nullable UniversalToast.ToastCallback toastCallback) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, charSequence, uri, charSequence2, Integer.valueOf(i), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d05a8, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fd));
            linearLayout.setClickable(true);
            ((SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e48)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e47)) != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setText(charSequence);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090e49);
            if (findViewById != null) {
                findViewById.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e43);
            if (textView2 != null) {
                textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                if (!TextUtils.isEmpty(charSequence2)) {
                    textView2.setText(charSequence2);
                }
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090e46);
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fc));
            }
            if (ToastUtils.shouldShowSystemToast(applicationContext)) {
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                linearLayout.findViewById(R.id.obfuscated_res_0x7f090e44).setVisibility(8);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    UniversalToast.ToastCallback toastCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeL(1048576, this, view2) == null) && (toastCallback2 = this.this$0.val$callback) != null) {
                                        toastCallback2.onToastClick();
                                    }
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
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(linearLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    public static void showCustomToast(@NonNull Context context, @NonNull View view2, @NonNull int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, context, view2, i) == null) {
            mHandler.post(new Runnable(context.getApplicationContext(), view2, i) { // from class: com.baidu.android.ext.widget.toast.SingleToast.21
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
                        Object[] objArr = {r6, view2, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$appContext = r6;
                    this.val$customView = view2;
                    this.val$marginBottom = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Toast unused = SingleToast.mSystemToast = new Toast(this.val$appContext);
                        SingleToast.mSystemToast.setView(this.val$customView);
                        SingleToast.mSystemToast.setGravity(81, 0, this.val$marginBottom);
                        ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
                        SingleToast.mSystemToast.show();
                    }
                }
            });
        }
    }

    public static void showHighLoadingToast(Context context, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d09a2, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150d));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090f62).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f63);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081512));
            setAdapterHighlightTopView(progressBar);
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f64);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                setAdapterHighlightTitle(resources, textView);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            Toast toast = new Toast(this.val$context);
                            toast.setView(this.val$container);
                            toast.setGravity(17, 0, 0);
                            ToastUtils.setToastAnimation(toast, R.style.obfuscated_res_0x7f1003d9);
                            toast.show();
                            WeakReference unused = SingleToast.mSystemToastRef = new WeakReference(toast);
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
            toastCustom.setDuration(i);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f1003d9);
            toastCustom.show();
        }
    }

    public static void showHighlight(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view2, int i, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65557, null, new Object[]{context, charSequence, drawable, view2, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d09a2, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150d));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f64)) != null) {
            textView.setText(charSequence);
            setAdapterHighlightTitle(resources, textView);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f62);
        if (imageView != null) {
            setAdapterHighlightTopView(imageView);
            if (view2 != null) {
                new ReplaceViewHelper(applicationContext).toReplaceView(imageView, view2);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f08072d);
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        Toast toast = new Toast(this.val$context);
                        toast.setView(this.val$container);
                        toast.setGravity(17, 0, 0);
                        ToastUtils.setToastAnimation(toast, R.style.obfuscated_res_0x7f1003d9);
                        toast.show();
                        WeakReference unused = SingleToast.mSystemToastRef = new WeakReference(toast);
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
        toastCustom.setDuration(i);
        toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f1003d9);
        toastCustom.show();
    }

    public static void showIconTitleMsgBtnToast(@NonNull Context context, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, int i4, @Nullable UniversalToast.ToastCallback toastCallback) {
        boolean z;
        int i5;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, uri, Integer.valueOf(i), charSequence, charSequence2, charSequence3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), toastCallback}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0429, null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fd));
            linearLayout.setClickable(true);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914ff);
            if (uri != null) {
                simpleDraweeView.setImageURI(uri);
                if (i != 1) {
                    simpleDraweeView.getHierarchy().setRoundingParams(new RoundingParams().setRoundAsCircle(false));
                }
            } else {
                simpleDraweeView.setVisibility(8);
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0925d4);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09177d);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
            textView3.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
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
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070236);
                ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924a8).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
            }
            View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f090734);
            if (!TextUtils.isEmpty(charSequence3)) {
                if (i2 != 1) {
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f091544).setVisibility(8);
                    textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e0);
                    textView.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150e));
                    textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    textView.setText(charSequence3);
                } else {
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e0).setVisibility(8);
                    linearLayout.findViewById(R.id.obfuscated_res_0x7f090737).setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090733);
                    textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                    textView.setText(charSequence3);
                    ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090735)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0804fc));
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
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
                if (sDebug) {
                    Log.d(TAG, "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
                }
            }
            toastCustom.setView(linearLayout);
            if (i4 <= 0) {
                i5 = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239);
            } else {
                i5 = i4;
            }
            toastCustom.setGravity(81, 0, i5);
            toastCustom.setDuration(i3);
            toastCustom.setOnClick(toastCallback);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate2(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @NonNull TextColorHolder textColorHolder2, int i, @NonNull ToastLocation toastLocation, @Nullable UniversalToast.ToastCallback toastCallback, boolean z) {
        boolean z2;
        float f;
        ToastLocation toastLocation2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65561, null, new Object[]{context, uri, drawable, view2, charSequence, textColorHolder, charSequence2, textColorHolder2, Integer.valueOf(i), toastLocation, toastCallback, Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = null;
        try {
            linearLayout = (LinearLayout) View.inflate(context, R.layout.obfuscated_res_0x7f0d09a0, null);
        } catch (Exception unused) {
        }
        if (linearLayout == null) {
            return;
        }
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150d));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091500);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09150d);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f65);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f66);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091f67);
        if (!TextUtils.isEmpty(charSequence)) {
            FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e5);
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
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(DeviceUtil.ScreenInfo.dp2px(context, FontSizeHelper.getScaledSize(0, 200.0f)));
            } else {
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView, 0, R.dimen.obfuscated_res_0x7f0702ec, R.dimen.obfuscated_res_0x7f0702ec);
                    new ReplaceViewHelper(applicationContext).toReplaceView(simpleDraweeView, view2);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    z2 = true;
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (!z2) {
                        f = 14.0f;
                    } else {
                        f = 5.0f;
                    }
                    layoutParams.setMargins(DeviceUtils.ScreenInfo.dp2px(context, f), DeviceUtils.ScreenInfo.dp2px(context, 9.0f), DeviceUtils.ScreenInfo.dp2px(context, 14.0f), DeviceUtils.ScreenInfo.dp2px(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f5c);
                        FontSizeViewExtKt.setScaledSizeRes(imageView, 0, R.dimen.obfuscated_res_0x7f0702e7, R.dimen.obfuscated_res_0x7f0702e7);
                        imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081515));
                        textView2.setText(charSequence2);
                        FontSizeTextViewExtKt.setScaledSizeRes(textView2, 0, R.dimen.obfuscated_res_0x7f0702e5);
                        if (textColorHolder2 != null) {
                            if (NightModeHelper.getNightModeSwitcherState()) {
                                i2 = textColorHolder2.nightColor;
                            } else {
                                i2 = textColorHolder2.dayColor;
                            }
                            textView2.setTextColor(i2);
                        }
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c9));
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
                                public void onClick(View view3) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
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
                                public final /* synthetic */ Context val$context;
                                public final /* synthetic */ LinearLayout val$finalContainer;
                                public final /* synthetic */ ToastLocation val$finalToastLocation;
                                public final /* synthetic */ Resources val$resources;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {toastLocation2, resources, context, linearLayout};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$finalToastLocation = toastLocation2;
                                    this.val$resources = resources;
                                    this.val$context = context;
                                    this.val$finalContainer = linearLayout;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    int i4;
                                    int i5;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        if (ToastLocation.BOTTOM == this.val$finalToastLocation) {
                                            i4 = 81;
                                            i5 = (int) this.val$resources.getDimension(R.dimen.obfuscated_res_0x7f070239);
                                        } else {
                                            i4 = 17;
                                            i5 = 0;
                                        }
                                        Toast toast = new Toast(this.val$context);
                                        WeakReference unused2 = SingleToast.mSystemToastRef = new WeakReference(toast);
                                        toast.setView(this.val$finalContainer);
                                        toast.setGravity(i4, 0, i5);
                                        ToastUtils.setToastAnimation(toast, R.style.obfuscated_res_0x7f1003d9);
                                        toast.show();
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
                        toastCustom.setDuration(i);
                        toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f1003d9);
                        toastCustom.show();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    FontSizeViewExtKt.setScaledSizeRes(simpleDraweeView, 0, R.dimen.obfuscated_res_0x7f0702ec, R.dimen.obfuscated_res_0x7f0702ec);
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
                if (!z2) {
                }
                layoutParams2.setMargins(DeviceUtils.ScreenInfo.dp2px(context, f), DeviceUtils.ScreenInfo.dp2px(context, 9.0f), DeviceUtils.ScreenInfo.dp2px(context, 14.0f), DeviceUtils.ScreenInfo.dp2px(context, 10.0f));
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void showTemplate3(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @NonNull TextColorHolder textColorHolder, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @NonNull TextColorHolder textColorHolder2, @Nullable ToastRightAreaStyle toastRightAreaStyle, int i, UniversalToast.ToastCallback toastCallback, boolean z) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65562, null, new Object[]{context, uri, drawable, view2, charSequence, textColorHolder, charSequence2, charSequence3, textColorHolder2, toastRightAreaStyle, Integer.valueOf(i), toastCallback, Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d09a1, null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f08150d));
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924a8);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914ff);
        simpleDraweeView.setVisibility(0);
        if (view2 != null) {
            new ReplaceViewHelper(applicationContext).toReplaceView(simpleDraweeView, view2);
        } else if (drawable != null) {
            ToastUtils.setColorFilter(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(DeviceUtils.ScreenInfo.dp2px(applicationContext, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            z2 = true;
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0925a7);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092311);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a20);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z2) {
                        textView.setMaxWidth(DeviceUtils.ScreenInfo.dp2px(context, 175.0f));
                        textView2.setMaxWidth(DeviceUtils.ScreenInfo.dp2px(context, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    if (textColorHolder != null) {
                        if (NightModeHelper.getNightModeSwitcherState()) {
                            i4 = textColorHolder.nightColor;
                        } else {
                            i4 = textColorHolder.dayColor;
                        }
                        textView.setTextColor(i4);
                    }
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601cd));
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    textView3.setVisibility(8);
                } else {
                    if (z2) {
                        textView3.setMaxWidth(DeviceUtils.ScreenInfo.dp2px(context, 175.0f));
                    }
                    textView3.setText(charSequence);
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
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0904b7);
                LinearLayout linearLayout4 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091259);
                TextView textView4 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0904f9);
                TextView textView5 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09125f);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091265);
                View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091f67);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        linearLayout3.setVisibility(0);
                        linearLayout4.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setBackground(resources.getDrawable(toastRightAreaStyle.btnBgDrawableResId));
                        textView4.setTextColor(resources.getColor(toastRightAreaStyle.btnTextColorResId));
                        toastRightAreaStyle.resetButtonStyle();
                    } else {
                        linearLayout4.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView5.setText(charSequence3);
                        if (textColorHolder2 != null) {
                            if (NightModeHelper.getNightModeSwitcherState()) {
                                i3 = textColorHolder2.nightColor;
                            } else {
                                i3 = textColorHolder2.dayColor;
                            }
                            textView5.setTextColor(i3);
                        }
                        imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f081515));
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c9));
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
                            public void onClick(View view3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
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
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
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
                                int dimension = (int) this.val$resources.getDimension(R.dimen.obfuscated_res_0x7f070239);
                                Toast unused = SingleToast.mSystemToast = new Toast(this.val$context);
                                SingleToast.mSystemToast.setView(this.val$container);
                                SingleToast.mSystemToast.setGravity(81, 0, dimension);
                                ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f1003d9);
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
                toastCustom.setGravity(81, 0, (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070239));
                toastCustom.setDuration(i);
                toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f1003d9);
                toastCustom.show();
                return;
            }
            ToastUtils.printStackTraceString("has no main text");
            return;
        }
        z2 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0925a7);
        TextView textView22 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092311);
        TextView textView32 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a20);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public static void showToastBottom(@NonNull Context context, @NonNull CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65563, null, context, charSequence, i) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) View.inflate(applicationContext, R.layout.obfuscated_res_0x7f0d0736, null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081106));
            TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0919d3);
            if (textView != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060bae));
                textView.setText(charSequence);
                FontSizeTextViewExtKt.setScaledSizeRes(textView, 0, R.dimen.obfuscated_res_0x7f0702e5);
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                            SingleToast.mSystemToast.setGravity(81, 0, (int) this.val$context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
                            ToastUtils.setToastAnimation(SingleToast.mSystemToast, R.style.obfuscated_res_0x7f100443);
                            SingleToast.mSystemToast.show();
                            if (SingleToast.sDebug) {
                                Log.d(SingleToast.TAG, "mSystemToast.show() invoked in showToastBottom");
                            }
                        }
                    }
                });
                return;
            }
            ToastCustom toastCustom = new ToastCustom(applicationContext);
            setToastRef(toastCustom);
            toastCustom.setView(relativeLayout);
            toastCustom.setGravity(81, 0, (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070239));
            toastCustom.setDuration(i);
            toastCustom.setWindowAnimation(R.style.obfuscated_res_0x7f100443);
            toastCustom.show();
        }
    }
}
