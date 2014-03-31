package com.baidu.batsdk.b;

import android.content.Context;
import android.text.format.Time;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class c {
    private static final String[] a = {"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};

    public static String a(Context context) {
        try {
            Field field = Context.class.getField("DROPBOX_SERVICE");
            String str = field != null ? (String) field.get(null) : null;
            if (str == null) {
                return "N/A";
            }
            Object systemService = context.getSystemService(str);
            Method method = systemService.getClass().getMethod("getNextEntry", String.class, Long.TYPE);
            if (method == null) {
                return "N/A";
            }
            Time time = new Time();
            time.setToNow();
            time.minute -= 5;
            time.normalize(false);
            long millis = time.toMillis(false);
            ArrayList<String> arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(a));
            if (arrayList.isEmpty()) {
                return "No tag configured for collection.";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                sb.append("Tag: ").append(str2).append('\n');
                Object invoke = method.invoke(systemService, str2, Long.valueOf(millis));
                if (invoke == null) {
                    sb.append("Nothing.\n");
                } else {
                    Method method2 = invoke.getClass().getMethod("getText", Integer.TYPE);
                    Method method3 = invoke.getClass().getMethod("getTimeMillis", null);
                    Method method4 = invoke.getClass().getMethod("close", null);
                    Object obj = invoke;
                    while (obj != null) {
                        long longValue = ((Long) method3.invoke(obj, null)).longValue();
                        time.set(longValue);
                        sb.append("@").append(time.format2445()).append('\n');
                        String str3 = (String) method2.invoke(obj, Integer.valueOf(com.baidu.batsdk.a.q));
                        if (str3 != null) {
                            sb.append("Text: ").append(str3).append('\n');
                        } else {
                            sb.append("Not Text!\n");
                        }
                        method4.invoke(obj, null);
                        obj = method.invoke(systemService, str2, Long.valueOf(longValue));
                    }
                }
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e);
            return "N/A";
        } catch (IllegalArgumentException e2) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e2);
            return "N/A";
        } catch (NoSuchFieldException e3) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e3);
            return "N/A";
        } catch (NoSuchMethodException e4) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e4);
            return "N/A";
        } catch (SecurityException e5) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e5);
            return "N/A";
        } catch (InvocationTargetException e6) {
            com.baidu.batsdk.f.a.b("Fail to read DropBox.", e6);
            return "N/A";
        }
    }
}
