package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends b {
    @Nullable
    private ContentValues daS;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.daS = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String nK(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.O(str, "cuid", com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW())));
        sb.append(com.baidu.swan.apps.event.a.O(str, "mtjCuid", com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW())));
        if (this.daS != null) {
            for (String str2 : this.daS.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.daS.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.O(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
