package com.baidu.swan.pms.node;

import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b implements e {
    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONArray a(@Nullable c<JSONArray> cVar) {
        return (JSONArray) a(bdw(), cVar);
    }

    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONObject b(@Nullable c<JSONObject> cVar) {
        return (JSONObject) a(bdx(), cVar);
    }

    @Nullable
    protected JSONArray bdw() {
        return null;
    }

    @Nullable
    protected JSONObject bdx() {
        return null;
    }

    private static <T> T a(@Nullable T t, @Nullable c<T> cVar) {
        if (t != null && cVar != null) {
            cVar.W(t);
        }
        return t;
    }
}
