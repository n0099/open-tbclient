package com.baidu.swan.apps.inlinewidget.d.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class e extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.d.c> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avZ() {
        return "showConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.d.c cVar) {
        int i = command.arg1;
        a(cVar, command.what, "(keyboardHeight)" + i, false);
        cVar.hG(i);
    }
}
