package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface b {
    public static final boolean cRA = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes7.dex */
    public interface a {
        String ate();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0437b {
        final Map<String, a> cRB = new HashMap();
        boolean mIsValid = true;
        int cRC = 0;
        int cRD = this.cRC;
    }
}
