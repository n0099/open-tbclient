package com.baidu.swan.apps.adaptation.b;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.a.af;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
/* loaded from: classes11.dex */
public interface c<T extends d> extends af, e<T> {
    boolean IK();

    PullToRefreshBaseWebView IL();

    f IM();

    boolean IN();

    void IO();

    @Nullable
    com.baidu.swan.apps.component.c.a IP();

    boolean IQ();

    com.baidu.swan.apps.adaptation.b.a.d IR();

    void a(ViewGroup viewGroup, View view);

    void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar);

    void a(com.baidu.swan.apps.core.f.d dVar);

    void a(com.baidu.swan.apps.core.f.e eVar);

    void a(com.baidu.swan.apps.core.k.b bVar);

    boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar);

    boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar);

    void dV(int i);

    boolean dW(int i);

    void fa(String str);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);
}
