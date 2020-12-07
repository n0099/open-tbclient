package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes25.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean akY();

    PullToRefreshBaseWebView akZ();

    f ala();

    boolean alb();

    void alc();

    @Nullable
    com.baidu.swan.apps.component.c.a ald();

    boolean ale();

    com.baidu.swan.apps.adaptation.b.a.d alf();

    String alg();

    void b(ViewGroup viewGroup, View view);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void hO(int i);

    boolean hP(int i);

    void kX(String str);

    void kY(String str);
}
