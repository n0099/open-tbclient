package com.baidu.swan.apps.env.b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface b {
    public static final boolean cjq = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes7.dex */
    public interface a {
        String aeP();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0356b {
        final Map<String, a> cjr = new HashMap();
        boolean mIsValid = true;
        int cjs = 0;
        int cjt = this.cjs;
    }
}
