package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String Rc() {
        return "getVideoHeight";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        command.ret = aVar.getVideoHeight();
        a(aVar, command.what, "Height: " + command.ret, false);
    }
}
