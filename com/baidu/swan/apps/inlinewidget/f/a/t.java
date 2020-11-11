package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class t extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avA() {
        return "updateVideoRect";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        aVar.l(command.arg1, command.arg2, command.arg3, command.arg4);
        a(aVar, command.what, "Rect: (" + command.arg1 + ", " + command.arg2 + ", " + command.arg3 + ", " + command.arg4 + ")", false);
    }
}
