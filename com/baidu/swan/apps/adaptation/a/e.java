package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public interface e {

    /* loaded from: classes11.dex */
    public interface a {
        void dk(boolean z);

        void m(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean bb(Context context);

    String bc(Context context);

    String bd(@NonNull Context context);

    String be(@NonNull Context context);
}
