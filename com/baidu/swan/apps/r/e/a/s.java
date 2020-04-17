package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class s extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String abk() {
        return "updateVideoRect";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        aVar.l(command.arg1, command.arg2, command.arg3, command.arg4);
        a(aVar, command.what, "Rect: (" + command.arg1 + ", " + command.arg2 + ", " + command.arg3 + ", " + command.arg4 + ")", false);
    }
}
