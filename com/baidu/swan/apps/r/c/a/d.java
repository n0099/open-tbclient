package com.baidu.swan.apps.r.c.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.c.c> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String QG() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.c.c cVar) {
        int i = command.arg1;
        int T = af.T(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + T + ", " + i2 + ", " + i3, true);
        cVar.k(i, T, i2, i3);
    }
}
