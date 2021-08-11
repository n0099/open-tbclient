package c.a.n0.n.g;

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
import c.a.n0.n.g.c.c;
import c.a.n0.n.h.d;
import c.a.n0.n.h.e;
import c.a.n0.n.h.f;
import c.a.n0.n.h.g;
import c.a.n0.n.h.h;
import c.a.n0.n.h.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f11584b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11584b = new c();
    }

    public final <T> List<T> A(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.n0.n.g.c.b<T> a2 = this.f11584b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a2.e(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.n0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(cursor2);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final <T> T B(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    c.a.n0.n.g.c.b<T> a2 = this.f11584b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            T d2 = a2.d(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return d2;
                        } catch (Exception e2) {
                            e = e2;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    c.a.n0.n.o.c.a(r0);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(r0);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.n0.n.g.c.b<T> a2 = this.f11584b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a2.e(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.n0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(cursor2);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean a(f fVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, pMSAppInfo)) == null) ? b(fVar, null, null, null, pMSAppInfo) : invokeLL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean b(f fVar, List<g> list, d dVar, c.a.n0.n.h.b bVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, fVar, list, dVar, bVar, pMSAppInfo)) == null) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (fVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11584b.b(f.class)).withValues(this.f11584b.a(f.class).c(fVar)).build());
            }
            if (list != null && !list.isEmpty()) {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(g.class);
                for (g gVar : list) {
                    arrayList.add(ContentProviderOperation.newInsert(this.f11584b.b(g.class)).withValues(a2.c(gVar)).build());
                }
            }
            if (dVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11584b.b(d.class)).withValues(this.f11584b.a(d.class).c(dVar)).build());
            }
            if (bVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11584b.b(c.a.n0.n.h.b.class)).withValues(this.f11584b.a(c.a.n0.n.h.b.class).c(bVar)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f11584b.b(PMSAppInfo.class)).withValues(this.f11584b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(c.a.n0.n.g.e.b.f11591b, arrayList)) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f11584b.b(g.class), "app_id=?", new String[]{str});
        } catch (Exception e2) {
            if (c.a.n0.n.c.f11582a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.n0.n.g.a
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f11584b.b(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
        } catch (Exception e2) {
            if (c.a.n0.n.c.f11582a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.n0.n.g.a
    public <T extends e> boolean e(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cls, str)) == null) {
            try {
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f11584b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean f(@NonNull h hVar) {
        InterceptResult invokeL;
        Uri b2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar)) == null) {
            try {
                b2 = this.f11584b.b(hVar.getClass());
                if (hVar.f11613i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{hVar.f11611g, String.valueOf(hVar.f11613i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{hVar.f11611g};
                }
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(b2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f11584b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    @WorkerThread
    public int i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Cursor cursor = null;
            int i2 = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i2 = cursor.getInt(0);
                    }
                } catch (Exception e2) {
                    if (c.a.n0.n.c.f11582a) {
                        e2.printStackTrace();
                    }
                }
                return i2;
            } finally {
                c.a.n0.n.o.c.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // c.a.n0.n.g.a
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<g> j(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List<g> list = null;
            try {
                if (i2 >= 0) {
                    str2 = "app_id=? and version_code=?";
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b2 = this.f11584b.b(g.class);
                c.a.n0.n.g.c.b a2 = this.f11584b.a(g.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b2, null, str2, new String[]{str, String.valueOf(i2)}, null);
                if (query != null && a2 != null) {
                    try {
                        list = a2.e(query);
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        try {
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            c.a.n0.n.o.c.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        c.a.n0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
                c.a.n0.n.o.c.a(query);
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

    @Override // c.a.n0.n.g.a
    public boolean k(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pMSAppInfo)) == null) {
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f11584b.b(pMSAppInfo.getClass()), this.f11584b.a(pMSAppInfo.getClass()).c(pMSAppInfo));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public <T extends e> boolean l(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) ? y(t) : invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean m(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, str3)) == null) {
            Cursor cursor = null;
            try {
                try {
                    Uri b2 = this.f11584b.b(g.class);
                    c.a.n0.n.g.c.b a2 = this.f11584b.a(g.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b2, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        return a2.d(cursor) != null;
                    }
                } catch (Exception e2) {
                    if (c.a.n0.n.c.f11582a) {
                        e2.printStackTrace();
                    }
                }
                return false;
            } finally {
                c.a.n0.n.o.c.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.n0.n.g.a
    public List<h> n(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Closeable closeable = null;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    closeable = i2;
                    c.a.n0.n.o.c.a(closeable);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(closeable);
                throw th;
            }
            if (this.f11584b != null) {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(h.class), null, null, null, "update_time ASC limit 0," + i2);
                if (cursor != null) {
                    try {
                        List<h> e3 = a2.e(cursor);
                        c.a.n0.n.o.c.a(cursor);
                        return e3;
                    } catch (Exception e4) {
                        e = e4;
                        if (c.a.n0.n.c.f11582a) {
                            e.printStackTrace();
                        }
                        c.a.n0.n.o.c.a(cursor);
                        return null;
                    }
                }
                c.a.n0.n.o.c.a(cursor);
                return null;
            }
            c.a.n0.n.o.c.a(null);
            return null;
        }
        return (List) invokeI.objValue;
    }

    @Override // c.a.n0.n.g.a
    public <T extends e> T o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, cls, str)) == null) ? (T) B(cls, str) : (T) invokeLL.objValue;
    }

    @Override // c.a.n0.n.g.a
    public Map<String, f> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            HashMap hashMap = new HashMap();
            List<f> C = C(f.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (C != null && C.size() > 0) {
                for (f fVar : C) {
                    if (fVar != null) {
                        hashMap.put(fVar.f11611g, fVar);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.n0.n.g.a
    public List<h> q(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, strArr)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(h.class), null, str, strArr, "update_time DESC");
                if (cursor != null) {
                    try {
                        try {
                            List<h> e2 = a2.e(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.n0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(cursor2);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // c.a.n0.n.g.a
    @Nullable
    public i r(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    c.a.n0.n.g.c.b a2 = this.f11584b.a(i.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            i iVar = (i) a2.d(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return iVar;
                        } catch (Exception e2) {
                            e = e2;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    c.a.n0.n.o.c.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(r1);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (i) invokeL.objValue;
    }

    @Override // c.a.n0.n.g.a
    public PMSAppInfo s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? z(str) : (PMSAppInfo) invokeL.objValue;
    }

    @Override // c.a.n0.n.g.a
    public Map<String, PMSAppInfo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            HashMap hashMap = new HashMap();
            List<PMSAppInfo> A = A(PMSAppInfo.class, null, null, null);
            if (A != null && A.size() > 0) {
                for (PMSAppInfo pMSAppInfo : A) {
                    if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                        hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.a.n0.n.g.a
    public List<h> u(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(h.class);
                Uri.Builder buildUpon = this.f11584b.b(h.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List<h> e2 = a2.e(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.n0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.n0.n.o.c.a(cursor2);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean v(@NonNull h hVar) {
        InterceptResult invokeL;
        Uri b2;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, hVar)) == null) {
            try {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(hVar.getClass());
                b2 = this.f11584b.b(hVar.getClass());
                c2 = a2.c(hVar);
                if (hVar.f11613i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{hVar.f11611g, String.valueOf(hVar.f11613i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{hVar.f11611g, hVar.f11614j};
                }
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, c2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean w(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, pMSAppInfo)) == null) {
            try {
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(this.f11584b.b(pMSAppInfo.getClass()), this.f11584b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.g.a
    public boolean x(String str, int i2) {
        InterceptResult invokeLI;
        Uri b2;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b2 = this.f11584b.b(PMSAppInfo.class);
                contentValues = new ContentValues();
                contentValues.put("pending_err_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, contentValues, "app_id =? ", new String[]{str}) > 0;
        }
        return invokeLI.booleanValue;
    }

    public final <T extends e> boolean y(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, t)) == null) {
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f11584b.b(t.getClass()), this.f11584b.a(t.getClass()).c(t));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PMSAppInfo z(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            try {
                c.a.n0.n.g.c.b a2 = this.f11584b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f11584b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a2.d(cursor);
                            c.a.n0.n.o.c.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e2) {
                            e = e2;
                            if (c.a.n0.n.c.f11582a) {
                                e.printStackTrace();
                            }
                            c.a.n0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c.a.n0.n.o.c.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                c.a.n0.n.o.c.a(cursor);
                throw th;
            }
            c.a.n0.n.o.c.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }
}
