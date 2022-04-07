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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c61;
import com.repackage.j61;
import com.repackage.n61;
import com.repackage.t61;
import com.repackage.u61;
import com.repackage.x61;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleOpProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String METHOD_BUNDLE_CHECK = "check";
    public static final String METHOD_BUNDLE_CLEAR = "cleardeprecated";
    public static final String METHOD_BUNDLE_DOWNLOAD = "download";
    public static final String METHOD_BUNDLE_DOWNLOAD_ALL = "download_all";
    public static final String METHOD_BUNDLE_DOWNLOAD_BACKGROUND = "downloadBackground";
    public static final String METHOD_BUNDLE_FETCH = "fetch";
    public static final String METHOD_BUNDLE_INSTALL = "install";
    public static final String METHOD_BUNDLE_INSTALL_ONLY = "installonly";
    public static final String METHOD_BUNDLE_LOCAL_INSTALL = "localinstall";
    public static final String METHOD_BUNDLE_PRE_INFO = "presetinfo";
    public static final String METHOD_BUNDLE_PRE_INSTALL_ALL = "presetinstallall";
    public static final String METHOD_BUNDLE_PRE_INSTALL_SINGLE = "presetinstallsingle";
    public static final String METHOD_BUNDLE_RECORD = "record";
    public static final String NOTIFY_PKG_ALL = "all";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> mDownloadingLocks;
    public Map<String, Object> mInstallingLocks;
    public boolean mPresetInited;

    public BundleOpProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInstallingLocks = new HashMap();
        this.mDownloadingLocks = new HashMap();
        this.mPresetInited = false;
    }

    private Bundle checkBundleRunning(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                if (n61.d().k(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null))) {
                    bundle2.putInt(Constant.TAG.PARAM_PKG_STUS, 47);
                }
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    private Bundle clearDeprecatedBundles(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            j61.b(getContext()).a();
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    private synchronized Bundle downloadAllBundles() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                List<BundleInfo> c = j61.b(getContext()).c();
                ArrayList<BundleInfo> arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                for (BundleInfo bundleInfo : c) {
                    if (bundleInfo != null) {
                        if (bundleInfo.getType() == 1) {
                            arrayList.add(bundleInfo);
                        } else if (bundleInfo.getType() == 3) {
                            hashSet.add(bundleInfo.getPackageName());
                        }
                    }
                }
                for (BundleInfo bundleInfo2 : arrayList) {
                    if (hashSet.contains(bundleInfo2.getPackageName())) {
                        if (bundleInfo2.getSilenceUpdate() == 1) {
                            downloadBundle(bundleInfo2, 49);
                        }
                    } else if (bundleInfo2.getSilence() == 1) {
                        downloadBundle(bundleInfo2, 49);
                    }
                }
                bundle = new Bundle();
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    private Bundle downloadBackground(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                BundleInfo bundleInfo = contentValues != null ? BundleInfo.toBundleInfo(contentValues) : null;
                if (bundleInfo == null) {
                    bundle2.putInt(Constant.TAG.RET_CODE, 4);
                    return bundle2;
                }
                bundleInfo.setSilenceUpdate(1);
                bundleInfo.setSilence(1);
                j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    private Bundle downloadBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, bundleInfo)) == null) ? downloadBundle(bundleInfo, 48) : (Bundle) invokeL.objValue;
    }

    private Bundle fetchBundleInfo(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleInfo);
            n61.d c = n61.d().c(arrayList);
            int i = c.a;
            if (i == 0) {
                for (IBundleInfo iBundleInfo : c.b) {
                    BundleInfo bundleInfo2 = BundleInfo.toBundleInfo(iBundleInfo);
                    bundleInfo2.setType(1);
                    j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                }
                i = 0;
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            IBundleInfo iBundleInfo2 = c.b.isEmpty() ? null : c.b.get(0);
            if (iBundleInfo2 != null) {
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(iBundleInfo2));
            }
            notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static String getAuth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            return context.getPackageName() + ".bundle";
        }
        return (String) invokeL.objValue;
    }

    private Bundle initPresetBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Map<String, BundleInfo> f = n61.d().f();
            for (String str : f.keySet()) {
                arrayList.add(BundleInfo.toContentValues(f.get(str)));
            }
            bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    private Bundle installBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Bundle fetchBundleInfo = fetchBundleInfo(bundleInfo);
            if (fetchBundleInfo.getInt(Constant.TAG.RET_CODE) != 0) {
                return fetchBundleInfo;
            }
            Cursor d = j61.b(getContext()).d(bundleInfo.getPackageName(), 1);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(d);
            try {
                d.close();
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
        return (Bundle) invokeL.objValue;
    }

    private Bundle installBundleOnly(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            String absolutePath = u61.g(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
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
                } else if (n61.d().k(packageName)) {
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
                        Cursor e = j61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                        int i = 13;
                        if (e.getCount() == 0) {
                            int g = n61.d().g(bundleInfo, file);
                            if (g == 13) {
                                bundleInfo.setType(3);
                                bundleInfo.setAbi(x61.a());
                                j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                            }
                            c61.a().b().recordInstallResult(g, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                            i = g;
                        } else {
                            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(e).get(0)));
                        }
                        try {
                            e.close();
                        } catch (Exception unused) {
                        }
                        bundle.putInt(Constant.TAG.RET_CODE, i);
                        bundle.putLong("time_stamp", currentTimeMillis);
                    }
                    notifyDataChange(bundleInfo.getPackageName(), currentTimeMillis);
                    return bundle;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    private Bundle installLocalBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bundleInfo)) == null) {
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
                Cursor e = j61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                i = 13;
                if (e.getCount() == 0) {
                    int h = n61.d().h(bundleInfo);
                    if (h == 13) {
                        bundleInfo.setType(3);
                        bundleInfo.setAbi(x61.a());
                        bundleInfo.setApkPath("");
                        j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                    }
                    c61.a().b().recordInstallResult(h, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                    i = h;
                } else {
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(e).get(0)));
                }
                try {
                    e.close();
                } catch (Exception unused) {
                }
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    private Bundle installPresetBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, bundleInfo)) == null) {
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
                Cursor e = j61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                i = 13;
                if (e.getCount() == 0) {
                    int j = n61.d().j(bundleInfo);
                    if (j == 13) {
                        bundleInfo.setType(3);
                        bundleInfo.setAbi(x61.a());
                        j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                    }
                    c61.a().b().recordInstallResult(j, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "");
                    i = j;
                } else {
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(e).get(0)));
                }
                try {
                    e.close();
                } catch (Exception unused) {
                }
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            notifyDataChange(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    private synchronized Bundle installPresets() {
        InterceptResult invokeV;
        ArrayList<BundleInfo> arrayList;
        BundleInfo next;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65551, this)) != null) {
            return (Bundle) invokeV.objValue;
        }
        synchronized (this) {
            Bundle bundle = new Bundle();
            arrayList = new ArrayList();
            if (this.mPresetInited) {
                bundle.putInt(Constant.TAG.RET_CODE, 13);
                return bundle;
            }
            Iterator<BundleInfo> it = n61.d().f().values().iterator();
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
        }
        synchronized (this.mInstallingLocks.get(next.getPackageName())) {
            Cursor e = j61.b(getContext()).e(next.getPackageName(), next.getVersionCode(), 3);
            if (e.getCount() == 0) {
                int j = n61.d().j(next);
                if (j == 13) {
                    next.setType(3);
                    next.setAbi(x61.a());
                    j61.b(getContext()).update(null, BundleInfo.toContentValues(next), null, null);
                    arrayList.add(next);
                }
                c61.a().b().recordInstallResult(j, next.getPackageName(), next.getVersionCode(), "");
            } else {
                arrayList.add(BundleInfo.toBundleInfoList(e).get(0));
            }
            try {
                e.close();
            } catch (Exception unused) {
            }
        }
    }

    private void notifyDataChange(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65552, this, str, j) == null) {
            Uri.Builder appendPath = new Uri.Builder().scheme("content").authority(getAuth(ContextHolder.getApplicationContext())).appendPath(str);
            getContext().getContentResolver().notifyChange(appendPath.appendPath(j + "").build(), null);
        }
    }

    private Bundle recordBundleRunning(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                n61.d().m(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null));
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, bundle)) == null) ? call(null, str, str2, bundle) : (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, uri, str, strArr)) == null) ? j61.b(getContext()).delete(uri, str, strArr) : invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, uri, strArr, str, strArr2, str2)) == null) ? j61.b(getContext()).query(uri, strArr, str, strArr2, str2) : (Cursor) invokeLLLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, uri, contentValues, str, strArr)) == null) ? j61.b(getContext()).update(uri, contentValues, str, strArr) : invokeLLLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, THROW, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0127 A[Catch: all -> 0x015f, TryCatch #14 {, blocks: (B:16:0x0036, B:18:0x003b, B:23:0x0061, B:24:0x0064, B:27:0x0068, B:43:0x0085, B:48:0x00ab, B:49:0x00ae, B:52:0x00b2, B:68:0x00cf, B:73:0x00ed, B:74:0x00f0, B:78:0x00ff, B:97:0x0120, B:98:0x0125, B:100:0x0127, B:102:0x0131, B:103:0x0151, B:104:0x0158, B:93:0x0115, B:95:0x011b, B:90:0x0112, B:89:0x010f, B:62:0x00c3, B:61:0x00c0, B:64:0x00c5, B:66:0x00cb, B:37:0x0079, B:36:0x0076, B:39:0x007b, B:41:0x0081), top: B:141:0x0036, inners: #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120 A[Catch: all -> 0x015f, TryCatch #14 {, blocks: (B:16:0x0036, B:18:0x003b, B:23:0x0061, B:24:0x0064, B:27:0x0068, B:43:0x0085, B:48:0x00ab, B:49:0x00ae, B:52:0x00b2, B:68:0x00cf, B:73:0x00ed, B:74:0x00f0, B:78:0x00ff, B:97:0x0120, B:98:0x0125, B:100:0x0127, B:102:0x0131, B:103:0x0151, B:104:0x0158, B:93:0x0115, B:95:0x011b, B:90:0x0112, B:89:0x010f, B:62:0x00c3, B:61:0x00c0, B:64:0x00c5, B:66:0x00cb, B:37:0x0079, B:36:0x0076, B:39:0x007b, B:41:0x0081), top: B:141:0x0036, inners: #9, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle downloadBundle(BundleInfo bundleInfo, int i) {
        InterceptResult invokeLI;
        BundleInfo bundleInfo2;
        Cursor d;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, bundleInfo, i)) == null) {
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
                    e = j61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 2);
                    try {
                    } finally {
                    }
                } catch (Exception e2) {
                    if (t61.a()) {
                        e2.printStackTrace();
                    }
                }
                if (e.getCount() > 0) {
                    bundle.putInt(Constant.TAG.RET_CODE, 2);
                    bundle.putLong("time_stamp", currentTimeMillis);
                    if (e != null) {
                        e.close();
                    }
                    return bundle;
                }
                if (e != null) {
                    e.close();
                }
                try {
                    e = j61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    try {
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } catch (Exception e3) {
                    if (t61.a()) {
                        e3.printStackTrace();
                    }
                }
                if (e.getCount() > 0) {
                    bundle.putInt(Constant.TAG.RET_CODE, 2);
                    bundle.putLong("time_stamp", currentTimeMillis);
                    if (e != null) {
                        e.close();
                    }
                    return bundle;
                }
                if (e != null) {
                    e.close();
                }
                try {
                    d = j61.b(getContext()).d(bundleInfo.getPackageName(), 1);
                    try {
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (d != null) {
                                try {
                                    d.close();
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
                if (d.getCount() == 0) {
                    bundle.putInt(Constant.TAG.RET_CODE, 3);
                    if (d != null) {
                        d.close();
                    }
                    return bundle;
                }
                bundleInfo2 = BundleInfo.toBundleInfoList(d).get(0);
                if (d != null) {
                    try {
                        d.close();
                    } catch (Exception e5) {
                        e = e5;
                        if (t61.a()) {
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
                int b = n61.d().b(bundleInfo2, i);
                if (b == 2) {
                    bundleInfo2.setType(2);
                    j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo2));
                    bundle.putLong("time_stamp", currentTimeMillis);
                }
                notifyDataChange(bundleInfo.getPackageName(), currentTimeMillis);
                bundle.putInt(Constant.TAG.RET_CODE, b);
                return bundle;
            }
        }
        return (Bundle) invokeLI.objValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, bundle)) == null) {
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
                        if (METHOD_BUNDLE_CHECK.equalsIgnoreCase(str2)) {
                            return checkBundleRunning(bundle);
                        }
                        return METHOD_BUNDLE_DOWNLOAD_BACKGROUND.equals(str2) ? downloadBackground(bundle) : bundle2;
                    }
                }
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    private Bundle fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList<IBundleInfo> arrayList2 = new ArrayList();
            n61.d c = n61.d().c(arrayList);
            int i = c.a;
            if (i == 0) {
                for (IBundleInfo iBundleInfo : c.b) {
                    BundleInfo bundleInfo = BundleInfo.toBundleInfo(iBundleInfo);
                    bundleInfo.setType(1);
                    j61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
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
        return (Bundle) invokeV.objValue;
    }
}
