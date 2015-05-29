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
import java.util.Map;
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
        class C0009a implements a.b {
            C0009a() {
            }

            /* renamed from: com.baidu.sapi2.share.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0010a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0010a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0011a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0011a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, b.a(new ShareModel(ShareEvent.VALIDATE, a.this.b, Arrays.asList(a.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0010a.this.a != null) {
                                C0009a.this.a(ServiceConnectionC0010a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    a.this.a.post(new RunnableC0011a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0010a(intent2), 1);
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
            com.baidu.sapi2.share.a.a(b.g.context, new C0009a(), !this.c);
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null && g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            h.d(sapiAccount);
            HandlerThread handlerThread = new HandlerThread("InvalidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new RunnableC0012b(handler, sapiAccount));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0012b implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ SapiAccount b;

        RunnableC0012b(Handler handler, SapiAccount sapiAccount) {
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
            class ServiceConnectionC0013a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0013a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$b$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0014a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0014a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, b.a(new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0012b.this.b))), Parcel.obtain(), 0) && ServiceConnectionC0013a.this.a != null) {
                                a.this.a(ServiceConnectionC0013a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    RunnableC0012b.this.a.post(new RunnableC0014a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0013a(intent2), 1);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent) {
                b.a(intent, new ShareModel(ShareEvent.INVALIDATE, null, Arrays.asList(RunnableC0012b.this.b)));
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
                h();
            }
            i();
        } else if (!h.h() && g.loginShareStrategy() == LoginShareStrategy.SILENT) {
            h();
        }
    }

    public static void c() {
        if (g.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            if (h.d() != null || h.e().size() != 0 || h.f().size() != 0) {
                Map<String, Integer> o = h.o();
                if (o.containsKey(g.tpl) && o.get(g.tpl).intValue() != h.j()) {
                    HandlerThread handlerThread = new HandlerThread("SendThread");
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper());
                    handler.post(new d(handler, o));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    final class d implements Runnable {
        final /* synthetic */ Handler a;
        final /* synthetic */ Map b;

        d(Handler handler, Map map) {
            this.a = handler;
            this.b = map;
        }

        /* loaded from: classes.dex */
        class a implements a.b {
            a() {
            }

            /* renamed from: com.baidu.sapi2.share.b$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class ServiceConnectionC0017a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0017a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$d$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0018a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0018a(IBinder iBinder, ServiceConnection serviceConnection) {
                        this.a = iBinder;
                        this.b = serviceConnection;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!this.a.transact(0, b.a(b.g()), Parcel.obtain(), 0) && ServiceConnectionC0017a.this.a != null) {
                                a.this.a(ServiceConnectionC0017a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    d.this.a.post(new RunnableC0018a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0017a(intent2), 1);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent) {
                b.a(intent, b.g());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.sapi2.share.a.a(b.g.context, (a.b) new a(), false);
            b.h.a(((Integer) this.b.get(b.g.tpl)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShareModel g() {
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

    private static void h() {
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
            class ServiceConnectionC0015a implements ServiceConnection {
                final /* synthetic */ Intent a;

                ServiceConnectionC0015a(Intent intent) {
                    this.a = intent;
                }

                /* renamed from: com.baidu.sapi2.share.b$c$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class RunnableC0016a implements Runnable {
                    final /* synthetic */ IBinder a;
                    final /* synthetic */ ServiceConnection b;

                    RunnableC0016a(IBinder iBinder, ServiceConnection serviceConnection) {
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
                            } else if (ServiceConnectionC0015a.this.a != null) {
                                a.this.a(ServiceConnectionC0015a.this.a);
                            }
                            b.g.context.unbindService(this.b);
                        } catch (Throwable th) {
                            L.e(th);
                        }
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.a.post(new RunnableC0016a(iBinder, this));
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }

            @Override // com.baidu.sapi2.share.a.b
            public void a(Intent intent, Intent intent2) {
                try {
                    b.g.context.bindService(intent, new ServiceConnectionC0015a(intent2), 1);
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
    public final class e implements Runnable {
        e() {
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

    private static void i() {
        new Thread(new e()).start();
    }

    static void a(Intent intent, ShareModel shareModel) {
        try {
            com.baidu.sapi2.share.a.b(g.context, g.loginShareStrategy(), shareModel);
            intent.putExtra(a, shareModel);
            if (h.p() != null) {
                intent.putExtra(b, com.baidu.sapi2.share.e.a(g.context, h.p().toString()));
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
        if (h.p() != null) {
            bundle.putString(b, com.baidu.sapi2.share.e.a(g.context, h.p().toString()));
        }
        bundle.putSerializable(c, g.environment);
        obtain.writeBundle(bundle);
        return obtain;
    }
}
