package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.do1;
import com.baidu.tieba.nl3;
/* loaded from: classes3.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public TextView r;

    static {
        boolean z = do1.a;
    }

    public static BaseActivityDialog.e r() {
        return new BaseActivityDialog.e(SwanAppErrorDialog.class);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = nl3.c0(this);
        super.onCreate(bundle);
        nl3.g(this, c0);
        TextView textView = (TextView) findViewById(R.id.dialog_message);
        this.r = textView;
        textView.setGravity(17);
    }
}
