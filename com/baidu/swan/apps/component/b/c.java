package com.baidu.swan.apps.component.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class c {
    public String msg;
    public int statusCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i, @NonNull String str) {
        this.statusCode = i;
        this.msg = str;
    }

    public boolean isSuccess() {
        return this.statusCode == 0;
    }
}
