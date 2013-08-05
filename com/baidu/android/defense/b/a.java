package com.baidu.android.defense.b;

import android.content.Context;
import android.content.pm.IPackageInstallObserver;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class a extends IPackageInstallObserver.Stub {

    /* renamed from: a  reason: collision with root package name */
    private Context f499a;
    private String b;

    public a(Context context, String str) {
        this.f499a = context;
        this.b = str;
    }

    public void a(String str, int i) {
        if (i == 1) {
        }
        if (e.a(this.f499a).a()) {
            e.a(this.f499a).b(this.f499a, this.b);
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
