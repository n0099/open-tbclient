package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes10.dex */
public class BdPermissionActivity extends Activity {
    private int aeL;
    private String[] aeM;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tt();
    }

    private void tt() {
        Intent intent = getIntent();
        this.aeL = intent.getIntExtra("request_code", 0);
        this.aeM = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tu();
    }

    private void tu() {
        if (this.aeM != null && this.aeM.length != 0) {
            boolean z = false;
            for (String str : this.aeM) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.aeM, this.aeL);
            } else if (b.f(this, this.aeL)) {
                com.baidu.m.a.a.requestPermissions(this, this.aeM, this.aeL);
            } else {
                onRequestPermissionsResult(this.aeL, this.aeM, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0209a bn = a.tv().bn(this.aeL);
        if (bn != null) {
            bn.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
