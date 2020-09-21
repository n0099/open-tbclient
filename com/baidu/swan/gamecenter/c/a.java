package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String name;

    public abstract com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar);

    public a(String str) {
        this.name = str;
    }
}
