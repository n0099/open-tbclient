package com.baidu.swan.apps.component.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes8.dex */
public class a {
    private c cOd;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cOd = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c aly() {
        return this.cOd;
    }

    public void onDestroy() {
        this.cOd.onDestroy();
    }

    public void cC(@NonNull Context context) {
        this.mContext = context;
    }
}
