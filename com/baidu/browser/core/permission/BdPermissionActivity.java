package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.h.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int acR;
    private String[] acS;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rz();
    }

    private void rz() {
        Intent intent = getIntent();
        this.acR = intent.getIntExtra("request_code", 0);
        this.acS = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        rA();
    }

    private void rA() {
        if (this.acS != null && this.acS.length != 0) {
            boolean z = false;
            for (String str : this.acS) {
                z = z || com.baidu.h.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.h.a.a.requestPermissions(this, this.acS, this.acR);
            } else if (b.f(this, this.acR)) {
                com.baidu.h.a.a.requestPermissions(this, this.acS, this.acR);
            } else {
                onRequestPermissionsResult(this.acR, this.acS, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0127a bc = a.rB().bc(this.acR);
        if (bc != null) {
            bc.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
