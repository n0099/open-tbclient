package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import d.b.g0.a.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public static final boolean DEBUG = k.f45443a;
    public static final String TAG = "SwanAppErrorDialog";
    public TextView mMessage;

    public static BaseActivityDialog.c newBuilder() {
        return new BaseActivityDialog.c(SwanAppErrorDialog.class);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        TextView textView = (TextView) findViewById(f.dialog_message);
        this.mMessage = textView;
        textView.setGravity(17);
    }
}
