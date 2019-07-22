package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public abstract class c extends ContextWrapper {
    public c(b bVar) {
        super(bVar);
    }

    @NonNull
    public b Mu() {
        return (b) getBaseContext();
    }

    public void onDestroy() {
    }
}
