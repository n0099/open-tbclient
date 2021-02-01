package com.baidu.swan.games.w;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes9.dex */
public class c {
    protected com.baidu.swan.games.f.b ecD;
    protected b elh = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.ecD = bVar;
    }

    @NonNull
    public d xo(String str) {
        Object obj = null;
        if (str == null) {
            return d.xr("parameter error: the key cannot be null.");
        }
        String string = this.elh.getString(str, null);
        if (string != null) {
            obj = this.ecD.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aYx();
        }
        return d.ai(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xr("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ai(null);
        } else {
            byte[] a2 = this.ecD.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xr("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.elh.getString(str, null);
            int length = str.getBytes().length;
            if (this.elh.aLU() - this.elh.aLT() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xr("storage error: the storage space insufficient.");
            }
            boolean putString = this.elh.putString(str, encodeToString);
            e.dOe.update();
            return putString ? d.ai(null) : d.xr("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d xp(String str) {
        if (str == null) {
            return d.xr("parameter error: the key cannot be null.");
        }
        this.elh.remove(str);
        e.dOe.update();
        return d.ai(null);
    }

    @NonNull
    public d aYv() {
        this.elh.aYs();
        e.dOe.update();
        return d.ai(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aYr = this.elh.aYr();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aYr;
        cVar.currentSize = this.elh.aLT() / 1024;
        cVar.limitSize = this.elh.aLU() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xq("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
