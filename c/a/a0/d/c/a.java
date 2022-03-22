package c.a.a0.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.h;
import c.a.a0.u.d;
import c.a.a0.u.i;
import c.a.a0.u.j;
import c.a.a0.y.e;
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
    public static String f1091b;

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f1092c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<Long> f1093d;

    /* renamed from: e  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c.a.a0.d.c.b<Integer, Integer>>> f1094e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1095f;

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.a0.y.b f1096g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0014a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final RunnableC0014a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594705998, "Lc/a/a0/d/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1594705998, "Lc/a/a0/d/c/a$a;");
                    return;
                }
            }
            a = new RunnableC0014a();
        }

        public RunnableC0014a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static final class b<T> implements c.a.a0.n.a<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f1097b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f1098c;

        public b(long j, File file, File file2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), file, file2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.f1097b = file;
            this.f1098c = file2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.n.a
        /* renamed from: a */
        public final void accept(j res) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, res) == null) {
                Intrinsics.checkNotNullParameter(res, "res");
                boolean z = false;
                if (res.isSuccess()) {
                    a.d().i("iadex_sp_key_etag", res.a());
                    a.d().i("iadex_sp_key_modified_time", res.b());
                    a.d().h("iadex_last_update_time", this.a);
                    if (res.c() > 0 && h.a(this.f1097b, new File(this.f1098c, "iadex.json")) > 0) {
                        z = true;
                    }
                } else {
                    this.f1097b.deleteOnExit();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(68698475, "Lc/a/a0/d/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(68698475, "Lc/a/a0/d/c/a;");
                return;
            }
        }
        a = new AtomicInteger(0);
        f1091b = "";
        f1093d = new ArrayList<>();
        f1094e = new Hashtable<>();
        f1095f = true;
        c.a.a0.y.b b2 = e.a().b("iad_sp_file");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().getSp(SP_FILE_NAME)");
        f1096g = b2;
    }

    public static final c.a.a0.y.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f1096g : (c.a.a0.y.b) invokeV.objValue;
    }

    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (TextUtils.isEmpty(f1091b)) {
                f1091b = h();
                if (a.compareAndSet(0, 1)) {
                    c.a.a0.d0.b.c(RunnableC0014a.a, "update_iad_ex", 3);
                }
            }
            return f1091b;
        }
        return (String) invokeV.objValue;
    }

    public static final void f(PackageManager packageManager, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65542, null, packageManager, str, i, i2) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                j(i, i2);
            } catch (PackageManager.NameNotFoundException unused) {
                k(i, i2);
            }
        }
    }

    public static final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            Context context = c.a.a0.h.a.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (file.exists()) {
                File file2 = new File(file, "iadex.json");
                if (file2.exists()) {
                    String e2 = h.e(file2);
                    if (TextUtils.isEmpty(e2)) {
                        return;
                    }
                    synchronized (c.a.a0.d.c.b.class) {
                        try {
                            f1092c = new JSONObject(e2);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
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
            String string = f1096g.getString("AD_IADEX", "");
            String str = string != null ? string : "";
            Intrinsics.checkNotNullExpressionValue(str, "sp.getString(IADEX_KEY, \"\") ?: \"\"");
            if (!TextUtils.isEmpty(str)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    for (String str2 : (String[]) array) {
                        c.a.a0.x.a.b(arrayList, Long.valueOf(str2));
                    }
                    f1093d = arrayList;
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
            if (currentTimeMillis - f1096g.getLong("iadex_last_update_time", 0L) < TimeUnit.HOURS.toMillis(f1096g.getInt("cdn_expire", 12))) {
                return false;
            }
            String string = f1096g.getString("iadex_sp_key_etag", "");
            String string2 = f1096g.getString("iadex_sp_key_modified_time", "");
            Context context = c.a.a0.h.a.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            File file = new File(context.getFilesDir(), AdExtParam.KEY_IADEX);
            if (file.exists() || file.mkdir()) {
                File file2 = new File(file, "iadex.json.temp");
                d dVar = new d();
                i iVar = new i();
                iVar.a = string;
                iVar.f1619b = string2;
                iVar.f1620c = z;
                dVar.a("https://pn.baidu.com/iad/os_type2_all.json", iVar, file2, new b(currentTimeMillis, file2, file, string));
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public static final void j(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i, i2) == null) {
            ArrayList<Long> arrayList = f1093d;
            if (i < arrayList.size()) {
                Long l = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i, Long.valueOf(l.longValue() | (1 << i2)));
            }
        }
    }

    public static final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, null, i, i2) == null) {
            ArrayList<Long> arrayList = f1093d;
            if (i < arrayList.size()) {
                Long l = arrayList.get(i);
                Intrinsics.checkNotNullExpressionValue(l, "tCpArray[groupIndex]");
                arrayList.set(i, Long.valueOf(l.longValue() & (~(1 << i2))));
            }
        }
    }

    public static final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i) == null) {
            k(i, 0);
        }
    }

    public static final void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            j(i, 0);
        }
    }

    public static final void n() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (jSONObject = f1092c) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>(f1093d);
        int length = optJSONArray.length();
        int k = c.a.a0.x.a.k(arrayList);
        if (length != k) {
            if (length > k) {
                while (k < length) {
                    c.a.a0.x.a.b(arrayList, 0L);
                    k++;
                }
            } else {
                for (int i = length; i < k; i++) {
                    c.a.a0.x.a.i(arrayList, i);
                }
            }
        }
        f1093d = arrayList;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                return;
            }
            String groupName = optJSONObject.optString("name");
            int optInt = optJSONObject.optInt("interval");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("list");
            Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
            q(i2, groupName, optInt, optJSONArray2, f1095f);
        }
        if (f1095f) {
            f1095f = false;
        }
    }

    public static final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList<Long> arrayList = f1093d;
            if (c.a.a0.x.a.g(arrayList)) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.a0.x.a.b(arrayList2, String.valueOf(it.next().longValue()));
            }
            String join = TextUtils.join(",", arrayList2);
            Intrinsics.checkNotNullExpressionValue(join, "TextUtils.join(IADEX_DELIMITER, tmpFlag)");
            return join;
        }
        return (String) invokeV.objValue;
    }

    public static final void p(int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i, jSONArray) == null) {
            if (i >= f1093d.size()) {
                Log.e("AD_IADEX", "group index should NOT greater or equal group size!!!");
                return;
            }
            Context context = c.a.a0.h.a.b();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            PackageManager packageManager = context.getPackageManager();
            l(i);
            int i2 = 0;
            int length = jSONArray.length();
            while (i2 < length) {
                String packageName = jSONArray.optString(i2);
                i2++;
                c.a.a0.d.c.b bVar = new c.a.a0.d.c.b(Integer.valueOf(i), Integer.valueOf(i2));
                ArrayList<c.a.a0.d.c.b<Integer, Integer>> arrayList = f1094e.get(packageName);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                c.a.a0.x.a.b(arrayList, bVar);
                f1094e.put(packageName, arrayList);
                Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                f(packageManager, packageName, i, i2);
            }
            m(i);
            String o = o();
            f1091b = o;
            f1096g.i("AD_IADEX", o);
        }
    }

    public static final void q(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), jSONArray, Boolean.valueOf(z)}) == null) || i < 0 || TextUtils.isEmpty(str) || i2 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_IADEX_" + str + "_TS";
        long j = f1096g.getLong(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i2);
        boolean z2 = true;
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        boolean z3 = i3 == 0;
        z2 = (i3 <= 0 || time - j <= millis) ? false : false;
        if (z || z3 || z2) {
            f1096g.h(str2, time);
            p(i, jSONArray);
        }
    }
}
