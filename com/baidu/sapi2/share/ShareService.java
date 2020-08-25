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
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public final class ShareService extends Service {
    private Context a;
    private LoginShareStrategy b;
    private SapiContext c;
    private boolean d = false;
    private Handler e;

    /* loaded from: classes12.dex */
    static /* synthetic */ class a {
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

    /* loaded from: classes12.dex */
    private class b extends Binder {

        /* loaded from: classes12.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiAccountManager.getReceiveShareListener() != null) {
                    SapiAccountManager.getReceiveShareListener().onReceiveShare();
                }
            }
        }

        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [110=4] */
        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle readBundle;
            ShareModel shareModel;
            if (e.a(ShareService.this)) {
                if (SapiAccountManager.getReceiveShareListener() != null) {
                    if (ShareService.this.e == null) {
                        ShareService.this.e = new Handler(Looper.getMainLooper());
                    }
                    ShareService.this.e.post(new a());
                }
                if (!ShareService.this.d) {
                    ShareService shareService = ShareService.this;
                    shareService.a((Context) shareService);
                }
                if (!ShareService.this.d || ShareService.this.b == LoginShareStrategy.DISABLED) {
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
                if (SapiContext.getInstance().shareLivingunameEnable()) {
                    ArrayList arrayList = new ArrayList();
                    String string2 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                    if (!TextUtils.isEmpty(string2)) {
                        arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string2));
                    }
                    if (!arrayList.isEmpty()) {
                        new FaceLoginService().syncFaceLoginUidList(ShareService.this.a, arrayList);
                    }
                }
                boolean z2 = readBundle.getBoolean("VEHICLE_SYSTEM", false);
                if (readBundle.getSerializable("RUNTIME_ENVIRONMENT") == null || !(readBundle.getSerializable("RUNTIME_ENVIRONMENT") instanceof Domain) || ((Domain) readBundle.getSerializable("RUNTIME_ENVIRONMENT")) == SapiAccountManager.getInstance().getSapiConfiguration().environment) {
                    int i3 = readBundle.getInt(com.baidu.sapi2.share.b.g);
                    String string3 = readBundle.getString("PKG");
                    String loginShareDirection = SapiAccountManager.getInstance().getSapiConfiguration().loginShareDirection();
                    int i4 = a.a[shareModel.a().ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3 && (!com.baidu.sapi2.utils.enums.a.a.equals(loginShareDirection) || !SapiContext.getInstance().getCurrentAccount().isGuestAccount())) {
                                ShareService.this.a(parcel2);
                            }
                        } else if (!com.baidu.sapi2.utils.enums.a.b.equals(loginShareDirection)) {
                            e.a(ShareService.this.a, shareModel);
                        }
                    } else if (!com.baidu.sapi2.utils.enums.a.b.equals(loginShareDirection)) {
                        e.a(ShareService.this.a, ShareService.this.b, shareModel, i3, string, z, z2, string3);
                    }
                    return true;
                }
                return true;
            }
            return false;
        }

        /* synthetic */ b(ShareService shareService, a aVar) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new b(this, null);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.e = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Service
    @TargetApi(5)
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        a();
        return super.onUnbind(intent);
    }

    private void a() {
        try {
            stopSelf();
        } catch (Exception e) {
            Log.e(e);
        }
    }

    void a(Context context) {
        try {
            this.a = context;
            this.c = SapiContext.getInstance();
            this.b = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy();
            this.d = true;
        } catch (IllegalStateException e) {
            this.d = false;
        }
    }

    void a(Parcel parcel) {
        Bundle bundle = new Bundle();
        ShareModel shareModel = new ShareModel(ShareEvent.SYNC_ACK);
        SapiAccount currentAccount = this.c.getCurrentAccount();
        shareModel.a(currentAccount);
        List<SapiAccount> loginAccounts = this.c.getLoginAccounts();
        if (currentAccount != null) {
            currentAccount.app = SapiUtils.getAppName(this.a);
            if (loginAccounts.size() > 0 && loginAccounts.contains(currentAccount)) {
                loginAccounts.set(loginAccounts.indexOf(currentAccount), loginAccounts.get(0));
                loginAccounts.set(0, currentAccount);
            }
        } else {
            Collections.reverse(loginAccounts);
        }
        shareModel.c().addAll(loginAccounts);
        shareModel.c().addAll(this.c.getShareAccounts());
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareModel.c()) {
            if (sapiAccount.getAccountType() == AccountType.INCOMPLETE_USER) {
                arrayList.add(sapiAccount);
            }
        }
        shareModel.c().removeAll(arrayList);
        for (SapiAccount sapiAccount2 : shareModel.c()) {
            sapiAccount2.app = SapiUtils.getAppName(this.a);
        }
        e.a(this.a, this.b, shareModel);
        bundle.putParcelable("LOGIN_SHARE_MODEL", shareModel);
        bundle.putSerializable("RUNTIME_ENVIRONMENT", SapiAccountManager.getInstance().getSapiConfiguration().environment);
        bundle.putInt(com.baidu.sapi2.share.b.g, SapiAccountManager.VERSION_CODE);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        bundle.putString("PKG", getPackageName());
        if (e.b()) {
            bundle.putBoolean("VEHICLE_SYSTEM", true);
        }
        parcel.writeBundle(bundle);
    }
}
