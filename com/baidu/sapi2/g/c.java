package com.baidu.sapi2.g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
/* loaded from: classes2.dex */
public class c extends FingerprintManager.AuthenticationCallback {
    public static final int i = 0;
    public static final int j = -2;
    public static final int k = -3;
    public static final int l = -8;
    public static final String m = c.class.getSimpleName();
    public static final int n = 5;

    /* renamed from: a  reason: collision with root package name */
    public int f10817a;

    /* renamed from: b  reason: collision with root package name */
    public char f10818b = 5;

    /* renamed from: c  reason: collision with root package name */
    public Context f10819c;

    /* renamed from: d  reason: collision with root package name */
    public FingerprintManager f10820d;

    /* renamed from: e  reason: collision with root package name */
    public FingerprintManager.CryptoObject f10821e;

    /* renamed from: f  reason: collision with root package name */
    public CancellationSignal f10822f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.sapi2.g.a f10823g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.sapi2.g.b f10824h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.f10823g.onCall(-2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.f10823g.onCall(-2);
        }
    }

    /* renamed from: com.baidu.sapi2.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0142c implements View.OnClickListener {
        public View$OnClickListenerC0142c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.f10823g.onCall(-3);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
            c.this.f10823g.onCall(-2);
        }
    }

    public c(Context context, com.baidu.sapi2.g.b bVar) {
        this.f10821e = null;
        this.f10822f = null;
        this.f10819c = context;
        this.f10824h = bVar;
        this.f10820d = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.f10821e = null;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f10822f = new CancellationSignal();
        }
    }

    private void b() {
        a((Activity) this.f10819c, (Dialog) this.f10824h);
        this.f10824h.setTitle("百度帐号 触控ID", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new a()).showDialog();
    }

    private void c() {
        a((Activity) this.f10819c, (Dialog) this.f10824h);
        StatService.onEvent("fingerprint_try_again_dialog_show", null);
        this.f10824h.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(2).setNegativeBtn("取消", new d()).setPositiveBtn("换个登录方式", new View$OnClickListenerC0142c()).showDialog();
    }

    private void d() {
        a((Activity) this.f10819c, (Dialog) this.f10824h);
        this.f10824h.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new b()).showDialog();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i2, CharSequence charSequence) {
        super.onAuthenticationError(i2, charSequence);
        String str = m;
        Log.i(str, "Authentication error:" + i2 + ((Object) charSequence));
        a();
        this.f10818b = (char) 5;
        if (i2 == 7) {
            com.baidu.sapi2.g.a aVar = this.f10823g;
            if (aVar != null) {
                aVar.onCall(-8);
                return;
            }
            return;
        }
        com.baidu.sapi2.g.a aVar2 = this.f10823g;
        if (aVar2 != null) {
            aVar2.onCall(i2);
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(m, "Authentication failed ");
        char c2 = (char) (this.f10818b - 1);
        this.f10818b = c2;
        if (c2 > 0) {
            if (this.f10817a == 3) {
                c();
                return;
            } else {
                d();
                return;
            }
        }
        a();
        this.f10818b = (char) 5;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        super.onAuthenticationHelp(i2, charSequence);
        String str = m;
        Log.i(str, "Authentication help:" + i2 + ((Object) charSequence));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(m, "Authentication Succeeded ");
        a((Activity) this.f10819c, (Dialog) this.f10824h);
        com.baidu.sapi2.g.a aVar = this.f10823g;
        if (aVar != null) {
            aVar.onCall(0);
        }
    }

    public void a(int i2, com.baidu.sapi2.g.a aVar) {
        Log.i(m, "startAuthenticate");
        this.f10817a = i2;
        this.f10823g = aVar;
        if (Build.VERSION.SDK_INT >= 16 && this.f10822f.isCanceled()) {
            this.f10822f = new CancellationSignal();
        }
        this.f10820d.authenticate(this.f10821e, this.f10822f, 0, this, null);
        b();
    }

    public void a() {
        Log.i(m, "stopAuthenticate");
        a((Activity) this.f10819c, (Dialog) this.f10824h);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f10822f.cancel();
            this.f10820d.authenticate(this.f10821e, this.f10822f, 0, this, null);
        }
    }

    public static void a(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog == null || activity.isFinishing() || !dialog.isShowing()) {
                return;
            }
            try {
                dialog.dismiss();
                return;
            } catch (Exception e2) {
                Log.e(e2);
                return;
            }
        }
        throw new IllegalArgumentException("Activity must not be null");
    }
}
