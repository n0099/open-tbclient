package c.a.e0.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3242a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0065a> f3243b;

    /* renamed from: c.a.e0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0065a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3244a;

        /* renamed from: b  reason: collision with root package name */
        public String f3245b;

        /* renamed from: c  reason: collision with root package name */
        public String f3246c;

        /* renamed from: d  reason: collision with root package name */
        public String f3247d;

        /* renamed from: e  reason: collision with root package name */
        public String f3248e;

        /* renamed from: f  reason: collision with root package name */
        public Long f3249f;

        /* renamed from: g  reason: collision with root package name */
        public int f3250g;

        /* renamed from: h  reason: collision with root package name */
        public String f3251h;

        public C0065a() {
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

        public C0065a(JSONObject jSONObject) {
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
            this.f3245b = jSONObject.optString("display_name");
            this.f3246c = jSONObject.optString("pay_text");
            this.f3248e = jSONObject.optString("icon");
            this.f3247d = jSONObject.optString("valid_info");
            this.f3251h = jSONObject.optString("host_marketing_detail");
            this.f3249f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f3250g = jSONObject.optInt("is_selected");
            this.f3244a = jSONObject.optInt("type");
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
        this.f3243b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f3243b.add(new C0065a(jSONObject));
            }
        }
        this.f3242a = this.f3243b.size() > 1;
    }
}
