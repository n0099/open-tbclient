package com.baidu.sapi2.share;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b {
    static final String a = "LOGIN_SHARE_MODEL";
    static final String b = "RELOGIN_CREDENTIALS";
    static final String c = "baidu.intent.action.SHARE_V6";
    static final String d = "com.baidu.permission.SHARE";
    private static final b h = new b();
    private static SapiConfiguration e = SapiAccountManager.getInstance().getSapiConfiguration();
    private static com.baidu.sapi2.d f = com.baidu.sapi2.d.a(e.context);
    private static d g = new d(e.context);

    public static b a() {
        return h;
    }

    private b() {
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            throw new IllegalArgumentException("Account can't be null");
        }
        if (TextUtils.isEmpty(sapiAccount.app)) {
            sapiAccount.app = com.baidu.sapi2.utils.c.a(e.context);
        }
        if (e.loginShareStrategy == LoginShareStrategy.SILENT) {
            f();
        }
        f.a(sapiAccount);
        f.c(sapiAccount);
        f.d(sapiAccount);
        if (e.loginShareStrategy == LoginShareStrategy.DISABLED) {
            f();
            return;
        }
        ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE, f.d(), Arrays.asList(sapiAccount));
        shareModel.a(e.loginShareStrategy);
        g.a(shareModel);
    }

    public void b() {
        SapiAccount d2 = f.d();
        if (d2 != null && !TextUtils.isEmpty(d2.uid)) {
            f.d(d2);
            f.e(d2);
            if (e.loginShareStrategy == LoginShareStrategy.DISABLED) {
                f.a((SapiAccount) null);
            } else if (e.loginShareStrategy != LoginShareStrategy.SILENT || f.d() != null) {
                if (f.d() != null && d2.uid.equals(f.d().uid)) {
                    f.a((SapiAccount) null);
                }
                ShareModel shareModel = new ShareModel(ShareEvent.INVALIDATE, f.d(), Arrays.asList(d2));
                shareModel.a(e.loginShareStrategy);
                g.a(shareModel);
            }
        }
    }

    public static void c() {
        if (f.g()) {
            if (e.loginShareStrategy != LoginShareStrategy.DISABLED) {
                new ShareModel(ShareEvent.SYNC_REQ).a(e.loginShareStrategy);
                g.a(new ShareModel(ShareEvent.SYNC_REQ));
            }
            g();
        }
    }

    private void f() {
        for (SapiAccount sapiAccount : f.e()) {
            f.d(sapiAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiAccount a = c.a(b.e.context);
            if (a != null) {
                b.f.a(a);
                b.f.c(a);
            }
        }
    }

    private static void g() {
        new Thread(new a()).start();
    }
}
