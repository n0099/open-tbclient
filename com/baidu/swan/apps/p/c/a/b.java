package com.baidu.swan.apps.p.c.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.c.c> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "release";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.c.c cVar) {
        a(cVar, command.what, null, true);
        cVar.release();
    }
}
