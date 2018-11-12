package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.e.a.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class BdPermissionActivity extends Activity {
    private int Ve;
    private String[] Vf;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qk();
    }

    private void qk() {
        Intent intent = getIntent();
        this.Ve = intent.getIntExtra(IntentConfig.REQUEST_CODE, 0);
        this.Vf = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ql();
    }

    private void ql() {
        if (this.Vf != null && this.Vf.length != 0) {
            boolean z = false;
            for (String str : this.Vf) {
                z = z || com.baidu.e.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.e.a.a.requestPermissions(this, this.Vf, this.Ve);
            } else if (b.i(this, this.Ve)) {
                com.baidu.e.a.a.requestPermissions(this, this.Vf, this.Ve);
            } else {
                onRequestPermissionsResult(this.Ve, this.Vf, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0073a bC = a.qm().bC(this.Ve);
        if (bC != null) {
            bC.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
