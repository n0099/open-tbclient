package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
/* loaded from: classes2.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private TextView aLm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aLm = (TextView) findViewById(b.f.dialog_message);
        this.aLm.setGravity(17);
    }

    public static BaseActivityDialog.a MG() {
        return new BaseActivityDialog.a(SwanAppErrorDialog.class);
    }
}
