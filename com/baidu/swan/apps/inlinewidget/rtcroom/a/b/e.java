package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avA() {
        return "enableLocalMirror";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        a(bVar, command.what, "" + command.obj, true);
        if (command.obj instanceof String) {
            String str = (String) command.obj;
            if (TextUtils.equals("auto", str)) {
                bVar.oH(str);
            } else if (TextUtils.equals(com.baidu.fsg.face.base.b.c.l, str)) {
                bVar.oH(str);
            } else if (TextUtils.equals("disable", str)) {
                bVar.oH(str);
            }
        }
    }
}
