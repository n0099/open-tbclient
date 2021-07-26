package a.a.a.a.s;

import a.a.a.a.s.d;
import a.a.a.a.s.e;
import a.a.a.a.s.h;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f1320a;

    /* renamed from: b  reason: collision with root package name */
    public int f1321b;

    /* renamed from: c  reason: collision with root package name */
    public int f1322c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<h> f1323d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<e> f1324e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f1325f;

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
        this.f1323d = new HashSet();
        this.f1324e = new HashSet();
        this.f1325f = new HashSet();
    }

    public static double a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? d2 < d3 ? d3 : d2 : invokeCommon.doubleValue;
    }

    public static float a(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 < f3 ? f3 : f2 > f4 ? f4 : f2 : invokeCommon.floatValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i2 < i3) {
                return i3;
            }
            if (i2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return i2;
        }
        return invokeII.intValue;
    }

    public static long a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j < j2) {
                return j2;
            }
            if (j > Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    public static long a(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j < j2 ? j2 : j > j3 ? j3 : j : invokeCommon.longValue;
    }

    @VisibleForTesting
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (h hVar : this.f1323d) {
                if (hashSet.contains(hVar.f1358c)) {
                    a.a.a.a.v.d.b("Duplicate ssp:type(%s) found.", hVar.f1358c);
                    return false;
                }
                hashSet.add(hVar.f1358c);
                for (h.a aVar : hVar.f1359d) {
                    if (hashSet2.contains(Long.valueOf(aVar.f1360b))) {
                        a.a.a.a.v.d.b("Duplicate pid(%d) found.", Long.valueOf(aVar.f1360b));
                        return false;
                    }
                    hashSet2.add(Long.valueOf(aVar.f1360b));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (e eVar : this.f1324e) {
                if (hashSet3.contains(eVar.f1340b)) {
                    a.a.a.a.v.d.b("Duplicate sid(%s) found in SlotId", eVar.f1340b);
                    return false;
                }
                hashSet3.add(eVar.f1340b);
                for (e.b bVar : eVar.f1344f) {
                    HashSet hashSet4 = new HashSet();
                    for (e.a aVar2 : bVar.f1350c) {
                        if (!hashSet2.contains(Long.valueOf(aVar2.f1345b))) {
                            a.a.a.a.v.d.b("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar2.f1345b));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(aVar2.f1345b))) {
                            a.a.a.a.v.d.b("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar2.f1345b), eVar.f1340b);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(aVar2.f1345b));
                        }
                    }
                }
            }
            if (this.f1322c == 2) {
                for (d dVar : this.f1325f) {
                    if (hashSet3.contains(dVar.f1332b)) {
                        a.a.a.a.v.d.b("Duplicate sid(%s) found in SerialSlotId.", dVar.f1332b);
                        return false;
                    }
                    hashSet3.add(dVar.f1332b);
                    for (d.b bVar2 : dVar.f1333c) {
                        for (d.a aVar3 : bVar2.f1339c) {
                            if (!hashSet2.contains(Long.valueOf(aVar3.f1335b))) {
                                a.a.a.a.v.d.b("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar3.f1335b));
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b(str);
                a.a.a.a.v.d.c("Config cfgv:%d parsed over.", Long.valueOf(this.f1320a));
                if (a()) {
                    a.a.a.a.v.b.a(this.f1320a, this.f1321b, this.f1322c, new a(this.f1323d, this.f1324e, this.f1325f));
                    a.a.a.a.v.d.c("Config cfgv:%d persisted over.", Long.valueOf(this.f1320a));
                    return true;
                }
            } catch (JSONException e2) {
                a.a.a.a.v.d.a(e2);
            }
            this.f1323d.clear();
            this.f1324e.clear();
            this.f1325f.clear();
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public void b(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("config");
            this.f1320a = a(jSONObject2.getLong("ver"), 0L);
            int i2 = jSONObject2.getInt("interval");
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 1440) {
                i2 = 1440;
            }
            this.f1321b = i2;
            this.f1322c = a(jSONObject2.optInt("V", 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                h hVar = new h(jSONArray.getJSONObject(i3));
                for (h.a aVar : hVar.f1359d) {
                    hashMap.put(Long.valueOf(aVar.f1360b), aVar);
                }
                this.f1323d.add(hVar);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                this.f1324e.add(new e(jSONArray2.getJSONObject(i4), hashMap));
            }
            if (this.f1322c < 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
                return;
            }
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                this.f1325f.add(new d(optJSONArray.getJSONObject(i5), hashMap));
            }
        }
    }
}
