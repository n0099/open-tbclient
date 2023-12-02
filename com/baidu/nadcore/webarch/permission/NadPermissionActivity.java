package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.tieba.a31;
import com.baidu.tieba.b31;
import com.baidu.tieba.x21;
/* loaded from: classes3.dex */
public class NadPermissionActivity extends BaseActivity {
    public int u;
    public String[] v;

    public final void G1() {
        Intent intent = getIntent();
        this.u = intent.getIntExtra("request_code", 0);
        this.v = intent.getStringArrayExtra("permissions");
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1() {
        super.z1();
        H1();
    }

    public final void H1() {
        String[] strArr = this.v;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !x21.d(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                x21.b(this, this.v, this.u);
            } else if (b31.a(this, this.u)) {
                x21.b(this, this.v, this.u);
            } else {
                onRequestPermissionsResult(this.u, this.v, new int[0]);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        x21.b c = a31.b().c(this.u);
        if (c != null) {
            c.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void t1(Bundle bundle) {
        super.t1(bundle);
        G1();
    }
}
