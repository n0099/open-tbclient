package com.baidu.swan.apps.inlinewidget.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
public class p extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String azr() {
        return "setUseFreeFlow";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        aVar.fP(command.arg1 == 1);
        a(aVar, command.what, null, false);
    }
}
