package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes11.dex */
public class a {
    private c bHU;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.bHU = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c SN() {
        return this.bHU;
    }

    public void onDestroy() {
        this.bHU.onDestroy();
    }

    public void bD(@NonNull Context context) {
        this.mContext = context;
    }
}
