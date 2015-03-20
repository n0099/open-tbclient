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
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    static final String a = "LOGIN_SHARE_MODEL";
    static final String b = "RELOGIN_CREDENTIALS";
    static final String c = "RUNTIME_ENVIRONMENT";
    static final String d = "baidu.intent.action.SHARE_V6";
    static final String e = "baidu.intent.action.account.SHARE_SERVICE";
    static final String f = "com.baidu.permission.SHARE";
    private static final c i = new c();
    private static SapiConfiguration g = SapiAccountManager.getInstance().getSapiConfiguration();
    private static com.baidu.sapi2.c h = com.baidu.sapi2.c.a(g.context);

    public static c a() {
        return i;
    }

    private c() {
    }

    public void a(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            if (TextUtils.isEmpty(sapiAccount.app)) {
                sapiAccount.app = SapiUtils.getAppName(g.context);
            }
            h.a(sapiAccount);
            h.c(sapiAccount);
            h.d(sapiAccount);
            if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                HandlerThread handlerThread = new HandlerThread("ValidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new b(handler, sapiAccount));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ SapiAccount b;

        b(Handler handler, SapiAccount sapiAccount) {
            this.a = handler;
            this.b = sapiAccount;
        }

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0007b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.c$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0011a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0011a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.c$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0012a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0012a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, c.a(new ShareModel(ShareEvent.VALIDATE, c.h.d(), Arrays.asList(b.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0011a.this.a != null) {
                                a.this.a(ServiceConnectionC0011a.this.a);
                            }
                            c.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    b.this.a.post(new RunnableC0012a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent, Intent intent2) {
                c.g.context.bindService(intent, new ServiceConnectionC0011a(intent2), 1);
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent) {
                c.a(intent, new ShareModel(ShareEvent.VALIDATE, c.h.d(), Arrays.asList(b.this.b)));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.b.a(c.g.context, new a());
        }
    }

    public void b() {
        SapiAccount d2 = h.d();
        if (d2 != null) {
            h.a((SapiAccount) null);
            h.d(d2);
            h.e(d2);
            if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new RunnableC0013c(handler, d2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0013c implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ SapiAccount b;

        RunnableC0013c(Handler handler, SapiAccount sapiAccount) {
            this.a = handler;
            this.b = sapiAccount;
        }

        /* renamed from: com.baidu.sapi2.share.c$c$a */
        /* loaded from: classes.dex */
        class a implements b.InterfaceC0007b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.c$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0014a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0014a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.c$c$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0015a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0015a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, c.a(new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0013c.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0014a.this.a != null) {
                                a.this.a(ServiceConnectionC0014a.this.a);
                            }
                            c.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    RunnableC0013c.this.a.post(new RunnableC0015a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent, Intent intent2) {
                c.g.context.bindService(intent, new ServiceConnectionC0014a(intent2), 1);
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent) {
                c.a(intent, new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0013c.this.b)));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.b.a(c.g.context, new a());
        }
    }

    public static void c() {
        if (h.g()) {
            if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                i();
            }
            j();
        } else if (!h.h() && g.loginShareStrategy() == LoginShareStrategy.SILENT) {
            i();
        }
    }

    public static void d() {
        if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            if (h.d() != null || h.e().size() != 0 || h.f().size() != 0) {
                Map<String, Integer> b2 = h.j().b();
                if (b2.containsKey(g.tpl) && b2.get(g.tpl).intValue() != h.i()) {
                    HandlerThread handlerThread = new HandlerThread("SendThread");
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper());
                    handler.post(new a(handler, b2));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    final class a implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ Map b;

        a(Handler handler, Map map) {
            this.a = handler;
            this.b = map;
        }

        /* renamed from: com.baidu.sapi2.share.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0008a implements b.InterfaceC0007b {
            C0008a() {
            }

            /* renamed from: com.baidu.sapi2.share.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0009a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0009a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.c$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0010a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0010a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, c.a(c.h()), Parcel.obtain(), 0) && ServiceConnectionC0009a.this.a != null) {
                                C0008a.this.a(ServiceConnectionC0009a.this.a);
                            }
                            c.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.a.post(new RunnableC0010a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent, Intent intent2) {
                c.g.context.bindService(intent, new ServiceConnectionC0009a(intent2), 1);
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent) {
                c.a(intent, c.h());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.b.a(c.g.context, new C0008a());
            c.h.a(((Integer) this.b.get(c.g.tpl)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShareModel h() {
        ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE);
        SapiAccount d2 = h.d();
        if (d2 != null) {
            d2.app = SapiUtils.getAppName(g.context);
            shareModel.a(d2);
        }
        shareModel.a().addAll(h.e());
        shareModel.a().addAll(h.f());
        for (SapiAccount sapiAccount : shareModel.a()) {
            sapiAccount.app = SapiUtils.getAppName(g.context);
        }
        return shareModel;
    }

    private static void i() {
        HandlerThread handlerThread = new HandlerThread("SyncThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new d(handler));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d implements Runnable {
        final /* synthetic */ Handler a;

        d(Handler handler) {
            this.a = handler;
        }

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0007b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.c$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0016a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0016a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.c$d$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0017a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0017a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Parcel a = c.a(new ShareModel(ShareEvent.SYNC_REQ));
                            Parcel obtain = Parcel.obtain();
                            if (this.a.transact(0, a, obtain, 0)) {
                                c.b(obtain);
                            } else if (ServiceConnectionC0016a.this.a != null) {
                                a.this.a(ServiceConnectionC0016a.this.a);
                            }
                            c.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    d.this.a.post(new RunnableC0017a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent, Intent intent2) {
                c.g.context.bindService(intent, new ServiceConnectionC0016a(intent2), 1);
            }

            @Override // com.baidu.sapi2.share.b.InterfaceC0007b
            public void a(Intent intent) {
                c.a(intent, new ShareModel(ShareEvent.SYNC_REQ));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.b.a(c.g.context, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Parcel parcel) {
        if (parcel != null) {
            Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
            com.baidu.sapi2.share.b.c(g.context, readBundle.getString(b));
            com.baidu.sapi2.share.b.a(g.context, g.loginShareStrategy(), (ShareModel) readBundle.getParcelable(a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiAccount a = com.baidu.sapi2.share.d.a(c.g.context);
            if (a != null) {
                c.h.a(a);
                c.h.c(a);
            }
        }
    }

    private static void j() {
        new Thread(new e()).start();
    }

    static void a(Intent intent, ShareModel shareModel) {
        try {
            com.baidu.sapi2.share.b.b(g.context, g.loginShareStrategy(), shareModel);
            intent.putExtra(a, shareModel);
            if (h.k() != null) {
                intent.putExtra(b, com.baidu.sapi2.share.a.a(g.context, h.k().toString()));
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
        com.baidu.sapi2.share.b.b(g.context, g.loginShareStrategy(), shareModel);
        bundle.putParcelable(a, shareModel);
        if (h.k() != null) {
            bundle.putString(b, com.baidu.sapi2.share.a.a(g.context, h.k().toString()));
        }
        bundle.putSerializable(c, g.environment);
        obtain.writeBundle(bundle);
        return obtain;
    }
}
