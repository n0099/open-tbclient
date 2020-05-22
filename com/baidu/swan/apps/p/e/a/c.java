package com.baidu.swan.apps.p.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "getVideoHeight";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        command.ret = aVar.getVideoHeight();
        a(aVar, command.what, "Height: " + command.ret, false);
    }
}
