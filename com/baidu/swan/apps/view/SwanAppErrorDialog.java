package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
/* loaded from: classes11.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private TextView mMessage;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
        this.mMessage = (TextView) findViewById(a.f.dialog_message);
        this.mMessage.setGravity(17);
    }

    public static BaseActivityDialog.a aup() {
        return new BaseActivityDialog.a(SwanAppErrorDialog.class);
    }
}
