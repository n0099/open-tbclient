package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
/* loaded from: classes2.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView bhg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bhg = (TextView) findViewById(a.f.dialog_message);
        this.bhg.setGravity(17);
    }

    public static BaseActivityDialog.a UV() {
        return new BaseActivityDialog.a(SwanAppErrorDialog.class);
    }
}
