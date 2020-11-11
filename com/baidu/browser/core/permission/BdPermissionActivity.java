package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes10.dex */
public class BdPermissionActivity extends Activity {
    private int afd;
    private String[] afe;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tt();
    }

    private void tt() {
        Intent intent = getIntent();
        this.afd = intent.getIntExtra("request_code", 0);
        this.afe = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tu();
    }

    private void tu() {
        if (this.afe != null && this.afe.length != 0) {
            boolean z = false;
            for (String str : this.afe) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.afe, this.afd);
            } else if (b.f(this, this.afd)) {
                com.baidu.m.a.a.requestPermissions(this, this.afe, this.afd);
            } else {
                onRequestPermissionsResult(this.afd, this.afe, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0250a bn = a.tv().bn(this.afd);
        if (bn != null) {
            bn.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
