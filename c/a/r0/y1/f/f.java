package c.a.r0.y1.f;

import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f28846a;

    /* renamed from: b  reason: collision with root package name */
    public b f28847b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f28848a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1349f> f28849b;

        /* renamed from: c  reason: collision with root package name */
        public String f28850c;

        /* renamed from: d  reason: collision with root package name */
        public String f28851d;

        /* renamed from: e  reason: collision with root package name */
        public String f28852e;

        public a() {
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
            this.f28848a = new ArrayList();
            this.f28849b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28850c = jSONObject.optString("content");
            this.f28851d = jSONObject.optString("tip_text");
            this.f28852e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f28848a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.RIGHT);
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1349f c1349f = new C1349f();
                c1349f.a(optJSONArray2.optJSONObject(i3));
                this.f28849b.add(c1349f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f28853a;

        /* renamed from: b  reason: collision with root package name */
        public a f28854b;

        public b() {
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
            this.f28853a = new c();
            this.f28854b = new a();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28853a.a(jSONObject.optJSONObject("member"));
            this.f28854b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f28855a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1349f> f28856b;

        /* renamed from: c  reason: collision with root package name */
        public String f28857c;

        /* renamed from: d  reason: collision with root package name */
        public String f28858d;

        /* renamed from: e  reason: collision with root package name */
        public String f28859e;

        public c() {
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
            this.f28855a = new ArrayList();
            this.f28856b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28857c = jSONObject.optString("content");
            this.f28858d = jSONObject.optString("tip_text");
            this.f28859e = jSONObject.optString("img");
            JSONArray optJSONArray = jSONObject.optJSONArray("money_info");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                d dVar = new d();
                dVar.a(jSONObject2);
                if (1 == dVar.k) {
                    dVar.m = true;
                } else {
                    dVar.m = false;
                }
                this.f28855a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.RIGHT);
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1349f c1349f = new C1349f();
                c1349f.a(jSONObject3);
                this.f28856b.add(c1349f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28860a;

        /* renamed from: b  reason: collision with root package name */
        public String f28861b;

        /* renamed from: c  reason: collision with root package name */
        public String f28862c;

        /* renamed from: d  reason: collision with root package name */
        public String f28863d;

        /* renamed from: e  reason: collision with root package name */
        public String f28864e;

        /* renamed from: f  reason: collision with root package name */
        public String f28865f;

        /* renamed from: g  reason: collision with root package name */
        public String f28866g;

        /* renamed from: h  reason: collision with root package name */
        public String f28867h;

        /* renamed from: i  reason: collision with root package name */
        public long f28868i;

        /* renamed from: j  reason: collision with root package name */
        public long f28869j;
        public long k;
        public long l;
        public boolean m;
        public int n;
        public boolean o;

        public d() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28860a = jSONObject.optString("productId");
            this.f28861b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f28862c = jSONObject.optString("discount");
            this.f28863d = jSONObject.optString("original_cost");
            this.f28864e = jSONObject.optString("icon");
            this.f28868i = jSONObject.optLong("props_id");
            this.f28869j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f28865f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f28866g = jSONObject.optString("payment_pos_key");
            this.f28867h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f28870a;

        /* renamed from: b  reason: collision with root package name */
        public String f28871b;

        public e() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28870a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f28871b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: c.a.r0.y1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1349f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1349f() {
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

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optString("name");
            jSONObject.optLong("num");
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28872a;

        /* renamed from: b  reason: collision with root package name */
        public String f28873b;

        /* renamed from: c  reason: collision with root package name */
        public e f28874c;

        public g() {
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
            this.f28874c = new e();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f28872a = jSONObject.optString("name_show");
            this.f28873b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f28874c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }

    public f() {
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
        this.f28846a = new g();
        this.f28847b = new b();
    }

    public void a(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f28846a.a(jSONObject.optJSONObject("user"));
        this.f28847b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
