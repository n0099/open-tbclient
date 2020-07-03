package com.baidu.swan.apps.p.e.a;

import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class o extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String afq() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        if (command.obj != null) {
            aVar.setSurface((Surface) command.obj);
            a(aVar, command.what, "Surface:" + command.obj.hashCode(), true);
        }
    }
}
