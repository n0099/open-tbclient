package com.baidu.swan.apps.p.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class l extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "seekTo";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        aVar.seekTo(command.arg1);
        a(aVar, command.what, "SeekTo: " + command.arg1, true);
    }
}
