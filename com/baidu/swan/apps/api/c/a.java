package com.baidu.swan.apps.api.c;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public interface a {
    @NonNull
    public static final a can = new b(202, "params parsed as JSONObject is null");

    boolean isSuccess();

    @NonNull
    String toJsonString();
}
