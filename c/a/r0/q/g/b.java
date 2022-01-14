package c.a.r0.q.g;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.q.g.c.c;
import c.a.r0.q.i.e;
import c.a.r0.q.i.f;
import c.a.r0.q.i.g;
import c.a.r0.q.i.h;
import c.a.r0.q.i.i;
import c.a.r0.q.i.j;
import c.a.r0.q.p.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final c.a.r0.q.p.a f11464c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f11465b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-220958166, "Lc/a/r0/q/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-220958166, "Lc/a/r0/q/g/b;");
                return;
            }
        }
        f11464c = c.a.r0.q.p.a.c();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11465b = new c();
    }

    public final <T extends f> boolean A(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#addPackage bundleId=" + t);
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f11465b.b(t.getClass()), this.f11465b.a(t.getClass()).c(t));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#addPackage error", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PMSAppInfo B(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                c.a.r0.q.g.c.b a = this.f11465b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a.d(cursor);
                            d.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e2) {
                            e = e2;
                            f11464c.g("PMSDBImpl", "#queryAppInfo error", e);
                            d.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        d.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                d.a(cursor);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.r0.q.g.c.b<T> a = this.f11465b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a.e(cursor);
                            d.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            f11464c.g("PMSDBImpl", "#queryAppInfoList error", e);
                            d.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(cursor2);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final <T> T D(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    c.a.r0.q.g.c.b<T> a = this.f11465b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            T d2 = a.d(cursor);
                            d.a(cursor);
                            return d2;
                        } catch (Exception e2) {
                            e = e2;
                            f11464c.g("PMSDBImpl", "#queryPackage error", e);
                            d.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    d.a(r0);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(r0);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final <T> List<T> E(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.r0.q.g.c.b<T> a = this.f11465b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a.e(cursor);
                            d.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            f11464c.g("PMSDBImpl", "#queryPackageList error", e);
                            d.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(cursor2);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    public List<i> F(String str, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            Cursor cursor2 = null;
            try {
                c.a.r0.q.g.c.b a = this.f11465b.a(i.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(i.class), null, "bundle_id = ? AND version_code >= ? AND version_code <= ? ", new String[]{str, String.valueOf(j2), String.valueOf(j3)}, "version_code DESC");
                if (cursor != null) {
                    try {
                        List<i> singletonList = z ? Collections.singletonList(a.d(cursor)) : a.e(cursor);
                        d.a(cursor);
                        return singletonList;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.a(cursor);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean a(g gVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gVar, pMSAppInfo)) == null) ? b(gVar, null, null, null, pMSAppInfo) : invokeLL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean b(g gVar, List<h> list, e eVar, c.a.r0.q.i.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, gVar, list, eVar, cVar, pMSAppInfo)) == null) {
            f11464c.i("PMSDBImpl", "#bulkInsert");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (gVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11465b.b(g.class)).withValues(this.f11465b.a(g.class).c(gVar)).build());
            }
            if (list != null && !list.isEmpty()) {
                c.a.r0.q.g.c.b a = this.f11465b.a(h.class);
                for (h hVar : list) {
                    arrayList.add(ContentProviderOperation.newInsert(this.f11465b.b(h.class)).withValues(a.c(hVar)).build());
                }
            }
            if (eVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11465b.b(e.class)).withValues(this.f11465b.a(e.class).c(eVar)).build());
            }
            if (cVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11465b.b(c.a.r0.q.i.c.class)).withValues(this.f11465b.a(c.a.r0.q.i.c.class).c(cVar)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11465b.b(PMSAppInfo.class)).withValues(this.f11465b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(c.a.r0.q.g.e.b.f11472c, arrayList)) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#bulkInsert error", e2);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.r0.q.p.a aVar = f11464c;
            aVar.i("PMSDBImpl", "#clearSubPackage appId=" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.f11465b.b(h.class), "app_id=?", new String[]{str});
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#clearSubPackage error", e2);
            }
        }
    }

    @Override // c.a.r0.q.g.a
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            c.a.r0.q.p.a aVar = f11464c;
            aVar.i("PMSDBImpl", "#clearSubPackage appId=" + str + " versionCode=" + str2);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.f11465b.b(h.class), "app_id=? AND version_code=?", new String[]{str, str2});
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#clearSubPackage error", e2);
            }
        }
    }

    @Override // c.a.r0.q.g.a
    public <T extends f> boolean e(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, str)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#deletePkg bundleId=" + str);
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#deletePkg error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f11465b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean f(@NonNull i iVar) {
        InterceptResult invokeL;
        Uri b2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iVar)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#deletePlugin bundleId=" + iVar.f11494g + " versionCode=" + iVar.f11496i);
                b2 = this.f11465b.b(iVar.getClass());
                if (iVar.f11496i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{iVar.f11494g, String.valueOf(iVar.f11496i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{iVar.f11494g};
                }
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#deletePlugin error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(b2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean g(List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    Uri b2 = this.f11465b.b(i.class);
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    boolean z = true;
                    for (i iVar : list) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(" or ");
                        }
                        sb.append("( ");
                        sb.append("bundle_id");
                        sb.append(" = ? and ");
                        sb.append("version_code");
                        sb.append(" = ?");
                        sb.append(" )");
                        arrayList.add(iVar.f11494g);
                        arrayList.add(String.valueOf(iVar.f11496i));
                    }
                    if (AppRuntime.getAppContext().getContentResolver().delete(b2, sb.toString(), (String[]) arrayList.toArray(new String[0])) > 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            c.a.r0.q.p.a aVar = f11464c;
            aVar.i("PMSDBImpl", "#deleteSwanApp appId=" + str);
            try {
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#deleteSwanApp error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f11465b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    @WorkerThread
    public int j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Cursor cursor = null;
            int i2 = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(h.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i2 = cursor.getInt(0);
                    }
                } catch (Exception e2) {
                    f11464c.g("PMSDBImpl", "#getNewestSubPkgVersion fail", e2);
                }
                return i2;
            } finally {
                d.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // c.a.r0.q.g.a
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<h> k(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i2)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List<h> list = null;
            try {
                if (i2 >= 0) {
                    str2 = "app_id=? and version_code=?";
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b2 = this.f11465b.b(h.class);
                c.a.r0.q.g.c.b a = this.f11465b.a(h.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b2, null, str2, new String[]{str, String.valueOf(i2)}, null);
                if (query != null && a != null) {
                    try {
                        list = a.e(query);
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        try {
                            f11464c.g("PMSDBImpl", "#getSubPackageByAppId fail", e);
                            d.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            d.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        d.a(cursor2);
                        throw th;
                    }
                }
                d.a(query);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            return list != null ? Collections.emptyList() : list;
        }
        return (List) invokeLI.objValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean l(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#insertOrUpdateSwanApp appId=" + pMSAppInfo.appId);
                Class<?> cls = pMSAppInfo.getClass();
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f11465b.b(cls), this.f11465b.a(cls).c(pMSAppInfo));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#insertOrUpdateSwanApp error", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public <T extends f> boolean m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, t)) == null) {
            f11464c.i("PMSDBImpl", "#insertPkg");
            return A(t);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) == null) {
            Cursor cursor = null;
            try {
                try {
                    Uri b2 = this.f11465b.b(h.class);
                    c.a.r0.q.g.c.b a = this.f11465b.a(h.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b2, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        return a.d(cursor) != null;
                    }
                } catch (Exception e2) {
                    f11464c.g("PMSDBImpl", "#isSubPackageExist error", e2);
                }
                return false;
            } finally {
                d.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public <T extends f> T o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, str)) == null) ? (T) D(cls, str) : (T) invokeLL.objValue;
    }

    @Override // c.a.r0.q.g.a
    public Map<String, g> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            HashMap hashMap = new HashMap();
            List<g> E = E(g.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (E != null && E.size() > 0) {
                for (g gVar : E) {
                    if (gVar != null) {
                        hashMap.put(gVar.f11494g, gVar);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.r0.q.g.a
    public i q(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            List<i> F = F(str, j2, j3, true);
            if (F == null || F.isEmpty()) {
                return null;
            }
            return F.get(0);
        }
        return (i) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0030 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // c.a.r0.q.g.a
    public List<i> r(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, strArr)) == null) {
            ?? r1 = 0;
            try {
                try {
                    c.a.r0.q.g.c.b a = this.f11465b.a(i.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(i.class), null, str, strArr, "update_time DESC");
                    if (cursor != null) {
                        try {
                            List<i> e2 = a.e(cursor);
                            d.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            f11464c.g("PMSDBImpl", "#queryPlugin error", e);
                            d.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    d.a(r1);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(r1);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    @Override // c.a.r0.q.g.a
    public List<i> s(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? F(str, j2, j3, false) : (List) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // c.a.r0.q.g.a
    @Nullable
    public j t(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    c.a.r0.q.g.c.b a = this.f11465b.a(j.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11465b.b(j.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            j jVar = (j) a.d(cursor);
                            d.a(cursor);
                            return jVar;
                        } catch (Exception e2) {
                            e = e2;
                            f11464c.g("PMSDBImpl", "#querySoLib error", e);
                            d.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    d.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(r1);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (j) invokeL.objValue;
    }

    @Override // c.a.r0.q.g.a
    public PMSAppInfo u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? B(str) : (PMSAppInfo) invokeL.objValue;
    }

    @Override // c.a.r0.q.g.a
    public Map<String, PMSAppInfo> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            HashMap hashMap = new HashMap();
            List<PMSAppInfo> C = C(PMSAppInfo.class, null, null, null);
            if (C != null && C.size() > 0) {
                for (PMSAppInfo pMSAppInfo : C) {
                    if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                        hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.r0.q.g.a
    public List<i> w(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.r0.q.g.c.b a = this.f11465b.a(i.class);
                Uri.Builder buildUpon = this.f11465b.b(i.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List<i> e2 = a.e(cursor);
                            d.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            f11464c.g("PMSDBImpl", "#rawQueryPlugins error", e);
                            d.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a(cursor2);
                throw th;
            }
            d.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean x(@NonNull i iVar) {
        InterceptResult invokeL;
        Uri b2;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, iVar)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#deletePlugin bundleId=" + iVar.f11494g + " versionCode=" + iVar.f11496i);
                c.a.r0.q.g.c.b a = this.f11465b.a(iVar.getClass());
                b2 = this.f11465b.b(iVar.getClass());
                c2 = a.c(iVar);
                if (iVar.f11496i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{iVar.f11494g, String.valueOf(iVar.f11496i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{iVar.f11494g, iVar.f11497j};
                }
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#updatePlugin error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, c2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean y(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, pMSAppInfo)) == null) {
            try {
                c.a.r0.q.p.a aVar = f11464c;
                aVar.i("PMSDBImpl", "#updateSwanApp appId=" + pMSAppInfo.appId);
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#updateSwanApp error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().update(this.f11465b.b(pMSAppInfo.getClass()), this.f11465b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.q.g.a
    public boolean z(String str, int i2) {
        InterceptResult invokeLI;
        Uri b2;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i2)) == null) {
            c.a.r0.q.p.a aVar = f11464c;
            aVar.i("PMSDBImpl", "#updateSwanAppPendingErrCode appId=" + str + " errCode=" + i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b2 = this.f11465b.b(PMSAppInfo.class);
                contentValues = new ContentValues();
                contentValues.put("pending_err_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                f11464c.g("PMSDBImpl", "#updateSwanAppPendingErrCode error", e2);
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, contentValues, "app_id =? ", new String[]{str}) > 0;
        }
        return invokeLI.booleanValue;
    }
}
