package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes8.dex */
public class a {
    private c cce;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cce = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c adq() {
        return this.cce;
    }

    public void onDestroy() {
        this.cce.onDestroy();
    }

    public void bM(@NonNull Context context) {
        this.mContext = context;
    }
}
