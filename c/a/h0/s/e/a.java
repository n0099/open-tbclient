package c.a.h0.s.e;

import c.a.h0.r.h;
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

    /* renamed from: c.a.h0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0158a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3809b;

        /* renamed from: c  reason: collision with root package name */
        public long f3810c;

        /* renamed from: d  reason: collision with root package name */
        public long f3811d;

        /* renamed from: e  reason: collision with root package name */
        public long f3812e;

        /* renamed from: f  reason: collision with root package name */
        public String f3813f;

        /* renamed from: g  reason: collision with root package name */
        public int f3814g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0159a> f3815h;

        /* renamed from: c.a.h0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0159a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3816b;

            public C0159a() {
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

            public static C0159a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0159a c0159a = new C0159a();
                    c0159a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0159a.f3816b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0159a;
                }
                return (C0159a) invokeL.objValue;
            }

            public static JSONObject b(C0159a c0159a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0159a)) == null) {
                    if (c0159a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0159a.a);
                        jSONObject.put("valid", c0159a.f3816b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0159a> c(JSONArray jSONArray) {
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

        public C0158a() {
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

        public static JSONObject a(C0158a c0158a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0158a)) == null) {
                if (c0158a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0158a.a);
                    jSONObject.put("msg", c0158a.f3809b);
                    jSONObject.put("totalAmount", c0158a.f3810c);
                    jSONObject.put("userPayAmount", c0158a.f3811d);
                    jSONObject.put("reduceAmount", c0158a.f3812e);
                    jSONObject.put("overdueStatus", c0158a.f3814g);
                    jSONObject.put("usedHostMarketingDetail", c0158a.f3813f);
                    if (c0158a.f3815h != null && !c0158a.f3815h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0159a c0159a : c0158a.f3815h) {
                            jSONArray.put(C0159a.b(c0159a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3809b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3810c + ", userPayAmount=" + this.f3811d + ", reduceAmount=" + this.f3812e + ", usedHostMarketingDetail='" + this.f3813f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3814g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0158a c0158a);
}
