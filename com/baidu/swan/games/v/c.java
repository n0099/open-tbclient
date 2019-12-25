package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes9.dex */
public class c {
    protected com.baidu.swan.games.e.b cfI;
    protected b coc = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.cfI = bVar;
    }

    @NonNull
    public d po(String str) {
        Object obj = null;
        if (str == null) {
            return d.pr("parameter error: the key cannot be null.");
        }
        String string = this.coc.getString(str, null);
        if (string != null) {
            obj = this.cfI.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.ang();
        }
        return d.V(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.pr("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.V(null);
        } else {
            byte[] a = this.cfI.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.pr("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.coc.getString(str, null);
            int length = str.getBytes().length;
            if (this.coc.acy() - this.coc.acx() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.pr("storage error: the storage space insufficient.");
            }
            boolean putString = this.coc.putString(str, encodeToString);
            e.bTz.update();
            return putString ? d.V(null) : d.pr("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d pp(String str) {
        if (str == null) {
            return d.pr("parameter error: the key cannot be null.");
        }
        this.coc.remove(str);
        e.bTz.update();
        return d.V(null);
    }

    @NonNull
    public d ane() {
        this.coc.anb();
        e.bTz.update();
        return d.V(null);
    }

    @NonNull
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        String[] ana = this.coc.ana();
        com.baidu.swan.games.v.a.c cVar = new com.baidu.swan.games.v.a.c();
        cVar.keys = ana;
        cVar.currentSize = this.coc.acx() / 1024;
        cVar.limitSize = this.coc.acy() / 1024;
        cVar.errMsg = com.baidu.swan.games.v.a.a.pq("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
