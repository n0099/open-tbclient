package com.baidu.swan.apps.p.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class j extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.f.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "prepareAsync";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.f.b.a aVar) {
        command.ret = aVar.prepareAsync() ? 1 : 0;
        a(aVar, command.what, "isSupport: " + command.ret, true);
    }

    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command) {
        command.ret = 1;
    }
}
