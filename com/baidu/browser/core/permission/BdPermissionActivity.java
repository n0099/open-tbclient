package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.f.a.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class BdPermissionActivity extends Activity {
    private int Vc;
    private String[] Vd;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qm();
    }

    private void qm() {
        Intent intent = getIntent();
        this.Vc = intent.getIntExtra(IntentConfig.REQUEST_CODE, 0);
        this.Vd = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        qn();
    }

    private void qn() {
        if (this.Vd != null && this.Vd.length != 0) {
            boolean z = false;
            for (String str : this.Vd) {
                z = z || com.baidu.f.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.f.a.a.requestPermissions(this, this.Vd, this.Vc);
            } else if (b.i(this, this.Vc)) {
                com.baidu.f.a.a.requestPermissions(this, this.Vd, this.Vc);
            } else {
                onRequestPermissionsResult(this.Vc, this.Vd, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0073a bn = a.qo().bn(this.Vc);
        if (bn != null) {
            bn.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
