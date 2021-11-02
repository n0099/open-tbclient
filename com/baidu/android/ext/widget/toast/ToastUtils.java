package com.baidu.android.ext.widget.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.toast.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class ToastUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_MIUI_BUILD_VERSION = "ro.build.version.incremental";
    public static final String MEIZU_ROM = "Flyme";
    public static final String MIUI_NAME = "ro.miui.ui.version.name";
    public static final String OPPO_NAME = "ro.build.version.opporom";
    public static final int OP_SYSTEM_ALERT_WINDOW = 24;
    public static final String TAG = "ToastUtils";
    public static final int VERSION_MIUI = 9;
    public static boolean sDebug;
    public static String sMiOsName;
    public static String sMiuiVersion;
    public static String sOppoOsName;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class TNHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable mHideRunnable;
        public Handler mOrigHandler;

        public TNHandler(Runnable runnable, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHideRunnable = runnable;
            this.mOrigHandler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message.what == 0) {
                    try {
                        if (!hasMessages(2) && !hasMessages(1)) {
                            Method declaredMethod = Class.forName("android.os.Handler").getDeclaredMethod("hasCallbacks", Runnable.class);
                            declaredMethod.setAccessible(true);
                            if (((Boolean) declaredMethod.invoke(this, this.mHideRunnable)).booleanValue()) {
                                return;
                            }
                        }
                        return;
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    } catch (NoSuchMethodException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                }
                try {
                    this.mOrigHandler.handleMessage(message);
                } catch (WindowManager.BadTokenException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(822052730, "Lcom/baidu/android/ext/widget/toast/ToastUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(822052730, "Lcom/baidu/android/ext/widget/toast/ToastUtils;");
        }
    }

    public ToastUtils() {
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

    public static boolean checkIsMeizuRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Build.FINGERPRINT.contains(MEIZU_ROM) || Pattern.compile(MEIZU_ROM, 2).matcher(Build.DISPLAY).find() : invokeV.booleanValue;
    }

    public static boolean checkIsMiuiRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sMiOsName == null) {
                sMiOsName = PrivateApiUtils.getSystemProperty("ro.miui.ui.version.name", "");
            }
            if (sDebug) {
                String str = "OsName = " + sMiOsName;
            }
            return !TextUtils.isEmpty(sMiOsName);
        }
        return invokeV.booleanValue;
    }

    public static boolean checkIsOppoRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (sOppoOsName == null) {
                sOppoOsName = PrivateApiUtils.getSystemProperty("ro.build.version.opporom", "");
            }
            if (sDebug) {
                String str = "OsName = " + sOppoOsName;
            }
            return !TextUtils.isEmpty(sOppoOsName);
        }
        return invokeV.booleanValue;
    }

    public static boolean checkMiuiVersionIsLow9() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (sMiuiVersion == null) {
                sMiuiVersion = PrivateApiUtils.getSystemProperty("ro.build.version.incremental", "");
            }
            if (sDebug) {
                String str = "sMiuiVersion = " + sMiuiVersion;
            }
            if (!TextUtils.isEmpty(sMiuiVersion) && (split = sMiuiVersion.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
                String substring = split[0].substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    try {
                        if (Integer.parseInt(substring) < 9) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean checkVersionIs25() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT == 25 : invokeV.booleanValue;
    }

    public static boolean checkVersionIsHigh25() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.VERSION.SDK_INT >= 25 : invokeV.booleanValue;
    }

    public static void fixToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                Method declaredMethod = Toast.class.getDeclaredMethod("getService", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                if (invoke == null) {
                    return;
                }
                InvocationHandler invocationHandler = new InvocationHandler(invoke) { // from class: com.baidu.android.ext.widget.toast.ToastUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object val$serviceObj;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {invoke};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$serviceObj = invoke;
                    }

                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                            if (TextUtils.equals("enqueueToast", method.getName())) {
                                ToastUtils.replaceToastTNmHandler(objArr[1]);
                            }
                            return method.invoke(this.val$serviceObj, objArr);
                        }
                        return invokeLLL.objValue;
                    }
                };
                Field declaredField = Toast.class.getDeclaredField("sService");
                declaredField.setAccessible(true);
                declaredField.set(null, Proxy.newProxyInstance(invoke.getClass().getClassLoader(), new Class[]{declaredField.getType()}, invocationHandler));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLL;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) {
            if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLL.objValue;
    }

    @SuppressLint({"PrivateApi"})
    public static String getSystemProperty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        InterceptResult invokeL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 19) {
                try {
                    Object systemService = context.getSystemService("appops");
                    if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                        return false;
                    }
                    return ((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void printStackTraceString(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, str) == null) && sDebug) {
            Log.getStackTraceString(new Throwable(str));
        }
    }

    public static void processAlpha(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, view) == null) || view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.android.ext.widget.toast.ToastUtils.2
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
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        view2.setAlpha(0.2f);
                        return false;
                    } else if (action != 2) {
                        view2.setAlpha(1.0f);
                        return false;
                    } else {
                        return false;
                    }
                }
                return invokeLL.booleanValue;
            }
        });
    }

    public static void replaceToastTNmHandler(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, obj) == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("mHide");
                declaredField.setAccessible(true);
                Runnable runnable = (Runnable) declaredField.get(obj);
                Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                Handler handler = (Handler) declaredField2.get(obj);
                if (handler instanceof TNHandler) {
                    return;
                }
                declaredField2.set(obj, new TNHandler(runnable, handler));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void setColorFilter(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setColorFilter(AppRuntime.getAppContext().getResources().getColor(R.color.ui_cover_layer_color), PorterDuff.Mode.SRC_ATOP);
    }

    public static void setDebugEnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            sDebug = true;
        }
    }

    public static void setToastAnimation(Toast toast, @StyleRes int i2) {
        Object field;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65554, null, toast, i2) == null) {
            try {
                Object field2 = getField(toast, "mTN");
                if (field2 == null || (field = getField(field2, "mParams")) == null || !(field instanceof WindowManager.LayoutParams)) {
                    return;
                }
                ((WindowManager.LayoutParams) field).windowAnimations = i2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean shouldShowMeizuToast(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? checkIsMeizuRom() && !isFloatWindowOpAllowed(context) && Build.VERSION.SDK_INT >= 23 : invokeL.booleanValue;
    }

    public static boolean shouldShowMiToast(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (checkIsMiuiRom()) {
                return (checkMiuiVersionIsLow9() && isFloatWindowOpAllowed(context)) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldShowSystemToast(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            return (shouldShowMiToast(context) || checkVersionIsHigh25()) || shouldShowMeizuToast(context);
        }
        return invokeL.booleanValue;
    }
}
