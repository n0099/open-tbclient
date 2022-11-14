package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ViewUtility implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ float a;

        public a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                        view2.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                } else if (Build.VERSION.SDK_INT >= 11) {
                    view2.setAlpha(this.a);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    public ViewUtility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, activity, z)) == null) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                if (z) {
                    i = i3 | i2;
                } else {
                    i = (~i2) & i3;
                }
                declaredField2.setInt(attributes, i);
                activity.getWindow().setAttributes(attributes);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static boolean b(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.getDecorView().setSystemUiVisibility(8192);
            Class<?> cls = activity.getWindow().getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window2 = activity.getWindow();
                Object[] objArr = new Object[2];
                if (z) {
                    i = i2;
                } else {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window2, objArr);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[Catch: Exception -> 0x007f, TryCatch #0 {Exception -> 0x007f, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0036, B:20:0x003f, B:21:0x0043, B:23:0x0049, B:24:0x004c, B:27:0x0063, B:28:0x006d), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[Catch: Exception -> 0x007f, TryCatch #0 {Exception -> 0x007f, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0036, B:20:0x003f, B:21:0x0043, B:23:0x0049, B:24:0x004c, B:27:0x0063, B:28:0x006d), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[Catch: Exception -> 0x007f, TryCatch #0 {Exception -> 0x007f, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0036, B:20:0x003f, B:21:0x0043, B:23:0x0049, B:24:0x004c, B:27:0x0063, B:28:0x006d), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enableStatusBarTint(Activity activity, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i) != null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
            boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
            if (!z2 && !z3) {
                z = false;
                if (z && -1 == i) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        i = activity.getResources().getColor(R.color.obfuscated_res_0x7f0609f5);
                    } else {
                        i = activity.getColor(R.color.obfuscated_res_0x7f0609f5);
                    }
                }
                if (!b(activity, true)) {
                    a(activity, true);
                }
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.setStatusBarColor(i);
                if (Build.VERSION.SDK_INT < 23) {
                    if (!z) {
                        window.getDecorView().setSystemUiVisibility(9216);
                        return;
                    }
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-8193));
                    return;
                }
                return;
            }
            z = true;
            if (z) {
                if (Build.VERSION.SDK_INT >= 23) {
                }
            }
            if (!b(activity, true)) {
            }
            Window window2 = activity.getWindow();
            window2.addFlags(Integer.MIN_VALUE);
            window2.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window2.setStatusBarColor(i);
            if (Build.VERSION.SDK_INT < 23) {
            }
        } catch (Exception e) {
            Log.e(e);
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, dialog) == null) {
            if (activity != null) {
                if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                    try {
                        dialog.dismiss();
                        return;
                    } catch (Exception e) {
                        Log.e(e);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Activity must not be null");
        }
    }

    public static void enlargedOtherView(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, view2, i) == null) && view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = (int) ((layoutParams.width * i) / 100.0f);
            layoutParams.height = (int) ((layoutParams.height * i) / 100.0f);
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void enlargedTextView(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65542, null, textView, i) == null) && textView != null) {
            textView.setTextSize(0, (textView.getTextSize() * i) / 100.0f);
        }
    }

    public static void enlargedViews(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65543, null, view2, i) != null) || view2 == null) {
            return;
        }
        if (view2 instanceof Button) {
            enlargedTextView((TextView) view2, i);
        } else if (view2 instanceof TextView) {
            enlargedTextView((TextView) view2, i);
        } else {
            enlargedOtherView(view2, i);
        }
    }

    public static void setOnClickListener(View view2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, view2, onClickListener) == null) && view2 != null && onClickListener != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public static void setViewClickAlpha(View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(65550, null, view2, f) != null) || view2 == null) {
            return;
        }
        view2.setOnTouchListener(new a(f));
    }

    public static int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void newLoginStatusBarTint(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, activity) == null) {
            if (!b(activity, true)) {
                a(activity, true);
            }
            setTranslucentStatus(activity);
            setRootViewFitsSystemWindows(activity, false);
        }
    }

    public static void setOrientationToUndefined(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, activity) != null) || Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65548, null, activity, z) == null) && Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() > 0 && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
                viewGroup.setFitsSystemWindows(z);
            }
        }
    }

    public static void setTranslucentStatus(Activity activity) {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, activity) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                if (Build.VERSION.SDK_INT >= 23) {
                    boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
                    boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
                    if (!z2 && !z3) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        i = 9472;
                        decorView.setSystemUiVisibility(i);
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(0);
                    }
                }
                i = 1280;
                decorView.setSystemUiVisibility(i);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            } else if (i2 >= 19) {
                Window window2 = activity.getWindow();
                WindowManager.LayoutParams attributes = window2.getAttributes();
                attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
                window2.setAttributes(attributes);
            }
        }
    }
}
