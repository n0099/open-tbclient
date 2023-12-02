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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.ba1;
import com.baidu.tieba.fa1;
import com.baidu.tieba.k91;
import com.baidu.tieba.pa1;
import com.baidu.tieba.qa1;
import com.baidu.tieba.ta1;
import com.baidu.tieba.u91;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class BundleOpProvider extends ContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;
    public Map<String, Object> b;
    public boolean c;

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, uri)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
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

    public static String i(Context context) {
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
                if (fa1.h().q(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null))) {
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
            ba1.e(getContext()).d();
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle e(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundleInfo)) == null) {
            return f(bundleInfo, 48);
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle r(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                fa1.h().u(bundle.getString(Constant.TAG.PARAM_PKG_NAME, null));
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    public final void s(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundleInfo) == null) {
            ba1.e(getContext()).j(bundleInfo);
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            fa1.h().v(bundleInfo.getPackageName());
        }
    }

    public final synchronized Bundle c() {
        InterceptResult invokeV;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                List<BundleInfo> g = ba1.e(getContext()).g();
                ArrayList<BundleInfo> arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                HashMap hashMap = new HashMap();
                for (BundleInfo bundleInfo : g) {
                    if (bundleInfo != null) {
                        if (bundleInfo.getType() == 1) {
                            arrayList.add(bundleInfo);
                        } else if (bundleInfo.getType() == 3) {
                            hashSet.add(bundleInfo.getPackageName());
                            if (bundleInfo.isMainBundle()) {
                                hashMap.put(bundleInfo.getPackageName(), bundleInfo);
                            }
                        }
                    }
                }
                for (BundleInfo bundleInfo2 : arrayList) {
                    if (hashSet.contains(bundleInfo2.getPackageName())) {
                        if (bundleInfo2.getSilenceUpdate() == 1 && p(bundleInfo2, hashMap)) {
                            f(bundleInfo2, 49);
                        }
                    } else if (bundleInfo2.getSilence() == 1 && p(bundleInfo2, hashMap)) {
                        f(bundleInfo2, 49);
                    }
                }
                bundle = new Bundle();
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, bundle)) == null) {
            return call(null, str, str2, bundle);
        }
        return (Bundle) invokeLLL.objValue;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, uri, str, strArr)) == null) {
            return ba1.e(getContext()).c(uri, str, strArr);
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            BundleInfo bundleInfo = null;
            if ("installonly".equalsIgnoreCase(str2)) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                if (contentValues != null) {
                    bundleInfo = BundleInfo.toBundleInfo(contentValues);
                }
                return l(bundleInfo);
            } else if ("install".equalsIgnoreCase(str2)) {
                ContentValues contentValues2 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                if (contentValues2 != null) {
                    bundleInfo = BundleInfo.toBundleInfo(contentValues2);
                }
                return k(bundleInfo, bundle.getBoolean(Constant.TAG.PARAM_MULTI_BUNDLE_ENABLE, false));
            } else if ("presetinstallall".equalsIgnoreCase(str2)) {
                return o();
            } else {
                if ("presetinstallsingle".equalsIgnoreCase(str2)) {
                    ContentValues contentValues3 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                    if (contentValues3 != null) {
                        bundleInfo = BundleInfo.toBundleInfo(contentValues3);
                    }
                    return n(bundleInfo);
                } else if ("localinstall".equalsIgnoreCase(str2)) {
                    ContentValues contentValues4 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                    if (contentValues4 != null) {
                        bundleInfo = BundleInfo.toBundleInfo(contentValues4);
                    }
                    return m(bundleInfo);
                } else if ("presetinfo".equalsIgnoreCase(str2)) {
                    return j();
                } else {
                    if ("download".equalsIgnoreCase(str2)) {
                        ContentValues contentValues5 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                        if (contentValues5 != null) {
                            bundleInfo = BundleInfo.toBundleInfo(contentValues5);
                        }
                        return e(bundleInfo);
                    } else if ("download_all".equalsIgnoreCase(str2)) {
                        return c();
                    } else {
                        if ("fetch".equalsIgnoreCase(str2)) {
                            return g();
                        }
                        if ("cleardeprecated".equalsIgnoreCase(str2)) {
                            return b(bundle);
                        }
                        if ("record".equalsIgnoreCase(str2)) {
                            return r(bundle);
                        }
                        if (ApkCheckUBCManagerKt.PAGE.equalsIgnoreCase(str2)) {
                            return a(bundle);
                        }
                        if ("downloadBackground".equals(str2)) {
                            return d(bundle);
                        }
                        if ("resettype".equals(str2)) {
                            ContentValues contentValues6 = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                            if (contentValues6 != null) {
                                bundleInfo = BundleInfo.toBundleInfo(contentValues6);
                            }
                            s(bundleInfo);
                            return bundle2;
                        }
                        return bundle2;
                    }
                }
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public final Bundle d(Bundle bundle) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                ContentValues contentValues = (ContentValues) bundle.getParcelable(Constant.TAG.PARAM_VALUE);
                if (contentValues != null) {
                    bundleInfo = BundleInfo.toBundleInfo(contentValues);
                } else {
                    bundleInfo = null;
                }
                if (bundleInfo == null) {
                    bundle2.putInt(Constant.TAG.RET_CODE, 4);
                    return bundle2;
                }
                bundleInfo.setSilenceUpdate(1);
                bundleInfo.setSilence(1);
                ba1.e(getContext()).m(null, BundleInfo.toContentValues(bundleInfo), null, null);
            }
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0096 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01ca: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:133:0x01ca */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0179 A[Catch: all -> 0x01cf, TryCatch #6 {, blocks: (B:24:0x0062, B:30:0x008d, B:31:0x0090, B:33:0x0092, B:50:0x00cd, B:51:0x00d0, B:53:0x00d2, B:65:0x00e7, B:72:0x0109, B:73:0x010c, B:76:0x0118, B:114:0x0179, B:115:0x017e, B:117:0x0180, B:119:0x018a, B:120:0x01af, B:121:0x01b6, B:87:0x012b, B:90:0x0131, B:91:0x0134, B:96:0x0151, B:97:0x0154, B:100:0x0160, B:111:0x0173, B:126:0x01bf, B:127:0x01c2, B:130:0x01c5, B:131:0x01c8, B:134:0x01cb, B:135:0x01ce), top: B:153:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0180 A[Catch: all -> 0x01cf, TryCatch #6 {, blocks: (B:24:0x0062, B:30:0x008d, B:31:0x0090, B:33:0x0092, B:50:0x00cd, B:51:0x00d0, B:53:0x00d2, B:65:0x00e7, B:72:0x0109, B:73:0x010c, B:76:0x0118, B:114:0x0179, B:115:0x017e, B:117:0x0180, B:119:0x018a, B:120:0x01af, B:121:0x01b6, B:87:0x012b, B:90:0x0131, B:91:0x0134, B:96:0x0151, B:97:0x0154, B:100:0x0160, B:111:0x0173, B:126:0x01bf, B:127:0x01c2, B:130:0x01c5, B:131:0x01c8, B:134:0x01cb, B:135:0x01ce), top: B:153:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2 A[Catch: Exception -> 0x00d6, all -> 0x01c3, TRY_LEAVE, TryCatch #0 {all -> 0x01c3, blocks: (B:47:0x00bc, B:49:0x00c2, B:61:0x00dd, B:63:0x00e3), top: B:146:0x00a8 }] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r8v32, types: [java.lang.Exception] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle f(BundleInfo bundleInfo, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2;
        Cursor cursor2;
        Cursor cursor3;
        BundleInfo bundleInfo2;
        Cursor cursor4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundleInfo, i)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            BundleInfo bundleInfo3 = fa1.h().j().get(bundleInfo.getPackageName());
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
                Closeable closeable3 = null;
                try {
                    try {
                        cursor = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 2);
                        try {
                            int count = cursor.getCount();
                            closeable2 = count;
                            if (count > 0) {
                                bundle.putInt(Constant.TAG.RET_CODE, 2);
                                bundle.putLong("time_stamp", currentTimeMillis);
                                k91.a(cursor);
                                return bundle;
                            }
                        } catch (Exception e) {
                            e = e;
                            closeable2 = e;
                            if (pa1.a()) {
                                e.printStackTrace();
                                closeable2 = e;
                            }
                            k91.a(cursor);
                            try {
                                cursor2 = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                                try {
                                    if (cursor2.getCount() > 0) {
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    if (pa1.a()) {
                                        e.printStackTrace();
                                    }
                                    k91.a(cursor2);
                                    if (bundleInfo.getType() == 4) {
                                    }
                                    if (bundleInfo2 == null) {
                                    }
                                }
                                k91.a(cursor2);
                                try {
                                    if (bundleInfo.getType() == 4) {
                                    }
                                    if (bundleInfo2 == null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    closeable3 = 4;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                closeable3 = closeable2;
                                k91.a(closeable3);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable3 = closeable;
                        k91.a(closeable3);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th4) {
                    th = th4;
                    k91.a(closeable3);
                    throw th;
                }
                k91.a(cursor);
                try {
                    cursor2 = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    if (cursor2.getCount() > 0) {
                        bundle.putInt(Constant.TAG.RET_CODE, 2);
                        bundle.putLong("time_stamp", currentTimeMillis);
                        k91.a(cursor2);
                        return bundle;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    k91.a(closeable3);
                    throw th;
                }
                k91.a(cursor2);
                try {
                    if (bundleInfo.getType() == 4) {
                        try {
                            cursor3 = ba1.e(getContext()).h(bundleInfo.getPackageName(), 4);
                            try {
                                if (cursor3.getCount() == 0) {
                                    bundle.putInt(Constant.TAG.RET_CODE, 3);
                                    k91.a(cursor3);
                                    return bundle;
                                }
                                bundleInfo2 = BundleInfo.toBundleInfoList(cursor3).get(0);
                                k91.a(cursor3);
                            } catch (Exception e5) {
                                e = e5;
                                if (pa1.a()) {
                                    e.printStackTrace();
                                }
                                k91.a(cursor3);
                                bundleInfo2 = null;
                                if (bundleInfo2 == null) {
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            cursor3 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            k91.a(closeable3);
                            throw th;
                        }
                    } else {
                        try {
                            cursor4 = ba1.e(getContext()).h(bundleInfo.getPackageName(), 1);
                            try {
                                if (cursor4.getCount() == 0) {
                                    bundle.putInt(Constant.TAG.RET_CODE, 3);
                                    k91.a(cursor4);
                                    return bundle;
                                }
                                bundleInfo2 = BundleInfo.toBundleInfoList(cursor4).get(0);
                                k91.a(cursor4);
                            } catch (Exception e7) {
                                e = e7;
                                if (pa1.a()) {
                                    e.printStackTrace();
                                }
                                k91.a(cursor4);
                                bundleInfo2 = null;
                                if (bundleInfo2 == null) {
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            cursor4 = null;
                        } catch (Throwable th7) {
                            th = th7;
                            k91.a(closeable3);
                            throw th;
                        }
                    }
                    if (bundleInfo2 == null) {
                        bundle.putInt(Constant.TAG.RET_CODE, 3);
                        return bundle;
                    }
                    int e9 = fa1.h().e(bundleInfo2, i);
                    if (e9 == 2) {
                        bundleInfo2.setType(2);
                        ba1.e(getContext()).m(null, BundleInfo.toContentValues(bundleInfo2), null, null);
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo2));
                        currentTimeMillis = System.currentTimeMillis();
                        bundle.putLong("time_stamp", currentTimeMillis);
                    }
                    q(bundleInfo.getPackageName(), currentTimeMillis);
                    bundle.putInt(Constant.TAG.RET_CODE, e9);
                    return bundle;
                } catch (Throwable th8) {
                    th = th8;
                    closeable3 = 4;
                }
            }
        } else {
            return (Bundle) invokeLI.objValue;
        }
    }

    public final Bundle k(BundleInfo bundleInfo, boolean z) {
        InterceptResult invokeLZ;
        Bundle l;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, bundleInfo, z)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Bundle h = h(bundleInfo);
            if (h.getInt(Constant.TAG.RET_CODE) != 0) {
                return h;
            }
            Cursor h2 = ba1.e(getContext()).h(bundleInfo.getPackageName(), 1);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(h2);
            try {
                h2.close();
            } catch (Exception unused) {
            }
            if (!bundleInfoList.isEmpty()) {
                BundleInfo bundleInfo2 = bundleInfoList.get(0);
                BundleInfo bundleInfo3 = fa1.h().j().get(bundleInfo.getPackageName());
                if (z && bundleInfo2.isSubBundle()) {
                    if (pa1.a()) {
                        Log.d("BundleOpProvider", "installBundle multiBundleEnable=true pkg=" + bundleInfo2.getPackageName());
                    }
                    Cursor h3 = ba1.e(getContext()).h(bundleInfo2.getMainBudble(), 3);
                    List<BundleInfo> bundleInfoList2 = BundleInfo.toBundleInfoList(h3);
                    try {
                        h3.close();
                    } catch (Exception unused2) {
                    }
                    if (!bundleInfoList2.isEmpty()) {
                        List<SubBundleInfo> subBundle = bundleInfoList2.get(0).getSubBundle();
                        if (subBundle != null && !subBundle.isEmpty()) {
                            Iterator<SubBundleInfo> it = subBundle.iterator();
                            while (true) {
                                i = -1;
                                if (it.hasNext()) {
                                    SubBundleInfo next = it.next();
                                    if (bundleInfo.getPackageName() != null && bundleInfo.getPackageName().equals(next.getPackageName())) {
                                        i = next.getMaxVersion();
                                        i2 = next.getMinVersion();
                                        break;
                                    }
                                } else {
                                    i2 = -1;
                                    break;
                                }
                            }
                            if (i < 0 && i2 < 0) {
                                h.putInt(Constant.TAG.RET_CODE, 57);
                            } else if (bundleInfo3 != null && bundleInfo3.getVersionCode() >= bundleInfo2.getVersionCode() && bundleInfo3.getVersionCode() >= i2 && bundleInfo3.getVersionCode() <= i) {
                                l = n(bundleInfo3);
                            } else if (bundleInfo2.getVersionCode() >= i2 && bundleInfo2.getVersionCode() <= i) {
                                Bundle f = f(bundleInfo2, 50);
                                if (f.getInt(Constant.TAG.RET_CODE) != 2) {
                                    return f;
                                }
                                l = l(bundleInfoList.get(0));
                            } else if (bundleInfo2.needForceUpdate()) {
                                h.putInt(Constant.TAG.RET_CODE, 57);
                                return h;
                            } else {
                                Cursor h4 = ba1.e(getContext()).h(bundleInfo.getPackageName(), 4);
                                List<BundleInfo> bundleInfoList3 = BundleInfo.toBundleInfoList(h4);
                                try {
                                    h4.close();
                                } catch (Exception unused3) {
                                }
                                if (!bundleInfoList3.isEmpty()) {
                                    BundleInfo bundleInfo4 = bundleInfoList3.get(0);
                                    if (bundleInfo4.getVersionCode() >= i2 && bundleInfo4.getVersionCode() <= i) {
                                        Bundle f2 = f(bundleInfo4, 50);
                                        if (f2.getInt(Constant.TAG.RET_CODE) != 2) {
                                            return f2;
                                        }
                                        l = l(bundleInfo4);
                                    } else {
                                        h.putInt(Constant.TAG.RET_CODE, 57);
                                    }
                                } else {
                                    h.putInt(Constant.TAG.RET_CODE, 57);
                                }
                            }
                        } else {
                            h.putInt(Constant.TAG.RET_CODE, 57);
                        }
                    } else {
                        h.putInt(Constant.TAG.RET_CODE, 57);
                    }
                } else if (bundleInfo3 != null && bundleInfo3.getVersionCode() >= bundleInfo2.getVersionCode()) {
                    l = n(bundleInfo3);
                } else {
                    Bundle f3 = f(bundleInfo2, 50);
                    if (f3.getInt(Constant.TAG.RET_CODE) != 2) {
                        return f3;
                    }
                    l = l(bundleInfoList.get(0));
                }
                h = l;
            } else {
                h.putInt(Constant.TAG.RET_CODE, 3);
            }
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return h;
        }
        return (Bundle) invokeLZ.objValue;
    }

    public final Bundle g() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            ArrayList<IBundleInfo> arrayList2 = new ArrayList();
            fa1.d g = fa1.h().g(arrayList);
            int i = g.a;
            if (i == 0) {
                HashSet<String> hashSet = new HashSet();
                Iterator<IBundleInfo> it = g.b.iterator();
                while (true) {
                    cursor = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    BundleInfo bundleInfo = BundleInfo.toBundleInfo(it.next());
                    bundleInfo.setType(1);
                    ba1.e(getContext()).m(null, BundleInfo.toContentValues(bundleInfo), null, null);
                    arrayList2.add(bundleInfo);
                    if (!TextUtils.isEmpty(bundleInfo.getMainBudble())) {
                        hashSet.add(bundleInfo.getMainBudble());
                    }
                }
                BundleInfo bundleInfo2 = null;
                for (String str : hashSet) {
                    try {
                        cursor = ba1.e(getContext()).h(str, 3);
                        if (cursor.getCount() > 0) {
                            bundleInfo2 = BundleInfo.toBundleInfoList(cursor).get(0);
                        }
                        if (bundleInfo2 != null) {
                            ba1.e(getContext()).l(bundleInfo2);
                        }
                    } finally {
                        k91.a(cursor);
                    }
                }
                i = 0;
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
            for (IBundleInfo iBundleInfo : arrayList2) {
                arrayList3.add(BundleInfo.toContentValues(iBundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList3);
            long currentTimeMillis = System.currentTimeMillis();
            bundle.putLong("time_stamp", currentTimeMillis);
            q("all", currentTimeMillis);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public final synchronized Bundle o() {
        InterceptResult invokeV;
        ArrayList<BundleInfo> arrayList;
        BundleInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                Bundle bundle = new Bundle();
                arrayList = new ArrayList();
                if (this.c) {
                    bundle.putInt(Constant.TAG.RET_CODE, 13);
                    return bundle;
                }
                Iterator<BundleInfo> it = fa1.h().j().values().iterator();
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
                Cursor i = ba1.e(getContext()).i(next.getPackageName(), next.getVersionCode(), 3);
                if (i.getCount() == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int p = fa1.h().p(next);
                    if (p == 13) {
                        t(next);
                        arrayList.add(next);
                    }
                    IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
                    statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
                    statisticExtendInfo.source = "installPresets";
                    u91.a().b().recordInstallResult(p, next.getPackageName(), next.getVersionCode(), "", statisticExtendInfo);
                } else {
                    arrayList.add(BundleInfo.toBundleInfoList(i).get(0));
                }
                try {
                    i.close();
                } catch (Exception unused) {
                }
            }
        } else {
            return (Bundle) invokeV.objValue;
        }
    }

    public final Bundle h(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        BundleInfo bundleInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleInfo);
            if (bundleInfo.isMainBundle()) {
                for (SubBundleInfo subBundleInfo : bundleInfo.getSubBundle()) {
                    BundleInfo bundleInfo3 = new BundleInfo();
                    bundleInfo3.setPackageName(subBundleInfo.getPackageName());
                    arrayList.add(bundleInfo3);
                }
            }
            fa1.d g = fa1.h().g(arrayList);
            int i = g.a;
            IBundleInfo iBundleInfo = null;
            Cursor cursor = null;
            if (i == 0) {
                for (IBundleInfo iBundleInfo2 : g.b) {
                    BundleInfo bundleInfo4 = BundleInfo.toBundleInfo(iBundleInfo2);
                    bundleInfo4.setType(1);
                    ba1.e(getContext()).m(null, BundleInfo.toContentValues(bundleInfo4), null, null);
                }
                if (bundleInfo.isMainBundle()) {
                    try {
                        Cursor h = ba1.e(getContext()).h(bundleInfo.getPackageName(), 3);
                        try {
                            if (h.getCount() > 0) {
                                bundleInfo2 = BundleInfo.toBundleInfoList(h).get(0);
                            } else {
                                bundleInfo2 = null;
                            }
                            k91.a(h);
                            if (bundleInfo2 != null) {
                                ba1.e(getContext()).l(bundleInfo2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = h;
                            k91.a(cursor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                i = 0;
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            if (!g.b.isEmpty()) {
                iBundleInfo = g.b.get(0);
            }
            if (iBundleInfo != null) {
                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(iBundleInfo));
            }
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle l(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            }
            Application applicationContext = ContextHolder.getApplicationContext();
            String absolutePath = qa1.g(applicationContext, bundleInfo.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
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
                } else if (fa1.h().q(packageName)) {
                    bundle.putInt(Constant.TAG.RET_CODE, 50);
                    return bundle;
                } else {
                    synchronized (this) {
                        if (!this.a.containsKey(packageName)) {
                            this.a.put(packageName, new Object());
                        }
                    }
                    System.currentTimeMillis();
                    synchronized (this.a.get(packageName)) {
                        Cursor i = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                        int i2 = 13;
                        if (i.getCount() == 0) {
                            int k = fa1.h().k(bundleInfo, file);
                            if (k == 13) {
                                t(bundleInfo);
                                bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                            }
                            i2 = k;
                        } else {
                            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i).get(0)));
                        }
                        try {
                            i.close();
                        } catch (Exception unused) {
                        }
                        bundle.putInt(Constant.TAG.RET_CODE, i2);
                        currentTimeMillis = System.currentTimeMillis();
                        bundle.putLong("time_stamp", currentTimeMillis);
                    }
                    q(bundleInfo.getPackageName(), currentTimeMillis);
                    return bundle;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public final Bundle j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Map<String, BundleInfo> j = fa1.h().j();
            for (String str : j.keySet()) {
                arrayList.add(BundleInfo.toContentValues(j.get(str)));
            }
            bundle.putParcelableArrayList(Constant.TAG.RET_VALUE, arrayList);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public final Bundle m(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bundleInfo)) == null) {
            Bundle bundle = new Bundle();
            if (bundleInfo == null) {
                bundle.putInt(Constant.TAG.RET_CODE, 4);
                return bundle;
            } else if (fa1.h().q(bundleInfo.getPackageName())) {
                bundle.putInt(Constant.TAG.RET_CODE, 50);
                return bundle;
            } else {
                synchronized (this) {
                    if (!this.a.containsKey(bundleInfo.getPackageName())) {
                        this.a.put(bundleInfo.getPackageName(), new Object());
                    }
                }
                synchronized (this.a.get(bundleInfo.getPackageName())) {
                    Cursor i2 = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                    i = 13;
                    if (i2.getCount() == 0) {
                        int l = fa1.h().l(bundleInfo);
                        if (l == 13) {
                            bundleInfo.setApkPath("");
                            t(bundleInfo);
                            bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                        }
                        i = l;
                    } else {
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i2).get(0)));
                    }
                    try {
                        i2.close();
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

    public final Bundle n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundleInfo)) == null) {
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
                Cursor i2 = ba1.e(getContext()).i(bundleInfo.getPackageName(), bundleInfo.getVersionCode(), 3);
                i = 13;
                if (i2.getCount() == 0) {
                    int p = fa1.h().p(bundleInfo);
                    if (p == 13) {
                        t(bundleInfo);
                        bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(bundleInfo));
                    }
                    i = p;
                } else {
                    bundle.putParcelable(Constant.TAG.RET_VALUE, BundleInfo.toContentValues(BundleInfo.toBundleInfoList(i2).get(0)));
                }
                try {
                    i2.close();
                } catch (Exception unused) {
                }
            }
            bundle.putInt(Constant.TAG.RET_CODE, i);
            q(bundleInfo.getPackageName(), System.currentTimeMillis());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean p(BundleInfo bundleInfo, Map<String, BundleInfo> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, bundleInfo, map)) == null) {
            if (bundleInfo.isSubBundle()) {
                if (map == null) {
                    return false;
                }
                return k91.b(map.get(bundleInfo.getMainBudble()), bundleInfo);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048597, this, str, j) == null) {
            Uri.Builder appendPath = new Uri.Builder().scheme("content").authority(i(ContextHolder.getApplicationContext())).appendPath(str);
            getContext().getContentResolver().notifyChange(appendPath.appendPath(j + "").build(), null);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048598, this, uri, strArr, str, strArr2, str2)) == null) {
            return ba1.e(getContext()).f(uri, strArr, str, strArr2, str2);
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    public final void t(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundleInfo) == null) {
            bundleInfo.setType(3);
            bundleInfo.setAbi(ta1.a());
            ba1.e(getContext()).l(bundleInfo);
            ba1.e(getContext()).m(null, BundleInfo.toContentValues(bundleInfo), null, null);
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048602, this, uri, contentValues, str, strArr)) == null) {
            return ba1.e(getContext()).m(uri, contentValues, str, strArr);
        }
        return invokeLLLL.intValue;
    }
}
