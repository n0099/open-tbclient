package com.baidu.swan.apps.runtime;

import android.content.ContextWrapper;
import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public abstract class f extends ContextWrapper {
    public f(e eVar) {
        super(eVar);
    }

    @NonNull
    public e aao() {
        return (e) getBaseContext();
    }

    public void onDestroy() {
    }
}
