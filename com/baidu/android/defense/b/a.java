package com.baidu.android.defense.b;

import android.content.Context;
import android.content.pm.IPackageInstallObserver;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class a extends IPackageInstallObserver.Stub {

    /* renamed from: a  reason: collision with root package name */
    private Context f235a;
    private String b;

    public a(Context context, String str) {
        this.f235a = context;
        this.b = str;
    }

    public void a(String str, int i) {
        if (i == 1) {
        }
        if (e.a(this.f235a).a()) {
            e.a(this.f235a).b(this.f235a, this.b);
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
