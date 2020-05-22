package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public interface e {

    /* loaded from: classes11.dex */
    public interface a {
        void df(boolean z);

        void m(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean ba(Context context);

    String bb(Context context);

    String bc(@NonNull Context context);

    String bd(@NonNull Context context);
}
