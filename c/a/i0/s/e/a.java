package c.a.i0.s.e;

import c.a.i0.r.h;
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

    /* renamed from: c.a.i0.s.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0164a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f3916b;

        /* renamed from: c  reason: collision with root package name */
        public long f3917c;

        /* renamed from: d  reason: collision with root package name */
        public long f3918d;

        /* renamed from: e  reason: collision with root package name */
        public long f3919e;

        /* renamed from: f  reason: collision with root package name */
        public String f3920f;

        /* renamed from: g  reason: collision with root package name */
        public int f3921g;

        /* renamed from: h  reason: collision with root package name */
        public List<C0165a> f3922h;

        /* renamed from: c.a.i0.s.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0165a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f3923b;

            public C0165a() {
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

            public static C0165a a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    C0165a c0165a = new C0165a();
                    c0165a.a = jSONObject.isNull("promotionInsId") ? "" : jSONObject.optString("promotionInsId");
                    c0165a.f3923b = jSONObject.isNull("valid") ? "" : jSONObject.optString("valid");
                    return c0165a;
                }
                return (C0165a) invokeL.objValue;
            }

            public static JSONObject b(C0165a c0165a) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0165a)) == null) {
                    if (c0165a == null) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("promotionInsId", c0165a.a);
                        jSONObject.put("valid", c0165a.f3923b);
                    } catch (JSONException e2) {
                        h.d(e2.getMessage());
                    }
                    return jSONObject;
                }
                return (JSONObject) invokeL.objValue;
            }

            public static List<C0165a> c(JSONArray jSONArray) {
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

        public C0164a() {
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

        public static JSONObject a(C0164a c0164a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0164a)) == null) {
                if (c0164a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, c0164a.a);
                    jSONObject.put("msg", c0164a.f3916b);
                    jSONObject.put("totalAmount", c0164a.f3917c);
                    jSONObject.put("userPayAmount", c0164a.f3918d);
                    jSONObject.put("reduceAmount", c0164a.f3919e);
                    jSONObject.put("overdueStatus", c0164a.f3921g);
                    jSONObject.put("usedHostMarketingDetail", c0164a.f3920f);
                    if (c0164a.f3922h != null && !c0164a.f3922h.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (C0165a c0165a : c0164a.f3922h) {
                            jSONArray.put(C0165a.b(c0165a));
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
                return "Data{statusCode=" + this.a + ", message='" + this.f3916b + ExtendedMessageFormat.QUOTE + ", totalAmount=" + this.f3917c + ", userPayAmount=" + this.f3918d + ", reduceAmount=" + this.f3919e + ", usedHostMarketingDetail='" + this.f3920f + ExtendedMessageFormat.QUOTE + ", overdueStatus='" + this.f3921g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    void a(C0164a c0164a);
}
