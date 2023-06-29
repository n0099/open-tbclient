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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ToastUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIG_FONT_MAX_LINES = 3;
    public static final String KEY_MIUI_BUILD_VERSION = "ro.build.version.incremental";
    public static final String MEIZU_ROM = "Flyme";
    public static final String MIUI_NAME = "ro.miui.ui.version.name";
    public static final int NORMAL_MAX_LINES = 2;
    public static final String OPPO_NAME = "ro.build.version.opporom";
    public static final int OP_SYSTEM_ALERT_WINDOW = 24;
    public static final String TAG = "ToastUtils";
    public static final int VERSION_MIUI = 9;
    public static boolean sDebug;
    public static String sMiOsName;
    public static String sMiuiVersion;
    public static String sOppoOsName;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    } catch (Exception e) {
                        if (ToastUtils.sDebug) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    this.mOrigHandler.handleMessage(message);
                } catch (WindowManager.BadTokenException e2) {
                    if (ToastUtils.sDebug) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public ToastUtils() {
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

    public static boolean checkVersionIs25() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT == 25) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean checkVersionIsHigh25() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int getMaxTitleLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (FontSizeHelper.getFontSizeType() < 2) {
                return 2;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public static void setDebugEnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            sDebug = true;
        }
    }

    public static void printStackTraceString(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, str) == null) && sDebug) {
            Log.d(TAG, Log.getStackTraceString(new Throwable(str)));
        }
    }

    public static void processAlpha(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, view2) == null) && view2 != null) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.android.ext.widget.toast.ToastUtils.2
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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 2) {
                                view3.setAlpha(1.0f);
                                return false;
                            }
                            return false;
                        }
                        view3.setAlpha(0.2f);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    public static void setColorFilter(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, drawable) != null) || drawable == null) {
            return;
        }
        drawable.setColorFilter(AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060b83), PorterDuff.Mode.SRC_ATOP);
    }

    public static boolean shouldShowMeizuToast(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (!checkIsMeizuRom() || isFloatWindowOpAllowed(context) || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldShowMiToast(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (!checkIsMiuiRom()) {
                return false;
            }
            if (checkMiuiVersionIsLow9() && isFloatWindowOpAllowed(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean shouldShowSystemToast(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (!shouldShowMiToast(context) && !checkVersionIsHigh25()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && !shouldShowMeizuToast(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkIsMeizuRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!Build.FINGERPRINT.contains(MEIZU_ROM) && !Pattern.compile(MEIZU_ROM, 2).matcher(Build.DISPLAY).find()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean checkIsMiuiRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (sMiOsName == null) {
                sMiOsName = PrivateApiUtils.getSystemProperty("ro.miui.ui.version.name", "");
            }
            if (sDebug) {
                Log.d(TAG, "OsName = " + sMiOsName);
            }
            return !TextUtils.isEmpty(sMiOsName);
        }
        return invokeV.booleanValue;
    }

    public static boolean checkIsOppoRom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sOppoOsName == null) {
                sOppoOsName = PrivateApiUtils.getSystemProperty("ro.build.version.opporom", "");
            }
            if (sDebug) {
                Log.d(TAG, "OsName = " + sOppoOsName);
            }
            return !TextUtils.isEmpty(sOppoOsName);
        }
        return invokeV.booleanValue;
    }

    public static boolean checkMiuiVersionIsLow9() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (sMiuiVersion == null) {
                sMiuiVersion = PrivateApiUtils.getSystemProperty("ro.build.version.incremental", "");
            }
            if (sDebug) {
                Log.d(TAG, "sMiuiVersion = " + sMiuiVersion);
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

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void fixToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
            } catch (Exception e) {
                if (sDebug) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLL;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e) {
                if (sDebug) {
                    e.printStackTrace();
                    return str2;
                }
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void setToastAnimation(Toast toast, @StyleRes int i) {
        Object field;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, toast, i) == null) {
            try {
                Object field2 = getField(toast, "mTN");
                if (field2 != null && (field = getField(field2, "mParams")) != null && (field instanceof WindowManager.LayoutParams)) {
                    ((WindowManager.LayoutParams) field).windowAnimations = i;
                }
            } catch (Exception e) {
                if (sDebug) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        InterceptResult invokeL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 19) {
                try {
                    Object systemService = context.getSystemService("appops");
                    if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                        return false;
                    }
                    if (((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() != 0) {
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    if (sDebug) {
                        th.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void replaceToastTNmHandler(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, obj) == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("mHide");
                declaredField.setAccessible(true);
                Runnable runnable = (Runnable) declaredField.get(obj);
                Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                Handler handler = (Handler) declaredField2.get(obj);
                if (!(handler instanceof TNHandler)) {
                    declaredField2.set(obj, new TNHandler(runnable, handler));
                }
            } catch (Exception e) {
                if (sDebug) {
                    e.printStackTrace();
                }
            }
        }
    }
}
