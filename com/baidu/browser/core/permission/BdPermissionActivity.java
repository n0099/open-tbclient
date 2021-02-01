package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.l.a.a;
/* loaded from: classes6.dex */
public class BdPermissionActivity extends Activity {
    private int afF;
    private String[] afG;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sG();
    }

    private void sG() {
        Intent intent = getIntent();
        this.afF = intent.getIntExtra("request_code", 0);
        this.afG = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        sH();
    }

    private void sH() {
        if (this.afG != null && this.afG.length != 0) {
            boolean z = false;
            for (String str : this.afG) {
                z = z || com.baidu.l.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.l.a.a.requestPermissions(this, this.afG, this.afF);
            } else if (b.f(this, this.afF)) {
                com.baidu.l.a.a.requestPermissions(this, this.afG, this.afF);
            } else {
                onRequestPermissionsResult(this.afF, this.afG, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0148a bp = a.sI().bp(this.afF);
        if (bp != null) {
            bp.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
