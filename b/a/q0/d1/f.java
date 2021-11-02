package b.a.q0.d1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f12100a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f12101b;

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f12102c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f12103d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12104e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12104e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                String p = b.a.q0.s.e0.b.j().p("old_sniff_url", "");
                if (TextUtils.isEmpty(this.f12104e) || this.f12104e.equals(p)) {
                    f.q(false);
                    return;
                }
                File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
                if (!file.exists()) {
                    file.mkdir();
                }
                if (d.c().a(new File(file, "sniff.json"), this.f12104e) > 0) {
                    b.a.q0.s.e0.b.j().x("old_sniff_url", "");
                }
                f.q(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f12105e;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12105e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (f.f12100a == null || this.f12105e) {
                    f.h();
                }
                f.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c<X, Y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final X f12106a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f12107b;

        public c(X x, Y y) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x, y};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12106a = x;
            this.f12107b = y;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-89903762, "Lb/a/q0/d1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-89903762, "Lb/a/q0/d1/f;");
                return;
            }
        }
        f12101b = new ArrayList<>();
        f12102c = new Hashtable<>();
        f12103d = true;
    }

    public f() {
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

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f12101b.size() > 0) {
                return j();
            }
            return g();
        }
        return (String) invokeV.objValue;
    }

    public static void f(PackageManager packageManager, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65543, null, packageManager, str, i2, i3) == null) {
            try {
                packageManager.getApplicationInfo(str, 0);
                k(i2, i3);
            } catch (PackageManager.NameNotFoundException unused) {
                l(i2, i3);
            }
        }
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String p = b.a.q0.s.e0.b.j().p("AD_SNIFF_RESULT_KEY", "");
            if (!TextUtils.isEmpty(p)) {
                ArrayList<Long> arrayList = new ArrayList<>();
                for (String str : p.split(",")) {
                    arrayList.add(Long.valueOf(str));
                }
                f12101b = arrayList;
            } else {
                q(false);
            }
            return p;
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
                    synchronized (f.class) {
                        try {
                            f12100a = new JSONObject(readFileData);
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
            h.d.f("").k(Schedulers.io()).w(new a(str));
        }
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ArrayList<Long> arrayList = f12101b;
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

    public static void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f12101b;
            if (i2 < arrayList.size()) {
                arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() | (1 << i3)));
            }
        }
    }

    public static void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i2, i3) == null) {
            ArrayList<Long> arrayList = f12101b;
            if (i2 < arrayList.size()) {
                arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() & (~(1 << i3))));
            }
        }
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            l(i2, 0);
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, null, i2) == null) {
            k(i2, 0);
        }
    }

    public static void o(int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65552, null, i2, jSONArray) == null) || i2 >= f12101b.size()) {
            return;
        }
        PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
        m(i2);
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            String optString = jSONArray.optString(i3);
            i3++;
            c<Integer, Integer> cVar = new c<>(Integer.valueOf(i2), Integer.valueOf(i3));
            ArrayList<c<Integer, Integer>> arrayList = f12102c.get(optString);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(cVar);
            f12102c.put(optString, arrayList);
            f(packageManager, optString, i2, i3);
        }
        n(i2);
        b.a.q0.s.e0.b.j().x("AD_SNIFF_RESULT_KEY", j());
    }

    public static void p() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, null) == null) || (jSONObject = f12100a) == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f12101b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 < size) {
                arrayList.add(f12101b.get(i2));
            } else {
                arrayList.add(0L);
            }
        }
        f12101b = arrayList;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject == null) {
                return;
            }
            r(i3, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f12103d);
        }
        if (f12103d) {
            f12103d = false;
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            h.d.f("").k(Schedulers.io()).w(new b(z));
        }
    }

    public static void r(int i2, String str, int i3, JSONArray jSONArray, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), jSONArray, Boolean.valueOf(z)}) == null) || i2 < 0 || TextUtils.isEmpty(str) || i3 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long l = b.a.q0.s.e0.b.j().l(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i3);
        boolean z2 = true;
        int i4 = (l > 0L ? 1 : (l == 0L ? 0 : -1));
        boolean z3 = i4 == 0;
        z2 = (i4 <= 0 || time - l <= millis) ? false : false;
        if (z || z3 || z2) {
            b.a.q0.s.e0.b.j().w(str2, time);
            o(i2, jSONArray);
        }
    }

    public static void s(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, intent) == null) || TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f12102c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.f12106a.intValue();
                int intValue2 = next.f12107b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}
