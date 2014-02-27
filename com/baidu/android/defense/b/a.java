package com.baidu.android.defense.b;

import android.content.Context;
import android.content.pm.IPackageInstallObserver;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class a extends IPackageInstallObserver.Stub {
    private Context a;
    private String b;

    public a(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // android.content.pm.IPackageInstallObserver
    public void packageInstalled(String str, int i) {
        if (e.a(this.a).a()) {
            e.a(this.a).b(this.a, this.b);
        }
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        try {
            File file = new File(this.b);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }
}
