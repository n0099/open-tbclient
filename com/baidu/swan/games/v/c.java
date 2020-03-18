package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.e.b ckm;
    protected b csD = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.ckm = bVar;
    }

    @NonNull
    public d pF(String str) {
        Object obj = null;
        if (str == null) {
            return d.pI("parameter error: the key cannot be null.");
        }
        String string = this.csD.getString(str, null);
        if (string != null) {
            obj = this.ckm.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.apS();
        }
        return d.X(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.pI("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.X(null);
        } else {
            byte[] a = this.ckm.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.pI("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.csD.getString(str, null);
            int length = str.getBytes().length;
            if (this.csD.afo() - this.csD.afn() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.pI("storage error: the storage space insufficient.");
            }
            boolean putString = this.csD.putString(str, encodeToString);
            e.bYc.update();
            return putString ? d.X(null) : d.pI("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d pG(String str) {
        if (str == null) {
            return d.pI("parameter error: the key cannot be null.");
        }
        this.csD.remove(str);
        e.bYc.update();
        return d.X(null);
    }

    @NonNull
    public d apQ() {
        this.csD.apN();
        e.bYc.update();
        return d.X(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] apM = this.csD.apM();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = apM;
        cVar.currentSize = this.csD.afn() / 1024;
        cVar.limitSize = this.csD.afo() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.pH("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
