package com.baidu.swan.apps.component.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.c;
/* loaded from: classes9.dex */
public class a {
    private c cMD;
    private Context mContext;

    public a(@NonNull Context context, @NonNull com.baidu.swan.apps.view.b.a aVar) {
        this.mContext = context;
        this.cMD = new c(aVar);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public c alv() {
        return this.cMD;
    }

    public void onDestroy() {
        this.cMD.onDestroy();
    }

    public void cD(@NonNull Context context) {
        this.mContext = context;
    }
}
