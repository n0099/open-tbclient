package com.baidu.swan.pms.node;

import android.support.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public abstract class b implements e {
    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONArray a(@Nullable c<JSONArray> cVar) {
        return (JSONArray) a(bcj(), cVar);
    }

    @Override // com.baidu.swan.pms.node.e
    @Nullable
    public JSONObject b(@Nullable c<JSONObject> cVar) {
        return (JSONObject) a(bck(), cVar);
    }

    @Nullable
    protected JSONArray bcj() {
        return null;
    }

    @Nullable
    protected JSONObject bck() {
        return null;
    }

    private static <T> T a(@Nullable T t, @Nullable c<T> cVar) {
        if (t != null && cVar != null) {
            cVar.W(t);
        }
        return t;
    }
}
