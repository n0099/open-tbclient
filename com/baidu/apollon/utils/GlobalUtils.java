package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes10.dex */
public final class GlobalUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static LayoutInflater a = null;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Toast> f32702b = null;
    public static String showStr = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(599490569, "Lcom/baidu/apollon/utils/GlobalUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(599490569, "Lcom/baidu/apollon/utils/GlobalUtils;");
        }
    }

    public GlobalUtils() {
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

    public static String getProperties(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean hideInputMethod(Context context, View view) {
        InterceptResult invokeLL;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, view)) == null) {
            if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
                return false;
            }
            return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return invokeLL.booleanValue;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        View currentFocus;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity) == null) || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public static boolean showInputMethod(Context context, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, view)) == null) {
            if (context == null || view == null) {
                return false;
            }
            view.requestFocusFromTouch();
            view.postDelayed(new Runnable(context, view) { // from class: com.baidu.apollon.utils.GlobalUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f32703b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f32703b = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this.f32703b, 0);
                    }
                }
            }, 100L);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void toast(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, charSequence) == null) {
            toast(context, charSequence, 0);
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, context, charSequence, i2) == null) {
            try {
                toast(context, charSequence, -1, i2);
            } catch (Exception unused) {
                LogUtil.errord("Exception in Toast!");
            }
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65544, null, context, charSequence, i2, i3) == null) {
            Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            WeakReference<Toast> weakReference = f32702b;
            if (weakReference != null && weakReference.get() != null) {
                f32702b.get().cancel();
            }
            if (a == null) {
                a = LayoutInflater.from(applicationContext);
            }
            View inflate = a.inflate(ResUtils.layout(applicationContext, "wallet_base_toast"), (ViewGroup) null);
            if (inflate == null || (textView = (TextView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_message"))) == null) {
                return;
            }
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_icon"));
            if (imageView != null && i2 > 0) {
                imageView.setImageResource(i2);
                imageView.setVisibility(0);
            }
            Toast toast = new Toast(applicationContext);
            toast.setDuration(i3);
            toast.setGravity(17, 0, 0);
            toast.setView(inflate);
            f32702b = new WeakReference<>(toast);
            toast.show();
        }
    }
}
