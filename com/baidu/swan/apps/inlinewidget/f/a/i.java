package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class i extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String ata() {
        return "setRate";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        float floatValue;
        if (command.obj != null) {
            if (command.obj instanceof Float) {
                floatValue = ((Float) command.obj).floatValue();
            } else {
                floatValue = command.obj instanceof Double ? ((Double) command.obj).floatValue() : Float.MIN_VALUE;
            }
            if (floatValue != Float.MIN_VALUE) {
                aVar.setSpeed(floatValue);
                a(aVar, command.what, "playbackRate: " + command.obj, false);
            }
        }
    }
}
