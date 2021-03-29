package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.permissionhelper.app.ActivityCompat;
import d.b.h.a.j.a;
import d.b.h.a.j.b;
/* loaded from: classes.dex */
public class BdPermissionActivity extends Activity {
    public String[] mPermissions;
    public int mReqCode;

    private void getRequest() {
        Intent intent = getIntent();
        this.mReqCode = intent.getIntExtra("request_code", 0);
        this.mPermissions = intent.getStringArrayExtra("permissions");
    }

    private void requestPermissions() {
        String[] strArr = this.mPermissions;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        boolean z = false;
        for (String str : strArr) {
            z = z || ActivityCompat.shouldShowRequestPermissionRationale(this, str);
        }
        if (z) {
            ActivityCompat.requestPermissions(this, this.mPermissions, this.mReqCode);
        } else if (b.c(this, this.mReqCode)) {
            ActivityCompat.requestPermissions(this, this.mPermissions, this.mReqCode);
        } else {
            onRequestPermissionsResult(this.mReqCode, this.mPermissions, new int[0]);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getRequest();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        ActivityCompat.OnRequestPermissionsResultCallback c2 = a.b().c(this.mReqCode);
        if (c2 != null) {
            c2.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        requestPermissions();
    }
}
