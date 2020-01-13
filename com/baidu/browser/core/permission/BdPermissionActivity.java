package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.k.a.a;
/* loaded from: classes10.dex */
public class BdPermissionActivity extends Activity {
    private int Io;
    private String[] Ip;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mk();
    }

    private void mk() {
        Intent intent = getIntent();
        this.Io = intent.getIntExtra("request_code", 0);
        this.Ip = intent.getStringArrayExtra("permissions");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ml();
    }

    private void ml() {
        if (this.Ip != null && this.Ip.length != 0) {
            boolean z = false;
            for (String str : this.Ip) {
                z = z || com.baidu.k.a.a.shouldShowRequestPermissionRationale(this, str);
            }
            if (z) {
                com.baidu.k.a.a.requestPermissions(this, this.Ip, this.Io);
            } else if (b.h(this, this.Io)) {
                com.baidu.k.a.a.requestPermissions(this, this.Ip, this.Io);
            } else {
                onRequestPermissionsResult(this.Io, this.Ip, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.InterfaceC0072a aG = a.mm().aG(this.Io);
        if (aG != null) {
            aG.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
