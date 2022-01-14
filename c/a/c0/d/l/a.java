package c.a.c0.d.l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.g0.h;
import c.a.c0.u.d;
import c.a.c0.u.i;
import c.a.c0.u.j;
import c.a.c0.y.e;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1790b;

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f1791c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<Long> f1792d;

    /* renamed from: e  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c.a.c0.d.l.b<Integer, Integer>>> f1793e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1794f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.c0.y.b f1795g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.c0.d.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0045a implements Runnable {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final RunnableC0045a f1796e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1741534361, "Lc/a/c0/d/l/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1741534361, "Lc/a/c0/d/l/a$a;");
                    return;
                }
            }
            f1796e = new RunnableC0045a();
        }

        public RunnableC0045a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.g();
                a.n();
                a.i(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> implements c.a.c0.n.a<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f1797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1798c;

        public b(long j2, File file, File file2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), file, file2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2;
            this.f1797b = file;
            this.f1798c = file2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.n.a
        /* renamed from: a */
        public final void accept(j res) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, res) == null) {
                Intrinsics.checkNotNullParameter(res, "res");
                boolean z = false;
                if (res.isSuccess()) {
                    a.d().g("iadex_sp_key_etag", res.a());
                    a.d().g("iadex_sp_key_modified_time", res.b());
                    a.d().f("iadex_last_update_time", this.a);
                    if (res.c() > 0 && h.a(this.f1797b, new File(this.f1798c, "iadex.json")) > 0) {
                        z = true;
                    }
                } else {
                    this.f1797b.deleteOnExit();
                }
                if (z) {
                    a.g();
                    a.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(749024964, "Lc/a/c0/d/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(749024964, "Lc/a/c0/d/l/a;");
                return;
            }
        }
        a = new AtomicInteger(0);
        f1790b = "";
        f1792d = new ArrayList<>();
        f1793e = new Hashtable<>();
        f1794f = true;
        c.a.c0.y.b b2 = e.a().b("iad_sp_file");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().getSp(SP_FILE_NAME)");
        f1795g = b2;
    }

    public static final c.a.c0.y.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1795g : (c.a.c0.y.b) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (TextUtils.isEmpty(f1790b)) {
                f1790b = h();
                if (a.compareAndSet(0, 1)) {
                    c.a.c0.d0.b.c(RunnableC0045a.f1796e, "update_iad_ex", 3);
                }
            }
            return f1790b;
        }
        return (String) invokeV.objValue;
    }

    public static final void f(PackageManager packageManager, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65542, null, packageManager, str, i2, i3) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                j(i2, i3);
            } catch (PackageManager.NameNotFoundException unused) {
                k(i2, i3);
            }
        }
    }

    public static final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            Context context = c.a.c0.h.a.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (file.exists()) {
                File file2 = new File(file, "iadex.json");
                if (file2.exists()) {
                    String d2 = h.d(file2);
                    if (TextUtils.isEmpty(d2)) {
                        return;
                    }
                    synchronized (c.a.c0.d.l.b.class) {
                        try {
                            f1791c = new JSONObject(d2);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String string = f1795g.getString("AD_IADEX", "");
            String str = string != null ? string : "";
            Intrinsics.checkNotNullExpressionValue(str, "sp.getString(IADEX_KEY, \"\") ?: \"\"");
            if (!TextUtils.isEmpty(str)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    for (String str2 : (String[]) array) {
                        c.a.c0.x.a.b(arrayList, Long.valueOf(str2));
                    }
                    f1792d = arrayList;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static final boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, null, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f1795g.getLong("iadex_last_update_time", 0L) < TimeUnit.HOURS.toMillis(f1795g.getInt("cdn_expire", 12))) {
                return false;
            }
            String string = f1795g.getString("iadex_sp_key_etag", "");
            String string2 = f1795g.getString("iadex_sp_key_modified_time", "");
            Context context = c.a.c0.h.a.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (file.exists() || file.mkdir()) {
                File file2 = new File(file, "iadex.json.temp");
                d dVar = new d();
                i iVar = new i();
                iVar.a = string;
                iVar.f2287b = string2;
                iVar.f2288c = z;
                dVar.a("https://pn.baidu.com/iad/os_type2_all.json", iVar, file2, new b(currentTimeMillis, file2, file, string));
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public static final void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f1792d;
            if (i2 < arrayList.size()) {
                Long l = arrayList.get(i2);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i2, Long.valueOf(l.longValue() | (1 << i3)));
            }
        }
    }

    public static final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f1792d;
            if (i2 < arrayList.size()) {
                Long l = arrayList.get(i2);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i2, Long.valueOf(l.longValue() & (~(1 << i3))));
            }
        }
    }

    public static final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i2) == null) {
            k(i2, 0);
        }
    }

    public static final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i2) == null) {
            j(i2, 0);
        }
    }

    public static final void n() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (jSONObject = f1791c) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>(f1792d);
        int length = optJSONArray.length();
        int k = c.a.c0.x.a.k(arrayList);
        if (length != k) {
            if (length > k) {
                while (k < length) {
                    c.a.c0.x.a.b(arrayList, 0L);
                    k++;
                }
            } else {
                for (int i2 = length; i2 < k; i2++) {
                    c.a.c0.x.a.i(arrayList, i2);
                }
            }
        }
        f1792d = arrayList;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject == null) {
                return;
            }
            String groupName = optJSONObject.optString("name");
            int optInt = optJSONObject.optInt("interval");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("list");
            Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
            q(i3, groupName, optInt, optJSONArray2, f1794f);
        }
        if (f1794f) {
            f1794f = false;
        }
    }

    public static final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList<Long> arrayList = f1792d;
            if (c.a.c0.x.a.g(arrayList)) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.c0.x.a.b(arrayList2, String.valueOf(it.next().longValue()));
            }
            String join = TextUtils.join(",", arrayList2);
            Intrinsics.checkNotNullExpressionValue(join, "TextUtils.join(IADEX_DELIMITER, tmpFlag)");
            return join;
        }
        return (String) invokeV.objValue;
    }

    public static final void p(int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65552, null, i2, jSONArray) == null) || i2 >= f1792d.size()) {
            return;
        }
        Context context = c.a.c0.h.a.b();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        PackageManager packageManager = context.getPackageManager();
        l(i2);
        int i3 = 0;
        int length = jSONArray.length();
        while (i3 < length) {
            String packageName = jSONArray.optString(i3);
            i3++;
            c.a.c0.d.l.b bVar = new c.a.c0.d.l.b(Integer.valueOf(i2), Integer.valueOf(i3));
            ArrayList<c.a.c0.d.l.b<Integer, Integer>> arrayList = f1793e.get(packageName);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            c.a.c0.x.a.b(arrayList, bVar);
            f1793e.put(packageName, arrayList);
            Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            f(packageManager, packageName, i2, i3);
        }
        m(i2);
        String o = o();
        f1790b = o;
        f1795g.g("AD_IADEX", o);
    }

    public static final void q(int i2, String str, int i3, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), jSONArray, Boolean.valueOf(z)}) == null) || i2 < 0 || TextUtils.isEmpty(str) || i3 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_IADEX_" + str + "_TS";
        long j2 = f1795g.getLong(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i3);
        boolean z2 = true;
        int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        boolean z3 = i4 == 0;
        z2 = (i4 <= 0 || time - j2 <= millis) ? false : false;
        if (z || z3 || z2) {
            f1795g.f(str2, time);
            p(i2, jSONArray);
        }
    }
}
