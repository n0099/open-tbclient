package c.a.e0.j.e;

import c.a.e0.i.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.e0.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0129a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f2845b;

        /* renamed from: c  reason: collision with root package name */
        public long f2846c;

        /* renamed from: d  reason: collision with root package name */
        public long f2847d;

        /* renamed from: e  reason: collision with root package name */
        public long f2848e;

        /* renamed from: f  reason: collision with root package name */
        public String f2849f;

        /* renamed from: g  reason: collision with root package name */
        public int f2850g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0130a> f2851h;

        /* renamed from: c.a.e0.j.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0130a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f2852b;

            public C0130a() {
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

            public static C0130a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0130a c0130a = new C0130a();
                    c0130a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0130a.f2852b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0130a;
                }
                return (C0130a) invokeL.objValue;
            }

            public static JSONObject b(C0130a c0130a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0130a)) == null) {
                    if (c0130a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0130a.a);
                        jSONObject.put("valid", c0130a.f2852b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0130a> c(JSONArray jSONArray) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
                    if (jSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        jSONArray.get(0);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(a((JSONObject) jSONArray.opt(i)));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    return arrayList;
                }
                return (List) invokeL.objValue;
            }
        }

        public C0129a() {
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
            this.a = 2;
        }

        public static JSONObject a(C0129a c0129a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0129a)) == null) {
                if (c0129a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("statusCode", c0129a.a);
                    jSONObject.put("msg", c0129a.f2845b);
                    jSONObject.put("totalAmount", c0129a.f2846c);
                    jSONObject.put("userPayAmount", c0129a.f2847d);
                    jSONObject.put("reduceAmount", c0129a.f2848e);
                    jSONObject.put("overdueStatus", c0129a.f2850g);
                    jSONObject.put("usedHostMarketingDetail", c0129a.f2849f);
                    if (c0129a.f2851h != null && !c0129a.f2851h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0130a c0130a : c0129a.f2851h) {
                            jSONArray.put(C0130a.b(c0130a));
                        }
                        jSONObject.put("promotionStatus", jSONArray);
                    }
                } catch (JSONException e2) {
                    h.d(e2.getMessage());
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Data{statusCode=" + this.a + ", message='" + this.f2845b + "', totalAmount=" + this.f2846c + ", userPayAmount=" + this.f2847d + ", reduceAmount=" + this.f2848e + ", usedHostMarketingDetail='" + this.f2849f + "', overdueStatus='" + this.f2850g + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0129a c0129a);
}
