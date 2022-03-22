package c.a.e0.k.e;

import c.a.e0.i.h;
import com.baidu.android.imsdk.internal.Constants;
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
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0134a> f2871b;

    /* renamed from: c.a.e0.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0134a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f2872b;

        /* renamed from: c  reason: collision with root package name */
        public String f2873c;

        /* renamed from: d  reason: collision with root package name */
        public String f2874d;

        /* renamed from: e  reason: collision with root package name */
        public String f2875e;

        /* renamed from: f  reason: collision with root package name */
        public String f2876f;

        /* renamed from: g  reason: collision with root package name */
        public Long f2877g;

        /* renamed from: h  reason: collision with root package name */
        public int f2878h;
        public String i;

        public C0134a() {
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

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("display_name", this.f2873c);
                    jSONObject.put("pay_text", this.f2874d);
                    jSONObject.put("icon", this.f2876f);
                    jSONObject.put("valid_info", this.f2875e);
                    jSONObject.put("host_marketing_detail", this.i);
                    jSONObject.put("available_par_money", this.f2877g);
                    jSONObject.put("is_selected", this.f2878h);
                    jSONObject.put("style", this.f2872b);
                    jSONObject.put("type", this.a);
                } catch (JSONException e2) {
                    if (h.f2807d) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CouponItem{type=" + this.a + ", style=" + this.f2872b + ", displayName='" + this.f2873c + "', payText='" + this.f2874d + "', validInfo='" + this.f2875e + "', icon='" + this.f2876f + "', cutMoney=" + this.f2877g + ", isSelected=" + this.f2878h + ", hostMarketingDetail='" + this.i + "'}";
            }
            return (String) invokeV.objValue;
        }

        public C0134a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                return;
            }
            this.f2873c = jSONObject.optString("display_name");
            this.f2874d = jSONObject.optString("pay_text");
            this.f2876f = jSONObject.optString("icon");
            this.f2875e = jSONObject.optString("valid_info");
            this.i = jSONObject.optString("host_marketing_detail");
            this.f2877g = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f2878h = jSONObject.optInt("is_selected");
            this.f2872b = jSONObject.optInt("style");
            this.a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONArray == null) {
            return;
        }
        this.f2871b = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i3);
            if (jSONObject != null) {
                this.f2871b.add(new C0134a(jSONObject));
            }
        }
        this.a = this.f2871b.size() > 1;
    }
}
