package com.baidu.swan.apps.inlinewidget.a.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.a.c> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String ata() {
        return "pageScrollBack";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.a.c cVar) {
        a(cVar, command.what, null, false);
        cVar.atg();
    }
}
