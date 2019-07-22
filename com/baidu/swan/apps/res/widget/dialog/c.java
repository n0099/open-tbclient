package com.baidu.swan.apps.res.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
/* loaded from: classes2.dex */
public class c extends Dialog {
    private boolean aqP;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.aqP = com.baidu.swan.apps.res.widget.a.aNC;
    }

    public void bY(boolean z) {
        this.aqP = com.baidu.swan.apps.res.widget.a.aNC && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.aqP) {
            com.baidu.swan.apps.res.widget.a.a(this);
        }
        boolean b = com.baidu.swan.apps.res.widget.a.b(this);
        if (b) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (b) {
            getWindow().clearFlags(8);
        }
    }
}
