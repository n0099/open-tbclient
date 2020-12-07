package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public interface b {
    public static final boolean cYt = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes25.dex */
    public interface a {
        String awm();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0449b {
        final Map<String, a> cYu = new HashMap();
        boolean mIsValid = true;
        int cYv = 0;
        int cYw = this.cYv;
    }
}
