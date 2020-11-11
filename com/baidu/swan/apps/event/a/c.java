package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes10.dex */
public class c extends b {
    @Nullable
    private ContentValues cTr;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cTr = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String ok(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.I(str, "cuid", com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA())));
        sb.append(com.baidu.swan.apps.event.a.I(str, "mtjCuid", com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA())));
        if (this.cTr != null) {
            for (String str2 : this.cTr.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cTr.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.I(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
