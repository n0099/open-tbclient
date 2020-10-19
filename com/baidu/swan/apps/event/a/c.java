package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes10.dex */
public class c extends b {
    @Nullable
    private ContentValues cFc;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cFc = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String nC(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.B(str, "cuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf())));
        sb.append(com.baidu.swan.apps.event.a.B(str, "mtjCuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf())));
        if (this.cFc != null) {
            for (String str2 : this.cFc.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.cFc.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.B(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
