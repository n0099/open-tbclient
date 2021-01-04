package com.baidu.swan.apps.inlinewidget.rtcroom.a.a;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
public class f extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String azr() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        a(aVar, command.what, "" + command.obj, true);
        if (command.obj instanceof Surface) {
            aVar.setSurface((Surface) command.obj);
        }
    }
}
