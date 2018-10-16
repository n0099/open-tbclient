package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginModel;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.webkit.internal.ABTestConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    public static final int a = 5;
    static final String b = "LOGIN_SHARE_MODEL";
    static final String c = "RELOGIN_CREDENTIALS";
    static final String d = "RUNTIME_ENVIRONMENT";
    static final String e = "SDK_VERSION";
    static final String f = "EXTRA_OTHER_INFO";
    static final String g = "IQIYI_TOKEN";
    public static final String h = "FACE_LOGIN_UID";
    public static final String i = "FACE_LOGIN_MODEL";
    public static final String j = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String k = "PKG";
    static final String l = "VEHICLE_SYSTEM";
    static final String m = "baidu.intent.action.account.SHARE_SERVICE";
    static final String n = "baidu.intent.action.account.SHARE_ACTIVITY";
    private volatile int o = 0;
    private volatile boolean p = true;
    private static final a s = new a();
    private static SapiConfiguration q = SapiAccountManager.getInstance().getSapiConfiguration();
    private static SapiContext r = SapiContext.getInstance(q.context);

    static /* synthetic */ int a(a aVar) {
        int i2 = aVar.o;
        aVar.o = i2 - 1;
        return i2;
    }

    static /* synthetic */ int d(a aVar) {
        int i2 = aVar.o;
        aVar.o = i2 + 1;
        return i2;
    }

    public static a a() {
        return s;
    }

    private a() {
    }

    public void b() {
        List<Intent> b2 = c.b(q.context);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= b2.size()) {
                break;
            }
            Intent intent = b2.get(i3);
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
            r.setCurrentAccount(sapiAccount);
            SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
            r.addLoginAccount(sapiAccount);
            new ShareStorage().a(false);
            r.removeShareAccount(sapiAccount);
            if (q.loginShareStrategy() != LoginShareStrategy.DISABLED && sapiAccount.getAccountType() != AccountType.INCOMPLETE_USER && !f() && !g()) {
                a(sapiAccount, c.b(q.context), false);
            }
        }
    }

    @TargetApi(5)
    void a(SapiAccount sapiAccount, List<Intent> list, boolean z) {
        if (!com.baidu.sapi2.utils.enums.a.a.equals(q.loginShareDirection()) && !sapiAccount.isGuestAccount()) {
            HandlerThread handlerThread = new HandlerThread("ValidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new AnonymousClass1(list, handler, sapiAccount, z, handlerThread));
        }
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
                    a.q.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.1.1
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
                                                a.q.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.q.context.unbindService(this);
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

    @TargetApi(5)
    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null && !sapiAccount.isGuestAccount() && q.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            r.removeShareAccount(sapiAccount);
            if (!f() && !g() && !com.baidu.sapi2.utils.enums.a.a.equals(q.loginShareDirection())) {
                HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new AnonymousClass2(c.b(q.context), handler, sapiAccount, handlerThread));
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
                    a.q.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.2.1
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
                                                a.q.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.q.context.unbindService(this);
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
        if (r.isFirstLaunch()) {
            if (q.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                j();
            }
        } else if (!r.isLoginStatusChanged() && q.loginShareStrategy() == LoginShareStrategy.SILENT) {
            j();
        }
    }

    @TargetApi(5)
    private static void j() {
        if (!g() && !com.baidu.sapi2.utils.enums.a.b.equals(q.loginShareDirection())) {
            HandlerThread handlerThread = new HandlerThread("SyncThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new AnonymousClass3(c.b(q.context), (q.loginShareStrategy() == LoginShareStrategy.DISABLED || q.loginShareStrategy() == LoginShareStrategy.CHOICE) ? false : true, handler, handlerThread));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.share.a$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass3 implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Handler c;
        final /* synthetic */ HandlerThread d;

        AnonymousClass3(List list, boolean z, Handler handler, HandlerThread handlerThread) {
            this.a = list;
            this.b = z;
            this.c = handler;
            this.d = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isEmpty()) {
                try {
                    if (this.b) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("cuid", SapiUtils.getClientId(a.q.context));
                        hashMap.put(Config.DEVICE_PART, Build.MODEL);
                        hashMap.put("num", this.a.size() + "");
                        StatService.onEvent("share_silent_account", hashMap, false);
                    }
                    a.q.context.bindService((Intent) this.a.get(0), new ServiceConnection() { // from class: com.baidu.sapi2.share.a.3.1
                        @Override // android.content.ServiceConnection
                        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                            AnonymousClass3.this.c.post(new Runnable() { // from class: com.baidu.sapi2.share.a.3.1.1
                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        Parcel a = a.a(new ShareModel(ShareEvent.SYNC_REQ), false);
                                        Parcel obtain = Parcel.obtain();
                                        if (iBinder.transact(0, a, obtain, 0)) {
                                            a.b(obtain);
                                        }
                                        if (AnonymousClass3.this.b) {
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put("cuid", SapiUtils.getClientId(a.q.context));
                                            hashMap2.put(Config.DEVICE_PART, Build.MODEL);
                                            SapiAccount session = SapiAccountManager.getInstance().getSession();
                                            if (session != null) {
                                                hashMap2.put("isLogin", "true");
                                                hashMap2.put("uid", session.uid);
                                                hashMap2.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, session.app);
                                            } else {
                                                hashMap2.put("isLogin", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
                                            }
                                            StatService.onEvent("share_silent_account_success", hashMap2, false);
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            Log.e(th);
                                            try {
                                                a.q.context.unbindService(this);
                                            } catch (Throwable th2) {
                                                Log.e(th2);
                                            }
                                        } finally {
                                            try {
                                                a.q.context.unbindService(this);
                                            } catch (Throwable th3) {
                                                Log.e(th3);
                                            }
                                        }
                                    }
                                    AnonymousClass3.this.a.remove(0);
                                    if (!AnonymousClass3.this.a.isEmpty() && a.r.getShareAccounts().size() < 5) {
                                        AnonymousClass3.this.c.post(this);
                                    } else {
                                        AnonymousClass3.this.d.quit();
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
                if (readBundle != null) {
                    boolean z = readBundle.getBoolean(l, false);
                    String string = readBundle.getString("PKG");
                    c.b(q.context, readBundle.getString(c));
                    c.a(q.context, q.loginShareStrategy(), (ShareModel) readBundle.getParcelable(b), readBundle.getInt("SDK_VERSION"), null, false, z, string);
                    ArrayList arrayList = new ArrayList();
                    String string2 = readBundle.getString("FACE_LOGIN_UID");
                    if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(SapiContext.getInstance(q.context).getFaceLoginUid())) {
                        arrayList.add(new FaceLoginModel.a(string2, 1L));
                    }
                    String string3 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                    if (!TextUtils.isEmpty(string3)) {
                        arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string3));
                    }
                    if (!arrayList.isEmpty()) {
                        new FaceLoginService().syncPriWithShare(arrayList, false);
                    }
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
            bundle.putString(g, SapiContext.getInstance(q.context).getIqiyiAccesstoken());
        } else {
            if (r.getReloginCredentials() != null) {
                bundle.putString(c, b.a(q.context, r.getReloginCredentials().toString()));
            }
            if (c.b()) {
                bundle.putBoolean(l, true);
            }
        }
        if (SapiContext.getInstance(q.context).shareLivingunameEnable()) {
            bundle.putString("FACE_LOGIN_UID", SapiContext.getInstance(q.context).getFaceLoginUid());
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance(q.context).getV2FaceLivingUnames());
        }
        c.a(q.context, q.loginShareStrategy(), shareModel);
        bundle.putString("PKG", q.context.getPackageName());
        bundle.putParcelable(b, shareModel);
        bundle.putSerializable(d, q.environment);
        bundle.putInt("SDK_VERSION", SapiAccountManager.VERSION_CODE);
        obtain.writeBundle(bundle);
        return obtain;
    }

    public static boolean d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.baidu.sapi2.demo.standard");
        return arrayList.contains(q.context.getPackageName());
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
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String str : arrayList) {
            if (q.context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f() {
        if (q.enableShare) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        return arrayList.contains(q.context.getPackageName());
    }

    static boolean g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.input_huawei");
        arrayList.add("com.baidu.input_yijia");
        arrayList.add("com.baidu.browser.apps");
        return arrayList.contains(q.context.getPackageName());
    }

    public List<ShareStorage.StorageModel> a(Context context) {
        return (q.loginShareStrategy() == LoginShareStrategy.DISABLED || com.baidu.sapi2.utils.enums.a.b.equals(q.loginShareDirection())) ? new ArrayList(0) : c.e(context);
    }

    public void b(Context context) {
        if (SapiContext.getInstance(context).getInt(SapiContext.KEY_INIT_SHARE_LOGIN_GRAY, -1) == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            SapiContext.getInstance(context).put(SapiContext.KEY_INIT_SHARE_LOGIN_GRAY, random.nextInt(100));
        }
    }

    public boolean c(Context context) {
        int i2 = SapiContext.getInstance(context).getInt(SapiContext.KEY_INIT_SHARE_LOGIN_GRAY, -1);
        int shareAccountGray = SapiContext.getInstance(context).getShareAccountGray();
        return shareAccountGray == 100 || shareAccountGray > i2;
    }

    public void d(Context context) {
        Application application;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                application = (Application) context;
            } catch (Exception e2) {
                Log.e(e2);
                application = null;
            }
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.sapi2.share.a.4
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        a.a(a.this);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        if (a.this.o == 0) {
                            if (a.this.p) {
                                a.this.p = false;
                            } else {
                                new ShareCallPacking().markLoginState(true);
                            }
                        }
                        a.d(a.this);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }
                });
            }
        }
    }
}
