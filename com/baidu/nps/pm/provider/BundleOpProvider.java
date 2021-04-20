package com.baidu.nps.pm.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import d.b.w.c.a.f;
import d.b.w.f.b.a;
import d.b.w.h.b;
import d.b.w.h.c;
import d.b.w.h.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleOpProvider extends ContentProvider {
    public static final String METHOD_BUNDLE_CHECK = "check";
    public static final String METHOD_BUNDLE_CLEAR = "cleardeprecated";
    public static final String METHOD_BUNDLE_DOWNLOAD = "download";
    public static final String METHOD_BUNDLE_DOWNLOAD_ALL = "download_all";
    public static final String METHOD_BUNDLE_FETCH = "fetch";
    public static final String METHOD_BUNDLE_INSTALL = "install";
    public static final String METHOD_BUNDLE_INSTALL_ONLY = "installonly";
    public static final String METHOD_BUNDLE_LOCAL_INSTALL = "localinstall";
    public static final String METHOD_BUNDLE_PRE_INFO = "presetinfo";
    public static final String METHOD_BUNDLE_PRE_INSTALL_ALL = "presetinstallall";
    public static final String METHOD_BUNDLE_PRE_INSTALL_SINGLE = "presetinstallsingle";
    public static final String METHOD_BUNDLE_RECORD = "record";
    public static final String NOTIFY_PKG_ALL = "all";
    public Map<String, Object> mInstallingLocks = new HashMap();
    public Map<String, Object> mDownloadingLocks = new HashMap();
    public boolean mPresetInited = false;

    private Bundle checkBundleRunning(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            if (a.c().j(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null))) {
                bundle2.putInt(Constant.TAG.PARAM_PKG_STUS, 47);
            }
        }
        return bundle2;
    }

    private Bundle clearDeprecatedBundles(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Constant.TAG.PARAM_VALUE);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                BundleInfo bundleInfo = BundleInfo.toBundleInfo((ContentValues) it.next());
                d.b.w.f.a.a.d(getContext()).b(bundleInfo.getPackageName(), bundleInfo.getMinVersion());
            }
        }
        d.b.w.f.a.a.d(getContext()).c();
        return bundle2;
    }

    private synchronized Bundle downloadAllBundles() {
        Cursor g2 = d.b.w.f.a.a.d(getContext()).g(1);
        List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(g2);
        try {
            g2.close();
        } catch (Exception unused) {
        }
        for (BundleInfo bundleInfo : bundleInfoList) {
            downloadBundle(bundleInfo, 49);
        }
        return new Bundle();
    }

    private Bundle downloadBundle(BundleInfo bundleInfo) {
        return downloadBundle(bundleInfo, 48);
    }

    private Bundle fetchBundleInfo(BundleInfo bundleInfo) {
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bundleInfo);
        a.d b2 = a.c().b(arrayList);
        int i = b2.f65579a;
        if (i == 0) {
            for (IBundleInfo iBundleInfo : b2.f65580b) {
                BundleInfo bundleInfo2 = BundleInfo.toBundleInfo(iBundleInfo);
                bundleInfo2.setType(1);
                d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo2), null, null);
            }
            i = 0;
        }
        bundle.putInt(Constant.TAG.RET_CODE, i);
        IBundleInfo iBundleInfo2 = b2.f65580b.isEmpty() ? null : b2.f65580b.get(0);
        if (iBundleInfo2 != null) {
            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(iBundleInfo2));
        }
        notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
        return bundle;
    }

    public static String getAuth(Context context) {
        return context.getPackageName() + ".bundle";
    }

    private Bundle initPresetBundleInfo() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Map<String, BundleInfo> e2 = a.c().e();
        for (String str : e2.keySet()) {
            arrayList.add(BundleInfo.toContentValues(e2.get(str)));
        }
        bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList);
        return bundle;
    }

    private Bundle installBundle(BundleInfo bundleInfo) {
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        Bundle fetchBundleInfo = fetchBundleInfo(bundleInfo);
        if (fetchBundleInfo.getInt(Constant.TAG.RET_CODE) != 0) {
            return fetchBundleInfo;
        }
        Cursor h2 = d.b.w.f.a.a.d(getContext()).h(bundleInfo.getPackageName(), 1);
        List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(h2);
        try {
            h2.close();
        } catch (Exception unused) {
        }
        if (!bundleInfoList.isEmpty()) {
            Bundle downloadBundle = downloadBundle(bundleInfoList.get(0));
            if (downloadBundle.getInt(Constant.TAG.RET_CODE) != 2) {
                return downloadBundle;
            }
            fetchBundleInfo = installBundleOnly(bundleInfoList.get(0));
        } else {
            fetchBundleInfo.putInt(Constant.TAG.RET_CODE, 3);
        }
        notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
        return fetchBundleInfo;
    }

    private Bundle installBundleOnly(BundleInfo bundleInfo) {
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        Application applicationContext = ContextHolder.getApplicationContext();
        String absolutePath = c.g(applicationContext, bundleInfo.getPackageName() + ".apk").getAbsolutePath();
        String packageName = bundleInfo.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            bundle.putInt(Constant.TAG.RET_CODE, 5);
            return bundle;
        } else if (TextUtils.isEmpty(absolutePath)) {
            bundle.putInt(Constant.TAG.RET_CODE, 6);
            return bundle;
        } else {
            File file = new File(absolutePath);
            if (!file.exists()) {
                bundle.putInt(Constant.TAG.RET_CODE, 7);
                return bundle;
            } else if (a.c().j(packageName)) {
                bundle.putInt(Constant.TAG.RET_CODE, 50);
                return bundle;
            } else {
                synchronized (this) {
                    if (!this.mInstallingLocks.containsKey(packageName)) {
                        this.mInstallingLocks.put(packageName, new Object());
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.mInstallingLocks.get(packageName)) {
                    Cursor i = d.b.w.f.a.a.d(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    int i2 = 13;
                    if (i.getCount() == 0) {
                        int f2 = a.c().f(bundleInfo, file);
                        if (f2 == 13) {
                            bundleInfo.setType(3);
                            bundleInfo.setAbi(e.a());
                            d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo), null, null);
                            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                        }
                        f.a().b().recordInstallResult(f2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                        i2 = f2;
                    } else {
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i).get(0)));
                    }
                    try {
                        i.close();
                    } catch (Exception unused) {
                    }
                    bundle.putInt(Constant.TAG.RET_CODE, i2);
                    bundle.putLong("time_stamp", currentTimeMillis);
                }
                notifyDataChange(bundleInfo.getPackageName(), currentTimeMillis);
                return bundle;
            }
        }
    }

    private Bundle installLocalBundle(BundleInfo bundleInfo) {
        int i;
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        synchronized (this) {
            if (!this.mInstallingLocks.containsKey(bundleInfo.getPackageName())) {
                this.mInstallingLocks.put(bundleInfo.getPackageName(), new Object());
            }
        }
        synchronized (this.mInstallingLocks.get(bundleInfo.getPackageName())) {
            Cursor i2 = d.b.w.f.a.a.d(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
            i = 13;
            if (i2.getCount() == 0) {
                int g2 = a.c().g(bundleInfo);
                if (g2 == 13) {
                    bundleInfo.setType(3);
                    bundleInfo.setAbi(e.a());
                    bundleInfo.setApkPath("");
                    d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo), null, null);
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                }
                f.a().b().recordInstallResult(g2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                i = g2;
            } else {
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i2).get(0)));
            }
            try {
                i2.close();
            } catch (Exception unused) {
            }
        }
        bundle.putInt(Constant.TAG.RET_CODE, i);
        notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
        return bundle;
    }

    private Bundle installPresetBundle(BundleInfo bundleInfo) {
        int i;
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        synchronized (this) {
            if (!this.mInstallingLocks.containsKey(bundleInfo.getPackageName())) {
                this.mInstallingLocks.put(bundleInfo.getPackageName(), new Object());
            }
        }
        synchronized (this.mInstallingLocks.get(bundleInfo.getPackageName())) {
            Cursor i2 = d.b.w.f.a.a.d(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
            i = 13;
            if (i2.getCount() == 0) {
                int i3 = a.c().i(bundleInfo);
                if (i3 == 13) {
                    bundleInfo.setType(3);
                    bundleInfo.setAbi(e.a());
                    d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo), null, null);
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                }
                f.a().b().recordInstallResult(i3, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                i = i3;
            } else {
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i2).get(0)));
            }
            try {
                i2.close();
            } catch (Exception unused) {
            }
        }
        bundle.putInt(Constant.TAG.RET_CODE, i);
        notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
        return bundle;
    }

    private synchronized Bundle installPresets() {
        ArrayList<BundleInfo> arrayList;
        BundleInfo next;
        Bundle bundle = new Bundle();
        arrayList = new ArrayList();
        if (this.mPresetInited) {
            bundle.putInt(Constant.TAG.RET_CODE, 13);
            return bundle;
        }
        Iterator<BundleInfo> it = a.c().e().values().iterator();
        while (it.hasNext()) {
            next = it.next();
            synchronized (this) {
                if (!this.mInstallingLocks.containsKey(next.getPackageName())) {
                    this.mInstallingLocks.put(next.getPackageName(), new Object());
                }
            }
        }
        bundle.putInt(Constant.TAG.RET_CODE, 13);
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        for (BundleInfo bundleInfo : arrayList) {
            arrayList2.add(BundleInfo.toContentValues(bundleInfo));
        }
        bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList2);
        bundle.putLong("time_stamp", System.currentTimeMillis());
        this.mPresetInited = true;
        return bundle;
        synchronized (this.mInstallingLocks.get(next.getPackageName())) {
            Cursor i = d.b.w.f.a.a.d(getContext()).i(next.getPackageName(), next.getVersionCode(), 3);
            if (i.getCount() == 0) {
                int i2 = a.c().i(next);
                if (i2 == 13) {
                    next.setType(3);
                    next.setAbi(e.a());
                    d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(next), null, null);
                    arrayList.add(next);
                }
                f.a().b().recordInstallResult(i2, next.getPackageName(), next.getVersionCode(), "");
            } else {
                arrayList.add(BundleInfo.toBundleInfoList(i).get(0));
            }
            try {
                i.close();
            } catch (Exception unused) {
            }
        }
    }

    private void notifyDataChange(String str, long j) {
        Uri.Builder appendPath = new Uri.Builder().scheme("content").authority(getAuth(ContextHolder.getApplicationContext())).appendPath(str);
        getContext().getContentResolver().notifyChange(appendPath.appendPath(j + "").build(), null);
    }

    private Bundle recordBundleRunning(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            a.c().l(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null));
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return call(null, str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return d.b.w.f.a.a.d(getContext()).a(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return d.b.w.f.a.a.d(getContext()).e(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return d.b.w.f.a.a.d(getContext()).k(uri, contentValues, str, strArr);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, THROW, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011e A[Catch: all -> 0x015e, TryCatch #13 {, blocks: (B:14:0x0032, B:16:0x0037, B:21:0x005e, B:22:0x0061, B:25:0x0065, B:41:0x0082, B:46:0x00a9, B:47:0x00ac, B:50:0x00b0, B:66:0x00cd, B:71:0x00eb, B:72:0x00ee, B:76:0x00fd, B:95:0x011e, B:96:0x0123, B:98:0x0125, B:100:0x012f, B:101:0x0150, B:102:0x0157, B:91:0x0113, B:93:0x0119, B:88:0x0110, B:87:0x010d, B:60:0x00c1, B:59:0x00be, B:62:0x00c3, B:64:0x00c9, B:35:0x0076, B:34:0x0073, B:37:0x0078, B:39:0x007e), top: B:133:0x0032, inners: #4, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125 A[Catch: all -> 0x015e, TryCatch #13 {, blocks: (B:14:0x0032, B:16:0x0037, B:21:0x005e, B:22:0x0061, B:25:0x0065, B:41:0x0082, B:46:0x00a9, B:47:0x00ac, B:50:0x00b0, B:66:0x00cd, B:71:0x00eb, B:72:0x00ee, B:76:0x00fd, B:95:0x011e, B:96:0x0123, B:98:0x0125, B:100:0x012f, B:101:0x0150, B:102:0x0157, B:91:0x0113, B:93:0x0119, B:88:0x0110, B:87:0x010d, B:60:0x00c1, B:59:0x00be, B:62:0x00c3, B:64:0x00c9, B:35:0x0076, B:34:0x0073, B:37:0x0078, B:39:0x007e), top: B:133:0x0032, inners: #4, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle downloadBundle(BundleInfo bundleInfo, int i) {
        BundleInfo bundleInfo2;
        Cursor h2;
        Cursor i2;
        Bundle bundle = new Bundle();
        if (bundleInfo == null) {
            bundle.putInt(Constant.TAG.RET_CODE, 4);
            return bundle;
        }
        synchronized (this.mDownloadingLocks) {
            if (!this.mDownloadingLocks.containsKey(bundleInfo.getPackageName())) {
                this.mDownloadingLocks.put(bundleInfo.getPackageName(), bundleInfo);
            }
        }
        synchronized (this.mDownloadingLocks.get(bundleInfo.getPackageName())) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                i2 = d.b.w.f.a.a.d(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 2);
                try {
                } finally {
                }
            } catch (Exception e2) {
                if (b.a()) {
                    e2.printStackTrace();
                }
            }
            if (i2.getCount() > 0) {
                bundle.putInt(Constant.TAG.RET_CODE, 2);
                bundle.putLong("time_stamp", currentTimeMillis);
                if (i2 != null) {
                    i2.close();
                }
                return bundle;
            }
            if (i2 != null) {
                i2.close();
            }
            try {
                i2 = d.b.w.f.a.a.d(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                try {
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception e3) {
                if (b.a()) {
                    e3.printStackTrace();
                }
            }
            if (i2.getCount() > 0) {
                bundle.putInt(Constant.TAG.RET_CODE, 2);
                bundle.putLong("time_stamp", currentTimeMillis);
                if (i2 != null) {
                    i2.close();
                }
                return bundle;
            }
            if (i2 != null) {
                i2.close();
            }
            try {
                h2 = d.b.w.f.a.a.d(getContext()).h(bundleInfo.getPackageName(), 1);
                try {
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (h2 != null) {
                            try {
                                h2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bundleInfo2 = null;
            }
            if (h2.getCount() == 0) {
                bundle.putInt(Constant.TAG.RET_CODE, 3);
                if (h2 != null) {
                    h2.close();
                }
                return bundle;
            }
            bundleInfo2 = BundleInfo.toBundleInfoList(h2).get(0);
            if (h2 != null) {
                try {
                    h2.close();
                } catch (Exception e5) {
                    e = e5;
                    if (b.a()) {
                        e.printStackTrace();
                    }
                    if (bundleInfo2 != null) {
                    }
                }
            }
            if (bundleInfo2 != null) {
                bundle.putInt(Constant.TAG.RET_CODE, 3);
                return bundle;
            }
            int a2 = a.c().a(bundleInfo2, i);
            if (a2 == 2) {
                bundleInfo2.setType(2);
                d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo2));
                bundle.putLong("time_stamp", currentTimeMillis);
            }
            notifyDataChange(bundleInfo.getPackageName(), currentTimeMillis);
            bundle.putInt(Constant.TAG.RET_CODE, a2);
            return bundle;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (METHOD_BUNDLE_INSTALL_ONLY.equalsIgnoreCase(str2)) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
            return installBundleOnly(contentValues != null ? BundleInfo.toBundleInfo(contentValues) : null);
        } else if ("install".equalsIgnoreCase(str2)) {
            ContentValues contentValues2 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
            return installBundle(contentValues2 != null ? BundleInfo.toBundleInfo(contentValues2) : null);
        } else if (METHOD_BUNDLE_PRE_INSTALL_ALL.equalsIgnoreCase(str2)) {
            return installPresets();
        } else {
            if (METHOD_BUNDLE_PRE_INSTALL_SINGLE.equalsIgnoreCase(str2)) {
                ContentValues contentValues3 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                return installPresetBundle(contentValues3 != null ? BundleInfo.toBundleInfo(contentValues3) : null);
            } else if (METHOD_BUNDLE_LOCAL_INSTALL.equalsIgnoreCase(str2)) {
                ContentValues contentValues4 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                return installLocalBundle(contentValues4 != null ? BundleInfo.toBundleInfo(contentValues4) : null);
            } else if (METHOD_BUNDLE_PRE_INFO.equalsIgnoreCase(str2)) {
                return initPresetBundleInfo();
            } else {
                if ("download".equalsIgnoreCase(str2)) {
                    ContentValues contentValues5 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                    return downloadBundle(contentValues5 != null ? BundleInfo.toBundleInfo(contentValues5) : null);
                } else if (METHOD_BUNDLE_DOWNLOAD_ALL.equalsIgnoreCase(str2)) {
                    return downloadAllBundles();
                } else {
                    if (METHOD_BUNDLE_FETCH.equalsIgnoreCase(str2)) {
                        return fetchBundleInfo();
                    }
                    if (METHOD_BUNDLE_CLEAR.equalsIgnoreCase(str2)) {
                        return clearDeprecatedBundles(bundle);
                    }
                    if (METHOD_BUNDLE_RECORD.equalsIgnoreCase(str2)) {
                        return recordBundleRunning(bundle);
                    }
                    return METHOD_BUNDLE_CHECK.equalsIgnoreCase(str2) ? checkBundleRunning(bundle) : bundle2;
                }
            }
        }
    }

    private Bundle fetchBundleInfo() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        ArrayList<IBundleInfo> arrayList2 = new ArrayList();
        a.d b2 = a.c().b(arrayList);
        int i = b2.f65579a;
        if (i == 0) {
            for (IBundleInfo iBundleInfo : b2.f65580b) {
                BundleInfo bundleInfo = BundleInfo.toBundleInfo(iBundleInfo);
                bundleInfo.setType(1);
                d.b.w.f.a.a.d(getContext()).k(null, BundleInfo.toContentValues(bundleInfo), null, null);
                arrayList2.add(bundleInfo);
            }
            i = 0;
        }
        bundle.putInt(Constant.TAG.RET_CODE, i);
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        for (IBundleInfo iBundleInfo2 : arrayList2) {
            arrayList3.add(BundleInfo.toContentValues(iBundleInfo2));
        }
        bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList3);
        long currentTimeMillis = System.currentTimeMillis();
        bundle.putLong("time_stamp", currentTimeMillis);
        notifyDataChange("all", currentTimeMillis);
        return bundle;
    }
}
