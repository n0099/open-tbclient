package c.a.o0.c1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f9949b;

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f9950c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f9951d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements g.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                String q = c.a.o0.r.j0.b.k().q("old_sniff_url", "");
                if (TextUtils.isEmpty(this.a) || this.a.equals(q)) {
                    h.q(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (f.j().b(new File(file, "sniff.json"), this.a) > 0) {
                    c.a.o0.r.j0.b.k().y("old_sniff_url", "");
                }
                h.q(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements g.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (h.a == null || this.a) {
                    h.h();
                }
                h.p();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c<X, Y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f9952b;

        public c(X x, Y y) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x, y};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x;
            this.f9952b = y;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(847602124, "Lc/a/o0/c1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(847602124, "Lc/a/o0/c1/h;");
                return;
            }
        }
        f9949b = new ArrayList<>();
        f9950c = new Hashtable<>();
        f9951d = true;
    }

    public h() {
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

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c.a.p0.a.h().y()) {
                return c.a.a0.d.c.a.e();
            }
            if (f9949b.size() > 0) {
                return j();
            }
            return g();
        }
        return (String) invokeV.objValue;
    }

    public static void f(PackageManager packageManager, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65543, null, packageManager, str, i, i2) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                k(i, i2);
            } catch (PackageManager.NameNotFoundException unused) {
                l(i, i2);
            }
        }
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String q = c.a.o0.r.j0.b.k().q("AD_SNIFF_RESULT_KEY", "");
            if (!TextUtils.isEmpty(q)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                for (String str : q.split(",")) {
                    arrayList.add(Long.valueOf(str));
                }
                f9949b = arrayList;
            } else {
                q(false);
            }
            return q;
        }
        return (String) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (file.exists()) {
                File file2 = new File(file, "sniff.json");
                if (file2.exists()) {
                    String readFileData = FileUtils.readFileData(file2);
                    if (TextUtils.isEmpty(readFileData)) {
                        return;
                    }
                    synchronized (h.class) {
                        try {
                            a = new JSONObject(readFileData);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            g.d.f("").k(Schedulers.io()).w(new a(str));
        }
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ArrayList<Long> arrayList = f9949b;
            if (arrayList == null || arrayList.size() == 0) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(it.next()));
            }
            return TextUtils.join(",", arrayList2);
        }
        return (String) invokeV.objValue;
    }

    public static void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            ArrayList<Long> arrayList = f9949b;
            if (i < arrayList.size()) {
                arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
            }
        }
    }

    public static void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i, i2) == null) {
            ArrayList<Long> arrayList = f9949b;
            if (i < arrayList.size()) {
                arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & (~(1 << i2))));
            }
        }
    }

    public static void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            l(i, 0);
        }
    }

    public static void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, null, i) == null) {
            k(i, 0);
        }
    }

    public static void o(int i, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i, jSONArray) == null) {
            if (i >= f9949b.size()) {
                Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
                return;
            }
            PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
            m(i);
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                String optString = jSONArray.optString(i2);
                i2++;
                c<Integer, Integer> cVar = new c<>(Integer.valueOf(i), Integer.valueOf(i2));
                ArrayList<c<Integer, Integer>> arrayList = f9950c.get(optString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(cVar);
                f9950c.put(optString, arrayList);
                f(packageManager, optString, i, i2);
            }
            n(i);
            c.a.o0.r.j0.b.k().y("AD_SNIFF_RESULT_KEY", j());
        }
    }

    public static void p() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, null) == null) || (jSONObject = a) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f9949b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < size) {
                arrayList.add(f9949b.get(i));
            } else {
                arrayList.add(0L);
            }
        }
        f9949b = arrayList;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                return;
            }
            r(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f9951d);
        }
        if (f9951d) {
            f9951d = false;
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            g.d.f("").k(Schedulers.io()).w(new b(z));
        }
    }

    public static void r(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), jSONArray, Boolean.valueOf(z)}) == null) || i < 0 || TextUtils.isEmpty(str) || i2 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long m = c.a.o0.r.j0.b.k().m(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i2);
        boolean z2 = true;
        int i3 = (m > 0L ? 1 : (m == 0L ? 0 : -1));
        boolean z3 = i3 == 0;
        z2 = (i3 <= 0 || time - m <= millis) ? false : false;
        if (z || z3 || z2) {
            c.a.o0.r.j0.b.k().x(str2, time);
            o(i, jSONArray);
        }
    }

    public static void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, intent) == null) || TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f9950c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.a.intValue();
                int intValue2 = next.f9952b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}
