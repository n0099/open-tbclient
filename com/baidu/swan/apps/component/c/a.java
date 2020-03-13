package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes11.dex */
public class a {
    private c bjz;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.bjz = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c KW() {
        return this.bjz;
    }

    public void onDestroy() {
        this.bjz.onDestroy();
    }

    public void bQ(@NonNull Context context) {
        this.mContext = context;
    }
}
