package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes25.dex */
public class c {
    protected com.baidu.swan.games.f.b dWl;
    protected b eeN = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dWl = bVar;
    }

    @NonNull
    public d yh(String str) {
        Object obj = null;
        if (str == null) {
            return d.yk("parameter error: the key cannot be null.");
        }
        String string = this.eeN.getString(str, null);
        if (string != null) {
            obj = this.dWl.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aZK();
        }
        return d.ah(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.yk("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ah(null);
        } else {
            byte[] a2 = this.dWl.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.yk("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.eeN.getString(str, null);
            int length = str.getBytes().length;
            if (this.eeN.aNe() - this.eeN.aNd() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.yk("storage error: the storage space insufficient.");
            }
            boolean putString = this.eeN.putString(str, encodeToString);
            e.dIh.update();
            return putString ? d.ah(null) : d.yk("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d yi(String str) {
        if (str == null) {
            return d.yk("parameter error: the key cannot be null.");
        }
        this.eeN.remove(str);
        e.dIh.update();
        return d.ah(null);
    }

    @NonNull
    public d aZI() {
        this.eeN.aZF();
        e.dIh.update();
        return d.ah(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aZE = this.eeN.aZE();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aZE;
        cVar.currentSize = this.eeN.aNd() / 1024;
        cVar.limitSize = this.eeN.aNe() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.yj("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
