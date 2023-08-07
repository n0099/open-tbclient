package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.tieba.h71;
import com.baidu.tieba.k71;
import com.baidu.tieba.l71;
/* loaded from: classes3.dex */
public class NadPermissionActivity extends BaseActivity {
    public int u;
    public String[] v;

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void G1() {
        super.G1();
        requestPermissions();
    }

    public final void M1() {
        Intent intent = getIntent();
        this.u = intent.getIntExtra("request_code", 0);
        this.v = intent.getStringArrayExtra("permissions");
    }

    private void requestPermissions() {
        String[] strArr = this.v;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !h71.b(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                h71.requestPermissions(this, this.v, this.u);
            } else if (l71.a(this, this.u)) {
                h71.requestPermissions(this, this.v, this.u);
            } else {
                onRequestPermissionsResult(this.u, this.v, new int[0]);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        h71.b c = k71.b().c(this.u);
        if (c != null) {
            c.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void z1(Bundle bundle) {
        super.z1(bundle);
        M1();
    }
}
