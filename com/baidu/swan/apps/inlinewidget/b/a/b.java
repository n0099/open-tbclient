package com.baidu.swan.apps.inlinewidget.b.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.b.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
        return "release";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.b.a aVar) {
        aVar.release();
    }
}
