package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface b {
    public static final boolean cTk = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public interface a {
        String atM();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0439b {
        final Map<String, a> cTl = new HashMap();
        boolean mIsValid = true;
        int cTm = 0;
        int cTn = this.cTm;
    }
}
