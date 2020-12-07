package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes25.dex */
public class k extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static String dbY = "release";

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
        return dbY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        aVar.release();
        a(aVar, command.what, null, false);
    }
}
