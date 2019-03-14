package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.q.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b aZZ;
    protected b bfj = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.aZZ = bVar;
    }

    @NonNull
    public d iW(String str) {
        Object obj = null;
        if (str == null) {
            return d.iZ("parameter error: the key cannot be null.");
        }
        String string = this.bfj.getString(str, null);
        if (string != null) {
            obj = this.aZZ.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.Pe();
        }
        return d.S(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.iZ("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.S(null);
        }
        byte[] a = this.aZZ.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.iZ("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bfj.getString(str, null);
        int length = str.getBytes().length;
        if (this.bfj.KI() - this.bfj.KH() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.iZ("storage error: the storage space insufficient.");
        }
        boolean be = this.bfj.be(str, encodeToString);
        e.aVP.update();
        return be ? d.S(null) : d.iZ("storage error: the storage is invalid.");
    }

    @NonNull
    public d iX(String str) {
        if (str == null) {
            return d.iZ("parameter error: the key cannot be null.");
        }
        this.bfj.remove(str);
        e.aVP.update();
        return d.S(null);
    }

    @NonNull
    public d Pc() {
        this.bfj.Pa();
        e.aVP.update();
        return d.S(null);
    }

    @NonNull
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        String[] OZ = this.bfj.OZ();
        com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
        cVar.keys = OZ;
        cVar.currentSize = this.bfj.KH() / 1024;
        cVar.limitSize = this.bfj.KI() / 1024;
        cVar.errMsg = com.baidu.swan.games.q.a.a.iY("getStorageInfoSync");
        return cVar;
    }
}
