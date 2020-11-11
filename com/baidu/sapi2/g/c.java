package com.baidu.sapi2.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes5.dex */
public class c extends FingerprintManager.AuthenticationCallback {
    private static final int i = 0;
    private static final int j = -2;
    private static final int k = -3;
    private static final int l = -8;
    public static final String m = c.class.getSimpleName();
    private static final int n = 5;

    /* renamed from: a  reason: collision with root package name */
    private int f3459a;
    private char b = 5;
    private Context c;
    private FingerprintManager d;
    private FingerprintManager.CryptoObject e;
    private CancellationSignal f;
    private com.baidu.sapi2.g.a g;
    private com.baidu.sapi2.g.b h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.g.onCall(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.g.onCall(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0336c implements View.OnClickListener {
        View$OnClickListenerC0336c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.g.onCall(-3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.g.onCall(-2);
        }
    }

    public c(Context context, com.baidu.sapi2.g.b bVar) {
        this.e = null;
        this.f = null;
        this.c = context;
        this.h = bVar;
        this.d = (FingerprintManager) this.c.getSystemService(FingerprintManager.class);
        this.e = null;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f = new CancellationSignal();
        }
    }

    private void b() {
        a((Activity) this.c, (Dialog) this.h);
        this.h.a("百度帐号 触控ID", "请验证已有手机指纹").a(1).a(PayHelper.STATUS_CANCEL_DESC, new a()).b();
    }

    private void c() {
        a((Activity) this.c, (Dialog) this.h);
        this.h.a("再试一次", "请验证已有手机指纹").a(2).a(PayHelper.STATUS_CANCEL_DESC, new d()).b("换个登录方式", new View$OnClickListenerC0336c()).b();
    }

    private void d() {
        a((Activity) this.c, (Dialog) this.h);
        this.h.a("再试一次", "请验证已有手机指纹").a(1).a(PayHelper.STATUS_CANCEL_DESC, new b()).b();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i2, CharSequence charSequence) {
        super.onAuthenticationError(i2, charSequence);
        Log.i(m, "Authentication error:" + i2 + ((Object) charSequence));
        a();
        this.b = (char) 5;
        if (i2 == 7) {
            com.baidu.sapi2.g.a aVar = this.g;
            if (aVar != null) {
                aVar.onCall(-8);
                return;
            }
            return;
        }
        com.baidu.sapi2.g.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.onCall(i2);
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(m, "Authentication failed ");
        char c = (char) (this.b - 1);
        this.b = c;
        if (c > 0) {
            if (this.f3459a == 3) {
                c();
                return;
            } else {
                d();
                return;
            }
        }
        a();
        this.b = (char) 5;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        super.onAuthenticationHelp(i2, charSequence);
        Log.i(m, "Authentication help:" + i2 + ((Object) charSequence));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(m, "Authentication Succeeded ");
        a((Activity) this.c, (Dialog) this.h);
        com.baidu.sapi2.g.a aVar = this.g;
        if (aVar != null) {
            aVar.onCall(0);
        }
    }

    public void a(int i2, com.baidu.sapi2.g.a aVar) {
        Log.i(m, "startAuthenticate");
        this.f3459a = i2;
        this.g = aVar;
        if (Build.VERSION.SDK_INT >= 16 && this.f.isCanceled()) {
            this.f = new CancellationSignal();
        }
        this.d.authenticate(this.e, this.f, 0, this, null);
        b();
    }

    public void a() {
        Log.i(m, "stopAuthenticate");
        a((Activity) this.c, (Dialog) this.h);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f.cancel();
            this.d.authenticate(this.e, this.f, 0, this, null);
        }
    }

    private static void a(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e) {
                    Log.e(e);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Activity must not be null");
    }
}
