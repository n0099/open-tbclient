package com.baidu.sapi2.share;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b {
    static final String a = "LOGIN_SHARE_MODEL";
    static final String b = "RELOGIN_CREDENTIALS";
    static final String c = "RUNTIME_ENVIRONMENT";
    static final String d = "baidu.intent.action.SHARE_V6";
    static final String e = "baidu.intent.action.account.SHARE_SERVICE";
    static final String f = "com.baidu.permission.SHARE";
    private static final b i = new b();
    private static SapiConfiguration g = SapiAccountManager.getInstance().getSapiConfiguration();
    private static com.baidu.sapi2.d h = com.baidu.sapi2.d.a(g.context);

    public static b a() {
        return i;
    }

    private b() {
    }

    public void a(SapiAccount sapiAccount) {
        a(sapiAccount, true);
    }

    public void a(SapiAccount sapiAccount, boolean z) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            if (TextUtils.isEmpty(sapiAccount.app)) {
                sapiAccount.app = SapiUtils.getAppName(g.context);
            }
            if (z) {
                h.a(sapiAccount);
                h.c(sapiAccount);
                h.d(sapiAccount);
                if (g.loginShareStrategy() == LoginShareStrategy.DISABLED) {
                    return;
                }
            }
            HandlerThread handlerThread = new HandlerThread("ValidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new a(handler, sapiAccount, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ SapiAccount b;
        final /* synthetic */ boolean c;

        a(Handler handler, SapiAccount sapiAccount, boolean z) {
            this.a = handler;
            this.b = sapiAccount;
            this.c = z;
        }

        /* renamed from: com.baidu.sapi2.share.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0029a implements a.b {
            C0029a() {
            }

            /* renamed from: com.baidu.sapi2.share.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0030a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0030a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0031a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0031a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, b.a(new ShareModel(ShareEvent.VALIDATE, a.this.b, Arrays.asList(a.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0030a.this.a != null) {
                                C0029a.this.a(ServiceConnectionC0030a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.a.post(new RunnableC0031a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0030a(intent2), 1);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent) {
                b.a(intent, new ShareModel(ShareEvent.VALIDATE, a.this.b, Arrays.asList(a.this.b)));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.a.a(b.g.context, new C0029a(), !this.c);
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null && g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            h.d(sapiAccount);
            HandlerThread handlerThread = new HandlerThread("InvalidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new RunnableC0032b(handler, sapiAccount));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0032b implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ SapiAccount b;

        RunnableC0032b(Handler handler, SapiAccount sapiAccount) {
            this.a = handler;
            this.b = sapiAccount;
        }

        /* renamed from: com.baidu.sapi2.share.b$b$a */
        /* loaded from: classes.dex */
        class a implements a.b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0033a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0033a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0034a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0034a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, b.a(new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0032b.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0033a.this.a != null) {
                                a.this.a(ServiceConnectionC0033a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    RunnableC0032b.this.a.post(new RunnableC0034a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0033a(intent2), 1);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent) {
                b.a(intent, new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0032b.this.b)));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.a.a(b.g.context, (a.b) new a(), false);
        }
    }

    public static void b() {
        if (h.g()) {
            if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                e();
            }
            f();
        } else if (!h.h() && g.loginShareStrategy() == LoginShareStrategy.SILENT) {
            e();
        }
    }

    private static void e() {
        HandlerThread handlerThread = new HandlerThread("SyncThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new c(handler));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c implements Runnable {
        final /* synthetic */ Handler a;

        c(Handler handler) {
            this.a = handler;
        }

        /* loaded from: classes.dex */
        class a implements a.b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.b$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0035a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0035a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$c$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0036a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0036a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Parcel a = b.a(new ShareModel(ShareEvent.SYNC_REQ));
                            Parcel obtain = Parcel.obtain();
                            if (this.a.transact(0, a, obtain, 0)) {
                                b.b(obtain);
                            } else if (ServiceConnectionC0035a.this.a != null) {
                                a.this.a(ServiceConnectionC0035a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.a.post(new RunnableC0036a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0035a(intent2), 1);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent) {
                b.a(intent, new ShareModel(ShareEvent.SYNC_REQ));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.a.a(b.g.context, (a.b) new a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Parcel parcel) {
        if (parcel != null) {
            try {
                Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                com.baidu.sapi2.share.a.c(g.context, readBundle.getString(b));
                com.baidu.sapi2.share.a.a(g.context, g.loginShareStrategy(), (ShareModel) readBundle.getParcelable(a));
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiAccount a = com.baidu.sapi2.share.c.a(b.g.context);
            if (a != null) {
                b.h.a(a);
                b.h.c(a);
            }
        }
    }

    private static void f() {
        new Thread(new d()).start();
    }

    static void a(Intent intent, ShareModel shareModel) {
        try {
            com.baidu.sapi2.share.a.b(g.context, g.loginShareStrategy(), shareModel);
            intent.putExtra(a, shareModel);
            if (h.n() != null) {
                intent.putExtra(b, e.a(g.context, h.n().toString()));
            }
            intent.putExtra(c, g.environment);
            g.context.sendBroadcast(intent, f);
        } catch (Throwable th) {
            L.e(th);
        }
    }

    static Parcel a(ShareModel shareModel) {
        Parcel obtain = Parcel.obtain();
        Bundle bundle = new Bundle();
        com.baidu.sapi2.share.a.b(g.context, g.loginShareStrategy(), shareModel);
        bundle.putParcelable(a, shareModel);
        if (h.n() != null) {
            bundle.putString(b, e.a(g.context, h.n().toString()));
        }
        bundle.putSerializable(c, g.environment);
        obtain.writeBundle(bundle);
        return obtain;
    }
}
