package com.baidu.swan.apps.component.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes8.dex */
public class a {
    private c cKp;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cKp = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c akX() {
        return this.cKp;
    }

    public void onDestroy() {
        this.cKp.onDestroy();
    }

    public void cE(@NonNull Context context) {
        this.mContext = context;
    }
}
