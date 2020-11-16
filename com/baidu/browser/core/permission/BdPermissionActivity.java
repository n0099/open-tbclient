package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int afi;
    private String[] afj;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tt();
    }

    private void tt() {
        Intent intent = getIntent();
        this.afi = intent.getIntExtra("request_code", 0);
        this.afj = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tu();
    }

    private void tu() {
        if (this.afj != null && this.afj.length != 0) {
            boolean z = false;
            for (String str : this.afj) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.afj, this.afi);
            } else if (b.f(this, this.afi)) {
                com.baidu.m.a.a.requestPermissions(this, this.afj, this.afi);
            } else {
                onRequestPermissionsResult(this.afi, this.afj, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0248a bn = a.tv().bn(this.afi);
        if (bn != null) {
            bn.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
