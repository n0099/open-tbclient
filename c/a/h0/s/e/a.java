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
    public static class C0149a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3668b;

        /* renamed from: c  reason: collision with root package name */
        public long f3669c;

        /* renamed from: d  reason: collision with root package name */
        public long f3670d;

        /* renamed from: e  reason: collision with root package name */
        public long f3671e;

        /* renamed from: f  reason: collision with root package name */
        public String f3672f;

        /* renamed from: g  reason: collision with root package name */
        public int f3673g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0150a> f3674h;

        /* renamed from: c.a.h0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0150a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3675b;

            public C0150a() {
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

            public static C0150a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0150a c0150a = new C0150a();
                    c0150a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0150a.f3675b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0150a;
                }
                return (C0150a) invokeL.objValue;
            }

            public static JSONObject b(C0150a c0150a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0150a)) == null) {
                    if (c0150a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0150a.a);
                        jSONObject.put("valid", c0150a.f3675b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0150a> c(JSONArray jSONArray) {
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

        public C0149a() {
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

        public static JSONObject a(C0149a c0149a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0149a)) == null) {
                if (c0149a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0149a.a);
                    jSONObject.put("msg", c0149a.f3668b);
                    jSONObject.put("totalAmount", c0149a.f3669c);
                    jSONObject.put("userPayAmount", c0149a.f3670d);
                    jSONObject.put("reduceAmount", c0149a.f3671e);
                    jSONObject.put("overdueStatus", c0149a.f3673g);
                    jSONObject.put("usedHostMarketingDetail", c0149a.f3672f);
                    if (c0149a.f3674h != null && !c0149a.f3674h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0150a c0150a : c0149a.f3674h) {
                            jSONArray.put(C0150a.b(c0150a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3668b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3669c + ", userPayAmount=" + this.f3670d + ", reduceAmount=" + this.f3671e + ", usedHostMarketingDetail='" + this.f3672f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3673g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0149a c0149a);
}
