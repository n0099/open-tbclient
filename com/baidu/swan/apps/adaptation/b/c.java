package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes3.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    String abA();

    boolean abs();

    PullToRefreshBaseWebView abt();

    f abu();

    boolean abv();

    void abw();

    @Nullable
    com.baidu.swan.apps.component.c.a abx();

    boolean aby();

    com.baidu.swan.apps.adaptation.b.a.d abz();

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void gC(int i);

    boolean gD(int i);

    void jc(String str);

    void jd(String str);
}
