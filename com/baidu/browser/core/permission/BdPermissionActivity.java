package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.m.a.a;
/* loaded from: classes19.dex */
public class BdPermissionActivity extends Activity {
    private int aet;
    private String[] aeu;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        tn();
    }

    private void tn() {
        Intent intent = getIntent();
        this.aet = intent.getIntExtra("request_code", 0);
        this.aeu = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        tp();
    }

    private void tp() {
        if (this.aeu != null && this.aeu.length != 0) {
            boolean z = false;
            for (String str : this.aeu) {
                z = z || com.baidu.m.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.m.a.a.requestPermissions(this, this.aeu, this.aet);
            } else if (b.f(this, this.aet)) {
                com.baidu.m.a.a.requestPermissions(this, this.aeu, this.aet);
            } else {
                onRequestPermissionsResult(this.aet, this.aeu, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0210a bj = a.tq().bj(this.aet);
        if (bj != null) {
            bj.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
