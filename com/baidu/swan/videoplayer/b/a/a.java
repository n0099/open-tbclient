package com.baidu.swan.videoplayer.b.a;

import com.baidu.swan.apps.adaptation.a.x;
import com.baidu.swan.videoplayer.b.a.a.b;
import com.baidu.swan.videoplayer.b.a.a.c;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes11.dex */
public class a implements x {
    @Override // com.baidu.swan.apps.adaptation.a.x
    public com.baidu.swan.apps.p.e.b.a a(ZeusPluginFactory.Invoker invoker, String str) {
        return new c(invoker, str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.x
    public com.baidu.swan.apps.p.e.b.a b(ZeusPluginFactory.Invoker invoker, String str) {
        return new b(invoker, str);
    }
}
