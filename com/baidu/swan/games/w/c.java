package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes8.dex */
public class c {
    protected com.baidu.swan.games.f.b doB;
    protected b dxf = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.doB = bVar;
    }

    @NonNull
    public d vT(String str) {
        Object obj = null;
        if (str == null) {
            return d.vW("parameter error: the key cannot be null.");
        }
        String string = this.dxf.getString(str, null);
        if (string != null) {
            obj = this.doB.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aPz();
        }
        return d.ad(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.vW("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ad(null);
        } else {
            byte[] a = this.doB.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.vW("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dxf.getString(str, null);
            int length = str.getBytes().length;
            if (this.dxf.aCS() - this.dxf.aCR() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.vW("storage error: the storage space insufficient.");
            }
            boolean putString = this.dxf.putString(str, encodeToString);
            e.dam.update();
            return putString ? d.ad(null) : d.vW("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d vU(String str) {
        if (str == null) {
            return d.vW("parameter error: the key cannot be null.");
        }
        this.dxf.remove(str);
        e.dam.update();
        return d.ad(null);
    }

    @NonNull
    public d aPx() {
        this.dxf.aPu();
        e.dam.update();
        return d.ad(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aPt = this.dxf.aPt();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aPt;
        cVar.currentSize = this.dxf.aCR() / 1024;
        cVar.limitSize = this.dxf.aCS() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.vV("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
