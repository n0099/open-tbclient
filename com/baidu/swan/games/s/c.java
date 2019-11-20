package com.baidu.swan.games.s;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.s.a.d;
/* loaded from: classes2.dex */
public class c {
    protected b bDG = new b();
    protected com.baidu.swan.games.e.b bxv;

    public c(com.baidu.swan.games.e.b bVar) {
        this.bxv = bVar;
    }

    @NonNull
    public d kB(String str) {
        Object obj = null;
        if (str == null) {
            return d.kE("parameter error: the key cannot be null.");
        }
        String string = this.bDG.getString(str, null);
        if (string != null) {
            obj = this.bxv.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.Yh();
        }
        return d.O(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.kE("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.O(null);
        }
        byte[] a = this.bxv.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.kE("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bDG.getString(str, null);
        int length = str.getBytes().length;
        if (this.bDG.SQ() - this.bDG.SP() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.kE("storage error: the storage space insufficient.");
        }
        boolean bo = this.bDG.bo(str, encodeToString);
        e.bsj.update();
        return bo ? d.O(null) : d.kE("storage error: the storage is invalid.");
    }

    @NonNull
    public d kC(String str) {
        if (str == null) {
            return d.kE("parameter error: the key cannot be null.");
        }
        this.bDG.remove(str);
        e.bsj.update();
        return d.O(null);
    }

    @NonNull
    public d Yf() {
        this.bDG.Yd();
        e.bsj.update();
        return d.O(null);
    }

    @NonNull
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        String[] Yc = this.bDG.Yc();
        com.baidu.swan.games.s.a.c cVar = new com.baidu.swan.games.s.a.c();
        cVar.keys = Yc;
        cVar.currentSize = this.bDG.SP() / 1024;
        cVar.limitSize = this.bDG.SQ() / 1024;
        cVar.errMsg = com.baidu.swan.games.s.a.a.kD("getStorageInfoSync");
        return cVar;
    }
}
