package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.af;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes10.dex */
public interface c<T extends d> extends af, e<T> {
    boolean Gq();

    PullToRefreshBaseWebView Gr();

    f Gs();

    boolean Gt();

    void Gu();

    @Nullable
    com.baidu.swan.apps.component.c.a Gv();

    boolean Gw();

    com.baidu.swan.apps.adaptation.b.a.d Gx();

    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.k.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void dF(int i);

    boolean dG(int i);

    void eM(String str);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);
}
