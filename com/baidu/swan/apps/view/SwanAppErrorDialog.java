package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.ek3;
import com.baidu.tieba.vm1;
/* loaded from: classes4.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public TextView r;

    static {
        boolean z = vm1.a;
    }

    public static BaseActivityDialog.e r() {
        return new BaseActivityDialog.e(SwanAppErrorDialog.class);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        ek3.g(this, c0);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090905);
        this.r = textView;
        textView.setGravity(17);
    }
}
