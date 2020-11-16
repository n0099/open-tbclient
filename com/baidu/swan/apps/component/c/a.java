package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes7.dex */
public class a {
    private c cDl;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cDl = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c akx() {
        return this.cDl;
    }

    public void onDestroy() {
        this.cDl.onDestroy();
    }

    public void bR(@NonNull Context context) {
        this.mContext = context;
    }
}
