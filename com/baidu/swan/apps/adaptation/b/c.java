package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ai;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes11.dex */
public interface c<T extends d> extends ai, e<T> {
    boolean Uf();

    PullToRefreshBaseWebView Ug();

    f Uh();

    boolean Ui();

    void Uj();

    @Nullable
    com.baidu.swan.apps.component.c.a Uk();

    boolean Ul();

    com.baidu.swan.apps.adaptation.b.a.d Um();

    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void et(int i);

    boolean eu(int i);

    void hh(String str);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);
}
