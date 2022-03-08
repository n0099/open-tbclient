package c.a.f0.j.e;

import c.a.f0.i.h;
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

    /* renamed from: c.a.f0.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0140a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3403b;

        /* renamed from: c  reason: collision with root package name */
        public long f3404c;

        /* renamed from: d  reason: collision with root package name */
        public long f3405d;

        /* renamed from: e  reason: collision with root package name */
        public long f3406e;

        /* renamed from: f  reason: collision with root package name */
        public String f3407f;

        /* renamed from: g  reason: collision with root package name */
        public int f3408g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0141a> f3409h;

        /* renamed from: c.a.f0.j.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0141a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3410b;

            public C0141a() {
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

            public static C0141a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0141a c0141a = new C0141a();
                    c0141a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0141a.f3410b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0141a;
                }
                return (C0141a) invokeL.objValue;
            }

            public static JSONObject b(C0141a c0141a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0141a)) == null) {
                    if (c0141a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0141a.a);
                        jSONObject.put("valid", c0141a.f3410b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0141a> c(JSONArray jSONArray) {
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

        public C0140a() {
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

        public static JSONObject a(C0140a c0140a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0140a)) == null) {
                if (c0140a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0140a.a);
                    jSONObject.put("msg", c0140a.f3403b);
                    jSONObject.put("totalAmount", c0140a.f3404c);
                    jSONObject.put("userPayAmount", c0140a.f3405d);
                    jSONObject.put("reduceAmount", c0140a.f3406e);
                    jSONObject.put("overdueStatus", c0140a.f3408g);
                    jSONObject.put("usedHostMarketingDetail", c0140a.f3407f);
                    if (c0140a.f3409h != null && !c0140a.f3409h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0141a c0141a : c0140a.f3409h) {
                            jSONArray.put(C0141a.b(c0141a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3403b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3404c + ", userPayAmount=" + this.f3405d + ", reduceAmount=" + this.f3406e + ", usedHostMarketingDetail='" + this.f3407f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3408g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0140a c0140a);
}
