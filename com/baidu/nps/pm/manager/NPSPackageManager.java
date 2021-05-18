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
import com.baidu.nps.utils.SourceData;
import d.a.x.i.j;
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
        public final /* synthetic */ String f8984e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IInstallCallback f8985f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8986g;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0112a extends ContentObserver {
            public C0112a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                d.a.x.i.g a2 = j.a(uri);
                if (a2.f64900b > 0 || a2.f64899a > 0) {
                    a.this.f8985f.onProgress(a2.f64899a, a2.f64900b);
                }
            }
        }

        public a(String str, IInstallCallback iInstallCallback, int i2) {
            this.f8984e = str;
            this.f8985f = iInstallCallback;
            this.f8986g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri e2 = j.e(this.f8984e);
            C0112a c0112a = new C0112a(null);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, c0112a);
            int installBundle = NPSPackageManager.this.installBundle(this.f8984e, this.f8986g);
            NPSPackageManager.this.mInstallingSet.remove(this.f8984e);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(c0112a);
            if (this.f8985f != null) {
                if (d.a.x.i.b.a()) {
                    Log.i(NPSPackageManager.TAG, "installBundle, retCode=" + installBundle);
                }
                this.f8985f.onResult(installBundle, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.x.d.a.a f8989e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8990f;

        /* loaded from: classes2.dex */
        public class a extends ContentObserver {
            public a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                d.a.x.i.g a2 = j.a(uri);
                if (b.this.f8989e != null) {
                    if (a2.f64900b > 0 || a2.f64899a > 0) {
                        b.this.f8989e.onProgress(a2.f64899a, a2.f64900b);
                    }
                }
            }
        }

        public b(d.a.x.d.a.a aVar, String str) {
            this.f8989e = aVar;
            this.f8990f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = null;
            if (this.f8989e != null) {
                Uri d2 = j.d(this.f8990f);
                a aVar2 = new a(null);
                ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d2, false, aVar2);
                aVar = aVar2;
            }
            int downloadBundle = NPSPackageManager.this.downloadBundle(this.f8990f);
            if (aVar != null) {
                ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
            }
            d.a.x.d.a.a aVar3 = this.f8989e;
            if (aVar3 != null) {
                aVar3.onResult(downloadBundle, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8994f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.x.d.a.a f8995g;

        public c(String str, int i2, d.a.x.d.a.a aVar) {
            this.f8993e = str;
            this.f8994f = i2;
            this.f8995g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NPSPackageManager.this.getBundleStatus(this.f8993e) == 44) {
                if (this.f8994f == 0) {
                    d.a.x.g.a.b.i().c(NPSPackageManager.this.getUpdateBundle(this.f8993e));
                    return;
                } else if (!d.a.x.i.d.b(ContextHolder.getApplicationContext())) {
                    d.a.x.g.a.b.i().c(NPSPackageManager.this.getUpdateBundle(this.f8993e));
                    d.a.x.d.a.a aVar = this.f8995g;
                    if (aVar != null) {
                        aVar.onResult(51, NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                    }
                    if (d.a.x.i.b.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                        return;
                    }
                    return;
                } else {
                    NPSPackageManager.this.downloadBundle(this.f8993e, this.f8995g, 48);
                    return;
                }
            }
            d.a.x.d.a.a aVar2 = this.f8995g;
            if (aVar2 != null) {
                aVar2.onResult(3, NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_no_available_msg));
            }
            if (d.a.x.i.b.a()) {
                Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_no_available_msg));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.x.d.a.a f8998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8999g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.x.f.a f9000h;

        /* loaded from: classes2.dex */
        public class a implements d.a.x.f.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BundleInfo f9002a;

            public a(BundleInfo bundleInfo) {
                this.f9002a = bundleInfo;
            }

            @Override // d.a.x.f.b
            public void onResult(int i2) {
                if (i2 == 1) {
                    d dVar = d.this;
                    NPSPackageManager.this.downloadBundle(dVar.f8997e, dVar.f8998f, 48);
                    return;
                }
                d.a.x.g.a.b.i().c(this.f9002a);
                d dVar2 = d.this;
                d.a.x.d.a.a aVar = dVar2.f8998f;
                if (aVar != null) {
                    aVar.onResult(51, NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                }
                if (d.a.x.i.b.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                }
            }
        }

        public d(String str, d.a.x.d.a.a aVar, int i2, d.a.x.f.a aVar2) {
            this.f8997e = str;
            this.f8998f = aVar;
            this.f8999g = i2;
            this.f9000h = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BundleInfo updateBundle = NPSPackageManager.this.getUpdateBundle(this.f8997e);
            if (updateBundle == null) {
                d.a.x.d.a.a aVar = this.f8998f;
                if (aVar != null) {
                    aVar.onResult(3, NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_no_available_msg));
                }
                if (d.a.x.i.b.a()) {
                    Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_no_available_msg));
                }
            } else if (this.f8999g == 1) {
                if (d.a.x.i.d.b(ContextHolder.getApplicationContext())) {
                    NPSPackageManager.this.downloadBundle(this.f8997e);
                } else {
                    this.f9000h.checkAuthorization(updateBundle, 1, new a(updateBundle));
                }
            } else {
                d.a.x.g.a.b.i().c(updateBundle);
                d.a.x.d.a.a aVar2 = this.f8998f;
                if (aVar2 != null) {
                    aVar2.onResult(51, NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                }
                if (d.a.x.i.b.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + NPSPackageManager.this.getDownloadMessage(d.a.x.a.predownload_net_error_msg));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e(NPSPackageManager nPSPackageManager) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.x.g.a.b.i().b();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends ContentObserver {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f9005e;

            public a(Uri uri) {
                this.f9005e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                NPSPackageManager.this.updateBundleInfos(this.f9005e);
            }
        }

        public f(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            d.a.x.c.a.g.a().b().run(new a(uri));
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle o = d.a.x.g.a.b.i().o();
            if (o != null && o.getInt(Constant.TAG.RET_CODE, -1) == 13) {
                ArrayList parcelableArrayList = o.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = o.getLong("time_stamp");
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
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9008e;

        public h(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            this.f9008e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f9008e.countDown();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9009e;

        public i(CountDownLatch countDownLatch) {
            this.f9009e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NPSPackageManager.this.killProcessesWithPluginsRunning();
            this.f9009e.countDown();
        }
    }

    private void clearDeprecatedBundles() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (BundleInfo bundleInfo : d.a.x.e.a.b().d()) {
            arrayList.add(BundleInfo.toContentValues(bundleInfo));
        }
        bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
        d.a.x.g.a.b.i().a(bundle);
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
        Bundle d2 = d.a.x.g.a.b.i().d(bundleByType);
        if (d2 == null) {
            return 31;
        }
        int i2 = d2.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 2) {
            ContentValues contentValues = (ContentValues) d2.getParcelable(Constant.TAG.RET_VALUE);
            long j = d2.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i2;
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        return d.a.x.g.a.b.i().g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadMessage(int i2) {
        try {
            Application applicationContext = ContextHolder.getApplicationContext();
            return applicationContext != null ? applicationContext.getString(i2) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static NPSPackageManager getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BundleInfo getUpdateBundle(String str) {
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (bundleInfoGroup == null) {
            return null;
        }
        return bundleInfoGroup.getBundleByType(1);
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
        if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < d.a.x.e.a.b().c(str)) {
            return false;
        }
        return bundleInfo2.getVersionCode() > (bundleInfo == null ? 0 : bundleInfo.getVersionCode());
    }

    private boolean hasValidInstalledBundle(String str) {
        initIfNeed();
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
        return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < d.a.x.e.a.b().c(str)) ? false : true;
    }

    private boolean hasValidPresetBundle(String str) {
        initIfNeed();
        BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
        if (bundleInfo != null && bundleInfo.getVersionCode() >= d.a.x.e.a.b().c(str)) {
            return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
        }
        return false;
    }

    private void initBundleInfoFromDB(long j) {
        this.mBundleInfoGroupMap = d.a.x.g.a.b.i().f(j);
    }

    private synchronized void initIfNeed() {
        if (!this.mIsInited) {
            init();
        }
    }

    private int initPresetInfo() {
        Bundle j = d.a.x.g.a.b.i().j();
        if (j == null) {
            return 32;
        }
        int i2 = j.getInt(Constant.TAG.RET_CODE, -1);
        ArrayList parcelableArrayList = j.getParcelableArrayList(Constant.TAG.RET_VALUE);
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
    public int installBundle(String str, int i2) {
        BundleInfo bundleInfo = new BundleInfo();
        bundleInfo.setPackageName(str);
        return installBundle(bundleInfo, i2);
    }

    private int installBundleOnly(BundleInfo bundleInfo) {
        Bundle l = d.a.x.g.a.b.i().l(bundleInfo);
        if (l == null) {
            return 28;
        }
        int i2 = l.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 13) {
            ContentValues contentValues = (ContentValues) l.getParcelable(Constant.TAG.RET_VALUE);
            long j = l.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i2;
    }

    private void installPreset() {
        d.a.x.c.a.g.a().b().run(new g());
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
        return d.a.x.e.a.b().c(str) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Intent intent = new Intent(d.a.x.i.a.f64897a);
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
        d.a.x.g.a.b.i().r(true, new f(new Handler(Looper.getMainLooper())));
    }

    private void sendResartAlert() {
        Application applicationContext = ContextHolder.getApplicationContext();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a.x.c.a.a.a().c(applicationContext.getString(d.a.x.a.alert_title_force_update), applicationContext.getString(d.a.x.a.alert_msg_force_update), new h(this, countDownLatch), applicationContext.getString(d.a.x.a.alert_force_update_negative_msg), new i(countDownLatch), applicationContext.getString(d.a.x.a.alert_force_update_positive_msg));
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
        d.a.x.c.a.g.a().b().run(new e(this));
    }

    public void downloadUpdatePackage(String str, d.a.x.d.a.a aVar, d.a.x.f.a aVar2, int i2) {
        d.a.x.c.a.g.a().b().run(new d(str, aVar, i2, aVar2));
    }

    public int fetchBundleInfo() {
        Bundle e2 = d.a.x.g.a.b.i().e();
        if (e2 == null) {
            return 30;
        }
        int i2 = e2.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 0) {
            ArrayList parcelableArrayList = e2.getParcelableArrayList(Constant.TAG.RET_VALUE);
            long j = e2.getLong("time_stamp");
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                }
            }
        }
        return i2;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroup() {
        initIfNeed();
        return this.mBundleInfoGroupMap;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroupForLogSystem() {
        return BundleInfoGroupManager.toBundleInfoGroups(d.a.x.g.a.a.c(ContextHolder.getApplicationContext()).e(), System.currentTimeMillis());
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
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=5");
                return 5;
            }
            return 5;
        }
        initIfNeed();
        if (!isValidPackageName(str)) {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=15");
                return 15;
            }
            return 15;
        } else if (needForceUpdate(str)) {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=44");
            }
            return 44;
        } else if (hasValidInstalledBundle(str)) {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=43");
            }
            return 43;
        } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=44");
            }
            return 44;
        } else {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "getBundleStatus, retCode=43");
            }
            return 43;
        }
    }

    public String getPackageNameFromComponent(String str) {
        initIfNeed();
        return d.a.x.e.a.b().e(str);
    }

    public synchronized void init() {
        if (this.mIsInited) {
            return;
        }
        d.a.x.e.a.b().f();
        clearDeprecatedBundles();
        registerObsever();
        initBundleInfoFromDB(System.currentTimeMillis());
        initPresetInfo();
        installPreset();
        this.mIsInited = true;
    }

    public int installBundleForDebug(String str) {
        if (new File(str).exists()) {
            PackageInfo a2 = d.a.x.i.e.a(str, 128);
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
        Bundle m = d.a.x.g.a.b.i().m(bundleInfo);
        if (m == null) {
            return 29;
        }
        int i2 = m.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 13) {
            ContentValues contentValues = (ContentValues) m.getParcelable(Constant.TAG.RET_VALUE);
            long j = m.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        }
        return i2;
    }

    public boolean isBundleRunning(String str) {
        return d.a.x.g.a.b.i().p(str);
    }

    public void preDownload(String str, d.a.x.d.a.a aVar, int i2, SourceData sourceData) {
        d.a.x.c.a.g.a().b().run(new c(str, i2, aVar));
    }

    public int prepareBundle(String str) {
        return prepareBundle(str, 0);
    }

    public void recordBundleRunning(String str) {
        d.a.x.g.a.b.i().q(str);
    }

    private int installPreset(BundleInfo bundleInfo) {
        Bundle n = d.a.x.g.a.b.i().n(bundleInfo);
        if (n == null) {
            return 33;
        }
        int i2 = n.getInt(Constant.TAG.RET_CODE, -1);
        if (i2 == 13) {
            BundleInfo bundleInfo2 = BundleInfo.toBundleInfo((ContentValues) n.getParcelable(Constant.TAG.RET_VALUE));
            long j = n.getLong("time_stamp");
            if (bundleInfo2 != null) {
                updateBundleInfo(bundleInfo2, j);
            }
        }
        return i2;
    }

    public int prepareBundle(String str, int i2) {
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
                            if (bundleByType.needForceUpdate() && (i2 & 16) == 1) {
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

    private int installBundle(BundleInfo bundleInfo, int i2) {
        Bundle k = d.a.x.g.a.b.i().k(bundleInfo);
        if (k == null) {
            return 27;
        }
        int i3 = k.getInt(Constant.TAG.RET_CODE, -1);
        if (i3 == 13) {
            ContentValues contentValues = (ContentValues) k.getParcelable(Constant.TAG.RET_VALUE);
            long j = k.getLong("time_stamp");
            if (contentValues != null) {
                updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
            }
        } else if (i3 == 50) {
            int i4 = i2 & 16;
            if (i4 == 0) {
                return 13;
            }
            BundleInfo bundleByType = getBundleGroup(bundleInfo.getPackageName()).getBundleByType(2);
            if (bundleByType != null && bundleByType.needForceUpdate() && i4 == 1) {
                sendResartAlert();
            }
        }
        return i3;
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
            d.a.x.c.a.f.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
            j = 0L;
        }
        if ("all".equalsIgnoreCase(str)) {
            initBundleInfoFromDB(j);
            return;
        }
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
            this.mBundleInfoGroupMap.put(str, d.a.x.g.a.b.i().h(str, j));
        }
    }

    public void downloadBundle(String str, d.a.x.d.a.a aVar) {
        if (aVar == null) {
            return;
        }
        downloadBundle(str, aVar, 48);
    }

    public void downloadBundle(String str, d.a.x.d.a.a aVar, int i2) {
        d.a.x.c.a.g.a().b().run(new b(aVar, str));
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        installBundle(str, 0, iInstallCallback);
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback) {
        if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
            if (d.a.x.i.b.a()) {
                Log.i(TAG, "installBundle, retCode=34");
            }
            iInstallCallback.onResult(34, "");
            return;
        }
        this.mInstallingSet.add(str);
        d.a.x.c.a.g.a().b().run(new a(str, iInstallCallback, i2));
    }
}
