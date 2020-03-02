package com.baidu.swan.apps.r.c.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.c.c> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String Ts() {
        return "hideConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.c.c cVar) {
        a(cVar, command.what, null, true);
        cVar.TD();
    }
}
