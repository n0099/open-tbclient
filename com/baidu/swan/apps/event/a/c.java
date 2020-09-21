package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends b {
    @Nullable
    private ContentValues csR;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.csR = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String mQ(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.A(str, "cuid", com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu())));
        sb.append(com.baidu.swan.apps.event.a.A(str, "mtjCuid", com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu())));
        if (this.csR != null) {
            for (String str2 : this.csR.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.csR.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.A(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
