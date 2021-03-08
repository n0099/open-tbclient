package com.baidu.swan.apps.event.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b extends a {
    protected final Map<String, String> mParams;

    public b(@NonNull String str) {
        this(str, null);
    }

    public b(@NonNull String str, @Nullable Map<String, String> map) {
        this.mParams = new HashMap();
        this.cJT = str;
        if (map != null) {
            this.mParams.putAll(map);
        }
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nR(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.event.a.O(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
