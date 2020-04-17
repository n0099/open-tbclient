package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.h.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int abR;
    private String[] abS;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rb();
    }

    private void rb() {
        Intent intent = getIntent();
        this.abR = intent.getIntExtra("request_code", 0);
        this.abS = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        rc();
    }

    private void rc() {
        if (this.abS != null && this.abS.length != 0) {
            boolean z = false;
            for (String str : this.abS) {
                z = z || com.baidu.h.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.h.a.a.requestPermissions(this, this.abS, this.abR);
            } else if (b.f(this, this.abR)) {
                com.baidu.h.a.a.requestPermissions(this, this.abS, this.abR);
            } else {
                onRequestPermissionsResult(this.abR, this.abS, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0100a aV = a.rd().aV(this.abR);
        if (aV != null) {
            aV.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
