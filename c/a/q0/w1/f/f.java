package c.a.q0.w1.f;

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
    public g f27963a;

    /* renamed from: b  reason: collision with root package name */
    public b f27964b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f27965a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1305f> f27966b;

        /* renamed from: c  reason: collision with root package name */
        public String f27967c;

        /* renamed from: d  reason: collision with root package name */
        public String f27968d;

        /* renamed from: e  reason: collision with root package name */
        public String f27969e;

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
            this.f27965a = new ArrayList();
            this.f27966b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27967c = jSONObject.optString("content");
            this.f27968d = jSONObject.optString("tip_text");
            this.f27969e = jSONObject.optString("img");
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
                this.f27965a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.RIGHT);
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                C1305f c1305f = new C1305f();
                c1305f.a(optJSONArray2.optJSONObject(i3));
                this.f27966b.add(c1305f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f27970a;

        /* renamed from: b  reason: collision with root package name */
        public a f27971b;

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
            this.f27970a = new c();
            this.f27971b = new a();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27970a.a(jSONObject.optJSONObject("member"));
            this.f27971b.a(jSONObject.optJSONObject("adv_member"));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<d> f27972a;

        /* renamed from: b  reason: collision with root package name */
        public List<C1305f> f27973b;

        /* renamed from: c  reason: collision with root package name */
        public String f27974c;

        /* renamed from: d  reason: collision with root package name */
        public String f27975d;

        /* renamed from: e  reason: collision with root package name */
        public String f27976e;

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
            this.f27972a = new ArrayList();
            this.f27973b = new ArrayList();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f27974c = jSONObject.optString("content");
            this.f27975d = jSONObject.optString("tip_text");
            this.f27976e = jSONObject.optString("img");
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
                this.f27972a.add(dVar);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HorizontalTranslateLayout.RIGHT);
            if (optJSONArray2 == null) {
                return;
            }
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                C1305f c1305f = new C1305f();
                c1305f.a(jSONObject3);
                this.f27973b.add(c1305f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27977a;

        /* renamed from: b  reason: collision with root package name */
        public String f27978b;

        /* renamed from: c  reason: collision with root package name */
        public String f27979c;

        /* renamed from: d  reason: collision with root package name */
        public String f27980d;

        /* renamed from: e  reason: collision with root package name */
        public String f27981e;

        /* renamed from: f  reason: collision with root package name */
        public String f27982f;

        /* renamed from: g  reason: collision with root package name */
        public String f27983g;

        /* renamed from: h  reason: collision with root package name */
        public String f27984h;

        /* renamed from: i  reason: collision with root package name */
        public long f27985i;

        /* renamed from: j  reason: collision with root package name */
        public long f27986j;
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
            this.f27977a = jSONObject.optString("productId");
            this.f27978b = jSONObject.optString("title");
            jSONObject.optString("desc");
            this.f27979c = jSONObject.optString("discount");
            this.f27980d = jSONObject.optString("original_cost");
            this.f27981e = jSONObject.optString("icon");
            this.f27985i = jSONObject.optLong("props_id");
            this.f27986j = jSONObject.optLong("money");
            this.l = jSONObject.optLong("months");
            this.k = jSONObject.optLong("default");
            this.f27982f = jSONObject.optString("packet_text");
            this.n = jSONObject.optInt("is_autopay");
            this.o = false;
            this.f27983g = jSONObject.optString("payment_pos_key");
            this.f27984h = jSONObject.optString("tag_name");
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f27987a;

        /* renamed from: b  reason: collision with root package name */
        public String f27988b;

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
            this.f27987a = jSONObject.optLong("props_id");
            jSONObject.optLong("end_time");
            this.f27988b = jSONObject.optString("pic_url");
            jSONObject.optLong("upgrade_month");
        }
    }

    /* renamed from: c.a.q0.w1.f.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1305f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1305f() {
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
        public String f27989a;

        /* renamed from: b  reason: collision with root package name */
        public String f27990b;

        /* renamed from: c  reason: collision with root package name */
        public e f27991c;

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
            this.f27991c = new e();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optLong("id");
            jSONObject.optString("name");
            this.f27989a = jSONObject.optString("name_show");
            this.f27990b = jSONObject.optString("portrait");
            jSONObject.optLong("user_type");
            jSONObject.optLong("is_verify");
            this.f27991c.a(jSONObject.optJSONObject("pay_member_info"));
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
        this.f27963a = new g();
        this.f27964b = new b();
    }

    public void a(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("have_autopay", 0);
        this.f27963a.a(jSONObject.optJSONObject("user"));
        this.f27964b.a(jSONObject.optJSONObject("goods_info"));
        jSONObject.optString("equal_cost");
    }
}
