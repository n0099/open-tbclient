package com.baidu.searchbox.pms.utils;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.google.gson.Gson;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DebugUtils {
    public static void log(boolean z, Object... objArr) {
        String str;
        String substring;
        boolean z2;
        String json;
        if (!AppConfig.isDebug()) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            substring = DebugUtils.class.getSimpleName();
            str = "error" + Log.getStackTraceString(new Throwable());
        } else {
            str = stackTrace[3].getMethodName() + "()";
            substring = stackTrace[3].getClassName().substring(stackTrace[3].getClassName().lastIndexOf(".") + 1);
        }
        StringBuilder sb = new StringBuilder();
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (!(obj instanceof String) && !(obj instanceof Number)) {
                    if (obj instanceof Throwable) {
                        sb.append(((Throwable) obj).getLocalizedMessage());
                    } else if (obj instanceof JSONObject) {
                        sb.append(obj.toString());
                    } else if (obj == null) {
                        sb.append(StringUtil.NULL_STRING);
                    } else {
                        try {
                            obj.getClass().getDeclaredMethod("toString", new Class[0]);
                            z2 = true;
                        } catch (NoSuchMethodException unused) {
                            z2 = false;
                        }
                        sb.append(obj.getClass().getSimpleName());
                        sb.append(":");
                        if (z2) {
                            json = obj.toString();
                        } else {
                            json = new Gson().toJson(obj);
                        }
                        sb.append(json);
                        sb.append(" | ");
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(" ");
            }
        } else {
            sb.append("------");
        }
        if (z) {
            Log.e("pms_" + substring + "." + str, sb.toString());
            return;
        }
        Log.d("pms_" + substring + "." + str, sb.toString());
    }

    public static void log(Object... objArr) {
        log(false, objArr);
    }

    public static void logE(Object... objArr) {
        log(true, objArr);
    }

    public static void printStackTrace(Throwable th) {
        if (AppConfig.isDebug()) {
            th.printStackTrace();
        }
    }

    public static void throwExceptionForDebug(String str) {
        if (!AppConfig.isDebug()) {
            return;
        }
        throw new RuntimeException(str);
    }

    public static void throwExceptionForDebug(Throwable th) {
        if (!AppConfig.isDebug()) {
            return;
        }
        throw new RuntimeException(th);
    }
}
