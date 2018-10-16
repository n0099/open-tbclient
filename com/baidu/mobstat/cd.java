package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public final class cd {
    public static String a(Context context) {
        return e.a(context);
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap<>(map);
    }

    public static String a(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AiAppDateTimeUtil.DAY_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(date);
    }

    public static boolean a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String methodName = stackTraceElement.getMethodName();
            if (!TextUtils.isEmpty(methodName) && cls != null && methodName.equals(str)) {
                String className = stackTraceElement.getClassName();
                Class<?> cls2 = null;
                try {
                    cls2 = Class.forName(className);
                } catch (Throwable th) {
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
