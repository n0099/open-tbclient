package c.a.g0.s.e;

import c.a.g0.r.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.a.g0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0118a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3261b;

        /* renamed from: c  reason: collision with root package name */
        public long f3262c;

        /* renamed from: d  reason: collision with root package name */
        public long f3263d;

        /* renamed from: e  reason: collision with root package name */
        public long f3264e;

        /* renamed from: f  reason: collision with root package name */
        public String f3265f;

        /* renamed from: g  reason: collision with root package name */
        public int f3266g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0119a> f3267h;

        /* renamed from: c.a.g0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0119a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3268b;

            public C0119a() {
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

            public static C0119a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0119a c0119a = new C0119a();
                    c0119a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0119a.f3268b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0119a;
                }
                return (C0119a) invokeL.objValue;
            }

            public static JSONObject b(C0119a c0119a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0119a)) == null) {
                    if (c0119a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0119a.a);
                        jSONObject.put("valid", c0119a.f3268b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0119a> c(JSONArray jSONArray) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
                    if (jSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        jSONArray.get(0);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(a((JSONObject) jSONArray.opt(i2)));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    return arrayList;
                }
                return (List) invokeL.objValue;
            }
        }

        public C0118a() {
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
            this.a = 2;
        }

        public static JSONObject a(C0118a c0118a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0118a)) == null) {
                if (c0118a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0118a.a);
                    jSONObject.put("msg", c0118a.f3261b);
                    jSONObject.put("totalAmount", c0118a.f3262c);
                    jSONObject.put("userPayAmount", c0118a.f3263d);
                    jSONObject.put("reduceAmount", c0118a.f3264e);
                    jSONObject.put("overdueStatus", c0118a.f3266g);
                    jSONObject.put("usedHostMarketingDetail", c0118a.f3265f);
                    if (c0118a.f3267h != null && !c0118a.f3267h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0119a c0119a : c0118a.f3267h) {
                            jSONArray.put(C0119a.b(c0119a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3261b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3262c + ", userPayAmount=" + this.f3263d + ", reduceAmount=" + this.f3264e + ", usedHostMarketingDetail='" + this.f3265f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3266g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0118a c0118a);
}
