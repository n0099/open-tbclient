package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes10.dex */
public class c extends b {
    @Nullable
    private ContentValues cNy;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cNy = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String nV(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.I(str, "cuid", com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua())));
        sb.append(com.baidu.swan.apps.event.a.I(str, "mtjCuid", com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua())));
        if (this.cNy != null) {
            for (String str2 : this.cNy.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cNy.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.I(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
