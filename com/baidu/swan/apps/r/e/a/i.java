package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class i extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String Ts() {
        return "setRate";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        float floatValue;
        if (command.obj != null) {
            if (command.obj instanceof Float) {
                floatValue = ((Float) command.obj).floatValue();
            } else {
                floatValue = command.obj instanceof Double ? ((Double) command.obj).floatValue() : Float.MIN_VALUE;
            }
            if (floatValue != Float.MIN_VALUE) {
                aVar.setSpeed(floatValue);
                a(aVar, command.what, "playbackRate: " + command.obj, true);
            }
        }
    }
}
