package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes10.dex */
public class c {
    protected com.baidu.swan.games.f.b dQV;
    protected b dZw = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dQV = bVar;
    }

    @NonNull
    public d xF(String str) {
        Object obj = null;
        if (str == null) {
            return d.xI("parameter error: the key cannot be null.");
        }
        String string = this.dZw.getString(str, null);
        if (string != null) {
            obj = this.dQV.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aXn();
        }
        return d.ah(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xI("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ah(null);
        } else {
            byte[] a2 = this.dQV.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xI("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.dZw.getString(str, null);
            int length = str.getBytes().length;
            if (this.dZw.aKF() - this.dZw.aKE() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xI("storage error: the storage space insufficient.");
            }
            boolean putString = this.dZw.putString(str, encodeToString);
            e.dCQ.update();
            return putString ? d.ah(null) : d.xI("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d xG(String str) {
        if (str == null) {
            return d.xI("parameter error: the key cannot be null.");
        }
        this.dZw.remove(str);
        e.dCQ.update();
        return d.ah(null);
    }

    @NonNull
    public d aXl() {
        this.dZw.aXi();
        e.dCQ.update();
        return d.ah(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aXh = this.dZw.aXh();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aXh;
        cVar.currentSize = this.dZw.aKE() / 1024;
        cVar.limitSize = this.dZw.aKF() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xH("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
