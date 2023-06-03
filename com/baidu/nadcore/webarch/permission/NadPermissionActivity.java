package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.tieba.c71;
import com.baidu.tieba.d71;
import com.baidu.tieba.z61;
/* loaded from: classes3.dex */
public class NadPermissionActivity extends BaseActivity {
    public int u;
    public String[] v;

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void I1() {
        super.I1();
        requestPermissions();
    }

    public final void N1() {
        Intent intent = getIntent();
        this.u = intent.getIntExtra("request_code", 0);
        this.v = intent.getStringArrayExtra("permissions");
    }

    private void requestPermissions() {
        String[] strArr = this.v;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !z61.b(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                z61.requestPermissions(this, this.v, this.u);
            } else if (d71.a(this, this.u)) {
                z61.requestPermissions(this, this.v, this.u);
            } else {
                onRequestPermissionsResult(this.u, this.v, new int[0]);
            }
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void A1(Bundle bundle) {
        super.A1(bundle);
        N1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        z61.b c = c71.b().c(this.u);
        if (c != null) {
            c.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
