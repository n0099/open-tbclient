package com.baidu.swan.apps.event.a;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
/* loaded from: classes11.dex */
public class c extends b {
    @Nullable
    private ContentValues chy;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.chy = contentValues;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String kl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.swan.apps.event.a.y(str, "cuid", com.baidu.swan.apps.u.a.agc().bd(com.baidu.swan.apps.u.a.afX())));
        sb.append(com.baidu.swan.apps.event.a.y(str, "mtjCuid", com.baidu.swan.apps.u.a.agc().bd(com.baidu.swan.apps.u.a.afX())));
        if (this.chy != null) {
            for (String str2 : this.chy.keySet()) {
                sb.append(com.baidu.swan.apps.event.a.c(str, str2, this.chy.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
                sb.append(com.baidu.swan.apps.event.a.y(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }
}
