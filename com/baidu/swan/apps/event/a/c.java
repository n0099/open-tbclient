package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes11.dex */
public class c extends b {
    @Nullable
    private ContentValues ccK;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.ccK = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String kd(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.x(str, "cuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR())));
        sb.append(com.baidu.swan.apps.event.a.x(str, "mtjCuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR())));
        if (this.ccK != null) {
            for (String str2 : this.ccK.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.ccK.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.x(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
