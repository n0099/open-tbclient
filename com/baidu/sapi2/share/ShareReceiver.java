package com.baidu.sapi2.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
/* loaded from: classes.dex */
public final class ShareReceiver extends BroadcastReceiver {
    private static Context a;
    private static LoginShareStrategy b;
    private static com.baidu.sapi2.d c;
    private static g d;
    private static boolean e = false;
    private static Handler f;
    private static Handler g;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ShareModel shareModel;
        if (SapiAccountManager.getReceiveShareListener() != null) {
            if (f == null) {
                f = new Handler(Looper.getMainLooper());
            }
            f.post(new c());
        }
        if (!e) {
            a(context);
        }
        if (e && b != LoginShareStrategy.DISABLED) {
            try {
                if ("baidu.intent.action.SHARE_V6".equals(intent.getAction()) && (shareModel = (ShareModel) intent.getParcelableExtra("LOGIN_SHARE_MODEL")) != null) {
                    String b2 = e.b(context, shareModel.c());
                    if (TextUtils.isEmpty(b2) || !b2.equals(context.getPackageName())) {
                        if (intent.getSerializableExtra("RUNTIME_ENVIRONMENT") == null || !(intent.getSerializableExtra("RUNTIME_ENVIRONMENT") instanceof Domain) || ((Domain) intent.getSerializableExtra("RUNTIME_ENVIRONMENT")) == SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                            g.post(new a(context, intent, shareModel));
                        }
                    }
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiAccountManager.getReceiveShareListener() != null) {
                SapiAccountManager.getReceiveShareListener().onReceiveShare();
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;
        final /* synthetic */ ShareModel c;

        a(Context context, Intent intent, ShareModel shareModel) {
            this.a = context;
            this.b = intent;
            this.c = shareModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.baidu.sapi2.share.a.c(this.a, this.b.getStringExtra("RELOGIN_CREDENTIALS"));
                if (ShareReceiver.d != null) {
                    ShareReceiver.d.a(this.c);
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    void a(Context context) {
        try {
            a = context;
            c = com.baidu.sapi2.d.a(context);
            b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            d = new b();
            HandlerThread handlerThread = new HandlerThread("ReceiverThread");
            handlerThread.start();
            g = new Handler(handlerThread.getLooper());
            e = true;
        } catch (IllegalStateException e2) {
            e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements g {
        b() {
        }

        @Override // com.baidu.sapi2.share.g
        public void a(ShareModel shareModel) {
            if (shareModel != null && ShareReceiver.b != LoginShareStrategy.DISABLED) {
                switch (d.a[shareModel.b().ordinal()]) {
                    case 1:
                        com.baidu.sapi2.share.a.a(ShareReceiver.a, ShareReceiver.b, shareModel);
                        return;
                    case 2:
                        com.baidu.sapi2.share.a.a(ShareReceiver.a, shareModel);
                        return;
                    case 3:
                        ShareReceiver.this.a(shareModel);
                        return;
                    case 4:
                        com.baidu.sapi2.share.a.a(ShareReceiver.a, ShareReceiver.b, shareModel);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    /* synthetic */ class d {
        static final /* synthetic */ int[] a = new int[ShareEvent.values().length];

        static {
            try {
                a[ShareEvent.VALIDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ShareEvent.INVALIDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ShareEvent.SYNC_REQ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ShareEvent.SYNC_ACK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    void a(ShareModel shareModel) {
        shareModel.b(a);
        Intent intent = new Intent("baidu.intent.action.SHARE_V6");
        intent.setPackage(shareModel.c());
        ShareModel shareModel2 = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount d2 = c.d();
        if (d2 != null) {
            d2.app = SapiUtils.getAppName(a);
        }
        shareModel2.a(d2);
        shareModel2.a().addAll(c.e());
        shareModel2.a().addAll(c.f());
        for (SapiAccount sapiAccount : shareModel2.a()) {
            sapiAccount.app = SapiUtils.getAppName(a);
        }
        com.baidu.sapi2.share.a.b(a, b, shareModel2);
        intent.putExtra("LOGIN_SHARE_MODEL", shareModel2);
        if (c.p() != null) {
            intent.putExtra("RELOGIN_CREDENTIALS", e.a(a, c.p().toString()));
        }
        intent.putExtra("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        if (Build.VERSION.SDK_INT > 11) {
            intent.addFlags(32);
        }
        a.sendBroadcast(intent, "com.baidu.permission.SHARE");
    }
}
