package c.a.r0.x1.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f28690a;

    /* renamed from: b  reason: collision with root package name */
    public List<c> f28691b;

    /* renamed from: c.a.r0.x1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1343a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28692a;

        /* renamed from: b  reason: collision with root package name */
        public String f28693b;

        /* renamed from: c  reason: collision with root package name */
        public String f28694c;

        /* renamed from: d  reason: collision with root package name */
        public String f28695d;

        public C1343a() {
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
            this.f28692a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            this.f28693b = jSONObject.optString("title");
            this.f28694c = jSONObject.optString("desc");
            this.f28695d = jSONObject.optString("link");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f28696a;

        /* renamed from: b  reason: collision with root package name */
        public long f28697b;

        /* renamed from: c  reason: collision with root package name */
        public long f28698c;

        /* renamed from: d  reason: collision with root package name */
        public String f28699d;

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
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.f28696a;
                return (j2 == 1 || j2 == 2) && this.f28697b > this.f28698c;
            }
            return invokeV.booleanValue;
        }

        public void b(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28696a = jSONObject.optInt("props_id");
            this.f28697b = jSONObject.optLong("end_time");
            this.f28698c = jSONObject.optLong("now_time");
            this.f28699d = jSONObject.optString("pic_url");
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28700a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C1343a> f28701b;

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
            this.f28701b = new ArrayList<>();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28700a = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C1343a c1343a = new C1343a();
                c1343a.a(jSONObject2);
                this.f28701b.add(c1343a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f28702a;

        /* renamed from: b  reason: collision with root package name */
        public long f28703b;

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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28702a >= 0 && this.f28703b >= 0 : invokeV.booleanValue;
        }

        public void b(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optLong("scores_total");
            jSONObject.optLong("scores_fetch");
            this.f28702a = jSONObject.optLong("scores_money");
            this.f28703b = jSONObject.optLong("scores_other");
            jSONObject.optLong("update_time");
            jSONObject.optLong("level");
            jSONObject.optLong(Constants.EXTRA_CONFIG_LIMIT);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f28704a;

        /* renamed from: b  reason: collision with root package name */
        public String f28705b;

        /* renamed from: c  reason: collision with root package name */
        public String f28706c;

        /* renamed from: d  reason: collision with root package name */
        public b f28707d;

        /* renamed from: e  reason: collision with root package name */
        public d f28708e;

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
                    return;
                }
            }
            this.f28707d = new b();
            this.f28708e = new d();
        }

        public void a(JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.f28704a = jSONObject.optString("id");
            this.f28705b = jSONObject.optString("name");
            this.f28706c = jSONObject.optString("portrait");
            this.f28707d.b(jSONObject.optJSONObject("pay_member_info"));
            this.f28708e.b(jSONObject.optJSONObject("Parr_scores"));
        }
    }

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
        this.f28690a = new e();
        this.f28691b = new ArrayList();
    }

    public void a(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f28690a.a(jSONObject.optJSONObject("user"));
        JSONArray optJSONArray = jSONObject.optJSONArray("special_List");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            c cVar = new c();
            cVar.a(optJSONArray.getJSONObject(i2));
            this.f28691b.add(cVar);
        }
    }
}
