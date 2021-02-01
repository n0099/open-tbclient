package com.baidu.swan.pms.c;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface f {

    /* loaded from: classes3.dex */
    public interface a {
        void U(String str, int i);

        void b(String str, String str2, JSONObject jSONObject);

        void onFail(Exception exc);
    }

    void a(String str, Map<String, String> map, Map<String, String> map2, a aVar);

    void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, a aVar);
}
