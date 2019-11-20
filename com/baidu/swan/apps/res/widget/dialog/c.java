package com.baidu.swan.apps.res.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
/* loaded from: classes2.dex */
public class c extends Dialog {
    private boolean aKl;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.aKl = com.baidu.swan.apps.res.widget.a.bgQ;
    }

    public void cp(boolean z) {
        this.aKl = com.baidu.swan.apps.res.widget.a.bgQ && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.aKl) {
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
