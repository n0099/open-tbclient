package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes8.dex */
public class c {
    protected com.baidu.swan.games.f.b dox;
    protected b dxb = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dox = bVar;
    }

    @NonNull
    public d vS(String str) {
        Object obj = null;
        if (str == null) {
            return d.vV("parameter error: the key cannot be null.");
        }
        String string = this.dxb.getString(str, null);
        if (string != null) {
            obj = this.dox.d(Base64.decode(string, 2), true);
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
            return d.vV("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ad(null);
        } else {
            byte[] a = this.dox.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.vV("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dxb.getString(str, null);
            int length = str.getBytes().length;
            if (this.dxb.aCS() - this.dxb.aCR() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.vV("storage error: the storage space insufficient.");
            }
            boolean putString = this.dxb.putString(str, encodeToString);
            e.dai.update();
            return putString ? d.ad(null) : d.vV("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d vT(String str) {
        if (str == null) {
            return d.vV("parameter error: the key cannot be null.");
        }
        this.dxb.remove(str);
        e.dai.update();
        return d.ad(null);
    }

    @NonNull
    public d aPx() {
        this.dxb.aPu();
        e.dai.update();
        return d.ad(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aPt = this.dxb.aPt();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aPt;
        cVar.currentSize = this.dxb.aCR() / 1024;
        cVar.limitSize = this.dxb.aCS() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.vU("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
