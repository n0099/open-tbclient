package com.baidu.swan.apps.res.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
/* loaded from: classes2.dex */
public class c extends Dialog {
    private boolean aKD;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.aKD = com.baidu.swan.apps.res.widget.a.bhi;
    }

    public void cp(boolean z) {
        this.aKD = com.baidu.swan.apps.res.widget.a.bhi && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.aKD) {
            com.baidu.swan.apps.res.widget.a.b(this);
        }
        boolean c = com.baidu.swan.apps.res.widget.a.c(this);
        if (c) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (c) {
            getWindow().clearFlags(8);
        }
    }
}
