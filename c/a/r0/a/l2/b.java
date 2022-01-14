package c.a.r0.a.l2;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.p.e.e;
import c.a.r0.a.u1.f;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public float f7638b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f7639c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f7640d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f7641e;

    /* renamed from: f  reason: collision with root package name */
    public List<Float> f7642f;

    /* renamed from: g  reason: collision with root package name */
    public List<Float> f7643g;

    /* renamed from: h  reason: collision with root package name */
    public List<Float> f7644h;

    /* renamed from: i  reason: collision with root package name */
    public List<Float> f7645i;

    /* renamed from: j  reason: collision with root package name */
    public a f7646j;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: b  reason: collision with root package name */
        public float f7647b;

        /* renamed from: c  reason: collision with root package name */
        public float f7648c;

        /* renamed from: d  reason: collision with root package name */
        public float f7649d;

        /* renamed from: e  reason: collision with root package name */
        public float f7650e;

        /* renamed from: f  reason: collision with root package name */
        public float f7651f;

        /* renamed from: g  reason: collision with root package name */
        public int f7652g;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static float a(List<Float> list, List<Long> list2, long j2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, list2, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
                if (j2 == 0 || list == null || list.isEmpty() || list2 == null || list2.isEmpty() || list.size() != list2.size()) {
                    return 0.0f;
                }
                c.a.r0.a.e0.d.b("SwanAppStabilityData", "#calcFirstAndMaxMemDiff memList=" + list + " timeList=" + list2 + " fmp=" + j2 + " isBefore=" + z);
                float f2 = Float.MIN_VALUE;
                Float f3 = list.get(0);
                float floatValue = f3 != null ? f3.floatValue() : 0.0f;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Long l = list2.get(i2);
                    Float f4 = list.get(i2);
                    if (l != null && f4 != null) {
                        if (z) {
                            if (l.longValue() <= j2) {
                                f2 = Math.max(f2, f4.floatValue());
                            }
                        } else if (l.longValue() >= j2) {
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
                int i2 = 0;
                float f2 = 0.0f;
                for (Integer num : list) {
                    if (num != null && num.intValue() > 0) {
                        i2++;
                        f2 += num.intValue();
                    }
                }
                if (i2 == 0) {
                    return 0.0f;
                }
                return f2 / i2;
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
            c.a.r0.a.h0.g.f o;
            c.a.r0.a.p.e.b i3;
            c.a.r0.a.p.e.j.d O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                g V = c.a.r0.a.g1.f.U().V();
                if (V == null || (o = V.o()) == null || (i3 = o.i3()) == null) {
                    return 0L;
                }
                e l = i3.l();
                if (l == null) {
                    O = i3.O();
                } else {
                    O = l.O();
                }
                if (O == null) {
                    return 0L;
                }
                return O.f8160c;
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
                int i2 = 0;
                for (Float f3 : list) {
                    if (f3 != null) {
                        i2++;
                        f2 += f3.floatValue();
                    }
                }
                if (i2 == 0) {
                    return -1.0f;
                }
                return f2 / i2;
            }
            return invokeL.floatValue;
        }

        public static float f(List<Float> list, List<Long> list2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{list, list2, Long.valueOf(j2)})) == null) ? a(list, list2, j2, true) : invokeCommon.floatValue;
        }

        public static float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                PMSAppInfo u = c.a.r0.q.g.a.i().u(c.a.r0.a.d2.d.J().getAppId());
                if (u == null) {
                    return 0.0f;
                }
                return ((float) u.pkgSize) / 1024.0f;
            }
            return invokeV.floatValue;
        }

        public static int h(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j2)) == null) {
                int i2 = 0;
                for (c.a.r0.a.h0.i.g.d.a aVar : c.a.r0.a.h0.i.g.d.b.d().c()) {
                    if (aVar != null && aVar.e() < j2) {
                        i2++;
                    }
                }
                return i2;
            }
            return invokeJ.intValue;
        }

        public static float i(List<Float> list, List<Long> list2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{list, list2, Long.valueOf(j2)})) == null) ? a(list, list2, j2, false) : invokeCommon.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "VerificationData{mFmp=" + this.a + ", mMainPkgSize=" + this.f7647b + ", mIdleCpuAvg=" + this.f7648c + ", mFpsAvg=" + this.f7649d + ", mLaunchDiffMem=" + this.f7650e + ", mRunningDiffMem=" + this.f7651f + ", mLaunchRequestCount=" + this.f7652g + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

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
        this.a = 500;
        this.f7638b = 0.0f;
        this.f7639c = new ConcurrentSkipListSet();
        this.f7640d = new CopyOnWriteArrayList();
        this.f7641e = new CopyOnWriteArrayList();
        this.f7642f = new CopyOnWriteArrayList();
        this.f7643g = new CopyOnWriteArrayList();
        this.f7644h = new CopyOnWriteArrayList();
        this.f7645i = new CopyOnWriteArrayList();
        this.f7646j = new a();
    }

    public void a(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            a aVar = this.f7646j;
            Pair<Long, Long> b2 = b(10000);
            long longValue = ((Long) b2.first).longValue();
            aVar.a = ((Long) b2.second).longValue();
            aVar.f7648c = a.e(list);
            aVar.f7647b = a.g();
            aVar.f7650e = a.f(this.f7645i, this.f7640d, longValue);
            aVar.f7651f = a.i(this.f7645i, this.f7640d, longValue);
            aVar.f7652g = a.h(longValue);
            aVar.f7649d = a.b(this.f7641e);
        }
    }

    public final Pair<Long, Long> b(int i2) {
        InterceptResult invokeI;
        long c2;
        long d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            long currentTimeMillis = i2 + System.currentTimeMillis();
            do {
                c2 = a.c();
                d2 = a.d();
                if (c2 > 0 && d2 > 0) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100L);
                } catch (InterruptedException e2) {
                    c.a.r0.a.e0.d.l("SwanAppStabilityData", "sleep 中断", e2);
                }
            } while (currentTimeMillis > System.currentTimeMillis());
            c.a.r0.a.e0.d.i("SwanAppStabilityData", "fmpTimestamp=" + d2 + " fmp=" + c2);
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
                treeMap.put("totalMem", String.valueOf(this.f7638b));
                treeMap.put("prelinkUrlList", JSONObject.wrap(this.f7639c).toString());
                treeMap.put("timestampList", JSONObject.wrap(this.f7640d).toString());
                treeMap.put("fpsList", JSONObject.wrap(this.f7641e).toString());
                treeMap.put("cpuList", JSONObject.wrap(this.f7642f).toString());
                treeMap.put("deviceMemList", JSONObject.wrap(this.f7643g).toString());
                treeMap.put("hostMemList", JSONObject.wrap(this.f7644h).toString());
                treeMap.put("mnpMemList", JSONObject.wrap(this.f7645i).toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fmp", String.valueOf(this.f7646j.a));
                jSONObject.put("mainPkgSize", String.valueOf(this.f7646j.f7647b));
                jSONObject.put("idleCpuAvg", String.valueOf(this.f7646j.f7648c));
                jSONObject.put("fpsAvg", String.valueOf(this.f7646j.f7649d));
                jSONObject.put("launchMemDiff", String.valueOf(this.f7646j.f7650e));
                jSONObject.put("runningMemDiff", String.valueOf(this.f7646j.f7651f));
                jSONObject.put("launchRequestCount", String.valueOf(this.f7646j.f7652g));
                treeMap.put("verificationData", jSONObject.toString());
            } catch (Exception e2) {
                c.a.r0.a.e0.d.l("SwanAppStabilityData", "#toMap 出错", e2);
            }
            return treeMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "SwanAppStabilityData{mObtainInterval=" + this.a + ", mTotalMem=" + this.f7638b + ", mPrelinkUrlList=" + this.f7639c + ", mTimestampList=" + this.f7640d + ", mFpsList=" + this.f7641e + ", mCpuList=" + this.f7642f + ", mDeviceMemList=" + this.f7643g + ", mHostMemList=" + this.f7644h + ", mMnpMemList=" + this.f7645i + ", mVerificationData=" + this.f7646j + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
