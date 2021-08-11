package c.a.d0.p.a;

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
    public boolean f1887a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0036a> f1888b;

    /* renamed from: c.a.d0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1889a;

        /* renamed from: b  reason: collision with root package name */
        public String f1890b;

        /* renamed from: c  reason: collision with root package name */
        public String f1891c;

        /* renamed from: d  reason: collision with root package name */
        public String f1892d;

        /* renamed from: e  reason: collision with root package name */
        public String f1893e;

        /* renamed from: f  reason: collision with root package name */
        public Long f1894f;

        /* renamed from: g  reason: collision with root package name */
        public int f1895g;

        /* renamed from: h  reason: collision with root package name */
        public String f1896h;

        public C0036a() {
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

        public C0036a(JSONObject jSONObject) {
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
            this.f1890b = jSONObject.optString("display_name");
            this.f1891c = jSONObject.optString("pay_text");
            this.f1893e = jSONObject.optString("icon");
            this.f1892d = jSONObject.optString("valid_info");
            this.f1896h = jSONObject.optString("host_marketing_detail");
            this.f1894f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f1895g = jSONObject.optInt("is_selected");
            this.f1889a = jSONObject.optInt("type");
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
        this.f1888b = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i4);
            if (jSONObject != null) {
                this.f1888b.add(new C0036a(jSONObject));
            }
        }
        this.f1887a = this.f1888b.size() > 1;
    }
}
