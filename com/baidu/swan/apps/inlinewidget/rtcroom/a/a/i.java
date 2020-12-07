package com.baidu.swan.apps.inlinewidget.rtcroom.a.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes25.dex */
public class i extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
        return "onZoom";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        a(aVar, command.what, "" + command.obj, true);
        if (command.obj instanceof Integer) {
            aVar.je(((Integer) command.obj).intValue());
        }
    }
}
