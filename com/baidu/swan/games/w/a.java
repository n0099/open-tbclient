package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes8.dex */
public class a extends c {
    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
    }

    public void getStorage(JsObject jsObject) {
        String a = a(jsObject, "getStorage");
        if (a != null) {
            d vS = vS(a);
            if (vS.isSuccess()) {
                com.baidu.swan.games.w.a.b bVar = new com.baidu.swan.games.w.a.b();
                bVar.errMsg = com.baidu.swan.games.w.a.a.vU("getStorage");
                bVar.data = vS.getData();
                if (bVar.data instanceof JsSerializeValue) {
                    ((JsSerializeValue) bVar.data).setAutoRelease(false);
                }
                com.baidu.swan.games.utils.b.a(k(jsObject), true, bVar);
                return;
            }
            a(jsObject, "getStorage", a, vS);
        }
    }

    public void setStorage(JsObject jsObject) {
        String a = a(jsObject, "setStorage");
        if (a != null) {
            a(jsObject, "setStorage", a, a(a, m(jsObject)));
        }
    }

    public void removeStorage(JsObject jsObject) {
        String a = a(jsObject, "removeStorage");
        if (a != null) {
            a(jsObject, "removeStorage", a, vT(a));
        }
    }

    public void clearStorage(JsObject jsObject) {
        a(jsObject, "clearStorage", "", aPx());
    }

    public void getStorageInfo(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        com.baidu.swan.games.w.a.c storageInfoSync = getStorageInfoSync();
        storageInfoSync.errMsg = com.baidu.swan.games.w.a.a.vU("getStorageInfo");
        com.baidu.swan.games.utils.b.a(k, true, storageInfoSync);
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c k(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        return e == null ? new com.baidu.swan.games.binding.model.c() : e;
    }

    private String a(JsObject jsObject, String str) {
        d l = l(jsObject);
        if (l.isSuccess()) {
            return (String) l.getData();
        }
        a(jsObject, str, "", l);
        return null;
    }

    private d l(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("key".equals(jsObject.getPropertyName(i))) {
                int propertyType = jsObject.getPropertyType(i);
                if (propertyType == 7) {
                    return d.ad(jsObject.toString(i));
                }
                return d.vV(String.format("parameter error: the key must be string instead of %s.", d.lh(propertyType)));
            }
        }
        return d.vV("parameter error: the parameter key is necessary.");
    }

    private JsSerializeValue m(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("data".equals(jsObject.getPropertyName(i))) {
                return jsObject.toSerializeValue(i);
            }
        }
        return null;
    }

    private void a(JsObject jsObject, String str, String str2, d dVar) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        boolean isSuccess = dVar.isSuccess();
        bVar.errMsg = dVar.cY(str, str2);
        com.baidu.swan.games.utils.b.a(k, isSuccess, bVar);
        if (!isSuccess) {
            com.baidu.swan.games.v.c.cX(str2, bVar.errMsg);
        }
    }
}
