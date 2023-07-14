package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.fs1;
import com.baidu.tieba.pp3;
/* loaded from: classes4.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public TextView r;

    static {
        boolean z = fs1.a;
    }

    public static BaseActivityDialog.e r() {
        return new BaseActivityDialog.e(SwanAppErrorDialog.class);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = pp3.c0(this);
        super.onCreate(bundle);
        pp3.g(this, c0);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0908aa);
        this.r = textView;
        textView.setGravity(17);
    }
}
