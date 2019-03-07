package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.q.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b aZY;
    protected b bfi = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.aZY = bVar;
    }

    @NonNull
    public d iW(String str) {
        Object obj = null;
        if (str == null) {
            return d.iZ("parameter error: the key cannot be null.");
        }
        String string = this.bfi.getString(str, null);
        if (string != null) {
            obj = this.aZY.c(Base64.decode(string, 2), true);
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
        byte[] a = this.aZY.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.iZ("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bfi.getString(str, null);
        int length = str.getBytes().length;
        if (this.bfi.KI() - this.bfi.KH() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.iZ("storage error: the storage space insufficient.");
        }
        boolean be = this.bfi.be(str, encodeToString);
        e.aVO.update();
        return be ? d.S(null) : d.iZ("storage error: the storage is invalid.");
    }

    @NonNull
    public d iX(String str) {
        if (str == null) {
            return d.iZ("parameter error: the key cannot be null.");
        }
        this.bfi.remove(str);
        e.aVO.update();
        return d.S(null);
    }

    @NonNull
    public d Pc() {
        this.bfi.Pa();
        e.aVO.update();
        return d.S(null);
    }

    @NonNull
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        String[] OZ = this.bfi.OZ();
        com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
        cVar.keys = OZ;
        cVar.currentSize = this.bfi.KH() / 1024;
        cVar.limitSize = this.bfi.KI() / 1024;
        cVar.errMsg = com.baidu.swan.games.q.a.a.iY("getStorageInfoSync");
        return cVar;
    }
}
