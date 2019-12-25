package com.baidu.swan.apps.component.c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes9.dex */
public class a {
    private c beu;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.beu = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c Ij() {
        return this.beu;
    }

    public void onDestroy() {
        this.beu.onDestroy();
    }

    public void bM(@NonNull Context context) {
        this.mContext = context;
    }
}
