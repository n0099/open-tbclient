package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public interface e {

    /* loaded from: classes3.dex */
    public interface a {
        void du(boolean z);

        void m(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean bi(Context context);

    String bj(Context context);

    String bk(@NonNull Context context);

    String bl(@NonNull Context context);
}
