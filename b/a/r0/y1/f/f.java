package b.a.r0.y1.f;

import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f27565a;

    /* renamed from: b  reason: collision with root package name */
    public b f27566b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f27567a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1349f> f27568b;

        /* renamed from: c  reason: collision with root package name */
        public String f27569c;

        /* renamed from: d  reason: collision with root package name */
        public String f27570d;

        /* renamed from: e  reason: collision with root package name */
        public String f27571e;

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
            this.f27567a = new ArrayList();
            this.f27568b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27569c = jSONObject.optString("content");
            this.f27570d = jSONObject.optString("tip_text");
            this.f27571e = jSONObject.optString("img");
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
                this.f27567a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.RIGHT);
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1349f c1349f = new C1349f();
                c1349f.a(optJSONArray2.optJSONObject(i3));
                this.f27568b.add(c1349f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f27572a;

        /* renamed from: b  reason: collision with root package name */
        public a f27573b;

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
            this.f27572a = new c();
            this.f27573b = new a();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27572a.a(jSONObject.optJSONObject("member"));
            this.f27573b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f27574a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1349f> f27575b;

        /* renamed from: c  reason: collision with root package name */
        public String f27576c;

        /* renamed from: d  reason: collision with root package name */
        public String f27577d;

        /* renamed from: e  reason: collision with root package name */
        public String f27578e;

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
            this.f27574a = new ArrayList();
            this.f27575b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27576c = jSONObject.optString("content");
            this.f27577d = jSONObject.optString("tip_text");
            this.f27578e = jSONObject.optString("img");
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
                this.f27574a.add(dVar);
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
                this.f27575b.add(c1349f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27579a;

        /* renamed from: b  reason: collision with root package name */
        public String f27580b;

        /* renamed from: c  reason: collision with root package name */
        public String f27581c;

        /* renamed from: d  reason: collision with root package name */
        public String f27582d;

        /* renamed from: e  reason: collision with root package name */
        public String f27583e;

        /* renamed from: f  reason: collision with root package name */
        public String f27584f;

        /* renamed from: g  reason: collision with root package name */
        public String f27585g;

        /* renamed from: h  reason: collision with root package name */
        public String f27586h;

        /* renamed from: i  reason: collision with root package name */
        public long f27587i;
        public long j;
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
            this.f27579a = jSONObject.optString("productId");
            this.f27580b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f27581c = jSONObject.optString("discount");
            this.f27582d = jSONObject.optString("original_cost");
            this.f27583e = jSONObject.optString("icon");
            this.f27587i = jSONObject.optLong("props_id");
            this.j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f27584f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f27585g = jSONObject.optString("payment_pos_key");
            this.f27586h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f27588a;

        /* renamed from: b  reason: collision with root package name */
        public String f27589b;

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
            this.f27588a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f27589b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: b.a.r0.y1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27590a;

        /* renamed from: b  reason: collision with root package name */
        public String f27591b;

        /* renamed from: c  reason: collision with root package name */
        public e f27592c;

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
            this.f27592c = new e();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f27590a = jSONObject.optString("name_show");
            this.f27591b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f27592c.a(jSONObject.optJSONObject("pay_member_info"));
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
        this.f27565a = new g();
        this.f27566b = new b();
    }

    public void a(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f27565a.a(jSONObject.optJSONObject("user"));
        this.f27566b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
