package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes4.dex */
public final class RimGlobalUtils {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public RimGlobalUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : (String) invokeV.objValue;
    }

    public static String getZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Object invoke = Class.forName("com.baidu.sofire.ac.FH").getDeclaredMethod("gz", Context.class).invoke(null, context);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getZid2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                Class<?> cls = Class.forName("com.fsg.soter.Soter");
                Object invoke = cls.getDeclaredMethod("getLid", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean hideInputMethod(Context context, View view) {
        InterceptResult invokeLL;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65541, null, activity) == null) || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, baseActivity, i2) == null) {
            try {
                Activity activity = baseActivity.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                baseActivity.getActivity().removeDialog(i2);
            } catch (Throwable th) {
                LogUtil.e("globalUtils", "dialog Exception", th);
            }
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, baseActivity, i2) == null) {
            try {
                baseActivity.getActivity().showDialog(i2);
            } catch (Exception e2) {
                if (LogUtil.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, baseActivity, i2, str) == null) {
            a = str;
            try {
                baseActivity.getActivity().showDialog(i2);
            } catch (Exception e2) {
                if (LogUtil.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void setMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            a = str;
        }
    }

    public static boolean showInputMethod(Context context, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, view)) == null) {
            if (context == null || view == null) {
                return false;
            }
            view.requestFocusFromTouch();
            view.postDelayed(new Runnable(context, view) { // from class: com.baidu.fsg.base.utils.RimGlobalUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f32514b;

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
                    this.f32514b = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(this.f32514b, 0);
                    }
                }
            }, 100L);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        View inflate;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65547, null, context, charSequence, i2, i3) == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            if (TextUtils.isEmpty(charSequence) || (inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "rim_base_toast_tips"), (ViewGroup) null)) == null || (textView = (TextView) inflate.findViewById(ResUtils.id(context, "rim_base_toast_message"))) == null) {
                return;
            }
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(context, "rim_base_toast_icon"));
            if (imageView != null && i2 > 0) {
                imageView.setImageResource(i2);
                imageView.setVisibility(0);
            }
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i3);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static void toastWithText(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, charSequence) == null) {
            toast(context, charSequence, -1, 0);
        }
    }

    public static void toastWithText(Context context, CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, null, context, charSequence, i2) == null) {
            toast(context, charSequence, -1, i2);
        }
    }

    public static void toastWithTextId(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, context, i2) == null) {
            toastWithTextId(context, i2, 0);
        }
    }

    public static void toastWithTextId(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65551, null, context, i2, i3) == null) {
            try {
                toastWithText(context, context.getResources().getString(i2), i3);
            } catch (Resources.NotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
