package com.baidu.swan.games.v.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes10.dex */
public class d {
    private final Object data;
    private final String error;

    private d(String str, Object obj) {
        this.error = str;
        this.data = obj;
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    public String bL(String str, String str2) {
        if (isSuccess()) {
            return a.pt(str);
        }
        return a.L(str, str2, any());
    }

    public String any() {
        return this.error;
    }

    public Object getData() {
        return this.data;
    }

    public static Object anz() {
        return new JsObject();
    }

    public static String hF(int i) {
        switch (i) {
            case 1:
                return "boolean";
            case 2:
            case 3:
            case 5:
                return "number";
            case 4:
            default:
                return "unknown";
            case 6:
                return "array";
            case 7:
                return "string";
            case 8:
                return "function";
            case 9:
                return "object";
            case 10:
                return "arraybuffer";
            case 11:
                return "null";
            case 12:
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        }
    }

    public static d V(@Nullable Object obj) {
        return new d(null, obj);
    }

    public static d pu(@NonNull String str) {
        return new d(str, null);
    }

    public static Object a(com.baidu.swan.games.e.b bVar, String str, String str2, d dVar) {
        if (dVar.isSuccess()) {
            return dVar.getData();
        }
        String L = a.L(str, str2, dVar.any());
        bVar.throwJSException(JSExceptionType.Error, L);
        return L;
    }
}
