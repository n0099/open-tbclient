package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends b {
    @Nullable
    private ContentValues ddw;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.ddw = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String oF(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.O(str, "cuid", com.baidu.swan.apps.t.a.aAw().cd(com.baidu.swan.apps.t.a.aAr())));
        sb.append(com.baidu.swan.apps.event.a.O(str, "mtjCuid", com.baidu.swan.apps.t.a.aAw().cd(com.baidu.swan.apps.t.a.aAr())));
        if (this.ddw != null) {
            for (String str2 : this.ddw.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.ddw.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.O(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
