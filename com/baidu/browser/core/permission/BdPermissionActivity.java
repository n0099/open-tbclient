package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.l.a.a;
/* loaded from: classes4.dex */
public class BdPermissionActivity extends Activity {
    private int afM;
    private String[] afN;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sJ();
    }

    private void sJ() {
        Intent intent = getIntent();
        this.afM = intent.getIntExtra("request_code", 0);
        this.afN = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        sK();
    }

    private void sK() {
        if (this.afN != null && this.afN.length != 0) {
            boolean z = false;
            for (String str : this.afN) {
                z = z || com.baidu.l.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.l.a.a.requestPermissions(this, this.afN, this.afM);
            } else if (b.f(this, this.afM)) {
                com.baidu.l.a.a.requestPermissions(this, this.afN, this.afM);
            } else {
                onRequestPermissionsResult(this.afM, this.afN, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0148a bp = a.sL().bp(this.afM);
        if (bp != null) {
            bp.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
