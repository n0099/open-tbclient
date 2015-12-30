package com.baidu.sapi2.share;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
/* loaded from: classes.dex */
public final class ShareService extends Service {
    private static Context a;
    private static LoginShareStrategy b;
    private static com.baidu.sapi2.d c;
    private static boolean d = false;
    private Handler e;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.e = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new a(this, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        stopSelf();
        return 2;
    }

    /* loaded from: classes.dex */
    private class a extends Binder {
        private a() {
        }

        /* synthetic */ a(ShareService shareService, b bVar) {
            this();
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle readBundle;
            ShareModel shareModel;
            if (!com.baidu.sapi2.share.a.c(ShareService.this)) {
                return false;
            }
            if (SapiAccountManager.getReceiveShareListener() != null) {
                if (ShareService.this.e == null) {
                    ShareService.this.e = new Handler(Looper.getMainLooper());
                }
                ShareService.this.e.post(new RunnableC0028a());
            }
            if (!ShareService.d) {
                ShareService.this.a((Context) ShareService.this);
            }
            if (!ShareService.d || ShareService.b == LoginShareStrategy.DISABLED) {
                return true;
            }
            try {
                readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                shareModel = (ShareModel) readBundle.getParcelable("LOGIN_SHARE_MODEL");
            } catch (Throwable th) {
                L.e(th);
            }
            if (shareModel == null) {
                return true;
            }
            if (readBundle.getSerializable("RUNTIME_ENVIRONMENT") == null || !(readBundle.getSerializable("RUNTIME_ENVIRONMENT") instanceof Domain) || ((Domain) readBundle.getSerializable("RUNTIME_ENVIRONMENT")) == SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                com.baidu.sapi2.share.a.c(ShareService.a, readBundle.getString("RELOGIN_CREDENTIALS"));
                switch (b.a[shareModel.b().ordinal()]) {
                    case 1:
                        com.baidu.sapi2.share.a.a(ShareService.a, ShareService.b, shareModel);
                        break;
                    case 2:
                        com.baidu.sapi2.share.a.a(ShareService.a, shareModel);
                        break;
                    case 3:
                        ShareService.this.a(parcel2);
                        break;
                }
                return true;
            }
            return true;
        }

        /* renamed from: com.baidu.sapi2.share.ShareService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0028a implements Runnable {
            RunnableC0028a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiAccountManager.getReceiveShareListener() != null) {
                    SapiAccountManager.getReceiveShareListener().onReceiveShare();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {
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
        }
    }

    void a(Context context) {
        try {
            a = context;
            c = com.baidu.sapi2.d.a(context);
            b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            d = true;
        } catch (IllegalStateException e) {
            d = false;
        }
    }

    void a(Parcel parcel) {
        Bundle bundle = new Bundle();
        ShareModel shareModel = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount d2 = c.d();
        if (d2 != null) {
            d2.app = SapiUtils.getAppName(a);
        }
        shareModel.a(d2);
        shareModel.a().addAll(c.e());
        shareModel.a().addAll(c.f());
        for (SapiAccount sapiAccount : shareModel.a()) {
            sapiAccount.app = SapiUtils.getAppName(a);
        }
        com.baidu.sapi2.share.a.b(a, b, shareModel);
        bundle.putParcelable("LOGIN_SHARE_MODEL", shareModel);
        if (c.n() != null) {
            bundle.putString("RELOGIN_CREDENTIALS", e.a(a, c.n().toString()));
        }
        bundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        parcel.writeBundle(bundle);
    }
}
