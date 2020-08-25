package com.baidu.swan.games.utils;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes8.dex */
public class b {
    public static void a(com.baidu.swan.games.binding.model.c cVar, boolean z, Object obj) {
        com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(cVar);
        if (z) {
            f.onSuccess(obj);
        } else {
            f.Y(obj);
        }
    }

    public static void a(com.baidu.swan.games.f.b bVar, JSTypeMismatchException jSTypeMismatchException) {
        bVar.throwJSException(JSExceptionType.TypeError, String.format("The \"%s\" argument must be %s. Received type %s", jSTypeMismatchException.name, li(jSTypeMismatchException.requiredType), li(jSTypeMismatchException.actualType)));
    }

    public static String a(@NonNull String str, @NonNull JSTypeMismatchException jSTypeMismatchException) {
        return String.format("%s:fail parameter error: parameter.%s should be %s instead of %s", str, jSTypeMismatchException.name, li(jSTypeMismatchException.requiredType), li(jSTypeMismatchException.actualType));
    }

    public static String cZ(@NonNull String str, @NonNull String str2) {
        return String.format("%s: %s", str, str2);
    }

    private static String li(int i) {
        switch (i) {
            case 1:
                return "boolean";
            case 2:
            case 3:
            case 5:
                return "number";
            case 4:
            case 9:
            case 10:
            default:
                return "object";
            case 6:
                return "array object";
            case 7:
                return "string";
            case 8:
                return "function object";
            case 11:
                return "null";
            case 12:
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        }
    }
}
