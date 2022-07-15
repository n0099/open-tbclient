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
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d61;
import com.repackage.h61;
import com.repackage.q61;
import com.repackage.r61;
import com.repackage.u61;
import com.repackage.w51;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleOpProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;
    public Map<String, Object> b;
    public boolean c;

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
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = false;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return context.getPackageName() + ".bundle";
        }
        return (String) invokeL.objValue;
    }

    public final Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                if (h61.h().q(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null))) {
                    bundle2.putInt(Constant.TAG.PARAM_PKG_STUS, 47);
                }
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle b(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            d61.b(getContext()).a();
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final void c(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) ? call(null, str, str2, bundle) : (Bundle) invokeLLL.objValue;
    }

    public final synchronized Bundle d() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                List<BundleInfo> c = d61.b(getContext()).c();
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
                            g(bundleInfo2, 49);
                        }
                    } else if (bundleInfo2.getSilence() == 1) {
                        g(bundleInfo2, 49);
                    }
                }
                bundle = new Bundle();
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, uri, str, strArr)) == null) ? d61.b(getContext()).delete(uri, str, strArr) : invokeLLL.intValue;
    }

    public final Bundle e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
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
                d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle f(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundleInfo)) == null) ? g(bundleInfo, 48) : (Bundle) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[Catch: Exception -> 0x00d4, all -> 0x016f, TRY_LEAVE, TryCatch #3 {Exception -> 0x00d4, blocks: (B:47:0x00bb, B:49:0x00c1), top: B:122:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fc A[Catch: Exception -> 0x0115, all -> 0x0169, TRY_LEAVE, TryCatch #0 {all -> 0x0169, blocks: (B:66:0x00f6, B:68:0x00fc, B:72:0x0106, B:81:0x011b, B:83:0x0121), top: B:118:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106 A[Catch: Exception -> 0x0115, all -> 0x0169, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0169, blocks: (B:66:0x00f6, B:68:0x00fc, B:72:0x0106, B:81:0x011b, B:83:0x0121), top: B:118:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012a A[Catch: all -> 0x017b, TryCatch #12 {, blocks: (B:24:0x0062, B:30:0x008c, B:31:0x008f, B:33:0x0091, B:50:0x00cb, B:51:0x00ce, B:53:0x00d0, B:69:0x0101, B:70:0x0104, B:73:0x0111, B:86:0x012a, B:87:0x012f, B:89:0x0131, B:91:0x013b, B:92:0x015b, B:93:0x0162, B:84:0x0124, B:98:0x016b, B:99:0x016e, B:102:0x0171, B:103:0x0174, B:106:0x0177, B:107:0x017a), top: B:126:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0131 A[Catch: all -> 0x017b, TryCatch #12 {, blocks: (B:24:0x0062, B:30:0x008c, B:31:0x008f, B:33:0x0091, B:50:0x00cb, B:51:0x00ce, B:53:0x00d0, B:69:0x0101, B:70:0x0104, B:73:0x0111, B:86:0x012a, B:87:0x012f, B:89:0x0131, B:91:0x013b, B:92:0x015b, B:93:0x0162, B:84:0x0124, B:98:0x016b, B:99:0x016e, B:102:0x0171, B:103:0x0174, B:106:0x0177, B:107:0x017a), top: B:126:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle g(BundleInfo bundleInfo, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        BundleInfo bundleInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, bundleInfo, i)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            BundleInfo bundleInfo3 = h61.h().j().get(bundleInfo.getPackageName());
            if (bundleInfo3 != null && bundleInfo.getVersionCode() != 0 && bundleInfo3.getVersionCode() >= bundleInfo.getVersionCode()) {
                bundle.putInt(Constant.TAG.RET_CODE, 55);
                return bundle;
            }
            synchronized (this.b) {
                if (!this.b.containsKey(bundleInfo.getPackageName())) {
                    this.b.put(bundleInfo.getPackageName(), bundleInfo);
                }
            }
            synchronized (this.b.get(bundleInfo.getPackageName())) {
                long currentTimeMillis = System.currentTimeMillis();
                Closeable closeable = null;
                try {
                    cursor = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 2);
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                bundle.putInt(Constant.TAG.RET_CODE, 2);
                                bundle.putLong("time_stamp", currentTimeMillis);
                                c(cursor);
                                return bundle;
                            }
                        } catch (Exception e) {
                            e = e;
                            if (q61.a()) {
                                e.printStackTrace();
                            }
                            c(cursor);
                            cursor2 = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                            try {
                                try {
                                    try {
                                        try {
                                            if (cursor2.getCount() > 0) {
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            if (q61.a()) {
                                                e.printStackTrace();
                                            }
                                            c(cursor2);
                                            cursor3 = d61.b(getContext()).d(bundleInfo.getPackageName(), 1);
                                            if (cursor3.getCount() == 0) {
                                            }
                                        }
                                        if (cursor3.getCount() == 0) {
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        if (q61.a()) {
                                            e.printStackTrace();
                                        }
                                        c(cursor3);
                                        bundleInfo2 = null;
                                        if (bundleInfo2 != null) {
                                        }
                                    }
                                    cursor3 = d61.b(getContext()).d(bundleInfo.getPackageName(), 1);
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = cursor2;
                                    c(closeable);
                                    throw th;
                                }
                                c(cursor2);
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = cursor2;
                                c(closeable);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = cursor;
                        c(closeable);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th4) {
                    th = th4;
                    c(closeable);
                    throw th;
                }
                c(cursor);
                try {
                    cursor2 = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    if (cursor2.getCount() > 0) {
                        bundle.putInt(Constant.TAG.RET_CODE, 2);
                        bundle.putLong("time_stamp", currentTimeMillis);
                        c(cursor2);
                        return bundle;
                    }
                } catch (Exception e5) {
                    e = e5;
                    cursor2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    c(closeable);
                    throw th;
                }
                c(cursor2);
                try {
                    cursor3 = d61.b(getContext()).d(bundleInfo.getPackageName(), 1);
                } catch (Exception e6) {
                    e = e6;
                    cursor3 = null;
                } catch (Throwable th6) {
                    th = th6;
                    c(closeable);
                    throw th;
                }
                if (cursor3.getCount() == 0) {
                    bundle.putInt(Constant.TAG.RET_CODE, 3);
                    c(cursor3);
                    return bundle;
                }
                bundleInfo2 = BundleInfo.toBundleInfoList(cursor3).get(0);
                c(cursor3);
                if (bundleInfo2 != null) {
                    bundle.putInt(Constant.TAG.RET_CODE, 3);
                    return bundle;
                }
                int e7 = h61.h().e(bundleInfo2, i);
                if (e7 == 2) {
                    bundleInfo2.setType(2);
                    d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo2));
                    bundle.putLong("time_stamp", currentTimeMillis);
                }
                q(bundleInfo.getPackageName(), currentTimeMillis);
                bundle.putInt(Constant.TAG.RET_CODE, e7);
                return bundle;
            }
        }
        return (Bundle) invokeLI.objValue;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final Bundle h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList<IBundleInfo> arrayList2 = new ArrayList();
            h61.d g = h61.h().g(arrayList);
            int i = g.a;
            if (i == 0) {
                for (IBundleInfo iBundleInfo : g.b) {
                    BundleInfo bundleInfo = BundleInfo.toBundleInfo(iBundleInfo);
                    bundleInfo.setType(1);
                    d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
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
            q("all", currentTimeMillis);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public final Bundle i(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleInfo);
            h61.d g = h61.h().g(arrayList);
            int i = g.a;
            if (i == 0) {
                for (IBundleInfo iBundleInfo : g.b) {
                    BundleInfo bundleInfo2 = BundleInfo.toBundleInfo(iBundleInfo);
                    bundleInfo2.setType(1);
                    d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                }
                i = 0;
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            IBundleInfo iBundleInfo2 = g.b.isEmpty() ? null : g.b.get(0);
            if (iBundleInfo2 != null) {
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(iBundleInfo2));
            }
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    public final Bundle k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Map<String, BundleInfo> j = h61.h().j();
            for (String str : j.keySet()) {
                arrayList.add(BundleInfo.toContentValues(j.get(str)));
            }
            bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public final Bundle l(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Bundle i = i(bundleInfo);
            if (i.getInt(Constant.TAG.RET_CODE) != 0) {
                return i;
            }
            Cursor d = d61.b(getContext()).d(bundleInfo.getPackageName(), 1);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(d);
            try {
                d.close();
            } catch (Exception unused) {
            }
            if (!bundleInfoList.isEmpty()) {
                BundleInfo bundleInfo2 = bundleInfoList.get(0);
                BundleInfo bundleInfo3 = h61.h().j().get(bundleInfo.getPackageName());
                if (bundleInfo3 != null && bundleInfo3.getVersionCode() >= bundleInfo2.getVersionCode()) {
                    i = o(bundleInfo3);
                } else {
                    Bundle g = g(bundleInfo2, 50);
                    if (g.getInt(Constant.TAG.RET_CODE) != 2) {
                        return g;
                    }
                    i = m(bundleInfoList.get(0));
                }
            } else {
                i.putInt(Constant.TAG.RET_CODE, 3);
            }
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return i;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle m(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            String absolutePath = r61.g(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
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
                    s(bundleInfo);
                    bundle.putInt(Constant.TAG.RET_CODE, 7);
                    return bundle;
                } else if (h61.h().q(packageName)) {
                    bundle.putInt(Constant.TAG.RET_CODE, 50);
                    return bundle;
                } else {
                    synchronized (this) {
                        if (!this.a.containsKey(packageName)) {
                            this.a.put(packageName, new Object());
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    synchronized (this.a.get(packageName)) {
                        Cursor e = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                        int i = 13;
                        if (e.getCount() == 0) {
                            int k = h61.h().k(bundleInfo, file);
                            if (k == 13) {
                                bundleInfo.setType(3);
                                bundleInfo.setAbi(u61.a());
                                d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                            }
                            i = k;
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
                    q(bundleInfo.getPackageName(), currentTimeMillis);
                    return bundle;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            } else if (h61.h().q(bundleInfo.getPackageName())) {
                bundle.putInt(Constant.TAG.RET_CODE, 50);
                return bundle;
            } else {
                synchronized (this) {
                    if (!this.a.containsKey(bundleInfo.getPackageName())) {
                        this.a.put(bundleInfo.getPackageName(), new Object());
                    }
                }
                synchronized (this.a.get(bundleInfo.getPackageName())) {
                    Cursor e = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    i = 13;
                    if (e.getCount() == 0) {
                        int l = h61.h().l(bundleInfo);
                        if (l == 13) {
                            bundleInfo.setType(3);
                            bundleInfo.setAbi(u61.a());
                            bundleInfo.setApkPath("");
                            d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                        }
                        i = l;
                    } else {
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(e).get(0)));
                    }
                    try {
                        e.close();
                    } catch (Exception unused) {
                    }
                }
                bundle.putInt(Constant.TAG.RET_CODE, i);
                q(bundleInfo.getPackageName(), System.currentTimeMillis());
                return bundle;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle o(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            synchronized (this) {
                if (!this.a.containsKey(bundleInfo.getPackageName())) {
                    this.a.put(bundleInfo.getPackageName(), new Object());
                }
            }
            synchronized (this.a.get(bundleInfo.getPackageName())) {
                Cursor e = d61.b(getContext()).e(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                i = 13;
                if (e.getCount() == 0) {
                    int p = h61.h().p(bundleInfo);
                    if (p == 13) {
                        bundleInfo.setType(3);
                        bundleInfo.setAbi(u61.a());
                        d61.b(getContext()).update(null, BundleInfo.toContentValues(bundleInfo), null, null);
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                    }
                    i = p;
                } else {
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(e).get(0)));
                }
                try {
                    e.close();
                } catch (Exception unused) {
                }
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized Bundle p() {
        InterceptResult invokeV;
        ArrayList<BundleInfo> arrayList;
        BundleInfo next;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048596, this)) != null) {
            return (Bundle) invokeV.objValue;
        }
        synchronized (this) {
            Bundle bundle = new Bundle();
            arrayList = new ArrayList();
            if (this.c) {
                bundle.putInt(Constant.TAG.RET_CODE, 13);
                return bundle;
            }
            Iterator<BundleInfo> it = h61.h().j().values().iterator();
            while (it.hasNext()) {
                next = it.next();
                synchronized (this) {
                    if (!this.a.containsKey(next.getPackageName())) {
                        this.a.put(next.getPackageName(), new Object());
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
            this.c = true;
            return bundle;
        }
        synchronized (this.a.get(next.getPackageName())) {
            Cursor e = d61.b(getContext()).e(next.getPackageName(), next.getVersionCode(), 3);
            if (e.getCount() == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                int p = h61.h().p(next);
                if (p == 13) {
                    next.setType(3);
                    next.setAbi(u61.a());
                    d61.b(getContext()).update(null, BundleInfo.toContentValues(next), null, null);
                    arrayList.add(next);
                }
                IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
                statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
                statisticExtendInfo.source = "installPresets";
                w51.a().b().recordInstallResult(p, next.getPackageName(), next.getVersionCode(), "", statisticExtendInfo);
            } else {
                arrayList.add(BundleInfo.toBundleInfoList(e).get(0));
            }
            try {
                e.close();
            } catch (Exception unused) {
            }
        }
    }

    public final void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048597, this, str, j) == null) {
            Uri.Builder appendPath = new Uri.Builder().scheme("content").authority(j(ContextHolder.getApplicationContext())).appendPath(str);
            getContext().getContentResolver().notifyChange(appendPath.appendPath(j + "").build(), null);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048598, this, uri, strArr, str, strArr2, str2)) == null) ? d61.b(getContext()).query(uri, strArr, str, strArr2, str2) : (Cursor) invokeLLLLL.objValue;
    }

    public final Bundle r(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                h61.h().u(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null));
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final void s(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundleInfo) == null) {
            d61.b(getContext()).f(bundleInfo);
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            h61.h().v(bundleInfo.getPackageName());
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048601, this, uri, contentValues, str, strArr)) == null) ? d61.b(getContext()).update(uri, contentValues, str, strArr) : invokeLLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if ("installonly".equalsIgnoreCase(str2)) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                return m(contentValues != null ? BundleInfo.toBundleInfo(contentValues) : null);
            } else if ("install".equalsIgnoreCase(str2)) {
                ContentValues contentValues2 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                return l(contentValues2 != null ? BundleInfo.toBundleInfo(contentValues2) : null);
            } else if ("presetinstallall".equalsIgnoreCase(str2)) {
                return p();
            } else {
                if ("presetinstallsingle".equalsIgnoreCase(str2)) {
                    ContentValues contentValues3 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                    return o(contentValues3 != null ? BundleInfo.toBundleInfo(contentValues3) : null);
                } else if ("localinstall".equalsIgnoreCase(str2)) {
                    ContentValues contentValues4 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                    return n(contentValues4 != null ? BundleInfo.toBundleInfo(contentValues4) : null);
                } else if ("presetinfo".equalsIgnoreCase(str2)) {
                    return k();
                } else {
                    if ("download".equalsIgnoreCase(str2)) {
                        ContentValues contentValues5 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                        return f(contentValues5 != null ? BundleInfo.toBundleInfo(contentValues5) : null);
                    } else if ("download_all".equalsIgnoreCase(str2)) {
                        return d();
                    } else {
                        if ("fetch".equalsIgnoreCase(str2)) {
                            return h();
                        }
                        if ("cleardeprecated".equalsIgnoreCase(str2)) {
                            return b(bundle);
                        }
                        if ("record".equalsIgnoreCase(str2)) {
                            return r(bundle);
                        }
                        if ("check".equalsIgnoreCase(str2)) {
                            return a(bundle);
                        }
                        if ("downloadBackground".equals(str2)) {
                            return e(bundle);
                        }
                        if ("resettype".equals(str2)) {
                            ContentValues contentValues6 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                            s(contentValues6 != null ? BundleInfo.toBundleInfo(contentValues6) : null);
                            return bundle2;
                        }
                        return bundle2;
                    }
                }
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }
}
