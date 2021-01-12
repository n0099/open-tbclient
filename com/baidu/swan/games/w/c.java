package com.baidu.swan.games.w;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes8.dex */
public class c {
    protected com.baidu.swan.games.f.b eaw;
    protected b eja = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.eaw = bVar;
    }

    @NonNull
    public d wV(String str) {
        Object obj = null;
        if (str == null) {
            return d.wY("parameter error: the key cannot be null.");
        }
        String string = this.eja.getString(str, null);
        if (string != null) {
            obj = this.eaw.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aYl();
        }
        return d.ai(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.wY("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ai(null);
        } else {
            byte[] a2 = this.eaw.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.wY("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.eja.getString(str, null);
            int length = str.getBytes().length;
            if (this.eja.aLB() - this.eja.aLA() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.wY("storage error: the storage space insufficient.");
            }
            boolean putString = this.eja.putString(str, encodeToString);
            e.dMa.update();
            return putString ? d.ai(null) : d.wY("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d wW(String str) {
        if (str == null) {
            return d.wY("parameter error: the key cannot be null.");
        }
        this.eja.remove(str);
        e.dMa.update();
        return d.ai(null);
    }

    @NonNull
    public d aYj() {
        this.eja.aYg();
        e.dMa.update();
        return d.ai(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aYf = this.eja.aYf();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aYf;
        cVar.currentSize = this.eja.aLA() / 1024;
        cVar.limitSize = this.eja.aLB() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.wX("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
