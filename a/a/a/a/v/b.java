package a.a.a.a.v;

import a.a.a.a.v.c;
import a.a.a.a.v.d;
import a.a.a.a.v.e;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
    public long f1318a;

    /* renamed from: b  reason: collision with root package name */
    public int f1319b;

    /* renamed from: c  reason: collision with root package name */
    public int f1320c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<e> f1321d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f1322e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<c> f1323f;

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
        this.f1321d = new HashSet();
        this.f1322e = new HashSet();
        this.f1323f = new HashSet();
    }

    public static float a(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 < f3 ? f3 : f2 > f4 ? f4 : f2 : invokeCommon.floatValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j < j2 ? j2 : j > j3 ? j3 : j : invokeCommon.longValue;
    }

    @VisibleForTesting
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (e eVar : this.f1321d) {
                if (hashSet.contains(eVar.f1342c)) {
                    a.a.a.a.y.d.b("Duplicate ssp:type(%s) found.", eVar.f1342c);
                    return false;
                }
                hashSet.add(eVar.f1342c);
                for (e.a aVar : eVar.f1343d) {
                    if (hashSet2.contains(Long.valueOf(aVar.f1344b))) {
                        a.a.a.a.y.d.b("Duplicate pid(%d) found.", Long.valueOf(aVar.f1344b));
                        return false;
                    }
                    hashSet2.add(Long.valueOf(aVar.f1344b));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (d dVar : this.f1322e) {
                if (hashSet3.contains(dVar.f1331b)) {
                    a.a.a.a.y.d.b("Duplicate sid(%s) found in SlotId", dVar.f1331b);
                    return false;
                }
                hashSet3.add(dVar.f1331b);
                for (d.b bVar : dVar.f1334e) {
                    HashSet hashSet4 = new HashSet();
                    for (d.a aVar2 : bVar.f1340c) {
                        if (!hashSet2.contains(Long.valueOf(aVar2.f1335b))) {
                            a.a.a.a.y.d.b("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar2.f1335b));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(aVar2.f1335b))) {
                            a.a.a.a.y.d.b("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar2.f1335b), dVar.f1331b);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(aVar2.f1335b));
                        }
                    }
                }
            }
            if (this.f1320c == 2) {
                for (c cVar : this.f1323f) {
                    if (hashSet3.contains(cVar.f1324b)) {
                        a.a.a.a.y.d.b("Duplicate sid(%s) found in SerialSlotId.", cVar.f1324b);
                        return false;
                    }
                    hashSet3.add(cVar.f1324b);
                    for (c.b bVar2 : cVar.f1325c) {
                        for (c.a aVar3 : bVar2.f1330c) {
                            if (!hashSet2.contains(Long.valueOf(aVar3.f1326b))) {
                                a.a.a.a.y.d.b("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar3.f1326b));
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
                a.a.a.a.y.d.c("Config parsed over.", new Object[0]);
                if (a()) {
                    a.a.a.a.y.b.a(this.f1318a, this.f1319b, this.f1320c, new a(this.f1321d, this.f1322e, this.f1323f));
                    a.a.a.a.y.d.c("Config persisted over.", new Object[0]);
                    return true;
                }
            } catch (JSONException e2) {
                a.a.a.a.y.d.a(e2);
            }
            this.f1321d.clear();
            this.f1322e.clear();
            this.f1323f.clear();
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
            this.f1318a = a(jSONObject2.getLong("ver"), 0L);
            int i2 = jSONObject2.getInt("interval");
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 1440) {
                i2 = 1440;
            }
            this.f1319b = i2;
            this.f1320c = a(jSONObject2.optInt("V", 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                e eVar = new e(jSONArray.getJSONObject(i3));
                for (e.a aVar : eVar.f1343d) {
                    hashMap.put(Long.valueOf(aVar.f1344b), aVar);
                }
                this.f1321d.add(eVar);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                this.f1322e.add(new d(jSONArray2.getJSONObject(i4), hashMap));
            }
            if (this.f1320c != 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
                return;
            }
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                this.f1323f.add(new c(optJSONArray.getJSONObject(i5), hashMap));
            }
        }
    }
}
