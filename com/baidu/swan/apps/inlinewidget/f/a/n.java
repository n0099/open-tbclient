package com.baidu.swan.apps.inlinewidget.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class n extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avZ() {
        return "setMuted";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (command.obj instanceof Boolean) {
            aVar.setMuted(((Boolean) command.obj).booleanValue());
            a(aVar, command.what, "setMuted:" + command.obj, false);
        }
    }
}
