package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.e.b cJn;
    protected b cRD = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cJn = bVar;
    }

    @NonNull
    public d qS(String str) {
        Object obj = null;
        if (str == null) {
            return d.qV("parameter error: the key cannot be null.");
        }
        String string = this.cRD.getString(str, null);
        if (string != null) {
            obj = this.cJn.b(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aye();
        }
        return d.Z(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.qV("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.Z(null);
        } else {
            byte[] a = this.cJn.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.qV("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.cRD.getString(str, null);
            int length = str.getBytes().length;
            if (this.cRD.ans() - this.cRD.anr() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.qV("storage error: the storage space insufficient.");
            }
            boolean putString = this.cRD.putString(str, encodeToString);
            e.cxa.update();
            return putString ? d.Z(null) : d.qV("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d qT(String str) {
        if (str == null) {
            return d.qV("parameter error: the key cannot be null.");
        }
        this.cRD.remove(str);
        e.cxa.update();
        return d.Z(null);
    }

    @NonNull
    public d ayc() {
        this.cRD.axZ();
        e.cxa.update();
        return d.Z(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] axY = this.cRD.axY();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = axY;
        cVar.currentSize = this.cRD.anr() / 1024;
        cVar.limitSize = this.cRD.ans() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.qU("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
