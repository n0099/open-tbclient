package com.baidu.sapi2.share;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {
    static final String a = "LOGIN_SHARE_MODEL";
    static final String b = "RELOGIN_CREDENTIALS";
    static final String c = "RUNTIME_ENVIRONMENT";
    static final String d = "baidu.intent.action.SHARE_V6";
    static final String e = "com.baidu.permission.SHARE";
    private static final b h = new b();
    private static SapiConfiguration f = SapiAccountManager.getInstance().getSapiConfiguration();
    private static com.baidu.sapi2.d g = com.baidu.sapi2.d.a(f.context);

    public static b a() {
        return h;
    }

    private b() {
    }

    public void a(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            if (TextUtils.isEmpty(sapiAccount.app)) {
                sapiAccount.app = SapiUtils.getAppName(f.context);
            }
            g.a(sapiAccount);
            g.c(sapiAccount);
            g.d(sapiAccount);
            if (f.loginShareStrategy != LoginShareStrategy.DISABLED) {
                a(new ShareModel(ShareEvent.VALIDATE, g.d(), Arrays.asList(sapiAccount)));
            }
        }
    }

    public void b() {
        SapiAccount d2 = g.d();
        if (d2 != null) {
            g.a((SapiAccount) null);
            g.d(d2);
            g.e(d2);
            if (f.loginShareStrategy != LoginShareStrategy.DISABLED) {
                a(new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(d2)));
            }
        }
    }

    public static void c() {
        if (g.g()) {
            if (f.loginShareStrategy != LoginShareStrategy.DISABLED) {
                g();
            }
            h();
        } else if (!g.h() && f.loginShareStrategy == LoginShareStrategy.SILENT) {
            g();
        }
    }

    public static void d() {
        if (f.loginShareStrategy != LoginShareStrategy.DISABLED) {
            if (g.d() != null || g.e().size() != 0 || g.f().size() != 0) {
                Map<String, Integer> b2 = g.j().b();
                if (b2.containsKey(f.tpl) && b2.get(f.tpl).intValue() != g.i()) {
                    ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE);
                    SapiAccount d2 = g.d();
                    if (d2 != null) {
                        d2.app = SapiUtils.getAppName(f.context);
                        shareModel.a(d2);
                    }
                    shareModel.a().addAll(g.e());
                    shareModel.a().addAll(g.f());
                    for (SapiAccount sapiAccount : shareModel.a()) {
                        sapiAccount.app = SapiUtils.getAppName(f.context);
                    }
                    a(shareModel);
                    g.a(b2.get(f.tpl).intValue());
                }
            }
        }
    }

    private static void g() {
        a(new ShareModel(ShareEvent.SYNC_REQ));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiAccount a = c.a(b.f.context);
            if (a != null) {
                b.g.a(a);
                b.g.c(a);
            }
        }
    }

    private static void h() {
        new Thread(new a()).start();
    }

    static void a(ShareModel shareModel) {
        if (shareModel != null && shareModel.b() != null) {
            Intent intent = new Intent(d);
            if (TextUtils.isEmpty(shareModel.c())) {
                shareModel.a(f.context.getPackageName());
            }
            shareModel.a(f.loginShareStrategy);
            try {
                shareModel.a(f.context);
                intent.putExtra(a, shareModel);
                if (g.k() != null) {
                    intent.putExtra(b, com.baidu.sapi2.share.a.a(f.context, g.k().toString()));
                }
                intent.putExtra(c, f.environment);
                if (Build.VERSION.SDK_INT > 11) {
                    intent.addFlags(32);
                }
                f.context.sendBroadcast(intent, e);
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }
}
