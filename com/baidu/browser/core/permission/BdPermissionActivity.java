package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.k.a.a;
/* loaded from: classes9.dex */
public class BdPermissionActivity extends Activity {
    private int Ij;
    private String[] Ik;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mk();
    }

    private void mk() {
        Intent intent = getIntent();
        this.Ij = intent.getIntExtra("request_code", 0);
        this.Ik = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ml();
    }

    private void ml() {
        if (this.Ik != null && this.Ik.length != 0) {
            boolean z = false;
            for (String str : this.Ik) {
                z = z || com.baidu.k.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.k.a.a.requestPermissions(this, this.Ik, this.Ij);
            } else if (b.h(this, this.Ij)) {
                com.baidu.k.a.a.requestPermissions(this, this.Ik, this.Ij);
            } else {
                onRequestPermissionsResult(this.Ij, this.Ik, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0072a aG = a.mm().aG(this.Ij);
        if (aG != null) {
            aG.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
