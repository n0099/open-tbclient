package com.baidu.sapi2.b;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.d;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
/* loaded from: classes.dex */
public final class a {
    private static SapiConfiguration a;
    private static d b;
    private static final a c = new a();

    static {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        a = sapiConfiguration;
        b = d.a(sapiConfiguration.context);
    }

    public static a a() {
        return c;
    }

    private a() {
    }

    public final void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            throw new IllegalArgumentException("Account can't be null");
        }
        if (TextUtils.isEmpty(sapiAccount.app)) {
            sapiAccount.app = com.baidu.sapi2.utils.d.a(a.context);
        }
        if (a.loginShareStrategy == LoginShareStrategy.SILENT) {
            c();
        }
        b.a(sapiAccount);
        b.b(sapiAccount);
        b.c(sapiAccount);
        if (a.loginShareStrategy == LoginShareStrategy.DISABLED) {
            c();
        }
    }

    public final void b() {
        SapiAccount b2 = b.b();
        if (b2 != null && !TextUtils.isEmpty(b2.uid)) {
            b.c(b2);
            b.d(b2);
            if (a.loginShareStrategy == LoginShareStrategy.DISABLED) {
                b.a((SapiAccount) null);
            } else if ((a.loginShareStrategy != LoginShareStrategy.SILENT || b.b() != null) && b.b() != null && b2.uid.equals(b.b().uid)) {
                b.a((SapiAccount) null);
            }
        }
    }

    private void c() {
        for (SapiAccount sapiAccount : b.c()) {
            b.c(sapiAccount);
        }
    }
}
