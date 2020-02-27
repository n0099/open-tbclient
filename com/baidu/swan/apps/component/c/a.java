package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes11.dex */
public class a {
    private c bjx;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.bjx = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c KU() {
        return this.bjx;
    }

    public void onDestroy() {
        this.bjx.onDestroy();
    }

    public void bQ(@NonNull Context context) {
        this.mContext = context;
    }
}
