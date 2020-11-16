package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends b {
    @Nullable
    private ContentValues cRH;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cRH = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String od(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.I(str, "cuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS())));
        sb.append(com.baidu.swan.apps.event.a.I(str, "mtjCuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS())));
        if (this.cRH != null) {
            for (String str2 : this.cRH.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cRH.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.I(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
