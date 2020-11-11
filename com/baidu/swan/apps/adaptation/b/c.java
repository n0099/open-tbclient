package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes10.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    f aiA();

    boolean aiB();

    void aiC();

    @Nullable
    com.baidu.swan.apps.component.c.a aiD();

    boolean aiE();

    com.baidu.swan.apps.adaptation.b.a.d aiF();

    String aiG();

    boolean aiy();

    PullToRefreshBaseWebView aiz();

    void b(ViewGroup viewGroup, View view);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void hu(int i);

    boolean hv(int i);

    void kw(String str);

    void kx(String str);
}
