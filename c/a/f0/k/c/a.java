package c.a.f0.k.c;

import c.a.f0.i.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0143a> f3416b;

    /* renamed from: c.a.f0.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0143a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f3417b;

        /* renamed from: c  reason: collision with root package name */
        public String f3418c;

        /* renamed from: d  reason: collision with root package name */
        public String f3419d;

        /* renamed from: e  reason: collision with root package name */
        public String f3420e;

        /* renamed from: f  reason: collision with root package name */
        public String f3421f;

        /* renamed from: g  reason: collision with root package name */
        public Long f3422g;

        /* renamed from: h  reason: collision with root package name */
        public int f3423h;

        /* renamed from: i  reason: collision with root package name */
        public String f3424i;

        public C0143a() {
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

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("display_name", this.f3418c);
                    jSONObject.put("pay_text", this.f3419d);
                    jSONObject.put("icon", this.f3421f);
                    jSONObject.put("valid_info", this.f3420e);
                    jSONObject.put("host_marketing_detail", this.f3424i);
                    jSONObject.put("available_par_money", this.f3422g);
                    jSONObject.put("is_selected", this.f3423h);
                    jSONObject.put("style", this.f3417b);
                    jSONObject.put("type", this.a);
                } catch (JSONException e2) {
                    if (h.f3361d) {
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
                return "CouponItem{type=" + this.a + ", style=" + this.f3417b + ", displayName='" + this.f3418c + ExtendedMessageFormat.QUOTE + ", payText='" + this.f3419d + ExtendedMessageFormat.QUOTE + ", validInfo='" + this.f3420e + ExtendedMessageFormat.QUOTE + ", icon='" + this.f3421f + ExtendedMessageFormat.QUOTE + ", cutMoney=" + this.f3422g + ", isSelected=" + this.f3423h + ", hostMarketingDetail='" + this.f3424i + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0143a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                return;
            }
            this.f3418c = jSONObject.optString("display_name");
            this.f3419d = jSONObject.optString("pay_text");
            this.f3421f = jSONObject.optString("icon");
            this.f3420e = jSONObject.optString("valid_info");
            this.f3424i = jSONObject.optString("host_marketing_detail");
            this.f3422g = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f3423h = jSONObject.optInt("is_selected");
            this.f3417b = jSONObject.optInt("style");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONArray == null) {
            return;
        }
        this.f3416b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f3416b.add(new C0143a(jSONObject));
            }
        }
        this.a = this.f3416b.size() > 1;
    }
}
