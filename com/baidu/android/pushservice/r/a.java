package com.baidu.android.pushservice.r;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.baidu.android.pushservice.r.b
    public int a() {
        return 0;
    }

    @Override // com.baidu.android.pushservice.r.b
    public void a(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i);
        try {
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception unused) {
        }
    }
}
