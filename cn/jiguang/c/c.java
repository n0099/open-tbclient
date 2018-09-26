package cn.jiguang.c;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class c {
    private static String a = "";

    public static String a(Context context) {
        return !TextUtils.isEmpty("") ? "" : b(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context) {
        String str;
        Object systemService;
        Method declaredMethod;
        Object invoke;
        int intValue;
        String str2 = null;
        int i = -1;
        if (context != null) {
            try {
                systemService = context.getApplicationContext().getSystemService("country_detector");
            } catch (Throwable th) {
            }
            if (systemService != null && (declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0])) != null && (invoke = declaredMethod.invoke(systemService, new Object[0])) != null) {
                String str3 = (String) invoke.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(invoke, new Object[0]);
                try {
                    str2 = str3;
                    intValue = ((Integer) invoke.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(invoke, new Object[0])).intValue();
                    i = intValue;
                    str = str2;
                } catch (Throwable th2) {
                    str2 = str3;
                    str = str2;
                    if (i != 0) {
                    }
                }
                return (i != 0 || i == 1) ? str : "";
            }
        }
        intValue = -1;
        i = intValue;
        str = str2;
        if (i != 0) {
            return str;
        }
    }
}
