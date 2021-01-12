package com.baidu.swan.apps.res.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
/* loaded from: classes8.dex */
public class c extends Dialog {
    private boolean cPA;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.cPA = com.baidu.swan.apps.res.widget.a.dyP;
    }

    public void gL(boolean z) {
        this.cPA = com.baidu.swan.apps.res.widget.a.dyP && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.cPA) {
            com.baidu.swan.apps.res.widget.a.e(this);
        }
        boolean f = com.baidu.swan.apps.res.widget.a.f(this);
        if (f) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (f) {
            getWindow().clearFlags(8);
        }
    }
}
