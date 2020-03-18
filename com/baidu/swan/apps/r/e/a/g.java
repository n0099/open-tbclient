package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String Tv() {
        return "isPlaying";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        command.ret = aVar.isPlaying() ? 1 : 0;
        a(aVar, command.what, "isPlaying: " + aVar.isPlaying(), false);
    }
}
