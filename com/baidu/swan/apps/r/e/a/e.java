package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String Tv() {
        return "goBackground";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        aVar.TJ();
        a(aVar, command.what, null, true);
    }
}
