package com.baidu.swan.games.w;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes9.dex */
public class c {
    protected com.baidu.swan.games.f.b efi;
    protected b enO = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.efi = bVar;
    }

    @NonNull
    public d yg(String str) {
        Object obj = null;
        if (str == null) {
            return d.yj("parameter error: the key cannot be null.");
        }
        String string = this.enO.getString(str, null);
        if (string != null) {
            obj = this.efi.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.bcf();
        }
        return d.ai(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.yj("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ai(null);
        } else {
            byte[] a2 = this.efi.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.yj("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.enO.getString(str, null);
            int length = str.getBytes().length;
            if (this.enO.aPv() - this.enO.aPu() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.yj("storage error: the storage space insufficient.");
            }
            boolean putString = this.enO.putString(str, encodeToString);
            e.dQM.update();
            return putString ? d.ai(null) : d.yj("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d yh(String str) {
        if (str == null) {
            return d.yj("parameter error: the key cannot be null.");
        }
        this.enO.remove(str);
        e.dQM.update();
        return d.ai(null);
    }

    @NonNull
    public d bcd() {
        this.enO.bca();
        e.dQM.update();
        return d.ai(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] bbZ = this.enO.bbZ();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = bbZ;
        cVar.currentSize = this.enO.aPu() / 1024;
        cVar.limitSize = this.enO.aPv() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.yi("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
