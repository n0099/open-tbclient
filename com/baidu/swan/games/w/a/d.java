package com.baidu.swan.games.w.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes8.dex */
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

    /* renamed from: do  reason: not valid java name */
    public String m29do(String str, String str2) {
        if (isSuccess()) {
            return a.wX(str);
        }
        return a.ag(str, str2, aYk());
    }

    public String aYk() {
        return this.error;
    }

    public Object getData() {
        return this.data;
    }

    public static Object aYl() {
        return new JsObject();
    }

    public static String lg(int i) {
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
                return com.baidu.fsg.base.statistics.b.j;
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

    public static d ai(@Nullable Object obj) {
        return new d(null, obj);
    }

    public static d wY(@NonNull String str) {
        return new d(str, null);
    }

    public static Object a(com.baidu.swan.games.f.b bVar, String str, String str2, d dVar) {
        if (dVar.isSuccess()) {
            return dVar.getData();
        }
        String ag = a.ag(str, str2, dVar.aYk());
        bVar.throwJSException(JSExceptionType.Error, ag);
        return ag;
    }
}
