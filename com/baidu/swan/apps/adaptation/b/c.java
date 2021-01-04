package com.baidu.swan.apps.adaptation.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.a.ao;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes9.dex */
public interface c<T extends d> extends ao, e<T> {
    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean ami();

    PullToRefreshBaseWebView amj();

    f amk();

    boolean aml();

    void amm();

    @Nullable
    com.baidu.swan.apps.component.c.a amn();

    boolean amo();

    com.baidu.swan.apps.adaptation.b.a.d amp();

    String amq();

    void b(ViewGroup viewGroup, View view);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void hI(int i);

    boolean hJ(int i);

    void kQ(String str);

    void kR(String str);
}
