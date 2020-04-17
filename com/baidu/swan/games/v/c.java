package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.e.b cJh;
    protected b cRy = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cJh = bVar;
    }

    @NonNull
    public d qS(String str) {
        Object obj = null;
        if (str == null) {
            return d.qV("parameter error: the key cannot be null.");
        }
        String string = this.cRy.getString(str, null);
        if (string != null) {
            obj = this.cJh.b(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aye();
        }
        return d.Y(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.qV("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.Y(null);
        } else {
            byte[] a = this.cJh.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.qV("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.cRy.getString(str, null);
            int length = str.getBytes().length;
            if (this.cRy.ant() - this.cRy.ans() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.qV("storage error: the storage space insufficient.");
            }
            boolean putString = this.cRy.putString(str, encodeToString);
            e.cwU.update();
            return putString ? d.Y(null) : d.qV("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d qT(String str) {
        if (str == null) {
            return d.qV("parameter error: the key cannot be null.");
        }
        this.cRy.remove(str);
        e.cwU.update();
        return d.Y(null);
    }

    @NonNull
    public d ayc() {
        this.cRy.axZ();
        e.cwU.update();
        return d.Y(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] axY = this.cRy.axY();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = axY;
        cVar.currentSize = this.cRy.ans() / 1024;
        cVar.limitSize = this.cRy.ant() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.qU("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
