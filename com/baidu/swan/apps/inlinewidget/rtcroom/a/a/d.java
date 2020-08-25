package com.baidu.swan.apps.inlinewidget.rtcroom.a.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String anJ() {
        return "onItemRelease";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        a(aVar, command.what, null, true);
        aVar.onRelease();
    }
}
