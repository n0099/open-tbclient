package com.baidu.android.pushservice.ach.e;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public class b implements c {
    @Override // com.baidu.android.pushservice.ach.e.c
    public void a(Service service, Intent intent, int i, boolean z) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15987, this, service, intent, Integer.valueOf(i), Boolean.valueOf(z));
    }

    @Override // com.baidu.android.pushservice.ach.e.c
    public void a(Context context) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15950, this, context);
    }

    @Override // com.baidu.android.pushservice.ach.e.c
    public boolean b(Context context) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15949, this, context);
    }
}
