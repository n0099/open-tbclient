package com.baidu.swan.videoplayer.b.a;

import com.baidu.swan.apps.adaptation.a.aa;
import com.baidu.swan.videoplayer.b.a.a.b;
import com.baidu.swan.videoplayer.b.a.a.c;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes9.dex */
public class a implements aa {
    @Override // com.baidu.swan.apps.adaptation.a.aa
    public com.baidu.swan.apps.inlinewidget.f.c.a a(ZeusPluginFactory.Invoker invoker, String str) {
        return new c(invoker, str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.aa
    public com.baidu.swan.apps.inlinewidget.f.c.a b(ZeusPluginFactory.Invoker invoker, String str) {
        return new b(invoker, str);
    }

    @Override // com.baidu.swan.apps.adaptation.a.aa
    public com.baidu.swan.apps.inlinewidget.rtcroom.c.b c(ZeusPluginFactory.Invoker invoker, String str) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aa
    public com.baidu.swan.apps.inlinewidget.rtcroom.c.a d(ZeusPluginFactory.Invoker invoker, String str) {
        return null;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aa
    public com.baidu.swan.apps.inlinewidget.b.a e(ZeusPluginFactory.Invoker invoker, String str) {
        return new com.baidu.swan.videoplayer.widget.a(invoker, str);
    }
}
