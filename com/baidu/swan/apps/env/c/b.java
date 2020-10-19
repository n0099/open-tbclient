package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface b {
    public static final boolean cEV = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public interface a {
        String apr();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0413b {
        final Map<String, a> cEW = new HashMap();
        boolean mIsValid = true;
        int cEX = 0;
        int cEY = this.cEX;
    }
}
