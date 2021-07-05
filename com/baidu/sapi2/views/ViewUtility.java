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
import android.widget.TextView;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import d.a.e0.a.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ViewUtility implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f10056a;

        public a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10056a = f2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                        view.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                } else if (Build.VERSION.SDK_INT >= 11) {
                    view.setAlpha(this.f10056a);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        InterceptResult invokeLZ;
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
                declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
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
                objArr[0] = Integer.valueOf(z ? i2 : 0);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window2, objArr);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, dialog) == null) {
            if (activity != null) {
                if (dialog == null || activity.isFinishing() || !dialog.isShowing()) {
                    return;
                }
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e2) {
                    Log.e(e2);
                    return;
                }
            }
            throw new IllegalArgumentException("Activity must not be null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0033, B:20:0x003e, B:21:0x0044, B:23:0x004a, B:24:0x004d, B:27:0x0064, B:28:0x006e), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0033, B:20:0x003e, B:21:0x0044, B:23:0x004a, B:24:0x004d, B:27:0x0064, B:28:0x006e), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:7:0x000b, B:17:0x002f, B:19:0x0033, B:20:0x003e, B:21:0x0044, B:23:0x004a, B:24:0x004d, B:27:0x0064, B:28:0x006e), top: B:36:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enableStatusBarTint(Activity activity, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65540, null, activity, i2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
            boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
            if (!z2 && !z3) {
                z = false;
                if (z && -1 == i2) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        i2 = activity.getResources().getColor(b.sapi_sdk_dark_mode_title_color);
                    } else {
                        i2 = activity.getColor(b.sapi_sdk_dark_mode_title_color);
                    }
                }
                if (!b(activity, true)) {
                    a(activity, true);
                }
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.setStatusBarColor(i2);
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
            window2.setStatusBarColor(i2);
            if (Build.VERSION.SDK_INT < 23) {
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public static void enlargedOtherView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, view, i2) == null) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((layoutParams.width * i2) / 100.0f);
        layoutParams.height = (int) ((layoutParams.height * i2) / 100.0f);
        view.setLayoutParams(layoutParams);
    }

    public static void enlargedTextView(TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, textView, i2) == null) || textView == null) {
            return;
        }
        textView.setTextSize(0, (textView.getTextSize() * i2) / 100.0f);
    }

    public static void enlargedViews(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65543, null, view, i2) == null) || view == null) {
            return;
        }
        if (view instanceof TextView) {
            enlargedTextView((TextView) view, i2);
        } else {
            enlargedOtherView(view, i2);
        }
    }

    public static int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
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

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, view, onClickListener) == null) || view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void setOrientationToUndefined(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, activity) == null) && Build.VERSION.SDK_INT == 26) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
                declaredField.setAccessible(false);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65548, null, activity, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
            return;
        }
        viewGroup.setFitsSystemWindows(z);
    }

    public static void setTranslucentStatus(Activity activity) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, activity) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 21) {
                if (i3 >= 19) {
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
                    window.setAttributes(attributes);
                    return;
                }
                return;
            }
            Window window2 = activity.getWindow();
            View decorView = window2.getDecorView();
            if (Build.VERSION.SDK_INT >= 23) {
                if (!(SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode)) {
                    i2 = 9472;
                    decorView.setSystemUiVisibility(i2);
                    window2.addFlags(Integer.MIN_VALUE);
                    window2.setStatusBarColor(0);
                }
            }
            i2 = 1280;
            decorView.setSystemUiVisibility(i2);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(0);
        }
    }

    public static void setViewClickAlpha(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65550, null, view, f2) == null) || view == null) {
            return;
        }
        view.setOnTouchListener(new a(f2));
    }
}
