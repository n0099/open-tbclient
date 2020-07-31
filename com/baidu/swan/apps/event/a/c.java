package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends b {
    @Nullable
    private ContentValues cjx;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.cjx = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String kH(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.y(str, "cuid", com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj())));
        sb.append(com.baidu.swan.apps.event.a.y(str, "mtjCuid", com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj())));
        if (this.cjx != null) {
            for (String str2 : this.cjx.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.d(str, str2, this.cjx.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.y(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
