package com.baidu.swan.apps.env.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {
    public static final boolean csK = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes3.dex */
    public interface a {
        String amF();

        boolean isValid();

        JSONObject toJSONObject();
    }

    /* renamed from: com.baidu.swan.apps.env.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0396b {
        final Map<String, a> csL = new HashMap();
        boolean mIsValid = true;
        int csM = 0;
        int csN = this.csM;
    }
}
