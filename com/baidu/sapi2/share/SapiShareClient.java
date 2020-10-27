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
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class SapiShareClient {
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_FACE_LOGIN_MODEL = "FACE_LOGIN_MODEL";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final int MAX_SHARE_ACCOUNTS = 5;
    public static final String SHARE_ACCOUNT_CLOUND_VERSION = "shareV3";
    public static final String SHARE_ACCOUNT_NEW_VERSION = "shareV2";
    static final String c = "LOGIN_SHARE_MODEL";
    static final String d = "RUNTIME_ENVIRONMENT";
    static final String e = "SDK_VERSION";
    static final String f = "EXTRA_OTHER_INFO";
    static final String g = "IQIYI_TOKEN";
    static final String h = "VEHICLE_SYSTEM";
    static final String i = "baidu.intent.action.account.SHARE_SERVICE";
    static final String j = "baidu.intent.action.account.SHARE_ACTIVITY";

    /* renamed from: a  reason: collision with root package name */
    private volatile int f3488a = 0;
    private volatile boolean b = true;
    private static final SapiShareClient m = new SapiShareClient();
    private static SapiConfiguration k = SapiAccountManager.getInstance().getSapiConfiguration();
    private static SapiContext l = SapiContext.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3489a;
        final /* synthetic */ Handler b;
        final /* synthetic */ SapiAccount c;
        final /* synthetic */ boolean d;
        final /* synthetic */ HandlerThread e;

        /* renamed from: com.baidu.sapi2.share.SapiShareClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class ServiceConnectionC0326a implements ServiceConnection {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f3490a;

            /* renamed from: com.baidu.sapi2.share.SapiShareClient$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0327a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ IBinder f3491a;
                final /* synthetic */ ServiceConnection b;

                RunnableC0327a(IBinder iBinder, ServiceConnection serviceConnection) {
                    this.f3491a = iBinder;
                    this.b = serviceConnection;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE, a.this.c, Collections.singletonList(a.this.c));
                        if (a.this.d) {
                            shareModel = new ShareModel(ShareEvent.VALIDATE);
                        }
                        this.f3491a.transact(0, SapiShareClient.a(shareModel, a.this.d), Parcel.obtain(), 0);
                    } catch (Throwable th) {
                        try {
                            Log.e(th);
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th2) {
                                Log.e(th2);
                            }
                        } finally {
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th3) {
                                Log.e(th3);
                            }
                        }
                    }
                    a.this.f3489a.remove(0);
                    if (!a.this.f3489a.isEmpty()) {
                        ServiceConnectionC0326a serviceConnectionC0326a = ServiceConnectionC0326a.this;
                        a.this.b.post(serviceConnectionC0326a.f3490a);
                        return;
                    }
                    a.this.e.quit();
                }
            }

            ServiceConnectionC0326a(Runnable runnable) {
                this.f3490a = runnable;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.b.post(new RunnableC0327a(iBinder, this));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        a(List list, Handler handler, SapiAccount sapiAccount, boolean z, HandlerThread handlerThread) {
            this.f3489a = list;
            this.b = handler;
            this.c = sapiAccount;
            this.d = z;
            this.e = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f3489a.isEmpty()) {
                try {
                    if (!SapiShareClient.k.context.bindService((Intent) this.f3489a.get(0), new ServiceConnectionC0326a(this), 1)) {
                        this.f3489a.remove(0);
                        if (!this.f3489a.isEmpty()) {
                            this.b.post(this);
                        } else {
                            this.e.quit();
                        }
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3492a;
        final /* synthetic */ Handler b;
        final /* synthetic */ SapiAccount c;
        final /* synthetic */ HandlerThread d;

        /* loaded from: classes5.dex */
        class a implements ServiceConnection {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f3493a;

            /* renamed from: com.baidu.sapi2.share.SapiShareClient$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0328a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ IBinder f3494a;
                final /* synthetic */ ServiceConnection b;

                RunnableC0328a(IBinder iBinder, ServiceConnection serviceConnection) {
                    this.f3494a = iBinder;
                    this.b = serviceConnection;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.f3494a.transact(0, SapiShareClient.a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(b.this.c)), false), Parcel.obtain(), 0);
                    } catch (Throwable th) {
                        try {
                            Log.e(th);
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th2) {
                                Log.e(th2);
                            }
                        } finally {
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th3) {
                                Log.e(th3);
                            }
                        }
                    }
                    b.this.f3492a.remove(0);
                    if (!b.this.f3492a.isEmpty()) {
                        a aVar = a.this;
                        b.this.b.post(aVar.f3493a);
                        return;
                    }
                    b.this.d.quit();
                }
            }

            a(Runnable runnable) {
                this.f3493a = runnable;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                b.this.b.post(new RunnableC0328a(iBinder, this));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        b(List list, Handler handler, SapiAccount sapiAccount, HandlerThread handlerThread) {
            this.f3492a = list;
            this.b = handler;
            this.c = sapiAccount;
            this.d = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f3492a.isEmpty()) {
                try {
                    if (!SapiShareClient.k.context.bindService((Intent) this.f3492a.get(0), new a(this), 1)) {
                        this.f3492a.remove(0);
                        if (!this.f3492a.isEmpty()) {
                            this.b.post(this);
                        } else {
                            this.d.quit();
                        }
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3495a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Handler c;
        final /* synthetic */ HandlerThread d;

        /* loaded from: classes5.dex */
        class a implements ServiceConnection {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f3496a;

            /* renamed from: com.baidu.sapi2.share.SapiShareClient$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0329a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ IBinder f3497a;
                final /* synthetic */ ServiceConnection b;

                RunnableC0329a(IBinder iBinder, ServiceConnection serviceConnection) {
                    this.f3497a = iBinder;
                    this.b = serviceConnection;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Parcel a2 = SapiShareClient.a(new ShareModel(ShareEvent.SYNC_REQ), false);
                        Parcel obtain = Parcel.obtain();
                        if (this.f3497a.transact(0, a2, obtain, 0)) {
                            SapiShareClient.b(obtain);
                        }
                        if (c.this.b) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("cuid", SapiUtils.getClientId(SapiShareClient.k.context));
                            hashMap.put(Config.DEVICE_PART, Build.MODEL);
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            if (currentAccount != null) {
                                hashMap.put("isLogin", "true");
                                hashMap.put("uid", currentAccount.uid);
                                hashMap.put(b.c.g, currentAccount.app);
                            } else {
                                hashMap.put("isLogin", "false");
                            }
                            k.a("share_silent_account_success", hashMap);
                        }
                    } catch (Throwable th) {
                        try {
                            Log.e(th);
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th2) {
                                Log.e(th2);
                            }
                        } finally {
                            try {
                                SapiShareClient.k.context.unbindService(this.b);
                            } catch (Throwable th3) {
                                Log.e(th3);
                            }
                        }
                    }
                    c.this.f3495a.remove(0);
                    if (!c.this.f3495a.isEmpty() && SapiShareClient.l.getShareAccounts().size() < 5) {
                        a aVar = a.this;
                        c.this.c.post(aVar.f3496a);
                        return;
                    }
                    c.this.d.quit();
                }
            }

            a(Runnable runnable) {
                this.f3496a = runnable;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.c.post(new RunnableC0329a(iBinder, this));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        c(List list, boolean z, Handler handler, HandlerThread handlerThread) {
            this.f3495a = list;
            this.b = z;
            this.c = handler;
            this.d = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f3495a.isEmpty()) {
                try {
                    if (this.b) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("cuid", SapiUtils.getClientId(SapiShareClient.k.context));
                        hashMap.put(Config.DEVICE_PART, Build.MODEL);
                        hashMap.put("num", this.f3495a.size() + "");
                        k.a("share_silent_account", hashMap);
                    }
                    if (!SapiShareClient.k.context.bindService((Intent) this.f3495a.get(0), new a(this), 1)) {
                        this.f3495a.remove(0);
                        if (!this.f3495a.isEmpty() && SapiShareClient.l.getShareAccounts().size() < 5) {
                            this.c.post(this);
                        } else {
                            this.d.quit();
                        }
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Application.ActivityLifecycleCallbacks {
        d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (SapiShareClient.this.f3488a == 0) {
                if (SapiShareClient.this.b) {
                    SapiShareClient.this.b = false;
                } else {
                    new com.baidu.sapi2.share.b().a(1);
                }
            }
            SapiShareClient.b(SapiShareClient.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            SapiShareClient.c(SapiShareClient.this);
        }
    }

    private SapiShareClient() {
    }

    static /* synthetic */ int c(SapiShareClient sapiShareClient) {
        int i2 = sapiShareClient.f3488a;
        sapiShareClient.f3488a = i2 - 1;
        return i2;
    }

    public static SapiShareClient getInstance() {
        return m;
    }

    public static boolean isInReceiveOtherInfoWhiteList(String str) {
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

    public static boolean isInShareBlackList() {
        if (k.enableShare) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        return arrayList.contains(k.context.getPackageName());
    }

    public static boolean isInShareOtherInfoWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.baidu.sapi2.demo.standard");
        return arrayList.contains(k.context.getPackageName());
    }

    public static boolean isInV2ShareDisableWhiteList() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String str : arrayList) {
            if (k.context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static void sendCloudShareAccountReset() {
        if (!l.isFirstLaunch() || k.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return;
        }
        new com.baidu.sapi2.share.b().a(4);
    }

    public static void syncShareAccounts() {
    }

    public List<ShareStorage.StorageModel> getShareStorageModel(Context context) {
        if (k.loginShareStrategy() != LoginShareStrategy.DISABLED && !com.baidu.sapi2.utils.enums.a.b.equals(k.loginShareDirection())) {
            return e.a();
        }
        return new ArrayList(0);
    }

    @TargetApi(5)
    public void invalidate(SapiAccount sapiAccount) {
        if (sapiAccount != null && !sapiAccount.isGuestAccount() && k.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            l.removeShareAccount(sapiAccount);
            if (!isInShareBlackList() && !c() && !com.baidu.sapi2.utils.enums.a.f3551a.equals(k.loginShareDirection())) {
                HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new b(e.d(k.context), handler, sapiAccount, handlerThread));
            }
        }
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        Application application;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                application = (Application) context;
            } catch (Exception e2) {
                Log.e(e2);
                application = null;
            }
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new d());
            }
        }
    }

    public void validate(SapiAccount sapiAccount) {
        if (SapiAccount.isValidAccount(sapiAccount)) {
            com.baidu.sapi2.share.a.a().d(sapiAccount);
            l.setCurrentAccount(sapiAccount);
            SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
            l.addLoginAccount(sapiAccount);
            new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.h);
            new ShareStorage().a(2);
            l.removeShareAccount(sapiAccount);
            if (k.loginShareStrategy() == LoginShareStrategy.DISABLED || sapiAccount.getAccountType() == AccountType.INCOMPLETE_USER || isInShareBlackList() || c()) {
                return;
            }
            a(sapiAccount, e.d(k.context), false);
        }
    }

    public void validateOtherInfo() {
        List<Intent> d2 = e.d(k.context);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= d2.size()) {
                break;
            }
            Intent intent = d2.get(i3);
            if (isInReceiveOtherInfoWhiteList(intent.getComponent().getPackageName())) {
                arrayList.add(intent);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() == 0) {
            return;
        }
        a(null, arrayList, true);
    }

    static /* synthetic */ int b(SapiShareClient sapiShareClient) {
        int i2 = sapiShareClient.f3488a;
        sapiShareClient.f3488a = i2 + 1;
        return i2;
    }

    static boolean c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.input_huawei");
        arrayList.add("com.baidu.input_yijia");
        arrayList.add("com.baidu.browser.apps");
        return arrayList.contains(k.context.getPackageName());
    }

    @TargetApi(5)
    private static void d() {
        if (!c() && !com.baidu.sapi2.utils.enums.a.b.equals(k.loginShareDirection())) {
            HandlerThread handlerThread = new HandlerThread("SyncThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new c(e.d(k.context), (k.loginShareStrategy() == LoginShareStrategy.DISABLED || k.loginShareStrategy() == LoginShareStrategy.CHOICE) ? false : true, handler, handlerThread));
        }
    }

    @TargetApi(5)
    void a(SapiAccount sapiAccount, List<Intent> list, boolean z) {
        if (!com.baidu.sapi2.utils.enums.a.f3551a.equals(k.loginShareDirection()) && !sapiAccount.isGuestAccount()) {
            HandlerThread handlerThread = new HandlerThread("ValidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new a(list, handler, sapiAccount, z, handlerThread));
        }
    }

    static Parcel a(ShareModel shareModel, boolean z) {
        Parcel obtain = Parcel.obtain();
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean(f, true);
            bundle.putString(g, SapiContext.getInstance().getIqiyiAccesstoken());
        } else if (e.b()) {
            bundle.putBoolean(h, true);
        }
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        SapiConfiguration sapiConfiguration = k;
        e.a(sapiConfiguration.context, sapiConfiguration.loginShareStrategy(), shareModel);
        bundle.putString("PKG", k.context.getPackageName());
        bundle.putParcelable(c, shareModel);
        bundle.putSerializable(d, k.environment);
        bundle.putInt("SDK_VERSION", 249);
        obtain.writeBundle(bundle);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Parcel parcel) {
        if (parcel != null) {
            try {
                Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                if (readBundle != null) {
                    boolean z = readBundle.getBoolean(h, false);
                    String string = readBundle.getString("PKG");
                    e.a(k.context, k.loginShareStrategy(), (ShareModel) readBundle.getParcelable(c), readBundle.getInt("SDK_VERSION"), null, false, z, string);
                    if (SapiContext.getInstance().shareLivingunameEnable()) {
                        ArrayList arrayList = new ArrayList();
                        String string2 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string2));
                        }
                        if (!arrayList.isEmpty()) {
                            new FaceLoginService().syncFaceLoginUidList(k.context, arrayList);
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
