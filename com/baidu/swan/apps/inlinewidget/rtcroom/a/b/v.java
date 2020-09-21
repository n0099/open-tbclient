package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class v extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aot() {
        return "setCheekThin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        a(bVar, command.what, "" + command.obj, true);
        if (command.obj instanceof Integer) {
            bVar.hW(((Integer) command.obj).intValue());
        }
    }
}
