package com.baidu.swan.apps.p.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class t extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.f.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "updateVideoRect";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.f.b.a aVar) {
        aVar.l(command.arg1, command.arg2, command.arg3, command.arg4);
        a(aVar, command.what, "Rect: (" + command.arg1 + ", " + command.arg2 + ", " + command.arg3 + ", " + command.arg4 + ")", false);
    }
}
