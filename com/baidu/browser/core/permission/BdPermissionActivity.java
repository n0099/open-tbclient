package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes19.dex */
public class BdPermissionActivity extends Activity {
    private int aer;
    private String[] aes;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tn();
    }

    private void tn() {
        Intent intent = getIntent();
        this.aer = intent.getIntExtra("request_code", 0);
        this.aes = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tp();
    }

    private void tp() {
        if (this.aes != null && this.aes.length != 0) {
            boolean z = false;
            for (String str : this.aes) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.aes, this.aer);
            } else if (b.f(this, this.aer)) {
                com.baidu.m.a.a.requestPermissions(this, this.aes, this.aer);
            } else {
                onRequestPermissionsResult(this.aer, this.aes, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0210a bj = a.tq().bj(this.aer);
        if (bj != null) {
            bj.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
