package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.tieba.a51;
import com.baidu.tieba.w41;
import com.baidu.tieba.z41;
/* loaded from: classes2.dex */
public class NadPermissionActivity extends BaseActivity {
    public int u;
    public String[] v;

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        requestPermissions();
    }

    public final void X1() {
        Intent intent = getIntent();
        this.u = intent.getIntExtra("request_code", 0);
        this.v = intent.getStringArrayExtra("permissions");
    }

    private void requestPermissions() {
        String[] strArr = this.v;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !w41.b(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                w41.requestPermissions(this, this.v, this.u);
            } else if (a51.a(this, this.u)) {
                w41.requestPermissions(this, this.v, this.u);
            } else {
                onRequestPermissionsResult(this.u, this.v, new int[0]);
            }
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void B1(Bundle bundle) {
        super.B1(bundle);
        X1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        w41.b c = z41.b().c(this.u);
        if (c != null) {
            c.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
