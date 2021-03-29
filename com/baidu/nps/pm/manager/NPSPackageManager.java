package com.baidu.nps.pm.manager;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.BundleInfoGroupManager;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import d.b.z.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class NPSPackageManager {
    public static final String TAG = "NPS-NPSPackageManager";
    public static NPSPackageManager sInstance = new NPSPackageManager();
    public boolean mIsInited = false;
    public Map<String, BundleInfoGroup> mBundleInfoGroupMap = new HashMap();
    public Map<String, BundleInfo> mPresetInfoMap = new HashMap();
    public Set<String> mInstallingSet = new CopyOnWriteArraySet();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IInstallCallback f9298f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f9299g;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0113a extends ContentObserver {
            public C0113a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                d.b.z.h.f a2 = i.a(uri);
                if (a2.f64929b > 0 || a2.f64928a > 0) {
                    a.this.f9298f.onProgress(a2.f64928a, a2.f64929b);
                }
            }
        }

        public a(String str, IInstallCallback iInstallCallback, int i) {
            this.f9297e = str;
            this.f9298f = iInstallCallback;
            this.f9299g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri e2 = i.e(this.f9297e);
            C0113a c0113a = new C0113a(null);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, c0113a);
            int installBundle = NPSPackageManager.this.installBundle(this.f9297e, this.f9299g);
            NPSPackageManager.this.mInstallingSet.remove(this.f9297e);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(c0113a);
            if (this.f9298f != null) {
                if (d.b.z.h.b.a()) {
                    Log.i(NPSPackageManager.TAG, "installBundle, retCode=" + installBundle);
                }
                this.f9298f.onResult(installBundle, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.z.d.a.a f9303f;

        /* loaded from: classes2.dex */
        public class a extends ContentObserver {
            public a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                d.b.z.h.f a2 = i.a(uri);
                if (a2.f64929b > 0 || a2.f64928a > 0) {
                    b.this.f9303f.onProgress(a2.f64928a, a2.f64929b);
                }
            }
        }

        public b(String str, d.b.z.d.a.a aVar) {
            this.f9302e = str;
            this.f9303f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri d2 = i.d(this.f9302e);
            a aVar = new a(null);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d2, false, aVar);
            int downloadBundle = NPSPackageManager.this.downloadBundle(this.f9302e);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
            this.f9303f.onResult(downloadBundle, "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c(NPSPackageManager nPSPackageManager) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.z.f.a.b.h().b();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends ContentObserver {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f9307e;

            public a(Uri uri) {
                this.f9307e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                NPSPackageManager.this.updateBundleInfos(this.f9307e);
            }
        }

        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            d.b.z.c.a.g.a().b().run(new a(uri));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle n = d.b.z.f.a.b.h().n();
            if (n != null && n.getInt(Constant.TAG.RET_CODE, -1) == 13) {
                ArrayList parcelableArrayList = n.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = n.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        NPSPackageManager.this.updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9310e;

        public f(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            this.f9310e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9310e.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9311e;

        public g(CountDownLatch countDownLatch) {
            this.f9311e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NPSPackageManager.this.killProcessesWithPluginsRunning();
            this.f9311e.countDown();
        }
    }

    private void clearDeprecatedBundles() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (BundleInfo bundleInfo : d.b.z.e.a.a().c()) {
            arrayList.add(BundleInfo.toContentValues(bundleInfo));
        }
        bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
        d.b.z.f.a.b.h().a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int downloadBundle(String str) {
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (bundleInfoGroup == null) {
            return 26;
        }
        BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
        if (bundleByType == null) {
            return 3;
        }
        Bundle c2 = d.b.z.f.a.b.h().c(bundleByType);
        if (c2 == null) {
            return 31;
        }
        int i = c2.getInt(Constant.TAG.RET_CODE, -1);
        if (i == 2) {
            ContentValues contentValues = (ContentValues) c2.getParcelable(Constant.TAG.RET_VALUE);
            long j = c2.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i;
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        return d.b.z.f.a.b.h().f(str);
    }

    public static NPSPackageManager getInstance() {
        return sInstance;
    }

    private boolean hasValidDownloadedBundle(String str) {
        BundleInfo bundleInfo;
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleInfo2 = null;
        if (bundleInfoGroup != null) {
            bundleInfo2 = bundleInfoGroup.getBundleByType(2);
            bundleInfo = bundleInfoGroup.getBundleByType(3);
        } else {
            bundleInfo = null;
        }
        if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < d.b.z.e.a.a().b(str)) {
            return false;
        }
        return bundleInfo2.getVersionCode() > (bundleInfo == null ? 0 : bundleInfo.getVersionCode());
    }

    private boolean hasValidInstalledBundle(String str) {
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
        return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < d.b.z.e.a.a().b(str)) ? false : true;
    }

    private boolean hasValidPresetBundle(String str) {
        initIfNeed();
        BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
        if (bundleInfo != null && bundleInfo.getVersionCode() >= d.b.z.e.a.a().b(str)) {
            return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
        }
        return false;
    }

    private void initBundleInfoFromDB(long j) {
        this.mBundleInfoGroupMap = d.b.z.f.a.b.h().e(j);
    }

    private synchronized void initIfNeed() {
        if (!this.mIsInited) {
            init();
        }
    }

    private int initPresetInfo() {
        Bundle i = d.b.z.f.a.b.h().i();
        if (i == null) {
            return 32;
        }
        int i2 = i.getInt(Constant.TAG.RET_CODE, -1);
        ArrayList parcelableArrayList = i.getParcelableArrayList(Constant.TAG.RET_VALUE);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                BundleInfo bundleInfo = BundleInfo.toBundleInfo((ContentValues) ((Parcelable) it.next()));
                this.mPresetInfoMap.put(bundleInfo.getPackageName(), bundleInfo);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int installBundle(String str, int i) {
        BundleInfo bundleInfo = new BundleInfo();
        bundleInfo.setPackageName(str);
        return installBundle(bundleInfo, i);
    }

    private int installBundleOnly(BundleInfo bundleInfo) {
        Bundle k = d.b.z.f.a.b.h().k(bundleInfo);
        if (k == null) {
            return 28;
        }
        int i = k.getInt(Constant.TAG.RET_CODE, -1);
        if (i == 13) {
            ContentValues contentValues = (ContentValues) k.getParcelable(Constant.TAG.RET_VALUE);
            long j = k.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i;
    }

    private void installPreset() {
        d.b.z.c.a.g.a().b().run(new e());
    }

    private boolean isForbidden(String str) {
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (bundleInfoGroup == null) {
            return false;
        }
        BundleInfo bundleByType = bundleInfoGroup.getBundleByType(3);
        if (bundleByType == null || bundleByType.isForbidden()) {
            BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
            if (bundleByType2 == null || bundleByType2.isForbidden()) {
                BundleInfo bundleByType3 = bundleInfoGroup.getBundleByType(1);
                if (bundleByType3 == null || bundleByType3.isForbidden()) {
                    return (bundleByType == null && bundleByType2 == null && bundleByType3 == null) ? false : true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean isValidPackageName(String str) {
        return d.b.z.e.a.a().b(str) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Intent intent = new Intent(d.b.z.h.a.f64926a);
        intent.setPackage(ContextHolder.getApplicationContext().getPackageName());
        ContextHolder.getApplicationContext().sendBroadcast(intent);
    }

    private boolean needForceUpdate(String str) {
        BundleInfo bundleInfo;
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleInfo2 = null;
        if (bundleInfoGroup != null) {
            BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
            bundleInfo2 = bundleInfoGroup.getBundleByType(3);
            bundleInfo = bundleByType;
        } else {
            bundleInfo = null;
        }
        return bundleInfo != null && bundleInfo.needForceUpdate() && bundleInfo.getVersionCode() > (bundleInfo2 == null ? 0 : bundleInfo2.getVersionCode());
    }

    private void registerObsever() {
        d.b.z.f.a.b.h().q(true, new d(new Handler(Looper.getMainLooper())));
    }

    private void sendResartAlert() {
        Application applicationContext = ContextHolder.getApplicationContext();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.b.z.c.a.a.a().c(applicationContext.getString(d.b.z.a.alert_title_force_update), applicationContext.getString(d.b.z.a.alert_msg_force_update), new f(this, countDownLatch), applicationContext.getString(d.b.z.a.alert_force_update_negative_msg), new g(countDownLatch), applicationContext.getString(d.b.z.a.alert_force_update_positive_msg));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateBundleInfo(BundleInfo bundleInfo, long j) {
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(bundleInfo.getPackageName());
        long j2 = 0;
        if (bundleInfoGroup == null) {
            bundleInfoGroup = new BundleInfoGroup(j);
            this.mBundleInfoGroupMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
        } else {
            j2 = bundleInfoGroup.getTimeStamp();
        }
        if (j > j2) {
            bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
        }
    }

    private synchronized void updateBundleInfos(List<BundleInfo> list, long j) {
        for (BundleInfo bundleInfo : list) {
            updateBundleInfo(bundleInfo, j);
        }
    }

    public void downloadAllBundles() {
        d.b.z.c.a.g.a().b().run(new c(this));
    }

    public int fetchBundleInfo() {
        Bundle d2 = d.b.z.f.a.b.h().d();
        if (d2 == null) {
            return 30;
        }
        int i = d2.getInt(Constant.TAG.RET_CODE, -1);
        if (i == 0) {
            ArrayList parcelableArrayList = d2.getParcelableArrayList(Constant.TAG.RET_VALUE);
            long j = d2.getLong("time_stamp");
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                }
            }
        }
        return i;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroup() {
        initIfNeed();
        return this.mBundleInfoGroupMap;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroupForLogSystem() {
        return BundleInfoGroupManager.toBundleInfoGroups(d.b.z.f.a.a.d(ContextHolder.getApplicationContext()).f(), System.currentTimeMillis());
    }

    public BundleInfoGroup getBundleGroup(String str) {
        initIfNeed();
        return this.mBundleInfoGroupMap.get(str);
    }

    public BundleInfo getBundleInfo(String str) {
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (bundleInfoGroup == null) {
            return null;
        }
        return bundleInfoGroup.getBundleByType(3);
    }

    public int getBundleStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=5");
                return 5;
            }
            return 5;
        }
        initIfNeed();
        if (!isValidPackageName(str)) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=15");
                return 15;
            }
            return 15;
        } else if (needForceUpdate(str)) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=44");
            }
            return 44;
        } else if (hasValidInstalledBundle(str)) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=43");
            }
            return 43;
        } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=44");
            }
            return 44;
        } else {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=43");
            }
            return 43;
        }
    }

    public String getPackageNameFromComponent(String str) {
        initIfNeed();
        return d.b.z.e.a.a().d(str);
    }

    public synchronized void init() {
        if (this.mIsInited) {
            return;
        }
        d.b.z.e.a.a().e();
        clearDeprecatedBundles();
        registerObsever();
        initBundleInfoFromDB(System.currentTimeMillis());
        initPresetInfo();
        installPreset();
        this.mIsInited = true;
    }

    public int installBundleForDebug(String str) {
        if (new File(str).exists()) {
            PackageInfo a2 = d.b.z.h.d.a(str, 128);
            if (a2 == null) {
                return 8;
            }
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(a2.packageName);
            bundleInfo.setVersionCode(a2.versionCode);
            bundleInfo.setApkPath(str);
            return installLocalBundle(bundleInfo);
        }
        return 7;
    }

    public int installLocalBundle(BundleInfo bundleInfo) {
        Bundle l = d.b.z.f.a.b.h().l(bundleInfo);
        if (l == null) {
            return 29;
        }
        int i = l.getInt(Constant.TAG.RET_CODE, -1);
        if (i == 13) {
            ContentValues contentValues = (ContentValues) l.getParcelable(Constant.TAG.RET_VALUE);
            long j = l.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i;
    }

    public boolean isBundleRunning(String str) {
        return d.b.z.f.a.b.h().o(str);
    }

    public int prepareBundle(String str) {
        return prepareBundle(str, 0);
    }

    public void recordBundleRunning(String str) {
        d.b.z.f.a.b.h().p(str);
    }

    private int installPreset(BundleInfo bundleInfo) {
        Bundle m = d.b.z.f.a.b.h().m(bundleInfo);
        if (m == null) {
            return 33;
        }
        int i = m.getInt(Constant.TAG.RET_CODE, -1);
        if (i == 13) {
            BundleInfo bundleInfo2 = BundleInfo.toBundleInfo((ContentValues) m.getParcelable(Constant.TAG.RET_VALUE));
            long j = m.getLong("time_stamp");
            if (bundleInfo2 != null) {
                updateBundleInfo(bundleInfo2, j);
            }
        }
        return i;
    }

    public int prepareBundle(String str, int i) {
        int installPreset;
        initIfNeed();
        if (isValidPackageName(str)) {
            if (isForbidden(str)) {
                return 42;
            }
            if (needForceUpdate(str)) {
                return 44;
            }
            if (hasValidPresetBundle(str) || hasValidDownloadedBundle(str) || hasValidInstalledBundle(str)) {
                if (hasValidInstalledBundle(str) || !hasValidPresetBundle(str) || (installPreset = installPreset(this.mPresetInfoMap.get(str))) == 13) {
                    if (hasValidDownloadedBundle(str)) {
                        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
                        if (bundleInfoGroup == null) {
                            return 25;
                        }
                        BundleInfo bundleByType = bundleInfoGroup.getBundleByType(2);
                        if (bundleByType == null) {
                            return hasValidInstalledBundle(str) ? 41 : 23;
                        }
                        int installBundleOnly = installBundleOnly(bundleByType);
                        if (installBundleOnly == 50) {
                            if (bundleByType.needForceUpdate() && (i & 16) == 1) {
                                sendResartAlert();
                                return installBundleOnly;
                            }
                        } else if (installBundleOnly != 13) {
                            return installBundleOnly;
                        }
                    }
                    return hasValidInstalledBundle(str) ? 41 : 45;
                }
                return installPreset;
            }
            return 44;
        }
        return 15;
    }

    private int installBundle(BundleInfo bundleInfo, int i) {
        Bundle j = d.b.z.f.a.b.h().j(bundleInfo);
        if (j == null) {
            return 27;
        }
        int i2 = j.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 13) {
            ContentValues contentValues = (ContentValues) j.getParcelable(Constant.TAG.RET_VALUE);
            long j2 = j.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j2);
            }
        } else if (i2 == 50) {
            int i3 = i & 16;
            if (i3 == 0) {
                return 13;
            }
            BundleInfo bundleByType = getBundleGroup(bundleInfo.getPackageName()).getBundleByType(2);
            if (bundleByType != null && bundleByType.needForceUpdate() && i3 == 1) {
                sendResartAlert();
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBundleInfos(Uri uri) {
        long j;
        if (uri == null) {
            return;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2) {
            return;
        }
        String str = pathSegments.get(0);
        try {
            j = Long.parseLong(pathSegments.get(1));
        } catch (NumberFormatException e2) {
            d.b.z.c.a.f.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
            j = 0L;
        }
        if ("all".equalsIgnoreCase(str)) {
            initBundleInfoFromDB(j);
            return;
        }
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
            this.mBundleInfoGroupMap.put(str, d.b.z.f.a.b.h().g(str, j));
        }
    }

    public void downloadBundle(String str, d.b.z.d.a.a aVar) {
        if (aVar == null) {
            return;
        }
        d.b.z.c.a.g.a().b().run(new b(str, aVar));
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        installBundle(str, 0, iInstallCallback);
    }

    public synchronized void installBundle(String str, int i, IInstallCallback iInstallCallback) {
        if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
            if (d.b.z.h.b.a()) {
                Log.i(TAG, "installBundle, retCode=34");
            }
            iInstallCallback.onResult(34, "");
            return;
        }
        this.mInstallingSet.add(str);
        d.b.z.c.a.g.a().b().run(new a(str, iInstallCallback, i));
    }
}
