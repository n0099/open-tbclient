package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public interface e {

    /* loaded from: classes9.dex */
    public interface a {
        void eN(boolean z);

        void n(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean cb(Context context);

    String cc(Context context);

    String cd(@NonNull Context context);

    String ce(@NonNull Context context);
}
