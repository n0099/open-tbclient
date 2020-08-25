package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface b {
    public static final boolean cqD = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public interface a {
        String alV();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0401b {
        final Map<String, a> cqE = new HashMap();
        boolean mIsValid = true;
        int cqF = 0;
        int cqG = this.cqF;
    }
}
