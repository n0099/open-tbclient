package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.games.q.a.d;
/* loaded from: classes2.dex */
public class a extends c {
    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
    }

    public void getStorage(JsObject jsObject) {
        String a = a(jsObject, "getStorage");
        if (a != null) {
            d iX = iX(a);
            if (iX.isSuccess()) {
                com.baidu.swan.games.q.a.b bVar = new com.baidu.swan.games.q.a.b();
                bVar.errMsg = com.baidu.swan.games.q.a.a.iZ("getStorage");
                bVar.data = iX.getData();
                com.baidu.swan.games.utils.a.a(h(jsObject), true, bVar);
                return;
            }
            a(jsObject, "getStorage", iX);
        }
    }

    public void setStorage(JsObject jsObject) {
        String a = a(jsObject, "setStorage");
        if (a != null) {
            a(jsObject, "setStorage", a(a, j(jsObject)));
        }
    }

    public void removeStorage(JsObject jsObject) {
        String a = a(jsObject, "removeStorage");
        if (a != null) {
            a(jsObject, "removeStorage", iY(a));
        }
    }

    public void clearStorage(JsObject jsObject) {
        a(jsObject, "clearStorage", Pa());
    }

    public void getStorageInfo(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c h = h(jsObject);
        com.baidu.swan.games.q.a.c storageInfoSync = getStorageInfoSync();
        storageInfoSync.errMsg = com.baidu.swan.games.q.a.a.iZ("getStorageInfo");
        com.baidu.swan.games.utils.a.a(h, true, storageInfoSync);
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c h(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c b = com.baidu.swan.games.binding.model.c.b(jsObject);
        return b == null ? new com.baidu.swan.games.binding.model.c() : b;
    }

    private String a(JsObject jsObject, String str) {
        d i = i(jsObject);
        if (i.isSuccess()) {
            return (String) i.getData();
        }
        a(jsObject, str, i);
        return null;
    }

    private d i(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("key".equals(jsObject.getPropertyName(i))) {
                int propertyType = jsObject.getPropertyType(i);
                if (propertyType == 7) {
                    return d.Q(jsObject.toString(i));
                }
                return d.ja(String.format("parameter error: the key must be string instead of %s.", d.eH(propertyType)));
            }
        }
        return d.ja("parameter error: the parameter key is necessary.");
    }

    private JsSerializeValue j(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("data".equals(jsObject.getPropertyName(i))) {
                return jsObject.toSerializeValue(i);
            }
        }
        return null;
    }

    private void a(JsObject jsObject, String str, d dVar) {
        com.baidu.swan.games.binding.model.c h = h(jsObject);
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        boolean isSuccess = dVar.isSuccess();
        bVar.errMsg = dVar.ik(str);
        com.baidu.swan.games.utils.a.a(h, isSuccess, bVar);
    }
}
