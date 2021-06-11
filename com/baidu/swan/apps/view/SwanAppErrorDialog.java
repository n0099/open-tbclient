package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import d.a.l0.a.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public static final boolean DEBUG = k.f46875a;
    public static final String TAG = "SwanAppErrorDialog";
    public TextView mMessage;

    public static BaseActivityDialog.e newBuilder() {
        return new BaseActivityDialog.e(SwanAppErrorDialog.class);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        TextView textView = (TextView) findViewById(f.dialog_message);
        this.mMessage = textView;
        textView.setGravity(17);
    }
}
