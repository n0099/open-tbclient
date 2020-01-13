package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes10.dex */
public class c {
    protected com.baidu.swan.games.e.b cfV;
    protected b cop = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cfV = bVar;
    }

    @NonNull
    public d pr(String str) {
        Object obj = null;
        if (str == null) {
            return d.pu("parameter error: the key cannot be null.");
        }
        String string = this.cop.getString(str, null);
        if (string != null) {
            obj = this.cfV.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.anz();
        }
        return d.V(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.pu("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.V(null);
        } else {
            byte[] a = this.cfV.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.pu("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.cop.getString(str, null);
            int length = str.getBytes().length;
            if (this.cop.acV() - this.cop.acU() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.pu("storage error: the storage space insufficient.");
            }
            boolean putString = this.cop.putString(str, encodeToString);
            e.bTL.update();
            return putString ? d.V(null) : d.pu("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d ps(String str) {
        if (str == null) {
            return d.pu("parameter error: the key cannot be null.");
        }
        this.cop.remove(str);
        e.bTL.update();
        return d.V(null);
    }

    @NonNull
    public d anx() {
        this.cop.anu();
        e.bTL.update();
        return d.V(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] ant = this.cop.ant();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = ant;
        cVar.currentSize = this.cop.acU() / 1024;
        cVar.limitSize = this.cop.acV() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.pt("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
