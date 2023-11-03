package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.tieba.u21;
import com.baidu.tieba.x21;
import com.baidu.tieba.y21;
/* loaded from: classes3.dex */
public class NadPermissionActivity extends BaseActivity {
    public int u;
    public String[] v;

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void D1() {
        super.D1();
        N1();
    }

    public final void L1() {
        Intent intent = getIntent();
        this.u = intent.getIntExtra("request_code", 0);
        this.v = intent.getStringArrayExtra("permissions");
    }

    public final void N1() {
        String[] strArr = this.v;
        if (strArr != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !u21.d(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                u21.b(this, this.v, this.u);
            } else if (y21.a(this, this.u)) {
                u21.b(this, this.v, this.u);
            } else {
                onRequestPermissionsResult(this.u, this.v, new int[0]);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        u21.b c = x21.b().c(this.u);
        if (c != null) {
            c.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void u1(Bundle bundle) {
        super.u1(bundle);
        L1();
    }
}
