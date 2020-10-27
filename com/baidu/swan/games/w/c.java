package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes10.dex */
public class c {
    protected com.baidu.swan.games.f.b dLd;
    protected b dTE = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dLd = bVar;
    }

    @NonNull
    public d xr(String str) {
        Object obj = null;
        if (str == null) {
            return d.xu("parameter error: the key cannot be null.");
        }
        String string = this.dTE.getString(str, null);
        if (string != null) {
            obj = this.dLd.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aUN();
        }
        return d.ah(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xu("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ah(null);
        } else {
            byte[] a2 = this.dLd.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xu("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.dTE.getString(str, null);
            int length = str.getBytes().length;
            if (this.dTE.aIf() - this.dTE.aIe() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xu("storage error: the storage space insufficient.");
            }
            boolean putString = this.dTE.putString(str, encodeToString);
            e.dwY.update();
            return putString ? d.ah(null) : d.xu("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d xs(String str) {
        if (str == null) {
            return d.xu("parameter error: the key cannot be null.");
        }
        this.dTE.remove(str);
        e.dwY.update();
        return d.ah(null);
    }

    @NonNull
    public d aUL() {
        this.dTE.aUI();
        e.dwY.update();
        return d.ah(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aUH = this.dTE.aUH();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aUH;
        cVar.currentSize = this.dTE.aIe() / 1024;
        cVar.limitSize = this.dTE.aIf() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xt("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
