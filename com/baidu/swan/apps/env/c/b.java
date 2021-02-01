package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface b {
    public static final boolean daL = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public interface a {
        String auj();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0421b {
        final Map<String, a> daM = new HashMap();
        boolean mIsValid = true;
        int daN = 0;
        int daO = this.daN;
    }
}
