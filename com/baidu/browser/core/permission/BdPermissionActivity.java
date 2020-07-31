package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.i.a.a;
/* loaded from: classes10.dex */
public class BdPermissionActivity extends Activity {
    private int acM;
    private String[] acN;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rB();
    }

    private void rB() {
        Intent intent = getIntent();
        this.acM = intent.getIntExtra("request_code", 0);
        this.acN = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        rC();
    }

    private void rC() {
        if (this.acN != null && this.acN.length != 0) {
            boolean z = false;
            for (String str : this.acN) {
                z = z || com.baidu.i.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.i.a.a.requestPermissions(this, this.acN, this.acM);
            } else if (b.f(this, this.acM)) {
                com.baidu.i.a.a.requestPermissions(this, this.acN, this.acM);
            } else {
                onRequestPermissionsResult(this.acM, this.acN, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0153a be = a.rD().be(this.acM);
        if (be != null) {
            be.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
