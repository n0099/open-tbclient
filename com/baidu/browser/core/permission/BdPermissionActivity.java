package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.e.a.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class BdPermissionActivity extends Activity {
    private int Vn;
    private String[] Vo;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qn();
    }

    private void qn() {
        Intent intent = getIntent();
        this.Vn = intent.getIntExtra(IntentConfig.REQUEST_CODE, 0);
        this.Vo = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        qo();
    }

    private void qo() {
        if (this.Vo != null && this.Vo.length != 0) {
            boolean z = false;
            for (String str : this.Vo) {
                z = z || com.baidu.e.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.e.a.a.requestPermissions(this, this.Vo, this.Vn);
            } else if (b.i(this, this.Vn)) {
                com.baidu.e.a.a.requestPermissions(this, this.Vo, this.Vn);
            } else {
                onRequestPermissionsResult(this.Vn, this.Vo, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0073a bC = a.qp().bC(this.Vn);
        if (bC != null) {
            bC.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
