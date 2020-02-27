package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.k.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int IK;
    private String[] IL;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mz();
    }

    private void mz() {
        Intent intent = getIntent();
        this.IK = intent.getIntExtra("request_code", 0);
        this.IL = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mA();
    }

    private void mA() {
        if (this.IL != null && this.IL.length != 0) {
            boolean z = false;
            for (String str : this.IL) {
                z = z || com.baidu.k.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.k.a.a.requestPermissions(this, this.IL, this.IK);
            } else if (b.h(this, this.IK)) {
                com.baidu.k.a.a.requestPermissions(this, this.IL, this.IK);
            } else {
                onRequestPermissionsResult(this.IK, this.IL, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0078a aJ = a.mB().aJ(this.IK);
        if (aJ != null) {
            aJ.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
