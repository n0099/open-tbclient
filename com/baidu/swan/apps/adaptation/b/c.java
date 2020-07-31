package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.ak;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes7.dex */
public interface c<T extends d> extends ak, e<T> {
    boolean UG();

    PullToRefreshBaseWebView UH();

    f UI();

    boolean UJ();

    void UK();

    @Nullable
    com.baidu.swan.apps.component.c.a UL();

    boolean UM();

    com.baidu.swan.apps.adaptation.b.a.d UN();

    String UO();

    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.turbo.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void ev(int i);

    boolean ew(int i);

    void hn(String str);

    void ho(String str);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);
}
