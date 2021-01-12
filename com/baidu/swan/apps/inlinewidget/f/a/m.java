package com.baidu.swan.apps.inlinewidget.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class m extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avy() {
        return "setDataSource";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        if (command.obj != null) {
            ArrayList arrayList = (ArrayList) command.obj;
            command.ret = aVar.e((String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), command.arg1 != 0) ? 1 : 0;
            a(aVar, command.what, "DataSource: " + ((String) arrayList.get(0)) + " ;UserAgent: " + ((String) arrayList.get(1)) + " ;Cookies: " + ((String) arrayList.get(2)), false);
        }
    }
}
