package b.a.e0.s.e;

import b.a.e0.r.h;
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

    /* renamed from: b.a.e0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2753a;

        /* renamed from: b  reason: collision with root package name */
        public String f2754b;

        /* renamed from: c  reason: collision with root package name */
        public long f2755c;

        /* renamed from: d  reason: collision with root package name */
        public long f2756d;

        /* renamed from: e  reason: collision with root package name */
        public long f2757e;

        /* renamed from: f  reason: collision with root package name */
        public String f2758f;

        /* renamed from: g  reason: collision with root package name */
        public int f2759g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0058a> f2760h;

        /* renamed from: b.a.e0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0058a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f2761a;

            /* renamed from: b  reason: collision with root package name */
            public String f2762b;

            public C0058a() {
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

            public static C0058a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0058a c0058a = new C0058a();
                    c0058a.f2761a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0058a.f2762b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0058a;
                }
                return (C0058a) invokeL.objValue;
            }

            public static JSONObject b(C0058a c0058a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0058a)) == null) {
                    if (c0058a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0058a.f2761a);
                        jSONObject.put("valid", c0058a.f2762b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0058a> c(JSONArray jSONArray) {
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

        public C0057a() {
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
            this.f2753a = 2;
        }

        public static JSONObject a(C0057a c0057a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0057a)) == null) {
                if (c0057a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0057a.f2753a);
                    jSONObject.put("msg", c0057a.f2754b);
                    jSONObject.put("totalAmount", c0057a.f2755c);
                    jSONObject.put("userPayAmount", c0057a.f2756d);
                    jSONObject.put("reduceAmount", c0057a.f2757e);
                    jSONObject.put("overdueStatus", c0057a.f2759g);
                    jSONObject.put("usedHostMarketingDetail", c0057a.f2758f);
                    if (c0057a.f2760h != null && !c0057a.f2760h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0058a c0058a : c0057a.f2760h) {
                            jSONArray.put(C0058a.b(c0058a));
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
                return "Data{statusCode=" + this.f2753a + ", message='" + this.f2754b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f2755c + ", userPayAmount=" + this.f2756d + ", reduceAmount=" + this.f2757e + ", usedHostMarketingDetail='" + this.f2758f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f2759g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0057a c0057a);
}
