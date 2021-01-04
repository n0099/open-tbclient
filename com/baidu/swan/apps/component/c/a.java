package com.baidu.swan.apps.component.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes9.dex */
public class a {
    private c cPb;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cPb = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c aoQ() {
        return this.cPb;
    }

    public void onDestroy() {
        this.cPb.onDestroy();
    }

    public void cF(@NonNull Context context) {
        this.mContext = context;
    }
}
