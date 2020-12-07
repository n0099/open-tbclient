package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes25.dex */
public class c extends b {
    @Nullable
    private ContentValues cYA;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cYA = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String oM(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.L(str, "cuid", com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza())));
        sb.append(com.baidu.swan.apps.event.a.L(str, "mtjCuid", com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza())));
        if (this.cYA != null) {
            for (String str2 : this.cYA.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cYA.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.L(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
