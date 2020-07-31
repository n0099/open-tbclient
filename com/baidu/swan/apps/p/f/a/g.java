package com.baidu.swan.apps.p.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.f.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "isPlaying";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.f.b.a aVar) {
        command.ret = aVar.isPlaying() ? 1 : 0;
        a(aVar, command.what, "isPlaying: " + aVar.isPlaying(), false);
    }
}
