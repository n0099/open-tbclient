package com.baidu.swan.apps.p.a.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.a.c> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "showsoftkeyboard";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.a.c cVar) {
        int i = command.arg1;
        a(cVar, command.what, "Type:" + i, true);
        cVar.fp(i);
    }
}
