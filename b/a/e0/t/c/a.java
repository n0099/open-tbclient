package b.a.e0.t.c;

import b.a.e0.r.h;
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

    /* renamed from: a  reason: collision with root package name */
    public boolean f2772a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0060a> f2773b;

    /* renamed from: b.a.e0.t.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2774a;

        /* renamed from: b  reason: collision with root package name */
        public int f2775b;

        /* renamed from: c  reason: collision with root package name */
        public String f2776c;

        /* renamed from: d  reason: collision with root package name */
        public String f2777d;

        /* renamed from: e  reason: collision with root package name */
        public String f2778e;

        /* renamed from: f  reason: collision with root package name */
        public String f2779f;

        /* renamed from: g  reason: collision with root package name */
        public Long f2780g;

        /* renamed from: h  reason: collision with root package name */
        public int f2781h;

        /* renamed from: i  reason: collision with root package name */
        public String f2782i;

        public C0060a() {
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
                    jSONObject.put("display_name", this.f2776c);
                    jSONObject.put("pay_text", this.f2777d);
                    jSONObject.put("icon", this.f2779f);
                    jSONObject.put("valid_info", this.f2778e);
                    jSONObject.put("host_marketing_detail", this.f2782i);
                    jSONObject.put("available_par_money", this.f2780g);
                    jSONObject.put("is_selected", this.f2781h);
                    jSONObject.put("style", this.f2775b);
                    jSONObject.put("type", this.f2774a);
                } catch (JSONException e2) {
                    if (h.f2696d) {
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
                return "CouponItem{type=" + this.f2774a + ", style=" + this.f2775b + ", displayName='" + this.f2776c + ExtendedMessageFormat.QUOTE + ", payText='" + this.f2777d + ExtendedMessageFormat.QUOTE + ", validInfo='" + this.f2778e + ExtendedMessageFormat.QUOTE + ", icon='" + this.f2779f + ExtendedMessageFormat.QUOTE + ", cutMoney=" + this.f2780g + ", isSelected=" + this.f2781h + ", hostMarketingDetail='" + this.f2782i + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public C0060a(JSONObject jSONObject) {
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
            this.f2776c = jSONObject.optString("display_name");
            this.f2777d = jSONObject.optString("pay_text");
            this.f2779f = jSONObject.optString("icon");
            this.f2778e = jSONObject.optString("valid_info");
            this.f2782i = jSONObject.optString("host_marketing_detail");
            this.f2780g = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f2781h = jSONObject.optInt("is_selected");
            this.f2775b = jSONObject.optInt("style");
            this.f2774a = jSONObject.optInt("type");
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
        this.f2773b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f2773b.add(new C0060a(jSONObject));
            }
        }
        this.f2772a = this.f2773b.size() > 1;
    }
}
