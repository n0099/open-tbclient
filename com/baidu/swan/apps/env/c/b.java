package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface b {
    public static final boolean ddo = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes9.dex */
    public interface a {
        String axE();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0441b {
        final Map<String, a> ddp = new HashMap();
        boolean mIsValid = true;
        int ddq = 0;
        int ddr = this.ddq;
    }
}
