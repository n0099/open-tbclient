package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class z extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String anJ() {
        return "setSoundModel";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        a(bVar, command.what, "" + command.obj, true);
        if (command.obj instanceof String) {
            String str = (String) command.obj;
            if (TextUtils.equals(str, "ear")) {
                bVar.mR(str);
            } else if (TextUtils.equals(str, "speaker")) {
                bVar.mR(str);
            }
        }
    }
}
