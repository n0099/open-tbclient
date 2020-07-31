package com.baidu.sapi2.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes19.dex */
public class g extends FingerprintManager.AuthenticationCallback {
    private static final int a = 0;
    private static final int b = -2;
    private static final int c = -3;
    private static final int d = -8;
    public static final String e = "g";
    private static final int f = 5;
    private int g;
    private char h = 5;
    private Context i;
    private FingerprintManager j;
    private FingerprintManager.CryptoObject k;
    private CancellationSignal l;
    private a m;
    private b n;

    public g(Context context, b bVar) {
        this.k = null;
        this.l = null;
        this.i = context;
        this.n = bVar;
        this.j = (FingerprintManager) this.i.getSystemService(FingerprintManager.class);
        this.k = null;
        if (Build.VERSION.SDK_INT >= 16) {
            this.l = new CancellationSignal();
        }
    }

    private void b() {
        a((Activity) this.i, (Dialog) this.n);
        this.n.a("百度帐号 触控ID", "请验证已有手机指纹").a(1).setNegativeBtn(PayHelper.STATUS_CANCEL_DESC, new c(this)).showDialog();
    }

    private void c() {
        a((Activity) this.i, (Dialog) this.n);
        this.n.a("再试一次", "请验证已有手机指纹").a(2).setNegativeBtn(PayHelper.STATUS_CANCEL_DESC, new f(this)).setPositiveBtn("换个登录方式", new e(this)).showDialog();
    }

    private void d() {
        a((Activity) this.i, (Dialog) this.n);
        this.n.a("再试一次", "请验证已有手机指纹").a(1).setNegativeBtn(PayHelper.STATUS_CANCEL_DESC, new d(this)).showDialog();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        super.onAuthenticationError(i, charSequence);
        Log.i(e, "Authentication error:" + i + ((Object) charSequence));
        a();
        this.h = (char) 5;
        if (i == 7) {
            a aVar = this.m;
            if (aVar != null) {
                aVar.onCall(-8);
                return;
            }
            return;
        }
        a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.onCall(i);
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(e, "Authentication failed ");
        char c2 = (char) (this.h - 1);
        this.h = c2;
        if (c2 > 0) {
            if (this.g == 3) {
                c();
                return;
            } else {
                d();
                return;
            }
        }
        a();
        this.h = (char) 5;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        super.onAuthenticationHelp(i, charSequence);
        Log.i(e, "Authentication help:" + i + ((Object) charSequence));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(e, "Authentication Succeeded ");
        a((Activity) this.i, (Dialog) this.n);
        a aVar = this.m;
        if (aVar != null) {
            aVar.onCall(0);
        }
    }

    public void a(int i, a aVar) {
        Log.i(e, "startAuthenticate");
        this.g = i;
        this.m = aVar;
        if (Build.VERSION.SDK_INT >= 16 && this.l.isCanceled()) {
            this.l = new CancellationSignal();
        }
        this.j.authenticate(this.k, this.l, 0, this, null);
        b();
    }

    public void a() {
        Log.i(e, "stopAuthenticate");
        a((Activity) this.i, (Dialog) this.n);
        if (Build.VERSION.SDK_INT >= 16) {
            this.l.cancel();
            this.j.authenticate(this.k, this.l, 0, this, null);
        }
    }

    private static void a(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e2) {
                    Log.e(e2);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Activity must not be null");
    }
}
