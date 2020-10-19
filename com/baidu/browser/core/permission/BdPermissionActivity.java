package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes10.dex */
public class BdPermissionActivity extends Activity {
    private int afc;
    private String[] afd;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tt();
    }

    private void tt() {
        Intent intent = getIntent();
        this.afc = intent.getIntExtra("request_code", 0);
        this.afd = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tu();
    }

    private void tu() {
        if (this.afd != null && this.afd.length != 0) {
            boolean z = false;
            for (String str : this.afd) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.afd, this.afc);
            } else if (b.f(this, this.afc)) {
                com.baidu.m.a.a.requestPermissions(this, this.afd, this.afc);
            } else {
                onRequestPermissionsResult(this.afc, this.afd, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0224a bn = a.tv().bn(this.afc);
        if (bn != null) {
            bn.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
