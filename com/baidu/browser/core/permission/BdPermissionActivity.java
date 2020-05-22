package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.h.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int acm;
    private String[] acn;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ri();
    }

    private void ri() {
        Intent intent = getIntent();
        this.acm = intent.getIntExtra("request_code", 0);
        this.acn = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        rj();
    }

    private void rj() {
        if (this.acn != null && this.acn.length != 0) {
            boolean z = false;
            for (String str : this.acn) {
                z = z || com.baidu.h.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.h.a.a.requestPermissions(this, this.acn, this.acm);
            } else if (b.f(this, this.acm)) {
                com.baidu.h.a.a.requestPermissions(this, this.acn, this.acm);
            } else {
                onRequestPermissionsResult(this.acm, this.acn, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0125a aW = a.rk().aW(this.acm);
        if (aW != null) {
            aW.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
