package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String anJ() {
        return "getCurrentPosition";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        command.ret = aVar.getCurrentPosition();
        a(aVar, command.what, "Position: " + command.ret, false);
    }
}
