package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.h.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int abU;
    private String[] abV;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rb();
    }

    private void rb() {
        Intent intent = getIntent();
        this.abU = intent.getIntExtra("request_code", 0);
        this.abV = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        rc();
    }

    private void rc() {
        if (this.abV != null && this.abV.length != 0) {
            boolean z = false;
            for (String str : this.abV) {
                z = z || com.baidu.h.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.h.a.a.requestPermissions(this, this.abV, this.abU);
            } else if (b.f(this, this.abU)) {
                com.baidu.h.a.a.requestPermissions(this, this.abV, this.abU);
            } else {
                onRequestPermissionsResult(this.abU, this.abV, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0121a aV = a.rd().aV(this.abU);
        if (aV != null) {
            aV.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
