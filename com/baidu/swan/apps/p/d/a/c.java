package com.baidu.swan.apps.p.d.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.d.c> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "pageScrollBack";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.d.c cVar) {
        a(cVar, command.what, null, true);
        cVar.agH();
    }
}
