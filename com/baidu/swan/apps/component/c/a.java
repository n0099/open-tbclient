package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes7.dex */
public class a {
    private c bWw;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.bWw = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c Xk() {
        return this.bWw;
    }

    public void onDestroy() {
        this.bWw.onDestroy();
    }

    public void bF(@NonNull Context context) {
        this.mContext = context;
    }
}
