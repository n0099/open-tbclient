package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes25.dex */
public class a {
    private c cKg;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cKg = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c anF() {
        return this.cKg;
    }

    public void onDestroy() {
        this.cKg.onDestroy();
    }

    public void cx(@NonNull Context context) {
        this.mContext = context;
    }
}
