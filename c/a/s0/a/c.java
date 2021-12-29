package c.a.s0.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String C = "activityid";
    public static String D = "missionid";
    public static String E = "activitysource";
    public static String F = "source";
    public static String G = "tab";
    public static String H = "calltype";
    public static String I = "tasktype";
    public static String J = "browsetimepage";
    public static String K = "browsetime";
    public static String L = "threadnum";
    public static String M = "forumnum";
    public static String N = "cleartype";
    public static String O = "cleartime";
    public static String P = "tid";
    public static String Q = "fid";
    public static String R = "threadtext";
    public static String S = "threadimg";
    public static String T = "threadforum";
    public static String U = "tab_code";
    public static String V = "total_limit";
    public static int W = -1;
    public static int X = 1;
    public static int Y = 2;
    public static int Z = 3;
    public static int a0 = 8;
    public static int b0 = 9;
    public static int c0 = 10;
    public static int d0 = -1;
    public static int e0 = 0;
    public static int f0 = 1;
    public static int g0 = 2;
    public static int h0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public final ArrayList<i> B;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12346b;

    /* renamed from: c  reason: collision with root package name */
    public int f12347c;

    /* renamed from: d  reason: collision with root package name */
    public long f12348d;

    /* renamed from: e  reason: collision with root package name */
    public String f12349e;

    /* renamed from: f  reason: collision with root package name */
    public int f12350f;

    /* renamed from: g  reason: collision with root package name */
    public int f12351g;

    /* renamed from: h  reason: collision with root package name */
    public long f12352h;

    /* renamed from: i  reason: collision with root package name */
    public long f12353i;

    /* renamed from: j  reason: collision with root package name */
    public String f12354j;

    /* renamed from: k  reason: collision with root package name */
    public String f12355k;
    public String l;
    public String m;
    public String n;
    public long o;
    public int p;
    public long q;
    public int[] r;
    public long s;
    public int t;
    public volatile int u;
    public volatile int v;
    public boolean w;
    public int x;
    public volatile int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(252160818, "Lc/a/s0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(252160818, "Lc/a/s0/a/c;");
        }
    }

    public c() {
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
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12350f : invokeV.intValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12352h : invokeV.longValue;
    }

    public final long D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            long u = u();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i2);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() - u;
        }
        return invokeI.longValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : invokeV.intValue;
    }

    public synchronized int G() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this.v + 1;
                this.v = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int H() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.y + 1;
                this.y = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int I() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i2 = this.u + 1;
                this.u = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean J(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            for (int i2 = 0; i2 < this.B.size(); i2++) {
                i iVar = (i) ListUtils.getItem(this.B, i2);
                if (iVar != null) {
                    long m = m(iVar);
                    if (m > 0 && m == j2 && iVar.e()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a > 0 && this.f12346b > 0 && this.f12347c > 0 && this.f12348d > 0 : invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? System.currentTimeMillis() > t() * 1000 : invokeV.booleanValue;
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (c.a.d.f.p.m.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optInt(C);
                this.f12346b = jSONObject.optInt(D);
                this.f12354j = jSONObject.optString(E);
                this.l = jSONObject.optString(F);
                this.f12355k = jSONObject.optString(G);
                this.t = jSONObject.optInt(H);
                int optInt = jSONObject.optInt(I);
                this.f12347c = optInt;
                if (optInt == 15) {
                    this.f12347c = 4;
                }
                String optString = jSONObject.optString(J);
                this.f12349e = optString;
                this.r = Q(optString);
                this.f12348d = jSONObject.optLong(K);
                this.f12350f = jSONObject.optInt(L);
                this.f12351g = jSONObject.optInt(M);
                this.p = jSONObject.optInt(N);
                this.q = jSONObject.optLong(O);
                this.s = c();
                this.f12352h = jSONObject.optLong(P);
                this.f12353i = jSONObject.optLong(Q);
                this.m = jSONObject.optString(R);
                this.n = jSONObject.optString(S);
                this.o = jSONObject.optLong(T);
                int optInt2 = jSONObject.optInt(V);
                if (optInt2 > 0) {
                    this.x = optInt2;
                }
                String optString2 = jSONObject.optString(U);
                if (TextUtils.isEmpty(optString2)) {
                    return true;
                }
                String valueOf = String.valueOf(optString2.hashCode());
                this.f12349e = valueOf;
                this.r = Q(valueOf);
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void O(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, activeCenterMissionData) == null) || activeCenterMissionData == null) {
            return;
        }
        b0(activeCenterMissionData.mission_id);
        m0(activeCenterMissionData.total_limit);
        f0(activeCenterMissionData.task_type);
        S(activeCenterMissionData.active_id);
        Y(activeCenterMissionData.cleartype);
        X(activeCenterMissionData.cleartime);
    }

    public void P(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, str) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    long optLong = jSONObject.optLong("i");
                    long optLong2 = jSONObject.optLong("t");
                    boolean optBoolean = jSONObject.optBoolean("c");
                    int optInt = jSONObject.optInt("a");
                    if (i2 == 7) {
                        if (optLong > 0) {
                            l lVar = new l(this, optLong);
                            lVar.f(optBoolean);
                            lVar.g(optLong2);
                            lVar.h(optInt);
                            a(lVar);
                        }
                    } else if (i2 == 1) {
                        if (optLong > 0) {
                            n nVar = new n(this, optLong);
                            nVar.f(optBoolean);
                            nVar.g(optLong2);
                            nVar.h(optInt);
                            a(nVar);
                        }
                    } else if (i2 == 2) {
                        if (optLong > 0) {
                            k kVar = new k(this, optLong);
                            kVar.f(optBoolean);
                            kVar.g(optLong2);
                            kVar.h(optInt);
                            a(kVar);
                        }
                    } else if (i2 == 4) {
                        j jVar = new j(this);
                        jVar.f(optBoolean);
                        jVar.g(optLong2);
                        jVar.h(optInt);
                        a(jVar);
                    } else if (i2 == 8) {
                        m mVar = new m(this);
                        mVar.f(optBoolean);
                        mVar.g(optLong2);
                        mVar.h(optInt);
                        a(mVar);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final int[] Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            int i2 = this.f12347c;
            if (i2 == 8) {
                return new int[]{W};
            }
            if (i2 == 7) {
                return new int[]{X, a0, b0};
            }
            if (str == null) {
                return null;
            }
            String[] split = str.split(",");
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                int e2 = c.a.d.f.m.b.e(split[i3], 0);
                if (e2 != 0) {
                    iArr[i3] = e2;
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.B.clear();
            this.u = 0;
            this.v = 0;
            this.y = 0;
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.a = i2;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f12354j = str;
        }
    }

    public void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.f12348d = j2;
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f12349e = str;
            this.r = Q(str);
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.t = i2;
        }
    }

    public void X(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.q = j2;
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.p = i2;
        }
    }

    public void Z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            this.f12353i = j2;
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, iVar) == null) {
            if (this.f12347c == 7 && (iVar instanceof l)) {
                if (this.B.contains(iVar)) {
                    return;
                }
                this.B.add(iVar);
            } else if (this.f12347c == 1 && (iVar instanceof n)) {
                if (this.B.contains(iVar)) {
                    return;
                }
                this.B.add(iVar);
            } else if (this.f12347c == 2 && (iVar instanceof k)) {
                if (this.B.contains(iVar)) {
                    return;
                }
                this.B.add(iVar);
            } else if (this.f12347c == 4 && (iVar instanceof j)) {
                if (this.B.contains(iVar)) {
                    return;
                }
                this.B.add(iVar);
            } else if (this.f12347c == 8 && (iVar instanceof m) && !this.B.contains(iVar)) {
                this.B.add(iVar);
            }
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f12351g = i2;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                ArrayList<i> arrayList = this.B;
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    i iVar = (i) ListUtils.getItem(arrayList, i2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("i", m(iVar));
                    jSONObject.put("t", iVar.b());
                    jSONObject.put("c", iVar.e());
                    jSONObject.put("a", iVar.d());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "[]";
            }
        }
        return (String) invokeV.objValue;
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.f12346b = i2;
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i2 = this.p;
            if (i2 == d0) {
                return 0L;
            }
            if (i2 == e0) {
                return this.q + (System.currentTimeMillis() / 1000);
            }
            if (i2 == f0) {
                long u = this.q + (u() / 1000);
                return System.currentTimeMillis() > u ? u + 86400 : u;
            } else if (i2 == g0) {
                return r((int) this.q, D(4)) / 1000;
            } else {
                if (i2 == h0) {
                    return this.q / 1000;
                }
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.w = z;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a : invokeV.intValue;
    }

    public void d0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.s = j2;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f12354j : (String) invokeV.objValue;
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.y = i2;
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f12348d : invokeV.longValue;
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.f12347c = i2;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f12349e : (String) invokeV.objValue;
    }

    public void g0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j2) == null) {
            this.o = j2;
        }
    }

    public int[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.r : (int[]) invokeV.objValue;
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.n = str;
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.t : invokeV.intValue;
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f12350f = i2;
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q : invokeV.longValue;
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.m = str;
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.p : invokeV.intValue;
    }

    public void k0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j2) == null) {
            this.f12352h = j2;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int size = this.B.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = (i) ListUtils.getItem(this.B, i3);
                if ((iVar instanceof l) && ((l) iVar).d() == w()) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.A = str;
        }
    }

    public long m(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, iVar)) == null) {
            if (iVar == null) {
                return 0L;
            }
            if (this.f12347c == 7 && (iVar instanceof l)) {
                return ((l) iVar).i();
            }
            if (this.f12347c == 1 && (iVar instanceof n)) {
                return ((n) iVar).i();
            }
            if (this.f12347c == 2 && (iVar instanceof k)) {
                return ((k) iVar).i();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.x = i2;
        }
    }

    public ArrayList<i> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int size = this.B.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = (i) ListUtils.getItem(this.B, i2);
                if (iVar != null) {
                    iVar.f(true);
                }
            }
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f12353i : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f12351g : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f12346b : invokeV.intValue;
    }

    public final long r(int i2, long j2) {
        InterceptResult invokeCommon;
        long timeInMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            switch (i2) {
                case 1:
                    i2 = 2;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 6;
                    break;
                case 6:
                    i2 = 7;
                    break;
                case 7:
                    i2 = 1;
                    break;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            if (calendar.get(7) == i2 && System.currentTimeMillis() - timeInMillis2 < j2) {
                timeInMillis = calendar.getTimeInMillis();
            } else {
                do {
                    calendar.add(5, 1);
                } while (calendar.get(7) != i2);
                timeInMillis = calendar.getTimeInMillis();
            }
            return timeInMillis + j2;
        }
        return invokeCommon.longValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.s : invokeV.longValue;
    }

    public final long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f12355k : (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.y : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.f12347c : invokeV.intValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.o : invokeV.longValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
        N(str);
    }

    public c(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {missionInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
        if (missionInfo == null) {
            return;
        }
        this.a = missionInfo.activityid.intValue();
        this.f12346b = missionInfo.missionid.intValue();
        this.f12347c = missionInfo.tasktype.intValue();
        this.p = missionInfo.cleartype.intValue();
        this.q = missionInfo.cleartime.intValue();
        this.s = c();
        String str = missionInfo.browsetimepage;
        this.f12349e = str;
        this.r = Q(str);
        if (missionInfo.threadnum.intValue() > 0) {
            this.f12350f = missionInfo.threadnum.intValue();
        }
        if (missionInfo.browsetime.intValue() > 0) {
            this.f12348d = missionInfo.browsetime.intValue();
        }
        if (missionInfo.total_limit.intValue() > 0) {
            this.x = missionInfo.total_limit.intValue();
        }
    }
}
