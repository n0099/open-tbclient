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
    public static class C0141a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3722b;

        /* renamed from: c  reason: collision with root package name */
        public long f3723c;

        /* renamed from: d  reason: collision with root package name */
        public long f3724d;

        /* renamed from: e  reason: collision with root package name */
        public long f3725e;

        /* renamed from: f  reason: collision with root package name */
        public String f3726f;

        /* renamed from: g  reason: collision with root package name */
        public int f3727g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0142a> f3728h;

        /* renamed from: c.a.h0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0142a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3729b;

            public C0142a() {
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

            public static C0142a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0142a c0142a = new C0142a();
                    c0142a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0142a.f3729b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0142a;
                }
                return (C0142a) invokeL.objValue;
            }

            public static JSONObject b(C0142a c0142a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0142a)) == null) {
                    if (c0142a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0142a.a);
                        jSONObject.put("valid", c0142a.f3729b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0142a> c(JSONArray jSONArray) {
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
                    return;
                }
            }
            this.a = 2;
        }

        public static JSONObject a(C0141a c0141a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0141a)) == null) {
                if (c0141a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0141a.a);
                    jSONObject.put("msg", c0141a.f3722b);
                    jSONObject.put("totalAmount", c0141a.f3723c);
                    jSONObject.put("userPayAmount", c0141a.f3724d);
                    jSONObject.put("reduceAmount", c0141a.f3725e);
                    jSONObject.put("overdueStatus", c0141a.f3727g);
                    jSONObject.put("usedHostMarketingDetail", c0141a.f3726f);
                    if (c0141a.f3728h != null && !c0141a.f3728h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0142a c0142a : c0141a.f3728h) {
                            jSONArray.put(C0142a.b(c0142a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3722b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3723c + ", userPayAmount=" + this.f3724d + ", reduceAmount=" + this.f3725e + ", usedHostMarketingDetail='" + this.f3726f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3727g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0141a c0141a);
}
