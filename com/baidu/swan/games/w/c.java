package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes7.dex */
public class c {
    protected com.baidu.swan.games.f.b deo;
    protected b dmW = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.deo = bVar;
    }

    @NonNull
    public d tC(String str) {
        Object obj = null;
        if (str == null) {
            return d.tF("parameter error: the key cannot be null.");
        }
        String string = this.dmW.getString(str, null);
        if (string != null) {
            obj = this.deo.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aGI();
        }
        return d.ad(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.tF("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ad(null);
        } else {
            byte[] a = this.deo.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.tF("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dmW.getString(str, null);
            int length = str.getBytes().length;
            if (this.dmW.auJ() - this.dmW.auI() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.tF("storage error: the storage space insufficient.");
            }
            boolean putString = this.dmW.putString(str, encodeToString);
            e.cRi.update();
            return putString ? d.ad(null) : d.tF("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d tD(String str) {
        if (str == null) {
            return d.tF("parameter error: the key cannot be null.");
        }
        this.dmW.remove(str);
        e.cRi.update();
        return d.ad(null);
    }

    @NonNull
    public d aGG() {
        this.dmW.aGD();
        e.cRi.update();
        return d.ad(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aGC = this.dmW.aGC();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aGC;
        cVar.currentSize = this.dmW.auI() / 1024;
        cVar.limitSize = this.dmW.auJ() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.tE("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
