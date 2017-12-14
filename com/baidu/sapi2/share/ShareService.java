package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
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
    private static SapiContext c;
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
    @TargetApi(5)
    public int onStartCommand(Intent intent, int i, int i2) {
        d();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d();
        return super.onUnbind(intent);
    }

    private void d() {
        try {
            stopSelf();
        } catch (Exception e) {
            Log.e(e);
        }
    }

    /* loaded from: classes.dex */
    private class a extends Binder {
        private a() {
        }

        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle readBundle;
            ShareModel shareModel;
            if (!c.b(ShareService.this)) {
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
                Log.e(th);
            }
            if (shareModel == null) {
                return true;
            }
            String string = readBundle.getString("IQIYI_TOKEN");
            boolean z = readBundle.getBoolean("EXTRA_OTHER_INFO");
            String string2 = readBundle.getString("FACE_LOGIN_UID");
            if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(SapiContext.getInstance(ShareService.a).getFaceLoginUid())) {
                SapiContext.getInstance(ShareService.a).setFaceLoginUid(string2);
            }
            if (readBundle.getSerializable("RUNTIME_ENVIRONMENT") == null || !(readBundle.getSerializable("RUNTIME_ENVIRONMENT") instanceof Domain) || ((Domain) readBundle.getSerializable("RUNTIME_ENVIRONMENT")) == SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                int i3 = readBundle.getInt("SDK_VERSION");
                if (!z) {
                    c.b(ShareService.a, readBundle.getString("RELOGIN_CREDENTIALS"));
                }
                switch (shareModel.b()) {
                    case VALIDATE:
                        c.a(ShareService.a, ShareService.b, shareModel, i3, string, z);
                        break;
                    case INVALIDATE:
                        c.a(ShareService.a, shareModel);
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
            c = SapiContext.getInstance(context);
            b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            d = true;
        } catch (IllegalStateException e) {
            d = false;
        }
    }

    void a(Parcel parcel) {
        Bundle bundle = new Bundle();
        ShareModel shareModel = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount currentAccount = c.getCurrentAccount();
        shareModel.a(currentAccount);
        List<SapiAccount> loginAccounts = c.getLoginAccounts();
        if (currentAccount != null) {
            currentAccount.app = SapiUtils.getAppName(a);
            if (loginAccounts.size() > 0 && loginAccounts.contains(currentAccount)) {
                loginAccounts.set(loginAccounts.indexOf(currentAccount), loginAccounts.get(0));
                loginAccounts.set(0, currentAccount);
            }
        } else {
            Collections.reverse(loginAccounts);
        }
        shareModel.a().addAll(loginAccounts);
        shareModel.a().addAll(c.getShareAccounts());
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
        c.a(a, b, shareModel);
        bundle.putParcelable("LOGIN_SHARE_MODEL", shareModel);
        if (c.getReloginCredentials() != null) {
            bundle.putString("RELOGIN_CREDENTIALS", b.a(a, c.getReloginCredentials().toString()));
        }
        bundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        bundle.putInt("SDK_VERSION", 127);
        if (SapiContext.getInstance(a).shareLivingunameEnable()) {
            bundle.putString("FACE_LOGIN_UID", SapiContext.getInstance(a).getFaceLoginUid());
        }
        parcel.writeBundle(bundle);
    }
}
