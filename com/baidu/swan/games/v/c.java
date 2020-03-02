package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.e.b cka;
    protected b csr = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cka = bVar;
    }

    @NonNull
    public d pG(String str) {
        Object obj = null;
        if (str == null) {
            return d.pJ("parameter error: the key cannot be null.");
        }
        String string = this.csr.getString(str, null);
        if (string != null) {
            obj = this.cka.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.apP();
        }
        return d.X(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.pJ("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.X(null);
        } else {
            byte[] a = this.cka.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.pJ("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.csr.getString(str, null);
            int length = str.getBytes().length;
            if (this.csr.afl() - this.csr.afk() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.pJ("storage error: the storage space insufficient.");
            }
            boolean putString = this.csr.putString(str, encodeToString);
            e.bXQ.update();
            return putString ? d.X(null) : d.pJ("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d pH(String str) {
        if (str == null) {
            return d.pJ("parameter error: the key cannot be null.");
        }
        this.csr.remove(str);
        e.bXQ.update();
        return d.X(null);
    }

    @NonNull
    public d apN() {
        this.csr.apK();
        e.bXQ.update();
        return d.X(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] apJ = this.csr.apJ();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = apJ;
        cVar.currentSize = this.csr.afk() / 1024;
        cVar.limitSize = this.csr.afl() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.pI("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
