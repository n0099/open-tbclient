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
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static final int a = 5;
    static final String b = "LOGIN_SHARE_MODEL";
    static final String c = "RELOGIN_CREDENTIALS";
    static final String d = "RUNTIME_ENVIRONMENT";
    static final String e = "SDK_VERSION";
    static final String f = "EXTRA_OTHER_INFO";
    static final String g = "IQIYI_TOKEN";
    static final String h = "FACE_LOGIN_UID";
    static final String i = "baidu.intent.action.account.SHARE_SERVICE";
    private static final a l = new a();
    private static SapiConfiguration j = SapiAccountManager.getInstance().getSapiConfiguration();
    private static SapiContext k = SapiContext.getInstance(j.context);

    public static a a() {
        return l;
    }

    private a() {
    }

    public void b() {
        List<Intent> a2 = c.a(j.context);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= a2.size()) {
                break;
            }
            Intent intent = a2.get(i3);
            if (a(intent.getComponent().getPackageName())) {
                arrayList.add(intent);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() != 0) {
            a(null, arrayList, true);
        }
    }

    public void a(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            ShareAccountAccessor.getAccessor().updatePtoken(sapiAccount);
            if (TextUtils.isEmpty(sapiAccount.app)) {
                sapiAccount.app = SapiUtils.getAppName(j.context);
            }
            k.setCurrentAccount(sapiAccount);
            SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
            k.addLoginAccount(sapiAccount);
            k.removeShareAccount(sapiAccount);
            if (j.loginShareStrategy() != LoginShareStrategy.DISABLED && sapiAccount.getAccountType() != AccountType.INCOMPLETE_USER && !e() && !f()) {
                a(sapiAccount, c.a(j.context), false);
            }
        }
    }

    void a(SapiAccount sapiAccount, List<Intent> list, boolean z) {
        HandlerThread handlerThread = new HandlerThread("ValidateThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new AnonymousClass1(list, handler, sapiAccount, z, handlerThread));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ Handler b;
        final /* synthetic */ SapiAccount c;
        final /* synthetic */ boolean d;
        final /* synthetic */ HandlerThread e;

        AnonymousClass1(List list, Handler handler, SapiAccount sapiAccount, boolean z, HandlerThread handlerThread) {
            this.a = list;
            this.b = handler;
            this.c = sapiAccount;
            this.d = z;
            this.e = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isEmpty()) {
                try {
                    a.j.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.1.1
                        @Override // android.content.ServiceConnection
                        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                            AnonymousClass1.this.b.post(new Runnable() { // from class: com.baidu.sapi2.share.a.1.1.1
                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE, AnonymousClass1.this.c, Collections.singletonList(AnonymousClass1.this.c));
                                        if (AnonymousClass1.this.d) {
                                            shareModel = new ShareModel(ShareEvent.VALIDATE);
                                        }
                                        iBinder.transact(0, a.a(shareModel, AnonymousClass1.this.d), Parcel.obtain(), 0);
                                    } catch (Throwable th) {
                                        try {
                                            Log.e(th);
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th3) {
                                                Log.e(th3);
                                            }
                                        }
                                    }
                                    AnonymousClass1.this.a.remove(0);
                                    if (!AnonymousClass1.this.a.isEmpty()) {
                                        AnonymousClass1.this.b.post(this);
                                    } else {
                                        AnonymousClass1.this.e.quit();
                                    }
                                }
                            });
                        }

                        @Override // android.content.ServiceConnection
                        public void onServiceDisconnected(ComponentName componentName) {
                        }
                    }, 1);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null && j.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            k.removeShareAccount(sapiAccount);
            if (!e() && !f()) {
                HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new AnonymousClass2(c.a(j.context), handler, sapiAccount, handlerThread));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.a$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ Handler b;
        final /* synthetic */ SapiAccount c;
        final /* synthetic */ HandlerThread d;

        AnonymousClass2(List list, Handler handler, SapiAccount sapiAccount, HandlerThread handlerThread) {
            this.a = list;
            this.b = handler;
            this.c = sapiAccount;
            this.d = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isEmpty()) {
                try {
                    a.j.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.2.1
                        @Override // android.content.ServiceConnection
                        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                            AnonymousClass2.this.b.post(new Runnable() { // from class: com.baidu.sapi2.share.a.2.1.1
                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        iBinder.transact(0, a.a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(AnonymousClass2.this.c)), false), Parcel.obtain(), 0);
                                    } catch (Throwable th) {
                                        try {
                                            Log.e(th);
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th3) {
                                                Log.e(th3);
                                            }
                                        }
                                    }
                                    AnonymousClass2.this.a.remove(0);
                                    if (!AnonymousClass2.this.a.isEmpty()) {
                                        AnonymousClass2.this.b.post(this);
                                    } else {
                                        AnonymousClass2.this.d.quit();
                                    }
                                }
                            });
                        }

                        @Override // android.content.ServiceConnection
                        public void onServiceDisconnected(ComponentName componentName) {
                        }
                    }, 1);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    public static void c() {
        if (k.isFirstLaunch()) {
            if (j.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                i();
            }
        } else if (!k.isLoginStatusChanged() && j.loginShareStrategy() == LoginShareStrategy.SILENT) {
            i();
        }
    }

    private static void i() {
        if (!f()) {
            HandlerThread handlerThread = new HandlerThread("SyncThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new AnonymousClass3(c.a(j.context), handler, handlerThread));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.a$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass3 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ Handler b;
        final /* synthetic */ HandlerThread c;

        AnonymousClass3(List list, Handler handler, HandlerThread handlerThread) {
            this.a = list;
            this.b = handler;
            this.c = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isEmpty()) {
                try {
                    a.j.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.3.1
                        @Override // android.content.ServiceConnection
                        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                            AnonymousClass3.this.b.post(new Runnable() { // from class: com.baidu.sapi2.share.a.3.1.1
                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        Parcel a = a.a(new ShareModel(ShareEvent.SYNC_REQ), false);
                                        Parcel obtain = Parcel.obtain();
                                        if (iBinder.transact(0, a, obtain, 0)) {
                                            a.b(obtain);
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            Log.e(th);
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.j.context.unbindService(this);
                                            } catch (Throwable th3) {
                                                Log.e(th3);
                                            }
                                        }
                                    }
                                    AnonymousClass3.this.a.remove(0);
                                    if (!AnonymousClass3.this.a.isEmpty() && a.k.getShareAccounts().size() < 5) {
                                        AnonymousClass3.this.b.post(this);
                                    } else {
                                        AnonymousClass3.this.c.quit();
                                    }
                                }
                            });
                        }

                        @Override // android.content.ServiceConnection
                        public void onServiceDisconnected(ComponentName componentName) {
                        }
                    }, 1);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Parcel parcel) {
        if (parcel != null) {
            try {
                Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                c.b(j.context, readBundle.getString(c));
                c.a(j.context, j.loginShareStrategy(), (ShareModel) readBundle.getParcelable(b), readBundle.getInt(e), null, false);
                String string = readBundle.getString(h);
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(SapiContext.getInstance(j.context).getFaceLoginUid())) {
                    SapiContext.getInstance(j.context).setFaceLoginUid(string);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    static Parcel a(ShareModel shareModel, boolean z) {
        Parcel obtain = Parcel.obtain();
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean(f, true);
            bundle.putString(g, SapiContext.getInstance(j.context).getIqiyiAccesstoken());
        } else if (k.getReloginCredentials() != null) {
            bundle.putString(c, b.a(j.context, k.getReloginCredentials().toString()));
        }
        if (SapiContext.getInstance(j.context).shareLivingunameEnable()) {
            bundle.putString(h, SapiContext.getInstance(j.context).getFaceLoginUid());
        }
        c.a(j.context, j.loginShareStrategy(), shareModel);
        bundle.putParcelable(b, shareModel);
        bundle.putSerializable(d, j.environment);
        bundle.putInt(e, 127);
        obtain.writeBundle(bundle);
        return obtain;
    }

    public static boolean d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.baidu.sapi2.demo.standard");
        return arrayList.contains(j.context.getPackageName());
    }

    public static boolean a(String str) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.sapi2.(.*)");
        for (String str2 : arrayList) {
            if (str.matches(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        if (j.enableShare) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        return arrayList.contains(j.context.getPackageName());
    }

    static boolean f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.input_huawei");
        arrayList.add("com.baidu.input_yijia");
        arrayList.add("com.baidu.browser.apps");
        return arrayList.contains(j.context.getPackageName());
    }
}
