package com.baidu.swan.apps.adaptation.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes8.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean aiQ();

    PullToRefreshBaseWebView aiR();

    f aiS();

    boolean aiT();

    void aiU();

    @Nullable
    com.baidu.swan.apps.component.c.a aiV();

    boolean aiW();

    com.baidu.swan.apps.adaptation.b.a.d aiX();

    String aiY();

    void b(ViewGroup viewGroup, View view);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void gf(int i);

    boolean gg(int i);

    void ke(String str);

    void kf(String str);
}
