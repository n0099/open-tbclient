package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes3.dex */
public class c {
    protected com.baidu.swan.games.f.b dqC;
    protected b dzg = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dqC = bVar;
    }

    @NonNull
    public d wm(String str) {
        Object obj = null;
        if (str == null) {
            return d.wp("parameter error: the key cannot be null.");
        }
        String string = this.dzg.getString(str, null);
        if (string != null) {
            obj = this.dqC.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aQk();
        }
        return d.ae(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.wp("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ae(null);
        } else {
            byte[] a = this.dqC.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.wp("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dzg.getString(str, null);
            int length = str.getBytes().length;
            if (this.dzg.aDC() - this.dzg.aDB() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.wp("storage error: the storage space insufficient.");
            }
            boolean putString = this.dzg.putString(str, encodeToString);
            e.dco.update();
            return putString ? d.ae(null) : d.wp("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d wn(String str) {
        if (str == null) {
            return d.wp("parameter error: the key cannot be null.");
        }
        this.dzg.remove(str);
        e.dco.update();
        return d.ae(null);
    }

    @NonNull
    public d aQi() {
        this.dzg.aQf();
        e.dco.update();
        return d.ae(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aQe = this.dzg.aQe();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aQe;
        cVar.currentSize = this.dzg.aDB() / 1024;
        cVar.limitSize = this.dzg.aDC() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.wo("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
