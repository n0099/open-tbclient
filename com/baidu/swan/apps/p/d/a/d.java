package com.baidu.swan.apps.p.d.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ai;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class d extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.d.c> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "pageScrollUp";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.d.c cVar) {
        int i = command.arg1;
        int D = ai.D(command.arg2);
        int i2 = command.arg3;
        int i3 = command.arg4;
        a(cVar, command.what, "(top, inputHeight, keyboardHeight, cursorSpacing) " + i + ", " + D + ", " + i2 + ", " + i3, true);
        cVar.j(i, D, i2, i3);
    }
}
