package com.baidu.android.pushservice.f;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.baidu.android.pushservice.f.b
    public int a() {
        return 0;
    }

    @Override // com.baidu.android.pushservice.f.b
    public void a(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString(DealIntentService.KEY_CLASS, componentName.getClassName());
        bundle.putInt("badgenumber", i);
        try {
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception unused) {
        }
    }
}
