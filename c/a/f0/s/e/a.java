package c.a.f0.s.e;

import c.a.f0.r.h;
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

    /* renamed from: c.a.f0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0116a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3246b;

        /* renamed from: c  reason: collision with root package name */
        public long f3247c;

        /* renamed from: d  reason: collision with root package name */
        public long f3248d;

        /* renamed from: e  reason: collision with root package name */
        public long f3249e;

        /* renamed from: f  reason: collision with root package name */
        public String f3250f;

        /* renamed from: g  reason: collision with root package name */
        public int f3251g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0117a> f3252h;

        /* renamed from: c.a.f0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0117a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3253b;

            public C0117a() {
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

            public static C0117a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0117a c0117a = new C0117a();
                    c0117a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0117a.f3253b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0117a;
                }
                return (C0117a) invokeL.objValue;
            }

            public static JSONObject b(C0117a c0117a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0117a)) == null) {
                    if (c0117a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0117a.a);
                        jSONObject.put("valid", c0117a.f3253b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0117a> c(JSONArray jSONArray) {
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

        public C0116a() {
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

        public static JSONObject a(C0116a c0116a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0116a)) == null) {
                if (c0116a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0116a.a);
                    jSONObject.put("msg", c0116a.f3246b);
                    jSONObject.put("totalAmount", c0116a.f3247c);
                    jSONObject.put("userPayAmount", c0116a.f3248d);
                    jSONObject.put("reduceAmount", c0116a.f3249e);
                    jSONObject.put("overdueStatus", c0116a.f3251g);
                    jSONObject.put("usedHostMarketingDetail", c0116a.f3250f);
                    if (c0116a.f3252h != null && !c0116a.f3252h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0117a c0117a : c0116a.f3252h) {
                            jSONArray.put(C0117a.b(c0117a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3246b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3247c + ", userPayAmount=" + this.f3248d + ", reduceAmount=" + this.f3249e + ", usedHostMarketingDetail='" + this.f3250f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3251g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0116a c0116a);
}
