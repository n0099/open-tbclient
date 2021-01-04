package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.n.a.a;
/* loaded from: classes4.dex */
public class BdPermissionActivity extends Activity {
    private int agE;
    private String[] agF;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sU();
    }

    private void sU() {
        Intent intent = getIntent();
        this.agE = intent.getIntExtra("request_code", 0);
        this.agF = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        sV();
    }

    private void sV() {
        if (this.agF != null && this.agF.length != 0) {
            boolean z = false;
            for (String str : this.agF) {
                z = z || com.baidu.n.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.n.a.a.requestPermissions(this, this.agF, this.agE);
            } else if (b.f(this, this.agE)) {
                com.baidu.n.a.a.requestPermissions(this, this.agF, this.agE);
            } else {
                onRequestPermissionsResult(this.agE, this.agF, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0277a br = a.sW().br(this.agE);
        if (br != null) {
            br.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
