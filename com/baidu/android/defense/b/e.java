package com.baidu.android.defense.b;

import android.content.Context;
import android.content.pm.IPackageInstallObserver;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class e extends IPackageInstallObserver.Stub {

    /* renamed from: a  reason: collision with root package name */
    private Context f632a;
    private String b;

    public e(Context context, String str) {
        this.f632a = context;
        this.b = str;
    }

    public void a(String str, int i) {
        if (i == 1) {
        }
        if (b.a(this.f632a).a()) {
            b.a(this.f632a).b(this.f632a, this.b);
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
