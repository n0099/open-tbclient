package com.baidu.swan.apps.n.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b extends a {
    protected final Map<String, String> mParams;

    public b(@NonNull String str) {
        this(str, null);
    }

    public b(@NonNull String str, @Nullable Map<String, String> map) {
        this.mParams = new HashMap();
        this.buG = str;
        if (map != null) {
            this.mParams.putAll(map);
        }
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hI(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(com.baidu.swan.apps.n.a.s(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
