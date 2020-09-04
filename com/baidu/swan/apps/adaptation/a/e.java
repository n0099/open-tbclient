package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public interface e {

    /* loaded from: classes8.dex */
    public interface a {
        void dw(boolean z);

        void m(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean bj(Context context);

    String bk(Context context);

    String bl(@NonNull Context context);

    String bm(@NonNull Context context);
}
