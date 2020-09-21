package com.baidu.swan.apps.inlinewidget.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ah;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.a.c> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aot() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.a.c cVar) {
        int i = command.arg1;
        int H = ah.H(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + H + ", " + i2 + ", " + i3, false);
        cVar.j(i, H, i2, i3);
    }
}
