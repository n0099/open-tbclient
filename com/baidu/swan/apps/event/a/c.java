package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes8.dex */
public class c extends b {
    @Nullable
    private ContentValues cYG;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cYG = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String ns(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.N(str, "cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy())));
        sb.append(com.baidu.swan.apps.event.a.N(str, "mtjCuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy())));
        if (this.cYG != null) {
            for (String str2 : this.cYG.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cYG.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.N(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
