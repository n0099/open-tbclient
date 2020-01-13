package com.baidu.android.ext.widget.toast;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;
/* loaded from: classes12.dex */
public class ToastUtils {
    private static final String KEY_MIUI_BUILD_VERSION = "ro.build.version.incremental";
    private static final String MEIZU_ROM = "Flyme";
    private static final String MIUI_NAME = "ro.miui.ui.version.name";
    private static final String OPPO_NAME = "ro.build.version.opporom";
    private static final int OP_SYSTEM_ALERT_WINDOW = 24;
    private static final String TAG = "ToastUtils";
    private static final int VERSION_MIUI = 9;
    private static String sMiOsName = null;
    private static String sMiuiVersion = null;
    private static String sOppoOsName = null;
    private static boolean sDebug = false;

    public static boolean shouldShowSystemToast(Context context) {
        return (shouldShowMiToast(context) || checkVersionIsHigh25()) || shouldShowMeizuToast(context);
    }

    private static boolean shouldShowMiToast(Context context) {
        if (checkIsMiuiRom()) {
            return (checkMiuiVersionIsLow9() && isFloatWindowOpAllowed(context)) ? false : true;
        }
        return false;
    }

    private static boolean checkMiuiVersionIsLow9() {
        String[] split;
        if (sMiuiVersion == null) {
            sMiuiVersion = PrivateApiUtils.getSystemProperty("ro.build.version.incremental", "");
        }
        if (sDebug) {
            Log.d(TAG, "sMiuiVersion = " + sMiuiVersion);
        }
        if (!TextUtils.isEmpty(sMiuiVersion) && (split = sMiuiVersion.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
            String substring = split[0].substring(1);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            try {
                return Integer.parseInt(substring) < 9;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    private static boolean checkVersionIsHigh25() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static boolean checkVersionIs25() {
        return Build.VERSION.SDK_INT == 25;
    }

    private static boolean checkIsMiuiRom() {
        if (sMiOsName == null) {
            sMiOsName = PrivateApiUtils.getSystemProperty(MIUI_NAME, "");
        }
        if (sDebug) {
            Log.d(TAG, "OsName = " + sMiOsName);
        }
        return !TextUtils.isEmpty(sMiOsName);
    }

    public static boolean checkIsOppoRom() {
        if (sOppoOsName == null) {
            sOppoOsName = PrivateApiUtils.getSystemProperty(OPPO_NAME, "");
        }
        if (sDebug) {
            Log.d(TAG, "OsName = " + sOppoOsName);
        }
        return !TextUtils.isEmpty(sOppoOsName);
    }

    private static boolean shouldShowMeizuToast(Context context) {
        return checkIsMeizuRom() && !isFloatWindowOpAllowed(context) && Build.VERSION.SDK_INT >= 23;
    }

    private static boolean checkIsMeizuRom() {
        return Build.FINGERPRINT.contains(MEIZU_ROM) || Pattern.compile(MEIZU_ROM, 2).matcher(Build.DISPLAY).find();
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void setToastAnimation(Toast toast, @StyleRes int i) {
        Object field;
        try {
            Object field2 = getField(toast, "mTN");
            if (field2 != null && (field = getField(field2, "mParams")) != null && (field instanceof WindowManager.LayoutParams)) {
                ((WindowManager.LayoutParams) field).windowAnimations = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField;
        if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        Method method;
        if (context != null && Build.VERSION.SDK_INT >= 19) {
            try {
                Object systemService = context.getSystemService("appops");
                if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                    return false;
                }
                return ((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void fixToast() {
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", null);
            declaredMethod.setAccessible(true);
            final Object invoke = declaredMethod.invoke(null, null);
            if (invoke != null) {
                InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.baidu.android.ext.widget.toast.ToastUtils.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if (TextUtils.equals("enqueueToast", method.getName())) {
                            ToastUtils.replaceToastTNmHandler(objArr[1]);
                        }
                        return method.invoke(invoke, objArr);
                    }
                };
                Field declaredField = Toast.class.getDeclaredField("sService");
                declaredField.setAccessible(true);
                declaredField.set(null, Proxy.newProxyInstance(invoke.getClass().getClassLoader(), new Class[]{declaredField.getType()}, invocationHandler));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class TNHandler extends Handler {
        private Runnable mHideRunnable;
        private Handler mOrigHandler;

        public TNHandler(Runnable runnable, Handler handler) {
            this.mHideRunnable = runnable;
            this.mOrigHandler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                try {
                    if (!hasMessages(2) && !hasMessages(1)) {
                        Method declaredMethod = Class.forName("android.os.Handler").getDeclaredMethod("hasCallbacks", Runnable.class);
                        declaredMethod.setAccessible(true);
                        if (((Boolean) declaredMethod.invoke(this, this.mHideRunnable)).booleanValue()) {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
            try {
                this.mOrigHandler.handleMessage(message);
            } catch (WindowManager.BadTokenException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void replaceToastTNmHandler(Object obj) {
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
