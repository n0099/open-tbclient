package com.baidu.swan.apps.runtime;

import android.content.ContextWrapper;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public abstract class f extends ContextWrapper {
    public f(e eVar) {
        super(eVar);
    }

    @NonNull
    public e adb() {
        return (e) getBaseContext();
    }

    public void onDestroy() {
    }
}
