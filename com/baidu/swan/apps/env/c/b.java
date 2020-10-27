package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface b {
    public static final boolean cNr = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public interface a {
        String arl();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0427b {
        final Map<String, a> cNs = new HashMap();
        boolean mIsValid = true;
        int cNt = 0;
        int cNu = this.cNt;
    }
}
