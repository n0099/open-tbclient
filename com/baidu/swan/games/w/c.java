package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes10.dex */
public class c {
    protected com.baidu.swan.games.f.b dCG;
    protected b dLh = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dCG = bVar;
    }

    @NonNull
    public d wY(String str) {
        Object obj = null;
        if (str == null) {
            return d.xb("parameter error: the key cannot be null.");
        }
        String string = this.dLh.getString(str, null);
        if (string != null) {
            obj = this.dCG.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aST();
        }
        return d.ah(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xb("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ah(null);
        } else {
            byte[] a2 = this.dCG.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xb("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.dLh.getString(str, null);
            int length = str.getBytes().length;
            if (this.dLh.aGl() - this.dLh.aGk() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xb("storage error: the storage space insufficient.");
            }
            boolean putString = this.dLh.putString(str, encodeToString);
            e.doy.update();
            return putString ? d.ah(null) : d.xb("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d wZ(String str) {
        if (str == null) {
            return d.xb("parameter error: the key cannot be null.");
        }
        this.dLh.remove(str);
        e.doy.update();
        return d.ah(null);
    }

    @NonNull
    public d aSR() {
        this.dLh.aSO();
        e.doy.update();
        return d.ah(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aSN = this.dLh.aSN();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aSN;
        cVar.currentSize = this.dLh.aGk() / 1024;
        cVar.limitSize = this.dLh.aGl() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xa("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
