package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public interface e {

    /* loaded from: classes9.dex */
    public interface a {
        void bI(boolean z);

        void j(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    boolean bl(Context context);

    String bm(Context context);

    String bn(@NonNull Context context);

    String bo(@NonNull Context context);
}
