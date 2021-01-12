package com.baidu.swan.apps.inlinewidget.d.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.d.c> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avy() {
        return "hideConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.d.c cVar) {
        a(cVar, command.what, null, false);
        cVar.avT();
    }
}
