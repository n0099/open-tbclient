package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.n.a.a;
/* loaded from: classes11.dex */
public class BdPermissionActivity extends Activity {
    private int agd;
    private String[] agf;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tw();
    }

    private void tw() {
        Intent intent = getIntent();
        this.agd = intent.getIntExtra("request_code", 0);
        this.agf = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tx();
    }

    private void tx() {
        if (this.agf != null && this.agf.length != 0) {
            boolean z = false;
            for (String str : this.agf) {
                z = z || com.baidu.n.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.n.a.a.requestPermissions(this, this.agf, this.agd);
            } else if (b.f(this, this.agd)) {
                com.baidu.n.a.a.requestPermissions(this, this.agf, this.agd);
            } else {
                onRequestPermissionsResult(this.agd, this.agf, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0276a br = a.ty().br(this.agd);
        if (br != null) {
            br.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
