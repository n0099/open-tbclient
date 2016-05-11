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
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ShareService extends Service {
    private static Context a;
    private static LoginShareStrategy b;
    private static com.baidu.sapi2.c c;
    private static boolean d = false;
    private Handler e;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.e = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }

    /* loaded from: classes.dex */
    private class a extends Binder {
        private a() {
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle readBundle;
            ShareModel shareModel;
            if (!d.b(ShareService.this)) {
                return false;
            }
            if (SapiAccountManager.getReceiveShareListener() != null) {
                if (ShareService.this.e == null) {
                    ShareService.this.e = new Handler(Looper.getMainLooper());
                }
                ShareService.this.e.post(new Runnable() { // from class: com.baidu.sapi2.share.ShareService.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiAccountManager.getReceiveShareListener() != null) {
                            SapiAccountManager.getReceiveShareListener().onReceiveShare();
                        }
                    }
                });
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
                int i3 = readBundle.getInt("SDK_VERSION");
                d.b(ShareService.a, readBundle.getString("RELOGIN_CREDENTIALS"));
                switch (shareModel.b()) {
                    case VALIDATE:
                        d.a(ShareService.a, ShareService.b, shareModel, i3);
                        break;
                    case INVALIDATE:
                        d.a(ShareService.a, shareModel);
                        break;
                    case SYNC_REQ:
                        ShareService.this.a(parcel2);
                        break;
                }
                return true;
            }
            return true;
        }
    }

    void a(Context context) {
        try {
            a = context;
            c = com.baidu.sapi2.c.a(context);
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
        shareModel.a(d2);
        List<SapiAccount> g = c.g();
        if (d2 != null) {
            d2.app = SapiUtils.getAppName(a);
            if (g.size() > 0 && g.contains(d2)) {
                g.set(g.indexOf(d2), g.get(0));
                g.set(0, d2);
            }
        } else {
            Collections.reverse(g);
        }
        shareModel.a().addAll(g);
        shareModel.a().addAll(c.f());
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareModel.a()) {
            if (sapiAccount.getAccountType() == AccountType.INCOMPLETE_USER) {
                arrayList.add(sapiAccount);
            }
        }
        shareModel.a().removeAll(arrayList);
        for (SapiAccount sapiAccount2 : shareModel.a()) {
            sapiAccount2.app = SapiUtils.getAppName(a);
        }
        d.a(a, b, shareModel);
        bundle.putParcelable("LOGIN_SHARE_MODEL", shareModel);
        if (c.r() != null) {
            bundle.putString("RELOGIN_CREDENTIALS", c.a(a, c.r().toString()));
        }
        bundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        bundle.putInt("SDK_VERSION", 93);
        parcel.writeBundle(bundle);
    }
}
