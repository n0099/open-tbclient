package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public interface e {

    /* loaded from: classes11.dex */
    public interface a {
        void bV(boolean z);

        void j(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    boolean bp(Context context);

    String bq(Context context);

    String br(@NonNull Context context);

    String bs(@NonNull Context context);
}
