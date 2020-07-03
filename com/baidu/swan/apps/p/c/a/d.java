package com.baidu.swan.apps.p.c.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ag;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.c.c> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String afq() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.c.c cVar) {
        int i = command.arg1;
        int D = ag.D(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + D + ", " + i2 + ", " + i3, true);
        cVar.j(i, D, i2, i3);
    }
}
