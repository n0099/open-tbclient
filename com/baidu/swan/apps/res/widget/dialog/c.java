package com.baidu.swan.apps.res.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
/* loaded from: classes11.dex */
public class c extends Dialog {
    private boolean mImmersionEnabled;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.mImmersionEnabled = com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION;
    }

    public void setEnableImmersion(boolean z) {
        this.mImmersionEnabled = com.baidu.swan.apps.res.widget.a.SUPPORT_IMMERSION && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.mImmersionEnabled) {
            com.baidu.swan.apps.res.widget.a.setDialogImmersion(this);
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
