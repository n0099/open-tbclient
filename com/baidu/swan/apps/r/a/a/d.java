package com.baidu.swan.apps.r.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.af;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.a.c> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String abj() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.a.c cVar) {
        int i = command.arg1;
        int C = af.C(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + C + ", " + i2 + ", " + i3, true);
        cVar.j(i, C, i2, i3);
    }
}
