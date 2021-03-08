package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.l.a.a;
/* loaded from: classes14.dex */
public class BdPermissionActivity extends Activity {
    private int agY;
    private String[] agZ;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sG();
    }

    private void sG() {
        Intent intent = getIntent();
        this.agY = intent.getIntExtra("request_code", 0);
        this.agZ = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        sH();
    }

    private void sH() {
        if (this.agZ != null && this.agZ.length != 0) {
            boolean z = false;
            for (String str : this.agZ) {
                z = z || com.baidu.l.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.l.a.a.requestPermissions(this, this.agZ, this.agY);
            } else if (b.f(this, this.agY)) {
                com.baidu.l.a.a.requestPermissions(this, this.agZ, this.agY);
            } else {
                onRequestPermissionsResult(this.agY, this.agZ, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0154a bq = a.sI().bq(this.agY);
        if (bq != null) {
            bq.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
