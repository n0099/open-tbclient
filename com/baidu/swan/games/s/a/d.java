package com.baidu.swan.games.s.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes2.dex */
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

    public String bp(String str, String str2) {
        if (isSuccess()) {
            return a.kD(str);
        }
        return a.D(str, str2, Yg());
    }

    public String Yg() {
        return this.error;
    }

    public Object getData() {
        return this.data;
    }

    public static Object Yh() {
        return new JsObject();
    }

    public static String ga(int i) {
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
                return "undefined";
        }
    }

    public static d O(@Nullable Object obj) {
        return new d(null, obj);
    }

    public static d kE(@NonNull String str) {
        return new d(str, null);
    }

    public static Object a(com.baidu.swan.games.e.b bVar, String str, String str2, d dVar) {
        if (dVar.isSuccess()) {
            return dVar.getData();
        }
        String D = a.D(str, str2, dVar.Yg());
        bVar.throwJSException(JSExceptionType.Error, D);
        return D;
    }
}
