package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes10.dex */
public class a {
    private c bfj;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.bfj = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c IF() {
        return this.bfj;
    }

    public void onDestroy() {
        this.bfj.onDestroy();
    }

    public void bM(@NonNull Context context) {
        this.mContext = context;
    }
}
