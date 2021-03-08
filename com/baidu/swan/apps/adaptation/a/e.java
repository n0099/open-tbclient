package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface e {

    /* loaded from: classes8.dex */
    public interface a {
        void eL(boolean z);

        void n(Exception exc);
    }

    void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(com.baidu.swan.apps.a.c cVar);

    void b(com.baidu.swan.apps.a.a aVar);

    boolean bY(Context context);

    String bZ(Context context);

    String ca(@NonNull Context context);

    String cb(@NonNull Context context);
}
