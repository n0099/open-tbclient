package com.baidu.swan.apps.p.b.a;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.b.a> {
    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "release";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.b.a aVar) {
        aVar.release();
    }
}
