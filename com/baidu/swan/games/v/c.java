package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.e.b cjZ;
    protected b csq = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cjZ = bVar;
    }

    @NonNull
    public d pG(String str) {
        Object obj = null;
        if (str == null) {
            return d.pJ("parameter error: the key cannot be null.");
        }
        String string = this.csq.getString(str, null);
        if (string != null) {
            obj = this.cjZ.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.apN();
        }
        return d.X(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.pJ("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.X(null);
        } else {
            byte[] a = this.cjZ.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.pJ("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.csq.getString(str, null);
            int length = str.getBytes().length;
            if (this.csq.afj() - this.csq.afi() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.pJ("storage error: the storage space insufficient.");
            }
            boolean putString = this.csq.putString(str, encodeToString);
            e.bXP.update();
            return putString ? d.X(null) : d.pJ("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d pH(String str) {
        if (str == null) {
            return d.pJ("parameter error: the key cannot be null.");
        }
        this.csq.remove(str);
        e.bXP.update();
        return d.X(null);
    }

    @NonNull
    public d apL() {
        this.csq.apI();
        e.bXP.update();
        return d.X(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] apH = this.csq.apH();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = apH;
        cVar.currentSize = this.csq.afi() / 1024;
        cVar.limitSize = this.csq.afj() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.pI("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
