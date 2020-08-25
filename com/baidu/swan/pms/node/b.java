package com.baidu.swan.pms.node;

import android.support.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class b implements e {
    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONArray a(@Nullable c<JSONArray> cVar) {
        return (JSONArray) a(aUv(), cVar);
    }

    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONObject b(@Nullable c<JSONObject> cVar) {
        return (JSONObject) a(aUw(), cVar);
    }

    @Nullable
    protected JSONArray aUv() {
        return null;
    }

    @Nullable
    protected JSONObject aUw() {
        return null;
    }

    private static <T> T a(@Nullable T t, @Nullable c<T> cVar) {
        if (t != null && cVar != null) {
            cVar.S(t);
        }
        return t;
    }
}
