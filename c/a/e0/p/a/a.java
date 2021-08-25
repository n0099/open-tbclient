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
    public boolean f3251a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0065a> f3252b;

    /* renamed from: c.a.e0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0065a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3253a;

        /* renamed from: b  reason: collision with root package name */
        public String f3254b;

        /* renamed from: c  reason: collision with root package name */
        public String f3255c;

        /* renamed from: d  reason: collision with root package name */
        public String f3256d;

        /* renamed from: e  reason: collision with root package name */
        public String f3257e;

        /* renamed from: f  reason: collision with root package name */
        public Long f3258f;

        /* renamed from: g  reason: collision with root package name */
        public int f3259g;

        /* renamed from: h  reason: collision with root package name */
        public String f3260h;

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
            this.f3254b = jSONObject.optString("display_name");
            this.f3255c = jSONObject.optString("pay_text");
            this.f3257e = jSONObject.optString("icon");
            this.f3256d = jSONObject.optString("valid_info");
            this.f3260h = jSONObject.optString("host_marketing_detail");
            this.f3258f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f3259g = jSONObject.optInt("is_selected");
            this.f3253a = jSONObject.optInt("type");
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
        this.f3252b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f3252b.add(new C0065a(jSONObject));
            }
        }
        this.f3251a = this.f3252b.size() > 1;
    }
}
