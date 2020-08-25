package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes8.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean aaJ();

    PullToRefreshBaseWebView aaK();

    f aaL();

    boolean aaM();

    void aaN();

    @Nullable
    com.baidu.swan.apps.component.c.a aaO();

    boolean aaP();

    com.baidu.swan.apps.adaptation.b.a.d aaQ();

    String aaR();

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void gt(int i);

    boolean gu(int i);

    void iI(String str);

    void iJ(String str);
}
