package com.baidu.swan.apps.r.e.a;

import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
public class o extends com.baidu.swan.apps.r.a<com.baidu.swan.apps.r.e.b.a> {
    @Override // com.baidu.swan.apps.r.a
    @NonNull
    public String abj() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.r.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        if (command.obj != null) {
            aVar.setSurface((Surface) command.obj);
            a(aVar, command.what, "Surface:" + command.obj.hashCode(), true);
        }
    }
}
