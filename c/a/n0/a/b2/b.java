package c.a.n0.a.b2;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.e.e;
import c.a.n0.a.k1.f;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public float f3918b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f3919c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f3920d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f3921e;

    /* renamed from: f  reason: collision with root package name */
    public List<Float> f3922f;

    /* renamed from: g  reason: collision with root package name */
    public List<Float> f3923g;

    /* renamed from: h  reason: collision with root package name */
    public List<Float> f3924h;
    public List<Float> i;
    public a j;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: b  reason: collision with root package name */
        public float f3925b;

        /* renamed from: c  reason: collision with root package name */
        public float f3926c;

        /* renamed from: d  reason: collision with root package name */
        public float f3927d;

        /* renamed from: e  reason: collision with root package name */
        public float f3928e;

        /* renamed from: f  reason: collision with root package name */
        public float f3929f;

        /* renamed from: g  reason: collision with root package name */
        public int f3930g;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static float a(List<Float> list, List<Long> list2, long j, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, list2, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
                if (j == 0 || list == null || list.isEmpty() || list2 == null || list2.isEmpty() || list.size() != list2.size()) {
                    return 0.0f;
                }
                c.a.n0.a.u.d.b("SwanAppStabilityData", "#calcFirstAndMaxMemDiff memList=" + list + " timeList=" + list2 + " fmp=" + j + " isBefore=" + z);
                float f2 = Float.MIN_VALUE;
                Float f3 = list.get(0);
                float floatValue = f3 != null ? f3.floatValue() : 0.0f;
                for (int i = 0; i < list.size(); i++) {
                    Long l = list2.get(i);
                    Float f4 = list.get(i);
                    if (l != null && f4 != null) {
                        if (z) {
                            if (l.longValue() <= j) {
                                f2 = Math.max(f2, f4.floatValue());
                            }
                        } else if (l.longValue() >= j) {
                            f2 = Math.max(f2, f4.floatValue());
                        }
                    }
                }
                return f2 - floatValue;
            }
            return invokeCommon.floatValue;
        }

        public static float b(List<Integer> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
                int i = 0;
                float f2 = 0.0f;
                for (Integer num : list) {
                    if (num != null && num.intValue() > 0) {
                        i++;
                        f2 += num.intValue();
                    }
                }
                if (i == 0) {
                    return 0.0f;
                }
                return f2 / i;
            }
            return invokeL.floatValue;
        }

        public static long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f.a.a().a : invokeV.longValue;
        }

        public static long d() {
            InterceptResult invokeV;
            c.a.n0.a.x.g.f o;
            c.a.n0.a.f.e.b m3;
            c.a.n0.a.f.e.j.d P;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                g V = c.a.n0.a.w0.f.U().V();
                if (V == null || (o = V.o()) == null || (m3 = o.m3()) == null) {
                    return 0L;
                }
                e m = m3.m();
                if (m == null) {
                    P = m3.P();
                } else {
                    P = m.P();
                }
                if (P == null) {
                    return 0L;
                }
                return P.f4339c;
            }
            return invokeV.longValue;
        }

        public static float e(List<Float> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
                float f2 = 0.0f;
                if (list == null || list.isEmpty()) {
                    return 0.0f;
                }
                int i = 0;
                for (Float f3 : list) {
                    if (f3 != null) {
                        i++;
                        f2 += f3.floatValue();
                    }
                }
                if (i == 0) {
                    return -1.0f;
                }
                return f2 / i;
            }
            return invokeL.floatValue;
        }

        public static float f(List<Float> list, List<Long> list2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{list, list2, Long.valueOf(j)})) == null) ? a(list, list2, j, true) : invokeCommon.floatValue;
        }

        public static float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                PMSAppInfo u = c.a.n0.q.f.a.i().u(c.a.n0.a.t1.d.J().getAppId());
                if (u == null) {
                    return 0.0f;
                }
                return ((float) u.pkgSize) / 1024.0f;
            }
            return invokeV.floatValue;
        }

        public static int h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) {
                int i = 0;
                for (c.a.n0.a.x.i.g.d.a aVar : c.a.n0.a.x.i.g.d.b.d().c()) {
                    if (aVar != null && aVar.e() < j) {
                        i++;
                    }
                }
                return i;
            }
            return invokeJ.intValue;
        }

        public static float i(List<Float> list, List<Long> list2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{list, list2, Long.valueOf(j)})) == null) ? a(list, list2, j, false) : invokeCommon.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "VerificationData{mFmp=" + this.a + ", mMainPkgSize=" + this.f3925b + ", mIdleCpuAvg=" + this.f3926c + ", mFpsAvg=" + this.f3927d + ", mLaunchDiffMem=" + this.f3928e + ", mRunningDiffMem=" + this.f3929f + ", mLaunchRequestCount=" + this.f3930g + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public b() {
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
        this.a = 500;
        this.f3918b = 0.0f;
        this.f3919c = new ConcurrentSkipListSet();
        this.f3920d = new CopyOnWriteArrayList();
        this.f3921e = new CopyOnWriteArrayList();
        this.f3922f = new CopyOnWriteArrayList();
        this.f3923g = new CopyOnWriteArrayList();
        this.f3924h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new a();
    }

    public void a(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            a aVar = this.j;
            Pair<Long, Long> b2 = b(10000);
            long longValue = ((Long) b2.first).longValue();
            aVar.a = ((Long) b2.second).longValue();
            aVar.f3926c = a.e(list);
            aVar.f3925b = a.g();
            aVar.f3928e = a.f(this.i, this.f3920d, longValue);
            aVar.f3929f = a.i(this.i, this.f3920d, longValue);
            aVar.f3930g = a.h(longValue);
            aVar.f3927d = a.b(this.f3921e);
        }
    }

    public final Pair<Long, Long> b(int i) {
        InterceptResult invokeI;
        long c2;
        long d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            long currentTimeMillis = i + System.currentTimeMillis();
            do {
                c2 = a.c();
                d2 = a.d();
                if (c2 > 0 && d2 > 0) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100L);
                } catch (InterruptedException e2) {
                    c.a.n0.a.u.d.l("SwanAppStabilityData", "sleep 中断", e2);
                }
            } while (currentTimeMillis > System.currentTimeMillis());
            c.a.n0.a.u.d.i("SwanAppStabilityData", "fmpTimestamp=" + d2 + " fmp=" + c2);
            return Pair.create(Long.valueOf(d2), Long.valueOf(c2));
        }
        return (Pair) invokeI.objValue;
    }

    @NonNull
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.valueOf(JSONObject.wrap(d())) : (String) invokeV.objValue;
    }

    @NonNull
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TreeMap treeMap = new TreeMap();
            try {
                treeMap.put("obtainInterval", String.valueOf(this.a));
                treeMap.put("totalMem", String.valueOf(this.f3918b));
                treeMap.put("prelinkUrlList", JSONObject.wrap(this.f3919c).toString());
                treeMap.put("timestampList", JSONObject.wrap(this.f3920d).toString());
                treeMap.put("fpsList", JSONObject.wrap(this.f3921e).toString());
                treeMap.put("cpuList", JSONObject.wrap(this.f3922f).toString());
                treeMap.put("deviceMemList", JSONObject.wrap(this.f3923g).toString());
                treeMap.put("hostMemList", JSONObject.wrap(this.f3924h).toString());
                treeMap.put("mnpMemList", JSONObject.wrap(this.i).toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fmp", String.valueOf(this.j.a));
                jSONObject.put("mainPkgSize", String.valueOf(this.j.f3925b));
                jSONObject.put("idleCpuAvg", String.valueOf(this.j.f3926c));
                jSONObject.put("fpsAvg", String.valueOf(this.j.f3927d));
                jSONObject.put("launchMemDiff", String.valueOf(this.j.f3928e));
                jSONObject.put("runningMemDiff", String.valueOf(this.j.f3929f));
                jSONObject.put("launchRequestCount", String.valueOf(this.j.f3930g));
                treeMap.put("verificationData", jSONObject.toString());
            } catch (Exception e2) {
                c.a.n0.a.u.d.l("SwanAppStabilityData", "#toMap 出错", e2);
            }
            return treeMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "SwanAppStabilityData{mObtainInterval=" + this.a + ", mTotalMem=" + this.f3918b + ", mPrelinkUrlList=" + this.f3919c + ", mTimestampList=" + this.f3920d + ", mFpsList=" + this.f3921e + ", mCpuList=" + this.f3922f + ", mDeviceMemList=" + this.f3923g + ", mHostMemList=" + this.f3924h + ", mMnpMemList=" + this.i + ", mVerificationData=" + this.j + '}';
        }
        return (String) invokeV.objValue;
    }
}
