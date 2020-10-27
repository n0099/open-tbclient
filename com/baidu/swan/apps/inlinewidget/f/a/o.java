package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class o extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String ata() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (command.obj != null) {
            aVar.setSurface((Surface) command.obj);
            a(aVar, command.what, "Surface:" + command.obj.hashCode(), false);
        }
    }
}
