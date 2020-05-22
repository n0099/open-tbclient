package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.f.b cTU;
    protected b dcB = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.cTU = bVar;
    }

    @NonNull
    public d sw(String str) {
        Object obj = null;
        if (str == null) {
            return d.sz("parameter error: the key cannot be null.");
        }
        String string = this.dcB.getString(str, null);
        if (string != null) {
            obj = this.cTU.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aBV();
        }
        return d.ad(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.sz("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ad(null);
        } else {
            byte[] a = this.cTU.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.sz("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dcB.getString(str, null);
            int length = str.getBytes().length;
            if (this.dcB.arB() - this.dcB.arA() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.sz("storage error: the storage space insufficient.");
            }
            boolean putString = this.dcB.putString(str, encodeToString);
            e.cJd.update();
            return putString ? d.ad(null) : d.sz("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d sx(String str) {
        if (str == null) {
            return d.sz("parameter error: the key cannot be null.");
        }
        this.dcB.remove(str);
        e.cJd.update();
        return d.ad(null);
    }

    @NonNull
    public d aBT() {
        this.dcB.aBQ();
        e.cJd.update();
        return d.ad(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aBP = this.dcB.aBP();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aBP;
        cVar.currentSize = this.dcB.arA() / 1024;
        cVar.limitSize = this.dcB.arB() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.sy("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
