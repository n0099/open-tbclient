package com.baidu.swan.apps.inlinewidget.d.a;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ah;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.d.c> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avZ() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.d.c cVar) {
        int i = command.arg1;
        int T = ah.T(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + T + ", " + i2 + ", " + i3, false);
        cVar.m(i, T, i2, i3);
    }
}
