package com.baidu.swan.apps.u.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public interface c {

    /* loaded from: classes2.dex */
    public interface a {
        void bp(boolean z);

        void j(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void a(String str, a aVar);

    boolean bd(Context context);

    String be(Context context);

    String bf(@NonNull Context context);

    String bg(@NonNull Context context);
}
